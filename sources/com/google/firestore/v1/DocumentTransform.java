package com.google.firestore.v1;

import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class DocumentTransform extends GeneratedMessageLite<DocumentTransform, Builder> implements DocumentTransformOrBuilder {
    /* access modifiers changed from: private */
    public static final DocumentTransform DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile Parser<DocumentTransform> PARSER;
    private int bitField0_;
    private String document_ = "";
    private Internal.ProtobufList<FieldTransform> fieldTransforms_ = emptyProtobufList();

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface FieldTransformOrBuilder extends MessageLiteOrBuilder {
        ArrayValue getAppendMissingElements();

        String getFieldPath();

        ByteString getFieldPathBytes();

        Value getIncrement();

        Value getMaximum();

        Value getMinimum();

        ArrayValue getRemoveAllFromArray();

        FieldTransform.ServerValue getSetToServerValue();

        int getSetToServerValueValue();

        FieldTransform.TransformTypeCase getTransformTypeCase();
    }

    private DocumentTransform() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class FieldTransform extends GeneratedMessageLite<FieldTransform, Builder> implements FieldTransformOrBuilder {
        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        /* access modifiers changed from: private */
        public static final FieldTransform DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile Parser<FieldTransform> PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private String fieldPath_ = "";
        private int transformTypeCase_ = 0;
        private Object transformType_;

        private FieldTransform() {
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public enum ServerValue implements Internal.EnumLite {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);
            
            public static final int REQUEST_TIME_VALUE = 1;
            public static final int SERVER_VALUE_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<ServerValue> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<ServerValue>() {
                    public ServerValue findValueByNumber(int number) {
                        return ServerValue.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ServerValue valueOf(int value2) {
                return forNumber(value2);
            }

            public static ServerValue forNumber(int value2) {
                if (value2 == 0) {
                    return SERVER_VALUE_UNSPECIFIED;
                }
                if (value2 != 1) {
                    return null;
                }
                return REQUEST_TIME;
            }

            public static Internal.EnumLiteMap<ServerValue> internalGetValueMap() {
                return internalValueMap;
            }

            private ServerValue(int value2) {
                this.value = value2;
            }
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public enum TransformTypeCase implements Internal.EnumLite {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);
            
            private final int value;

            private TransformTypeCase(int value2) {
                this.value = value2;
            }

            @Deprecated
            public static TransformTypeCase valueOf(int value2) {
                return forNumber(value2);
            }

            public static TransformTypeCase forNumber(int value2) {
                if (value2 == 0) {
                    return TRANSFORMTYPE_NOT_SET;
                }
                switch (value2) {
                    case 2:
                        return SET_TO_SERVER_VALUE;
                    case 3:
                        return INCREMENT;
                    case 4:
                        return MAXIMUM;
                    case 5:
                        return MINIMUM;
                    case 6:
                        return APPEND_MISSING_ELEMENTS;
                    case 7:
                        return REMOVE_ALL_FROM_ARRAY;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        public TransformTypeCase getTransformTypeCase() {
            return TransformTypeCase.forNumber(this.transformTypeCase_);
        }

        /* access modifiers changed from: private */
        public void clearTransformType() {
            this.transformTypeCase_ = 0;
            this.transformType_ = null;
        }

        public String getFieldPath() {
            return this.fieldPath_;
        }

        public ByteString getFieldPathBytes() {
            return ByteString.copyFromUtf8(this.fieldPath_);
        }

        /* access modifiers changed from: private */
        public void setFieldPath(String value) {
            if (value != null) {
                this.fieldPath_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearFieldPath() {
            this.fieldPath_ = getDefaultInstance().getFieldPath();
        }

        /* access modifiers changed from: private */
        public void setFieldPathBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                this.fieldPath_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public int getSetToServerValueValue() {
            if (this.transformTypeCase_ == 2) {
                return ((Integer) this.transformType_).intValue();
            }
            return 0;
        }

        public ServerValue getSetToServerValue() {
            if (this.transformTypeCase_ != 2) {
                return ServerValue.SERVER_VALUE_UNSPECIFIED;
            }
            ServerValue result = ServerValue.forNumber(((Integer) this.transformType_).intValue());
            return result == null ? ServerValue.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void setSetToServerValueValue(int value) {
            this.transformTypeCase_ = 2;
            this.transformType_ = Integer.valueOf(value);
        }

        /* access modifiers changed from: private */
        public void setSetToServerValue(ServerValue value) {
            if (value != null) {
                this.transformTypeCase_ = 2;
                this.transformType_ = Integer.valueOf(value.getNumber());
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearSetToServerValue() {
            if (this.transformTypeCase_ == 2) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        public Value getIncrement() {
            if (this.transformTypeCase_ == 3) {
                return (Value) this.transformType_;
            }
            return Value.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setIncrement(Value value) {
            if (value != null) {
                this.transformType_ = value;
                this.transformTypeCase_ = 3;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setIncrement(Value.Builder builderForValue) {
            this.transformType_ = builderForValue.build();
            this.transformTypeCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void mergeIncrement(Value value) {
            if (this.transformTypeCase_ != 3 || this.transformType_ == Value.getDefaultInstance()) {
                this.transformType_ = value;
            } else {
                this.transformType_ = ((Value.Builder) Value.newBuilder((Value) this.transformType_).mergeFrom(value)).buildPartial();
            }
            this.transformTypeCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void clearIncrement() {
            if (this.transformTypeCase_ == 3) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        public Value getMaximum() {
            if (this.transformTypeCase_ == 4) {
                return (Value) this.transformType_;
            }
            return Value.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setMaximum(Value value) {
            if (value != null) {
                this.transformType_ = value;
                this.transformTypeCase_ = 4;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setMaximum(Value.Builder builderForValue) {
            this.transformType_ = builderForValue.build();
            this.transformTypeCase_ = 4;
        }

        /* access modifiers changed from: private */
        public void mergeMaximum(Value value) {
            if (this.transformTypeCase_ != 4 || this.transformType_ == Value.getDefaultInstance()) {
                this.transformType_ = value;
            } else {
                this.transformType_ = ((Value.Builder) Value.newBuilder((Value) this.transformType_).mergeFrom(value)).buildPartial();
            }
            this.transformTypeCase_ = 4;
        }

        /* access modifiers changed from: private */
        public void clearMaximum() {
            if (this.transformTypeCase_ == 4) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        public Value getMinimum() {
            if (this.transformTypeCase_ == 5) {
                return (Value) this.transformType_;
            }
            return Value.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setMinimum(Value value) {
            if (value != null) {
                this.transformType_ = value;
                this.transformTypeCase_ = 5;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setMinimum(Value.Builder builderForValue) {
            this.transformType_ = builderForValue.build();
            this.transformTypeCase_ = 5;
        }

        /* access modifiers changed from: private */
        public void mergeMinimum(Value value) {
            if (this.transformTypeCase_ != 5 || this.transformType_ == Value.getDefaultInstance()) {
                this.transformType_ = value;
            } else {
                this.transformType_ = ((Value.Builder) Value.newBuilder((Value) this.transformType_).mergeFrom(value)).buildPartial();
            }
            this.transformTypeCase_ = 5;
        }

        /* access modifiers changed from: private */
        public void clearMinimum() {
            if (this.transformTypeCase_ == 5) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        public ArrayValue getAppendMissingElements() {
            if (this.transformTypeCase_ == 6) {
                return (ArrayValue) this.transformType_;
            }
            return ArrayValue.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setAppendMissingElements(ArrayValue value) {
            if (value != null) {
                this.transformType_ = value;
                this.transformTypeCase_ = 6;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppendMissingElements(ArrayValue.Builder builderForValue) {
            this.transformType_ = builderForValue.build();
            this.transformTypeCase_ = 6;
        }

        /* access modifiers changed from: private */
        public void mergeAppendMissingElements(ArrayValue value) {
            if (this.transformTypeCase_ != 6 || this.transformType_ == ArrayValue.getDefaultInstance()) {
                this.transformType_ = value;
            } else {
                this.transformType_ = ((ArrayValue.Builder) ArrayValue.newBuilder((ArrayValue) this.transformType_).mergeFrom(value)).buildPartial();
            }
            this.transformTypeCase_ = 6;
        }

        /* access modifiers changed from: private */
        public void clearAppendMissingElements() {
            if (this.transformTypeCase_ == 6) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        public ArrayValue getRemoveAllFromArray() {
            if (this.transformTypeCase_ == 7) {
                return (ArrayValue) this.transformType_;
            }
            return ArrayValue.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setRemoveAllFromArray(ArrayValue value) {
            if (value != null) {
                this.transformType_ = value;
                this.transformTypeCase_ = 7;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setRemoveAllFromArray(ArrayValue.Builder builderForValue) {
            this.transformType_ = builderForValue.build();
            this.transformTypeCase_ = 7;
        }

        /* access modifiers changed from: private */
        public void mergeRemoveAllFromArray(ArrayValue value) {
            if (this.transformTypeCase_ != 7 || this.transformType_ == ArrayValue.getDefaultInstance()) {
                this.transformType_ = value;
            } else {
                this.transformType_ = ((ArrayValue.Builder) ArrayValue.newBuilder((ArrayValue) this.transformType_).mergeFrom(value)).buildPartial();
            }
            this.transformTypeCase_ = 7;
        }

        /* access modifiers changed from: private */
        public void clearRemoveAllFromArray() {
            if (this.transformTypeCase_ == 7) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.fieldPath_.isEmpty()) {
                output.writeString(1, getFieldPath());
            }
            if (this.transformTypeCase_ == 2) {
                output.writeEnum(2, ((Integer) this.transformType_).intValue());
            }
            if (this.transformTypeCase_ == 3) {
                output.writeMessage(3, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 4) {
                output.writeMessage(4, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 5) {
                output.writeMessage(5, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 6) {
                output.writeMessage(6, (ArrayValue) this.transformType_);
            }
            if (this.transformTypeCase_ == 7) {
                output.writeMessage(7, (ArrayValue) this.transformType_);
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.fieldPath_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeStringSize(1, getFieldPath());
            }
            if (this.transformTypeCase_ == 2) {
                size2 += CodedOutputStream.computeEnumSize(2, ((Integer) this.transformType_).intValue());
            }
            if (this.transformTypeCase_ == 3) {
                size2 += CodedOutputStream.computeMessageSize(3, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 4) {
                size2 += CodedOutputStream.computeMessageSize(4, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 5) {
                size2 += CodedOutputStream.computeMessageSize(5, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 6) {
                size2 += CodedOutputStream.computeMessageSize(6, (ArrayValue) this.transformType_);
            }
            if (this.transformTypeCase_ == 7) {
                size2 += CodedOutputStream.computeMessageSize(7, (ArrayValue) this.transformType_);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static FieldTransform parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldTransform parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldTransform parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldTransform parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldTransform parseFrom(InputStream input) throws IOException {
            return (FieldTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldTransform parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldTransform parseDelimitedFrom(InputStream input) throws IOException {
            return (FieldTransform) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldTransform parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldTransform) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldTransform parseFrom(CodedInputStream input) throws IOException {
            return (FieldTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldTransform parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldTransform prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldTransform, Builder> implements FieldTransformOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(FieldTransform.DEFAULT_INSTANCE);
            }

            public TransformTypeCase getTransformTypeCase() {
                return ((FieldTransform) this.instance).getTransformTypeCase();
            }

            public Builder clearTransformType() {
                copyOnWrite();
                ((FieldTransform) this.instance).clearTransformType();
                return this;
            }

            public String getFieldPath() {
                return ((FieldTransform) this.instance).getFieldPath();
            }

            public ByteString getFieldPathBytes() {
                return ((FieldTransform) this.instance).getFieldPathBytes();
            }

            public Builder setFieldPath(String value) {
                copyOnWrite();
                ((FieldTransform) this.instance).setFieldPath(value);
                return this;
            }

            public Builder clearFieldPath() {
                copyOnWrite();
                ((FieldTransform) this.instance).clearFieldPath();
                return this;
            }

            public Builder setFieldPathBytes(ByteString value) {
                copyOnWrite();
                ((FieldTransform) this.instance).setFieldPathBytes(value);
                return this;
            }

            public int getSetToServerValueValue() {
                return ((FieldTransform) this.instance).getSetToServerValueValue();
            }

            public Builder setSetToServerValueValue(int value) {
                copyOnWrite();
                ((FieldTransform) this.instance).setSetToServerValueValue(value);
                return this;
            }

            public ServerValue getSetToServerValue() {
                return ((FieldTransform) this.instance).getSetToServerValue();
            }

            public Builder setSetToServerValue(ServerValue value) {
                copyOnWrite();
                ((FieldTransform) this.instance).setSetToServerValue(value);
                return this;
            }

            public Builder clearSetToServerValue() {
                copyOnWrite();
                ((FieldTransform) this.instance).clearSetToServerValue();
                return this;
            }

            public Value getIncrement() {
                return ((FieldTransform) this.instance).getIncrement();
            }

            public Builder setIncrement(Value value) {
                copyOnWrite();
                ((FieldTransform) this.instance).setIncrement(value);
                return this;
            }

            public Builder setIncrement(Value.Builder builderForValue) {
                copyOnWrite();
                ((FieldTransform) this.instance).setIncrement(builderForValue);
                return this;
            }

            public Builder mergeIncrement(Value value) {
                copyOnWrite();
                ((FieldTransform) this.instance).mergeIncrement(value);
                return this;
            }

            public Builder clearIncrement() {
                copyOnWrite();
                ((FieldTransform) this.instance).clearIncrement();
                return this;
            }

            public Value getMaximum() {
                return ((FieldTransform) this.instance).getMaximum();
            }

            public Builder setMaximum(Value value) {
                copyOnWrite();
                ((FieldTransform) this.instance).setMaximum(value);
                return this;
            }

            public Builder setMaximum(Value.Builder builderForValue) {
                copyOnWrite();
                ((FieldTransform) this.instance).setMaximum(builderForValue);
                return this;
            }

            public Builder mergeMaximum(Value value) {
                copyOnWrite();
                ((FieldTransform) this.instance).mergeMaximum(value);
                return this;
            }

            public Builder clearMaximum() {
                copyOnWrite();
                ((FieldTransform) this.instance).clearMaximum();
                return this;
            }

            public Value getMinimum() {
                return ((FieldTransform) this.instance).getMinimum();
            }

            public Builder setMinimum(Value value) {
                copyOnWrite();
                ((FieldTransform) this.instance).setMinimum(value);
                return this;
            }

            public Builder setMinimum(Value.Builder builderForValue) {
                copyOnWrite();
                ((FieldTransform) this.instance).setMinimum(builderForValue);
                return this;
            }

            public Builder mergeMinimum(Value value) {
                copyOnWrite();
                ((FieldTransform) this.instance).mergeMinimum(value);
                return this;
            }

            public Builder clearMinimum() {
                copyOnWrite();
                ((FieldTransform) this.instance).clearMinimum();
                return this;
            }

            public ArrayValue getAppendMissingElements() {
                return ((FieldTransform) this.instance).getAppendMissingElements();
            }

            public Builder setAppendMissingElements(ArrayValue value) {
                copyOnWrite();
                ((FieldTransform) this.instance).setAppendMissingElements(value);
                return this;
            }

            public Builder setAppendMissingElements(ArrayValue.Builder builderForValue) {
                copyOnWrite();
                ((FieldTransform) this.instance).setAppendMissingElements(builderForValue);
                return this;
            }

            public Builder mergeAppendMissingElements(ArrayValue value) {
                copyOnWrite();
                ((FieldTransform) this.instance).mergeAppendMissingElements(value);
                return this;
            }

            public Builder clearAppendMissingElements() {
                copyOnWrite();
                ((FieldTransform) this.instance).clearAppendMissingElements();
                return this;
            }

            public ArrayValue getRemoveAllFromArray() {
                return ((FieldTransform) this.instance).getRemoveAllFromArray();
            }

            public Builder setRemoveAllFromArray(ArrayValue value) {
                copyOnWrite();
                ((FieldTransform) this.instance).setRemoveAllFromArray(value);
                return this;
            }

            public Builder setRemoveAllFromArray(ArrayValue.Builder builderForValue) {
                copyOnWrite();
                ((FieldTransform) this.instance).setRemoveAllFromArray(builderForValue);
                return this;
            }

            public Builder mergeRemoveAllFromArray(ArrayValue value) {
                copyOnWrite();
                ((FieldTransform) this.instance).mergeRemoveAllFromArray(value);
                return this;
            }

            public Builder clearRemoveAllFromArray() {
                copyOnWrite();
                ((FieldTransform) this.instance).clearRemoveAllFromArray();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            int i;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new FieldTransform();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    FieldTransform other = (FieldTransform) arg1;
                    boolean z = true;
                    this.fieldPath_ = visitor.visitString(!this.fieldPath_.isEmpty(), this.fieldPath_, !other.fieldPath_.isEmpty(), other.fieldPath_);
                    switch (AnonymousClass1.$SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[other.getTransformTypeCase().ordinal()]) {
                        case 1:
                            if (this.transformTypeCase_ != 2) {
                                z = false;
                            }
                            this.transformType_ = visitor.visitOneofInt(z, this.transformType_, other.transformType_);
                            break;
                        case 2:
                            if (this.transformTypeCase_ != 3) {
                                z = false;
                            }
                            this.transformType_ = visitor.visitOneofMessage(z, this.transformType_, other.transformType_);
                            break;
                        case 3:
                            if (this.transformTypeCase_ != 4) {
                                z = false;
                            }
                            this.transformType_ = visitor.visitOneofMessage(z, this.transformType_, other.transformType_);
                            break;
                        case 4:
                            if (this.transformTypeCase_ != 5) {
                                z = false;
                            }
                            this.transformType_ = visitor.visitOneofMessage(z, this.transformType_, other.transformType_);
                            break;
                        case 5:
                            if (this.transformTypeCase_ != 6) {
                                z = false;
                            }
                            this.transformType_ = visitor.visitOneofMessage(z, this.transformType_, other.transformType_);
                            break;
                        case 6:
                            if (this.transformTypeCase_ != 7) {
                                z = false;
                            }
                            this.transformType_ = visitor.visitOneofMessage(z, this.transformType_, other.transformType_);
                            break;
                        case 7:
                            if (this.transformTypeCase_ == 0) {
                                z = false;
                            }
                            visitor.visitOneofNotSet(z);
                            break;
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.transformTypeCase_) != 0) {
                        this.transformTypeCase_ = i;
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
                                this.fieldPath_ = input.readStringRequireUtf8();
                            } else if (tag == 16) {
                                int rawValue = input.readEnum();
                                this.transformTypeCase_ = 2;
                                this.transformType_ = Integer.valueOf(rawValue);
                            } else if (tag == 26) {
                                Value.Builder subBuilder = null;
                                if (this.transformTypeCase_ == 3) {
                                    subBuilder = (Value.Builder) ((Value) this.transformType_).toBuilder();
                                }
                                MessageLite readMessage = input.readMessage(Value.parser(), extensionRegistry);
                                this.transformType_ = readMessage;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((Value) readMessage);
                                    this.transformType_ = subBuilder.buildPartial();
                                }
                                this.transformTypeCase_ = 3;
                            } else if (tag == 34) {
                                Value.Builder subBuilder2 = null;
                                if (this.transformTypeCase_ == 4) {
                                    subBuilder2 = (Value.Builder) ((Value) this.transformType_).toBuilder();
                                }
                                MessageLite readMessage2 = input.readMessage(Value.parser(), extensionRegistry);
                                this.transformType_ = readMessage2;
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((Value) readMessage2);
                                    this.transformType_ = subBuilder2.buildPartial();
                                }
                                this.transformTypeCase_ = 4;
                            } else if (tag == 42) {
                                Value.Builder subBuilder3 = null;
                                if (this.transformTypeCase_ == 5) {
                                    subBuilder3 = (Value.Builder) ((Value) this.transformType_).toBuilder();
                                }
                                MessageLite readMessage3 = input.readMessage(Value.parser(), extensionRegistry);
                                this.transformType_ = readMessage3;
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((Value) readMessage3);
                                    this.transformType_ = subBuilder3.buildPartial();
                                }
                                this.transformTypeCase_ = 5;
                            } else if (tag == 50) {
                                ArrayValue.Builder subBuilder4 = null;
                                if (this.transformTypeCase_ == 6) {
                                    subBuilder4 = (ArrayValue.Builder) ((ArrayValue) this.transformType_).toBuilder();
                                }
                                MessageLite readMessage4 = input.readMessage(ArrayValue.parser(), extensionRegistry);
                                this.transformType_ = readMessage4;
                                if (subBuilder4 != null) {
                                    subBuilder4.mergeFrom((ArrayValue) readMessage4);
                                    this.transformType_ = subBuilder4.buildPartial();
                                }
                                this.transformTypeCase_ = 6;
                            } else if (tag == 58) {
                                ArrayValue.Builder subBuilder5 = null;
                                if (this.transformTypeCase_ == 7) {
                                    subBuilder5 = (ArrayValue.Builder) ((ArrayValue) this.transformType_).toBuilder();
                                }
                                MessageLite readMessage5 = input.readMessage(ArrayValue.parser(), extensionRegistry);
                                this.transformType_ = readMessage5;
                                if (subBuilder5 != null) {
                                    subBuilder5.mergeFrom((ArrayValue) readMessage5);
                                    this.transformType_ = subBuilder5.buildPartial();
                                }
                                this.transformTypeCase_ = 7;
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
                        synchronized (FieldTransform.class) {
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
            FieldTransform fieldTransform = new FieldTransform();
            DEFAULT_INSTANCE = fieldTransform;
            fieldTransform.makeImmutable();
        }

        public static FieldTransform getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FieldTransform> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.firestore.v1.DocumentTransform$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase;
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
            int[] iArr2 = new int[FieldTransform.TransformTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase = iArr2;
            try {
                iArr2[FieldTransform.TransformTypeCase.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[FieldTransform.TransformTypeCase.INCREMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[FieldTransform.TransformTypeCase.MAXIMUM.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[FieldTransform.TransformTypeCase.MINIMUM.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[FieldTransform.TransformTypeCase.APPEND_MISSING_ELEMENTS.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[FieldTransform.TransformTypeCase.REMOVE_ALL_FROM_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[FieldTransform.TransformTypeCase.TRANSFORMTYPE_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    public String getDocument() {
        return this.document_;
    }

    public ByteString getDocumentBytes() {
        return ByteString.copyFromUtf8(this.document_);
    }

    /* access modifiers changed from: private */
    public void setDocument(String value) {
        if (value != null) {
            this.document_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = getDefaultInstance().getDocument();
    }

    /* access modifiers changed from: private */
    public void setDocumentBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.document_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<FieldTransform> getFieldTransformsList() {
        return this.fieldTransforms_;
    }

    public List<? extends FieldTransformOrBuilder> getFieldTransformsOrBuilderList() {
        return this.fieldTransforms_;
    }

    public int getFieldTransformsCount() {
        return this.fieldTransforms_.size();
    }

    public FieldTransform getFieldTransforms(int index) {
        return (FieldTransform) this.fieldTransforms_.get(index);
    }

    public FieldTransformOrBuilder getFieldTransformsOrBuilder(int index) {
        return (FieldTransformOrBuilder) this.fieldTransforms_.get(index);
    }

    private void ensureFieldTransformsIsMutable() {
        if (!this.fieldTransforms_.isModifiable()) {
            this.fieldTransforms_ = GeneratedMessageLite.mutableCopy(this.fieldTransforms_);
        }
    }

    /* access modifiers changed from: private */
    public void setFieldTransforms(int index, FieldTransform value) {
        if (value != null) {
            ensureFieldTransformsIsMutable();
            this.fieldTransforms_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setFieldTransforms(int index, FieldTransform.Builder builderForValue) {
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.set(index, (FieldTransform) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addFieldTransforms(FieldTransform value) {
        if (value != null) {
            ensureFieldTransformsIsMutable();
            this.fieldTransforms_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFieldTransforms(int index, FieldTransform value) {
        if (value != null) {
            ensureFieldTransformsIsMutable();
            this.fieldTransforms_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFieldTransforms(FieldTransform.Builder builderForValue) {
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.add((FieldTransform) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addFieldTransforms(int index, FieldTransform.Builder builderForValue) {
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.add(index, (FieldTransform) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllFieldTransforms(Iterable<? extends FieldTransform> values) {
        ensureFieldTransformsIsMutable();
        AbstractMessageLite.addAll(values, this.fieldTransforms_);
    }

    /* access modifiers changed from: private */
    public void clearFieldTransforms() {
        this.fieldTransforms_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeFieldTransforms(int index) {
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.document_.isEmpty()) {
            output.writeString(1, getDocument());
        }
        for (int i = 0; i < this.fieldTransforms_.size(); i++) {
            output.writeMessage(2, (MessageLite) this.fieldTransforms_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.document_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getDocument());
        }
        for (int i = 0; i < this.fieldTransforms_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.fieldTransforms_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static DocumentTransform parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DocumentTransform parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DocumentTransform parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DocumentTransform parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DocumentTransform parseFrom(InputStream input) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentTransform parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DocumentTransform parseDelimitedFrom(InputStream input) throws IOException {
        return (DocumentTransform) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentTransform parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentTransform) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DocumentTransform parseFrom(CodedInputStream input) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentTransform parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentTransform prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentTransform, Builder> implements DocumentTransformOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(DocumentTransform.DEFAULT_INSTANCE);
        }

        public String getDocument() {
            return ((DocumentTransform) this.instance).getDocument();
        }

        public ByteString getDocumentBytes() {
            return ((DocumentTransform) this.instance).getDocumentBytes();
        }

        public Builder setDocument(String value) {
            copyOnWrite();
            ((DocumentTransform) this.instance).setDocument(value);
            return this;
        }

        public Builder clearDocument() {
            copyOnWrite();
            ((DocumentTransform) this.instance).clearDocument();
            return this;
        }

        public Builder setDocumentBytes(ByteString value) {
            copyOnWrite();
            ((DocumentTransform) this.instance).setDocumentBytes(value);
            return this;
        }

        public List<FieldTransform> getFieldTransformsList() {
            return Collections.unmodifiableList(((DocumentTransform) this.instance).getFieldTransformsList());
        }

        public int getFieldTransformsCount() {
            return ((DocumentTransform) this.instance).getFieldTransformsCount();
        }

        public FieldTransform getFieldTransforms(int index) {
            return ((DocumentTransform) this.instance).getFieldTransforms(index);
        }

        public Builder setFieldTransforms(int index, FieldTransform value) {
            copyOnWrite();
            ((DocumentTransform) this.instance).setFieldTransforms(index, value);
            return this;
        }

        public Builder setFieldTransforms(int index, FieldTransform.Builder builderForValue) {
            copyOnWrite();
            ((DocumentTransform) this.instance).setFieldTransforms(index, builderForValue);
            return this;
        }

        public Builder addFieldTransforms(FieldTransform value) {
            copyOnWrite();
            ((DocumentTransform) this.instance).addFieldTransforms(value);
            return this;
        }

        public Builder addFieldTransforms(int index, FieldTransform value) {
            copyOnWrite();
            ((DocumentTransform) this.instance).addFieldTransforms(index, value);
            return this;
        }

        public Builder addFieldTransforms(FieldTransform.Builder builderForValue) {
            copyOnWrite();
            ((DocumentTransform) this.instance).addFieldTransforms(builderForValue);
            return this;
        }

        public Builder addFieldTransforms(int index, FieldTransform.Builder builderForValue) {
            copyOnWrite();
            ((DocumentTransform) this.instance).addFieldTransforms(index, builderForValue);
            return this;
        }

        public Builder addAllFieldTransforms(Iterable<? extends FieldTransform> values) {
            copyOnWrite();
            ((DocumentTransform) this.instance).addAllFieldTransforms(values);
            return this;
        }

        public Builder clearFieldTransforms() {
            copyOnWrite();
            ((DocumentTransform) this.instance).clearFieldTransforms();
            return this;
        }

        public Builder removeFieldTransforms(int index) {
            copyOnWrite();
            ((DocumentTransform) this.instance).removeFieldTransforms(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new DocumentTransform();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fieldTransforms_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                DocumentTransform other = (DocumentTransform) arg1;
                this.document_ = visitor.visitString(!this.document_.isEmpty(), this.document_, !other.document_.isEmpty(), other.document_);
                this.fieldTransforms_ = visitor.visitList(this.fieldTransforms_, other.fieldTransforms_);
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
                            this.document_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            if (!this.fieldTransforms_.isModifiable()) {
                                this.fieldTransforms_ = GeneratedMessageLite.mutableCopy(this.fieldTransforms_);
                            }
                            this.fieldTransforms_.add((FieldTransform) input.readMessage(FieldTransform.parser(), extensionRegistry));
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
                    synchronized (DocumentTransform.class) {
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
        DocumentTransform documentTransform = new DocumentTransform();
        DEFAULT_INSTANCE = documentTransform;
        documentTransform.makeImmutable();
    }

    public static DocumentTransform getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<DocumentTransform> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
