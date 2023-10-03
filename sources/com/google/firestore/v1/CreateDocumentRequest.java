package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
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
public final class CreateDocumentRequest extends GeneratedMessageLite<CreateDocumentRequest, Builder> implements CreateDocumentRequestOrBuilder {
    public static final int COLLECTION_ID_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final CreateDocumentRequest DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 4;
    public static final int DOCUMENT_ID_FIELD_NUMBER = 3;
    public static final int MASK_FIELD_NUMBER = 5;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<CreateDocumentRequest> PARSER;
    private String collectionId_ = "";
    private String documentId_ = "";
    private Document document_;
    private DocumentMask mask_;
    private String parent_ = "";

    private CreateDocumentRequest() {
    }

    public String getParent() {
        return this.parent_;
    }

    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    /* access modifiers changed from: private */
    public void setParent(String value) {
        if (value != null) {
            this.parent_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearParent() {
        this.parent_ = getDefaultInstance().getParent();
    }

    /* access modifiers changed from: private */
    public void setParentBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.parent_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getCollectionId() {
        return this.collectionId_;
    }

    public ByteString getCollectionIdBytes() {
        return ByteString.copyFromUtf8(this.collectionId_);
    }

    /* access modifiers changed from: private */
    public void setCollectionId(String value) {
        if (value != null) {
            this.collectionId_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearCollectionId() {
        this.collectionId_ = getDefaultInstance().getCollectionId();
    }

    /* access modifiers changed from: private */
    public void setCollectionIdBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.collectionId_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getDocumentId() {
        return this.documentId_;
    }

    public ByteString getDocumentIdBytes() {
        return ByteString.copyFromUtf8(this.documentId_);
    }

    /* access modifiers changed from: private */
    public void setDocumentId(String value) {
        if (value != null) {
            this.documentId_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDocumentId() {
        this.documentId_ = getDefaultInstance().getDocumentId();
    }

    /* access modifiers changed from: private */
    public void setDocumentIdBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.documentId_ = value.toStringUtf8();
            return;
        }
        throw null;
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

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.parent_.isEmpty()) {
            output.writeString(1, getParent());
        }
        if (!this.collectionId_.isEmpty()) {
            output.writeString(2, getCollectionId());
        }
        if (!this.documentId_.isEmpty()) {
            output.writeString(3, getDocumentId());
        }
        if (this.document_ != null) {
            output.writeMessage(4, getDocument());
        }
        if (this.mask_ != null) {
            output.writeMessage(5, getMask());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.parent_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getParent());
        }
        if (!this.collectionId_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getCollectionId());
        }
        if (!this.documentId_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getDocumentId());
        }
        if (this.document_ != null) {
            size2 += CodedOutputStream.computeMessageSize(4, getDocument());
        }
        if (this.mask_ != null) {
            size2 += CodedOutputStream.computeMessageSize(5, getMask());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static CreateDocumentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CreateDocumentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CreateDocumentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CreateDocumentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CreateDocumentRequest parseFrom(InputStream input) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CreateDocumentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CreateDocumentRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (CreateDocumentRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static CreateDocumentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CreateDocumentRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CreateDocumentRequest parseFrom(CodedInputStream input) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CreateDocumentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CreateDocumentRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<CreateDocumentRequest, Builder> implements CreateDocumentRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(CreateDocumentRequest.DEFAULT_INSTANCE);
        }

        public String getParent() {
            return ((CreateDocumentRequest) this.instance).getParent();
        }

        public ByteString getParentBytes() {
            return ((CreateDocumentRequest) this.instance).getParentBytes();
        }

        public Builder setParent(String value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setParent(value);
            return this;
        }

        public Builder clearParent() {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).clearParent();
            return this;
        }

        public Builder setParentBytes(ByteString value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setParentBytes(value);
            return this;
        }

        public String getCollectionId() {
            return ((CreateDocumentRequest) this.instance).getCollectionId();
        }

        public ByteString getCollectionIdBytes() {
            return ((CreateDocumentRequest) this.instance).getCollectionIdBytes();
        }

        public Builder setCollectionId(String value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setCollectionId(value);
            return this;
        }

        public Builder clearCollectionId() {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).clearCollectionId();
            return this;
        }

        public Builder setCollectionIdBytes(ByteString value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setCollectionIdBytes(value);
            return this;
        }

        public String getDocumentId() {
            return ((CreateDocumentRequest) this.instance).getDocumentId();
        }

        public ByteString getDocumentIdBytes() {
            return ((CreateDocumentRequest) this.instance).getDocumentIdBytes();
        }

        public Builder setDocumentId(String value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setDocumentId(value);
            return this;
        }

        public Builder clearDocumentId() {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).clearDocumentId();
            return this;
        }

        public Builder setDocumentIdBytes(ByteString value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setDocumentIdBytes(value);
            return this;
        }

        public boolean hasDocument() {
            return ((CreateDocumentRequest) this.instance).hasDocument();
        }

        public Document getDocument() {
            return ((CreateDocumentRequest) this.instance).getDocument();
        }

        public Builder setDocument(Document value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setDocument(value);
            return this;
        }

        public Builder setDocument(Document.Builder builderForValue) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setDocument(builderForValue);
            return this;
        }

        public Builder mergeDocument(Document value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).mergeDocument(value);
            return this;
        }

        public Builder clearDocument() {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).clearDocument();
            return this;
        }

        public boolean hasMask() {
            return ((CreateDocumentRequest) this.instance).hasMask();
        }

        public DocumentMask getMask() {
            return ((CreateDocumentRequest) this.instance).getMask();
        }

        public Builder setMask(DocumentMask value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setMask(value);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builderForValue) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).setMask(builderForValue);
            return this;
        }

        public Builder mergeMask(DocumentMask value) {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).mergeMask(value);
            return this;
        }

        public Builder clearMask() {
            copyOnWrite();
            ((CreateDocumentRequest) this.instance).clearMask();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.CreateDocumentRequest$1  reason: invalid class name */
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
                return new CreateDocumentRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                CreateDocumentRequest other = (CreateDocumentRequest) arg1;
                this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !other.parent_.isEmpty(), other.parent_);
                this.collectionId_ = visitor.visitString(!this.collectionId_.isEmpty(), this.collectionId_, !other.collectionId_.isEmpty(), other.collectionId_);
                this.documentId_ = visitor.visitString(!this.documentId_.isEmpty(), this.documentId_, !other.documentId_.isEmpty(), other.documentId_);
                this.document_ = (Document) visitor.visitMessage(this.document_, other.document_);
                this.mask_ = (DocumentMask) visitor.visitMessage(this.mask_, other.mask_);
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
                            this.parent_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.collectionId_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            this.documentId_ = input.readStringRequireUtf8();
                        } else if (tag == 34) {
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
                        } else if (tag == 42) {
                            DocumentMask.Builder subBuilder2 = null;
                            if (this.mask_ != null) {
                                subBuilder2 = (DocumentMask.Builder) this.mask_.toBuilder();
                            }
                            DocumentMask documentMask = (DocumentMask) input.readMessage(DocumentMask.parser(), extensionRegistry);
                            this.mask_ = documentMask;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom(documentMask);
                                this.mask_ = (DocumentMask) subBuilder2.buildPartial();
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
                    synchronized (CreateDocumentRequest.class) {
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
        CreateDocumentRequest createDocumentRequest = new CreateDocumentRequest();
        DEFAULT_INSTANCE = createDocumentRequest;
        createDocumentRequest.makeImmutable();
    }

    public static CreateDocumentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CreateDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
