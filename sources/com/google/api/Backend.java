package com.google.api;

import com.google.api.BackendRule;
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
public final class Backend extends GeneratedMessageLite<Backend, Builder> implements BackendOrBuilder {
    /* access modifiers changed from: private */
    public static final Backend DEFAULT_INSTANCE;
    private static volatile Parser<Backend> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<BackendRule> rules_ = emptyProtobufList();

    private Backend() {
    }

    public List<BackendRule> getRulesList() {
        return this.rules_;
    }

    public List<? extends BackendRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    public int getRulesCount() {
        return this.rules_.size();
    }

    public BackendRule getRules(int index) {
        return (BackendRule) this.rules_.get(index);
    }

    public BackendRuleOrBuilder getRulesOrBuilder(int index) {
        return (BackendRuleOrBuilder) this.rules_.get(index);
    }

    private void ensureRulesIsMutable() {
        if (!this.rules_.isModifiable()) {
            this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
        }
    }

    /* access modifiers changed from: private */
    public void setRules(int index, BackendRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRules(int index, BackendRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.set(index, (BackendRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(BackendRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(int index, BackendRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(BackendRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add((BackendRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(int index, BackendRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add(index, (BackendRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllRules(Iterable<? extends BackendRule> values) {
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

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.rules_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.rules_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.rules_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.rules_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Backend parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Backend) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Backend parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Backend) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Backend parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Backend) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Backend parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Backend) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Backend parseFrom(InputStream input) throws IOException {
        return (Backend) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Backend parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Backend) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Backend parseDelimitedFrom(InputStream input) throws IOException {
        return (Backend) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Backend parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Backend) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Backend parseFrom(CodedInputStream input) throws IOException {
        return (Backend) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Backend parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Backend) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Backend prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Backend, Builder> implements BackendOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Backend.DEFAULT_INSTANCE);
        }

        public List<BackendRule> getRulesList() {
            return Collections.unmodifiableList(((Backend) this.instance).getRulesList());
        }

        public int getRulesCount() {
            return ((Backend) this.instance).getRulesCount();
        }

        public BackendRule getRules(int index) {
            return ((Backend) this.instance).getRules(index);
        }

        public Builder setRules(int index, BackendRule value) {
            copyOnWrite();
            ((Backend) this.instance).setRules(index, value);
            return this;
        }

        public Builder setRules(int index, BackendRule.Builder builderForValue) {
            copyOnWrite();
            ((Backend) this.instance).setRules(index, builderForValue);
            return this;
        }

        public Builder addRules(BackendRule value) {
            copyOnWrite();
            ((Backend) this.instance).addRules(value);
            return this;
        }

        public Builder addRules(int index, BackendRule value) {
            copyOnWrite();
            ((Backend) this.instance).addRules(index, value);
            return this;
        }

        public Builder addRules(BackendRule.Builder builderForValue) {
            copyOnWrite();
            ((Backend) this.instance).addRules(builderForValue);
            return this;
        }

        public Builder addRules(int index, BackendRule.Builder builderForValue) {
            copyOnWrite();
            ((Backend) this.instance).addRules(index, builderForValue);
            return this;
        }

        public Builder addAllRules(Iterable<? extends BackendRule> values) {
            copyOnWrite();
            ((Backend) this.instance).addAllRules(values);
            return this;
        }

        public Builder clearRules() {
            copyOnWrite();
            ((Backend) this.instance).clearRules();
            return this;
        }

        public Builder removeRules(int index) {
            copyOnWrite();
            ((Backend) this.instance).removeRules(index);
            return this;
        }
    }

    /* renamed from: com.google.api.Backend$1  reason: invalid class name */
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
                return new Backend();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.rules_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.rules_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.rules_, ((Backend) arg1).rules_);
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
                        } else if (tag == 10) {
                            if (!this.rules_.isModifiable()) {
                                this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
                            }
                            this.rules_.add((BackendRule) input.readMessage(BackendRule.parser(), extensionRegistry));
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
                    synchronized (Backend.class) {
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
        Backend backend = new Backend();
        DEFAULT_INSTANCE = backend;
        backend.makeImmutable();
    }

    public static Backend getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Backend> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
