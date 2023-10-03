package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.List;

final class PickFirstLoadBalancer extends LoadBalancer {
    private final LoadBalancer.Helper helper;
    private LoadBalancer.Subchannel subchannel;

    PickFirstLoadBalancer(LoadBalancer.Helper helper2) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper2, "helper");
    }

    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        List<EquivalentAddressGroup> servers = resolvedAddresses.getAddresses();
        LoadBalancer.Subchannel subchannel2 = this.subchannel;
        if (subchannel2 == null) {
            this.subchannel = this.helper.createSubchannel(servers, Attributes.EMPTY);
            this.helper.updateBalancingState(ConnectivityState.CONNECTING, new Picker(LoadBalancer.PickResult.withSubchannel(this.subchannel)));
            this.subchannel.requestConnection();
            return;
        }
        this.helper.updateSubchannelAddresses(subchannel2, servers);
    }

    public void handleNameResolutionError(Status error) {
        LoadBalancer.Subchannel subchannel2 = this.subchannel;
        if (subchannel2 != null) {
            subchannel2.shutdown();
            this.subchannel = null;
        }
        this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new Picker(LoadBalancer.PickResult.withError(error)));
    }

    public void handleSubchannelState(LoadBalancer.Subchannel subchannel2, ConnectivityStateInfo stateInfo) {
        LoadBalancer.SubchannelPicker picker;
        ConnectivityState currentState = stateInfo.getState();
        if (subchannel2 == this.subchannel && currentState != ConnectivityState.SHUTDOWN) {
            int i = AnonymousClass1.$SwitchMap$io$grpc$ConnectivityState[currentState.ordinal()];
            if (i == 1) {
                picker = new RequestConnectionPicker(subchannel2);
            } else if (i == 2) {
                picker = new Picker(LoadBalancer.PickResult.withNoResult());
            } else if (i == 3) {
                picker = new Picker(LoadBalancer.PickResult.withSubchannel(subchannel2));
            } else if (i == 4) {
                picker = new Picker(LoadBalancer.PickResult.withError(stateInfo.getStatus()));
            } else {
                throw new IllegalArgumentException("Unsupported state:" + currentState);
            }
            this.helper.updateBalancingState(currentState, picker);
        }
    }

    /* renamed from: io.grpc.internal.PickFirstLoadBalancer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$ConnectivityState;

        static {
            int[] iArr = new int[ConnectivityState.values().length];
            $SwitchMap$io$grpc$ConnectivityState = iArr;
            try {
                iArr[ConnectivityState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void shutdown() {
        LoadBalancer.Subchannel subchannel2 = this.subchannel;
        if (subchannel2 != null) {
            subchannel2.shutdown();
        }
    }

    private static final class Picker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.PickResult result;

        Picker(LoadBalancer.PickResult result2) {
            this.result = (LoadBalancer.PickResult) Preconditions.checkNotNull(result2, "result");
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return this.result;
        }
    }

    private static final class RequestConnectionPicker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.Subchannel subchannel;

        RequestConnectionPicker(LoadBalancer.Subchannel subchannel2) {
            this.subchannel = (LoadBalancer.Subchannel) Preconditions.checkNotNull(subchannel2, "subchannel");
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            this.subchannel.requestConnection();
            return LoadBalancer.PickResult.withNoResult();
        }

        public void requestConnection() {
            this.subchannel.requestConnection();
        }
    }
}
