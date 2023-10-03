package com.google.firebase.firestore.proto;

import com.google.firebase.firestore.proto.NoDocument;
import com.google.firebase.firestore.proto.UnknownDocument;
import com.google.firestore.v1.Document;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class MaybeDocument extends GeneratedMessageLite<MaybeDocument, Builder> implements MaybeDocumentOrBuilder {
    /* access modifiers changed from: private */
    public static final MaybeDocument DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 2;
    public static final int HAS_COMMITTED_MUTATIONS_FIELD_NUMBER = 4;
    public static final int NO_DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<MaybeDocument> PARSER = null;
    public static final int UNKNOWN_DOCUMENT_FIELD_NUMBER = 3;
    private int documentTypeCase_ = 0;
    private Object documentType_;
    private boolean hasCommittedMutations_;

    private MaybeDocument() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum DocumentTypeCase implements Internal.EnumLite {
        NO_DOCUMENT(1),
        DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        DOCUMENTTYPE_NOT_SET(0);
        
        private final int value;

        private DocumentTypeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static DocumentTypeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static DocumentTypeCase forNumber(int value2) {
            if (value2 == 0) {
                return DOCUMENTTYPE_NOT_SET;
            }
            if (value2 == 1) {
                return NO_DOCUMENT;
            }
            if (value2 == 2) {
                return DOCUMENT;
            }
            if (value2 != 3) {
                return null;
            }
            return UNKNOWN_DOCUMENT;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public DocumentTypeCase getDocumentTypeCase() {
        return DocumentTypeCase.forNumber(this.documentTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearDocumentType() {
        this.documentTypeCase_ = 0;
        this.documentType_ = null;
    }

    public NoDocument getNoDocument() {
        if (this.documentTypeCase_ == 1) {
            return (NoDocument) this.documentType_;
        }
        return NoDocument.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setNoDocument(NoDocument value) {
        if (value != null) {
            this.documentType_ = value;
            this.documentTypeCase_ = 1;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setNoDocument(NoDocument.Builder builderForValue) {
        this.documentType_ = builderForValue.build();
        this.documentTypeCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void mergeNoDocument(NoDocument value) {
        if (this.documentTypeCase_ != 1 || this.documentType_ == NoDocument.getDefaultInstance()) {
            this.documentType_ = value;
        } else {
            this.documentType_ = ((NoDocument.Builder) NoDocument.newBuilder((NoDocument) this.documentType_).mergeFrom(value)).buildPartial();
        }
        this.documentTypeCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void clearNoDocument() {
        if (this.documentTypeCase_ == 1) {
            this.documentTypeCase_ = 0;
            this.documentType_ = null;
        }
    }

    public Document getDocument() {
        if (this.documentTypeCase_ == 2) {
            return (Document) this.documentType_;
        }
        return Document.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setDocument(Document value) {
        if (value != null) {
            this.documentType_ = value;
            this.documentTypeCase_ = 2;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocument(Document.Builder builderForValue) {
        this.documentType_ = builderForValue.build();
        this.documentTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void mergeDocument(Document value) {
        if (this.documentTypeCase_ != 2 || this.documentType_ == Document.getDefaultInstance()) {
            this.documentType_ = value;
        } else {
            this.documentType_ = ((Document.Builder) Document.newBuilder((Document) this.documentType_).mergeFrom(value)).buildPartial();
        }
        this.documentTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void clearDocument() {
        if (this.documentTypeCase_ == 2) {
            this.documentTypeCase_ = 0;
            this.documentType_ = null;
        }
    }

    public UnknownDocument getUnknownDocument() {
        if (this.documentTypeCase_ == 3) {
            return (UnknownDocument) this.documentType_;
        }
        return UnknownDocument.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setUnknownDocument(UnknownDocument value) {
        if (value != null) {
            this.documentType_ = value;
            this.documentTypeCase_ = 3;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setUnknownDocument(UnknownDocument.Builder builderForValue) {
        this.documentType_ = builderForValue.build();
        this.documentTypeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void mergeUnknownDocument(UnknownDocument value) {
        if (this.documentTypeCase_ != 3 || this.documentType_ == UnknownDocument.getDefaultInstance()) {
            this.documentType_ = value;
        } else {
            this.documentType_ = ((UnknownDocument.Builder) UnknownDocument.newBuilder((UnknownDocument) this.documentType_).mergeFrom(value)).buildPartial();
        }
        this.documentTypeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void clearUnknownDocument() {
        if (this.documentTypeCase_ == 3) {
            this.documentTypeCase_ = 0;
            this.documentType_ = null;
        }
    }

    public boolean getHasCommittedMutations() {
        return this.hasCommittedMutations_;
    }

    /* access modifiers changed from: private */
    public void setHasCommittedMutations(boolean value) {
        this.hasCommittedMutations_ = value;
    }

    /* access modifiers changed from: private */
    public void clearHasCommittedMutations() {
        this.hasCommittedMutations_ = false;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.documentTypeCase_ == 1) {
            output.writeMessage(1, (NoDocument) this.documentType_);
        }
        if (this.documentTypeCase_ == 2) {
            output.writeMessage(2, (Document) this.documentType_);
        }
        if (this.documentTypeCase_ == 3) {
            output.writeMessage(3, (UnknownDocument) this.documentType_);
        }
        boolean z = this.hasCommittedMutations_;
        if (z) {
            output.writeBool(4, z);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.documentTypeCase_ == 1) {
            size2 = 0 + CodedOutputStream.computeMessageSize(1, (NoDocument) this.documentType_);
        }
        if (this.documentTypeCase_ == 2) {
            size2 += CodedOutputStream.computeMessageSize(2, (Document) this.documentType_);
        }
        if (this.documentTypeCase_ == 3) {
            size2 += CodedOutputStream.computeMessageSize(3, (UnknownDocument) this.documentType_);
        }
        boolean z = this.hasCommittedMutations_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(4, z);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static MaybeDocument parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (MaybeDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MaybeDocument parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MaybeDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MaybeDocument parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (MaybeDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MaybeDocument parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MaybeDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MaybeDocument parseFrom(InputStream input) throws IOException {
        return (MaybeDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MaybeDocument parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MaybeDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MaybeDocument parseDelimitedFrom(InputStream input) throws IOException {
        return (MaybeDocument) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static MaybeDocument parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MaybeDocument) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MaybeDocument parseFrom(CodedInputStream input) throws IOException {
        return (MaybeDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MaybeDocument parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MaybeDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MaybeDocument prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<MaybeDocument, Builder> implements MaybeDocumentOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(MaybeDocument.DEFAULT_INSTANCE);
        }

        public DocumentTypeCase getDocumentTypeCase() {
            return ((MaybeDocument) this.instance).getDocumentTypeCase();
        }

        public Builder clearDocumentType() {
            copyOnWrite();
            ((MaybeDocument) this.instance).clearDocumentType();
            return this;
        }

        public NoDocument getNoDocument() {
            return ((MaybeDocument) this.instance).getNoDocument();
        }

        public Builder setNoDocument(NoDocument value) {
            copyOnWrite();
            ((MaybeDocument) this.instance).setNoDocument(value);
            return this;
        }

        public Builder setNoDocument(NoDocument.Builder builderForValue) {
            copyOnWrite();
            ((MaybeDocument) this.instance).setNoDocument(builderForValue);
            return this;
        }

        public Builder mergeNoDocument(NoDocument value) {
            copyOnWrite();
            ((MaybeDocument) this.instance).mergeNoDocument(value);
            return this;
        }

        public Builder clearNoDocument() {
            copyOnWrite();
            ((MaybeDocument) this.instance).clearNoDocument();
            return this;
        }

        public Document getDocument() {
            return ((MaybeDocument) this.instance).getDocument();
        }

        public Builder setDocument(Document value) {
            copyOnWrite();
            ((MaybeDocument) this.instance).setDocument(value);
            return this;
        }

        public Builder setDocument(Document.Builder builderForValue) {
            copyOnWrite();
            ((MaybeDocument) this.instance).setDocument(builderForValue);
            return this;
        }

        public Builder mergeDocument(Document value) {
            copyOnWrite();
            ((MaybeDocument) this.instance).mergeDocument(value);
            return this;
        }

        public Builder clearDocument() {
            copyOnWrite();
            ((MaybeDocument) this.instance).clearDocument();
            return this;
        }

        public UnknownDocument getUnknownDocument() {
            return ((MaybeDocument) this.instance).getUnknownDocument();
        }

        public Builder setUnknownDocument(UnknownDocument value) {
            copyOnWrite();
            ((MaybeDocument) this.instance).setUnknownDocument(value);
            return this;
        }

        public Builder setUnknownDocument(UnknownDocument.Builder builderForValue) {
            copyOnWrite();
            ((MaybeDocument) this.instance).setUnknownDocument(builderForValue);
            return this;
        }

        public Builder mergeUnknownDocument(UnknownDocument value) {
            copyOnWrite();
            ((MaybeDocument) this.instance).mergeUnknownDocument(value);
            return this;
        }

        public Builder clearUnknownDocument() {
            copyOnWrite();
            ((MaybeDocument) this.instance).clearUnknownDocument();
            return this;
        }

        public boolean getHasCommittedMutations() {
            return ((MaybeDocument) this.instance).getHasCommittedMutations();
        }

        public Builder setHasCommittedMutations(boolean value) {
            copyOnWrite();
            ((MaybeDocument) this.instance).setHasCommittedMutations(value);
            return this;
        }

        public Builder clearHasCommittedMutations() {
            copyOnWrite();
            ((MaybeDocument) this.instance).clearHasCommittedMutations();
            return this;
        }
    }

    /* renamed from: com.google.firebase.firestore.proto.MaybeDocument$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase;
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
            int[] iArr2 = new int[DocumentTypeCase.values().length];
            $SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase = iArr2;
            try {
                iArr2[DocumentTypeCase.NO_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase[DocumentTypeCase.DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase[DocumentTypeCase.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase[DocumentTypeCase.DOCUMENTTYPE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        boolean z = true;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new MaybeDocument();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                MaybeDocument other = (MaybeDocument) arg1;
                boolean z2 = this.hasCommittedMutations_;
                boolean z3 = other.hasCommittedMutations_;
                this.hasCommittedMutations_ = visitor.visitBoolean(z2, z2, z3, z3);
                int i2 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase[other.getDocumentTypeCase().ordinal()];
                if (i2 == 1) {
                    if (this.documentTypeCase_ != 1) {
                        z = false;
                    }
                    this.documentType_ = visitor.visitOneofMessage(z, this.documentType_, other.documentType_);
                } else if (i2 == 2) {
                    if (this.documentTypeCase_ != 2) {
                        z = false;
                    }
                    this.documentType_ = visitor.visitOneofMessage(z, this.documentType_, other.documentType_);
                } else if (i2 == 3) {
                    if (this.documentTypeCase_ != 3) {
                        z = false;
                    }
                    this.documentType_ = visitor.visitOneofMessage(z, this.documentType_, other.documentType_);
                } else if (i2 == 4) {
                    if (this.documentTypeCase_ == 0) {
                        z = false;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.documentTypeCase_) != 0) {
                    this.documentTypeCase_ = i;
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
                            NoDocument.Builder subBuilder = null;
                            if (this.documentTypeCase_ == 1) {
                                subBuilder = (NoDocument.Builder) ((NoDocument) this.documentType_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(NoDocument.parser(), extensionRegistry);
                            this.documentType_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((NoDocument) readMessage);
                                this.documentType_ = subBuilder.buildPartial();
                            }
                            this.documentTypeCase_ = 1;
                        } else if (tag == 18) {
                            Document.Builder subBuilder2 = null;
                            if (this.documentTypeCase_ == 2) {
                                subBuilder2 = (Document.Builder) ((Document) this.documentType_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(Document.parser(), extensionRegistry);
                            this.documentType_ = readMessage2;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((Document) readMessage2);
                                this.documentType_ = subBuilder2.buildPartial();
                            }
                            this.documentTypeCase_ = 2;
                        } else if (tag == 26) {
                            UnknownDocument.Builder subBuilder3 = null;
                            if (this.documentTypeCase_ == 3) {
                                subBuilder3 = (UnknownDocument.Builder) ((UnknownDocument) this.documentType_).toBuilder();
                            }
                            MessageLite readMessage3 = input.readMessage(UnknownDocument.parser(), extensionRegistry);
                            this.documentType_ = readMessage3;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom((UnknownDocument) readMessage3);
                                this.documentType_ = subBuilder3.buildPartial();
                            }
                            this.documentTypeCase_ = 3;
                        } else if (tag == 32) {
                            this.hasCommittedMutations_ = input.readBool();
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
                    synchronized (MaybeDocument.class) {
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
        MaybeDocument maybeDocument = new MaybeDocument();
        DEFAULT_INSTANCE = maybeDocument;
        maybeDocument.makeImmutable();
    }

    public static MaybeDocument getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MaybeDocument> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
