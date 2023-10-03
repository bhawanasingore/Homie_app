package com.google.firestore.v1;

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
public final class BeginTransactionResponse extends GeneratedMessageLite<BeginTransactionResponse, Builder> implements BeginTransactionResponseOrBuilder {
    /* access modifiers changed from: private */
    public static final BeginTransactionResponse DEFAULT_INSTANCE;
    private static volatile Parser<BeginTransactionResponse> PARSER = null;
    public static final int TRANSACTION_FIELD_NUMBER = 1;
    private ByteString transaction_ = ByteString.EMPTY;

    private BeginTransactionResponse() {
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

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.transaction_.isEmpty()) {
            output.writeBytes(1, this.transaction_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.transaction_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeBytesSize(1, this.transaction_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static BeginTransactionResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (BeginTransactionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BeginTransactionResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BeginTransactionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BeginTransactionResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (BeginTransactionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BeginTransactionResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BeginTransactionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BeginTransactionResponse parseFrom(InputStream input) throws IOException {
        return (BeginTransactionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BeginTransactionResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BeginTransactionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BeginTransactionResponse parseDelimitedFrom(InputStream input) throws IOException {
        return (BeginTransactionResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static BeginTransactionResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BeginTransactionResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BeginTransactionResponse parseFrom(CodedInputStream input) throws IOException {
        return (BeginTransactionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BeginTransactionResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BeginTransactionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BeginTransactionResponse prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<BeginTransactionResponse, Builder> implements BeginTransactionResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(BeginTransactionResponse.DEFAULT_INSTANCE);
        }

        public ByteString getTransaction() {
            return ((BeginTransactionResponse) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString value) {
            copyOnWrite();
            ((BeginTransactionResponse) this.instance).setTransaction(value);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((BeginTransactionResponse) this.instance).clearTransaction();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.BeginTransactionResponse$1  reason: invalid class name */
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
                return new BeginTransactionResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                BeginTransactionResponse other = (BeginTransactionResponse) arg1;
                boolean z = true;
                boolean z2 = this.transaction_ != ByteString.EMPTY;
                ByteString byteString = this.transaction_;
                if (other.transaction_ == ByteString.EMPTY) {
                    z = false;
                }
                this.transaction_ = visitor.visitByteString(z2, byteString, z, other.transaction_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream input = (CodedInputStream) arg0;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        if (tag == 0) {
                            done = true;
                        } else if (tag == 10) {
                            this.transaction_ = input.readBytes();
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
                    synchronized (BeginTransactionResponse.class) {
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
        BeginTransactionResponse beginTransactionResponse = new BeginTransactionResponse();
        DEFAULT_INSTANCE = beginTransactionResponse;
        beginTransactionResponse.makeImmutable();
    }

    public static BeginTransactionResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<BeginTransactionResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
