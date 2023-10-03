package com.google.rpc;

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
public final class ResourceInfo extends GeneratedMessageLite<ResourceInfo, Builder> implements ResourceInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final ResourceInfo DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int OWNER_FIELD_NUMBER = 3;
    private static volatile Parser<ResourceInfo> PARSER = null;
    public static final int RESOURCE_NAME_FIELD_NUMBER = 2;
    public static final int RESOURCE_TYPE_FIELD_NUMBER = 1;
    private String description_ = "";
    private String owner_ = "";
    private String resourceName_ = "";
    private String resourceType_ = "";

    private ResourceInfo() {
    }

    public String getResourceType() {
        return this.resourceType_;
    }

    public ByteString getResourceTypeBytes() {
        return ByteString.copyFromUtf8(this.resourceType_);
    }

    /* access modifiers changed from: private */
    public void setResourceType(String value) {
        if (value != null) {
            this.resourceType_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearResourceType() {
        this.resourceType_ = getDefaultInstance().getResourceType();
    }

    /* access modifiers changed from: private */
    public void setResourceTypeBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.resourceType_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getResourceName() {
        return this.resourceName_;
    }

    public ByteString getResourceNameBytes() {
        return ByteString.copyFromUtf8(this.resourceName_);
    }

    /* access modifiers changed from: private */
    public void setResourceName(String value) {
        if (value != null) {
            this.resourceName_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearResourceName() {
        this.resourceName_ = getDefaultInstance().getResourceName();
    }

    /* access modifiers changed from: private */
    public void setResourceNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.resourceName_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getOwner() {
        return this.owner_;
    }

    public ByteString getOwnerBytes() {
        return ByteString.copyFromUtf8(this.owner_);
    }

    /* access modifiers changed from: private */
    public void setOwner(String value) {
        if (value != null) {
            this.owner_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearOwner() {
        this.owner_ = getDefaultInstance().getOwner();
    }

    /* access modifiers changed from: private */
    public void setOwnerBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.owner_ = value.toStringUtf8();
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

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.resourceType_.isEmpty()) {
            output.writeString(1, getResourceType());
        }
        if (!this.resourceName_.isEmpty()) {
            output.writeString(2, getResourceName());
        }
        if (!this.owner_.isEmpty()) {
            output.writeString(3, getOwner());
        }
        if (!this.description_.isEmpty()) {
            output.writeString(4, getDescription());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.resourceType_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getResourceType());
        }
        if (!this.resourceName_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getResourceName());
        }
        if (!this.owner_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getOwner());
        }
        if (!this.description_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(4, getDescription());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ResourceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ResourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ResourceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ResourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ResourceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ResourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ResourceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ResourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ResourceInfo parseFrom(InputStream input) throws IOException {
        return (ResourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ResourceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ResourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ResourceInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (ResourceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ResourceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ResourceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ResourceInfo parseFrom(CodedInputStream input) throws IOException {
        return (ResourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ResourceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ResourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ResourceInfo prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<ResourceInfo, Builder> implements ResourceInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ResourceInfo.DEFAULT_INSTANCE);
        }

        public String getResourceType() {
            return ((ResourceInfo) this.instance).getResourceType();
        }

        public ByteString getResourceTypeBytes() {
            return ((ResourceInfo) this.instance).getResourceTypeBytes();
        }

        public Builder setResourceType(String value) {
            copyOnWrite();
            ((ResourceInfo) this.instance).setResourceType(value);
            return this;
        }

        public Builder clearResourceType() {
            copyOnWrite();
            ((ResourceInfo) this.instance).clearResourceType();
            return this;
        }

        public Builder setResourceTypeBytes(ByteString value) {
            copyOnWrite();
            ((ResourceInfo) this.instance).setResourceTypeBytes(value);
            return this;
        }

        public String getResourceName() {
            return ((ResourceInfo) this.instance).getResourceName();
        }

        public ByteString getResourceNameBytes() {
            return ((ResourceInfo) this.instance).getResourceNameBytes();
        }

        public Builder setResourceName(String value) {
            copyOnWrite();
            ((ResourceInfo) this.instance).setResourceName(value);
            return this;
        }

        public Builder clearResourceName() {
            copyOnWrite();
            ((ResourceInfo) this.instance).clearResourceName();
            return this;
        }

        public Builder setResourceNameBytes(ByteString value) {
            copyOnWrite();
            ((ResourceInfo) this.instance).setResourceNameBytes(value);
            return this;
        }

        public String getOwner() {
            return ((ResourceInfo) this.instance).getOwner();
        }

        public ByteString getOwnerBytes() {
            return ((ResourceInfo) this.instance).getOwnerBytes();
        }

        public Builder setOwner(String value) {
            copyOnWrite();
            ((ResourceInfo) this.instance).setOwner(value);
            return this;
        }

        public Builder clearOwner() {
            copyOnWrite();
            ((ResourceInfo) this.instance).clearOwner();
            return this;
        }

        public Builder setOwnerBytes(ByteString value) {
            copyOnWrite();
            ((ResourceInfo) this.instance).setOwnerBytes(value);
            return this;
        }

        public String getDescription() {
            return ((ResourceInfo) this.instance).getDescription();
        }

        public ByteString getDescriptionBytes() {
            return ((ResourceInfo) this.instance).getDescriptionBytes();
        }

        public Builder setDescription(String value) {
            copyOnWrite();
            ((ResourceInfo) this.instance).setDescription(value);
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((ResourceInfo) this.instance).clearDescription();
            return this;
        }

        public Builder setDescriptionBytes(ByteString value) {
            copyOnWrite();
            ((ResourceInfo) this.instance).setDescriptionBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.rpc.ResourceInfo$1  reason: invalid class name */
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
                return new ResourceInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ResourceInfo other = (ResourceInfo) arg1;
                this.resourceType_ = visitor.visitString(!this.resourceType_.isEmpty(), this.resourceType_, !other.resourceType_.isEmpty(), other.resourceType_);
                this.resourceName_ = visitor.visitString(!this.resourceName_.isEmpty(), this.resourceName_, !other.resourceName_.isEmpty(), other.resourceName_);
                this.owner_ = visitor.visitString(!this.owner_.isEmpty(), this.owner_, !other.owner_.isEmpty(), other.owner_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !other.description_.isEmpty(), other.description_);
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
                            this.resourceType_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.resourceName_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            this.owner_ = input.readStringRequireUtf8();
                        } else if (tag == 34) {
                            this.description_ = input.readStringRequireUtf8();
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
                    synchronized (ResourceInfo.class) {
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
        ResourceInfo resourceInfo = new ResourceInfo();
        DEFAULT_INSTANCE = resourceInfo;
        resourceInfo.makeImmutable();
    }

    public static ResourceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ResourceInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
