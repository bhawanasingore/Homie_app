package io.grpc.stub;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ClientCalls {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger logger = Logger.getLogger(ClientCalls.class.getName());

    private ClientCalls() {
    }

    public static <ReqT, RespT> void asyncUnaryCall(ClientCall<ReqT, RespT> call, ReqT req, StreamObserver<RespT> responseObserver) {
        asyncUnaryRequestCall(call, req, responseObserver, false);
    }

    public static <ReqT, RespT> void asyncServerStreamingCall(ClientCall<ReqT, RespT> call, ReqT req, StreamObserver<RespT> responseObserver) {
        asyncUnaryRequestCall(call, req, responseObserver, true);
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncClientStreamingCall(ClientCall<ReqT, RespT> call, StreamObserver<RespT> responseObserver) {
        return asyncStreamingRequestCall(call, responseObserver, false);
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncBidiStreamingCall(ClientCall<ReqT, RespT> call, StreamObserver<RespT> responseObserver) {
        return asyncStreamingRequestCall(call, responseObserver, true);
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(ClientCall<ReqT, RespT> call, ReqT req) {
        try {
            return getUnchecked(futureUnaryCall(call, req));
        } catch (RuntimeException e) {
            throw cancelThrow(call, e);
        } catch (Error e2) {
            throw cancelThrow(call, e2);
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [io.grpc.MethodDescriptor, io.grpc.MethodDescriptor<ReqT, RespT>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <ReqT, RespT> RespT blockingUnaryCall(io.grpc.Channel r6, io.grpc.MethodDescriptor<ReqT, RespT> r7, io.grpc.CallOptions r8, ReqT r9) {
        /*
            io.grpc.stub.ClientCalls$ThreadlessExecutor r0 = new io.grpc.stub.ClientCalls$ThreadlessExecutor
            r0.<init>()
            io.grpc.CallOptions r1 = r8.withExecutor(r0)
            io.grpc.ClientCall r1 = r6.newCall(r7, r1)
            com.google.common.util.concurrent.ListenableFuture r2 = futureUnaryCall(r1, r9)     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
        L_0x0011:
            boolean r3 = r2.isDone()     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
            if (r3 != 0) goto L_0x0034
            r0.waitAndDrain()     // Catch:{ InterruptedException -> 0x001b }
            goto L_0x0011
        L_0x001b:
            r3 = move-exception
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
            r4.interrupt()     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
            io.grpc.Status r4 = io.grpc.Status.CANCELLED     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
            java.lang.String r5 = "Call was interrupted"
            io.grpc.Status r4 = r4.withDescription(r5)     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
            io.grpc.Status r4 = r4.withCause(r3)     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
            io.grpc.StatusRuntimeException r4 = r4.asRuntimeException()     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
            throw r4     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
        L_0x0034:
            java.lang.Object r3 = getUnchecked(r2)     // Catch:{ RuntimeException -> 0x003f, Error -> 0x0039 }
            return r3
        L_0x0039:
            r2 = move-exception
            java.lang.RuntimeException r3 = cancelThrow(r1, r2)
            throw r3
        L_0x003f:
            r2 = move-exception
            java.lang.RuntimeException r3 = cancelThrow(r1, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.stub.ClientCalls.blockingUnaryCall(io.grpc.Channel, io.grpc.MethodDescriptor, io.grpc.CallOptions, java.lang.Object):java.lang.Object");
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(ClientCall<ReqT, RespT> call, ReqT req) {
        BlockingResponseStream<RespT> result = new BlockingResponseStream<>(call);
        asyncUnaryRequestCall(call, req, result.listener(), true);
        return result;
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(Channel channel, MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, ReqT req) {
        ThreadlessExecutor executor = new ThreadlessExecutor();
        ClientCall<ReqT, RespT> call = channel.newCall(method, callOptions.withExecutor(executor));
        BlockingResponseStream<RespT> result = new BlockingResponseStream<>(call, executor);
        asyncUnaryRequestCall(call, req, result.listener(), true);
        return result;
    }

    public static <ReqT, RespT> ListenableFuture<RespT> futureUnaryCall(ClientCall<ReqT, RespT> call, ReqT req) {
        GrpcFuture<RespT> responseFuture = new GrpcFuture<>(call);
        asyncUnaryRequestCall(call, req, new UnaryStreamToFuture(responseFuture), false);
        return responseFuture;
    }

    private static <V> V getUnchecked(Future<V> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw Status.CANCELLED.withDescription("Call was interrupted").withCause(e).asRuntimeException();
        } catch (ExecutionException e2) {
            throw toStatusRuntimeException(e2.getCause());
        }
    }

    private static StatusRuntimeException toStatusRuntimeException(Throwable t) {
        Throwable cause = (Throwable) Preconditions.checkNotNull(t, "t");
        while (cause != null) {
            if (cause instanceof StatusException) {
                StatusException se = (StatusException) cause;
                return new StatusRuntimeException(se.getStatus(), se.getTrailers());
            } else if (cause instanceof StatusRuntimeException) {
                StatusRuntimeException se2 = (StatusRuntimeException) cause;
                return new StatusRuntimeException(se2.getStatus(), se2.getTrailers());
            } else {
                cause = cause.getCause();
            }
        }
        return Status.UNKNOWN.withDescription("unexpected exception").withCause(t).asRuntimeException();
    }

    private static RuntimeException cancelThrow(ClientCall<?, ?> call, Throwable t) {
        try {
            call.cancel((String) null, t);
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "RuntimeException encountered while closing call", e);
        }
        if (t instanceof RuntimeException) {
            throw ((RuntimeException) t);
        } else if (t instanceof Error) {
            throw ((Error) t);
        } else {
            throw new AssertionError(t);
        }
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> call, ReqT req, StreamObserver<RespT> responseObserver, boolean streamingResponse) {
        asyncUnaryRequestCall(call, req, new StreamObserverToCallListenerAdapter(responseObserver, new CallToStreamObserverAdapter(call), streamingResponse), streamingResponse);
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> call, ReqT req, ClientCall.Listener<RespT> responseListener, boolean streamingResponse) {
        startCall(call, responseListener, streamingResponse);
        try {
            call.sendMessage(req);
            call.halfClose();
        } catch (RuntimeException e) {
            throw cancelThrow(call, e);
        } catch (Error e2) {
            throw cancelThrow(call, e2);
        }
    }

    private static <ReqT, RespT> StreamObserver<ReqT> asyncStreamingRequestCall(ClientCall<ReqT, RespT> call, StreamObserver<RespT> responseObserver, boolean streamingResponse) {
        CallToStreamObserverAdapter<ReqT> adapter = new CallToStreamObserverAdapter<>(call);
        startCall(call, new StreamObserverToCallListenerAdapter(responseObserver, adapter, streamingResponse), streamingResponse);
        return adapter;
    }

    private static <ReqT, RespT> void startCall(ClientCall<ReqT, RespT> call, ClientCall.Listener<RespT> responseListener, boolean streamingResponse) {
        call.start(responseListener, new Metadata());
        if (streamingResponse) {
            call.request(1);
        } else {
            call.request(2);
        }
    }

    private static final class CallToStreamObserverAdapter<T> extends ClientCallStreamObserver<T> {
        private boolean aborted = false;
        /* access modifiers changed from: private */
        public boolean autoFlowControlEnabled = true;
        private final ClientCall<T, ?> call;
        private boolean completed = false;
        private boolean frozen;
        /* access modifiers changed from: private */
        public Runnable onReadyHandler;

        CallToStreamObserverAdapter(ClientCall<T, ?> call2) {
            this.call = call2;
        }

        /* access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        public void onNext(T value) {
            Preconditions.checkState(!this.aborted, "Stream was terminated by error, no further calls are allowed");
            Preconditions.checkState(!this.completed, "Stream is already completed, no further calls are allowed");
            this.call.sendMessage(value);
        }

        public void onError(Throwable t) {
            this.call.cancel("Cancelled by client with StreamObserver.onError()", t);
            this.aborted = true;
        }

        public void onCompleted() {
            this.call.halfClose();
            this.completed = true;
        }

        public boolean isReady() {
            return this.call.isReady();
        }

        public void setOnReadyHandler(Runnable onReadyHandler2) {
            if (!this.frozen) {
                this.onReadyHandler = onReadyHandler2;
                return;
            }
            throw new IllegalStateException("Cannot alter onReadyHandler after call started");
        }

        public void disableAutoInboundFlowControl() {
            if (!this.frozen) {
                this.autoFlowControlEnabled = false;
                return;
            }
            throw new IllegalStateException("Cannot disable auto flow control call started");
        }

        public void request(int count) {
            this.call.request(count);
        }

        public void setMessageCompression(boolean enable) {
            this.call.setMessageCompression(enable);
        }

        public void cancel(@Nullable String message, @Nullable Throwable cause) {
            this.call.cancel(message, cause);
        }
    }

    private static final class StreamObserverToCallListenerAdapter<ReqT, RespT> extends ClientCall.Listener<RespT> {
        private final CallToStreamObserverAdapter<ReqT> adapter;
        private boolean firstResponseReceived;
        private final StreamObserver<RespT> observer;
        private final boolean streamingResponse;

        StreamObserverToCallListenerAdapter(StreamObserver<RespT> observer2, CallToStreamObserverAdapter<ReqT> adapter2, boolean streamingResponse2) {
            this.observer = observer2;
            this.streamingResponse = streamingResponse2;
            this.adapter = adapter2;
            if (observer2 instanceof ClientResponseObserver) {
                ((ClientResponseObserver) observer2).beforeStart(adapter2);
            }
            adapter2.freeze();
        }

        public void onHeaders(Metadata headers) {
        }

        public void onMessage(RespT message) {
            if (!this.firstResponseReceived || this.streamingResponse) {
                this.firstResponseReceived = true;
                this.observer.onNext(message);
                if (this.streamingResponse && this.adapter.autoFlowControlEnabled) {
                    this.adapter.request(1);
                    return;
                }
                return;
            }
            throw Status.INTERNAL.withDescription("More than one responses received for unary or client-streaming call").asRuntimeException();
        }

        public void onClose(Status status, Metadata trailers) {
            if (status.isOk()) {
                this.observer.onCompleted();
            } else {
                this.observer.onError(status.asRuntimeException(trailers));
            }
        }

        public void onReady() {
            if (this.adapter.onReadyHandler != null) {
                this.adapter.onReadyHandler.run();
            }
        }
    }

    private static final class UnaryStreamToFuture<RespT> extends ClientCall.Listener<RespT> {
        private final GrpcFuture<RespT> responseFuture;
        private RespT value;

        UnaryStreamToFuture(GrpcFuture<RespT> responseFuture2) {
            this.responseFuture = responseFuture2;
        }

        public void onHeaders(Metadata headers) {
        }

        public void onMessage(RespT value2) {
            if (this.value == null) {
                this.value = value2;
                return;
            }
            throw Status.INTERNAL.withDescription("More than one value received for unary call").asRuntimeException();
        }

        public void onClose(Status status, Metadata trailers) {
            if (status.isOk()) {
                if (this.value == null) {
                    this.responseFuture.setException(Status.INTERNAL.withDescription("No value received for unary call").asRuntimeException(trailers));
                }
                this.responseFuture.set(this.value);
                return;
            }
            this.responseFuture.setException(status.asRuntimeException(trailers));
        }
    }

    private static final class GrpcFuture<RespT> extends AbstractFuture<RespT> {
        private final ClientCall<?, RespT> call;

        GrpcFuture(ClientCall<?, RespT> call2) {
            this.call = call2;
        }

        /* access modifiers changed from: protected */
        public void interruptTask() {
            this.call.cancel("GrpcFuture was cancelled", (Throwable) null);
        }

        /* access modifiers changed from: protected */
        public boolean set(@Nullable RespT resp) {
            return super.set(resp);
        }

        /* access modifiers changed from: protected */
        public boolean setException(Throwable throwable) {
            return super.setException(throwable);
        }

        /* access modifiers changed from: protected */
        public String pendingToString() {
            return MoreObjects.toStringHelper((Object) this).add("clientCall", (Object) this.call).toString();
        }
    }

    private static final class BlockingResponseStream<T> implements Iterator<T> {
        /* access modifiers changed from: private */
        public final BlockingQueue<Object> buffer;
        private final ClientCall<?, T> call;
        private Object last;
        private final ClientCall.Listener<T> listener;
        private final ThreadlessExecutor threadless;

        BlockingResponseStream(ClientCall<?, T> call2) {
            this(call2, (ThreadlessExecutor) null);
        }

        BlockingResponseStream(ClientCall<?, T> call2, ThreadlessExecutor threadless2) {
            this.buffer = new ArrayBlockingQueue(2);
            this.listener = new QueuingListener();
            this.call = call2;
            this.threadless = threadless2;
        }

        /* access modifiers changed from: package-private */
        public ClientCall.Listener<T> listener() {
            return this.listener;
        }

        private Object waitForNext() throws InterruptedException {
            if (this.threadless == null) {
                return this.buffer.take();
            }
            Object next = this.buffer.poll();
            while (next == null) {
                this.threadless.waitAndDrain();
                next = this.buffer.poll();
            }
            return next;
        }

        public boolean hasNext() {
            if (this.last == null) {
                try {
                    this.last = waitForNext();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw Status.CANCELLED.withDescription("interrupted").withCause(ie).asRuntimeException();
                }
            }
            Object obj = this.last;
            if (!(obj instanceof StatusRuntimeException)) {
                return obj != this;
            }
            StatusRuntimeException e = (StatusRuntimeException) obj;
            throw e.getStatus().asRuntimeException(e.getTrailers());
        }

        public T next() {
            if (hasNext()) {
                try {
                    this.call.request(1);
                    return this.last;
                } finally {
                    this.last = null;
                }
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private final class QueuingListener extends ClientCall.Listener<T> {
            private boolean done = false;

            QueuingListener() {
            }

            public void onHeaders(Metadata headers) {
            }

            public void onMessage(T value) {
                Preconditions.checkState(!this.done, "ClientCall already closed");
                BlockingResponseStream.this.buffer.add(value);
            }

            public void onClose(Status status, Metadata trailers) {
                Preconditions.checkState(!this.done, "ClientCall already closed");
                if (status.isOk()) {
                    BlockingResponseStream.this.buffer.add(BlockingResponseStream.this);
                } else {
                    BlockingResponseStream.this.buffer.add(status.asRuntimeException(trailers));
                }
                this.done = true;
            }
        }
    }

    private static final class ThreadlessExecutor extends ConcurrentLinkedQueue<Runnable> implements Executor {
        private static final Logger log = Logger.getLogger(ThreadlessExecutor.class.getName());
        private volatile Thread waiter;

        ThreadlessExecutor() {
        }

        public void waitAndDrain() throws InterruptedException {
            Runnable runnable;
            Thread currentThread = Thread.currentThread();
            throwIfInterrupted(currentThread);
            Runnable runnable2 = (Runnable) poll();
            if (runnable2 == null) {
                this.waiter = currentThread;
                while (true) {
                    try {
                        Runnable runnable3 = (Runnable) poll();
                        runnable2 = runnable3;
                        if (runnable3 != null) {
                            break;
                        }
                        LockSupport.park(this);
                        throwIfInterrupted(currentThread);
                    } finally {
                        this.waiter = null;
                    }
                }
            }
            do {
                try {
                    runnable2.run();
                } catch (Throwable t) {
                    log.log(Level.WARNING, "Runnable threw exception", t);
                }
                runnable = (Runnable) poll();
                runnable2 = runnable;
            } while (runnable != null);
        }

        private static void throwIfInterrupted(Thread currentThread) throws InterruptedException {
            if (currentThread.isInterrupted()) {
                throw new InterruptedException();
            }
        }

        public void execute(Runnable runnable) {
            add(runnable);
            LockSupport.unpark(this.waiter);
        }
    }
}
