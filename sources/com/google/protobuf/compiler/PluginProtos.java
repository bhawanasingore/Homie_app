package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class PluginProtos {

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface CodeGeneratorRequestOrBuilder extends MessageLiteOrBuilder {
        Version getCompilerVersion();

        String getFileToGenerate(int i);

        ByteString getFileToGenerateBytes(int i);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int i);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        boolean hasCompilerVersion();

        boolean hasParameter();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface CodeGeneratorResponseOrBuilder extends MessageLiteOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int i);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        boolean hasError();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface VersionOrBuilder extends MessageLiteOrBuilder {
        int getMajor();

        int getMinor();

        int getPatch();

        String getSuffix();

        ByteString getSuffixBytes();

        boolean hasMajor();

        boolean hasMinor();

        boolean hasPatch();

        boolean hasSuffix();
    }

    private PluginProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Version extends GeneratedMessageLite<Version, Builder> implements VersionOrBuilder {
        /* access modifiers changed from: private */
        public static final Version DEFAULT_INSTANCE;
        public static final int MAJOR_FIELD_NUMBER = 1;
        public static final int MINOR_FIELD_NUMBER = 2;
        private static volatile Parser<Version> PARSER = null;
        public static final int PATCH_FIELD_NUMBER = 3;
        public static final int SUFFIX_FIELD_NUMBER = 4;
        private int bitField0_;
        private int major_;
        private int minor_;
        private int patch_;
        private String suffix_ = "";

        private Version() {
        }

        public boolean hasMajor() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getMajor() {
            return this.major_;
        }

        /* access modifiers changed from: private */
        public void setMajor(int value) {
            this.bitField0_ |= 1;
            this.major_ = value;
        }

        /* access modifiers changed from: private */
        public void clearMajor() {
            this.bitField0_ &= -2;
            this.major_ = 0;
        }

        public boolean hasMinor() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getMinor() {
            return this.minor_;
        }

        /* access modifiers changed from: private */
        public void setMinor(int value) {
            this.bitField0_ |= 2;
            this.minor_ = value;
        }

        /* access modifiers changed from: private */
        public void clearMinor() {
            this.bitField0_ &= -3;
            this.minor_ = 0;
        }

        public boolean hasPatch() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getPatch() {
            return this.patch_;
        }

        /* access modifiers changed from: private */
        public void setPatch(int value) {
            this.bitField0_ |= 4;
            this.patch_ = value;
        }

        /* access modifiers changed from: private */
        public void clearPatch() {
            this.bitField0_ &= -5;
            this.patch_ = 0;
        }

        public boolean hasSuffix() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getSuffix() {
            return this.suffix_;
        }

        public ByteString getSuffixBytes() {
            return ByteString.copyFromUtf8(this.suffix_);
        }

        /* access modifiers changed from: private */
        public void setSuffix(String value) {
            if (value != null) {
                this.bitField0_ |= 8;
                this.suffix_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearSuffix() {
            this.bitField0_ &= -9;
            this.suffix_ = getDefaultInstance().getSuffix();
        }

        /* access modifiers changed from: private */
        public void setSuffixBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 8;
                this.suffix_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.major_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.minor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeInt32(3, this.patch_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeString(4, getSuffix());
            }
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.major_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeInt32Size(2, this.minor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeInt32Size(3, this.patch_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeStringSize(4, getSuffix());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static Version parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Version parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Version parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Version parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Version parseFrom(InputStream input) throws IOException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Version parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Version parseDelimitedFrom(InputStream input) throws IOException {
            return (Version) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Version parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Version) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Version parseFrom(CodedInputStream input) throws IOException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Version parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Version prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<Version, Builder> implements VersionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(Version.DEFAULT_INSTANCE);
            }

            public boolean hasMajor() {
                return ((Version) this.instance).hasMajor();
            }

            public int getMajor() {
                return ((Version) this.instance).getMajor();
            }

            public Builder setMajor(int value) {
                copyOnWrite();
                ((Version) this.instance).setMajor(value);
                return this;
            }

            public Builder clearMajor() {
                copyOnWrite();
                ((Version) this.instance).clearMajor();
                return this;
            }

            public boolean hasMinor() {
                return ((Version) this.instance).hasMinor();
            }

            public int getMinor() {
                return ((Version) this.instance).getMinor();
            }

            public Builder setMinor(int value) {
                copyOnWrite();
                ((Version) this.instance).setMinor(value);
                return this;
            }

            public Builder clearMinor() {
                copyOnWrite();
                ((Version) this.instance).clearMinor();
                return this;
            }

            public boolean hasPatch() {
                return ((Version) this.instance).hasPatch();
            }

            public int getPatch() {
                return ((Version) this.instance).getPatch();
            }

            public Builder setPatch(int value) {
                copyOnWrite();
                ((Version) this.instance).setPatch(value);
                return this;
            }

            public Builder clearPatch() {
                copyOnWrite();
                ((Version) this.instance).clearPatch();
                return this;
            }

            public boolean hasSuffix() {
                return ((Version) this.instance).hasSuffix();
            }

            public String getSuffix() {
                return ((Version) this.instance).getSuffix();
            }

            public ByteString getSuffixBytes() {
                return ((Version) this.instance).getSuffixBytes();
            }

            public Builder setSuffix(String value) {
                copyOnWrite();
                ((Version) this.instance).setSuffix(value);
                return this;
            }

            public Builder clearSuffix() {
                copyOnWrite();
                ((Version) this.instance).clearSuffix();
                return this;
            }

            public Builder setSuffixBytes(ByteString value) {
                copyOnWrite();
                ((Version) this.instance).setSuffixBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new Version();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    Version other = (Version) arg1;
                    this.major_ = visitor.visitInt(hasMajor(), this.major_, other.hasMajor(), other.major_);
                    this.minor_ = visitor.visitInt(hasMinor(), this.minor_, other.hasMinor(), other.minor_);
                    this.patch_ = visitor.visitInt(hasPatch(), this.patch_, other.hasPatch(), other.patch_);
                    this.suffix_ = visitor.visitString(hasSuffix(), this.suffix_, other.hasSuffix(), other.suffix_);
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
                            } else if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.major_ = input.readInt32();
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.minor_ = input.readInt32();
                            } else if (tag == 24) {
                                this.bitField0_ |= 4;
                                this.patch_ = input.readInt32();
                            } else if (tag == 34) {
                                String s = input.readString();
                                this.bitField0_ = 8 | this.bitField0_;
                                this.suffix_ = s;
                            } else if (!parseUnknownField(tag, input)) {
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
                        synchronized (Version.class) {
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
            Version version = new Version();
            DEFAULT_INSTANCE = version;
            version.makeImmutable();
        }

        public static Version getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Version> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.protobuf.compiler.PluginProtos$1  reason: invalid class name */
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

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class CodeGeneratorRequest extends GeneratedMessageLite<CodeGeneratorRequest, Builder> implements CodeGeneratorRequestOrBuilder {
        public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
        /* access modifiers changed from: private */
        public static final CodeGeneratorRequest DEFAULT_INSTANCE;
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;
        private static volatile Parser<CodeGeneratorRequest> PARSER = null;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        private int bitField0_;
        private Version compilerVersion_;
        private Internal.ProtobufList<String> fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
        private byte memoizedIsInitialized = -1;
        private String parameter_ = "";
        private Internal.ProtobufList<DescriptorProtos.FileDescriptorProto> protoFile_ = emptyProtobufList();

        private CodeGeneratorRequest() {
        }

        public List<String> getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        public String getFileToGenerate(int index) {
            return (String) this.fileToGenerate_.get(index);
        }

        public ByteString getFileToGenerateBytes(int index) {
            return ByteString.copyFromUtf8((String) this.fileToGenerate_.get(index));
        }

        private void ensureFileToGenerateIsMutable() {
            if (!this.fileToGenerate_.isModifiable()) {
                this.fileToGenerate_ = GeneratedMessageLite.mutableCopy(this.fileToGenerate_);
            }
        }

        /* access modifiers changed from: private */
        public void setFileToGenerate(int index, String value) {
            if (value != null) {
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addFileToGenerate(String value) {
            if (value != null) {
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addAllFileToGenerate(Iterable<String> values) {
            ensureFileToGenerateIsMutable();
            AbstractMessageLite.addAll(values, this.fileToGenerate_);
        }

        /* access modifiers changed from: private */
        public void clearFileToGenerate() {
            this.fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addFileToGenerateBytes(ByteString value) {
            if (value != null) {
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(value.toStringUtf8());
                return;
            }
            throw null;
        }

        public boolean hasParameter() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getParameter() {
            return this.parameter_;
        }

        public ByteString getParameterBytes() {
            return ByteString.copyFromUtf8(this.parameter_);
        }

        /* access modifiers changed from: private */
        public void setParameter(String value) {
            if (value != null) {
                this.bitField0_ |= 1;
                this.parameter_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearParameter() {
            this.bitField0_ &= -2;
            this.parameter_ = getDefaultInstance().getParameter();
        }

        /* access modifiers changed from: private */
        public void setParameterBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 1;
                this.parameter_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        public DescriptorProtos.FileDescriptorProto getProtoFile(int index) {
            return (DescriptorProtos.FileDescriptorProto) this.protoFile_.get(index);
        }

        public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int index) {
            return (DescriptorProtos.FileDescriptorProtoOrBuilder) this.protoFile_.get(index);
        }

        private void ensureProtoFileIsMutable() {
            if (!this.protoFile_.isModifiable()) {
                this.protoFile_ = GeneratedMessageLite.mutableCopy(this.protoFile_);
            }
        }

        /* access modifiers changed from: private */
        public void setProtoFile(int index, DescriptorProtos.FileDescriptorProto value) {
            if (value != null) {
                ensureProtoFileIsMutable();
                this.protoFile_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setProtoFile(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
            ensureProtoFileIsMutable();
            this.protoFile_.set(index, (DescriptorProtos.FileDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addProtoFile(DescriptorProtos.FileDescriptorProto value) {
            if (value != null) {
                ensureProtoFileIsMutable();
                this.protoFile_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addProtoFile(int index, DescriptorProtos.FileDescriptorProto value) {
            if (value != null) {
                ensureProtoFileIsMutable();
                this.protoFile_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addProtoFile(DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
            ensureProtoFileIsMutable();
            this.protoFile_.add((DescriptorProtos.FileDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addProtoFile(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
            ensureProtoFileIsMutable();
            this.protoFile_.add(index, (DescriptorProtos.FileDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> values) {
            ensureProtoFileIsMutable();
            AbstractMessageLite.addAll(values, this.protoFile_);
        }

        /* access modifiers changed from: private */
        public void clearProtoFile() {
            this.protoFile_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeProtoFile(int index) {
            ensureProtoFileIsMutable();
            this.protoFile_.remove(index);
        }

        public boolean hasCompilerVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        public Version getCompilerVersion() {
            Version version = this.compilerVersion_;
            return version == null ? Version.getDefaultInstance() : version;
        }

        /* access modifiers changed from: private */
        public void setCompilerVersion(Version value) {
            if (value != null) {
                this.compilerVersion_ = value;
                this.bitField0_ |= 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setCompilerVersion(Version.Builder builderForValue) {
            this.compilerVersion_ = (Version) builderForValue.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeCompilerVersion(Version value) {
            Version version = this.compilerVersion_;
            if (version == null || version == Version.getDefaultInstance()) {
                this.compilerVersion_ = value;
            } else {
                this.compilerVersion_ = (Version) ((Version.Builder) Version.newBuilder(this.compilerVersion_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearCompilerVersion() {
            this.compilerVersion_ = null;
            this.bitField0_ &= -3;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.fileToGenerate_.size(); i++) {
                output.writeString(1, (String) this.fileToGenerate_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(2, getParameter());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(3, getCompilerVersion());
            }
            for (int i2 = 0; i2 < this.protoFile_.size(); i2++) {
                output.writeMessage(15, (MessageLite) this.protoFile_.get(i2));
            }
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.fileToGenerate_.size(); i++) {
                dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.fileToGenerate_.get(i));
            }
            int size2 = 0 + dataSize + (getFileToGenerateList().size() * 1);
            if ((this.bitField0_ & 1) == 1) {
                size2 += CodedOutputStream.computeStringSize(2, getParameter());
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeMessageSize(3, getCompilerVersion());
            }
            for (int i2 = 0; i2 < this.protoFile_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(15, (MessageLite) this.protoFile_.get(i2));
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static CodeGeneratorRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static CodeGeneratorRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static CodeGeneratorRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static CodeGeneratorRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static CodeGeneratorRequest parseFrom(InputStream input) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static CodeGeneratorRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (CodeGeneratorRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream input) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorRequest prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorRequest, Builder> implements CodeGeneratorRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(CodeGeneratorRequest.DEFAULT_INSTANCE);
            }

            public List<String> getFileToGenerateList() {
                return Collections.unmodifiableList(((CodeGeneratorRequest) this.instance).getFileToGenerateList());
            }

            public int getFileToGenerateCount() {
                return ((CodeGeneratorRequest) this.instance).getFileToGenerateCount();
            }

            public String getFileToGenerate(int index) {
                return ((CodeGeneratorRequest) this.instance).getFileToGenerate(index);
            }

            public ByteString getFileToGenerateBytes(int index) {
                return ((CodeGeneratorRequest) this.instance).getFileToGenerateBytes(index);
            }

            public Builder setFileToGenerate(int index, String value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setFileToGenerate(index, value);
                return this;
            }

            public Builder addFileToGenerate(String value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addFileToGenerate(value);
                return this;
            }

            public Builder addAllFileToGenerate(Iterable<String> values) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addAllFileToGenerate(values);
                return this;
            }

            public Builder clearFileToGenerate() {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).clearFileToGenerate();
                return this;
            }

            public Builder addFileToGenerateBytes(ByteString value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addFileToGenerateBytes(value);
                return this;
            }

            public boolean hasParameter() {
                return ((CodeGeneratorRequest) this.instance).hasParameter();
            }

            public String getParameter() {
                return ((CodeGeneratorRequest) this.instance).getParameter();
            }

            public ByteString getParameterBytes() {
                return ((CodeGeneratorRequest) this.instance).getParameterBytes();
            }

            public Builder setParameter(String value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setParameter(value);
                return this;
            }

            public Builder clearParameter() {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).clearParameter();
                return this;
            }

            public Builder setParameterBytes(ByteString value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setParameterBytes(value);
                return this;
            }

            public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                return Collections.unmodifiableList(((CodeGeneratorRequest) this.instance).getProtoFileList());
            }

            public int getProtoFileCount() {
                return ((CodeGeneratorRequest) this.instance).getProtoFileCount();
            }

            public DescriptorProtos.FileDescriptorProto getProtoFile(int index) {
                return ((CodeGeneratorRequest) this.instance).getProtoFile(index);
            }

            public Builder setProtoFile(int index, DescriptorProtos.FileDescriptorProto value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setProtoFile(index, value);
                return this;
            }

            public Builder setProtoFile(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setProtoFile(index, builderForValue);
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addProtoFile(value);
                return this;
            }

            public Builder addProtoFile(int index, DescriptorProtos.FileDescriptorProto value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addProtoFile(index, value);
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addProtoFile(builderForValue);
                return this;
            }

            public Builder addProtoFile(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addProtoFile(index, builderForValue);
                return this;
            }

            public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> values) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addAllProtoFile(values);
                return this;
            }

            public Builder clearProtoFile() {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).clearProtoFile();
                return this;
            }

            public Builder removeProtoFile(int index) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).removeProtoFile(index);
                return this;
            }

            public boolean hasCompilerVersion() {
                return ((CodeGeneratorRequest) this.instance).hasCompilerVersion();
            }

            public Version getCompilerVersion() {
                return ((CodeGeneratorRequest) this.instance).getCompilerVersion();
            }

            public Builder setCompilerVersion(Version value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setCompilerVersion(value);
                return this;
            }

            public Builder setCompilerVersion(Version.Builder builderForValue) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setCompilerVersion(builderForValue);
                return this;
            }

            public Builder mergeCompilerVersion(Version value) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).mergeCompilerVersion(value);
                return this;
            }

            public Builder clearCompilerVersion() {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).clearCompilerVersion();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new CodeGeneratorRequest();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getProtoFileCount(); i++) {
                        if (!getProtoFile(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.fileToGenerate_.makeImmutable();
                    this.protoFile_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    CodeGeneratorRequest other = (CodeGeneratorRequest) arg1;
                    this.fileToGenerate_ = visitor.visitList(this.fileToGenerate_, other.fileToGenerate_);
                    this.parameter_ = visitor.visitString(hasParameter(), this.parameter_, other.hasParameter(), other.parameter_);
                    this.protoFile_ = visitor.visitList(this.protoFile_, other.protoFile_);
                    this.compilerVersion_ = (Version) visitor.visitMessage(this.compilerVersion_, other.compilerVersion_);
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
                                String s = input.readString();
                                if (!this.fileToGenerate_.isModifiable()) {
                                    this.fileToGenerate_ = GeneratedMessageLite.mutableCopy(this.fileToGenerate_);
                                }
                                this.fileToGenerate_.add(s);
                            } else if (tag == 18) {
                                String s2 = input.readString();
                                this.bitField0_ |= 1;
                                this.parameter_ = s2;
                            } else if (tag == 26) {
                                Version.Builder subBuilder = null;
                                if ((this.bitField0_ & 2) == 2) {
                                    subBuilder = (Version.Builder) this.compilerVersion_.toBuilder();
                                }
                                Version version = (Version) input.readMessage(Version.parser(), extensionRegistry);
                                this.compilerVersion_ = version;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(version);
                                    this.compilerVersion_ = (Version) subBuilder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag == 122) {
                                if (!this.protoFile_.isModifiable()) {
                                    this.protoFile_ = GeneratedMessageLite.mutableCopy(this.protoFile_);
                                }
                                this.protoFile_.add((DescriptorProtos.FileDescriptorProto) input.readMessage(DescriptorProtos.FileDescriptorProto.parser(), extensionRegistry));
                            } else if (!parseUnknownField(tag, input)) {
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
                        synchronized (CodeGeneratorRequest.class) {
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
            CodeGeneratorRequest codeGeneratorRequest = new CodeGeneratorRequest();
            DEFAULT_INSTANCE = codeGeneratorRequest;
            codeGeneratorRequest.makeImmutable();
        }

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodeGeneratorRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class CodeGeneratorResponse extends GeneratedMessageLite<CodeGeneratorResponse, Builder> implements CodeGeneratorResponseOrBuilder {
        /* access modifiers changed from: private */
        public static final CodeGeneratorResponse DEFAULT_INSTANCE;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;
        private static volatile Parser<CodeGeneratorResponse> PARSER;
        private int bitField0_;
        private String error_ = "";
        private Internal.ProtobufList<File> file_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface FileOrBuilder extends MessageLiteOrBuilder {
            String getContent();

            ByteString getContentBytes();

            String getInsertionPoint();

            ByteString getInsertionPointBytes();

            String getName();

            ByteString getNameBytes();

            boolean hasContent();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        private CodeGeneratorResponse() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class File extends GeneratedMessageLite<File, Builder> implements FileOrBuilder {
            public static final int CONTENT_FIELD_NUMBER = 15;
            /* access modifiers changed from: private */
            public static final File DEFAULT_INSTANCE;
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static volatile Parser<File> PARSER;
            private int bitField0_;
            private String content_ = "";
            private String insertionPoint_ = "";
            private String name_ = "";

            private File() {
            }

            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
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
                    this.bitField0_ |= 1;
                    this.name_ = value;
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void clearName() {
                this.bitField0_ &= -2;
                this.name_ = getDefaultInstance().getName();
            }

            /* access modifiers changed from: private */
            public void setNameBytes(ByteString value) {
                if (value != null) {
                    this.bitField0_ |= 1;
                    this.name_ = value.toStringUtf8();
                    return;
                }
                throw null;
            }

            public boolean hasInsertionPoint() {
                return (this.bitField0_ & 2) == 2;
            }

            public String getInsertionPoint() {
                return this.insertionPoint_;
            }

            public ByteString getInsertionPointBytes() {
                return ByteString.copyFromUtf8(this.insertionPoint_);
            }

            /* access modifiers changed from: private */
            public void setInsertionPoint(String value) {
                if (value != null) {
                    this.bitField0_ |= 2;
                    this.insertionPoint_ = value;
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void clearInsertionPoint() {
                this.bitField0_ &= -3;
                this.insertionPoint_ = getDefaultInstance().getInsertionPoint();
            }

            /* access modifiers changed from: private */
            public void setInsertionPointBytes(ByteString value) {
                if (value != null) {
                    this.bitField0_ |= 2;
                    this.insertionPoint_ = value.toStringUtf8();
                    return;
                }
                throw null;
            }

            public boolean hasContent() {
                return (this.bitField0_ & 4) == 4;
            }

            public String getContent() {
                return this.content_;
            }

            public ByteString getContentBytes() {
                return ByteString.copyFromUtf8(this.content_);
            }

            /* access modifiers changed from: private */
            public void setContent(String value) {
                if (value != null) {
                    this.bitField0_ |= 4;
                    this.content_ = value;
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void clearContent() {
                this.bitField0_ &= -5;
                this.content_ = getDefaultInstance().getContent();
            }

            /* access modifiers changed from: private */
            public void setContentBytes(ByteString value) {
                if (value != null) {
                    this.bitField0_ |= 4;
                    this.content_ = value.toStringUtf8();
                    return;
                }
                throw null;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    output.writeString(1, getName());
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeString(2, getInsertionPoint());
                }
                if ((this.bitField0_ & 4) == 4) {
                    output.writeString(15, getContent());
                }
                this.unknownFields.writeTo(output);
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int size2 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    size2 = 0 + CodedOutputStream.computeStringSize(1, getName());
                }
                if ((this.bitField0_ & 2) == 2) {
                    size2 += CodedOutputStream.computeStringSize(2, getInsertionPoint());
                }
                if ((this.bitField0_ & 4) == 4) {
                    size2 += CodedOutputStream.computeStringSize(15, getContent());
                }
                int size3 = size2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size3;
                return size3;
            }

            public static File parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static File parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static File parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static File parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static File parseFrom(InputStream input) throws IOException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static File parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static File parseDelimitedFrom(InputStream input) throws IOException {
                return (File) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static File parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (File) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static File parseFrom(CodedInputStream input) throws IOException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static File parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(File prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<File, Builder> implements FileOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(File.DEFAULT_INSTANCE);
                }

                public boolean hasName() {
                    return ((File) this.instance).hasName();
                }

                public String getName() {
                    return ((File) this.instance).getName();
                }

                public ByteString getNameBytes() {
                    return ((File) this.instance).getNameBytes();
                }

                public Builder setName(String value) {
                    copyOnWrite();
                    ((File) this.instance).setName(value);
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((File) this.instance).clearName();
                    return this;
                }

                public Builder setNameBytes(ByteString value) {
                    copyOnWrite();
                    ((File) this.instance).setNameBytes(value);
                    return this;
                }

                public boolean hasInsertionPoint() {
                    return ((File) this.instance).hasInsertionPoint();
                }

                public String getInsertionPoint() {
                    return ((File) this.instance).getInsertionPoint();
                }

                public ByteString getInsertionPointBytes() {
                    return ((File) this.instance).getInsertionPointBytes();
                }

                public Builder setInsertionPoint(String value) {
                    copyOnWrite();
                    ((File) this.instance).setInsertionPoint(value);
                    return this;
                }

                public Builder clearInsertionPoint() {
                    copyOnWrite();
                    ((File) this.instance).clearInsertionPoint();
                    return this;
                }

                public Builder setInsertionPointBytes(ByteString value) {
                    copyOnWrite();
                    ((File) this.instance).setInsertionPointBytes(value);
                    return this;
                }

                public boolean hasContent() {
                    return ((File) this.instance).hasContent();
                }

                public String getContent() {
                    return ((File) this.instance).getContent();
                }

                public ByteString getContentBytes() {
                    return ((File) this.instance).getContentBytes();
                }

                public Builder setContent(String value) {
                    copyOnWrite();
                    ((File) this.instance).setContent(value);
                    return this;
                }

                public Builder clearContent() {
                    copyOnWrite();
                    ((File) this.instance).clearContent();
                    return this;
                }

                public Builder setContentBytes(ByteString value) {
                    copyOnWrite();
                    ((File) this.instance).setContentBytes(value);
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new File();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                        File other = (File) arg1;
                        this.name_ = visitor.visitString(hasName(), this.name_, other.hasName(), other.name_);
                        this.insertionPoint_ = visitor.visitString(hasInsertionPoint(), this.insertionPoint_, other.hasInsertionPoint(), other.insertionPoint_);
                        this.content_ = visitor.visitString(hasContent(), this.content_, other.hasContent(), other.content_);
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
                                    String s = input.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = s;
                                } else if (tag == 18) {
                                    String s2 = input.readString();
                                    this.bitField0_ |= 2;
                                    this.insertionPoint_ = s2;
                                } else if (tag == 122) {
                                    String s3 = input.readString();
                                    this.bitField0_ |= 4;
                                    this.content_ = s3;
                                } else if (!parseUnknownField(tag, input)) {
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
                            synchronized (File.class) {
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
                File file = new File();
                DEFAULT_INSTANCE = file;
                file.makeImmutable();
            }

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<File> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public boolean hasError() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getError() {
            return this.error_;
        }

        public ByteString getErrorBytes() {
            return ByteString.copyFromUtf8(this.error_);
        }

        /* access modifiers changed from: private */
        public void setError(String value) {
            if (value != null) {
                this.bitField0_ |= 1;
                this.error_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearError() {
            this.bitField0_ &= -2;
            this.error_ = getDefaultInstance().getError();
        }

        /* access modifiers changed from: private */
        public void setErrorBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 1;
                this.error_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public List<File> getFileList() {
            return this.file_;
        }

        public List<? extends FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        public int getFileCount() {
            return this.file_.size();
        }

        public File getFile(int index) {
            return (File) this.file_.get(index);
        }

        public FileOrBuilder getFileOrBuilder(int index) {
            return (FileOrBuilder) this.file_.get(index);
        }

        private void ensureFileIsMutable() {
            if (!this.file_.isModifiable()) {
                this.file_ = GeneratedMessageLite.mutableCopy(this.file_);
            }
        }

        /* access modifiers changed from: private */
        public void setFile(int index, File value) {
            if (value != null) {
                ensureFileIsMutable();
                this.file_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setFile(int index, File.Builder builderForValue) {
            ensureFileIsMutable();
            this.file_.set(index, (File) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addFile(File value) {
            if (value != null) {
                ensureFileIsMutable();
                this.file_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addFile(int index, File value) {
            if (value != null) {
                ensureFileIsMutable();
                this.file_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addFile(File.Builder builderForValue) {
            ensureFileIsMutable();
            this.file_.add((File) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addFile(int index, File.Builder builderForValue) {
            ensureFileIsMutable();
            this.file_.add(index, (File) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllFile(Iterable<? extends File> values) {
            ensureFileIsMutable();
            AbstractMessageLite.addAll(values, this.file_);
        }

        /* access modifiers changed from: private */
        public void clearFile() {
            this.file_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeFile(int index) {
            ensureFileIsMutable();
            this.file_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getError());
            }
            for (int i = 0; i < this.file_.size(); i++) {
                output.writeMessage(15, (MessageLite) this.file_.get(i));
            }
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                size2 = 0 + CodedOutputStream.computeStringSize(1, getError());
            }
            for (int i = 0; i < this.file_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(15, (MessageLite) this.file_.get(i));
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static CodeGeneratorResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static CodeGeneratorResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static CodeGeneratorResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static CodeGeneratorResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static CodeGeneratorResponse parseFrom(InputStream input) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static CodeGeneratorResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (CodeGeneratorResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream input) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorResponse prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse, Builder> implements CodeGeneratorResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(CodeGeneratorResponse.DEFAULT_INSTANCE);
            }

            public boolean hasError() {
                return ((CodeGeneratorResponse) this.instance).hasError();
            }

            public String getError() {
                return ((CodeGeneratorResponse) this.instance).getError();
            }

            public ByteString getErrorBytes() {
                return ((CodeGeneratorResponse) this.instance).getErrorBytes();
            }

            public Builder setError(String value) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).setError(value);
                return this;
            }

            public Builder clearError() {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).clearError();
                return this;
            }

            public Builder setErrorBytes(ByteString value) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).setErrorBytes(value);
                return this;
            }

            public List<File> getFileList() {
                return Collections.unmodifiableList(((CodeGeneratorResponse) this.instance).getFileList());
            }

            public int getFileCount() {
                return ((CodeGeneratorResponse) this.instance).getFileCount();
            }

            public File getFile(int index) {
                return ((CodeGeneratorResponse) this.instance).getFile(index);
            }

            public Builder setFile(int index, File value) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).setFile(index, value);
                return this;
            }

            public Builder setFile(int index, File.Builder builderForValue) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).setFile(index, builderForValue);
                return this;
            }

            public Builder addFile(File value) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addFile(value);
                return this;
            }

            public Builder addFile(int index, File value) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addFile(index, value);
                return this;
            }

            public Builder addFile(File.Builder builderForValue) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addFile(builderForValue);
                return this;
            }

            public Builder addFile(int index, File.Builder builderForValue) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addFile(index, builderForValue);
                return this;
            }

            public Builder addAllFile(Iterable<? extends File> values) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addAllFile(values);
                return this;
            }

            public Builder clearFile() {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).clearFile();
                return this;
            }

            public Builder removeFile(int index) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).removeFile(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new CodeGeneratorResponse();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.file_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    CodeGeneratorResponse other = (CodeGeneratorResponse) arg1;
                    this.error_ = visitor.visitString(hasError(), this.error_, other.hasError(), other.error_);
                    this.file_ = visitor.visitList(this.file_, other.file_);
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
                                String s = input.readString();
                                this.bitField0_ |= 1;
                                this.error_ = s;
                            } else if (tag == 122) {
                                if (!this.file_.isModifiable()) {
                                    this.file_ = GeneratedMessageLite.mutableCopy(this.file_);
                                }
                                this.file_.add((File) input.readMessage(File.parser(), extensionRegistry));
                            } else if (!parseUnknownField(tag, input)) {
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
                        synchronized (CodeGeneratorResponse.class) {
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
            CodeGeneratorResponse codeGeneratorResponse = new CodeGeneratorResponse();
            DEFAULT_INSTANCE = codeGeneratorResponse;
            codeGeneratorResponse.makeImmutable();
        }

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodeGeneratorResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
