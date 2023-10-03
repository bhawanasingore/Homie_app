package com.google.firestore.v1;

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
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class WriteResult extends GeneratedMessageLite<WriteResult, Builder> implements WriteResultOrBuilder {
    /* access modifiers changed from: private */
    public static final WriteResult DEFAULT_INSTANCE;
    private static volatile Parser<WriteResult> PARSER = null;
    public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
    public static final int UPDATE_TIME_FIELD_NUMBER = 1;
    private int bitField0_;
    private Internal.ProtobufList<Value> transformResults_ = emptyProtobufList();
    private Timestamp updateTime_;

    private WriteResult() {
    }

    public boolean hasUpdateTime() {
        return this.updateTime_ != null;
    }

    public Timestamp getUpdateTime() {
        Timestamp timestamp = this.updateTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setUpdateTime(Timestamp value) {
        if (value != null) {
            this.updateTime_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setUpdateTime(Timestamp.Builder builderForValue) {
        this.updateTime_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeUpdateTime(Timestamp value) {
        Timestamp timestamp = this.updateTime_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.updateTime_ = value;
        } else {
            this.updateTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.updateTime_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearUpdateTime() {
        this.updateTime_ = null;
    }

    public List<Value> getTransformResultsList() {
        return this.transformResults_;
    }

    public List<? extends ValueOrBuilder> getTransformResultsOrBuilderList() {
        return this.transformResults_;
    }

    public int getTransformResultsCount() {
        return this.transformResults_.size();
    }

    public Value getTransformResults(int index) {
        return (Value) this.transformResults_.get(index);
    }

    public ValueOrBuilder getTransformResultsOrBuilder(int index) {
        return (ValueOrBuilder) this.transformResults_.get(index);
    }

    private void ensureTransformResultsIsMutable() {
        if (!this.transformResults_.isModifiable()) {
            this.transformResults_ = GeneratedMessageLite.mutableCopy(this.transformResults_);
        }
    }

    /* access modifiers changed from: private */
    public void setTransformResults(int index, Value value) {
        if (value != null) {
            ensureTransformResultsIsMutable();
            this.transformResults_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setTransformResults(int index, Value.Builder builderForValue) {
        ensureTransformResultsIsMutable();
        this.transformResults_.set(index, (Value) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addTransformResults(Value value) {
        if (value != null) {
            ensureTransformResultsIsMutable();
            this.transformResults_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addTransformResults(int index, Value value) {
        if (value != null) {
            ensureTransformResultsIsMutable();
            this.transformResults_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addTransformResults(Value.Builder builderForValue) {
        ensureTransformResultsIsMutable();
        this.transformResults_.add((Value) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addTransformResults(int index, Value.Builder builderForValue) {
        ensureTransformResultsIsMutable();
        this.transformResults_.add(index, (Value) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllTransformResults(Iterable<? extends Value> values) {
        ensureTransformResultsIsMutable();
        AbstractMessageLite.addAll(values, this.transformResults_);
    }

    /* access modifiers changed from: private */
    public void clearTransformResults() {
        this.transformResults_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeTransformResults(int index) {
        ensureTransformResultsIsMutable();
        this.transformResults_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.updateTime_ != null) {
            output.writeMessage(1, getUpdateTime());
        }
        for (int i = 0; i < this.transformResults_.size(); i++) {
            output.writeMessage(2, (MessageLite) this.transformResults_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.updateTime_ != null) {
            size2 = 0 + CodedOutputStream.computeMessageSize(1, getUpdateTime());
        }
        for (int i = 0; i < this.transformResults_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.transformResults_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static WriteResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static WriteResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static WriteResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static WriteResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static WriteResult parseFrom(InputStream input) throws IOException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static WriteResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static WriteResult parseDelimitedFrom(InputStream input) throws IOException {
        return (WriteResult) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static WriteResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (WriteResult) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static WriteResult parseFrom(CodedInputStream input) throws IOException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static WriteResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WriteResult prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteResult, Builder> implements WriteResultOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(WriteResult.DEFAULT_INSTANCE);
        }

        public boolean hasUpdateTime() {
            return ((WriteResult) this.instance).hasUpdateTime();
        }

        public Timestamp getUpdateTime() {
            return ((WriteResult) this.instance).getUpdateTime();
        }

        public Builder setUpdateTime(Timestamp value) {
            copyOnWrite();
            ((WriteResult) this.instance).setUpdateTime(value);
            return this;
        }

        public Builder setUpdateTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((WriteResult) this.instance).setUpdateTime(builderForValue);
            return this;
        }

        public Builder mergeUpdateTime(Timestamp value) {
            copyOnWrite();
            ((WriteResult) this.instance).mergeUpdateTime(value);
            return this;
        }

        public Builder clearUpdateTime() {
            copyOnWrite();
            ((WriteResult) this.instance).clearUpdateTime();
            return this;
        }

        public List<Value> getTransformResultsList() {
            return Collections.unmodifiableList(((WriteResult) this.instance).getTransformResultsList());
        }

        public int getTransformResultsCount() {
            return ((WriteResult) this.instance).getTransformResultsCount();
        }

        public Value getTransformResults(int index) {
            return ((WriteResult) this.instance).getTransformResults(index);
        }

        public Builder setTransformResults(int index, Value value) {
            copyOnWrite();
            ((WriteResult) this.instance).setTransformResults(index, value);
            return this;
        }

        public Builder setTransformResults(int index, Value.Builder builderForValue) {
            copyOnWrite();
            ((WriteResult) this.instance).setTransformResults(index, builderForValue);
            return this;
        }

        public Builder addTransformResults(Value value) {
            copyOnWrite();
            ((WriteResult) this.instance).addTransformResults(value);
            return this;
        }

        public Builder addTransformResults(int index, Value value) {
            copyOnWrite();
            ((WriteResult) this.instance).addTransformResults(index, value);
            return this;
        }

        public Builder addTransformResults(Value.Builder builderForValue) {
            copyOnWrite();
            ((WriteResult) this.instance).addTransformResults(builderForValue);
            return this;
        }

        public Builder addTransformResults(int index, Value.Builder builderForValue) {
            copyOnWrite();
            ((WriteResult) this.instance).addTransformResults(index, builderForValue);
            return this;
        }

        public Builder addAllTransformResults(Iterable<? extends Value> values) {
            copyOnWrite();
            ((WriteResult) this.instance).addAllTransformResults(values);
            return this;
        }

        public Builder clearTransformResults() {
            copyOnWrite();
            ((WriteResult) this.instance).clearTransformResults();
            return this;
        }

        public Builder removeTransformResults(int index) {
            copyOnWrite();
            ((WriteResult) this.instance).removeTransformResults(index);
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.WriteResult$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
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
                return new WriteResult();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.transformResults_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                WriteResult other = (WriteResult) arg1;
                this.updateTime_ = (Timestamp) visitor.visitMessage(this.updateTime_, other.updateTime_);
                this.transformResults_ = visitor.visitList(this.transformResults_, other.transformResults_);
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
                            Timestamp.Builder subBuilder = null;
                            if (this.updateTime_ != null) {
                                subBuilder = (Timestamp.Builder) this.updateTime_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.updateTime_ = timestamp;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(timestamp);
                                this.updateTime_ = (Timestamp) subBuilder.buildPartial();
                            }
                        } else if (tag == 18) {
                            if (!this.transformResults_.isModifiable()) {
                                this.transformResults_ = GeneratedMessageLite.mutableCopy(this.transformResults_);
                            }
                            this.transformResults_.add((Value) input.readMessage(Value.parser(), extensionRegistry));
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
                    synchronized (WriteResult.class) {
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
        WriteResult writeResult = new WriteResult();
        DEFAULT_INSTANCE = writeResult;
        writeResult.makeImmutable();
    }

    public static WriteResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<WriteResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
