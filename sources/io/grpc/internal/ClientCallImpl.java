package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import io.grpc.perfmark.PerfMark;
import io.grpc.perfmark.PerfTag;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class ClientCallImpl<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private static final byte[] FULL_STREAM_DECOMPRESSION_ENCODINGS = "gzip".getBytes(Charset.forName("US-ASCII"));
    private static final Logger log = Logger.getLogger(ClientCallImpl.class.getName());
    /* access modifiers changed from: private */
    public final Executor callExecutor;
    private final CallOptions callOptions;
    private boolean cancelCalled;
    /* access modifiers changed from: private */
    public volatile boolean cancelListenersShouldBeRemoved;
    private final Context.CancellationListener cancellationListener = new ContextCancellationListener();
    /* access modifiers changed from: private */
    public final CallTracer channelCallsTracer;
    private final ClientTransportProvider clientTransportProvider;
    private CompressorRegistry compressorRegistry = CompressorRegistry.getDefaultInstance();
    /* access modifiers changed from: private */
    public final Context context;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private volatile ScheduledFuture<?> deadlineCancellationFuture;
    private DecompressorRegistry decompressorRegistry = DecompressorRegistry.getDefaultInstance();
    private boolean fullStreamDecompression;
    private boolean halfCloseCalled;
    /* access modifiers changed from: private */
    public final MethodDescriptor<ReqT, RespT> method;
    private final boolean retryEnabled;
    /* access modifiers changed from: private */
    public ClientStream stream;
    /* access modifiers changed from: private */
    public final PerfTag tag;
    private final boolean unaryRequest;

    interface ClientTransportProvider {
        ClientTransport get(LoadBalancer.PickSubchannelArgs pickSubchannelArgs);

        <ReqT> ClientStream newRetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context);
    }

    ClientCallImpl(MethodDescriptor<ReqT, RespT> method2, Executor executor, CallOptions callOptions2, ClientTransportProvider clientTransportProvider2, ScheduledExecutorService deadlineCancellationExecutor2, CallTracer channelCallsTracer2, boolean retryEnabled2) {
        Executor executor2;
        this.method = method2;
        this.tag = PerfMark.createTag(method2.getFullMethodName());
        if (executor == MoreExecutors.directExecutor()) {
            executor2 = new SerializeReentrantCallsDirectExecutor();
        } else {
            executor2 = new SerializingExecutor(executor);
        }
        this.callExecutor = executor2;
        this.channelCallsTracer = channelCallsTracer2;
        this.context = Context.current();
        this.unaryRequest = method2.getType() == MethodDescriptor.MethodType.UNARY || method2.getType() == MethodDescriptor.MethodType.SERVER_STREAMING;
        this.callOptions = callOptions2;
        this.clientTransportProvider = clientTransportProvider2;
        this.deadlineCancellationExecutor = deadlineCancellationExecutor2;
        this.retryEnabled = retryEnabled2;
    }

    private final class ContextCancellationListener implements Context.CancellationListener {
        private ContextCancellationListener() {
        }

        public void cancelled(Context context) {
            ClientCallImpl.this.stream.cancel(Contexts.statusFromCancelled(context));
        }
    }

    /* access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setFullStreamDecompression(boolean fullStreamDecompression2) {
        this.fullStreamDecompression = fullStreamDecompression2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setDecompressorRegistry(DecompressorRegistry decompressorRegistry2) {
        this.decompressorRegistry = decompressorRegistry2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setCompressorRegistry(CompressorRegistry compressorRegistry2) {
        this.compressorRegistry = compressorRegistry2;
        return this;
    }

    static void prepareHeaders(Metadata headers, DecompressorRegistry decompressorRegistry2, Compressor compressor, boolean fullStreamDecompression2) {
        headers.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (compressor != Codec.Identity.NONE) {
            headers.put(GrpcUtil.MESSAGE_ENCODING_KEY, compressor.getMessageEncoding());
        }
        headers.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        byte[] advertisedEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(decompressorRegistry2);
        if (advertisedEncodings.length != 0) {
            headers.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, advertisedEncodings);
        }
        headers.discardAll(GrpcUtil.CONTENT_ENCODING_KEY);
        headers.discardAll(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY);
        if (fullStreamDecompression2) {
            headers.put(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY, FULL_STREAM_DECOMPRESSION_ENCODINGS);
        }
    }

    public void start(ClientCall.Listener<RespT> observer, Metadata headers) {
        PerfMark.taskStart(this.tag, "ClientCall.start");
        try {
            startInternal(observer, headers);
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.start");
        }
    }

    private void startInternal(final ClientCall.Listener<RespT> observer, Metadata headers) {
        Compressor compressor;
        boolean deadlineExceeded = false;
        Preconditions.checkState(this.stream == null, "Already started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkNotNull(observer, "observer");
        Preconditions.checkNotNull(headers, "headers");
        if (this.context.isCancelled()) {
            this.stream = NoopClientStream.INSTANCE;
            this.callExecutor.execute(new ContextRunnable() {
                public void runInContext() {
                    ClientCallImpl clientCallImpl = ClientCallImpl.this;
                    clientCallImpl.closeObserver(observer, Contexts.statusFromCancelled(clientCallImpl.context), new Metadata());
                }
            });
            return;
        }
        final String compressorName = this.callOptions.getCompressor();
        if (compressorName != null) {
            compressor = this.compressorRegistry.lookupCompressor(compressorName);
            if (compressor == null) {
                this.stream = NoopClientStream.INSTANCE;
                this.callExecutor.execute(new ContextRunnable() {
                    public void runInContext() {
                        ClientCallImpl.this.closeObserver(observer, Status.INTERNAL.withDescription(String.format("Unable to find compressor by name %s", new Object[]{compressorName})), new Metadata());
                    }
                });
                return;
            }
        } else {
            compressor = Codec.Identity.NONE;
        }
        prepareHeaders(headers, this.decompressorRegistry, compressor, this.fullStreamDecompression);
        Deadline effectiveDeadline = effectiveDeadline();
        if (effectiveDeadline != null && effectiveDeadline.isExpired()) {
            deadlineExceeded = true;
        }
        if (!deadlineExceeded) {
            logIfContextNarrowedTimeout(effectiveDeadline, this.callOptions.getDeadline(), this.context.getDeadline());
            if (this.retryEnabled) {
                this.stream = this.clientTransportProvider.newRetriableStream(this.method, this.callOptions, headers, this.context);
            } else {
                ClientTransport transport = this.clientTransportProvider.get(new PickSubchannelArgsImpl(this.method, headers, this.callOptions));
                Context origContext = this.context.attach();
                try {
                    this.stream = transport.newStream(this.method, headers, this.callOptions);
                } finally {
                    this.context.detach(origContext);
                }
            }
        } else {
            this.stream = new FailingClientStream(Status.DEADLINE_EXCEEDED.withDescription("deadline exceeded: " + effectiveDeadline));
        }
        if (this.callOptions.getAuthority() != null) {
            this.stream.setAuthority(this.callOptions.getAuthority());
        }
        if (this.callOptions.getMaxInboundMessageSize() != null) {
            this.stream.setMaxInboundMessageSize(this.callOptions.getMaxInboundMessageSize().intValue());
        }
        if (this.callOptions.getMaxOutboundMessageSize() != null) {
            this.stream.setMaxOutboundMessageSize(this.callOptions.getMaxOutboundMessageSize().intValue());
        }
        if (effectiveDeadline != null) {
            this.stream.setDeadline(effectiveDeadline);
        }
        this.stream.setCompressor(compressor);
        boolean z = this.fullStreamDecompression;
        if (z) {
            this.stream.setFullStreamDecompression(z);
        }
        this.stream.setDecompressorRegistry(this.decompressorRegistry);
        this.channelCallsTracer.reportCallStarted();
        this.stream.start(new ClientStreamListenerImpl(observer));
        this.context.addListener(this.cancellationListener, MoreExecutors.directExecutor());
        if (!(effectiveDeadline == null || this.context.getDeadline() == effectiveDeadline || this.deadlineCancellationExecutor == null)) {
            this.deadlineCancellationFuture = startDeadlineTimer(effectiveDeadline);
        }
        if (this.cancelListenersShouldBeRemoved) {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }

    private static void logIfContextNarrowedTimeout(Deadline effectiveDeadline, @Nullable Deadline outerCallDeadline, @Nullable Deadline callDeadline) {
        if (log.isLoggable(Level.FINE) && effectiveDeadline != null && outerCallDeadline == effectiveDeadline) {
            StringBuilder builder = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", new Object[]{Long.valueOf(Math.max(0, effectiveDeadline.timeRemaining(TimeUnit.NANOSECONDS)))}));
            if (callDeadline == null) {
                builder.append(" Explicit call timeout was not set.");
            } else {
                builder.append(String.format(" Explicit call timeout was '%d' ns.", new Object[]{Long.valueOf(callDeadline.timeRemaining(TimeUnit.NANOSECONDS))}));
            }
            log.fine(builder.toString());
        }
    }

    /* access modifiers changed from: private */
    public void removeContextListenerAndCancelDeadlineFuture() {
        this.context.removeListener(this.cancellationListener);
        ScheduledFuture<?> f = this.deadlineCancellationFuture;
        if (f != null) {
            f.cancel(false);
        }
    }

    private class DeadlineTimer implements Runnable {
        private final long remainingNanos;

        DeadlineTimer(long remainingNanos2) {
            this.remainingNanos = remainingNanos2;
        }

        public void run() {
            ClientCallImpl.this.stream.cancel(Status.DEADLINE_EXCEEDED.augmentDescription(String.format("deadline exceeded after %dns", new Object[]{Long.valueOf(this.remainingNanos)})));
        }
    }

    private ScheduledFuture<?> startDeadlineTimer(Deadline deadline) {
        long remainingNanos = deadline.timeRemaining(TimeUnit.NANOSECONDS);
        return this.deadlineCancellationExecutor.schedule(new LogExceptionRunnable(new DeadlineTimer(remainingNanos)), remainingNanos, TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: private */
    @Nullable
    public Deadline effectiveDeadline() {
        return min(this.callOptions.getDeadline(), this.context.getDeadline());
    }

    @Nullable
    private static Deadline min(@Nullable Deadline deadline0, @Nullable Deadline deadline1) {
        if (deadline0 == null) {
            return deadline1;
        }
        if (deadline1 == null) {
            return deadline0;
        }
        return deadline0.minimum(deadline1);
    }

    public void request(int numMessages) {
        boolean z = true;
        Preconditions.checkState(this.stream != null, "Not started");
        if (numMessages < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Number requested must be non-negative");
        this.stream.request(numMessages);
    }

    public void cancel(@Nullable String message, @Nullable Throwable cause) {
        PerfMark.taskStart(this.tag, "ClientCall.cancel");
        try {
            cancelInternal(message, cause);
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.cancel");
        }
    }

    private void cancelInternal(@Nullable String message, @Nullable Throwable cause) {
        Status status;
        if (message == null && cause == null) {
            cause = new CancellationException("Cancelled without a message or cause");
            log.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", cause);
        }
        if (!this.cancelCalled) {
            this.cancelCalled = true;
            try {
                if (this.stream != null) {
                    Status status2 = Status.CANCELLED;
                    if (message != null) {
                        status = status2.withDescription(message);
                    } else {
                        status = status2.withDescription("Call cancelled without message");
                    }
                    if (cause != null) {
                        status = status.withCause(cause);
                    }
                    this.stream.cancel(status);
                }
            } finally {
                removeContextListenerAndCancelDeadlineFuture();
            }
        }
    }

    public void halfClose() {
        PerfMark.taskStart(this.tag, "ClientCall.halfClose");
        try {
            halfCloseInternal();
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.halfClose");
        }
    }

    private void halfCloseInternal() {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call already half-closed");
        this.halfCloseCalled = true;
        this.stream.halfClose();
    }

    public void sendMessage(ReqT message) {
        PerfMark.taskStart(this.tag, "ClientCall.sendMessage");
        try {
            sendMessageInternal(message);
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.sendMessage");
        }
    }

    private void sendMessageInternal(ReqT message) {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call was half-closed");
        try {
            if (this.stream instanceof RetriableStream) {
                ((RetriableStream) this.stream).sendMessage(message);
            } else {
                this.stream.writeMessage(this.method.streamRequest(message));
            }
            if (!this.unaryRequest) {
                this.stream.flush();
            }
        } catch (RuntimeException e) {
            this.stream.cancel(Status.CANCELLED.withCause(e).withDescription("Failed to stream message"));
        } catch (Error e2) {
            this.stream.cancel(Status.CANCELLED.withDescription("Client sendMessage() failed with Error"));
            throw e2;
        }
    }

    public void setMessageCompression(boolean enabled) {
        Preconditions.checkState(this.stream != null, "Not started");
        this.stream.setMessageCompression(enabled);
    }

    public boolean isReady() {
        return this.stream.isReady();
    }

    public Attributes getAttributes() {
        ClientStream clientStream = this.stream;
        if (clientStream != null) {
            return clientStream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    /* access modifiers changed from: private */
    public void closeObserver(ClientCall.Listener<RespT> observer, Status status, Metadata trailers) {
        observer.onClose(status, trailers);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add(FirebaseAnalytics.Param.METHOD, (Object) this.method).toString();
    }

    private class ClientStreamListenerImpl implements ClientStreamListener {
        /* access modifiers changed from: private */
        public boolean closed;
        /* access modifiers changed from: private */
        public final ClientCall.Listener<RespT> observer;

        public ClientStreamListenerImpl(ClientCall.Listener<RespT> observer2) {
            this.observer = (ClientCall.Listener) Preconditions.checkNotNull(observer2, "observer");
        }

        public void headersRead(final Metadata headers) {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                public final void runInContext() {
                    if (!ClientStreamListenerImpl.this.closed) {
                        PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.headersRead");
                        try {
                            ClientStreamListenerImpl.this.observer.onHeaders(headers);
                        } catch (Throwable th) {
                            PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.headersRead");
                            throw th;
                        }
                        PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.headersRead");
                    }
                }
            });
        }

        public void messagesAvailable(final StreamListener.MessageProducer producer) {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                public final void runInContext() {
                    InputStream message;
                    if (ClientStreamListenerImpl.this.closed) {
                        GrpcUtil.closeQuietly(producer);
                        return;
                    }
                    PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.messagesAvailable");
                    while (true) {
                        try {
                            InputStream next = producer.next();
                            message = next;
                            if (next == null) {
                                break;
                            }
                            ClientStreamListenerImpl.this.observer.onMessage(ClientCallImpl.this.method.parseResponse(message));
                            message.close();
                        } catch (Throwable t) {
                            try {
                                GrpcUtil.closeQuietly(producer);
                                Status status = Status.CANCELLED.withCause(t).withDescription("Failed to read message.");
                                ClientCallImpl.this.stream.cancel(status);
                                ClientStreamListenerImpl.this.close(status, new Metadata());
                            } catch (Throwable th) {
                                PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.messagesAvailable");
                                throw th;
                            }
                        }
                    }
                    PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.messagesAvailable");
                }
            });
        }

        /* access modifiers changed from: private */
        public void close(Status status, Metadata trailers) {
            this.closed = true;
            boolean unused = ClientCallImpl.this.cancelListenersShouldBeRemoved = true;
            try {
                ClientCallImpl.this.closeObserver(this.observer, status, trailers);
            } finally {
                ClientCallImpl.this.removeContextListenerAndCancelDeadlineFuture();
                ClientCallImpl.this.channelCallsTracer.reportCallEnded(status.isOk());
            }
        }

        public void closed(Status status, Metadata trailers) {
            closed(status, ClientStreamListener.RpcProgress.PROCESSED, trailers);
        }

        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
            Deadline deadline = ClientCallImpl.this.effectiveDeadline();
            if (status.getCode() == Status.Code.CANCELLED && deadline != null && deadline.isExpired()) {
                status = Status.DEADLINE_EXCEEDED;
                trailers = new Metadata();
            }
            final Status savedStatus = status;
            final Metadata savedTrailers = trailers;
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                public final void runInContext() {
                    if (!ClientStreamListenerImpl.this.closed) {
                        PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.closed");
                        try {
                            ClientStreamListenerImpl.this.close(savedStatus, savedTrailers);
                        } finally {
                            PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.closed");
                        }
                    }
                }
            });
        }

        public void onReady() {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                {
                    Context access$200 = ClientCallImpl.this.context;
                }

                public final void runInContext() {
                    PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.onReady");
                    try {
                        ClientStreamListenerImpl.this.observer.onReady();
                    } catch (Throwable th) {
                        PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.onReady");
                        throw th;
                    }
                    PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.onReady");
                }
            });
        }
    }
}
