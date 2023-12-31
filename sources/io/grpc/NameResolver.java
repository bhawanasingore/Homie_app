package io.grpc;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class NameResolver {

    public interface Listener {
        void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes);

        void onError(Status status);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResolutionResultAttr {
    }

    public static abstract class ServiceConfigParser {
        public abstract ConfigOrError parseServiceConfig(Map<String, ?> map);
    }

    public abstract String getServiceAuthority();

    public abstract void shutdown();

    public void start(final Listener listener) {
        if (listener instanceof Listener2) {
            start((Listener2) listener);
        } else {
            start((Listener2) new Listener2() {
                public void onError(Status error) {
                    listener.onError(error);
                }

                public void onResult(ResolutionResult resolutionResult) {
                    listener.onAddresses(resolutionResult.getAddresses(), resolutionResult.getAttributes());
                }
            });
        }
    }

    public void start(Listener2 listener) {
        start((Listener) listener);
    }

    public void refresh() {
    }

    public static abstract class Factory {
        @Deprecated
        public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = Attributes.Key.create("params-default-port");
        @Deprecated
        private static final Attributes.Key<ServiceConfigParser> PARAMS_PARSER = Attributes.Key.create("params-parser");
        @Deprecated
        public static final Attributes.Key<ProxyDetector> PARAMS_PROXY_DETECTOR = Attributes.Key.create("params-proxy-detector");
        @Deprecated
        private static final Attributes.Key<SynchronizationContext> PARAMS_SYNC_CONTEXT = Attributes.Key.create("params-sync-context");

        public abstract String getDefaultScheme();

        @Deprecated
        @Nullable
        public NameResolver newNameResolver(URI targetUri, Attributes params) {
            return newNameResolver(targetUri, Args.newBuilder().setDefaultPort(((Integer) params.get(PARAMS_DEFAULT_PORT)).intValue()).setProxyDetector((ProxyDetector) params.get(PARAMS_PROXY_DETECTOR)).setSynchronizationContext((SynchronizationContext) params.get(PARAMS_SYNC_CONTEXT)).setServiceConfigParser((ServiceConfigParser) params.get(PARAMS_PARSER)).build());
        }

        @Deprecated
        @Nullable
        public NameResolver newNameResolver(URI targetUri, final Helper helper) {
            return newNameResolver(targetUri, Attributes.newBuilder().set(PARAMS_DEFAULT_PORT, Integer.valueOf(helper.getDefaultPort())).set(PARAMS_PROXY_DETECTOR, helper.getProxyDetector()).set(PARAMS_SYNC_CONTEXT, helper.getSynchronizationContext()).set(PARAMS_PARSER, new ServiceConfigParser() {
                public ConfigOrError parseServiceConfig(Map<String, ?> rawServiceConfig) {
                    return helper.parseServiceConfig(rawServiceConfig);
                }
            }).build());
        }

        public NameResolver newNameResolver(URI targetUri, final Args args) {
            return newNameResolver(targetUri, (Helper) new Helper() {
                public int getDefaultPort() {
                    return args.getDefaultPort();
                }

                public ProxyDetector getProxyDetector() {
                    return args.getProxyDetector();
                }

                public SynchronizationContext getSynchronizationContext() {
                    return args.getSynchronizationContext();
                }

                public ConfigOrError parseServiceConfig(Map<String, ?> rawServiceConfig) {
                    return args.getServiceConfigParser().parseServiceConfig(rawServiceConfig);
                }
            });
        }
    }

    public static abstract class Listener2 implements Listener {
        public abstract void onError(Status status);

        public abstract void onResult(ResolutionResult resolutionResult);

        @Deprecated
        public final void onAddresses(List<EquivalentAddressGroup> servers, Attributes attributes) {
            onResult(ResolutionResult.newBuilder().setAddresses(servers).setAttributes(attributes).build());
        }
    }

    @Deprecated
    public static abstract class Helper {
        public abstract int getDefaultPort();

        public abstract ProxyDetector getProxyDetector();

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public ConfigOrError parseServiceConfig(Map<String, ?> map) {
            throw new UnsupportedOperationException("should have been implemented");
        }
    }

    public static final class Args {
        private final int defaultPort;
        private final ProxyDetector proxyDetector;
        private final ServiceConfigParser serviceConfigParser;
        private final SynchronizationContext syncContext;

        Args(Integer defaultPort2, ProxyDetector proxyDetector2, SynchronizationContext syncContext2, ServiceConfigParser serviceConfigParser2) {
            this.defaultPort = ((Integer) Preconditions.checkNotNull(defaultPort2, "defaultPort not set")).intValue();
            this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector2, "proxyDetector not set");
            this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(syncContext2, "syncContext not set");
            this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser2, "serviceConfigParser not set");
        }

        public int getDefaultPort() {
            return this.defaultPort;
        }

        public ProxyDetector getProxyDetector() {
            return this.proxyDetector;
        }

        public SynchronizationContext getSynchronizationContext() {
            return this.syncContext;
        }

        public ServiceConfigParser getServiceConfigParser() {
            return this.serviceConfigParser;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("defaultPort", this.defaultPort).add("proxyDetector", (Object) this.proxyDetector).add("syncContext", (Object) this.syncContext).add("serviceConfigParser", (Object) this.serviceConfigParser).toString();
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setDefaultPort(this.defaultPort);
            builder.setProxyDetector(this.proxyDetector);
            builder.setSynchronizationContext(this.syncContext);
            builder.setServiceConfigParser(this.serviceConfigParser);
            return builder;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static final class Builder {
            private Integer defaultPort;
            private ProxyDetector proxyDetector;
            private ServiceConfigParser serviceConfigParser;
            private SynchronizationContext syncContext;

            Builder() {
            }

            public Builder setDefaultPort(int defaultPort2) {
                this.defaultPort = Integer.valueOf(defaultPort2);
                return this;
            }

            public Builder setProxyDetector(ProxyDetector proxyDetector2) {
                this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector2);
                return this;
            }

            public Builder setSynchronizationContext(SynchronizationContext syncContext2) {
                this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(syncContext2);
                return this;
            }

            public Builder setServiceConfigParser(ServiceConfigParser parser) {
                this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(parser);
                return this;
            }

            public Args build() {
                return new Args(this.defaultPort, this.proxyDetector, this.syncContext, this.serviceConfigParser);
            }
        }
    }

    public static final class ResolutionResult {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;
        @Nullable
        private final ConfigOrError serviceConfig;

        ResolutionResult(List<EquivalentAddressGroup> addresses2, Attributes attributes2, ConfigOrError serviceConfig2) {
            this.addresses = Collections.unmodifiableList(new ArrayList(addresses2));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes2, "attributes");
            this.serviceConfig = serviceConfig2;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setServiceConfig(this.serviceConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public ConfigOrError getServiceConfig() {
            return this.serviceConfig;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("addresses", (Object) this.addresses).add("attributes", (Object) this.attributes).add("serviceConfig", (Object) this.serviceConfig).toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResolutionResult)) {
                return false;
            }
            ResolutionResult that = (ResolutionResult) obj;
            if (!Objects.equal(this.addresses, that.addresses) || !Objects.equal(this.attributes, that.attributes) || !Objects.equal(this.serviceConfig, that.serviceConfig)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.addresses, this.attributes, this.serviceConfig);
        }

        public static final class Builder {
            private List<EquivalentAddressGroup> addresses = Collections.emptyList();
            private Attributes attributes = Attributes.EMPTY;
            @Nullable
            private ConfigOrError serviceConfig;

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

            public Builder setServiceConfig(@Nullable ConfigOrError serviceConfig2) {
                this.serviceConfig = serviceConfig2;
                return this;
            }

            public ResolutionResult build() {
                return new ResolutionResult(this.addresses, this.attributes, this.serviceConfig);
            }
        }
    }

    public static final class ConfigOrError {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Object config;
        private final Status status;

        static {
            Class<NameResolver> cls = NameResolver.class;
        }

        public static ConfigOrError fromConfig(Object config2) {
            return new ConfigOrError(config2);
        }

        public static ConfigOrError fromError(Status status2) {
            return new ConfigOrError(status2);
        }

        private ConfigOrError(Object config2) {
            this.config = Preconditions.checkNotNull(config2, "config");
            this.status = null;
        }

        private ConfigOrError(Status status2) {
            this.config = null;
            this.status = (Status) Preconditions.checkNotNull(status2, NotificationCompat.CATEGORY_STATUS);
            Preconditions.checkArgument(!status2.isOk(), "cannot use OK status: %s", (Object) status2);
        }

        @Nullable
        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public Status getError() {
            return this.status;
        }

        public String toString() {
            if (this.config != null) {
                return MoreObjects.toStringHelper((Object) this).add("config", this.config).toString();
            }
            return MoreObjects.toStringHelper((Object) this).add("error", (Object) this.status).toString();
        }
    }
}
