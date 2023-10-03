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
public final class UsageRule extends GeneratedMessageLite<UsageRule, Builder> implements UsageRuleOrBuilder {
    public static final int ALLOW_UNREGISTERED_CALLS_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final UsageRule DEFAULT_INSTANCE;
    private static volatile Parser<UsageRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    public static final int SKIP_SERVICE_CONTROL_FIELD_NUMBER = 3;
    private boolean allowUnregisteredCalls_;
    private String selector_ = "";
    private boolean skipServiceControl_;

    private UsageRule() {
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

    public boolean getAllowUnregisteredCalls() {
        return this.allowUnregisteredCalls_;
    }

    /* access modifiers changed from: private */
    public void setAllowUnregisteredCalls(boolean value) {
        this.allowUnregisteredCalls_ = value;
    }

    /* access modifiers changed from: private */
    public void clearAllowUnregisteredCalls() {
        this.allowUnregisteredCalls_ = false;
    }

    public boolean getSkipServiceControl() {
        return this.skipServiceControl_;
    }

    /* access modifiers changed from: private */
    public void setSkipServiceControl(boolean value) {
        this.skipServiceControl_ = value;
    }

    /* access modifiers changed from: private */
    public void clearSkipServiceControl() {
        this.skipServiceControl_ = false;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.selector_.isEmpty()) {
            output.writeString(1, getSelector());
        }
        boolean z = this.allowUnregisteredCalls_;
        if (z) {
            output.writeBool(2, z);
        }
        boolean z2 = this.skipServiceControl_;
        if (z2) {
            output.writeBool(3, z2);
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
        boolean z = this.allowUnregisteredCalls_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(2, z);
        }
        boolean z2 = this.skipServiceControl_;
        if (z2) {
            size2 += CodedOutputStream.computeBoolSize(3, z2);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static UsageRule parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (UsageRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static UsageRule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (UsageRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static UsageRule parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (UsageRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static UsageRule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (UsageRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static UsageRule parseFrom(InputStream input) throws IOException {
        return (UsageRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static UsageRule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (UsageRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static UsageRule parseDelimitedFrom(InputStream input) throws IOException {
        return (UsageRule) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static UsageRule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (UsageRule) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static UsageRule parseFrom(CodedInputStream input) throws IOException {
        return (UsageRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static UsageRule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (UsageRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(UsageRule prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<UsageRule, Builder> implements UsageRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(UsageRule.DEFAULT_INSTANCE);
        }

        public String getSelector() {
            return ((UsageRule) this.instance).getSelector();
        }

        public ByteString getSelectorBytes() {
            return ((UsageRule) this.instance).getSelectorBytes();
        }

        public Builder setSelector(String value) {
            copyOnWrite();
            ((UsageRule) this.instance).setSelector(value);
            return this;
        }

        public Builder clearSelector() {
            copyOnWrite();
            ((UsageRule) this.instance).clearSelector();
            return this;
        }

        public Builder setSelectorBytes(ByteString value) {
            copyOnWrite();
            ((UsageRule) this.instance).setSelectorBytes(value);
            return this;
        }

        public boolean getAllowUnregisteredCalls() {
            return ((UsageRule) this.instance).getAllowUnregisteredCalls();
        }

        public Builder setAllowUnregisteredCalls(boolean value) {
            copyOnWrite();
            ((UsageRule) this.instance).setAllowUnregisteredCalls(value);
            return this;
        }

        public Builder clearAllowUnregisteredCalls() {
            copyOnWrite();
            ((UsageRule) this.instance).clearAllowUnregisteredCalls();
            return this;
        }

        public boolean getSkipServiceControl() {
            return ((UsageRule) this.instance).getSkipServiceControl();
        }

        public Builder setSkipServiceControl(boolean value) {
            copyOnWrite();
            ((UsageRule) this.instance).setSkipServiceControl(value);
            return this;
        }

        public Builder clearSkipServiceControl() {
            copyOnWrite();
            ((UsageRule) this.instance).clearSkipServiceControl();
            return this;
        }
    }

    /* renamed from: com.google.api.UsageRule$1  reason: invalid class name */
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
                return new UsageRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                UsageRule other = (UsageRule) arg1;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, !other.selector_.isEmpty(), other.selector_);
                boolean z = this.allowUnregisteredCalls_;
                boolean z2 = other.allowUnregisteredCalls_;
                this.allowUnregisteredCalls_ = visitor.visitBoolean(z, z, z2, z2);
                boolean z3 = this.skipServiceControl_;
                boolean z4 = other.skipServiceControl_;
                this.skipServiceControl_ = visitor.visitBoolean(z3, z3, z4, z4);
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
                        } else if (tag == 16) {
                            this.allowUnregisteredCalls_ = input.readBool();
                        } else if (tag == 24) {
                            this.skipServiceControl_ = input.readBool();
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
                    synchronized (UsageRule.class) {
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
        UsageRule usageRule = new UsageRule();
        DEFAULT_INSTANCE = usageRule;
        usageRule.makeImmutable();
    }

    public static UsageRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<UsageRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
