package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteOrBuilder;
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
public final class WriteBatch extends GeneratedMessageLite<WriteBatch, Builder> implements WriteBatchOrBuilder {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final WriteBatch DEFAULT_INSTANCE;
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile Parser<WriteBatch> PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private Internal.ProtobufList<Write> baseWrites_ = emptyProtobufList();
    private int batchId_;
    private int bitField0_;
    private Timestamp localWriteTime_;
    private Internal.ProtobufList<Write> writes_ = emptyProtobufList();

    private WriteBatch() {
    }

    public int getBatchId() {
        return this.batchId_;
    }

    /* access modifiers changed from: private */
    public void setBatchId(int value) {
        this.batchId_ = value;
    }

    /* access modifiers changed from: private */
    public void clearBatchId() {
        this.batchId_ = 0;
    }

    public List<Write> getWritesList() {
        return this.writes_;
    }

    public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
        return this.writes_;
    }

    public int getWritesCount() {
        return this.writes_.size();
    }

    public Write getWrites(int index) {
        return (Write) this.writes_.get(index);
    }

    public WriteOrBuilder getWritesOrBuilder(int index) {
        return (WriteOrBuilder) this.writes_.get(index);
    }

    private void ensureWritesIsMutable() {
        if (!this.writes_.isModifiable()) {
            this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_);
        }
    }

    /* access modifiers changed from: private */
    public void setWrites(int index, Write value) {
        if (value != null) {
            ensureWritesIsMutable();
            this.writes_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setWrites(int index, Write.Builder builderForValue) {
        ensureWritesIsMutable();
        this.writes_.set(index, (Write) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addWrites(Write value) {
        if (value != null) {
            ensureWritesIsMutable();
            this.writes_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addWrites(int index, Write value) {
        if (value != null) {
            ensureWritesIsMutable();
            this.writes_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addWrites(Write.Builder builderForValue) {
        ensureWritesIsMutable();
        this.writes_.add((Write) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addWrites(int index, Write.Builder builderForValue) {
        ensureWritesIsMutable();
        this.writes_.add(index, (Write) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllWrites(Iterable<? extends Write> values) {
        ensureWritesIsMutable();
        AbstractMessageLite.addAll(values, this.writes_);
    }

    /* access modifiers changed from: private */
    public void clearWrites() {
        this.writes_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeWrites(int index) {
        ensureWritesIsMutable();
        this.writes_.remove(index);
    }

    public boolean hasLocalWriteTime() {
        return this.localWriteTime_ != null;
    }

    public Timestamp getLocalWriteTime() {
        Timestamp timestamp = this.localWriteTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setLocalWriteTime(Timestamp value) {
        if (value != null) {
            this.localWriteTime_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLocalWriteTime(Timestamp.Builder builderForValue) {
        this.localWriteTime_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeLocalWriteTime(Timestamp value) {
        Timestamp timestamp = this.localWriteTime_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.localWriteTime_ = value;
        } else {
            this.localWriteTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.localWriteTime_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLocalWriteTime() {
        this.localWriteTime_ = null;
    }

    public List<Write> getBaseWritesList() {
        return this.baseWrites_;
    }

    public List<? extends WriteOrBuilder> getBaseWritesOrBuilderList() {
        return this.baseWrites_;
    }

    public int getBaseWritesCount() {
        return this.baseWrites_.size();
    }

    public Write getBaseWrites(int index) {
        return (Write) this.baseWrites_.get(index);
    }

    public WriteOrBuilder getBaseWritesOrBuilder(int index) {
        return (WriteOrBuilder) this.baseWrites_.get(index);
    }

    private void ensureBaseWritesIsMutable() {
        if (!this.baseWrites_.isModifiable()) {
            this.baseWrites_ = GeneratedMessageLite.mutableCopy(this.baseWrites_);
        }
    }

    /* access modifiers changed from: private */
    public void setBaseWrites(int index, Write value) {
        if (value != null) {
            ensureBaseWritesIsMutable();
            this.baseWrites_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setBaseWrites(int index, Write.Builder builderForValue) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.set(index, (Write) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addBaseWrites(Write value) {
        if (value != null) {
            ensureBaseWritesIsMutable();
            this.baseWrites_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addBaseWrites(int index, Write value) {
        if (value != null) {
            ensureBaseWritesIsMutable();
            this.baseWrites_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addBaseWrites(Write.Builder builderForValue) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.add((Write) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addBaseWrites(int index, Write.Builder builderForValue) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(index, (Write) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllBaseWrites(Iterable<? extends Write> values) {
        ensureBaseWritesIsMutable();
        AbstractMessageLite.addAll(values, this.baseWrites_);
    }

    /* access modifiers changed from: private */
    public void clearBaseWrites() {
        this.baseWrites_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeBaseWrites(int index) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = this.batchId_;
        if (i != 0) {
            output.writeInt32(1, i);
        }
        for (int i2 = 0; i2 < this.writes_.size(); i2++) {
            output.writeMessage(2, (MessageLite) this.writes_.get(i2));
        }
        if (this.localWriteTime_ != null) {
            output.writeMessage(3, getLocalWriteTime());
        }
        for (int i3 = 0; i3 < this.baseWrites_.size(); i3++) {
            output.writeMessage(4, (MessageLite) this.baseWrites_.get(i3));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.batchId_;
        if (i != 0) {
            size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
        }
        for (int i2 = 0; i2 < this.writes_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.writes_.get(i2));
        }
        if (this.localWriteTime_ != null) {
            size2 += CodedOutputStream.computeMessageSize(3, getLocalWriteTime());
        }
        for (int i3 = 0; i3 < this.baseWrites_.size(); i3++) {
            size2 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.baseWrites_.get(i3));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static WriteBatch parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static WriteBatch parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static WriteBatch parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static WriteBatch parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static WriteBatch parseFrom(InputStream input) throws IOException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static WriteBatch parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static WriteBatch parseDelimitedFrom(InputStream input) throws IOException {
        return (WriteBatch) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static WriteBatch parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (WriteBatch) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static WriteBatch parseFrom(CodedInputStream input) throws IOException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static WriteBatch parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WriteBatch prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteBatch, Builder> implements WriteBatchOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(WriteBatch.DEFAULT_INSTANCE);
        }

        public int getBatchId() {
            return ((WriteBatch) this.instance).getBatchId();
        }

        public Builder setBatchId(int value) {
            copyOnWrite();
            ((WriteBatch) this.instance).setBatchId(value);
            return this;
        }

        public Builder clearBatchId() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearBatchId();
            return this;
        }

        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.instance).getWritesList());
        }

        public int getWritesCount() {
            return ((WriteBatch) this.instance).getWritesCount();
        }

        public Write getWrites(int index) {
            return ((WriteBatch) this.instance).getWrites(index);
        }

        public Builder setWrites(int index, Write value) {
            copyOnWrite();
            ((WriteBatch) this.instance).setWrites(index, value);
            return this;
        }

        public Builder setWrites(int index, Write.Builder builderForValue) {
            copyOnWrite();
            ((WriteBatch) this.instance).setWrites(index, builderForValue);
            return this;
        }

        public Builder addWrites(Write value) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(value);
            return this;
        }

        public Builder addWrites(int index, Write value) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(index, value);
            return this;
        }

        public Builder addWrites(Write.Builder builderForValue) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(builderForValue);
            return this;
        }

        public Builder addWrites(int index, Write.Builder builderForValue) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(index, builderForValue);
            return this;
        }

        public Builder addAllWrites(Iterable<? extends Write> values) {
            copyOnWrite();
            ((WriteBatch) this.instance).addAllWrites(values);
            return this;
        }

        public Builder clearWrites() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearWrites();
            return this;
        }

        public Builder removeWrites(int index) {
            copyOnWrite();
            ((WriteBatch) this.instance).removeWrites(index);
            return this;
        }

        public boolean hasLocalWriteTime() {
            return ((WriteBatch) this.instance).hasLocalWriteTime();
        }

        public Timestamp getLocalWriteTime() {
            return ((WriteBatch) this.instance).getLocalWriteTime();
        }

        public Builder setLocalWriteTime(Timestamp value) {
            copyOnWrite();
            ((WriteBatch) this.instance).setLocalWriteTime(value);
            return this;
        }

        public Builder setLocalWriteTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((WriteBatch) this.instance).setLocalWriteTime(builderForValue);
            return this;
        }

        public Builder mergeLocalWriteTime(Timestamp value) {
            copyOnWrite();
            ((WriteBatch) this.instance).mergeLocalWriteTime(value);
            return this;
        }

        public Builder clearLocalWriteTime() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearLocalWriteTime();
            return this;
        }

        public List<Write> getBaseWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.instance).getBaseWritesList());
        }

        public int getBaseWritesCount() {
            return ((WriteBatch) this.instance).getBaseWritesCount();
        }

        public Write getBaseWrites(int index) {
            return ((WriteBatch) this.instance).getBaseWrites(index);
        }

        public Builder setBaseWrites(int index, Write value) {
            copyOnWrite();
            ((WriteBatch) this.instance).setBaseWrites(index, value);
            return this;
        }

        public Builder setBaseWrites(int index, Write.Builder builderForValue) {
            copyOnWrite();
            ((WriteBatch) this.instance).setBaseWrites(index, builderForValue);
            return this;
        }

        public Builder addBaseWrites(Write value) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(value);
            return this;
        }

        public Builder addBaseWrites(int index, Write value) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(index, value);
            return this;
        }

        public Builder addBaseWrites(Write.Builder builderForValue) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(builderForValue);
            return this;
        }

        public Builder addBaseWrites(int index, Write.Builder builderForValue) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(index, builderForValue);
            return this;
        }

        public Builder addAllBaseWrites(Iterable<? extends Write> values) {
            copyOnWrite();
            ((WriteBatch) this.instance).addAllBaseWrites(values);
            return this;
        }

        public Builder clearBaseWrites() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearBaseWrites();
            return this;
        }

        public Builder removeBaseWrites(int index) {
            copyOnWrite();
            ((WriteBatch) this.instance).removeBaseWrites(index);
            return this;
        }
    }

    /* renamed from: com.google.firebase.firestore.proto.WriteBatch$1  reason: invalid class name */
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
                return new WriteBatch();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.writes_.makeImmutable();
                this.baseWrites_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                WriteBatch other = (WriteBatch) arg1;
                boolean z = true;
                boolean z2 = this.batchId_ != 0;
                int i = this.batchId_;
                if (other.batchId_ == 0) {
                    z = false;
                }
                this.batchId_ = visitor.visitInt(z2, i, z, other.batchId_);
                this.writes_ = visitor.visitList(this.writes_, other.writes_);
                this.localWriteTime_ = (Timestamp) visitor.visitMessage(this.localWriteTime_, other.localWriteTime_);
                this.baseWrites_ = visitor.visitList(this.baseWrites_, other.baseWrites_);
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
                        } else if (tag == 8) {
                            this.batchId_ = input.readInt32();
                        } else if (tag == 18) {
                            if (!this.writes_.isModifiable()) {
                                this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_);
                            }
                            this.writes_.add((Write) input.readMessage(Write.parser(), extensionRegistry));
                        } else if (tag == 26) {
                            Timestamp.Builder subBuilder = null;
                            if (this.localWriteTime_ != null) {
                                subBuilder = (Timestamp.Builder) this.localWriteTime_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.localWriteTime_ = timestamp;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(timestamp);
                                this.localWriteTime_ = (Timestamp) subBuilder.buildPartial();
                            }
                        } else if (tag == 34) {
                            if (!this.baseWrites_.isModifiable()) {
                                this.baseWrites_ = GeneratedMessageLite.mutableCopy(this.baseWrites_);
                            }
                            this.baseWrites_.add((Write) input.readMessage(Write.parser(), extensionRegistry));
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
                    synchronized (WriteBatch.class) {
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
        WriteBatch writeBatch = new WriteBatch();
        DEFAULT_INSTANCE = writeBatch;
        writeBatch.makeImmutable();
    }

    public static WriteBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<WriteBatch> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
