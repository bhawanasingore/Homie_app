package com.google.firestore.v1;

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
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class BatchGetDocumentsResponse extends GeneratedMessageLite<BatchGetDocumentsResponse, Builder> implements BatchGetDocumentsResponseOrBuilder {
    /* access modifiers changed from: private */
    public static final BatchGetDocumentsResponse DEFAULT_INSTANCE;
    public static final int FOUND_FIELD_NUMBER = 1;
    public static final int MISSING_FIELD_NUMBER = 2;
    private static volatile Parser<BatchGetDocumentsResponse> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private Timestamp readTime_;
    private int resultCase_ = 0;
    private Object result_;
    private ByteString transaction_ = ByteString.EMPTY;

    private BatchGetDocumentsResponse() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ResultCase implements Internal.EnumLite {
        FOUND(1),
        MISSING(2),
        RESULT_NOT_SET(0);
        
        private final int value;

        private ResultCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static ResultCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static ResultCase forNumber(int value2) {
            if (value2 == 0) {
                return RESULT_NOT_SET;
            }
            if (value2 == 1) {
                return FOUND;
            }
            if (value2 != 2) {
                return null;
            }
            return MISSING;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    /* access modifiers changed from: private */
    public void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    public Document getFound() {
        if (this.resultCase_ == 1) {
            return (Document) this.result_;
        }
        return Document.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setFound(Document value) {
        if (value != null) {
            this.result_ = value;
            this.resultCase_ = 1;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setFound(Document.Builder builderForValue) {
        this.result_ = builderForValue.build();
        this.resultCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void mergeFound(Document value) {
        if (this.resultCase_ != 1 || this.result_ == Document.getDefaultInstance()) {
            this.result_ = value;
        } else {
            this.result_ = ((Document.Builder) Document.newBuilder((Document) this.result_).mergeFrom(value)).buildPartial();
        }
        this.resultCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void clearFound() {
        if (this.resultCase_ == 1) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    public String getMissing() {
        if (this.resultCase_ == 2) {
            return (String) this.result_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getMissingBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.resultCase_
            r2 = 2
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.result_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.BatchGetDocumentsResponse.getMissingBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setMissing(String value) {
        if (value != null) {
            this.resultCase_ = 2;
            this.result_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearMissing() {
        if (this.resultCase_ == 2) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setMissingBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.resultCase_ = 2;
            this.result_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public ByteString getTransaction() {
        return this.transaction_;
    }

    /* access modifiers changed from: private */
    public void setTransaction(ByteString value) {
        if (value != null) {
            this.transaction_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTransaction() {
        this.transaction_ = getDefaultInstance().getTransaction();
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
        if (this.resultCase_ == 1) {
            output.writeMessage(1, (Document) this.result_);
        }
        if (this.resultCase_ == 2) {
            output.writeString(2, getMissing());
        }
        if (!this.transaction_.isEmpty()) {
            output.writeBytes(3, this.transaction_);
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
        if (this.resultCase_ == 1) {
            size2 = 0 + CodedOutputStream.computeMessageSize(1, (Document) this.result_);
        }
        if (this.resultCase_ == 2) {
            size2 += CodedOutputStream.computeStringSize(2, getMissing());
        }
        if (!this.transaction_.isEmpty()) {
            size2 += CodedOutputStream.computeBytesSize(3, this.transaction_);
        }
        if (this.readTime_ != null) {
            size2 += CodedOutputStream.computeMessageSize(4, getReadTime());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static BatchGetDocumentsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BatchGetDocumentsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BatchGetDocumentsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BatchGetDocumentsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BatchGetDocumentsResponse parseFrom(InputStream input) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BatchGetDocumentsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream input) throws IOException {
        return (BatchGetDocumentsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BatchGetDocumentsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BatchGetDocumentsResponse parseFrom(CodedInputStream input) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BatchGetDocumentsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BatchGetDocumentsResponse prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocumentsResponse, Builder> implements BatchGetDocumentsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(BatchGetDocumentsResponse.DEFAULT_INSTANCE);
        }

        public ResultCase getResultCase() {
            return ((BatchGetDocumentsResponse) this.instance).getResultCase();
        }

        public Builder clearResult() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearResult();
            return this;
        }

        public Document getFound() {
            return ((BatchGetDocumentsResponse) this.instance).getFound();
        }

        public Builder setFound(Document value) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setFound(value);
            return this;
        }

        public Builder setFound(Document.Builder builderForValue) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setFound(builderForValue);
            return this;
        }

        public Builder mergeFound(Document value) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).mergeFound(value);
            return this;
        }

        public Builder clearFound() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearFound();
            return this;
        }

        public String getMissing() {
            return ((BatchGetDocumentsResponse) this.instance).getMissing();
        }

        public ByteString getMissingBytes() {
            return ((BatchGetDocumentsResponse) this.instance).getMissingBytes();
        }

        public Builder setMissing(String value) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setMissing(value);
            return this;
        }

        public Builder clearMissing() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearMissing();
            return this;
        }

        public Builder setMissingBytes(ByteString value) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setMissingBytes(value);
            return this;
        }

        public ByteString getTransaction() {
            return ((BatchGetDocumentsResponse) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString value) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setTransaction(value);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearTransaction();
            return this;
        }

        public boolean hasReadTime() {
            return ((BatchGetDocumentsResponse) this.instance).hasReadTime();
        }

        public Timestamp getReadTime() {
            return ((BatchGetDocumentsResponse) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearReadTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.BatchGetDocumentsResponse$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase;
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
            int[] iArr2 = new int[ResultCase.values().length];
            $SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase = iArr2;
            try {
                iArr2[ResultCase.FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase[ResultCase.MISSING.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase[ResultCase.RESULT_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        boolean z = true;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new BatchGetDocumentsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                BatchGetDocumentsResponse other = (BatchGetDocumentsResponse) arg1;
                this.transaction_ = visitor.visitByteString(this.transaction_ != ByteString.EMPTY, this.transaction_, other.transaction_ != ByteString.EMPTY, other.transaction_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, other.readTime_);
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase[other.getResultCase().ordinal()];
                if (i2 == 1) {
                    if (this.resultCase_ != 1) {
                        z = false;
                    }
                    this.result_ = visitor.visitOneofMessage(z, this.result_, other.result_);
                } else if (i2 == 2) {
                    if (this.resultCase_ != 2) {
                        z = false;
                    }
                    this.result_ = visitor.visitOneofString(z, this.result_, other.result_);
                } else if (i2 == 3) {
                    if (this.resultCase_ == 0) {
                        z = false;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.resultCase_) != 0) {
                    this.resultCase_ = i;
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
                            if (this.resultCase_ == 1) {
                                subBuilder = (Document.Builder) ((Document) this.result_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(Document.parser(), extensionRegistry);
                            this.result_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((Document) readMessage);
                                this.result_ = subBuilder.buildPartial();
                            }
                            this.resultCase_ = 1;
                        } else if (tag == 18) {
                            String s = input.readStringRequireUtf8();
                            this.resultCase_ = 2;
                            this.result_ = s;
                        } else if (tag == 26) {
                            this.transaction_ = input.readBytes();
                        } else if (tag == 34) {
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
                    synchronized (BatchGetDocumentsResponse.class) {
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
        BatchGetDocumentsResponse batchGetDocumentsResponse = new BatchGetDocumentsResponse();
        DEFAULT_INSTANCE = batchGetDocumentsResponse;
        batchGetDocumentsResponse.makeImmutable();
    }

    public static BatchGetDocumentsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<BatchGetDocumentsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
