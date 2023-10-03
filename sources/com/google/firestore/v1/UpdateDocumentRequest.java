package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.Precondition;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class UpdateDocumentRequest extends GeneratedMessageLite<UpdateDocumentRequest, Builder> implements UpdateDocumentRequestOrBuilder {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */
    public static final UpdateDocumentRequest DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int MASK_FIELD_NUMBER = 3;
    private static volatile Parser<UpdateDocumentRequest> PARSER = null;
    public static final int UPDATE_MASK_FIELD_NUMBER = 2;
    private Precondition currentDocument_;
    private Document document_;
    private DocumentMask mask_;
    private DocumentMask updateMask_;

    private UpdateDocumentRequest() {
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

    public boolean hasUpdateMask() {
        return this.updateMask_ != null;
    }

    public DocumentMask getUpdateMask() {
        DocumentMask documentMask = this.updateMask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    /* access modifiers changed from: private */
    public void setUpdateMask(DocumentMask value) {
        if (value != null) {
            this.updateMask_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setUpdateMask(DocumentMask.Builder builderForValue) {
        this.updateMask_ = (DocumentMask) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeUpdateMask(DocumentMask value) {
        DocumentMask documentMask = this.updateMask_;
        if (documentMask == null || documentMask == DocumentMask.getDefaultInstance()) {
            this.updateMask_ = value;
        } else {
            this.updateMask_ = (DocumentMask) ((DocumentMask.Builder) DocumentMask.newBuilder(this.updateMask_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearUpdateMask() {
        this.updateMask_ = null;
    }

    public boolean hasMask() {
        return this.mask_ != null;
    }

    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    /* access modifiers changed from: private */
    public void setMask(DocumentMask value) {
        if (value != null) {
            this.mask_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setMask(DocumentMask.Builder builderForValue) {
        this.mask_ = (DocumentMask) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeMask(DocumentMask value) {
        DocumentMask documentMask = this.mask_;
        if (documentMask == null || documentMask == DocumentMask.getDefaultInstance()) {
            this.mask_ = value;
        } else {
            this.mask_ = (DocumentMask) ((DocumentMask.Builder) DocumentMask.newBuilder(this.mask_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearMask() {
        this.mask_ = null;
    }

    public boolean hasCurrentDocument() {
        return this.currentDocument_ != null;
    }

    public Precondition getCurrentDocument() {
        Precondition precondition = this.currentDocument_;
        return precondition == null ? Precondition.getDefaultInstance() : precondition;
    }

    /* access modifiers changed from: private */
    public void setCurrentDocument(Precondition value) {
        if (value != null) {
            this.currentDocument_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setCurrentDocument(Precondition.Builder builderForValue) {
        this.currentDocument_ = (Precondition) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeCurrentDocument(Precondition value) {
        Precondition precondition = this.currentDocument_;
        if (precondition == null || precondition == Precondition.getDefaultInstance()) {
            this.currentDocument_ = value;
        } else {
            this.currentDocument_ = (Precondition) ((Precondition.Builder) Precondition.newBuilder(this.currentDocument_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearCurrentDocument() {
        this.currentDocument_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.document_ != null) {
            output.writeMessage(1, getDocument());
        }
        if (this.updateMask_ != null) {
            output.writeMessage(2, getUpdateMask());
        }
        if (this.mask_ != null) {
            output.writeMessage(3, getMask());
        }
        if (this.currentDocument_ != null) {
            output.writeMessage(4, getCurrentDocument());
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
        if (this.updateMask_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getUpdateMask());
        }
        if (this.mask_ != null) {
            size2 += CodedOutputStream.computeMessageSize(3, getMask());
        }
        if (this.currentDocument_ != null) {
            size2 += CodedOutputStream.computeMessageSize(4, getCurrentDocument());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static UpdateDocumentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static UpdateDocumentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static UpdateDocumentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static UpdateDocumentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static UpdateDocumentRequest parseFrom(InputStream input) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static UpdateDocumentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static UpdateDocumentRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (UpdateDocumentRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static UpdateDocumentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (UpdateDocumentRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static UpdateDocumentRequest parseFrom(CodedInputStream input) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static UpdateDocumentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(UpdateDocumentRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<UpdateDocumentRequest, Builder> implements UpdateDocumentRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(UpdateDocumentRequest.DEFAULT_INSTANCE);
        }

        public boolean hasDocument() {
            return ((UpdateDocumentRequest) this.instance).hasDocument();
        }

        public Document getDocument() {
            return ((UpdateDocumentRequest) this.instance).getDocument();
        }

        public Builder setDocument(Document value) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).setDocument(value);
            return this;
        }

        public Builder setDocument(Document.Builder builderForValue) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).setDocument(builderForValue);
            return this;
        }

        public Builder mergeDocument(Document value) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).mergeDocument(value);
            return this;
        }

        public Builder clearDocument() {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).clearDocument();
            return this;
        }

        public boolean hasUpdateMask() {
            return ((UpdateDocumentRequest) this.instance).hasUpdateMask();
        }

        public DocumentMask getUpdateMask() {
            return ((UpdateDocumentRequest) this.instance).getUpdateMask();
        }

        public Builder setUpdateMask(DocumentMask value) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).setUpdateMask(value);
            return this;
        }

        public Builder setUpdateMask(DocumentMask.Builder builderForValue) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).setUpdateMask(builderForValue);
            return this;
        }

        public Builder mergeUpdateMask(DocumentMask value) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).mergeUpdateMask(value);
            return this;
        }

        public Builder clearUpdateMask() {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).clearUpdateMask();
            return this;
        }

        public boolean hasMask() {
            return ((UpdateDocumentRequest) this.instance).hasMask();
        }

        public DocumentMask getMask() {
            return ((UpdateDocumentRequest) this.instance).getMask();
        }

        public Builder setMask(DocumentMask value) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).setMask(value);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builderForValue) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).setMask(builderForValue);
            return this;
        }

        public Builder mergeMask(DocumentMask value) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).mergeMask(value);
            return this;
        }

        public Builder clearMask() {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).clearMask();
            return this;
        }

        public boolean hasCurrentDocument() {
            return ((UpdateDocumentRequest) this.instance).hasCurrentDocument();
        }

        public Precondition getCurrentDocument() {
            return ((UpdateDocumentRequest) this.instance).getCurrentDocument();
        }

        public Builder setCurrentDocument(Precondition value) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).setCurrentDocument(value);
            return this;
        }

        public Builder setCurrentDocument(Precondition.Builder builderForValue) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).setCurrentDocument(builderForValue);
            return this;
        }

        public Builder mergeCurrentDocument(Precondition value) {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).mergeCurrentDocument(value);
            return this;
        }

        public Builder clearCurrentDocument() {
            copyOnWrite();
            ((UpdateDocumentRequest) this.instance).clearCurrentDocument();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.UpdateDocumentRequest$1  reason: invalid class name */
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
                return new UpdateDocumentRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                UpdateDocumentRequest other = (UpdateDocumentRequest) arg1;
                this.document_ = (Document) visitor.visitMessage(this.document_, other.document_);
                this.updateMask_ = (DocumentMask) visitor.visitMessage(this.updateMask_, other.updateMask_);
                this.mask_ = (DocumentMask) visitor.visitMessage(this.mask_, other.mask_);
                this.currentDocument_ = (Precondition) visitor.visitMessage(this.currentDocument_, other.currentDocument_);
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
                        } else if (tag == 18) {
                            DocumentMask.Builder subBuilder2 = null;
                            if (this.updateMask_ != null) {
                                subBuilder2 = (DocumentMask.Builder) this.updateMask_.toBuilder();
                            }
                            DocumentMask documentMask = (DocumentMask) input.readMessage(DocumentMask.parser(), extensionRegistry);
                            this.updateMask_ = documentMask;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom(documentMask);
                                this.updateMask_ = (DocumentMask) subBuilder2.buildPartial();
                            }
                        } else if (tag == 26) {
                            DocumentMask.Builder subBuilder3 = null;
                            if (this.mask_ != null) {
                                subBuilder3 = (DocumentMask.Builder) this.mask_.toBuilder();
                            }
                            DocumentMask documentMask2 = (DocumentMask) input.readMessage(DocumentMask.parser(), extensionRegistry);
                            this.mask_ = documentMask2;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom(documentMask2);
                                this.mask_ = (DocumentMask) subBuilder3.buildPartial();
                            }
                        } else if (tag == 34) {
                            Precondition.Builder subBuilder4 = null;
                            if (this.currentDocument_ != null) {
                                subBuilder4 = (Precondition.Builder) this.currentDocument_.toBuilder();
                            }
                            Precondition precondition = (Precondition) input.readMessage(Precondition.parser(), extensionRegistry);
                            this.currentDocument_ = precondition;
                            if (subBuilder4 != null) {
                                subBuilder4.mergeFrom(precondition);
                                this.currentDocument_ = (Precondition) subBuilder4.buildPartial();
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
                    synchronized (UpdateDocumentRequest.class) {
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
        UpdateDocumentRequest updateDocumentRequest = new UpdateDocumentRequest();
        DEFAULT_INSTANCE = updateDocumentRequest;
        updateDocumentRequest.makeImmutable();
    }

    public static UpdateDocumentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<UpdateDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
