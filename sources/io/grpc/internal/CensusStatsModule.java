package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
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
import io.opencensus.contrib.grpc.metrics.RpcMeasureConstants;
import io.opencensus.stats.Measure;
import io.opencensus.stats.MeasureMap;
import io.opencensus.stats.Stats;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import io.opencensus.tags.unsafe.ContextUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class CensusStatsModule {
    /* access modifiers changed from: private */
    public static final double NANOS_PER_MILLI = ((double) TimeUnit.MILLISECONDS.toNanos(1));
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(CensusStatsModule.class.getName());
    /* access modifiers changed from: private */
    public final boolean propagateTags;
    /* access modifiers changed from: private */
    public final boolean recordFinishedRpcs;
    private final boolean recordRealTimeMetrics;
    /* access modifiers changed from: private */
    public final boolean recordStartedRpcs;
    final Metadata.Key<TagContext> statsHeader;
    /* access modifiers changed from: private */
    public final StatsRecorder statsRecorder;
    /* access modifiers changed from: private */
    public final Supplier<Stopwatch> stopwatchSupplier;
    /* access modifiers changed from: private */
    public final Tagger tagger;

    CensusStatsModule(Supplier<Stopwatch> stopwatchSupplier2, boolean propagateTags2, boolean recordStartedRpcs2, boolean recordFinishedRpcs2, boolean recordRealTimeMetrics2) {
        this(Tags.getTagger(), Tags.getTagPropagationComponent().getBinarySerializer(), Stats.getStatsRecorder(), stopwatchSupplier2, propagateTags2, recordStartedRpcs2, recordFinishedRpcs2, recordRealTimeMetrics2);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object, com.google.common.base.Supplier<com.google.common.base.Stopwatch>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CensusStatsModule(final io.opencensus.tags.Tagger r3, final io.opencensus.tags.propagation.TagContextBinarySerializer r4, io.opencensus.stats.StatsRecorder r5, com.google.common.base.Supplier<com.google.common.base.Stopwatch> r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.String r0 = "tagger"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r3, r0)
            io.opencensus.tags.Tagger r0 = (io.opencensus.tags.Tagger) r0
            r2.tagger = r0
            java.lang.String r0 = "statsRecorder"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r5, r0)
            io.opencensus.stats.StatsRecorder r0 = (io.opencensus.stats.StatsRecorder) r0
            r2.statsRecorder = r0
            java.lang.String r0 = "tagCtxSerializer"
            com.google.common.base.Preconditions.checkNotNull(r4, r0)
            java.lang.String r0 = "stopwatchSupplier"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r6, r0)
            com.google.common.base.Supplier r0 = (com.google.common.base.Supplier) r0
            r2.stopwatchSupplier = r0
            r2.propagateTags = r7
            r2.recordStartedRpcs = r8
            r2.recordFinishedRpcs = r9
            r2.recordRealTimeMetrics = r10
            io.grpc.internal.CensusStatsModule$1 r0 = new io.grpc.internal.CensusStatsModule$1
            r0.<init>(r4, r3)
            java.lang.String r1 = "grpc-tags-bin"
            io.grpc.Metadata$Key r0 = io.grpc.Metadata.Key.of((java.lang.String) r1, r0)
            r2.statsHeader = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.CensusStatsModule.<init>(io.opencensus.tags.Tagger, io.opencensus.tags.propagation.TagContextBinarySerializer, io.opencensus.stats.StatsRecorder, com.google.common.base.Supplier, boolean, boolean, boolean, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public ClientCallTracer newClientCallTracer(TagContext parentCtx, String fullMethodName) {
        return new ClientCallTracer(this, parentCtx, fullMethodName);
    }

    /* access modifiers changed from: package-private */
    public ServerStreamTracer.Factory getServerTracerFactory() {
        return new ServerTracerFactory();
    }

    /* access modifiers changed from: package-private */
    public ClientInterceptor getClientInterceptor() {
        return new StatsClientInterceptor();
    }

    /* access modifiers changed from: private */
    public void recordRealTimeMetric(TagContext ctx, Measure.MeasureDouble measure, double value) {
        if (this.recordRealTimeMetrics) {
            this.statsRecorder.newMeasureMap().put(measure, value).record(ctx);
        }
    }

    /* access modifiers changed from: private */
    public void recordRealTimeMetric(TagContext ctx, Measure.MeasureLong measure, long value) {
        if (this.recordRealTimeMetrics) {
            this.statsRecorder.newMeasureMap().put(measure, value).record(ctx);
        }
    }

    private static final class ClientTracer extends ClientStreamTracer {
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> inboundMessageCountUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> inboundUncompressedSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> inboundWireSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> outboundMessageCountUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> outboundUncompressedSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> outboundWireSizeUpdater;
        volatile long inboundMessageCount;
        volatile long inboundUncompressedSize;
        volatile long inboundWireSize;
        private final CensusStatsModule module;
        volatile long outboundMessageCount;
        volatile long outboundUncompressedSize;
        volatile long outboundWireSize;
        private final TagContext startCtx;

        static {
            AtomicLongFieldUpdater<ClientTracer> tmpOutboundUncompressedSizeUpdater;
            AtomicLongFieldUpdater<ClientTracer> tmpInboundWireSizeUpdater;
            AtomicLongFieldUpdater<ClientTracer> tmpOutboundWireSizeUpdater;
            AtomicLongFieldUpdater<ClientTracer> tmpInboundMessageCountUpdater;
            AtomicLongFieldUpdater<ClientTracer> tmpOutboundMessageCountUpdater;
            AtomicLongFieldUpdater<ClientTracer> tmpInboundUncompressedSizeUpdater;
            Class<ClientTracer> cls = ClientTracer.class;
            try {
                tmpOutboundMessageCountUpdater = AtomicLongFieldUpdater.newUpdater(cls, "outboundMessageCount");
                tmpInboundMessageCountUpdater = AtomicLongFieldUpdater.newUpdater(cls, "inboundMessageCount");
                tmpOutboundWireSizeUpdater = AtomicLongFieldUpdater.newUpdater(cls, "outboundWireSize");
                tmpInboundWireSizeUpdater = AtomicLongFieldUpdater.newUpdater(cls, "inboundWireSize");
                tmpOutboundUncompressedSizeUpdater = AtomicLongFieldUpdater.newUpdater(cls, "outboundUncompressedSize");
                tmpInboundUncompressedSizeUpdater = AtomicLongFieldUpdater.newUpdater(cls, "inboundUncompressedSize");
            } catch (Throwable t) {
                CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", t);
                tmpOutboundMessageCountUpdater = null;
                tmpInboundMessageCountUpdater = null;
                tmpOutboundWireSizeUpdater = null;
                tmpInboundWireSizeUpdater = null;
                tmpOutboundUncompressedSizeUpdater = null;
                tmpInboundUncompressedSizeUpdater = null;
            }
            outboundMessageCountUpdater = tmpOutboundMessageCountUpdater;
            inboundMessageCountUpdater = tmpInboundMessageCountUpdater;
            outboundWireSizeUpdater = tmpOutboundWireSizeUpdater;
            inboundWireSizeUpdater = tmpInboundWireSizeUpdater;
            outboundUncompressedSizeUpdater = tmpOutboundUncompressedSizeUpdater;
            inboundUncompressedSizeUpdater = tmpInboundUncompressedSizeUpdater;
        }

        ClientTracer(CensusStatsModule module2, TagContext startCtx2) {
            this.module = (CensusStatsModule) Preconditions.checkNotNull(module2, "module");
            this.startCtx = (TagContext) Preconditions.checkNotNull(startCtx2, "startCtx");
        }

        public void outboundWireSize(long bytes) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, bytes);
            } else {
                this.outboundWireSize += bytes;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_SENT_BYTES_PER_METHOD, (double) bytes);
        }

        public void inboundWireSize(long bytes) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, bytes);
            } else {
                this.inboundWireSize += bytes;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_RECEIVED_BYTES_PER_METHOD, (double) bytes);
        }

        public void outboundUncompressedSize(long bytes) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, bytes);
            } else {
                this.outboundUncompressedSize += bytes;
            }
        }

        public void inboundUncompressedSize(long bytes) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, bytes);
            } else {
                this.inboundUncompressedSize += bytes;
            }
        }

        public void inboundMessage(int seqNo) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.inboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_RECEIVED_MESSAGES_PER_METHOD, 1);
        }

        public void outboundMessage(int seqNo) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.outboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_SENT_MESSAGES_PER_METHOD, 1);
        }
    }

    static final class ClientCallTracer extends ClientStreamTracer.Factory {
        @Nullable
        private static final AtomicIntegerFieldUpdater<ClientCallTracer> callEndedUpdater;
        @Nullable
        private static final AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> streamTracerUpdater;
        private volatile int callEnded;
        private final CensusStatsModule module;
        private final TagContext parentCtx;
        private final TagContext startCtx;
        private final Stopwatch stopwatch;
        private volatile ClientTracer streamTracer;

        static {
            AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> tmpStreamTracerUpdater;
            AtomicIntegerFieldUpdater<ClientCallTracer> tmpCallEndedUpdater;
            Class<ClientCallTracer> cls = ClientCallTracer.class;
            try {
                tmpStreamTracerUpdater = AtomicReferenceFieldUpdater.newUpdater(cls, ClientTracer.class, "streamTracer");
                tmpCallEndedUpdater = AtomicIntegerFieldUpdater.newUpdater(cls, "callEnded");
            } catch (Throwable t) {
                CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", t);
                tmpStreamTracerUpdater = null;
                tmpCallEndedUpdater = null;
            }
            streamTracerUpdater = tmpStreamTracerUpdater;
            callEndedUpdater = tmpCallEndedUpdater;
        }

        ClientCallTracer(CensusStatsModule module2, TagContext parentCtx2, String fullMethodName) {
            this.module = (CensusStatsModule) Preconditions.checkNotNull(module2);
            this.parentCtx = (TagContext) Preconditions.checkNotNull(parentCtx2);
            this.startCtx = module2.tagger.toBuilder(parentCtx2).putPropagating(DeprecatedCensusConstants.RPC_METHOD, TagValue.create(fullMethodName)).build();
            this.stopwatch = ((Stopwatch) module2.stopwatchSupplier.get()).start();
            if (module2.recordStartedRpcs) {
                module2.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_CLIENT_STARTED_COUNT, 1).record(this.startCtx);
            }
        }

        public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo info, Metadata headers) {
            ClientTracer tracer = new ClientTracer(this.module, this.startCtx);
            AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> atomicReferenceFieldUpdater = streamTracerUpdater;
            if (atomicReferenceFieldUpdater != null) {
                Preconditions.checkState(atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, tracer), "Are you creating multiple streams per call? This class doesn't yet support this case");
            } else {
                Preconditions.checkState(this.streamTracer == null, "Are you creating multiple streams per call? This class doesn't yet support this case");
                this.streamTracer = tracer;
            }
            if (this.module.propagateTags) {
                headers.discardAll(this.module.statsHeader);
                if (!this.module.tagger.empty().equals(this.parentCtx)) {
                    headers.put(this.module.statsHeader, this.parentCtx);
                }
            }
            return tracer;
        }

        /* access modifiers changed from: package-private */
        public void callEnded(Status status) {
            AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater = callEndedUpdater;
            if (atomicIntegerFieldUpdater != null) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.callEnded == 0) {
                this.callEnded = 1;
            } else {
                return;
            }
            if (this.module.recordFinishedRpcs) {
                this.stopwatch.stop();
                long roundtripNanos = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
                ClientTracer tracer = this.streamTracer;
                if (tracer == null) {
                    tracer = new ClientTracer(this.module, this.startCtx);
                }
                MeasureMap measureMap = this.module.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_CLIENT_FINISHED_COUNT, 1).put(DeprecatedCensusConstants.RPC_CLIENT_ROUNDTRIP_LATENCY, ((double) roundtripNanos) / CensusStatsModule.NANOS_PER_MILLI).put(DeprecatedCensusConstants.RPC_CLIENT_REQUEST_COUNT, tracer.outboundMessageCount).put(DeprecatedCensusConstants.RPC_CLIENT_RESPONSE_COUNT, tracer.inboundMessageCount).put(DeprecatedCensusConstants.RPC_CLIENT_REQUEST_BYTES, (double) tracer.outboundWireSize).put(DeprecatedCensusConstants.RPC_CLIENT_RESPONSE_BYTES, (double) tracer.inboundWireSize).put(DeprecatedCensusConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, (double) tracer.outboundUncompressedSize).put(DeprecatedCensusConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, (double) tracer.inboundUncompressedSize);
                if (!status.isOk()) {
                    measureMap.put(DeprecatedCensusConstants.RPC_CLIENT_ERROR_COUNT, 1);
                }
                measureMap.record(this.module.tagger.toBuilder(this.startCtx).putPropagating(DeprecatedCensusConstants.RPC_STATUS, TagValue.create(status.getCode().toString())).build());
            }
        }
    }

    private static final class ServerTracer extends ServerStreamTracer {
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> inboundMessageCountUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> inboundUncompressedSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> inboundWireSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> outboundMessageCountUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> outboundUncompressedSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> outboundWireSizeUpdater;
        @Nullable
        private static final AtomicIntegerFieldUpdater<ServerTracer> streamClosedUpdater;
        private volatile long inboundMessageCount;
        private volatile long inboundUncompressedSize;
        private volatile long inboundWireSize;
        private final CensusStatsModule module;
        private volatile long outboundMessageCount;
        private volatile long outboundUncompressedSize;
        private volatile long outboundWireSize;
        private final TagContext parentCtx;
        private final Stopwatch stopwatch;
        private volatile int streamClosed;

        static {
            AtomicLongFieldUpdater<ServerTracer> tmpOutboundUncompressedSizeUpdater;
            AtomicLongFieldUpdater<ServerTracer> tmpInboundWireSizeUpdater;
            AtomicLongFieldUpdater<ServerTracer> tmpOutboundWireSizeUpdater;
            AtomicLongFieldUpdater<ServerTracer> tmpInboundMessageCountUpdater;
            AtomicLongFieldUpdater<ServerTracer> tmpOutboundMessageCountUpdater;
            AtomicIntegerFieldUpdater<ServerTracer> tmpStreamClosedUpdater;
            AtomicLongFieldUpdater<ServerTracer> tmpInboundUncompressedSizeUpdater;
            Class<ServerTracer> cls = ServerTracer.class;
            try {
                tmpStreamClosedUpdater = AtomicIntegerFieldUpdater.newUpdater(cls, "streamClosed");
                tmpOutboundMessageCountUpdater = AtomicLongFieldUpdater.newUpdater(cls, "outboundMessageCount");
                tmpInboundMessageCountUpdater = AtomicLongFieldUpdater.newUpdater(cls, "inboundMessageCount");
                tmpOutboundWireSizeUpdater = AtomicLongFieldUpdater.newUpdater(cls, "outboundWireSize");
                tmpInboundWireSizeUpdater = AtomicLongFieldUpdater.newUpdater(cls, "inboundWireSize");
                tmpOutboundUncompressedSizeUpdater = AtomicLongFieldUpdater.newUpdater(cls, "outboundUncompressedSize");
                tmpInboundUncompressedSizeUpdater = AtomicLongFieldUpdater.newUpdater(cls, "inboundUncompressedSize");
            } catch (Throwable t) {
                CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", t);
                tmpStreamClosedUpdater = null;
                tmpOutboundMessageCountUpdater = null;
                tmpInboundMessageCountUpdater = null;
                tmpOutboundWireSizeUpdater = null;
                tmpInboundWireSizeUpdater = null;
                tmpOutboundUncompressedSizeUpdater = null;
                tmpInboundUncompressedSizeUpdater = null;
            }
            streamClosedUpdater = tmpStreamClosedUpdater;
            outboundMessageCountUpdater = tmpOutboundMessageCountUpdater;
            inboundMessageCountUpdater = tmpInboundMessageCountUpdater;
            outboundWireSizeUpdater = tmpOutboundWireSizeUpdater;
            inboundWireSizeUpdater = tmpInboundWireSizeUpdater;
            outboundUncompressedSizeUpdater = tmpOutboundUncompressedSizeUpdater;
            inboundUncompressedSizeUpdater = tmpInboundUncompressedSizeUpdater;
        }

        ServerTracer(CensusStatsModule module2, TagContext parentCtx2) {
            this.module = (CensusStatsModule) Preconditions.checkNotNull(module2, "module");
            this.parentCtx = (TagContext) Preconditions.checkNotNull(parentCtx2, "parentCtx");
            this.stopwatch = ((Stopwatch) module2.stopwatchSupplier.get()).start();
            if (module2.recordStartedRpcs) {
                module2.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_SERVER_STARTED_COUNT, 1).record(parentCtx2);
            }
        }

        public void outboundWireSize(long bytes) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, bytes);
            } else {
                this.outboundWireSize += bytes;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_SENT_BYTES_PER_METHOD, (double) bytes);
        }

        public void inboundWireSize(long bytes) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, bytes);
            } else {
                this.inboundWireSize += bytes;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_RECEIVED_BYTES_PER_METHOD, (double) bytes);
        }

        public void outboundUncompressedSize(long bytes) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, bytes);
            } else {
                this.outboundUncompressedSize += bytes;
            }
        }

        public void inboundUncompressedSize(long bytes) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, bytes);
            } else {
                this.inboundUncompressedSize += bytes;
            }
        }

        public void inboundMessage(int seqNo) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.inboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_RECEIVED_MESSAGES_PER_METHOD, 1);
        }

        public void outboundMessage(int seqNo) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.outboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_SENT_MESSAGES_PER_METHOD, 1);
        }

        public void streamClosed(Status status) {
            AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater = streamClosedUpdater;
            if (atomicIntegerFieldUpdater != null) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.streamClosed == 0) {
                this.streamClosed = 1;
            } else {
                return;
            }
            if (this.module.recordFinishedRpcs) {
                this.stopwatch.stop();
                MeasureMap measureMap = this.module.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_SERVER_FINISHED_COUNT, 1).put(DeprecatedCensusConstants.RPC_SERVER_SERVER_LATENCY, ((double) this.stopwatch.elapsed(TimeUnit.NANOSECONDS)) / CensusStatsModule.NANOS_PER_MILLI).put(DeprecatedCensusConstants.RPC_SERVER_RESPONSE_COUNT, this.outboundMessageCount).put(DeprecatedCensusConstants.RPC_SERVER_REQUEST_COUNT, this.inboundMessageCount).put(DeprecatedCensusConstants.RPC_SERVER_RESPONSE_BYTES, (double) this.outboundWireSize).put(DeprecatedCensusConstants.RPC_SERVER_REQUEST_BYTES, (double) this.inboundWireSize).put(DeprecatedCensusConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, (double) this.outboundUncompressedSize).put(DeprecatedCensusConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, (double) this.inboundUncompressedSize);
                if (!status.isOk()) {
                    measureMap.put(DeprecatedCensusConstants.RPC_SERVER_ERROR_COUNT, 1);
                }
                measureMap.record(this.module.tagger.toBuilder(this.parentCtx).putPropagating(DeprecatedCensusConstants.RPC_STATUS, TagValue.create(status.getCode().toString())).build());
            }
        }

        public Context filterContext(Context context) {
            if (!this.module.tagger.empty().equals(this.parentCtx)) {
                return ContextUtils.withValue(context, this.parentCtx);
            }
            return context;
        }
    }

    final class ServerTracerFactory extends ServerStreamTracer.Factory {
        ServerTracerFactory() {
        }

        public ServerStreamTracer newServerStreamTracer(String fullMethodName, Metadata headers) {
            TagContext parentCtx = (TagContext) headers.get(CensusStatsModule.this.statsHeader);
            if (parentCtx == null) {
                parentCtx = CensusStatsModule.this.tagger.empty();
            }
            return new ServerTracer(CensusStatsModule.this, CensusStatsModule.this.tagger.toBuilder(parentCtx).putPropagating(DeprecatedCensusConstants.RPC_METHOD, TagValue.create(fullMethodName)).build());
        }
    }

    final class StatsClientInterceptor implements ClientInterceptor {
        StatsClientInterceptor() {
        }

        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            final ClientCallTracer tracerFactory = CensusStatsModule.this.newClientCallTracer(CensusStatsModule.this.tagger.getCurrentTagContext(), method.getFullMethodName());
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
}
