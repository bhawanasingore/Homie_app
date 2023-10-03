package com.google.api;

import com.google.api.Property;
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
public final class ProjectProperties extends GeneratedMessageLite<ProjectProperties, Builder> implements ProjectPropertiesOrBuilder {
    /* access modifiers changed from: private */
    public static final ProjectProperties DEFAULT_INSTANCE;
    private static volatile Parser<ProjectProperties> PARSER = null;
    public static final int PROPERTIES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Property> properties_ = emptyProtobufList();

    private ProjectProperties() {
    }

    public List<Property> getPropertiesList() {
        return this.properties_;
    }

    public List<? extends PropertyOrBuilder> getPropertiesOrBuilderList() {
        return this.properties_;
    }

    public int getPropertiesCount() {
        return this.properties_.size();
    }

    public Property getProperties(int index) {
        return (Property) this.properties_.get(index);
    }

    public PropertyOrBuilder getPropertiesOrBuilder(int index) {
        return (PropertyOrBuilder) this.properties_.get(index);
    }

    private void ensurePropertiesIsMutable() {
        if (!this.properties_.isModifiable()) {
            this.properties_ = GeneratedMessageLite.mutableCopy(this.properties_);
        }
    }

    /* access modifiers changed from: private */
    public void setProperties(int index, Property value) {
        if (value != null) {
            ensurePropertiesIsMutable();
            this.properties_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setProperties(int index, Property.Builder builderForValue) {
        ensurePropertiesIsMutable();
        this.properties_.set(index, (Property) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addProperties(Property value) {
        if (value != null) {
            ensurePropertiesIsMutable();
            this.properties_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addProperties(int index, Property value) {
        if (value != null) {
            ensurePropertiesIsMutable();
            this.properties_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addProperties(Property.Builder builderForValue) {
        ensurePropertiesIsMutable();
        this.properties_.add((Property) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addProperties(int index, Property.Builder builderForValue) {
        ensurePropertiesIsMutable();
        this.properties_.add(index, (Property) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllProperties(Iterable<? extends Property> values) {
        ensurePropertiesIsMutable();
        AbstractMessageLite.addAll(values, this.properties_);
    }

    /* access modifiers changed from: private */
    public void clearProperties() {
        this.properties_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeProperties(int index) {
        ensurePropertiesIsMutable();
        this.properties_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.properties_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.properties_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.properties_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.properties_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ProjectProperties parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ProjectProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ProjectProperties parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ProjectProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ProjectProperties parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ProjectProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ProjectProperties parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ProjectProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ProjectProperties parseFrom(InputStream input) throws IOException {
        return (ProjectProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ProjectProperties parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ProjectProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ProjectProperties parseDelimitedFrom(InputStream input) throws IOException {
        return (ProjectProperties) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ProjectProperties parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ProjectProperties) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ProjectProperties parseFrom(CodedInputStream input) throws IOException {
        return (ProjectProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ProjectProperties parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ProjectProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ProjectProperties prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<ProjectProperties, Builder> implements ProjectPropertiesOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ProjectProperties.DEFAULT_INSTANCE);
        }

        public List<Property> getPropertiesList() {
            return Collections.unmodifiableList(((ProjectProperties) this.instance).getPropertiesList());
        }

        public int getPropertiesCount() {
            return ((ProjectProperties) this.instance).getPropertiesCount();
        }

        public Property getProperties(int index) {
            return ((ProjectProperties) this.instance).getProperties(index);
        }

        public Builder setProperties(int index, Property value) {
            copyOnWrite();
            ((ProjectProperties) this.instance).setProperties(index, value);
            return this;
        }

        public Builder setProperties(int index, Property.Builder builderForValue) {
            copyOnWrite();
            ((ProjectProperties) this.instance).setProperties(index, builderForValue);
            return this;
        }

        public Builder addProperties(Property value) {
            copyOnWrite();
            ((ProjectProperties) this.instance).addProperties(value);
            return this;
        }

        public Builder addProperties(int index, Property value) {
            copyOnWrite();
            ((ProjectProperties) this.instance).addProperties(index, value);
            return this;
        }

        public Builder addProperties(Property.Builder builderForValue) {
            copyOnWrite();
            ((ProjectProperties) this.instance).addProperties(builderForValue);
            return this;
        }

        public Builder addProperties(int index, Property.Builder builderForValue) {
            copyOnWrite();
            ((ProjectProperties) this.instance).addProperties(index, builderForValue);
            return this;
        }

        public Builder addAllProperties(Iterable<? extends Property> values) {
            copyOnWrite();
            ((ProjectProperties) this.instance).addAllProperties(values);
            return this;
        }

        public Builder clearProperties() {
            copyOnWrite();
            ((ProjectProperties) this.instance).clearProperties();
            return this;
        }

        public Builder removeProperties(int index) {
            copyOnWrite();
            ((ProjectProperties) this.instance).removeProperties(index);
            return this;
        }
    }

    /* renamed from: com.google.api.ProjectProperties$1  reason: invalid class name */
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
                return new ProjectProperties();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.properties_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.properties_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.properties_, ((ProjectProperties) arg1).properties_);
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
                            if (!this.properties_.isModifiable()) {
                                this.properties_ = GeneratedMessageLite.mutableCopy(this.properties_);
                            }
                            this.properties_.add((Property) input.readMessage(Property.parser(), extensionRegistry));
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
                    synchronized (ProjectProperties.class) {
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
        ProjectProperties projectProperties = new ProjectProperties();
        DEFAULT_INSTANCE = projectProperties;
        projectProperties.makeImmutable();
    }

    public static ProjectProperties getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ProjectProperties> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
