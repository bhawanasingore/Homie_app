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
public final class AuthenticationInfo extends GeneratedMessageLite<AuthenticationInfo, Builder> implements AuthenticationInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final AuthenticationInfo DEFAULT_INSTANCE;
    private static volatile Parser<AuthenticationInfo> PARSER = null;
    public static final int PRINCIPAL_EMAIL_FIELD_NUMBER = 1;
    private String principalEmail_ = "";

    private AuthenticationInfo() {
    }

    public String getPrincipalEmail() {
        return this.principalEmail_;
    }

    public ByteString getPrincipalEmailBytes() {
        return ByteString.copyFromUtf8(this.principalEmail_);
    }

    /* access modifiers changed from: private */
    public void setPrincipalEmail(String value) {
        if (value != null) {
            this.principalEmail_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearPrincipalEmail() {
        this.principalEmail_ = getDefaultInstance().getPrincipalEmail();
    }

    /* access modifiers changed from: private */
    public void setPrincipalEmailBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.principalEmail_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.principalEmail_.isEmpty()) {
            output.writeString(1, getPrincipalEmail());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.principalEmail_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getPrincipalEmail());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static AuthenticationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AuthenticationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthenticationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthenticationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthenticationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AuthenticationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthenticationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthenticationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthenticationInfo parseFrom(InputStream input) throws IOException {
        return (AuthenticationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthenticationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthenticationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthenticationInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (AuthenticationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthenticationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthenticationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthenticationInfo parseFrom(CodedInputStream input) throws IOException {
        return (AuthenticationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthenticationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthenticationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthenticationInfo prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthenticationInfo, Builder> implements AuthenticationInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(AuthenticationInfo.DEFAULT_INSTANCE);
        }

        public String getPrincipalEmail() {
            return ((AuthenticationInfo) this.instance).getPrincipalEmail();
        }

        public ByteString getPrincipalEmailBytes() {
            return ((AuthenticationInfo) this.instance).getPrincipalEmailBytes();
        }

        public Builder setPrincipalEmail(String value) {
            copyOnWrite();
            ((AuthenticationInfo) this.instance).setPrincipalEmail(value);
            return this;
        }

        public Builder clearPrincipalEmail() {
            copyOnWrite();
            ((AuthenticationInfo) this.instance).clearPrincipalEmail();
            return this;
        }

        public Builder setPrincipalEmailBytes(ByteString value) {
            copyOnWrite();
            ((AuthenticationInfo) this.instance).setPrincipalEmailBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.cloud.audit.AuthenticationInfo$1  reason: invalid class name */
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
                return new AuthenticationInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                AuthenticationInfo other = (AuthenticationInfo) arg1;
                this.principalEmail_ = ((GeneratedMessageLite.Visitor) arg0).visitString(!this.principalEmail_.isEmpty(), this.principalEmail_, !other.principalEmail_.isEmpty(), other.principalEmail_);
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
                            this.principalEmail_ = input.readStringRequireUtf8();
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
                    synchronized (AuthenticationInfo.class) {
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
        AuthenticationInfo authenticationInfo = new AuthenticationInfo();
        DEFAULT_INSTANCE = authenticationInfo;
        authenticationInfo.makeImmutable();
    }

    public static AuthenticationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthenticationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
