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
public final class AuthProvider extends GeneratedMessageLite<AuthProvider, Builder> implements AuthProviderOrBuilder {
    public static final int AUDIENCES_FIELD_NUMBER = 4;
    public static final int AUTHORIZATION_URL_FIELD_NUMBER = 5;
    /* access modifiers changed from: private */
    public static final AuthProvider DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int ISSUER_FIELD_NUMBER = 2;
    public static final int JWKS_URI_FIELD_NUMBER = 3;
    private static volatile Parser<AuthProvider> PARSER;
    private String audiences_ = "";
    private String authorizationUrl_ = "";
    private String id_ = "";
    private String issuer_ = "";
    private String jwksUri_ = "";

    private AuthProvider() {
    }

    public String getId() {
        return this.id_;
    }

    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    /* access modifiers changed from: private */
    public void setId(String value) {
        if (value != null) {
            this.id_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* access modifiers changed from: private */
    public void setIdBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.id_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getIssuer() {
        return this.issuer_;
    }

    public ByteString getIssuerBytes() {
        return ByteString.copyFromUtf8(this.issuer_);
    }

    /* access modifiers changed from: private */
    public void setIssuer(String value) {
        if (value != null) {
            this.issuer_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearIssuer() {
        this.issuer_ = getDefaultInstance().getIssuer();
    }

    /* access modifiers changed from: private */
    public void setIssuerBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.issuer_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getJwksUri() {
        return this.jwksUri_;
    }

    public ByteString getJwksUriBytes() {
        return ByteString.copyFromUtf8(this.jwksUri_);
    }

    /* access modifiers changed from: private */
    public void setJwksUri(String value) {
        if (value != null) {
            this.jwksUri_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearJwksUri() {
        this.jwksUri_ = getDefaultInstance().getJwksUri();
    }

    /* access modifiers changed from: private */
    public void setJwksUriBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.jwksUri_ = value.toStringUtf8();
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

    public String getAuthorizationUrl() {
        return this.authorizationUrl_;
    }

    public ByteString getAuthorizationUrlBytes() {
        return ByteString.copyFromUtf8(this.authorizationUrl_);
    }

    /* access modifiers changed from: private */
    public void setAuthorizationUrl(String value) {
        if (value != null) {
            this.authorizationUrl_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearAuthorizationUrl() {
        this.authorizationUrl_ = getDefaultInstance().getAuthorizationUrl();
    }

    /* access modifiers changed from: private */
    public void setAuthorizationUrlBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.authorizationUrl_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.id_.isEmpty()) {
            output.writeString(1, getId());
        }
        if (!this.issuer_.isEmpty()) {
            output.writeString(2, getIssuer());
        }
        if (!this.jwksUri_.isEmpty()) {
            output.writeString(3, getJwksUri());
        }
        if (!this.audiences_.isEmpty()) {
            output.writeString(4, getAudiences());
        }
        if (!this.authorizationUrl_.isEmpty()) {
            output.writeString(5, getAuthorizationUrl());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.id_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getId());
        }
        if (!this.issuer_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getIssuer());
        }
        if (!this.jwksUri_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getJwksUri());
        }
        if (!this.audiences_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(4, getAudiences());
        }
        if (!this.authorizationUrl_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(5, getAuthorizationUrl());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static AuthProvider parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthProvider parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthProvider parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthProvider parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthProvider parseFrom(InputStream input) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthProvider parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthProvider parseDelimitedFrom(InputStream input) throws IOException {
        return (AuthProvider) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthProvider parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthProvider) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthProvider parseFrom(CodedInputStream input) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthProvider parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthProvider prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthProvider, Builder> implements AuthProviderOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(AuthProvider.DEFAULT_INSTANCE);
        }

        public String getId() {
            return ((AuthProvider) this.instance).getId();
        }

        public ByteString getIdBytes() {
            return ((AuthProvider) this.instance).getIdBytes();
        }

        public Builder setId(String value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setId(value);
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearId();
            return this;
        }

        public Builder setIdBytes(ByteString value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setIdBytes(value);
            return this;
        }

        public String getIssuer() {
            return ((AuthProvider) this.instance).getIssuer();
        }

        public ByteString getIssuerBytes() {
            return ((AuthProvider) this.instance).getIssuerBytes();
        }

        public Builder setIssuer(String value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setIssuer(value);
            return this;
        }

        public Builder clearIssuer() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearIssuer();
            return this;
        }

        public Builder setIssuerBytes(ByteString value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setIssuerBytes(value);
            return this;
        }

        public String getJwksUri() {
            return ((AuthProvider) this.instance).getJwksUri();
        }

        public ByteString getJwksUriBytes() {
            return ((AuthProvider) this.instance).getJwksUriBytes();
        }

        public Builder setJwksUri(String value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwksUri(value);
            return this;
        }

        public Builder clearJwksUri() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearJwksUri();
            return this;
        }

        public Builder setJwksUriBytes(ByteString value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwksUriBytes(value);
            return this;
        }

        public String getAudiences() {
            return ((AuthProvider) this.instance).getAudiences();
        }

        public ByteString getAudiencesBytes() {
            return ((AuthProvider) this.instance).getAudiencesBytes();
        }

        public Builder setAudiences(String value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAudiences(value);
            return this;
        }

        public Builder clearAudiences() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearAudiences();
            return this;
        }

        public Builder setAudiencesBytes(ByteString value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAudiencesBytes(value);
            return this;
        }

        public String getAuthorizationUrl() {
            return ((AuthProvider) this.instance).getAuthorizationUrl();
        }

        public ByteString getAuthorizationUrlBytes() {
            return ((AuthProvider) this.instance).getAuthorizationUrlBytes();
        }

        public Builder setAuthorizationUrl(String value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAuthorizationUrl(value);
            return this;
        }

        public Builder clearAuthorizationUrl() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearAuthorizationUrl();
            return this;
        }

        public Builder setAuthorizationUrlBytes(ByteString value) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAuthorizationUrlBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.AuthProvider$1  reason: invalid class name */
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
                return new AuthProvider();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                AuthProvider other = (AuthProvider) arg1;
                this.id_ = visitor.visitString(!this.id_.isEmpty(), this.id_, !other.id_.isEmpty(), other.id_);
                this.issuer_ = visitor.visitString(!this.issuer_.isEmpty(), this.issuer_, !other.issuer_.isEmpty(), other.issuer_);
                this.jwksUri_ = visitor.visitString(!this.jwksUri_.isEmpty(), this.jwksUri_, !other.jwksUri_.isEmpty(), other.jwksUri_);
                this.audiences_ = visitor.visitString(!this.audiences_.isEmpty(), this.audiences_, !other.audiences_.isEmpty(), other.audiences_);
                this.authorizationUrl_ = visitor.visitString(!this.authorizationUrl_.isEmpty(), this.authorizationUrl_, !other.authorizationUrl_.isEmpty(), other.authorizationUrl_);
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
                            this.id_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.issuer_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            this.jwksUri_ = input.readStringRequireUtf8();
                        } else if (tag == 34) {
                            this.audiences_ = input.readStringRequireUtf8();
                        } else if (tag == 42) {
                            this.authorizationUrl_ = input.readStringRequireUtf8();
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
                    synchronized (AuthProvider.class) {
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
        AuthProvider authProvider = new AuthProvider();
        DEFAULT_INSTANCE = authProvider;
        authProvider.makeImmutable();
    }

    public static AuthProvider getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthProvider> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
