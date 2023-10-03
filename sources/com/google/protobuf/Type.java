package com.google.protobuf;

import com.google.protobuf.Field;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Type extends GeneratedMessageLite<Type, Builder> implements TypeOrBuilder {
    /* access modifiers changed from: private */
    public static final Type DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static volatile Parser<Type> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private int bitField0_;
    private Internal.ProtobufList<Field> fields_ = emptyProtobufList();
    private String name_ = "";
    private Internal.ProtobufList<String> oneofs_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<Option> options_ = emptyProtobufList();
    private SourceContext sourceContext_;
    private int syntax_;

    private Type() {
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

    public List<Field> getFieldsList() {
        return this.fields_;
    }

    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    public int getFieldsCount() {
        return this.fields_.size();
    }

    public Field getFields(int index) {
        return (Field) this.fields_.get(index);
    }

    public FieldOrBuilder getFieldsOrBuilder(int index) {
        return (FieldOrBuilder) this.fields_.get(index);
    }

    private void ensureFieldsIsMutable() {
        if (!this.fields_.isModifiable()) {
            this.fields_ = GeneratedMessageLite.mutableCopy(this.fields_);
        }
    }

    /* access modifiers changed from: private */
    public void setFields(int index, Field value) {
        if (value != null) {
            ensureFieldsIsMutable();
            this.fields_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setFields(int index, Field.Builder builderForValue) {
        ensureFieldsIsMutable();
        this.fields_.set(index, (Field) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addFields(Field value) {
        if (value != null) {
            ensureFieldsIsMutable();
            this.fields_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFields(int index, Field value) {
        if (value != null) {
            ensureFieldsIsMutable();
            this.fields_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFields(Field.Builder builderForValue) {
        ensureFieldsIsMutable();
        this.fields_.add((Field) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addFields(int index, Field.Builder builderForValue) {
        ensureFieldsIsMutable();
        this.fields_.add(index, (Field) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllFields(Iterable<? extends Field> values) {
        ensureFieldsIsMutable();
        AbstractMessageLite.addAll(values, this.fields_);
    }

    /* access modifiers changed from: private */
    public void clearFields() {
        this.fields_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeFields(int index) {
        ensureFieldsIsMutable();
        this.fields_.remove(index);
    }

    public List<String> getOneofsList() {
        return this.oneofs_;
    }

    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    public String getOneofs(int index) {
        return (String) this.oneofs_.get(index);
    }

    public ByteString getOneofsBytes(int index) {
        return ByteString.copyFromUtf8((String) this.oneofs_.get(index));
    }

    private void ensureOneofsIsMutable() {
        if (!this.oneofs_.isModifiable()) {
            this.oneofs_ = GeneratedMessageLite.mutableCopy(this.oneofs_);
        }
    }

    /* access modifiers changed from: private */
    public void setOneofs(int index, String value) {
        if (value != null) {
            ensureOneofsIsMutable();
            this.oneofs_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addOneofs(String value) {
        if (value != null) {
            ensureOneofsIsMutable();
            this.oneofs_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllOneofs(Iterable<String> values) {
        ensureOneofsIsMutable();
        AbstractMessageLite.addAll(values, this.oneofs_);
    }

    /* access modifiers changed from: private */
    public void clearOneofs() {
        this.oneofs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addOneofsBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureOneofsIsMutable();
            this.oneofs_.add(value.toStringUtf8());
            return;
        }
        throw null;
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
        for (int i = 0; i < this.fields_.size(); i++) {
            output.writeMessage(2, (MessageLite) this.fields_.get(i));
        }
        for (int i2 = 0; i2 < this.oneofs_.size(); i2++) {
            output.writeString(3, (String) this.oneofs_.get(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            output.writeMessage(4, (MessageLite) this.options_.get(i3));
        }
        if (this.sourceContext_ != null) {
            output.writeMessage(5, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            output.writeEnum(6, this.syntax_);
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
        for (int i = 0; i < this.fields_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.fields_.get(i));
        }
        int dataSize = 0;
        for (int i2 = 0; i2 < this.oneofs_.size(); i2++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.oneofs_.get(i2));
        }
        int size3 = size2 + dataSize + (getOneofsList().size() * 1);
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            size3 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.options_.get(i3));
        }
        if (this.sourceContext_ != null) {
            size3 += CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            size3 += CodedOutputStream.computeEnumSize(6, this.syntax_);
        }
        this.memoizedSerializedSize = size3;
        return size3;
    }

    public static Type parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Type parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Type parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Type parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Type parseFrom(InputStream input) throws IOException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Type parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Type parseDelimitedFrom(InputStream input) throws IOException {
        return (Type) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Type parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Type) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Type parseFrom(CodedInputStream input) throws IOException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Type parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Type prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Type.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((Type) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Type) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Type) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Type) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Type) this.instance).setNameBytes(value);
            return this;
        }

        public List<Field> getFieldsList() {
            return Collections.unmodifiableList(((Type) this.instance).getFieldsList());
        }

        public int getFieldsCount() {
            return ((Type) this.instance).getFieldsCount();
        }

        public Field getFields(int index) {
            return ((Type) this.instance).getFields(index);
        }

        public Builder setFields(int index, Field value) {
            copyOnWrite();
            ((Type) this.instance).setFields(index, value);
            return this;
        }

        public Builder setFields(int index, Field.Builder builderForValue) {
            copyOnWrite();
            ((Type) this.instance).setFields(index, builderForValue);
            return this;
        }

        public Builder addFields(Field value) {
            copyOnWrite();
            ((Type) this.instance).addFields(value);
            return this;
        }

        public Builder addFields(int index, Field value) {
            copyOnWrite();
            ((Type) this.instance).addFields(index, value);
            return this;
        }

        public Builder addFields(Field.Builder builderForValue) {
            copyOnWrite();
            ((Type) this.instance).addFields(builderForValue);
            return this;
        }

        public Builder addFields(int index, Field.Builder builderForValue) {
            copyOnWrite();
            ((Type) this.instance).addFields(index, builderForValue);
            return this;
        }

        public Builder addAllFields(Iterable<? extends Field> values) {
            copyOnWrite();
            ((Type) this.instance).addAllFields(values);
            return this;
        }

        public Builder clearFields() {
            copyOnWrite();
            ((Type) this.instance).clearFields();
            return this;
        }

        public Builder removeFields(int index) {
            copyOnWrite();
            ((Type) this.instance).removeFields(index);
            return this;
        }

        public List<String> getOneofsList() {
            return Collections.unmodifiableList(((Type) this.instance).getOneofsList());
        }

        public int getOneofsCount() {
            return ((Type) this.instance).getOneofsCount();
        }

        public String getOneofs(int index) {
            return ((Type) this.instance).getOneofs(index);
        }

        public ByteString getOneofsBytes(int index) {
            return ((Type) this.instance).getOneofsBytes(index);
        }

        public Builder setOneofs(int index, String value) {
            copyOnWrite();
            ((Type) this.instance).setOneofs(index, value);
            return this;
        }

        public Builder addOneofs(String value) {
            copyOnWrite();
            ((Type) this.instance).addOneofs(value);
            return this;
        }

        public Builder addAllOneofs(Iterable<String> values) {
            copyOnWrite();
            ((Type) this.instance).addAllOneofs(values);
            return this;
        }

        public Builder clearOneofs() {
            copyOnWrite();
            ((Type) this.instance).clearOneofs();
            return this;
        }

        public Builder addOneofsBytes(ByteString value) {
            copyOnWrite();
            ((Type) this.instance).addOneofsBytes(value);
            return this;
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Type) this.instance).getOptionsList());
        }

        public int getOptionsCount() {
            return ((Type) this.instance).getOptionsCount();
        }

        public Option getOptions(int index) {
            return ((Type) this.instance).getOptions(index);
        }

        public Builder setOptions(int index, Option value) {
            copyOnWrite();
            ((Type) this.instance).setOptions(index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Type) this.instance).setOptions(index, builderForValue);
            return this;
        }

        public Builder addOptions(Option value) {
            copyOnWrite();
            ((Type) this.instance).addOptions(value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            copyOnWrite();
            ((Type) this.instance).addOptions(index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            copyOnWrite();
            ((Type) this.instance).addOptions(builderForValue);
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Type) this.instance).addOptions(index, builderForValue);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            copyOnWrite();
            ((Type) this.instance).addAllOptions(values);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Type) this.instance).clearOptions();
            return this;
        }

        public Builder removeOptions(int index) {
            copyOnWrite();
            ((Type) this.instance).removeOptions(index);
            return this;
        }

        public boolean hasSourceContext() {
            return ((Type) this.instance).hasSourceContext();
        }

        public SourceContext getSourceContext() {
            return ((Type) this.instance).getSourceContext();
        }

        public Builder setSourceContext(SourceContext value) {
            copyOnWrite();
            ((Type) this.instance).setSourceContext(value);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builderForValue) {
            copyOnWrite();
            ((Type) this.instance).setSourceContext(builderForValue);
            return this;
        }

        public Builder mergeSourceContext(SourceContext value) {
            copyOnWrite();
            ((Type) this.instance).mergeSourceContext(value);
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            ((Type) this.instance).clearSourceContext();
            return this;
        }

        public int getSyntaxValue() {
            return ((Type) this.instance).getSyntaxValue();
        }

        public Builder setSyntaxValue(int value) {
            copyOnWrite();
            ((Type) this.instance).setSyntaxValue(value);
            return this;
        }

        public Syntax getSyntax() {
            return ((Type) this.instance).getSyntax();
        }

        public Builder setSyntax(Syntax value) {
            copyOnWrite();
            ((Type) this.instance).setSyntax(value);
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((Type) this.instance).clearSyntax();
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Type$1  reason: invalid class name */
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
                return new Type();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fields_.makeImmutable();
                this.oneofs_.makeImmutable();
                this.options_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Type other = (Type) arg1;
                boolean z = true;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.fields_ = visitor.visitList(this.fields_, other.fields_);
                this.oneofs_ = visitor.visitList(this.oneofs_, other.oneofs_);
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
                            if (!this.fields_.isModifiable()) {
                                this.fields_ = GeneratedMessageLite.mutableCopy(this.fields_);
                            }
                            this.fields_.add((Field) input.readMessage(Field.parser(), extensionRegistry));
                        } else if (tag == 26) {
                            String s = input.readStringRequireUtf8();
                            if (!this.oneofs_.isModifiable()) {
                                this.oneofs_ = GeneratedMessageLite.mutableCopy(this.oneofs_);
                            }
                            this.oneofs_.add(s);
                        } else if (tag == 34) {
                            if (!this.options_.isModifiable()) {
                                this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
                            }
                            this.options_.add((Option) input.readMessage(Option.parser(), extensionRegistry));
                        } else if (tag == 42) {
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
                        } else if (tag == 48) {
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
                    synchronized (Type.class) {
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
        Type type = new Type();
        DEFAULT_INSTANCE = type;
        type.makeImmutable();
    }

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Type> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
