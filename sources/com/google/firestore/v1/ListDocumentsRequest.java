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
public final class ListDocumentsRequest extends GeneratedMessageLite<ListDocumentsRequest, Builder> implements ListDocumentsRequestOrBuilder {
    public static final int COLLECTION_ID_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final ListDocumentsRequest DEFAULT_INSTANCE;
    public static final int MASK_FIELD_NUMBER = 7;
    public static final int ORDER_BY_FIELD_NUMBER = 6;
    public static final int PAGE_SIZE_FIELD_NUMBER = 3;
    public static final int PAGE_TOKEN_FIELD_NUMBER = 4;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<ListDocumentsRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 10;
    public static final int SHOW_MISSING_FIELD_NUMBER = 12;
    public static final int TRANSACTION_FIELD_NUMBER = 8;
    private String collectionId_ = "";
    private int consistencySelectorCase_ = 0;
    private Object consistencySelector_;
    private DocumentMask mask_;
    private String orderBy_ = "";
    private int pageSize_;
    private String pageToken_ = "";
    private String parent_ = "";
    private boolean showMissing_;

    private ListDocumentsRequest() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ConsistencySelectorCase implements Internal.EnumLite {
        TRANSACTION(8),
        READ_TIME(10),
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
            if (value2 == 8) {
                return TRANSACTION;
            }
            if (value2 != 10) {
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

    public int getPageSize() {
        return this.pageSize_;
    }

    /* access modifiers changed from: private */
    public void setPageSize(int value) {
        this.pageSize_ = value;
    }

    /* access modifiers changed from: private */
    public void clearPageSize() {
        this.pageSize_ = 0;
    }

    public String getPageToken() {
        return this.pageToken_;
    }

    public ByteString getPageTokenBytes() {
        return ByteString.copyFromUtf8(this.pageToken_);
    }

    /* access modifiers changed from: private */
    public void setPageToken(String value) {
        if (value != null) {
            this.pageToken_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearPageToken() {
        this.pageToken_ = getDefaultInstance().getPageToken();
    }

    /* access modifiers changed from: private */
    public void setPageTokenBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.pageToken_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getOrderBy() {
        return this.orderBy_;
    }

    public ByteString getOrderByBytes() {
        return ByteString.copyFromUtf8(this.orderBy_);
    }

    /* access modifiers changed from: private */
    public void setOrderBy(String value) {
        if (value != null) {
            this.orderBy_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearOrderBy() {
        this.orderBy_ = getDefaultInstance().getOrderBy();
    }

    /* access modifiers changed from: private */
    public void setOrderByBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.orderBy_ = value.toStringUtf8();
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
        if (this.consistencySelectorCase_ == 8) {
            return (ByteString) this.consistencySelector_;
        }
        return ByteString.EMPTY;
    }

    /* access modifiers changed from: private */
    public void setTransaction(ByteString value) {
        if (value != null) {
            this.consistencySelectorCase_ = 8;
            this.consistencySelector_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTransaction() {
        if (this.consistencySelectorCase_ == 8) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public Timestamp getReadTime() {
        if (this.consistencySelectorCase_ == 10) {
            return (Timestamp) this.consistencySelector_;
        }
        return Timestamp.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp value) {
        if (value != null) {
            this.consistencySelector_ = value;
            this.consistencySelectorCase_ = 10;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builderForValue) {
        this.consistencySelector_ = builderForValue.build();
        this.consistencySelectorCase_ = 10;
    }

    /* access modifiers changed from: private */
    public void mergeReadTime(Timestamp value) {
        if (this.consistencySelectorCase_ != 10 || this.consistencySelector_ == Timestamp.getDefaultInstance()) {
            this.consistencySelector_ = value;
        } else {
            this.consistencySelector_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom(value)).buildPartial();
        }
        this.consistencySelectorCase_ = 10;
    }

    /* access modifiers changed from: private */
    public void clearReadTime() {
        if (this.consistencySelectorCase_ == 10) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public boolean getShowMissing() {
        return this.showMissing_;
    }

    /* access modifiers changed from: private */
    public void setShowMissing(boolean value) {
        this.showMissing_ = value;
    }

    /* access modifiers changed from: private */
    public void clearShowMissing() {
        this.showMissing_ = false;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.parent_.isEmpty()) {
            output.writeString(1, getParent());
        }
        if (!this.collectionId_.isEmpty()) {
            output.writeString(2, getCollectionId());
        }
        int i = this.pageSize_;
        if (i != 0) {
            output.writeInt32(3, i);
        }
        if (!this.pageToken_.isEmpty()) {
            output.writeString(4, getPageToken());
        }
        if (!this.orderBy_.isEmpty()) {
            output.writeString(6, getOrderBy());
        }
        if (this.mask_ != null) {
            output.writeMessage(7, getMask());
        }
        if (this.consistencySelectorCase_ == 8) {
            output.writeBytes(8, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 10) {
            output.writeMessage(10, (Timestamp) this.consistencySelector_);
        }
        boolean z = this.showMissing_;
        if (z) {
            output.writeBool(12, z);
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
        int i = this.pageSize_;
        if (i != 0) {
            size2 += CodedOutputStream.computeInt32Size(3, i);
        }
        if (!this.pageToken_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(4, getPageToken());
        }
        if (!this.orderBy_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(6, getOrderBy());
        }
        if (this.mask_ != null) {
            size2 += CodedOutputStream.computeMessageSize(7, getMask());
        }
        if (this.consistencySelectorCase_ == 8) {
            size2 += CodedOutputStream.computeBytesSize(8, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 10) {
            size2 += CodedOutputStream.computeMessageSize(10, (Timestamp) this.consistencySelector_);
        }
        boolean z = this.showMissing_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(12, z);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ListDocumentsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListDocumentsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListDocumentsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListDocumentsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListDocumentsRequest parseFrom(InputStream input) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListDocumentsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListDocumentsRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (ListDocumentsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ListDocumentsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListDocumentsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListDocumentsRequest parseFrom(CodedInputStream input) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListDocumentsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListDocumentsRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<ListDocumentsRequest, Builder> implements ListDocumentsRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ListDocumentsRequest.DEFAULT_INSTANCE);
        }

        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((ListDocumentsRequest) this.instance).getConsistencySelectorCase();
        }

        public Builder clearConsistencySelector() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearConsistencySelector();
            return this;
        }

        public String getParent() {
            return ((ListDocumentsRequest) this.instance).getParent();
        }

        public ByteString getParentBytes() {
            return ((ListDocumentsRequest) this.instance).getParentBytes();
        }

        public Builder setParent(String value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setParent(value);
            return this;
        }

        public Builder clearParent() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearParent();
            return this;
        }

        public Builder setParentBytes(ByteString value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setParentBytes(value);
            return this;
        }

        public String getCollectionId() {
            return ((ListDocumentsRequest) this.instance).getCollectionId();
        }

        public ByteString getCollectionIdBytes() {
            return ((ListDocumentsRequest) this.instance).getCollectionIdBytes();
        }

        public Builder setCollectionId(String value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setCollectionId(value);
            return this;
        }

        public Builder clearCollectionId() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearCollectionId();
            return this;
        }

        public Builder setCollectionIdBytes(ByteString value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setCollectionIdBytes(value);
            return this;
        }

        public int getPageSize() {
            return ((ListDocumentsRequest) this.instance).getPageSize();
        }

        public Builder setPageSize(int value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setPageSize(value);
            return this;
        }

        public Builder clearPageSize() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearPageSize();
            return this;
        }

        public String getPageToken() {
            return ((ListDocumentsRequest) this.instance).getPageToken();
        }

        public ByteString getPageTokenBytes() {
            return ((ListDocumentsRequest) this.instance).getPageTokenBytes();
        }

        public Builder setPageToken(String value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setPageToken(value);
            return this;
        }

        public Builder clearPageToken() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearPageToken();
            return this;
        }

        public Builder setPageTokenBytes(ByteString value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setPageTokenBytes(value);
            return this;
        }

        public String getOrderBy() {
            return ((ListDocumentsRequest) this.instance).getOrderBy();
        }

        public ByteString getOrderByBytes() {
            return ((ListDocumentsRequest) this.instance).getOrderByBytes();
        }

        public Builder setOrderBy(String value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setOrderBy(value);
            return this;
        }

        public Builder clearOrderBy() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearOrderBy();
            return this;
        }

        public Builder setOrderByBytes(ByteString value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setOrderByBytes(value);
            return this;
        }

        public boolean hasMask() {
            return ((ListDocumentsRequest) this.instance).hasMask();
        }

        public DocumentMask getMask() {
            return ((ListDocumentsRequest) this.instance).getMask();
        }

        public Builder setMask(DocumentMask value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setMask(value);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builderForValue) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setMask(builderForValue);
            return this;
        }

        public Builder mergeMask(DocumentMask value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).mergeMask(value);
            return this;
        }

        public Builder clearMask() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearMask();
            return this;
        }

        public ByteString getTransaction() {
            return ((ListDocumentsRequest) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setTransaction(value);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearTransaction();
            return this;
        }

        public Timestamp getReadTime() {
            return ((ListDocumentsRequest) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearReadTime();
            return this;
        }

        public boolean getShowMissing() {
            return ((ListDocumentsRequest) this.instance).getShowMissing();
        }

        public Builder setShowMissing(boolean value) {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).setShowMissing(value);
            return this;
        }

        public Builder clearShowMissing() {
            copyOnWrite();
            ((ListDocumentsRequest) this.instance).clearShowMissing();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.ListDocumentsRequest$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$ListDocumentsRequest$ConsistencySelectorCase;
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
            $SwitchMap$com$google$firestore$v1$ListDocumentsRequest$ConsistencySelectorCase = iArr2;
            try {
                iArr2[ConsistencySelectorCase.TRANSACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListDocumentsRequest$ConsistencySelectorCase[ConsistencySelectorCase.READ_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListDocumentsRequest$ConsistencySelectorCase[ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new ListDocumentsRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ListDocumentsRequest other = (ListDocumentsRequest) arg1;
                boolean z = true;
                this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !other.parent_.isEmpty(), other.parent_);
                this.collectionId_ = visitor.visitString(!this.collectionId_.isEmpty(), this.collectionId_, !other.collectionId_.isEmpty(), other.collectionId_);
                this.pageSize_ = visitor.visitInt(this.pageSize_ != 0, this.pageSize_, other.pageSize_ != 0, other.pageSize_);
                this.pageToken_ = visitor.visitString(!this.pageToken_.isEmpty(), this.pageToken_, !other.pageToken_.isEmpty(), other.pageToken_);
                this.orderBy_ = visitor.visitString(!this.orderBy_.isEmpty(), this.orderBy_, !other.orderBy_.isEmpty(), other.orderBy_);
                this.mask_ = (DocumentMask) visitor.visitMessage(this.mask_, other.mask_);
                boolean z2 = this.showMissing_;
                boolean z3 = other.showMissing_;
                this.showMissing_ = visitor.visitBoolean(z2, z2, z3, z3);
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$ListDocumentsRequest$ConsistencySelectorCase[other.getConsistencySelectorCase().ordinal()];
                if (i2 == 1) {
                    if (this.consistencySelectorCase_ != 8) {
                        z = false;
                    }
                    this.consistencySelector_ = visitor.visitOneofByteString(z, this.consistencySelector_, other.consistencySelector_);
                } else if (i2 == 2) {
                    if (this.consistencySelectorCase_ != 10) {
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
                            this.parent_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.collectionId_ = input.readStringRequireUtf8();
                        } else if (tag == 24) {
                            this.pageSize_ = input.readInt32();
                        } else if (tag == 34) {
                            this.pageToken_ = input.readStringRequireUtf8();
                        } else if (tag == 50) {
                            this.orderBy_ = input.readStringRequireUtf8();
                        } else if (tag == 58) {
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
                        } else if (tag == 66) {
                            this.consistencySelectorCase_ = 8;
                            this.consistencySelector_ = input.readBytes();
                        } else if (tag == 82) {
                            Timestamp.Builder subBuilder2 = null;
                            if (this.consistencySelectorCase_ == 10) {
                                subBuilder2 = (Timestamp.Builder) ((Timestamp) this.consistencySelector_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.consistencySelector_ = readMessage;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((Timestamp) readMessage);
                                this.consistencySelector_ = subBuilder2.buildPartial();
                            }
                            this.consistencySelectorCase_ = 10;
                        } else if (tag == 96) {
                            this.showMissing_ = input.readBool();
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
                    synchronized (ListDocumentsRequest.class) {
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
        ListDocumentsRequest listDocumentsRequest = new ListDocumentsRequest();
        DEFAULT_INSTANCE = listDocumentsRequest;
        listDocumentsRequest.makeImmutable();
    }

    public static ListDocumentsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListDocumentsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
