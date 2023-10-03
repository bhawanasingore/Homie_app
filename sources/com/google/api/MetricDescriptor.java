package com.google.api;

import com.google.api.LabelDescriptor;
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
public final class MetricDescriptor extends GeneratedMessageLite<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
    /* access modifiers changed from: private */
    public static final MetricDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
    public static final int LABELS_FIELD_NUMBER = 2;
    public static final int METRIC_KIND_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<MetricDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UNIT_FIELD_NUMBER = 5;
    public static final int VALUE_TYPE_FIELD_NUMBER = 4;
    private int bitField0_;
    private String description_ = "";
    private String displayName_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = emptyProtobufList();
    private int metricKind_;
    private String name_ = "";
    private String type_ = "";
    private String unit_ = "";
    private int valueType_;

    private MetricDescriptor() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum MetricKind implements Internal.EnumLite {
        METRIC_KIND_UNSPECIFIED(0),
        GAUGE(1),
        DELTA(2),
        CUMULATIVE(3),
        UNRECOGNIZED(-1);
        
        public static final int CUMULATIVE_VALUE = 3;
        public static final int DELTA_VALUE = 2;
        public static final int GAUGE_VALUE = 1;
        public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<MetricKind> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<MetricKind>() {
                public MetricKind findValueByNumber(int number) {
                    return MetricKind.forNumber(number);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static MetricKind valueOf(int value2) {
            return forNumber(value2);
        }

        public static MetricKind forNumber(int value2) {
            if (value2 == 0) {
                return METRIC_KIND_UNSPECIFIED;
            }
            if (value2 == 1) {
                return GAUGE;
            }
            if (value2 == 2) {
                return DELTA;
            }
            if (value2 != 3) {
                return null;
            }
            return CUMULATIVE;
        }

        public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
            return internalValueMap;
        }

        private MetricKind(int value2) {
            this.value = value2;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum ValueType implements Internal.EnumLite {
        VALUE_TYPE_UNSPECIFIED(0),
        BOOL(1),
        INT64(2),
        DOUBLE(3),
        STRING(4),
        DISTRIBUTION(5),
        MONEY(6),
        UNRECOGNIZED(-1);
        
        public static final int BOOL_VALUE = 1;
        public static final int DISTRIBUTION_VALUE = 5;
        public static final int DOUBLE_VALUE = 3;
        public static final int INT64_VALUE = 2;
        public static final int MONEY_VALUE = 6;
        public static final int STRING_VALUE = 4;
        public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;
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
            switch (value2) {
                case 0:
                    return VALUE_TYPE_UNSPECIFIED;
                case 1:
                    return BOOL;
                case 2:
                    return INT64;
                case 3:
                    return DOUBLE;
                case 4:
                    return STRING;
                case 5:
                    return DISTRIBUTION;
                case 6:
                    return MONEY;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
            return internalValueMap;
        }

        private ValueType(int value2) {
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

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    /* access modifiers changed from: private */
    public void setType(String value) {
        if (value != null) {
            this.type_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    /* access modifiers changed from: private */
    public void setTypeBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.type_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    public int getLabelsCount() {
        return this.labels_.size();
    }

    public LabelDescriptor getLabels(int index) {
        return (LabelDescriptor) this.labels_.get(index);
    }

    public LabelDescriptorOrBuilder getLabelsOrBuilder(int index) {
        return (LabelDescriptorOrBuilder) this.labels_.get(index);
    }

    private void ensureLabelsIsMutable() {
        if (!this.labels_.isModifiable()) {
            this.labels_ = GeneratedMessageLite.mutableCopy(this.labels_);
        }
    }

    /* access modifiers changed from: private */
    public void setLabels(int index, LabelDescriptor value) {
        if (value != null) {
            ensureLabelsIsMutable();
            this.labels_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLabels(int index, LabelDescriptor.Builder builderForValue) {
        ensureLabelsIsMutable();
        this.labels_.set(index, (LabelDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLabels(LabelDescriptor value) {
        if (value != null) {
            ensureLabelsIsMutable();
            this.labels_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLabels(int index, LabelDescriptor value) {
        if (value != null) {
            ensureLabelsIsMutable();
            this.labels_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLabels(LabelDescriptor.Builder builderForValue) {
        ensureLabelsIsMutable();
        this.labels_.add((LabelDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLabels(int index, LabelDescriptor.Builder builderForValue) {
        ensureLabelsIsMutable();
        this.labels_.add(index, (LabelDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllLabels(Iterable<? extends LabelDescriptor> values) {
        ensureLabelsIsMutable();
        AbstractMessageLite.addAll(values, this.labels_);
    }

    /* access modifiers changed from: private */
    public void clearLabels() {
        this.labels_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeLabels(int index) {
        ensureLabelsIsMutable();
        this.labels_.remove(index);
    }

    public int getMetricKindValue() {
        return this.metricKind_;
    }

    public MetricKind getMetricKind() {
        MetricKind result = MetricKind.forNumber(this.metricKind_);
        return result == null ? MetricKind.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setMetricKindValue(int value) {
        this.metricKind_ = value;
    }

    /* access modifiers changed from: private */
    public void setMetricKind(MetricKind value) {
        if (value != null) {
            this.metricKind_ = value.getNumber();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearMetricKind() {
        this.metricKind_ = 0;
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

    public String getUnit() {
        return this.unit_;
    }

    public ByteString getUnitBytes() {
        return ByteString.copyFromUtf8(this.unit_);
    }

    /* access modifiers changed from: private */
    public void setUnit(String value) {
        if (value != null) {
            this.unit_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearUnit() {
        this.unit_ = getDefaultInstance().getUnit();
    }

    /* access modifiers changed from: private */
    public void setUnitBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.unit_ = value.toStringUtf8();
            return;
        }
        throw null;
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

    public String getDisplayName() {
        return this.displayName_;
    }

    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    /* access modifiers changed from: private */
    public void setDisplayName(String value) {
        if (value != null) {
            this.displayName_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* access modifiers changed from: private */
    public void setDisplayNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.displayName_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        for (int i = 0; i < this.labels_.size(); i++) {
            output.writeMessage(2, (MessageLite) this.labels_.get(i));
        }
        if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber()) {
            output.writeEnum(3, this.metricKind_);
        }
        if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber()) {
            output.writeEnum(4, this.valueType_);
        }
        if (!this.unit_.isEmpty()) {
            output.writeString(5, getUnit());
        }
        if (!this.description_.isEmpty()) {
            output.writeString(6, getDescription());
        }
        if (!this.displayName_.isEmpty()) {
            output.writeString(7, getDisplayName());
        }
        if (!this.type_.isEmpty()) {
            output.writeString(8, getType());
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
        for (int i = 0; i < this.labels_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.labels_.get(i));
        }
        if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(3, this.metricKind_);
        }
        if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(4, this.valueType_);
        }
        if (!this.unit_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(5, getUnit());
        }
        if (!this.description_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(6, getDescription());
        }
        if (!this.displayName_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(7, getDisplayName());
        }
        if (!this.type_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(8, getType());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static MetricDescriptor parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MetricDescriptor parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MetricDescriptor parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MetricDescriptor parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MetricDescriptor parseFrom(InputStream input) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MetricDescriptor parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream input) throws IOException {
        return (MetricDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MetricDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MetricDescriptor parseFrom(CodedInputStream input) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MetricDescriptor parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MetricDescriptor prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(MetricDescriptor.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((MetricDescriptor) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((MetricDescriptor) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setNameBytes(value);
            return this;
        }

        public String getType() {
            return ((MetricDescriptor) this.instance).getType();
        }

        public ByteString getTypeBytes() {
            return ((MetricDescriptor) this.instance).getTypeBytes();
        }

        public Builder setType(String value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setType(value);
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearType();
            return this;
        }

        public Builder setTypeBytes(ByteString value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setTypeBytes(value);
            return this;
        }

        public List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MetricDescriptor) this.instance).getLabelsList());
        }

        public int getLabelsCount() {
            return ((MetricDescriptor) this.instance).getLabelsCount();
        }

        public LabelDescriptor getLabels(int index) {
            return ((MetricDescriptor) this.instance).getLabels(index);
        }

        public Builder setLabels(int index, LabelDescriptor value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLabels(index, value);
            return this;
        }

        public Builder setLabels(int index, LabelDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLabels(index, builderForValue);
            return this;
        }

        public Builder addLabels(LabelDescriptor value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(value);
            return this;
        }

        public Builder addLabels(int index, LabelDescriptor value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(index, value);
            return this;
        }

        public Builder addLabels(LabelDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(builderForValue);
            return this;
        }

        public Builder addLabels(int index, LabelDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(index, builderForValue);
            return this;
        }

        public Builder addAllLabels(Iterable<? extends LabelDescriptor> values) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addAllLabels(values);
            return this;
        }

        public Builder clearLabels() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearLabels();
            return this;
        }

        public Builder removeLabels(int index) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).removeLabels(index);
            return this;
        }

        public int getMetricKindValue() {
            return ((MetricDescriptor) this.instance).getMetricKindValue();
        }

        public Builder setMetricKindValue(int value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetricKindValue(value);
            return this;
        }

        public MetricKind getMetricKind() {
            return ((MetricDescriptor) this.instance).getMetricKind();
        }

        public Builder setMetricKind(MetricKind value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetricKind(value);
            return this;
        }

        public Builder clearMetricKind() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearMetricKind();
            return this;
        }

        public int getValueTypeValue() {
            return ((MetricDescriptor) this.instance).getValueTypeValue();
        }

        public Builder setValueTypeValue(int value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setValueTypeValue(value);
            return this;
        }

        public ValueType getValueType() {
            return ((MetricDescriptor) this.instance).getValueType();
        }

        public Builder setValueType(ValueType value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setValueType(value);
            return this;
        }

        public Builder clearValueType() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearValueType();
            return this;
        }

        public String getUnit() {
            return ((MetricDescriptor) this.instance).getUnit();
        }

        public ByteString getUnitBytes() {
            return ((MetricDescriptor) this.instance).getUnitBytes();
        }

        public Builder setUnit(String value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setUnit(value);
            return this;
        }

        public Builder clearUnit() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearUnit();
            return this;
        }

        public Builder setUnitBytes(ByteString value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setUnitBytes(value);
            return this;
        }

        public String getDescription() {
            return ((MetricDescriptor) this.instance).getDescription();
        }

        public ByteString getDescriptionBytes() {
            return ((MetricDescriptor) this.instance).getDescriptionBytes();
        }

        public Builder setDescription(String value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDescription(value);
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearDescription();
            return this;
        }

        public Builder setDescriptionBytes(ByteString value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDescriptionBytes(value);
            return this;
        }

        public String getDisplayName() {
            return ((MetricDescriptor) this.instance).getDisplayName();
        }

        public ByteString getDisplayNameBytes() {
            return ((MetricDescriptor) this.instance).getDisplayNameBytes();
        }

        public Builder setDisplayName(String value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDisplayName(value);
            return this;
        }

        public Builder clearDisplayName() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearDisplayName();
            return this;
        }

        public Builder setDisplayNameBytes(ByteString value) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDisplayNameBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.MetricDescriptor$1  reason: invalid class name */
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
                return new MetricDescriptor();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.labels_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                MetricDescriptor other = (MetricDescriptor) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.type_ = visitor.visitString(!this.type_.isEmpty(), this.type_, !other.type_.isEmpty(), other.type_);
                this.labels_ = visitor.visitList(this.labels_, other.labels_);
                boolean z = false;
                this.metricKind_ = visitor.visitInt(this.metricKind_ != 0, this.metricKind_, other.metricKind_ != 0, other.metricKind_);
                boolean z2 = this.valueType_ != 0;
                int i = this.valueType_;
                if (other.valueType_ != 0) {
                    z = true;
                }
                this.valueType_ = visitor.visitInt(z2, i, z, other.valueType_);
                this.unit_ = visitor.visitString(!this.unit_.isEmpty(), this.unit_, !other.unit_.isEmpty(), other.unit_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !other.description_.isEmpty(), other.description_);
                this.displayName_ = visitor.visitString(!this.displayName_.isEmpty(), this.displayName_, true ^ other.displayName_.isEmpty(), other.displayName_);
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
                            if (!this.labels_.isModifiable()) {
                                this.labels_ = GeneratedMessageLite.mutableCopy(this.labels_);
                            }
                            this.labels_.add((LabelDescriptor) input.readMessage(LabelDescriptor.parser(), extensionRegistry));
                        } else if (tag == 24) {
                            this.metricKind_ = input.readEnum();
                        } else if (tag == 32) {
                            this.valueType_ = input.readEnum();
                        } else if (tag == 42) {
                            this.unit_ = input.readStringRequireUtf8();
                        } else if (tag == 50) {
                            this.description_ = input.readStringRequireUtf8();
                        } else if (tag == 58) {
                            this.displayName_ = input.readStringRequireUtf8();
                        } else if (tag == 66) {
                            this.type_ = input.readStringRequireUtf8();
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
                    synchronized (MetricDescriptor.class) {
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
        MetricDescriptor metricDescriptor = new MetricDescriptor();
        DEFAULT_INSTANCE = metricDescriptor;
        metricDescriptor.makeImmutable();
    }

    public static MetricDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MetricDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
