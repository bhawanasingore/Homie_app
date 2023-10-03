package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.ServiceConfigUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class AutoConfiguredLoadBalancerFactory extends LoadBalancer.Factory {
    private static final String GRPCLB_POLICY_NAME = "grpclb";
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(AutoConfiguredLoadBalancerFactory.class.getName());
    /* access modifiers changed from: private */
    public final String defaultPolicy;
    /* access modifiers changed from: private */
    public final LoadBalancerRegistry registry;

    public AutoConfiguredLoadBalancerFactory(String defaultPolicy2) {
        this(LoadBalancerRegistry.getDefaultRegistry(), defaultPolicy2);
    }

    AutoConfiguredLoadBalancerFactory(LoadBalancerRegistry registry2, String defaultPolicy2) {
        this.registry = (LoadBalancerRegistry) Preconditions.checkNotNull(registry2, "registry");
        this.defaultPolicy = (String) Preconditions.checkNotNull(defaultPolicy2, "defaultPolicy");
    }

    public LoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new AutoConfiguredLoadBalancer(helper);
    }

    private static final class NoopLoadBalancer extends LoadBalancer {
        private NoopLoadBalancer() {
        }

        @Deprecated
        public void handleResolvedAddressGroups(List<EquivalentAddressGroup> list, Attributes a) {
        }

        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        }

        public void handleNameResolutionError(Status error) {
        }

        public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo stateInfo) {
        }

        public void shutdown() {
        }
    }

    public final class AutoConfiguredLoadBalancer extends LoadBalancer {
        private LoadBalancer delegate;
        private LoadBalancerProvider delegateProvider;
        private final LoadBalancer.Helper helper;
        private boolean roundRobinDueToGrpclbDepMissing;

        AutoConfiguredLoadBalancer(LoadBalancer.Helper helper2) {
            this.helper = helper2;
            LoadBalancerProvider provider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(AutoConfiguredLoadBalancerFactory.this.defaultPolicy);
            this.delegateProvider = provider;
            if (provider != null) {
                this.delegate = provider.newLoadBalancer(helper2);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + AutoConfiguredLoadBalancerFactory.this.defaultPolicy + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
            List<EquivalentAddressGroup> servers = resolvedAddresses.getAddresses();
            Attributes attributes = resolvedAddresses.getAttributes();
            if (attributes.get(ATTR_LOAD_BALANCING_CONFIG) == null) {
                try {
                    PolicySelection selection = decideLoadBalancerProvider(servers, (Map) attributes.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG));
                    if (this.delegateProvider == null || !selection.provider.getPolicyName().equals(this.delegateProvider.getPolicyName())) {
                        this.helper.updateBalancingState(ConnectivityState.CONNECTING, new EmptyPicker());
                        this.delegate.shutdown();
                        LoadBalancerProvider loadBalancerProvider = selection.provider;
                        this.delegateProvider = loadBalancerProvider;
                        LoadBalancer old = this.delegate;
                        this.delegate = loadBalancerProvider.newLoadBalancer(this.helper);
                        this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.INFO, "Load balancer changed from {0} to {1}", old.getClass().getSimpleName(), this.delegate.getClass().getSimpleName());
                    }
                    if (selection.config != null) {
                        this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.DEBUG, "Load-balancing config: {0}", selection.config);
                        attributes = attributes.toBuilder().set(ATTR_LOAD_BALANCING_CONFIG, selection.config).build();
                    }
                    LoadBalancer delegate2 = getDelegate();
                    if (!selection.serverList.isEmpty() || delegate2.canHandleEmptyAddressListFromNameResolution()) {
                        delegate2.handleResolvedAddresses(LoadBalancer.ResolvedAddresses.newBuilder().setAddresses(selection.serverList).setAttributes(attributes).build());
                        return;
                    }
                    Status status = Status.UNAVAILABLE;
                    delegate2.handleNameResolutionError(status.withDescription("Name resolver returned no usable address. addrs=" + servers + ", attrs=" + attributes));
                } catch (PolicyException e) {
                    this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new FailingPicker(Status.INTERNAL.withDescription(e.getMessage())));
                    this.delegate.shutdown();
                    this.delegateProvider = null;
                    this.delegate = new NoopLoadBalancer();
                }
            } else {
                throw new IllegalArgumentException("Unexpected ATTR_LOAD_BALANCING_CONFIG from upstream: " + attributes.get(ATTR_LOAD_BALANCING_CONFIG));
            }
        }

        public void handleNameResolutionError(Status error) {
            getDelegate().handleNameResolutionError(error);
        }

        public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo stateInfo) {
            getDelegate().handleSubchannelState(subchannel, stateInfo);
        }

        public boolean canHandleEmptyAddressListFromNameResolution() {
            return true;
        }

        public void shutdown() {
            this.delegate.shutdown();
            this.delegate = null;
        }

        public LoadBalancer getDelegate() {
            return this.delegate;
        }

        /* access modifiers changed from: package-private */
        public void setDelegate(LoadBalancer lb) {
            this.delegate = lb;
        }

        /* access modifiers changed from: package-private */
        public LoadBalancerProvider getDelegateProvider() {
            return this.delegateProvider;
        }

        /* access modifiers changed from: package-private */
        public PolicySelection decideLoadBalancerProvider(List<EquivalentAddressGroup> servers, @Nullable Map<String, ?> config) throws PolicyException {
            boolean haveBalancerAddress = false;
            ArrayList arrayList = new ArrayList();
            for (EquivalentAddressGroup s : servers) {
                if (s.getAttributes().get(GrpcAttributes.ATTR_LB_ADDR_AUTHORITY) != null) {
                    haveBalancerAddress = true;
                } else {
                    arrayList.add(s);
                }
            }
            List<ServiceConfigUtil.LbConfig> lbConfigs = null;
            if (config != null) {
                lbConfigs = ServiceConfigUtil.unwrapLoadBalancingConfigList(ServiceConfigUtil.getLoadBalancingConfigsFromServiceConfig(config));
            }
            if (lbConfigs != null && !lbConfigs.isEmpty()) {
                LinkedHashSet<String> policiesTried = new LinkedHashSet<>();
                for (ServiceConfigUtil.LbConfig lbConfig : lbConfigs) {
                    String policy = lbConfig.getPolicyName();
                    LoadBalancerProvider provider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(policy);
                    if (provider == null) {
                        policiesTried.add(policy);
                    } else {
                        if (!policiesTried.isEmpty()) {
                            this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.DEBUG, "{0} specified by Service Config are not available", policiesTried);
                        }
                        return new PolicySelection(provider, policy.equals(AutoConfiguredLoadBalancerFactory.GRPCLB_POLICY_NAME) ? servers : arrayList, lbConfig.getRawConfigValue());
                    }
                }
                if (!haveBalancerAddress) {
                    throw new PolicyException("None of " + policiesTried + " specified by Service Config are available.");
                }
            }
            if (haveBalancerAddress) {
                LoadBalancerProvider grpclbProvider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(AutoConfiguredLoadBalancerFactory.GRPCLB_POLICY_NAME);
                if (grpclbProvider != null) {
                    return new PolicySelection(grpclbProvider, servers, (Map<String, ?>) null);
                }
                if (!arrayList.isEmpty()) {
                    if (!this.roundRobinDueToGrpclbDepMissing) {
                        this.roundRobinDueToGrpclbDepMissing = true;
                        this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.ERROR, "Found balancer addresses but grpclb runtime is missing. Will use round_robin. Please include grpc-grpclb in your runtime depedencies.");
                        AutoConfiguredLoadBalancerFactory.logger.warning("Found balancer addresses but grpclb runtime is missing. Will use round_robin. Please include grpc-grpclb in your runtime depedencies.");
                    }
                    return new PolicySelection(AutoConfiguredLoadBalancerFactory.this.getProviderOrThrow("round_robin", "received balancer addresses but grpclb runtime is missing"), arrayList, (Map<String, ?>) null);
                }
                throw new PolicyException("Received ONLY balancer addresses but grpclb runtime is missing");
            }
            this.roundRobinDueToGrpclbDepMissing = false;
            AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory = AutoConfiguredLoadBalancerFactory.this;
            return new PolicySelection(autoConfiguredLoadBalancerFactory.getProviderOrThrow(autoConfiguredLoadBalancerFactory.defaultPolicy, "using default policy"), servers, (Map<String, ?>) null);
        }
    }

    /* access modifiers changed from: private */
    public LoadBalancerProvider getProviderOrThrow(String policy, String choiceReason) throws PolicyException {
        LoadBalancerProvider provider = this.registry.getProvider(policy);
        if (provider != null) {
            return provider;
        }
        throw new PolicyException("Trying to load '" + policy + "' because " + choiceReason + ", but it's unavailable");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public NameResolver.ConfigOrError selectLoadBalancerPolicy(Map<String, ?> serviceConfig) {
        List<ServiceConfigUtil.LbConfig> loadBalancerConfigs = null;
        if (serviceConfig != null) {
            try {
                loadBalancerConfigs = ServiceConfigUtil.unwrapLoadBalancingConfigList(ServiceConfigUtil.getLoadBalancingConfigsFromServiceConfig(serviceConfig));
            } catch (RuntimeException e) {
                return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("can't parse load balancer configuration").withCause(e));
            }
        }
        if (loadBalancerConfigs == null || loadBalancerConfigs.isEmpty()) {
            return null;
        }
        List<String> policiesTried = new ArrayList<>();
        for (ServiceConfigUtil.LbConfig lbConfig : loadBalancerConfigs) {
            String policy = lbConfig.getPolicyName();
            LoadBalancerProvider provider = this.registry.getProvider(policy);
            if (provider != null) {
                return NameResolver.ConfigOrError.fromConfig(new PolicySelection(provider, (List<EquivalentAddressGroup>) null, lbConfig.getRawConfigValue()));
            }
            policiesTried.add(policy);
        }
        Status status = Status.UNKNOWN;
        return NameResolver.ConfigOrError.fromError(status.withDescription("None of " + policiesTried + " specified by Service Config are available."));
    }

    static final class PolicyException extends Exception {
        private static final long serialVersionUID = 1;

        private PolicyException(String msg) {
            super(msg);
        }
    }

    static final class PolicySelection {
        @Nullable
        final Map<String, ?> config;
        final LoadBalancerProvider provider;
        @Nullable
        final List<EquivalentAddressGroup> serverList;

        PolicySelection(LoadBalancerProvider provider2, List<EquivalentAddressGroup> serverList2, @Nullable Map<String, ?> config2) {
            this.provider = (LoadBalancerProvider) Preconditions.checkNotNull(provider2, "provider");
            this.serverList = Collections.unmodifiableList((List) Preconditions.checkNotNull(serverList2, "serverList"));
            this.config = config2;
        }

        PolicySelection(LoadBalancerProvider provider2, @Nullable Map<String, ?> config2) {
            this.provider = (LoadBalancerProvider) Preconditions.checkNotNull(provider2, "provider");
            this.serverList = null;
            this.config = config2;
        }
    }

    private static final class EmptyPicker extends LoadBalancer.SubchannelPicker {
        private EmptyPicker() {
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return LoadBalancer.PickResult.withNoResult();
        }
    }

    private static final class FailingPicker extends LoadBalancer.SubchannelPicker {
        private final Status failure;

        FailingPicker(Status failure2) {
            this.failure = failure2;
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return LoadBalancer.PickResult.withError(this.failure);
        }
    }
}
