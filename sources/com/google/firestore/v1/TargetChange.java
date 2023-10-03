package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class TargetChange extends GeneratedMessageLite<TargetChange, Builder> implements TargetChangeOrBuilder {
    public static final int CAUSE_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final TargetChange DEFAULT_INSTANCE;
    private static volatile Parser<TargetChange> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private Status cause_;
    private Timestamp readTime_;
    private ByteString resumeToken_ = ByteString.EMPTY;
    private int targetChangeType_;
    private Internal.IntList targetIds_ = emptyIntList();

    private TargetChange() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum TargetChangeType implements Internal.EnumLite {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);
        
        public static final int ADD_VALUE = 1;
        public static final int CURRENT_VALUE = 3;
        public static final int NO_CHANGE_VALUE = 0;
        public static final int REMOVE_VALUE = 2;
        public static final int RESET_VALUE = 4;
        private static final Internal.EnumLiteMap<TargetChangeType> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<TargetChangeType>() {
                public TargetChangeType findValueByNumber(int number) {
                    return TargetChangeType.forNumber(number);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TargetChangeType valueOf(int value2) {
            return forNumber(value2);
        }

        public static TargetChangeType forNumber(int value2) {
            if (value2 == 0) {
                return NO_CHANGE;
            }
            if (value2 == 1) {
                return ADD;
            }
            if (value2 == 2) {
                return REMOVE;
            }
            if (value2 == 3) {
                return CURRENT;
            }
            if (value2 != 4) {
                return null;
            }
            return RESET;
        }

        public static Internal.EnumLiteMap<TargetChangeType> internalGetValueMap() {
            return internalValueMap;
        }

        private TargetChangeType(int value2) {
            this.value = value2;
        }
    }

    public int getTargetChangeTypeValue() {
        return this.targetChangeType_;
    }

    public TargetChangeType getTargetChangeType() {
        TargetChangeType result = TargetChangeType.forNumber(this.targetChangeType_);
        return result == null ? TargetChangeType.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setTargetChangeTypeValue(int value) {
        this.targetChangeType_ = value;
    }

    /* access modifiers changed from: private */
    public void setTargetChangeType(TargetChangeType value) {
        if (value != null) {
            this.targetChangeType_ = value.getNumber();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTargetChangeType() {
        this.targetChangeType_ = 0;
    }

    public List<Integer> getTargetIdsList() {
        return this.targetIds_;
    }

    public int getTargetIdsCount() {
        return this.targetIds_.size();
    }

    public int getTargetIds(int index) {
        return this.targetIds_.getInt(index);
    }

    private void ensureTargetIdsIsMutable() {
        if (!this.targetIds_.isModifiable()) {
            this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
        }
    }

    /* access modifiers changed from: private */
    public void setTargetIds(int index, int value) {
        ensureTargetIdsIsMutable();
        this.targetIds_.setInt(index, value);
    }

    /* access modifiers changed from: private */
    public void addTargetIds(int value) {
        ensureTargetIdsIsMutable();
        this.targetIds_.addInt(value);
    }

    /* access modifiers changed from: private */
    public void addAllTargetIds(Iterable<? extends Integer> values) {
        ensureTargetIdsIsMutable();
        AbstractMessageLite.addAll(values, this.targetIds_);
    }

    /* access modifiers changed from: private */
    public void clearTargetIds() {
        this.targetIds_ = emptyIntList();
    }

    public boolean hasCause() {
        return this.cause_ != null;
    }

    public Status getCause() {
        Status status = this.cause_;
        return status == null ? Status.getDefaultInstance() : status;
    }

    /* access modifiers changed from: private */
    public void setCause(Status value) {
        if (value != null) {
            this.cause_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setCause(Status.Builder builderForValue) {
        this.cause_ = (Status) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeCause(Status value) {
        Status status = this.cause_;
        if (status == null || status == Status.getDefaultInstance()) {
            this.cause_ = value;
        } else {
            this.cause_ = (Status) ((Status.Builder) Status.newBuilder(this.cause_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearCause() {
        this.cause_ = null;
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

    public boolean hasReadTime() {
        return this.readTime_ != null;
    }

    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp value) {
        if (value != null) {
            this.readTime_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builderForValue) {
        this.readTime_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeReadTime(Timestamp value) {
        Timestamp timestamp = this.readTime_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.readTime_ = value;
        } else {
            this.readTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.readTime_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearReadTime() {
        this.readTime_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        getSerializedSize();
        if (this.targetChangeType_ != TargetChangeType.NO_CHANGE.getNumber()) {
            output.writeEnum(1, this.targetChangeType_);
        }
        for (int i = 0; i < this.targetIds_.size(); i++) {
            output.writeInt32(2, this.targetIds_.getInt(i));
        }
        if (this.cause_ != null) {
            output.writeMessage(3, getCause());
        }
        if (!this.resumeToken_.isEmpty()) {
            output.writeBytes(4, this.resumeToken_);
        }
        if (this.readTime_ != null) {
            output.writeMessage(6, getReadTime());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.targetChangeType_ != TargetChangeType.NO_CHANGE.getNumber()) {
            size2 = 0 + CodedOutputStream.computeEnumSize(1, this.targetChangeType_);
        }
        int dataSize = 0;
        for (int i = 0; i < this.targetIds_.size(); i++) {
            dataSize += CodedOutputStream.computeInt32SizeNoTag(this.targetIds_.getInt(i));
        }
        int size3 = size2 + dataSize + (getTargetIdsList().size() * 1);
        if (this.cause_ != null) {
            size3 += CodedOutputStream.computeMessageSize(3, getCause());
        }
        if (!this.resumeToken_.isEmpty()) {
            size3 += CodedOutputStream.computeBytesSize(4, this.resumeToken_);
        }
        if (this.readTime_ != null) {
            size3 += CodedOutputStream.computeMessageSize(6, getReadTime());
        }
        this.memoizedSerializedSize = size3;
        return size3;
    }

    public static TargetChange parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TargetChange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TargetChange parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TargetChange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TargetChange parseFrom(InputStream input) throws IOException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TargetChange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TargetChange parseDelimitedFrom(InputStream input) throws IOException {
        return (TargetChange) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static TargetChange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TargetChange) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TargetChange parseFrom(CodedInputStream input) throws IOException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TargetChange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TargetChange prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<TargetChange, Builder> implements TargetChangeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(TargetChange.DEFAULT_INSTANCE);
        }

        public int getTargetChangeTypeValue() {
            return ((TargetChange) this.instance).getTargetChangeTypeValue();
        }

        public Builder setTargetChangeTypeValue(int value) {
            copyOnWrite();
            ((TargetChange) this.instance).setTargetChangeTypeValue(value);
            return this;
        }

        public TargetChangeType getTargetChangeType() {
            return ((TargetChange) this.instance).getTargetChangeType();
        }

        public Builder setTargetChangeType(TargetChangeType value) {
            copyOnWrite();
            ((TargetChange) this.instance).setTargetChangeType(value);
            return this;
        }

        public Builder clearTargetChangeType() {
            copyOnWrite();
            ((TargetChange) this.instance).clearTargetChangeType();
            return this;
        }

        public List<Integer> getTargetIdsList() {
            return Collections.unmodifiableList(((TargetChange) this.instance).getTargetIdsList());
        }

        public int getTargetIdsCount() {
            return ((TargetChange) this.instance).getTargetIdsCount();
        }

        public int getTargetIds(int index) {
            return ((TargetChange) this.instance).getTargetIds(index);
        }

        public Builder setTargetIds(int index, int value) {
            copyOnWrite();
            ((TargetChange) this.instance).setTargetIds(index, value);
            return this;
        }

        public Builder addTargetIds(int value) {
            copyOnWrite();
            ((TargetChange) this.instance).addTargetIds(value);
            return this;
        }

        public Builder addAllTargetIds(Iterable<? extends Integer> values) {
            copyOnWrite();
            ((TargetChange) this.instance).addAllTargetIds(values);
            return this;
        }

        public Builder clearTargetIds() {
            copyOnWrite();
            ((TargetChange) this.instance).clearTargetIds();
            return this;
        }

        public boolean hasCause() {
            return ((TargetChange) this.instance).hasCause();
        }

        public Status getCause() {
            return ((TargetChange) this.instance).getCause();
        }

        public Builder setCause(Status value) {
            copyOnWrite();
            ((TargetChange) this.instance).setCause(value);
            return this;
        }

        public Builder setCause(Status.Builder builderForValue) {
            copyOnWrite();
            ((TargetChange) this.instance).setCause(builderForValue);
            return this;
        }

        public Builder mergeCause(Status value) {
            copyOnWrite();
            ((TargetChange) this.instance).mergeCause(value);
            return this;
        }

        public Builder clearCause() {
            copyOnWrite();
            ((TargetChange) this.instance).clearCause();
            return this;
        }

        public ByteString getResumeToken() {
            return ((TargetChange) this.instance).getResumeToken();
        }

        public Builder setResumeToken(ByteString value) {
            copyOnWrite();
            ((TargetChange) this.instance).setResumeToken(value);
            return this;
        }

        public Builder clearResumeToken() {
            copyOnWrite();
            ((TargetChange) this.instance).clearResumeToken();
            return this;
        }

        public boolean hasReadTime() {
            return ((TargetChange) this.instance).hasReadTime();
        }

        public Timestamp getReadTime() {
            return ((TargetChange) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((TargetChange) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((TargetChange) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((TargetChange) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((TargetChange) this.instance).clearReadTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.TargetChange$1  reason: invalid class name */
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
                return new TargetChange();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.targetIds_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                TargetChange other = (TargetChange) arg1;
                boolean z = true;
                this.targetChangeType_ = visitor.visitInt(this.targetChangeType_ != 0, this.targetChangeType_, other.targetChangeType_ != 0, other.targetChangeType_);
                this.targetIds_ = visitor.visitIntList(this.targetIds_, other.targetIds_);
                this.cause_ = (Status) visitor.visitMessage(this.cause_, other.cause_);
                boolean z2 = this.resumeToken_ != ByteString.EMPTY;
                ByteString byteString = this.resumeToken_;
                if (other.resumeToken_ == ByteString.EMPTY) {
                    z = false;
                }
                this.resumeToken_ = visitor.visitByteString(z2, byteString, z, other.resumeToken_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, other.readTime_);
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
                            this.targetChangeType_ = input.readEnum();
                        } else if (tag == 16) {
                            if (!this.targetIds_.isModifiable()) {
                                this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
                            }
                            this.targetIds_.addInt(input.readInt32());
                        } else if (tag == 18) {
                            int limit = input.pushLimit(input.readRawVarint32());
                            if (!this.targetIds_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.targetIds_.addInt(input.readInt32());
                            }
                            input.popLimit(limit);
                        } else if (tag == 26) {
                            Status.Builder subBuilder = null;
                            if (this.cause_ != null) {
                                subBuilder = (Status.Builder) this.cause_.toBuilder();
                            }
                            Status status = (Status) input.readMessage(Status.parser(), extensionRegistry);
                            this.cause_ = status;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(status);
                                this.cause_ = (Status) subBuilder.buildPartial();
                            }
                        } else if (tag == 34) {
                            this.resumeToken_ = input.readBytes();
                        } else if (tag == 50) {
                            Timestamp.Builder subBuilder2 = null;
                            if (this.readTime_ != null) {
                                subBuilder2 = (Timestamp.Builder) this.readTime_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.readTime_ = timestamp;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom(timestamp);
                                this.readTime_ = (Timestamp) subBuilder2.buildPartial();
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
                    synchronized (TargetChange.class) {
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
        TargetChange targetChange = new TargetChange();
        DEFAULT_INSTANCE = targetChange;
        targetChange.makeImmutable();
    }

    public static TargetChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TargetChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
