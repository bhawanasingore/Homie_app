package com.google.firebase.firestore.proto;

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
public final class NoDocument extends GeneratedMessageLite<NoDocument, Builder> implements NoDocumentOrBuilder {
    /* access modifiers changed from: private */
    public static final NoDocument DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<NoDocument> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 2;
    private String name_ = "";
    private Timestamp readTime_;

    private NoDocument() {
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
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (this.readTime_ != null) {
            output.writeMessage(2, getReadTime());
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
        if (this.readTime_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getReadTime());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static NoDocument parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (NoDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static NoDocument parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (NoDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static NoDocument parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (NoDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static NoDocument parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (NoDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static NoDocument parseFrom(InputStream input) throws IOException {
        return (NoDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static NoDocument parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (NoDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static NoDocument parseDelimitedFrom(InputStream input) throws IOException {
        return (NoDocument) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static NoDocument parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (NoDocument) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static NoDocument parseFrom(CodedInputStream input) throws IOException {
        return (NoDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static NoDocument parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (NoDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(NoDocument prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<NoDocument, Builder> implements NoDocumentOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(NoDocument.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((NoDocument) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((NoDocument) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((NoDocument) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((NoDocument) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((NoDocument) this.instance).setNameBytes(value);
            return this;
        }

        public boolean hasReadTime() {
            return ((NoDocument) this.instance).hasReadTime();
        }

        public Timestamp getReadTime() {
            return ((NoDocument) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((NoDocument) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((NoDocument) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((NoDocument) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((NoDocument) this.instance).clearReadTime();
            return this;
        }
    }

    /* renamed from: com.google.firebase.firestore.proto.NoDocument$1  reason: invalid class name */
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
                return new NoDocument();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                NoDocument other = (NoDocument) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, other.readTime_);
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
                            this.name_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            Timestamp.Builder subBuilder = null;
                            if (this.readTime_ != null) {
                                subBuilder = (Timestamp.Builder) this.readTime_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.readTime_ = timestamp;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(timestamp);
                                this.readTime_ = (Timestamp) subBuilder.buildPartial();
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
                    synchronized (NoDocument.class) {
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
        NoDocument noDocument = new NoDocument();
        DEFAULT_INSTANCE = noDocument;
        noDocument.makeImmutable();
    }

    public static NoDocument getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<NoDocument> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
