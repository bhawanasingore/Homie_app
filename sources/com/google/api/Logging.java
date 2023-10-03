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
public final class Logging extends GeneratedMessageLite<Logging, Builder> implements LoggingOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Logging DEFAULT_INSTANCE;
    private static volatile Parser<Logging> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<LoggingDestination> consumerDestinations_ = emptyProtobufList();
    private Internal.ProtobufList<LoggingDestination> producerDestinations_ = emptyProtobufList();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface LoggingDestinationOrBuilder extends MessageLiteOrBuilder {
        String getLogs(int i);

        ByteString getLogsBytes(int i);

        int getLogsCount();

        List<String> getLogsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    private Logging() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class LoggingDestination extends GeneratedMessageLite<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
        /* access modifiers changed from: private */
        public static final LoggingDestination DEFAULT_INSTANCE;
        public static final int LOGS_FIELD_NUMBER = 1;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 3;
        private static volatile Parser<LoggingDestination> PARSER;
        private int bitField0_;
        private Internal.ProtobufList<String> logs_ = GeneratedMessageLite.emptyProtobufList();
        private String monitoredResource_ = "";

        private LoggingDestination() {
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

        public List<String> getLogsList() {
            return this.logs_;
        }

        public int getLogsCount() {
            return this.logs_.size();
        }

        public String getLogs(int index) {
            return (String) this.logs_.get(index);
        }

        public ByteString getLogsBytes(int index) {
            return ByteString.copyFromUtf8((String) this.logs_.get(index));
        }

        private void ensureLogsIsMutable() {
            if (!this.logs_.isModifiable()) {
                this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_);
            }
        }

        /* access modifiers changed from: private */
        public void setLogs(int index, String value) {
            if (value != null) {
                ensureLogsIsMutable();
                this.logs_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addLogs(String value) {
            if (value != null) {
                ensureLogsIsMutable();
                this.logs_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addAllLogs(Iterable<String> values) {
            ensureLogsIsMutable();
            AbstractMessageLite.addAll(values, this.logs_);
        }

        /* access modifiers changed from: private */
        public void clearLogs() {
            this.logs_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addLogsBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                ensureLogsIsMutable();
                this.logs_.add(value.toStringUtf8());
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.logs_.size(); i++) {
                output.writeString(1, (String) this.logs_.get(i));
            }
            if (!this.monitoredResource_.isEmpty()) {
                output.writeString(3, getMonitoredResource());
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.logs_.size(); i++) {
                dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.logs_.get(i));
            }
            int size2 = 0 + dataSize + (getLogsList().size() * 1);
            if (!this.monitoredResource_.isEmpty()) {
                size2 += CodedOutputStream.computeStringSize(3, getMonitoredResource());
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static LoggingDestination parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LoggingDestination parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LoggingDestination parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LoggingDestination parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LoggingDestination parseFrom(InputStream input) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LoggingDestination parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LoggingDestination parseDelimitedFrom(InputStream input) throws IOException {
            return (LoggingDestination) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static LoggingDestination parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoggingDestination) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LoggingDestination parseFrom(CodedInputStream input) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LoggingDestination parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LoggingDestination prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(LoggingDestination.DEFAULT_INSTANCE);
            }

            public String getMonitoredResource() {
                return ((LoggingDestination) this.instance).getMonitoredResource();
            }

            public ByteString getMonitoredResourceBytes() {
                return ((LoggingDestination) this.instance).getMonitoredResourceBytes();
            }

            public Builder setMonitoredResource(String value) {
                copyOnWrite();
                ((LoggingDestination) this.instance).setMonitoredResource(value);
                return this;
            }

            public Builder clearMonitoredResource() {
                copyOnWrite();
                ((LoggingDestination) this.instance).clearMonitoredResource();
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString value) {
                copyOnWrite();
                ((LoggingDestination) this.instance).setMonitoredResourceBytes(value);
                return this;
            }

            public List<String> getLogsList() {
                return Collections.unmodifiableList(((LoggingDestination) this.instance).getLogsList());
            }

            public int getLogsCount() {
                return ((LoggingDestination) this.instance).getLogsCount();
            }

            public String getLogs(int index) {
                return ((LoggingDestination) this.instance).getLogs(index);
            }

            public ByteString getLogsBytes(int index) {
                return ((LoggingDestination) this.instance).getLogsBytes(index);
            }

            public Builder setLogs(int index, String value) {
                copyOnWrite();
                ((LoggingDestination) this.instance).setLogs(index, value);
                return this;
            }

            public Builder addLogs(String value) {
                copyOnWrite();
                ((LoggingDestination) this.instance).addLogs(value);
                return this;
            }

            public Builder addAllLogs(Iterable<String> values) {
                copyOnWrite();
                ((LoggingDestination) this.instance).addAllLogs(values);
                return this;
            }

            public Builder clearLogs() {
                copyOnWrite();
                ((LoggingDestination) this.instance).clearLogs();
                return this;
            }

            public Builder addLogsBytes(ByteString value) {
                copyOnWrite();
                ((LoggingDestination) this.instance).addLogsBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new LoggingDestination();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.logs_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    LoggingDestination other = (LoggingDestination) arg1;
                    this.monitoredResource_ = visitor.visitString(!this.monitoredResource_.isEmpty(), this.monitoredResource_, !other.monitoredResource_.isEmpty(), other.monitoredResource_);
                    this.logs_ = visitor.visitList(this.logs_, other.logs_);
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
                                String s = input.readStringRequireUtf8();
                                if (!this.logs_.isModifiable()) {
                                    this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_);
                                }
                                this.logs_.add(s);
                            } else if (tag == 26) {
                                this.monitoredResource_ = input.readStringRequireUtf8();
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
                        synchronized (LoggingDestination.class) {
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
            LoggingDestination loggingDestination = new LoggingDestination();
            DEFAULT_INSTANCE = loggingDestination;
            loggingDestination.makeImmutable();
        }

        public static LoggingDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LoggingDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Logging$1  reason: invalid class name */
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

    public List<LoggingDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    public List<? extends LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    public LoggingDestination getProducerDestinations(int index) {
        return (LoggingDestination) this.producerDestinations_.get(index);
    }

    public LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int index) {
        return (LoggingDestinationOrBuilder) this.producerDestinations_.get(index);
    }

    private void ensureProducerDestinationsIsMutable() {
        if (!this.producerDestinations_.isModifiable()) {
            this.producerDestinations_ = GeneratedMessageLite.mutableCopy(this.producerDestinations_);
        }
    }

    /* access modifiers changed from: private */
    public void setProducerDestinations(int index, LoggingDestination value) {
        if (value != null) {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setProducerDestinations(int index, LoggingDestination.Builder builderForValue) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(index, (LoggingDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(LoggingDestination value) {
        if (value != null) {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(int index, LoggingDestination value) {
        if (value != null) {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(LoggingDestination.Builder builderForValue) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add((LoggingDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addProducerDestinations(int index, LoggingDestination.Builder builderForValue) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(index, (LoggingDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllProducerDestinations(Iterable<? extends LoggingDestination> values) {
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

    public List<LoggingDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public List<? extends LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    public LoggingDestination getConsumerDestinations(int index) {
        return (LoggingDestination) this.consumerDestinations_.get(index);
    }

    public LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int index) {
        return (LoggingDestinationOrBuilder) this.consumerDestinations_.get(index);
    }

    private void ensureConsumerDestinationsIsMutable() {
        if (!this.consumerDestinations_.isModifiable()) {
            this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_);
        }
    }

    /* access modifiers changed from: private */
    public void setConsumerDestinations(int index, LoggingDestination value) {
        if (value != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setConsumerDestinations(int index, LoggingDestination.Builder builderForValue) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(index, (LoggingDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(LoggingDestination value) {
        if (value != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(int index, LoggingDestination value) {
        if (value != null) {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(LoggingDestination.Builder builderForValue) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add((LoggingDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addConsumerDestinations(int index, LoggingDestination.Builder builderForValue) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(index, (LoggingDestination) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllConsumerDestinations(Iterable<? extends LoggingDestination> values) {
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

    public static Logging parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Logging parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Logging parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Logging parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Logging parseFrom(InputStream input) throws IOException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Logging parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Logging parseDelimitedFrom(InputStream input) throws IOException {
        return (Logging) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Logging parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Logging) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Logging parseFrom(CodedInputStream input) throws IOException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Logging parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Logging prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Logging, Builder> implements LoggingOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Logging.DEFAULT_INSTANCE);
        }

        public List<LoggingDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(((Logging) this.instance).getProducerDestinationsList());
        }

        public int getProducerDestinationsCount() {
            return ((Logging) this.instance).getProducerDestinationsCount();
        }

        public LoggingDestination getProducerDestinations(int index) {
            return ((Logging) this.instance).getProducerDestinations(index);
        }

        public Builder setProducerDestinations(int index, LoggingDestination value) {
            copyOnWrite();
            ((Logging) this.instance).setProducerDestinations(index, value);
            return this;
        }

        public Builder setProducerDestinations(int index, LoggingDestination.Builder builderForValue) {
            copyOnWrite();
            ((Logging) this.instance).setProducerDestinations(index, builderForValue);
            return this;
        }

        public Builder addProducerDestinations(LoggingDestination value) {
            copyOnWrite();
            ((Logging) this.instance).addProducerDestinations(value);
            return this;
        }

        public Builder addProducerDestinations(int index, LoggingDestination value) {
            copyOnWrite();
            ((Logging) this.instance).addProducerDestinations(index, value);
            return this;
        }

        public Builder addProducerDestinations(LoggingDestination.Builder builderForValue) {
            copyOnWrite();
            ((Logging) this.instance).addProducerDestinations(builderForValue);
            return this;
        }

        public Builder addProducerDestinations(int index, LoggingDestination.Builder builderForValue) {
            copyOnWrite();
            ((Logging) this.instance).addProducerDestinations(index, builderForValue);
            return this;
        }

        public Builder addAllProducerDestinations(Iterable<? extends LoggingDestination> values) {
            copyOnWrite();
            ((Logging) this.instance).addAllProducerDestinations(values);
            return this;
        }

        public Builder clearProducerDestinations() {
            copyOnWrite();
            ((Logging) this.instance).clearProducerDestinations();
            return this;
        }

        public Builder removeProducerDestinations(int index) {
            copyOnWrite();
            ((Logging) this.instance).removeProducerDestinations(index);
            return this;
        }

        public List<LoggingDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Logging) this.instance).getConsumerDestinationsList());
        }

        public int getConsumerDestinationsCount() {
            return ((Logging) this.instance).getConsumerDestinationsCount();
        }

        public LoggingDestination getConsumerDestinations(int index) {
            return ((Logging) this.instance).getConsumerDestinations(index);
        }

        public Builder setConsumerDestinations(int index, LoggingDestination value) {
            copyOnWrite();
            ((Logging) this.instance).setConsumerDestinations(index, value);
            return this;
        }

        public Builder setConsumerDestinations(int index, LoggingDestination.Builder builderForValue) {
            copyOnWrite();
            ((Logging) this.instance).setConsumerDestinations(index, builderForValue);
            return this;
        }

        public Builder addConsumerDestinations(LoggingDestination value) {
            copyOnWrite();
            ((Logging) this.instance).addConsumerDestinations(value);
            return this;
        }

        public Builder addConsumerDestinations(int index, LoggingDestination value) {
            copyOnWrite();
            ((Logging) this.instance).addConsumerDestinations(index, value);
            return this;
        }

        public Builder addConsumerDestinations(LoggingDestination.Builder builderForValue) {
            copyOnWrite();
            ((Logging) this.instance).addConsumerDestinations(builderForValue);
            return this;
        }

        public Builder addConsumerDestinations(int index, LoggingDestination.Builder builderForValue) {
            copyOnWrite();
            ((Logging) this.instance).addConsumerDestinations(index, builderForValue);
            return this;
        }

        public Builder addAllConsumerDestinations(Iterable<? extends LoggingDestination> values) {
            copyOnWrite();
            ((Logging) this.instance).addAllConsumerDestinations(values);
            return this;
        }

        public Builder clearConsumerDestinations() {
            copyOnWrite();
            ((Logging) this.instance).clearConsumerDestinations();
            return this;
        }

        public Builder removeConsumerDestinations(int index) {
            copyOnWrite();
            ((Logging) this.instance).removeConsumerDestinations(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Logging();
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
                Logging other = (Logging) arg1;
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
                            this.producerDestinations_.add((LoggingDestination) input.readMessage(LoggingDestination.parser(), extensionRegistry));
                        } else if (tag == 18) {
                            if (!this.consumerDestinations_.isModifiable()) {
                                this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_);
                            }
                            this.consumerDestinations_.add((LoggingDestination) input.readMessage(LoggingDestination.parser(), extensionRegistry));
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
                    synchronized (Logging.class) {
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
        Logging logging = new Logging();
        DEFAULT_INSTANCE = logging;
        logging.makeImmutable();
    }

    public static Logging getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Logging> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
