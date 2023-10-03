package com.google.firestore.v1;

import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    /* access modifiers changed from: private */
    public static final Value DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile Parser<Value> PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    private Value() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ValueTypeCase implements Internal.EnumLite {
        NULL_VALUE(11),
        BOOLEAN_VALUE(1),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(18),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(8),
        ARRAY_VALUE(9),
        MAP_VALUE(6),
        VALUETYPE_NOT_SET(0);
        
        private final int value;

        private ValueTypeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static ValueTypeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static ValueTypeCase forNumber(int value2) {
            if (value2 == 0) {
                return VALUETYPE_NOT_SET;
            }
            if (value2 == 1) {
                return BOOLEAN_VALUE;
            }
            if (value2 == 2) {
                return INTEGER_VALUE;
            }
            if (value2 == 3) {
                return DOUBLE_VALUE;
            }
            if (value2 == 5) {
                return REFERENCE_VALUE;
            }
            if (value2 == 6) {
                return MAP_VALUE;
            }
            if (value2 == 17) {
                return STRING_VALUE;
            }
            if (value2 == 18) {
                return BYTES_VALUE;
            }
            switch (value2) {
                case 8:
                    return GEO_POINT_VALUE;
                case 9:
                    return ARRAY_VALUE;
                case 10:
                    return TIMESTAMP_VALUE;
                case 11:
                    return NULL_VALUE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ValueTypeCase getValueTypeCase() {
        return ValueTypeCase.forNumber(this.valueTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearValueType() {
        this.valueTypeCase_ = 0;
        this.valueType_ = null;
    }

    public int getNullValueValue() {
        if (this.valueTypeCase_ == 11) {
            return ((Integer) this.valueType_).intValue();
        }
        return 0;
    }

    public NullValue getNullValue() {
        if (this.valueTypeCase_ != 11) {
            return NullValue.NULL_VALUE;
        }
        NullValue result = NullValue.forNumber(((Integer) this.valueType_).intValue());
        return result == null ? NullValue.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setNullValueValue(int value) {
        this.valueTypeCase_ = 11;
        this.valueType_ = Integer.valueOf(value);
    }

    /* access modifiers changed from: private */
    public void setNullValue(NullValue value) {
        if (value != null) {
            this.valueTypeCase_ = 11;
            this.valueType_ = Integer.valueOf(value.getNumber());
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearNullValue() {
        if (this.valueTypeCase_ == 11) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public boolean getBooleanValue() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void setBooleanValue(boolean value) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(value);
    }

    /* access modifiers changed from: private */
    public void clearBooleanValue() {
        if (this.valueTypeCase_ == 1) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public long getIntegerValue() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void setIntegerValue(long value) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(value);
    }

    /* access modifiers changed from: private */
    public void clearIntegerValue() {
        if (this.valueTypeCase_ == 2) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public double getDoubleValue() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }

    /* access modifiers changed from: private */
    public void setDoubleValue(double value) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(value);
    }

    /* access modifiers changed from: private */
    public void clearDoubleValue() {
        if (this.valueTypeCase_ == 3) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public Timestamp getTimestampValue() {
        if (this.valueTypeCase_ == 10) {
            return (Timestamp) this.valueType_;
        }
        return Timestamp.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setTimestampValue(Timestamp value) {
        if (value != null) {
            this.valueType_ = value;
            this.valueTypeCase_ = 10;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setTimestampValue(Timestamp.Builder builderForValue) {
        this.valueType_ = builderForValue.build();
        this.valueTypeCase_ = 10;
    }

    /* access modifiers changed from: private */
    public void mergeTimestampValue(Timestamp value) {
        if (this.valueTypeCase_ != 10 || this.valueType_ == Timestamp.getDefaultInstance()) {
            this.valueType_ = value;
        } else {
            this.valueType_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.valueType_).mergeFrom(value)).buildPartial();
        }
        this.valueTypeCase_ = 10;
    }

    /* access modifiers changed from: private */
    public void clearTimestampValue() {
        if (this.valueTypeCase_ == 10) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public String getStringValue() {
        if (this.valueTypeCase_ == 17) {
            return (String) this.valueType_;
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
            int r1 = r3.valueTypeCase_
            r2 = 17
            if (r1 != r2) goto L_0x000d
            java.lang.Object r1 = r3.valueType_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000d:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Value.getStringValueBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setStringValue(String value) {
        if (value != null) {
            this.valueTypeCase_ = 17;
            this.valueType_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearStringValue() {
        if (this.valueTypeCase_ == 17) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setStringValueBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.valueTypeCase_ = 17;
            this.valueType_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public ByteString getBytesValue() {
        if (this.valueTypeCase_ == 18) {
            return (ByteString) this.valueType_;
        }
        return ByteString.EMPTY;
    }

    /* access modifiers changed from: private */
    public void setBytesValue(ByteString value) {
        if (value != null) {
            this.valueTypeCase_ = 18;
            this.valueType_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearBytesValue() {
        if (this.valueTypeCase_ == 18) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public String getReferenceValue() {
        if (this.valueTypeCase_ == 5) {
            return (String) this.valueType_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getReferenceValueBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.valueTypeCase_
            r2 = 5
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.valueType_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Value.getReferenceValueBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setReferenceValue(String value) {
        if (value != null) {
            this.valueTypeCase_ = 5;
            this.valueType_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearReferenceValue() {
        if (this.valueTypeCase_ == 5) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setReferenceValueBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.valueTypeCase_ = 5;
            this.valueType_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public LatLng getGeoPointValue() {
        if (this.valueTypeCase_ == 8) {
            return (LatLng) this.valueType_;
        }
        return LatLng.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setGeoPointValue(LatLng value) {
        if (value != null) {
            this.valueType_ = value;
            this.valueTypeCase_ = 8;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setGeoPointValue(LatLng.Builder builderForValue) {
        this.valueType_ = builderForValue.build();
        this.valueTypeCase_ = 8;
    }

    /* access modifiers changed from: private */
    public void mergeGeoPointValue(LatLng value) {
        if (this.valueTypeCase_ != 8 || this.valueType_ == LatLng.getDefaultInstance()) {
            this.valueType_ = value;
        } else {
            this.valueType_ = ((LatLng.Builder) LatLng.newBuilder((LatLng) this.valueType_).mergeFrom(value)).buildPartial();
        }
        this.valueTypeCase_ = 8;
    }

    /* access modifiers changed from: private */
    public void clearGeoPointValue() {
        if (this.valueTypeCase_ == 8) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public ArrayValue getArrayValue() {
        if (this.valueTypeCase_ == 9) {
            return (ArrayValue) this.valueType_;
        }
        return ArrayValue.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setArrayValue(ArrayValue value) {
        if (value != null) {
            this.valueType_ = value;
            this.valueTypeCase_ = 9;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setArrayValue(ArrayValue.Builder builderForValue) {
        this.valueType_ = builderForValue.build();
        this.valueTypeCase_ = 9;
    }

    /* access modifiers changed from: private */
    public void mergeArrayValue(ArrayValue value) {
        if (this.valueTypeCase_ != 9 || this.valueType_ == ArrayValue.getDefaultInstance()) {
            this.valueType_ = value;
        } else {
            this.valueType_ = ((ArrayValue.Builder) ArrayValue.newBuilder((ArrayValue) this.valueType_).mergeFrom(value)).buildPartial();
        }
        this.valueTypeCase_ = 9;
    }

    /* access modifiers changed from: private */
    public void clearArrayValue() {
        if (this.valueTypeCase_ == 9) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public MapValue getMapValue() {
        if (this.valueTypeCase_ == 6) {
            return (MapValue) this.valueType_;
        }
        return MapValue.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setMapValue(MapValue value) {
        if (value != null) {
            this.valueType_ = value;
            this.valueTypeCase_ = 6;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setMapValue(MapValue.Builder builderForValue) {
        this.valueType_ = builderForValue.build();
        this.valueTypeCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void mergeMapValue(MapValue value) {
        if (this.valueTypeCase_ != 6 || this.valueType_ == MapValue.getDefaultInstance()) {
            this.valueType_ = value;
        } else {
            this.valueType_ = ((MapValue.Builder) MapValue.newBuilder((MapValue) this.valueType_).mergeFrom(value)).buildPartial();
        }
        this.valueTypeCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void clearMapValue() {
        if (this.valueTypeCase_ == 6) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.valueTypeCase_ == 1) {
            output.writeBool(1, ((Boolean) this.valueType_).booleanValue());
        }
        if (this.valueTypeCase_ == 2) {
            output.writeInt64(2, ((Long) this.valueType_).longValue());
        }
        if (this.valueTypeCase_ == 3) {
            output.writeDouble(3, ((Double) this.valueType_).doubleValue());
        }
        if (this.valueTypeCase_ == 5) {
            output.writeString(5, getReferenceValue());
        }
        if (this.valueTypeCase_ == 6) {
            output.writeMessage(6, (MapValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 8) {
            output.writeMessage(8, (LatLng) this.valueType_);
        }
        if (this.valueTypeCase_ == 9) {
            output.writeMessage(9, (ArrayValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 10) {
            output.writeMessage(10, (Timestamp) this.valueType_);
        }
        if (this.valueTypeCase_ == 11) {
            output.writeEnum(11, ((Integer) this.valueType_).intValue());
        }
        if (this.valueTypeCase_ == 17) {
            output.writeString(17, getStringValue());
        }
        if (this.valueTypeCase_ == 18) {
            output.writeBytes(18, (ByteString) this.valueType_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.valueTypeCase_ == 1) {
            size2 = 0 + CodedOutputStream.computeBoolSize(1, ((Boolean) this.valueType_).booleanValue());
        }
        if (this.valueTypeCase_ == 2) {
            size2 += CodedOutputStream.computeInt64Size(2, ((Long) this.valueType_).longValue());
        }
        if (this.valueTypeCase_ == 3) {
            size2 += CodedOutputStream.computeDoubleSize(3, ((Double) this.valueType_).doubleValue());
        }
        if (this.valueTypeCase_ == 5) {
            size2 += CodedOutputStream.computeStringSize(5, getReferenceValue());
        }
        if (this.valueTypeCase_ == 6) {
            size2 += CodedOutputStream.computeMessageSize(6, (MapValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 8) {
            size2 += CodedOutputStream.computeMessageSize(8, (LatLng) this.valueType_);
        }
        if (this.valueTypeCase_ == 9) {
            size2 += CodedOutputStream.computeMessageSize(9, (ArrayValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 10) {
            size2 += CodedOutputStream.computeMessageSize(10, (Timestamp) this.valueType_);
        }
        if (this.valueTypeCase_ == 11) {
            size2 += CodedOutputStream.computeEnumSize(11, ((Integer) this.valueType_).intValue());
        }
        if (this.valueTypeCase_ == 17) {
            size2 += CodedOutputStream.computeStringSize(17, getStringValue());
        }
        if (this.valueTypeCase_ == 18) {
            size2 += CodedOutputStream.computeBytesSize(18, (ByteString) this.valueType_);
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

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Value.DEFAULT_INSTANCE);
        }

        public ValueTypeCase getValueTypeCase() {
            return ((Value) this.instance).getValueTypeCase();
        }

        public Builder clearValueType() {
            copyOnWrite();
            ((Value) this.instance).clearValueType();
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

        public boolean getBooleanValue() {
            return ((Value) this.instance).getBooleanValue();
        }

        public Builder setBooleanValue(boolean value) {
            copyOnWrite();
            ((Value) this.instance).setBooleanValue(value);
            return this;
        }

        public Builder clearBooleanValue() {
            copyOnWrite();
            ((Value) this.instance).clearBooleanValue();
            return this;
        }

        public long getIntegerValue() {
            return ((Value) this.instance).getIntegerValue();
        }

        public Builder setIntegerValue(long value) {
            copyOnWrite();
            ((Value) this.instance).setIntegerValue(value);
            return this;
        }

        public Builder clearIntegerValue() {
            copyOnWrite();
            ((Value) this.instance).clearIntegerValue();
            return this;
        }

        public double getDoubleValue() {
            return ((Value) this.instance).getDoubleValue();
        }

        public Builder setDoubleValue(double value) {
            copyOnWrite();
            ((Value) this.instance).setDoubleValue(value);
            return this;
        }

        public Builder clearDoubleValue() {
            copyOnWrite();
            ((Value) this.instance).clearDoubleValue();
            return this;
        }

        public Timestamp getTimestampValue() {
            return ((Value) this.instance).getTimestampValue();
        }

        public Builder setTimestampValue(Timestamp value) {
            copyOnWrite();
            ((Value) this.instance).setTimestampValue(value);
            return this;
        }

        public Builder setTimestampValue(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((Value) this.instance).setTimestampValue(builderForValue);
            return this;
        }

        public Builder mergeTimestampValue(Timestamp value) {
            copyOnWrite();
            ((Value) this.instance).mergeTimestampValue(value);
            return this;
        }

        public Builder clearTimestampValue() {
            copyOnWrite();
            ((Value) this.instance).clearTimestampValue();
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

        public ByteString getBytesValue() {
            return ((Value) this.instance).getBytesValue();
        }

        public Builder setBytesValue(ByteString value) {
            copyOnWrite();
            ((Value) this.instance).setBytesValue(value);
            return this;
        }

        public Builder clearBytesValue() {
            copyOnWrite();
            ((Value) this.instance).clearBytesValue();
            return this;
        }

        public String getReferenceValue() {
            return ((Value) this.instance).getReferenceValue();
        }

        public ByteString getReferenceValueBytes() {
            return ((Value) this.instance).getReferenceValueBytes();
        }

        public Builder setReferenceValue(String value) {
            copyOnWrite();
            ((Value) this.instance).setReferenceValue(value);
            return this;
        }

        public Builder clearReferenceValue() {
            copyOnWrite();
            ((Value) this.instance).clearReferenceValue();
            return this;
        }

        public Builder setReferenceValueBytes(ByteString value) {
            copyOnWrite();
            ((Value) this.instance).setReferenceValueBytes(value);
            return this;
        }

        public LatLng getGeoPointValue() {
            return ((Value) this.instance).getGeoPointValue();
        }

        public Builder setGeoPointValue(LatLng value) {
            copyOnWrite();
            ((Value) this.instance).setGeoPointValue(value);
            return this;
        }

        public Builder setGeoPointValue(LatLng.Builder builderForValue) {
            copyOnWrite();
            ((Value) this.instance).setGeoPointValue(builderForValue);
            return this;
        }

        public Builder mergeGeoPointValue(LatLng value) {
            copyOnWrite();
            ((Value) this.instance).mergeGeoPointValue(value);
            return this;
        }

        public Builder clearGeoPointValue() {
            copyOnWrite();
            ((Value) this.instance).clearGeoPointValue();
            return this;
        }

        public ArrayValue getArrayValue() {
            return ((Value) this.instance).getArrayValue();
        }

        public Builder setArrayValue(ArrayValue value) {
            copyOnWrite();
            ((Value) this.instance).setArrayValue(value);
            return this;
        }

        public Builder setArrayValue(ArrayValue.Builder builderForValue) {
            copyOnWrite();
            ((Value) this.instance).setArrayValue(builderForValue);
            return this;
        }

        public Builder mergeArrayValue(ArrayValue value) {
            copyOnWrite();
            ((Value) this.instance).mergeArrayValue(value);
            return this;
        }

        public Builder clearArrayValue() {
            copyOnWrite();
            ((Value) this.instance).clearArrayValue();
            return this;
        }

        public MapValue getMapValue() {
            return ((Value) this.instance).getMapValue();
        }

        public Builder setMapValue(MapValue value) {
            copyOnWrite();
            ((Value) this.instance).setMapValue(value);
            return this;
        }

        public Builder setMapValue(MapValue.Builder builderForValue) {
            copyOnWrite();
            ((Value) this.instance).setMapValue(builderForValue);
            return this;
        }

        public Builder mergeMapValue(MapValue value) {
            copyOnWrite();
            ((Value) this.instance).mergeMapValue(value);
            return this;
        }

        public Builder clearMapValue() {
            copyOnWrite();
            ((Value) this.instance).clearMapValue();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.Value$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase;
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
            int[] iArr2 = new int[ValueTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase = iArr2;
            try {
                iArr2[ValueTypeCase.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[ValueTypeCase.VALUETYPE_NOT_SET.ordinal()] = 12;
            } catch (NoSuchFieldError e20) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        int i2 = 18;
        int i3 = 11;
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
                switch (AnonymousClass1.$SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[other.getValueTypeCase().ordinal()]) {
                    case 1:
                        if (this.valueTypeCase_ != 11) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofInt(z, this.valueType_, other.valueType_);
                        break;
                    case 2:
                        if (this.valueTypeCase_ != 1) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofBoolean(z, this.valueType_, other.valueType_);
                        break;
                    case 3:
                        if (this.valueTypeCase_ != 2) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofLong(z, this.valueType_, other.valueType_);
                        break;
                    case 4:
                        if (this.valueTypeCase_ != 3) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofDouble(z, this.valueType_, other.valueType_);
                        break;
                    case 5:
                        if (this.valueTypeCase_ != 10) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofMessage(z, this.valueType_, other.valueType_);
                        break;
                    case 6:
                        if (this.valueTypeCase_ != 17) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofString(z, this.valueType_, other.valueType_);
                        break;
                    case 7:
                        if (this.valueTypeCase_ != 18) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofByteString(z, this.valueType_, other.valueType_);
                        break;
                    case 8:
                        if (this.valueTypeCase_ != 5) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofString(z, this.valueType_, other.valueType_);
                        break;
                    case 9:
                        if (this.valueTypeCase_ != 8) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofMessage(z, this.valueType_, other.valueType_);
                        break;
                    case 10:
                        if (this.valueTypeCase_ != 9) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofMessage(z, this.valueType_, other.valueType_);
                        break;
                    case 11:
                        if (this.valueTypeCase_ != 6) {
                            z = false;
                        }
                        this.valueType_ = visitor.visitOneofMessage(z, this.valueType_, other.valueType_);
                        break;
                    case 12:
                        if (this.valueTypeCase_ == 0) {
                            z = false;
                        }
                        visitor.visitOneofNotSet(z);
                        break;
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.valueTypeCase_) != 0) {
                    this.valueTypeCase_ = i;
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
                                this.valueTypeCase_ = 1;
                                this.valueType_ = Boolean.valueOf(input.readBool());
                                break;
                            case 16:
                                this.valueTypeCase_ = 2;
                                this.valueType_ = Long.valueOf(input.readInt64());
                                break;
                            case 25:
                                this.valueTypeCase_ = 3;
                                this.valueType_ = Double.valueOf(input.readDouble());
                                break;
                            case 42:
                                String s = input.readStringRequireUtf8();
                                this.valueTypeCase_ = 5;
                                this.valueType_ = s;
                                break;
                            case 50:
                                MapValue.Builder subBuilder = null;
                                if (this.valueTypeCase_ == 6) {
                                    subBuilder = (MapValue.Builder) ((MapValue) this.valueType_).toBuilder();
                                }
                                MessageLite readMessage = input.readMessage(MapValue.parser(), extensionRegistry);
                                this.valueType_ = readMessage;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((MapValue) readMessage);
                                    this.valueType_ = subBuilder.buildPartial();
                                }
                                this.valueTypeCase_ = 6;
                                break;
                            case 66:
                                LatLng.Builder subBuilder2 = null;
                                if (this.valueTypeCase_ == 8) {
                                    subBuilder2 = (LatLng.Builder) ((LatLng) this.valueType_).toBuilder();
                                }
                                MessageLite readMessage2 = input.readMessage(LatLng.parser(), extensionRegistry);
                                this.valueType_ = readMessage2;
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((LatLng) readMessage2);
                                    this.valueType_ = subBuilder2.buildPartial();
                                }
                                this.valueTypeCase_ = 8;
                                break;
                            case 74:
                                ArrayValue.Builder subBuilder3 = null;
                                if (this.valueTypeCase_ == 9) {
                                    subBuilder3 = (ArrayValue.Builder) ((ArrayValue) this.valueType_).toBuilder();
                                }
                                MessageLite readMessage3 = input.readMessage(ArrayValue.parser(), extensionRegistry);
                                this.valueType_ = readMessage3;
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((ArrayValue) readMessage3);
                                    this.valueType_ = subBuilder3.buildPartial();
                                }
                                this.valueTypeCase_ = 9;
                                break;
                            case 82:
                                Timestamp.Builder subBuilder4 = null;
                                if (this.valueTypeCase_ == 10) {
                                    subBuilder4 = (Timestamp.Builder) ((Timestamp) this.valueType_).toBuilder();
                                }
                                MessageLite readMessage4 = input.readMessage(Timestamp.parser(), extensionRegistry);
                                this.valueType_ = readMessage4;
                                if (subBuilder4 != null) {
                                    subBuilder4.mergeFrom((Timestamp) readMessage4);
                                    this.valueType_ = subBuilder4.buildPartial();
                                }
                                this.valueTypeCase_ = 10;
                                break;
                            case 88:
                                int rawValue = input.readEnum();
                                this.valueTypeCase_ = i3;
                                this.valueType_ = Integer.valueOf(rawValue);
                                break;
                            case 138:
                                String s2 = input.readStringRequireUtf8();
                                this.valueTypeCase_ = 17;
                                this.valueType_ = s2;
                                break;
                            case 146:
                                this.valueTypeCase_ = i2;
                                this.valueType_ = input.readBytes();
                                break;
                            default:
                                if (input.skipField(tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        i2 = 18;
                        i3 = 11;
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
