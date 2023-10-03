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
public final class Billing extends GeneratedMessageLite<Billing, Builder> implements BillingOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 8;
    /* access modifiers changed from: private */
    public static final Billing DEFAULT_INSTANCE;
    private static volatile Parser<Billing> PARSER;
    private Internal.ProtobufList<BillingDestination> consumerDestinations_ = emptyProtobufList();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface BillingDestinationOrBuilder extends MessageLiteOrBuilder {
        String getMetrics(int i);

        ByteString getMetricsBytes(int i);

        int getMetricsCount();

        List<String> getMetricsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    private Billing() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class BillingDestination extends GeneratedMessageLite<BillingDestination, Builder> implements BillingDestinationOrBuilder {
        /* access modifiers changed from: private */
        public static final BillingDestination DEFAULT_INSTANCE;
        public static final int METRICS_FIELD_NUMBER = 2;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
        private static volatile Parser<BillingDestination> PARSER;
        private int bitField0_;
        private Internal.ProtobufList<String> metrics_ = GeneratedMessageLite.emptyProtobufList();
        private String monitoredResource_ = "";

        private BillingDestination() {
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

        public static BillingDestination parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static BillingDestination parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static BillingDestination parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static BillingDestination parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static BillingDestination parseFrom(InputStream input) throws IOException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static BillingDestination parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static BillingDestination parseDelimitedFrom(InputStream input) throws IOException {
            return (BillingDestination) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static BillingDestination parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BillingDestination) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static BillingDestination parseFrom(CodedInputStream input) throws IOException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static BillingDestination parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BillingDestination prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<BillingDestination, Builder> implements BillingDestinationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(BillingDestination.DEFAULT_INSTANCE);
            }

            public String getMonitoredResource() {
                return ((BillingDestination) this.instance).getMonitoredResource();
            }

            public ByteString getMonitoredResourceBytes() {
                return ((BillingDestination) this.instance).getMonitoredResourceBytes();
            }

            public Builder setMonitoredResource(String value) {
                copyOnWrite();
                ((BillingDestination) this.instance).setMonitoredResource(value);
                return this;
            }

            public Builder clearMonitoredResource() {
                copyOnWrite();
                ((BillingDestination) this.instance).clearMonitoredResource();
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString value) {
                copyOnWrite();
                ((BillingDestination) this.instance).setMonitoredResourceBytes(value);
                return this;
            }

            public List<String> getMetricsList() {
                return Collections.unmodifiableList(((BillingDestination) this.instance).getMetricsList());
            }

            public int getMetricsCount() {
                return ((BillingDestination) this.instance).getMetricsCount();
            }

            public String getMetrics(int index) {
                return ((BillingDestination) this.instance).getMetrics(index);
            }

            public ByteString getMetricsBytes(int index) {
                return ((BillingDestination) this.instance).getMetricsBytes(index);
            }

            public Builder setMetrics(int index, String value) {
                copyOnWrite();
                ((BillingDestination) this.instance).setMetrics(index, value);
                return this;
            }

            public Builder addMetrics(String value) {
                copyOnWrite();
                ((BillingDestination) this.instance).addMetrics(value);
                return this;
            }

            public Builder addAllMetrics(Iterable<String> values) {
                copyOnWrite();
                ((BillingDestination) this.instance).addAllMetrics(values);
                return this;
            }

            public Builder clearMetrics() {
                copyOnWrite();
                ((BillingDestination) this.instance).clearMetrics();
                return this;
            }

            public Builder addMetricsBytes(ByteString value) {
                copyOnWrite();
                ((BillingDestination) this.instance).addMetricsBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new BillingDestination();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.metrics_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    BillingDestination other = (BillingDestination) arg1;
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
                        synchronized (BillingDestination.class) {
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
            BillingDestination billingDestination = new BillingDestination();
            DEFAULT_INSTANCE = billingDestination;
            billingDestination.makeImmutable();
        }

        public static BillingDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BillingDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Billing$1  reason: invalid class name */
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

    public List<BillingDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public List<? extends BillingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    public BillingDestination getConsumerDestinations(int index) {
        return (BillingDestination) this.consumerDestinations_.get(index);
    }

    public BillingDestinationOrBuilder getConsumerDestinationsOrBuilder(int index) {
        return (BillingDestinationOrBuilder) this.consumerDestinations_.get(index);
    }

    private void ensureConsumerDestinationsIsMutable() {
        if (!this.consumerDestinations_.isModifiable()) {
            this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_);
        }
    }

    /* access modifiers changed from: private */
    public void setConsumerDestinations(int index, BillingDestination value) {
        if (value != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setConsumerDestinations(int index, BillingDestination.Builder builderForValue) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(index, (BillingDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(BillingDestination value) {
        if (value != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(int index, BillingDestination value) {
        if (value != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(BillingDestination.Builder builderForValue) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add((BillingDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(int index, BillingDestination.Builder builderForValue) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(index, (BillingDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllConsumerDestinations(Iterable<? extends BillingDestination> values) {
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
        for (int i = 0; i < this.consumerDestinations_.size(); i++) {
            output.writeMessage(8, (MessageLite) this.consumerDestinations_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.consumerDestinations_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(8, (MessageLite) this.consumerDestinations_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Billing parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Billing parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Billing parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Billing parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Billing parseFrom(InputStream input) throws IOException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Billing parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Billing parseDelimitedFrom(InputStream input) throws IOException {
        return (Billing) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Billing parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Billing) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Billing parseFrom(CodedInputStream input) throws IOException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Billing parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Billing prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Billing, Builder> implements BillingOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Billing.DEFAULT_INSTANCE);
        }

        public List<BillingDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Billing) this.instance).getConsumerDestinationsList());
        }

        public int getConsumerDestinationsCount() {
            return ((Billing) this.instance).getConsumerDestinationsCount();
        }

        public BillingDestination getConsumerDestinations(int index) {
            return ((Billing) this.instance).getConsumerDestinations(index);
        }

        public Builder setConsumerDestinations(int index, BillingDestination value) {
            copyOnWrite();
            ((Billing) this.instance).setConsumerDestinations(index, value);
            return this;
        }

        public Builder setConsumerDestinations(int index, BillingDestination.Builder builderForValue) {
            copyOnWrite();
            ((Billing) this.instance).setConsumerDestinations(index, builderForValue);
            return this;
        }

        public Builder addConsumerDestinations(BillingDestination value) {
            copyOnWrite();
            ((Billing) this.instance).addConsumerDestinations(value);
            return this;
        }

        public Builder addConsumerDestinations(int index, BillingDestination value) {
            copyOnWrite();
            ((Billing) this.instance).addConsumerDestinations(index, value);
            return this;
        }

        public Builder addConsumerDestinations(BillingDestination.Builder builderForValue) {
            copyOnWrite();
            ((Billing) this.instance).addConsumerDestinations(builderForValue);
            return this;
        }

        public Builder addConsumerDestinations(int index, BillingDestination.Builder builderForValue) {
            copyOnWrite();
            ((Billing) this.instance).addConsumerDestinations(index, builderForValue);
            return this;
        }

        public Builder addAllConsumerDestinations(Iterable<? extends BillingDestination> values) {
            copyOnWrite();
            ((Billing) this.instance).addAllConsumerDestinations(values);
            return this;
        }

        public Builder clearConsumerDestinations() {
            copyOnWrite();
            ((Billing) this.instance).clearConsumerDestinations();
            return this;
        }

        public Builder removeConsumerDestinations(int index) {
            copyOnWrite();
            ((Billing) this.instance).removeConsumerDestinations(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Billing();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.consumerDestinations_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.consumerDestinations_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.consumerDestinations_, ((Billing) arg1).consumerDestinations_);
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
                        } else if (tag == 66) {
                            if (!this.consumerDestinations_.isModifiable()) {
                                this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_);
                            }
                            this.consumerDestinations_.add((BillingDestination) input.readMessage(BillingDestination.parser(), extensionRegistry));
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
                    synchronized (Billing.class) {
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
        Billing billing = new Billing();
        DEFAULT_INSTANCE = billing;
        billing.makeImmutable();
    }

    public static Billing getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Billing> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
