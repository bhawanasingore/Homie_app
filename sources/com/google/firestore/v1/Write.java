package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.DocumentTransform;
import com.google.firestore.v1.Precondition;
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
public final class Write extends GeneratedMessageLite<Write, Builder> implements WriteOrBuilder {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */
    public static final Write DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile Parser<Write> PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    public static final int VERIFY_FIELD_NUMBER = 5;
    private Precondition currentDocument_;
    private int operationCase_ = 0;
    private Object operation_;
    private DocumentMask updateMask_;

    private Write() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum OperationCase implements Internal.EnumLite {
        UPDATE(1),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);
        
        private final int value;

        private OperationCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static OperationCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static OperationCase forNumber(int value2) {
            if (value2 == 0) {
                return OPERATION_NOT_SET;
            }
            if (value2 == 1) {
                return UPDATE;
            }
            if (value2 == 2) {
                return DELETE;
            }
            if (value2 == 5) {
                return VERIFY;
            }
            if (value2 != 6) {
                return null;
            }
            return TRANSFORM;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public OperationCase getOperationCase() {
        return OperationCase.forNumber(this.operationCase_);
    }

    /* access modifiers changed from: private */
    public void clearOperation() {
        this.operationCase_ = 0;
        this.operation_ = null;
    }

    public Document getUpdate() {
        if (this.operationCase_ == 1) {
            return (Document) this.operation_;
        }
        return Document.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setUpdate(Document value) {
        if (value != null) {
            this.operation_ = value;
            this.operationCase_ = 1;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setUpdate(Document.Builder builderForValue) {
        this.operation_ = builderForValue.build();
        this.operationCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void mergeUpdate(Document value) {
        if (this.operationCase_ != 1 || this.operation_ == Document.getDefaultInstance()) {
            this.operation_ = value;
        } else {
            this.operation_ = ((Document.Builder) Document.newBuilder((Document) this.operation_).mergeFrom(value)).buildPartial();
        }
        this.operationCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void clearUpdate() {
        if (this.operationCase_ == 1) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    public String getDelete() {
        if (this.operationCase_ == 2) {
            return (String) this.operation_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getDeleteBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.operationCase_
            r2 = 2
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.operation_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Write.getDeleteBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setDelete(String value) {
        if (value != null) {
            this.operationCase_ = 2;
            this.operation_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDelete() {
        if (this.operationCase_ == 2) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setDeleteBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.operationCase_ = 2;
            this.operation_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getVerify() {
        if (this.operationCase_ == 5) {
            return (String) this.operation_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getVerifyBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.operationCase_
            r2 = 5
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.operation_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Write.getVerifyBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setVerify(String value) {
        if (value != null) {
            this.operationCase_ = 5;
            this.operation_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearVerify() {
        if (this.operationCase_ == 5) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setVerifyBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.operationCase_ = 5;
            this.operation_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public DocumentTransform getTransform() {
        if (this.operationCase_ == 6) {
            return (DocumentTransform) this.operation_;
        }
        return DocumentTransform.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setTransform(DocumentTransform value) {
        if (value != null) {
            this.operation_ = value;
            this.operationCase_ = 6;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setTransform(DocumentTransform.Builder builderForValue) {
        this.operation_ = builderForValue.build();
        this.operationCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void mergeTransform(DocumentTransform value) {
        if (this.operationCase_ != 6 || this.operation_ == DocumentTransform.getDefaultInstance()) {
            this.operation_ = value;
        } else {
            this.operation_ = ((DocumentTransform.Builder) DocumentTransform.newBuilder((DocumentTransform) this.operation_).mergeFrom(value)).buildPartial();
        }
        this.operationCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void clearTransform() {
        if (this.operationCase_ == 6) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
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
        if (this.operationCase_ == 1) {
            output.writeMessage(1, (Document) this.operation_);
        }
        if (this.operationCase_ == 2) {
            output.writeString(2, getDelete());
        }
        if (this.updateMask_ != null) {
            output.writeMessage(3, getUpdateMask());
        }
        if (this.currentDocument_ != null) {
            output.writeMessage(4, getCurrentDocument());
        }
        if (this.operationCase_ == 5) {
            output.writeString(5, getVerify());
        }
        if (this.operationCase_ == 6) {
            output.writeMessage(6, (DocumentTransform) this.operation_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.operationCase_ == 1) {
            size2 = 0 + CodedOutputStream.computeMessageSize(1, (Document) this.operation_);
        }
        if (this.operationCase_ == 2) {
            size2 += CodedOutputStream.computeStringSize(2, getDelete());
        }
        if (this.updateMask_ != null) {
            size2 += CodedOutputStream.computeMessageSize(3, getUpdateMask());
        }
        if (this.currentDocument_ != null) {
            size2 += CodedOutputStream.computeMessageSize(4, getCurrentDocument());
        }
        if (this.operationCase_ == 5) {
            size2 += CodedOutputStream.computeStringSize(5, getVerify());
        }
        if (this.operationCase_ == 6) {
            size2 += CodedOutputStream.computeMessageSize(6, (DocumentTransform) this.operation_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Write parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Write parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Write parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Write parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Write parseFrom(InputStream input) throws IOException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Write parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Write parseDelimitedFrom(InputStream input) throws IOException {
        return (Write) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Write parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Write) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Write parseFrom(CodedInputStream input) throws IOException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Write parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Write prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<Write, Builder> implements WriteOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Write.DEFAULT_INSTANCE);
        }

        public OperationCase getOperationCase() {
            return ((Write) this.instance).getOperationCase();
        }

        public Builder clearOperation() {
            copyOnWrite();
            ((Write) this.instance).clearOperation();
            return this;
        }

        public Document getUpdate() {
            return ((Write) this.instance).getUpdate();
        }

        public Builder setUpdate(Document value) {
            copyOnWrite();
            ((Write) this.instance).setUpdate(value);
            return this;
        }

        public Builder setUpdate(Document.Builder builderForValue) {
            copyOnWrite();
            ((Write) this.instance).setUpdate(builderForValue);
            return this;
        }

        public Builder mergeUpdate(Document value) {
            copyOnWrite();
            ((Write) this.instance).mergeUpdate(value);
            return this;
        }

        public Builder clearUpdate() {
            copyOnWrite();
            ((Write) this.instance).clearUpdate();
            return this;
        }

        public String getDelete() {
            return ((Write) this.instance).getDelete();
        }

        public ByteString getDeleteBytes() {
            return ((Write) this.instance).getDeleteBytes();
        }

        public Builder setDelete(String value) {
            copyOnWrite();
            ((Write) this.instance).setDelete(value);
            return this;
        }

        public Builder clearDelete() {
            copyOnWrite();
            ((Write) this.instance).clearDelete();
            return this;
        }

        public Builder setDeleteBytes(ByteString value) {
            copyOnWrite();
            ((Write) this.instance).setDeleteBytes(value);
            return this;
        }

        public String getVerify() {
            return ((Write) this.instance).getVerify();
        }

        public ByteString getVerifyBytes() {
            return ((Write) this.instance).getVerifyBytes();
        }

        public Builder setVerify(String value) {
            copyOnWrite();
            ((Write) this.instance).setVerify(value);
            return this;
        }

        public Builder clearVerify() {
            copyOnWrite();
            ((Write) this.instance).clearVerify();
            return this;
        }

        public Builder setVerifyBytes(ByteString value) {
            copyOnWrite();
            ((Write) this.instance).setVerifyBytes(value);
            return this;
        }

        public DocumentTransform getTransform() {
            return ((Write) this.instance).getTransform();
        }

        public Builder setTransform(DocumentTransform value) {
            copyOnWrite();
            ((Write) this.instance).setTransform(value);
            return this;
        }

        public Builder setTransform(DocumentTransform.Builder builderForValue) {
            copyOnWrite();
            ((Write) this.instance).setTransform(builderForValue);
            return this;
        }

        public Builder mergeTransform(DocumentTransform value) {
            copyOnWrite();
            ((Write) this.instance).mergeTransform(value);
            return this;
        }

        public Builder clearTransform() {
            copyOnWrite();
            ((Write) this.instance).clearTransform();
            return this;
        }

        public boolean hasUpdateMask() {
            return ((Write) this.instance).hasUpdateMask();
        }

        public DocumentMask getUpdateMask() {
            return ((Write) this.instance).getUpdateMask();
        }

        public Builder setUpdateMask(DocumentMask value) {
            copyOnWrite();
            ((Write) this.instance).setUpdateMask(value);
            return this;
        }

        public Builder setUpdateMask(DocumentMask.Builder builderForValue) {
            copyOnWrite();
            ((Write) this.instance).setUpdateMask(builderForValue);
            return this;
        }

        public Builder mergeUpdateMask(DocumentMask value) {
            copyOnWrite();
            ((Write) this.instance).mergeUpdateMask(value);
            return this;
        }

        public Builder clearUpdateMask() {
            copyOnWrite();
            ((Write) this.instance).clearUpdateMask();
            return this;
        }

        public boolean hasCurrentDocument() {
            return ((Write) this.instance).hasCurrentDocument();
        }

        public Precondition getCurrentDocument() {
            return ((Write) this.instance).getCurrentDocument();
        }

        public Builder setCurrentDocument(Precondition value) {
            copyOnWrite();
            ((Write) this.instance).setCurrentDocument(value);
            return this;
        }

        public Builder setCurrentDocument(Precondition.Builder builderForValue) {
            copyOnWrite();
            ((Write) this.instance).setCurrentDocument(builderForValue);
            return this;
        }

        public Builder mergeCurrentDocument(Precondition value) {
            copyOnWrite();
            ((Write) this.instance).mergeCurrentDocument(value);
            return this;
        }

        public Builder clearCurrentDocument() {
            copyOnWrite();
            ((Write) this.instance).clearCurrentDocument();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.Write$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Write$OperationCase;
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
            int[] iArr2 = new int[OperationCase.values().length];
            $SwitchMap$com$google$firestore$v1$Write$OperationCase = iArr2;
            try {
                iArr2[OperationCase.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Write$OperationCase[OperationCase.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Write$OperationCase[OperationCase.VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Write$OperationCase[OperationCase.TRANSFORM.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Write$OperationCase[OperationCase.OPERATION_NOT_SET.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        boolean z = true;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Write();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Write other = (Write) arg1;
                this.updateMask_ = (DocumentMask) visitor.visitMessage(this.updateMask_, other.updateMask_);
                this.currentDocument_ = (Precondition) visitor.visitMessage(this.currentDocument_, other.currentDocument_);
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Write$OperationCase[other.getOperationCase().ordinal()];
                if (i2 == 1) {
                    if (this.operationCase_ != 1) {
                        z = false;
                    }
                    this.operation_ = visitor.visitOneofMessage(z, this.operation_, other.operation_);
                } else if (i2 == 2) {
                    if (this.operationCase_ != 2) {
                        z = false;
                    }
                    this.operation_ = visitor.visitOneofString(z, this.operation_, other.operation_);
                } else if (i2 == 3) {
                    if (this.operationCase_ != 5) {
                        z = false;
                    }
                    this.operation_ = visitor.visitOneofString(z, this.operation_, other.operation_);
                } else if (i2 == 4) {
                    if (this.operationCase_ != 6) {
                        z = false;
                    }
                    this.operation_ = visitor.visitOneofMessage(z, this.operation_, other.operation_);
                } else if (i2 == 5) {
                    if (this.operationCase_ == 0) {
                        z = false;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.operationCase_) != 0) {
                    this.operationCase_ = i;
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
                            if (this.operationCase_ == 1) {
                                subBuilder = (Document.Builder) ((Document) this.operation_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(Document.parser(), extensionRegistry);
                            this.operation_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((Document) readMessage);
                                this.operation_ = subBuilder.buildPartial();
                            }
                            this.operationCase_ = 1;
                        } else if (tag == 18) {
                            String s = input.readStringRequireUtf8();
                            this.operationCase_ = 2;
                            this.operation_ = s;
                        } else if (tag == 26) {
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
                        } else if (tag == 34) {
                            Precondition.Builder subBuilder3 = null;
                            if (this.currentDocument_ != null) {
                                subBuilder3 = (Precondition.Builder) this.currentDocument_.toBuilder();
                            }
                            Precondition precondition = (Precondition) input.readMessage(Precondition.parser(), extensionRegistry);
                            this.currentDocument_ = precondition;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom(precondition);
                                this.currentDocument_ = (Precondition) subBuilder3.buildPartial();
                            }
                        } else if (tag == 42) {
                            String s2 = input.readStringRequireUtf8();
                            this.operationCase_ = 5;
                            this.operation_ = s2;
                        } else if (tag == 50) {
                            DocumentTransform.Builder subBuilder4 = null;
                            if (this.operationCase_ == 6) {
                                subBuilder4 = (DocumentTransform.Builder) ((DocumentTransform) this.operation_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(DocumentTransform.parser(), extensionRegistry);
                            this.operation_ = readMessage2;
                            if (subBuilder4 != null) {
                                subBuilder4.mergeFrom((DocumentTransform) readMessage2);
                                this.operation_ = subBuilder4.buildPartial();
                            }
                            this.operationCase_ = 6;
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
                    synchronized (Write.class) {
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
        Write write = new Write();
        DEFAULT_INSTANCE = write;
        write.makeImmutable();
    }

    public static Write getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Write> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
