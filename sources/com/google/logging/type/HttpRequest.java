package com.google.logging.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class HttpRequest extends GeneratedMessageLite<HttpRequest, Builder> implements HttpRequestOrBuilder {
    public static final int CACHE_FILL_BYTES_FIELD_NUMBER = 12;
    public static final int CACHE_HIT_FIELD_NUMBER = 9;
    public static final int CACHE_LOOKUP_FIELD_NUMBER = 11;
    public static final int CACHE_VALIDATED_WITH_ORIGIN_SERVER_FIELD_NUMBER = 10;
    /* access modifiers changed from: private */
    public static final HttpRequest DEFAULT_INSTANCE;
    public static final int LATENCY_FIELD_NUMBER = 14;
    private static volatile Parser<HttpRequest> PARSER = null;
    public static final int PROTOCOL_FIELD_NUMBER = 15;
    public static final int REFERER_FIELD_NUMBER = 8;
    public static final int REMOTE_IP_FIELD_NUMBER = 7;
    public static final int REQUEST_METHOD_FIELD_NUMBER = 1;
    public static final int REQUEST_SIZE_FIELD_NUMBER = 3;
    public static final int REQUEST_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_SIZE_FIELD_NUMBER = 5;
    public static final int SERVER_IP_FIELD_NUMBER = 13;
    public static final int STATUS_FIELD_NUMBER = 4;
    public static final int USER_AGENT_FIELD_NUMBER = 6;
    private long cacheFillBytes_;
    private boolean cacheHit_;
    private boolean cacheLookup_;
    private boolean cacheValidatedWithOriginServer_;
    private Duration latency_;
    private String protocol_ = "";
    private String referer_ = "";
    private String remoteIp_ = "";
    private String requestMethod_ = "";
    private long requestSize_;
    private String requestUrl_ = "";
    private long responseSize_;
    private String serverIp_ = "";
    private int status_;
    private String userAgent_ = "";

    private HttpRequest() {
    }

    public String getRequestMethod() {
        return this.requestMethod_;
    }

    public ByteString getRequestMethodBytes() {
        return ByteString.copyFromUtf8(this.requestMethod_);
    }

    /* access modifiers changed from: private */
    public void setRequestMethod(String value) {
        if (value != null) {
            this.requestMethod_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearRequestMethod() {
        this.requestMethod_ = getDefaultInstance().getRequestMethod();
    }

    /* access modifiers changed from: private */
    public void setRequestMethodBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.requestMethod_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getRequestUrl() {
        return this.requestUrl_;
    }

    public ByteString getRequestUrlBytes() {
        return ByteString.copyFromUtf8(this.requestUrl_);
    }

    /* access modifiers changed from: private */
    public void setRequestUrl(String value) {
        if (value != null) {
            this.requestUrl_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearRequestUrl() {
        this.requestUrl_ = getDefaultInstance().getRequestUrl();
    }

    /* access modifiers changed from: private */
    public void setRequestUrlBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.requestUrl_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public long getRequestSize() {
        return this.requestSize_;
    }

    /* access modifiers changed from: private */
    public void setRequestSize(long value) {
        this.requestSize_ = value;
    }

    /* access modifiers changed from: private */
    public void clearRequestSize() {
        this.requestSize_ = 0;
    }

    public int getStatus() {
        return this.status_;
    }

    /* access modifiers changed from: private */
    public void setStatus(int value) {
        this.status_ = value;
    }

    /* access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    public long getResponseSize() {
        return this.responseSize_;
    }

    /* access modifiers changed from: private */
    public void setResponseSize(long value) {
        this.responseSize_ = value;
    }

    /* access modifiers changed from: private */
    public void clearResponseSize() {
        this.responseSize_ = 0;
    }

    public String getUserAgent() {
        return this.userAgent_;
    }

    public ByteString getUserAgentBytes() {
        return ByteString.copyFromUtf8(this.userAgent_);
    }

    /* access modifiers changed from: private */
    public void setUserAgent(String value) {
        if (value != null) {
            this.userAgent_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearUserAgent() {
        this.userAgent_ = getDefaultInstance().getUserAgent();
    }

    /* access modifiers changed from: private */
    public void setUserAgentBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.userAgent_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getRemoteIp() {
        return this.remoteIp_;
    }

    public ByteString getRemoteIpBytes() {
        return ByteString.copyFromUtf8(this.remoteIp_);
    }

    /* access modifiers changed from: private */
    public void setRemoteIp(String value) {
        if (value != null) {
            this.remoteIp_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearRemoteIp() {
        this.remoteIp_ = getDefaultInstance().getRemoteIp();
    }

    /* access modifiers changed from: private */
    public void setRemoteIpBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.remoteIp_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getServerIp() {
        return this.serverIp_;
    }

    public ByteString getServerIpBytes() {
        return ByteString.copyFromUtf8(this.serverIp_);
    }

    /* access modifiers changed from: private */
    public void setServerIp(String value) {
        if (value != null) {
            this.serverIp_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearServerIp() {
        this.serverIp_ = getDefaultInstance().getServerIp();
    }

    /* access modifiers changed from: private */
    public void setServerIpBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.serverIp_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getReferer() {
        return this.referer_;
    }

    public ByteString getRefererBytes() {
        return ByteString.copyFromUtf8(this.referer_);
    }

    /* access modifiers changed from: private */
    public void setReferer(String value) {
        if (value != null) {
            this.referer_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearReferer() {
        this.referer_ = getDefaultInstance().getReferer();
    }

    /* access modifiers changed from: private */
    public void setRefererBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.referer_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public boolean hasLatency() {
        return this.latency_ != null;
    }

    public Duration getLatency() {
        Duration duration = this.latency_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    /* access modifiers changed from: private */
    public void setLatency(Duration value) {
        if (value != null) {
            this.latency_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLatency(Duration.Builder builderForValue) {
        this.latency_ = (Duration) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeLatency(Duration value) {
        Duration duration = this.latency_;
        if (duration == null || duration == Duration.getDefaultInstance()) {
            this.latency_ = value;
        } else {
            this.latency_ = (Duration) ((Duration.Builder) Duration.newBuilder(this.latency_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLatency() {
        this.latency_ = null;
    }

    public boolean getCacheLookup() {
        return this.cacheLookup_;
    }

    /* access modifiers changed from: private */
    public void setCacheLookup(boolean value) {
        this.cacheLookup_ = value;
    }

    /* access modifiers changed from: private */
    public void clearCacheLookup() {
        this.cacheLookup_ = false;
    }

    public boolean getCacheHit() {
        return this.cacheHit_;
    }

    /* access modifiers changed from: private */
    public void setCacheHit(boolean value) {
        this.cacheHit_ = value;
    }

    /* access modifiers changed from: private */
    public void clearCacheHit() {
        this.cacheHit_ = false;
    }

    public boolean getCacheValidatedWithOriginServer() {
        return this.cacheValidatedWithOriginServer_;
    }

    /* access modifiers changed from: private */
    public void setCacheValidatedWithOriginServer(boolean value) {
        this.cacheValidatedWithOriginServer_ = value;
    }

    /* access modifiers changed from: private */
    public void clearCacheValidatedWithOriginServer() {
        this.cacheValidatedWithOriginServer_ = false;
    }

    public long getCacheFillBytes() {
        return this.cacheFillBytes_;
    }

    /* access modifiers changed from: private */
    public void setCacheFillBytes(long value) {
        this.cacheFillBytes_ = value;
    }

    /* access modifiers changed from: private */
    public void clearCacheFillBytes() {
        this.cacheFillBytes_ = 0;
    }

    public String getProtocol() {
        return this.protocol_;
    }

    public ByteString getProtocolBytes() {
        return ByteString.copyFromUtf8(this.protocol_);
    }

    /* access modifiers changed from: private */
    public void setProtocol(String value) {
        if (value != null) {
            this.protocol_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearProtocol() {
        this.protocol_ = getDefaultInstance().getProtocol();
    }

    /* access modifiers changed from: private */
    public void setProtocolBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.protocol_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.requestMethod_.isEmpty()) {
            output.writeString(1, getRequestMethod());
        }
        if (!this.requestUrl_.isEmpty()) {
            output.writeString(2, getRequestUrl());
        }
        long j = this.requestSize_;
        if (j != 0) {
            output.writeInt64(3, j);
        }
        int i = this.status_;
        if (i != 0) {
            output.writeInt32(4, i);
        }
        long j2 = this.responseSize_;
        if (j2 != 0) {
            output.writeInt64(5, j2);
        }
        if (!this.userAgent_.isEmpty()) {
            output.writeString(6, getUserAgent());
        }
        if (!this.remoteIp_.isEmpty()) {
            output.writeString(7, getRemoteIp());
        }
        if (!this.referer_.isEmpty()) {
            output.writeString(8, getReferer());
        }
        boolean z = this.cacheHit_;
        if (z) {
            output.writeBool(9, z);
        }
        boolean z2 = this.cacheValidatedWithOriginServer_;
        if (z2) {
            output.writeBool(10, z2);
        }
        boolean z3 = this.cacheLookup_;
        if (z3) {
            output.writeBool(11, z3);
        }
        long j3 = this.cacheFillBytes_;
        if (j3 != 0) {
            output.writeInt64(12, j3);
        }
        if (!this.serverIp_.isEmpty()) {
            output.writeString(13, getServerIp());
        }
        if (this.latency_ != null) {
            output.writeMessage(14, getLatency());
        }
        if (!this.protocol_.isEmpty()) {
            output.writeString(15, getProtocol());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.requestMethod_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getRequestMethod());
        }
        if (!this.requestUrl_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getRequestUrl());
        }
        long j = this.requestSize_;
        if (j != 0) {
            size2 += CodedOutputStream.computeInt64Size(3, j);
        }
        int i = this.status_;
        if (i != 0) {
            size2 += CodedOutputStream.computeInt32Size(4, i);
        }
        long j2 = this.responseSize_;
        if (j2 != 0) {
            size2 += CodedOutputStream.computeInt64Size(5, j2);
        }
        if (!this.userAgent_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(6, getUserAgent());
        }
        if (!this.remoteIp_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(7, getRemoteIp());
        }
        if (!this.referer_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(8, getReferer());
        }
        boolean z = this.cacheHit_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(9, z);
        }
        boolean z2 = this.cacheValidatedWithOriginServer_;
        if (z2) {
            size2 += CodedOutputStream.computeBoolSize(10, z2);
        }
        boolean z3 = this.cacheLookup_;
        if (z3) {
            size2 += CodedOutputStream.computeBoolSize(11, z3);
        }
        long j3 = this.cacheFillBytes_;
        if (j3 != 0) {
            size2 += CodedOutputStream.computeInt64Size(12, j3);
        }
        if (!this.serverIp_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(13, getServerIp());
        }
        if (this.latency_ != null) {
            size2 += CodedOutputStream.computeMessageSize(14, getLatency());
        }
        if (!this.protocol_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(15, getProtocol());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static HttpRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HttpRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HttpRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HttpRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HttpRequest parseFrom(InputStream input) throws IOException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HttpRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HttpRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (HttpRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HttpRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HttpRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HttpRequest parseFrom(CodedInputStream input) throws IOException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HttpRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(HttpRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRequest, Builder> implements HttpRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(HttpRequest.DEFAULT_INSTANCE);
        }

        public String getRequestMethod() {
            return ((HttpRequest) this.instance).getRequestMethod();
        }

        public ByteString getRequestMethodBytes() {
            return ((HttpRequest) this.instance).getRequestMethodBytes();
        }

        public Builder setRequestMethod(String value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestMethod(value);
            return this;
        }

        public Builder clearRequestMethod() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearRequestMethod();
            return this;
        }

        public Builder setRequestMethodBytes(ByteString value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestMethodBytes(value);
            return this;
        }

        public String getRequestUrl() {
            return ((HttpRequest) this.instance).getRequestUrl();
        }

        public ByteString getRequestUrlBytes() {
            return ((HttpRequest) this.instance).getRequestUrlBytes();
        }

        public Builder setRequestUrl(String value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestUrl(value);
            return this;
        }

        public Builder clearRequestUrl() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearRequestUrl();
            return this;
        }

        public Builder setRequestUrlBytes(ByteString value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestUrlBytes(value);
            return this;
        }

        public long getRequestSize() {
            return ((HttpRequest) this.instance).getRequestSize();
        }

        public Builder setRequestSize(long value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestSize(value);
            return this;
        }

        public Builder clearRequestSize() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearRequestSize();
            return this;
        }

        public int getStatus() {
            return ((HttpRequest) this.instance).getStatus();
        }

        public Builder setStatus(int value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setStatus(value);
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearStatus();
            return this;
        }

        public long getResponseSize() {
            return ((HttpRequest) this.instance).getResponseSize();
        }

        public Builder setResponseSize(long value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setResponseSize(value);
            return this;
        }

        public Builder clearResponseSize() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearResponseSize();
            return this;
        }

        public String getUserAgent() {
            return ((HttpRequest) this.instance).getUserAgent();
        }

        public ByteString getUserAgentBytes() {
            return ((HttpRequest) this.instance).getUserAgentBytes();
        }

        public Builder setUserAgent(String value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setUserAgent(value);
            return this;
        }

        public Builder clearUserAgent() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearUserAgent();
            return this;
        }

        public Builder setUserAgentBytes(ByteString value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setUserAgentBytes(value);
            return this;
        }

        public String getRemoteIp() {
            return ((HttpRequest) this.instance).getRemoteIp();
        }

        public ByteString getRemoteIpBytes() {
            return ((HttpRequest) this.instance).getRemoteIpBytes();
        }

        public Builder setRemoteIp(String value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRemoteIp(value);
            return this;
        }

        public Builder clearRemoteIp() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearRemoteIp();
            return this;
        }

        public Builder setRemoteIpBytes(ByteString value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRemoteIpBytes(value);
            return this;
        }

        public String getServerIp() {
            return ((HttpRequest) this.instance).getServerIp();
        }

        public ByteString getServerIpBytes() {
            return ((HttpRequest) this.instance).getServerIpBytes();
        }

        public Builder setServerIp(String value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setServerIp(value);
            return this;
        }

        public Builder clearServerIp() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearServerIp();
            return this;
        }

        public Builder setServerIpBytes(ByteString value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setServerIpBytes(value);
            return this;
        }

        public String getReferer() {
            return ((HttpRequest) this.instance).getReferer();
        }

        public ByteString getRefererBytes() {
            return ((HttpRequest) this.instance).getRefererBytes();
        }

        public Builder setReferer(String value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setReferer(value);
            return this;
        }

        public Builder clearReferer() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearReferer();
            return this;
        }

        public Builder setRefererBytes(ByteString value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRefererBytes(value);
            return this;
        }

        public boolean hasLatency() {
            return ((HttpRequest) this.instance).hasLatency();
        }

        public Duration getLatency() {
            return ((HttpRequest) this.instance).getLatency();
        }

        public Builder setLatency(Duration value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setLatency(value);
            return this;
        }

        public Builder setLatency(Duration.Builder builderForValue) {
            copyOnWrite();
            ((HttpRequest) this.instance).setLatency(builderForValue);
            return this;
        }

        public Builder mergeLatency(Duration value) {
            copyOnWrite();
            ((HttpRequest) this.instance).mergeLatency(value);
            return this;
        }

        public Builder clearLatency() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearLatency();
            return this;
        }

        public boolean getCacheLookup() {
            return ((HttpRequest) this.instance).getCacheLookup();
        }

        public Builder setCacheLookup(boolean value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setCacheLookup(value);
            return this;
        }

        public Builder clearCacheLookup() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearCacheLookup();
            return this;
        }

        public boolean getCacheHit() {
            return ((HttpRequest) this.instance).getCacheHit();
        }

        public Builder setCacheHit(boolean value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setCacheHit(value);
            return this;
        }

        public Builder clearCacheHit() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearCacheHit();
            return this;
        }

        public boolean getCacheValidatedWithOriginServer() {
            return ((HttpRequest) this.instance).getCacheValidatedWithOriginServer();
        }

        public Builder setCacheValidatedWithOriginServer(boolean value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setCacheValidatedWithOriginServer(value);
            return this;
        }

        public Builder clearCacheValidatedWithOriginServer() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearCacheValidatedWithOriginServer();
            return this;
        }

        public long getCacheFillBytes() {
            return ((HttpRequest) this.instance).getCacheFillBytes();
        }

        public Builder setCacheFillBytes(long value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setCacheFillBytes(value);
            return this;
        }

        public Builder clearCacheFillBytes() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearCacheFillBytes();
            return this;
        }

        public String getProtocol() {
            return ((HttpRequest) this.instance).getProtocol();
        }

        public ByteString getProtocolBytes() {
            return ((HttpRequest) this.instance).getProtocolBytes();
        }

        public Builder setProtocol(String value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setProtocol(value);
            return this;
        }

        public Builder clearProtocol() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearProtocol();
            return this;
        }

        public Builder setProtocolBytes(ByteString value) {
            copyOnWrite();
            ((HttpRequest) this.instance).setProtocolBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.logging.type.HttpRequest$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new HttpRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                HttpRequest other = (HttpRequest) arg1;
                this.requestMethod_ = visitor.visitString(!this.requestMethod_.isEmpty(), this.requestMethod_, !other.requestMethod_.isEmpty(), other.requestMethod_);
                this.requestUrl_ = visitor.visitString(!this.requestUrl_.isEmpty(), this.requestUrl_, !other.requestUrl_.isEmpty(), other.requestUrl_);
                this.requestSize_ = visitor.visitLong(this.requestSize_ != 0, this.requestSize_, other.requestSize_ != 0, other.requestSize_);
                this.status_ = visitor.visitInt(this.status_ != 0, this.status_, other.status_ != 0, other.status_);
                this.responseSize_ = visitor.visitLong(this.responseSize_ != 0, this.responseSize_, other.responseSize_ != 0, other.responseSize_);
                this.userAgent_ = visitor.visitString(!this.userAgent_.isEmpty(), this.userAgent_, !other.userAgent_.isEmpty(), other.userAgent_);
                this.remoteIp_ = visitor.visitString(!this.remoteIp_.isEmpty(), this.remoteIp_, !other.remoteIp_.isEmpty(), other.remoteIp_);
                this.serverIp_ = visitor.visitString(!this.serverIp_.isEmpty(), this.serverIp_, !other.serverIp_.isEmpty(), other.serverIp_);
                this.referer_ = visitor.visitString(!this.referer_.isEmpty(), this.referer_, !other.referer_.isEmpty(), other.referer_);
                this.latency_ = (Duration) visitor.visitMessage(this.latency_, other.latency_);
                boolean z = this.cacheLookup_;
                boolean z2 = other.cacheLookup_;
                this.cacheLookup_ = visitor.visitBoolean(z, z, z2, z2);
                boolean z3 = this.cacheHit_;
                boolean z4 = other.cacheHit_;
                this.cacheHit_ = visitor.visitBoolean(z3, z3, z4, z4);
                boolean z5 = this.cacheValidatedWithOriginServer_;
                boolean z6 = other.cacheValidatedWithOriginServer_;
                this.cacheValidatedWithOriginServer_ = visitor.visitBoolean(z5, z5, z6, z6);
                this.cacheFillBytes_ = visitor.visitLong(this.cacheFillBytes_ != 0, this.cacheFillBytes_, other.cacheFillBytes_ != 0, other.cacheFillBytes_);
                this.protocol_ = visitor.visitString(!this.protocol_.isEmpty(), this.protocol_, !other.protocol_.isEmpty(), other.protocol_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream input = (CodedInputStream) arg0;
                ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10:
                                this.requestMethod_ = input.readStringRequireUtf8();
                                break;
                            case 18:
                                this.requestUrl_ = input.readStringRequireUtf8();
                                break;
                            case 24:
                                this.requestSize_ = input.readInt64();
                                break;
                            case 32:
                                this.status_ = input.readInt32();
                                break;
                            case 40:
                                this.responseSize_ = input.readInt64();
                                break;
                            case 50:
                                this.userAgent_ = input.readStringRequireUtf8();
                                break;
                            case 58:
                                this.remoteIp_ = input.readStringRequireUtf8();
                                break;
                            case 66:
                                this.referer_ = input.readStringRequireUtf8();
                                break;
                            case 72:
                                this.cacheHit_ = input.readBool();
                                break;
                            case 80:
                                this.cacheValidatedWithOriginServer_ = input.readBool();
                                break;
                            case 88:
                                this.cacheLookup_ = input.readBool();
                                break;
                            case 96:
                                this.cacheFillBytes_ = input.readInt64();
                                break;
                            case 106:
                                this.serverIp_ = input.readStringRequireUtf8();
                                break;
                            case 114:
                                Duration.Builder subBuilder = null;
                                if (this.latency_ != null) {
                                    subBuilder = (Duration.Builder) this.latency_.toBuilder();
                                }
                                Duration duration = (Duration) input.readMessage(Duration.parser(), extensionRegistry);
                                this.latency_ = duration;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(duration);
                                    this.latency_ = (Duration) subBuilder.buildPartial();
                                    break;
                                }
                            case 122:
                                this.protocol_ = input.readStringRequireUtf8();
                                break;
                            default:
                                if (input.skipField(tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (HttpRequest.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    static {
        HttpRequest httpRequest = new HttpRequest();
        DEFAULT_INSTANCE = httpRequest;
        httpRequest.makeImmutable();
    }

    public static HttpRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HttpRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
