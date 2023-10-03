package com.google.protobuf;

import com.google.protobuf.EnumValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Enum extends GeneratedMessageLite<Enum, Builder> implements EnumOrBuilder {
    /* access modifiers changed from: private */
    public static final Enum DEFAULT_INSTANCE;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Enum> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private int bitField0_;
    private Internal.ProtobufList<EnumValue> enumvalue_ = emptyProtobufList();
    private String name_ = "";
    private Internal.ProtobufList<Option> options_ = emptyProtobufList();
    private SourceContext sourceContext_;
    private int syntax_;

    private Enum() {
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* access modifiers changed from: private */
    public void setName(String value) {
        if (value != null) {
            this.name_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    public void setNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.name_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    public EnumValue getEnumvalue(int index) {
        return (EnumValue) this.enumvalue_.get(index);
    }

    public EnumValueOrBuilder getEnumvalueOrBuilder(int index) {
        return (EnumValueOrBuilder) this.enumvalue_.get(index);
    }

    private void ensureEnumvalueIsMutable() {
        if (!this.enumvalue_.isModifiable()) {
            this.enumvalue_ = GeneratedMessageLite.mutableCopy(this.enumvalue_);
        }
    }

    /* access modifiers changed from: private */
    public void setEnumvalue(int index, EnumValue value) {
        if (value != null) {
            ensureEnumvalueIsMutable();
            this.enumvalue_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setEnumvalue(int index, EnumValue.Builder builderForValue) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.set(index, (EnumValue) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addEnumvalue(EnumValue value) {
        if (value != null) {
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addEnumvalue(int index, EnumValue value) {
        if (value != null) {
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addEnumvalue(EnumValue.Builder builderForValue) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.add((EnumValue) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addEnumvalue(int index, EnumValue.Builder builderForValue) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.add(index, (EnumValue) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllEnumvalue(Iterable<? extends EnumValue> values) {
        ensureEnumvalueIsMutable();
        AbstractMessageLite.addAll(values, this.enumvalue_);
    }

    /* access modifiers changed from: private */
    public void clearEnumvalue() {
        this.enumvalue_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeEnumvalue(int index) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.remove(index);
    }

    public List<Option> getOptionsList() {
        return this.options_;
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public Option getOptions(int index) {
        return (Option) this.options_.get(index);
    }

    public OptionOrBuilder getOptionsOrBuilder(int index) {
        return (OptionOrBuilder) this.options_.get(index);
    }

    private void ensureOptionsIsMutable() {
        if (!this.options_.isModifiable()) {
            this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
        }
    }

    /* access modifiers changed from: private */
    public void setOptions(int index, Option value) {
        if (value != null) {
            ensureOptionsIsMutable();
            this.options_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setOptions(int index, Option.Builder builderForValue) {
        ensureOptionsIsMutable();
        this.options_.set(index, (Option) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addOptions(Option value) {
        if (value != null) {
            ensureOptionsIsMutable();
            this.options_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addOptions(int index, Option value) {
        if (value != null) {
            ensureOptionsIsMutable();
            this.options_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addOptions(Option.Builder builderForValue) {
        ensureOptionsIsMutable();
        this.options_.add((Option) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addOptions(int index, Option.Builder builderForValue) {
        ensureOptionsIsMutable();
        this.options_.add(index, (Option) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> values) {
        ensureOptionsIsMutable();
        AbstractMessageLite.addAll(values, this.options_);
    }

    /* access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeOptions(int index) {
        ensureOptionsIsMutable();
        this.options_.remove(index);
    }

    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    /* access modifiers changed from: private */
    public void setSourceContext(SourceContext value) {
        if (value != null) {
            this.sourceContext_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setSourceContext(SourceContext.Builder builderForValue) {
        this.sourceContext_ = (SourceContext) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeSourceContext(SourceContext value) {
        SourceContext sourceContext = this.sourceContext_;
        if (sourceContext == null || sourceContext == SourceContext.getDefaultInstance()) {
            this.sourceContext_ = value;
        } else {
            this.sourceContext_ = (SourceContext) ((SourceContext.Builder) SourceContext.newBuilder(this.sourceContext_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearSourceContext() {
        this.sourceContext_ = null;
    }

    public int getSyntaxValue() {
        return this.syntax_;
    }

    public Syntax getSyntax() {
        Syntax result = Syntax.forNumber(this.syntax_);
        return result == null ? Syntax.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setSyntaxValue(int value) {
        this.syntax_ = value;
    }

    /* access modifiers changed from: private */
    public void setSyntax(Syntax value) {
        if (value != null) {
            this.syntax_ = value.getNumber();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearSyntax() {
        this.syntax_ = 0;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        for (int i = 0; i < this.enumvalue_.size(); i++) {
            output.writeMessage(2, (MessageLite) this.enumvalue_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            output.writeMessage(3, (MessageLite) this.options_.get(i2));
        }
        if (this.sourceContext_ != null) {
            output.writeMessage(4, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            output.writeEnum(5, this.syntax_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.name_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getName());
        }
        for (int i = 0; i < this.enumvalue_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.enumvalue_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.options_.get(i2));
        }
        if (this.sourceContext_ != null) {
            size2 += CodedOutputStream.computeMessageSize(4, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(5, this.syntax_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Enum parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Enum parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Enum parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Enum parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Enum parseFrom(InputStream input) throws IOException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Enum parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Enum parseDelimitedFrom(InputStream input) throws IOException {
        return (Enum) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Enum parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Enum) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Enum parseFrom(CodedInputStream input) throws IOException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Enum parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Enum prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Enum, Builder> implements EnumOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Enum.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((Enum) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Enum) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Enum) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Enum) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Enum) this.instance).setNameBytes(value);
            return this;
        }

        public List<EnumValue> getEnumvalueList() {
            return Collections.unmodifiableList(((Enum) this.instance).getEnumvalueList());
        }

        public int getEnumvalueCount() {
            return ((Enum) this.instance).getEnumvalueCount();
        }

        public EnumValue getEnumvalue(int index) {
            return ((Enum) this.instance).getEnumvalue(index);
        }

        public Builder setEnumvalue(int index, EnumValue value) {
            copyOnWrite();
            ((Enum) this.instance).setEnumvalue(index, value);
            return this;
        }

        public Builder setEnumvalue(int index, EnumValue.Builder builderForValue) {
            copyOnWrite();
            ((Enum) this.instance).setEnumvalue(index, builderForValue);
            return this;
        }

        public Builder addEnumvalue(EnumValue value) {
            copyOnWrite();
            ((Enum) this.instance).addEnumvalue(value);
            return this;
        }

        public Builder addEnumvalue(int index, EnumValue value) {
            copyOnWrite();
            ((Enum) this.instance).addEnumvalue(index, value);
            return this;
        }

        public Builder addEnumvalue(EnumValue.Builder builderForValue) {
            copyOnWrite();
            ((Enum) this.instance).addEnumvalue(builderForValue);
            return this;
        }

        public Builder addEnumvalue(int index, EnumValue.Builder builderForValue) {
            copyOnWrite();
            ((Enum) this.instance).addEnumvalue(index, builderForValue);
            return this;
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> values) {
            copyOnWrite();
            ((Enum) this.instance).addAllEnumvalue(values);
            return this;
        }

        public Builder clearEnumvalue() {
            copyOnWrite();
            ((Enum) this.instance).clearEnumvalue();
            return this;
        }

        public Builder removeEnumvalue(int index) {
            copyOnWrite();
            ((Enum) this.instance).removeEnumvalue(index);
            return this;
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Enum) this.instance).getOptionsList());
        }

        public int getOptionsCount() {
            return ((Enum) this.instance).getOptionsCount();
        }

        public Option getOptions(int index) {
            return ((Enum) this.instance).getOptions(index);
        }

        public Builder setOptions(int index, Option value) {
            copyOnWrite();
            ((Enum) this.instance).setOptions(index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Enum) this.instance).setOptions(index, builderForValue);
            return this;
        }

        public Builder addOptions(Option value) {
            copyOnWrite();
            ((Enum) this.instance).addOptions(value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            copyOnWrite();
            ((Enum) this.instance).addOptions(index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            copyOnWrite();
            ((Enum) this.instance).addOptions(builderForValue);
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Enum) this.instance).addOptions(index, builderForValue);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            copyOnWrite();
            ((Enum) this.instance).addAllOptions(values);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Enum) this.instance).clearOptions();
            return this;
        }

        public Builder removeOptions(int index) {
            copyOnWrite();
            ((Enum) this.instance).removeOptions(index);
            return this;
        }

        public boolean hasSourceContext() {
            return ((Enum) this.instance).hasSourceContext();
        }

        public SourceContext getSourceContext() {
            return ((Enum) this.instance).getSourceContext();
        }

        public Builder setSourceContext(SourceContext value) {
            copyOnWrite();
            ((Enum) this.instance).setSourceContext(value);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builderForValue) {
            copyOnWrite();
            ((Enum) this.instance).setSourceContext(builderForValue);
            return this;
        }

        public Builder mergeSourceContext(SourceContext value) {
            copyOnWrite();
            ((Enum) this.instance).mergeSourceContext(value);
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            ((Enum) this.instance).clearSourceContext();
            return this;
        }

        public int getSyntaxValue() {
            return ((Enum) this.instance).getSyntaxValue();
        }

        public Builder setSyntaxValue(int value) {
            copyOnWrite();
            ((Enum) this.instance).setSyntaxValue(value);
            return this;
        }

        public Syntax getSyntax() {
            return ((Enum) this.instance).getSyntax();
        }

        public Builder setSyntax(Syntax value) {
            copyOnWrite();
            ((Enum) this.instance).setSyntax(value);
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((Enum) this.instance).clearSyntax();
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Enum$1  reason: invalid class name */
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
                return new Enum();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.enumvalue_.makeImmutable();
                this.options_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Enum other = (Enum) arg1;
                boolean z = true;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.enumvalue_ = visitor.visitList(this.enumvalue_, other.enumvalue_);
                this.options_ = visitor.visitList(this.options_, other.options_);
                this.sourceContext_ = (SourceContext) visitor.visitMessage(this.sourceContext_, other.sourceContext_);
                boolean z2 = this.syntax_ != 0;
                int i = this.syntax_;
                if (other.syntax_ == 0) {
                    z = false;
                }
                this.syntax_ = visitor.visitInt(z2, i, z, other.syntax_);
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
                            this.name_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            if (!this.enumvalue_.isModifiable()) {
                                this.enumvalue_ = GeneratedMessageLite.mutableCopy(this.enumvalue_);
                            }
                            this.enumvalue_.add((EnumValue) input.readMessage(EnumValue.parser(), extensionRegistry));
                        } else if (tag == 26) {
                            if (!this.options_.isModifiable()) {
                                this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
                            }
                            this.options_.add((Option) input.readMessage(Option.parser(), extensionRegistry));
                        } else if (tag == 34) {
                            SourceContext.Builder subBuilder = null;
                            if (this.sourceContext_ != null) {
                                subBuilder = (SourceContext.Builder) this.sourceContext_.toBuilder();
                            }
                            SourceContext sourceContext = (SourceContext) input.readMessage(SourceContext.parser(), extensionRegistry);
                            this.sourceContext_ = sourceContext;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(sourceContext);
                                this.sourceContext_ = (SourceContext) subBuilder.buildPartial();
                            }
                        } else if (tag == 40) {
                            this.syntax_ = input.readEnum();
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
                    synchronized (Enum.class) {
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
        Enum enumR = new Enum();
        DEFAULT_INSTANCE = enumR;
        enumR.makeImmutable();
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Enum> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
