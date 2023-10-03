package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class TransactionOptions extends GeneratedMessageLite<TransactionOptions, Builder> implements TransactionOptionsOrBuilder {
    /* access modifiers changed from: private */
    public static final TransactionOptions DEFAULT_INSTANCE;
    private static volatile Parser<TransactionOptions> PARSER = null;
    public static final int READ_ONLY_FIELD_NUMBER = 2;
    public static final int READ_WRITE_FIELD_NUMBER = 3;
    private int modeCase_ = 0;
    private Object mode_;

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface ReadOnlyOrBuilder extends MessageLiteOrBuilder {
        ReadOnly.ConsistencySelectorCase getConsistencySelectorCase();

        Timestamp getReadTime();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface ReadWriteOrBuilder extends MessageLiteOrBuilder {
        ByteString getRetryTransaction();
    }

    private TransactionOptions() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class ReadWrite extends GeneratedMessageLite<ReadWrite, Builder> implements ReadWriteOrBuilder {
        /* access modifiers changed from: private */
        public static final ReadWrite DEFAULT_INSTANCE;
        private static volatile Parser<ReadWrite> PARSER = null;
        public static final int RETRY_TRANSACTION_FIELD_NUMBER = 1;
        private ByteString retryTransaction_ = ByteString.EMPTY;

        private ReadWrite() {
        }

        public ByteString getRetryTransaction() {
            return this.retryTransaction_;
        }

        /* access modifiers changed from: private */
        public void setRetryTransaction(ByteString value) {
            if (value != null) {
                this.retryTransaction_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearRetryTransaction() {
            this.retryTransaction_ = getDefaultInstance().getRetryTransaction();
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.retryTransaction_.isEmpty()) {
                output.writeBytes(1, this.retryTransaction_);
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.retryTransaction_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeBytesSize(1, this.retryTransaction_);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static ReadWrite parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadWrite parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadWrite parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadWrite parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadWrite parseFrom(InputStream input) throws IOException {
            return (ReadWrite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadWrite parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadWrite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadWrite parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadWrite) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadWrite parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadWrite) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadWrite parseFrom(CodedInputStream input) throws IOException {
            return (ReadWrite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadWrite parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadWrite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReadWrite prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadWrite, Builder> implements ReadWriteOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(ReadWrite.DEFAULT_INSTANCE);
            }

            public ByteString getRetryTransaction() {
                return ((ReadWrite) this.instance).getRetryTransaction();
            }

            public Builder setRetryTransaction(ByteString value) {
                copyOnWrite();
                ((ReadWrite) this.instance).setRetryTransaction(value);
                return this;
            }

            public Builder clearRetryTransaction() {
                copyOnWrite();
                ((ReadWrite) this.instance).clearRetryTransaction();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new ReadWrite();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    ReadWrite other = (ReadWrite) arg1;
                    boolean z = true;
                    boolean z2 = this.retryTransaction_ != ByteString.EMPTY;
                    ByteString byteString = this.retryTransaction_;
                    if (other.retryTransaction_ == ByteString.EMPTY) {
                        z = false;
                    }
                    this.retryTransaction_ = visitor.visitByteString(z2, byteString, z, other.retryTransaction_);
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
                                this.retryTransaction_ = input.readBytes();
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
                        synchronized (ReadWrite.class) {
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
            ReadWrite readWrite = new ReadWrite();
            DEFAULT_INSTANCE = readWrite;
            readWrite.makeImmutable();
        }

        public static ReadWrite getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadWrite> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class ReadOnly extends GeneratedMessageLite<ReadOnly, Builder> implements ReadOnlyOrBuilder {
        /* access modifiers changed from: private */
        public static final ReadOnly DEFAULT_INSTANCE;
        private static volatile Parser<ReadOnly> PARSER = null;
        public static final int READ_TIME_FIELD_NUMBER = 2;
        private int consistencySelectorCase_ = 0;
        private Object consistencySelector_;

        private ReadOnly() {
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public enum ConsistencySelectorCase implements Internal.EnumLite {
            READ_TIME(2),
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
                if (value2 != 2) {
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

        public Timestamp getReadTime() {
            if (this.consistencySelectorCase_ == 2) {
                return (Timestamp) this.consistencySelector_;
            }
            return Timestamp.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setReadTime(Timestamp value) {
            if (value != null) {
                this.consistencySelector_ = value;
                this.consistencySelectorCase_ = 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setReadTime(Timestamp.Builder builderForValue) {
            this.consistencySelector_ = builderForValue.build();
            this.consistencySelectorCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void mergeReadTime(Timestamp value) {
            if (this.consistencySelectorCase_ != 2 || this.consistencySelector_ == Timestamp.getDefaultInstance()) {
                this.consistencySelector_ = value;
            } else {
                this.consistencySelector_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom(value)).buildPartial();
            }
            this.consistencySelectorCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void clearReadTime() {
            if (this.consistencySelectorCase_ == 2) {
                this.consistencySelectorCase_ = 0;
                this.consistencySelector_ = null;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.consistencySelectorCase_ == 2) {
                output.writeMessage(2, (Timestamp) this.consistencySelector_);
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.consistencySelectorCase_ == 2) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, (Timestamp) this.consistencySelector_);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static ReadOnly parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadOnly parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadOnly parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadOnly parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadOnly parseFrom(InputStream input) throws IOException {
            return (ReadOnly) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadOnly parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadOnly) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadOnly parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadOnly) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadOnly parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadOnly) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadOnly parseFrom(CodedInputStream input) throws IOException {
            return (ReadOnly) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadOnly parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadOnly) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReadOnly prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadOnly, Builder> implements ReadOnlyOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(ReadOnly.DEFAULT_INSTANCE);
            }

            public ConsistencySelectorCase getConsistencySelectorCase() {
                return ((ReadOnly) this.instance).getConsistencySelectorCase();
            }

            public Builder clearConsistencySelector() {
                copyOnWrite();
                ((ReadOnly) this.instance).clearConsistencySelector();
                return this;
            }

            public Timestamp getReadTime() {
                return ((ReadOnly) this.instance).getReadTime();
            }

            public Builder setReadTime(Timestamp value) {
                copyOnWrite();
                ((ReadOnly) this.instance).setReadTime(value);
                return this;
            }

            public Builder setReadTime(Timestamp.Builder builderForValue) {
                copyOnWrite();
                ((ReadOnly) this.instance).setReadTime(builderForValue);
                return this;
            }

            public Builder mergeReadTime(Timestamp value) {
                copyOnWrite();
                ((ReadOnly) this.instance).mergeReadTime(value);
                return this;
            }

            public Builder clearReadTime() {
                copyOnWrite();
                ((ReadOnly) this.instance).clearReadTime();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            int i;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new ReadOnly();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    ReadOnly other = (ReadOnly) arg1;
                    int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$TransactionOptions$ReadOnly$ConsistencySelectorCase[other.getConsistencySelectorCase().ordinal()];
                    boolean z = false;
                    if (i2 == 1) {
                        if (this.consistencySelectorCase_ == 2) {
                            z = true;
                        }
                        this.consistencySelector_ = visitor.visitOneofMessage(z, this.consistencySelector_, other.consistencySelector_);
                    } else if (i2 == 2) {
                        if (this.consistencySelectorCase_ != 0) {
                            z = true;
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
                            } else if (tag == 18) {
                                Timestamp.Builder subBuilder = null;
                                if (this.consistencySelectorCase_ == 2) {
                                    subBuilder = (Timestamp.Builder) ((Timestamp) this.consistencySelector_).toBuilder();
                                }
                                MessageLite readMessage = input.readMessage(Timestamp.parser(), extensionRegistry);
                                this.consistencySelector_ = readMessage;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((Timestamp) readMessage);
                                    this.consistencySelector_ = subBuilder.buildPartial();
                                }
                                this.consistencySelectorCase_ = 2;
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
                        synchronized (ReadOnly.class) {
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
            ReadOnly readOnly = new ReadOnly();
            DEFAULT_INSTANCE = readOnly;
            readOnly.makeImmutable();
        }

        public static ReadOnly getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadOnly> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ModeCase implements Internal.EnumLite {
        READ_ONLY(2),
        READ_WRITE(3),
        MODE_NOT_SET(0);
        
        private final int value;

        private ModeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static ModeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static ModeCase forNumber(int value2) {
            if (value2 == 0) {
                return MODE_NOT_SET;
            }
            if (value2 == 2) {
                return READ_ONLY;
            }
            if (value2 != 3) {
                return null;
            }
            return READ_WRITE;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ModeCase getModeCase() {
        return ModeCase.forNumber(this.modeCase_);
    }

    /* access modifiers changed from: private */
    public void clearMode() {
        this.modeCase_ = 0;
        this.mode_ = null;
    }

    public ReadOnly getReadOnly() {
        if (this.modeCase_ == 2) {
            return (ReadOnly) this.mode_;
        }
        return ReadOnly.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setReadOnly(ReadOnly value) {
        if (value != null) {
            this.mode_ = value;
            this.modeCase_ = 2;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setReadOnly(ReadOnly.Builder builderForValue) {
        this.mode_ = builderForValue.build();
        this.modeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void mergeReadOnly(ReadOnly value) {
        if (this.modeCase_ != 2 || this.mode_ == ReadOnly.getDefaultInstance()) {
            this.mode_ = value;
        } else {
            this.mode_ = ((ReadOnly.Builder) ReadOnly.newBuilder((ReadOnly) this.mode_).mergeFrom(value)).buildPartial();
        }
        this.modeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void clearReadOnly() {
        if (this.modeCase_ == 2) {
            this.modeCase_ = 0;
            this.mode_ = null;
        }
    }

    public ReadWrite getReadWrite() {
        if (this.modeCase_ == 3) {
            return (ReadWrite) this.mode_;
        }
        return ReadWrite.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setReadWrite(ReadWrite value) {
        if (value != null) {
            this.mode_ = value;
            this.modeCase_ = 3;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setReadWrite(ReadWrite.Builder builderForValue) {
        this.mode_ = builderForValue.build();
        this.modeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void mergeReadWrite(ReadWrite value) {
        if (this.modeCase_ != 3 || this.mode_ == ReadWrite.getDefaultInstance()) {
            this.mode_ = value;
        } else {
            this.mode_ = ((ReadWrite.Builder) ReadWrite.newBuilder((ReadWrite) this.mode_).mergeFrom(value)).buildPartial();
        }
        this.modeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void clearReadWrite() {
        if (this.modeCase_ == 3) {
            this.modeCase_ = 0;
            this.mode_ = null;
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.modeCase_ == 2) {
            output.writeMessage(2, (ReadOnly) this.mode_);
        }
        if (this.modeCase_ == 3) {
            output.writeMessage(3, (ReadWrite) this.mode_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.modeCase_ == 2) {
            size2 = 0 + CodedOutputStream.computeMessageSize(2, (ReadOnly) this.mode_);
        }
        if (this.modeCase_ == 3) {
            size2 += CodedOutputStream.computeMessageSize(3, (ReadWrite) this.mode_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static TransactionOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TransactionOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TransactionOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TransactionOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TransactionOptions parseFrom(InputStream input) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TransactionOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TransactionOptions parseDelimitedFrom(InputStream input) throws IOException {
        return (TransactionOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static TransactionOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TransactionOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TransactionOptions parseFrom(CodedInputStream input) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TransactionOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TransactionOptions prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<TransactionOptions, Builder> implements TransactionOptionsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(TransactionOptions.DEFAULT_INSTANCE);
        }

        public ModeCase getModeCase() {
            return ((TransactionOptions) this.instance).getModeCase();
        }

        public Builder clearMode() {
            copyOnWrite();
            ((TransactionOptions) this.instance).clearMode();
            return this;
        }

        public ReadOnly getReadOnly() {
            return ((TransactionOptions) this.instance).getReadOnly();
        }

        public Builder setReadOnly(ReadOnly value) {
            copyOnWrite();
            ((TransactionOptions) this.instance).setReadOnly(value);
            return this;
        }

        public Builder setReadOnly(ReadOnly.Builder builderForValue) {
            copyOnWrite();
            ((TransactionOptions) this.instance).setReadOnly(builderForValue);
            return this;
        }

        public Builder mergeReadOnly(ReadOnly value) {
            copyOnWrite();
            ((TransactionOptions) this.instance).mergeReadOnly(value);
            return this;
        }

        public Builder clearReadOnly() {
            copyOnWrite();
            ((TransactionOptions) this.instance).clearReadOnly();
            return this;
        }

        public ReadWrite getReadWrite() {
            return ((TransactionOptions) this.instance).getReadWrite();
        }

        public Builder setReadWrite(ReadWrite value) {
            copyOnWrite();
            ((TransactionOptions) this.instance).setReadWrite(value);
            return this;
        }

        public Builder setReadWrite(ReadWrite.Builder builderForValue) {
            copyOnWrite();
            ((TransactionOptions) this.instance).setReadWrite(builderForValue);
            return this;
        }

        public Builder mergeReadWrite(ReadWrite value) {
            copyOnWrite();
            ((TransactionOptions) this.instance).mergeReadWrite(value);
            return this;
        }

        public Builder clearReadWrite() {
            copyOnWrite();
            ((TransactionOptions) this.instance).clearReadWrite();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new TransactionOptions();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                TransactionOptions other = (TransactionOptions) arg1;
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$TransactionOptions$ModeCase[other.getModeCase().ordinal()];
                boolean z = false;
                if (i2 == 1) {
                    if (this.modeCase_ == 2) {
                        z = true;
                    }
                    this.mode_ = visitor.visitOneofMessage(z, this.mode_, other.mode_);
                } else if (i2 == 2) {
                    if (this.modeCase_ == 3) {
                        z = true;
                    }
                    this.mode_ = visitor.visitOneofMessage(z, this.mode_, other.mode_);
                } else if (i2 == 3) {
                    if (this.modeCase_ != 0) {
                        z = true;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.modeCase_) != 0) {
                    this.modeCase_ = i;
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
                        } else if (tag == 18) {
                            ReadOnly.Builder subBuilder = null;
                            if (this.modeCase_ == 2) {
                                subBuilder = (ReadOnly.Builder) ((ReadOnly) this.mode_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(ReadOnly.parser(), extensionRegistry);
                            this.mode_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((ReadOnly) readMessage);
                                this.mode_ = subBuilder.buildPartial();
                            }
                            this.modeCase_ = 2;
                        } else if (tag == 26) {
                            ReadWrite.Builder subBuilder2 = null;
                            if (this.modeCase_ == 3) {
                                subBuilder2 = (ReadWrite.Builder) ((ReadWrite) this.mode_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(ReadWrite.parser(), extensionRegistry);
                            this.mode_ = readMessage2;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((ReadWrite) readMessage2);
                                this.mode_ = subBuilder2.buildPartial();
                            }
                            this.modeCase_ = 3;
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
                    synchronized (TransactionOptions.class) {
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

    /* renamed from: com.google.firestore.v1.TransactionOptions$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$TransactionOptions$ModeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$TransactionOptions$ReadOnly$ConsistencySelectorCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[ModeCase.values().length];
            $SwitchMap$com$google$firestore$v1$TransactionOptions$ModeCase = iArr;
            try {
                iArr[ModeCase.READ_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$TransactionOptions$ModeCase[ModeCase.READ_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$TransactionOptions$ModeCase[ModeCase.MODE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[ReadOnly.ConsistencySelectorCase.values().length];
            $SwitchMap$com$google$firestore$v1$TransactionOptions$ReadOnly$ConsistencySelectorCase = iArr2;
            try {
                iArr2[ReadOnly.ConsistencySelectorCase.READ_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$TransactionOptions$ReadOnly$ConsistencySelectorCase[ReadOnly.ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr3 = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr3;
            try {
                iArr3[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    static {
        TransactionOptions transactionOptions = new TransactionOptions();
        DEFAULT_INSTANCE = transactionOptions;
        transactionOptions.makeImmutable();
    }

    public static TransactionOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TransactionOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
