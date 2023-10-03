package com.google.api;

import com.google.api.AuthRequirement;
import com.google.api.OAuthRequirements;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class AuthenticationRule extends GeneratedMessageLite<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
    public static final int ALLOW_WITHOUT_CREDENTIAL_FIELD_NUMBER = 5;
    /* access modifiers changed from: private */
    public static final AuthenticationRule DEFAULT_INSTANCE;
    public static final int OAUTH_FIELD_NUMBER = 2;
    private static volatile Parser<AuthenticationRule> PARSER = null;
    public static final int REQUIREMENTS_FIELD_NUMBER = 7;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private boolean allowWithoutCredential_;
    private int bitField0_;
    private OAuthRequirements oauth_;
    private Internal.ProtobufList<AuthRequirement> requirements_ = emptyProtobufList();
    private String selector_ = "";

    private AuthenticationRule() {
    }

    public String getSelector() {
        return this.selector_;
    }

    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* access modifiers changed from: private */
    public void setSelector(String value) {
        if (value != null) {
            this.selector_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* access modifiers changed from: private */
    public void setSelectorBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.selector_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public boolean hasOauth() {
        return this.oauth_ != null;
    }

    public OAuthRequirements getOauth() {
        OAuthRequirements oAuthRequirements = this.oauth_;
        return oAuthRequirements == null ? OAuthRequirements.getDefaultInstance() : oAuthRequirements;
    }

    /* access modifiers changed from: private */
    public void setOauth(OAuthRequirements value) {
        if (value != null) {
            this.oauth_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setOauth(OAuthRequirements.Builder builderForValue) {
        this.oauth_ = (OAuthRequirements) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeOauth(OAuthRequirements value) {
        OAuthRequirements oAuthRequirements = this.oauth_;
        if (oAuthRequirements == null || oAuthRequirements == OAuthRequirements.getDefaultInstance()) {
            this.oauth_ = value;
        } else {
            this.oauth_ = (OAuthRequirements) ((OAuthRequirements.Builder) OAuthRequirements.newBuilder(this.oauth_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearOauth() {
        this.oauth_ = null;
    }

    public boolean getAllowWithoutCredential() {
        return this.allowWithoutCredential_;
    }

    /* access modifiers changed from: private */
    public void setAllowWithoutCredential(boolean value) {
        this.allowWithoutCredential_ = value;
    }

    /* access modifiers changed from: private */
    public void clearAllowWithoutCredential() {
        this.allowWithoutCredential_ = false;
    }

    public List<AuthRequirement> getRequirementsList() {
        return this.requirements_;
    }

    public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
        return this.requirements_;
    }

    public int getRequirementsCount() {
        return this.requirements_.size();
    }

    public AuthRequirement getRequirements(int index) {
        return (AuthRequirement) this.requirements_.get(index);
    }

    public AuthRequirementOrBuilder getRequirementsOrBuilder(int index) {
        return (AuthRequirementOrBuilder) this.requirements_.get(index);
    }

    private void ensureRequirementsIsMutable() {
        if (!this.requirements_.isModifiable()) {
            this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_);
        }
    }

    /* access modifiers changed from: private */
    public void setRequirements(int index, AuthRequirement value) {
        if (value != null) {
            ensureRequirementsIsMutable();
            this.requirements_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRequirements(int index, AuthRequirement.Builder builderForValue) {
        ensureRequirementsIsMutable();
        this.requirements_.set(index, (AuthRequirement) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRequirements(AuthRequirement value) {
        if (value != null) {
            ensureRequirementsIsMutable();
            this.requirements_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRequirements(int index, AuthRequirement value) {
        if (value != null) {
            ensureRequirementsIsMutable();
            this.requirements_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRequirements(AuthRequirement.Builder builderForValue) {
        ensureRequirementsIsMutable();
        this.requirements_.add((AuthRequirement) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRequirements(int index, AuthRequirement.Builder builderForValue) {
        ensureRequirementsIsMutable();
        this.requirements_.add(index, (AuthRequirement) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllRequirements(Iterable<? extends AuthRequirement> values) {
        ensureRequirementsIsMutable();
        AbstractMessageLite.addAll(values, this.requirements_);
    }

    /* access modifiers changed from: private */
    public void clearRequirements() {
        this.requirements_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeRequirements(int index) {
        ensureRequirementsIsMutable();
        this.requirements_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.selector_.isEmpty()) {
            output.writeString(1, getSelector());
        }
        if (this.oauth_ != null) {
            output.writeMessage(2, getOauth());
        }
        boolean z = this.allowWithoutCredential_;
        if (z) {
            output.writeBool(5, z);
        }
        for (int i = 0; i < this.requirements_.size(); i++) {
            output.writeMessage(7, (MessageLite) this.requirements_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.selector_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getSelector());
        }
        if (this.oauth_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getOauth());
        }
        boolean z = this.allowWithoutCredential_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(5, z);
        }
        for (int i = 0; i < this.requirements_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(7, (MessageLite) this.requirements_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static AuthenticationRule parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthenticationRule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthenticationRule parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuthenticationRule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuthenticationRule parseFrom(InputStream input) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthenticationRule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream input) throws IOException {
        return (AuthenticationRule) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthenticationRule) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuthenticationRule parseFrom(CodedInputStream input) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuthenticationRule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthenticationRule prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(AuthenticationRule.DEFAULT_INSTANCE);
        }

        public String getSelector() {
            return ((AuthenticationRule) this.instance).getSelector();
        }

        public ByteString getSelectorBytes() {
            return ((AuthenticationRule) this.instance).getSelectorBytes();
        }

        public Builder setSelector(String value) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setSelector(value);
            return this;
        }

        public Builder clearSelector() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearSelector();
            return this;
        }

        public Builder setSelectorBytes(ByteString value) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setSelectorBytes(value);
            return this;
        }

        public boolean hasOauth() {
            return ((AuthenticationRule) this.instance).hasOauth();
        }

        public OAuthRequirements getOauth() {
            return ((AuthenticationRule) this.instance).getOauth();
        }

        public Builder setOauth(OAuthRequirements value) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setOauth(value);
            return this;
        }

        public Builder setOauth(OAuthRequirements.Builder builderForValue) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setOauth(builderForValue);
            return this;
        }

        public Builder mergeOauth(OAuthRequirements value) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).mergeOauth(value);
            return this;
        }

        public Builder clearOauth() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearOauth();
            return this;
        }

        public boolean getAllowWithoutCredential() {
            return ((AuthenticationRule) this.instance).getAllowWithoutCredential();
        }

        public Builder setAllowWithoutCredential(boolean value) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setAllowWithoutCredential(value);
            return this;
        }

        public Builder clearAllowWithoutCredential() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearAllowWithoutCredential();
            return this;
        }

        public List<AuthRequirement> getRequirementsList() {
            return Collections.unmodifiableList(((AuthenticationRule) this.instance).getRequirementsList());
        }

        public int getRequirementsCount() {
            return ((AuthenticationRule) this.instance).getRequirementsCount();
        }

        public AuthRequirement getRequirements(int index) {
            return ((AuthenticationRule) this.instance).getRequirements(index);
        }

        public Builder setRequirements(int index, AuthRequirement value) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setRequirements(index, value);
            return this;
        }

        public Builder setRequirements(int index, AuthRequirement.Builder builderForValue) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setRequirements(index, builderForValue);
            return this;
        }

        public Builder addRequirements(AuthRequirement value) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(value);
            return this;
        }

        public Builder addRequirements(int index, AuthRequirement value) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(index, value);
            return this;
        }

        public Builder addRequirements(AuthRequirement.Builder builderForValue) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(builderForValue);
            return this;
        }

        public Builder addRequirements(int index, AuthRequirement.Builder builderForValue) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(index, builderForValue);
            return this;
        }

        public Builder addAllRequirements(Iterable<? extends AuthRequirement> values) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addAllRequirements(values);
            return this;
        }

        public Builder clearRequirements() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearRequirements();
            return this;
        }

        public Builder removeRequirements(int index) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).removeRequirements(index);
            return this;
        }
    }

    /* renamed from: com.google.api.AuthenticationRule$1  reason: invalid class name */
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
                return new AuthenticationRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.requirements_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                AuthenticationRule other = (AuthenticationRule) arg1;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, !other.selector_.isEmpty(), other.selector_);
                this.oauth_ = (OAuthRequirements) visitor.visitMessage(this.oauth_, other.oauth_);
                boolean z = this.allowWithoutCredential_;
                boolean z2 = other.allowWithoutCredential_;
                this.allowWithoutCredential_ = visitor.visitBoolean(z, z, z2, z2);
                this.requirements_ = visitor.visitList(this.requirements_, other.requirements_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= other.bitField0_;
                }
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
                        } else if (tag == 10) {
                            this.selector_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            OAuthRequirements.Builder subBuilder = null;
                            if (this.oauth_ != null) {
                                subBuilder = (OAuthRequirements.Builder) this.oauth_.toBuilder();
                            }
                            OAuthRequirements oAuthRequirements = (OAuthRequirements) input.readMessage(OAuthRequirements.parser(), extensionRegistry);
                            this.oauth_ = oAuthRequirements;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(oAuthRequirements);
                                this.oauth_ = (OAuthRequirements) subBuilder.buildPartial();
                            }
                        } else if (tag == 40) {
                            this.allowWithoutCredential_ = input.readBool();
                        } else if (tag == 58) {
                            if (!this.requirements_.isModifiable()) {
                                this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_);
                            }
                            this.requirements_.add((AuthRequirement) input.readMessage(AuthRequirement.parser(), extensionRegistry));
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
                    synchronized (AuthenticationRule.class) {
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
        AuthenticationRule authenticationRule = new AuthenticationRule();
        DEFAULT_INSTANCE = authenticationRule;
        authenticationRule.makeImmutable();
    }

    public static AuthenticationRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthenticationRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
