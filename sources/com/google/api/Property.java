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
public final class Property extends GeneratedMessageLite<Property, Builder> implements PropertyOrBuilder {
    /* access modifiers changed from: private */
    public static final Property DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Property> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 2;
    private String description_ = "";
    private String name_ = "";
    private int type_;

    private Property() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum PropertyType implements Internal.EnumLite {
        UNSPECIFIED(0),
        INT64(1),
        BOOL(2),
        STRING(3),
        DOUBLE(4),
        UNRECOGNIZED(-1);
        
        public static final int BOOL_VALUE = 2;
        public static final int DOUBLE_VALUE = 4;
        public static final int INT64_VALUE = 1;
        public static final int STRING_VALUE = 3;
        public static final int UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<PropertyType> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<PropertyType>() {
                public PropertyType findValueByNumber(int number) {
                    return PropertyType.forNumber(number);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static PropertyType valueOf(int value2) {
            return forNumber(value2);
        }

        public static PropertyType forNumber(int value2) {
            if (value2 == 0) {
                return UNSPECIFIED;
            }
            if (value2 == 1) {
                return INT64;
            }
            if (value2 == 2) {
                return BOOL;
            }
            if (value2 == 3) {
                return STRING;
            }
            if (value2 != 4) {
                return null;
            }
            return DOUBLE;
        }

        public static Internal.EnumLiteMap<PropertyType> internalGetValueMap() {
            return internalValueMap;
        }

        private PropertyType(int value2) {
            this.value = value2;
        }
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

    public int getTypeValue() {
        return this.type_;
    }

    public PropertyType getType() {
        PropertyType result = PropertyType.forNumber(this.type_);
        return result == null ? PropertyType.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setTypeValue(int value) {
        this.type_ = value;
    }

    /* access modifiers changed from: private */
    public void setType(PropertyType value) {
        if (value != null) {
            this.type_ = value.getNumber();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
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
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (this.type_ != PropertyType.UNSPECIFIED.getNumber()) {
            output.writeEnum(2, this.type_);
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
        if (!this.name_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getName());
        }
        if (this.type_ != PropertyType.UNSPECIFIED.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(2, this.type_);
        }
        if (!this.description_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getDescription());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Property parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Property) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Property parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Property) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Property parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Property) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Property parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Property) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Property parseFrom(InputStream input) throws IOException {
        return (Property) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Property parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Property) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Property parseDelimitedFrom(InputStream input) throws IOException {
        return (Property) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Property parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Property) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Property parseFrom(CodedInputStream input) throws IOException {
        return (Property) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Property parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Property) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Property prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Property, Builder> implements PropertyOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Property.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((Property) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Property) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Property) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Property) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Property) this.instance).setNameBytes(value);
            return this;
        }

        public int getTypeValue() {
            return ((Property) this.instance).getTypeValue();
        }

        public Builder setTypeValue(int value) {
            copyOnWrite();
            ((Property) this.instance).setTypeValue(value);
            return this;
        }

        public PropertyType getType() {
            return ((Property) this.instance).getType();
        }

        public Builder setType(PropertyType value) {
            copyOnWrite();
            ((Property) this.instance).setType(value);
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((Property) this.instance).clearType();
            return this;
        }

        public String getDescription() {
            return ((Property) this.instance).getDescription();
        }

        public ByteString getDescriptionBytes() {
            return ((Property) this.instance).getDescriptionBytes();
        }

        public Builder setDescription(String value) {
            copyOnWrite();
            ((Property) this.instance).setDescription(value);
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((Property) this.instance).clearDescription();
            return this;
        }

        public Builder setDescriptionBytes(ByteString value) {
            copyOnWrite();
            ((Property) this.instance).setDescriptionBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.Property$1  reason: invalid class name */
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
                return new Property();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Property other = (Property) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                boolean z = false;
                boolean z2 = this.type_ != 0;
                int i = this.type_;
                if (other.type_ != 0) {
                    z = true;
                }
                this.type_ = visitor.visitInt(z2, i, z, other.type_);
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
                            this.name_ = input.readStringRequireUtf8();
                        } else if (tag == 16) {
                            this.type_ = input.readEnum();
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
                    synchronized (Property.class) {
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
        Property property = new Property();
        DEFAULT_INSTANCE = property;
        property.makeImmutable();
    }

    public static Property getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Property> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
