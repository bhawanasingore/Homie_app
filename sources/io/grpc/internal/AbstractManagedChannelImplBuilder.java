package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverRegistry;
import io.grpc.ProxyDetector;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ExponentialBackoffPolicy;
import io.grpc.internal.TransportTracer;
import io.opencensus.trace.Tracing;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class AbstractManagedChannelImplBuilder<T extends AbstractManagedChannelImplBuilder<T>> extends ManagedChannelBuilder<T> {
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final NameResolver.Factory DEFAULT_NAME_RESOLVER_FACTORY = NameResolverRegistry.getDefaultRegistry().asFactory();
    private static final long DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES = 1048576;
    private static final long DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES = 16777216;
    private static final String DIRECT_ADDRESS_SCHEME = "directaddress";
    static final long IDLE_MODE_DEFAULT_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(IDLE_MODE_MAX_TIMEOUT_DAYS);
    static final long IDLE_MODE_MAX_TIMEOUT_DAYS = 30;
    static final long IDLE_MODE_MIN_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(1);
    @Nullable
    String authorityOverride;
    @Nullable
    BinaryLog binlog;
    @Nullable
    private CensusStatsModule censusStatsOverride;
    InternalChannelz channelz = InternalChannelz.instance();
    CompressorRegistry compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
    DecompressorRegistry decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
    String defaultLbPolicy = GrpcUtil.DEFAULT_LB_POLICY;
    @Nullable
    Map<String, ?> defaultServiceConfig;
    @Nullable
    private final SocketAddress directServerAddress;
    ObjectPool<? extends Executor> executorPool = DEFAULT_EXECUTOR_POOL;
    boolean fullStreamDecompression;
    long idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
    private final List<ClientInterceptor> interceptors = new ArrayList();
    boolean lookUpServiceConfig = true;
    int maxHedgedAttempts = 5;
    private int maxInboundMessageSize = 4194304;
    int maxRetryAttempts = 5;
    int maxTraceEvents;
    private NameResolver.Factory nameResolverFactory = DEFAULT_NAME_RESOLVER_FACTORY;
    long perRpcBufferLimit = DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES;
    @Nullable
    ProxyDetector proxyDetector;
    private boolean recordFinishedRpcs = true;
    private boolean recordRealTimeMetrics = false;
    private boolean recordStartedRpcs = true;
    long retryBufferSize = DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES;
    boolean retryEnabled = false;
    private boolean statsEnabled = true;
    final String target;
    boolean temporarilyDisableRetry;
    private boolean tracingEnabled = true;
    protected TransportTracer.Factory transportTracerFactory = TransportTracer.getDefaultFactory();
    @Nullable
    String userAgent;

    /* access modifiers changed from: protected */
    public abstract ClientTransportFactory buildTransportFactory();

    public static ManagedChannelBuilder<?> forAddress(String name, int port) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    public static ManagedChannelBuilder<?> forTarget(String target2) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    public T maxInboundMessageSize(int max) {
        Preconditions.checkArgument(max >= 0, "negative max");
        this.maxInboundMessageSize = max;
        return thisT();
    }

    /* access modifiers changed from: protected */
    public final int maxInboundMessageSize() {
        return this.maxInboundMessageSize;
    }

    protected AbstractManagedChannelImplBuilder(String target2) {
        this.target = (String) Preconditions.checkNotNull(target2, "target");
        this.directServerAddress = null;
    }

    static String makeTargetStringForDirectAddress(SocketAddress address) {
        try {
            return new URI(DIRECT_ADDRESS_SCHEME, "", "/" + address, (String) null).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    protected AbstractManagedChannelImplBuilder(SocketAddress directServerAddress2, String authority) {
        this.target = makeTargetStringForDirectAddress(directServerAddress2);
        this.directServerAddress = directServerAddress2;
        this.nameResolverFactory = new DirectAddressNameResolverFactory(directServerAddress2, authority);
    }

    public final T directExecutor() {
        return executor(MoreExecutors.directExecutor());
    }

    public final T executor(Executor executor) {
        if (executor != null) {
            this.executorPool = new FixedObjectPool(executor);
        } else {
            this.executorPool = DEFAULT_EXECUTOR_POOL;
        }
        return thisT();
    }

    public final T intercept(List<ClientInterceptor> interceptors2) {
        this.interceptors.addAll(interceptors2);
        return thisT();
    }

    public final T intercept(ClientInterceptor... interceptors2) {
        return intercept(Arrays.asList(interceptors2));
    }

    public final T nameResolverFactory(NameResolver.Factory resolverFactory) {
        Preconditions.checkState(this.directServerAddress == null, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", (Object) this.directServerAddress);
        if (resolverFactory != null) {
            this.nameResolverFactory = resolverFactory;
        } else {
            this.nameResolverFactory = DEFAULT_NAME_RESOLVER_FACTORY;
        }
        return thisT();
    }

    public final T defaultLoadBalancingPolicy(String policy) {
        boolean z = true;
        Preconditions.checkState(this.directServerAddress == null, "directServerAddress is set (%s), which forbids the use of load-balancing policy", (Object) this.directServerAddress);
        if (policy == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "policy cannot be null");
        this.defaultLbPolicy = policy;
        return thisT();
    }

    public final T enableFullStreamDecompression() {
        this.fullStreamDecompression = true;
        return thisT();
    }

    public final T decompressorRegistry(DecompressorRegistry registry) {
        if (registry != null) {
            this.decompressorRegistry = registry;
        } else {
            this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        }
        return thisT();
    }

    public final T compressorRegistry(CompressorRegistry registry) {
        if (registry != null) {
            this.compressorRegistry = registry;
        } else {
            this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        }
        return thisT();
    }

    public final T userAgent(@Nullable String userAgent2) {
        this.userAgent = userAgent2;
        return thisT();
    }

    public final T overrideAuthority(String authority) {
        this.authorityOverride = checkAuthority(authority);
        return thisT();
    }

    public final T idleTimeout(long value, TimeUnit unit) {
        Preconditions.checkArgument(value > 0, "idle timeout is %s, but must be positive", value);
        if (unit.toDays(value) >= IDLE_MODE_MAX_TIMEOUT_DAYS) {
            this.idleTimeoutMillis = -1;
        } else {
            this.idleTimeoutMillis = Math.max(unit.toMillis(value), IDLE_MODE_MIN_TIMEOUT_MILLIS);
        }
        return thisT();
    }

    public final T maxRetryAttempts(int maxRetryAttempts2) {
        this.maxRetryAttempts = maxRetryAttempts2;
        return thisT();
    }

    public final T maxHedgedAttempts(int maxHedgedAttempts2) {
        this.maxHedgedAttempts = maxHedgedAttempts2;
        return thisT();
    }

    public final T retryBufferSize(long bytes) {
        Preconditions.checkArgument(bytes > 0, "retry buffer size must be positive");
        this.retryBufferSize = bytes;
        return thisT();
    }

    public final T perRpcBufferLimit(long bytes) {
        Preconditions.checkArgument(bytes > 0, "per RPC buffer limit must be positive");
        this.perRpcBufferLimit = bytes;
        return thisT();
    }

    public final T disableRetry() {
        this.retryEnabled = false;
        return thisT();
    }

    public final T enableRetry() {
        this.retryEnabled = true;
        this.statsEnabled = false;
        this.tracingEnabled = false;
        return thisT();
    }

    public final T setBinaryLog(BinaryLog binlog2) {
        this.binlog = binlog2;
        return thisT();
    }

    public T maxTraceEvents(int maxTraceEvents2) {
        Preconditions.checkArgument(maxTraceEvents2 >= 0, "maxTraceEvents must be non-negative");
        this.maxTraceEvents = maxTraceEvents2;
        return thisT();
    }

    /* access modifiers changed from: protected */
    public final T overrideCensusStatsModule(CensusStatsModule censusStats) {
        this.censusStatsOverride = censusStats;
        return thisT();
    }

    public T proxyDetector(@Nullable ProxyDetector proxyDetector2) {
        this.proxyDetector = proxyDetector2;
        return thisT();
    }

    public T defaultServiceConfig(@Nullable Map<String, ?> serviceConfig) {
        this.defaultServiceConfig = checkMapEntryTypes(serviceConfig);
        return thisT();
    }

    @Nullable
    private static Map<String, ?> checkMapEntryTypes(@Nullable Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        Map<String, Object> parsedMap = new LinkedHashMap<>();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Preconditions.checkArgument(entry.getKey() instanceof String, "The key of the entry '%s' is not of String type", (Object) entry);
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                parsedMap.put(key, (Object) null);
            } else if (value instanceof Map) {
                parsedMap.put(key, checkMapEntryTypes((Map) value));
            } else if (value instanceof List) {
                parsedMap.put(key, checkListEntryTypes((List) value));
            } else if (value instanceof String) {
                parsedMap.put(key, value);
            } else if (value instanceof Double) {
                parsedMap.put(key, value);
            } else if (value instanceof Boolean) {
                parsedMap.put(key, value);
            } else {
                throw new IllegalArgumentException("The value of the map entry '" + entry + "' is of type '" + value.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableMap(parsedMap);
    }

    private static List<?> checkListEntryTypes(List<?> list) {
        List<Object> parsedList = new ArrayList<>(list.size());
        for (Object value : list) {
            if (value == null) {
                parsedList.add((Object) null);
            } else if (value instanceof Map) {
                parsedList.add(checkMapEntryTypes((Map) value));
            } else if (value instanceof List) {
                parsedList.add(checkListEntryTypes((List) value));
            } else if (value instanceof String) {
                parsedList.add(value);
            } else if (value instanceof Double) {
                parsedList.add(value);
            } else if (value instanceof Boolean) {
                parsedList.add(value);
            } else {
                throw new IllegalArgumentException("The entry '" + value + "' is of type '" + value.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableList(parsedList);
    }

    public T disableServiceConfigLookUp() {
        this.lookUpServiceConfig = false;
        return thisT();
    }

    /* access modifiers changed from: protected */
    public void setStatsEnabled(boolean value) {
        this.statsEnabled = value;
    }

    /* access modifiers changed from: protected */
    public void setStatsRecordStartedRpcs(boolean value) {
        this.recordStartedRpcs = value;
    }

    /* access modifiers changed from: protected */
    public void setStatsRecordFinishedRpcs(boolean value) {
        this.recordFinishedRpcs = value;
    }

    /* access modifiers changed from: protected */
    public void setStatsRecordRealTimeMetrics(boolean value) {
        this.recordRealTimeMetrics = value;
    }

    /* access modifiers changed from: protected */
    public void setTracingEnabled(boolean value) {
        this.tracingEnabled = value;
    }

    /* access modifiers changed from: package-private */
    public final long getIdleTimeoutMillis() {
        return this.idleTimeoutMillis;
    }

    /* access modifiers changed from: protected */
    public String checkAuthority(String authority) {
        return GrpcUtil.checkAuthority(authority);
    }

    public ManagedChannel build() {
        return new ManagedChannelOrphanWrapper(new ManagedChannelImpl(this, buildTransportFactory(), new ExponentialBackoffPolicy.Provider(), SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR), GrpcUtil.STOPWATCH_SUPPLIER, getEffectiveInterceptors(), TimeProvider.SYSTEM_TIME_PROVIDER));
    }

    /* access modifiers changed from: package-private */
    public final List<ClientInterceptor> getEffectiveInterceptors() {
        List<ClientInterceptor> effectiveInterceptors = new ArrayList<>(this.interceptors);
        this.temporarilyDisableRetry = false;
        if (this.statsEnabled) {
            this.temporarilyDisableRetry = true;
            CensusStatsModule censusStats = this.censusStatsOverride;
            if (censusStats == null) {
                censusStats = new CensusStatsModule(GrpcUtil.STOPWATCH_SUPPLIER, true, this.recordStartedRpcs, this.recordFinishedRpcs, this.recordRealTimeMetrics);
            }
            effectiveInterceptors.add(0, censusStats.getClientInterceptor());
        }
        if (this.tracingEnabled) {
            this.temporarilyDisableRetry = true;
            effectiveInterceptors.add(0, new CensusTracingModule(Tracing.getTracer(), Tracing.getPropagationComponent().getBinaryFormat()).getClientInterceptor());
        }
        return effectiveInterceptors;
    }

    /* access modifiers changed from: protected */
    public int getDefaultPort() {
        return GrpcUtil.DEFAULT_PORT_SSL;
    }

    /* access modifiers changed from: package-private */
    public NameResolver.Factory getNameResolverFactory() {
        String str = this.authorityOverride;
        if (str == null) {
            return this.nameResolverFactory;
        }
        return new OverrideAuthorityNameResolverFactory(this.nameResolverFactory, str);
    }

    private static class DirectAddressNameResolverFactory extends NameResolver.Factory {
        final SocketAddress address;
        final String authority;

        DirectAddressNameResolverFactory(SocketAddress address2, String authority2) {
            this.address = address2;
            this.authority = authority2;
        }

        public NameResolver newNameResolver(URI notUsedUri, NameResolver.Args args) {
            return new NameResolver() {
                public String getServiceAuthority() {
                    return DirectAddressNameResolverFactory.this.authority;
                }

                public void start(NameResolver.Listener2 listener) {
                    listener.onResult(NameResolver.ResolutionResult.newBuilder().setAddresses(Collections.singletonList(new EquivalentAddressGroup(DirectAddressNameResolverFactory.this.address))).setAttributes(Attributes.EMPTY).build());
                }

                public void shutdown() {
                }
            };
        }

        public String getDefaultScheme() {
            return AbstractManagedChannelImplBuilder.DIRECT_ADDRESS_SCHEME;
        }
    }

    private T thisT() {
        return this;
    }
}
