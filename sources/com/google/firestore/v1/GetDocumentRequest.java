package com.google.firestore.v1;

import com.google.firestore.v1.DocumentMask;
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
public final class GetDocumentRequest extends GeneratedMessageLite<GetDocumentRequest, Builder> implements GetDocumentRequestOrBuilder {
    /* access modifiers changed from: private */
    public static final GetDocumentRequest DEFAULT_INSTANCE;
    public static final int MASK_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<GetDocumentRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 5;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private int consistencySelectorCase_ = 0;
    private Object consistencySelector_;
    private DocumentMask mask_;
    private String name_ = "";

    private GetDocumentRequest() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ConsistencySelectorCase implements Internal.EnumLite {
        TRANSACTION(3),
        READ_TIME(5),
        CONSISTENCYSELECTOR_NOT_SET(0);
        
        private final int value;

        private ConsistencySelectorCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static ConsistencySelectorCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static ConsistencySelectorCase forNumber(int value2) {
            if (value2 == 0) {
                return CONSISTENCYSELECTOR_NOT_SET;
            }
            if (value2 == 3) {
                return TRANSACTION;
            }
            if (value2 != 5) {
                return null;
            }
            return READ_TIME;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    /* access modifiers changed from: private */
    public void clearConsistencySelector() {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
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

    public ByteString getTransaction() {
        if (this.consistencySelectorCase_ == 3) {
            return (ByteString) this.consistencySelector_;
        }
        return ByteString.EMPTY;
    }

    /* access modifiers changed from: private */
    public void setTransaction(ByteString value) {
        if (value != null) {
            this.consistencySelectorCase_ = 3;
            this.consistencySelector_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTransaction() {
        if (this.consistencySelectorCase_ == 3) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public Timestamp getReadTime() {
        if (this.consistencySelectorCase_ == 5) {
            return (Timestamp) this.consistencySelector_;
        }
        return Timestamp.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp value) {
        if (value != null) {
            this.consistencySelector_ = value;
            this.consistencySelectorCase_ = 5;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builderForValue) {
        this.consistencySelector_ = builderForValue.build();
        this.consistencySelectorCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void mergeReadTime(Timestamp value) {
        if (this.consistencySelectorCase_ != 5 || this.consistencySelector_ == Timestamp.getDefaultInstance()) {
            this.consistencySelector_ = value;
        } else {
            this.consistencySelector_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom(value)).buildPartial();
        }
        this.consistencySelectorCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void clearReadTime() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (this.mask_ != null) {
            output.writeMessage(2, getMask());
        }
        if (this.consistencySelectorCase_ == 3) {
            output.writeBytes(3, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 5) {
            output.writeMessage(5, (Timestamp) this.consistencySelector_);
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
        if (this.mask_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getMask());
        }
        if (this.consistencySelectorCase_ == 3) {
            size2 += CodedOutputStream.computeBytesSize(3, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 5) {
            size2 += CodedOutputStream.computeMessageSize(5, (Timestamp) this.consistencySelector_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static GetDocumentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static GetDocumentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static GetDocumentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static GetDocumentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static GetDocumentRequest parseFrom(InputStream input) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static GetDocumentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static GetDocumentRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (GetDocumentRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static GetDocumentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (GetDocumentRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static GetDocumentRequest parseFrom(CodedInputStream input) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static GetDocumentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GetDocumentRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<GetDocumentRequest, Builder> implements GetDocumentRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(GetDocumentRequest.DEFAULT_INSTANCE);
        }

        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((GetDocumentRequest) this.instance).getConsistencySelectorCase();
        }

        public Builder clearConsistencySelector() {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).clearConsistencySelector();
            return this;
        }

        public String getName() {
            return ((GetDocumentRequest) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((GetDocumentRequest) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).setNameBytes(value);
            return this;
        }

        public boolean hasMask() {
            return ((GetDocumentRequest) this.instance).hasMask();
        }

        public DocumentMask getMask() {
            return ((GetDocumentRequest) this.instance).getMask();
        }

        public Builder setMask(DocumentMask value) {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).setMask(value);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builderForValue) {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).setMask(builderForValue);
            return this;
        }

        public Builder mergeMask(DocumentMask value) {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).mergeMask(value);
            return this;
        }

        public Builder clearMask() {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).clearMask();
            return this;
        }

        public ByteString getTransaction() {
            return ((GetDocumentRequest) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString value) {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).setTransaction(value);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).clearTransaction();
            return this;
        }

        public Timestamp getReadTime() {
            return ((GetDocumentRequest) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((GetDocumentRequest) this.instance).clearReadTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.GetDocumentRequest$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$GetDocumentRequest$ConsistencySelectorCase;
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
            int[] iArr2 = new int[ConsistencySelectorCase.values().length];
            $SwitchMap$com$google$firestore$v1$GetDocumentRequest$ConsistencySelectorCase = iArr2;
            try {
                iArr2[ConsistencySelectorCase.TRANSACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$GetDocumentRequest$ConsistencySelectorCase[ConsistencySelectorCase.READ_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$GetDocumentRequest$ConsistencySelectorCase[ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new GetDocumentRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                GetDocumentRequest other = (GetDocumentRequest) arg1;
                boolean z = true;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.mask_ = (DocumentMask) visitor.visitMessage(this.mask_, other.mask_);
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$GetDocumentRequest$ConsistencySelectorCase[other.getConsistencySelectorCase().ordinal()];
                if (i2 == 1) {
                    if (this.consistencySelectorCase_ != 3) {
                        z = false;
                    }
                    this.consistencySelector_ = visitor.visitOneofByteString(z, this.consistencySelector_, other.consistencySelector_);
                } else if (i2 == 2) {
                    if (this.consistencySelectorCase_ != 5) {
                        z = false;
                    }
                    this.consistencySelector_ = visitor.visitOneofMessage(z, this.consistencySelector_, other.consistencySelector_);
                } else if (i2 == 3) {
                    if (this.consistencySelectorCase_ == 0) {
                        z = false;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.consistencySelectorCase_) != 0) {
                    this.consistencySelectorCase_ = i;
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
                            this.name_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            DocumentMask.Builder subBuilder = null;
                            if (this.mask_ != null) {
                                subBuilder = (DocumentMask.Builder) this.mask_.toBuilder();
                            }
                            DocumentMask documentMask = (DocumentMask) input.readMessage(DocumentMask.parser(), extensionRegistry);
                            this.mask_ = documentMask;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(documentMask);
                                this.mask_ = (DocumentMask) subBuilder.buildPartial();
                            }
                        } else if (tag == 26) {
                            this.consistencySelectorCase_ = 3;
                            this.consistencySelector_ = input.readBytes();
                        } else if (tag == 42) {
                            Timestamp.Builder subBuilder2 = null;
                            if (this.consistencySelectorCase_ == 5) {
                                subBuilder2 = (Timestamp.Builder) ((Timestamp) this.consistencySelector_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.consistencySelector_ = readMessage;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((Timestamp) readMessage);
                                this.consistencySelector_ = subBuilder2.buildPartial();
                            }
                            this.consistencySelectorCase_ = 5;
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
                    synchronized (GetDocumentRequest.class) {
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
        GetDocumentRequest getDocumentRequest = new GetDocumentRequest();
        DEFAULT_INSTANCE = getDocumentRequest;
        getDocumentRequest.makeImmutable();
    }

    public static GetDocumentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<GetDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
