package com.google.api;

import com.google.api.HttpRule;
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
public final class Http extends GeneratedMessageLite<Http, Builder> implements HttpOrBuilder {
    /* access modifiers changed from: private */
    public static final Http DEFAULT_INSTANCE;
    public static final int FULLY_DECODE_RESERVED_EXPANSION_FIELD_NUMBER = 2;
    private static volatile Parser<Http> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean fullyDecodeReservedExpansion_;
    private Internal.ProtobufList<HttpRule> rules_ = emptyProtobufList();

    private Http() {
    }

    public List<HttpRule> getRulesList() {
        return this.rules_;
    }

    public List<? extends HttpRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    public int getRulesCount() {
        return this.rules_.size();
    }

    public HttpRule getRules(int index) {
        return (HttpRule) this.rules_.get(index);
    }

    public HttpRuleOrBuilder getRulesOrBuilder(int index) {
        return (HttpRuleOrBuilder) this.rules_.get(index);
    }

    private void ensureRulesIsMutable() {
        if (!this.rules_.isModifiable()) {
            this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
        }
    }

    /* access modifiers changed from: private */
    public void setRules(int index, HttpRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRules(int index, HttpRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.set(index, (HttpRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(HttpRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(int index, HttpRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(HttpRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add((HttpRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(int index, HttpRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add(index, (HttpRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllRules(Iterable<? extends HttpRule> values) {
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

    public boolean getFullyDecodeReservedExpansion() {
        return this.fullyDecodeReservedExpansion_;
    }

    /* access modifiers changed from: private */
    public void setFullyDecodeReservedExpansion(boolean value) {
        this.fullyDecodeReservedExpansion_ = value;
    }

    /* access modifiers changed from: private */
    public void clearFullyDecodeReservedExpansion() {
        this.fullyDecodeReservedExpansion_ = false;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.rules_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.rules_.get(i));
        }
        boolean z = this.fullyDecodeReservedExpansion_;
        if (z) {
            output.writeBool(2, z);
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
        boolean z = this.fullyDecodeReservedExpansion_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(2, z);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Http parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Http parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Http parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Http parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Http parseFrom(InputStream input) throws IOException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Http parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Http parseDelimitedFrom(InputStream input) throws IOException {
        return (Http) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Http parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Http) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Http parseFrom(CodedInputStream input) throws IOException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Http parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Http prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Http, Builder> implements HttpOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Http.DEFAULT_INSTANCE);
        }

        public List<HttpRule> getRulesList() {
            return Collections.unmodifiableList(((Http) this.instance).getRulesList());
        }

        public int getRulesCount() {
            return ((Http) this.instance).getRulesCount();
        }

        public HttpRule getRules(int index) {
            return ((Http) this.instance).getRules(index);
        }

        public Builder setRules(int index, HttpRule value) {
            copyOnWrite();
            ((Http) this.instance).setRules(index, value);
            return this;
        }

        public Builder setRules(int index, HttpRule.Builder builderForValue) {
            copyOnWrite();
            ((Http) this.instance).setRules(index, builderForValue);
            return this;
        }

        public Builder addRules(HttpRule value) {
            copyOnWrite();
            ((Http) this.instance).addRules(value);
            return this;
        }

        public Builder addRules(int index, HttpRule value) {
            copyOnWrite();
            ((Http) this.instance).addRules(index, value);
            return this;
        }

        public Builder addRules(HttpRule.Builder builderForValue) {
            copyOnWrite();
            ((Http) this.instance).addRules(builderForValue);
            return this;
        }

        public Builder addRules(int index, HttpRule.Builder builderForValue) {
            copyOnWrite();
            ((Http) this.instance).addRules(index, builderForValue);
            return this;
        }

        public Builder addAllRules(Iterable<? extends HttpRule> values) {
            copyOnWrite();
            ((Http) this.instance).addAllRules(values);
            return this;
        }

        public Builder clearRules() {
            copyOnWrite();
            ((Http) this.instance).clearRules();
            return this;
        }

        public Builder removeRules(int index) {
            copyOnWrite();
            ((Http) this.instance).removeRules(index);
            return this;
        }

        public boolean getFullyDecodeReservedExpansion() {
            return ((Http) this.instance).getFullyDecodeReservedExpansion();
        }

        public Builder setFullyDecodeReservedExpansion(boolean value) {
            copyOnWrite();
            ((Http) this.instance).setFullyDecodeReservedExpansion(value);
            return this;
        }

        public Builder clearFullyDecodeReservedExpansion() {
            copyOnWrite();
            ((Http) this.instance).clearFullyDecodeReservedExpansion();
            return this;
        }
    }

    /* renamed from: com.google.api.Http$1  reason: invalid class name */
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
                return new Http();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.rules_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Http other = (Http) arg1;
                this.rules_ = visitor.visitList(this.rules_, other.rules_);
                boolean z = this.fullyDecodeReservedExpansion_;
                boolean z2 = other.fullyDecodeReservedExpansion_;
                this.fullyDecodeReservedExpansion_ = visitor.visitBoolean(z, z, z2, z2);
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
                            if (!this.rules_.isModifiable()) {
                                this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
                            }
                            this.rules_.add((HttpRule) input.readMessage(HttpRule.parser(), extensionRegistry));
                        } else if (tag == 16) {
                            this.fullyDecodeReservedExpansion_ = input.readBool();
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
                    synchronized (Http.class) {
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
        Http http = new Http();
        DEFAULT_INSTANCE = http;
        http.makeImmutable();
    }

    public static Http getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Http> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
