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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class DocumentRemove extends GeneratedMessageLite<DocumentRemove, Builder> implements DocumentRemoveOrBuilder {
    /* access modifiers changed from: private */
    public static final DocumentRemove DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentRemove> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private String document_ = "";
    private Timestamp readTime_;
    private Internal.IntList removedTargetIds_ = emptyIntList();

    private DocumentRemove() {
    }

    public String getDocument() {
        return this.document_;
    }

    public ByteString getDocumentBytes() {
        return ByteString.copyFromUtf8(this.document_);
    }

    /* access modifiers changed from: private */
    public void setDocument(String value) {
        if (value != null) {
            this.document_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = getDefaultInstance().getDocument();
    }

    /* access modifiers changed from: private */
    public void setDocumentBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.document_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<Integer> getRemovedTargetIdsList() {
        return this.removedTargetIds_;
    }

    public int getRemovedTargetIdsCount() {
        return this.removedTargetIds_.size();
    }

    public int getRemovedTargetIds(int index) {
        return this.removedTargetIds_.getInt(index);
    }

    private void ensureRemovedTargetIdsIsMutable() {
        if (!this.removedTargetIds_.isModifiable()) {
            this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_);
        }
    }

    /* access modifiers changed from: private */
    public void setRemovedTargetIds(int index, int value) {
        ensureRemovedTargetIdsIsMutable();
        this.removedTargetIds_.setInt(index, value);
    }

    /* access modifiers changed from: private */
    public void addRemovedTargetIds(int value) {
        ensureRemovedTargetIdsIsMutable();
        this.removedTargetIds_.addInt(value);
    }

    /* access modifiers changed from: private */
    public void addAllRemovedTargetIds(Iterable<? extends Integer> values) {
        ensureRemovedTargetIdsIsMutable();
        AbstractMessageLite.addAll(values, this.removedTargetIds_);
    }

    /* access modifiers changed from: private */
    public void clearRemovedTargetIds() {
        this.removedTargetIds_ = emptyIntList();
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
        if (!this.document_.isEmpty()) {
            output.writeString(1, getDocument());
        }
        for (int i = 0; i < this.removedTargetIds_.size(); i++) {
            output.writeInt32(2, this.removedTargetIds_.getInt(i));
        }
        if (this.readTime_ != null) {
            output.writeMessage(4, getReadTime());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.document_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getDocument());
        }
        int dataSize = 0;
        for (int i = 0; i < this.removedTargetIds_.size(); i++) {
            dataSize += CodedOutputStream.computeInt32SizeNoTag(this.removedTargetIds_.getInt(i));
        }
        int size3 = size2 + dataSize + (getRemovedTargetIdsList().size() * 1);
        if (this.readTime_ != null) {
            size3 += CodedOutputStream.computeMessageSize(4, getReadTime());
        }
        this.memoizedSerializedSize = size3;
        return size3;
    }

    public static DocumentRemove parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (DocumentRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DocumentRemove parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DocumentRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DocumentRemove parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (DocumentRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DocumentRemove parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DocumentRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DocumentRemove parseFrom(InputStream input) throws IOException {
        return (DocumentRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentRemove parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DocumentRemove parseDelimitedFrom(InputStream input) throws IOException {
        return (DocumentRemove) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentRemove parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentRemove) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DocumentRemove parseFrom(CodedInputStream input) throws IOException {
        return (DocumentRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentRemove parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentRemove prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentRemove, Builder> implements DocumentRemoveOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(DocumentRemove.DEFAULT_INSTANCE);
        }

        public String getDocument() {
            return ((DocumentRemove) this.instance).getDocument();
        }

        public ByteString getDocumentBytes() {
            return ((DocumentRemove) this.instance).getDocumentBytes();
        }

        public Builder setDocument(String value) {
            copyOnWrite();
            ((DocumentRemove) this.instance).setDocument(value);
            return this;
        }

        public Builder clearDocument() {
            copyOnWrite();
            ((DocumentRemove) this.instance).clearDocument();
            return this;
        }

        public Builder setDocumentBytes(ByteString value) {
            copyOnWrite();
            ((DocumentRemove) this.instance).setDocumentBytes(value);
            return this;
        }

        public List<Integer> getRemovedTargetIdsList() {
            return Collections.unmodifiableList(((DocumentRemove) this.instance).getRemovedTargetIdsList());
        }

        public int getRemovedTargetIdsCount() {
            return ((DocumentRemove) this.instance).getRemovedTargetIdsCount();
        }

        public int getRemovedTargetIds(int index) {
            return ((DocumentRemove) this.instance).getRemovedTargetIds(index);
        }

        public Builder setRemovedTargetIds(int index, int value) {
            copyOnWrite();
            ((DocumentRemove) this.instance).setRemovedTargetIds(index, value);
            return this;
        }

        public Builder addRemovedTargetIds(int value) {
            copyOnWrite();
            ((DocumentRemove) this.instance).addRemovedTargetIds(value);
            return this;
        }

        public Builder addAllRemovedTargetIds(Iterable<? extends Integer> values) {
            copyOnWrite();
            ((DocumentRemove) this.instance).addAllRemovedTargetIds(values);
            return this;
        }

        public Builder clearRemovedTargetIds() {
            copyOnWrite();
            ((DocumentRemove) this.instance).clearRemovedTargetIds();
            return this;
        }

        public boolean hasReadTime() {
            return ((DocumentRemove) this.instance).hasReadTime();
        }

        public Timestamp getReadTime() {
            return ((DocumentRemove) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((DocumentRemove) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((DocumentRemove) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((DocumentRemove) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((DocumentRemove) this.instance).clearReadTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.DocumentRemove$1  reason: invalid class name */
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
                return new DocumentRemove();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.removedTargetIds_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                DocumentRemove other = (DocumentRemove) arg1;
                this.document_ = visitor.visitString(!this.document_.isEmpty(), this.document_, !other.document_.isEmpty(), other.document_);
                this.removedTargetIds_ = visitor.visitIntList(this.removedTargetIds_, other.removedTargetIds_);
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
                        } else if (tag == 10) {
                            this.document_ = input.readStringRequireUtf8();
                        } else if (tag == 16) {
                            if (!this.removedTargetIds_.isModifiable()) {
                                this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_);
                            }
                            this.removedTargetIds_.addInt(input.readInt32());
                        } else if (tag == 18) {
                            int limit = input.pushLimit(input.readRawVarint32());
                            if (!this.removedTargetIds_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_);
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.removedTargetIds_.addInt(input.readInt32());
                            }
                            input.popLimit(limit);
                        } else if (tag == 34) {
                            Timestamp.Builder subBuilder = null;
                            if (this.readTime_ != null) {
                                subBuilder = (Timestamp.Builder) this.readTime_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.readTime_ = timestamp;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(timestamp);
                                this.readTime_ = (Timestamp) subBuilder.buildPartial();
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
                    synchronized (DocumentRemove.class) {
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
        DocumentRemove documentRemove = new DocumentRemove();
        DEFAULT_INSTANCE = documentRemove;
        documentRemove.makeImmutable();
    }

    public static DocumentRemove getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<DocumentRemove> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
