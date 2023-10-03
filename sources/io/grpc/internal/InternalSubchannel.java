package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.InternalWithLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.BackoffPolicy;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ManagedClientTransport;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class InternalSubchannel implements InternalInstrumented<InternalChannelz.ChannelStats> {
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(InternalSubchannel.class.getName());
    /* access modifiers changed from: private */
    @Nullable
    public volatile ManagedClientTransport activeTransport;
    /* access modifiers changed from: private */
    public Index addressIndex;
    private final String authority;
    private final BackoffPolicy.Provider backoffPolicyProvider;
    /* access modifiers changed from: private */
    public final Callback callback;
    private final CallTracer callsTracer;
    /* access modifiers changed from: private */
    public final ChannelLoggerImpl channelLogger;
    private final ChannelTracer channelTracer;
    /* access modifiers changed from: private */
    public final InternalChannelz channelz;
    private final Stopwatch connectingTimer;
    /* access modifiers changed from: private */
    public final InUseStateAggregator<ConnectionClientTransport> inUseStateAggregator = new InUseStateAggregator<ConnectionClientTransport>() {
        /* access modifiers changed from: protected */
        public void handleInUse() {
            InternalSubchannel.this.callback.onInUse(InternalSubchannel.this);
        }

        /* access modifiers changed from: protected */
        public void handleNotInUse() {
            InternalSubchannel.this.callback.onNotInUse(InternalSubchannel.this);
        }
    };
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final InternalLogId logId;
    /* access modifiers changed from: private */
    @Nullable
    public ConnectionClientTransport pendingTransport;
    /* access modifiers changed from: private */
    public boolean reconnectCanceled;
    /* access modifiers changed from: private */
    public BackoffPolicy reconnectPolicy;
    /* access modifiers changed from: private */
    @Nullable
    public ScheduledFuture<?> reconnectTask;
    private final ScheduledExecutorService scheduledExecutor;
    /* access modifiers changed from: private */
    public Status shutdownReason;
    /* access modifiers changed from: private */
    public ConnectivityStateInfo state = ConnectivityStateInfo.forNonError(ConnectivityState.IDLE);
    /* access modifiers changed from: private */
    public final SynchronizationContext syncContext;
    private final ClientTransportFactory transportFactory;
    /* access modifiers changed from: private */
    public final Collection<ConnectionClientTransport> transports = new ArrayList();
    private final String userAgent;

    InternalSubchannel(List<EquivalentAddressGroup> addressGroups, String authority2, String userAgent2, BackoffPolicy.Provider backoffPolicyProvider2, ClientTransportFactory transportFactory2, ScheduledExecutorService scheduledExecutor2, Supplier<Stopwatch> stopwatchSupplier, SynchronizationContext syncContext2, Callback callback2, InternalChannelz channelz2, CallTracer callsTracer2, ChannelTracer channelTracer2, InternalLogId logId2, TimeProvider timeProvider) {
        List<EquivalentAddressGroup> list = addressGroups;
        String str = authority2;
        ChannelTracer channelTracer3 = channelTracer2;
        Preconditions.checkNotNull(addressGroups, "addressGroups");
        Preconditions.checkArgument(!addressGroups.isEmpty(), "addressGroups is empty");
        checkListHasNoNulls(addressGroups, "addressGroups contains null entry");
        this.addressIndex = new Index(Collections.unmodifiableList(new ArrayList(addressGroups)));
        this.authority = str;
        this.userAgent = userAgent2;
        this.backoffPolicyProvider = backoffPolicyProvider2;
        this.transportFactory = transportFactory2;
        this.scheduledExecutor = scheduledExecutor2;
        this.connectingTimer = stopwatchSupplier.get();
        this.syncContext = syncContext2;
        this.callback = callback2;
        this.channelz = channelz2;
        this.callsTracer = callsTracer2;
        this.channelTracer = (ChannelTracer) Preconditions.checkNotNull(channelTracer3, "channelTracer");
        this.logId = InternalLogId.allocate("Subchannel", str);
        this.channelLogger = new ChannelLoggerImpl(channelTracer3, timeProvider);
    }

    /* access modifiers changed from: package-private */
    public ChannelLogger getChannelLogger() {
        return this.channelLogger;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        r5.syncContext.drain();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        return null;
     */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.grpc.internal.ClientTransport obtainActiveTransport() {
        /*
            r5 = this;
            io.grpc.internal.ManagedClientTransport r0 = r5.activeTransport
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.Object r1 = r5.lock     // Catch:{ all -> 0x003b }
            monitor-enter(r1)     // Catch:{ all -> 0x003b }
            io.grpc.internal.ManagedClientTransport r2 = r5.activeTransport     // Catch:{ all -> 0x0038 }
            r0 = r2
            if (r0 == 0) goto L_0x0014
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            io.grpc.SynchronizationContext r1 = r5.syncContext
            r1.drain()
            return r0
        L_0x0014:
            io.grpc.ConnectivityStateInfo r2 = r5.state     // Catch:{ all -> 0x0038 }
            io.grpc.ConnectivityState r2 = r2.getState()     // Catch:{ all -> 0x0038 }
            io.grpc.ConnectivityState r3 = io.grpc.ConnectivityState.IDLE     // Catch:{ all -> 0x0038 }
            if (r2 != r3) goto L_0x002f
            io.grpc.internal.ChannelLoggerImpl r2 = r5.channelLogger     // Catch:{ all -> 0x0038 }
            io.grpc.ChannelLogger$ChannelLogLevel r3 = io.grpc.ChannelLogger.ChannelLogLevel.INFO     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = "CONNECTING as requested"
            r2.log(r3, r4)     // Catch:{ all -> 0x0038 }
            io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.CONNECTING     // Catch:{ all -> 0x0038 }
            r5.gotoNonErrorState(r2)     // Catch:{ all -> 0x0038 }
            r5.startNewTransport()     // Catch:{ all -> 0x0038 }
        L_0x002f:
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            io.grpc.SynchronizationContext r1 = r5.syncContext
            r1.drain()
            r1 = 0
            return r1
        L_0x0038:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            throw r2     // Catch:{ all -> 0x003b }
        L_0x003b:
            r1 = move-exception
            io.grpc.SynchronizationContext r2 = r5.syncContext
            r2.drain()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.InternalSubchannel.obtainActiveTransport():io.grpc.internal.ClientTransport");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ClientTransport getTransport() {
        return this.activeTransport;
    }

    /* access modifiers changed from: package-private */
    public String getAuthority() {
        return this.authority;
    }

    /* access modifiers changed from: private */
    public void startNewTransport() {
        Preconditions.checkState(this.reconnectTask == null, "Should have no reconnectTask scheduled");
        if (this.addressIndex.isAtBeginning()) {
            this.connectingTimer.reset().start();
        }
        SocketAddress address = this.addressIndex.getCurrentAddress();
        HttpConnectProxiedSocketAddress proxiedAddr = null;
        boolean z = address instanceof HttpConnectProxiedSocketAddress;
        SocketAddress address2 = address;
        if (z) {
            proxiedAddr = (HttpConnectProxiedSocketAddress) address;
            address2 = proxiedAddr.getTargetAddress();
        }
        ClientTransportFactory.ClientTransportOptions options = new ClientTransportFactory.ClientTransportOptions().setAuthority(this.authority).setEagAttributes(this.addressIndex.getCurrentEagAttributes()).setUserAgent(this.userAgent).setHttpConnectProxiedSocketAddress(proxiedAddr);
        TransportLogger transportLogger = new TransportLogger();
        transportLogger.logId = getLogId();
        ConnectionClientTransport transport = new CallTracingTransport(this.transportFactory.newClientTransport(address2, options, transportLogger), this.callsTracer);
        transportLogger.logId = transport.getLogId();
        this.channelz.addClientSocket(transport);
        this.pendingTransport = transport;
        this.transports.add(transport);
        Runnable runnable = transport.start(new TransportListener(transport, address2));
        if (runnable != null) {
            this.syncContext.executeLater(runnable);
        }
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Started transport {0}", transportLogger.logId);
    }

    /* access modifiers changed from: private */
    public void scheduleBackoff(Status status) {
        gotoState(ConnectivityStateInfo.forTransientFailure(status));
        if (this.reconnectPolicy == null) {
            this.reconnectPolicy = this.backoffPolicyProvider.get();
        }
        long delayNanos = this.reconnectPolicy.nextBackoffNanos() - this.connectingTimer.elapsed(TimeUnit.NANOSECONDS);
        boolean z = true;
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", printShortStatus(status), Long.valueOf(delayNanos));
        if (this.reconnectTask != null) {
            z = false;
        }
        Preconditions.checkState(z, "previous reconnectTask is not done");
        this.reconnectCanceled = false;
        this.reconnectTask = this.scheduledExecutor.schedule(new LogExceptionRunnable(new Runnable() {
            public void run() {
                try {
                    synchronized (InternalSubchannel.this.lock) {
                        ScheduledFuture unused = InternalSubchannel.this.reconnectTask = null;
                        if (InternalSubchannel.this.reconnectCanceled) {
                            InternalSubchannel.this.syncContext.drain();
                            return;
                        }
                        InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING after backoff");
                        InternalSubchannel.this.gotoNonErrorState(ConnectivityState.CONNECTING);
                        InternalSubchannel.this.startNewTransport();
                    }
                } catch (Throwable t) {
                    try {
                        InternalSubchannel.log.log(Level.WARNING, "Exception handling end of backoff", t);
                    } catch (Throwable th) {
                        InternalSubchannel.this.syncContext.drain();
                        throw th;
                    }
                }
                InternalSubchannel.this.syncContext.drain();
            }
        }), delayNanos, TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: package-private */
    public void resetConnectBackoff() {
        try {
            synchronized (this.lock) {
                if (this.state.getState() != ConnectivityState.TRANSIENT_FAILURE) {
                    this.syncContext.drain();
                    return;
                }
                cancelReconnectTask();
                this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING; backoff interrupted");
                gotoNonErrorState(ConnectivityState.CONNECTING);
                startNewTransport();
                this.syncContext.drain();
            }
        } catch (Throwable th) {
            this.syncContext.drain();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void gotoNonErrorState(ConnectivityState newState) {
        gotoState(ConnectivityStateInfo.forNonError(newState));
    }

    private void gotoState(final ConnectivityStateInfo newState) {
        if (this.state.getState() != newState.getState()) {
            boolean z = this.state.getState() != ConnectivityState.SHUTDOWN;
            Preconditions.checkState(z, "Cannot transition out of SHUTDOWN to " + newState);
            this.state = newState;
            this.syncContext.executeLater(new Runnable() {
                public void run() {
                    InternalSubchannel.this.callback.onStateChange(InternalSubchannel.this, newState);
                }
            });
        }
    }

    public void updateAddresses(List<EquivalentAddressGroup> newAddressGroups) {
        Preconditions.checkNotNull(newAddressGroups, "newAddressGroups");
        checkListHasNoNulls(newAddressGroups, "newAddressGroups contains null entry");
        Preconditions.checkArgument(!newAddressGroups.isEmpty(), "newAddressGroups is empty");
        List<EquivalentAddressGroup> newAddressGroups2 = Collections.unmodifiableList(new ArrayList(newAddressGroups));
        ManagedClientTransport savedTransport = null;
        try {
            synchronized (this.lock) {
                SocketAddress previousAddress = this.addressIndex.getCurrentAddress();
                this.addressIndex.updateGroups(newAddressGroups2);
                if ((this.state.getState() == ConnectivityState.READY || this.state.getState() == ConnectivityState.CONNECTING) && !this.addressIndex.seekTo(previousAddress)) {
                    if (this.state.getState() == ConnectivityState.READY) {
                        savedTransport = this.activeTransport;
                        this.activeTransport = null;
                        this.addressIndex.reset();
                        gotoNonErrorState(ConnectivityState.IDLE);
                    } else {
                        savedTransport = this.pendingTransport;
                        this.pendingTransport = null;
                        this.addressIndex.reset();
                        startNewTransport();
                    }
                }
            }
            this.syncContext.drain();
            if (savedTransport != null) {
                savedTransport.shutdown(Status.UNAVAILABLE.withDescription("InternalSubchannel closed transport due to address change"));
            }
        } catch (Throwable th) {
            this.syncContext.drain();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r4.syncContext.drain();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r1 == null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r1.shutdown(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r2.shutdown(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shutdown(io.grpc.Status r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.lock     // Catch:{ all -> 0x004c }
            monitor-enter(r0)     // Catch:{ all -> 0x004c }
            io.grpc.ConnectivityStateInfo r1 = r4.state     // Catch:{ all -> 0x0049 }
            io.grpc.ConnectivityState r1 = r1.getState()     // Catch:{ all -> 0x0049 }
            io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.SHUTDOWN     // Catch:{ all -> 0x0049 }
            if (r1 != r2) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            io.grpc.SynchronizationContext r0 = r4.syncContext
            r0.drain()
            return
        L_0x0014:
            r4.shutdownReason = r5     // Catch:{ all -> 0x0049 }
            io.grpc.ConnectivityState r1 = io.grpc.ConnectivityState.SHUTDOWN     // Catch:{ all -> 0x0049 }
            r4.gotoNonErrorState(r1)     // Catch:{ all -> 0x0049 }
            io.grpc.internal.ManagedClientTransport r1 = r4.activeTransport     // Catch:{ all -> 0x0049 }
            io.grpc.internal.ConnectionClientTransport r2 = r4.pendingTransport     // Catch:{ all -> 0x0049 }
            r3 = 0
            r4.activeTransport = r3     // Catch:{ all -> 0x0049 }
            r4.pendingTransport = r3     // Catch:{ all -> 0x0049 }
            io.grpc.internal.InternalSubchannel$Index r3 = r4.addressIndex     // Catch:{ all -> 0x0049 }
            r3.reset()     // Catch:{ all -> 0x0049 }
            java.util.Collection<io.grpc.internal.ConnectionClientTransport> r3 = r4.transports     // Catch:{ all -> 0x0049 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0034
            r4.handleTermination()     // Catch:{ all -> 0x0049 }
        L_0x0034:
            r4.cancelReconnectTask()     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            io.grpc.SynchronizationContext r0 = r4.syncContext
            r0.drain()
            if (r1 == 0) goto L_0x0043
            r1.shutdown(r5)
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            r2.shutdown(r5)
        L_0x0048:
            return
        L_0x0049:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            io.grpc.SynchronizationContext r1 = r4.syncContext
            r1.drain()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.InternalSubchannel.shutdown(io.grpc.Status):void");
    }

    public String toString() {
        Object addressGroupsCopy;
        synchronized (this.lock) {
            addressGroupsCopy = this.addressIndex.getGroups();
        }
        return MoreObjects.toStringHelper((Object) this).add("logId", this.logId.getId()).add("addressGroups", addressGroupsCopy).toString();
    }

    /* access modifiers changed from: private */
    public void handleTermination() {
        this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "Terminated");
        this.syncContext.executeLater(new Runnable() {
            public void run() {
                InternalSubchannel.this.callback.onTerminated(InternalSubchannel.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleTransportInUseState(final ConnectionClientTransport transport, final boolean inUse) {
        this.syncContext.execute(new Runnable() {
            public void run() {
                InternalSubchannel.this.inUseStateAggregator.updateObjectInUse(transport, inUse);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void shutdownNow(Status reason) {
        Collection<ManagedClientTransport> transportsCopy;
        shutdown(reason);
        try {
            synchronized (this.lock) {
                transportsCopy = new ArrayList<>(this.transports);
            }
            this.syncContext.drain();
            for (ManagedClientTransport transport : transportsCopy) {
                transport.shutdownNow(reason);
            }
        } catch (Throwable th) {
            this.syncContext.drain();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public List<EquivalentAddressGroup> getAddressGroups() {
        List<EquivalentAddressGroup> groups;
        try {
            synchronized (this.lock) {
                groups = this.addressIndex.getGroups();
            }
            this.syncContext.drain();
            return groups;
        } catch (Throwable th) {
            this.syncContext.drain();
            throw th;
        }
    }

    private void cancelReconnectTask() {
        ScheduledFuture<?> scheduledFuture = this.reconnectTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.reconnectCanceled = true;
            this.reconnectTask = null;
            this.reconnectPolicy = null;
        }
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    public ListenableFuture<InternalChannelz.ChannelStats> getStats() {
        List<EquivalentAddressGroup> addressGroupsSnapshot;
        List<InternalWithLogId> transportsSnapshot;
        SettableFuture<InternalChannelz.ChannelStats> ret = SettableFuture.create();
        InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
        synchronized (this.lock) {
            addressGroupsSnapshot = this.addressIndex.getGroups();
            transportsSnapshot = new ArrayList<>(this.transports);
        }
        builder.setTarget(addressGroupsSnapshot.toString()).setState(getState());
        builder.setSockets(transportsSnapshot);
        this.callsTracer.updateBuilder(builder);
        this.channelTracer.updateBuilder(builder);
        ret.set(builder.build());
        return ret;
    }

    /* access modifiers changed from: package-private */
    public ConnectivityState getState() {
        ConnectivityState state2;
        try {
            synchronized (this.lock) {
                state2 = this.state.getState();
            }
            this.syncContext.drain();
            return state2;
        } catch (Throwable th) {
            this.syncContext.drain();
            throw th;
        }
    }

    private static void checkListHasNoNulls(List<?> list, String msg) {
        for (Object item : list) {
            Preconditions.checkNotNull(item, msg);
        }
    }

    private class TransportListener implements ManagedClientTransport.Listener {
        final SocketAddress address;
        final ConnectionClientTransport transport;

        TransportListener(ConnectionClientTransport transport2, SocketAddress address2) {
            this.transport = transport2;
            this.address = address2;
        }

        public void transportReady() {
            Status savedShutdownReason;
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "READY");
            try {
                synchronized (InternalSubchannel.this.lock) {
                    savedShutdownReason = InternalSubchannel.this.shutdownReason;
                    BackoffPolicy unused = InternalSubchannel.this.reconnectPolicy = null;
                    if (savedShutdownReason != null) {
                        Preconditions.checkState(InternalSubchannel.this.activeTransport == null, "Unexpected non-null activeTransport");
                    } else if (InternalSubchannel.this.pendingTransport == this.transport) {
                        InternalSubchannel.this.gotoNonErrorState(ConnectivityState.READY);
                        ManagedClientTransport unused2 = InternalSubchannel.this.activeTransport = this.transport;
                        ConnectionClientTransport unused3 = InternalSubchannel.this.pendingTransport = null;
                    }
                }
                InternalSubchannel.this.syncContext.drain();
                if (savedShutdownReason != null) {
                    this.transport.shutdown(savedShutdownReason);
                }
            } catch (Throwable th) {
                InternalSubchannel.this.syncContext.drain();
                throw th;
            }
        }

        public void transportInUse(boolean inUse) {
            InternalSubchannel.this.handleTransportInUseState(this.transport, inUse);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ba, code lost:
            io.grpc.internal.InternalSubchannel.access$900(r7.this$0).drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c4, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void transportShutdown(io.grpc.Status r8) {
            /*
                r7 = this;
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.ChannelLoggerImpl r0 = r0.channelLogger
                io.grpc.ChannelLogger$ChannelLogLevel r1 = io.grpc.ChannelLogger.ChannelLogLevel.INFO
                java.lang.String r2 = "{0} SHUTDOWN with {1}"
                r3 = 2
                java.lang.Object[] r3 = new java.lang.Object[r3]
                io.grpc.internal.ConnectionClientTransport r4 = r7.transport
                io.grpc.InternalLogId r4 = r4.getLogId()
                r5 = 0
                r3[r5] = r4
                io.grpc.internal.InternalSubchannel r4 = io.grpc.internal.InternalSubchannel.this
                java.lang.String r4 = r4.printShortStatus(r8)
                r6 = 1
                r3[r6] = r4
                r0.log(r1, r2, r3)
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c8 }
                java.lang.Object r0 = r0.lock     // Catch:{ all -> 0x00c8 }
                monitor-enter(r0)     // Catch:{ all -> 0x00c8 }
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.ConnectivityStateInfo r1 = r1.state     // Catch:{ all -> 0x00c5 }
                io.grpc.ConnectivityState r1 = r1.getState()     // Catch:{ all -> 0x00c5 }
                io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.SHUTDOWN     // Catch:{ all -> 0x00c5 }
                if (r1 != r2) goto L_0x0042
                monitor-exit(r0)     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                io.grpc.SynchronizationContext r0 = r0.syncContext
                r0.drain()
                return
            L_0x0042:
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.ManagedClientTransport r1 = r1.activeTransport     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.ConnectionClientTransport r2 = r7.transport     // Catch:{ all -> 0x00c5 }
                r3 = 0
                if (r1 != r2) goto L_0x0063
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.IDLE     // Catch:{ all -> 0x00c5 }
                r1.gotoNonErrorState(r2)     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.ManagedClientTransport unused = r1.activeTransport = r3     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel$Index r1 = r1.addressIndex     // Catch:{ all -> 0x00c5 }
                r1.reset()     // Catch:{ all -> 0x00c5 }
                goto L_0x00b9
            L_0x0063:
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.ConnectionClientTransport r1 = r1.pendingTransport     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.ConnectionClientTransport r2 = r7.transport     // Catch:{ all -> 0x00c5 }
                if (r1 != r2) goto L_0x00b9
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.ConnectivityStateInfo r1 = r1.state     // Catch:{ all -> 0x00c5 }
                io.grpc.ConnectivityState r1 = r1.getState()     // Catch:{ all -> 0x00c5 }
                io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.CONNECTING     // Catch:{ all -> 0x00c5 }
                if (r1 != r2) goto L_0x007c
                r5 = r6
            L_0x007c:
                java.lang.String r1 = "Expected state is CONNECTING, actual state is %s"
                io.grpc.internal.InternalSubchannel r2 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.ConnectivityStateInfo r2 = r2.state     // Catch:{ all -> 0x00c5 }
                io.grpc.ConnectivityState r2 = r2.getState()     // Catch:{ all -> 0x00c5 }
                com.google.common.base.Preconditions.checkState((boolean) r5, (java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel$Index r1 = r1.addressIndex     // Catch:{ all -> 0x00c5 }
                r1.increment()     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel$Index r1 = r1.addressIndex     // Catch:{ all -> 0x00c5 }
                boolean r1 = r1.isValid()     // Catch:{ all -> 0x00c5 }
                if (r1 != 0) goto L_0x00b4
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.ConnectionClientTransport unused = r1.pendingTransport = r3     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel$Index r1 = r1.addressIndex     // Catch:{ all -> 0x00c5 }
                r1.reset()     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                r1.scheduleBackoff(r8)     // Catch:{ all -> 0x00c5 }
                goto L_0x00b9
            L_0x00b4:
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this     // Catch:{ all -> 0x00c5 }
                r1.startNewTransport()     // Catch:{ all -> 0x00c5 }
            L_0x00b9:
                monitor-exit(r0)     // Catch:{ all -> 0x00c5 }
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                io.grpc.SynchronizationContext r0 = r0.syncContext
                r0.drain()
                return
            L_0x00c5:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00c5 }
                throw r1     // Catch:{ all -> 0x00c8 }
            L_0x00c8:
                r0 = move-exception
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.SynchronizationContext r1 = r1.syncContext
                r1.drain()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.InternalSubchannel.TransportListener.transportShutdown(io.grpc.Status):void");
        }

        public void transportTerminated() {
            boolean z = true;
            InternalSubchannel.this.channelLogger.log(ChannelLogger.ChannelLogLevel.INFO, "{0} Terminated", this.transport.getLogId());
            InternalSubchannel.this.channelz.removeClientSocket(this.transport);
            InternalSubchannel.this.handleTransportInUseState(this.transport, false);
            try {
                synchronized (InternalSubchannel.this.lock) {
                    InternalSubchannel.this.transports.remove(this.transport);
                    if (InternalSubchannel.this.state.getState() == ConnectivityState.SHUTDOWN && InternalSubchannel.this.transports.isEmpty()) {
                        InternalSubchannel.this.handleTermination();
                    }
                }
                InternalSubchannel.this.syncContext.drain();
                if (InternalSubchannel.this.activeTransport == this.transport) {
                    z = false;
                }
                Preconditions.checkState(z, "activeTransport still points to this transport. Seems transportShutdown() was not called.");
            } catch (Throwable th) {
                InternalSubchannel.this.syncContext.drain();
                throw th;
            }
        }
    }

    static abstract class Callback {
        Callback() {
        }

        /* access modifiers changed from: package-private */
        public void onTerminated(InternalSubchannel is) {
        }

        /* access modifiers changed from: package-private */
        public void onStateChange(InternalSubchannel is, ConnectivityStateInfo newState) {
        }

        /* access modifiers changed from: package-private */
        public void onInUse(InternalSubchannel is) {
        }

        /* access modifiers changed from: package-private */
        public void onNotInUse(InternalSubchannel is) {
        }
    }

    static final class CallTracingTransport extends ForwardingConnectionClientTransport {
        /* access modifiers changed from: private */
        public final CallTracer callTracer;
        private final ConnectionClientTransport delegate;

        private CallTracingTransport(ConnectionClientTransport delegate2, CallTracer callTracer2) {
            this.delegate = delegate2;
            this.callTracer = callTracer2;
        }

        /* access modifiers changed from: protected */
        public ConnectionClientTransport delegate() {
            return this.delegate;
        }

        public ClientStream newStream(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions) {
            final ClientStream streamDelegate = super.newStream(method, headers, callOptions);
            return new ForwardingClientStream() {
                /* access modifiers changed from: protected */
                public ClientStream delegate() {
                    return streamDelegate;
                }

                public void start(final ClientStreamListener listener) {
                    CallTracingTransport.this.callTracer.reportCallStarted();
                    super.start(new ForwardingClientStreamListener() {
                        /* access modifiers changed from: protected */
                        public ClientStreamListener delegate() {
                            return listener;
                        }

                        public void closed(Status status, Metadata trailers) {
                            CallTracingTransport.this.callTracer.reportCallEnded(status.isOk());
                            super.closed(status, trailers);
                        }

                        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
                            CallTracingTransport.this.callTracer.reportCallEnded(status.isOk());
                            super.closed(status, rpcProgress, trailers);
                        }
                    });
                }
            };
        }
    }

    static final class Index {
        private List<EquivalentAddressGroup> addressGroups;
        private int addressIndex;
        private int groupIndex;

        public Index(List<EquivalentAddressGroup> groups) {
            this.addressGroups = groups;
        }

        public boolean isValid() {
            return this.groupIndex < this.addressGroups.size();
        }

        public boolean isAtBeginning() {
            return this.groupIndex == 0 && this.addressIndex == 0;
        }

        public void increment() {
            int i = this.addressIndex + 1;
            this.addressIndex = i;
            if (i >= this.addressGroups.get(this.groupIndex).getAddresses().size()) {
                this.groupIndex++;
                this.addressIndex = 0;
            }
        }

        public void reset() {
            this.groupIndex = 0;
            this.addressIndex = 0;
        }

        public SocketAddress getCurrentAddress() {
            return this.addressGroups.get(this.groupIndex).getAddresses().get(this.addressIndex);
        }

        public Attributes getCurrentEagAttributes() {
            return this.addressGroups.get(this.groupIndex).getAttributes();
        }

        public List<EquivalentAddressGroup> getGroups() {
            return this.addressGroups;
        }

        public void updateGroups(List<EquivalentAddressGroup> newGroups) {
            this.addressGroups = newGroups;
            reset();
        }

        public boolean seekTo(SocketAddress needle) {
            int i = 0;
            while (i < this.addressGroups.size()) {
                int j = this.addressGroups.get(i).getAddresses().indexOf(needle);
                if (j == -1) {
                    i++;
                } else {
                    this.groupIndex = i;
                    this.addressIndex = j;
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public String printShortStatus(Status status) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(status.getCode());
        if (status.getDescription() != null) {
            buffer.append("(");
            buffer.append(status.getDescription());
            buffer.append(")");
        }
        return buffer.toString();
    }

    static final class TransportLogger extends ChannelLogger {
        InternalLogId logId;

        TransportLogger() {
        }

        public void log(ChannelLogger.ChannelLogLevel level, String message) {
            ChannelLoggerImpl.logOnly(this.logId, level, message);
        }

        public void log(ChannelLogger.ChannelLogLevel level, String messageFormat, Object... args) {
            ChannelLoggerImpl.logOnly(this.logId, level, messageFormat, args);
        }
    }
}
