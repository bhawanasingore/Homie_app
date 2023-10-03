package com.google.api;

import com.google.api.AuthProvider;
import com.google.api.AuthenticationRule;
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
public final class Authentication extends GeneratedMessageLite<Authentication, Builder> implements AuthenticationOrBuilder {
    /* access modifiers changed from: private */
    public static final Authentication DEFAULT_INSTANCE;
    private static volatile Parser<Authentication> PARSER = null;
    public static final int PROVIDERS_FIELD_NUMBER = 4;
    public static final int RULES_FIELD_NUMBER = 3;
    private Internal.ProtobufList<AuthProvider> providers_ = emptyProtobufList();
    private Internal.ProtobufList<AuthenticationRule> rules_ = emptyProtobufList();

    private Authentication() {
    }

    public List<AuthenticationRule> getRulesList() {
        return this.rules_;
    }

    public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    public int getRulesCount() {
        return this.rules_.size();
    }

    public AuthenticationRule getRules(int index) {
        return (AuthenticationRule) this.rules_.get(index);
    }

    public AuthenticationRuleOrBuilder getRulesOrBuilder(int index) {
        return (AuthenticationRuleOrBuilder) this.rules_.get(index);
    }

    private void ensureRulesIsMutable() {
        if (!this.rules_.isModifiable()) {
            this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
        }
    }

    /* access modifiers changed from: private */
    public void setRules(int index, AuthenticationRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRules(int index, AuthenticationRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.set(index, (AuthenticationRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(AuthenticationRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(int index, AuthenticationRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(AuthenticationRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add((AuthenticationRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(int index, AuthenticationRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add(index, (AuthenticationRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllRules(Iterable<? extends AuthenticationRule> values) {
        ensureRulesIsMutable();
        AbstractMessageLite.addAll(values, this.rules_);
    }

    /* access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeRules(int index) {
        ensureRulesIsMutable();
        this.rules_.remove(index);
    }

    public List<AuthProvider> getProvidersList() {
        return this.providers_;
    }

    public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
        return this.providers_;
    }

    public int getProvidersCount() {
        return this.providers_.size();
    }

    public AuthProvider getProviders(int index) {
        return (AuthProvider) this.providers_.get(index);
    }

    public AuthProviderOrBuilder getProvidersOrBuilder(int index) {
        return (AuthProviderOrBuilder) this.providers_.get(index);
    }

    private void ensureProvidersIsMutable() {
        if (!this.providers_.isModifiable()) {
            this.providers_ = GeneratedMessageLite.mutableCopy(this.providers_);
        }
    }

    /* access modifiers changed from: private */
    public void setProviders(int index, AuthProvider value) {
        if (value != null) {
            ensureProvidersIsMutable();
            this.providers_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setProviders(int index, AuthProvider.Builder builderForValue) {
        ensureProvidersIsMutable();
        this.providers_.set(index, (AuthProvider) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addProviders(AuthProvider value) {
        if (value != null) {
            ensureProvidersIsMutable();
            this.providers_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addProviders(int index, AuthProvider value) {
        if (value != null) {
            ensureProvidersIsMutable();
            this.providers_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addProviders(AuthProvider.Builder builderForValue) {
        ensureProvidersIsMutable();
        this.providers_.add((AuthProvider) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addProviders(int index, AuthProvider.Builder builderForValue) {
        ensureProvidersIsMutable();
        this.providers_.add(index, (AuthProvider) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllProviders(Iterable<? extends AuthProvider> values) {
        ensureProvidersIsMutable();
        AbstractMessageLite.addAll(values, this.providers_);
    }

    /* access modifiers changed from: private */
    public void clearProviders() {
        this.providers_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeProviders(int index) {
        ensureProvidersIsMutable();
        this.providers_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.rules_.size(); i++) {
            output.writeMessage(3, (MessageLite) this.rules_.get(i));
        }
        for (int i2 = 0; i2 < this.providers_.size(); i2++) {
            output.writeMessage(4, (MessageLite) this.providers_.get(i2));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.rules_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.rules_.get(i));
        }
        for (int i2 = 0; i2 < this.providers_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.providers_.get(i2));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Authentication parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Authentication parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Authentication parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Authentication parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Authentication parseFrom(InputStream input) throws IOException {
        return (Authentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Authentication parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Authentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Authentication parseDelimitedFrom(InputStream input) throws IOException {
        return (Authentication) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Authentication parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Authentication) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Authentication parseFrom(CodedInputStream input) throws IOException {
        return (Authentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Authentication parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Authentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Authentication prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Authentication, Builder> implements AuthenticationOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Authentication.DEFAULT_INSTANCE);
        }

        public List<AuthenticationRule> getRulesList() {
            return Collections.unmodifiableList(((Authentication) this.instance).getRulesList());
        }

        public int getRulesCount() {
            return ((Authentication) this.instance).getRulesCount();
        }

        public AuthenticationRule getRules(int index) {
            return ((Authentication) this.instance).getRules(index);
        }

        public Builder setRules(int index, AuthenticationRule value) {
            copyOnWrite();
            ((Authentication) this.instance).setRules(index, value);
            return this;
        }

        public Builder setRules(int index, AuthenticationRule.Builder builderForValue) {
            copyOnWrite();
            ((Authentication) this.instance).setRules(index, builderForValue);
            return this;
        }

        public Builder addRules(AuthenticationRule value) {
            copyOnWrite();
            ((Authentication) this.instance).addRules(value);
            return this;
        }

        public Builder addRules(int index, AuthenticationRule value) {
            copyOnWrite();
            ((Authentication) this.instance).addRules(index, value);
            return this;
        }

        public Builder addRules(AuthenticationRule.Builder builderForValue) {
            copyOnWrite();
            ((Authentication) this.instance).addRules(builderForValue);
            return this;
        }

        public Builder addRules(int index, AuthenticationRule.Builder builderForValue) {
            copyOnWrite();
            ((Authentication) this.instance).addRules(index, builderForValue);
            return this;
        }

        public Builder addAllRules(Iterable<? extends AuthenticationRule> values) {
            copyOnWrite();
            ((Authentication) this.instance).addAllRules(values);
            return this;
        }

        public Builder clearRules() {
            copyOnWrite();
            ((Authentication) this.instance).clearRules();
            return this;
        }

        public Builder removeRules(int index) {
            copyOnWrite();
            ((Authentication) this.instance).removeRules(index);
            return this;
        }

        public List<AuthProvider> getProvidersList() {
            return Collections.unmodifiableList(((Authentication) this.instance).getProvidersList());
        }

        public int getProvidersCount() {
            return ((Authentication) this.instance).getProvidersCount();
        }

        public AuthProvider getProviders(int index) {
            return ((Authentication) this.instance).getProviders(index);
        }

        public Builder setProviders(int index, AuthProvider value) {
            copyOnWrite();
            ((Authentication) this.instance).setProviders(index, value);
            return this;
        }

        public Builder setProviders(int index, AuthProvider.Builder builderForValue) {
            copyOnWrite();
            ((Authentication) this.instance).setProviders(index, builderForValue);
            return this;
        }

        public Builder addProviders(AuthProvider value) {
            copyOnWrite();
            ((Authentication) this.instance).addProviders(value);
            return this;
        }

        public Builder addProviders(int index, AuthProvider value) {
            copyOnWrite();
            ((Authentication) this.instance).addProviders(index, value);
            return this;
        }

        public Builder addProviders(AuthProvider.Builder builderForValue) {
            copyOnWrite();
            ((Authentication) this.instance).addProviders(builderForValue);
            return this;
        }

        public Builder addProviders(int index, AuthProvider.Builder builderForValue) {
            copyOnWrite();
            ((Authentication) this.instance).addProviders(index, builderForValue);
            return this;
        }

        public Builder addAllProviders(Iterable<? extends AuthProvider> values) {
            copyOnWrite();
            ((Authentication) this.instance).addAllProviders(values);
            return this;
        }

        public Builder clearProviders() {
            copyOnWrite();
            ((Authentication) this.instance).clearProviders();
            return this;
        }

        public Builder removeProviders(int index) {
            copyOnWrite();
            ((Authentication) this.instance).removeProviders(index);
            return this;
        }
    }

    /* renamed from: com.google.api.Authentication$1  reason: invalid class name */
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
                return new Authentication();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.rules_.makeImmutable();
                this.providers_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Authentication other = (Authentication) arg1;
                this.rules_ = visitor.visitList(this.rules_, other.rules_);
                this.providers_ = visitor.visitList(this.providers_, other.providers_);
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
                        } else if (tag == 26) {
                            if (!this.rules_.isModifiable()) {
                                this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
                            }
                            this.rules_.add((AuthenticationRule) input.readMessage(AuthenticationRule.parser(), extensionRegistry));
                        } else if (tag == 34) {
                            if (!this.providers_.isModifiable()) {
                                this.providers_ = GeneratedMessageLite.mutableCopy(this.providers_);
                            }
                            this.providers_.add((AuthProvider) input.readMessage(AuthProvider.parser(), extensionRegistry));
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
                    synchronized (Authentication.class) {
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
        Authentication authentication = new Authentication();
        DEFAULT_INSTANCE = authentication;
        authentication.makeImmutable();
    }

    public static Authentication getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Authentication> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
