package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.AtomicBackoff;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.TlsVersion;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class OkHttpChannelBuilder extends AbstractManagedChannelImplBuilder<OkHttpChannelBuilder> {
    private static final long AS_LARGE_AS_INFINITE = TimeUnit.DAYS.toNanos(1000);
    public static final int DEFAULT_FLOW_CONTROL_WINDOW = 65535;
    static final ConnectionSpec INTERNAL_DEFAULT_CONNECTION_SPEC = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384).tlsVersions(TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
    /* access modifiers changed from: private */
    public static final SharedResourceHolder.Resource<Executor> SHARED_EXECUTOR = new SharedResourceHolder.Resource<Executor>() {
        public Executor create() {
            return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-okhttp-%d", true));
        }

        public void close(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }
    };
    private ConnectionSpec connectionSpec;
    private int flowControlWindow;
    private HostnameVerifier hostnameVerifier;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    private int maxInboundMetadataSize;
    private NegotiationType negotiationType;
    private ScheduledExecutorService scheduledExecutorService;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private Executor transportExecutor;

    private enum NegotiationType {
        TLS,
        PLAINTEXT
    }

    public static OkHttpChannelBuilder forAddress(String host, int port) {
        return new OkHttpChannelBuilder(host, port);
    }

    public static OkHttpChannelBuilder forTarget(String target) {
        return new OkHttpChannelBuilder(target);
    }

    protected OkHttpChannelBuilder(String host, int port) {
        this(GrpcUtil.authorityFromHostAndPort(host, port));
    }

    private OkHttpChannelBuilder(String target) {
        super(target);
        this.connectionSpec = INTERNAL_DEFAULT_CONNECTION_SPEC;
        this.negotiationType = NegotiationType.TLS;
        this.keepAliveTimeNanos = Long.MAX_VALUE;
        this.keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
        this.flowControlWindow = 65535;
        this.maxInboundMetadataSize = Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final OkHttpChannelBuilder setTransportTracerFactory(TransportTracer.Factory transportTracerFactory) {
        this.transportTracerFactory = transportTracerFactory;
        return this;
    }

    public final OkHttpChannelBuilder transportExecutor(@Nullable Executor transportExecutor2) {
        this.transportExecutor = transportExecutor2;
        return this;
    }

    public final OkHttpChannelBuilder socketFactory(@Nullable SocketFactory socketFactory2) {
        this.socketFactory = socketFactory2;
        return this;
    }

    @Deprecated
    public final OkHttpChannelBuilder negotiationType(NegotiationType type) {
        Preconditions.checkNotNull(type, "type");
        int i = AnonymousClass2.$SwitchMap$io$grpc$okhttp$NegotiationType[type.ordinal()];
        if (i == 1) {
            this.negotiationType = NegotiationType.TLS;
        } else if (i == 2) {
            this.negotiationType = NegotiationType.PLAINTEXT;
        } else {
            throw new AssertionError("Unknown negotiation type: " + type);
        }
        return this;
    }

    @Deprecated
    public final OkHttpChannelBuilder enableKeepAlive(boolean enable) {
        if (enable) {
            return keepAliveTime(GrpcUtil.DEFAULT_KEEPALIVE_TIME_NANOS, TimeUnit.NANOSECONDS);
        }
        return keepAliveTime(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    @Deprecated
    public final OkHttpChannelBuilder enableKeepAlive(boolean enable, long keepAliveTime, TimeUnit delayUnit, long keepAliveTimeout, TimeUnit timeoutUnit) {
        if (enable) {
            return keepAliveTime(keepAliveTime, delayUnit).keepAliveTimeout(keepAliveTimeout, timeoutUnit);
        }
        return keepAliveTime(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    public OkHttpChannelBuilder keepAliveTime(long keepAliveTime, TimeUnit timeUnit) {
        Preconditions.checkArgument(keepAliveTime > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(keepAliveTime);
        this.keepAliveTimeNanos = nanos;
        long clampKeepAliveTimeInNanos = KeepAliveManager.clampKeepAliveTimeInNanos(nanos);
        this.keepAliveTimeNanos = clampKeepAliveTimeInNanos;
        if (clampKeepAliveTimeInNanos >= AS_LARGE_AS_INFINITE) {
            this.keepAliveTimeNanos = Long.MAX_VALUE;
        }
        return this;
    }

    public OkHttpChannelBuilder keepAliveTimeout(long keepAliveTimeout, TimeUnit timeUnit) {
        Preconditions.checkArgument(keepAliveTimeout > 0, "keepalive timeout must be positive");
        long nanos = timeUnit.toNanos(keepAliveTimeout);
        this.keepAliveTimeoutNanos = nanos;
        this.keepAliveTimeoutNanos = KeepAliveManager.clampKeepAliveTimeoutInNanos(nanos);
        return this;
    }

    public OkHttpChannelBuilder flowControlWindow(int flowControlWindow2) {
        Preconditions.checkState(flowControlWindow2 > 0, "flowControlWindow must be positive");
        this.flowControlWindow = flowControlWindow2;
        return this;
    }

    public OkHttpChannelBuilder keepAliveWithoutCalls(boolean enable) {
        this.keepAliveWithoutCalls = enable;
        return this;
    }

    public final OkHttpChannelBuilder sslSocketFactory(SSLSocketFactory factory) {
        this.sslSocketFactory = factory;
        this.negotiationType = NegotiationType.TLS;
        return this;
    }

    public final OkHttpChannelBuilder hostnameVerifier(@Nullable HostnameVerifier hostnameVerifier2) {
        this.hostnameVerifier = hostnameVerifier2;
        return this;
    }

    public final OkHttpChannelBuilder connectionSpec(com.squareup.okhttp.ConnectionSpec connectionSpec2) {
        Preconditions.checkArgument(connectionSpec2.isTls(), "plaintext ConnectionSpec is not accepted");
        this.connectionSpec = Utils.convertSpec(connectionSpec2);
        return this;
    }

    @Deprecated
    public final OkHttpChannelBuilder usePlaintext(boolean skipNegotiation) {
        if (skipNegotiation) {
            negotiationType(NegotiationType.PLAINTEXT);
            return this;
        }
        throw new IllegalArgumentException("Plaintext negotiation not currently supported");
    }

    public final OkHttpChannelBuilder usePlaintext() {
        this.negotiationType = NegotiationType.PLAINTEXT;
        return this;
    }

    public final OkHttpChannelBuilder useTransportSecurity() {
        this.negotiationType = NegotiationType.TLS;
        return this;
    }

    public final OkHttpChannelBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService2) {
        this.scheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService2, "scheduledExecutorService");
        return this;
    }

    public OkHttpChannelBuilder maxInboundMetadataSize(int bytes) {
        Preconditions.checkArgument(bytes > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = bytes;
        return this;
    }

    /* access modifiers changed from: protected */
    public final ClientTransportFactory buildTransportFactory() {
        OkHttpTransportFactory okHttpTransportFactory = r2;
        OkHttpTransportFactory okHttpTransportFactory2 = new OkHttpTransportFactory(this.transportExecutor, this.scheduledExecutorService, this.socketFactory, createSslSocketFactory(), this.hostnameVerifier, this.connectionSpec, maxInboundMessageSize(), this.keepAliveTimeNanos != Long.MAX_VALUE, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.flowControlWindow, this.keepAliveWithoutCalls, this.maxInboundMetadataSize, this.transportTracerFactory);
        return okHttpTransportFactory;
    }

    /* renamed from: io.grpc.okhttp.OkHttpChannelBuilder$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$okhttp$NegotiationType;
        static final /* synthetic */ int[] $SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType;

        static {
            int[] iArr = new int[NegotiationType.values().length];
            $SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType = iArr;
            try {
                iArr[NegotiationType.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType[NegotiationType.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[NegotiationType.values().length];
            $SwitchMap$io$grpc$okhttp$NegotiationType = iArr2;
            try {
                iArr2[NegotiationType.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$io$grpc$okhttp$NegotiationType[NegotiationType.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getDefaultPort() {
        int i = AnonymousClass2.$SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType[this.negotiationType.ordinal()];
        if (i == 1) {
            return 80;
        }
        if (i == 2) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        throw new AssertionError(this.negotiationType + " not handled");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public SSLSocketFactory createSslSocketFactory() {
        SSLContext sslContext;
        int i = AnonymousClass2.$SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType[this.negotiationType.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            try {
                if (this.sslSocketFactory == null) {
                    if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
                        sslContext = SSLContext.getInstance("TLS", Platform.get().getProvider());
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                        sslContext.init((KeyManager[]) null, trustManagerFactory.getTrustManagers(), SecureRandom.getInstance("SHA1PRNG", Platform.get().getProvider()));
                    } else {
                        sslContext = SSLContext.getInstance("Default", Platform.get().getProvider());
                    }
                    this.sslSocketFactory = sslContext.getSocketFactory();
                }
                return this.sslSocketFactory;
            } catch (GeneralSecurityException gse) {
                throw new RuntimeException("TLS Provider failure", gse);
            }
        } else {
            throw new RuntimeException("Unknown negotiation type: " + this.negotiationType);
        }
    }

    static final class OkHttpTransportFactory implements ClientTransportFactory {
        private boolean closed;
        private final ConnectionSpec connectionSpec;
        private final boolean enableKeepAlive;
        private final Executor executor;
        private final int flowControlWindow;
        @Nullable
        private final HostnameVerifier hostnameVerifier;
        private final AtomicBackoff keepAliveTimeNanos;
        private final long keepAliveTimeoutNanos;
        private final boolean keepAliveWithoutCalls;
        private final int maxInboundMetadataSize;
        private final int maxMessageSize;
        private final SocketFactory socketFactory;
        @Nullable
        private final SSLSocketFactory sslSocketFactory;
        private final ScheduledExecutorService timeoutService;
        private final TransportTracer.Factory transportTracerFactory;
        private final boolean usingSharedExecutor;
        private final boolean usingSharedScheduler;

        private OkHttpTransportFactory(Executor executor2, @Nullable ScheduledExecutorService timeoutService2, @Nullable SocketFactory socketFactory2, @Nullable SSLSocketFactory sslSocketFactory2, @Nullable HostnameVerifier hostnameVerifier2, ConnectionSpec connectionSpec2, int maxMessageSize2, boolean enableKeepAlive2, long keepAliveTimeNanos2, long keepAliveTimeoutNanos2, int flowControlWindow2, boolean keepAliveWithoutCalls2, int maxInboundMetadataSize2, TransportTracer.Factory transportTracerFactory2) {
            Executor executor3 = executor2;
            boolean z = false;
            boolean z2 = timeoutService2 == null;
            this.usingSharedScheduler = z2;
            this.timeoutService = z2 ? (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE) : timeoutService2;
            this.socketFactory = socketFactory2;
            this.sslSocketFactory = sslSocketFactory2;
            this.hostnameVerifier = hostnameVerifier2;
            this.connectionSpec = connectionSpec2;
            this.maxMessageSize = maxMessageSize2;
            this.enableKeepAlive = enableKeepAlive2;
            this.keepAliveTimeNanos = new AtomicBackoff("keepalive time nanos", keepAliveTimeNanos2);
            this.keepAliveTimeoutNanos = keepAliveTimeoutNanos2;
            this.flowControlWindow = flowControlWindow2;
            this.keepAliveWithoutCalls = keepAliveWithoutCalls2;
            this.maxInboundMetadataSize = maxInboundMetadataSize2;
            this.usingSharedExecutor = executor3 == null ? true : z;
            this.transportTracerFactory = (TransportTracer.Factory) Preconditions.checkNotNull(transportTracerFactory2, "transportTracerFactory");
            if (this.usingSharedExecutor) {
                this.executor = (Executor) SharedResourceHolder.get(OkHttpChannelBuilder.SHARED_EXECUTOR);
            } else {
                this.executor = executor3;
            }
        }

        public ConnectionClientTransport newClientTransport(SocketAddress addr, ClientTransportFactory.ClientTransportOptions options, ChannelLogger channelLogger) {
            if (!this.closed) {
                final AtomicBackoff.State keepAliveTimeNanosState = this.keepAliveTimeNanos.getState();
                Runnable tooManyPingsRunnable = new Runnable() {
                    public void run() {
                        keepAliveTimeNanosState.backoff();
                    }
                };
                String authority = options.getAuthority();
                String userAgent = options.getUserAgent();
                Attributes eagAttributes = options.getEagAttributes();
                Executor executor2 = this.executor;
                SocketFactory socketFactory2 = this.socketFactory;
                SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
                HostnameVerifier hostnameVerifier2 = this.hostnameVerifier;
                ConnectionSpec connectionSpec2 = this.connectionSpec;
                int i = this.maxMessageSize;
                int i2 = this.flowControlWindow;
                HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress = options.getHttpConnectProxiedSocketAddress();
                int i3 = this.maxInboundMetadataSize;
                OkHttpClientTransport transport = new OkHttpClientTransport((InetSocketAddress) addr, authority, userAgent, eagAttributes, executor2, socketFactory2, sSLSocketFactory, hostnameVerifier2, connectionSpec2, i, i2, httpConnectProxiedSocketAddress, tooManyPingsRunnable, i3, this.transportTracerFactory.create());
                if (this.enableKeepAlive) {
                    transport.enableKeepAlive(true, keepAliveTimeNanosState.get(), this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
                }
                return transport;
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            return this.timeoutService;
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                if (this.usingSharedScheduler) {
                    SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timeoutService);
                }
                if (this.usingSharedExecutor) {
                    SharedResourceHolder.release(OkHttpChannelBuilder.SHARED_EXECUTOR, this.executor);
                }
            }
        }
    }
}
