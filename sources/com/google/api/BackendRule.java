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
public final class BackendRule extends GeneratedMessageLite<BackendRule, Builder> implements BackendRuleOrBuilder {
    public static final int ADDRESS_FIELD_NUMBER = 2;
    public static final int DEADLINE_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final BackendRule DEFAULT_INSTANCE;
    private static volatile Parser<BackendRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private String address_ = "";
    private double deadline_;
    private String selector_ = "";

    private BackendRule() {
    }

    public String getSelector() {
        return this.selector_;
    }

    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* access modifiers changed from: private */
    public void setSelector(String value) {
        if (value != null) {
            this.selector_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* access modifiers changed from: private */
    public void setSelectorBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.selector_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getAddress() {
        return this.address_;
    }

    public ByteString getAddressBytes() {
        return ByteString.copyFromUtf8(this.address_);
    }

    /* access modifiers changed from: private */
    public void setAddress(String value) {
        if (value != null) {
            this.address_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    /* access modifiers changed from: private */
    public void setAddressBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.address_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public double getDeadline() {
        return this.deadline_;
    }

    /* access modifiers changed from: private */
    public void setDeadline(double value) {
        this.deadline_ = value;
    }

    /* access modifiers changed from: private */
    public void clearDeadline() {
        this.deadline_ = 0.0d;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.selector_.isEmpty()) {
            output.writeString(1, getSelector());
        }
        if (!this.address_.isEmpty()) {
            output.writeString(2, getAddress());
        }
        double d = this.deadline_;
        if (d != 0.0d) {
            output.writeDouble(3, d);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.selector_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getSelector());
        }
        if (!this.address_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getAddress());
        }
        double d = this.deadline_;
        if (d != 0.0d) {
            size2 += CodedOutputStream.computeDoubleSize(3, d);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static BackendRule parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BackendRule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BackendRule parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BackendRule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BackendRule parseFrom(InputStream input) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BackendRule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BackendRule parseDelimitedFrom(InputStream input) throws IOException {
        return (BackendRule) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static BackendRule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BackendRule) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BackendRule parseFrom(CodedInputStream input) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BackendRule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BackendRule prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<BackendRule, Builder> implements BackendRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(BackendRule.DEFAULT_INSTANCE);
        }

        public String getSelector() {
            return ((BackendRule) this.instance).getSelector();
        }

        public ByteString getSelectorBytes() {
            return ((BackendRule) this.instance).getSelectorBytes();
        }

        public Builder setSelector(String value) {
            copyOnWrite();
            ((BackendRule) this.instance).setSelector(value);
            return this;
        }

        public Builder clearSelector() {
            copyOnWrite();
            ((BackendRule) this.instance).clearSelector();
            return this;
        }

        public Builder setSelectorBytes(ByteString value) {
            copyOnWrite();
            ((BackendRule) this.instance).setSelectorBytes(value);
            return this;
        }

        public String getAddress() {
            return ((BackendRule) this.instance).getAddress();
        }

        public ByteString getAddressBytes() {
            return ((BackendRule) this.instance).getAddressBytes();
        }

        public Builder setAddress(String value) {
            copyOnWrite();
            ((BackendRule) this.instance).setAddress(value);
            return this;
        }

        public Builder clearAddress() {
            copyOnWrite();
            ((BackendRule) this.instance).clearAddress();
            return this;
        }

        public Builder setAddressBytes(ByteString value) {
            copyOnWrite();
            ((BackendRule) this.instance).setAddressBytes(value);
            return this;
        }

        public double getDeadline() {
            return ((BackendRule) this.instance).getDeadline();
        }

        public Builder setDeadline(double value) {
            copyOnWrite();
            ((BackendRule) this.instance).setDeadline(value);
            return this;
        }

        public Builder clearDeadline() {
            copyOnWrite();
            ((BackendRule) this.instance).clearDeadline();
            return this;
        }
    }

    /* renamed from: com.google.api.BackendRule$1  reason: invalid class name */
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
                return new BackendRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                BackendRule other = (BackendRule) arg1;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, !other.selector_.isEmpty(), other.selector_);
                this.address_ = visitor.visitString(!this.address_.isEmpty(), this.address_, !other.address_.isEmpty(), other.address_);
                this.deadline_ = visitor.visitDouble(this.deadline_ != 0.0d, this.deadline_, other.deadline_ != 0.0d, other.deadline_);
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
                            this.selector_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.address_ = input.readStringRequireUtf8();
                        } else if (tag == 25) {
                            this.deadline_ = input.readDouble();
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
                    synchronized (BackendRule.class) {
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
        BackendRule backendRule = new BackendRule();
        DEFAULT_INSTANCE = backendRule;
        backendRule.makeImmutable();
    }

    public static BackendRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<BackendRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
