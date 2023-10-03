package com.google.api;

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
public final class AuthorizationConfig extends GeneratedMessageLite<AuthorizationConfig, Builder> implements AuthorizationConfigOrBuilder {
    /* access modifiers changed from: private */
    public static final AuthorizationConfig DEFAULT_INSTANCE;
    private static volatile Parser<AuthorizationConfig> PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 1;
    private String provider_ = "";

    private AuthorizationConfig() {
    }

    public String getProvider() {
        return this.provider_;
    }

    public ByteString getProviderBytes() {
        return ByteString.copyFromUtf8(this.provider_);
    }

    /* access modifiers changed from: private */
    public void setProvider(String value) {
        if (value != null) {
            this.provider_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearProvider() {
        this.provider_ = getDefaultInstance().getProvider();
    }

    /* access modifiers changed from: private */
    public void setProviderBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.provider_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.provider_.isEmpty()) {
            output.writeString(1, getProvider());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.provider_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getProvider());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static AuthorizationConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthorizationConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthorizationConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthorizationConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthorizationConfig parseFrom(InputStream input) throws IOException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthorizationConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthorizationConfig parseDelimitedFrom(InputStream input) throws IOException {
        return (AuthorizationConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthorizationConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthorizationConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthorizationConfig parseFrom(CodedInputStream input) throws IOException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthorizationConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthorizationConfig prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationConfig, Builder> implements AuthorizationConfigOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(AuthorizationConfig.DEFAULT_INSTANCE);
        }

        public String getProvider() {
            return ((AuthorizationConfig) this.instance).getProvider();
        }

        public ByteString getProviderBytes() {
            return ((AuthorizationConfig) this.instance).getProviderBytes();
        }

        public Builder setProvider(String value) {
            copyOnWrite();
            ((AuthorizationConfig) this.instance).setProvider(value);
            return this;
        }

        public Builder clearProvider() {
            copyOnWrite();
            ((AuthorizationConfig) this.instance).clearProvider();
            return this;
        }

        public Builder setProviderBytes(ByteString value) {
            copyOnWrite();
            ((AuthorizationConfig) this.instance).setProviderBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.AuthorizationConfig$1  reason: invalid class name */
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
                return new AuthorizationConfig();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                AuthorizationConfig other = (AuthorizationConfig) arg1;
                this.provider_ = ((GeneratedMessageLite.Visitor) arg0).visitString(!this.provider_.isEmpty(), this.provider_, !other.provider_.isEmpty(), other.provider_);
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
                            this.provider_ = input.readStringRequireUtf8();
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
                    synchronized (AuthorizationConfig.class) {
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
        AuthorizationConfig authorizationConfig = new AuthorizationConfig();
        DEFAULT_INSTANCE = authorizationConfig;
        authorizationConfig.makeImmutable();
    }

    public static AuthorizationConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthorizationConfig> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
