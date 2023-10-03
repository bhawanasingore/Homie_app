package com.google.api;

import com.google.api.SystemParameter;
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
public final class SystemParameterRule extends GeneratedMessageLite<SystemParameterRule, Builder> implements SystemParameterRuleOrBuilder {
    /* access modifiers changed from: private */
    public static final SystemParameterRule DEFAULT_INSTANCE;
    public static final int PARAMETERS_FIELD_NUMBER = 2;
    private static volatile Parser<SystemParameterRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private int bitField0_;
    private Internal.ProtobufList<SystemParameter> parameters_ = emptyProtobufList();
    private String selector_ = "";

    private SystemParameterRule() {
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

    public List<SystemParameter> getParametersList() {
        return this.parameters_;
    }

    public List<? extends SystemParameterOrBuilder> getParametersOrBuilderList() {
        return this.parameters_;
    }

    public int getParametersCount() {
        return this.parameters_.size();
    }

    public SystemParameter getParameters(int index) {
        return (SystemParameter) this.parameters_.get(index);
    }

    public SystemParameterOrBuilder getParametersOrBuilder(int index) {
        return (SystemParameterOrBuilder) this.parameters_.get(index);
    }

    private void ensureParametersIsMutable() {
        if (!this.parameters_.isModifiable()) {
            this.parameters_ = GeneratedMessageLite.mutableCopy(this.parameters_);
        }
    }

    /* access modifiers changed from: private */
    public void setParameters(int index, SystemParameter value) {
        if (value != null) {
            ensureParametersIsMutable();
            this.parameters_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setParameters(int index, SystemParameter.Builder builderForValue) {
        ensureParametersIsMutable();
        this.parameters_.set(index, (SystemParameter) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addParameters(SystemParameter value) {
        if (value != null) {
            ensureParametersIsMutable();
            this.parameters_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addParameters(int index, SystemParameter value) {
        if (value != null) {
            ensureParametersIsMutable();
            this.parameters_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addParameters(SystemParameter.Builder builderForValue) {
        ensureParametersIsMutable();
        this.parameters_.add((SystemParameter) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addParameters(int index, SystemParameter.Builder builderForValue) {
        ensureParametersIsMutable();
        this.parameters_.add(index, (SystemParameter) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllParameters(Iterable<? extends SystemParameter> values) {
        ensureParametersIsMutable();
        AbstractMessageLite.addAll(values, this.parameters_);
    }

    /* access modifiers changed from: private */
    public void clearParameters() {
        this.parameters_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeParameters(int index) {
        ensureParametersIsMutable();
        this.parameters_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.selector_.isEmpty()) {
            output.writeString(1, getSelector());
        }
        for (int i = 0; i < this.parameters_.size(); i++) {
            output.writeMessage(2, (MessageLite) this.parameters_.get(i));
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
        for (int i = 0; i < this.parameters_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.parameters_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static SystemParameterRule parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (SystemParameterRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static SystemParameterRule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (SystemParameterRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static SystemParameterRule parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (SystemParameterRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static SystemParameterRule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (SystemParameterRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static SystemParameterRule parseFrom(InputStream input) throws IOException {
        return (SystemParameterRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static SystemParameterRule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SystemParameterRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static SystemParameterRule parseDelimitedFrom(InputStream input) throws IOException {
        return (SystemParameterRule) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static SystemParameterRule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SystemParameterRule) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static SystemParameterRule parseFrom(CodedInputStream input) throws IOException {
        return (SystemParameterRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static SystemParameterRule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SystemParameterRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SystemParameterRule prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<SystemParameterRule, Builder> implements SystemParameterRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(SystemParameterRule.DEFAULT_INSTANCE);
        }

        public String getSelector() {
            return ((SystemParameterRule) this.instance).getSelector();
        }

        public ByteString getSelectorBytes() {
            return ((SystemParameterRule) this.instance).getSelectorBytes();
        }

        public Builder setSelector(String value) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).setSelector(value);
            return this;
        }

        public Builder clearSelector() {
            copyOnWrite();
            ((SystemParameterRule) this.instance).clearSelector();
            return this;
        }

        public Builder setSelectorBytes(ByteString value) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).setSelectorBytes(value);
            return this;
        }

        public List<SystemParameter> getParametersList() {
            return Collections.unmodifiableList(((SystemParameterRule) this.instance).getParametersList());
        }

        public int getParametersCount() {
            return ((SystemParameterRule) this.instance).getParametersCount();
        }

        public SystemParameter getParameters(int index) {
            return ((SystemParameterRule) this.instance).getParameters(index);
        }

        public Builder setParameters(int index, SystemParameter value) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).setParameters(index, value);
            return this;
        }

        public Builder setParameters(int index, SystemParameter.Builder builderForValue) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).setParameters(index, builderForValue);
            return this;
        }

        public Builder addParameters(SystemParameter value) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).addParameters(value);
            return this;
        }

        public Builder addParameters(int index, SystemParameter value) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).addParameters(index, value);
            return this;
        }

        public Builder addParameters(SystemParameter.Builder builderForValue) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).addParameters(builderForValue);
            return this;
        }

        public Builder addParameters(int index, SystemParameter.Builder builderForValue) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).addParameters(index, builderForValue);
            return this;
        }

        public Builder addAllParameters(Iterable<? extends SystemParameter> values) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).addAllParameters(values);
            return this;
        }

        public Builder clearParameters() {
            copyOnWrite();
            ((SystemParameterRule) this.instance).clearParameters();
            return this;
        }

        public Builder removeParameters(int index) {
            copyOnWrite();
            ((SystemParameterRule) this.instance).removeParameters(index);
            return this;
        }
    }

    /* renamed from: com.google.api.SystemParameterRule$1  reason: invalid class name */
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
                return new SystemParameterRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.parameters_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                SystemParameterRule other = (SystemParameterRule) arg1;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, !other.selector_.isEmpty(), other.selector_);
                this.parameters_ = visitor.visitList(this.parameters_, other.parameters_);
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
                            if (!this.parameters_.isModifiable()) {
                                this.parameters_ = GeneratedMessageLite.mutableCopy(this.parameters_);
                            }
                            this.parameters_.add((SystemParameter) input.readMessage(SystemParameter.parser(), extensionRegistry));
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
                    synchronized (SystemParameterRule.class) {
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
        SystemParameterRule systemParameterRule = new SystemParameterRule();
        DEFAULT_INSTANCE = systemParameterRule;
        systemParameterRule.makeImmutable();
    }

    public static SystemParameterRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SystemParameterRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
