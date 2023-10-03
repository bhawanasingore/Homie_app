package com.google.firestore.v1;

import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.TransactionOptions;
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
public final class RunQueryRequest extends GeneratedMessageLite<RunQueryRequest, Builder> implements RunQueryRequestOrBuilder {
    /* access modifiers changed from: private */
    public static final RunQueryRequest DEFAULT_INSTANCE;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 6;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<RunQueryRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 7;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    public static final int TRANSACTION_FIELD_NUMBER = 5;
    private int consistencySelectorCase_ = 0;
    private Object consistencySelector_;
    private String parent_ = "";
    private int queryTypeCase_ = 0;
    private Object queryType_;

    private RunQueryRequest() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum QueryTypeCase implements Internal.EnumLite {
        STRUCTURED_QUERY(2),
        QUERYTYPE_NOT_SET(0);
        
        private final int value;

        private QueryTypeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static QueryTypeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static QueryTypeCase forNumber(int value2) {
            if (value2 == 0) {
                return QUERYTYPE_NOT_SET;
            }
            if (value2 != 2) {
                return null;
            }
            return STRUCTURED_QUERY;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public QueryTypeCase getQueryTypeCase() {
        return QueryTypeCase.forNumber(this.queryTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearQueryType() {
        this.queryTypeCase_ = 0;
        this.queryType_ = null;
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ConsistencySelectorCase implements Internal.EnumLite {
        TRANSACTION(5),
        NEW_TRANSACTION(6),
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
            if (value2 == 5) {
                return TRANSACTION;
            }
            if (value2 == 6) {
                return NEW_TRANSACTION;
            }
            if (value2 != 7) {
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

    public StructuredQuery getStructuredQuery() {
        if (this.queryTypeCase_ == 2) {
            return (StructuredQuery) this.queryType_;
        }
        return StructuredQuery.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setStructuredQuery(StructuredQuery value) {
        if (value != null) {
            this.queryType_ = value;
            this.queryTypeCase_ = 2;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setStructuredQuery(StructuredQuery.Builder builderForValue) {
        this.queryType_ = builderForValue.build();
        this.queryTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void mergeStructuredQuery(StructuredQuery value) {
        if (this.queryTypeCase_ != 2 || this.queryType_ == StructuredQuery.getDefaultInstance()) {
            this.queryType_ = value;
        } else {
            this.queryType_ = ((StructuredQuery.Builder) StructuredQuery.newBuilder((StructuredQuery) this.queryType_).mergeFrom(value)).buildPartial();
        }
        this.queryTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void clearStructuredQuery() {
        if (this.queryTypeCase_ == 2) {
            this.queryTypeCase_ = 0;
            this.queryType_ = null;
        }
    }

    public ByteString getTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            return (ByteString) this.consistencySelector_;
        }
        return ByteString.EMPTY;
    }

    /* access modifiers changed from: private */
    public void setTransaction(ByteString value) {
        if (value != null) {
            this.consistencySelectorCase_ = 5;
            this.consistencySelector_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public TransactionOptions getNewTransaction() {
        if (this.consistencySelectorCase_ == 6) {
            return (TransactionOptions) this.consistencySelector_;
        }
        return TransactionOptions.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setNewTransaction(TransactionOptions value) {
        if (value != null) {
            this.consistencySelector_ = value;
            this.consistencySelectorCase_ = 6;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setNewTransaction(TransactionOptions.Builder builderForValue) {
        this.consistencySelector_ = builderForValue.build();
        this.consistencySelectorCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void mergeNewTransaction(TransactionOptions value) {
        if (this.consistencySelectorCase_ != 6 || this.consistencySelector_ == TransactionOptions.getDefaultInstance()) {
            this.consistencySelector_ = value;
        } else {
            this.consistencySelector_ = ((TransactionOptions.Builder) TransactionOptions.newBuilder((TransactionOptions) this.consistencySelector_).mergeFrom(value)).buildPartial();
        }
        this.consistencySelectorCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void clearNewTransaction() {
        if (this.consistencySelectorCase_ == 6) {
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
        if (!this.parent_.isEmpty()) {
            output.writeString(1, getParent());
        }
        if (this.queryTypeCase_ == 2) {
            output.writeMessage(2, (StructuredQuery) this.queryType_);
        }
        if (this.consistencySelectorCase_ == 5) {
            output.writeBytes(5, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 6) {
            output.writeMessage(6, (TransactionOptions) this.consistencySelector_);
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
        if (!this.parent_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getParent());
        }
        if (this.queryTypeCase_ == 2) {
            size2 += CodedOutputStream.computeMessageSize(2, (StructuredQuery) this.queryType_);
        }
        if (this.consistencySelectorCase_ == 5) {
            size2 += CodedOutputStream.computeBytesSize(5, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 6) {
            size2 += CodedOutputStream.computeMessageSize(6, (TransactionOptions) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 7) {
            size2 += CodedOutputStream.computeMessageSize(7, (Timestamp) this.consistencySelector_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static RunQueryRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RunQueryRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RunQueryRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RunQueryRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RunQueryRequest parseFrom(InputStream input) throws IOException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RunQueryRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RunQueryRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (RunQueryRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RunQueryRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RunQueryRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RunQueryRequest parseFrom(CodedInputStream input) throws IOException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RunQueryRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RunQueryRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<RunQueryRequest, Builder> implements RunQueryRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(RunQueryRequest.DEFAULT_INSTANCE);
        }

        public QueryTypeCase getQueryTypeCase() {
            return ((RunQueryRequest) this.instance).getQueryTypeCase();
        }

        public Builder clearQueryType() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearQueryType();
            return this;
        }

        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((RunQueryRequest) this.instance).getConsistencySelectorCase();
        }

        public Builder clearConsistencySelector() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearConsistencySelector();
            return this;
        }

        public String getParent() {
            return ((RunQueryRequest) this.instance).getParent();
        }

        public ByteString getParentBytes() {
            return ((RunQueryRequest) this.instance).getParentBytes();
        }

        public Builder setParent(String value) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setParent(value);
            return this;
        }

        public Builder clearParent() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearParent();
            return this;
        }

        public Builder setParentBytes(ByteString value) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setParentBytes(value);
            return this;
        }

        public StructuredQuery getStructuredQuery() {
            return ((RunQueryRequest) this.instance).getStructuredQuery();
        }

        public Builder setStructuredQuery(StructuredQuery value) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setStructuredQuery(value);
            return this;
        }

        public Builder setStructuredQuery(StructuredQuery.Builder builderForValue) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setStructuredQuery(builderForValue);
            return this;
        }

        public Builder mergeStructuredQuery(StructuredQuery value) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).mergeStructuredQuery(value);
            return this;
        }

        public Builder clearStructuredQuery() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearStructuredQuery();
            return this;
        }

        public ByteString getTransaction() {
            return ((RunQueryRequest) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString value) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setTransaction(value);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearTransaction();
            return this;
        }

        public TransactionOptions getNewTransaction() {
            return ((RunQueryRequest) this.instance).getNewTransaction();
        }

        public Builder setNewTransaction(TransactionOptions value) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setNewTransaction(value);
            return this;
        }

        public Builder setNewTransaction(TransactionOptions.Builder builderForValue) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setNewTransaction(builderForValue);
            return this;
        }

        public Builder mergeNewTransaction(TransactionOptions value) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).mergeNewTransaction(value);
            return this;
        }

        public Builder clearNewTransaction() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearNewTransaction();
            return this;
        }

        public Timestamp getReadTime() {
            return ((RunQueryRequest) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearReadTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.RunQueryRequest$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase;
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
            $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase = iArr2;
            try {
                iArr2[ConsistencySelectorCase.TRANSACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase[ConsistencySelectorCase.NEW_TRANSACTION.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase[ConsistencySelectorCase.READ_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase[ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            int[] iArr3 = new int[QueryTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase = iArr3;
            try {
                iArr3[QueryTypeCase.STRUCTURED_QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase[QueryTypeCase.QUERYTYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new RunQueryRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                RunQueryRequest other = (RunQueryRequest) arg1;
                boolean z = true;
                this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !other.parent_.isEmpty(), other.parent_);
                int i = AnonymousClass1.$SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase[other.getQueryTypeCase().ordinal()];
                if (i == 1) {
                    this.queryType_ = visitor.visitOneofMessage(this.queryTypeCase_ == 2, this.queryType_, other.queryType_);
                } else if (i == 2) {
                    visitor.visitOneofNotSet(this.queryTypeCase_ != 0);
                }
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase[other.getConsistencySelectorCase().ordinal()];
                if (i2 == 1) {
                    if (this.consistencySelectorCase_ != 5) {
                        z = false;
                    }
                    this.consistencySelector_ = visitor.visitOneofByteString(z, this.consistencySelector_, other.consistencySelector_);
                } else if (i2 == 2) {
                    if (this.consistencySelectorCase_ != 6) {
                        z = false;
                    }
                    this.consistencySelector_ = visitor.visitOneofMessage(z, this.consistencySelector_, other.consistencySelector_);
                } else if (i2 == 3) {
                    if (this.consistencySelectorCase_ != 7) {
                        z = false;
                    }
                    this.consistencySelector_ = visitor.visitOneofMessage(z, this.consistencySelector_, other.consistencySelector_);
                } else if (i2 == 4) {
                    if (this.consistencySelectorCase_ == 0) {
                        z = false;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    int i3 = other.queryTypeCase_;
                    if (i3 != 0) {
                        this.queryTypeCase_ = i3;
                    }
                    int i4 = other.consistencySelectorCase_;
                    if (i4 != 0) {
                        this.consistencySelectorCase_ = i4;
                    }
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
                            StructuredQuery.Builder subBuilder = null;
                            if (this.queryTypeCase_ == 2) {
                                subBuilder = (StructuredQuery.Builder) ((StructuredQuery) this.queryType_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(StructuredQuery.parser(), extensionRegistry);
                            this.queryType_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((StructuredQuery) readMessage);
                                this.queryType_ = subBuilder.buildPartial();
                            }
                            this.queryTypeCase_ = 2;
                        } else if (tag == 42) {
                            this.consistencySelectorCase_ = 5;
                            this.consistencySelector_ = input.readBytes();
                        } else if (tag == 50) {
                            TransactionOptions.Builder subBuilder2 = null;
                            if (this.consistencySelectorCase_ == 6) {
                                subBuilder2 = (TransactionOptions.Builder) ((TransactionOptions) this.consistencySelector_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(TransactionOptions.parser(), extensionRegistry);
                            this.consistencySelector_ = readMessage2;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((TransactionOptions) readMessage2);
                                this.consistencySelector_ = subBuilder2.buildPartial();
                            }
                            this.consistencySelectorCase_ = 6;
                        } else if (tag == 58) {
                            Timestamp.Builder subBuilder3 = null;
                            if (this.consistencySelectorCase_ == 7) {
                                subBuilder3 = (Timestamp.Builder) ((Timestamp) this.consistencySelector_).toBuilder();
                            }
                            MessageLite readMessage3 = input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.consistencySelector_ = readMessage3;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom((Timestamp) readMessage3);
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
                    synchronized (RunQueryRequest.class) {
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
        RunQueryRequest runQueryRequest = new RunQueryRequest();
        DEFAULT_INSTANCE = runQueryRequest;
        runQueryRequest.makeImmutable();
    }

    public static RunQueryRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RunQueryRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
