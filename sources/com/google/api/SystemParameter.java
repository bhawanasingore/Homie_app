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
public final class SystemParameter extends GeneratedMessageLite<SystemParameter, Builder> implements SystemParameterOrBuilder {
    /* access modifiers changed from: private */
    public static final SystemParameter DEFAULT_INSTANCE;
    public static final int HTTP_HEADER_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<SystemParameter> PARSER = null;
    public static final int URL_QUERY_PARAMETER_FIELD_NUMBER = 3;
    private String httpHeader_ = "";
    private String name_ = "";
    private String urlQueryParameter_ = "";

    private SystemParameter() {
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

    public String getHttpHeader() {
        return this.httpHeader_;
    }

    public ByteString getHttpHeaderBytes() {
        return ByteString.copyFromUtf8(this.httpHeader_);
    }

    /* access modifiers changed from: private */
    public void setHttpHeader(String value) {
        if (value != null) {
            this.httpHeader_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearHttpHeader() {
        this.httpHeader_ = getDefaultInstance().getHttpHeader();
    }

    /* access modifiers changed from: private */
    public void setHttpHeaderBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.httpHeader_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getUrlQueryParameter() {
        return this.urlQueryParameter_;
    }

    public ByteString getUrlQueryParameterBytes() {
        return ByteString.copyFromUtf8(this.urlQueryParameter_);
    }

    /* access modifiers changed from: private */
    public void setUrlQueryParameter(String value) {
        if (value != null) {
            this.urlQueryParameter_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearUrlQueryParameter() {
        this.urlQueryParameter_ = getDefaultInstance().getUrlQueryParameter();
    }

    /* access modifiers changed from: private */
    public void setUrlQueryParameterBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.urlQueryParameter_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (!this.httpHeader_.isEmpty()) {
            output.writeString(2, getHttpHeader());
        }
        if (!this.urlQueryParameter_.isEmpty()) {
            output.writeString(3, getUrlQueryParameter());
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
        if (!this.httpHeader_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getHttpHeader());
        }
        if (!this.urlQueryParameter_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getUrlQueryParameter());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static SystemParameter parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (SystemParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static SystemParameter parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (SystemParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static SystemParameter parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (SystemParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static SystemParameter parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (SystemParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static SystemParameter parseFrom(InputStream input) throws IOException {
        return (SystemParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static SystemParameter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SystemParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static SystemParameter parseDelimitedFrom(InputStream input) throws IOException {
        return (SystemParameter) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static SystemParameter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SystemParameter) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static SystemParameter parseFrom(CodedInputStream input) throws IOException {
        return (SystemParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static SystemParameter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SystemParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SystemParameter prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<SystemParameter, Builder> implements SystemParameterOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(SystemParameter.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((SystemParameter) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((SystemParameter) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((SystemParameter) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((SystemParameter) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((SystemParameter) this.instance).setNameBytes(value);
            return this;
        }

        public String getHttpHeader() {
            return ((SystemParameter) this.instance).getHttpHeader();
        }

        public ByteString getHttpHeaderBytes() {
            return ((SystemParameter) this.instance).getHttpHeaderBytes();
        }

        public Builder setHttpHeader(String value) {
            copyOnWrite();
            ((SystemParameter) this.instance).setHttpHeader(value);
            return this;
        }

        public Builder clearHttpHeader() {
            copyOnWrite();
            ((SystemParameter) this.instance).clearHttpHeader();
            return this;
        }

        public Builder setHttpHeaderBytes(ByteString value) {
            copyOnWrite();
            ((SystemParameter) this.instance).setHttpHeaderBytes(value);
            return this;
        }

        public String getUrlQueryParameter() {
            return ((SystemParameter) this.instance).getUrlQueryParameter();
        }

        public ByteString getUrlQueryParameterBytes() {
            return ((SystemParameter) this.instance).getUrlQueryParameterBytes();
        }

        public Builder setUrlQueryParameter(String value) {
            copyOnWrite();
            ((SystemParameter) this.instance).setUrlQueryParameter(value);
            return this;
        }

        public Builder clearUrlQueryParameter() {
            copyOnWrite();
            ((SystemParameter) this.instance).clearUrlQueryParameter();
            return this;
        }

        public Builder setUrlQueryParameterBytes(ByteString value) {
            copyOnWrite();
            ((SystemParameter) this.instance).setUrlQueryParameterBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.SystemParameter$1  reason: invalid class name */
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
                return new SystemParameter();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                SystemParameter other = (SystemParameter) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.httpHeader_ = visitor.visitString(!this.httpHeader_.isEmpty(), this.httpHeader_, !other.httpHeader_.isEmpty(), other.httpHeader_);
                this.urlQueryParameter_ = visitor.visitString(!this.urlQueryParameter_.isEmpty(), this.urlQueryParameter_, !other.urlQueryParameter_.isEmpty(), other.urlQueryParameter_);
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
                            this.name_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.httpHeader_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            this.urlQueryParameter_ = input.readStringRequireUtf8();
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
                    synchronized (SystemParameter.class) {
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
        SystemParameter systemParameter = new SystemParameter();
        DEFAULT_INSTANCE = systemParameter;
        systemParameter.makeImmutable();
    }

    public static SystemParameter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SystemParameter> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
