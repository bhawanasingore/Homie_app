package com.google.firestore.v1;

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
public final class DeleteDocumentRequest extends GeneratedMessageLite<DeleteDocumentRequest, Builder> implements DeleteDocumentRequestOrBuilder {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final DeleteDocumentRequest DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<DeleteDocumentRequest> PARSER;
    private Precondition currentDocument_;
    private String name_ = "";

    private DeleteDocumentRequest() {
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* access modifiers changed from: private */
    public void setName(String value) {
        if (value != null) {
            this.name_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    public void setNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.name_ = value.toStringUtf8();
            return;
        }
        throw null;
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
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (this.currentDocument_ != null) {
            output.writeMessage(2, getCurrentDocument());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.name_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getName());
        }
        if (this.currentDocument_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getCurrentDocument());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static DeleteDocumentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (DeleteDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DeleteDocumentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DeleteDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DeleteDocumentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (DeleteDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DeleteDocumentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DeleteDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DeleteDocumentRequest parseFrom(InputStream input) throws IOException {
        return (DeleteDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DeleteDocumentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DeleteDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DeleteDocumentRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (DeleteDocumentRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static DeleteDocumentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DeleteDocumentRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DeleteDocumentRequest parseFrom(CodedInputStream input) throws IOException {
        return (DeleteDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DeleteDocumentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DeleteDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DeleteDocumentRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<DeleteDocumentRequest, Builder> implements DeleteDocumentRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(DeleteDocumentRequest.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((DeleteDocumentRequest) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((DeleteDocumentRequest) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((DeleteDocumentRequest) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((DeleteDocumentRequest) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((DeleteDocumentRequest) this.instance).setNameBytes(value);
            return this;
        }

        public boolean hasCurrentDocument() {
            return ((DeleteDocumentRequest) this.instance).hasCurrentDocument();
        }

        public Precondition getCurrentDocument() {
            return ((DeleteDocumentRequest) this.instance).getCurrentDocument();
        }

        public Builder setCurrentDocument(Precondition value) {
            copyOnWrite();
            ((DeleteDocumentRequest) this.instance).setCurrentDocument(value);
            return this;
        }

        public Builder setCurrentDocument(Precondition.Builder builderForValue) {
            copyOnWrite();
            ((DeleteDocumentRequest) this.instance).setCurrentDocument(builderForValue);
            return this;
        }

        public Builder mergeCurrentDocument(Precondition value) {
            copyOnWrite();
            ((DeleteDocumentRequest) this.instance).mergeCurrentDocument(value);
            return this;
        }

        public Builder clearCurrentDocument() {
            copyOnWrite();
            ((DeleteDocumentRequest) this.instance).clearCurrentDocument();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.DeleteDocumentRequest$1  reason: invalid class name */
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
                return new DeleteDocumentRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                DeleteDocumentRequest other = (DeleteDocumentRequest) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
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
                            this.name_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            Precondition.Builder subBuilder = null;
                            if (this.currentDocument_ != null) {
                                subBuilder = (Precondition.Builder) this.currentDocument_.toBuilder();
                            }
                            Precondition precondition = (Precondition) input.readMessage(Precondition.parser(), extensionRegistry);
                            this.currentDocument_ = precondition;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(precondition);
                                this.currentDocument_ = (Precondition) subBuilder.buildPartial();
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
                    synchronized (DeleteDocumentRequest.class) {
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
        DeleteDocumentRequest deleteDocumentRequest = new DeleteDocumentRequest();
        DEFAULT_INSTANCE = deleteDocumentRequest;
        deleteDocumentRequest.makeImmutable();
    }

    public static DeleteDocumentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<DeleteDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
