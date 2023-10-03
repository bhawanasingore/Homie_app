package com.google.firestore.v1;

import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.TransactionOptions;
import com.google.protobuf.AbstractMessageLite;
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
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class BatchGetDocumentsRequest extends GeneratedMessageLite<BatchGetDocumentsRequest, Builder> implements BatchGetDocumentsRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final BatchGetDocumentsRequest DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 2;
    public static final int MASK_FIELD_NUMBER = 3;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
    private static volatile Parser<BatchGetDocumentsRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 7;
    public static final int TRANSACTION_FIELD_NUMBER = 4;
    private int bitField0_;
    private int consistencySelectorCase_ = 0;
    private Object consistencySelector_;
    private String database_ = "";
    private Internal.ProtobufList<String> documents_ = GeneratedMessageLite.emptyProtobufList();
    private DocumentMask mask_;

    private BatchGetDocumentsRequest() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ConsistencySelectorCase implements Internal.EnumLite {
        TRANSACTION(4),
        NEW_TRANSACTION(5),
        READ_TIME(7),
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
            if (value2 == 7) {
                return READ_TIME;
            }
            if (value2 == 4) {
                return TRANSACTION;
            }
            if (value2 != 5) {
                return null;
            }
            return NEW_TRANSACTION;
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

    public String getDatabase() {
        return this.database_;
    }

    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    /* access modifiers changed from: private */
    public void setDatabase(String value) {
        if (value != null) {
            this.database_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDatabase() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* access modifiers changed from: private */
    public void setDatabaseBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.database_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<String> getDocumentsList() {
        return this.documents_;
    }

    public int getDocumentsCount() {
        return this.documents_.size();
    }

    public String getDocuments(int index) {
        return (String) this.documents_.get(index);
    }

    public ByteString getDocumentsBytes(int index) {
        return ByteString.copyFromUtf8((String) this.documents_.get(index));
    }

    private void ensureDocumentsIsMutable() {
        if (!this.documents_.isModifiable()) {
            this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
        }
    }

    /* access modifiers changed from: private */
    public void setDocuments(int index, String value) {
        if (value != null) {
            ensureDocumentsIsMutable();
            this.documents_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addDocuments(String value) {
        if (value != null) {
            ensureDocumentsIsMutable();
            this.documents_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllDocuments(Iterable<String> values) {
        ensureDocumentsIsMutable();
        AbstractMessageLite.addAll(values, this.documents_);
    }

    /* access modifiers changed from: private */
    public void clearDocuments() {
        this.documents_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addDocumentsBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureDocumentsIsMutable();
            this.documents_.add(value.toStringUtf8());
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
        if (this.consistencySelectorCase_ == 4) {
            return (ByteString) this.consistencySelector_;
        }
        return ByteString.EMPTY;
    }

    /* access modifiers changed from: private */
    public void setTransaction(ByteString value) {
        if (value != null) {
            this.consistencySelectorCase_ = 4;
            this.consistencySelector_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTransaction() {
        if (this.consistencySelectorCase_ == 4) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public TransactionOptions getNewTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            return (TransactionOptions) this.consistencySelector_;
        }
        return TransactionOptions.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setNewTransaction(TransactionOptions value) {
        if (value != null) {
            this.consistencySelector_ = value;
            this.consistencySelectorCase_ = 5;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setNewTransaction(TransactionOptions.Builder builderForValue) {
        this.consistencySelector_ = builderForValue.build();
        this.consistencySelectorCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void mergeNewTransaction(TransactionOptions value) {
        if (this.consistencySelectorCase_ != 5 || this.consistencySelector_ == TransactionOptions.getDefaultInstance()) {
            this.consistencySelector_ = value;
        } else {
            this.consistencySelector_ = ((TransactionOptions.Builder) TransactionOptions.newBuilder((TransactionOptions) this.consistencySelector_).mergeFrom(value)).buildPartial();
        }
        this.consistencySelectorCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void clearNewTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public Timestamp getReadTime() {
        if (this.consistencySelectorCase_ == 7) {
            return (Timestamp) this.consistencySelector_;
        }
        return Timestamp.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp value) {
        if (value != null) {
            this.consistencySelector_ = value;
            this.consistencySelectorCase_ = 7;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builderForValue) {
        this.consistencySelector_ = builderForValue.build();
        this.consistencySelectorCase_ = 7;
    }

    /* access modifiers changed from: private */
    public void mergeReadTime(Timestamp value) {
        if (this.consistencySelectorCase_ != 7 || this.consistencySelector_ == Timestamp.getDefaultInstance()) {
            this.consistencySelector_ = value;
        } else {
            this.consistencySelector_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom(value)).buildPartial();
        }
        this.consistencySelectorCase_ = 7;
    }

    /* access modifiers changed from: private */
    public void clearReadTime() {
        if (this.consistencySelectorCase_ == 7) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.database_.isEmpty()) {
            output.writeString(1, getDatabase());
        }
        for (int i = 0; i < this.documents_.size(); i++) {
            output.writeString(2, (String) this.documents_.get(i));
        }
        if (this.mask_ != null) {
            output.writeMessage(3, getMask());
        }
        if (this.consistencySelectorCase_ == 4) {
            output.writeBytes(4, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 5) {
            output.writeMessage(5, (TransactionOptions) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 7) {
            output.writeMessage(7, (Timestamp) this.consistencySelector_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.database_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getDatabase());
        }
        int dataSize = 0;
        for (int i = 0; i < this.documents_.size(); i++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.documents_.get(i));
        }
        int size3 = size2 + dataSize + (getDocumentsList().size() * 1);
        if (this.mask_ != null) {
            size3 += CodedOutputStream.computeMessageSize(3, getMask());
        }
        if (this.consistencySelectorCase_ == 4) {
            size3 += CodedOutputStream.computeBytesSize(4, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 5) {
            size3 += CodedOutputStream.computeMessageSize(5, (TransactionOptions) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 7) {
            size3 += CodedOutputStream.computeMessageSize(7, (Timestamp) this.consistencySelector_);
        }
        this.memoizedSerializedSize = size3;
        return size3;
    }

    public static BatchGetDocumentsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BatchGetDocumentsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BatchGetDocumentsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BatchGetDocumentsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BatchGetDocumentsRequest parseFrom(InputStream input) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BatchGetDocumentsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BatchGetDocumentsRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (BatchGetDocumentsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static BatchGetDocumentsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BatchGetDocumentsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BatchGetDocumentsRequest parseFrom(CodedInputStream input) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BatchGetDocumentsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BatchGetDocumentsRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocumentsRequest, Builder> implements BatchGetDocumentsRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(BatchGetDocumentsRequest.DEFAULT_INSTANCE);
        }

        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((BatchGetDocumentsRequest) this.instance).getConsistencySelectorCase();
        }

        public Builder clearConsistencySelector() {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).clearConsistencySelector();
            return this;
        }

        public String getDatabase() {
            return ((BatchGetDocumentsRequest) this.instance).getDatabase();
        }

        public ByteString getDatabaseBytes() {
            return ((BatchGetDocumentsRequest) this.instance).getDatabaseBytes();
        }

        public Builder setDatabase(String value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setDatabase(value);
            return this;
        }

        public Builder clearDatabase() {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).clearDatabase();
            return this;
        }

        public Builder setDatabaseBytes(ByteString value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setDatabaseBytes(value);
            return this;
        }

        public List<String> getDocumentsList() {
            return Collections.unmodifiableList(((BatchGetDocumentsRequest) this.instance).getDocumentsList());
        }

        public int getDocumentsCount() {
            return ((BatchGetDocumentsRequest) this.instance).getDocumentsCount();
        }

        public String getDocuments(int index) {
            return ((BatchGetDocumentsRequest) this.instance).getDocuments(index);
        }

        public ByteString getDocumentsBytes(int index) {
            return ((BatchGetDocumentsRequest) this.instance).getDocumentsBytes(index);
        }

        public Builder setDocuments(int index, String value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setDocuments(index, value);
            return this;
        }

        public Builder addDocuments(String value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).addDocuments(value);
            return this;
        }

        public Builder addAllDocuments(Iterable<String> values) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).addAllDocuments(values);
            return this;
        }

        public Builder clearDocuments() {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).clearDocuments();
            return this;
        }

        public Builder addDocumentsBytes(ByteString value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).addDocumentsBytes(value);
            return this;
        }

        public boolean hasMask() {
            return ((BatchGetDocumentsRequest) this.instance).hasMask();
        }

        public DocumentMask getMask() {
            return ((BatchGetDocumentsRequest) this.instance).getMask();
        }

        public Builder setMask(DocumentMask value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setMask(value);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builderForValue) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setMask(builderForValue);
            return this;
        }

        public Builder mergeMask(DocumentMask value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).mergeMask(value);
            return this;
        }

        public Builder clearMask() {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).clearMask();
            return this;
        }

        public ByteString getTransaction() {
            return ((BatchGetDocumentsRequest) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setTransaction(value);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).clearTransaction();
            return this;
        }

        public TransactionOptions getNewTransaction() {
            return ((BatchGetDocumentsRequest) this.instance).getNewTransaction();
        }

        public Builder setNewTransaction(TransactionOptions value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setNewTransaction(value);
            return this;
        }

        public Builder setNewTransaction(TransactionOptions.Builder builderForValue) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setNewTransaction(builderForValue);
            return this;
        }

        public Builder mergeNewTransaction(TransactionOptions value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).mergeNewTransaction(value);
            return this;
        }

        public Builder clearNewTransaction() {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).clearNewTransaction();
            return this;
        }

        public Timestamp getReadTime() {
            return ((BatchGetDocumentsRequest) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((BatchGetDocumentsRequest) this.instance).clearReadTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.BatchGetDocumentsRequest$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$BatchGetDocumentsRequest$ConsistencySelectorCase;
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
            $SwitchMap$com$google$firestore$v1$BatchGetDocumentsRequest$ConsistencySelectorCase = iArr2;
            try {
                iArr2[ConsistencySelectorCase.TRANSACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$BatchGetDocumentsRequest$ConsistencySelectorCase[ConsistencySelectorCase.NEW_TRANSACTION.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$BatchGetDocumentsRequest$ConsistencySelectorCase[ConsistencySelectorCase.READ_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$BatchGetDocumentsRequest$ConsistencySelectorCase[ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new BatchGetDocumentsRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.documents_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                BatchGetDocumentsRequest other = (BatchGetDocumentsRequest) arg1;
                boolean z = true;
                this.database_ = visitor.visitString(!this.database_.isEmpty(), this.database_, !other.database_.isEmpty(), other.database_);
                this.documents_ = visitor.visitList(this.documents_, other.documents_);
                this.mask_ = (DocumentMask) visitor.visitMessage(this.mask_, other.mask_);
                int i = AnonymousClass1.$SwitchMap$com$google$firestore$v1$BatchGetDocumentsRequest$ConsistencySelectorCase[other.getConsistencySelectorCase().ordinal()];
                if (i == 1) {
                    if (this.consistencySelectorCase_ != 4) {
                        z = false;
                    }
                    this.consistencySelector_ = visitor.visitOneofByteString(z, this.consistencySelector_, other.consistencySelector_);
                } else if (i == 2) {
                    if (this.consistencySelectorCase_ != 5) {
                        z = false;
                    }
                    this.consistencySelector_ = visitor.visitOneofMessage(z, this.consistencySelector_, other.consistencySelector_);
                } else if (i == 3) {
                    if (this.consistencySelectorCase_ != 7) {
                        z = false;
                    }
                    this.consistencySelector_ = visitor.visitOneofMessage(z, this.consistencySelector_, other.consistencySelector_);
                } else if (i == 4) {
                    if (this.consistencySelectorCase_ == 0) {
                        z = false;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    int i2 = other.consistencySelectorCase_;
                    if (i2 != 0) {
                        this.consistencySelectorCase_ = i2;
                    }
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
                            this.database_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            String s = input.readStringRequireUtf8();
                            if (!this.documents_.isModifiable()) {
                                this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
                            }
                            this.documents_.add(s);
                        } else if (tag == 26) {
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
                        } else if (tag == 34) {
                            this.consistencySelectorCase_ = 4;
                            this.consistencySelector_ = input.readBytes();
                        } else if (tag == 42) {
                            TransactionOptions.Builder subBuilder2 = null;
                            if (this.consistencySelectorCase_ == 5) {
                                subBuilder2 = (TransactionOptions.Builder) ((TransactionOptions) this.consistencySelector_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(TransactionOptions.parser(), extensionRegistry);
                            this.consistencySelector_ = readMessage;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((TransactionOptions) readMessage);
                                this.consistencySelector_ = subBuilder2.buildPartial();
                            }
                            this.consistencySelectorCase_ = 5;
                        } else if (tag == 58) {
                            Timestamp.Builder subBuilder3 = null;
                            if (this.consistencySelectorCase_ == 7) {
                                subBuilder3 = (Timestamp.Builder) ((Timestamp) this.consistencySelector_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.consistencySelector_ = readMessage2;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom((Timestamp) readMessage2);
                                this.consistencySelector_ = subBuilder3.buildPartial();
                            }
                            this.consistencySelectorCase_ = 7;
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
                    synchronized (BatchGetDocumentsRequest.class) {
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
        BatchGetDocumentsRequest batchGetDocumentsRequest = new BatchGetDocumentsRequest();
        DEFAULT_INSTANCE = batchGetDocumentsRequest;
        batchGetDocumentsRequest.makeImmutable();
    }

    public static BatchGetDocumentsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<BatchGetDocumentsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
