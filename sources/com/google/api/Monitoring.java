package com.google.api;

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

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Monitoring extends GeneratedMessageLite<Monitoring, Builder> implements MonitoringOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Monitoring DEFAULT_INSTANCE;
    private static volatile Parser<Monitoring> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<MonitoringDestination> consumerDestinations_ = emptyProtobufList();
    private Internal.ProtobufList<MonitoringDestination> producerDestinations_ = emptyProtobufList();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface MonitoringDestinationOrBuilder extends MessageLiteOrBuilder {
        String getMetrics(int i);

        ByteString getMetricsBytes(int i);

        int getMetricsCount();

        List<String> getMetricsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    private Monitoring() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class MonitoringDestination extends GeneratedMessageLite<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
        /* access modifiers changed from: private */
        public static final MonitoringDestination DEFAULT_INSTANCE;
        public static final int METRICS_FIELD_NUMBER = 2;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
        private static volatile Parser<MonitoringDestination> PARSER;
        private int bitField0_;
        private Internal.ProtobufList<String> metrics_ = GeneratedMessageLite.emptyProtobufList();
        private String monitoredResource_ = "";

        private MonitoringDestination() {
        }

        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        public ByteString getMonitoredResourceBytes() {
            return ByteString.copyFromUtf8(this.monitoredResource_);
        }

        /* access modifiers changed from: private */
        public void setMonitoredResource(String value) {
            if (value != null) {
                this.monitoredResource_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearMonitoredResource() {
            this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
        }

        /* access modifiers changed from: private */
        public void setMonitoredResourceBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                this.monitoredResource_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public List<String> getMetricsList() {
            return this.metrics_;
        }

        public int getMetricsCount() {
            return this.metrics_.size();
        }

        public String getMetrics(int index) {
            return (String) this.metrics_.get(index);
        }

        public ByteString getMetricsBytes(int index) {
            return ByteString.copyFromUtf8((String) this.metrics_.get(index));
        }

        private void ensureMetricsIsMutable() {
            if (!this.metrics_.isModifiable()) {
                this.metrics_ = GeneratedMessageLite.mutableCopy(this.metrics_);
            }
        }

        /* access modifiers changed from: private */
        public void setMetrics(int index, String value) {
            if (value != null) {
                ensureMetricsIsMutable();
                this.metrics_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addMetrics(String value) {
            if (value != null) {
                ensureMetricsIsMutable();
                this.metrics_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addAllMetrics(Iterable<String> values) {
            ensureMetricsIsMutable();
            AbstractMessageLite.addAll(values, this.metrics_);
        }

        /* access modifiers changed from: private */
        public void clearMetrics() {
            this.metrics_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addMetricsBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                ensureMetricsIsMutable();
                this.metrics_.add(value.toStringUtf8());
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.monitoredResource_.isEmpty()) {
                output.writeString(1, getMonitoredResource());
            }
            for (int i = 0; i < this.metrics_.size(); i++) {
                output.writeString(2, (String) this.metrics_.get(i));
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.monitoredResource_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeStringSize(1, getMonitoredResource());
            }
            int dataSize = 0;
            for (int i = 0; i < this.metrics_.size(); i++) {
                dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.metrics_.get(i));
            }
            int size3 = size2 + dataSize + (getMetricsList().size() * 1);
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static MonitoringDestination parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MonitoringDestination parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MonitoringDestination parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MonitoringDestination parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MonitoringDestination parseFrom(InputStream input) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MonitoringDestination parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream input) throws IOException {
            return (MonitoringDestination) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonitoringDestination) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MonitoringDestination parseFrom(CodedInputStream input) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MonitoringDestination parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MonitoringDestination prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(MonitoringDestination.DEFAULT_INSTANCE);
            }

            public String getMonitoredResource() {
                return ((MonitoringDestination) this.instance).getMonitoredResource();
            }

            public ByteString getMonitoredResourceBytes() {
                return ((MonitoringDestination) this.instance).getMonitoredResourceBytes();
            }

            public Builder setMonitoredResource(String value) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).setMonitoredResource(value);
                return this;
            }

            public Builder clearMonitoredResource() {
                copyOnWrite();
                ((MonitoringDestination) this.instance).clearMonitoredResource();
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString value) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).setMonitoredResourceBytes(value);
                return this;
            }

            public List<String> getMetricsList() {
                return Collections.unmodifiableList(((MonitoringDestination) this.instance).getMetricsList());
            }

            public int getMetricsCount() {
                return ((MonitoringDestination) this.instance).getMetricsCount();
            }

            public String getMetrics(int index) {
                return ((MonitoringDestination) this.instance).getMetrics(index);
            }

            public ByteString getMetricsBytes(int index) {
                return ((MonitoringDestination) this.instance).getMetricsBytes(index);
            }

            public Builder setMetrics(int index, String value) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).setMetrics(index, value);
                return this;
            }

            public Builder addMetrics(String value) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).addMetrics(value);
                return this;
            }

            public Builder addAllMetrics(Iterable<String> values) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).addAllMetrics(values);
                return this;
            }

            public Builder clearMetrics() {
                copyOnWrite();
                ((MonitoringDestination) this.instance).clearMetrics();
                return this;
            }

            public Builder addMetricsBytes(ByteString value) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).addMetricsBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new MonitoringDestination();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.metrics_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    MonitoringDestination other = (MonitoringDestination) arg1;
                    this.monitoredResource_ = visitor.visitString(!this.monitoredResource_.isEmpty(), this.monitoredResource_, !other.monitoredResource_.isEmpty(), other.monitoredResource_);
                    this.metrics_ = visitor.visitList(this.metrics_, other.metrics_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= other.bitField0_;
                    }
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
                                this.monitoredResource_ = input.readStringRequireUtf8();
                            } else if (tag == 18) {
                                String s = input.readStringRequireUtf8();
                                if (!this.metrics_.isModifiable()) {
                                    this.metrics_ = GeneratedMessageLite.mutableCopy(this.metrics_);
                                }
                                this.metrics_.add(s);
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
                        synchronized (MonitoringDestination.class) {
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
            MonitoringDestination monitoringDestination = new MonitoringDestination();
            DEFAULT_INSTANCE = monitoringDestination;
            monitoringDestination.makeImmutable();
        }

        public static MonitoringDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MonitoringDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Monitoring$1  reason: invalid class name */
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

    public List<MonitoringDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    public List<? extends MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    public MonitoringDestination getProducerDestinations(int index) {
        return (MonitoringDestination) this.producerDestinations_.get(index);
    }

    public MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int index) {
        return (MonitoringDestinationOrBuilder) this.producerDestinations_.get(index);
    }

    private void ensureProducerDestinationsIsMutable() {
        if (!this.producerDestinations_.isModifiable()) {
            this.producerDestinations_ = GeneratedMessageLite.mutableCopy(this.producerDestinations_);
        }
    }

    /* access modifiers changed from: private */
    public void setProducerDestinations(int index, MonitoringDestination value) {
        if (value != null) {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setProducerDestinations(int index, MonitoringDestination.Builder builderForValue) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(index, (MonitoringDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(MonitoringDestination value) {
        if (value != null) {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(int index, MonitoringDestination value) {
        if (value != null) {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(MonitoringDestination.Builder builderForValue) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add((MonitoringDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(int index, MonitoringDestination.Builder builderForValue) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(index, (MonitoringDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllProducerDestinations(Iterable<? extends MonitoringDestination> values) {
        ensureProducerDestinationsIsMutable();
        AbstractMessageLite.addAll(values, this.producerDestinations_);
    }

    /* access modifiers changed from: private */
    public void clearProducerDestinations() {
        this.producerDestinations_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeProducerDestinations(int index) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.remove(index);
    }

    public List<MonitoringDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public List<? extends MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    public MonitoringDestination getConsumerDestinations(int index) {
        return (MonitoringDestination) this.consumerDestinations_.get(index);
    }

    public MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int index) {
        return (MonitoringDestinationOrBuilder) this.consumerDestinations_.get(index);
    }

    private void ensureConsumerDestinationsIsMutable() {
        if (!this.consumerDestinations_.isModifiable()) {
            this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_);
        }
    }

    /* access modifiers changed from: private */
    public void setConsumerDestinations(int index, MonitoringDestination value) {
        if (value != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setConsumerDestinations(int index, MonitoringDestination.Builder builderForValue) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(index, (MonitoringDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(MonitoringDestination value) {
        if (value != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(int index, MonitoringDestination value) {
        if (value != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(MonitoringDestination.Builder builderForValue) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add((MonitoringDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(int index, MonitoringDestination.Builder builderForValue) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(index, (MonitoringDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllConsumerDestinations(Iterable<? extends MonitoringDestination> values) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.addAll(values, this.consumerDestinations_);
    }

    /* access modifiers changed from: private */
    public void clearConsumerDestinations() {
        this.consumerDestinations_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeConsumerDestinations(int index) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.producerDestinations_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.producerDestinations_.get(i));
        }
        for (int i2 = 0; i2 < this.consumerDestinations_.size(); i2++) {
            output.writeMessage(2, (MessageLite) this.consumerDestinations_.get(i2));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.producerDestinations_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.producerDestinations_.get(i));
        }
        for (int i2 = 0; i2 < this.consumerDestinations_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.consumerDestinations_.get(i2));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Monitoring parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Monitoring parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Monitoring parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Monitoring parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Monitoring parseFrom(InputStream input) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Monitoring parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Monitoring parseDelimitedFrom(InputStream input) throws IOException {
        return (Monitoring) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Monitoring parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Monitoring) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Monitoring parseFrom(CodedInputStream input) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Monitoring parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Monitoring prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Monitoring, Builder> implements MonitoringOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Monitoring.DEFAULT_INSTANCE);
        }

        public List<MonitoringDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.instance).getProducerDestinationsList());
        }

        public int getProducerDestinationsCount() {
            return ((Monitoring) this.instance).getProducerDestinationsCount();
        }

        public MonitoringDestination getProducerDestinations(int index) {
            return ((Monitoring) this.instance).getProducerDestinations(index);
        }

        public Builder setProducerDestinations(int index, MonitoringDestination value) {
            copyOnWrite();
            ((Monitoring) this.instance).setProducerDestinations(index, value);
            return this;
        }

        public Builder setProducerDestinations(int index, MonitoringDestination.Builder builderForValue) {
            copyOnWrite();
            ((Monitoring) this.instance).setProducerDestinations(index, builderForValue);
            return this;
        }

        public Builder addProducerDestinations(MonitoringDestination value) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(value);
            return this;
        }

        public Builder addProducerDestinations(int index, MonitoringDestination value) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(index, value);
            return this;
        }

        public Builder addProducerDestinations(MonitoringDestination.Builder builderForValue) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(builderForValue);
            return this;
        }

        public Builder addProducerDestinations(int index, MonitoringDestination.Builder builderForValue) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(index, builderForValue);
            return this;
        }

        public Builder addAllProducerDestinations(Iterable<? extends MonitoringDestination> values) {
            copyOnWrite();
            ((Monitoring) this.instance).addAllProducerDestinations(values);
            return this;
        }

        public Builder clearProducerDestinations() {
            copyOnWrite();
            ((Monitoring) this.instance).clearProducerDestinations();
            return this;
        }

        public Builder removeProducerDestinations(int index) {
            copyOnWrite();
            ((Monitoring) this.instance).removeProducerDestinations(index);
            return this;
        }

        public List<MonitoringDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.instance).getConsumerDestinationsList());
        }

        public int getConsumerDestinationsCount() {
            return ((Monitoring) this.instance).getConsumerDestinationsCount();
        }

        public MonitoringDestination getConsumerDestinations(int index) {
            return ((Monitoring) this.instance).getConsumerDestinations(index);
        }

        public Builder setConsumerDestinations(int index, MonitoringDestination value) {
            copyOnWrite();
            ((Monitoring) this.instance).setConsumerDestinations(index, value);
            return this;
        }

        public Builder setConsumerDestinations(int index, MonitoringDestination.Builder builderForValue) {
            copyOnWrite();
            ((Monitoring) this.instance).setConsumerDestinations(index, builderForValue);
            return this;
        }

        public Builder addConsumerDestinations(MonitoringDestination value) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(value);
            return this;
        }

        public Builder addConsumerDestinations(int index, MonitoringDestination value) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(index, value);
            return this;
        }

        public Builder addConsumerDestinations(MonitoringDestination.Builder builderForValue) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(builderForValue);
            return this;
        }

        public Builder addConsumerDestinations(int index, MonitoringDestination.Builder builderForValue) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(index, builderForValue);
            return this;
        }

        public Builder addAllConsumerDestinations(Iterable<? extends MonitoringDestination> values) {
            copyOnWrite();
            ((Monitoring) this.instance).addAllConsumerDestinations(values);
            return this;
        }

        public Builder clearConsumerDestinations() {
            copyOnWrite();
            ((Monitoring) this.instance).clearConsumerDestinations();
            return this;
        }

        public Builder removeConsumerDestinations(int index) {
            copyOnWrite();
            ((Monitoring) this.instance).removeConsumerDestinations(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Monitoring();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.producerDestinations_.makeImmutable();
                this.consumerDestinations_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Monitoring other = (Monitoring) arg1;
                this.producerDestinations_ = visitor.visitList(this.producerDestinations_, other.producerDestinations_);
                this.consumerDestinations_ = visitor.visitList(this.consumerDestinations_, other.consumerDestinations_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                            if (!this.producerDestinations_.isModifiable()) {
                                this.producerDestinations_ = GeneratedMessageLite.mutableCopy(this.producerDestinations_);
                            }
                            this.producerDestinations_.add((MonitoringDestination) input.readMessage(MonitoringDestination.parser(), extensionRegistry));
                        } else if (tag == 18) {
                            if (!this.consumerDestinations_.isModifiable()) {
                                this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_);
                            }
                            this.consumerDestinations_.add((MonitoringDestination) input.readMessage(MonitoringDestination.parser(), extensionRegistry));
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
                    synchronized (Monitoring.class) {
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
        Monitoring monitoring = new Monitoring();
        DEFAULT_INSTANCE = monitoring;
        monitoring.makeImmutable();
    }

    public static Monitoring getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Monitoring> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
