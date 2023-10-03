package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.opencensus.trace.BlankSpan;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.MessageEvent;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.propagation.BinaryFormat;
import io.opencensus.trace.unsafe.ContextUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class CensusTracingModule {
    /* access modifiers changed from: private */
    @Nullable
    public static final AtomicIntegerFieldUpdater<ClientCallTracer> callEndedUpdater;
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(CensusTracingModule.class.getName());
    /* access modifiers changed from: private */
    @Nullable
    public static final AtomicIntegerFieldUpdater<ServerTracer> streamClosedUpdater;
    /* access modifiers changed from: private */
    public final Tracer censusTracer;
    private final TracingClientInterceptor clientInterceptor = new TracingClientInterceptor();
    private final ServerTracerFactory serverTracerFactory = new ServerTracerFactory();
    final Metadata.Key<SpanContext> tracingHeader;

    static {
        AtomicIntegerFieldUpdater<ClientCallTracer> tmpCallEndedUpdater;
        AtomicIntegerFieldUpdater<ClientCallTracer> tmpCallEndedUpdater2;
        try {
            tmpCallEndedUpdater2 = AtomicIntegerFieldUpdater.newUpdater(ClientCallTracer.class, "callEnded");
            tmpCallEndedUpdater = AtomicIntegerFieldUpdater.newUpdater(ServerTracer.class, "streamClosed");
        } catch (Throwable t) {
            logger.log(Level.SEVERE, "Creating atomic field updaters failed", t);
            tmpCallEndedUpdater2 = null;
            tmpCallEndedUpdater = null;
        }
        callEndedUpdater = tmpCallEndedUpdater2;
        streamClosedUpdater = tmpCallEndedUpdater;
    }

    CensusTracingModule(Tracer censusTracer2, final BinaryFormat censusPropagationBinaryFormat) {
        this.censusTracer = (Tracer) Preconditions.checkNotNull(censusTracer2, "censusTracer");
        Preconditions.checkNotNull(censusPropagationBinaryFormat, "censusPropagationBinaryFormat");
        this.tracingHeader = Metadata.Key.of("grpc-trace-bin", new Metadata.BinaryMarshaller<SpanContext>() {
            public byte[] toBytes(SpanContext context) {
                return censusPropagationBinaryFormat.toByteArray(context);
            }

            public SpanContext parseBytes(byte[] serialized) {
                try {
                    return censusPropagationBinaryFormat.fromByteArray(serialized);
                } catch (Exception e) {
                    CensusTracingModule.logger.log(Level.FINE, "Failed to parse tracing header", e);
                    return SpanContext.INVALID;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public ClientCallTracer newClientCallTracer(@Nullable Span parentSpan, MethodDescriptor<?, ?> method) {
        return new ClientCallTracer(parentSpan, method);
    }

    /* access modifiers changed from: package-private */
    public ServerStreamTracer.Factory getServerTracerFactory() {
        return this.serverTracerFactory;
    }

    /* access modifiers changed from: package-private */
    public ClientInterceptor getClientInterceptor() {
        return this.clientInterceptor;
    }

    /* renamed from: io.grpc.internal.CensusTracingModule$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$Status$Code;

        static {
            int[] iArr = new int[Status.Code.values().length];
            $SwitchMap$io$grpc$Status$Code = iArr;
            try {
                iArr[Status.Code.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.INVALID_ARGUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.DEADLINE_EXCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.NOT_FOUND.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.ALREADY_EXISTS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.PERMISSION_DENIED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.RESOURCE_EXHAUSTED.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.FAILED_PRECONDITION.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.ABORTED.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.OUT_OF_RANGE.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.UNIMPLEMENTED.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.INTERNAL.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.UNAVAILABLE.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.DATA_LOSS.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.UNAUTHENTICATED.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
        }
    }

    static io.opencensus.trace.Status convertStatus(Status grpcStatus) {
        io.opencensus.trace.Status status;
        switch (AnonymousClass2.$SwitchMap$io$grpc$Status$Code[grpcStatus.getCode().ordinal()]) {
            case 1:
                status = io.opencensus.trace.Status.OK;
                break;
            case 2:
                status = io.opencensus.trace.Status.CANCELLED;
                break;
            case 3:
                status = io.opencensus.trace.Status.UNKNOWN;
                break;
            case 4:
                status = io.opencensus.trace.Status.INVALID_ARGUMENT;
                break;
            case 5:
                status = io.opencensus.trace.Status.DEADLINE_EXCEEDED;
                break;
            case 6:
                status = io.opencensus.trace.Status.NOT_FOUND;
                break;
            case 7:
                status = io.opencensus.trace.Status.ALREADY_EXISTS;
                break;
            case 8:
                status = io.opencensus.trace.Status.PERMISSION_DENIED;
                break;
            case 9:
                status = io.opencensus.trace.Status.RESOURCE_EXHAUSTED;
                break;
            case 10:
                status = io.opencensus.trace.Status.FAILED_PRECONDITION;
                break;
            case 11:
                status = io.opencensus.trace.Status.ABORTED;
                break;
            case 12:
                status = io.opencensus.trace.Status.OUT_OF_RANGE;
                break;
            case 13:
                status = io.opencensus.trace.Status.UNIMPLEMENTED;
                break;
            case 14:
                status = io.opencensus.trace.Status.INTERNAL;
                break;
            case 15:
                status = io.opencensus.trace.Status.UNAVAILABLE;
                break;
            case 16:
                status = io.opencensus.trace.Status.DATA_LOSS;
                break;
            case 17:
                status = io.opencensus.trace.Status.UNAUTHENTICATED;
                break;
            default:
                throw new AssertionError("Unhandled status code " + grpcStatus.getCode());
        }
        if (grpcStatus.getDescription() != null) {
            return status.withDescription(grpcStatus.getDescription());
        }
        return status;
    }

    /* access modifiers changed from: private */
    public static EndSpanOptions createEndSpanOptions(Status status, boolean sampledToLocalTracing) {
        return EndSpanOptions.builder().setStatus(convertStatus(status)).setSampleToLocalSpanStore(sampledToLocalTracing).build();
    }

    /* access modifiers changed from: private */
    public static void recordMessageEvent(Span span, MessageEvent.Type type, int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        MessageEvent.Builder eventBuilder = MessageEvent.builder(type, (long) seqNo);
        if (optionalUncompressedSize != -1) {
            eventBuilder.setUncompressedMessageSize(optionalUncompressedSize);
        }
        if (optionalWireSize != -1) {
            eventBuilder.setCompressedMessageSize(optionalWireSize);
        }
        span.addMessageEvent(eventBuilder.build());
    }

    final class ClientCallTracer extends ClientStreamTracer.Factory {
        volatile int callEnded;
        private final boolean isSampledToLocalTracing;
        private final Span span;

        ClientCallTracer(@Nullable Span parentSpan, MethodDescriptor<?, ?> method) {
            Preconditions.checkNotNull(method, FirebaseAnalytics.Param.METHOD);
            this.isSampledToLocalTracing = method.isSampledToLocalTracing();
            this.span = CensusTracingModule.this.censusTracer.spanBuilderWithExplicitParent(CensusTracingModule.generateTraceSpanName(false, method.getFullMethodName()), parentSpan).setRecordEvents(true).startSpan();
        }

        public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo info, Metadata headers) {
            if (this.span != BlankSpan.INSTANCE) {
                headers.discardAll(CensusTracingModule.this.tracingHeader);
                headers.put(CensusTracingModule.this.tracingHeader, this.span.getContext());
            }
            return new ClientTracer(this.span);
        }

        /* access modifiers changed from: package-private */
        public void callEnded(Status status) {
            if (CensusTracingModule.callEndedUpdater != null) {
                if (CensusTracingModule.callEndedUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.callEnded == 0) {
                this.callEnded = 1;
            } else {
                return;
            }
            this.span.end(CensusTracingModule.createEndSpanOptions(status, this.isSampledToLocalTracing));
        }
    }

    private static final class ClientTracer extends ClientStreamTracer {
        private final Span span;

        ClientTracer(Span span2) {
            this.span = (Span) Preconditions.checkNotNull(span2, "span");
        }

        public void outboundMessageSent(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.SENT, seqNo, optionalWireSize, optionalUncompressedSize);
        }

        public void inboundMessageRead(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.RECEIVED, seqNo, optionalWireSize, optionalUncompressedSize);
        }
    }

    private final class ServerTracer extends ServerStreamTracer {
        volatile boolean isSampledToLocalTracing;
        private final Span span;
        volatile int streamClosed;

        ServerTracer(String fullMethodName, @Nullable SpanContext remoteSpan) {
            Preconditions.checkNotNull(fullMethodName, "fullMethodName");
            this.span = CensusTracingModule.this.censusTracer.spanBuilderWithRemoteParent(CensusTracingModule.generateTraceSpanName(true, fullMethodName), remoteSpan).setRecordEvents(true).startSpan();
        }

        public void serverCallStarted(ServerStreamTracer.ServerCallInfo<?, ?> callInfo) {
            this.isSampledToLocalTracing = callInfo.getMethodDescriptor().isSampledToLocalTracing();
        }

        public void streamClosed(Status status) {
            if (CensusTracingModule.streamClosedUpdater != null) {
                if (CensusTracingModule.streamClosedUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.streamClosed == 0) {
                this.streamClosed = 1;
            } else {
                return;
            }
            this.span.end(CensusTracingModule.createEndSpanOptions(status, this.isSampledToLocalTracing));
        }

        public Context filterContext(Context context) {
            return ContextUtils.withValue(context, this.span);
        }

        public void outboundMessageSent(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.SENT, seqNo, optionalWireSize, optionalUncompressedSize);
        }

        public void inboundMessageRead(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.RECEIVED, seqNo, optionalWireSize, optionalUncompressedSize);
        }
    }

    final class ServerTracerFactory extends ServerStreamTracer.Factory {
        ServerTracerFactory() {
        }

        public ServerStreamTracer newServerStreamTracer(String fullMethodName, Metadata headers) {
            SpanContext remoteSpan = (SpanContext) headers.get(CensusTracingModule.this.tracingHeader);
            if (remoteSpan == SpanContext.INVALID) {
                remoteSpan = null;
            }
            return new ServerTracer(fullMethodName, remoteSpan);
        }
    }

    final class TracingClientInterceptor implements ClientInterceptor {
        TracingClientInterceptor() {
        }

        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            final ClientCallTracer tracerFactory = CensusTracingModule.this.newClientCallTracer(ContextUtils.getValue(Context.current()), method);
            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions.withStreamTracerFactory(tracerFactory))) {
                public void start(ClientCall.Listener<RespT> responseListener, Metadata headers) {
                    delegate().start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                        public void onClose(Status status, Metadata trailers) {
                            tracerFactory.callEnded(status);
                            super.onClose(status, trailers);
                        }
                    }, headers);
                }
            };
        }
    }

    static String generateTraceSpanName(boolean isServer, String fullMethodName) {
        String prefix = isServer ? "Recv" : "Sent";
        return prefix + "." + fullMethodName.replace('/', '.');
    }
}
