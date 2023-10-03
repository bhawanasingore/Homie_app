package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Endpoint extends GeneratedMessageLite<Endpoint, Builder> implements EndpointOrBuilder {
    public static final int ALIASES_FIELD_NUMBER = 2;
    public static final int ALLOW_CORS_FIELD_NUMBER = 5;
    public static final int APIS_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final Endpoint DEFAULT_INSTANCE;
    public static final int FEATURES_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Endpoint> PARSER = null;
    public static final int TARGET_FIELD_NUMBER = 101;
    private Internal.ProtobufList<String> aliases_ = GeneratedMessageLite.emptyProtobufList();
    private boolean allowCors_;
    private Internal.ProtobufList<String> apis_ = GeneratedMessageLite.emptyProtobufList();
    private int bitField0_;
    private Internal.ProtobufList<String> features_ = GeneratedMessageLite.emptyProtobufList();
    private String name_ = "";
    private String target_ = "";

    private Endpoint() {
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

    public List<String> getAliasesList() {
        return this.aliases_;
    }

    public int getAliasesCount() {
        return this.aliases_.size();
    }

    public String getAliases(int index) {
        return (String) this.aliases_.get(index);
    }

    public ByteString getAliasesBytes(int index) {
        return ByteString.copyFromUtf8((String) this.aliases_.get(index));
    }

    private void ensureAliasesIsMutable() {
        if (!this.aliases_.isModifiable()) {
            this.aliases_ = GeneratedMessageLite.mutableCopy(this.aliases_);
        }
    }

    /* access modifiers changed from: private */
    public void setAliases(int index, String value) {
        if (value != null) {
            ensureAliasesIsMutable();
            this.aliases_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAliases(String value) {
        if (value != null) {
            ensureAliasesIsMutable();
            this.aliases_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllAliases(Iterable<String> values) {
        ensureAliasesIsMutable();
        AbstractMessageLite.addAll(values, this.aliases_);
    }

    /* access modifiers changed from: private */
    public void clearAliases() {
        this.aliases_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addAliasesBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureAliasesIsMutable();
            this.aliases_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public List<String> getApisList() {
        return this.apis_;
    }

    public int getApisCount() {
        return this.apis_.size();
    }

    public String getApis(int index) {
        return (String) this.apis_.get(index);
    }

    public ByteString getApisBytes(int index) {
        return ByteString.copyFromUtf8((String) this.apis_.get(index));
    }

    private void ensureApisIsMutable() {
        if (!this.apis_.isModifiable()) {
            this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_);
        }
    }

    /* access modifiers changed from: private */
    public void setApis(int index, String value) {
        if (value != null) {
            ensureApisIsMutable();
            this.apis_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addApis(String value) {
        if (value != null) {
            ensureApisIsMutable();
            this.apis_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllApis(Iterable<String> values) {
        ensureApisIsMutable();
        AbstractMessageLite.addAll(values, this.apis_);
    }

    /* access modifiers changed from: private */
    public void clearApis() {
        this.apis_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addApisBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureApisIsMutable();
            this.apis_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public List<String> getFeaturesList() {
        return this.features_;
    }

    public int getFeaturesCount() {
        return this.features_.size();
    }

    public String getFeatures(int index) {
        return (String) this.features_.get(index);
    }

    public ByteString getFeaturesBytes(int index) {
        return ByteString.copyFromUtf8((String) this.features_.get(index));
    }

    private void ensureFeaturesIsMutable() {
        if (!this.features_.isModifiable()) {
            this.features_ = GeneratedMessageLite.mutableCopy(this.features_);
        }
    }

    /* access modifiers changed from: private */
    public void setFeatures(int index, String value) {
        if (value != null) {
            ensureFeaturesIsMutable();
            this.features_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFeatures(String value) {
        if (value != null) {
            ensureFeaturesIsMutable();
            this.features_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllFeatures(Iterable<String> values) {
        ensureFeaturesIsMutable();
        AbstractMessageLite.addAll(values, this.features_);
    }

    /* access modifiers changed from: private */
    public void clearFeatures() {
        this.features_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addFeaturesBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureFeaturesIsMutable();
            this.features_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public String getTarget() {
        return this.target_;
    }

    public ByteString getTargetBytes() {
        return ByteString.copyFromUtf8(this.target_);
    }

    /* access modifiers changed from: private */
    public void setTarget(String value) {
        if (value != null) {
            this.target_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTarget() {
        this.target_ = getDefaultInstance().getTarget();
    }

    /* access modifiers changed from: private */
    public void setTargetBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.target_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public boolean getAllowCors() {
        return this.allowCors_;
    }

    /* access modifiers changed from: private */
    public void setAllowCors(boolean value) {
        this.allowCors_ = value;
    }

    /* access modifiers changed from: private */
    public void clearAllowCors() {
        this.allowCors_ = false;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        for (int i = 0; i < this.aliases_.size(); i++) {
            output.writeString(2, (String) this.aliases_.get(i));
        }
        for (int i2 = 0; i2 < this.apis_.size(); i2++) {
            output.writeString(3, (String) this.apis_.get(i2));
        }
        for (int i3 = 0; i3 < this.features_.size(); i3++) {
            output.writeString(4, (String) this.features_.get(i3));
        }
        boolean z = this.allowCors_;
        if (z) {
            output.writeBool(5, z);
        }
        if (!this.target_.isEmpty()) {
            output.writeString(101, getTarget());
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
        int dataSize = 0;
        for (int i = 0; i < this.aliases_.size(); i++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.aliases_.get(i));
        }
        int size3 = size2 + dataSize + (getAliasesList().size() * 1);
        int dataSize2 = 0;
        for (int i2 = 0; i2 < this.apis_.size(); i2++) {
            dataSize2 += CodedOutputStream.computeStringSizeNoTag((String) this.apis_.get(i2));
        }
        int size4 = size3 + dataSize2 + (getApisList().size() * 1);
        int dataSize3 = 0;
        for (int i3 = 0; i3 < this.features_.size(); i3++) {
            dataSize3 += CodedOutputStream.computeStringSizeNoTag((String) this.features_.get(i3));
        }
        int size5 = size4 + dataSize3 + (getFeaturesList().size() * 1);
        boolean z = this.allowCors_;
        if (z) {
            size5 += CodedOutputStream.computeBoolSize(5, z);
        }
        if (!this.target_.isEmpty()) {
            size5 += CodedOutputStream.computeStringSize(101, getTarget());
        }
        this.memoizedSerializedSize = size5;
        return size5;
    }

    public static Endpoint parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Endpoint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Endpoint parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Endpoint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Endpoint parseFrom(InputStream input) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Endpoint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Endpoint parseDelimitedFrom(InputStream input) throws IOException {
        return (Endpoint) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Endpoint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Endpoint) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Endpoint parseFrom(CodedInputStream input) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Endpoint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Endpoint prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Endpoint, Builder> implements EndpointOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Endpoint.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((Endpoint) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Endpoint) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Endpoint) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Endpoint) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Endpoint) this.instance).setNameBytes(value);
            return this;
        }

        public List<String> getAliasesList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getAliasesList());
        }

        public int getAliasesCount() {
            return ((Endpoint) this.instance).getAliasesCount();
        }

        public String getAliases(int index) {
            return ((Endpoint) this.instance).getAliases(index);
        }

        public ByteString getAliasesBytes(int index) {
            return ((Endpoint) this.instance).getAliasesBytes(index);
        }

        public Builder setAliases(int index, String value) {
            copyOnWrite();
            ((Endpoint) this.instance).setAliases(index, value);
            return this;
        }

        public Builder addAliases(String value) {
            copyOnWrite();
            ((Endpoint) this.instance).addAliases(value);
            return this;
        }

        public Builder addAllAliases(Iterable<String> values) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllAliases(values);
            return this;
        }

        public Builder clearAliases() {
            copyOnWrite();
            ((Endpoint) this.instance).clearAliases();
            return this;
        }

        public Builder addAliasesBytes(ByteString value) {
            copyOnWrite();
            ((Endpoint) this.instance).addAliasesBytes(value);
            return this;
        }

        public List<String> getApisList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getApisList());
        }

        public int getApisCount() {
            return ((Endpoint) this.instance).getApisCount();
        }

        public String getApis(int index) {
            return ((Endpoint) this.instance).getApis(index);
        }

        public ByteString getApisBytes(int index) {
            return ((Endpoint) this.instance).getApisBytes(index);
        }

        public Builder setApis(int index, String value) {
            copyOnWrite();
            ((Endpoint) this.instance).setApis(index, value);
            return this;
        }

        public Builder addApis(String value) {
            copyOnWrite();
            ((Endpoint) this.instance).addApis(value);
            return this;
        }

        public Builder addAllApis(Iterable<String> values) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllApis(values);
            return this;
        }

        public Builder clearApis() {
            copyOnWrite();
            ((Endpoint) this.instance).clearApis();
            return this;
        }

        public Builder addApisBytes(ByteString value) {
            copyOnWrite();
            ((Endpoint) this.instance).addApisBytes(value);
            return this;
        }

        public List<String> getFeaturesList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getFeaturesList());
        }

        public int getFeaturesCount() {
            return ((Endpoint) this.instance).getFeaturesCount();
        }

        public String getFeatures(int index) {
            return ((Endpoint) this.instance).getFeatures(index);
        }

        public ByteString getFeaturesBytes(int index) {
            return ((Endpoint) this.instance).getFeaturesBytes(index);
        }

        public Builder setFeatures(int index, String value) {
            copyOnWrite();
            ((Endpoint) this.instance).setFeatures(index, value);
            return this;
        }

        public Builder addFeatures(String value) {
            copyOnWrite();
            ((Endpoint) this.instance).addFeatures(value);
            return this;
        }

        public Builder addAllFeatures(Iterable<String> values) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllFeatures(values);
            return this;
        }

        public Builder clearFeatures() {
            copyOnWrite();
            ((Endpoint) this.instance).clearFeatures();
            return this;
        }

        public Builder addFeaturesBytes(ByteString value) {
            copyOnWrite();
            ((Endpoint) this.instance).addFeaturesBytes(value);
            return this;
        }

        public String getTarget() {
            return ((Endpoint) this.instance).getTarget();
        }

        public ByteString getTargetBytes() {
            return ((Endpoint) this.instance).getTargetBytes();
        }

        public Builder setTarget(String value) {
            copyOnWrite();
            ((Endpoint) this.instance).setTarget(value);
            return this;
        }

        public Builder clearTarget() {
            copyOnWrite();
            ((Endpoint) this.instance).clearTarget();
            return this;
        }

        public Builder setTargetBytes(ByteString value) {
            copyOnWrite();
            ((Endpoint) this.instance).setTargetBytes(value);
            return this;
        }

        public boolean getAllowCors() {
            return ((Endpoint) this.instance).getAllowCors();
        }

        public Builder setAllowCors(boolean value) {
            copyOnWrite();
            ((Endpoint) this.instance).setAllowCors(value);
            return this;
        }

        public Builder clearAllowCors() {
            copyOnWrite();
            ((Endpoint) this.instance).clearAllowCors();
            return this;
        }
    }

    /* renamed from: com.google.api.Endpoint$1  reason: invalid class name */
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
                return new Endpoint();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.aliases_.makeImmutable();
                this.apis_.makeImmutable();
                this.features_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Endpoint other = (Endpoint) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.aliases_ = visitor.visitList(this.aliases_, other.aliases_);
                this.apis_ = visitor.visitList(this.apis_, other.apis_);
                this.features_ = visitor.visitList(this.features_, other.features_);
                this.target_ = visitor.visitString(!this.target_.isEmpty(), this.target_, !other.target_.isEmpty(), other.target_);
                boolean z = this.allowCors_;
                boolean z2 = other.allowCors_;
                this.allowCors_ = visitor.visitBoolean(z, z, z2, z2);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= other.bitField0_;
                }
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
                            this.name_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            String s = input.readStringRequireUtf8();
                            if (!this.aliases_.isModifiable()) {
                                this.aliases_ = GeneratedMessageLite.mutableCopy(this.aliases_);
                            }
                            this.aliases_.add(s);
                        } else if (tag == 26) {
                            String s2 = input.readStringRequireUtf8();
                            if (!this.apis_.isModifiable()) {
                                this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_);
                            }
                            this.apis_.add(s2);
                        } else if (tag == 34) {
                            String s3 = input.readStringRequireUtf8();
                            if (!this.features_.isModifiable()) {
                                this.features_ = GeneratedMessageLite.mutableCopy(this.features_);
                            }
                            this.features_.add(s3);
                        } else if (tag == 40) {
                            this.allowCors_ = input.readBool();
                        } else if (tag == 810) {
                            this.target_ = input.readStringRequireUtf8();
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
                    synchronized (Endpoint.class) {
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
        Endpoint endpoint = new Endpoint();
        DEFAULT_INSTANCE = endpoint;
        endpoint.makeImmutable();
    }

    public static Endpoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Endpoint> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
