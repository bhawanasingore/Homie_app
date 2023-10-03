package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class DocumentChange extends GeneratedMessageLite<DocumentChange, Builder> implements DocumentChangeOrBuilder {
    /* access modifiers changed from: private */
    public static final DocumentChange DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentChange> PARSER = null;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    public static final int TARGET_IDS_FIELD_NUMBER = 5;
    private int bitField0_;
    private Document document_;
    private Internal.IntList removedTargetIds_ = emptyIntList();
    private Internal.IntList targetIds_ = emptyIntList();

    private DocumentChange() {
    }

    public boolean hasDocument() {
        return this.document_ != null;
    }

    public Document getDocument() {
        Document document = this.document_;
        return document == null ? Document.getDefaultInstance() : document;
    }

    /* access modifiers changed from: private */
    public void setDocument(Document value) {
        if (value != null) {
            this.document_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocument(Document.Builder builderForValue) {
        this.document_ = (Document) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeDocument(Document value) {
        Document document = this.document_;
        if (document == null || document == Document.getDefaultInstance()) {
            this.document_ = value;
        } else {
            this.document_ = (Document) ((Document.Builder) Document.newBuilder(this.document_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = null;
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

    public void writeTo(CodedOutputStream output) throws IOException {
        getSerializedSize();
        if (this.document_ != null) {
            output.writeMessage(1, getDocument());
        }
        for (int i = 0; i < this.targetIds_.size(); i++) {
            output.writeInt32(5, this.targetIds_.getInt(i));
        }
        for (int i2 = 0; i2 < this.removedTargetIds_.size(); i2++) {
            output.writeInt32(6, this.removedTargetIds_.getInt(i2));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.document_ != null) {
            size2 = 0 + CodedOutputStream.computeMessageSize(1, getDocument());
        }
        int dataSize = 0;
        for (int i = 0; i < this.targetIds_.size(); i++) {
            dataSize += CodedOutputStream.computeInt32SizeNoTag(this.targetIds_.getInt(i));
        }
        int size3 = size2 + dataSize + (getTargetIdsList().size() * 1);
        int dataSize2 = 0;
        for (int i2 = 0; i2 < this.removedTargetIds_.size(); i2++) {
            dataSize2 += CodedOutputStream.computeInt32SizeNoTag(this.removedTargetIds_.getInt(i2));
        }
        int size4 = size3 + dataSize2 + (getRemovedTargetIdsList().size() * 1);
        this.memoizedSerializedSize = size4;
        return size4;
    }

    public static DocumentChange parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DocumentChange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DocumentChange parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DocumentChange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DocumentChange parseFrom(InputStream input) throws IOException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentChange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DocumentChange parseDelimitedFrom(InputStream input) throws IOException {
        return (DocumentChange) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentChange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentChange) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DocumentChange parseFrom(CodedInputStream input) throws IOException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentChange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentChange prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentChange, Builder> implements DocumentChangeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(DocumentChange.DEFAULT_INSTANCE);
        }

        public boolean hasDocument() {
            return ((DocumentChange) this.instance).hasDocument();
        }

        public Document getDocument() {
            return ((DocumentChange) this.instance).getDocument();
        }

        public Builder setDocument(Document value) {
            copyOnWrite();
            ((DocumentChange) this.instance).setDocument(value);
            return this;
        }

        public Builder setDocument(Document.Builder builderForValue) {
            copyOnWrite();
            ((DocumentChange) this.instance).setDocument(builderForValue);
            return this;
        }

        public Builder mergeDocument(Document value) {
            copyOnWrite();
            ((DocumentChange) this.instance).mergeDocument(value);
            return this;
        }

        public Builder clearDocument() {
            copyOnWrite();
            ((DocumentChange) this.instance).clearDocument();
            return this;
        }

        public List<Integer> getTargetIdsList() {
            return Collections.unmodifiableList(((DocumentChange) this.instance).getTargetIdsList());
        }

        public int getTargetIdsCount() {
            return ((DocumentChange) this.instance).getTargetIdsCount();
        }

        public int getTargetIds(int index) {
            return ((DocumentChange) this.instance).getTargetIds(index);
        }

        public Builder setTargetIds(int index, int value) {
            copyOnWrite();
            ((DocumentChange) this.instance).setTargetIds(index, value);
            return this;
        }

        public Builder addTargetIds(int value) {
            copyOnWrite();
            ((DocumentChange) this.instance).addTargetIds(value);
            return this;
        }

        public Builder addAllTargetIds(Iterable<? extends Integer> values) {
            copyOnWrite();
            ((DocumentChange) this.instance).addAllTargetIds(values);
            return this;
        }

        public Builder clearTargetIds() {
            copyOnWrite();
            ((DocumentChange) this.instance).clearTargetIds();
            return this;
        }

        public List<Integer> getRemovedTargetIdsList() {
            return Collections.unmodifiableList(((DocumentChange) this.instance).getRemovedTargetIdsList());
        }

        public int getRemovedTargetIdsCount() {
            return ((DocumentChange) this.instance).getRemovedTargetIdsCount();
        }

        public int getRemovedTargetIds(int index) {
            return ((DocumentChange) this.instance).getRemovedTargetIds(index);
        }

        public Builder setRemovedTargetIds(int index, int value) {
            copyOnWrite();
            ((DocumentChange) this.instance).setRemovedTargetIds(index, value);
            return this;
        }

        public Builder addRemovedTargetIds(int value) {
            copyOnWrite();
            ((DocumentChange) this.instance).addRemovedTargetIds(value);
            return this;
        }

        public Builder addAllRemovedTargetIds(Iterable<? extends Integer> values) {
            copyOnWrite();
            ((DocumentChange) this.instance).addAllRemovedTargetIds(values);
            return this;
        }

        public Builder clearRemovedTargetIds() {
            copyOnWrite();
            ((DocumentChange) this.instance).clearRemovedTargetIds();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.DocumentChange$1  reason: invalid class name */
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
                return new DocumentChange();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.targetIds_.makeImmutable();
                this.removedTargetIds_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                DocumentChange other = (DocumentChange) arg1;
                this.document_ = (Document) visitor.visitMessage(this.document_, other.document_);
                this.targetIds_ = visitor.visitIntList(this.targetIds_, other.targetIds_);
                this.removedTargetIds_ = visitor.visitIntList(this.removedTargetIds_, other.removedTargetIds_);
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
                            Document.Builder subBuilder = null;
                            if (this.document_ != null) {
                                subBuilder = (Document.Builder) this.document_.toBuilder();
                            }
                            Document document = (Document) input.readMessage(Document.parser(), extensionRegistry);
                            this.document_ = document;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(document);
                                this.document_ = (Document) subBuilder.buildPartial();
                            }
                        } else if (tag == 40) {
                            if (!this.targetIds_.isModifiable()) {
                                this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
                            }
                            this.targetIds_.addInt(input.readInt32());
                        } else if (tag == 42) {
                            int limit = input.pushLimit(input.readRawVarint32());
                            if (!this.targetIds_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.targetIds_.addInt(input.readInt32());
                            }
                            input.popLimit(limit);
                        } else if (tag == 48) {
                            if (!this.removedTargetIds_.isModifiable()) {
                                this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_);
                            }
                            this.removedTargetIds_.addInt(input.readInt32());
                        } else if (tag == 50) {
                            int limit2 = input.pushLimit(input.readRawVarint32());
                            if (!this.removedTargetIds_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_);
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.removedTargetIds_.addInt(input.readInt32());
                            }
                            input.popLimit(limit2);
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
                    synchronized (DocumentChange.class) {
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
        DocumentChange documentChange = new DocumentChange();
        DEFAULT_INSTANCE = documentChange;
        documentChange.makeImmutable();
    }

    public static DocumentChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<DocumentChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
