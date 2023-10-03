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
public final class AuthorizationInfo extends GeneratedMessageLite<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final AuthorizationInfo DEFAULT_INSTANCE;
    public static final int GRANTED_FIELD_NUMBER = 3;
    private static volatile Parser<AuthorizationInfo> PARSER = null;
    public static final int PERMISSION_FIELD_NUMBER = 2;
    public static final int RESOURCE_FIELD_NUMBER = 1;
    private boolean granted_;
    private String permission_ = "";
    private String resource_ = "";

    private AuthorizationInfo() {
    }

    public String getResource() {
        return this.resource_;
    }

    public ByteString getResourceBytes() {
        return ByteString.copyFromUtf8(this.resource_);
    }

    /* access modifiers changed from: private */
    public void setResource(String value) {
        if (value != null) {
            this.resource_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearResource() {
        this.resource_ = getDefaultInstance().getResource();
    }

    /* access modifiers changed from: private */
    public void setResourceBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.resource_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getPermission() {
        return this.permission_;
    }

    public ByteString getPermissionBytes() {
        return ByteString.copyFromUtf8(this.permission_);
    }

    /* access modifiers changed from: private */
    public void setPermission(String value) {
        if (value != null) {
            this.permission_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearPermission() {
        this.permission_ = getDefaultInstance().getPermission();
    }

    /* access modifiers changed from: private */
    public void setPermissionBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.permission_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public boolean getGranted() {
        return this.granted_;
    }

    /* access modifiers changed from: private */
    public void setGranted(boolean value) {
        this.granted_ = value;
    }

    /* access modifiers changed from: private */
    public void clearGranted() {
        this.granted_ = false;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.resource_.isEmpty()) {
            output.writeString(1, getResource());
        }
        if (!this.permission_.isEmpty()) {
            output.writeString(2, getPermission());
        }
        boolean z = this.granted_;
        if (z) {
            output.writeBool(3, z);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.resource_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getResource());
        }
        if (!this.permission_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getPermission());
        }
        boolean z = this.granted_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(3, z);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static AuthorizationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthorizationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthorizationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthorizationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthorizationInfo parseFrom(InputStream input) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthorizationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (AuthorizationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthorizationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthorizationInfo parseFrom(CodedInputStream input) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthorizationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthorizationInfo prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(AuthorizationInfo.DEFAULT_INSTANCE);
        }

        public String getResource() {
            return ((AuthorizationInfo) this.instance).getResource();
        }

        public ByteString getResourceBytes() {
            return ((AuthorizationInfo) this.instance).getResourceBytes();
        }

        public Builder setResource(String value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setResource(value);
            return this;
        }

        public Builder clearResource() {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).clearResource();
            return this;
        }

        public Builder setResourceBytes(ByteString value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setResourceBytes(value);
            return this;
        }

        public String getPermission() {
            return ((AuthorizationInfo) this.instance).getPermission();
        }

        public ByteString getPermissionBytes() {
            return ((AuthorizationInfo) this.instance).getPermissionBytes();
        }

        public Builder setPermission(String value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setPermission(value);
            return this;
        }

        public Builder clearPermission() {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).clearPermission();
            return this;
        }

        public Builder setPermissionBytes(ByteString value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setPermissionBytes(value);
            return this;
        }

        public boolean getGranted() {
            return ((AuthorizationInfo) this.instance).getGranted();
        }

        public Builder setGranted(boolean value) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setGranted(value);
            return this;
        }

        public Builder clearGranted() {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).clearGranted();
            return this;
        }
    }

    /* renamed from: com.google.cloud.audit.AuthorizationInfo$1  reason: invalid class name */
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
                return new AuthorizationInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                AuthorizationInfo other = (AuthorizationInfo) arg1;
                this.resource_ = visitor.visitString(!this.resource_.isEmpty(), this.resource_, !other.resource_.isEmpty(), other.resource_);
                this.permission_ = visitor.visitString(!this.permission_.isEmpty(), this.permission_, !other.permission_.isEmpty(), other.permission_);
                boolean z = this.granted_;
                boolean z2 = other.granted_;
                this.granted_ = visitor.visitBoolean(z, z, z2, z2);
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
                            this.resource_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.permission_ = input.readStringRequireUtf8();
                        } else if (tag == 24) {
                            this.granted_ = input.readBool();
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
                    synchronized (AuthorizationInfo.class) {
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
        AuthorizationInfo authorizationInfo = new AuthorizationInfo();
        DEFAULT_INSTANCE = authorizationInfo;
        authorizationInfo.makeImmutable();
    }

    public static AuthorizationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthorizationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
