package com.google.api;

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
public final class HttpBody extends GeneratedMessageLite<HttpBody, Builder> implements HttpBodyOrBuilder {
    public static final int CONTENT_TYPE_FIELD_NUMBER = 1;
    public static final int DATA_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final HttpBody DEFAULT_INSTANCE;
    private static volatile Parser<HttpBody> PARSER;
    private String contentType_ = "";
    private ByteString data_ = ByteString.EMPTY;

    private HttpBody() {
    }

    public String getContentType() {
        return this.contentType_;
    }

    public ByteString getContentTypeBytes() {
        return ByteString.copyFromUtf8(this.contentType_);
    }

    /* access modifiers changed from: private */
    public void setContentType(String value) {
        if (value != null) {
            this.contentType_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearContentType() {
        this.contentType_ = getDefaultInstance().getContentType();
    }

    /* access modifiers changed from: private */
    public void setContentTypeBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.contentType_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public ByteString getData() {
        return this.data_;
    }

    /* access modifiers changed from: private */
    public void setData(ByteString value) {
        if (value != null) {
            this.data_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.contentType_.isEmpty()) {
            output.writeString(1, getContentType());
        }
        if (!this.data_.isEmpty()) {
            output.writeBytes(2, this.data_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.contentType_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getContentType());
        }
        if (!this.data_.isEmpty()) {
            size2 += CodedOutputStream.computeBytesSize(2, this.data_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static HttpBody parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HttpBody parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HttpBody parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HttpBody parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HttpBody parseFrom(InputStream input) throws IOException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HttpBody parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HttpBody parseDelimitedFrom(InputStream input) throws IOException {
        return (HttpBody) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HttpBody parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HttpBody) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HttpBody parseFrom(CodedInputStream input) throws IOException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HttpBody parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(HttpBody prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpBody, Builder> implements HttpBodyOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(HttpBody.DEFAULT_INSTANCE);
        }

        public String getContentType() {
            return ((HttpBody) this.instance).getContentType();
        }

        public ByteString getContentTypeBytes() {
            return ((HttpBody) this.instance).getContentTypeBytes();
        }

        public Builder setContentType(String value) {
            copyOnWrite();
            ((HttpBody) this.instance).setContentType(value);
            return this;
        }

        public Builder clearContentType() {
            copyOnWrite();
            ((HttpBody) this.instance).clearContentType();
            return this;
        }

        public Builder setContentTypeBytes(ByteString value) {
            copyOnWrite();
            ((HttpBody) this.instance).setContentTypeBytes(value);
            return this;
        }

        public ByteString getData() {
            return ((HttpBody) this.instance).getData();
        }

        public Builder setData(ByteString value) {
            copyOnWrite();
            ((HttpBody) this.instance).setData(value);
            return this;
        }

        public Builder clearData() {
            copyOnWrite();
            ((HttpBody) this.instance).clearData();
            return this;
        }
    }

    /* renamed from: com.google.api.HttpBody$1  reason: invalid class name */
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
                return new HttpBody();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                HttpBody other = (HttpBody) arg1;
                boolean z = true;
                this.contentType_ = visitor.visitString(!this.contentType_.isEmpty(), this.contentType_, !other.contentType_.isEmpty(), other.contentType_);
                boolean z2 = this.data_ != ByteString.EMPTY;
                ByteString byteString = this.data_;
                if (other.data_ == ByteString.EMPTY) {
                    z = false;
                }
                this.data_ = visitor.visitByteString(z2, byteString, z, other.data_);
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
                            this.contentType_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.data_ = input.readBytes();
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
                    synchronized (HttpBody.class) {
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
        HttpBody httpBody = new HttpBody();
        DEFAULT_INSTANCE = httpBody;
        httpBody.makeImmutable();
    }

    public static HttpBody getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HttpBody> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
