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
public final class AuthRequirement extends GeneratedMessageLite<AuthRequirement, Builder> implements AuthRequirementOrBuilder {
    public static final int AUDIENCES_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final AuthRequirement DEFAULT_INSTANCE;
    private static volatile Parser<AuthRequirement> PARSER = null;
    public static final int PROVIDER_ID_FIELD_NUMBER = 1;
    private String audiences_ = "";
    private String providerId_ = "";

    private AuthRequirement() {
    }

    public String getProviderId() {
        return this.providerId_;
    }

    public ByteString getProviderIdBytes() {
        return ByteString.copyFromUtf8(this.providerId_);
    }

    /* access modifiers changed from: private */
    public void setProviderId(String value) {
        if (value != null) {
            this.providerId_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearProviderId() {
        this.providerId_ = getDefaultInstance().getProviderId();
    }

    /* access modifiers changed from: private */
    public void setProviderIdBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.providerId_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getAudiences() {
        return this.audiences_;
    }

    public ByteString getAudiencesBytes() {
        return ByteString.copyFromUtf8(this.audiences_);
    }

    /* access modifiers changed from: private */
    public void setAudiences(String value) {
        if (value != null) {
            this.audiences_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearAudiences() {
        this.audiences_ = getDefaultInstance().getAudiences();
    }

    /* access modifiers changed from: private */
    public void setAudiencesBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.audiences_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.providerId_.isEmpty()) {
            output.writeString(1, getProviderId());
        }
        if (!this.audiences_.isEmpty()) {
            output.writeString(2, getAudiences());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.providerId_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getProviderId());
        }
        if (!this.audiences_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getAudiences());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static AuthRequirement parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthRequirement parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthRequirement parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthRequirement parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthRequirement parseFrom(InputStream input) throws IOException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthRequirement parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthRequirement parseDelimitedFrom(InputStream input) throws IOException {
        return (AuthRequirement) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthRequirement parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthRequirement) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthRequirement parseFrom(CodedInputStream input) throws IOException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthRequirement parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthRequirement) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthRequirement prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthRequirement, Builder> implements AuthRequirementOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(AuthRequirement.DEFAULT_INSTANCE);
        }

        public String getProviderId() {
            return ((AuthRequirement) this.instance).getProviderId();
        }

        public ByteString getProviderIdBytes() {
            return ((AuthRequirement) this.instance).getProviderIdBytes();
        }

        public Builder setProviderId(String value) {
            copyOnWrite();
            ((AuthRequirement) this.instance).setProviderId(value);
            return this;
        }

        public Builder clearProviderId() {
            copyOnWrite();
            ((AuthRequirement) this.instance).clearProviderId();
            return this;
        }

        public Builder setProviderIdBytes(ByteString value) {
            copyOnWrite();
            ((AuthRequirement) this.instance).setProviderIdBytes(value);
            return this;
        }

        public String getAudiences() {
            return ((AuthRequirement) this.instance).getAudiences();
        }

        public ByteString getAudiencesBytes() {
            return ((AuthRequirement) this.instance).getAudiencesBytes();
        }

        public Builder setAudiences(String value) {
            copyOnWrite();
            ((AuthRequirement) this.instance).setAudiences(value);
            return this;
        }

        public Builder clearAudiences() {
            copyOnWrite();
            ((AuthRequirement) this.instance).clearAudiences();
            return this;
        }

        public Builder setAudiencesBytes(ByteString value) {
            copyOnWrite();
            ((AuthRequirement) this.instance).setAudiencesBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.AuthRequirement$1  reason: invalid class name */
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
                return new AuthRequirement();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                AuthRequirement other = (AuthRequirement) arg1;
                this.providerId_ = visitor.visitString(!this.providerId_.isEmpty(), this.providerId_, !other.providerId_.isEmpty(), other.providerId_);
                this.audiences_ = visitor.visitString(!this.audiences_.isEmpty(), this.audiences_, !other.audiences_.isEmpty(), other.audiences_);
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
                            this.providerId_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.audiences_ = input.readStringRequireUtf8();
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
                    synchronized (AuthRequirement.class) {
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
        AuthRequirement authRequirement = new AuthRequirement();
        DEFAULT_INSTANCE = authRequirement;
        authRequirement.makeImmutable();
    }

    public static AuthRequirement getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthRequirement> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
