package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Target;
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

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class Target extends GeneratedMessageLite<Target, Builder> implements TargetOrBuilder {
    /* access modifiers changed from: private */
    public static final Target DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile Parser<Target> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private Timestamp lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private ByteString resumeToken_ = ByteString.EMPTY;
    private Timestamp snapshotVersion_;
    private int targetId_;
    private int targetTypeCase_ = 0;
    private Object targetType_;

    private Target() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum TargetTypeCase implements Internal.EnumLite {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);
        
        private final int value;

        private TargetTypeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static TargetTypeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static TargetTypeCase forNumber(int value2) {
            if (value2 == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (value2 == 5) {
                return QUERY;
            }
            if (value2 != 6) {
                return null;
            }
            return DOCUMENTS;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public TargetTypeCase getTargetTypeCase() {
        return TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearTargetType() {
        this.targetTypeCase_ = 0;
        this.targetType_ = null;
    }

    public int getTargetId() {
        return this.targetId_;
    }

    /* access modifiers changed from: private */
    public void setTargetId(int value) {
        this.targetId_ = value;
    }

    /* access modifiers changed from: private */
    public void clearTargetId() {
        this.targetId_ = 0;
    }

    public boolean hasSnapshotVersion() {
        return this.snapshotVersion_ != null;
    }

    public Timestamp getSnapshotVersion() {
        Timestamp timestamp = this.snapshotVersion_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setSnapshotVersion(Timestamp value) {
        if (value != null) {
            this.snapshotVersion_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setSnapshotVersion(Timestamp.Builder builderForValue) {
        this.snapshotVersion_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeSnapshotVersion(Timestamp value) {
        Timestamp timestamp = this.snapshotVersion_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.snapshotVersion_ = value;
        } else {
            this.snapshotVersion_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.snapshotVersion_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearSnapshotVersion() {
        this.snapshotVersion_ = null;
    }

    public ByteString getResumeToken() {
        return this.resumeToken_;
    }

    /* access modifiers changed from: private */
    public void setResumeToken(ByteString value) {
        if (value != null) {
            this.resumeToken_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearResumeToken() {
        this.resumeToken_ = getDefaultInstance().getResumeToken();
    }

    public long getLastListenSequenceNumber() {
        return this.lastListenSequenceNumber_;
    }

    /* access modifiers changed from: private */
    public void setLastListenSequenceNumber(long value) {
        this.lastListenSequenceNumber_ = value;
    }

    /* access modifiers changed from: private */
    public void clearLastListenSequenceNumber() {
        this.lastListenSequenceNumber_ = 0;
    }

    public Target.QueryTarget getQuery() {
        if (this.targetTypeCase_ == 5) {
            return (Target.QueryTarget) this.targetType_;
        }
        return Target.QueryTarget.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setQuery(Target.QueryTarget value) {
        if (value != null) {
            this.targetType_ = value;
            this.targetTypeCase_ = 5;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setQuery(Target.QueryTarget.Builder builderForValue) {
        this.targetType_ = builderForValue.build();
        this.targetTypeCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void mergeQuery(Target.QueryTarget value) {
        if (this.targetTypeCase_ != 5 || this.targetType_ == Target.QueryTarget.getDefaultInstance()) {
            this.targetType_ = value;
        } else {
            this.targetType_ = ((Target.QueryTarget.Builder) Target.QueryTarget.newBuilder((Target.QueryTarget) this.targetType_).mergeFrom(value)).buildPartial();
        }
        this.targetTypeCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void clearQuery() {
        if (this.targetTypeCase_ == 5) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    public Target.DocumentsTarget getDocuments() {
        if (this.targetTypeCase_ == 6) {
            return (Target.DocumentsTarget) this.targetType_;
        }
        return Target.DocumentsTarget.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setDocuments(Target.DocumentsTarget value) {
        if (value != null) {
            this.targetType_ = value;
            this.targetTypeCase_ = 6;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocuments(Target.DocumentsTarget.Builder builderForValue) {
        this.targetType_ = builderForValue.build();
        this.targetTypeCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void mergeDocuments(Target.DocumentsTarget value) {
        if (this.targetTypeCase_ != 6 || this.targetType_ == Target.DocumentsTarget.getDefaultInstance()) {
            this.targetType_ = value;
        } else {
            this.targetType_ = ((Target.DocumentsTarget.Builder) Target.DocumentsTarget.newBuilder((Target.DocumentsTarget) this.targetType_).mergeFrom(value)).buildPartial();
        }
        this.targetTypeCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void clearDocuments() {
        if (this.targetTypeCase_ == 6) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    public boolean hasLastLimboFreeSnapshotVersion() {
        return this.lastLimboFreeSnapshotVersion_ != null;
    }

    public Timestamp getLastLimboFreeSnapshotVersion() {
        Timestamp timestamp = this.lastLimboFreeSnapshotVersion_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setLastLimboFreeSnapshotVersion(Timestamp value) {
        if (value != null) {
            this.lastLimboFreeSnapshotVersion_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLastLimboFreeSnapshotVersion(Timestamp.Builder builderForValue) {
        this.lastLimboFreeSnapshotVersion_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeLastLimboFreeSnapshotVersion(Timestamp value) {
        Timestamp timestamp = this.lastLimboFreeSnapshotVersion_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.lastLimboFreeSnapshotVersion_ = value;
        } else {
            this.lastLimboFreeSnapshotVersion_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.lastLimboFreeSnapshotVersion_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLastLimboFreeSnapshotVersion() {
        this.lastLimboFreeSnapshotVersion_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = this.targetId_;
        if (i != 0) {
            output.writeInt32(1, i);
        }
        if (this.snapshotVersion_ != null) {
            output.writeMessage(2, getSnapshotVersion());
        }
        if (!this.resumeToken_.isEmpty()) {
            output.writeBytes(3, this.resumeToken_);
        }
        long j = this.lastListenSequenceNumber_;
        if (j != 0) {
            output.writeInt64(4, j);
        }
        if (this.targetTypeCase_ == 5) {
            output.writeMessage(5, (Target.QueryTarget) this.targetType_);
        }
        if (this.targetTypeCase_ == 6) {
            output.writeMessage(6, (Target.DocumentsTarget) this.targetType_);
        }
        if (this.lastLimboFreeSnapshotVersion_ != null) {
            output.writeMessage(7, getLastLimboFreeSnapshotVersion());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.targetId_;
        if (i != 0) {
            size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
        }
        if (this.snapshotVersion_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getSnapshotVersion());
        }
        if (!this.resumeToken_.isEmpty()) {
            size2 += CodedOutputStream.computeBytesSize(3, this.resumeToken_);
        }
        long j = this.lastListenSequenceNumber_;
        if (j != 0) {
            size2 += CodedOutputStream.computeInt64Size(4, j);
        }
        if (this.targetTypeCase_ == 5) {
            size2 += CodedOutputStream.computeMessageSize(5, (Target.QueryTarget) this.targetType_);
        }
        if (this.targetTypeCase_ == 6) {
            size2 += CodedOutputStream.computeMessageSize(6, (Target.DocumentsTarget) this.targetType_);
        }
        if (this.lastLimboFreeSnapshotVersion_ != null) {
            size2 += CodedOutputStream.computeMessageSize(7, getLastLimboFreeSnapshotVersion());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Target parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Target parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Target parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Target parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Target parseFrom(InputStream input) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Target parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Target parseDelimitedFrom(InputStream input) throws IOException {
        return (Target) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Target parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Target) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Target parseFrom(CodedInputStream input) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Target parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Target prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<Target, Builder> implements TargetOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Target.DEFAULT_INSTANCE);
        }

        public TargetTypeCase getTargetTypeCase() {
            return ((Target) this.instance).getTargetTypeCase();
        }

        public Builder clearTargetType() {
            copyOnWrite();
            ((Target) this.instance).clearTargetType();
            return this;
        }

        public int getTargetId() {
            return ((Target) this.instance).getTargetId();
        }

        public Builder setTargetId(int value) {
            copyOnWrite();
            ((Target) this.instance).setTargetId(value);
            return this;
        }

        public Builder clearTargetId() {
            copyOnWrite();
            ((Target) this.instance).clearTargetId();
            return this;
        }

        public boolean hasSnapshotVersion() {
            return ((Target) this.instance).hasSnapshotVersion();
        }

        public Timestamp getSnapshotVersion() {
            return ((Target) this.instance).getSnapshotVersion();
        }

        public Builder setSnapshotVersion(Timestamp value) {
            copyOnWrite();
            ((Target) this.instance).setSnapshotVersion(value);
            return this;
        }

        public Builder setSnapshotVersion(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((Target) this.instance).setSnapshotVersion(builderForValue);
            return this;
        }

        public Builder mergeSnapshotVersion(Timestamp value) {
            copyOnWrite();
            ((Target) this.instance).mergeSnapshotVersion(value);
            return this;
        }

        public Builder clearSnapshotVersion() {
            copyOnWrite();
            ((Target) this.instance).clearSnapshotVersion();
            return this;
        }

        public ByteString getResumeToken() {
            return ((Target) this.instance).getResumeToken();
        }

        public Builder setResumeToken(ByteString value) {
            copyOnWrite();
            ((Target) this.instance).setResumeToken(value);
            return this;
        }

        public Builder clearResumeToken() {
            copyOnWrite();
            ((Target) this.instance).clearResumeToken();
            return this;
        }

        public long getLastListenSequenceNumber() {
            return ((Target) this.instance).getLastListenSequenceNumber();
        }

        public Builder setLastListenSequenceNumber(long value) {
            copyOnWrite();
            ((Target) this.instance).setLastListenSequenceNumber(value);
            return this;
        }

        public Builder clearLastListenSequenceNumber() {
            copyOnWrite();
            ((Target) this.instance).clearLastListenSequenceNumber();
            return this;
        }

        public Target.QueryTarget getQuery() {
            return ((Target) this.instance).getQuery();
        }

        public Builder setQuery(Target.QueryTarget value) {
            copyOnWrite();
            ((Target) this.instance).setQuery(value);
            return this;
        }

        public Builder setQuery(Target.QueryTarget.Builder builderForValue) {
            copyOnWrite();
            ((Target) this.instance).setQuery(builderForValue);
            return this;
        }

        public Builder mergeQuery(Target.QueryTarget value) {
            copyOnWrite();
            ((Target) this.instance).mergeQuery(value);
            return this;
        }

        public Builder clearQuery() {
            copyOnWrite();
            ((Target) this.instance).clearQuery();
            return this;
        }

        public Target.DocumentsTarget getDocuments() {
            return ((Target) this.instance).getDocuments();
        }

        public Builder setDocuments(Target.DocumentsTarget value) {
            copyOnWrite();
            ((Target) this.instance).setDocuments(value);
            return this;
        }

        public Builder setDocuments(Target.DocumentsTarget.Builder builderForValue) {
            copyOnWrite();
            ((Target) this.instance).setDocuments(builderForValue);
            return this;
        }

        public Builder mergeDocuments(Target.DocumentsTarget value) {
            copyOnWrite();
            ((Target) this.instance).mergeDocuments(value);
            return this;
        }

        public Builder clearDocuments() {
            copyOnWrite();
            ((Target) this.instance).clearDocuments();
            return this;
        }

        public boolean hasLastLimboFreeSnapshotVersion() {
            return ((Target) this.instance).hasLastLimboFreeSnapshotVersion();
        }

        public Timestamp getLastLimboFreeSnapshotVersion() {
            return ((Target) this.instance).getLastLimboFreeSnapshotVersion();
        }

        public Builder setLastLimboFreeSnapshotVersion(Timestamp value) {
            copyOnWrite();
            ((Target) this.instance).setLastLimboFreeSnapshotVersion(value);
            return this;
        }

        public Builder setLastLimboFreeSnapshotVersion(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((Target) this.instance).setLastLimboFreeSnapshotVersion(builderForValue);
            return this;
        }

        public Builder mergeLastLimboFreeSnapshotVersion(Timestamp value) {
            copyOnWrite();
            ((Target) this.instance).mergeLastLimboFreeSnapshotVersion(value);
            return this;
        }

        public Builder clearLastLimboFreeSnapshotVersion() {
            copyOnWrite();
            ((Target) this.instance).clearLastLimboFreeSnapshotVersion();
            return this;
        }
    }

    /* renamed from: com.google.firebase.firestore.proto.Target$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase;
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
            int[] iArr2 = new int[TargetTypeCase.values().length];
            $SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase = iArr2;
            try {
                iArr2[TargetTypeCase.QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase[TargetTypeCase.DOCUMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase[TargetTypeCase.TARGETTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Target();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Target other = (Target) arg1;
                boolean z = false;
                this.targetId_ = visitor.visitInt(this.targetId_ != 0, this.targetId_, other.targetId_ != 0, other.targetId_);
                this.snapshotVersion_ = (Timestamp) visitor.visitMessage(this.snapshotVersion_, other.snapshotVersion_);
                this.resumeToken_ = visitor.visitByteString(this.resumeToken_ != ByteString.EMPTY, this.resumeToken_, other.resumeToken_ != ByteString.EMPTY, other.resumeToken_);
                this.lastListenSequenceNumber_ = visitor.visitLong(this.lastListenSequenceNumber_ != 0, this.lastListenSequenceNumber_, other.lastListenSequenceNumber_ != 0, other.lastListenSequenceNumber_);
                this.lastLimboFreeSnapshotVersion_ = (Timestamp) visitor.visitMessage(this.lastLimboFreeSnapshotVersion_, other.lastLimboFreeSnapshotVersion_);
                int i2 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase[other.getTargetTypeCase().ordinal()];
                if (i2 == 1) {
                    if (this.targetTypeCase_ == 5) {
                        z = true;
                    }
                    this.targetType_ = visitor.visitOneofMessage(z, this.targetType_, other.targetType_);
                } else if (i2 == 2) {
                    if (this.targetTypeCase_ == 6) {
                        z = true;
                    }
                    this.targetType_ = visitor.visitOneofMessage(z, this.targetType_, other.targetType_);
                } else if (i2 == 3) {
                    if (this.targetTypeCase_ != 0) {
                        z = true;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.targetTypeCase_) != 0) {
                    this.targetTypeCase_ = i;
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
                            this.targetId_ = input.readInt32();
                        } else if (tag == 18) {
                            Timestamp.Builder subBuilder = null;
                            if (this.snapshotVersion_ != null) {
                                subBuilder = (Timestamp.Builder) this.snapshotVersion_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.snapshotVersion_ = timestamp;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(timestamp);
                                this.snapshotVersion_ = (Timestamp) subBuilder.buildPartial();
                            }
                        } else if (tag == 26) {
                            this.resumeToken_ = input.readBytes();
                        } else if (tag == 32) {
                            this.lastListenSequenceNumber_ = input.readInt64();
                        } else if (tag == 42) {
                            Target.QueryTarget.Builder subBuilder2 = null;
                            if (this.targetTypeCase_ == 5) {
                                subBuilder2 = (Target.QueryTarget.Builder) ((Target.QueryTarget) this.targetType_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(Target.QueryTarget.parser(), extensionRegistry);
                            this.targetType_ = readMessage;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((Target.QueryTarget) readMessage);
                                this.targetType_ = subBuilder2.buildPartial();
                            }
                            this.targetTypeCase_ = 5;
                        } else if (tag == 50) {
                            Target.DocumentsTarget.Builder subBuilder3 = null;
                            if (this.targetTypeCase_ == 6) {
                                subBuilder3 = (Target.DocumentsTarget.Builder) ((Target.DocumentsTarget) this.targetType_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(Target.DocumentsTarget.parser(), extensionRegistry);
                            this.targetType_ = readMessage2;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom((Target.DocumentsTarget) readMessage2);
                                this.targetType_ = subBuilder3.buildPartial();
                            }
                            this.targetTypeCase_ = 6;
                        } else if (tag == 58) {
                            Timestamp.Builder subBuilder4 = null;
                            if (this.lastLimboFreeSnapshotVersion_ != null) {
                                subBuilder4 = (Timestamp.Builder) this.lastLimboFreeSnapshotVersion_.toBuilder();
                            }
                            Timestamp timestamp2 = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.lastLimboFreeSnapshotVersion_ = timestamp2;
                            if (subBuilder4 != null) {
                                subBuilder4.mergeFrom(timestamp2);
                                this.lastLimboFreeSnapshotVersion_ = (Timestamp) subBuilder4.buildPartial();
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
                    synchronized (Target.class) {
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
        Target target = new Target();
        DEFAULT_INSTANCE = target;
        target.makeImmutable();
    }

    public static Target getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Target> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
