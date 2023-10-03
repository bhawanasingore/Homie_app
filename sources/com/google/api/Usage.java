package com.google.api;

import com.google.api.UsageRule;
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
public final class Usage extends GeneratedMessageLite<Usage, Builder> implements UsageOrBuilder {
    /* access modifiers changed from: private */
    public static final Usage DEFAULT_INSTANCE;
    private static volatile Parser<Usage> PARSER = null;
    public static final int PRODUCER_NOTIFICATION_CHANNEL_FIELD_NUMBER = 7;
    public static final int REQUIREMENTS_FIELD_NUMBER = 1;
    public static final int RULES_FIELD_NUMBER = 6;
    private int bitField0_;
    private String producerNotificationChannel_ = "";
    private Internal.ProtobufList<String> requirements_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<UsageRule> rules_ = emptyProtobufList();

    private Usage() {
    }

    public List<String> getRequirementsList() {
        return this.requirements_;
    }

    public int getRequirementsCount() {
        return this.requirements_.size();
    }

    public String getRequirements(int index) {
        return (String) this.requirements_.get(index);
    }

    public ByteString getRequirementsBytes(int index) {
        return ByteString.copyFromUtf8((String) this.requirements_.get(index));
    }

    private void ensureRequirementsIsMutable() {
        if (!this.requirements_.isModifiable()) {
            this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_);
        }
    }

    /* access modifiers changed from: private */
    public void setRequirements(int index, String value) {
        if (value != null) {
            ensureRequirementsIsMutable();
            this.requirements_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRequirements(String value) {
        if (value != null) {
            ensureRequirementsIsMutable();
            this.requirements_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllRequirements(Iterable<String> values) {
        ensureRequirementsIsMutable();
        AbstractMessageLite.addAll(values, this.requirements_);
    }

    /* access modifiers changed from: private */
    public void clearRequirements() {
        this.requirements_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addRequirementsBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureRequirementsIsMutable();
            this.requirements_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public List<UsageRule> getRulesList() {
        return this.rules_;
    }

    public List<? extends UsageRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    public int getRulesCount() {
        return this.rules_.size();
    }

    public UsageRule getRules(int index) {
        return (UsageRule) this.rules_.get(index);
    }

    public UsageRuleOrBuilder getRulesOrBuilder(int index) {
        return (UsageRuleOrBuilder) this.rules_.get(index);
    }

    private void ensureRulesIsMutable() {
        if (!this.rules_.isModifiable()) {
            this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
        }
    }

    /* access modifiers changed from: private */
    public void setRules(int index, UsageRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRules(int index, UsageRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.set(index, (UsageRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(UsageRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(int index, UsageRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(UsageRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add((UsageRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(int index, UsageRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add(index, (UsageRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllRules(Iterable<? extends UsageRule> values) {
        ensureRulesIsMutable();
        AbstractMessageLite.addAll(values, this.rules_);
    }

    /* access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeRules(int index) {
        ensureRulesIsMutable();
        this.rules_.remove(index);
    }

    public String getProducerNotificationChannel() {
        return this.producerNotificationChannel_;
    }

    public ByteString getProducerNotificationChannelBytes() {
        return ByteString.copyFromUtf8(this.producerNotificationChannel_);
    }

    /* access modifiers changed from: private */
    public void setProducerNotificationChannel(String value) {
        if (value != null) {
            this.producerNotificationChannel_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearProducerNotificationChannel() {
        this.producerNotificationChannel_ = getDefaultInstance().getProducerNotificationChannel();
    }

    /* access modifiers changed from: private */
    public void setProducerNotificationChannelBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.producerNotificationChannel_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.requirements_.size(); i++) {
            output.writeString(1, (String) this.requirements_.get(i));
        }
        for (int i2 = 0; i2 < this.rules_.size(); i2++) {
            output.writeMessage(6, (MessageLite) this.rules_.get(i2));
        }
        if (!this.producerNotificationChannel_.isEmpty()) {
            output.writeString(7, getProducerNotificationChannel());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int dataSize = 0;
        for (int i = 0; i < this.requirements_.size(); i++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.requirements_.get(i));
        }
        int size2 = 0 + dataSize + (getRequirementsList().size() * 1);
        for (int i2 = 0; i2 < this.rules_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(6, (MessageLite) this.rules_.get(i2));
        }
        if (!this.producerNotificationChannel_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(7, getProducerNotificationChannel());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Usage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Usage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Usage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Usage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Usage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Usage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Usage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Usage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Usage parseFrom(InputStream input) throws IOException {
        return (Usage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Usage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Usage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Usage parseDelimitedFrom(InputStream input) throws IOException {
        return (Usage) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Usage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Usage) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Usage parseFrom(CodedInputStream input) throws IOException {
        return (Usage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Usage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Usage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Usage prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Usage, Builder> implements UsageOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Usage.DEFAULT_INSTANCE);
        }

        public List<String> getRequirementsList() {
            return Collections.unmodifiableList(((Usage) this.instance).getRequirementsList());
        }

        public int getRequirementsCount() {
            return ((Usage) this.instance).getRequirementsCount();
        }

        public String getRequirements(int index) {
            return ((Usage) this.instance).getRequirements(index);
        }

        public ByteString getRequirementsBytes(int index) {
            return ((Usage) this.instance).getRequirementsBytes(index);
        }

        public Builder setRequirements(int index, String value) {
            copyOnWrite();
            ((Usage) this.instance).setRequirements(index, value);
            return this;
        }

        public Builder addRequirements(String value) {
            copyOnWrite();
            ((Usage) this.instance).addRequirements(value);
            return this;
        }

        public Builder addAllRequirements(Iterable<String> values) {
            copyOnWrite();
            ((Usage) this.instance).addAllRequirements(values);
            return this;
        }

        public Builder clearRequirements() {
            copyOnWrite();
            ((Usage) this.instance).clearRequirements();
            return this;
        }

        public Builder addRequirementsBytes(ByteString value) {
            copyOnWrite();
            ((Usage) this.instance).addRequirementsBytes(value);
            return this;
        }

        public List<UsageRule> getRulesList() {
            return Collections.unmodifiableList(((Usage) this.instance).getRulesList());
        }

        public int getRulesCount() {
            return ((Usage) this.instance).getRulesCount();
        }

        public UsageRule getRules(int index) {
            return ((Usage) this.instance).getRules(index);
        }

        public Builder setRules(int index, UsageRule value) {
            copyOnWrite();
            ((Usage) this.instance).setRules(index, value);
            return this;
        }

        public Builder setRules(int index, UsageRule.Builder builderForValue) {
            copyOnWrite();
            ((Usage) this.instance).setRules(index, builderForValue);
            return this;
        }

        public Builder addRules(UsageRule value) {
            copyOnWrite();
            ((Usage) this.instance).addRules(value);
            return this;
        }

        public Builder addRules(int index, UsageRule value) {
            copyOnWrite();
            ((Usage) this.instance).addRules(index, value);
            return this;
        }

        public Builder addRules(UsageRule.Builder builderForValue) {
            copyOnWrite();
            ((Usage) this.instance).addRules(builderForValue);
            return this;
        }

        public Builder addRules(int index, UsageRule.Builder builderForValue) {
            copyOnWrite();
            ((Usage) this.instance).addRules(index, builderForValue);
            return this;
        }

        public Builder addAllRules(Iterable<? extends UsageRule> values) {
            copyOnWrite();
            ((Usage) this.instance).addAllRules(values);
            return this;
        }

        public Builder clearRules() {
            copyOnWrite();
            ((Usage) this.instance).clearRules();
            return this;
        }

        public Builder removeRules(int index) {
            copyOnWrite();
            ((Usage) this.instance).removeRules(index);
            return this;
        }

        public String getProducerNotificationChannel() {
            return ((Usage) this.instance).getProducerNotificationChannel();
        }

        public ByteString getProducerNotificationChannelBytes() {
            return ((Usage) this.instance).getProducerNotificationChannelBytes();
        }

        public Builder setProducerNotificationChannel(String value) {
            copyOnWrite();
            ((Usage) this.instance).setProducerNotificationChannel(value);
            return this;
        }

        public Builder clearProducerNotificationChannel() {
            copyOnWrite();
            ((Usage) this.instance).clearProducerNotificationChannel();
            return this;
        }

        public Builder setProducerNotificationChannelBytes(ByteString value) {
            copyOnWrite();
            ((Usage) this.instance).setProducerNotificationChannelBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.Usage$1  reason: invalid class name */
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
                return new Usage();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.requirements_.makeImmutable();
                this.rules_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Usage other = (Usage) arg1;
                this.requirements_ = visitor.visitList(this.requirements_, other.requirements_);
                this.rules_ = visitor.visitList(this.rules_, other.rules_);
                this.producerNotificationChannel_ = visitor.visitString(!this.producerNotificationChannel_.isEmpty(), this.producerNotificationChannel_, !other.producerNotificationChannel_.isEmpty(), other.producerNotificationChannel_);
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
                            String s = input.readStringRequireUtf8();
                            if (!this.requirements_.isModifiable()) {
                                this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_);
                            }
                            this.requirements_.add(s);
                        } else if (tag == 50) {
                            if (!this.rules_.isModifiable()) {
                                this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
                            }
                            this.rules_.add((UsageRule) input.readMessage(UsageRule.parser(), extensionRegistry));
                        } else if (tag == 58) {
                            this.producerNotificationChannel_ = input.readStringRequireUtf8();
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
                    synchronized (Usage.class) {
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
        Usage usage = new Usage();
        DEFAULT_INSTANCE = usage;
        usage.makeImmutable();
    }

    public static Usage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Usage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
