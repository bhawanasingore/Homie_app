package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class RunQueryResponse extends GeneratedMessageLite<RunQueryResponse, Builder> implements RunQueryResponseOrBuilder {
    /* access modifiers changed from: private */
    public static final RunQueryResponse DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<RunQueryResponse> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 3;
    public static final int SKIPPED_RESULTS_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 2;
    private Document document_;
    private Timestamp readTime_;
    private int skippedResults_;
    private ByteString transaction_ = ByteString.EMPTY;

    private RunQueryResponse() {
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

    public boolean hasDocument() {
        return this.document_ != null;
    }

    public Document getDocument() {
        Document document = this.document_;
        return document == null ? Document.getDefaultInstance() : document;
    }

    /* access modifiers changed from: private */
    public void setDocument(Document value) {
        if (value != null) {
            this.document_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocument(Document.Builder builderForValue) {
        this.document_ = (Document) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeDocument(Document value) {
        Document document = this.document_;
        if (document == null || document == Document.getDefaultInstance()) {
            this.document_ = value;
        } else {
            this.document_ = (Document) ((Document.Builder) Document.newBuilder(this.document_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = null;
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

    public int getSkippedResults() {
        return this.skippedResults_;
    }

    /* access modifiers changed from: private */
    public void setSkippedResults(int value) {
        this.skippedResults_ = value;
    }

    /* access modifiers changed from: private */
    public void clearSkippedResults() {
        this.skippedResults_ = 0;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.document_ != null) {
            output.writeMessage(1, getDocument());
        }
        if (!this.transaction_.isEmpty()) {
            output.writeBytes(2, this.transaction_);
        }
        if (this.readTime_ != null) {
            output.writeMessage(3, getReadTime());
        }
        int i = this.skippedResults_;
        if (i != 0) {
            output.writeInt32(4, i);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.document_ != null) {
            size2 = 0 + CodedOutputStream.computeMessageSize(1, getDocument());
        }
        if (!this.transaction_.isEmpty()) {
            size2 += CodedOutputStream.computeBytesSize(2, this.transaction_);
        }
        if (this.readTime_ != null) {
            size2 += CodedOutputStream.computeMessageSize(3, getReadTime());
        }
        int i = this.skippedResults_;
        if (i != 0) {
            size2 += CodedOutputStream.computeInt32Size(4, i);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static RunQueryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RunQueryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RunQueryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RunQueryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RunQueryResponse parseFrom(InputStream input) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RunQueryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RunQueryResponse parseDelimitedFrom(InputStream input) throws IOException {
        return (RunQueryResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RunQueryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RunQueryResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RunQueryResponse parseFrom(CodedInputStream input) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RunQueryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RunQueryResponse prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<RunQueryResponse, Builder> implements RunQueryResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(RunQueryResponse.DEFAULT_INSTANCE);
        }

        public ByteString getTransaction() {
            return ((RunQueryResponse) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString value) {
            copyOnWrite();
            ((RunQueryResponse) this.instance).setTransaction(value);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((RunQueryResponse) this.instance).clearTransaction();
            return this;
        }

        public boolean hasDocument() {
            return ((RunQueryResponse) this.instance).hasDocument();
        }

        public Document getDocument() {
            return ((RunQueryResponse) this.instance).getDocument();
        }

        public Builder setDocument(Document value) {
            copyOnWrite();
            ((RunQueryResponse) this.instance).setDocument(value);
            return this;
        }

        public Builder setDocument(Document.Builder builderForValue) {
            copyOnWrite();
            ((RunQueryResponse) this.instance).setDocument(builderForValue);
            return this;
        }

        public Builder mergeDocument(Document value) {
            copyOnWrite();
            ((RunQueryResponse) this.instance).mergeDocument(value);
            return this;
        }

        public Builder clearDocument() {
            copyOnWrite();
            ((RunQueryResponse) this.instance).clearDocument();
            return this;
        }

        public boolean hasReadTime() {
            return ((RunQueryResponse) this.instance).hasReadTime();
        }

        public Timestamp getReadTime() {
            return ((RunQueryResponse) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((RunQueryResponse) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((RunQueryResponse) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((RunQueryResponse) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((RunQueryResponse) this.instance).clearReadTime();
            return this;
        }

        public int getSkippedResults() {
            return ((RunQueryResponse) this.instance).getSkippedResults();
        }

        public Builder setSkippedResults(int value) {
            copyOnWrite();
            ((RunQueryResponse) this.instance).setSkippedResults(value);
            return this;
        }

        public Builder clearSkippedResults() {
            copyOnWrite();
            ((RunQueryResponse) this.instance).clearSkippedResults();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.RunQueryResponse$1  reason: invalid class name */
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
                return new RunQueryResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                RunQueryResponse other = (RunQueryResponse) arg1;
                boolean z = true;
                this.transaction_ = visitor.visitByteString(this.transaction_ != ByteString.EMPTY, this.transaction_, other.transaction_ != ByteString.EMPTY, other.transaction_);
                this.document_ = (Document) visitor.visitMessage(this.document_, other.document_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, other.readTime_);
                boolean z2 = this.skippedResults_ != 0;
                int i = this.skippedResults_;
                if (other.skippedResults_ == 0) {
                    z = false;
                }
                this.skippedResults_ = visitor.visitInt(z2, i, z, other.skippedResults_);
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
                            Document.Builder subBuilder = null;
                            if (this.document_ != null) {
                                subBuilder = (Document.Builder) this.document_.toBuilder();
                            }
                            Document document = (Document) input.readMessage(Document.parser(), extensionRegistry);
                            this.document_ = document;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(document);
                                this.document_ = (Document) subBuilder.buildPartial();
                            }
                        } else if (tag == 18) {
                            this.transaction_ = input.readBytes();
                        } else if (tag == 26) {
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
                        } else if (tag == 32) {
                            this.skippedResults_ = input.readInt32();
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
                    synchronized (RunQueryResponse.class) {
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
        RunQueryResponse runQueryResponse = new RunQueryResponse();
        DEFAULT_INSTANCE = runQueryResponse;
        runQueryResponse.makeImmutable();
    }

    public static RunQueryResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RunQueryResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
