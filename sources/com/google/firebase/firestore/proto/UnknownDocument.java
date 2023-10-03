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
public final class UnknownDocument extends GeneratedMessageLite<UnknownDocument, Builder> implements UnknownDocumentOrBuilder {
    /* access modifiers changed from: private */
    public static final UnknownDocument DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<UnknownDocument> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private String name_ = "";
    private Timestamp version_;

    private UnknownDocument() {
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

    public boolean hasVersion() {
        return this.version_ != null;
    }

    public Timestamp getVersion() {
        Timestamp timestamp = this.version_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setVersion(Timestamp value) {
        if (value != null) {
            this.version_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setVersion(Timestamp.Builder builderForValue) {
        this.version_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeVersion(Timestamp value) {
        Timestamp timestamp = this.version_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.version_ = value;
        } else {
            this.version_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.version_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (this.version_ != null) {
            output.writeMessage(2, getVersion());
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
        if (this.version_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getVersion());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static UnknownDocument parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (UnknownDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static UnknownDocument parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (UnknownDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static UnknownDocument parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (UnknownDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static UnknownDocument parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (UnknownDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static UnknownDocument parseFrom(InputStream input) throws IOException {
        return (UnknownDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static UnknownDocument parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (UnknownDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static UnknownDocument parseDelimitedFrom(InputStream input) throws IOException {
        return (UnknownDocument) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static UnknownDocument parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (UnknownDocument) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static UnknownDocument parseFrom(CodedInputStream input) throws IOException {
        return (UnknownDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static UnknownDocument parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (UnknownDocument) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(UnknownDocument prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<UnknownDocument, Builder> implements UnknownDocumentOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(UnknownDocument.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((UnknownDocument) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((UnknownDocument) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((UnknownDocument) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((UnknownDocument) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((UnknownDocument) this.instance).setNameBytes(value);
            return this;
        }

        public boolean hasVersion() {
            return ((UnknownDocument) this.instance).hasVersion();
        }

        public Timestamp getVersion() {
            return ((UnknownDocument) this.instance).getVersion();
        }

        public Builder setVersion(Timestamp value) {
            copyOnWrite();
            ((UnknownDocument) this.instance).setVersion(value);
            return this;
        }

        public Builder setVersion(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((UnknownDocument) this.instance).setVersion(builderForValue);
            return this;
        }

        public Builder mergeVersion(Timestamp value) {
            copyOnWrite();
            ((UnknownDocument) this.instance).mergeVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((UnknownDocument) this.instance).clearVersion();
            return this;
        }
    }

    /* renamed from: com.google.firebase.firestore.proto.UnknownDocument$1  reason: invalid class name */
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
                return new UnknownDocument();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                UnknownDocument other = (UnknownDocument) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.version_ = (Timestamp) visitor.visitMessage(this.version_, other.version_);
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
                            if (this.version_ != null) {
                                subBuilder = (Timestamp.Builder) this.version_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.version_ = timestamp;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(timestamp);
                                this.version_ = (Timestamp) subBuilder.buildPartial();
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
                    synchronized (UnknownDocument.class) {
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
        UnknownDocument unknownDocument = new UnknownDocument();
        DEFAULT_INSTANCE = unknownDocument;
        unknownDocument.makeImmutable();
    }

    public static UnknownDocument getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<UnknownDocument> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
