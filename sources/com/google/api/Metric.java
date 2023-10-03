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
public final class Metric extends GeneratedMessageLite<Metric, Builder> implements MetricOrBuilder {
    /* access modifiers changed from: private */
    public static final Metric DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 2;
    private static volatile Parser<Metric> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 3;
    private int bitField0_;
    private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
    private String type_ = "";

    private Metric() {
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

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    private static final class LabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private LabelsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, String> internalGetLabels() {
        return this.labels_;
    }

    private MapFieldLite<String, String> internalGetMutableLabels() {
        if (!this.labels_.isMutable()) {
            this.labels_ = this.labels_.mutableCopy();
        }
        return this.labels_;
    }

    public int getLabelsCount() {
        return internalGetLabels().size();
    }

    public boolean containsLabels(String key) {
        if (key != null) {
            return internalGetLabels().containsKey(key);
        }
        throw null;
    }

    @Deprecated
    public Map<String, String> getLabels() {
        return getLabelsMap();
    }

    public Map<String, String> getLabelsMap() {
        return Collections.unmodifiableMap(internalGetLabels());
    }

    public String getLabelsOrDefault(String key, String defaultValue) {
        if (key != null) {
            Map<String, String> map = internalGetLabels();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }
        throw null;
    }

    public String getLabelsOrThrow(String key) {
        if (key != null) {
            Map<String, String> map = internalGetLabels();
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public Map<String, String> getMutableLabelsMap() {
        return internalGetMutableLabels();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            LabelsDefaultEntryHolder.defaultEntry.serializeTo(output, 2, entry.getKey(), entry.getValue());
        }
        if (!this.type_.isEmpty()) {
            output.writeString(3, getType());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            size2 += LabelsDefaultEntryHolder.defaultEntry.computeMessageSize(2, entry.getKey(), entry.getValue());
        }
        if (!this.type_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getType());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Metric parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Metric parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Metric parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Metric parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Metric parseFrom(InputStream input) throws IOException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Metric parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Metric parseDelimitedFrom(InputStream input) throws IOException {
        return (Metric) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Metric parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Metric) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Metric parseFrom(CodedInputStream input) throws IOException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Metric parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Metric prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Metric, Builder> implements MetricOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Metric.DEFAULT_INSTANCE);
        }

        public String getType() {
            return ((Metric) this.instance).getType();
        }

        public ByteString getTypeBytes() {
            return ((Metric) this.instance).getTypeBytes();
        }

        public Builder setType(String value) {
            copyOnWrite();
            ((Metric) this.instance).setType(value);
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((Metric) this.instance).clearType();
            return this;
        }

        public Builder setTypeBytes(ByteString value) {
            copyOnWrite();
            ((Metric) this.instance).setTypeBytes(value);
            return this;
        }

        public int getLabelsCount() {
            return ((Metric) this.instance).getLabelsMap().size();
        }

        public boolean containsLabels(String key) {
            if (key != null) {
                return ((Metric) this.instance).getLabelsMap().containsKey(key);
            }
            throw null;
        }

        public Builder clearLabels() {
            copyOnWrite();
            ((Metric) this.instance).getMutableLabelsMap().clear();
            return this;
        }

        public Builder removeLabels(String key) {
            if (key != null) {
                copyOnWrite();
                ((Metric) this.instance).getMutableLabelsMap().remove(key);
                return this;
            }
            throw null;
        }

        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        public Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(((Metric) this.instance).getLabelsMap());
        }

        public String getLabelsOrDefault(String key, String defaultValue) {
            if (key != null) {
                Map<String, String> map = ((Metric) this.instance).getLabelsMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }
            throw null;
        }

        public String getLabelsOrThrow(String key) {
            if (key != null) {
                Map<String, String> map = ((Metric) this.instance).getLabelsMap();
                if (map.containsKey(key)) {
                    return map.get(key);
                }
                throw new IllegalArgumentException();
            }
            throw null;
        }

        public Builder putLabels(String key, String value) {
            if (key == null) {
                throw null;
            } else if (value != null) {
                copyOnWrite();
                ((Metric) this.instance).getMutableLabelsMap().put(key, value);
                return this;
            } else {
                throw null;
            }
        }

        public Builder putAllLabels(Map<String, String> values) {
            copyOnWrite();
            ((Metric) this.instance).getMutableLabelsMap().putAll(values);
            return this;
        }
    }

    /* renamed from: com.google.api.Metric$1  reason: invalid class name */
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
                return new Metric();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.labels_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Metric other = (Metric) arg1;
                this.type_ = visitor.visitString(!this.type_.isEmpty(), this.type_, !other.type_.isEmpty(), other.type_);
                this.labels_ = visitor.visitMap(this.labels_, other.internalGetLabels());
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
                        } else if (tag == 18) {
                            if (!this.labels_.isMutable()) {
                                this.labels_ = this.labels_.mutableCopy();
                            }
                            LabelsDefaultEntryHolder.defaultEntry.parseInto(this.labels_, input, extensionRegistry);
                        } else if (tag == 26) {
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
                    synchronized (Metric.class) {
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
        Metric metric = new Metric();
        DEFAULT_INSTANCE = metric;
        metric.makeImmutable();
    }

    public static Metric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Metric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
