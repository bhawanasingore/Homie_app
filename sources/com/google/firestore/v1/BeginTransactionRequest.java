package com.google.firestore.v1;

import com.google.firestore.v1.TransactionOptions;
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
public final class BeginTransactionRequest extends GeneratedMessageLite<BeginTransactionRequest, Builder> implements BeginTransactionRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final BeginTransactionRequest DEFAULT_INSTANCE;
    public static final int OPTIONS_FIELD_NUMBER = 2;
    private static volatile Parser<BeginTransactionRequest> PARSER;
    private String database_ = "";
    private TransactionOptions options_;

    private BeginTransactionRequest() {
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

    public boolean hasOptions() {
        return this.options_ != null;
    }

    public TransactionOptions getOptions() {
        TransactionOptions transactionOptions = this.options_;
        return transactionOptions == null ? TransactionOptions.getDefaultInstance() : transactionOptions;
    }

    /* access modifiers changed from: private */
    public void setOptions(TransactionOptions value) {
        if (value != null) {
            this.options_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setOptions(TransactionOptions.Builder builderForValue) {
        this.options_ = (TransactionOptions) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeOptions(TransactionOptions value) {
        TransactionOptions transactionOptions = this.options_;
        if (transactionOptions == null || transactionOptions == TransactionOptions.getDefaultInstance()) {
            this.options_ = value;
        } else {
            this.options_ = (TransactionOptions) ((TransactionOptions.Builder) TransactionOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.database_.isEmpty()) {
            output.writeString(1, getDatabase());
        }
        if (this.options_ != null) {
            output.writeMessage(2, getOptions());
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
        if (this.options_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getOptions());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static BeginTransactionRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (BeginTransactionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BeginTransactionRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BeginTransactionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BeginTransactionRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (BeginTransactionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BeginTransactionRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BeginTransactionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BeginTransactionRequest parseFrom(InputStream input) throws IOException {
        return (BeginTransactionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BeginTransactionRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BeginTransactionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BeginTransactionRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (BeginTransactionRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static BeginTransactionRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BeginTransactionRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BeginTransactionRequest parseFrom(CodedInputStream input) throws IOException {
        return (BeginTransactionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BeginTransactionRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BeginTransactionRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BeginTransactionRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<BeginTransactionRequest, Builder> implements BeginTransactionRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(BeginTransactionRequest.DEFAULT_INSTANCE);
        }

        public String getDatabase() {
            return ((BeginTransactionRequest) this.instance).getDatabase();
        }

        public ByteString getDatabaseBytes() {
            return ((BeginTransactionRequest) this.instance).getDatabaseBytes();
        }

        public Builder setDatabase(String value) {
            copyOnWrite();
            ((BeginTransactionRequest) this.instance).setDatabase(value);
            return this;
        }

        public Builder clearDatabase() {
            copyOnWrite();
            ((BeginTransactionRequest) this.instance).clearDatabase();
            return this;
        }

        public Builder setDatabaseBytes(ByteString value) {
            copyOnWrite();
            ((BeginTransactionRequest) this.instance).setDatabaseBytes(value);
            return this;
        }

        public boolean hasOptions() {
            return ((BeginTransactionRequest) this.instance).hasOptions();
        }

        public TransactionOptions getOptions() {
            return ((BeginTransactionRequest) this.instance).getOptions();
        }

        public Builder setOptions(TransactionOptions value) {
            copyOnWrite();
            ((BeginTransactionRequest) this.instance).setOptions(value);
            return this;
        }

        public Builder setOptions(TransactionOptions.Builder builderForValue) {
            copyOnWrite();
            ((BeginTransactionRequest) this.instance).setOptions(builderForValue);
            return this;
        }

        public Builder mergeOptions(TransactionOptions value) {
            copyOnWrite();
            ((BeginTransactionRequest) this.instance).mergeOptions(value);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((BeginTransactionRequest) this.instance).clearOptions();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.BeginTransactionRequest$1  reason: invalid class name */
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
                return new BeginTransactionRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                BeginTransactionRequest other = (BeginTransactionRequest) arg1;
                this.database_ = visitor.visitString(!this.database_.isEmpty(), this.database_, !other.database_.isEmpty(), other.database_);
                this.options_ = (TransactionOptions) visitor.visitMessage(this.options_, other.options_);
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
                            this.database_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            TransactionOptions.Builder subBuilder = null;
                            if (this.options_ != null) {
                                subBuilder = (TransactionOptions.Builder) this.options_.toBuilder();
                            }
                            TransactionOptions transactionOptions = (TransactionOptions) input.readMessage(TransactionOptions.parser(), extensionRegistry);
                            this.options_ = transactionOptions;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(transactionOptions);
                                this.options_ = (TransactionOptions) subBuilder.buildPartial();
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
                    synchronized (BeginTransactionRequest.class) {
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
        BeginTransactionRequest beginTransactionRequest = new BeginTransactionRequest();
        DEFAULT_INSTANCE = beginTransactionRequest;
        beginTransactionRequest.makeImmutable();
    }

    public static BeginTransactionRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<BeginTransactionRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
