package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class LabelDescriptor extends GeneratedMessageLite<LabelDescriptor, Builder> implements LabelDescriptorOrBuilder {
    /* access modifiers changed from: private */
    public static final LabelDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile Parser<LabelDescriptor> PARSER = null;
    public static final int VALUE_TYPE_FIELD_NUMBER = 2;
    private String description_ = "";
    private String key_ = "";
    private int valueType_;

    private LabelDescriptor() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum ValueType implements Internal.EnumLite {
        STRING(0),
        BOOL(1),
        INT64(2),
        UNRECOGNIZED(-1);
        
        public static final int BOOL_VALUE = 1;
        public static final int INT64_VALUE = 2;
        public static final int STRING_VALUE = 0;
        private static final Internal.EnumLiteMap<ValueType> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<ValueType>() {
                public ValueType findValueByNumber(int number) {
                    return ValueType.forNumber(number);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ValueType valueOf(int value2) {
            return forNumber(value2);
        }

        public static ValueType forNumber(int value2) {
            if (value2 == 0) {
                return STRING;
            }
            if (value2 == 1) {
                return BOOL;
            }
            if (value2 != 2) {
                return null;
            }
            return INT64;
        }

        public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
            return internalValueMap;
        }

        private ValueType(int value2) {
            this.value = value2;
        }
    }

    public String getKey() {
        return this.key_;
    }

    public ByteString getKeyBytes() {
        return ByteString.copyFromUtf8(this.key_);
    }

    /* access modifiers changed from: private */
    public void setKey(String value) {
        if (value != null) {
            this.key_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    /* access modifiers changed from: private */
    public void setKeyBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.key_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public int getValueTypeValue() {
        return this.valueType_;
    }

    public ValueType getValueType() {
        ValueType result = ValueType.forNumber(this.valueType_);
        return result == null ? ValueType.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setValueTypeValue(int value) {
        this.valueType_ = value;
    }

    /* access modifiers changed from: private */
    public void setValueType(ValueType value) {
        if (value != null) {
            this.valueType_ = value.getNumber();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearValueType() {
        this.valueType_ = 0;
    }

    public String getDescription() {
        return this.description_;
    }

    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    /* access modifiers changed from: private */
    public void setDescription(String value) {
        if (value != null) {
            this.description_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* access modifiers changed from: private */
    public void setDescriptionBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.description_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.key_.isEmpty()) {
            output.writeString(1, getKey());
        }
        if (this.valueType_ != ValueType.STRING.getNumber()) {
            output.writeEnum(2, this.valueType_);
        }
        if (!this.description_.isEmpty()) {
            output.writeString(3, getDescription());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.key_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getKey());
        }
        if (this.valueType_ != ValueType.STRING.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(2, this.valueType_);
        }
        if (!this.description_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getDescription());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static LabelDescriptor parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (LabelDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LabelDescriptor parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LabelDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LabelDescriptor parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (LabelDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LabelDescriptor parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LabelDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LabelDescriptor parseFrom(InputStream input) throws IOException {
        return (LabelDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LabelDescriptor parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LabelDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LabelDescriptor parseDelimitedFrom(InputStream input) throws IOException {
        return (LabelDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static LabelDescriptor parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LabelDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LabelDescriptor parseFrom(CodedInputStream input) throws IOException {
        return (LabelDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LabelDescriptor parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LabelDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LabelDescriptor prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<LabelDescriptor, Builder> implements LabelDescriptorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(LabelDescriptor.DEFAULT_INSTANCE);
        }

        public String getKey() {
            return ((LabelDescriptor) this.instance).getKey();
        }

        public ByteString getKeyBytes() {
            return ((LabelDescriptor) this.instance).getKeyBytes();
        }

        public Builder setKey(String value) {
            copyOnWrite();
            ((LabelDescriptor) this.instance).setKey(value);
            return this;
        }

        public Builder clearKey() {
            copyOnWrite();
            ((LabelDescriptor) this.instance).clearKey();
            return this;
        }

        public Builder setKeyBytes(ByteString value) {
            copyOnWrite();
            ((LabelDescriptor) this.instance).setKeyBytes(value);
            return this;
        }

        public int getValueTypeValue() {
            return ((LabelDescriptor) this.instance).getValueTypeValue();
        }

        public Builder setValueTypeValue(int value) {
            copyOnWrite();
            ((LabelDescriptor) this.instance).setValueTypeValue(value);
            return this;
        }

        public ValueType getValueType() {
            return ((LabelDescriptor) this.instance).getValueType();
        }

        public Builder setValueType(ValueType value) {
            copyOnWrite();
            ((LabelDescriptor) this.instance).setValueType(value);
            return this;
        }

        public Builder clearValueType() {
            copyOnWrite();
            ((LabelDescriptor) this.instance).clearValueType();
            return this;
        }

        public String getDescription() {
            return ((LabelDescriptor) this.instance).getDescription();
        }

        public ByteString getDescriptionBytes() {
            return ((LabelDescriptor) this.instance).getDescriptionBytes();
        }

        public Builder setDescription(String value) {
            copyOnWrite();
            ((LabelDescriptor) this.instance).setDescription(value);
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((LabelDescriptor) this.instance).clearDescription();
            return this;
        }

        public Builder setDescriptionBytes(ByteString value) {
            copyOnWrite();
            ((LabelDescriptor) this.instance).setDescriptionBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.LabelDescriptor$1  reason: invalid class name */
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
                return new LabelDescriptor();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                LabelDescriptor other = (LabelDescriptor) arg1;
                this.key_ = visitor.visitString(!this.key_.isEmpty(), this.key_, !other.key_.isEmpty(), other.key_);
                boolean z = false;
                boolean z2 = this.valueType_ != 0;
                int i = this.valueType_;
                if (other.valueType_ != 0) {
                    z = true;
                }
                this.valueType_ = visitor.visitInt(z2, i, z, other.valueType_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, true ^ other.description_.isEmpty(), other.description_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream input = (CodedInputStream) arg0;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        if (tag == 0) {
                            done = true;
                        } else if (tag == 10) {
                            this.key_ = input.readStringRequireUtf8();
                        } else if (tag == 16) {
                            this.valueType_ = input.readEnum();
                        } else if (tag == 26) {
                            this.description_ = input.readStringRequireUtf8();
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
                    synchronized (LabelDescriptor.class) {
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
        LabelDescriptor labelDescriptor = new LabelDescriptor();
        DEFAULT_INSTANCE = labelDescriptor;
        labelDescriptor.makeImmutable();
    }

    public static LabelDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<LabelDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
