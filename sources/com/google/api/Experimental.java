package com.google.api;

import com.google.api.AuthorizationConfig;
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
public final class Experimental extends GeneratedMessageLite<Experimental, Builder> implements ExperimentalOrBuilder {
    public static final int AUTHORIZATION_FIELD_NUMBER = 8;
    /* access modifiers changed from: private */
    public static final Experimental DEFAULT_INSTANCE;
    private static volatile Parser<Experimental> PARSER;
    private AuthorizationConfig authorization_;

    private Experimental() {
    }

    public boolean hasAuthorization() {
        return this.authorization_ != null;
    }

    public AuthorizationConfig getAuthorization() {
        AuthorizationConfig authorizationConfig = this.authorization_;
        return authorizationConfig == null ? AuthorizationConfig.getDefaultInstance() : authorizationConfig;
    }

    /* access modifiers changed from: private */
    public void setAuthorization(AuthorizationConfig value) {
        if (value != null) {
            this.authorization_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAuthorization(AuthorizationConfig.Builder builderForValue) {
        this.authorization_ = (AuthorizationConfig) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeAuthorization(AuthorizationConfig value) {
        AuthorizationConfig authorizationConfig = this.authorization_;
        if (authorizationConfig == null || authorizationConfig == AuthorizationConfig.getDefaultInstance()) {
            this.authorization_ = value;
        } else {
            this.authorization_ = (AuthorizationConfig) ((AuthorizationConfig.Builder) AuthorizationConfig.newBuilder(this.authorization_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAuthorization() {
        this.authorization_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.authorization_ != null) {
            output.writeMessage(8, getAuthorization());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.authorization_ != null) {
            size2 = 0 + CodedOutputStream.computeMessageSize(8, getAuthorization());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Experimental parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Experimental parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Experimental parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Experimental parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Experimental parseFrom(InputStream input) throws IOException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Experimental parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Experimental parseDelimitedFrom(InputStream input) throws IOException {
        return (Experimental) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Experimental parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Experimental) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Experimental parseFrom(CodedInputStream input) throws IOException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Experimental parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Experimental prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Experimental, Builder> implements ExperimentalOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Experimental.DEFAULT_INSTANCE);
        }

        public boolean hasAuthorization() {
            return ((Experimental) this.instance).hasAuthorization();
        }

        public AuthorizationConfig getAuthorization() {
            return ((Experimental) this.instance).getAuthorization();
        }

        public Builder setAuthorization(AuthorizationConfig value) {
            copyOnWrite();
            ((Experimental) this.instance).setAuthorization(value);
            return this;
        }

        public Builder setAuthorization(AuthorizationConfig.Builder builderForValue) {
            copyOnWrite();
            ((Experimental) this.instance).setAuthorization(builderForValue);
            return this;
        }

        public Builder mergeAuthorization(AuthorizationConfig value) {
            copyOnWrite();
            ((Experimental) this.instance).mergeAuthorization(value);
            return this;
        }

        public Builder clearAuthorization() {
            copyOnWrite();
            ((Experimental) this.instance).clearAuthorization();
            return this;
        }
    }

    /* renamed from: com.google.api.Experimental$1  reason: invalid class name */
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
                return new Experimental();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.authorization_ = (AuthorizationConfig) ((GeneratedMessageLite.Visitor) arg0).visitMessage(this.authorization_, ((Experimental) arg1).authorization_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream input = (CodedInputStream) arg0;
                ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        if (tag == 0) {
                            done = true;
                        } else if (tag == 66) {
                            AuthorizationConfig.Builder subBuilder = null;
                            if (this.authorization_ != null) {
                                subBuilder = (AuthorizationConfig.Builder) this.authorization_.toBuilder();
                            }
                            AuthorizationConfig authorizationConfig = (AuthorizationConfig) input.readMessage(AuthorizationConfig.parser(), extensionRegistry);
                            this.authorization_ = authorizationConfig;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(authorizationConfig);
                                this.authorization_ = (AuthorizationConfig) subBuilder.buildPartial();
                            }
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
                    synchronized (Experimental.class) {
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
        Experimental experimental = new Experimental();
        DEFAULT_INSTANCE = experimental;
        experimental.makeImmutable();
    }

    public static Experimental getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Experimental> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
