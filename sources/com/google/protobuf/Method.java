package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Method extends GeneratedMessageLite<Method, Builder> implements MethodOrBuilder {
    /* access modifiers changed from: private */
    public static final Method DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile Parser<Method> PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private int bitField0_;
    private String name_ = "";
    private Internal.ProtobufList<Option> options_ = emptyProtobufList();
    private boolean requestStreaming_;
    private String requestTypeUrl_ = "";
    private boolean responseStreaming_;
    private String responseTypeUrl_ = "";
    private int syntax_;

    private Method() {
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

    public String getRequestTypeUrl() {
        return this.requestTypeUrl_;
    }

    public ByteString getRequestTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.requestTypeUrl_);
    }

    /* access modifiers changed from: private */
    public void setRequestTypeUrl(String value) {
        if (value != null) {
            this.requestTypeUrl_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearRequestTypeUrl() {
        this.requestTypeUrl_ = getDefaultInstance().getRequestTypeUrl();
    }

    /* access modifiers changed from: private */
    public void setRequestTypeUrlBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.requestTypeUrl_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    /* access modifiers changed from: private */
    public void setRequestStreaming(boolean value) {
        this.requestStreaming_ = value;
    }

    /* access modifiers changed from: private */
    public void clearRequestStreaming() {
        this.requestStreaming_ = false;
    }

    public String getResponseTypeUrl() {
        return this.responseTypeUrl_;
    }

    public ByteString getResponseTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.responseTypeUrl_);
    }

    /* access modifiers changed from: private */
    public void setResponseTypeUrl(String value) {
        if (value != null) {
            this.responseTypeUrl_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearResponseTypeUrl() {
        this.responseTypeUrl_ = getDefaultInstance().getResponseTypeUrl();
    }

    /* access modifiers changed from: private */
    public void setResponseTypeUrlBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.responseTypeUrl_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    /* access modifiers changed from: private */
    public void setResponseStreaming(boolean value) {
        this.responseStreaming_ = value;
    }

    /* access modifiers changed from: private */
    public void clearResponseStreaming() {
        this.responseStreaming_ = false;
    }

    public List<Option> getOptionsList() {
        return this.options_;
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public Option getOptions(int index) {
        return (Option) this.options_.get(index);
    }

    public OptionOrBuilder getOptionsOrBuilder(int index) {
        return (OptionOrBuilder) this.options_.get(index);
    }

    private void ensureOptionsIsMutable() {
        if (!this.options_.isModifiable()) {
            this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
        }
    }

    /* access modifiers changed from: private */
    public void setOptions(int index, Option value) {
        if (value != null) {
            ensureOptionsIsMutable();
            this.options_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setOptions(int index, Option.Builder builderForValue) {
        ensureOptionsIsMutable();
        this.options_.set(index, (Option) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addOptions(Option value) {
        if (value != null) {
            ensureOptionsIsMutable();
            this.options_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addOptions(int index, Option value) {
        if (value != null) {
            ensureOptionsIsMutable();
            this.options_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addOptions(Option.Builder builderForValue) {
        ensureOptionsIsMutable();
        this.options_.add((Option) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addOptions(int index, Option.Builder builderForValue) {
        ensureOptionsIsMutable();
        this.options_.add(index, (Option) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> values) {
        ensureOptionsIsMutable();
        AbstractMessageLite.addAll(values, this.options_);
    }

    /* access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeOptions(int index) {
        ensureOptionsIsMutable();
        this.options_.remove(index);
    }

    public int getSyntaxValue() {
        return this.syntax_;
    }

    public Syntax getSyntax() {
        Syntax result = Syntax.forNumber(this.syntax_);
        return result == null ? Syntax.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setSyntaxValue(int value) {
        this.syntax_ = value;
    }

    /* access modifiers changed from: private */
    public void setSyntax(Syntax value) {
        if (value != null) {
            this.syntax_ = value.getNumber();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearSyntax() {
        this.syntax_ = 0;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (!this.requestTypeUrl_.isEmpty()) {
            output.writeString(2, getRequestTypeUrl());
        }
        boolean z = this.requestStreaming_;
        if (z) {
            output.writeBool(3, z);
        }
        if (!this.responseTypeUrl_.isEmpty()) {
            output.writeString(4, getResponseTypeUrl());
        }
        boolean z2 = this.responseStreaming_;
        if (z2) {
            output.writeBool(5, z2);
        }
        for (int i = 0; i < this.options_.size(); i++) {
            output.writeMessage(6, (MessageLite) this.options_.get(i));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            output.writeEnum(7, this.syntax_);
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
        if (!this.requestTypeUrl_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getRequestTypeUrl());
        }
        boolean z = this.requestStreaming_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(3, z);
        }
        if (!this.responseTypeUrl_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(4, getResponseTypeUrl());
        }
        boolean z2 = this.responseStreaming_;
        if (z2) {
            size2 += CodedOutputStream.computeBoolSize(5, z2);
        }
        for (int i = 0; i < this.options_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(6, (MessageLite) this.options_.get(i));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(7, this.syntax_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Method parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Method parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Method parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Method parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Method parseFrom(InputStream input) throws IOException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Method parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Method parseDelimitedFrom(InputStream input) throws IOException {
        return (Method) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Method parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Method) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Method parseFrom(CodedInputStream input) throws IOException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Method parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Method prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Method, Builder> implements MethodOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Method.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((Method) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Method) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Method) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Method) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Method) this.instance).setNameBytes(value);
            return this;
        }

        public String getRequestTypeUrl() {
            return ((Method) this.instance).getRequestTypeUrl();
        }

        public ByteString getRequestTypeUrlBytes() {
            return ((Method) this.instance).getRequestTypeUrlBytes();
        }

        public Builder setRequestTypeUrl(String value) {
            copyOnWrite();
            ((Method) this.instance).setRequestTypeUrl(value);
            return this;
        }

        public Builder clearRequestTypeUrl() {
            copyOnWrite();
            ((Method) this.instance).clearRequestTypeUrl();
            return this;
        }

        public Builder setRequestTypeUrlBytes(ByteString value) {
            copyOnWrite();
            ((Method) this.instance).setRequestTypeUrlBytes(value);
            return this;
        }

        public boolean getRequestStreaming() {
            return ((Method) this.instance).getRequestStreaming();
        }

        public Builder setRequestStreaming(boolean value) {
            copyOnWrite();
            ((Method) this.instance).setRequestStreaming(value);
            return this;
        }

        public Builder clearRequestStreaming() {
            copyOnWrite();
            ((Method) this.instance).clearRequestStreaming();
            return this;
        }

        public String getResponseTypeUrl() {
            return ((Method) this.instance).getResponseTypeUrl();
        }

        public ByteString getResponseTypeUrlBytes() {
            return ((Method) this.instance).getResponseTypeUrlBytes();
        }

        public Builder setResponseTypeUrl(String value) {
            copyOnWrite();
            ((Method) this.instance).setResponseTypeUrl(value);
            return this;
        }

        public Builder clearResponseTypeUrl() {
            copyOnWrite();
            ((Method) this.instance).clearResponseTypeUrl();
            return this;
        }

        public Builder setResponseTypeUrlBytes(ByteString value) {
            copyOnWrite();
            ((Method) this.instance).setResponseTypeUrlBytes(value);
            return this;
        }

        public boolean getResponseStreaming() {
            return ((Method) this.instance).getResponseStreaming();
        }

        public Builder setResponseStreaming(boolean value) {
            copyOnWrite();
            ((Method) this.instance).setResponseStreaming(value);
            return this;
        }

        public Builder clearResponseStreaming() {
            copyOnWrite();
            ((Method) this.instance).clearResponseStreaming();
            return this;
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Method) this.instance).getOptionsList());
        }

        public int getOptionsCount() {
            return ((Method) this.instance).getOptionsCount();
        }

        public Option getOptions(int index) {
            return ((Method) this.instance).getOptions(index);
        }

        public Builder setOptions(int index, Option value) {
            copyOnWrite();
            ((Method) this.instance).setOptions(index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Method) this.instance).setOptions(index, builderForValue);
            return this;
        }

        public Builder addOptions(Option value) {
            copyOnWrite();
            ((Method) this.instance).addOptions(value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            copyOnWrite();
            ((Method) this.instance).addOptions(index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            copyOnWrite();
            ((Method) this.instance).addOptions(builderForValue);
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Method) this.instance).addOptions(index, builderForValue);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            copyOnWrite();
            ((Method) this.instance).addAllOptions(values);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Method) this.instance).clearOptions();
            return this;
        }

        public Builder removeOptions(int index) {
            copyOnWrite();
            ((Method) this.instance).removeOptions(index);
            return this;
        }

        public int getSyntaxValue() {
            return ((Method) this.instance).getSyntaxValue();
        }

        public Builder setSyntaxValue(int value) {
            copyOnWrite();
            ((Method) this.instance).setSyntaxValue(value);
            return this;
        }

        public Syntax getSyntax() {
            return ((Method) this.instance).getSyntax();
        }

        public Builder setSyntax(Syntax value) {
            copyOnWrite();
            ((Method) this.instance).setSyntax(value);
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((Method) this.instance).clearSyntax();
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Method$1  reason: invalid class name */
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
                return new Method();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.options_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Method other = (Method) arg1;
                boolean z = true;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.requestTypeUrl_ = visitor.visitString(!this.requestTypeUrl_.isEmpty(), this.requestTypeUrl_, !other.requestTypeUrl_.isEmpty(), other.requestTypeUrl_);
                boolean z2 = this.requestStreaming_;
                boolean z3 = other.requestStreaming_;
                this.requestStreaming_ = visitor.visitBoolean(z2, z2, z3, z3);
                this.responseTypeUrl_ = visitor.visitString(!this.responseTypeUrl_.isEmpty(), this.responseTypeUrl_, !other.responseTypeUrl_.isEmpty(), other.responseTypeUrl_);
                boolean z4 = this.responseStreaming_;
                boolean z5 = other.responseStreaming_;
                this.responseStreaming_ = visitor.visitBoolean(z4, z4, z5, z5);
                this.options_ = visitor.visitList(this.options_, other.options_);
                boolean z6 = this.syntax_ != 0;
                int i = this.syntax_;
                if (other.syntax_ == 0) {
                    z = false;
                }
                this.syntax_ = visitor.visitInt(z6, i, z, other.syntax_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= other.bitField0_;
                }
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
                            this.requestTypeUrl_ = input.readStringRequireUtf8();
                        } else if (tag == 24) {
                            this.requestStreaming_ = input.readBool();
                        } else if (tag == 34) {
                            this.responseTypeUrl_ = input.readStringRequireUtf8();
                        } else if (tag == 40) {
                            this.responseStreaming_ = input.readBool();
                        } else if (tag == 50) {
                            if (!this.options_.isModifiable()) {
                                this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
                            }
                            this.options_.add((Option) input.readMessage(Option.parser(), extensionRegistry));
                        } else if (tag == 56) {
                            this.syntax_ = input.readEnum();
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
                    synchronized (Method.class) {
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
        Method method = new Method();
        DEFAULT_INSTANCE = method;
        method.makeImmutable();
    }

    public static Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Method> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
