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
public final class RequestInfo extends GeneratedMessageLite<RequestInfo, Builder> implements RequestInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final RequestInfo DEFAULT_INSTANCE;
    private static volatile Parser<RequestInfo> PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int SERVING_DATA_FIELD_NUMBER = 2;
    private String requestId_ = "";
    private String servingData_ = "";

    private RequestInfo() {
    }

    public String getRequestId() {
        return this.requestId_;
    }

    public ByteString getRequestIdBytes() {
        return ByteString.copyFromUtf8(this.requestId_);
    }

    /* access modifiers changed from: private */
    public void setRequestId(String value) {
        if (value != null) {
            this.requestId_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    /* access modifiers changed from: private */
    public void setRequestIdBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.requestId_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getServingData() {
        return this.servingData_;
    }

    public ByteString getServingDataBytes() {
        return ByteString.copyFromUtf8(this.servingData_);
    }

    /* access modifiers changed from: private */
    public void setServingData(String value) {
        if (value != null) {
            this.servingData_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearServingData() {
        this.servingData_ = getDefaultInstance().getServingData();
    }

    /* access modifiers changed from: private */
    public void setServingDataBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.servingData_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.requestId_.isEmpty()) {
            output.writeString(1, getRequestId());
        }
        if (!this.servingData_.isEmpty()) {
            output.writeString(2, getServingData());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.requestId_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getRequestId());
        }
        if (!this.servingData_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getServingData());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static RequestInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RequestInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RequestInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RequestInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RequestInfo parseFrom(InputStream input) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RequestInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RequestInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (RequestInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RequestInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RequestInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RequestInfo parseFrom(CodedInputStream input) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RequestInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RequestInfo prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<RequestInfo, Builder> implements RequestInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(RequestInfo.DEFAULT_INSTANCE);
        }

        public String getRequestId() {
            return ((RequestInfo) this.instance).getRequestId();
        }

        public ByteString getRequestIdBytes() {
            return ((RequestInfo) this.instance).getRequestIdBytes();
        }

        public Builder setRequestId(String value) {
            copyOnWrite();
            ((RequestInfo) this.instance).setRequestId(value);
            return this;
        }

        public Builder clearRequestId() {
            copyOnWrite();
            ((RequestInfo) this.instance).clearRequestId();
            return this;
        }

        public Builder setRequestIdBytes(ByteString value) {
            copyOnWrite();
            ((RequestInfo) this.instance).setRequestIdBytes(value);
            return this;
        }

        public String getServingData() {
            return ((RequestInfo) this.instance).getServingData();
        }

        public ByteString getServingDataBytes() {
            return ((RequestInfo) this.instance).getServingDataBytes();
        }

        public Builder setServingData(String value) {
            copyOnWrite();
            ((RequestInfo) this.instance).setServingData(value);
            return this;
        }

        public Builder clearServingData() {
            copyOnWrite();
            ((RequestInfo) this.instance).clearServingData();
            return this;
        }

        public Builder setServingDataBytes(ByteString value) {
            copyOnWrite();
            ((RequestInfo) this.instance).setServingDataBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.rpc.RequestInfo$1  reason: invalid class name */
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
                return new RequestInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                RequestInfo other = (RequestInfo) arg1;
                this.requestId_ = visitor.visitString(!this.requestId_.isEmpty(), this.requestId_, !other.requestId_.isEmpty(), other.requestId_);
                this.servingData_ = visitor.visitString(!this.servingData_.isEmpty(), this.servingData_, !other.servingData_.isEmpty(), other.servingData_);
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
                            this.requestId_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.servingData_ = input.readStringRequireUtf8();
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
                    synchronized (RequestInfo.class) {
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
        RequestInfo requestInfo = new RequestInfo();
        DEFAULT_INSTANCE = requestInfo;
        requestInfo.makeImmutable();
    }

    public static RequestInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RequestInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
