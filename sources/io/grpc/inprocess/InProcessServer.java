package io.grpc.inprocess;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.InternalServer;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import io.grpc.internal.ServerTransportListener;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;

final class InProcessServer implements InternalServer {
    private static final ConcurrentMap<String, InProcessServer> registry = new ConcurrentHashMap();
    private ServerListener listener;
    private final int maxInboundMetadataSize;
    private final String name;
    private ScheduledExecutorService scheduler;
    private final ObjectPool<ScheduledExecutorService> schedulerPool;
    private boolean shutdown;
    private final List<ServerStreamTracer.Factory> streamTracerFactories;

    static InProcessServer findServer(String name2) {
        return (InProcessServer) registry.get(name2);
    }

    InProcessServer(InProcessServerBuilder builder, List<? extends ServerStreamTracer.Factory> streamTracerFactories2) {
        this.name = builder.name;
        this.schedulerPool = builder.schedulerPool;
        this.maxInboundMetadataSize = builder.maxInboundMetadataSize;
        this.streamTracerFactories = Collections.unmodifiableList((List) Preconditions.checkNotNull(streamTracerFactories2, "streamTracerFactories"));
    }

    public void start(ServerListener serverListener) throws IOException {
        this.listener = serverListener;
        this.scheduler = this.schedulerPool.getObject();
        if (registry.putIfAbsent(this.name, this) != null) {
            throw new IOException("name already registered: " + this.name);
        }
    }

    public SocketAddress getListenSocketAddress() {
        return new InProcessSocketAddress(this.name);
    }

    public InternalInstrumented<InternalChannelz.SocketStats> getListenSocketStats() {
        return null;
    }

    public void shutdown() {
        if (registry.remove(this.name, this)) {
            this.scheduler = this.schedulerPool.returnObject(this.scheduler);
            synchronized (this) {
                this.shutdown = true;
                this.listener.serverShutdown();
            }
            return;
        }
        throw new AssertionError();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) this.name).toString();
    }

    /* access modifiers changed from: package-private */
    public synchronized ServerTransportListener register(InProcessTransport transport) {
        if (this.shutdown) {
            return null;
        }
        return this.listener.transportCreated(transport);
    }

    /* access modifiers changed from: package-private */
    public ObjectPool<ScheduledExecutorService> getScheduledExecutorServicePool() {
        return this.schedulerPool;
    }

    /* access modifiers changed from: package-private */
    public int getMaxInboundMetadataSize() {
        return this.maxInboundMetadataSize;
    }

    /* access modifiers changed from: package-private */
    public List<ServerStreamTracer.Factory> getStreamTracerFactories() {
        return this.streamTracerFactories;
    }
}
