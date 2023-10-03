package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class RetryInfo extends GeneratedMessageLite<RetryInfo, Builder> implements RetryInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final RetryInfo DEFAULT_INSTANCE;
    private static volatile Parser<RetryInfo> PARSER = null;
    public static final int RETRY_DELAY_FIELD_NUMBER = 1;
    private Duration retryDelay_;

    private RetryInfo() {
    }

    public boolean hasRetryDelay() {
        return this.retryDelay_ != null;
    }

    public Duration getRetryDelay() {
        Duration duration = this.retryDelay_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    /* access modifiers changed from: private */
    public void setRetryDelay(Duration value) {
        if (value != null) {
            this.retryDelay_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRetryDelay(Duration.Builder builderForValue) {
        this.retryDelay_ = (Duration) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeRetryDelay(Duration value) {
        Duration duration = this.retryDelay_;
        if (duration == null || duration == Duration.getDefaultInstance()) {
            this.retryDelay_ = value;
        } else {
            this.retryDelay_ = (Duration) ((Duration.Builder) Duration.newBuilder(this.retryDelay_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearRetryDelay() {
        this.retryDelay_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.retryDelay_ != null) {
            output.writeMessage(1, getRetryDelay());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.retryDelay_ != null) {
            size2 = 0 + CodedOutputStream.computeMessageSize(1, getRetryDelay());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static RetryInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RetryInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RetryInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RetryInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RetryInfo parseFrom(InputStream input) throws IOException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RetryInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RetryInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (RetryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RetryInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RetryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RetryInfo parseFrom(CodedInputStream input) throws IOException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RetryInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RetryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RetryInfo prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<RetryInfo, Builder> implements RetryInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(RetryInfo.DEFAULT_INSTANCE);
        }

        public boolean hasRetryDelay() {
            return ((RetryInfo) this.instance).hasRetryDelay();
        }

        public Duration getRetryDelay() {
            return ((RetryInfo) this.instance).getRetryDelay();
        }

        public Builder setRetryDelay(Duration value) {
            copyOnWrite();
            ((RetryInfo) this.instance).setRetryDelay(value);
            return this;
        }

        public Builder setRetryDelay(Duration.Builder builderForValue) {
            copyOnWrite();
            ((RetryInfo) this.instance).setRetryDelay(builderForValue);
            return this;
        }

        public Builder mergeRetryDelay(Duration value) {
            copyOnWrite();
            ((RetryInfo) this.instance).mergeRetryDelay(value);
            return this;
        }

        public Builder clearRetryDelay() {
            copyOnWrite();
            ((RetryInfo) this.instance).clearRetryDelay();
            return this;
        }
    }

    /* renamed from: com.google.rpc.RetryInfo$1  reason: invalid class name */
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
                return new RetryInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.retryDelay_ = (Duration) ((GeneratedMessageLite.Visitor) arg0).visitMessage(this.retryDelay_, ((RetryInfo) arg1).retryDelay_);
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
                            Duration.Builder subBuilder = null;
                            if (this.retryDelay_ != null) {
                                subBuilder = (Duration.Builder) this.retryDelay_.toBuilder();
                            }
                            Duration duration = (Duration) input.readMessage(Duration.parser(), extensionRegistry);
                            this.retryDelay_ = duration;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(duration);
                                this.retryDelay_ = (Duration) subBuilder.buildPartial();
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
                    synchronized (RetryInfo.class) {
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
        RetryInfo retryInfo = new RetryInfo();
        DEFAULT_INSTANCE = retryInfo;
        retryInfo.makeImmutable();
    }

    public static RetryInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RetryInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
