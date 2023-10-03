package com.google.api;

import com.google.api.ContextRule;
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
public final class Context extends GeneratedMessageLite<Context, Builder> implements ContextOrBuilder {
    /* access modifiers changed from: private */
    public static final Context DEFAULT_INSTANCE;
    private static volatile Parser<Context> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<ContextRule> rules_ = emptyProtobufList();

    private Context() {
    }

    public List<ContextRule> getRulesList() {
        return this.rules_;
    }

    public List<? extends ContextRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    public int getRulesCount() {
        return this.rules_.size();
    }

    public ContextRule getRules(int index) {
        return (ContextRule) this.rules_.get(index);
    }

    public ContextRuleOrBuilder getRulesOrBuilder(int index) {
        return (ContextRuleOrBuilder) this.rules_.get(index);
    }

    private void ensureRulesIsMutable() {
        if (!this.rules_.isModifiable()) {
            this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
        }
    }

    /* access modifiers changed from: private */
    public void setRules(int index, ContextRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRules(int index, ContextRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.set(index, (ContextRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(ContextRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(int index, ContextRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(ContextRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add((ContextRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(int index, ContextRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add(index, (ContextRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllRules(Iterable<? extends ContextRule> values) {
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

    public static Context parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Context parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Context parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Context parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Context parseFrom(InputStream input) throws IOException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Context parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Context parseDelimitedFrom(InputStream input) throws IOException {
        return (Context) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Context parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Context) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Context parseFrom(CodedInputStream input) throws IOException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Context parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Context prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Context, Builder> implements ContextOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Context.DEFAULT_INSTANCE);
        }

        public List<ContextRule> getRulesList() {
            return Collections.unmodifiableList(((Context) this.instance).getRulesList());
        }

        public int getRulesCount() {
            return ((Context) this.instance).getRulesCount();
        }

        public ContextRule getRules(int index) {
            return ((Context) this.instance).getRules(index);
        }

        public Builder setRules(int index, ContextRule value) {
            copyOnWrite();
            ((Context) this.instance).setRules(index, value);
            return this;
        }

        public Builder setRules(int index, ContextRule.Builder builderForValue) {
            copyOnWrite();
            ((Context) this.instance).setRules(index, builderForValue);
            return this;
        }

        public Builder addRules(ContextRule value) {
            copyOnWrite();
            ((Context) this.instance).addRules(value);
            return this;
        }

        public Builder addRules(int index, ContextRule value) {
            copyOnWrite();
            ((Context) this.instance).addRules(index, value);
            return this;
        }

        public Builder addRules(ContextRule.Builder builderForValue) {
            copyOnWrite();
            ((Context) this.instance).addRules(builderForValue);
            return this;
        }

        public Builder addRules(int index, ContextRule.Builder builderForValue) {
            copyOnWrite();
            ((Context) this.instance).addRules(index, builderForValue);
            return this;
        }

        public Builder addAllRules(Iterable<? extends ContextRule> values) {
            copyOnWrite();
            ((Context) this.instance).addAllRules(values);
            return this;
        }

        public Builder clearRules() {
            copyOnWrite();
            ((Context) this.instance).clearRules();
            return this;
        }

        public Builder removeRules(int index) {
            copyOnWrite();
            ((Context) this.instance).removeRules(index);
            return this;
        }
    }

    /* renamed from: com.google.api.Context$1  reason: invalid class name */
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
                return new Context();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.rules_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.rules_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.rules_, ((Context) arg1).rules_);
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
                            this.rules_.add((ContextRule) input.readMessage(ContextRule.parser(), extensionRegistry));
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
                    synchronized (Context.class) {
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
        Context context = new Context();
        DEFAULT_INSTANCE = context;
        context.makeImmutable();
    }

    public static Context getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Context> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
