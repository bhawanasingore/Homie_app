package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class QuotaLimit extends GeneratedMessageLite<QuotaLimit, Builder> implements QuotaLimitOrBuilder {
    /* access modifiers changed from: private */
    public static final QuotaLimit DEFAULT_INSTANCE;
    public static final int DEFAULT_LIMIT_FIELD_NUMBER = 3;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 12;
    public static final int DURATION_FIELD_NUMBER = 5;
    public static final int FREE_TIER_FIELD_NUMBER = 7;
    public static final int MAX_LIMIT_FIELD_NUMBER = 4;
    public static final int METRIC_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 6;
    private static volatile Parser<QuotaLimit> PARSER = null;
    public static final int UNIT_FIELD_NUMBER = 9;
    public static final int VALUES_FIELD_NUMBER = 10;
    private int bitField0_;
    private long defaultLimit_;
    private String description_ = "";
    private String displayName_ = "";
    private String duration_ = "";
    private long freeTier_;
    private long maxLimit_;
    private String metric_ = "";
    private String name_ = "";
    private String unit_ = "";
    private MapFieldLite<String, Long> values_ = MapFieldLite.emptyMapField();

    private QuotaLimit() {
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

    public long getDefaultLimit() {
        return this.defaultLimit_;
    }

    /* access modifiers changed from: private */
    public void setDefaultLimit(long value) {
        this.defaultLimit_ = value;
    }

    /* access modifiers changed from: private */
    public void clearDefaultLimit() {
        this.defaultLimit_ = 0;
    }

    public long getMaxLimit() {
        return this.maxLimit_;
    }

    /* access modifiers changed from: private */
    public void setMaxLimit(long value) {
        this.maxLimit_ = value;
    }

    /* access modifiers changed from: private */
    public void clearMaxLimit() {
        this.maxLimit_ = 0;
    }

    public long getFreeTier() {
        return this.freeTier_;
    }

    /* access modifiers changed from: private */
    public void setFreeTier(long value) {
        this.freeTier_ = value;
    }

    /* access modifiers changed from: private */
    public void clearFreeTier() {
        this.freeTier_ = 0;
    }

    public String getDuration() {
        return this.duration_;
    }

    public ByteString getDurationBytes() {
        return ByteString.copyFromUtf8(this.duration_);
    }

    /* access modifiers changed from: private */
    public void setDuration(String value) {
        if (value != null) {
            this.duration_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDuration() {
        this.duration_ = getDefaultInstance().getDuration();
    }

    /* access modifiers changed from: private */
    public void setDurationBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.duration_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getMetric() {
        return this.metric_;
    }

    public ByteString getMetricBytes() {
        return ByteString.copyFromUtf8(this.metric_);
    }

    /* access modifiers changed from: private */
    public void setMetric(String value) {
        if (value != null) {
            this.metric_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearMetric() {
        this.metric_ = getDefaultInstance().getMetric();
    }

    /* access modifiers changed from: private */
    public void setMetricBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.metric_ = value.toStringUtf8();
            return;
        }
        throw null;
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

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    private static final class ValuesDefaultEntryHolder {
        static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

        private ValuesDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, Long> internalGetValues() {
        return this.values_;
    }

    private MapFieldLite<String, Long> internalGetMutableValues() {
        if (!this.values_.isMutable()) {
            this.values_ = this.values_.mutableCopy();
        }
        return this.values_;
    }

    public int getValuesCount() {
        return internalGetValues().size();
    }

    public boolean containsValues(String key) {
        if (key != null) {
            return internalGetValues().containsKey(key);
        }
        throw null;
    }

    @Deprecated
    public Map<String, Long> getValues() {
        return getValuesMap();
    }

    public Map<String, Long> getValuesMap() {
        return Collections.unmodifiableMap(internalGetValues());
    }

    public long getValuesOrDefault(String key, long defaultValue) {
        if (key != null) {
            Map<String, Long> map = internalGetValues();
            return map.containsKey(key) ? map.get(key).longValue() : defaultValue;
        }
        throw null;
    }

    public long getValuesOrThrow(String key) {
        if (key != null) {
            Map<String, Long> map = internalGetValues();
            if (map.containsKey(key)) {
                return map.get(key).longValue();
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public Map<String, Long> getMutableValuesMap() {
        return internalGetMutableValues();
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
        if (!this.description_.isEmpty()) {
            output.writeString(2, getDescription());
        }
        long j = this.defaultLimit_;
        if (j != 0) {
            output.writeInt64(3, j);
        }
        long j2 = this.maxLimit_;
        if (j2 != 0) {
            output.writeInt64(4, j2);
        }
        if (!this.duration_.isEmpty()) {
            output.writeString(5, getDuration());
        }
        if (!this.name_.isEmpty()) {
            output.writeString(6, getName());
        }
        long j3 = this.freeTier_;
        if (j3 != 0) {
            output.writeInt64(7, j3);
        }
        if (!this.metric_.isEmpty()) {
            output.writeString(8, getMetric());
        }
        if (!this.unit_.isEmpty()) {
            output.writeString(9, getUnit());
        }
        for (Map.Entry<String, Long> entry : internalGetValues().entrySet()) {
            ValuesDefaultEntryHolder.defaultEntry.serializeTo(output, 10, entry.getKey(), entry.getValue());
        }
        if (!this.displayName_.isEmpty()) {
            output.writeString(12, getDisplayName());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.description_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(2, getDescription());
        }
        long j = this.defaultLimit_;
        if (j != 0) {
            size2 += CodedOutputStream.computeInt64Size(3, j);
        }
        long j2 = this.maxLimit_;
        if (j2 != 0) {
            size2 += CodedOutputStream.computeInt64Size(4, j2);
        }
        if (!this.duration_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(5, getDuration());
        }
        if (!this.name_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(6, getName());
        }
        long j3 = this.freeTier_;
        if (j3 != 0) {
            size2 += CodedOutputStream.computeInt64Size(7, j3);
        }
        if (!this.metric_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(8, getMetric());
        }
        if (!this.unit_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(9, getUnit());
        }
        for (Map.Entry<String, Long> entry : internalGetValues().entrySet()) {
            size2 += ValuesDefaultEntryHolder.defaultEntry.computeMessageSize(10, entry.getKey(), entry.getValue());
        }
        if (!this.displayName_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(12, getDisplayName());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static QuotaLimit parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (QuotaLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static QuotaLimit parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (QuotaLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static QuotaLimit parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (QuotaLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static QuotaLimit parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (QuotaLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static QuotaLimit parseFrom(InputStream input) throws IOException {
        return (QuotaLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static QuotaLimit parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (QuotaLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static QuotaLimit parseDelimitedFrom(InputStream input) throws IOException {
        return (QuotaLimit) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static QuotaLimit parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (QuotaLimit) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static QuotaLimit parseFrom(CodedInputStream input) throws IOException {
        return (QuotaLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static QuotaLimit parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (QuotaLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(QuotaLimit prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<QuotaLimit, Builder> implements QuotaLimitOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(QuotaLimit.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((QuotaLimit) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((QuotaLimit) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((QuotaLimit) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setNameBytes(value);
            return this;
        }

        public String getDescription() {
            return ((QuotaLimit) this.instance).getDescription();
        }

        public ByteString getDescriptionBytes() {
            return ((QuotaLimit) this.instance).getDescriptionBytes();
        }

        public Builder setDescription(String value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setDescription(value);
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((QuotaLimit) this.instance).clearDescription();
            return this;
        }

        public Builder setDescriptionBytes(ByteString value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setDescriptionBytes(value);
            return this;
        }

        public long getDefaultLimit() {
            return ((QuotaLimit) this.instance).getDefaultLimit();
        }

        public Builder setDefaultLimit(long value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setDefaultLimit(value);
            return this;
        }

        public Builder clearDefaultLimit() {
            copyOnWrite();
            ((QuotaLimit) this.instance).clearDefaultLimit();
            return this;
        }

        public long getMaxLimit() {
            return ((QuotaLimit) this.instance).getMaxLimit();
        }

        public Builder setMaxLimit(long value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setMaxLimit(value);
            return this;
        }

        public Builder clearMaxLimit() {
            copyOnWrite();
            ((QuotaLimit) this.instance).clearMaxLimit();
            return this;
        }

        public long getFreeTier() {
            return ((QuotaLimit) this.instance).getFreeTier();
        }

        public Builder setFreeTier(long value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setFreeTier(value);
            return this;
        }

        public Builder clearFreeTier() {
            copyOnWrite();
            ((QuotaLimit) this.instance).clearFreeTier();
            return this;
        }

        public String getDuration() {
            return ((QuotaLimit) this.instance).getDuration();
        }

        public ByteString getDurationBytes() {
            return ((QuotaLimit) this.instance).getDurationBytes();
        }

        public Builder setDuration(String value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setDuration(value);
            return this;
        }

        public Builder clearDuration() {
            copyOnWrite();
            ((QuotaLimit) this.instance).clearDuration();
            return this;
        }

        public Builder setDurationBytes(ByteString value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setDurationBytes(value);
            return this;
        }

        public String getMetric() {
            return ((QuotaLimit) this.instance).getMetric();
        }

        public ByteString getMetricBytes() {
            return ((QuotaLimit) this.instance).getMetricBytes();
        }

        public Builder setMetric(String value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setMetric(value);
            return this;
        }

        public Builder clearMetric() {
            copyOnWrite();
            ((QuotaLimit) this.instance).clearMetric();
            return this;
        }

        public Builder setMetricBytes(ByteString value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setMetricBytes(value);
            return this;
        }

        public String getUnit() {
            return ((QuotaLimit) this.instance).getUnit();
        }

        public ByteString getUnitBytes() {
            return ((QuotaLimit) this.instance).getUnitBytes();
        }

        public Builder setUnit(String value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setUnit(value);
            return this;
        }

        public Builder clearUnit() {
            copyOnWrite();
            ((QuotaLimit) this.instance).clearUnit();
            return this;
        }

        public Builder setUnitBytes(ByteString value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setUnitBytes(value);
            return this;
        }

        public int getValuesCount() {
            return ((QuotaLimit) this.instance).getValuesMap().size();
        }

        public boolean containsValues(String key) {
            if (key != null) {
                return ((QuotaLimit) this.instance).getValuesMap().containsKey(key);
            }
            throw null;
        }

        public Builder clearValues() {
            copyOnWrite();
            ((QuotaLimit) this.instance).getMutableValuesMap().clear();
            return this;
        }

        public Builder removeValues(String key) {
            if (key != null) {
                copyOnWrite();
                ((QuotaLimit) this.instance).getMutableValuesMap().remove(key);
                return this;
            }
            throw null;
        }

        @Deprecated
        public Map<String, Long> getValues() {
            return getValuesMap();
        }

        public Map<String, Long> getValuesMap() {
            return Collections.unmodifiableMap(((QuotaLimit) this.instance).getValuesMap());
        }

        public long getValuesOrDefault(String key, long defaultValue) {
            if (key != null) {
                Map<String, Long> map = ((QuotaLimit) this.instance).getValuesMap();
                return map.containsKey(key) ? map.get(key).longValue() : defaultValue;
            }
            throw null;
        }

        public long getValuesOrThrow(String key) {
            if (key != null) {
                Map<String, Long> map = ((QuotaLimit) this.instance).getValuesMap();
                if (map.containsKey(key)) {
                    return map.get(key).longValue();
                }
                throw new IllegalArgumentException();
            }
            throw null;
        }

        public Builder putValues(String key, long value) {
            if (key != null) {
                copyOnWrite();
                ((QuotaLimit) this.instance).getMutableValuesMap().put(key, Long.valueOf(value));
                return this;
            }
            throw null;
        }

        public Builder putAllValues(Map<String, Long> values) {
            copyOnWrite();
            ((QuotaLimit) this.instance).getMutableValuesMap().putAll(values);
            return this;
        }

        public String getDisplayName() {
            return ((QuotaLimit) this.instance).getDisplayName();
        }

        public ByteString getDisplayNameBytes() {
            return ((QuotaLimit) this.instance).getDisplayNameBytes();
        }

        public Builder setDisplayName(String value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setDisplayName(value);
            return this;
        }

        public Builder clearDisplayName() {
            copyOnWrite();
            ((QuotaLimit) this.instance).clearDisplayName();
            return this;
        }

        public Builder setDisplayNameBytes(ByteString value) {
            copyOnWrite();
            ((QuotaLimit) this.instance).setDisplayNameBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.QuotaLimit$1  reason: invalid class name */
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
                return new QuotaLimit();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.values_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                QuotaLimit other = (QuotaLimit) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !other.description_.isEmpty(), other.description_);
                this.defaultLimit_ = visitor.visitLong(this.defaultLimit_ != 0, this.defaultLimit_, other.defaultLimit_ != 0, other.defaultLimit_);
                this.maxLimit_ = visitor.visitLong(this.maxLimit_ != 0, this.maxLimit_, other.maxLimit_ != 0, other.maxLimit_);
                this.freeTier_ = visitor.visitLong(this.freeTier_ != 0, this.freeTier_, other.freeTier_ != 0, other.freeTier_);
                this.duration_ = visitor.visitString(!this.duration_.isEmpty(), this.duration_, !other.duration_.isEmpty(), other.duration_);
                this.metric_ = visitor.visitString(!this.metric_.isEmpty(), this.metric_, !other.metric_.isEmpty(), other.metric_);
                this.unit_ = visitor.visitString(!this.unit_.isEmpty(), this.unit_, !other.unit_.isEmpty(), other.unit_);
                this.values_ = visitor.visitMap(this.values_, other.internalGetValues());
                this.displayName_ = visitor.visitString(!this.displayName_.isEmpty(), this.displayName_, !other.displayName_.isEmpty(), other.displayName_);
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
                            case 18:
                                this.description_ = input.readStringRequireUtf8();
                                break;
                            case 24:
                                this.defaultLimit_ = input.readInt64();
                                break;
                            case 32:
                                this.maxLimit_ = input.readInt64();
                                break;
                            case 42:
                                this.duration_ = input.readStringRequireUtf8();
                                break;
                            case 50:
                                this.name_ = input.readStringRequireUtf8();
                                break;
                            case 56:
                                this.freeTier_ = input.readInt64();
                                break;
                            case 66:
                                this.metric_ = input.readStringRequireUtf8();
                                break;
                            case 74:
                                this.unit_ = input.readStringRequireUtf8();
                                break;
                            case 82:
                                if (!this.values_.isMutable()) {
                                    this.values_ = this.values_.mutableCopy();
                                }
                                ValuesDefaultEntryHolder.defaultEntry.parseInto(this.values_, input, extensionRegistry);
                                break;
                            case 98:
                                this.displayName_ = input.readStringRequireUtf8();
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
                    synchronized (QuotaLimit.class) {
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
        QuotaLimit quotaLimit = new QuotaLimit();
        DEFAULT_INSTANCE = quotaLimit;
        quotaLimit.makeImmutable();
    }

    public static QuotaLimit getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<QuotaLimit> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
