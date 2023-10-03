package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Field extends GeneratedMessageLite<Field, Builder> implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Field DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static volatile Parser<Field> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int bitField0_;
    private int cardinality_;
    private String defaultValue_ = "";
    private String jsonName_ = "";
    private int kind_;
    private String name_ = "";
    private int number_;
    private int oneofIndex_;
    private Internal.ProtobufList<Option> options_ = emptyProtobufList();
    private boolean packed_;
    private String typeUrl_ = "";

    private Field() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum Kind implements Internal.EnumLite {
        TYPE_UNKNOWN(0),
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);
        
        public static final int TYPE_BOOL_VALUE = 8;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final int TYPE_INT32_VALUE = 5;
        public static final int TYPE_INT64_VALUE = 3;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final int TYPE_STRING_VALUE = 9;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<Kind>() {
                public Kind findValueByNumber(int number) {
                    return Kind.forNumber(number);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Kind valueOf(int value2) {
            return forNumber(value2);
        }

        public static Kind forNumber(int value2) {
            switch (value2) {
                case 0:
                    return TYPE_UNKNOWN;
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        private Kind(int value2) {
            this.value = value2;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum Cardinality implements Internal.EnumLite {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);
        
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<Cardinality>() {
                public Cardinality findValueByNumber(int number) {
                    return Cardinality.forNumber(number);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Cardinality valueOf(int value2) {
            return forNumber(value2);
        }

        public static Cardinality forNumber(int value2) {
            if (value2 == 0) {
                return CARDINALITY_UNKNOWN;
            }
            if (value2 == 1) {
                return CARDINALITY_OPTIONAL;
            }
            if (value2 == 2) {
                return CARDINALITY_REQUIRED;
            }
            if (value2 != 3) {
                return null;
            }
            return CARDINALITY_REPEATED;
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        private Cardinality(int value2) {
            this.value = value2;
        }
    }

    public int getKindValue() {
        return this.kind_;
    }

    public Kind getKind() {
        Kind result = Kind.forNumber(this.kind_);
        return result == null ? Kind.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setKindValue(int value) {
        this.kind_ = value;
    }

    /* access modifiers changed from: private */
    public void setKind(Kind value) {
        if (value != null) {
            this.kind_ = value.getNumber();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = 0;
    }

    public int getCardinalityValue() {
        return this.cardinality_;
    }

    public Cardinality getCardinality() {
        Cardinality result = Cardinality.forNumber(this.cardinality_);
        return result == null ? Cardinality.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setCardinalityValue(int value) {
        this.cardinality_ = value;
    }

    /* access modifiers changed from: private */
    public void setCardinality(Cardinality value) {
        if (value != null) {
            this.cardinality_ = value.getNumber();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearCardinality() {
        this.cardinality_ = 0;
    }

    public int getNumber() {
        return this.number_;
    }

    /* access modifiers changed from: private */
    public void setNumber(int value) {
        this.number_ = value;
    }

    /* access modifiers changed from: private */
    public void clearNumber() {
        this.number_ = 0;
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

    public String getTypeUrl() {
        return this.typeUrl_;
    }

    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.typeUrl_);
    }

    /* access modifiers changed from: private */
    public void setTypeUrl(String value) {
        if (value != null) {
            this.typeUrl_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTypeUrl() {
        this.typeUrl_ = getDefaultInstance().getTypeUrl();
    }

    /* access modifiers changed from: private */
    public void setTypeUrlBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.typeUrl_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    /* access modifiers changed from: private */
    public void setOneofIndex(int value) {
        this.oneofIndex_ = value;
    }

    /* access modifiers changed from: private */
    public void clearOneofIndex() {
        this.oneofIndex_ = 0;
    }

    public boolean getPacked() {
        return this.packed_;
    }

    /* access modifiers changed from: private */
    public void setPacked(boolean value) {
        this.packed_ = value;
    }

    /* access modifiers changed from: private */
    public void clearPacked() {
        this.packed_ = false;
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

    public String getJsonName() {
        return this.jsonName_;
    }

    public ByteString getJsonNameBytes() {
        return ByteString.copyFromUtf8(this.jsonName_);
    }

    /* access modifiers changed from: private */
    public void setJsonName(String value) {
        if (value != null) {
            this.jsonName_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearJsonName() {
        this.jsonName_ = getDefaultInstance().getJsonName();
    }

    /* access modifiers changed from: private */
    public void setJsonNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.jsonName_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getDefaultValue() {
        return this.defaultValue_;
    }

    public ByteString getDefaultValueBytes() {
        return ByteString.copyFromUtf8(this.defaultValue_);
    }

    /* access modifiers changed from: private */
    public void setDefaultValue(String value) {
        if (value != null) {
            this.defaultValue_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDefaultValue() {
        this.defaultValue_ = getDefaultInstance().getDefaultValue();
    }

    /* access modifiers changed from: private */
    public void setDefaultValueBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.defaultValue_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.kind_ != Kind.TYPE_UNKNOWN.getNumber()) {
            output.writeEnum(1, this.kind_);
        }
        if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            output.writeEnum(2, this.cardinality_);
        }
        int i = this.number_;
        if (i != 0) {
            output.writeInt32(3, i);
        }
        if (!this.name_.isEmpty()) {
            output.writeString(4, getName());
        }
        if (!this.typeUrl_.isEmpty()) {
            output.writeString(6, getTypeUrl());
        }
        int i2 = this.oneofIndex_;
        if (i2 != 0) {
            output.writeInt32(7, i2);
        }
        boolean z = this.packed_;
        if (z) {
            output.writeBool(8, z);
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            output.writeMessage(9, (MessageLite) this.options_.get(i3));
        }
        if (!this.jsonName_.isEmpty()) {
            output.writeString(10, getJsonName());
        }
        if (!this.defaultValue_.isEmpty()) {
            output.writeString(11, getDefaultValue());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.kind_ != Kind.TYPE_UNKNOWN.getNumber()) {
            size2 = 0 + CodedOutputStream.computeEnumSize(1, this.kind_);
        }
        if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(2, this.cardinality_);
        }
        int i = this.number_;
        if (i != 0) {
            size2 += CodedOutputStream.computeInt32Size(3, i);
        }
        if (!this.name_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(4, getName());
        }
        if (!this.typeUrl_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(6, getTypeUrl());
        }
        int i2 = this.oneofIndex_;
        if (i2 != 0) {
            size2 += CodedOutputStream.computeInt32Size(7, i2);
        }
        boolean z = this.packed_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(8, z);
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            size2 += CodedOutputStream.computeMessageSize(9, (MessageLite) this.options_.get(i3));
        }
        if (!this.jsonName_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(10, getJsonName());
        }
        if (!this.defaultValue_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(11, getDefaultValue());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Field parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Field parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Field parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Field parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Field parseFrom(InputStream input) throws IOException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Field parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Field parseDelimitedFrom(InputStream input) throws IOException {
        return (Field) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Field parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Field) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Field parseFrom(CodedInputStream input) throws IOException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Field parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Field prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Field, Builder> implements FieldOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Field.DEFAULT_INSTANCE);
        }

        public int getKindValue() {
            return ((Field) this.instance).getKindValue();
        }

        public Builder setKindValue(int value) {
            copyOnWrite();
            ((Field) this.instance).setKindValue(value);
            return this;
        }

        public Kind getKind() {
            return ((Field) this.instance).getKind();
        }

        public Builder setKind(Kind value) {
            copyOnWrite();
            ((Field) this.instance).setKind(value);
            return this;
        }

        public Builder clearKind() {
            copyOnWrite();
            ((Field) this.instance).clearKind();
            return this;
        }

        public int getCardinalityValue() {
            return ((Field) this.instance).getCardinalityValue();
        }

        public Builder setCardinalityValue(int value) {
            copyOnWrite();
            ((Field) this.instance).setCardinalityValue(value);
            return this;
        }

        public Cardinality getCardinality() {
            return ((Field) this.instance).getCardinality();
        }

        public Builder setCardinality(Cardinality value) {
            copyOnWrite();
            ((Field) this.instance).setCardinality(value);
            return this;
        }

        public Builder clearCardinality() {
            copyOnWrite();
            ((Field) this.instance).clearCardinality();
            return this;
        }

        public int getNumber() {
            return ((Field) this.instance).getNumber();
        }

        public Builder setNumber(int value) {
            copyOnWrite();
            ((Field) this.instance).setNumber(value);
            return this;
        }

        public Builder clearNumber() {
            copyOnWrite();
            ((Field) this.instance).clearNumber();
            return this;
        }

        public String getName() {
            return ((Field) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Field) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Field) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Field) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Field) this.instance).setNameBytes(value);
            return this;
        }

        public String getTypeUrl() {
            return ((Field) this.instance).getTypeUrl();
        }

        public ByteString getTypeUrlBytes() {
            return ((Field) this.instance).getTypeUrlBytes();
        }

        public Builder setTypeUrl(String value) {
            copyOnWrite();
            ((Field) this.instance).setTypeUrl(value);
            return this;
        }

        public Builder clearTypeUrl() {
            copyOnWrite();
            ((Field) this.instance).clearTypeUrl();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString value) {
            copyOnWrite();
            ((Field) this.instance).setTypeUrlBytes(value);
            return this;
        }

        public int getOneofIndex() {
            return ((Field) this.instance).getOneofIndex();
        }

        public Builder setOneofIndex(int value) {
            copyOnWrite();
            ((Field) this.instance).setOneofIndex(value);
            return this;
        }

        public Builder clearOneofIndex() {
            copyOnWrite();
            ((Field) this.instance).clearOneofIndex();
            return this;
        }

        public boolean getPacked() {
            return ((Field) this.instance).getPacked();
        }

        public Builder setPacked(boolean value) {
            copyOnWrite();
            ((Field) this.instance).setPacked(value);
            return this;
        }

        public Builder clearPacked() {
            copyOnWrite();
            ((Field) this.instance).clearPacked();
            return this;
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Field) this.instance).getOptionsList());
        }

        public int getOptionsCount() {
            return ((Field) this.instance).getOptionsCount();
        }

        public Option getOptions(int index) {
            return ((Field) this.instance).getOptions(index);
        }

        public Builder setOptions(int index, Option value) {
            copyOnWrite();
            ((Field) this.instance).setOptions(index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Field) this.instance).setOptions(index, builderForValue);
            return this;
        }

        public Builder addOptions(Option value) {
            copyOnWrite();
            ((Field) this.instance).addOptions(value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            copyOnWrite();
            ((Field) this.instance).addOptions(index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            copyOnWrite();
            ((Field) this.instance).addOptions(builderForValue);
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Field) this.instance).addOptions(index, builderForValue);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            copyOnWrite();
            ((Field) this.instance).addAllOptions(values);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Field) this.instance).clearOptions();
            return this;
        }

        public Builder removeOptions(int index) {
            copyOnWrite();
            ((Field) this.instance).removeOptions(index);
            return this;
        }

        public String getJsonName() {
            return ((Field) this.instance).getJsonName();
        }

        public ByteString getJsonNameBytes() {
            return ((Field) this.instance).getJsonNameBytes();
        }

        public Builder setJsonName(String value) {
            copyOnWrite();
            ((Field) this.instance).setJsonName(value);
            return this;
        }

        public Builder clearJsonName() {
            copyOnWrite();
            ((Field) this.instance).clearJsonName();
            return this;
        }

        public Builder setJsonNameBytes(ByteString value) {
            copyOnWrite();
            ((Field) this.instance).setJsonNameBytes(value);
            return this;
        }

        public String getDefaultValue() {
            return ((Field) this.instance).getDefaultValue();
        }

        public ByteString getDefaultValueBytes() {
            return ((Field) this.instance).getDefaultValueBytes();
        }

        public Builder setDefaultValue(String value) {
            copyOnWrite();
            ((Field) this.instance).setDefaultValue(value);
            return this;
        }

        public Builder clearDefaultValue() {
            copyOnWrite();
            ((Field) this.instance).clearDefaultValue();
            return this;
        }

        public Builder setDefaultValueBytes(ByteString value) {
            copyOnWrite();
            ((Field) this.instance).setDefaultValueBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Field$1  reason: invalid class name */
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
                return new Field();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.options_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Field other = (Field) arg1;
                boolean z = false;
                this.kind_ = visitor.visitInt(this.kind_ != 0, this.kind_, other.kind_ != 0, other.kind_);
                this.cardinality_ = visitor.visitInt(this.cardinality_ != 0, this.cardinality_, other.cardinality_ != 0, other.cardinality_);
                this.number_ = visitor.visitInt(this.number_ != 0, this.number_, other.number_ != 0, other.number_);
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.typeUrl_ = visitor.visitString(!this.typeUrl_.isEmpty(), this.typeUrl_, !other.typeUrl_.isEmpty(), other.typeUrl_);
                boolean z2 = this.oneofIndex_ != 0;
                int i = this.oneofIndex_;
                if (other.oneofIndex_ != 0) {
                    z = true;
                }
                this.oneofIndex_ = visitor.visitInt(z2, i, z, other.oneofIndex_);
                boolean z3 = this.packed_;
                boolean z4 = other.packed_;
                this.packed_ = visitor.visitBoolean(z3, z3, z4, z4);
                this.options_ = visitor.visitList(this.options_, other.options_);
                this.jsonName_ = visitor.visitString(!this.jsonName_.isEmpty(), this.jsonName_, !other.jsonName_.isEmpty(), other.jsonName_);
                this.defaultValue_ = visitor.visitString(!this.defaultValue_.isEmpty(), this.defaultValue_, true ^ other.defaultValue_.isEmpty(), other.defaultValue_);
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
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.kind_ = input.readEnum();
                                break;
                            case 16:
                                this.cardinality_ = input.readEnum();
                                break;
                            case 24:
                                this.number_ = input.readInt32();
                                break;
                            case 34:
                                this.name_ = input.readStringRequireUtf8();
                                break;
                            case 50:
                                this.typeUrl_ = input.readStringRequireUtf8();
                                break;
                            case 56:
                                this.oneofIndex_ = input.readInt32();
                                break;
                            case 64:
                                this.packed_ = input.readBool();
                                break;
                            case 74:
                                if (!this.options_.isModifiable()) {
                                    this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
                                }
                                this.options_.add((Option) input.readMessage(Option.parser(), extensionRegistry));
                                break;
                            case 82:
                                this.jsonName_ = input.readStringRequireUtf8();
                                break;
                            case 90:
                                this.defaultValue_ = input.readStringRequireUtf8();
                                break;
                            default:
                                if (input.skipField(tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
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
                    synchronized (Field.class) {
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
        Field field = new Field();
        DEFAULT_INSTANCE = field;
        field.makeImmutable();
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Field> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
