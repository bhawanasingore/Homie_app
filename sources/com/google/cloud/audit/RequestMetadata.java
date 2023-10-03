package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class RequestMetadata extends GeneratedMessageLite<RequestMetadata, Builder> implements RequestMetadataOrBuilder {
    public static final int CALLER_IP_FIELD_NUMBER = 1;
    public static final int CALLER_SUPPLIED_USER_AGENT_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final RequestMetadata DEFAULT_INSTANCE;
    private static volatile Parser<RequestMetadata> PARSER;
    private String callerIp_ = "";
    private String callerSuppliedUserAgent_ = "";

    private RequestMetadata() {
    }

    public String getCallerIp() {
        return this.callerIp_;
    }

    public ByteString getCallerIpBytes() {
        return ByteString.copyFromUtf8(this.callerIp_);
    }

    /* access modifiers changed from: private */
    public void setCallerIp(String value) {
        if (value != null) {
            this.callerIp_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearCallerIp() {
        this.callerIp_ = getDefaultInstance().getCallerIp();
    }

    /* access modifiers changed from: private */
    public void setCallerIpBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.callerIp_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getCallerSuppliedUserAgent() {
        return this.callerSuppliedUserAgent_;
    }

    public ByteString getCallerSuppliedUserAgentBytes() {
        return ByteString.copyFromUtf8(this.callerSuppliedUserAgent_);
    }

    /* access modifiers changed from: private */
    public void setCallerSuppliedUserAgent(String value) {
        if (value != null) {
            this.callerSuppliedUserAgent_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearCallerSuppliedUserAgent() {
        this.callerSuppliedUserAgent_ = getDefaultInstance().getCallerSuppliedUserAgent();
    }

    /* access modifiers changed from: private */
    public void setCallerSuppliedUserAgentBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.callerSuppliedUserAgent_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.callerIp_.isEmpty()) {
            output.writeString(1, getCallerIp());
        }
        if (!this.callerSuppliedUserAgent_.isEmpty()) {
            output.writeString(2, getCallerSuppliedUserAgent());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.callerIp_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getCallerIp());
        }
        if (!this.callerSuppliedUserAgent_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getCallerSuppliedUserAgent());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static RequestMetadata parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RequestMetadata parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RequestMetadata parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RequestMetadata parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RequestMetadata parseFrom(InputStream input) throws IOException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RequestMetadata parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RequestMetadata parseDelimitedFrom(InputStream input) throws IOException {
        return (RequestMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RequestMetadata parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RequestMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RequestMetadata parseFrom(CodedInputStream input) throws IOException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RequestMetadata parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RequestMetadata prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<RequestMetadata, Builder> implements RequestMetadataOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(RequestMetadata.DEFAULT_INSTANCE);
        }

        public String getCallerIp() {
            return ((RequestMetadata) this.instance).getCallerIp();
        }

        public ByteString getCallerIpBytes() {
            return ((RequestMetadata) this.instance).getCallerIpBytes();
        }

        public Builder setCallerIp(String value) {
            copyOnWrite();
            ((RequestMetadata) this.instance).setCallerIp(value);
            return this;
        }

        public Builder clearCallerIp() {
            copyOnWrite();
            ((RequestMetadata) this.instance).clearCallerIp();
            return this;
        }

        public Builder setCallerIpBytes(ByteString value) {
            copyOnWrite();
            ((RequestMetadata) this.instance).setCallerIpBytes(value);
            return this;
        }

        public String getCallerSuppliedUserAgent() {
            return ((RequestMetadata) this.instance).getCallerSuppliedUserAgent();
        }

        public ByteString getCallerSuppliedUserAgentBytes() {
            return ((RequestMetadata) this.instance).getCallerSuppliedUserAgentBytes();
        }

        public Builder setCallerSuppliedUserAgent(String value) {
            copyOnWrite();
            ((RequestMetadata) this.instance).setCallerSuppliedUserAgent(value);
            return this;
        }

        public Builder clearCallerSuppliedUserAgent() {
            copyOnWrite();
            ((RequestMetadata) this.instance).clearCallerSuppliedUserAgent();
            return this;
        }

        public Builder setCallerSuppliedUserAgentBytes(ByteString value) {
            copyOnWrite();
            ((RequestMetadata) this.instance).setCallerSuppliedUserAgentBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.cloud.audit.RequestMetadata$1  reason: invalid class name */
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
                return new RequestMetadata();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                RequestMetadata other = (RequestMetadata) arg1;
                this.callerIp_ = visitor.visitString(!this.callerIp_.isEmpty(), this.callerIp_, !other.callerIp_.isEmpty(), other.callerIp_);
                this.callerSuppliedUserAgent_ = visitor.visitString(!this.callerSuppliedUserAgent_.isEmpty(), this.callerSuppliedUserAgent_, !other.callerSuppliedUserAgent_.isEmpty(), other.callerSuppliedUserAgent_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream input = (CodedInputStream) arg0;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        if (tag == 0) {
                            done = true;
                        } else if (tag == 10) {
                            this.callerIp_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.callerSuppliedUserAgent_ = input.readStringRequireUtf8();
                        } else if (!input.skipField(tag)) {
                            done = true;
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
                    synchronized (RequestMetadata.class) {
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
        RequestMetadata requestMetadata = new RequestMetadata();
        DEFAULT_INSTANCE = requestMetadata;
        requestMetadata.makeImmutable();
    }

    public static RequestMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RequestMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
