package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Method;
import com.google.protobuf.Mixin;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Api extends GeneratedMessageLite<Api, Builder> implements ApiOrBuilder {
    /* access modifiers changed from: private */
    public static final Api DEFAULT_INSTANCE;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Api> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private int bitField0_;
    private Internal.ProtobufList<Method> methods_ = emptyProtobufList();
    private Internal.ProtobufList<Mixin> mixins_ = emptyProtobufList();
    private String name_ = "";
    private Internal.ProtobufList<Option> options_ = emptyProtobufList();
    private SourceContext sourceContext_;
    private int syntax_;
    private String version_ = "";

    private Api() {
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

    public List<Method> getMethodsList() {
        return this.methods_;
    }

    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    public int getMethodsCount() {
        return this.methods_.size();
    }

    public Method getMethods(int index) {
        return (Method) this.methods_.get(index);
    }

    public MethodOrBuilder getMethodsOrBuilder(int index) {
        return (MethodOrBuilder) this.methods_.get(index);
    }

    private void ensureMethodsIsMutable() {
        if (!this.methods_.isModifiable()) {
            this.methods_ = GeneratedMessageLite.mutableCopy(this.methods_);
        }
    }

    /* access modifiers changed from: private */
    public void setMethods(int index, Method value) {
        if (value != null) {
            ensureMethodsIsMutable();
            this.methods_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setMethods(int index, Method.Builder builderForValue) {
        ensureMethodsIsMutable();
        this.methods_.set(index, (Method) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMethods(Method value) {
        if (value != null) {
            ensureMethodsIsMutable();
            this.methods_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMethods(int index, Method value) {
        if (value != null) {
            ensureMethodsIsMutable();
            this.methods_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMethods(Method.Builder builderForValue) {
        ensureMethodsIsMutable();
        this.methods_.add((Method) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMethods(int index, Method.Builder builderForValue) {
        ensureMethodsIsMutable();
        this.methods_.add(index, (Method) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllMethods(Iterable<? extends Method> values) {
        ensureMethodsIsMutable();
        AbstractMessageLite.addAll(values, this.methods_);
    }

    /* access modifiers changed from: private */
    public void clearMethods() {
        this.methods_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeMethods(int index) {
        ensureMethodsIsMutable();
        this.methods_.remove(index);
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

    public String getVersion() {
        return this.version_;
    }

    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    /* access modifiers changed from: private */
    public void setVersion(String value) {
        if (value != null) {
            this.version_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    /* access modifiers changed from: private */
    public void setVersionBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.version_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    /* access modifiers changed from: private */
    public void setSourceContext(SourceContext value) {
        if (value != null) {
            this.sourceContext_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setSourceContext(SourceContext.Builder builderForValue) {
        this.sourceContext_ = (SourceContext) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeSourceContext(SourceContext value) {
        SourceContext sourceContext = this.sourceContext_;
        if (sourceContext == null || sourceContext == SourceContext.getDefaultInstance()) {
            this.sourceContext_ = value;
        } else {
            this.sourceContext_ = (SourceContext) ((SourceContext.Builder) SourceContext.newBuilder(this.sourceContext_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearSourceContext() {
        this.sourceContext_ = null;
    }

    public List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    public int getMixinsCount() {
        return this.mixins_.size();
    }

    public Mixin getMixins(int index) {
        return (Mixin) this.mixins_.get(index);
    }

    public MixinOrBuilder getMixinsOrBuilder(int index) {
        return (MixinOrBuilder) this.mixins_.get(index);
    }

    private void ensureMixinsIsMutable() {
        if (!this.mixins_.isModifiable()) {
            this.mixins_ = GeneratedMessageLite.mutableCopy(this.mixins_);
        }
    }

    /* access modifiers changed from: private */
    public void setMixins(int index, Mixin value) {
        if (value != null) {
            ensureMixinsIsMutable();
            this.mixins_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setMixins(int index, Mixin.Builder builderForValue) {
        ensureMixinsIsMutable();
        this.mixins_.set(index, (Mixin) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMixins(Mixin value) {
        if (value != null) {
            ensureMixinsIsMutable();
            this.mixins_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMixins(int index, Mixin value) {
        if (value != null) {
            ensureMixinsIsMutable();
            this.mixins_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMixins(Mixin.Builder builderForValue) {
        ensureMixinsIsMutable();
        this.mixins_.add((Mixin) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMixins(int index, Mixin.Builder builderForValue) {
        ensureMixinsIsMutable();
        this.mixins_.add(index, (Mixin) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllMixins(Iterable<? extends Mixin> values) {
        ensureMixinsIsMutable();
        AbstractMessageLite.addAll(values, this.mixins_);
    }

    /* access modifiers changed from: private */
    public void clearMixins() {
        this.mixins_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeMixins(int index) {
        ensureMixinsIsMutable();
        this.mixins_.remove(index);
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
        for (int i = 0; i < this.methods_.size(); i++) {
            output.writeMessage(2, (MessageLite) this.methods_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            output.writeMessage(3, (MessageLite) this.options_.get(i2));
        }
        if (!this.version_.isEmpty()) {
            output.writeString(4, getVersion());
        }
        if (this.sourceContext_ != null) {
            output.writeMessage(5, getSourceContext());
        }
        for (int i3 = 0; i3 < this.mixins_.size(); i3++) {
            output.writeMessage(6, (MessageLite) this.mixins_.get(i3));
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
        for (int i = 0; i < this.methods_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.methods_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.options_.get(i2));
        }
        if (!this.version_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(4, getVersion());
        }
        if (this.sourceContext_ != null) {
            size2 += CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        for (int i3 = 0; i3 < this.mixins_.size(); i3++) {
            size2 += CodedOutputStream.computeMessageSize(6, (MessageLite) this.mixins_.get(i3));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(7, this.syntax_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Api parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Api parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Api parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Api parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Api parseFrom(InputStream input) throws IOException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Api parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Api parseDelimitedFrom(InputStream input) throws IOException {
        return (Api) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Api parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Api parseFrom(CodedInputStream input) throws IOException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Api parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Api prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Api.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((Api) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Api) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Api) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Api) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Api) this.instance).setNameBytes(value);
            return this;
        }

        public List<Method> getMethodsList() {
            return Collections.unmodifiableList(((Api) this.instance).getMethodsList());
        }

        public int getMethodsCount() {
            return ((Api) this.instance).getMethodsCount();
        }

        public Method getMethods(int index) {
            return ((Api) this.instance).getMethods(index);
        }

        public Builder setMethods(int index, Method value) {
            copyOnWrite();
            ((Api) this.instance).setMethods(index, value);
            return this;
        }

        public Builder setMethods(int index, Method.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).setMethods(index, builderForValue);
            return this;
        }

        public Builder addMethods(Method value) {
            copyOnWrite();
            ((Api) this.instance).addMethods(value);
            return this;
        }

        public Builder addMethods(int index, Method value) {
            copyOnWrite();
            ((Api) this.instance).addMethods(index, value);
            return this;
        }

        public Builder addMethods(Method.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).addMethods(builderForValue);
            return this;
        }

        public Builder addMethods(int index, Method.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).addMethods(index, builderForValue);
            return this;
        }

        public Builder addAllMethods(Iterable<? extends Method> values) {
            copyOnWrite();
            ((Api) this.instance).addAllMethods(values);
            return this;
        }

        public Builder clearMethods() {
            copyOnWrite();
            ((Api) this.instance).clearMethods();
            return this;
        }

        public Builder removeMethods(int index) {
            copyOnWrite();
            ((Api) this.instance).removeMethods(index);
            return this;
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Api) this.instance).getOptionsList());
        }

        public int getOptionsCount() {
            return ((Api) this.instance).getOptionsCount();
        }

        public Option getOptions(int index) {
            return ((Api) this.instance).getOptions(index);
        }

        public Builder setOptions(int index, Option value) {
            copyOnWrite();
            ((Api) this.instance).setOptions(index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).setOptions(index, builderForValue);
            return this;
        }

        public Builder addOptions(Option value) {
            copyOnWrite();
            ((Api) this.instance).addOptions(value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            copyOnWrite();
            ((Api) this.instance).addOptions(index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).addOptions(builderForValue);
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).addOptions(index, builderForValue);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            copyOnWrite();
            ((Api) this.instance).addAllOptions(values);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Api) this.instance).clearOptions();
            return this;
        }

        public Builder removeOptions(int index) {
            copyOnWrite();
            ((Api) this.instance).removeOptions(index);
            return this;
        }

        public String getVersion() {
            return ((Api) this.instance).getVersion();
        }

        public ByteString getVersionBytes() {
            return ((Api) this.instance).getVersionBytes();
        }

        public Builder setVersion(String value) {
            copyOnWrite();
            ((Api) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((Api) this.instance).clearVersion();
            return this;
        }

        public Builder setVersionBytes(ByteString value) {
            copyOnWrite();
            ((Api) this.instance).setVersionBytes(value);
            return this;
        }

        public boolean hasSourceContext() {
            return ((Api) this.instance).hasSourceContext();
        }

        public SourceContext getSourceContext() {
            return ((Api) this.instance).getSourceContext();
        }

        public Builder setSourceContext(SourceContext value) {
            copyOnWrite();
            ((Api) this.instance).setSourceContext(value);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).setSourceContext(builderForValue);
            return this;
        }

        public Builder mergeSourceContext(SourceContext value) {
            copyOnWrite();
            ((Api) this.instance).mergeSourceContext(value);
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            ((Api) this.instance).clearSourceContext();
            return this;
        }

        public List<Mixin> getMixinsList() {
            return Collections.unmodifiableList(((Api) this.instance).getMixinsList());
        }

        public int getMixinsCount() {
            return ((Api) this.instance).getMixinsCount();
        }

        public Mixin getMixins(int index) {
            return ((Api) this.instance).getMixins(index);
        }

        public Builder setMixins(int index, Mixin value) {
            copyOnWrite();
            ((Api) this.instance).setMixins(index, value);
            return this;
        }

        public Builder setMixins(int index, Mixin.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).setMixins(index, builderForValue);
            return this;
        }

        public Builder addMixins(Mixin value) {
            copyOnWrite();
            ((Api) this.instance).addMixins(value);
            return this;
        }

        public Builder addMixins(int index, Mixin value) {
            copyOnWrite();
            ((Api) this.instance).addMixins(index, value);
            return this;
        }

        public Builder addMixins(Mixin.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).addMixins(builderForValue);
            return this;
        }

        public Builder addMixins(int index, Mixin.Builder builderForValue) {
            copyOnWrite();
            ((Api) this.instance).addMixins(index, builderForValue);
            return this;
        }

        public Builder addAllMixins(Iterable<? extends Mixin> values) {
            copyOnWrite();
            ((Api) this.instance).addAllMixins(values);
            return this;
        }

        public Builder clearMixins() {
            copyOnWrite();
            ((Api) this.instance).clearMixins();
            return this;
        }

        public Builder removeMixins(int index) {
            copyOnWrite();
            ((Api) this.instance).removeMixins(index);
            return this;
        }

        public int getSyntaxValue() {
            return ((Api) this.instance).getSyntaxValue();
        }

        public Builder setSyntaxValue(int value) {
            copyOnWrite();
            ((Api) this.instance).setSyntaxValue(value);
            return this;
        }

        public Syntax getSyntax() {
            return ((Api) this.instance).getSyntax();
        }

        public Builder setSyntax(Syntax value) {
            copyOnWrite();
            ((Api) this.instance).setSyntax(value);
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((Api) this.instance).clearSyntax();
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Api$1  reason: invalid class name */
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
                return new Api();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.methods_.makeImmutable();
                this.options_.makeImmutable();
                this.mixins_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Api other = (Api) arg1;
                boolean z = true;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.methods_ = visitor.visitList(this.methods_, other.methods_);
                this.options_ = visitor.visitList(this.options_, other.options_);
                this.version_ = visitor.visitString(!this.version_.isEmpty(), this.version_, !other.version_.isEmpty(), other.version_);
                this.sourceContext_ = (SourceContext) visitor.visitMessage(this.sourceContext_, other.sourceContext_);
                this.mixins_ = visitor.visitList(this.mixins_, other.mixins_);
                boolean z2 = this.syntax_ != 0;
                int i = this.syntax_;
                if (other.syntax_ == 0) {
                    z = false;
                }
                this.syntax_ = visitor.visitInt(z2, i, z, other.syntax_);
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
                            if (!this.methods_.isModifiable()) {
                                this.methods_ = GeneratedMessageLite.mutableCopy(this.methods_);
                            }
                            this.methods_.add((Method) input.readMessage(Method.parser(), extensionRegistry));
                        } else if (tag == 26) {
                            if (!this.options_.isModifiable()) {
                                this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
                            }
                            this.options_.add((Option) input.readMessage(Option.parser(), extensionRegistry));
                        } else if (tag == 34) {
                            this.version_ = input.readStringRequireUtf8();
                        } else if (tag == 42) {
                            SourceContext.Builder subBuilder = null;
                            if (this.sourceContext_ != null) {
                                subBuilder = (SourceContext.Builder) this.sourceContext_.toBuilder();
                            }
                            SourceContext sourceContext = (SourceContext) input.readMessage(SourceContext.parser(), extensionRegistry);
                            this.sourceContext_ = sourceContext;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(sourceContext);
                                this.sourceContext_ = (SourceContext) subBuilder.buildPartial();
                            }
                        } else if (tag == 50) {
                            if (!this.mixins_.isModifiable()) {
                                this.mixins_ = GeneratedMessageLite.mutableCopy(this.mixins_);
                            }
                            this.mixins_.add((Mixin) input.readMessage(Mixin.parser(), extensionRegistry));
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
                    synchronized (Api.class) {
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
        Api api = new Api();
        DEFAULT_INSTANCE = api;
        api.makeImmutable();
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Api> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
