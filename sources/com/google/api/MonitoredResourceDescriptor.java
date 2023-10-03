package com.google.api;

import com.google.api.LabelDescriptor;
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
public final class MonitoredResourceDescriptor extends GeneratedMessageLite<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
    /* access modifiers changed from: private */
    public static final MonitoredResourceDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int LABELS_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 5;
    private static volatile Parser<MonitoredResourceDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String description_ = "";
    private String displayName_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = emptyProtobufList();
    private String name_ = "";
    private String type_ = "";

    private MonitoredResourceDescriptor() {
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

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    /* access modifiers changed from: private */
    public void setType(String value) {
        if (value != null) {
            this.type_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    /* access modifiers changed from: private */
    public void setTypeBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.type_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getDisplayName() {
        return this.displayName_;
    }

    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    /* access modifiers changed from: private */
    public void setDisplayName(String value) {
        if (value != null) {
            this.displayName_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* access modifiers changed from: private */
    public void setDisplayNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.displayName_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getDescription() {
        return this.description_;
    }

    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    /* access modifiers changed from: private */
    public void setDescription(String value) {
        if (value != null) {
            this.description_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* access modifiers changed from: private */
    public void setDescriptionBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.description_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    public int getLabelsCount() {
        return this.labels_.size();
    }

    public LabelDescriptor getLabels(int index) {
        return (LabelDescriptor) this.labels_.get(index);
    }

    public LabelDescriptorOrBuilder getLabelsOrBuilder(int index) {
        return (LabelDescriptorOrBuilder) this.labels_.get(index);
    }

    private void ensureLabelsIsMutable() {
        if (!this.labels_.isModifiable()) {
            this.labels_ = GeneratedMessageLite.mutableCopy(this.labels_);
        }
    }

    /* access modifiers changed from: private */
    public void setLabels(int index, LabelDescriptor value) {
        if (value != null) {
            ensureLabelsIsMutable();
            this.labels_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLabels(int index, LabelDescriptor.Builder builderForValue) {
        ensureLabelsIsMutable();
        this.labels_.set(index, (LabelDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLabels(LabelDescriptor value) {
        if (value != null) {
            ensureLabelsIsMutable();
            this.labels_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLabels(int index, LabelDescriptor value) {
        if (value != null) {
            ensureLabelsIsMutable();
            this.labels_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLabels(LabelDescriptor.Builder builderForValue) {
        ensureLabelsIsMutable();
        this.labels_.add((LabelDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLabels(int index, LabelDescriptor.Builder builderForValue) {
        ensureLabelsIsMutable();
        this.labels_.add(index, (LabelDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllLabels(Iterable<? extends LabelDescriptor> values) {
        ensureLabelsIsMutable();
        AbstractMessageLite.addAll(values, this.labels_);
    }

    /* access modifiers changed from: private */
    public void clearLabels() {
        this.labels_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeLabels(int index) {
        ensureLabelsIsMutable();
        this.labels_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.type_.isEmpty()) {
            output.writeString(1, getType());
        }
        if (!this.displayName_.isEmpty()) {
            output.writeString(2, getDisplayName());
        }
        if (!this.description_.isEmpty()) {
            output.writeString(3, getDescription());
        }
        for (int i = 0; i < this.labels_.size(); i++) {
            output.writeMessage(4, (MessageLite) this.labels_.get(i));
        }
        if (!this.name_.isEmpty()) {
            output.writeString(5, getName());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.type_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getType());
        }
        if (!this.displayName_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getDisplayName());
        }
        if (!this.description_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getDescription());
        }
        for (int i = 0; i < this.labels_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.labels_.get(i));
        }
        if (!this.name_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(5, getName());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static MonitoredResourceDescriptor parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MonitoredResourceDescriptor parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static MonitoredResourceDescriptor parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static MonitoredResourceDescriptor parseFrom(InputStream input) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MonitoredResourceDescriptor parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream input) throws IOException {
        return (MonitoredResourceDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MonitoredResourceDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static MonitoredResourceDescriptor parseFrom(CodedInputStream input) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static MonitoredResourceDescriptor parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MonitoredResourceDescriptor prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(MonitoredResourceDescriptor.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((MonitoredResourceDescriptor) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((MonitoredResourceDescriptor) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setNameBytes(value);
            return this;
        }

        public String getType() {
            return ((MonitoredResourceDescriptor) this.instance).getType();
        }

        public ByteString getTypeBytes() {
            return ((MonitoredResourceDescriptor) this.instance).getTypeBytes();
        }

        public Builder setType(String value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setType(value);
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearType();
            return this;
        }

        public Builder setTypeBytes(ByteString value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setTypeBytes(value);
            return this;
        }

        public String getDisplayName() {
            return ((MonitoredResourceDescriptor) this.instance).getDisplayName();
        }

        public ByteString getDisplayNameBytes() {
            return ((MonitoredResourceDescriptor) this.instance).getDisplayNameBytes();
        }

        public Builder setDisplayName(String value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setDisplayName(value);
            return this;
        }

        public Builder clearDisplayName() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearDisplayName();
            return this;
        }

        public Builder setDisplayNameBytes(ByteString value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setDisplayNameBytes(value);
            return this;
        }

        public String getDescription() {
            return ((MonitoredResourceDescriptor) this.instance).getDescription();
        }

        public ByteString getDescriptionBytes() {
            return ((MonitoredResourceDescriptor) this.instance).getDescriptionBytes();
        }

        public Builder setDescription(String value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setDescription(value);
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearDescription();
            return this;
        }

        public Builder setDescriptionBytes(ByteString value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setDescriptionBytes(value);
            return this;
        }

        public List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MonitoredResourceDescriptor) this.instance).getLabelsList());
        }

        public int getLabelsCount() {
            return ((MonitoredResourceDescriptor) this.instance).getLabelsCount();
        }

        public LabelDescriptor getLabels(int index) {
            return ((MonitoredResourceDescriptor) this.instance).getLabels(index);
        }

        public Builder setLabels(int index, LabelDescriptor value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setLabels(index, value);
            return this;
        }

        public Builder setLabels(int index, LabelDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setLabels(index, builderForValue);
            return this;
        }

        public Builder addLabels(LabelDescriptor value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addLabels(value);
            return this;
        }

        public Builder addLabels(int index, LabelDescriptor value) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addLabels(index, value);
            return this;
        }

        public Builder addLabels(LabelDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addLabels(builderForValue);
            return this;
        }

        public Builder addLabels(int index, LabelDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addLabels(index, builderForValue);
            return this;
        }

        public Builder addAllLabels(Iterable<? extends LabelDescriptor> values) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addAllLabels(values);
            return this;
        }

        public Builder clearLabels() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearLabels();
            return this;
        }

        public Builder removeLabels(int index) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).removeLabels(index);
            return this;
        }
    }

    /* renamed from: com.google.api.MonitoredResourceDescriptor$1  reason: invalid class name */
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
                return new MonitoredResourceDescriptor();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.labels_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                MonitoredResourceDescriptor other = (MonitoredResourceDescriptor) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.type_ = visitor.visitString(!this.type_.isEmpty(), this.type_, !other.type_.isEmpty(), other.type_);
                this.displayName_ = visitor.visitString(!this.displayName_.isEmpty(), this.displayName_, !other.displayName_.isEmpty(), other.displayName_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !other.description_.isEmpty(), other.description_);
                this.labels_ = visitor.visitList(this.labels_, other.labels_);
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
                            this.type_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.displayName_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            this.description_ = input.readStringRequireUtf8();
                        } else if (tag == 34) {
                            if (!this.labels_.isModifiable()) {
                                this.labels_ = GeneratedMessageLite.mutableCopy(this.labels_);
                            }
                            this.labels_.add((LabelDescriptor) input.readMessage(LabelDescriptor.parser(), extensionRegistry));
                        } else if (tag == 42) {
                            this.name_ = input.readStringRequireUtf8();
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
                    synchronized (MonitoredResourceDescriptor.class) {
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
        MonitoredResourceDescriptor monitoredResourceDescriptor = new MonitoredResourceDescriptor();
        DEFAULT_INSTANCE = monitoredResourceDescriptor;
        monitoredResourceDescriptor.makeImmutable();
    }

    public static MonitoredResourceDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MonitoredResourceDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
