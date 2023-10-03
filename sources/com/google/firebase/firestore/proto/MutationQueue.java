package com.google.firebase.firestore.proto;

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
public final class MutationQueue extends GeneratedMessageLite<MutationQueue, Builder> implements MutationQueueOrBuilder {
    /* access modifiers changed from: private */
    public static final MutationQueue DEFAULT_INSTANCE;
    public static final int LAST_ACKNOWLEDGED_BATCH_ID_FIELD_NUMBER = 1;
    public static final int LAST_STREAM_TOKEN_FIELD_NUMBER = 2;
    private static volatile Parser<MutationQueue> PARSER;
    private int lastAcknowledgedBatchId_;
    private ByteString lastStreamToken_ = ByteString.EMPTY;

    private MutationQueue() {
    }

    public int getLastAcknowledgedBatchId() {
        return this.lastAcknowledgedBatchId_;
    }

    /* access modifiers changed from: private */
    public void setLastAcknowledgedBatchId(int value) {
        this.lastAcknowledgedBatchId_ = value;
    }

    /* access modifiers changed from: private */
    public void clearLastAcknowledgedBatchId() {
        this.lastAcknowledgedBatchId_ = 0;
    }

    public ByteString getLastStreamToken() {
        return this.lastStreamToken_;
    }

    /* access modifiers changed from: private */
    public void setLastStreamToken(ByteString value) {
        if (value != null) {
            this.lastStreamToken_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearLastStreamToken() {
        this.lastStreamToken_ = getDefaultInstance().getLastStreamToken();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = this.lastAcknowledgedBatchId_;
        if (i != 0) {
            output.writeInt32(1, i);
        }
        if (!this.lastStreamToken_.isEmpty()) {
            output.writeBytes(2, this.lastStreamToken_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.lastAcknowledgedBatchId_;
        if (i != 0) {
            size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
        }
        if (!this.lastStreamToken_.isEmpty()) {
            size2 += CodedOutputStream.computeBytesSize(2, this.lastStreamToken_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static MutationQueue parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (MutationQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MutationQueue parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MutationQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MutationQueue parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (MutationQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MutationQueue parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MutationQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MutationQueue parseFrom(InputStream input) throws IOException {
        return (MutationQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MutationQueue parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MutationQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MutationQueue parseDelimitedFrom(InputStream input) throws IOException {
        return (MutationQueue) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static MutationQueue parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MutationQueue) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MutationQueue parseFrom(CodedInputStream input) throws IOException {
        return (MutationQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MutationQueue parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MutationQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MutationQueue prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<MutationQueue, Builder> implements MutationQueueOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(MutationQueue.DEFAULT_INSTANCE);
        }

        public int getLastAcknowledgedBatchId() {
            return ((MutationQueue) this.instance).getLastAcknowledgedBatchId();
        }

        public Builder setLastAcknowledgedBatchId(int value) {
            copyOnWrite();
            ((MutationQueue) this.instance).setLastAcknowledgedBatchId(value);
            return this;
        }

        public Builder clearLastAcknowledgedBatchId() {
            copyOnWrite();
            ((MutationQueue) this.instance).clearLastAcknowledgedBatchId();
            return this;
        }

        public ByteString getLastStreamToken() {
            return ((MutationQueue) this.instance).getLastStreamToken();
        }

        public Builder setLastStreamToken(ByteString value) {
            copyOnWrite();
            ((MutationQueue) this.instance).setLastStreamToken(value);
            return this;
        }

        public Builder clearLastStreamToken() {
            copyOnWrite();
            ((MutationQueue) this.instance).clearLastStreamToken();
            return this;
        }
    }

    /* renamed from: com.google.firebase.firestore.proto.MutationQueue$1  reason: invalid class name */
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
                return new MutationQueue();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                MutationQueue other = (MutationQueue) arg1;
                boolean z = true;
                this.lastAcknowledgedBatchId_ = visitor.visitInt(this.lastAcknowledgedBatchId_ != 0, this.lastAcknowledgedBatchId_, other.lastAcknowledgedBatchId_ != 0, other.lastAcknowledgedBatchId_);
                boolean z2 = this.lastStreamToken_ != ByteString.EMPTY;
                ByteString byteString = this.lastStreamToken_;
                if (other.lastStreamToken_ == ByteString.EMPTY) {
                    z = false;
                }
                this.lastStreamToken_ = visitor.visitByteString(z2, byteString, z, other.lastStreamToken_);
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
                        } else if (tag == 8) {
                            this.lastAcknowledgedBatchId_ = input.readInt32();
                        } else if (tag == 18) {
                            this.lastStreamToken_ = input.readBytes();
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
                    synchronized (MutationQueue.class) {
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
        MutationQueue mutationQueue = new MutationQueue();
        DEFAULT_INSTANCE = mutationQueue;
        mutationQueue.makeImmutable();
    }

    public static MutationQueue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MutationQueue> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
