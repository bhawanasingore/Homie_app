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
public final class MetricRule extends GeneratedMessageLite<MetricRule, Builder> implements MetricRuleOrBuilder {
    /* access modifiers changed from: private */
    public static final MetricRule DEFAULT_INSTANCE;
    public static final int METRIC_COSTS_FIELD_NUMBER = 2;
    private static volatile Parser<MetricRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private int bitField0_;
    private MapFieldLite<String, Long> metricCosts_ = MapFieldLite.emptyMapField();
    private String selector_ = "";

    private MetricRule() {
    }

    public String getSelector() {
        return this.selector_;
    }

    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* access modifiers changed from: private */
    public void setSelector(String value) {
        if (value != null) {
            this.selector_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* access modifiers changed from: private */
    public void setSelectorBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.selector_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    private static final class MetricCostsDefaultEntryHolder {
        static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

        private MetricCostsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, Long> internalGetMetricCosts() {
        return this.metricCosts_;
    }

    private MapFieldLite<String, Long> internalGetMutableMetricCosts() {
        if (!this.metricCosts_.isMutable()) {
            this.metricCosts_ = this.metricCosts_.mutableCopy();
        }
        return this.metricCosts_;
    }

    public int getMetricCostsCount() {
        return internalGetMetricCosts().size();
    }

    public boolean containsMetricCosts(String key) {
        if (key != null) {
            return internalGetMetricCosts().containsKey(key);
        }
        throw null;
    }

    @Deprecated
    public Map<String, Long> getMetricCosts() {
        return getMetricCostsMap();
    }

    public Map<String, Long> getMetricCostsMap() {
        return Collections.unmodifiableMap(internalGetMetricCosts());
    }

    public long getMetricCostsOrDefault(String key, long defaultValue) {
        if (key != null) {
            Map<String, Long> map = internalGetMetricCosts();
            return map.containsKey(key) ? map.get(key).longValue() : defaultValue;
        }
        throw null;
    }

    public long getMetricCostsOrThrow(String key) {
        if (key != null) {
            Map<String, Long> map = internalGetMetricCosts();
            if (map.containsKey(key)) {
                return map.get(key).longValue();
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public Map<String, Long> getMutableMetricCostsMap() {
        return internalGetMutableMetricCosts();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.selector_.isEmpty()) {
            output.writeString(1, getSelector());
        }
        for (Map.Entry<String, Long> entry : internalGetMetricCosts().entrySet()) {
            MetricCostsDefaultEntryHolder.defaultEntry.serializeTo(output, 2, entry.getKey(), entry.getValue());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.selector_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getSelector());
        }
        for (Map.Entry<String, Long> entry : internalGetMetricCosts().entrySet()) {
            size2 += MetricCostsDefaultEntryHolder.defaultEntry.computeMessageSize(2, entry.getKey(), entry.getValue());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static MetricRule parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MetricRule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MetricRule parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MetricRule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MetricRule parseFrom(InputStream input) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MetricRule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MetricRule parseDelimitedFrom(InputStream input) throws IOException {
        return (MetricRule) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static MetricRule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MetricRule) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MetricRule parseFrom(CodedInputStream input) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MetricRule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MetricRule prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<MetricRule, Builder> implements MetricRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(MetricRule.DEFAULT_INSTANCE);
        }

        public String getSelector() {
            return ((MetricRule) this.instance).getSelector();
        }

        public ByteString getSelectorBytes() {
            return ((MetricRule) this.instance).getSelectorBytes();
        }

        public Builder setSelector(String value) {
            copyOnWrite();
            ((MetricRule) this.instance).setSelector(value);
            return this;
        }

        public Builder clearSelector() {
            copyOnWrite();
            ((MetricRule) this.instance).clearSelector();
            return this;
        }

        public Builder setSelectorBytes(ByteString value) {
            copyOnWrite();
            ((MetricRule) this.instance).setSelectorBytes(value);
            return this;
        }

        public int getMetricCostsCount() {
            return ((MetricRule) this.instance).getMetricCostsMap().size();
        }

        public boolean containsMetricCosts(String key) {
            if (key != null) {
                return ((MetricRule) this.instance).getMetricCostsMap().containsKey(key);
            }
            throw null;
        }

        public Builder clearMetricCosts() {
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().clear();
            return this;
        }

        public Builder removeMetricCosts(String key) {
            if (key != null) {
                copyOnWrite();
                ((MetricRule) this.instance).getMutableMetricCostsMap().remove(key);
                return this;
            }
            throw null;
        }

        @Deprecated
        public Map<String, Long> getMetricCosts() {
            return getMetricCostsMap();
        }

        public Map<String, Long> getMetricCostsMap() {
            return Collections.unmodifiableMap(((MetricRule) this.instance).getMetricCostsMap());
        }

        public long getMetricCostsOrDefault(String key, long defaultValue) {
            if (key != null) {
                Map<String, Long> map = ((MetricRule) this.instance).getMetricCostsMap();
                return map.containsKey(key) ? map.get(key).longValue() : defaultValue;
            }
            throw null;
        }

        public long getMetricCostsOrThrow(String key) {
            if (key != null) {
                Map<String, Long> map = ((MetricRule) this.instance).getMetricCostsMap();
                if (map.containsKey(key)) {
                    return map.get(key).longValue();
                }
                throw new IllegalArgumentException();
            }
            throw null;
        }

        public Builder putMetricCosts(String key, long value) {
            if (key != null) {
                copyOnWrite();
                ((MetricRule) this.instance).getMutableMetricCostsMap().put(key, Long.valueOf(value));
                return this;
            }
            throw null;
        }

        public Builder putAllMetricCosts(Map<String, Long> values) {
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().putAll(values);
            return this;
        }
    }

    /* renamed from: com.google.api.MetricRule$1  reason: invalid class name */
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
                return new MetricRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.metricCosts_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                MetricRule other = (MetricRule) arg1;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, !other.selector_.isEmpty(), other.selector_);
                this.metricCosts_ = visitor.visitMap(this.metricCosts_, other.internalGetMetricCosts());
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
                            this.selector_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            if (!this.metricCosts_.isMutable()) {
                                this.metricCosts_ = this.metricCosts_.mutableCopy();
                            }
                            MetricCostsDefaultEntryHolder.defaultEntry.parseInto(this.metricCosts_, input, extensionRegistry);
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
                    synchronized (MetricRule.class) {
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
        MetricRule metricRule = new MetricRule();
        DEFAULT_INSTANCE = metricRule;
        metricRule.makeImmutable();
    }

    public static MetricRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MetricRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
