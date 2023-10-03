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
public final class OAuthRequirements extends GeneratedMessageLite<OAuthRequirements, Builder> implements OAuthRequirementsOrBuilder {
    public static final int CANONICAL_SCOPES_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final OAuthRequirements DEFAULT_INSTANCE;
    private static volatile Parser<OAuthRequirements> PARSER;
    private String canonicalScopes_ = "";

    private OAuthRequirements() {
    }

    public String getCanonicalScopes() {
        return this.canonicalScopes_;
    }

    public ByteString getCanonicalScopesBytes() {
        return ByteString.copyFromUtf8(this.canonicalScopes_);
    }

    /* access modifiers changed from: private */
    public void setCanonicalScopes(String value) {
        if (value != null) {
            this.canonicalScopes_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearCanonicalScopes() {
        this.canonicalScopes_ = getDefaultInstance().getCanonicalScopes();
    }

    /* access modifiers changed from: private */
    public void setCanonicalScopesBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.canonicalScopes_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.canonicalScopes_.isEmpty()) {
            output.writeString(1, getCanonicalScopes());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.canonicalScopes_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getCanonicalScopes());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static OAuthRequirements parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static OAuthRequirements parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static OAuthRequirements parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static OAuthRequirements parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static OAuthRequirements parseFrom(InputStream input) throws IOException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static OAuthRequirements parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static OAuthRequirements parseDelimitedFrom(InputStream input) throws IOException {
        return (OAuthRequirements) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static OAuthRequirements parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (OAuthRequirements) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static OAuthRequirements parseFrom(CodedInputStream input) throws IOException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static OAuthRequirements parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (OAuthRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(OAuthRequirements prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<OAuthRequirements, Builder> implements OAuthRequirementsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(OAuthRequirements.DEFAULT_INSTANCE);
        }

        public String getCanonicalScopes() {
            return ((OAuthRequirements) this.instance).getCanonicalScopes();
        }

        public ByteString getCanonicalScopesBytes() {
            return ((OAuthRequirements) this.instance).getCanonicalScopesBytes();
        }

        public Builder setCanonicalScopes(String value) {
            copyOnWrite();
            ((OAuthRequirements) this.instance).setCanonicalScopes(value);
            return this;
        }

        public Builder clearCanonicalScopes() {
            copyOnWrite();
            ((OAuthRequirements) this.instance).clearCanonicalScopes();
            return this;
        }

        public Builder setCanonicalScopesBytes(ByteString value) {
            copyOnWrite();
            ((OAuthRequirements) this.instance).setCanonicalScopesBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.OAuthRequirements$1  reason: invalid class name */
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
                return new OAuthRequirements();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                OAuthRequirements other = (OAuthRequirements) arg1;
                this.canonicalScopes_ = ((GeneratedMessageLite.Visitor) arg0).visitString(!this.canonicalScopes_.isEmpty(), this.canonicalScopes_, !other.canonicalScopes_.isEmpty(), other.canonicalScopes_);
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
                            this.canonicalScopes_ = input.readStringRequireUtf8();
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
                    synchronized (OAuthRequirements.class) {
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
        OAuthRequirements oAuthRequirements = new OAuthRequirements();
        DEFAULT_INSTANCE = oAuthRequirements;
        oAuthRequirements.makeImmutable();
    }

    public static OAuthRequirements getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<OAuthRequirements> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
