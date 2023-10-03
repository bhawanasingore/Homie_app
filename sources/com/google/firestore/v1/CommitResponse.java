package com.google.firestore.v1;

import com.google.firestore.v1.WriteResult;
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
public final class CommitResponse extends GeneratedMessageLite<CommitResponse, Builder> implements CommitResponseOrBuilder {
    public static final int COMMIT_TIME_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final CommitResponse DEFAULT_INSTANCE;
    private static volatile Parser<CommitResponse> PARSER = null;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 1;
    private int bitField0_;
    private Timestamp commitTime_;
    private Internal.ProtobufList<WriteResult> writeResults_ = emptyProtobufList();

    private CommitResponse() {
    }

    public List<WriteResult> getWriteResultsList() {
        return this.writeResults_;
    }

    public List<? extends WriteResultOrBuilder> getWriteResultsOrBuilderList() {
        return this.writeResults_;
    }

    public int getWriteResultsCount() {
        return this.writeResults_.size();
    }

    public WriteResult getWriteResults(int index) {
        return (WriteResult) this.writeResults_.get(index);
    }

    public WriteResultOrBuilder getWriteResultsOrBuilder(int index) {
        return (WriteResultOrBuilder) this.writeResults_.get(index);
    }

    private void ensureWriteResultsIsMutable() {
        if (!this.writeResults_.isModifiable()) {
            this.writeResults_ = GeneratedMessageLite.mutableCopy(this.writeResults_);
        }
    }

    /* access modifiers changed from: private */
    public void setWriteResults(int index, WriteResult value) {
        if (value != null) {
            ensureWriteResultsIsMutable();
            this.writeResults_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setWriteResults(int index, WriteResult.Builder builderForValue) {
        ensureWriteResultsIsMutable();
        this.writeResults_.set(index, (WriteResult) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addWriteResults(WriteResult value) {
        if (value != null) {
            ensureWriteResultsIsMutable();
            this.writeResults_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addWriteResults(int index, WriteResult value) {
        if (value != null) {
            ensureWriteResultsIsMutable();
            this.writeResults_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addWriteResults(WriteResult.Builder builderForValue) {
        ensureWriteResultsIsMutable();
        this.writeResults_.add((WriteResult) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addWriteResults(int index, WriteResult.Builder builderForValue) {
        ensureWriteResultsIsMutable();
        this.writeResults_.add(index, (WriteResult) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllWriteResults(Iterable<? extends WriteResult> values) {
        ensureWriteResultsIsMutable();
        AbstractMessageLite.addAll(values, this.writeResults_);
    }

    /* access modifiers changed from: private */
    public void clearWriteResults() {
        this.writeResults_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeWriteResults(int index) {
        ensureWriteResultsIsMutable();
        this.writeResults_.remove(index);
    }

    public boolean hasCommitTime() {
        return this.commitTime_ != null;
    }

    public Timestamp getCommitTime() {
        Timestamp timestamp = this.commitTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setCommitTime(Timestamp value) {
        if (value != null) {
            this.commitTime_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setCommitTime(Timestamp.Builder builderForValue) {
        this.commitTime_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeCommitTime(Timestamp value) {
        Timestamp timestamp = this.commitTime_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.commitTime_ = value;
        } else {
            this.commitTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.commitTime_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearCommitTime() {
        this.commitTime_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.writeResults_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.writeResults_.get(i));
        }
        if (this.commitTime_ != null) {
            output.writeMessage(2, getCommitTime());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.writeResults_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.writeResults_.get(i));
        }
        if (this.commitTime_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getCommitTime());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static CommitResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CommitResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CommitResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CommitResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CommitResponse parseFrom(InputStream input) throws IOException {
        return (CommitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CommitResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CommitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CommitResponse parseDelimitedFrom(InputStream input) throws IOException {
        return (CommitResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static CommitResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CommitResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CommitResponse parseFrom(CodedInputStream input) throws IOException {
        return (CommitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CommitResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CommitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CommitResponse prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<CommitResponse, Builder> implements CommitResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(CommitResponse.DEFAULT_INSTANCE);
        }

        public List<WriteResult> getWriteResultsList() {
            return Collections.unmodifiableList(((CommitResponse) this.instance).getWriteResultsList());
        }

        public int getWriteResultsCount() {
            return ((CommitResponse) this.instance).getWriteResultsCount();
        }

        public WriteResult getWriteResults(int index) {
            return ((CommitResponse) this.instance).getWriteResults(index);
        }

        public Builder setWriteResults(int index, WriteResult value) {
            copyOnWrite();
            ((CommitResponse) this.instance).setWriteResults(index, value);
            return this;
        }

        public Builder setWriteResults(int index, WriteResult.Builder builderForValue) {
            copyOnWrite();
            ((CommitResponse) this.instance).setWriteResults(index, builderForValue);
            return this;
        }

        public Builder addWriteResults(WriteResult value) {
            copyOnWrite();
            ((CommitResponse) this.instance).addWriteResults(value);
            return this;
        }

        public Builder addWriteResults(int index, WriteResult value) {
            copyOnWrite();
            ((CommitResponse) this.instance).addWriteResults(index, value);
            return this;
        }

        public Builder addWriteResults(WriteResult.Builder builderForValue) {
            copyOnWrite();
            ((CommitResponse) this.instance).addWriteResults(builderForValue);
            return this;
        }

        public Builder addWriteResults(int index, WriteResult.Builder builderForValue) {
            copyOnWrite();
            ((CommitResponse) this.instance).addWriteResults(index, builderForValue);
            return this;
        }

        public Builder addAllWriteResults(Iterable<? extends WriteResult> values) {
            copyOnWrite();
            ((CommitResponse) this.instance).addAllWriteResults(values);
            return this;
        }

        public Builder clearWriteResults() {
            copyOnWrite();
            ((CommitResponse) this.instance).clearWriteResults();
            return this;
        }

        public Builder removeWriteResults(int index) {
            copyOnWrite();
            ((CommitResponse) this.instance).removeWriteResults(index);
            return this;
        }

        public boolean hasCommitTime() {
            return ((CommitResponse) this.instance).hasCommitTime();
        }

        public Timestamp getCommitTime() {
            return ((CommitResponse) this.instance).getCommitTime();
        }

        public Builder setCommitTime(Timestamp value) {
            copyOnWrite();
            ((CommitResponse) this.instance).setCommitTime(value);
            return this;
        }

        public Builder setCommitTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((CommitResponse) this.instance).setCommitTime(builderForValue);
            return this;
        }

        public Builder mergeCommitTime(Timestamp value) {
            copyOnWrite();
            ((CommitResponse) this.instance).mergeCommitTime(value);
            return this;
        }

        public Builder clearCommitTime() {
            copyOnWrite();
            ((CommitResponse) this.instance).clearCommitTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.CommitResponse$1  reason: invalid class name */
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
                return new CommitResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.writeResults_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                CommitResponse other = (CommitResponse) arg1;
                this.writeResults_ = visitor.visitList(this.writeResults_, other.writeResults_);
                this.commitTime_ = (Timestamp) visitor.visitMessage(this.commitTime_, other.commitTime_);
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
                            if (!this.writeResults_.isModifiable()) {
                                this.writeResults_ = GeneratedMessageLite.mutableCopy(this.writeResults_);
                            }
                            this.writeResults_.add((WriteResult) input.readMessage(WriteResult.parser(), extensionRegistry));
                        } else if (tag == 18) {
                            Timestamp.Builder subBuilder = null;
                            if (this.commitTime_ != null) {
                                subBuilder = (Timestamp.Builder) this.commitTime_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.commitTime_ = timestamp;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(timestamp);
                                this.commitTime_ = (Timestamp) subBuilder.buildPartial();
                            }
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
                    synchronized (CommitResponse.class) {
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
        CommitResponse commitResponse = new CommitResponse();
        DEFAULT_INSTANCE = commitResponse;
        commitResponse.makeImmutable();
    }

    public static CommitResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CommitResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
