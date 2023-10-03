package com.google.type;

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
public final class Money extends GeneratedMessageLite<Money, Builder> implements MoneyOrBuilder {
    public static final int CURRENCY_CODE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final Money DEFAULT_INSTANCE;
    public static final int NANOS_FIELD_NUMBER = 3;
    private static volatile Parser<Money> PARSER = null;
    public static final int UNITS_FIELD_NUMBER = 2;
    private String currencyCode_ = "";
    private int nanos_;
    private long units_;

    private Money() {
    }

    public String getCurrencyCode() {
        return this.currencyCode_;
    }

    public ByteString getCurrencyCodeBytes() {
        return ByteString.copyFromUtf8(this.currencyCode_);
    }

    /* access modifiers changed from: private */
    public void setCurrencyCode(String value) {
        if (value != null) {
            this.currencyCode_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearCurrencyCode() {
        this.currencyCode_ = getDefaultInstance().getCurrencyCode();
    }

    /* access modifiers changed from: private */
    public void setCurrencyCodeBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.currencyCode_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public long getUnits() {
        return this.units_;
    }

    /* access modifiers changed from: private */
    public void setUnits(long value) {
        this.units_ = value;
    }

    /* access modifiers changed from: private */
    public void clearUnits() {
        this.units_ = 0;
    }

    public int getNanos() {
        return this.nanos_;
    }

    /* access modifiers changed from: private */
    public void setNanos(int value) {
        this.nanos_ = value;
    }

    /* access modifiers changed from: private */
    public void clearNanos() {
        this.nanos_ = 0;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.currencyCode_.isEmpty()) {
            output.writeString(1, getCurrencyCode());
        }
        long j = this.units_;
        if (j != 0) {
            output.writeInt64(2, j);
        }
        int i = this.nanos_;
        if (i != 0) {
            output.writeInt32(3, i);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.currencyCode_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getCurrencyCode());
        }
        long j = this.units_;
        if (j != 0) {
            size2 += CodedOutputStream.computeInt64Size(2, j);
        }
        int i = this.nanos_;
        if (i != 0) {
            size2 += CodedOutputStream.computeInt32Size(3, i);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Money parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Money parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Money parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Money parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Money parseFrom(InputStream input) throws IOException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Money parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Money parseDelimitedFrom(InputStream input) throws IOException {
        return (Money) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Money parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Money) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Money parseFrom(CodedInputStream input) throws IOException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Money parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Money) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Money prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Money, Builder> implements MoneyOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Money.DEFAULT_INSTANCE);
        }

        public String getCurrencyCode() {
            return ((Money) this.instance).getCurrencyCode();
        }

        public ByteString getCurrencyCodeBytes() {
            return ((Money) this.instance).getCurrencyCodeBytes();
        }

        public Builder setCurrencyCode(String value) {
            copyOnWrite();
            ((Money) this.instance).setCurrencyCode(value);
            return this;
        }

        public Builder clearCurrencyCode() {
            copyOnWrite();
            ((Money) this.instance).clearCurrencyCode();
            return this;
        }

        public Builder setCurrencyCodeBytes(ByteString value) {
            copyOnWrite();
            ((Money) this.instance).setCurrencyCodeBytes(value);
            return this;
        }

        public long getUnits() {
            return ((Money) this.instance).getUnits();
        }

        public Builder setUnits(long value) {
            copyOnWrite();
            ((Money) this.instance).setUnits(value);
            return this;
        }

        public Builder clearUnits() {
            copyOnWrite();
            ((Money) this.instance).clearUnits();
            return this;
        }

        public int getNanos() {
            return ((Money) this.instance).getNanos();
        }

        public Builder setNanos(int value) {
            copyOnWrite();
            ((Money) this.instance).setNanos(value);
            return this;
        }

        public Builder clearNanos() {
            copyOnWrite();
            ((Money) this.instance).clearNanos();
            return this;
        }
    }

    /* renamed from: com.google.type.Money$1  reason: invalid class name */
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
                return new Money();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Money other = (Money) arg1;
                boolean z = true;
                this.currencyCode_ = visitor.visitString(!this.currencyCode_.isEmpty(), this.currencyCode_, !other.currencyCode_.isEmpty(), other.currencyCode_);
                this.units_ = visitor.visitLong(this.units_ != 0, this.units_, other.units_ != 0, other.units_);
                boolean z2 = this.nanos_ != 0;
                int i = this.nanos_;
                if (other.nanos_ == 0) {
                    z = false;
                }
                this.nanos_ = visitor.visitInt(z2, i, z, other.nanos_);
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
                            this.currencyCode_ = input.readStringRequireUtf8();
                        } else if (tag == 16) {
                            this.units_ = input.readInt64();
                        } else if (tag == 24) {
                            this.nanos_ = input.readInt32();
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
                    synchronized (Money.class) {
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
        Money money = new Money();
        DEFAULT_INSTANCE = money;
        money.makeImmutable();
    }

    public static Money getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Money> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
