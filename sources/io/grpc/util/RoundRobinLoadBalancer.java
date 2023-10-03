package io.grpc.util;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.ServiceConfigUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class RoundRobinLoadBalancer extends LoadBalancer {
    private static final Status EMPTY_OK = Status.OK.withDescription("no subchannels ready");
    static final Attributes.Key<Ref<ConnectivityStateInfo>> STATE_INFO = Attributes.Key.create("state-info");
    static final Attributes.Key<Ref<LoadBalancer.Subchannel>> STICKY_REF = Attributes.Key.create("sticky-ref");
    private RoundRobinPicker currentPicker = new EmptyPicker(EMPTY_OK);
    private ConnectivityState currentState;
    private final LoadBalancer.Helper helper;
    private final Random random;
    @Nullable
    private StickinessState stickinessState;
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap();

    RoundRobinLoadBalancer(LoadBalancer.Helper helper2) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper2, "helper");
        this.random = new Random();
    }

    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        String stickinessMetadataKey;
        List<EquivalentAddressGroup> servers = resolvedAddresses.getAddresses();
        Attributes attributes = resolvedAddresses.getAttributes();
        Set<EquivalentAddressGroup> currentAddrs = this.subchannels.keySet();
        Set<EquivalentAddressGroup> latestAddrs = stripAttrs(servers);
        Set<EquivalentAddressGroup> addedAddrs = setsDifference(latestAddrs, currentAddrs);
        Set<EquivalentAddressGroup> removedAddrs = setsDifference(currentAddrs, latestAddrs);
        Map<String, ?> serviceConfig = (Map) attributes.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG);
        if (!(serviceConfig == null || (stickinessMetadataKey = ServiceConfigUtil.getStickinessMetadataKeyFromServiceConfig(serviceConfig)) == null)) {
            if (stickinessMetadataKey.endsWith(Metadata.BINARY_HEADER_SUFFIX)) {
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.WARNING, "Binary stickiness header is not supported. The header \"{0}\" will be ignored", stickinessMetadataKey);
            } else {
                StickinessState stickinessState2 = this.stickinessState;
                if (stickinessState2 == null || !stickinessState2.key.name().equals(stickinessMetadataKey)) {
                    this.stickinessState = new StickinessState(stickinessMetadataKey);
                }
            }
        }
        for (EquivalentAddressGroup addressGroup : addedAddrs) {
            Attributes.Builder subchannelAttrs = Attributes.newBuilder().set(STATE_INFO, new Ref(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE)));
            Ref<LoadBalancer.Subchannel> stickyRef = null;
            if (this.stickinessState != null) {
                Attributes.Key<Ref<LoadBalancer.Subchannel>> key = STICKY_REF;
                Ref<LoadBalancer.Subchannel> ref = new Ref<>(null);
                stickyRef = ref;
                subchannelAttrs.set(key, ref);
            }
            LoadBalancer.Subchannel subchannel = (LoadBalancer.Subchannel) Preconditions.checkNotNull(this.helper.createSubchannel(addressGroup, subchannelAttrs.build()), "subchannel");
            if (stickyRef != null) {
                stickyRef.value = subchannel;
            }
            this.subchannels.put(addressGroup, subchannel);
            subchannel.requestConnection();
        }
        ArrayList<LoadBalancer.Subchannel> removedSubchannels = new ArrayList<>();
        for (EquivalentAddressGroup addressGroup2 : removedAddrs) {
            removedSubchannels.add(this.subchannels.remove(addressGroup2));
        }
        updateBalancingState();
        Iterator<LoadBalancer.Subchannel> it = removedSubchannels.iterator();
        while (it.hasNext()) {
            shutdownSubchannel(it.next());
        }
    }

    public void handleNameResolutionError(Status error) {
        ConnectivityState connectivityState = ConnectivityState.TRANSIENT_FAILURE;
        RoundRobinPicker roundRobinPicker = this.currentPicker;
        if (!(roundRobinPicker instanceof ReadyPicker)) {
            roundRobinPicker = new EmptyPicker(error);
        }
        updateBalancingState(connectivityState, roundRobinPicker);
    }

    public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo stateInfo) {
        StickinessState stickinessState2;
        if (this.subchannels.get(subchannel.getAddresses()) == subchannel) {
            if (stateInfo.getState() == ConnectivityState.SHUTDOWN && (stickinessState2 = this.stickinessState) != null) {
                stickinessState2.remove(subchannel);
            }
            if (stateInfo.getState() == ConnectivityState.IDLE) {
                subchannel.requestConnection();
            }
            getSubchannelStateInfoRef(subchannel).value = stateInfo;
            updateBalancingState();
        }
    }

    private void shutdownSubchannel(LoadBalancer.Subchannel subchannel) {
        subchannel.shutdown();
        getSubchannelStateInfoRef(subchannel).value = ConnectivityStateInfo.forNonError(ConnectivityState.SHUTDOWN);
        StickinessState stickinessState2 = this.stickinessState;
        if (stickinessState2 != null) {
            stickinessState2.remove(subchannel);
        }
    }

    public void shutdown() {
        for (LoadBalancer.Subchannel subchannel : getSubchannels()) {
            shutdownSubchannel(subchannel);
        }
    }

    private void updateBalancingState() {
        List<LoadBalancer.Subchannel> activeList = filterNonFailingSubchannels(getSubchannels());
        if (activeList.isEmpty()) {
            boolean isConnecting = false;
            Status aggStatus = EMPTY_OK;
            for (LoadBalancer.Subchannel subchannel : getSubchannels()) {
                ConnectivityStateInfo stateInfo = (ConnectivityStateInfo) getSubchannelStateInfoRef(subchannel).value;
                if (stateInfo.getState() == ConnectivityState.CONNECTING || stateInfo.getState() == ConnectivityState.IDLE) {
                    isConnecting = true;
                }
                if (aggStatus == EMPTY_OK || !aggStatus.isOk()) {
                    aggStatus = stateInfo.getStatus();
                }
            }
            updateBalancingState(isConnecting ? ConnectivityState.CONNECTING : ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(aggStatus));
            return;
        }
        updateBalancingState(ConnectivityState.READY, new ReadyPicker(activeList, this.random.nextInt(activeList.size()), this.stickinessState));
    }

    private void updateBalancingState(ConnectivityState state, RoundRobinPicker picker) {
        if (state != this.currentState || !picker.isEquivalentTo(this.currentPicker)) {
            this.helper.updateBalancingState(state, picker);
            this.currentState = state;
            this.currentPicker = picker;
        }
    }

    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> subchannels2) {
        List<LoadBalancer.Subchannel> readySubchannels = new ArrayList<>(subchannels2.size());
        for (LoadBalancer.Subchannel subchannel : subchannels2) {
            if (isReady(subchannel)) {
                readySubchannels.add(subchannel);
            }
        }
        return readySubchannels;
    }

    private static Set<EquivalentAddressGroup> stripAttrs(List<EquivalentAddressGroup> groupList) {
        Set<EquivalentAddressGroup> addrs = new HashSet<>(groupList.size());
        for (EquivalentAddressGroup group : groupList) {
            addrs.add(new EquivalentAddressGroup(group.getAddresses()));
        }
        return addrs;
    }

    /* access modifiers changed from: package-private */
    public Collection<LoadBalancer.Subchannel> getSubchannels() {
        return this.subchannels.values();
    }

    private static Ref<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel subchannel) {
        return (Ref) Preconditions.checkNotNull(subchannel.getAttributes().get(STATE_INFO), "STATE_INFO");
    }

    static boolean isReady(LoadBalancer.Subchannel subchannel) {
        return ((ConnectivityStateInfo) getSubchannelStateInfoRef(subchannel).value).getState() == ConnectivityState.READY;
    }

    private static <T> Set<T> setsDifference(Set<T> a, Set<T> b) {
        Set<T> aCopy = new HashSet<>(a);
        aCopy.removeAll(b);
        return aCopy;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Ref<LoadBalancer.Subchannel>> getStickinessMapForTest() {
        StickinessState stickinessState2 = this.stickinessState;
        if (stickinessState2 == null) {
            return null;
        }
        return stickinessState2.stickinessMap;
    }

    static final class StickinessState {
        static final int MAX_ENTRIES = 1000;
        final Queue<String> evictionQueue = new ConcurrentLinkedQueue();
        final Metadata.Key<String> key;
        final ConcurrentMap<String, Ref<LoadBalancer.Subchannel>> stickinessMap = new ConcurrentHashMap();

        StickinessState(@Nonnull String stickinessKey) {
            this.key = Metadata.Key.of(stickinessKey, Metadata.ASCII_STRING_MARSHALLER);
        }

        /* access modifiers changed from: package-private */
        @Nonnull
        public LoadBalancer.Subchannel maybeRegister(String stickinessValue, @Nonnull LoadBalancer.Subchannel subchannel) {
            Ref<LoadBalancer.Subchannel> existingSubchannelRef;
            Ref<LoadBalancer.Subchannel> newSubchannelRef = (Ref) subchannel.getAttributes().get(RoundRobinLoadBalancer.STICKY_REF);
            do {
                existingSubchannelRef = this.stickinessMap.putIfAbsent(stickinessValue, newSubchannelRef);
                if (existingSubchannelRef == null) {
                    addToEvictionQueue(stickinessValue);
                    return subchannel;
                }
                LoadBalancer.Subchannel existingSubchannel = (LoadBalancer.Subchannel) existingSubchannelRef.value;
                if (existingSubchannel != null && RoundRobinLoadBalancer.isReady(existingSubchannel)) {
                    return existingSubchannel;
                }
            } while (!this.stickinessMap.replace(stickinessValue, existingSubchannelRef, newSubchannelRef));
            return subchannel;
        }

        private void addToEvictionQueue(String value) {
            while (this.stickinessMap.size() >= 1000) {
                String poll = this.evictionQueue.poll();
                String oldValue = poll;
                if (poll == null) {
                    break;
                }
                this.stickinessMap.remove(oldValue);
            }
            this.evictionQueue.add(value);
        }

        /* access modifiers changed from: package-private */
        public void remove(LoadBalancer.Subchannel subchannel) {
            ((Ref) subchannel.getAttributes().get(RoundRobinLoadBalancer.STICKY_REF)).value = null;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public LoadBalancer.Subchannel getSubchannel(String stickinessValue) {
            Ref<LoadBalancer.Subchannel> subchannelRef = (Ref) this.stickinessMap.get(stickinessValue);
            if (subchannelRef != null) {
                return (LoadBalancer.Subchannel) subchannelRef.value;
            }
            return null;
        }
    }

    private static abstract class RoundRobinPicker extends LoadBalancer.SubchannelPicker {
        /* access modifiers changed from: package-private */
        public abstract boolean isEquivalentTo(RoundRobinPicker roundRobinPicker);

        private RoundRobinPicker() {
        }
    }

    static final class ReadyPicker extends RoundRobinPicker {
        private static final AtomicIntegerFieldUpdater<ReadyPicker> indexUpdater = AtomicIntegerFieldUpdater.newUpdater(ReadyPicker.class, FirebaseAnalytics.Param.INDEX);
        private volatile int index;
        private final List<LoadBalancer.Subchannel> list;
        @Nullable
        private final StickinessState stickinessState;

        ReadyPicker(List<LoadBalancer.Subchannel> list2, int startIndex, @Nullable StickinessState stickinessState2) {
            super();
            Preconditions.checkArgument(!list2.isEmpty(), "empty list");
            this.list = list2;
            this.stickinessState = stickinessState2;
            this.index = startIndex - 1;
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            String stickinessValue;
            LoadBalancer.Subchannel subchannel = null;
            if (!(this.stickinessState == null || (stickinessValue = (String) args.getHeaders().get(this.stickinessState.key)) == null || ((subchannel = this.stickinessState.getSubchannel(stickinessValue)) != null && RoundRobinLoadBalancer.isReady(subchannel)))) {
                subchannel = this.stickinessState.maybeRegister(stickinessValue, nextSubchannel());
            }
            return LoadBalancer.PickResult.withSubchannel(subchannel != null ? subchannel : nextSubchannel());
        }

        private LoadBalancer.Subchannel nextSubchannel() {
            int size = this.list.size();
            int i = indexUpdater.incrementAndGet(this);
            if (i >= size) {
                int oldi = i;
                i %= size;
                indexUpdater.compareAndSet(this, oldi, i);
            }
            return this.list.get(i);
        }

        /* access modifiers changed from: package-private */
        public List<LoadBalancer.Subchannel> getList() {
            return this.list;
        }

        /* JADX WARNING: type inference failed for: r5v0, types: [io.grpc.util.RoundRobinLoadBalancer$RoundRobinPicker] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isEquivalentTo(io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof io.grpc.util.RoundRobinLoadBalancer.ReadyPicker
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                r0 = r5
                io.grpc.util.RoundRobinLoadBalancer$ReadyPicker r0 = (io.grpc.util.RoundRobinLoadBalancer.ReadyPicker) r0
                if (r0 == r4) goto L_0x0030
                io.grpc.util.RoundRobinLoadBalancer$StickinessState r2 = r4.stickinessState
                io.grpc.util.RoundRobinLoadBalancer$StickinessState r3 = r0.stickinessState
                if (r2 != r3) goto L_0x002f
                java.util.List<io.grpc.LoadBalancer$Subchannel> r2 = r4.list
                int r2 = r2.size()
                java.util.List<io.grpc.LoadBalancer$Subchannel> r3 = r0.list
                int r3 = r3.size()
                if (r2 != r3) goto L_0x002f
                java.util.HashSet r2 = new java.util.HashSet
                java.util.List<io.grpc.LoadBalancer$Subchannel> r3 = r4.list
                r2.<init>(r3)
                java.util.List<io.grpc.LoadBalancer$Subchannel> r3 = r0.list
                boolean r2 = r2.containsAll(r3)
                if (r2 == 0) goto L_0x002f
                goto L_0x0030
            L_0x002f:
                goto L_0x0031
            L_0x0030:
                r1 = 1
            L_0x0031:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.util.RoundRobinLoadBalancer.ReadyPicker.isEquivalentTo(io.grpc.util.RoundRobinLoadBalancer$RoundRobinPicker):boolean");
        }
    }

    static final class EmptyPicker extends RoundRobinPicker {
        private final Status status;

        EmptyPicker(@Nonnull Status status2) {
            super();
            this.status = (Status) Preconditions.checkNotNull(status2, NotificationCompat.CATEGORY_STATUS);
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return this.status.isOk() ? LoadBalancer.PickResult.withNoResult() : LoadBalancer.PickResult.withError(this.status);
        }

        /* access modifiers changed from: package-private */
        public boolean isEquivalentTo(RoundRobinPicker picker) {
            return (picker instanceof EmptyPicker) && (Objects.equal(this.status, ((EmptyPicker) picker).status) || (this.status.isOk() && ((EmptyPicker) picker).status.isOk()));
        }
    }

    static final class Ref<T> {
        T value;

        Ref(T value2) {
            this.value = value2;
        }
    }
}
