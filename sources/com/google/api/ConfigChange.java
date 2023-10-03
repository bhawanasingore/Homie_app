package com.google.api;

import com.google.api.Advice;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class ConfigChange extends GeneratedMessageLite<ConfigChange, Builder> implements ConfigChangeOrBuilder {
    public static final int ADVICES_FIELD_NUMBER = 5;
    public static final int CHANGE_TYPE_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */
    public static final ConfigChange DEFAULT_INSTANCE;
    public static final int ELEMENT_FIELD_NUMBER = 1;
    public static final int NEW_VALUE_FIELD_NUMBER = 3;
    public static final int OLD_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<ConfigChange> PARSER;
    private Internal.ProtobufList<Advice> advices_ = emptyProtobufList();
    private int bitField0_;
    private int changeType_;
    private String element_ = "";
    private String newValue_ = "";
    private String oldValue_ = "";

    private ConfigChange() {
    }

    public String getElement() {
        return this.element_;
    }

    public ByteString getElementBytes() {
        return ByteString.copyFromUtf8(this.element_);
    }

    /* access modifiers changed from: private */
    public void setElement(String value) {
        if (value != null) {
            this.element_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearElement() {
        this.element_ = getDefaultInstance().getElement();
    }

    /* access modifiers changed from: private */
    public void setElementBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.element_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getOldValue() {
        return this.oldValue_;
    }

    public ByteString getOldValueBytes() {
        return ByteString.copyFromUtf8(this.oldValue_);
    }

    /* access modifiers changed from: private */
    public void setOldValue(String value) {
        if (value != null) {
            this.oldValue_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearOldValue() {
        this.oldValue_ = getDefaultInstance().getOldValue();
    }

    /* access modifiers changed from: private */
    public void setOldValueBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.oldValue_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getNewValue() {
        return this.newValue_;
    }

    public ByteString getNewValueBytes() {
        return ByteString.copyFromUtf8(this.newValue_);
    }

    /* access modifiers changed from: private */
    public void setNewValue(String value) {
        if (value != null) {
            this.newValue_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearNewValue() {
        this.newValue_ = getDefaultInstance().getNewValue();
    }

    /* access modifiers changed from: private */
    public void setNewValueBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.newValue_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public int getChangeTypeValue() {
        return this.changeType_;
    }

    public ChangeType getChangeType() {
        ChangeType result = ChangeType.forNumber(this.changeType_);
        return result == null ? ChangeType.UNRECOGNIZED : result;
    }

    /* access modifiers changed from: private */
    public void setChangeTypeValue(int value) {
        this.changeType_ = value;
    }

    /* access modifiers changed from: private */
    public void setChangeType(ChangeType value) {
        if (value != null) {
            this.changeType_ = value.getNumber();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearChangeType() {
        this.changeType_ = 0;
    }

    public List<Advice> getAdvicesList() {
        return this.advices_;
    }

    public List<? extends AdviceOrBuilder> getAdvicesOrBuilderList() {
        return this.advices_;
    }

    public int getAdvicesCount() {
        return this.advices_.size();
    }

    public Advice getAdvices(int index) {
        return (Advice) this.advices_.get(index);
    }

    public AdviceOrBuilder getAdvicesOrBuilder(int index) {
        return (AdviceOrBuilder) this.advices_.get(index);
    }

    private void ensureAdvicesIsMutable() {
        if (!this.advices_.isModifiable()) {
            this.advices_ = GeneratedMessageLite.mutableCopy(this.advices_);
        }
    }

    /* access modifiers changed from: private */
    public void setAdvices(int index, Advice value) {
        if (value != null) {
            ensureAdvicesIsMutable();
            this.advices_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAdvices(int index, Advice.Builder builderForValue) {
        ensureAdvicesIsMutable();
        this.advices_.set(index, (Advice) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAdvices(Advice value) {
        if (value != null) {
            ensureAdvicesIsMutable();
            this.advices_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAdvices(int index, Advice value) {
        if (value != null) {
            ensureAdvicesIsMutable();
            this.advices_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAdvices(Advice.Builder builderForValue) {
        ensureAdvicesIsMutable();
        this.advices_.add((Advice) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAdvices(int index, Advice.Builder builderForValue) {
        ensureAdvicesIsMutable();
        this.advices_.add(index, (Advice) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllAdvices(Iterable<? extends Advice> values) {
        ensureAdvicesIsMutable();
        AbstractMessageLite.addAll(values, this.advices_);
    }

    /* access modifiers changed from: private */
    public void clearAdvices() {
        this.advices_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeAdvices(int index) {
        ensureAdvicesIsMutable();
        this.advices_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.element_.isEmpty()) {
            output.writeString(1, getElement());
        }
        if (!this.oldValue_.isEmpty()) {
            output.writeString(2, getOldValue());
        }
        if (!this.newValue_.isEmpty()) {
            output.writeString(3, getNewValue());
        }
        if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
            output.writeEnum(4, this.changeType_);
        }
        for (int i = 0; i < this.advices_.size(); i++) {
            output.writeMessage(5, (MessageLite) this.advices_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.element_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getElement());
        }
        if (!this.oldValue_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getOldValue());
        }
        if (!this.newValue_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getNewValue());
        }
        if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(4, this.changeType_);
        }
        for (int i = 0; i < this.advices_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.advices_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ConfigChange parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ConfigChange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ConfigChange parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ConfigChange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ConfigChange parseFrom(InputStream input) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ConfigChange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ConfigChange parseDelimitedFrom(InputStream input) throws IOException {
        return (ConfigChange) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ConfigChange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ConfigChange) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ConfigChange parseFrom(CodedInputStream input) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ConfigChange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ConfigChange prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<ConfigChange, Builder> implements ConfigChangeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ConfigChange.DEFAULT_INSTANCE);
        }

        public String getElement() {
            return ((ConfigChange) this.instance).getElement();
        }

        public ByteString getElementBytes() {
            return ((ConfigChange) this.instance).getElementBytes();
        }

        public Builder setElement(String value) {
            copyOnWrite();
            ((ConfigChange) this.instance).setElement(value);
            return this;
        }

        public Builder clearElement() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearElement();
            return this;
        }

        public Builder setElementBytes(ByteString value) {
            copyOnWrite();
            ((ConfigChange) this.instance).setElementBytes(value);
            return this;
        }

        public String getOldValue() {
            return ((ConfigChange) this.instance).getOldValue();
        }

        public ByteString getOldValueBytes() {
            return ((ConfigChange) this.instance).getOldValueBytes();
        }

        public Builder setOldValue(String value) {
            copyOnWrite();
            ((ConfigChange) this.instance).setOldValue(value);
            return this;
        }

        public Builder clearOldValue() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearOldValue();
            return this;
        }

        public Builder setOldValueBytes(ByteString value) {
            copyOnWrite();
            ((ConfigChange) this.instance).setOldValueBytes(value);
            return this;
        }

        public String getNewValue() {
            return ((ConfigChange) this.instance).getNewValue();
        }

        public ByteString getNewValueBytes() {
            return ((ConfigChange) this.instance).getNewValueBytes();
        }

        public Builder setNewValue(String value) {
            copyOnWrite();
            ((ConfigChange) this.instance).setNewValue(value);
            return this;
        }

        public Builder clearNewValue() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearNewValue();
            return this;
        }

        public Builder setNewValueBytes(ByteString value) {
            copyOnWrite();
            ((ConfigChange) this.instance).setNewValueBytes(value);
            return this;
        }

        public int getChangeTypeValue() {
            return ((ConfigChange) this.instance).getChangeTypeValue();
        }

        public Builder setChangeTypeValue(int value) {
            copyOnWrite();
            ((ConfigChange) this.instance).setChangeTypeValue(value);
            return this;
        }

        public ChangeType getChangeType() {
            return ((ConfigChange) this.instance).getChangeType();
        }

        public Builder setChangeType(ChangeType value) {
            copyOnWrite();
            ((ConfigChange) this.instance).setChangeType(value);
            return this;
        }

        public Builder clearChangeType() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearChangeType();
            return this;
        }

        public List<Advice> getAdvicesList() {
            return Collections.unmodifiableList(((ConfigChange) this.instance).getAdvicesList());
        }

        public int getAdvicesCount() {
            return ((ConfigChange) this.instance).getAdvicesCount();
        }

        public Advice getAdvices(int index) {
            return ((ConfigChange) this.instance).getAdvices(index);
        }

        public Builder setAdvices(int index, Advice value) {
            copyOnWrite();
            ((ConfigChange) this.instance).setAdvices(index, value);
            return this;
        }

        public Builder setAdvices(int index, Advice.Builder builderForValue) {
            copyOnWrite();
            ((ConfigChange) this.instance).setAdvices(index, builderForValue);
            return this;
        }

        public Builder addAdvices(Advice value) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(value);
            return this;
        }

        public Builder addAdvices(int index, Advice value) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(index, value);
            return this;
        }

        public Builder addAdvices(Advice.Builder builderForValue) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(builderForValue);
            return this;
        }

        public Builder addAdvices(int index, Advice.Builder builderForValue) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(index, builderForValue);
            return this;
        }

        public Builder addAllAdvices(Iterable<? extends Advice> values) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAllAdvices(values);
            return this;
        }

        public Builder clearAdvices() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearAdvices();
            return this;
        }

        public Builder removeAdvices(int index) {
            copyOnWrite();
            ((ConfigChange) this.instance).removeAdvices(index);
            return this;
        }
    }

    /* renamed from: com.google.api.ConfigChange$1  reason: invalid class name */
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
                return new ConfigChange();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.advices_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ConfigChange other = (ConfigChange) arg1;
                boolean z = true;
                this.element_ = visitor.visitString(!this.element_.isEmpty(), this.element_, !other.element_.isEmpty(), other.element_);
                this.oldValue_ = visitor.visitString(!this.oldValue_.isEmpty(), this.oldValue_, !other.oldValue_.isEmpty(), other.oldValue_);
                this.newValue_ = visitor.visitString(!this.newValue_.isEmpty(), this.newValue_, !other.newValue_.isEmpty(), other.newValue_);
                boolean z2 = this.changeType_ != 0;
                int i = this.changeType_;
                if (other.changeType_ == 0) {
                    z = false;
                }
                this.changeType_ = visitor.visitInt(z2, i, z, other.changeType_);
                this.advices_ = visitor.visitList(this.advices_, other.advices_);
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
                            this.element_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.oldValue_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            this.newValue_ = input.readStringRequireUtf8();
                        } else if (tag == 32) {
                            this.changeType_ = input.readEnum();
                        } else if (tag == 42) {
                            if (!this.advices_.isModifiable()) {
                                this.advices_ = GeneratedMessageLite.mutableCopy(this.advices_);
                            }
                            this.advices_.add((Advice) input.readMessage(Advice.parser(), extensionRegistry));
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
                    synchronized (ConfigChange.class) {
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
        ConfigChange configChange = new ConfigChange();
        DEFAULT_INSTANCE = configChange;
        configChange.makeImmutable();
    }

    public static ConfigChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ConfigChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
