package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */
    public static final Value DEFAULT_INSTANCE;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<Value> PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private int kindCase_ = 0;
    private Object kind_;

    private Value() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum KindCase implements Internal.EnumLite {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);
        
        private final int value;

        private KindCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static KindCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static KindCase forNumber(int value2) {
            switch (value2) {
                case 0:
                    return KIND_NOT_SET;
                case 1:
                    return NULL_VALUE;
                case 2:
                    return NUMBER_VALUE;
                case 3:
                    return STRING_VALUE;
                case 4:
                    return BOOL_VALUE;
                case 5:
                    return STRUCT_VALUE;
                case 6:
                    return LIST_VALUE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    /* access modifiers changed from: private */
    public void clearKind() {
        this.kindCase_ = 0;
        this.kind_ = null;
    }

    public int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return ((Integer) this.kind_).intValue();
        }
        return 0;
    }

    public NullValue getNullValue() {
        if (this.kindCase_ != 1) {
            return NullValue.NULL_VALUE;
        }
        NullValue result = NullValue.forNumber(((Integer) this.kind_).intValue());
        return result == null ? NullValue.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setNullValueValue(int value) {
        this.kindCase_ = 1;
        this.kind_ = Integer.valueOf(value);
    }

    /* access modifiers changed from: private */
    public void setNullValue(NullValue value) {
        if (value != null) {
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(value.getNumber());
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearNullValue() {
        if (this.kindCase_ == 1) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    public double getNumberValue() {
        if (this.kindCase_ == 2) {
            return ((Double) this.kind_).doubleValue();
        }
        return 0.0d;
    }

    /* access modifiers changed from: private */
    public void setNumberValue(double value) {
        this.kindCase_ = 2;
        this.kind_ = Double.valueOf(value);
    }

    /* access modifiers changed from: private */
    public void clearNumberValue() {
        if (this.kindCase_ == 2) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    public String getStringValue() {
        if (this.kindCase_ == 3) {
            return (String) this.kind_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getStringValueBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.kindCase_
            r2 = 3
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.kind_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Value.getStringValueBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setStringValue(String value) {
        if (value != null) {
            this.kindCase_ = 3;
            this.kind_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearStringValue() {
        if (this.kindCase_ == 3) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setStringValueBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.kindCase_ = 3;
            this.kind_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public boolean getBoolValue() {
        if (this.kindCase_ == 4) {
            return ((Boolean) this.kind_).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void setBoolValue(boolean value) {
        this.kindCase_ = 4;
        this.kind_ = Boolean.valueOf(value);
    }

    /* access modifiers changed from: private */
    public void clearBoolValue() {
        if (this.kindCase_ == 4) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    public Struct getStructValue() {
        if (this.kindCase_ == 5) {
            return (Struct) this.kind_;
        }
        return Struct.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setStructValue(Struct value) {
        if (value != null) {
            this.kind_ = value;
            this.kindCase_ = 5;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setStructValue(Struct.Builder builderForValue) {
        this.kind_ = builderForValue.build();
        this.kindCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void mergeStructValue(Struct value) {
        if (this.kindCase_ != 5 || this.kind_ == Struct.getDefaultInstance()) {
            this.kind_ = value;
        } else {
            this.kind_ = ((Struct.Builder) Struct.newBuilder((Struct) this.kind_).mergeFrom(value)).buildPartial();
        }
        this.kindCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void clearStructValue() {
        if (this.kindCase_ == 5) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    public ListValue getListValue() {
        if (this.kindCase_ == 6) {
            return (ListValue) this.kind_;
        }
        return ListValue.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setListValue(ListValue value) {
        if (value != null) {
            this.kind_ = value;
            this.kindCase_ = 6;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setListValue(ListValue.Builder builderForValue) {
        this.kind_ = builderForValue.build();
        this.kindCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void mergeListValue(ListValue value) {
        if (this.kindCase_ != 6 || this.kind_ == ListValue.getDefaultInstance()) {
            this.kind_ = value;
        } else {
            this.kind_ = ((ListValue.Builder) ListValue.newBuilder((ListValue) this.kind_).mergeFrom(value)).buildPartial();
        }
        this.kindCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void clearListValue() {
        if (this.kindCase_ == 6) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.kindCase_ == 1) {
            output.writeEnum(1, ((Integer) this.kind_).intValue());
        }
        if (this.kindCase_ == 2) {
            output.writeDouble(2, ((Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            output.writeString(3, getStringValue());
        }
        if (this.kindCase_ == 4) {
            output.writeBool(4, ((Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            output.writeMessage(5, (Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            output.writeMessage(6, (ListValue) this.kind_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.kindCase_ == 1) {
            size2 = 0 + CodedOutputStream.computeEnumSize(1, ((Integer) this.kind_).intValue());
        }
        if (this.kindCase_ == 2) {
            size2 += CodedOutputStream.computeDoubleSize(2, ((Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            size2 += CodedOutputStream.computeStringSize(3, getStringValue());
        }
        if (this.kindCase_ == 4) {
            size2 += CodedOutputStream.computeBoolSize(4, ((Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            size2 += CodedOutputStream.computeMessageSize(5, (Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            size2 += CodedOutputStream.computeMessageSize(6, (ListValue) this.kind_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Value parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Value parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Value parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Value parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Value parseFrom(InputStream input) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Value parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Value parseDelimitedFrom(InputStream input) throws IOException {
        return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Value parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Value parseFrom(CodedInputStream input) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Value parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Value prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Value.DEFAULT_INSTANCE);
        }

        public KindCase getKindCase() {
            return ((Value) this.instance).getKindCase();
        }

        public Builder clearKind() {
            copyOnWrite();
            ((Value) this.instance).clearKind();
            return this;
        }

        public int getNullValueValue() {
            return ((Value) this.instance).getNullValueValue();
        }

        public Builder setNullValueValue(int value) {
            copyOnWrite();
            ((Value) this.instance).setNullValueValue(value);
            return this;
        }

        public NullValue getNullValue() {
            return ((Value) this.instance).getNullValue();
        }

        public Builder setNullValue(NullValue value) {
            copyOnWrite();
            ((Value) this.instance).setNullValue(value);
            return this;
        }

        public Builder clearNullValue() {
            copyOnWrite();
            ((Value) this.instance).clearNullValue();
            return this;
        }

        public double getNumberValue() {
            return ((Value) this.instance).getNumberValue();
        }

        public Builder setNumberValue(double value) {
            copyOnWrite();
            ((Value) this.instance).setNumberValue(value);
            return this;
        }

        public Builder clearNumberValue() {
            copyOnWrite();
            ((Value) this.instance).clearNumberValue();
            return this;
        }

        public String getStringValue() {
            return ((Value) this.instance).getStringValue();
        }

        public ByteString getStringValueBytes() {
            return ((Value) this.instance).getStringValueBytes();
        }

        public Builder setStringValue(String value) {
            copyOnWrite();
            ((Value) this.instance).setStringValue(value);
            return this;
        }

        public Builder clearStringValue() {
            copyOnWrite();
            ((Value) this.instance).clearStringValue();
            return this;
        }

        public Builder setStringValueBytes(ByteString value) {
            copyOnWrite();
            ((Value) this.instance).setStringValueBytes(value);
            return this;
        }

        public boolean getBoolValue() {
            return ((Value) this.instance).getBoolValue();
        }

        public Builder setBoolValue(boolean value) {
            copyOnWrite();
            ((Value) this.instance).setBoolValue(value);
            return this;
        }

        public Builder clearBoolValue() {
            copyOnWrite();
            ((Value) this.instance).clearBoolValue();
            return this;
        }

        public Struct getStructValue() {
            return ((Value) this.instance).getStructValue();
        }

        public Builder setStructValue(Struct value) {
            copyOnWrite();
            ((Value) this.instance).setStructValue(value);
            return this;
        }

        public Builder setStructValue(Struct.Builder builderForValue) {
            copyOnWrite();
            ((Value) this.instance).setStructValue(builderForValue);
            return this;
        }

        public Builder mergeStructValue(Struct value) {
            copyOnWrite();
            ((Value) this.instance).mergeStructValue(value);
            return this;
        }

        public Builder clearStructValue() {
            copyOnWrite();
            ((Value) this.instance).clearStructValue();
            return this;
        }

        public ListValue getListValue() {
            return ((Value) this.instance).getListValue();
        }

        public Builder setListValue(ListValue value) {
            copyOnWrite();
            ((Value) this.instance).setListValue(value);
            return this;
        }

        public Builder setListValue(ListValue.Builder builderForValue) {
            copyOnWrite();
            ((Value) this.instance).setListValue(builderForValue);
            return this;
        }

        public Builder mergeListValue(ListValue value) {
            copyOnWrite();
            ((Value) this.instance).mergeListValue(value);
            return this;
        }

        public Builder clearListValue() {
            copyOnWrite();
            ((Value) this.instance).clearListValue();
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Value$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Value$KindCase;

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
            int[] iArr2 = new int[KindCase.values().length];
            $SwitchMap$com$google$protobuf$Value$KindCase = iArr2;
            try {
                iArr2[KindCase.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.NUMBER_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.STRING_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.BOOL_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.STRUCT_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.LIST_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.KIND_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        boolean z = true;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Value();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Value other = (Value) arg1;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Value$KindCase[other.getKindCase().ordinal()]) {
                    case 1:
                        if (this.kindCase_ != 1) {
                            z = false;
                        }
                        this.kind_ = visitor.visitOneofInt(z, this.kind_, other.kind_);
                        break;
                    case 2:
                        if (this.kindCase_ != 2) {
                            z = false;
                        }
                        this.kind_ = visitor.visitOneofDouble(z, this.kind_, other.kind_);
                        break;
                    case 3:
                        if (this.kindCase_ != 3) {
                            z = false;
                        }
                        this.kind_ = visitor.visitOneofString(z, this.kind_, other.kind_);
                        break;
                    case 4:
                        if (this.kindCase_ != 4) {
                            z = false;
                        }
                        this.kind_ = visitor.visitOneofBoolean(z, this.kind_, other.kind_);
                        break;
                    case 5:
                        if (this.kindCase_ != 5) {
                            z = false;
                        }
                        this.kind_ = visitor.visitOneofMessage(z, this.kind_, other.kind_);
                        break;
                    case 6:
                        if (this.kindCase_ != 6) {
                            z = false;
                        }
                        this.kind_ = visitor.visitOneofMessage(z, this.kind_, other.kind_);
                        break;
                    case 7:
                        if (this.kindCase_ == 0) {
                            z = false;
                        }
                        visitor.visitOneofNotSet(z);
                        break;
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.kindCase_) != 0) {
                    this.kindCase_ = i;
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
                        } else if (tag == 8) {
                            int rawValue = input.readEnum();
                            this.kindCase_ = 1;
                            this.kind_ = Integer.valueOf(rawValue);
                        } else if (tag == 17) {
                            this.kindCase_ = 2;
                            this.kind_ = Double.valueOf(input.readDouble());
                        } else if (tag == 26) {
                            String s = input.readStringRequireUtf8();
                            this.kindCase_ = 3;
                            this.kind_ = s;
                        } else if (tag == 32) {
                            this.kindCase_ = 4;
                            this.kind_ = Boolean.valueOf(input.readBool());
                        } else if (tag == 42) {
                            Struct.Builder subBuilder = null;
                            if (this.kindCase_ == 5) {
                                subBuilder = (Struct.Builder) ((Struct) this.kind_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(Struct.parser(), extensionRegistry);
                            this.kind_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((Struct) readMessage);
                                this.kind_ = subBuilder.buildPartial();
                            }
                            this.kindCase_ = 5;
                        } else if (tag == 50) {
                            ListValue.Builder subBuilder2 = null;
                            if (this.kindCase_ == 6) {
                                subBuilder2 = (ListValue.Builder) ((ListValue) this.kind_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(ListValue.parser(), extensionRegistry);
                            this.kind_ = readMessage2;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((ListValue) readMessage2);
                                this.kind_ = subBuilder2.buildPartial();
                            }
                            this.kindCase_ = 6;
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
                    synchronized (Value.class) {
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
        Value value = new Value();
        DEFAULT_INSTANCE = value;
        value.makeImmutable();
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Value> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
