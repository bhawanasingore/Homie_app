package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class LocalizedMessage extends GeneratedMessageLite<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
    /* access modifiers changed from: private */
    public static final LocalizedMessage DEFAULT_INSTANCE;
    public static final int LOCALE_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<LocalizedMessage> PARSER;
    private String locale_ = "";
    private String message_ = "";

    private LocalizedMessage() {
    }

    public String getLocale() {
        return this.locale_;
    }

    public ByteString getLocaleBytes() {
        return ByteString.copyFromUtf8(this.locale_);
    }

    /* access modifiers changed from: private */
    public void setLocale(String value) {
        if (value != null) {
            this.locale_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearLocale() {
        this.locale_ = getDefaultInstance().getLocale();
    }

    /* access modifiers changed from: private */
    public void setLocaleBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.locale_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getMessage() {
        return this.message_;
    }

    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    /* access modifiers changed from: private */
    public void setMessage(String value) {
        if (value != null) {
            this.message_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* access modifiers changed from: private */
    public void setMessageBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.message_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.locale_.isEmpty()) {
            output.writeString(1, getLocale());
        }
        if (!this.message_.isEmpty()) {
            output.writeString(2, getMessage());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.locale_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getLocale());
        }
        if (!this.message_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getMessage());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static LocalizedMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocalizedMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocalizedMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocalizedMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocalizedMessage parseFrom(InputStream input) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocalizedMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocalizedMessage parseDelimitedFrom(InputStream input) throws IOException {
        return (LocalizedMessage) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static LocalizedMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocalizedMessage) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocalizedMessage parseFrom(CodedInputStream input) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocalizedMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LocalizedMessage prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(LocalizedMessage.DEFAULT_INSTANCE);
        }

        public String getLocale() {
            return ((LocalizedMessage) this.instance).getLocale();
        }

        public ByteString getLocaleBytes() {
            return ((LocalizedMessage) this.instance).getLocaleBytes();
        }

        public Builder setLocale(String value) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setLocale(value);
            return this;
        }

        public Builder clearLocale() {
            copyOnWrite();
            ((LocalizedMessage) this.instance).clearLocale();
            return this;
        }

        public Builder setLocaleBytes(ByteString value) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setLocaleBytes(value);
            return this;
        }

        public String getMessage() {
            return ((LocalizedMessage) this.instance).getMessage();
        }

        public ByteString getMessageBytes() {
            return ((LocalizedMessage) this.instance).getMessageBytes();
        }

        public Builder setMessage(String value) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setMessage(value);
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((LocalizedMessage) this.instance).clearMessage();
            return this;
        }

        public Builder setMessageBytes(ByteString value) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setMessageBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.rpc.LocalizedMessage$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
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
                return new LocalizedMessage();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                LocalizedMessage other = (LocalizedMessage) arg1;
                this.locale_ = visitor.visitString(!this.locale_.isEmpty(), this.locale_, !other.locale_.isEmpty(), other.locale_);
                this.message_ = visitor.visitString(!this.message_.isEmpty(), this.message_, !other.message_.isEmpty(), other.message_);
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
                            this.locale_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.message_ = input.readStringRequireUtf8();
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
                    synchronized (LocalizedMessage.class) {
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
        LocalizedMessage localizedMessage = new LocalizedMessage();
        DEFAULT_INSTANCE = localizedMessage;
        localizedMessage.makeImmutable();
    }

    public static LocalizedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<LocalizedMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
