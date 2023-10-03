package com.google.firebase.firestore.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class TargetGlobal extends GeneratedMessageLite<TargetGlobal, Builder> implements TargetGlobalOrBuilder {
    /* access modifiers changed from: private */
    public static final TargetGlobal DEFAULT_INSTANCE;
    public static final int HIGHEST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 2;
    public static final int HIGHEST_TARGET_ID_FIELD_NUMBER = 1;
    public static final int LAST_REMOTE_SNAPSHOT_VERSION_FIELD_NUMBER = 3;
    private static volatile Parser<TargetGlobal> PARSER = null;
    public static final int TARGET_COUNT_FIELD_NUMBER = 4;
    private long highestListenSequenceNumber_;
    private int highestTargetId_;
    private Timestamp lastRemoteSnapshotVersion_;
    private int targetCount_;

    private TargetGlobal() {
    }

    public int getHighestTargetId() {
        return this.highestTargetId_;
    }

    /* access modifiers changed from: private */
    public void setHighestTargetId(int value) {
        this.highestTargetId_ = value;
    }

    /* access modifiers changed from: private */
    public void clearHighestTargetId() {
        this.highestTargetId_ = 0;
    }

    public long getHighestListenSequenceNumber() {
        return this.highestListenSequenceNumber_;
    }

    /* access modifiers changed from: private */
    public void setHighestListenSequenceNumber(long value) {
        this.highestListenSequenceNumber_ = value;
    }

    /* access modifiers changed from: private */
    public void clearHighestListenSequenceNumber() {
        this.highestListenSequenceNumber_ = 0;
    }

    public boolean hasLastRemoteSnapshotVersion() {
        return this.lastRemoteSnapshotVersion_ != null;
    }

    public Timestamp getLastRemoteSnapshotVersion() {
        Timestamp timestamp = this.lastRemoteSnapshotVersion_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setLastRemoteSnapshotVersion(Timestamp value) {
        if (value != null) {
            this.lastRemoteSnapshotVersion_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLastRemoteSnapshotVersion(Timestamp.Builder builderForValue) {
        this.lastRemoteSnapshotVersion_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeLastRemoteSnapshotVersion(Timestamp value) {
        Timestamp timestamp = this.lastRemoteSnapshotVersion_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.lastRemoteSnapshotVersion_ = value;
        } else {
            this.lastRemoteSnapshotVersion_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.lastRemoteSnapshotVersion_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLastRemoteSnapshotVersion() {
        this.lastRemoteSnapshotVersion_ = null;
    }

    public int getTargetCount() {
        return this.targetCount_;
    }

    /* access modifiers changed from: private */
    public void setTargetCount(int value) {
        this.targetCount_ = value;
    }

    /* access modifiers changed from: private */
    public void clearTargetCount() {
        this.targetCount_ = 0;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = this.highestTargetId_;
        if (i != 0) {
            output.writeInt32(1, i);
        }
        long j = this.highestListenSequenceNumber_;
        if (j != 0) {
            output.writeInt64(2, j);
        }
        if (this.lastRemoteSnapshotVersion_ != null) {
            output.writeMessage(3, getLastRemoteSnapshotVersion());
        }
        int i2 = this.targetCount_;
        if (i2 != 0) {
            output.writeInt32(4, i2);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.highestTargetId_;
        if (i != 0) {
            size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
        }
        long j = this.highestListenSequenceNumber_;
        if (j != 0) {
            size2 += CodedOutputStream.computeInt64Size(2, j);
        }
        if (this.lastRemoteSnapshotVersion_ != null) {
            size2 += CodedOutputStream.computeMessageSize(3, getLastRemoteSnapshotVersion());
        }
        int i2 = this.targetCount_;
        if (i2 != 0) {
            size2 += CodedOutputStream.computeInt32Size(4, i2);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static TargetGlobal parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TargetGlobal parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TargetGlobal parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TargetGlobal parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TargetGlobal parseFrom(InputStream input) throws IOException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TargetGlobal parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TargetGlobal parseDelimitedFrom(InputStream input) throws IOException {
        return (TargetGlobal) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static TargetGlobal parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TargetGlobal) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TargetGlobal parseFrom(CodedInputStream input) throws IOException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TargetGlobal parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TargetGlobal prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<TargetGlobal, Builder> implements TargetGlobalOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(TargetGlobal.DEFAULT_INSTANCE);
        }

        public int getHighestTargetId() {
            return ((TargetGlobal) this.instance).getHighestTargetId();
        }

        public Builder setHighestTargetId(int value) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setHighestTargetId(value);
            return this;
        }

        public Builder clearHighestTargetId() {
            copyOnWrite();
            ((TargetGlobal) this.instance).clearHighestTargetId();
            return this;
        }

        public long getHighestListenSequenceNumber() {
            return ((TargetGlobal) this.instance).getHighestListenSequenceNumber();
        }

        public Builder setHighestListenSequenceNumber(long value) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setHighestListenSequenceNumber(value);
            return this;
        }

        public Builder clearHighestListenSequenceNumber() {
            copyOnWrite();
            ((TargetGlobal) this.instance).clearHighestListenSequenceNumber();
            return this;
        }

        public boolean hasLastRemoteSnapshotVersion() {
            return ((TargetGlobal) this.instance).hasLastRemoteSnapshotVersion();
        }

        public Timestamp getLastRemoteSnapshotVersion() {
            return ((TargetGlobal) this.instance).getLastRemoteSnapshotVersion();
        }

        public Builder setLastRemoteSnapshotVersion(Timestamp value) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setLastRemoteSnapshotVersion(value);
            return this;
        }

        public Builder setLastRemoteSnapshotVersion(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setLastRemoteSnapshotVersion(builderForValue);
            return this;
        }

        public Builder mergeLastRemoteSnapshotVersion(Timestamp value) {
            copyOnWrite();
            ((TargetGlobal) this.instance).mergeLastRemoteSnapshotVersion(value);
            return this;
        }

        public Builder clearLastRemoteSnapshotVersion() {
            copyOnWrite();
            ((TargetGlobal) this.instance).clearLastRemoteSnapshotVersion();
            return this;
        }

        public int getTargetCount() {
            return ((TargetGlobal) this.instance).getTargetCount();
        }

        public Builder setTargetCount(int value) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setTargetCount(value);
            return this;
        }

        public Builder clearTargetCount() {
            copyOnWrite();
            ((TargetGlobal) this.instance).clearTargetCount();
            return this;
        }
    }

    /* renamed from: com.google.firebase.firestore.proto.TargetGlobal$1  reason: invalid class name */
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
                return new TargetGlobal();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                TargetGlobal other = (TargetGlobal) arg1;
                boolean z = true;
                this.highestTargetId_ = visitor.visitInt(this.highestTargetId_ != 0, this.highestTargetId_, other.highestTargetId_ != 0, other.highestTargetId_);
                this.highestListenSequenceNumber_ = visitor.visitLong(this.highestListenSequenceNumber_ != 0, this.highestListenSequenceNumber_, other.highestListenSequenceNumber_ != 0, other.highestListenSequenceNumber_);
                this.lastRemoteSnapshotVersion_ = (Timestamp) visitor.visitMessage(this.lastRemoteSnapshotVersion_, other.lastRemoteSnapshotVersion_);
                boolean z2 = this.targetCount_ != 0;
                int i = this.targetCount_;
                if (other.targetCount_ == 0) {
                    z = false;
                }
                this.targetCount_ = visitor.visitInt(z2, i, z, other.targetCount_);
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
                        } else if (tag == 8) {
                            this.highestTargetId_ = input.readInt32();
                        } else if (tag == 16) {
                            this.highestListenSequenceNumber_ = input.readInt64();
                        } else if (tag == 26) {
                            Timestamp.Builder subBuilder = null;
                            if (this.lastRemoteSnapshotVersion_ != null) {
                                subBuilder = (Timestamp.Builder) this.lastRemoteSnapshotVersion_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.lastRemoteSnapshotVersion_ = timestamp;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(timestamp);
                                this.lastRemoteSnapshotVersion_ = (Timestamp) subBuilder.buildPartial();
                            }
                        } else if (tag == 32) {
                            this.targetCount_ = input.readInt32();
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
                    synchronized (TargetGlobal.class) {
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
        TargetGlobal targetGlobal = new TargetGlobal();
        DEFAULT_INSTANCE = targetGlobal;
        targetGlobal.makeImmutable();
    }

    public static TargetGlobal getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TargetGlobal> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
