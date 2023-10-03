package io.grpc;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.NameResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class LoadBalancer {
    public static final Attributes.Key<Map<String, ?>> ATTR_LOAD_BALANCING_CONFIG = Attributes.Key.create("io.grpc.LoadBalancer.loadBalancingConfig");

    public static abstract class Factory {
        public abstract LoadBalancer newLoadBalancer(Helper helper);
    }

    public static abstract class PickSubchannelArgs {
        public abstract CallOptions getCallOptions();

        public abstract Metadata getHeaders();

        public abstract MethodDescriptor<?, ?> getMethodDescriptor();
    }

    public abstract void handleNameResolutionError(Status status);

    public abstract void handleSubchannelState(Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo);

    public abstract void shutdown();

    @Deprecated
    public void handleResolvedAddressGroups(List<EquivalentAddressGroup> servers, Attributes attributes) {
        handleResolvedAddresses(ResolvedAddresses.newBuilder().setAddresses(servers).setAttributes(attributes).build());
    }

    public void handleResolvedAddresses(ResolvedAddresses resolvedAddresses) {
        handleResolvedAddressGroups(resolvedAddresses.getAddresses(), resolvedAddresses.getAttributes());
    }

    public static final class ResolvedAddresses {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;
        @Nullable
        private final Object loadBalancingPolicyConfig;

        private ResolvedAddresses(List<EquivalentAddressGroup> addresses2, Attributes attributes2, Object loadBalancingPolicyConfig2) {
            this.addresses = Collections.unmodifiableList(new ArrayList((Collection) Preconditions.checkNotNull(addresses2, "addresses")));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes2, "attributes");
            this.loadBalancingPolicyConfig = loadBalancingPolicyConfig2;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setLoadBalancingPolicyConfig(this.loadBalancingPolicyConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public Object getLoadBalancingPolicyConfig() {
            return this.loadBalancingPolicyConfig;
        }

        public static final class Builder {
            private List<EquivalentAddressGroup> addresses;
            private Attributes attributes = Attributes.EMPTY;
            @Nullable
            private Object loadBalancingPolicyConfig;

            Builder() {
            }

            public Builder setAddresses(List<EquivalentAddressGroup> addresses2) {
                this.addresses = addresses2;
                return this;
            }

            public Builder setAttributes(Attributes attributes2) {
                this.attributes = attributes2;
                return this;
            }

            public Builder setLoadBalancingPolicyConfig(@Nullable Object loadBalancingPolicyConfig2) {
                this.loadBalancingPolicyConfig = loadBalancingPolicyConfig2;
                return this;
            }

            public ResolvedAddresses build() {
                return new ResolvedAddresses(this.addresses, this.attributes, this.loadBalancingPolicyConfig);
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("addresses", (Object) this.addresses).add("attributes", (Object) this.attributes).add("loadBalancingPolicyConfig", this.loadBalancingPolicyConfig).toString();
        }

        public int hashCode() {
            return Objects.hashCode(this.addresses, this.attributes, this.loadBalancingPolicyConfig);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResolvedAddresses)) {
                return false;
            }
            ResolvedAddresses that = (ResolvedAddresses) obj;
            if (!Objects.equal(this.addresses, that.addresses) || !Objects.equal(this.attributes, that.attributes) || !Objects.equal(this.loadBalancingPolicyConfig, that.loadBalancingPolicyConfig)) {
                return false;
            }
            return true;
        }
    }

    public boolean canHandleEmptyAddressListFromNameResolution() {
        return false;
    }

    public static abstract class SubchannelPicker {
        public abstract PickResult pickSubchannel(PickSubchannelArgs pickSubchannelArgs);

        public void requestConnection() {
        }
    }

    public static final class PickResult {
        private static final PickResult NO_RESULT = new PickResult((Subchannel) null, (ClientStreamTracer.Factory) null, Status.OK, false);
        private final boolean drop;
        private final Status status;
        @Nullable
        private final ClientStreamTracer.Factory streamTracerFactory;
        @Nullable
        private final Subchannel subchannel;

        private PickResult(@Nullable Subchannel subchannel2, @Nullable ClientStreamTracer.Factory streamTracerFactory2, Status status2, boolean drop2) {
            this.subchannel = subchannel2;
            this.streamTracerFactory = streamTracerFactory2;
            this.status = (Status) Preconditions.checkNotNull(status2, NotificationCompat.CATEGORY_STATUS);
            this.drop = drop2;
        }

        public static PickResult withSubchannel(Subchannel subchannel2, @Nullable ClientStreamTracer.Factory streamTracerFactory2) {
            return new PickResult((Subchannel) Preconditions.checkNotNull(subchannel2, "subchannel"), streamTracerFactory2, Status.OK, false);
        }

        public static PickResult withSubchannel(Subchannel subchannel2) {
            return withSubchannel(subchannel2, (ClientStreamTracer.Factory) null);
        }

        public static PickResult withError(Status error) {
            Preconditions.checkArgument(!error.isOk(), "error status shouldn't be OK");
            return new PickResult((Subchannel) null, (ClientStreamTracer.Factory) null, error, false);
        }

        public static PickResult withDrop(Status status2) {
            Preconditions.checkArgument(!status2.isOk(), "drop status shouldn't be OK");
            return new PickResult((Subchannel) null, (ClientStreamTracer.Factory) null, status2, true);
        }

        public static PickResult withNoResult() {
            return NO_RESULT;
        }

        @Nullable
        public Subchannel getSubchannel() {
            return this.subchannel;
        }

        @Nullable
        public ClientStreamTracer.Factory getStreamTracerFactory() {
            return this.streamTracerFactory;
        }

        public Status getStatus() {
            return this.status;
        }

        public boolean isDrop() {
            return this.drop;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("subchannel", (Object) this.subchannel).add("streamTracerFactory", (Object) this.streamTracerFactory).add(NotificationCompat.CATEGORY_STATUS, (Object) this.status).add("drop", this.drop).toString();
        }

        public int hashCode() {
            return Objects.hashCode(this.subchannel, this.status, this.streamTracerFactory, Boolean.valueOf(this.drop));
        }

        public boolean equals(Object other) {
            if (!(other instanceof PickResult)) {
                return false;
            }
            PickResult that = (PickResult) other;
            if (!Objects.equal(this.subchannel, that.subchannel) || !Objects.equal(this.status, that.status) || !Objects.equal(this.streamTracerFactory, that.streamTracerFactory) || this.drop != that.drop) {
                return false;
            }
            return true;
        }
    }

    public static abstract class Helper {
        public abstract ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str);

        public abstract String getAuthority();

        @Deprecated
        public abstract NameResolver.Factory getNameResolverFactory();

        public abstract void updateBalancingState(@Nonnull ConnectivityState connectivityState, @Nonnull SubchannelPicker subchannelPicker);

        public final Subchannel createSubchannel(EquivalentAddressGroup addrs, Attributes attrs) {
            Preconditions.checkNotNull(addrs, "addrs");
            return createSubchannel((List<EquivalentAddressGroup>) Collections.singletonList(addrs), attrs);
        }

        public Subchannel createSubchannel(List<EquivalentAddressGroup> list, Attributes attrs) {
            throw new UnsupportedOperationException();
        }

        public final void updateSubchannelAddresses(Subchannel subchannel, EquivalentAddressGroup addrs) {
            Preconditions.checkNotNull(addrs, "addrs");
            updateSubchannelAddresses(subchannel, (List<EquivalentAddressGroup>) Collections.singletonList(addrs));
        }

        public void updateSubchannelAddresses(Subchannel subchannel, List<EquivalentAddressGroup> list) {
            throw new UnsupportedOperationException();
        }

        public void updateOobChannelAddresses(ManagedChannel channel, EquivalentAddressGroup eag) {
            throw new UnsupportedOperationException();
        }

        public ManagedChannel createResolvingOobChannel(String target) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void refreshNameResolution() {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public void runSerialized(Runnable task) {
            getSynchronizationContext().execute(task);
        }

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException();
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            throw new UnsupportedOperationException();
        }

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class Subchannel {
        public abstract Attributes getAttributes();

        public abstract void requestConnection();

        public abstract void shutdown();

        public final EquivalentAddressGroup getAddresses() {
            List<EquivalentAddressGroup> groups = getAllAddresses();
            boolean z = true;
            if (groups.size() != 1) {
                z = false;
            }
            Preconditions.checkState(z, "Does not have exactly one group");
            return groups.get(0);
        }

        public List<EquivalentAddressGroup> getAllAddresses() {
            throw new UnsupportedOperationException();
        }

        public Channel asChannel() {
            throw new UnsupportedOperationException();
        }

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }
    }
}
