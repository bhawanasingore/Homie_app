package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class DescriptorProtos {

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface DescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto.ExtensionRange getExtensionRange(int i);

        int getExtensionRangeCount();

        List<DescriptorProto.ExtensionRange> getExtensionRangeList();

        FieldDescriptorProto getField(int i);

        int getFieldCount();

        List<FieldDescriptorProto> getFieldList();

        String getName();

        ByteString getNameBytes();

        DescriptorProto getNestedType(int i);

        int getNestedTypeCount();

        List<DescriptorProto> getNestedTypeList();

        OneofDescriptorProto getOneofDecl(int i);

        int getOneofDeclCount();

        List<OneofDescriptorProto> getOneofDeclList();

        MessageOptions getOptions();

        String getReservedName(int i);

        ByteString getReservedNameBytes(int i);

        int getReservedNameCount();

        List<String> getReservedNameList();

        DescriptorProto.ReservedRange getReservedRange(int i);

        int getReservedRangeCount();

        List<DescriptorProto.ReservedRange> getReservedRangeList();

        boolean hasName();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface EnumDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        EnumOptions getOptions();

        String getReservedName(int i);

        ByteString getReservedNameBytes(int i);

        int getReservedNameCount();

        List<String> getReservedNameList();

        EnumDescriptorProto.EnumReservedRange getReservedRange(int i);

        int getReservedRangeCount();

        List<EnumDescriptorProto.EnumReservedRange> getReservedRangeList();

        EnumValueDescriptorProto getValue(int i);

        int getValueCount();

        List<EnumValueDescriptorProto> getValueList();

        boolean hasName();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface EnumOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumOptions, EnumOptions.Builder> {
        boolean getAllowAlias();

        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasAllowAlias();

        boolean hasDeprecated();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface EnumValueDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        int getNumber();

        EnumValueOptions getOptions();

        boolean hasName();

        boolean hasNumber();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface EnumValueOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumValueOptions, EnumValueOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface ExtensionRangeOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ExtensionRangeOptions, ExtensionRangeOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FieldDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDefaultValue();

        ByteString getDefaultValueBytes();

        String getExtendee();

        ByteString getExtendeeBytes();

        String getJsonName();

        ByteString getJsonNameBytes();

        FieldDescriptorProto.Label getLabel();

        String getName();

        ByteString getNameBytes();

        int getNumber();

        int getOneofIndex();

        FieldOptions getOptions();

        FieldDescriptorProto.Type getType();

        String getTypeName();

        ByteString getTypeNameBytes();

        boolean hasDefaultValue();

        boolean hasExtendee();

        boolean hasJsonName();

        boolean hasLabel();

        boolean hasName();

        boolean hasNumber();

        boolean hasOneofIndex();

        boolean hasOptions();

        boolean hasType();

        boolean hasTypeName();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FieldOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FieldOptions, FieldOptions.Builder> {
        FieldOptions.CType getCtype();

        boolean getDeprecated();

        FieldOptions.JSType getJstype();

        boolean getLazy();

        boolean getPacked();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean getWeak();

        boolean hasCtype();

        boolean hasDeprecated();

        boolean hasJstype();

        boolean hasLazy();

        boolean hasPacked();

        boolean hasWeak();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FileDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDependency(int i);

        ByteString getDependencyBytes(int i);

        int getDependencyCount();

        List<String> getDependencyList();

        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto getMessageType(int i);

        int getMessageTypeCount();

        List<DescriptorProto> getMessageTypeList();

        String getName();

        ByteString getNameBytes();

        FileOptions getOptions();

        String getPackage();

        ByteString getPackageBytes();

        int getPublicDependency(int i);

        int getPublicDependencyCount();

        List<Integer> getPublicDependencyList();

        ServiceDescriptorProto getService(int i);

        int getServiceCount();

        List<ServiceDescriptorProto> getServiceList();

        SourceCodeInfo getSourceCodeInfo();

        String getSyntax();

        ByteString getSyntaxBytes();

        int getWeakDependency(int i);

        int getWeakDependencyCount();

        List<Integer> getWeakDependencyList();

        boolean hasName();

        boolean hasOptions();

        boolean hasPackage();

        boolean hasSourceCodeInfo();

        boolean hasSyntax();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FileDescriptorSetOrBuilder extends MessageLiteOrBuilder {
        FileDescriptorProto getFile(int i);

        int getFileCount();

        List<FileDescriptorProto> getFileList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FileOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FileOptions, FileOptions.Builder> {
        boolean getCcEnableArenas();

        boolean getCcGenericServices();

        String getCsharpNamespace();

        ByteString getCsharpNamespaceBytes();

        boolean getDeprecated();

        String getGoPackage();

        ByteString getGoPackageBytes();

        @Deprecated
        boolean getJavaGenerateEqualsAndHash();

        boolean getJavaGenericServices();

        boolean getJavaMultipleFiles();

        String getJavaOuterClassname();

        ByteString getJavaOuterClassnameBytes();

        String getJavaPackage();

        ByteString getJavaPackageBytes();

        boolean getJavaStringCheckUtf8();

        String getObjcClassPrefix();

        ByteString getObjcClassPrefixBytes();

        FileOptions.OptimizeMode getOptimizeFor();

        String getPhpClassPrefix();

        ByteString getPhpClassPrefixBytes();

        boolean getPhpGenericServices();

        String getPhpNamespace();

        ByteString getPhpNamespaceBytes();

        boolean getPyGenericServices();

        String getSwiftPrefix();

        ByteString getSwiftPrefixBytes();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasCcEnableArenas();

        boolean hasCcGenericServices();

        boolean hasCsharpNamespace();

        boolean hasDeprecated();

        boolean hasGoPackage();

        @Deprecated
        boolean hasJavaGenerateEqualsAndHash();

        boolean hasJavaGenericServices();

        boolean hasJavaMultipleFiles();

        boolean hasJavaOuterClassname();

        boolean hasJavaPackage();

        boolean hasJavaStringCheckUtf8();

        boolean hasObjcClassPrefix();

        boolean hasOptimizeFor();

        boolean hasPhpClassPrefix();

        boolean hasPhpGenericServices();

        boolean hasPhpNamespace();

        boolean hasPyGenericServices();

        boolean hasSwiftPrefix();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface GeneratedCodeInfoOrBuilder extends MessageLiteOrBuilder {
        GeneratedCodeInfo.Annotation getAnnotation(int i);

        int getAnnotationCount();

        List<GeneratedCodeInfo.Annotation> getAnnotationList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface MessageOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MessageOptions, MessageOptions.Builder> {
        boolean getDeprecated();

        boolean getMapEntry();

        boolean getMessageSetWireFormat();

        boolean getNoStandardDescriptorAccessor();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasMapEntry();

        boolean hasMessageSetWireFormat();

        boolean hasNoStandardDescriptorAccessor();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface MethodDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        boolean getClientStreaming();

        String getInputType();

        ByteString getInputTypeBytes();

        String getName();

        ByteString getNameBytes();

        MethodOptions getOptions();

        String getOutputType();

        ByteString getOutputTypeBytes();

        boolean getServerStreaming();

        boolean hasClientStreaming();

        boolean hasInputType();

        boolean hasName();

        boolean hasOptions();

        boolean hasOutputType();

        boolean hasServerStreaming();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface MethodOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MethodOptions, MethodOptions.Builder> {
        boolean getDeprecated();

        MethodOptions.IdempotencyLevel getIdempotencyLevel();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasIdempotencyLevel();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface OneofDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        OneofOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface OneofOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<OneofOptions, OneofOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface ServiceDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        MethodDescriptorProto getMethod(int i);

        int getMethodCount();

        List<MethodDescriptorProto> getMethodList();

        String getName();

        ByteString getNameBytes();

        ServiceOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface ServiceOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ServiceOptions, ServiceOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface SourceCodeInfoOrBuilder extends MessageLiteOrBuilder {
        SourceCodeInfo.Location getLocation(int i);

        int getLocationCount();

        List<SourceCodeInfo.Location> getLocationList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface UninterpretedOptionOrBuilder extends MessageLiteOrBuilder {
        String getAggregateValue();

        ByteString getAggregateValueBytes();

        double getDoubleValue();

        String getIdentifierValue();

        ByteString getIdentifierValueBytes();

        UninterpretedOption.NamePart getName(int i);

        int getNameCount();

        List<UninterpretedOption.NamePart> getNameList();

        long getNegativeIntValue();

        long getPositiveIntValue();

        ByteString getStringValue();

        boolean hasAggregateValue();

        boolean hasDoubleValue();

        boolean hasIdentifierValue();

        boolean hasNegativeIntValue();

        boolean hasPositiveIntValue();

        boolean hasStringValue();
    }

    private DescriptorProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FileDescriptorSet extends GeneratedMessageLite<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
        /* access modifiers changed from: private */
        public static final FileDescriptorSet DEFAULT_INSTANCE;
        public static final int FILE_FIELD_NUMBER = 1;
        private static volatile Parser<FileDescriptorSet> PARSER;
        private Internal.ProtobufList<FileDescriptorProto> file_ = emptyProtobufList();
        private byte memoizedIsInitialized = -1;

        private FileDescriptorSet() {
        }

        public List<FileDescriptorProto> getFileList() {
            return this.file_;
        }

        public List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        public int getFileCount() {
            return this.file_.size();
        }

        public FileDescriptorProto getFile(int index) {
            return (FileDescriptorProto) this.file_.get(index);
        }

        public FileDescriptorProtoOrBuilder getFileOrBuilder(int index) {
            return (FileDescriptorProtoOrBuilder) this.file_.get(index);
        }

        private void ensureFileIsMutable() {
            if (!this.file_.isModifiable()) {
                this.file_ = GeneratedMessageLite.mutableCopy(this.file_);
            }
        }

        /* access modifiers changed from: private */
        public void setFile(int index, FileDescriptorProto value) {
            if (value != null) {
                ensureFileIsMutable();
                this.file_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setFile(int index, FileDescriptorProto.Builder builderForValue) {
            ensureFileIsMutable();
            this.file_.set(index, (FileDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addFile(FileDescriptorProto value) {
            if (value != null) {
                ensureFileIsMutable();
                this.file_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addFile(int index, FileDescriptorProto value) {
            if (value != null) {
                ensureFileIsMutable();
                this.file_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addFile(FileDescriptorProto.Builder builderForValue) {
            ensureFileIsMutable();
            this.file_.add((FileDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addFile(int index, FileDescriptorProto.Builder builderForValue) {
            ensureFileIsMutable();
            this.file_.add(index, (FileDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllFile(Iterable<? extends FileDescriptorProto> values) {
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
            for (int i = 0; i < this.file_.size(); i++) {
                output.writeMessage(1, (MessageLite) this.file_.get(i));
            }
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.file_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.file_.get(i));
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static FileDescriptorSet parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FileDescriptorSet parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FileDescriptorSet parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FileDescriptorSet parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FileDescriptorSet parseFrom(InputStream input) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FileDescriptorSet parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream input) throws IOException {
            return (FileDescriptorSet) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileDescriptorSet) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FileDescriptorSet parseFrom(CodedInputStream input) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FileDescriptorSet parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FileDescriptorSet prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(FileDescriptorSet.DEFAULT_INSTANCE);
            }

            public List<FileDescriptorProto> getFileList() {
                return Collections.unmodifiableList(((FileDescriptorSet) this.instance).getFileList());
            }

            public int getFileCount() {
                return ((FileDescriptorSet) this.instance).getFileCount();
            }

            public FileDescriptorProto getFile(int index) {
                return ((FileDescriptorSet) this.instance).getFile(index);
            }

            public Builder setFile(int index, FileDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).setFile(index, value);
                return this;
            }

            public Builder setFile(int index, FileDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).setFile(index, builderForValue);
                return this;
            }

            public Builder addFile(FileDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(value);
                return this;
            }

            public Builder addFile(int index, FileDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(index, value);
                return this;
            }

            public Builder addFile(FileDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(builderForValue);
                return this;
            }

            public Builder addFile(int index, FileDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(index, builderForValue);
                return this;
            }

            public Builder addAllFile(Iterable<? extends FileDescriptorProto> values) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addAllFile(values);
                return this;
            }

            public Builder clearFile() {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).clearFile();
                return this;
            }

            public Builder removeFile(int index) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).removeFile(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new FileDescriptorSet();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getFileCount(); i++) {
                        if (!getFile(i).isInitialized()) {
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
                    this.file_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    this.file_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.file_, ((FileDescriptorSet) arg1).file_);
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
                                if (!this.file_.isModifiable()) {
                                    this.file_ = GeneratedMessageLite.mutableCopy(this.file_);
                                }
                                this.file_.add((FileDescriptorProto) input.readMessage(FileDescriptorProto.parser(), extensionRegistry));
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
                        synchronized (FileDescriptorSet.class) {
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
            FileDescriptorSet fileDescriptorSet = new FileDescriptorSet();
            DEFAULT_INSTANCE = fileDescriptorSet;
            fileDescriptorSet.makeImmutable();
        }

        public static FileDescriptorSet getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileDescriptorSet> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.protobuf.DescriptorProtos$1  reason: invalid class name */
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
    public static final class FileDescriptorProto extends GeneratedMessageLite<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final FileDescriptorProto DEFAULT_INSTANCE;
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        private static volatile Parser<FileDescriptorProto> PARSER = null;
        public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        public static final int SYNTAX_FIELD_NUMBER = 12;
        public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
        private int bitField0_;
        private Internal.ProtobufList<String> dependency_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = emptyProtobufList();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = emptyProtobufList();
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<DescriptorProto> messageType_ = emptyProtobufList();
        private String name_ = "";
        private FileOptions options_;
        private String package_ = "";
        private Internal.IntList publicDependency_ = emptyIntList();
        private Internal.ProtobufList<ServiceDescriptorProto> service_ = emptyProtobufList();
        private SourceCodeInfo sourceCodeInfo_;
        private String syntax_ = "";
        private Internal.IntList weakDependency_ = emptyIntList();

        private FileDescriptorProto() {
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

        public boolean hasPackage() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getPackage() {
            return this.package_;
        }

        public ByteString getPackageBytes() {
            return ByteString.copyFromUtf8(this.package_);
        }

        /* access modifiers changed from: private */
        public void setPackage(String value) {
            if (value != null) {
                this.bitField0_ |= 2;
                this.package_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearPackage() {
            this.bitField0_ &= -3;
            this.package_ = getDefaultInstance().getPackage();
        }

        /* access modifiers changed from: private */
        public void setPackageBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 2;
                this.package_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public List<String> getDependencyList() {
            return this.dependency_;
        }

        public int getDependencyCount() {
            return this.dependency_.size();
        }

        public String getDependency(int index) {
            return (String) this.dependency_.get(index);
        }

        public ByteString getDependencyBytes(int index) {
            return ByteString.copyFromUtf8((String) this.dependency_.get(index));
        }

        private void ensureDependencyIsMutable() {
            if (!this.dependency_.isModifiable()) {
                this.dependency_ = GeneratedMessageLite.mutableCopy(this.dependency_);
            }
        }

        /* access modifiers changed from: private */
        public void setDependency(int index, String value) {
            if (value != null) {
                ensureDependencyIsMutable();
                this.dependency_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addDependency(String value) {
            if (value != null) {
                ensureDependencyIsMutable();
                this.dependency_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addAllDependency(Iterable<String> values) {
            ensureDependencyIsMutable();
            AbstractMessageLite.addAll(values, this.dependency_);
        }

        /* access modifiers changed from: private */
        public void clearDependency() {
            this.dependency_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addDependencyBytes(ByteString value) {
            if (value != null) {
                ensureDependencyIsMutable();
                this.dependency_.add(value.toStringUtf8());
                return;
            }
            throw null;
        }

        public List<Integer> getPublicDependencyList() {
            return this.publicDependency_;
        }

        public int getPublicDependencyCount() {
            return this.publicDependency_.size();
        }

        public int getPublicDependency(int index) {
            return this.publicDependency_.getInt(index);
        }

        private void ensurePublicDependencyIsMutable() {
            if (!this.publicDependency_.isModifiable()) {
                this.publicDependency_ = GeneratedMessageLite.mutableCopy(this.publicDependency_);
            }
        }

        /* access modifiers changed from: private */
        public void setPublicDependency(int index, int value) {
            ensurePublicDependencyIsMutable();
            this.publicDependency_.setInt(index, value);
        }

        /* access modifiers changed from: private */
        public void addPublicDependency(int value) {
            ensurePublicDependencyIsMutable();
            this.publicDependency_.addInt(value);
        }

        /* access modifiers changed from: private */
        public void addAllPublicDependency(Iterable<? extends Integer> values) {
            ensurePublicDependencyIsMutable();
            AbstractMessageLite.addAll(values, this.publicDependency_);
        }

        /* access modifiers changed from: private */
        public void clearPublicDependency() {
            this.publicDependency_ = emptyIntList();
        }

        public List<Integer> getWeakDependencyList() {
            return this.weakDependency_;
        }

        public int getWeakDependencyCount() {
            return this.weakDependency_.size();
        }

        public int getWeakDependency(int index) {
            return this.weakDependency_.getInt(index);
        }

        private void ensureWeakDependencyIsMutable() {
            if (!this.weakDependency_.isModifiable()) {
                this.weakDependency_ = GeneratedMessageLite.mutableCopy(this.weakDependency_);
            }
        }

        /* access modifiers changed from: private */
        public void setWeakDependency(int index, int value) {
            ensureWeakDependencyIsMutable();
            this.weakDependency_.setInt(index, value);
        }

        /* access modifiers changed from: private */
        public void addWeakDependency(int value) {
            ensureWeakDependencyIsMutable();
            this.weakDependency_.addInt(value);
        }

        /* access modifiers changed from: private */
        public void addAllWeakDependency(Iterable<? extends Integer> values) {
            ensureWeakDependencyIsMutable();
            AbstractMessageLite.addAll(values, this.weakDependency_);
        }

        /* access modifiers changed from: private */
        public void clearWeakDependency() {
            this.weakDependency_ = emptyIntList();
        }

        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        public List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
            return this.messageType_;
        }

        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        public DescriptorProto getMessageType(int index) {
            return (DescriptorProto) this.messageType_.get(index);
        }

        public DescriptorProtoOrBuilder getMessageTypeOrBuilder(int index) {
            return (DescriptorProtoOrBuilder) this.messageType_.get(index);
        }

        private void ensureMessageTypeIsMutable() {
            if (!this.messageType_.isModifiable()) {
                this.messageType_ = GeneratedMessageLite.mutableCopy(this.messageType_);
            }
        }

        /* access modifiers changed from: private */
        public void setMessageType(int index, DescriptorProto value) {
            if (value != null) {
                ensureMessageTypeIsMutable();
                this.messageType_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setMessageType(int index, DescriptorProto.Builder builderForValue) {
            ensureMessageTypeIsMutable();
            this.messageType_.set(index, (DescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addMessageType(DescriptorProto value) {
            if (value != null) {
                ensureMessageTypeIsMutable();
                this.messageType_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addMessageType(int index, DescriptorProto value) {
            if (value != null) {
                ensureMessageTypeIsMutable();
                this.messageType_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addMessageType(DescriptorProto.Builder builderForValue) {
            ensureMessageTypeIsMutable();
            this.messageType_.add((DescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addMessageType(int index, DescriptorProto.Builder builderForValue) {
            ensureMessageTypeIsMutable();
            this.messageType_.add(index, (DescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllMessageType(Iterable<? extends DescriptorProto> values) {
            ensureMessageTypeIsMutable();
            AbstractMessageLite.addAll(values, this.messageType_);
        }

        /* access modifiers changed from: private */
        public void clearMessageType() {
            this.messageType_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeMessageType(int index) {
            ensureMessageTypeIsMutable();
            this.messageType_.remove(index);
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public EnumDescriptorProto getEnumType(int index) {
            return (EnumDescriptorProto) this.enumType_.get(index);
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
            return (EnumDescriptorProtoOrBuilder) this.enumType_.get(index);
        }

        private void ensureEnumTypeIsMutable() {
            if (!this.enumType_.isModifiable()) {
                this.enumType_ = GeneratedMessageLite.mutableCopy(this.enumType_);
            }
        }

        /* access modifiers changed from: private */
        public void setEnumType(int index, EnumDescriptorProto value) {
            if (value != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
            ensureEnumTypeIsMutable();
            this.enumType_.set(index, (EnumDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto value) {
            if (value != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addEnumType(int index, EnumDescriptorProto value) {
            if (value != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto.Builder builderForValue) {
            ensureEnumTypeIsMutable();
            this.enumType_.add((EnumDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
            ensureEnumTypeIsMutable();
            this.enumType_.add(index, (EnumDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
            ensureEnumTypeIsMutable();
            AbstractMessageLite.addAll(values, this.enumType_);
        }

        /* access modifiers changed from: private */
        public void clearEnumType() {
            this.enumType_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeEnumType(int index) {
            ensureEnumTypeIsMutable();
            this.enumType_.remove(index);
        }

        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        public List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
            return this.service_;
        }

        public int getServiceCount() {
            return this.service_.size();
        }

        public ServiceDescriptorProto getService(int index) {
            return (ServiceDescriptorProto) this.service_.get(index);
        }

        public ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int index) {
            return (ServiceDescriptorProtoOrBuilder) this.service_.get(index);
        }

        private void ensureServiceIsMutable() {
            if (!this.service_.isModifiable()) {
                this.service_ = GeneratedMessageLite.mutableCopy(this.service_);
            }
        }

        /* access modifiers changed from: private */
        public void setService(int index, ServiceDescriptorProto value) {
            if (value != null) {
                ensureServiceIsMutable();
                this.service_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setService(int index, ServiceDescriptorProto.Builder builderForValue) {
            ensureServiceIsMutable();
            this.service_.set(index, (ServiceDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addService(ServiceDescriptorProto value) {
            if (value != null) {
                ensureServiceIsMutable();
                this.service_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addService(int index, ServiceDescriptorProto value) {
            if (value != null) {
                ensureServiceIsMutable();
                this.service_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addService(ServiceDescriptorProto.Builder builderForValue) {
            ensureServiceIsMutable();
            this.service_.add((ServiceDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addService(int index, ServiceDescriptorProto.Builder builderForValue) {
            ensureServiceIsMutable();
            this.service_.add(index, (ServiceDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllService(Iterable<? extends ServiceDescriptorProto> values) {
            ensureServiceIsMutable();
            AbstractMessageLite.addAll(values, this.service_);
        }

        /* access modifiers changed from: private */
        public void clearService() {
            this.service_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeService(int index) {
            ensureServiceIsMutable();
            this.service_.remove(index);
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public FieldDescriptorProto getExtension(int index) {
            return (FieldDescriptorProto) this.extension_.get(index);
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
            return (FieldDescriptorProtoOrBuilder) this.extension_.get(index);
        }

        private void ensureExtensionIsMutable() {
            if (!this.extension_.isModifiable()) {
                this.extension_ = GeneratedMessageLite.mutableCopy(this.extension_);
            }
        }

        /* access modifiers changed from: private */
        public void setExtension(int index, FieldDescriptorProto value) {
            if (value != null) {
                ensureExtensionIsMutable();
                this.extension_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setExtension(int index, FieldDescriptorProto.Builder builderForValue) {
            ensureExtensionIsMutable();
            this.extension_.set(index, (FieldDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto value) {
            if (value != null) {
                ensureExtensionIsMutable();
                this.extension_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addExtension(int index, FieldDescriptorProto value) {
            if (value != null) {
                ensureExtensionIsMutable();
                this.extension_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto.Builder builderForValue) {
            ensureExtensionIsMutable();
            this.extension_.add((FieldDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addExtension(int index, FieldDescriptorProto.Builder builderForValue) {
            ensureExtensionIsMutable();
            this.extension_.add(index, (FieldDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
            ensureExtensionIsMutable();
            AbstractMessageLite.addAll(values, this.extension_);
        }

        /* access modifiers changed from: private */
        public void clearExtension() {
            this.extension_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeExtension(int index) {
            ensureExtensionIsMutable();
            this.extension_.remove(index);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        public FileOptions getOptions() {
            FileOptions fileOptions = this.options_;
            return fileOptions == null ? FileOptions.getDefaultInstance() : fileOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(FileOptions value) {
            if (value != null) {
                this.options_ = value;
                this.bitField0_ |= 4;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOptions(FileOptions.Builder builderForValue) {
            this.options_ = (FileOptions) builderForValue.build();
            this.bitField0_ |= 4;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(FileOptions value) {
            FileOptions fileOptions = this.options_;
            if (fileOptions == null || fileOptions == FileOptions.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = (FileOptions) ((FileOptions.Builder) FileOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 4;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        public boolean hasSourceCodeInfo() {
            return (this.bitField0_ & 8) == 8;
        }

        public SourceCodeInfo getSourceCodeInfo() {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            return sourceCodeInfo == null ? SourceCodeInfo.getDefaultInstance() : sourceCodeInfo;
        }

        /* access modifiers changed from: private */
        public void setSourceCodeInfo(SourceCodeInfo value) {
            if (value != null) {
                this.sourceCodeInfo_ = value;
                this.bitField0_ |= 8;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setSourceCodeInfo(SourceCodeInfo.Builder builderForValue) {
            this.sourceCodeInfo_ = (SourceCodeInfo) builderForValue.build();
            this.bitField0_ |= 8;
        }

        /* access modifiers changed from: private */
        public void mergeSourceCodeInfo(SourceCodeInfo value) {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            if (sourceCodeInfo == null || sourceCodeInfo == SourceCodeInfo.getDefaultInstance()) {
                this.sourceCodeInfo_ = value;
            } else {
                this.sourceCodeInfo_ = (SourceCodeInfo) ((SourceCodeInfo.Builder) SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 8;
        }

        /* access modifiers changed from: private */
        public void clearSourceCodeInfo() {
            this.sourceCodeInfo_ = null;
            this.bitField0_ &= -9;
        }

        public boolean hasSyntax() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getSyntax() {
            return this.syntax_;
        }

        public ByteString getSyntaxBytes() {
            return ByteString.copyFromUtf8(this.syntax_);
        }

        /* access modifiers changed from: private */
        public void setSyntax(String value) {
            if (value != null) {
                this.bitField0_ |= 16;
                this.syntax_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearSyntax() {
            this.bitField0_ &= -17;
            this.syntax_ = getDefaultInstance().getSyntax();
        }

        /* access modifiers changed from: private */
        public void setSyntaxBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 16;
                this.syntax_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeString(2, getPackage());
            }
            for (int i = 0; i < this.dependency_.size(); i++) {
                output.writeString(3, (String) this.dependency_.get(i));
            }
            for (int i2 = 0; i2 < this.messageType_.size(); i2++) {
                output.writeMessage(4, (MessageLite) this.messageType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                output.writeMessage(5, (MessageLite) this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.service_.size(); i4++) {
                output.writeMessage(6, (MessageLite) this.service_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                output.writeMessage(7, (MessageLite) this.extension_.get(i5));
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(8, getOptions());
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(9, getSourceCodeInfo());
            }
            for (int i6 = 0; i6 < this.publicDependency_.size(); i6++) {
                output.writeInt32(10, this.publicDependency_.getInt(i6));
            }
            for (int i7 = 0; i7 < this.weakDependency_.size(); i7++) {
                output.writeInt32(11, this.weakDependency_.getInt(i7));
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeString(12, getSyntax());
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
                size2 += CodedOutputStream.computeStringSize(2, getPackage());
            }
            int dataSize = 0;
            for (int i = 0; i < this.dependency_.size(); i++) {
                dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.dependency_.get(i));
            }
            int size3 = size2 + dataSize + (getDependencyList().size() * 1);
            for (int i2 = 0; i2 < this.messageType_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.messageType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.service_.size(); i4++) {
                size3 += CodedOutputStream.computeMessageSize(6, (MessageLite) this.service_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                size3 += CodedOutputStream.computeMessageSize(7, (MessageLite) this.extension_.get(i5));
            }
            if ((this.bitField0_ & 4) == 4) {
                size3 += CodedOutputStream.computeMessageSize(8, getOptions());
            }
            if ((this.bitField0_ & 8) == 8) {
                size3 += CodedOutputStream.computeMessageSize(9, getSourceCodeInfo());
            }
            int dataSize2 = 0;
            for (int i6 = 0; i6 < this.publicDependency_.size(); i6++) {
                dataSize2 += CodedOutputStream.computeInt32SizeNoTag(this.publicDependency_.getInt(i6));
            }
            int size4 = size3 + dataSize2 + (getPublicDependencyList().size() * 1);
            int dataSize3 = 0;
            for (int i7 = 0; i7 < this.weakDependency_.size(); i7++) {
                dataSize3 += CodedOutputStream.computeInt32SizeNoTag(this.weakDependency_.getInt(i7));
            }
            int size5 = size4 + dataSize3 + (getWeakDependencyList().size() * 1);
            if ((this.bitField0_ & 16) == 16) {
                size5 += CodedOutputStream.computeStringSize(12, getSyntax());
            }
            int size6 = size5 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size6;
            return size6;
        }

        public static FileDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FileDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FileDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FileDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FileDescriptorProto parseFrom(InputStream input) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FileDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return (FileDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FileDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FileDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FileDescriptorProto prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(FileDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((FileDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((FileDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((FileDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setNameBytes(value);
                return this;
            }

            public boolean hasPackage() {
                return ((FileDescriptorProto) this.instance).hasPackage();
            }

            public String getPackage() {
                return ((FileDescriptorProto) this.instance).getPackage();
            }

            public ByteString getPackageBytes() {
                return ((FileDescriptorProto) this.instance).getPackageBytes();
            }

            public Builder setPackage(String value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setPackage(value);
                return this;
            }

            public Builder clearPackage() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearPackage();
                return this;
            }

            public Builder setPackageBytes(ByteString value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setPackageBytes(value);
                return this;
            }

            public List<String> getDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getDependencyList());
            }

            public int getDependencyCount() {
                return ((FileDescriptorProto) this.instance).getDependencyCount();
            }

            public String getDependency(int index) {
                return ((FileDescriptorProto) this.instance).getDependency(index);
            }

            public ByteString getDependencyBytes(int index) {
                return ((FileDescriptorProto) this.instance).getDependencyBytes(index);
            }

            public Builder setDependency(int index, String value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setDependency(index, value);
                return this;
            }

            public Builder addDependency(String value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addDependency(value);
                return this;
            }

            public Builder addAllDependency(Iterable<String> values) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllDependency(values);
                return this;
            }

            public Builder clearDependency() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearDependency();
                return this;
            }

            public Builder addDependencyBytes(ByteString value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addDependencyBytes(value);
                return this;
            }

            public List<Integer> getPublicDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getPublicDependencyList());
            }

            public int getPublicDependencyCount() {
                return ((FileDescriptorProto) this.instance).getPublicDependencyCount();
            }

            public int getPublicDependency(int index) {
                return ((FileDescriptorProto) this.instance).getPublicDependency(index);
            }

            public Builder setPublicDependency(int index, int value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setPublicDependency(index, value);
                return this;
            }

            public Builder addPublicDependency(int value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addPublicDependency(value);
                return this;
            }

            public Builder addAllPublicDependency(Iterable<? extends Integer> values) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllPublicDependency(values);
                return this;
            }

            public Builder clearPublicDependency() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearPublicDependency();
                return this;
            }

            public List<Integer> getWeakDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getWeakDependencyList());
            }

            public int getWeakDependencyCount() {
                return ((FileDescriptorProto) this.instance).getWeakDependencyCount();
            }

            public int getWeakDependency(int index) {
                return ((FileDescriptorProto) this.instance).getWeakDependency(index);
            }

            public Builder setWeakDependency(int index, int value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setWeakDependency(index, value);
                return this;
            }

            public Builder addWeakDependency(int value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addWeakDependency(value);
                return this;
            }

            public Builder addAllWeakDependency(Iterable<? extends Integer> values) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllWeakDependency(values);
                return this;
            }

            public Builder clearWeakDependency() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearWeakDependency();
                return this;
            }

            public List<DescriptorProto> getMessageTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getMessageTypeList());
            }

            public int getMessageTypeCount() {
                return ((FileDescriptorProto) this.instance).getMessageTypeCount();
            }

            public DescriptorProto getMessageType(int index) {
                return ((FileDescriptorProto) this.instance).getMessageType(index);
            }

            public Builder setMessageType(int index, DescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setMessageType(index, value);
                return this;
            }

            public Builder setMessageType(int index, DescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setMessageType(index, builderForValue);
                return this;
            }

            public Builder addMessageType(DescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(value);
                return this;
            }

            public Builder addMessageType(int index, DescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(index, value);
                return this;
            }

            public Builder addMessageType(DescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(builderForValue);
                return this;
            }

            public Builder addMessageType(int index, DescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(index, builderForValue);
                return this;
            }

            public Builder addAllMessageType(Iterable<? extends DescriptorProto> values) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllMessageType(values);
                return this;
            }

            public Builder clearMessageType() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearMessageType();
                return this;
            }

            public Builder removeMessageType(int index) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeMessageType(index);
                return this;
            }

            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getEnumTypeList());
            }

            public int getEnumTypeCount() {
                return ((FileDescriptorProto) this.instance).getEnumTypeCount();
            }

            public EnumDescriptorProto getEnumType(int index) {
                return ((FileDescriptorProto) this.instance).getEnumType(index);
            }

            public Builder setEnumType(int index, EnumDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setEnumType(index, value);
                return this;
            }

            public Builder setEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setEnumType(index, builderForValue);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(value);
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(index, value);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(builderForValue);
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(index, builderForValue);
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllEnumType(values);
                return this;
            }

            public Builder clearEnumType() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearEnumType();
                return this;
            }

            public Builder removeEnumType(int index) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeEnumType(index);
                return this;
            }

            public List<ServiceDescriptorProto> getServiceList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getServiceList());
            }

            public int getServiceCount() {
                return ((FileDescriptorProto) this.instance).getServiceCount();
            }

            public ServiceDescriptorProto getService(int index) {
                return ((FileDescriptorProto) this.instance).getService(index);
            }

            public Builder setService(int index, ServiceDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setService(index, value);
                return this;
            }

            public Builder setService(int index, ServiceDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setService(index, builderForValue);
                return this;
            }

            public Builder addService(ServiceDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(value);
                return this;
            }

            public Builder addService(int index, ServiceDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(index, value);
                return this;
            }

            public Builder addService(ServiceDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(builderForValue);
                return this;
            }

            public Builder addService(int index, ServiceDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(index, builderForValue);
                return this;
            }

            public Builder addAllService(Iterable<? extends ServiceDescriptorProto> values) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllService(values);
                return this;
            }

            public Builder clearService() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearService();
                return this;
            }

            public Builder removeService(int index) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeService(index);
                return this;
            }

            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getExtensionList());
            }

            public int getExtensionCount() {
                return ((FileDescriptorProto) this.instance).getExtensionCount();
            }

            public FieldDescriptorProto getExtension(int index) {
                return ((FileDescriptorProto) this.instance).getExtension(index);
            }

            public Builder setExtension(int index, FieldDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setExtension(index, value);
                return this;
            }

            public Builder setExtension(int index, FieldDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setExtension(index, builderForValue);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(value);
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(index, value);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(builderForValue);
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(index, builderForValue);
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllExtension(values);
                return this;
            }

            public Builder clearExtension() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearExtension();
                return this;
            }

            public Builder removeExtension(int index) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeExtension(index);
                return this;
            }

            public boolean hasOptions() {
                return ((FileDescriptorProto) this.instance).hasOptions();
            }

            public FileOptions getOptions() {
                return ((FileDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(FileOptions value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(FileOptions.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setOptions(builderForValue);
                return this;
            }

            public Builder mergeOptions(FileOptions value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearOptions();
                return this;
            }

            public boolean hasSourceCodeInfo() {
                return ((FileDescriptorProto) this.instance).hasSourceCodeInfo();
            }

            public SourceCodeInfo getSourceCodeInfo() {
                return ((FileDescriptorProto) this.instance).getSourceCodeInfo();
            }

            public Builder setSourceCodeInfo(SourceCodeInfo value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSourceCodeInfo(value);
                return this;
            }

            public Builder setSourceCodeInfo(SourceCodeInfo.Builder builderForValue) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSourceCodeInfo(builderForValue);
                return this;
            }

            public Builder mergeSourceCodeInfo(SourceCodeInfo value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).mergeSourceCodeInfo(value);
                return this;
            }

            public Builder clearSourceCodeInfo() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearSourceCodeInfo();
                return this;
            }

            public boolean hasSyntax() {
                return ((FileDescriptorProto) this.instance).hasSyntax();
            }

            public String getSyntax() {
                return ((FileDescriptorProto) this.instance).getSyntax();
            }

            public ByteString getSyntaxBytes() {
                return ((FileDescriptorProto) this.instance).getSyntaxBytes();
            }

            public Builder setSyntax(String value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSyntax(value);
                return this;
            }

            public Builder clearSyntax() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearSyntax();
                return this;
            }

            public Builder setSyntaxBytes(ByteString value) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSyntaxBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new FileDescriptorProto();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getMessageTypeCount(); i++) {
                        if (!getMessageType(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i2 = 0; i2 < getEnumTypeCount(); i2++) {
                        if (!getEnumType(i2).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i3 = 0; i3 < getServiceCount(); i3++) {
                        if (!getService(i3).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i4 = 0; i4 < getExtensionCount(); i4++) {
                        if (!getExtension(i4).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (hasOptions() == 0 || getOptions().isInitialized()) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case 3:
                    this.dependency_.makeImmutable();
                    this.publicDependency_.makeImmutable();
                    this.weakDependency_.makeImmutable();
                    this.messageType_.makeImmutable();
                    this.enumType_.makeImmutable();
                    this.service_.makeImmutable();
                    this.extension_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    FileDescriptorProto other = (FileDescriptorProto) arg1;
                    this.name_ = visitor.visitString(hasName(), this.name_, other.hasName(), other.name_);
                    this.package_ = visitor.visitString(hasPackage(), this.package_, other.hasPackage(), other.package_);
                    this.dependency_ = visitor.visitList(this.dependency_, other.dependency_);
                    this.publicDependency_ = visitor.visitIntList(this.publicDependency_, other.publicDependency_);
                    this.weakDependency_ = visitor.visitIntList(this.weakDependency_, other.weakDependency_);
                    this.messageType_ = visitor.visitList(this.messageType_, other.messageType_);
                    this.enumType_ = visitor.visitList(this.enumType_, other.enumType_);
                    this.service_ = visitor.visitList(this.service_, other.service_);
                    this.extension_ = visitor.visitList(this.extension_, other.extension_);
                    this.options_ = (FileOptions) visitor.visitMessage(this.options_, other.options_);
                    this.sourceCodeInfo_ = (SourceCodeInfo) visitor.visitMessage(this.sourceCodeInfo_, other.sourceCodeInfo_);
                    this.syntax_ = visitor.visitString(hasSyntax(), this.syntax_, other.hasSyntax(), other.syntax_);
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
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 10:
                                    String s = input.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = s;
                                    break;
                                case 18:
                                    String s2 = input.readString();
                                    this.bitField0_ |= 2;
                                    this.package_ = s2;
                                    break;
                                case 26:
                                    String s3 = input.readString();
                                    if (!this.dependency_.isModifiable()) {
                                        this.dependency_ = GeneratedMessageLite.mutableCopy(this.dependency_);
                                    }
                                    this.dependency_.add(s3);
                                    break;
                                case 34:
                                    if (!this.messageType_.isModifiable()) {
                                        this.messageType_ = GeneratedMessageLite.mutableCopy(this.messageType_);
                                    }
                                    this.messageType_.add((DescriptorProto) input.readMessage(DescriptorProto.parser(), extensionRegistry));
                                    break;
                                case 42:
                                    if (!this.enumType_.isModifiable()) {
                                        this.enumType_ = GeneratedMessageLite.mutableCopy(this.enumType_);
                                    }
                                    this.enumType_.add((EnumDescriptorProto) input.readMessage(EnumDescriptorProto.parser(), extensionRegistry));
                                    break;
                                case 50:
                                    if (!this.service_.isModifiable()) {
                                        this.service_ = GeneratedMessageLite.mutableCopy(this.service_);
                                    }
                                    this.service_.add((ServiceDescriptorProto) input.readMessage(ServiceDescriptorProto.parser(), extensionRegistry));
                                    break;
                                case 58:
                                    if (!this.extension_.isModifiable()) {
                                        this.extension_ = GeneratedMessageLite.mutableCopy(this.extension_);
                                    }
                                    this.extension_.add((FieldDescriptorProto) input.readMessage(FieldDescriptorProto.parser(), extensionRegistry));
                                    break;
                                case 66:
                                    FileOptions.Builder subBuilder = null;
                                    if ((this.bitField0_ & 4) == 4) {
                                        subBuilder = (FileOptions.Builder) this.options_.toBuilder();
                                    }
                                    FileOptions fileOptions = (FileOptions) input.readMessage(FileOptions.parser(), extensionRegistry);
                                    this.options_ = fileOptions;
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom(fileOptions);
                                        this.options_ = (FileOptions) subBuilder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                    break;
                                case 74:
                                    SourceCodeInfo.Builder subBuilder2 = null;
                                    if ((this.bitField0_ & 8) == 8) {
                                        subBuilder2 = (SourceCodeInfo.Builder) this.sourceCodeInfo_.toBuilder();
                                    }
                                    SourceCodeInfo sourceCodeInfo = (SourceCodeInfo) input.readMessage(SourceCodeInfo.parser(), extensionRegistry);
                                    this.sourceCodeInfo_ = sourceCodeInfo;
                                    if (subBuilder2 != null) {
                                        subBuilder2.mergeFrom(sourceCodeInfo);
                                        this.sourceCodeInfo_ = (SourceCodeInfo) subBuilder2.buildPartial();
                                    }
                                    this.bitField0_ |= 8;
                                    break;
                                case 80:
                                    if (!this.publicDependency_.isModifiable()) {
                                        this.publicDependency_ = GeneratedMessageLite.mutableCopy(this.publicDependency_);
                                    }
                                    this.publicDependency_.addInt(input.readInt32());
                                    break;
                                case 82:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if (!this.publicDependency_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                        this.publicDependency_ = GeneratedMessageLite.mutableCopy(this.publicDependency_);
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.publicDependency_.addInt(input.readInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 88:
                                    if (!this.weakDependency_.isModifiable()) {
                                        this.weakDependency_ = GeneratedMessageLite.mutableCopy(this.weakDependency_);
                                    }
                                    this.weakDependency_.addInt(input.readInt32());
                                    break;
                                case 90:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if (!this.weakDependency_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                        this.weakDependency_ = GeneratedMessageLite.mutableCopy(this.weakDependency_);
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.weakDependency_.addInt(input.readInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 98:
                                    String s4 = input.readString();
                                    this.bitField0_ |= 16;
                                    this.syntax_ = s4;
                                    break;
                                default:
                                    if (parseUnknownField(tag, input)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
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
                        synchronized (FileDescriptorProto.class) {
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
            FileDescriptorProto fileDescriptorProto = new FileDescriptorProto();
            DEFAULT_INSTANCE = fileDescriptorProto;
            fileDescriptorProto.makeImmutable();
        }

        public static FileDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class DescriptorProto extends GeneratedMessageLite<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final DescriptorProto DEFAULT_INSTANCE;
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int ONEOF_DECL_FIELD_NUMBER = 8;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static volatile Parser<DescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 10;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
        private int bitField0_;
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = emptyProtobufList();
        private Internal.ProtobufList<ExtensionRange> extensionRange_ = emptyProtobufList();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = emptyProtobufList();
        private Internal.ProtobufList<FieldDescriptorProto> field_ = emptyProtobufList();
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private Internal.ProtobufList<DescriptorProto> nestedType_ = emptyProtobufList();
        private Internal.ProtobufList<OneofDescriptorProto> oneofDecl_ = emptyProtobufList();
        private MessageOptions options_;
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<ReservedRange> reservedRange_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface ExtensionRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            ExtensionRangeOptions getOptions();

            int getStart();

            boolean hasEnd();

            boolean hasOptions();

            boolean hasStart();
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface ReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        private DescriptorProto() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class ExtensionRange extends GeneratedMessageLite<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
            /* access modifiers changed from: private */
            public static final ExtensionRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            public static final int OPTIONS_FIELD_NUMBER = 3;
            private static volatile Parser<ExtensionRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized = -1;
            private ExtensionRangeOptions options_;
            private int start_;

            private ExtensionRange() {
            }

            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getStart() {
                return this.start_;
            }

            /* access modifiers changed from: private */
            public void setStart(int value) {
                this.bitField0_ |= 1;
                this.start_ = value;
            }

            /* access modifiers changed from: private */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getEnd() {
                return this.end_;
            }

            /* access modifiers changed from: private */
            public void setEnd(int value) {
                this.bitField0_ |= 2;
                this.end_ = value;
            }

            /* access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            public boolean hasOptions() {
                return (this.bitField0_ & 4) == 4;
            }

            public ExtensionRangeOptions getOptions() {
                ExtensionRangeOptions extensionRangeOptions = this.options_;
                return extensionRangeOptions == null ? ExtensionRangeOptions.getDefaultInstance() : extensionRangeOptions;
            }

            /* access modifiers changed from: private */
            public void setOptions(ExtensionRangeOptions value) {
                if (value != null) {
                    this.options_ = value;
                    this.bitField0_ |= 4;
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void setOptions(ExtensionRangeOptions.Builder builderForValue) {
                this.options_ = (ExtensionRangeOptions) builderForValue.build();
                this.bitField0_ |= 4;
            }

            /* access modifiers changed from: private */
            public void mergeOptions(ExtensionRangeOptions value) {
                ExtensionRangeOptions extensionRangeOptions = this.options_;
                if (extensionRangeOptions == null || extensionRangeOptions == ExtensionRangeOptions.getDefaultInstance()) {
                    this.options_ = value;
                } else {
                    this.options_ = (ExtensionRangeOptions) ((ExtensionRangeOptions.Builder) ExtensionRangeOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
                }
                this.bitField0_ |= 4;
            }

            /* access modifiers changed from: private */
            public void clearOptions() {
                this.options_ = null;
                this.bitField0_ &= -5;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    output.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeInt32(2, this.end_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    output.writeMessage(3, getOptions());
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
                    size2 = 0 + CodedOutputStream.computeInt32Size(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    size2 += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    size2 += CodedOutputStream.computeMessageSize(3, getOptions());
                }
                int size3 = size2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size3;
                return size3;
            }

            public static ExtensionRange parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static ExtensionRange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static ExtensionRange parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static ExtensionRange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static ExtensionRange parseFrom(InputStream input) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static ExtensionRange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static ExtensionRange parseDelimitedFrom(InputStream input) throws IOException {
                return (ExtensionRange) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static ExtensionRange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ExtensionRange) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static ExtensionRange parseFrom(CodedInputStream input) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static ExtensionRange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(ExtensionRange prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(ExtensionRange.DEFAULT_INSTANCE);
                }

                public boolean hasStart() {
                    return ((ExtensionRange) this.instance).hasStart();
                }

                public int getStart() {
                    return ((ExtensionRange) this.instance).getStart();
                }

                public Builder setStart(int value) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setStart(value);
                    return this;
                }

                public Builder clearStart() {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).clearStart();
                    return this;
                }

                public boolean hasEnd() {
                    return ((ExtensionRange) this.instance).hasEnd();
                }

                public int getEnd() {
                    return ((ExtensionRange) this.instance).getEnd();
                }

                public Builder setEnd(int value) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setEnd(value);
                    return this;
                }

                public Builder clearEnd() {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).clearEnd();
                    return this;
                }

                public boolean hasOptions() {
                    return ((ExtensionRange) this.instance).hasOptions();
                }

                public ExtensionRangeOptions getOptions() {
                    return ((ExtensionRange) this.instance).getOptions();
                }

                public Builder setOptions(ExtensionRangeOptions value) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setOptions(value);
                    return this;
                }

                public Builder setOptions(ExtensionRangeOptions.Builder builderForValue) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setOptions(builderForValue);
                    return this;
                }

                public Builder mergeOptions(ExtensionRangeOptions value) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).mergeOptions(value);
                    return this;
                }

                public Builder clearOptions() {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).clearOptions();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new ExtensionRange();
                    case 2:
                        byte isInitialized = this.memoizedIsInitialized;
                        if (isInitialized == 1) {
                            return DEFAULT_INSTANCE;
                        }
                        if (isInitialized == 0) {
                            return null;
                        }
                        boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                        if (!hasOptions() || getOptions().isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 1;
                            }
                            return DEFAULT_INSTANCE;
                        }
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    case 3:
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                        ExtensionRange other = (ExtensionRange) arg1;
                        this.start_ = visitor.visitInt(hasStart(), this.start_, other.hasStart(), other.start_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, other.hasEnd(), other.end_);
                        this.options_ = (ExtensionRangeOptions) visitor.visitMessage(this.options_, other.options_);
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
                                } else if (tag == 8) {
                                    this.bitField0_ |= 1;
                                    this.start_ = input.readInt32();
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.end_ = input.readInt32();
                                } else if (tag == 26) {
                                    ExtensionRangeOptions.Builder subBuilder = null;
                                    if ((this.bitField0_ & 4) == 4) {
                                        subBuilder = (ExtensionRangeOptions.Builder) this.options_.toBuilder();
                                    }
                                    ExtensionRangeOptions extensionRangeOptions = (ExtensionRangeOptions) input.readMessage(ExtensionRangeOptions.parser(), extensionRegistry);
                                    this.options_ = extensionRangeOptions;
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom(extensionRangeOptions);
                                        this.options_ = (ExtensionRangeOptions) subBuilder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
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
                            synchronized (ExtensionRange.class) {
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
                ExtensionRange extensionRange = new ExtensionRange();
                DEFAULT_INSTANCE = extensionRange;
                extensionRange.makeImmutable();
            }

            public static ExtensionRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ExtensionRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class ReservedRange extends GeneratedMessageLite<ReservedRange, Builder> implements ReservedRangeOrBuilder {
            /* access modifiers changed from: private */
            public static final ReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<ReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            private ReservedRange() {
            }

            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getStart() {
                return this.start_;
            }

            /* access modifiers changed from: private */
            public void setStart(int value) {
                this.bitField0_ |= 1;
                this.start_ = value;
            }

            /* access modifiers changed from: private */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getEnd() {
                return this.end_;
            }

            /* access modifiers changed from: private */
            public void setEnd(int value) {
                this.bitField0_ |= 2;
                this.end_ = value;
            }

            /* access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    output.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeInt32(2, this.end_);
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
                    size2 = 0 + CodedOutputStream.computeInt32Size(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    size2 += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                int size3 = size2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size3;
                return size3;
            }

            public static ReservedRange parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static ReservedRange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static ReservedRange parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static ReservedRange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static ReservedRange parseFrom(InputStream input) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static ReservedRange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static ReservedRange parseDelimitedFrom(InputStream input) throws IOException {
                return (ReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static ReservedRange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static ReservedRange parseFrom(CodedInputStream input) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static ReservedRange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(ReservedRange prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<ReservedRange, Builder> implements ReservedRangeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(ReservedRange.DEFAULT_INSTANCE);
                }

                public boolean hasStart() {
                    return ((ReservedRange) this.instance).hasStart();
                }

                public int getStart() {
                    return ((ReservedRange) this.instance).getStart();
                }

                public Builder setStart(int value) {
                    copyOnWrite();
                    ((ReservedRange) this.instance).setStart(value);
                    return this;
                }

                public Builder clearStart() {
                    copyOnWrite();
                    ((ReservedRange) this.instance).clearStart();
                    return this;
                }

                public boolean hasEnd() {
                    return ((ReservedRange) this.instance).hasEnd();
                }

                public int getEnd() {
                    return ((ReservedRange) this.instance).getEnd();
                }

                public Builder setEnd(int value) {
                    copyOnWrite();
                    ((ReservedRange) this.instance).setEnd(value);
                    return this;
                }

                public Builder clearEnd() {
                    copyOnWrite();
                    ((ReservedRange) this.instance).clearEnd();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new ReservedRange();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                        ReservedRange other = (ReservedRange) arg1;
                        this.start_ = visitor.visitInt(hasStart(), this.start_, other.hasStart(), other.start_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, other.hasEnd(), other.end_);
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
                                    this.start_ = input.readInt32();
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.end_ = input.readInt32();
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
                            synchronized (ReservedRange.class) {
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
                ReservedRange reservedRange = new ReservedRange();
                DEFAULT_INSTANCE = reservedRange;
                reservedRange.makeImmutable();
            }

            public static ReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
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

        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
            return this.field_;
        }

        public int getFieldCount() {
            return this.field_.size();
        }

        public FieldDescriptorProto getField(int index) {
            return (FieldDescriptorProto) this.field_.get(index);
        }

        public FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index) {
            return (FieldDescriptorProtoOrBuilder) this.field_.get(index);
        }

        private void ensureFieldIsMutable() {
            if (!this.field_.isModifiable()) {
                this.field_ = GeneratedMessageLite.mutableCopy(this.field_);
            }
        }

        /* access modifiers changed from: private */
        public void setField(int index, FieldDescriptorProto value) {
            if (value != null) {
                ensureFieldIsMutable();
                this.field_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setField(int index, FieldDescriptorProto.Builder builderForValue) {
            ensureFieldIsMutable();
            this.field_.set(index, (FieldDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addField(FieldDescriptorProto value) {
            if (value != null) {
                ensureFieldIsMutable();
                this.field_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addField(int index, FieldDescriptorProto value) {
            if (value != null) {
                ensureFieldIsMutable();
                this.field_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addField(FieldDescriptorProto.Builder builderForValue) {
            ensureFieldIsMutable();
            this.field_.add((FieldDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addField(int index, FieldDescriptorProto.Builder builderForValue) {
            ensureFieldIsMutable();
            this.field_.add(index, (FieldDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllField(Iterable<? extends FieldDescriptorProto> values) {
            ensureFieldIsMutable();
            AbstractMessageLite.addAll(values, this.field_);
        }

        /* access modifiers changed from: private */
        public void clearField() {
            this.field_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeField(int index) {
            ensureFieldIsMutable();
            this.field_.remove(index);
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public FieldDescriptorProto getExtension(int index) {
            return (FieldDescriptorProto) this.extension_.get(index);
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
            return (FieldDescriptorProtoOrBuilder) this.extension_.get(index);
        }

        private void ensureExtensionIsMutable() {
            if (!this.extension_.isModifiable()) {
                this.extension_ = GeneratedMessageLite.mutableCopy(this.extension_);
            }
        }

        /* access modifiers changed from: private */
        public void setExtension(int index, FieldDescriptorProto value) {
            if (value != null) {
                ensureExtensionIsMutable();
                this.extension_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setExtension(int index, FieldDescriptorProto.Builder builderForValue) {
            ensureExtensionIsMutable();
            this.extension_.set(index, (FieldDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto value) {
            if (value != null) {
                ensureExtensionIsMutable();
                this.extension_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addExtension(int index, FieldDescriptorProto value) {
            if (value != null) {
                ensureExtensionIsMutable();
                this.extension_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto.Builder builderForValue) {
            ensureExtensionIsMutable();
            this.extension_.add((FieldDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addExtension(int index, FieldDescriptorProto.Builder builderForValue) {
            ensureExtensionIsMutable();
            this.extension_.add(index, (FieldDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
            ensureExtensionIsMutable();
            AbstractMessageLite.addAll(values, this.extension_);
        }

        /* access modifiers changed from: private */
        public void clearExtension() {
            this.extension_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeExtension(int index) {
            ensureExtensionIsMutable();
            this.extension_.remove(index);
        }

        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        public List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
            return this.nestedType_;
        }

        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        public DescriptorProto getNestedType(int index) {
            return (DescriptorProto) this.nestedType_.get(index);
        }

        public DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index) {
            return (DescriptorProtoOrBuilder) this.nestedType_.get(index);
        }

        private void ensureNestedTypeIsMutable() {
            if (!this.nestedType_.isModifiable()) {
                this.nestedType_ = GeneratedMessageLite.mutableCopy(this.nestedType_);
            }
        }

        /* access modifiers changed from: private */
        public void setNestedType(int index, DescriptorProto value) {
            if (value != null) {
                ensureNestedTypeIsMutable();
                this.nestedType_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setNestedType(int index, Builder builderForValue) {
            ensureNestedTypeIsMutable();
            this.nestedType_.set(index, (DescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addNestedType(DescriptorProto value) {
            if (value != null) {
                ensureNestedTypeIsMutable();
                this.nestedType_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addNestedType(int index, DescriptorProto value) {
            if (value != null) {
                ensureNestedTypeIsMutable();
                this.nestedType_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addNestedType(Builder builderForValue) {
            ensureNestedTypeIsMutable();
            this.nestedType_.add((DescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addNestedType(int index, Builder builderForValue) {
            ensureNestedTypeIsMutable();
            this.nestedType_.add(index, (DescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllNestedType(Iterable<? extends DescriptorProto> values) {
            ensureNestedTypeIsMutable();
            AbstractMessageLite.addAll(values, this.nestedType_);
        }

        /* access modifiers changed from: private */
        public void clearNestedType() {
            this.nestedType_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeNestedType(int index) {
            ensureNestedTypeIsMutable();
            this.nestedType_.remove(index);
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public EnumDescriptorProto getEnumType(int index) {
            return (EnumDescriptorProto) this.enumType_.get(index);
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
            return (EnumDescriptorProtoOrBuilder) this.enumType_.get(index);
        }

        private void ensureEnumTypeIsMutable() {
            if (!this.enumType_.isModifiable()) {
                this.enumType_ = GeneratedMessageLite.mutableCopy(this.enumType_);
            }
        }

        /* access modifiers changed from: private */
        public void setEnumType(int index, EnumDescriptorProto value) {
            if (value != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
            ensureEnumTypeIsMutable();
            this.enumType_.set(index, (EnumDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto value) {
            if (value != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addEnumType(int index, EnumDescriptorProto value) {
            if (value != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto.Builder builderForValue) {
            ensureEnumTypeIsMutable();
            this.enumType_.add((EnumDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
            ensureEnumTypeIsMutable();
            this.enumType_.add(index, (EnumDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
            ensureEnumTypeIsMutable();
            AbstractMessageLite.addAll(values, this.enumType_);
        }

        /* access modifiers changed from: private */
        public void clearEnumType() {
            this.enumType_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeEnumType(int index) {
            ensureEnumTypeIsMutable();
            this.enumType_.remove(index);
        }

        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
            return this.extensionRange_;
        }

        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        public ExtensionRange getExtensionRange(int index) {
            return (ExtensionRange) this.extensionRange_.get(index);
        }

        public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index) {
            return (ExtensionRangeOrBuilder) this.extensionRange_.get(index);
        }

        private void ensureExtensionRangeIsMutable() {
            if (!this.extensionRange_.isModifiable()) {
                this.extensionRange_ = GeneratedMessageLite.mutableCopy(this.extensionRange_);
            }
        }

        /* access modifiers changed from: private */
        public void setExtensionRange(int index, ExtensionRange value) {
            if (value != null) {
                ensureExtensionRangeIsMutable();
                this.extensionRange_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setExtensionRange(int index, ExtensionRange.Builder builderForValue) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.set(index, (ExtensionRange) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addExtensionRange(ExtensionRange value) {
            if (value != null) {
                ensureExtensionRangeIsMutable();
                this.extensionRange_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addExtensionRange(int index, ExtensionRange value) {
            if (value != null) {
                ensureExtensionRangeIsMutable();
                this.extensionRange_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addExtensionRange(ExtensionRange.Builder builderForValue) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add((ExtensionRange) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addExtensionRange(int index, ExtensionRange.Builder builderForValue) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add(index, (ExtensionRange) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllExtensionRange(Iterable<? extends ExtensionRange> values) {
            ensureExtensionRangeIsMutable();
            AbstractMessageLite.addAll(values, this.extensionRange_);
        }

        /* access modifiers changed from: private */
        public void clearExtensionRange() {
            this.extensionRange_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeExtensionRange(int index) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.remove(index);
        }

        public List<OneofDescriptorProto> getOneofDeclList() {
            return this.oneofDecl_;
        }

        public List<? extends OneofDescriptorProtoOrBuilder> getOneofDeclOrBuilderList() {
            return this.oneofDecl_;
        }

        public int getOneofDeclCount() {
            return this.oneofDecl_.size();
        }

        public OneofDescriptorProto getOneofDecl(int index) {
            return (OneofDescriptorProto) this.oneofDecl_.get(index);
        }

        public OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int index) {
            return (OneofDescriptorProtoOrBuilder) this.oneofDecl_.get(index);
        }

        private void ensureOneofDeclIsMutable() {
            if (!this.oneofDecl_.isModifiable()) {
                this.oneofDecl_ = GeneratedMessageLite.mutableCopy(this.oneofDecl_);
            }
        }

        /* access modifiers changed from: private */
        public void setOneofDecl(int index, OneofDescriptorProto value) {
            if (value != null) {
                ensureOneofDeclIsMutable();
                this.oneofDecl_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOneofDecl(int index, OneofDescriptorProto.Builder builderForValue) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.set(index, (OneofDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addOneofDecl(OneofDescriptorProto value) {
            if (value != null) {
                ensureOneofDeclIsMutable();
                this.oneofDecl_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addOneofDecl(int index, OneofDescriptorProto value) {
            if (value != null) {
                ensureOneofDeclIsMutable();
                this.oneofDecl_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addOneofDecl(OneofDescriptorProto.Builder builderForValue) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add((OneofDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addOneofDecl(int index, OneofDescriptorProto.Builder builderForValue) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add(index, (OneofDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllOneofDecl(Iterable<? extends OneofDescriptorProto> values) {
            ensureOneofDeclIsMutable();
            AbstractMessageLite.addAll(values, this.oneofDecl_);
        }

        /* access modifiers changed from: private */
        public void clearOneofDecl() {
            this.oneofDecl_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeOneofDecl(int index) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.remove(index);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        public MessageOptions getOptions() {
            MessageOptions messageOptions = this.options_;
            return messageOptions == null ? MessageOptions.getDefaultInstance() : messageOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(MessageOptions value) {
            if (value != null) {
                this.options_ = value;
                this.bitField0_ |= 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOptions(MessageOptions.Builder builderForValue) {
            this.options_ = (MessageOptions) builderForValue.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(MessageOptions value) {
            MessageOptions messageOptions = this.options_;
            if (messageOptions == null || messageOptions == MessageOptions.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = (MessageOptions) ((MessageOptions.Builder) MessageOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public List<ReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public List<? extends ReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        public ReservedRange getReservedRange(int index) {
            return (ReservedRange) this.reservedRange_.get(index);
        }

        public ReservedRangeOrBuilder getReservedRangeOrBuilder(int index) {
            return (ReservedRangeOrBuilder) this.reservedRange_.get(index);
        }

        private void ensureReservedRangeIsMutable() {
            if (!this.reservedRange_.isModifiable()) {
                this.reservedRange_ = GeneratedMessageLite.mutableCopy(this.reservedRange_);
            }
        }

        /* access modifiers changed from: private */
        public void setReservedRange(int index, ReservedRange value) {
            if (value != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setReservedRange(int index, ReservedRange.Builder builderForValue) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(index, (ReservedRange) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addReservedRange(ReservedRange value) {
            if (value != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addReservedRange(int index, ReservedRange value) {
            if (value != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addReservedRange(ReservedRange.Builder builderForValue) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add((ReservedRange) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addReservedRange(int index, ReservedRange.Builder builderForValue) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(index, (ReservedRange) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllReservedRange(Iterable<? extends ReservedRange> values) {
            ensureReservedRangeIsMutable();
            AbstractMessageLite.addAll(values, this.reservedRange_);
        }

        /* access modifiers changed from: private */
        public void clearReservedRange() {
            this.reservedRange_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeReservedRange(int index) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.remove(index);
        }

        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        public String getReservedName(int index) {
            return (String) this.reservedName_.get(index);
        }

        public ByteString getReservedNameBytes(int index) {
            return ByteString.copyFromUtf8((String) this.reservedName_.get(index));
        }

        private void ensureReservedNameIsMutable() {
            if (!this.reservedName_.isModifiable()) {
                this.reservedName_ = GeneratedMessageLite.mutableCopy(this.reservedName_);
            }
        }

        /* access modifiers changed from: private */
        public void setReservedName(int index, String value) {
            if (value != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addReservedName(String value) {
            if (value != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addAllReservedName(Iterable<String> values) {
            ensureReservedNameIsMutable();
            AbstractMessageLite.addAll(values, this.reservedName_);
        }

        /* access modifiers changed from: private */
        public void clearReservedName() {
            this.reservedName_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addReservedNameBytes(ByteString value) {
            if (value != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.add(value.toStringUtf8());
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getName());
            }
            for (int i = 0; i < this.field_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.field_.get(i));
            }
            for (int i2 = 0; i2 < this.nestedType_.size(); i2++) {
                output.writeMessage(3, (MessageLite) this.nestedType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                output.writeMessage(4, (MessageLite) this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.extensionRange_.size(); i4++) {
                output.writeMessage(5, (MessageLite) this.extensionRange_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                output.writeMessage(6, (MessageLite) this.extension_.get(i5));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(7, getOptions());
            }
            for (int i6 = 0; i6 < this.oneofDecl_.size(); i6++) {
                output.writeMessage(8, (MessageLite) this.oneofDecl_.get(i6));
            }
            for (int i7 = 0; i7 < this.reservedRange_.size(); i7++) {
                output.writeMessage(9, (MessageLite) this.reservedRange_.get(i7));
            }
            for (int i8 = 0; i8 < this.reservedName_.size(); i8++) {
                output.writeString(10, (String) this.reservedName_.get(i8));
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
            for (int i = 0; i < this.field_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.field_.get(i));
            }
            for (int i2 = 0; i2 < this.nestedType_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.nestedType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.extensionRange_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.extensionRange_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                size2 += CodedOutputStream.computeMessageSize(6, (MessageLite) this.extension_.get(i5));
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeMessageSize(7, getOptions());
            }
            for (int i6 = 0; i6 < this.oneofDecl_.size(); i6++) {
                size2 += CodedOutputStream.computeMessageSize(8, (MessageLite) this.oneofDecl_.get(i6));
            }
            for (int i7 = 0; i7 < this.reservedRange_.size(); i7++) {
                size2 += CodedOutputStream.computeMessageSize(9, (MessageLite) this.reservedRange_.get(i7));
            }
            int dataSize = 0;
            for (int i8 = 0; i8 < this.reservedName_.size(); i8++) {
                dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.reservedName_.get(i8));
            }
            int size3 = size2 + dataSize + (getReservedNameList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static DescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DescriptorProto parseFrom(InputStream input) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return (DescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DescriptorProto prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(DescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((DescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((DescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((DescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setNameBytes(value);
                return this;
            }

            public List<FieldDescriptorProto> getFieldList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getFieldList());
            }

            public int getFieldCount() {
                return ((DescriptorProto) this.instance).getFieldCount();
            }

            public FieldDescriptorProto getField(int index) {
                return ((DescriptorProto) this.instance).getField(index);
            }

            public Builder setField(int index, FieldDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setField(index, value);
                return this;
            }

            public Builder setField(int index, FieldDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setField(index, builderForValue);
                return this;
            }

            public Builder addField(FieldDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(value);
                return this;
            }

            public Builder addField(int index, FieldDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(index, value);
                return this;
            }

            public Builder addField(FieldDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(builderForValue);
                return this;
            }

            public Builder addField(int index, FieldDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(index, builderForValue);
                return this;
            }

            public Builder addAllField(Iterable<? extends FieldDescriptorProto> values) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllField(values);
                return this;
            }

            public Builder clearField() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearField();
                return this;
            }

            public Builder removeField(int index) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeField(index);
                return this;
            }

            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getExtensionList());
            }

            public int getExtensionCount() {
                return ((DescriptorProto) this.instance).getExtensionCount();
            }

            public FieldDescriptorProto getExtension(int index) {
                return ((DescriptorProto) this.instance).getExtension(index);
            }

            public Builder setExtension(int index, FieldDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtension(index, value);
                return this;
            }

            public Builder setExtension(int index, FieldDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtension(index, builderForValue);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(value);
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(index, value);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(builderForValue);
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(index, builderForValue);
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllExtension(values);
                return this;
            }

            public Builder clearExtension() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearExtension();
                return this;
            }

            public Builder removeExtension(int index) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeExtension(index);
                return this;
            }

            public List<DescriptorProto> getNestedTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getNestedTypeList());
            }

            public int getNestedTypeCount() {
                return ((DescriptorProto) this.instance).getNestedTypeCount();
            }

            public DescriptorProto getNestedType(int index) {
                return ((DescriptorProto) this.instance).getNestedType(index);
            }

            public Builder setNestedType(int index, DescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setNestedType(index, value);
                return this;
            }

            public Builder setNestedType(int index, Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setNestedType(index, builderForValue);
                return this;
            }

            public Builder addNestedType(DescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(value);
                return this;
            }

            public Builder addNestedType(int index, DescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(index, value);
                return this;
            }

            public Builder addNestedType(Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(builderForValue);
                return this;
            }

            public Builder addNestedType(int index, Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(index, builderForValue);
                return this;
            }

            public Builder addAllNestedType(Iterable<? extends DescriptorProto> values) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllNestedType(values);
                return this;
            }

            public Builder clearNestedType() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearNestedType();
                return this;
            }

            public Builder removeNestedType(int index) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeNestedType(index);
                return this;
            }

            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getEnumTypeList());
            }

            public int getEnumTypeCount() {
                return ((DescriptorProto) this.instance).getEnumTypeCount();
            }

            public EnumDescriptorProto getEnumType(int index) {
                return ((DescriptorProto) this.instance).getEnumType(index);
            }

            public Builder setEnumType(int index, EnumDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setEnumType(index, value);
                return this;
            }

            public Builder setEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setEnumType(index, builderForValue);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(value);
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(index, value);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(builderForValue);
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(index, builderForValue);
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllEnumType(values);
                return this;
            }

            public Builder clearEnumType() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearEnumType();
                return this;
            }

            public Builder removeEnumType(int index) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeEnumType(index);
                return this;
            }

            public List<ExtensionRange> getExtensionRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getExtensionRangeList());
            }

            public int getExtensionRangeCount() {
                return ((DescriptorProto) this.instance).getExtensionRangeCount();
            }

            public ExtensionRange getExtensionRange(int index) {
                return ((DescriptorProto) this.instance).getExtensionRange(index);
            }

            public Builder setExtensionRange(int index, ExtensionRange value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtensionRange(index, value);
                return this;
            }

            public Builder setExtensionRange(int index, ExtensionRange.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtensionRange(index, builderForValue);
                return this;
            }

            public Builder addExtensionRange(ExtensionRange value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(value);
                return this;
            }

            public Builder addExtensionRange(int index, ExtensionRange value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(index, value);
                return this;
            }

            public Builder addExtensionRange(ExtensionRange.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(builderForValue);
                return this;
            }

            public Builder addExtensionRange(int index, ExtensionRange.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(index, builderForValue);
                return this;
            }

            public Builder addAllExtensionRange(Iterable<? extends ExtensionRange> values) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllExtensionRange(values);
                return this;
            }

            public Builder clearExtensionRange() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearExtensionRange();
                return this;
            }

            public Builder removeExtensionRange(int index) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeExtensionRange(index);
                return this;
            }

            public List<OneofDescriptorProto> getOneofDeclList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getOneofDeclList());
            }

            public int getOneofDeclCount() {
                return ((DescriptorProto) this.instance).getOneofDeclCount();
            }

            public OneofDescriptorProto getOneofDecl(int index) {
                return ((DescriptorProto) this.instance).getOneofDecl(index);
            }

            public Builder setOneofDecl(int index, OneofDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOneofDecl(index, value);
                return this;
            }

            public Builder setOneofDecl(int index, OneofDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOneofDecl(index, builderForValue);
                return this;
            }

            public Builder addOneofDecl(OneofDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(value);
                return this;
            }

            public Builder addOneofDecl(int index, OneofDescriptorProto value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(index, value);
                return this;
            }

            public Builder addOneofDecl(OneofDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(builderForValue);
                return this;
            }

            public Builder addOneofDecl(int index, OneofDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(index, builderForValue);
                return this;
            }

            public Builder addAllOneofDecl(Iterable<? extends OneofDescriptorProto> values) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllOneofDecl(values);
                return this;
            }

            public Builder clearOneofDecl() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearOneofDecl();
                return this;
            }

            public Builder removeOneofDecl(int index) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeOneofDecl(index);
                return this;
            }

            public boolean hasOptions() {
                return ((DescriptorProto) this.instance).hasOptions();
            }

            public MessageOptions getOptions() {
                return ((DescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(MessageOptions value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(MessageOptions.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOptions(builderForValue);
                return this;
            }

            public Builder mergeOptions(MessageOptions value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearOptions();
                return this;
            }

            public List<ReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getReservedRangeList());
            }

            public int getReservedRangeCount() {
                return ((DescriptorProto) this.instance).getReservedRangeCount();
            }

            public ReservedRange getReservedRange(int index) {
                return ((DescriptorProto) this.instance).getReservedRange(index);
            }

            public Builder setReservedRange(int index, ReservedRange value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setReservedRange(index, value);
                return this;
            }

            public Builder setReservedRange(int index, ReservedRange.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setReservedRange(index, builderForValue);
                return this;
            }

            public Builder addReservedRange(ReservedRange value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(value);
                return this;
            }

            public Builder addReservedRange(int index, ReservedRange value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(index, value);
                return this;
            }

            public Builder addReservedRange(ReservedRange.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(builderForValue);
                return this;
            }

            public Builder addReservedRange(int index, ReservedRange.Builder builderForValue) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(index, builderForValue);
                return this;
            }

            public Builder addAllReservedRange(Iterable<? extends ReservedRange> values) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllReservedRange(values);
                return this;
            }

            public Builder clearReservedRange() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearReservedRange();
                return this;
            }

            public Builder removeReservedRange(int index) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeReservedRange(index);
                return this;
            }

            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getReservedNameList());
            }

            public int getReservedNameCount() {
                return ((DescriptorProto) this.instance).getReservedNameCount();
            }

            public String getReservedName(int index) {
                return ((DescriptorProto) this.instance).getReservedName(index);
            }

            public ByteString getReservedNameBytes(int index) {
                return ((DescriptorProto) this.instance).getReservedNameBytes(index);
            }

            public Builder setReservedName(int index, String value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setReservedName(index, value);
                return this;
            }

            public Builder addReservedName(String value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedName(value);
                return this;
            }

            public Builder addAllReservedName(Iterable<String> values) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllReservedName(values);
                return this;
            }

            public Builder clearReservedName() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearReservedName();
                return this;
            }

            public Builder addReservedNameBytes(ByteString value) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedNameBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new DescriptorProto();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getFieldCount(); i++) {
                        if (!getField(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i2 = 0; i2 < getExtensionCount(); i2++) {
                        if (!getExtension(i2).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i3 = 0; i3 < getNestedTypeCount(); i3++) {
                        if (!getNestedType(i3).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i4 = 0; i4 < getEnumTypeCount(); i4++) {
                        if (!getEnumType(i4).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i5 = 0; i5 < getExtensionRangeCount(); i5++) {
                        if (!getExtensionRange(i5).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i6 = 0; i6 < getOneofDeclCount(); i6++) {
                        if (!getOneofDecl(i6).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (hasOptions() == 0 || getOptions().isInitialized()) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case 3:
                    this.field_.makeImmutable();
                    this.extension_.makeImmutable();
                    this.nestedType_.makeImmutable();
                    this.enumType_.makeImmutable();
                    this.extensionRange_.makeImmutable();
                    this.oneofDecl_.makeImmutable();
                    this.reservedRange_.makeImmutable();
                    this.reservedName_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    DescriptorProto other = (DescriptorProto) arg1;
                    this.name_ = visitor.visitString(hasName(), this.name_, other.hasName(), other.name_);
                    this.field_ = visitor.visitList(this.field_, other.field_);
                    this.extension_ = visitor.visitList(this.extension_, other.extension_);
                    this.nestedType_ = visitor.visitList(this.nestedType_, other.nestedType_);
                    this.enumType_ = visitor.visitList(this.enumType_, other.enumType_);
                    this.extensionRange_ = visitor.visitList(this.extensionRange_, other.extensionRange_);
                    this.oneofDecl_ = visitor.visitList(this.oneofDecl_, other.oneofDecl_);
                    this.options_ = (MessageOptions) visitor.visitMessage(this.options_, other.options_);
                    this.reservedRange_ = visitor.visitList(this.reservedRange_, other.reservedRange_);
                    this.reservedName_ = visitor.visitList(this.reservedName_, other.reservedName_);
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
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 10:
                                    String s = input.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = s;
                                    break;
                                case 18:
                                    if (!this.field_.isModifiable()) {
                                        this.field_ = GeneratedMessageLite.mutableCopy(this.field_);
                                    }
                                    this.field_.add((FieldDescriptorProto) input.readMessage(FieldDescriptorProto.parser(), extensionRegistry));
                                    break;
                                case 26:
                                    if (!this.nestedType_.isModifiable()) {
                                        this.nestedType_ = GeneratedMessageLite.mutableCopy(this.nestedType_);
                                    }
                                    this.nestedType_.add((DescriptorProto) input.readMessage(parser(), extensionRegistry));
                                    break;
                                case 34:
                                    if (!this.enumType_.isModifiable()) {
                                        this.enumType_ = GeneratedMessageLite.mutableCopy(this.enumType_);
                                    }
                                    this.enumType_.add((EnumDescriptorProto) input.readMessage(EnumDescriptorProto.parser(), extensionRegistry));
                                    break;
                                case 42:
                                    if (!this.extensionRange_.isModifiable()) {
                                        this.extensionRange_ = GeneratedMessageLite.mutableCopy(this.extensionRange_);
                                    }
                                    this.extensionRange_.add((ExtensionRange) input.readMessage(ExtensionRange.parser(), extensionRegistry));
                                    break;
                                case 50:
                                    if (!this.extension_.isModifiable()) {
                                        this.extension_ = GeneratedMessageLite.mutableCopy(this.extension_);
                                    }
                                    this.extension_.add((FieldDescriptorProto) input.readMessage(FieldDescriptorProto.parser(), extensionRegistry));
                                    break;
                                case 58:
                                    MessageOptions.Builder subBuilder = null;
                                    if ((this.bitField0_ & 2) == 2) {
                                        subBuilder = (MessageOptions.Builder) this.options_.toBuilder();
                                    }
                                    MessageOptions messageOptions = (MessageOptions) input.readMessage(MessageOptions.parser(), extensionRegistry);
                                    this.options_ = messageOptions;
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom(messageOptions);
                                        this.options_ = (MessageOptions) subBuilder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                    break;
                                case 66:
                                    if (!this.oneofDecl_.isModifiable()) {
                                        this.oneofDecl_ = GeneratedMessageLite.mutableCopy(this.oneofDecl_);
                                    }
                                    this.oneofDecl_.add((OneofDescriptorProto) input.readMessage(OneofDescriptorProto.parser(), extensionRegistry));
                                    break;
                                case 74:
                                    if (!this.reservedRange_.isModifiable()) {
                                        this.reservedRange_ = GeneratedMessageLite.mutableCopy(this.reservedRange_);
                                    }
                                    this.reservedRange_.add((ReservedRange) input.readMessage(ReservedRange.parser(), extensionRegistry));
                                    break;
                                case 82:
                                    String s2 = input.readString();
                                    if (!this.reservedName_.isModifiable()) {
                                        this.reservedName_ = GeneratedMessageLite.mutableCopy(this.reservedName_);
                                    }
                                    this.reservedName_.add(s2);
                                    break;
                                default:
                                    if (parseUnknownField(tag, input)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
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
                        synchronized (DescriptorProto.class) {
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
            DescriptorProto descriptorProto = new DescriptorProto();
            DEFAULT_INSTANCE = descriptorProto;
            descriptorProto.makeImmutable();
        }

        public static DescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class ExtensionRangeOptions extends GeneratedMessageLite.ExtendableMessage<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final ExtensionRangeOptions DEFAULT_INSTANCE;
        private static volatile Parser<ExtensionRangeOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private ExtensionRangeOptions() {
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(values, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int index) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(536870912, output);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static ExtensionRangeOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ExtensionRangeOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ExtensionRangeOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ExtensionRangeOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ExtensionRangeOptions parseFrom(InputStream input) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ExtensionRangeOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (ExtensionRangeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExtensionRangeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ExtensionRangeOptions parseFrom(CodedInputStream input) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ExtensionRangeOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExtensionRangeOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(ExtensionRangeOptions.DEFAULT_INSTANCE);
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ExtensionRangeOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((ExtensionRangeOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return ((ExtensionRangeOptions) this.instance).getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).setUninterpretedOption(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).setUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(value);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(index, value);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addAllUninterpretedOption(values);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).removeUninterpretedOption(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new ExtensionRangeOptions();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (extensionsAreInitialized() == 0) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    this.uninterpretedOption_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.uninterpretedOption_, ((ExtensionRangeOptions) arg1).uninterpretedOption_);
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
                            } else if (tag == 7994) {
                                if (!this.uninterpretedOption_.isModifiable()) {
                                    this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                }
                                this.uninterpretedOption_.add((UninterpretedOption) input.readMessage(UninterpretedOption.parser(), extensionRegistry));
                            } else if (!parseUnknownField((ExtensionRangeOptions) getDefaultInstanceForType(), input, extensionRegistry, tag)) {
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
                        synchronized (ExtensionRangeOptions.class) {
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
            ExtensionRangeOptions extensionRangeOptions = new ExtensionRangeOptions();
            DEFAULT_INSTANCE = extensionRangeOptions;
            extensionRangeOptions.makeImmutable();
        }

        public static ExtensionRangeOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExtensionRangeOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FieldDescriptorProto extends GeneratedMessageLite<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final FieldDescriptorProto DEFAULT_INSTANCE;
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int JSON_NAME_FIELD_NUMBER = 10;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        private static volatile Parser<FieldDescriptorProto> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private int bitField0_;
        private String defaultValue_ = "";
        private String extendee_ = "";
        private String jsonName_ = "";
        private int label_ = 1;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private int number_;
        private int oneofIndex_;
        private FieldOptions options_;
        private String typeName_ = "";
        private int type_ = 1;

        private FieldDescriptorProto() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum Type implements Internal.EnumLite {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);
            
            public static final int TYPE_BOOL_VALUE = 8;
            public static final int TYPE_BYTES_VALUE = 12;
            public static final int TYPE_DOUBLE_VALUE = 1;
            public static final int TYPE_ENUM_VALUE = 14;
            public static final int TYPE_FIXED32_VALUE = 7;
            public static final int TYPE_FIXED64_VALUE = 6;
            public static final int TYPE_FLOAT_VALUE = 2;
            public static final int TYPE_GROUP_VALUE = 10;
            public static final int TYPE_INT32_VALUE = 5;
            public static final int TYPE_INT64_VALUE = 3;
            public static final int TYPE_MESSAGE_VALUE = 11;
            public static final int TYPE_SFIXED32_VALUE = 15;
            public static final int TYPE_SFIXED64_VALUE = 16;
            public static final int TYPE_SINT32_VALUE = 17;
            public static final int TYPE_SINT64_VALUE = 18;
            public static final int TYPE_STRING_VALUE = 9;
            public static final int TYPE_UINT32_VALUE = 13;
            public static final int TYPE_UINT64_VALUE = 4;
            private static final Internal.EnumLiteMap<Type> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Type>() {
                    public Type findValueByNumber(int number) {
                        return Type.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Type valueOf(int value2) {
                return forNumber(value2);
            }

            public static Type forNumber(int value2) {
                switch (value2) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            private Type(int value2) {
                this.value = value2;
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum Label implements Internal.EnumLite {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);
            
            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;
            private static final Internal.EnumLiteMap<Label> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Label>() {
                    public Label findValueByNumber(int number) {
                        return Label.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Label valueOf(int value2) {
                return forNumber(value2);
            }

            public static Label forNumber(int value2) {
                if (value2 == 1) {
                    return LABEL_OPTIONAL;
                }
                if (value2 == 2) {
                    return LABEL_REQUIRED;
                }
                if (value2 != 3) {
                    return null;
                }
                return LABEL_REPEATED;
            }

            public static Internal.EnumLiteMap<Label> internalGetValueMap() {
                return internalValueMap;
            }

            private Label(int value2) {
                this.value = value2;
            }
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

        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getNumber() {
            return this.number_;
        }

        /* access modifiers changed from: private */
        public void setNumber(int value) {
            this.bitField0_ |= 2;
            this.number_ = value;
        }

        /* access modifiers changed from: private */
        public void clearNumber() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        public boolean hasLabel() {
            return (this.bitField0_ & 4) == 4;
        }

        public Label getLabel() {
            Label result = Label.forNumber(this.label_);
            return result == null ? Label.LABEL_OPTIONAL : result;
        }

        /* access modifiers changed from: private */
        public void setLabel(Label value) {
            if (value != null) {
                this.bitField0_ |= 4;
                this.label_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearLabel() {
            this.bitField0_ &= -5;
            this.label_ = 1;
        }

        public boolean hasType() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type getType() {
            Type result = Type.forNumber(this.type_);
            return result == null ? Type.TYPE_DOUBLE : result;
        }

        /* access modifiers changed from: private */
        public void setType(Type value) {
            if (value != null) {
                this.bitField0_ |= 8;
                this.type_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -9;
            this.type_ = 1;
        }

        public boolean hasTypeName() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getTypeName() {
            return this.typeName_;
        }

        public ByteString getTypeNameBytes() {
            return ByteString.copyFromUtf8(this.typeName_);
        }

        /* access modifiers changed from: private */
        public void setTypeName(String value) {
            if (value != null) {
                this.bitField0_ |= 16;
                this.typeName_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearTypeName() {
            this.bitField0_ &= -17;
            this.typeName_ = getDefaultInstance().getTypeName();
        }

        /* access modifiers changed from: private */
        public void setTypeNameBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 16;
                this.typeName_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasExtendee() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getExtendee() {
            return this.extendee_;
        }

        public ByteString getExtendeeBytes() {
            return ByteString.copyFromUtf8(this.extendee_);
        }

        /* access modifiers changed from: private */
        public void setExtendee(String value) {
            if (value != null) {
                this.bitField0_ |= 32;
                this.extendee_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearExtendee() {
            this.bitField0_ &= -33;
            this.extendee_ = getDefaultInstance().getExtendee();
        }

        /* access modifiers changed from: private */
        public void setExtendeeBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 32;
                this.extendee_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasDefaultValue() {
            return (this.bitField0_ & 64) == 64;
        }

        public String getDefaultValue() {
            return this.defaultValue_;
        }

        public ByteString getDefaultValueBytes() {
            return ByteString.copyFromUtf8(this.defaultValue_);
        }

        /* access modifiers changed from: private */
        public void setDefaultValue(String value) {
            if (value != null) {
                this.bitField0_ |= 64;
                this.defaultValue_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearDefaultValue() {
            this.bitField0_ &= -65;
            this.defaultValue_ = getDefaultInstance().getDefaultValue();
        }

        /* access modifiers changed from: private */
        public void setDefaultValueBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 64;
                this.defaultValue_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasOneofIndex() {
            return (this.bitField0_ & 128) == 128;
        }

        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        /* access modifiers changed from: private */
        public void setOneofIndex(int value) {
            this.bitField0_ |= 128;
            this.oneofIndex_ = value;
        }

        /* access modifiers changed from: private */
        public void clearOneofIndex() {
            this.bitField0_ &= -129;
            this.oneofIndex_ = 0;
        }

        public boolean hasJsonName() {
            return (this.bitField0_ & 256) == 256;
        }

        public String getJsonName() {
            return this.jsonName_;
        }

        public ByteString getJsonNameBytes() {
            return ByteString.copyFromUtf8(this.jsonName_);
        }

        /* access modifiers changed from: private */
        public void setJsonName(String value) {
            if (value != null) {
                this.bitField0_ |= 256;
                this.jsonName_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearJsonName() {
            this.bitField0_ &= -257;
            this.jsonName_ = getDefaultInstance().getJsonName();
        }

        /* access modifiers changed from: private */
        public void setJsonNameBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 256;
                this.jsonName_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 512) == 512;
        }

        public FieldOptions getOptions() {
            FieldOptions fieldOptions = this.options_;
            return fieldOptions == null ? FieldOptions.getDefaultInstance() : fieldOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(FieldOptions value) {
            if (value != null) {
                this.options_ = value;
                this.bitField0_ |= 512;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOptions(FieldOptions.Builder builderForValue) {
            this.options_ = (FieldOptions) builderForValue.build();
            this.bitField0_ |= 512;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(FieldOptions value) {
            FieldOptions fieldOptions = this.options_;
            if (fieldOptions == null || fieldOptions == FieldOptions.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = (FieldOptions) ((FieldOptions.Builder) FieldOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 512;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -513;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getName());
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeString(2, getExtendee());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeEnum(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeEnum(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeString(6, getTypeName());
            }
            if ((this.bitField0_ & 64) == 64) {
                output.writeString(7, getDefaultValue());
            }
            if ((this.bitField0_ & 512) == 512) {
                output.writeMessage(8, getOptions());
            }
            if ((this.bitField0_ & 128) == 128) {
                output.writeInt32(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                output.writeString(10, getJsonName());
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
            if ((this.bitField0_ & 32) == 32) {
                size2 += CodedOutputStream.computeStringSize(2, getExtendee());
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeInt32Size(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeEnumSize(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeEnumSize(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                size2 += CodedOutputStream.computeStringSize(6, getTypeName());
            }
            if ((this.bitField0_ & 64) == 64) {
                size2 += CodedOutputStream.computeStringSize(7, getDefaultValue());
            }
            if ((this.bitField0_ & 512) == 512) {
                size2 += CodedOutputStream.computeMessageSize(8, getOptions());
            }
            if ((this.bitField0_ & 128) == 128) {
                size2 += CodedOutputStream.computeInt32Size(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                size2 += CodedOutputStream.computeStringSize(10, getJsonName());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static FieldDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldDescriptorProto parseFrom(InputStream input) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return (FieldDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldDescriptorProto prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(FieldDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((FieldDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((FieldDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((FieldDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setNameBytes(value);
                return this;
            }

            public boolean hasNumber() {
                return ((FieldDescriptorProto) this.instance).hasNumber();
            }

            public int getNumber() {
                return ((FieldDescriptorProto) this.instance).getNumber();
            }

            public Builder setNumber(int value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setNumber(value);
                return this;
            }

            public Builder clearNumber() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearNumber();
                return this;
            }

            public boolean hasLabel() {
                return ((FieldDescriptorProto) this.instance).hasLabel();
            }

            public Label getLabel() {
                return ((FieldDescriptorProto) this.instance).getLabel();
            }

            public Builder setLabel(Label value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setLabel(value);
                return this;
            }

            public Builder clearLabel() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearLabel();
                return this;
            }

            public boolean hasType() {
                return ((FieldDescriptorProto) this.instance).hasType();
            }

            public Type getType() {
                return ((FieldDescriptorProto) this.instance).getType();
            }

            public Builder setType(Type value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setType(value);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearType();
                return this;
            }

            public boolean hasTypeName() {
                return ((FieldDescriptorProto) this.instance).hasTypeName();
            }

            public String getTypeName() {
                return ((FieldDescriptorProto) this.instance).getTypeName();
            }

            public ByteString getTypeNameBytes() {
                return ((FieldDescriptorProto) this.instance).getTypeNameBytes();
            }

            public Builder setTypeName(String value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setTypeName(value);
                return this;
            }

            public Builder clearTypeName() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearTypeName();
                return this;
            }

            public Builder setTypeNameBytes(ByteString value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setTypeNameBytes(value);
                return this;
            }

            public boolean hasExtendee() {
                return ((FieldDescriptorProto) this.instance).hasExtendee();
            }

            public String getExtendee() {
                return ((FieldDescriptorProto) this.instance).getExtendee();
            }

            public ByteString getExtendeeBytes() {
                return ((FieldDescriptorProto) this.instance).getExtendeeBytes();
            }

            public Builder setExtendee(String value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setExtendee(value);
                return this;
            }

            public Builder clearExtendee() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearExtendee();
                return this;
            }

            public Builder setExtendeeBytes(ByteString value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setExtendeeBytes(value);
                return this;
            }

            public boolean hasDefaultValue() {
                return ((FieldDescriptorProto) this.instance).hasDefaultValue();
            }

            public String getDefaultValue() {
                return ((FieldDescriptorProto) this.instance).getDefaultValue();
            }

            public ByteString getDefaultValueBytes() {
                return ((FieldDescriptorProto) this.instance).getDefaultValueBytes();
            }

            public Builder setDefaultValue(String value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setDefaultValue(value);
                return this;
            }

            public Builder clearDefaultValue() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearDefaultValue();
                return this;
            }

            public Builder setDefaultValueBytes(ByteString value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setDefaultValueBytes(value);
                return this;
            }

            public boolean hasOneofIndex() {
                return ((FieldDescriptorProto) this.instance).hasOneofIndex();
            }

            public int getOneofIndex() {
                return ((FieldDescriptorProto) this.instance).getOneofIndex();
            }

            public Builder setOneofIndex(int value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setOneofIndex(value);
                return this;
            }

            public Builder clearOneofIndex() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearOneofIndex();
                return this;
            }

            public boolean hasJsonName() {
                return ((FieldDescriptorProto) this.instance).hasJsonName();
            }

            public String getJsonName() {
                return ((FieldDescriptorProto) this.instance).getJsonName();
            }

            public ByteString getJsonNameBytes() {
                return ((FieldDescriptorProto) this.instance).getJsonNameBytes();
            }

            public Builder setJsonName(String value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setJsonName(value);
                return this;
            }

            public Builder clearJsonName() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearJsonName();
                return this;
            }

            public Builder setJsonNameBytes(ByteString value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setJsonNameBytes(value);
                return this;
            }

            public boolean hasOptions() {
                return ((FieldDescriptorProto) this.instance).hasOptions();
            }

            public FieldOptions getOptions() {
                return ((FieldDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(FieldOptions value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(FieldOptions.Builder builderForValue) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setOptions(builderForValue);
                return this;
            }

            public Builder mergeOptions(FieldOptions value) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new FieldDescriptorProto();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    FieldDescriptorProto other = (FieldDescriptorProto) arg1;
                    this.name_ = visitor.visitString(hasName(), this.name_, other.hasName(), other.name_);
                    this.number_ = visitor.visitInt(hasNumber(), this.number_, other.hasNumber(), other.number_);
                    this.label_ = visitor.visitInt(hasLabel(), this.label_, other.hasLabel(), other.label_);
                    this.type_ = visitor.visitInt(hasType(), this.type_, other.hasType(), other.type_);
                    this.typeName_ = visitor.visitString(hasTypeName(), this.typeName_, other.hasTypeName(), other.typeName_);
                    this.extendee_ = visitor.visitString(hasExtendee(), this.extendee_, other.hasExtendee(), other.extendee_);
                    this.defaultValue_ = visitor.visitString(hasDefaultValue(), this.defaultValue_, other.hasDefaultValue(), other.defaultValue_);
                    this.oneofIndex_ = visitor.visitInt(hasOneofIndex(), this.oneofIndex_, other.hasOneofIndex(), other.oneofIndex_);
                    this.jsonName_ = visitor.visitString(hasJsonName(), this.jsonName_, other.hasJsonName(), other.jsonName_);
                    this.options_ = (FieldOptions) visitor.visitMessage(this.options_, other.options_);
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
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 10:
                                    String s = input.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = s;
                                    break;
                                case 18:
                                    String s2 = input.readString();
                                    this.bitField0_ |= 32;
                                    this.extendee_ = s2;
                                    break;
                                case 24:
                                    this.bitField0_ |= 2;
                                    this.number_ = input.readInt32();
                                    break;
                                case 32:
                                    int rawValue = input.readEnum();
                                    if (Label.forNumber(rawValue) != null) {
                                        this.bitField0_ = 4 | this.bitField0_;
                                        this.label_ = rawValue;
                                        break;
                                    } else {
                                        super.mergeVarintField(4, rawValue);
                                        break;
                                    }
                                case 40:
                                    int rawValue2 = input.readEnum();
                                    if (Type.forNumber(rawValue2) != null) {
                                        this.bitField0_ |= 8;
                                        this.type_ = rawValue2;
                                        break;
                                    } else {
                                        super.mergeVarintField(5, rawValue2);
                                        break;
                                    }
                                case 50:
                                    String s3 = input.readString();
                                    this.bitField0_ |= 16;
                                    this.typeName_ = s3;
                                    break;
                                case 58:
                                    String s4 = input.readString();
                                    this.bitField0_ |= 64;
                                    this.defaultValue_ = s4;
                                    break;
                                case 66:
                                    FieldOptions.Builder subBuilder = null;
                                    if ((this.bitField0_ & 512) == 512) {
                                        subBuilder = (FieldOptions.Builder) this.options_.toBuilder();
                                    }
                                    FieldOptions fieldOptions = (FieldOptions) input.readMessage(FieldOptions.parser(), extensionRegistry);
                                    this.options_ = fieldOptions;
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom(fieldOptions);
                                        this.options_ = (FieldOptions) subBuilder.buildPartial();
                                    }
                                    this.bitField0_ |= 512;
                                    break;
                                case 72:
                                    this.bitField0_ |= 128;
                                    this.oneofIndex_ = input.readInt32();
                                    break;
                                case 82:
                                    String s5 = input.readString();
                                    this.bitField0_ |= 256;
                                    this.jsonName_ = s5;
                                    break;
                                default:
                                    if (parseUnknownField(tag, input)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
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
                        synchronized (FieldDescriptorProto.class) {
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
            FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto();
            DEFAULT_INSTANCE = fieldDescriptorProto;
            fieldDescriptorProto.makeImmutable();
        }

        public static FieldDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FieldDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class OneofDescriptorProto extends GeneratedMessageLite<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final OneofDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 2;
        private static volatile Parser<OneofDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private OneofOptions options_;

        private OneofDescriptorProto() {
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

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        public OneofOptions getOptions() {
            OneofOptions oneofOptions = this.options_;
            return oneofOptions == null ? OneofOptions.getDefaultInstance() : oneofOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(OneofOptions value) {
            if (value != null) {
                this.options_ = value;
                this.bitField0_ |= 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOptions(OneofOptions.Builder builderForValue) {
            this.options_ = (OneofOptions) builderForValue.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(OneofOptions value) {
            OneofOptions oneofOptions = this.options_;
            if (oneofOptions == null || oneofOptions == OneofOptions.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = (OneofOptions) ((OneofOptions.Builder) OneofOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(2, getOptions());
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
                size2 += CodedOutputStream.computeMessageSize(2, getOptions());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static OneofDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static OneofDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static OneofDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static OneofDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static OneofDescriptorProto parseFrom(InputStream input) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static OneofDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return (OneofDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OneofDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static OneofDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static OneofDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OneofDescriptorProto prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(OneofDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((OneofDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((OneofDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((OneofDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setNameBytes(value);
                return this;
            }

            public boolean hasOptions() {
                return ((OneofDescriptorProto) this.instance).hasOptions();
            }

            public OneofOptions getOptions() {
                return ((OneofDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(OneofOptions value) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(OneofOptions.Builder builderForValue) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setOptions(builderForValue);
                return this;
            }

            public Builder mergeOptions(OneofOptions value) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new OneofDescriptorProto();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    OneofDescriptorProto other = (OneofDescriptorProto) arg1;
                    this.name_ = visitor.visitString(hasName(), this.name_, other.hasName(), other.name_);
                    this.options_ = (OneofOptions) visitor.visitMessage(this.options_, other.options_);
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
                                this.name_ = s;
                            } else if (tag == 18) {
                                OneofOptions.Builder subBuilder = null;
                                if ((this.bitField0_ & 2) == 2) {
                                    subBuilder = (OneofOptions.Builder) this.options_.toBuilder();
                                }
                                OneofOptions oneofOptions = (OneofOptions) input.readMessage(OneofOptions.parser(), extensionRegistry);
                                this.options_ = oneofOptions;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(oneofOptions);
                                    this.options_ = (OneofOptions) subBuilder.buildPartial();
                                }
                                this.bitField0_ |= 2;
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
                        synchronized (OneofDescriptorProto.class) {
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
            OneofDescriptorProto oneofDescriptorProto = new OneofDescriptorProto();
            DEFAULT_INSTANCE = oneofDescriptorProto;
            oneofDescriptorProto.makeImmutable();
        }

        public static OneofDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OneofDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class EnumDescriptorProto extends GeneratedMessageLite<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final EnumDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumDescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 5;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private EnumOptions options_;
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<EnumReservedRange> reservedRange_ = emptyProtobufList();
        private Internal.ProtobufList<EnumValueDescriptorProto> value_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface EnumReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        private EnumDescriptorProto() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class EnumReservedRange extends GeneratedMessageLite<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
            /* access modifiers changed from: private */
            public static final EnumReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<EnumReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            private EnumReservedRange() {
            }

            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getStart() {
                return this.start_;
            }

            /* access modifiers changed from: private */
            public void setStart(int value) {
                this.bitField0_ |= 1;
                this.start_ = value;
            }

            /* access modifiers changed from: private */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getEnd() {
                return this.end_;
            }

            /* access modifiers changed from: private */
            public void setEnd(int value) {
                this.bitField0_ |= 2;
                this.end_ = value;
            }

            /* access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    output.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeInt32(2, this.end_);
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
                    size2 = 0 + CodedOutputStream.computeInt32Size(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    size2 += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                int size3 = size2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size3;
                return size3;
            }

            public static EnumReservedRange parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static EnumReservedRange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static EnumReservedRange parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static EnumReservedRange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static EnumReservedRange parseFrom(InputStream input) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static EnumReservedRange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream input) throws IOException {
                return (EnumReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (EnumReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static EnumReservedRange parseFrom(CodedInputStream input) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static EnumReservedRange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(EnumReservedRange prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(EnumReservedRange.DEFAULT_INSTANCE);
                }

                public boolean hasStart() {
                    return ((EnumReservedRange) this.instance).hasStart();
                }

                public int getStart() {
                    return ((EnumReservedRange) this.instance).getStart();
                }

                public Builder setStart(int value) {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).setStart(value);
                    return this;
                }

                public Builder clearStart() {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).clearStart();
                    return this;
                }

                public boolean hasEnd() {
                    return ((EnumReservedRange) this.instance).hasEnd();
                }

                public int getEnd() {
                    return ((EnumReservedRange) this.instance).getEnd();
                }

                public Builder setEnd(int value) {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).setEnd(value);
                    return this;
                }

                public Builder clearEnd() {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).clearEnd();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new EnumReservedRange();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                        EnumReservedRange other = (EnumReservedRange) arg1;
                        this.start_ = visitor.visitInt(hasStart(), this.start_, other.hasStart(), other.start_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, other.hasEnd(), other.end_);
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
                                    this.start_ = input.readInt32();
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.end_ = input.readInt32();
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
                            synchronized (EnumReservedRange.class) {
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
                EnumReservedRange enumReservedRange = new EnumReservedRange();
                DEFAULT_INSTANCE = enumReservedRange;
                enumReservedRange.makeImmutable();
            }

            public static EnumReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<EnumReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
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

        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        public List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
            return this.value_;
        }

        public int getValueCount() {
            return this.value_.size();
        }

        public EnumValueDescriptorProto getValue(int index) {
            return (EnumValueDescriptorProto) this.value_.get(index);
        }

        public EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int index) {
            return (EnumValueDescriptorProtoOrBuilder) this.value_.get(index);
        }

        private void ensureValueIsMutable() {
            if (!this.value_.isModifiable()) {
                this.value_ = GeneratedMessageLite.mutableCopy(this.value_);
            }
        }

        /* access modifiers changed from: private */
        public void setValue(int index, EnumValueDescriptorProto value) {
            if (value != null) {
                ensureValueIsMutable();
                this.value_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setValue(int index, EnumValueDescriptorProto.Builder builderForValue) {
            ensureValueIsMutable();
            this.value_.set(index, (EnumValueDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addValue(EnumValueDescriptorProto value) {
            if (value != null) {
                ensureValueIsMutable();
                this.value_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addValue(int index, EnumValueDescriptorProto value) {
            if (value != null) {
                ensureValueIsMutable();
                this.value_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addValue(EnumValueDescriptorProto.Builder builderForValue) {
            ensureValueIsMutable();
            this.value_.add((EnumValueDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addValue(int index, EnumValueDescriptorProto.Builder builderForValue) {
            ensureValueIsMutable();
            this.value_.add(index, (EnumValueDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllValue(Iterable<? extends EnumValueDescriptorProto> values) {
            ensureValueIsMutable();
            AbstractMessageLite.addAll(values, this.value_);
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.value_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeValue(int index) {
            ensureValueIsMutable();
            this.value_.remove(index);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        public EnumOptions getOptions() {
            EnumOptions enumOptions = this.options_;
            return enumOptions == null ? EnumOptions.getDefaultInstance() : enumOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(EnumOptions value) {
            if (value != null) {
                this.options_ = value;
                this.bitField0_ |= 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOptions(EnumOptions.Builder builderForValue) {
            this.options_ = (EnumOptions) builderForValue.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(EnumOptions value) {
            EnumOptions enumOptions = this.options_;
            if (enumOptions == null || enumOptions == EnumOptions.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = (EnumOptions) ((EnumOptions.Builder) EnumOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public List<EnumReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public List<? extends EnumReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        public EnumReservedRange getReservedRange(int index) {
            return (EnumReservedRange) this.reservedRange_.get(index);
        }

        public EnumReservedRangeOrBuilder getReservedRangeOrBuilder(int index) {
            return (EnumReservedRangeOrBuilder) this.reservedRange_.get(index);
        }

        private void ensureReservedRangeIsMutable() {
            if (!this.reservedRange_.isModifiable()) {
                this.reservedRange_ = GeneratedMessageLite.mutableCopy(this.reservedRange_);
            }
        }

        /* access modifiers changed from: private */
        public void setReservedRange(int index, EnumReservedRange value) {
            if (value != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setReservedRange(int index, EnumReservedRange.Builder builderForValue) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(index, (EnumReservedRange) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addReservedRange(EnumReservedRange value) {
            if (value != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addReservedRange(int index, EnumReservedRange value) {
            if (value != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addReservedRange(EnumReservedRange.Builder builderForValue) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add((EnumReservedRange) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addReservedRange(int index, EnumReservedRange.Builder builderForValue) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(index, (EnumReservedRange) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllReservedRange(Iterable<? extends EnumReservedRange> values) {
            ensureReservedRangeIsMutable();
            AbstractMessageLite.addAll(values, this.reservedRange_);
        }

        /* access modifiers changed from: private */
        public void clearReservedRange() {
            this.reservedRange_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeReservedRange(int index) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.remove(index);
        }

        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        public String getReservedName(int index) {
            return (String) this.reservedName_.get(index);
        }

        public ByteString getReservedNameBytes(int index) {
            return ByteString.copyFromUtf8((String) this.reservedName_.get(index));
        }

        private void ensureReservedNameIsMutable() {
            if (!this.reservedName_.isModifiable()) {
                this.reservedName_ = GeneratedMessageLite.mutableCopy(this.reservedName_);
            }
        }

        /* access modifiers changed from: private */
        public void setReservedName(int index, String value) {
            if (value != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addReservedName(String value) {
            if (value != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addAllReservedName(Iterable<String> values) {
            ensureReservedNameIsMutable();
            AbstractMessageLite.addAll(values, this.reservedName_);
        }

        /* access modifiers changed from: private */
        public void clearReservedName() {
            this.reservedName_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addReservedNameBytes(ByteString value) {
            if (value != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.add(value.toStringUtf8());
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getName());
            }
            for (int i = 0; i < this.value_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.value_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(3, getOptions());
            }
            for (int i2 = 0; i2 < this.reservedRange_.size(); i2++) {
                output.writeMessage(4, (MessageLite) this.reservedRange_.get(i2));
            }
            for (int i3 = 0; i3 < this.reservedName_.size(); i3++) {
                output.writeString(5, (String) this.reservedName_.get(i3));
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
            for (int i = 0; i < this.value_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.value_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            for (int i2 = 0; i2 < this.reservedRange_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.reservedRange_.get(i2));
            }
            int dataSize = 0;
            for (int i3 = 0; i3 < this.reservedName_.size(); i3++) {
                dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.reservedName_.get(i3));
            }
            int size3 = size2 + dataSize + (getReservedNameList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static EnumDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EnumDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EnumDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EnumDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EnumDescriptorProto parseFrom(InputStream input) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return (EnumDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumDescriptorProto prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(EnumDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((EnumDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((EnumDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((EnumDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setNameBytes(value);
                return this;
            }

            public List<EnumValueDescriptorProto> getValueList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.instance).getValueList());
            }

            public int getValueCount() {
                return ((EnumDescriptorProto) this.instance).getValueCount();
            }

            public EnumValueDescriptorProto getValue(int index) {
                return ((EnumDescriptorProto) this.instance).getValue(index);
            }

            public Builder setValue(int index, EnumValueDescriptorProto value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setValue(index, value);
                return this;
            }

            public Builder setValue(int index, EnumValueDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setValue(index, builderForValue);
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(value);
                return this;
            }

            public Builder addValue(int index, EnumValueDescriptorProto value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(index, value);
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(builderForValue);
                return this;
            }

            public Builder addValue(int index, EnumValueDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(index, builderForValue);
                return this;
            }

            public Builder addAllValue(Iterable<? extends EnumValueDescriptorProto> values) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addAllValue(values);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearValue();
                return this;
            }

            public Builder removeValue(int index) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).removeValue(index);
                return this;
            }

            public boolean hasOptions() {
                return ((EnumDescriptorProto) this.instance).hasOptions();
            }

            public EnumOptions getOptions() {
                return ((EnumDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(EnumOptions value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(EnumOptions.Builder builderForValue) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setOptions(builderForValue);
                return this;
            }

            public Builder mergeOptions(EnumOptions value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearOptions();
                return this;
            }

            public List<EnumReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.instance).getReservedRangeList());
            }

            public int getReservedRangeCount() {
                return ((EnumDescriptorProto) this.instance).getReservedRangeCount();
            }

            public EnumReservedRange getReservedRange(int index) {
                return ((EnumDescriptorProto) this.instance).getReservedRange(index);
            }

            public Builder setReservedRange(int index, EnumReservedRange value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setReservedRange(index, value);
                return this;
            }

            public Builder setReservedRange(int index, EnumReservedRange.Builder builderForValue) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setReservedRange(index, builderForValue);
                return this;
            }

            public Builder addReservedRange(EnumReservedRange value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(value);
                return this;
            }

            public Builder addReservedRange(int index, EnumReservedRange value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(index, value);
                return this;
            }

            public Builder addReservedRange(EnumReservedRange.Builder builderForValue) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(builderForValue);
                return this;
            }

            public Builder addReservedRange(int index, EnumReservedRange.Builder builderForValue) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(index, builderForValue);
                return this;
            }

            public Builder addAllReservedRange(Iterable<? extends EnumReservedRange> values) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addAllReservedRange(values);
                return this;
            }

            public Builder clearReservedRange() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearReservedRange();
                return this;
            }

            public Builder removeReservedRange(int index) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).removeReservedRange(index);
                return this;
            }

            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.instance).getReservedNameList());
            }

            public int getReservedNameCount() {
                return ((EnumDescriptorProto) this.instance).getReservedNameCount();
            }

            public String getReservedName(int index) {
                return ((EnumDescriptorProto) this.instance).getReservedName(index);
            }

            public ByteString getReservedNameBytes(int index) {
                return ((EnumDescriptorProto) this.instance).getReservedNameBytes(index);
            }

            public Builder setReservedName(int index, String value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setReservedName(index, value);
                return this;
            }

            public Builder addReservedName(String value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedName(value);
                return this;
            }

            public Builder addAllReservedName(Iterable<String> values) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addAllReservedName(values);
                return this;
            }

            public Builder clearReservedName() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearReservedName();
                return this;
            }

            public Builder addReservedNameBytes(ByteString value) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedNameBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new EnumDescriptorProto();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getValueCount(); i++) {
                        if (!getValue(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (hasOptions() == 0 || getOptions().isInitialized()) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case 3:
                    this.value_.makeImmutable();
                    this.reservedRange_.makeImmutable();
                    this.reservedName_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    EnumDescriptorProto other = (EnumDescriptorProto) arg1;
                    this.name_ = visitor.visitString(hasName(), this.name_, other.hasName(), other.name_);
                    this.value_ = visitor.visitList(this.value_, other.value_);
                    this.options_ = (EnumOptions) visitor.visitMessage(this.options_, other.options_);
                    this.reservedRange_ = visitor.visitList(this.reservedRange_, other.reservedRange_);
                    this.reservedName_ = visitor.visitList(this.reservedName_, other.reservedName_);
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
                                this.name_ = s;
                            } else if (tag == 18) {
                                if (!this.value_.isModifiable()) {
                                    this.value_ = GeneratedMessageLite.mutableCopy(this.value_);
                                }
                                this.value_.add((EnumValueDescriptorProto) input.readMessage(EnumValueDescriptorProto.parser(), extensionRegistry));
                            } else if (tag == 26) {
                                EnumOptions.Builder subBuilder = null;
                                if ((this.bitField0_ & 2) == 2) {
                                    subBuilder = (EnumOptions.Builder) this.options_.toBuilder();
                                }
                                EnumOptions enumOptions = (EnumOptions) input.readMessage(EnumOptions.parser(), extensionRegistry);
                                this.options_ = enumOptions;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(enumOptions);
                                    this.options_ = (EnumOptions) subBuilder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag == 34) {
                                if (!this.reservedRange_.isModifiable()) {
                                    this.reservedRange_ = GeneratedMessageLite.mutableCopy(this.reservedRange_);
                                }
                                this.reservedRange_.add((EnumReservedRange) input.readMessage(EnumReservedRange.parser(), extensionRegistry));
                            } else if (tag == 42) {
                                String s2 = input.readString();
                                if (!this.reservedName_.isModifiable()) {
                                    this.reservedName_ = GeneratedMessageLite.mutableCopy(this.reservedName_);
                                }
                                this.reservedName_.add(s2);
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
                        synchronized (EnumDescriptorProto.class) {
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
            EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto();
            DEFAULT_INSTANCE = enumDescriptorProto;
            enumDescriptorProto.makeImmutable();
        }

        public static EnumDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnumDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class EnumValueDescriptorProto extends GeneratedMessageLite<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final EnumValueDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumValueDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private int number_;
        private EnumValueOptions options_;

        private EnumValueDescriptorProto() {
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

        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getNumber() {
            return this.number_;
        }

        /* access modifiers changed from: private */
        public void setNumber(int value) {
            this.bitField0_ |= 2;
            this.number_ = value;
        }

        /* access modifiers changed from: private */
        public void clearNumber() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        public EnumValueOptions getOptions() {
            EnumValueOptions enumValueOptions = this.options_;
            return enumValueOptions == null ? EnumValueOptions.getDefaultInstance() : enumValueOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(EnumValueOptions value) {
            if (value != null) {
                this.options_ = value;
                this.bitField0_ |= 4;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOptions(EnumValueOptions.Builder builderForValue) {
            this.options_ = (EnumValueOptions) builderForValue.build();
            this.bitField0_ |= 4;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(EnumValueOptions value) {
            EnumValueOptions enumValueOptions = this.options_;
            if (enumValueOptions == null || enumValueOptions == EnumValueOptions.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = (EnumValueOptions) ((EnumValueOptions.Builder) EnumValueOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 4;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(3, getOptions());
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
                size2 += CodedOutputStream.computeInt32Size(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static EnumValueDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream input) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return (EnumValueDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumValueDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumValueDescriptorProto prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(EnumValueDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((EnumValueDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((EnumValueDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((EnumValueDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setNameBytes(value);
                return this;
            }

            public boolean hasNumber() {
                return ((EnumValueDescriptorProto) this.instance).hasNumber();
            }

            public int getNumber() {
                return ((EnumValueDescriptorProto) this.instance).getNumber();
            }

            public Builder setNumber(int value) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setNumber(value);
                return this;
            }

            public Builder clearNumber() {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).clearNumber();
                return this;
            }

            public boolean hasOptions() {
                return ((EnumValueDescriptorProto) this.instance).hasOptions();
            }

            public EnumValueOptions getOptions() {
                return ((EnumValueDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(EnumValueOptions value) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(EnumValueOptions.Builder builderForValue) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setOptions(builderForValue);
                return this;
            }

            public Builder mergeOptions(EnumValueOptions value) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new EnumValueDescriptorProto();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    EnumValueDescriptorProto other = (EnumValueDescriptorProto) arg1;
                    this.name_ = visitor.visitString(hasName(), this.name_, other.hasName(), other.name_);
                    this.number_ = visitor.visitInt(hasNumber(), this.number_, other.hasNumber(), other.number_);
                    this.options_ = (EnumValueOptions) visitor.visitMessage(this.options_, other.options_);
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
                                this.name_ = s;
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.number_ = input.readInt32();
                            } else if (tag == 26) {
                                EnumValueOptions.Builder subBuilder = null;
                                if ((this.bitField0_ & 4) == 4) {
                                    subBuilder = (EnumValueOptions.Builder) this.options_.toBuilder();
                                }
                                EnumValueOptions enumValueOptions = (EnumValueOptions) input.readMessage(EnumValueOptions.parser(), extensionRegistry);
                                this.options_ = enumValueOptions;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(enumValueOptions);
                                    this.options_ = (EnumValueOptions) subBuilder.buildPartial();
                                }
                                this.bitField0_ |= 4;
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
                        synchronized (EnumValueDescriptorProto.class) {
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
            EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto();
            DEFAULT_INSTANCE = enumValueDescriptorProto;
            enumValueDescriptorProto.makeImmutable();
        }

        public static EnumValueDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnumValueDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class ServiceDescriptorProto extends GeneratedMessageLite<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final ServiceDescriptorProto DEFAULT_INSTANCE;
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<ServiceDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<MethodDescriptorProto> method_ = emptyProtobufList();
        private String name_ = "";
        private ServiceOptions options_;

        private ServiceDescriptorProto() {
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

        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        public List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
            return this.method_;
        }

        public int getMethodCount() {
            return this.method_.size();
        }

        public MethodDescriptorProto getMethod(int index) {
            return (MethodDescriptorProto) this.method_.get(index);
        }

        public MethodDescriptorProtoOrBuilder getMethodOrBuilder(int index) {
            return (MethodDescriptorProtoOrBuilder) this.method_.get(index);
        }

        private void ensureMethodIsMutable() {
            if (!this.method_.isModifiable()) {
                this.method_ = GeneratedMessageLite.mutableCopy(this.method_);
            }
        }

        /* access modifiers changed from: private */
        public void setMethod(int index, MethodDescriptorProto value) {
            if (value != null) {
                ensureMethodIsMutable();
                this.method_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setMethod(int index, MethodDescriptorProto.Builder builderForValue) {
            ensureMethodIsMutable();
            this.method_.set(index, (MethodDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addMethod(MethodDescriptorProto value) {
            if (value != null) {
                ensureMethodIsMutable();
                this.method_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addMethod(int index, MethodDescriptorProto value) {
            if (value != null) {
                ensureMethodIsMutable();
                this.method_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addMethod(MethodDescriptorProto.Builder builderForValue) {
            ensureMethodIsMutable();
            this.method_.add((MethodDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addMethod(int index, MethodDescriptorProto.Builder builderForValue) {
            ensureMethodIsMutable();
            this.method_.add(index, (MethodDescriptorProto) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllMethod(Iterable<? extends MethodDescriptorProto> values) {
            ensureMethodIsMutable();
            AbstractMessageLite.addAll(values, this.method_);
        }

        /* access modifiers changed from: private */
        public void clearMethod() {
            this.method_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeMethod(int index) {
            ensureMethodIsMutable();
            this.method_.remove(index);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        public ServiceOptions getOptions() {
            ServiceOptions serviceOptions = this.options_;
            return serviceOptions == null ? ServiceOptions.getDefaultInstance() : serviceOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(ServiceOptions value) {
            if (value != null) {
                this.options_ = value;
                this.bitField0_ |= 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOptions(ServiceOptions.Builder builderForValue) {
            this.options_ = (ServiceOptions) builderForValue.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(ServiceOptions value) {
            ServiceOptions serviceOptions = this.options_;
            if (serviceOptions == null || serviceOptions == ServiceOptions.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = (ServiceOptions) ((ServiceOptions.Builder) ServiceOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getName());
            }
            for (int i = 0; i < this.method_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.method_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(3, getOptions());
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
            for (int i = 0; i < this.method_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.method_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static ServiceDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ServiceDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ServiceDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ServiceDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ServiceDescriptorProto parseFrom(InputStream input) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ServiceDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return (ServiceDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServiceDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServiceDescriptorProto prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(ServiceDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((ServiceDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((ServiceDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((ServiceDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setNameBytes(value);
                return this;
            }

            public List<MethodDescriptorProto> getMethodList() {
                return Collections.unmodifiableList(((ServiceDescriptorProto) this.instance).getMethodList());
            }

            public int getMethodCount() {
                return ((ServiceDescriptorProto) this.instance).getMethodCount();
            }

            public MethodDescriptorProto getMethod(int index) {
                return ((ServiceDescriptorProto) this.instance).getMethod(index);
            }

            public Builder setMethod(int index, MethodDescriptorProto value) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setMethod(index, value);
                return this;
            }

            public Builder setMethod(int index, MethodDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setMethod(index, builderForValue);
                return this;
            }

            public Builder addMethod(MethodDescriptorProto value) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(value);
                return this;
            }

            public Builder addMethod(int index, MethodDescriptorProto value) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(index, value);
                return this;
            }

            public Builder addMethod(MethodDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(builderForValue);
                return this;
            }

            public Builder addMethod(int index, MethodDescriptorProto.Builder builderForValue) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(index, builderForValue);
                return this;
            }

            public Builder addAllMethod(Iterable<? extends MethodDescriptorProto> values) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addAllMethod(values);
                return this;
            }

            public Builder clearMethod() {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).clearMethod();
                return this;
            }

            public Builder removeMethod(int index) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).removeMethod(index);
                return this;
            }

            public boolean hasOptions() {
                return ((ServiceDescriptorProto) this.instance).hasOptions();
            }

            public ServiceOptions getOptions() {
                return ((ServiceDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(ServiceOptions value) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(ServiceOptions.Builder builderForValue) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setOptions(builderForValue);
                return this;
            }

            public Builder mergeOptions(ServiceOptions value) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new ServiceDescriptorProto();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getMethodCount(); i++) {
                        if (!getMethod(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (hasOptions() == 0 || getOptions().isInitialized()) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case 3:
                    this.method_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    ServiceDescriptorProto other = (ServiceDescriptorProto) arg1;
                    this.name_ = visitor.visitString(hasName(), this.name_, other.hasName(), other.name_);
                    this.method_ = visitor.visitList(this.method_, other.method_);
                    this.options_ = (ServiceOptions) visitor.visitMessage(this.options_, other.options_);
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
                                this.name_ = s;
                            } else if (tag == 18) {
                                if (!this.method_.isModifiable()) {
                                    this.method_ = GeneratedMessageLite.mutableCopy(this.method_);
                                }
                                this.method_.add((MethodDescriptorProto) input.readMessage(MethodDescriptorProto.parser(), extensionRegistry));
                            } else if (tag == 26) {
                                ServiceOptions.Builder subBuilder = null;
                                if ((this.bitField0_ & 2) == 2) {
                                    subBuilder = (ServiceOptions.Builder) this.options_.toBuilder();
                                }
                                ServiceOptions serviceOptions = (ServiceOptions) input.readMessage(ServiceOptions.parser(), extensionRegistry);
                                this.options_ = serviceOptions;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(serviceOptions);
                                    this.options_ = (ServiceOptions) subBuilder.buildPartial();
                                }
                                this.bitField0_ |= 2;
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
                        synchronized (ServiceDescriptorProto.class) {
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
            ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto();
            DEFAULT_INSTANCE = serviceDescriptorProto;
            serviceDescriptorProto.makeImmutable();
        }

        public static ServiceDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServiceDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class MethodDescriptorProto extends GeneratedMessageLite<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
        public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
        /* access modifiers changed from: private */
        public static final MethodDescriptorProto DEFAULT_INSTANCE;
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static volatile Parser<MethodDescriptorProto> PARSER = null;
        public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
        private int bitField0_;
        private boolean clientStreaming_;
        private String inputType_ = "";
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private MethodOptions options_;
        private String outputType_ = "";
        private boolean serverStreaming_;

        private MethodDescriptorProto() {
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

        public boolean hasInputType() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getInputType() {
            return this.inputType_;
        }

        public ByteString getInputTypeBytes() {
            return ByteString.copyFromUtf8(this.inputType_);
        }

        /* access modifiers changed from: private */
        public void setInputType(String value) {
            if (value != null) {
                this.bitField0_ |= 2;
                this.inputType_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearInputType() {
            this.bitField0_ &= -3;
            this.inputType_ = getDefaultInstance().getInputType();
        }

        /* access modifiers changed from: private */
        public void setInputTypeBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 2;
                this.inputType_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasOutputType() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getOutputType() {
            return this.outputType_;
        }

        public ByteString getOutputTypeBytes() {
            return ByteString.copyFromUtf8(this.outputType_);
        }

        /* access modifiers changed from: private */
        public void setOutputType(String value) {
            if (value != null) {
                this.bitField0_ |= 4;
                this.outputType_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearOutputType() {
            this.bitField0_ &= -5;
            this.outputType_ = getDefaultInstance().getOutputType();
        }

        /* access modifiers changed from: private */
        public void setOutputTypeBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 4;
                this.outputType_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 8) == 8;
        }

        public MethodOptions getOptions() {
            MethodOptions methodOptions = this.options_;
            return methodOptions == null ? MethodOptions.getDefaultInstance() : methodOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(MethodOptions value) {
            if (value != null) {
                this.options_ = value;
                this.bitField0_ |= 8;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOptions(MethodOptions.Builder builderForValue) {
            this.options_ = (MethodOptions) builderForValue.build();
            this.bitField0_ |= 8;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(MethodOptions value) {
            MethodOptions methodOptions = this.options_;
            if (methodOptions == null || methodOptions == MethodOptions.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = (MethodOptions) ((MethodOptions.Builder) MethodOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            }
            this.bitField0_ |= 8;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -9;
        }

        public boolean hasClientStreaming() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean getClientStreaming() {
            return this.clientStreaming_;
        }

        /* access modifiers changed from: private */
        public void setClientStreaming(boolean value) {
            this.bitField0_ |= 16;
            this.clientStreaming_ = value;
        }

        /* access modifiers changed from: private */
        public void clearClientStreaming() {
            this.bitField0_ &= -17;
            this.clientStreaming_ = false;
        }

        public boolean hasServerStreaming() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean getServerStreaming() {
            return this.serverStreaming_;
        }

        /* access modifiers changed from: private */
        public void setServerStreaming(boolean value) {
            this.bitField0_ |= 32;
            this.serverStreaming_ = value;
        }

        /* access modifiers changed from: private */
        public void clearServerStreaming() {
            this.bitField0_ &= -33;
            this.serverStreaming_ = false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeString(2, getInputType());
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeString(3, getOutputType());
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(4, getOptions());
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeBool(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeBool(6, this.serverStreaming_);
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
                size2 += CodedOutputStream.computeStringSize(2, getInputType());
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeStringSize(3, getOutputType());
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeMessageSize(4, getOptions());
            }
            if ((this.bitField0_ & 16) == 16) {
                size2 += CodedOutputStream.computeBoolSize(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                size2 += CodedOutputStream.computeBoolSize(6, this.serverStreaming_);
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static MethodDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MethodDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MethodDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MethodDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MethodDescriptorProto parseFrom(InputStream input) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MethodDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return (MethodDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MethodDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MethodDescriptorProto prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(MethodDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((MethodDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((MethodDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((MethodDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setNameBytes(value);
                return this;
            }

            public boolean hasInputType() {
                return ((MethodDescriptorProto) this.instance).hasInputType();
            }

            public String getInputType() {
                return ((MethodDescriptorProto) this.instance).getInputType();
            }

            public ByteString getInputTypeBytes() {
                return ((MethodDescriptorProto) this.instance).getInputTypeBytes();
            }

            public Builder setInputType(String value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setInputType(value);
                return this;
            }

            public Builder clearInputType() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearInputType();
                return this;
            }

            public Builder setInputTypeBytes(ByteString value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setInputTypeBytes(value);
                return this;
            }

            public boolean hasOutputType() {
                return ((MethodDescriptorProto) this.instance).hasOutputType();
            }

            public String getOutputType() {
                return ((MethodDescriptorProto) this.instance).getOutputType();
            }

            public ByteString getOutputTypeBytes() {
                return ((MethodDescriptorProto) this.instance).getOutputTypeBytes();
            }

            public Builder setOutputType(String value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOutputType(value);
                return this;
            }

            public Builder clearOutputType() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearOutputType();
                return this;
            }

            public Builder setOutputTypeBytes(ByteString value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOutputTypeBytes(value);
                return this;
            }

            public boolean hasOptions() {
                return ((MethodDescriptorProto) this.instance).hasOptions();
            }

            public MethodOptions getOptions() {
                return ((MethodDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(MethodOptions value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(MethodOptions.Builder builderForValue) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOptions(builderForValue);
                return this;
            }

            public Builder mergeOptions(MethodOptions value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearOptions();
                return this;
            }

            public boolean hasClientStreaming() {
                return ((MethodDescriptorProto) this.instance).hasClientStreaming();
            }

            public boolean getClientStreaming() {
                return ((MethodDescriptorProto) this.instance).getClientStreaming();
            }

            public Builder setClientStreaming(boolean value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setClientStreaming(value);
                return this;
            }

            public Builder clearClientStreaming() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearClientStreaming();
                return this;
            }

            public boolean hasServerStreaming() {
                return ((MethodDescriptorProto) this.instance).hasServerStreaming();
            }

            public boolean getServerStreaming() {
                return ((MethodDescriptorProto) this.instance).getServerStreaming();
            }

            public Builder setServerStreaming(boolean value) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setServerStreaming(value);
                return this;
            }

            public Builder clearServerStreaming() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearServerStreaming();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new MethodDescriptorProto();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    MethodDescriptorProto other = (MethodDescriptorProto) arg1;
                    this.name_ = visitor.visitString(hasName(), this.name_, other.hasName(), other.name_);
                    this.inputType_ = visitor.visitString(hasInputType(), this.inputType_, other.hasInputType(), other.inputType_);
                    this.outputType_ = visitor.visitString(hasOutputType(), this.outputType_, other.hasOutputType(), other.outputType_);
                    this.options_ = (MethodOptions) visitor.visitMessage(this.options_, other.options_);
                    this.clientStreaming_ = visitor.visitBoolean(hasClientStreaming(), this.clientStreaming_, other.hasClientStreaming(), other.clientStreaming_);
                    this.serverStreaming_ = visitor.visitBoolean(hasServerStreaming(), this.serverStreaming_, other.hasServerStreaming(), other.serverStreaming_);
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
                                this.name_ = s;
                            } else if (tag == 18) {
                                String s2 = input.readString();
                                this.bitField0_ |= 2;
                                this.inputType_ = s2;
                            } else if (tag == 26) {
                                String s3 = input.readString();
                                this.bitField0_ |= 4;
                                this.outputType_ = s3;
                            } else if (tag == 34) {
                                MethodOptions.Builder subBuilder = null;
                                if ((this.bitField0_ & 8) == 8) {
                                    subBuilder = (MethodOptions.Builder) this.options_.toBuilder();
                                }
                                MethodOptions methodOptions = (MethodOptions) input.readMessage(MethodOptions.parser(), extensionRegistry);
                                this.options_ = methodOptions;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(methodOptions);
                                    this.options_ = (MethodOptions) subBuilder.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            } else if (tag == 40) {
                                this.bitField0_ |= 16;
                                this.clientStreaming_ = input.readBool();
                            } else if (tag == 48) {
                                this.bitField0_ |= 32;
                                this.serverStreaming_ = input.readBool();
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
                        synchronized (MethodDescriptorProto.class) {
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
            MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto();
            DEFAULT_INSTANCE = methodDescriptorProto;
            methodDescriptorProto.makeImmutable();
        }

        public static MethodDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MethodDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FileOptions extends GeneratedMessageLite.ExtendableMessage<FileOptions, Builder> implements FileOptionsOrBuilder {
        public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
        /* access modifiers changed from: private */
        public static final FileOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 23;
        public static final int GO_PACKAGE_FIELD_NUMBER = 11;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
        public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        private static volatile Parser<FileOptions> PARSER = null;
        public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
        public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
        public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean ccEnableArenas_;
        private boolean ccGenericServices_;
        private String csharpNamespace_ = "";
        private boolean deprecated_;
        private String goPackage_ = "";
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private String javaOuterClassname_ = "";
        private String javaPackage_ = "";
        private boolean javaStringCheckUtf8_;
        private byte memoizedIsInitialized = -1;
        private String objcClassPrefix_ = "";
        private int optimizeFor_ = 1;
        private String phpClassPrefix_ = "";
        private boolean phpGenericServices_;
        private String phpNamespace_ = "";
        private boolean pyGenericServices_;
        private String swiftPrefix_ = "";
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private FileOptions() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum OptimizeMode implements Internal.EnumLite {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);
            
            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;
            private static final Internal.EnumLiteMap<OptimizeMode> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<OptimizeMode>() {
                    public OptimizeMode findValueByNumber(int number) {
                        return OptimizeMode.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OptimizeMode valueOf(int value2) {
                return forNumber(value2);
            }

            public static OptimizeMode forNumber(int value2) {
                if (value2 == 1) {
                    return SPEED;
                }
                if (value2 == 2) {
                    return CODE_SIZE;
                }
                if (value2 != 3) {
                    return null;
                }
                return LITE_RUNTIME;
            }

            public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            private OptimizeMode(int value2) {
                this.value = value2;
            }
        }

        public boolean hasJavaPackage() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getJavaPackage() {
            return this.javaPackage_;
        }

        public ByteString getJavaPackageBytes() {
            return ByteString.copyFromUtf8(this.javaPackage_);
        }

        /* access modifiers changed from: private */
        public void setJavaPackage(String value) {
            if (value != null) {
                this.bitField0_ |= 1;
                this.javaPackage_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearJavaPackage() {
            this.bitField0_ &= -2;
            this.javaPackage_ = getDefaultInstance().getJavaPackage();
        }

        /* access modifiers changed from: private */
        public void setJavaPackageBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 1;
                this.javaPackage_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasJavaOuterClassname() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getJavaOuterClassname() {
            return this.javaOuterClassname_;
        }

        public ByteString getJavaOuterClassnameBytes() {
            return ByteString.copyFromUtf8(this.javaOuterClassname_);
        }

        /* access modifiers changed from: private */
        public void setJavaOuterClassname(String value) {
            if (value != null) {
                this.bitField0_ |= 2;
                this.javaOuterClassname_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearJavaOuterClassname() {
            this.bitField0_ &= -3;
            this.javaOuterClassname_ = getDefaultInstance().getJavaOuterClassname();
        }

        /* access modifiers changed from: private */
        public void setJavaOuterClassnameBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 2;
                this.javaOuterClassname_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasJavaMultipleFiles() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        /* access modifiers changed from: private */
        public void setJavaMultipleFiles(boolean value) {
            this.bitField0_ |= 4;
            this.javaMultipleFiles_ = value;
        }

        /* access modifiers changed from: private */
        public void clearJavaMultipleFiles() {
            this.bitField0_ &= -5;
            this.javaMultipleFiles_ = false;
        }

        @Deprecated
        public boolean hasJavaGenerateEqualsAndHash() {
            return (this.bitField0_ & 8) == 8;
        }

        @Deprecated
        public boolean getJavaGenerateEqualsAndHash() {
            return this.javaGenerateEqualsAndHash_;
        }

        /* access modifiers changed from: private */
        public void setJavaGenerateEqualsAndHash(boolean value) {
            this.bitField0_ |= 8;
            this.javaGenerateEqualsAndHash_ = value;
        }

        /* access modifiers changed from: private */
        public void clearJavaGenerateEqualsAndHash() {
            this.bitField0_ &= -9;
            this.javaGenerateEqualsAndHash_ = false;
        }

        public boolean hasJavaStringCheckUtf8() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean getJavaStringCheckUtf8() {
            return this.javaStringCheckUtf8_;
        }

        /* access modifiers changed from: private */
        public void setJavaStringCheckUtf8(boolean value) {
            this.bitField0_ |= 16;
            this.javaStringCheckUtf8_ = value;
        }

        /* access modifiers changed from: private */
        public void clearJavaStringCheckUtf8() {
            this.bitField0_ &= -17;
            this.javaStringCheckUtf8_ = false;
        }

        public boolean hasOptimizeFor() {
            return (this.bitField0_ & 32) == 32;
        }

        public OptimizeMode getOptimizeFor() {
            OptimizeMode result = OptimizeMode.forNumber(this.optimizeFor_);
            return result == null ? OptimizeMode.SPEED : result;
        }

        /* access modifiers changed from: private */
        public void setOptimizeFor(OptimizeMode value) {
            if (value != null) {
                this.bitField0_ |= 32;
                this.optimizeFor_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearOptimizeFor() {
            this.bitField0_ &= -33;
            this.optimizeFor_ = 1;
        }

        public boolean hasGoPackage() {
            return (this.bitField0_ & 64) == 64;
        }

        public String getGoPackage() {
            return this.goPackage_;
        }

        public ByteString getGoPackageBytes() {
            return ByteString.copyFromUtf8(this.goPackage_);
        }

        /* access modifiers changed from: private */
        public void setGoPackage(String value) {
            if (value != null) {
                this.bitField0_ |= 64;
                this.goPackage_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearGoPackage() {
            this.bitField0_ &= -65;
            this.goPackage_ = getDefaultInstance().getGoPackage();
        }

        /* access modifiers changed from: private */
        public void setGoPackageBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 64;
                this.goPackage_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasCcGenericServices() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean getCcGenericServices() {
            return this.ccGenericServices_;
        }

        /* access modifiers changed from: private */
        public void setCcGenericServices(boolean value) {
            this.bitField0_ |= 128;
            this.ccGenericServices_ = value;
        }

        /* access modifiers changed from: private */
        public void clearCcGenericServices() {
            this.bitField0_ &= -129;
            this.ccGenericServices_ = false;
        }

        public boolean hasJavaGenericServices() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean getJavaGenericServices() {
            return this.javaGenericServices_;
        }

        /* access modifiers changed from: private */
        public void setJavaGenericServices(boolean value) {
            this.bitField0_ |= 256;
            this.javaGenericServices_ = value;
        }

        /* access modifiers changed from: private */
        public void clearJavaGenericServices() {
            this.bitField0_ &= -257;
            this.javaGenericServices_ = false;
        }

        public boolean hasPyGenericServices() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean getPyGenericServices() {
            return this.pyGenericServices_;
        }

        /* access modifiers changed from: private */
        public void setPyGenericServices(boolean value) {
            this.bitField0_ |= 512;
            this.pyGenericServices_ = value;
        }

        /* access modifiers changed from: private */
        public void clearPyGenericServices() {
            this.bitField0_ &= -513;
            this.pyGenericServices_ = false;
        }

        public boolean hasPhpGenericServices() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public boolean getPhpGenericServices() {
            return this.phpGenericServices_;
        }

        /* access modifiers changed from: private */
        public void setPhpGenericServices(boolean value) {
            this.bitField0_ |= 1024;
            this.phpGenericServices_ = value;
        }

        /* access modifiers changed from: private */
        public void clearPhpGenericServices() {
            this.bitField0_ &= -1025;
            this.phpGenericServices_ = false;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean value) {
            this.bitField0_ |= 2048;
            this.deprecated_ = value;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2049;
            this.deprecated_ = false;
        }

        public boolean hasCcEnableArenas() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public boolean getCcEnableArenas() {
            return this.ccEnableArenas_;
        }

        /* access modifiers changed from: private */
        public void setCcEnableArenas(boolean value) {
            this.bitField0_ |= 4096;
            this.ccEnableArenas_ = value;
        }

        /* access modifiers changed from: private */
        public void clearCcEnableArenas() {
            this.bitField0_ &= -4097;
            this.ccEnableArenas_ = false;
        }

        public boolean hasObjcClassPrefix() {
            return (this.bitField0_ & 8192) == 8192;
        }

        public String getObjcClassPrefix() {
            return this.objcClassPrefix_;
        }

        public ByteString getObjcClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.objcClassPrefix_);
        }

        /* access modifiers changed from: private */
        public void setObjcClassPrefix(String value) {
            if (value != null) {
                this.bitField0_ |= 8192;
                this.objcClassPrefix_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearObjcClassPrefix() {
            this.bitField0_ &= -8193;
            this.objcClassPrefix_ = getDefaultInstance().getObjcClassPrefix();
        }

        /* access modifiers changed from: private */
        public void setObjcClassPrefixBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 8192;
                this.objcClassPrefix_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasCsharpNamespace() {
            return (this.bitField0_ & 16384) == 16384;
        }

        public String getCsharpNamespace() {
            return this.csharpNamespace_;
        }

        public ByteString getCsharpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.csharpNamespace_);
        }

        /* access modifiers changed from: private */
        public void setCsharpNamespace(String value) {
            if (value != null) {
                this.bitField0_ |= 16384;
                this.csharpNamespace_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearCsharpNamespace() {
            this.bitField0_ &= -16385;
            this.csharpNamespace_ = getDefaultInstance().getCsharpNamespace();
        }

        /* access modifiers changed from: private */
        public void setCsharpNamespaceBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 16384;
                this.csharpNamespace_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasSwiftPrefix() {
            return (this.bitField0_ & 32768) == 32768;
        }

        public String getSwiftPrefix() {
            return this.swiftPrefix_;
        }

        public ByteString getSwiftPrefixBytes() {
            return ByteString.copyFromUtf8(this.swiftPrefix_);
        }

        /* access modifiers changed from: private */
        public void setSwiftPrefix(String value) {
            if (value != null) {
                this.bitField0_ |= 32768;
                this.swiftPrefix_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearSwiftPrefix() {
            this.bitField0_ &= -32769;
            this.swiftPrefix_ = getDefaultInstance().getSwiftPrefix();
        }

        /* access modifiers changed from: private */
        public void setSwiftPrefixBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 32768;
                this.swiftPrefix_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasPhpClassPrefix() {
            return (this.bitField0_ & 65536) == 65536;
        }

        public String getPhpClassPrefix() {
            return this.phpClassPrefix_;
        }

        public ByteString getPhpClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.phpClassPrefix_);
        }

        /* access modifiers changed from: private */
        public void setPhpClassPrefix(String value) {
            if (value != null) {
                this.bitField0_ |= 65536;
                this.phpClassPrefix_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearPhpClassPrefix() {
            this.bitField0_ &= -65537;
            this.phpClassPrefix_ = getDefaultInstance().getPhpClassPrefix();
        }

        /* access modifiers changed from: private */
        public void setPhpClassPrefixBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 65536;
                this.phpClassPrefix_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasPhpNamespace() {
            return (this.bitField0_ & 131072) == 131072;
        }

        public String getPhpNamespace() {
            return this.phpNamespace_;
        }

        public ByteString getPhpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.phpNamespace_);
        }

        /* access modifiers changed from: private */
        public void setPhpNamespace(String value) {
            if (value != null) {
                this.bitField0_ |= 131072;
                this.phpNamespace_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearPhpNamespace() {
            this.bitField0_ &= -131073;
            this.phpNamespace_ = getDefaultInstance().getPhpNamespace();
        }

        /* access modifiers changed from: private */
        public void setPhpNamespaceBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 131072;
                this.phpNamespace_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(values, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int index) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(1, getJavaPackage());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeString(8, getJavaOuterClassname());
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeEnum(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeBool(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                output.writeString(11, getGoPackage());
            }
            if ((this.bitField0_ & 128) == 128) {
                output.writeBool(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                output.writeBool(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                output.writeBool(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeBool(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                output.writeBool(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeBool(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                output.writeBool(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                output.writeString(36, getObjcClassPrefix());
            }
            if ((this.bitField0_ & 16384) == 16384) {
                output.writeString(37, getCsharpNamespace());
            }
            if ((this.bitField0_ & 32768) == 32768) {
                output.writeString(39, getSwiftPrefix());
            }
            if ((this.bitField0_ & 65536) == 65536) {
                output.writeString(40, getPhpClassPrefix());
            }
            if ((this.bitField0_ & 131072) == 131072) {
                output.writeString(41, getPhpNamespace());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                output.writeBool(42, this.phpGenericServices_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(536870912, output);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                size2 = 0 + CodedOutputStream.computeStringSize(1, getJavaPackage());
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeStringSize(8, getJavaOuterClassname());
            }
            if ((this.bitField0_ & 32) == 32) {
                size2 += CodedOutputStream.computeEnumSize(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeBoolSize(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                size2 += CodedOutputStream.computeStringSize(11, getGoPackage());
            }
            if ((this.bitField0_ & 128) == 128) {
                size2 += CodedOutputStream.computeBoolSize(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                size2 += CodedOutputStream.computeBoolSize(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                size2 += CodedOutputStream.computeBoolSize(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeBoolSize(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                size2 += CodedOutputStream.computeBoolSize(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                size2 += CodedOutputStream.computeBoolSize(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                size2 += CodedOutputStream.computeBoolSize(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                size2 += CodedOutputStream.computeStringSize(36, getObjcClassPrefix());
            }
            if ((this.bitField0_ & 16384) == 16384) {
                size2 += CodedOutputStream.computeStringSize(37, getCsharpNamespace());
            }
            if ((this.bitField0_ & 32768) == 32768) {
                size2 += CodedOutputStream.computeStringSize(39, getSwiftPrefix());
            }
            if ((this.bitField0_ & 65536) == 65536) {
                size2 += CodedOutputStream.computeStringSize(40, getPhpClassPrefix());
            }
            if ((this.bitField0_ & 131072) == 131072) {
                size2 += CodedOutputStream.computeStringSize(41, getPhpNamespace());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                size2 += CodedOutputStream.computeBoolSize(42, this.phpGenericServices_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static FileOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FileOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FileOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FileOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FileOptions parseFrom(InputStream input) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FileOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FileOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (FileOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FileOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FileOptions parseFrom(CodedInputStream input) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FileOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FileOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(FileOptions.DEFAULT_INSTANCE);
            }

            public boolean hasJavaPackage() {
                return ((FileOptions) this.instance).hasJavaPackage();
            }

            public String getJavaPackage() {
                return ((FileOptions) this.instance).getJavaPackage();
            }

            public ByteString getJavaPackageBytes() {
                return ((FileOptions) this.instance).getJavaPackageBytes();
            }

            public Builder setJavaPackage(String value) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaPackage(value);
                return this;
            }

            public Builder clearJavaPackage() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaPackage();
                return this;
            }

            public Builder setJavaPackageBytes(ByteString value) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaPackageBytes(value);
                return this;
            }

            public boolean hasJavaOuterClassname() {
                return ((FileOptions) this.instance).hasJavaOuterClassname();
            }

            public String getJavaOuterClassname() {
                return ((FileOptions) this.instance).getJavaOuterClassname();
            }

            public ByteString getJavaOuterClassnameBytes() {
                return ((FileOptions) this.instance).getJavaOuterClassnameBytes();
            }

            public Builder setJavaOuterClassname(String value) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaOuterClassname(value);
                return this;
            }

            public Builder clearJavaOuterClassname() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaOuterClassname();
                return this;
            }

            public Builder setJavaOuterClassnameBytes(ByteString value) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaOuterClassnameBytes(value);
                return this;
            }

            public boolean hasJavaMultipleFiles() {
                return ((FileOptions) this.instance).hasJavaMultipleFiles();
            }

            public boolean getJavaMultipleFiles() {
                return ((FileOptions) this.instance).getJavaMultipleFiles();
            }

            public Builder setJavaMultipleFiles(boolean value) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaMultipleFiles(value);
                return this;
            }

            public Builder clearJavaMultipleFiles() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaMultipleFiles();
                return this;
            }

            @Deprecated
            public boolean hasJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.instance).hasJavaGenerateEqualsAndHash();
            }

            @Deprecated
            public boolean getJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.instance).getJavaGenerateEqualsAndHash();
            }

            @Deprecated
            public Builder setJavaGenerateEqualsAndHash(boolean value) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaGenerateEqualsAndHash(value);
                return this;
            }

            @Deprecated
            public Builder clearJavaGenerateEqualsAndHash() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaGenerateEqualsAndHash();
                return this;
            }

            public boolean hasJavaStringCheckUtf8() {
                return ((FileOptions) this.instance).hasJavaStringCheckUtf8();
            }

            public boolean getJavaStringCheckUtf8() {
                return ((FileOptions) this.instance).getJavaStringCheckUtf8();
            }

            public Builder setJavaStringCheckUtf8(boolean value) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaStringCheckUtf8(value);
                return this;
            }

            public Builder clearJavaStringCheckUtf8() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaStringCheckUtf8();
                return this;
            }

            public boolean hasOptimizeFor() {
                return ((FileOptions) this.instance).hasOptimizeFor();
            }

            public OptimizeMode getOptimizeFor() {
                return ((FileOptions) this.instance).getOptimizeFor();
            }

            public Builder setOptimizeFor(OptimizeMode value) {
                copyOnWrite();
                ((FileOptions) this.instance).setOptimizeFor(value);
                return this;
            }

            public Builder clearOptimizeFor() {
                copyOnWrite();
                ((FileOptions) this.instance).clearOptimizeFor();
                return this;
            }

            public boolean hasGoPackage() {
                return ((FileOptions) this.instance).hasGoPackage();
            }

            public String getGoPackage() {
                return ((FileOptions) this.instance).getGoPackage();
            }

            public ByteString getGoPackageBytes() {
                return ((FileOptions) this.instance).getGoPackageBytes();
            }

            public Builder setGoPackage(String value) {
                copyOnWrite();
                ((FileOptions) this.instance).setGoPackage(value);
                return this;
            }

            public Builder clearGoPackage() {
                copyOnWrite();
                ((FileOptions) this.instance).clearGoPackage();
                return this;
            }

            public Builder setGoPackageBytes(ByteString value) {
                copyOnWrite();
                ((FileOptions) this.instance).setGoPackageBytes(value);
                return this;
            }

            public boolean hasCcGenericServices() {
                return ((FileOptions) this.instance).hasCcGenericServices();
            }

            public boolean getCcGenericServices() {
                return ((FileOptions) this.instance).getCcGenericServices();
            }

            public Builder setCcGenericServices(boolean value) {
                copyOnWrite();
                ((FileOptions) this.instance).setCcGenericServices(value);
                return this;
            }

            public Builder clearCcGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearCcGenericServices();
                return this;
            }

            public boolean hasJavaGenericServices() {
                return ((FileOptions) this.instance).hasJavaGenericServices();
            }

            public boolean getJavaGenericServices() {
                return ((FileOptions) this.instance).getJavaGenericServices();
            }

            public Builder setJavaGenericServices(boolean value) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaGenericServices(value);
                return this;
            }

            public Builder clearJavaGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaGenericServices();
                return this;
            }

            public boolean hasPyGenericServices() {
                return ((FileOptions) this.instance).hasPyGenericServices();
            }

            public boolean getPyGenericServices() {
                return ((FileOptions) this.instance).getPyGenericServices();
            }

            public Builder setPyGenericServices(boolean value) {
                copyOnWrite();
                ((FileOptions) this.instance).setPyGenericServices(value);
                return this;
            }

            public Builder clearPyGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPyGenericServices();
                return this;
            }

            public boolean hasPhpGenericServices() {
                return ((FileOptions) this.instance).hasPhpGenericServices();
            }

            public boolean getPhpGenericServices() {
                return ((FileOptions) this.instance).getPhpGenericServices();
            }

            public Builder setPhpGenericServices(boolean value) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpGenericServices(value);
                return this;
            }

            public Builder clearPhpGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpGenericServices();
                return this;
            }

            public boolean hasDeprecated() {
                return ((FileOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((FileOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean value) {
                copyOnWrite();
                ((FileOptions) this.instance).setDeprecated(value);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((FileOptions) this.instance).clearDeprecated();
                return this;
            }

            public boolean hasCcEnableArenas() {
                return ((FileOptions) this.instance).hasCcEnableArenas();
            }

            public boolean getCcEnableArenas() {
                return ((FileOptions) this.instance).getCcEnableArenas();
            }

            public Builder setCcEnableArenas(boolean value) {
                copyOnWrite();
                ((FileOptions) this.instance).setCcEnableArenas(value);
                return this;
            }

            public Builder clearCcEnableArenas() {
                copyOnWrite();
                ((FileOptions) this.instance).clearCcEnableArenas();
                return this;
            }

            public boolean hasObjcClassPrefix() {
                return ((FileOptions) this.instance).hasObjcClassPrefix();
            }

            public String getObjcClassPrefix() {
                return ((FileOptions) this.instance).getObjcClassPrefix();
            }

            public ByteString getObjcClassPrefixBytes() {
                return ((FileOptions) this.instance).getObjcClassPrefixBytes();
            }

            public Builder setObjcClassPrefix(String value) {
                copyOnWrite();
                ((FileOptions) this.instance).setObjcClassPrefix(value);
                return this;
            }

            public Builder clearObjcClassPrefix() {
                copyOnWrite();
                ((FileOptions) this.instance).clearObjcClassPrefix();
                return this;
            }

            public Builder setObjcClassPrefixBytes(ByteString value) {
                copyOnWrite();
                ((FileOptions) this.instance).setObjcClassPrefixBytes(value);
                return this;
            }

            public boolean hasCsharpNamespace() {
                return ((FileOptions) this.instance).hasCsharpNamespace();
            }

            public String getCsharpNamespace() {
                return ((FileOptions) this.instance).getCsharpNamespace();
            }

            public ByteString getCsharpNamespaceBytes() {
                return ((FileOptions) this.instance).getCsharpNamespaceBytes();
            }

            public Builder setCsharpNamespace(String value) {
                copyOnWrite();
                ((FileOptions) this.instance).setCsharpNamespace(value);
                return this;
            }

            public Builder clearCsharpNamespace() {
                copyOnWrite();
                ((FileOptions) this.instance).clearCsharpNamespace();
                return this;
            }

            public Builder setCsharpNamespaceBytes(ByteString value) {
                copyOnWrite();
                ((FileOptions) this.instance).setCsharpNamespaceBytes(value);
                return this;
            }

            public boolean hasSwiftPrefix() {
                return ((FileOptions) this.instance).hasSwiftPrefix();
            }

            public String getSwiftPrefix() {
                return ((FileOptions) this.instance).getSwiftPrefix();
            }

            public ByteString getSwiftPrefixBytes() {
                return ((FileOptions) this.instance).getSwiftPrefixBytes();
            }

            public Builder setSwiftPrefix(String value) {
                copyOnWrite();
                ((FileOptions) this.instance).setSwiftPrefix(value);
                return this;
            }

            public Builder clearSwiftPrefix() {
                copyOnWrite();
                ((FileOptions) this.instance).clearSwiftPrefix();
                return this;
            }

            public Builder setSwiftPrefixBytes(ByteString value) {
                copyOnWrite();
                ((FileOptions) this.instance).setSwiftPrefixBytes(value);
                return this;
            }

            public boolean hasPhpClassPrefix() {
                return ((FileOptions) this.instance).hasPhpClassPrefix();
            }

            public String getPhpClassPrefix() {
                return ((FileOptions) this.instance).getPhpClassPrefix();
            }

            public ByteString getPhpClassPrefixBytes() {
                return ((FileOptions) this.instance).getPhpClassPrefixBytes();
            }

            public Builder setPhpClassPrefix(String value) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpClassPrefix(value);
                return this;
            }

            public Builder clearPhpClassPrefix() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpClassPrefix();
                return this;
            }

            public Builder setPhpClassPrefixBytes(ByteString value) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpClassPrefixBytes(value);
                return this;
            }

            public boolean hasPhpNamespace() {
                return ((FileOptions) this.instance).hasPhpNamespace();
            }

            public String getPhpNamespace() {
                return ((FileOptions) this.instance).getPhpNamespace();
            }

            public ByteString getPhpNamespaceBytes() {
                return ((FileOptions) this.instance).getPhpNamespaceBytes();
            }

            public Builder setPhpNamespace(String value) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpNamespace(value);
                return this;
            }

            public Builder clearPhpNamespace() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpNamespace();
                return this;
            }

            public Builder setPhpNamespaceBytes(ByteString value) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpNamespaceBytes(value);
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FileOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((FileOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return ((FileOptions) this.instance).getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((FileOptions) this.instance).setUninterpretedOption(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((FileOptions) this.instance).setUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(value);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(index, value);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                copyOnWrite();
                ((FileOptions) this.instance).addAllUninterpretedOption(values);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((FileOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                copyOnWrite();
                ((FileOptions) this.instance).removeUninterpretedOption(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new FileOptions();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (extensionsAreInitialized() == 0) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    FileOptions other = (FileOptions) arg1;
                    this.javaPackage_ = visitor.visitString(hasJavaPackage(), this.javaPackage_, other.hasJavaPackage(), other.javaPackage_);
                    this.javaOuterClassname_ = visitor.visitString(hasJavaOuterClassname(), this.javaOuterClassname_, other.hasJavaOuterClassname(), other.javaOuterClassname_);
                    this.javaMultipleFiles_ = visitor.visitBoolean(hasJavaMultipleFiles(), this.javaMultipleFiles_, other.hasJavaMultipleFiles(), other.javaMultipleFiles_);
                    this.javaGenerateEqualsAndHash_ = visitor.visitBoolean(hasJavaGenerateEqualsAndHash(), this.javaGenerateEqualsAndHash_, other.hasJavaGenerateEqualsAndHash(), other.javaGenerateEqualsAndHash_);
                    this.javaStringCheckUtf8_ = visitor.visitBoolean(hasJavaStringCheckUtf8(), this.javaStringCheckUtf8_, other.hasJavaStringCheckUtf8(), other.javaStringCheckUtf8_);
                    this.optimizeFor_ = visitor.visitInt(hasOptimizeFor(), this.optimizeFor_, other.hasOptimizeFor(), other.optimizeFor_);
                    this.goPackage_ = visitor.visitString(hasGoPackage(), this.goPackage_, other.hasGoPackage(), other.goPackage_);
                    this.ccGenericServices_ = visitor.visitBoolean(hasCcGenericServices(), this.ccGenericServices_, other.hasCcGenericServices(), other.ccGenericServices_);
                    this.javaGenericServices_ = visitor.visitBoolean(hasJavaGenericServices(), this.javaGenericServices_, other.hasJavaGenericServices(), other.javaGenericServices_);
                    this.pyGenericServices_ = visitor.visitBoolean(hasPyGenericServices(), this.pyGenericServices_, other.hasPyGenericServices(), other.pyGenericServices_);
                    this.phpGenericServices_ = visitor.visitBoolean(hasPhpGenericServices(), this.phpGenericServices_, other.hasPhpGenericServices(), other.phpGenericServices_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, other.hasDeprecated(), other.deprecated_);
                    this.ccEnableArenas_ = visitor.visitBoolean(hasCcEnableArenas(), this.ccEnableArenas_, other.hasCcEnableArenas(), other.ccEnableArenas_);
                    this.objcClassPrefix_ = visitor.visitString(hasObjcClassPrefix(), this.objcClassPrefix_, other.hasObjcClassPrefix(), other.objcClassPrefix_);
                    this.csharpNamespace_ = visitor.visitString(hasCsharpNamespace(), this.csharpNamespace_, other.hasCsharpNamespace(), other.csharpNamespace_);
                    this.swiftPrefix_ = visitor.visitString(hasSwiftPrefix(), this.swiftPrefix_, other.hasSwiftPrefix(), other.swiftPrefix_);
                    this.phpClassPrefix_ = visitor.visitString(hasPhpClassPrefix(), this.phpClassPrefix_, other.hasPhpClassPrefix(), other.phpClassPrefix_);
                    this.phpNamespace_ = visitor.visitString(hasPhpNamespace(), this.phpNamespace_, other.hasPhpNamespace(), other.phpNamespace_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, other.uninterpretedOption_);
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
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 10:
                                    String s = input.readString();
                                    this.bitField0_ |= 1;
                                    this.javaPackage_ = s;
                                    break;
                                case 66:
                                    String s2 = input.readString();
                                    this.bitField0_ |= 2;
                                    this.javaOuterClassname_ = s2;
                                    break;
                                case 72:
                                    int rawValue = input.readEnum();
                                    if (OptimizeMode.forNumber(rawValue) != null) {
                                        this.bitField0_ |= 32;
                                        this.optimizeFor_ = rawValue;
                                        break;
                                    } else {
                                        super.mergeVarintField(9, rawValue);
                                        break;
                                    }
                                case 80:
                                    this.bitField0_ |= 4;
                                    this.javaMultipleFiles_ = input.readBool();
                                    break;
                                case 90:
                                    String s3 = input.readString();
                                    this.bitField0_ |= 64;
                                    this.goPackage_ = s3;
                                    break;
                                case 128:
                                    this.bitField0_ |= 128;
                                    this.ccGenericServices_ = input.readBool();
                                    break;
                                case 136:
                                    this.bitField0_ |= 256;
                                    this.javaGenericServices_ = input.readBool();
                                    break;
                                case 144:
                                    this.bitField0_ |= 512;
                                    this.pyGenericServices_ = input.readBool();
                                    break;
                                case 160:
                                    this.bitField0_ |= 8;
                                    this.javaGenerateEqualsAndHash_ = input.readBool();
                                    break;
                                case 184:
                                    this.bitField0_ |= 2048;
                                    this.deprecated_ = input.readBool();
                                    break;
                                case 216:
                                    this.bitField0_ |= 16;
                                    this.javaStringCheckUtf8_ = input.readBool();
                                    break;
                                case 248:
                                    this.bitField0_ |= 4096;
                                    this.ccEnableArenas_ = input.readBool();
                                    break;
                                case 290:
                                    String s4 = input.readString();
                                    this.bitField0_ |= 8192;
                                    this.objcClassPrefix_ = s4;
                                    break;
                                case 298:
                                    String s5 = input.readString();
                                    this.bitField0_ |= 16384;
                                    this.csharpNamespace_ = s5;
                                    break;
                                case 314:
                                    String s6 = input.readString();
                                    this.bitField0_ |= 32768;
                                    this.swiftPrefix_ = s6;
                                    break;
                                case 322:
                                    String s7 = input.readString();
                                    this.bitField0_ |= 65536;
                                    this.phpClassPrefix_ = s7;
                                    break;
                                case 330:
                                    String s8 = input.readString();
                                    this.bitField0_ |= 131072;
                                    this.phpNamespace_ = s8;
                                    break;
                                case 336:
                                    this.bitField0_ |= 1024;
                                    this.phpGenericServices_ = input.readBool();
                                    break;
                                case 7994:
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) input.readMessage(UninterpretedOption.parser(), extensionRegistry));
                                    break;
                                default:
                                    if (parseUnknownField((FileOptions) getDefaultInstanceForType(), input, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
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
                        synchronized (FileOptions.class) {
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
            FileOptions fileOptions = new FileOptions();
            DEFAULT_INSTANCE = fileOptions;
            fileOptions.makeImmutable();
        }

        public static FileOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class MessageOptions extends GeneratedMessageLite.ExtendableMessage<MessageOptions, Builder> implements MessageOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final MessageOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int MAP_ENTRY_FIELD_NUMBER = 7;
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        private static volatile Parser<MessageOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private boolean mapEntry_;
        private byte memoizedIsInitialized = -1;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private MessageOptions() {
        }

        public boolean hasMessageSetWireFormat() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        /* access modifiers changed from: private */
        public void setMessageSetWireFormat(boolean value) {
            this.bitField0_ |= 1;
            this.messageSetWireFormat_ = value;
        }

        /* access modifiers changed from: private */
        public void clearMessageSetWireFormat() {
            this.bitField0_ &= -2;
            this.messageSetWireFormat_ = false;
        }

        public boolean hasNoStandardDescriptorAccessor() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        /* access modifiers changed from: private */
        public void setNoStandardDescriptorAccessor(boolean value) {
            this.bitField0_ |= 2;
            this.noStandardDescriptorAccessor_ = value;
        }

        /* access modifiers changed from: private */
        public void clearNoStandardDescriptorAccessor() {
            this.bitField0_ &= -3;
            this.noStandardDescriptorAccessor_ = false;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean value) {
            this.bitField0_ |= 4;
            this.deprecated_ = value;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -5;
            this.deprecated_ = false;
        }

        public boolean hasMapEntry() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean getMapEntry() {
            return this.mapEntry_;
        }

        /* access modifiers changed from: private */
        public void setMapEntry(boolean value) {
            this.bitField0_ |= 8;
            this.mapEntry_ = value;
        }

        /* access modifiers changed from: private */
        public void clearMapEntry() {
            this.bitField0_ &= -9;
            this.mapEntry_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(values, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int index) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBool(1, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBool(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeBool(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeBool(7, this.mapEntry_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(536870912, output);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeBoolSize(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeBoolSize(7, this.mapEntry_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static MessageOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MessageOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MessageOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MessageOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MessageOptions parseFrom(InputStream input) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MessageOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MessageOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (MessageOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static MessageOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MessageOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MessageOptions parseFrom(CodedInputStream input) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MessageOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MessageOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(MessageOptions.DEFAULT_INSTANCE);
            }

            public boolean hasMessageSetWireFormat() {
                return ((MessageOptions) this.instance).hasMessageSetWireFormat();
            }

            public boolean getMessageSetWireFormat() {
                return ((MessageOptions) this.instance).getMessageSetWireFormat();
            }

            public Builder setMessageSetWireFormat(boolean value) {
                copyOnWrite();
                ((MessageOptions) this.instance).setMessageSetWireFormat(value);
                return this;
            }

            public Builder clearMessageSetWireFormat() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearMessageSetWireFormat();
                return this;
            }

            public boolean hasNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.instance).hasNoStandardDescriptorAccessor();
            }

            public boolean getNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.instance).getNoStandardDescriptorAccessor();
            }

            public Builder setNoStandardDescriptorAccessor(boolean value) {
                copyOnWrite();
                ((MessageOptions) this.instance).setNoStandardDescriptorAccessor(value);
                return this;
            }

            public Builder clearNoStandardDescriptorAccessor() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearNoStandardDescriptorAccessor();
                return this;
            }

            public boolean hasDeprecated() {
                return ((MessageOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((MessageOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean value) {
                copyOnWrite();
                ((MessageOptions) this.instance).setDeprecated(value);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearDeprecated();
                return this;
            }

            public boolean hasMapEntry() {
                return ((MessageOptions) this.instance).hasMapEntry();
            }

            public boolean getMapEntry() {
                return ((MessageOptions) this.instance).getMapEntry();
            }

            public Builder setMapEntry(boolean value) {
                copyOnWrite();
                ((MessageOptions) this.instance).setMapEntry(value);
                return this;
            }

            public Builder clearMapEntry() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearMapEntry();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MessageOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((MessageOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return ((MessageOptions) this.instance).getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((MessageOptions) this.instance).setUninterpretedOption(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((MessageOptions) this.instance).setUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(value);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(index, value);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                copyOnWrite();
                ((MessageOptions) this.instance).addAllUninterpretedOption(values);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                copyOnWrite();
                ((MessageOptions) this.instance).removeUninterpretedOption(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new MessageOptions();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (extensionsAreInitialized() == 0) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    MessageOptions other = (MessageOptions) arg1;
                    this.messageSetWireFormat_ = visitor.visitBoolean(hasMessageSetWireFormat(), this.messageSetWireFormat_, other.hasMessageSetWireFormat(), other.messageSetWireFormat_);
                    this.noStandardDescriptorAccessor_ = visitor.visitBoolean(hasNoStandardDescriptorAccessor(), this.noStandardDescriptorAccessor_, other.hasNoStandardDescriptorAccessor(), other.noStandardDescriptorAccessor_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, other.hasDeprecated(), other.deprecated_);
                    this.mapEntry_ = visitor.visitBoolean(hasMapEntry(), this.mapEntry_, other.hasMapEntry(), other.mapEntry_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, other.uninterpretedOption_);
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
                            } else if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.messageSetWireFormat_ = input.readBool();
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.noStandardDescriptorAccessor_ = input.readBool();
                            } else if (tag == 24) {
                                this.bitField0_ |= 4;
                                this.deprecated_ = input.readBool();
                            } else if (tag == 56) {
                                this.bitField0_ = 8 | this.bitField0_;
                                this.mapEntry_ = input.readBool();
                            } else if (tag == 7994) {
                                if (!this.uninterpretedOption_.isModifiable()) {
                                    this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                }
                                this.uninterpretedOption_.add((UninterpretedOption) input.readMessage(UninterpretedOption.parser(), extensionRegistry));
                            } else if (!parseUnknownField((MessageOptions) getDefaultInstanceForType(), input, extensionRegistry, tag)) {
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
                        synchronized (MessageOptions.class) {
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
            MessageOptions messageOptions = new MessageOptions();
            DEFAULT_INSTANCE = messageOptions;
            messageOptions.makeImmutable();
        }

        public static MessageOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MessageOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FieldOptions extends GeneratedMessageLite.ExtendableMessage<FieldOptions, Builder> implements FieldOptionsOrBuilder {
        public static final int CTYPE_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final FieldOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int JSTYPE_FIELD_NUMBER = 6;
        public static final int LAZY_FIELD_NUMBER = 5;
        public static final int PACKED_FIELD_NUMBER = 2;
        private static volatile Parser<FieldOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int WEAK_FIELD_NUMBER = 10;
        private int bitField0_;
        private int ctype_;
        private boolean deprecated_;
        private int jstype_;
        private boolean lazy_;
        private byte memoizedIsInitialized = -1;
        private boolean packed_;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();
        private boolean weak_;

        private FieldOptions() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum CType implements Internal.EnumLite {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);
            
            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;
            private static final Internal.EnumLiteMap<CType> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<CType>() {
                    public CType findValueByNumber(int number) {
                        return CType.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static CType valueOf(int value2) {
                return forNumber(value2);
            }

            public static CType forNumber(int value2) {
                if (value2 == 0) {
                    return STRING;
                }
                if (value2 == 1) {
                    return CORD;
                }
                if (value2 != 2) {
                    return null;
                }
                return STRING_PIECE;
            }

            public static Internal.EnumLiteMap<CType> internalGetValueMap() {
                return internalValueMap;
            }

            private CType(int value2) {
                this.value = value2;
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum JSType implements Internal.EnumLite {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);
            
            public static final int JS_NORMAL_VALUE = 0;
            public static final int JS_NUMBER_VALUE = 2;
            public static final int JS_STRING_VALUE = 1;
            private static final Internal.EnumLiteMap<JSType> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<JSType>() {
                    public JSType findValueByNumber(int number) {
                        return JSType.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static JSType valueOf(int value2) {
                return forNumber(value2);
            }

            public static JSType forNumber(int value2) {
                if (value2 == 0) {
                    return JS_NORMAL;
                }
                if (value2 == 1) {
                    return JS_STRING;
                }
                if (value2 != 2) {
                    return null;
                }
                return JS_NUMBER;
            }

            public static Internal.EnumLiteMap<JSType> internalGetValueMap() {
                return internalValueMap;
            }

            private JSType(int value2) {
                this.value = value2;
            }
        }

        public boolean hasCtype() {
            return (this.bitField0_ & 1) == 1;
        }

        public CType getCtype() {
            CType result = CType.forNumber(this.ctype_);
            return result == null ? CType.STRING : result;
        }

        /* access modifiers changed from: private */
        public void setCtype(CType value) {
            if (value != null) {
                this.bitField0_ |= 1;
                this.ctype_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearCtype() {
            this.bitField0_ &= -2;
            this.ctype_ = 0;
        }

        public boolean hasPacked() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean getPacked() {
            return this.packed_;
        }

        /* access modifiers changed from: private */
        public void setPacked(boolean value) {
            this.bitField0_ |= 2;
            this.packed_ = value;
        }

        /* access modifiers changed from: private */
        public void clearPacked() {
            this.bitField0_ &= -3;
            this.packed_ = false;
        }

        public boolean hasJstype() {
            return (this.bitField0_ & 4) == 4;
        }

        public JSType getJstype() {
            JSType result = JSType.forNumber(this.jstype_);
            return result == null ? JSType.JS_NORMAL : result;
        }

        /* access modifiers changed from: private */
        public void setJstype(JSType value) {
            if (value != null) {
                this.bitField0_ |= 4;
                this.jstype_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearJstype() {
            this.bitField0_ &= -5;
            this.jstype_ = 0;
        }

        public boolean hasLazy() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean getLazy() {
            return this.lazy_;
        }

        /* access modifiers changed from: private */
        public void setLazy(boolean value) {
            this.bitField0_ |= 8;
            this.lazy_ = value;
        }

        /* access modifiers changed from: private */
        public void clearLazy() {
            this.bitField0_ &= -9;
            this.lazy_ = false;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean value) {
            this.bitField0_ |= 16;
            this.deprecated_ = value;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -17;
            this.deprecated_ = false;
        }

        public boolean hasWeak() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean getWeak() {
            return this.weak_;
        }

        /* access modifiers changed from: private */
        public void setWeak(boolean value) {
            this.bitField0_ |= 32;
            this.weak_ = value;
        }

        /* access modifiers changed from: private */
        public void clearWeak() {
            this.bitField0_ &= -33;
            this.weak_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(values, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int index) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeEnum(1, this.ctype_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBool(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeBool(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeBool(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeEnum(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeBool(10, this.weak_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(536870912, output);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.ctype_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeBoolSize(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                size2 += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeBoolSize(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeEnumSize(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                size2 += CodedOutputStream.computeBoolSize(10, this.weak_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static FieldOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldOptions parseFrom(InputStream input) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (FieldOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldOptions parseFrom(CodedInputStream input) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(FieldOptions.DEFAULT_INSTANCE);
            }

            public boolean hasCtype() {
                return ((FieldOptions) this.instance).hasCtype();
            }

            public CType getCtype() {
                return ((FieldOptions) this.instance).getCtype();
            }

            public Builder setCtype(CType value) {
                copyOnWrite();
                ((FieldOptions) this.instance).setCtype(value);
                return this;
            }

            public Builder clearCtype() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearCtype();
                return this;
            }

            public boolean hasPacked() {
                return ((FieldOptions) this.instance).hasPacked();
            }

            public boolean getPacked() {
                return ((FieldOptions) this.instance).getPacked();
            }

            public Builder setPacked(boolean value) {
                copyOnWrite();
                ((FieldOptions) this.instance).setPacked(value);
                return this;
            }

            public Builder clearPacked() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearPacked();
                return this;
            }

            public boolean hasJstype() {
                return ((FieldOptions) this.instance).hasJstype();
            }

            public JSType getJstype() {
                return ((FieldOptions) this.instance).getJstype();
            }

            public Builder setJstype(JSType value) {
                copyOnWrite();
                ((FieldOptions) this.instance).setJstype(value);
                return this;
            }

            public Builder clearJstype() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearJstype();
                return this;
            }

            public boolean hasLazy() {
                return ((FieldOptions) this.instance).hasLazy();
            }

            public boolean getLazy() {
                return ((FieldOptions) this.instance).getLazy();
            }

            public Builder setLazy(boolean value) {
                copyOnWrite();
                ((FieldOptions) this.instance).setLazy(value);
                return this;
            }

            public Builder clearLazy() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearLazy();
                return this;
            }

            public boolean hasDeprecated() {
                return ((FieldOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((FieldOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean value) {
                copyOnWrite();
                ((FieldOptions) this.instance).setDeprecated(value);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearDeprecated();
                return this;
            }

            public boolean hasWeak() {
                return ((FieldOptions) this.instance).hasWeak();
            }

            public boolean getWeak() {
                return ((FieldOptions) this.instance).getWeak();
            }

            public Builder setWeak(boolean value) {
                copyOnWrite();
                ((FieldOptions) this.instance).setWeak(value);
                return this;
            }

            public Builder clearWeak() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearWeak();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FieldOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((FieldOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return ((FieldOptions) this.instance).getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((FieldOptions) this.instance).setUninterpretedOption(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((FieldOptions) this.instance).setUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(value);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(index, value);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                copyOnWrite();
                ((FieldOptions) this.instance).addAllUninterpretedOption(values);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                copyOnWrite();
                ((FieldOptions) this.instance).removeUninterpretedOption(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new FieldOptions();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (extensionsAreInitialized() == 0) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    FieldOptions other = (FieldOptions) arg1;
                    this.ctype_ = visitor.visitInt(hasCtype(), this.ctype_, other.hasCtype(), other.ctype_);
                    this.packed_ = visitor.visitBoolean(hasPacked(), this.packed_, other.hasPacked(), other.packed_);
                    this.jstype_ = visitor.visitInt(hasJstype(), this.jstype_, other.hasJstype(), other.jstype_);
                    this.lazy_ = visitor.visitBoolean(hasLazy(), this.lazy_, other.hasLazy(), other.lazy_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, other.hasDeprecated(), other.deprecated_);
                    this.weak_ = visitor.visitBoolean(hasWeak(), this.weak_, other.hasWeak(), other.weak_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, other.uninterpretedOption_);
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
                            } else if (tag == 8) {
                                int rawValue = input.readEnum();
                                if (CType.forNumber(rawValue) == null) {
                                    super.mergeVarintField(1, rawValue);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.ctype_ = rawValue;
                                }
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.packed_ = input.readBool();
                            } else if (tag == 24) {
                                this.bitField0_ |= 16;
                                this.deprecated_ = input.readBool();
                            } else if (tag == 40) {
                                this.bitField0_ = 8 | this.bitField0_;
                                this.lazy_ = input.readBool();
                            } else if (tag == 48) {
                                int rawValue2 = input.readEnum();
                                if (JSType.forNumber(rawValue2) == null) {
                                    super.mergeVarintField(6, rawValue2);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.jstype_ = rawValue2;
                                }
                            } else if (tag == 80) {
                                this.bitField0_ |= 32;
                                this.weak_ = input.readBool();
                            } else if (tag == 7994) {
                                if (!this.uninterpretedOption_.isModifiable()) {
                                    this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                }
                                this.uninterpretedOption_.add((UninterpretedOption) input.readMessage(UninterpretedOption.parser(), extensionRegistry));
                            } else if (!parseUnknownField((FieldOptions) getDefaultInstanceForType(), input, extensionRegistry, tag)) {
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
                        synchronized (FieldOptions.class) {
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
            FieldOptions fieldOptions = new FieldOptions();
            DEFAULT_INSTANCE = fieldOptions;
            fieldOptions.makeImmutable();
        }

        public static FieldOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FieldOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class OneofOptions extends GeneratedMessageLite.ExtendableMessage<OneofOptions, Builder> implements OneofOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final OneofOptions DEFAULT_INSTANCE;
        private static volatile Parser<OneofOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private OneofOptions() {
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(values, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int index) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(536870912, output);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static OneofOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static OneofOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static OneofOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static OneofOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static OneofOptions parseFrom(InputStream input) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static OneofOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static OneofOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (OneofOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static OneofOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OneofOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static OneofOptions parseFrom(CodedInputStream input) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static OneofOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OneofOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<OneofOptions, Builder> implements OneofOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(OneofOptions.DEFAULT_INSTANCE);
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((OneofOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((OneofOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return ((OneofOptions) this.instance).getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((OneofOptions) this.instance).setUninterpretedOption(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((OneofOptions) this.instance).setUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(value);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(index, value);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                copyOnWrite();
                ((OneofOptions) this.instance).addAllUninterpretedOption(values);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((OneofOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                copyOnWrite();
                ((OneofOptions) this.instance).removeUninterpretedOption(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new OneofOptions();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (extensionsAreInitialized() == 0) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    this.uninterpretedOption_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.uninterpretedOption_, ((OneofOptions) arg1).uninterpretedOption_);
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
                            } else if (tag == 7994) {
                                if (!this.uninterpretedOption_.isModifiable()) {
                                    this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                }
                                this.uninterpretedOption_.add((UninterpretedOption) input.readMessage(UninterpretedOption.parser(), extensionRegistry));
                            } else if (!parseUnknownField((OneofOptions) getDefaultInstanceForType(), input, extensionRegistry, tag)) {
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
                        synchronized (OneofOptions.class) {
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
            OneofOptions oneofOptions = new OneofOptions();
            DEFAULT_INSTANCE = oneofOptions;
            oneofOptions.makeImmutable();
        }

        public static OneofOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OneofOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class EnumOptions extends GeneratedMessageLite.ExtendableMessage<EnumOptions, Builder> implements EnumOptionsOrBuilder {
        public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final EnumOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        private static volatile Parser<EnumOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private boolean allowAlias_;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private EnumOptions() {
        }

        public boolean hasAllowAlias() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getAllowAlias() {
            return this.allowAlias_;
        }

        /* access modifiers changed from: private */
        public void setAllowAlias(boolean value) {
            this.bitField0_ |= 1;
            this.allowAlias_ = value;
        }

        /* access modifiers changed from: private */
        public void clearAllowAlias() {
            this.bitField0_ &= -2;
            this.allowAlias_ = false;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean value) {
            this.bitField0_ |= 2;
            this.deprecated_ = value;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -3;
            this.deprecated_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(values, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int index) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBool(2, this.allowAlias_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBool(3, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(536870912, output);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.allowAlias_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static EnumOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EnumOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EnumOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EnumOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EnumOptions parseFrom(InputStream input) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EnumOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (EnumOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EnumOptions parseFrom(CodedInputStream input) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(EnumOptions.DEFAULT_INSTANCE);
            }

            public boolean hasAllowAlias() {
                return ((EnumOptions) this.instance).hasAllowAlias();
            }

            public boolean getAllowAlias() {
                return ((EnumOptions) this.instance).getAllowAlias();
            }

            public Builder setAllowAlias(boolean value) {
                copyOnWrite();
                ((EnumOptions) this.instance).setAllowAlias(value);
                return this;
            }

            public Builder clearAllowAlias() {
                copyOnWrite();
                ((EnumOptions) this.instance).clearAllowAlias();
                return this;
            }

            public boolean hasDeprecated() {
                return ((EnumOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((EnumOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean value) {
                copyOnWrite();
                ((EnumOptions) this.instance).setDeprecated(value);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((EnumOptions) this.instance).clearDeprecated();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((EnumOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return ((EnumOptions) this.instance).getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((EnumOptions) this.instance).setUninterpretedOption(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((EnumOptions) this.instance).setUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(value);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(index, value);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                copyOnWrite();
                ((EnumOptions) this.instance).addAllUninterpretedOption(values);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((EnumOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                copyOnWrite();
                ((EnumOptions) this.instance).removeUninterpretedOption(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new EnumOptions();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (extensionsAreInitialized() == 0) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    EnumOptions other = (EnumOptions) arg1;
                    this.allowAlias_ = visitor.visitBoolean(hasAllowAlias(), this.allowAlias_, other.hasAllowAlias(), other.allowAlias_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, other.hasDeprecated(), other.deprecated_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, other.uninterpretedOption_);
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
                            } else if (tag == 16) {
                                this.bitField0_ |= 1;
                                this.allowAlias_ = input.readBool();
                            } else if (tag == 24) {
                                this.bitField0_ |= 2;
                                this.deprecated_ = input.readBool();
                            } else if (tag == 7994) {
                                if (!this.uninterpretedOption_.isModifiable()) {
                                    this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                }
                                this.uninterpretedOption_.add((UninterpretedOption) input.readMessage(UninterpretedOption.parser(), extensionRegistry));
                            } else if (!parseUnknownField((EnumOptions) getDefaultInstanceForType(), input, extensionRegistry, tag)) {
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
                        synchronized (EnumOptions.class) {
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
            EnumOptions enumOptions = new EnumOptions();
            DEFAULT_INSTANCE = enumOptions;
            enumOptions.makeImmutable();
        }

        public static EnumOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnumOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class EnumValueOptions extends GeneratedMessageLite.ExtendableMessage<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final EnumValueOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 1;
        private static volatile Parser<EnumValueOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private EnumValueOptions() {
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean value) {
            this.bitField0_ |= 1;
            this.deprecated_ = value;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(values, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int index) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBool(1, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(536870912, output);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static EnumValueOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EnumValueOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EnumValueOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EnumValueOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EnumValueOptions parseFrom(InputStream input) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumValueOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (EnumValueOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumValueOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EnumValueOptions parseFrom(CodedInputStream input) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EnumValueOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumValueOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(EnumValueOptions.DEFAULT_INSTANCE);
            }

            public boolean hasDeprecated() {
                return ((EnumValueOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((EnumValueOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean value) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).setDeprecated(value);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((EnumValueOptions) this.instance).clearDeprecated();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumValueOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((EnumValueOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return ((EnumValueOptions) this.instance).getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).setUninterpretedOption(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).setUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(value);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(index, value);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addAllUninterpretedOption(values);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((EnumValueOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).removeUninterpretedOption(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new EnumValueOptions();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (extensionsAreInitialized() == 0) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    EnumValueOptions other = (EnumValueOptions) arg1;
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, other.hasDeprecated(), other.deprecated_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, other.uninterpretedOption_);
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
                            } else if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.deprecated_ = input.readBool();
                            } else if (tag == 7994) {
                                if (!this.uninterpretedOption_.isModifiable()) {
                                    this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                }
                                this.uninterpretedOption_.add((UninterpretedOption) input.readMessage(UninterpretedOption.parser(), extensionRegistry));
                            } else if (!parseUnknownField((EnumValueOptions) getDefaultInstanceForType(), input, extensionRegistry, tag)) {
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
                        synchronized (EnumValueOptions.class) {
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
            EnumValueOptions enumValueOptions = new EnumValueOptions();
            DEFAULT_INSTANCE = enumValueOptions;
            enumValueOptions.makeImmutable();
        }

        public static EnumValueOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnumValueOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class ServiceOptions extends GeneratedMessageLite.ExtendableMessage<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final ServiceOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        private static volatile Parser<ServiceOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private ServiceOptions() {
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean value) {
            this.bitField0_ |= 1;
            this.deprecated_ = value;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(values, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int index) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBool(33, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(536870912, output);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                size2 = 0 + CodedOutputStream.computeBoolSize(33, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static ServiceOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ServiceOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ServiceOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ServiceOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ServiceOptions parseFrom(InputStream input) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ServiceOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ServiceOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (ServiceOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ServiceOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServiceOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ServiceOptions parseFrom(CodedInputStream input) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ServiceOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServiceOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(ServiceOptions.DEFAULT_INSTANCE);
            }

            public boolean hasDeprecated() {
                return ((ServiceOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((ServiceOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean value) {
                copyOnWrite();
                ((ServiceOptions) this.instance).setDeprecated(value);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((ServiceOptions) this.instance).clearDeprecated();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ServiceOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((ServiceOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return ((ServiceOptions) this.instance).getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((ServiceOptions) this.instance).setUninterpretedOption(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((ServiceOptions) this.instance).setUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(value);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(index, value);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addAllUninterpretedOption(values);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((ServiceOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                copyOnWrite();
                ((ServiceOptions) this.instance).removeUninterpretedOption(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new ServiceOptions();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (extensionsAreInitialized() == 0) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    ServiceOptions other = (ServiceOptions) arg1;
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, other.hasDeprecated(), other.deprecated_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, other.uninterpretedOption_);
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
                            } else if (tag == 264) {
                                this.bitField0_ |= 1;
                                this.deprecated_ = input.readBool();
                            } else if (tag == 7994) {
                                if (!this.uninterpretedOption_.isModifiable()) {
                                    this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                }
                                this.uninterpretedOption_.add((UninterpretedOption) input.readMessage(UninterpretedOption.parser(), extensionRegistry));
                            } else if (!parseUnknownField((ServiceOptions) getDefaultInstanceForType(), input, extensionRegistry, tag)) {
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
                        synchronized (ServiceOptions.class) {
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
            ServiceOptions serviceOptions = new ServiceOptions();
            DEFAULT_INSTANCE = serviceOptions;
            serviceOptions.makeImmutable();
        }

        public static ServiceOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServiceOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class MethodOptions extends GeneratedMessageLite.ExtendableMessage<MethodOptions, Builder> implements MethodOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final MethodOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
        private static volatile Parser<MethodOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private int idempotencyLevel_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private MethodOptions() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum IdempotencyLevel implements Internal.EnumLite {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);
            
            public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
            public static final int IDEMPOTENT_VALUE = 2;
            public static final int NO_SIDE_EFFECTS_VALUE = 1;
            private static final Internal.EnumLiteMap<IdempotencyLevel> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<IdempotencyLevel>() {
                    public IdempotencyLevel findValueByNumber(int number) {
                        return IdempotencyLevel.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static IdempotencyLevel valueOf(int value2) {
                return forNumber(value2);
            }

            public static IdempotencyLevel forNumber(int value2) {
                if (value2 == 0) {
                    return IDEMPOTENCY_UNKNOWN;
                }
                if (value2 == 1) {
                    return NO_SIDE_EFFECTS;
                }
                if (value2 != 2) {
                    return null;
                }
                return IDEMPOTENT;
            }

            public static Internal.EnumLiteMap<IdempotencyLevel> internalGetValueMap() {
                return internalValueMap;
            }

            private IdempotencyLevel(int value2) {
                this.value = value2;
            }
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean value) {
            this.bitField0_ |= 1;
            this.deprecated_ = value;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        public boolean hasIdempotencyLevel() {
            return (this.bitField0_ & 2) == 2;
        }

        public IdempotencyLevel getIdempotencyLevel() {
            IdempotencyLevel result = IdempotencyLevel.forNumber(this.idempotencyLevel_);
            return result == null ? IdempotencyLevel.IDEMPOTENCY_UNKNOWN : result;
        }

        /* access modifiers changed from: private */
        public void setIdempotencyLevel(IdempotencyLevel value) {
            if (value != null) {
                this.bitField0_ |= 2;
                this.idempotencyLevel_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearIdempotencyLevel() {
            this.bitField0_ &= -3;
            this.idempotencyLevel_ = 0;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption value) {
            if (value != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(index, (UninterpretedOption) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(values, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int index) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBool(33, this.deprecated_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeEnum(34, this.idempotencyLevel_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(536870912, output);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                size2 = 0 + CodedOutputStream.computeBoolSize(33, this.deprecated_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeEnumSize(34, this.idempotencyLevel_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static MethodOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MethodOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MethodOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MethodOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MethodOptions parseFrom(InputStream input) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MethodOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MethodOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (MethodOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static MethodOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MethodOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MethodOptions parseFrom(CodedInputStream input) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MethodOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MethodOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(MethodOptions.DEFAULT_INSTANCE);
            }

            public boolean hasDeprecated() {
                return ((MethodOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((MethodOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean value) {
                copyOnWrite();
                ((MethodOptions) this.instance).setDeprecated(value);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((MethodOptions) this.instance).clearDeprecated();
                return this;
            }

            public boolean hasIdempotencyLevel() {
                return ((MethodOptions) this.instance).hasIdempotencyLevel();
            }

            public IdempotencyLevel getIdempotencyLevel() {
                return ((MethodOptions) this.instance).getIdempotencyLevel();
            }

            public Builder setIdempotencyLevel(IdempotencyLevel value) {
                copyOnWrite();
                ((MethodOptions) this.instance).setIdempotencyLevel(value);
                return this;
            }

            public Builder clearIdempotencyLevel() {
                copyOnWrite();
                ((MethodOptions) this.instance).clearIdempotencyLevel();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MethodOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((MethodOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return ((MethodOptions) this.instance).getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((MethodOptions) this.instance).setUninterpretedOption(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((MethodOptions) this.instance).setUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(value);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(index, value);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(builderForValue);
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(index, builderForValue);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                copyOnWrite();
                ((MethodOptions) this.instance).addAllUninterpretedOption(values);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((MethodOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                copyOnWrite();
                ((MethodOptions) this.instance).removeUninterpretedOption(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new MethodOptions();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (extensionsAreInitialized() == 0) {
                        if (shouldMemoize) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (shouldMemoize) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    MethodOptions other = (MethodOptions) arg1;
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, other.hasDeprecated(), other.deprecated_);
                    this.idempotencyLevel_ = visitor.visitInt(hasIdempotencyLevel(), this.idempotencyLevel_, other.hasIdempotencyLevel(), other.idempotencyLevel_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, other.uninterpretedOption_);
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
                            } else if (tag == 264) {
                                this.bitField0_ |= 1;
                                this.deprecated_ = input.readBool();
                            } else if (tag == 272) {
                                int rawValue = input.readEnum();
                                if (IdempotencyLevel.forNumber(rawValue) == null) {
                                    super.mergeVarintField(34, rawValue);
                                } else {
                                    this.bitField0_ |= 2;
                                    this.idempotencyLevel_ = rawValue;
                                }
                            } else if (tag == 7994) {
                                if (!this.uninterpretedOption_.isModifiable()) {
                                    this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                }
                                this.uninterpretedOption_.add((UninterpretedOption) input.readMessage(UninterpretedOption.parser(), extensionRegistry));
                            } else if (!parseUnknownField((MethodOptions) getDefaultInstanceForType(), input, extensionRegistry, tag)) {
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
                        synchronized (MethodOptions.class) {
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
            MethodOptions methodOptions = new MethodOptions();
            DEFAULT_INSTANCE = methodOptions;
            methodOptions.makeImmutable();
        }

        public static MethodOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MethodOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class UninterpretedOption extends GeneratedMessageLite<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        /* access modifiers changed from: private */
        public static final UninterpretedOption DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        private static volatile Parser<UninterpretedOption> PARSER = null;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private String aggregateValue_ = "";
        private int bitField0_;
        private double doubleValue_;
        private String identifierValue_ = "";
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<NamePart> name_ = emptyProtobufList();
        private long negativeIntValue_;
        private long positiveIntValue_;
        private ByteString stringValue_ = ByteString.EMPTY;

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface NamePartOrBuilder extends MessageLiteOrBuilder {
            boolean getIsExtension();

            String getNamePart();

            ByteString getNamePartBytes();

            boolean hasIsExtension();

            boolean hasNamePart();
        }

        private UninterpretedOption() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class NamePart extends GeneratedMessageLite<NamePart, Builder> implements NamePartOrBuilder {
            /* access modifiers changed from: private */
            public static final NamePart DEFAULT_INSTANCE;
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static volatile Parser<NamePart> PARSER;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized = -1;
            private String namePart_ = "";

            private NamePart() {
            }

            public boolean hasNamePart() {
                return (this.bitField0_ & 1) == 1;
            }

            public String getNamePart() {
                return this.namePart_;
            }

            public ByteString getNamePartBytes() {
                return ByteString.copyFromUtf8(this.namePart_);
            }

            /* access modifiers changed from: private */
            public void setNamePart(String value) {
                if (value != null) {
                    this.bitField0_ |= 1;
                    this.namePart_ = value;
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void clearNamePart() {
                this.bitField0_ &= -2;
                this.namePart_ = getDefaultInstance().getNamePart();
            }

            /* access modifiers changed from: private */
            public void setNamePartBytes(ByteString value) {
                if (value != null) {
                    this.bitField0_ |= 1;
                    this.namePart_ = value.toStringUtf8();
                    return;
                }
                throw null;
            }

            public boolean hasIsExtension() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean getIsExtension() {
                return this.isExtension_;
            }

            /* access modifiers changed from: private */
            public void setIsExtension(boolean value) {
                this.bitField0_ |= 2;
                this.isExtension_ = value;
            }

            /* access modifiers changed from: private */
            public void clearIsExtension() {
                this.bitField0_ &= -3;
                this.isExtension_ = false;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    output.writeString(1, getNamePart());
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeBool(2, this.isExtension_);
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
                    size2 = 0 + CodedOutputStream.computeStringSize(1, getNamePart());
                }
                if ((this.bitField0_ & 2) == 2) {
                    size2 += CodedOutputStream.computeBoolSize(2, this.isExtension_);
                }
                int size3 = size2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size3;
                return size3;
            }

            public static NamePart parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static NamePart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static NamePart parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static NamePart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static NamePart parseFrom(InputStream input) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static NamePart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static NamePart parseDelimitedFrom(InputStream input) throws IOException {
                return (NamePart) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static NamePart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (NamePart) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static NamePart parseFrom(CodedInputStream input) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static NamePart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(NamePart prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<NamePart, Builder> implements NamePartOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(NamePart.DEFAULT_INSTANCE);
                }

                public boolean hasNamePart() {
                    return ((NamePart) this.instance).hasNamePart();
                }

                public String getNamePart() {
                    return ((NamePart) this.instance).getNamePart();
                }

                public ByteString getNamePartBytes() {
                    return ((NamePart) this.instance).getNamePartBytes();
                }

                public Builder setNamePart(String value) {
                    copyOnWrite();
                    ((NamePart) this.instance).setNamePart(value);
                    return this;
                }

                public Builder clearNamePart() {
                    copyOnWrite();
                    ((NamePart) this.instance).clearNamePart();
                    return this;
                }

                public Builder setNamePartBytes(ByteString value) {
                    copyOnWrite();
                    ((NamePart) this.instance).setNamePartBytes(value);
                    return this;
                }

                public boolean hasIsExtension() {
                    return ((NamePart) this.instance).hasIsExtension();
                }

                public boolean getIsExtension() {
                    return ((NamePart) this.instance).getIsExtension();
                }

                public Builder setIsExtension(boolean value) {
                    copyOnWrite();
                    ((NamePart) this.instance).setIsExtension(value);
                    return this;
                }

                public Builder clearIsExtension() {
                    copyOnWrite();
                    ((NamePart) this.instance).clearIsExtension();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new NamePart();
                    case 2:
                        byte isInitialized = this.memoizedIsInitialized;
                        if (isInitialized == 1) {
                            return DEFAULT_INSTANCE;
                        }
                        if (isInitialized == 0) {
                            return null;
                        }
                        boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                        if (!hasNamePart()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        } else if (!hasIsExtension()) {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        } else {
                            if (shouldMemoize) {
                                this.memoizedIsInitialized = 1;
                            }
                            return DEFAULT_INSTANCE;
                        }
                    case 3:
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                        NamePart other = (NamePart) arg1;
                        this.namePart_ = visitor.visitString(hasNamePart(), this.namePart_, other.hasNamePart(), other.namePart_);
                        this.isExtension_ = visitor.visitBoolean(hasIsExtension(), this.isExtension_, other.hasIsExtension(), other.isExtension_);
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
                                    this.namePart_ = s;
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.isExtension_ = input.readBool();
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
                            synchronized (NamePart.class) {
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
                NamePart namePart = new NamePart();
                DEFAULT_INSTANCE = namePart;
                namePart.makeImmutable();
            }

            public static NamePart getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<NamePart> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public List<NamePart> getNameList() {
            return this.name_;
        }

        public List<? extends NamePartOrBuilder> getNameOrBuilderList() {
            return this.name_;
        }

        public int getNameCount() {
            return this.name_.size();
        }

        public NamePart getName(int index) {
            return (NamePart) this.name_.get(index);
        }

        public NamePartOrBuilder getNameOrBuilder(int index) {
            return (NamePartOrBuilder) this.name_.get(index);
        }

        private void ensureNameIsMutable() {
            if (!this.name_.isModifiable()) {
                this.name_ = GeneratedMessageLite.mutableCopy(this.name_);
            }
        }

        /* access modifiers changed from: private */
        public void setName(int index, NamePart value) {
            if (value != null) {
                ensureNameIsMutable();
                this.name_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setName(int index, NamePart.Builder builderForValue) {
            ensureNameIsMutable();
            this.name_.set(index, (NamePart) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addName(NamePart value) {
            if (value != null) {
                ensureNameIsMutable();
                this.name_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addName(int index, NamePart value) {
            if (value != null) {
                ensureNameIsMutable();
                this.name_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addName(NamePart.Builder builderForValue) {
            ensureNameIsMutable();
            this.name_.add((NamePart) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addName(int index, NamePart.Builder builderForValue) {
            ensureNameIsMutable();
            this.name_.add(index, (NamePart) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllName(Iterable<? extends NamePart> values) {
            ensureNameIsMutable();
            AbstractMessageLite.addAll(values, this.name_);
        }

        /* access modifiers changed from: private */
        public void clearName() {
            this.name_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeName(int index) {
            ensureNameIsMutable();
            this.name_.remove(index);
        }

        public boolean hasIdentifierValue() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getIdentifierValue() {
            return this.identifierValue_;
        }

        public ByteString getIdentifierValueBytes() {
            return ByteString.copyFromUtf8(this.identifierValue_);
        }

        /* access modifiers changed from: private */
        public void setIdentifierValue(String value) {
            if (value != null) {
                this.bitField0_ |= 1;
                this.identifierValue_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearIdentifierValue() {
            this.bitField0_ &= -2;
            this.identifierValue_ = getDefaultInstance().getIdentifierValue();
        }

        /* access modifiers changed from: private */
        public void setIdentifierValueBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 1;
                this.identifierValue_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasPositiveIntValue() {
            return (this.bitField0_ & 2) == 2;
        }

        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        /* access modifiers changed from: private */
        public void setPositiveIntValue(long value) {
            this.bitField0_ |= 2;
            this.positiveIntValue_ = value;
        }

        /* access modifiers changed from: private */
        public void clearPositiveIntValue() {
            this.bitField0_ &= -3;
            this.positiveIntValue_ = 0;
        }

        public boolean hasNegativeIntValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        /* access modifiers changed from: private */
        public void setNegativeIntValue(long value) {
            this.bitField0_ |= 4;
            this.negativeIntValue_ = value;
        }

        /* access modifiers changed from: private */
        public void clearNegativeIntValue() {
            this.bitField0_ &= -5;
            this.negativeIntValue_ = 0;
        }

        public boolean hasDoubleValue() {
            return (this.bitField0_ & 8) == 8;
        }

        public double getDoubleValue() {
            return this.doubleValue_;
        }

        /* access modifiers changed from: private */
        public void setDoubleValue(double value) {
            this.bitField0_ |= 8;
            this.doubleValue_ = value;
        }

        /* access modifiers changed from: private */
        public void clearDoubleValue() {
            this.bitField0_ &= -9;
            this.doubleValue_ = 0.0d;
        }

        public boolean hasStringValue() {
            return (this.bitField0_ & 16) == 16;
        }

        public ByteString getStringValue() {
            return this.stringValue_;
        }

        /* access modifiers changed from: private */
        public void setStringValue(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 16;
                this.stringValue_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearStringValue() {
            this.bitField0_ &= -17;
            this.stringValue_ = getDefaultInstance().getStringValue();
        }

        public boolean hasAggregateValue() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getAggregateValue() {
            return this.aggregateValue_;
        }

        public ByteString getAggregateValueBytes() {
            return ByteString.copyFromUtf8(this.aggregateValue_);
        }

        /* access modifiers changed from: private */
        public void setAggregateValue(String value) {
            if (value != null) {
                this.bitField0_ |= 32;
                this.aggregateValue_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearAggregateValue() {
            this.bitField0_ &= -33;
            this.aggregateValue_ = getDefaultInstance().getAggregateValue();
        }

        /* access modifiers changed from: private */
        public void setAggregateValueBytes(ByteString value) {
            if (value != null) {
                this.bitField0_ |= 32;
                this.aggregateValue_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.name_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeString(3, getIdentifierValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeUInt64(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeInt64(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeDouble(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeBytes(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeString(8, getAggregateValue());
            }
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.name_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                size2 += CodedOutputStream.computeStringSize(3, getIdentifierValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeUInt64Size(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeInt64Size(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeDoubleSize(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                size2 += CodedOutputStream.computeBytesSize(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                size2 += CodedOutputStream.computeStringSize(8, getAggregateValue());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static UninterpretedOption parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UninterpretedOption parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UninterpretedOption parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UninterpretedOption parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UninterpretedOption parseFrom(InputStream input) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UninterpretedOption parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream input) throws IOException {
            return (UninterpretedOption) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UninterpretedOption) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UninterpretedOption parseFrom(CodedInputStream input) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UninterpretedOption parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UninterpretedOption prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(UninterpretedOption.DEFAULT_INSTANCE);
            }

            public List<NamePart> getNameList() {
                return Collections.unmodifiableList(((UninterpretedOption) this.instance).getNameList());
            }

            public int getNameCount() {
                return ((UninterpretedOption) this.instance).getNameCount();
            }

            public NamePart getName(int index) {
                return ((UninterpretedOption) this.instance).getName(index);
            }

            public Builder setName(int index, NamePart value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setName(index, value);
                return this;
            }

            public Builder setName(int index, NamePart.Builder builderForValue) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setName(index, builderForValue);
                return this;
            }

            public Builder addName(NamePart value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(value);
                return this;
            }

            public Builder addName(int index, NamePart value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(index, value);
                return this;
            }

            public Builder addName(NamePart.Builder builderForValue) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(builderForValue);
                return this;
            }

            public Builder addName(int index, NamePart.Builder builderForValue) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(index, builderForValue);
                return this;
            }

            public Builder addAllName(Iterable<? extends NamePart> values) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addAllName(values);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearName();
                return this;
            }

            public Builder removeName(int index) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).removeName(index);
                return this;
            }

            public boolean hasIdentifierValue() {
                return ((UninterpretedOption) this.instance).hasIdentifierValue();
            }

            public String getIdentifierValue() {
                return ((UninterpretedOption) this.instance).getIdentifierValue();
            }

            public ByteString getIdentifierValueBytes() {
                return ((UninterpretedOption) this.instance).getIdentifierValueBytes();
            }

            public Builder setIdentifierValue(String value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setIdentifierValue(value);
                return this;
            }

            public Builder clearIdentifierValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearIdentifierValue();
                return this;
            }

            public Builder setIdentifierValueBytes(ByteString value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setIdentifierValueBytes(value);
                return this;
            }

            public boolean hasPositiveIntValue() {
                return ((UninterpretedOption) this.instance).hasPositiveIntValue();
            }

            public long getPositiveIntValue() {
                return ((UninterpretedOption) this.instance).getPositiveIntValue();
            }

            public Builder setPositiveIntValue(long value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setPositiveIntValue(value);
                return this;
            }

            public Builder clearPositiveIntValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearPositiveIntValue();
                return this;
            }

            public boolean hasNegativeIntValue() {
                return ((UninterpretedOption) this.instance).hasNegativeIntValue();
            }

            public long getNegativeIntValue() {
                return ((UninterpretedOption) this.instance).getNegativeIntValue();
            }

            public Builder setNegativeIntValue(long value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setNegativeIntValue(value);
                return this;
            }

            public Builder clearNegativeIntValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearNegativeIntValue();
                return this;
            }

            public boolean hasDoubleValue() {
                return ((UninterpretedOption) this.instance).hasDoubleValue();
            }

            public double getDoubleValue() {
                return ((UninterpretedOption) this.instance).getDoubleValue();
            }

            public Builder setDoubleValue(double value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setDoubleValue(value);
                return this;
            }

            public Builder clearDoubleValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearDoubleValue();
                return this;
            }

            public boolean hasStringValue() {
                return ((UninterpretedOption) this.instance).hasStringValue();
            }

            public ByteString getStringValue() {
                return ((UninterpretedOption) this.instance).getStringValue();
            }

            public Builder setStringValue(ByteString value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setStringValue(value);
                return this;
            }

            public Builder clearStringValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearStringValue();
                return this;
            }

            public boolean hasAggregateValue() {
                return ((UninterpretedOption) this.instance).hasAggregateValue();
            }

            public String getAggregateValue() {
                return ((UninterpretedOption) this.instance).getAggregateValue();
            }

            public ByteString getAggregateValueBytes() {
                return ((UninterpretedOption) this.instance).getAggregateValueBytes();
            }

            public Builder setAggregateValue(String value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setAggregateValue(value);
                return this;
            }

            public Builder clearAggregateValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearAggregateValue();
                return this;
            }

            public Builder setAggregateValueBytes(ByteString value) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setAggregateValueBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new UninterpretedOption();
                case 2:
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (isInitialized == 0) {
                        return null;
                    }
                    boolean shouldMemoize = ((Boolean) arg0).booleanValue();
                    for (int i = 0; i < getNameCount(); i++) {
                        if (!getName(i).isInitialized()) {
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
                    this.name_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    UninterpretedOption other = (UninterpretedOption) arg1;
                    this.name_ = visitor.visitList(this.name_, other.name_);
                    this.identifierValue_ = visitor.visitString(hasIdentifierValue(), this.identifierValue_, other.hasIdentifierValue(), other.identifierValue_);
                    this.positiveIntValue_ = visitor.visitLong(hasPositiveIntValue(), this.positiveIntValue_, other.hasPositiveIntValue(), other.positiveIntValue_);
                    this.negativeIntValue_ = visitor.visitLong(hasNegativeIntValue(), this.negativeIntValue_, other.hasNegativeIntValue(), other.negativeIntValue_);
                    this.doubleValue_ = visitor.visitDouble(hasDoubleValue(), this.doubleValue_, other.hasDoubleValue(), other.doubleValue_);
                    this.stringValue_ = visitor.visitByteString(hasStringValue(), this.stringValue_, other.hasStringValue(), other.stringValue_);
                    this.aggregateValue_ = visitor.visitString(hasAggregateValue(), this.aggregateValue_, other.hasAggregateValue(), other.aggregateValue_);
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
                            } else if (tag == 18) {
                                if (!this.name_.isModifiable()) {
                                    this.name_ = GeneratedMessageLite.mutableCopy(this.name_);
                                }
                                this.name_.add((NamePart) input.readMessage(NamePart.parser(), extensionRegistry));
                            } else if (tag == 26) {
                                String s = input.readString();
                                this.bitField0_ |= 1;
                                this.identifierValue_ = s;
                            } else if (tag == 32) {
                                this.bitField0_ |= 2;
                                this.positiveIntValue_ = input.readUInt64();
                            } else if (tag == 40) {
                                this.bitField0_ |= 4;
                                this.negativeIntValue_ = input.readInt64();
                            } else if (tag == 49) {
                                this.bitField0_ |= 8;
                                this.doubleValue_ = input.readDouble();
                            } else if (tag == 58) {
                                this.bitField0_ |= 16;
                                this.stringValue_ = input.readBytes();
                            } else if (tag == 66) {
                                String s2 = input.readString();
                                this.bitField0_ = 32 | this.bitField0_;
                                this.aggregateValue_ = s2;
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
                        synchronized (UninterpretedOption.class) {
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
            UninterpretedOption uninterpretedOption = new UninterpretedOption();
            DEFAULT_INSTANCE = uninterpretedOption;
            uninterpretedOption.makeImmutable();
        }

        public static UninterpretedOption getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UninterpretedOption> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class SourceCodeInfo extends GeneratedMessageLite<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final SourceCodeInfo DEFAULT_INSTANCE;
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static volatile Parser<SourceCodeInfo> PARSER;
        private Internal.ProtobufList<Location> location_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface LocationOrBuilder extends MessageLiteOrBuilder {
            String getLeadingComments();

            ByteString getLeadingCommentsBytes();

            String getLeadingDetachedComments(int i);

            ByteString getLeadingDetachedCommentsBytes(int i);

            int getLeadingDetachedCommentsCount();

            List<String> getLeadingDetachedCommentsList();

            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            int getSpan(int i);

            int getSpanCount();

            List<Integer> getSpanList();

            String getTrailingComments();

            ByteString getTrailingCommentsBytes();

            boolean hasLeadingComments();

            boolean hasTrailingComments();
        }

        private SourceCodeInfo() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Location extends GeneratedMessageLite<Location, Builder> implements LocationOrBuilder {
            /* access modifiers changed from: private */
            public static final Location DEFAULT_INSTANCE;
            public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
            public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
            private static volatile Parser<Location> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
            private int bitField0_;
            private String leadingComments_ = "";
            private Internal.ProtobufList<String> leadingDetachedComments_ = GeneratedMessageLite.emptyProtobufList();
            private int pathMemoizedSerializedSize = -1;
            private Internal.IntList path_ = emptyIntList();
            private int spanMemoizedSerializedSize = -1;
            private Internal.IntList span_ = emptyIntList();
            private String trailingComments_ = "";

            private Location() {
            }

            public List<Integer> getPathList() {
                return this.path_;
            }

            public int getPathCount() {
                return this.path_.size();
            }

            public int getPath(int index) {
                return this.path_.getInt(index);
            }

            private void ensurePathIsMutable() {
                if (!this.path_.isModifiable()) {
                    this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                }
            }

            /* access modifiers changed from: private */
            public void setPath(int index, int value) {
                ensurePathIsMutable();
                this.path_.setInt(index, value);
            }

            /* access modifiers changed from: private */
            public void addPath(int value) {
                ensurePathIsMutable();
                this.path_.addInt(value);
            }

            /* access modifiers changed from: private */
            public void addAllPath(Iterable<? extends Integer> values) {
                ensurePathIsMutable();
                AbstractMessageLite.addAll(values, this.path_);
            }

            /* access modifiers changed from: private */
            public void clearPath() {
                this.path_ = emptyIntList();
            }

            public List<Integer> getSpanList() {
                return this.span_;
            }

            public int getSpanCount() {
                return this.span_.size();
            }

            public int getSpan(int index) {
                return this.span_.getInt(index);
            }

            private void ensureSpanIsMutable() {
                if (!this.span_.isModifiable()) {
                    this.span_ = GeneratedMessageLite.mutableCopy(this.span_);
                }
            }

            /* access modifiers changed from: private */
            public void setSpan(int index, int value) {
                ensureSpanIsMutable();
                this.span_.setInt(index, value);
            }

            /* access modifiers changed from: private */
            public void addSpan(int value) {
                ensureSpanIsMutable();
                this.span_.addInt(value);
            }

            /* access modifiers changed from: private */
            public void addAllSpan(Iterable<? extends Integer> values) {
                ensureSpanIsMutable();
                AbstractMessageLite.addAll(values, this.span_);
            }

            /* access modifiers changed from: private */
            public void clearSpan() {
                this.span_ = emptyIntList();
            }

            public boolean hasLeadingComments() {
                return (this.bitField0_ & 1) == 1;
            }

            public String getLeadingComments() {
                return this.leadingComments_;
            }

            public ByteString getLeadingCommentsBytes() {
                return ByteString.copyFromUtf8(this.leadingComments_);
            }

            /* access modifiers changed from: private */
            public void setLeadingComments(String value) {
                if (value != null) {
                    this.bitField0_ |= 1;
                    this.leadingComments_ = value;
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void clearLeadingComments() {
                this.bitField0_ &= -2;
                this.leadingComments_ = getDefaultInstance().getLeadingComments();
            }

            /* access modifiers changed from: private */
            public void setLeadingCommentsBytes(ByteString value) {
                if (value != null) {
                    this.bitField0_ |= 1;
                    this.leadingComments_ = value.toStringUtf8();
                    return;
                }
                throw null;
            }

            public boolean hasTrailingComments() {
                return (this.bitField0_ & 2) == 2;
            }

            public String getTrailingComments() {
                return this.trailingComments_;
            }

            public ByteString getTrailingCommentsBytes() {
                return ByteString.copyFromUtf8(this.trailingComments_);
            }

            /* access modifiers changed from: private */
            public void setTrailingComments(String value) {
                if (value != null) {
                    this.bitField0_ |= 2;
                    this.trailingComments_ = value;
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void clearTrailingComments() {
                this.bitField0_ &= -3;
                this.trailingComments_ = getDefaultInstance().getTrailingComments();
            }

            /* access modifiers changed from: private */
            public void setTrailingCommentsBytes(ByteString value) {
                if (value != null) {
                    this.bitField0_ |= 2;
                    this.trailingComments_ = value.toStringUtf8();
                    return;
                }
                throw null;
            }

            public List<String> getLeadingDetachedCommentsList() {
                return this.leadingDetachedComments_;
            }

            public int getLeadingDetachedCommentsCount() {
                return this.leadingDetachedComments_.size();
            }

            public String getLeadingDetachedComments(int index) {
                return (String) this.leadingDetachedComments_.get(index);
            }

            public ByteString getLeadingDetachedCommentsBytes(int index) {
                return ByteString.copyFromUtf8((String) this.leadingDetachedComments_.get(index));
            }

            private void ensureLeadingDetachedCommentsIsMutable() {
                if (!this.leadingDetachedComments_.isModifiable()) {
                    this.leadingDetachedComments_ = GeneratedMessageLite.mutableCopy(this.leadingDetachedComments_);
                }
            }

            /* access modifiers changed from: private */
            public void setLeadingDetachedComments(int index, String value) {
                if (value != null) {
                    ensureLeadingDetachedCommentsIsMutable();
                    this.leadingDetachedComments_.set(index, value);
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void addLeadingDetachedComments(String value) {
                if (value != null) {
                    ensureLeadingDetachedCommentsIsMutable();
                    this.leadingDetachedComments_.add(value);
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void addAllLeadingDetachedComments(Iterable<String> values) {
                ensureLeadingDetachedCommentsIsMutable();
                AbstractMessageLite.addAll(values, this.leadingDetachedComments_);
            }

            /* access modifiers changed from: private */
            public void clearLeadingDetachedComments() {
                this.leadingDetachedComments_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* access modifiers changed from: private */
            public void addLeadingDetachedCommentsBytes(ByteString value) {
                if (value != null) {
                    ensureLeadingDetachedCommentsIsMutable();
                    this.leadingDetachedComments_.add(value.toStringUtf8());
                    return;
                }
                throw null;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    output.writeUInt32NoTag(10);
                    output.writeUInt32NoTag(this.pathMemoizedSerializedSize);
                }
                for (int i = 0; i < this.path_.size(); i++) {
                    output.writeInt32NoTag(this.path_.getInt(i));
                }
                if (getSpanList().size() > 0) {
                    output.writeUInt32NoTag(18);
                    output.writeUInt32NoTag(this.spanMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.span_.size(); i2++) {
                    output.writeInt32NoTag(this.span_.getInt(i2));
                }
                if ((this.bitField0_ & 1) == 1) {
                    output.writeString(3, getLeadingComments());
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeString(4, getTrailingComments());
                }
                for (int i3 = 0; i3 < this.leadingDetachedComments_.size(); i3++) {
                    output.writeString(6, (String) this.leadingDetachedComments_.get(i3));
                }
                this.unknownFields.writeTo(output);
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int dataSize = 0;
                for (int i = 0; i < this.path_.size(); i++) {
                    dataSize += CodedOutputStream.computeInt32SizeNoTag(this.path_.getInt(i));
                }
                int size2 = 0 + dataSize;
                if (!getPathList().isEmpty()) {
                    size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
                }
                this.pathMemoizedSerializedSize = dataSize;
                int dataSize2 = 0;
                for (int i2 = 0; i2 < this.span_.size(); i2++) {
                    dataSize2 += CodedOutputStream.computeInt32SizeNoTag(this.span_.getInt(i2));
                }
                int size3 = size2 + dataSize2;
                if (!getSpanList().isEmpty()) {
                    size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
                }
                this.spanMemoizedSerializedSize = dataSize2;
                if ((this.bitField0_ & 1) == 1) {
                    size3 += CodedOutputStream.computeStringSize(3, getLeadingComments());
                }
                if ((this.bitField0_ & 2) == 2) {
                    size3 += CodedOutputStream.computeStringSize(4, getTrailingComments());
                }
                int dataSize3 = 0;
                for (int i3 = 0; i3 < this.leadingDetachedComments_.size(); i3++) {
                    dataSize3 += CodedOutputStream.computeStringSizeNoTag((String) this.leadingDetachedComments_.get(i3));
                }
                int size4 = size3 + dataSize3 + (getLeadingDetachedCommentsList().size() * 1) + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size4;
                return size4;
            }

            public static Location parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Location parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Location parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Location parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Location parseFrom(InputStream input) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Location parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Location parseDelimitedFrom(InputStream input) throws IOException {
                return (Location) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Location parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Location) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Location parseFrom(CodedInputStream input) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Location parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Location prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Location, Builder> implements LocationOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(Location.DEFAULT_INSTANCE);
                }

                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Location) this.instance).getPathList());
                }

                public int getPathCount() {
                    return ((Location) this.instance).getPathCount();
                }

                public int getPath(int index) {
                    return ((Location) this.instance).getPath(index);
                }

                public Builder setPath(int index, int value) {
                    copyOnWrite();
                    ((Location) this.instance).setPath(index, value);
                    return this;
                }

                public Builder addPath(int value) {
                    copyOnWrite();
                    ((Location) this.instance).addPath(value);
                    return this;
                }

                public Builder addAllPath(Iterable<? extends Integer> values) {
                    copyOnWrite();
                    ((Location) this.instance).addAllPath(values);
                    return this;
                }

                public Builder clearPath() {
                    copyOnWrite();
                    ((Location) this.instance).clearPath();
                    return this;
                }

                public List<Integer> getSpanList() {
                    return Collections.unmodifiableList(((Location) this.instance).getSpanList());
                }

                public int getSpanCount() {
                    return ((Location) this.instance).getSpanCount();
                }

                public int getSpan(int index) {
                    return ((Location) this.instance).getSpan(index);
                }

                public Builder setSpan(int index, int value) {
                    copyOnWrite();
                    ((Location) this.instance).setSpan(index, value);
                    return this;
                }

                public Builder addSpan(int value) {
                    copyOnWrite();
                    ((Location) this.instance).addSpan(value);
                    return this;
                }

                public Builder addAllSpan(Iterable<? extends Integer> values) {
                    copyOnWrite();
                    ((Location) this.instance).addAllSpan(values);
                    return this;
                }

                public Builder clearSpan() {
                    copyOnWrite();
                    ((Location) this.instance).clearSpan();
                    return this;
                }

                public boolean hasLeadingComments() {
                    return ((Location) this.instance).hasLeadingComments();
                }

                public String getLeadingComments() {
                    return ((Location) this.instance).getLeadingComments();
                }

                public ByteString getLeadingCommentsBytes() {
                    return ((Location) this.instance).getLeadingCommentsBytes();
                }

                public Builder setLeadingComments(String value) {
                    copyOnWrite();
                    ((Location) this.instance).setLeadingComments(value);
                    return this;
                }

                public Builder clearLeadingComments() {
                    copyOnWrite();
                    ((Location) this.instance).clearLeadingComments();
                    return this;
                }

                public Builder setLeadingCommentsBytes(ByteString value) {
                    copyOnWrite();
                    ((Location) this.instance).setLeadingCommentsBytes(value);
                    return this;
                }

                public boolean hasTrailingComments() {
                    return ((Location) this.instance).hasTrailingComments();
                }

                public String getTrailingComments() {
                    return ((Location) this.instance).getTrailingComments();
                }

                public ByteString getTrailingCommentsBytes() {
                    return ((Location) this.instance).getTrailingCommentsBytes();
                }

                public Builder setTrailingComments(String value) {
                    copyOnWrite();
                    ((Location) this.instance).setTrailingComments(value);
                    return this;
                }

                public Builder clearTrailingComments() {
                    copyOnWrite();
                    ((Location) this.instance).clearTrailingComments();
                    return this;
                }

                public Builder setTrailingCommentsBytes(ByteString value) {
                    copyOnWrite();
                    ((Location) this.instance).setTrailingCommentsBytes(value);
                    return this;
                }

                public List<String> getLeadingDetachedCommentsList() {
                    return Collections.unmodifiableList(((Location) this.instance).getLeadingDetachedCommentsList());
                }

                public int getLeadingDetachedCommentsCount() {
                    return ((Location) this.instance).getLeadingDetachedCommentsCount();
                }

                public String getLeadingDetachedComments(int index) {
                    return ((Location) this.instance).getLeadingDetachedComments(index);
                }

                public ByteString getLeadingDetachedCommentsBytes(int index) {
                    return ((Location) this.instance).getLeadingDetachedCommentsBytes(index);
                }

                public Builder setLeadingDetachedComments(int index, String value) {
                    copyOnWrite();
                    ((Location) this.instance).setLeadingDetachedComments(index, value);
                    return this;
                }

                public Builder addLeadingDetachedComments(String value) {
                    copyOnWrite();
                    ((Location) this.instance).addLeadingDetachedComments(value);
                    return this;
                }

                public Builder addAllLeadingDetachedComments(Iterable<String> values) {
                    copyOnWrite();
                    ((Location) this.instance).addAllLeadingDetachedComments(values);
                    return this;
                }

                public Builder clearLeadingDetachedComments() {
                    copyOnWrite();
                    ((Location) this.instance).clearLeadingDetachedComments();
                    return this;
                }

                public Builder addLeadingDetachedCommentsBytes(ByteString value) {
                    copyOnWrite();
                    ((Location) this.instance).addLeadingDetachedCommentsBytes(value);
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new Location();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        this.path_.makeImmutable();
                        this.span_.makeImmutable();
                        this.leadingDetachedComments_.makeImmutable();
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                        Location other = (Location) arg1;
                        this.path_ = visitor.visitIntList(this.path_, other.path_);
                        this.span_ = visitor.visitIntList(this.span_, other.span_);
                        this.leadingComments_ = visitor.visitString(hasLeadingComments(), this.leadingComments_, other.hasLeadingComments(), other.leadingComments_);
                        this.trailingComments_ = visitor.visitString(hasTrailingComments(), this.trailingComments_, other.hasTrailingComments(), other.trailingComments_);
                        this.leadingDetachedComments_ = visitor.visitList(this.leadingDetachedComments_, other.leadingDetachedComments_);
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
                                    if (!this.path_.isModifiable()) {
                                        this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                                    }
                                    this.path_.addInt(input.readInt32());
                                } else if (tag == 10) {
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if (!this.path_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                        this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.path_.addInt(input.readInt32());
                                    }
                                    input.popLimit(limit);
                                } else if (tag == 16) {
                                    if (!this.span_.isModifiable()) {
                                        this.span_ = GeneratedMessageLite.mutableCopy(this.span_);
                                    }
                                    this.span_.addInt(input.readInt32());
                                } else if (tag == 18) {
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if (!this.span_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                        this.span_ = GeneratedMessageLite.mutableCopy(this.span_);
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.span_.addInt(input.readInt32());
                                    }
                                    input.popLimit(limit2);
                                } else if (tag == 26) {
                                    String s = input.readString();
                                    this.bitField0_ |= 1;
                                    this.leadingComments_ = s;
                                } else if (tag == 34) {
                                    String s2 = input.readString();
                                    this.bitField0_ |= 2;
                                    this.trailingComments_ = s2;
                                } else if (tag == 50) {
                                    String s3 = input.readString();
                                    if (!this.leadingDetachedComments_.isModifiable()) {
                                        this.leadingDetachedComments_ = GeneratedMessageLite.mutableCopy(this.leadingDetachedComments_);
                                    }
                                    this.leadingDetachedComments_.add(s3);
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
                            synchronized (Location.class) {
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
                Location location = new Location();
                DEFAULT_INSTANCE = location;
                location.makeImmutable();
            }

            public static Location getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Location> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public List<Location> getLocationList() {
            return this.location_;
        }

        public List<? extends LocationOrBuilder> getLocationOrBuilderList() {
            return this.location_;
        }

        public int getLocationCount() {
            return this.location_.size();
        }

        public Location getLocation(int index) {
            return (Location) this.location_.get(index);
        }

        public LocationOrBuilder getLocationOrBuilder(int index) {
            return (LocationOrBuilder) this.location_.get(index);
        }

        private void ensureLocationIsMutable() {
            if (!this.location_.isModifiable()) {
                this.location_ = GeneratedMessageLite.mutableCopy(this.location_);
            }
        }

        /* access modifiers changed from: private */
        public void setLocation(int index, Location value) {
            if (value != null) {
                ensureLocationIsMutable();
                this.location_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setLocation(int index, Location.Builder builderForValue) {
            ensureLocationIsMutable();
            this.location_.set(index, (Location) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addLocation(Location value) {
            if (value != null) {
                ensureLocationIsMutable();
                this.location_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addLocation(int index, Location value) {
            if (value != null) {
                ensureLocationIsMutable();
                this.location_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addLocation(Location.Builder builderForValue) {
            ensureLocationIsMutable();
            this.location_.add((Location) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addLocation(int index, Location.Builder builderForValue) {
            ensureLocationIsMutable();
            this.location_.add(index, (Location) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllLocation(Iterable<? extends Location> values) {
            ensureLocationIsMutable();
            AbstractMessageLite.addAll(values, this.location_);
        }

        /* access modifiers changed from: private */
        public void clearLocation() {
            this.location_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeLocation(int index) {
            ensureLocationIsMutable();
            this.location_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.location_.size(); i++) {
                output.writeMessage(1, (MessageLite) this.location_.get(i));
            }
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.location_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.location_.get(i));
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static SourceCodeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SourceCodeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SourceCodeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SourceCodeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SourceCodeInfo parseFrom(InputStream input) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SourceCodeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SourceCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SourceCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SourceCodeInfo parseFrom(CodedInputStream input) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SourceCodeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SourceCodeInfo prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(SourceCodeInfo.DEFAULT_INSTANCE);
            }

            public List<Location> getLocationList() {
                return Collections.unmodifiableList(((SourceCodeInfo) this.instance).getLocationList());
            }

            public int getLocationCount() {
                return ((SourceCodeInfo) this.instance).getLocationCount();
            }

            public Location getLocation(int index) {
                return ((SourceCodeInfo) this.instance).getLocation(index);
            }

            public Builder setLocation(int index, Location value) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).setLocation(index, value);
                return this;
            }

            public Builder setLocation(int index, Location.Builder builderForValue) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).setLocation(index, builderForValue);
                return this;
            }

            public Builder addLocation(Location value) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(value);
                return this;
            }

            public Builder addLocation(int index, Location value) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(index, value);
                return this;
            }

            public Builder addLocation(Location.Builder builderForValue) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(builderForValue);
                return this;
            }

            public Builder addLocation(int index, Location.Builder builderForValue) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(index, builderForValue);
                return this;
            }

            public Builder addAllLocation(Iterable<? extends Location> values) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addAllLocation(values);
                return this;
            }

            public Builder clearLocation() {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).clearLocation();
                return this;
            }

            public Builder removeLocation(int index) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).removeLocation(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new SourceCodeInfo();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.location_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    this.location_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.location_, ((SourceCodeInfo) arg1).location_);
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
                                if (!this.location_.isModifiable()) {
                                    this.location_ = GeneratedMessageLite.mutableCopy(this.location_);
                                }
                                this.location_.add((Location) input.readMessage(Location.parser(), extensionRegistry));
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
                        synchronized (SourceCodeInfo.class) {
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
            SourceCodeInfo sourceCodeInfo = new SourceCodeInfo();
            DEFAULT_INSTANCE = sourceCodeInfo;
            sourceCodeInfo.makeImmutable();
        }

        public static SourceCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SourceCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class GeneratedCodeInfo extends GeneratedMessageLite<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final GeneratedCodeInfo DEFAULT_INSTANCE;
        private static volatile Parser<GeneratedCodeInfo> PARSER;
        private Internal.ProtobufList<Annotation> annotation_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
            int getBegin();

            int getEnd();

            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            String getSourceFile();

            ByteString getSourceFileBytes();

            boolean hasBegin();

            boolean hasEnd();

            boolean hasSourceFile();
        }

        private GeneratedCodeInfo() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Annotation extends GeneratedMessageLite<Annotation, Builder> implements AnnotationOrBuilder {
            public static final int BEGIN_FIELD_NUMBER = 3;
            /* access modifiers changed from: private */
            public static final Annotation DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 4;
            private static volatile Parser<Annotation> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SOURCE_FILE_FIELD_NUMBER = 2;
            private int begin_;
            private int bitField0_;
            private int end_;
            private int pathMemoizedSerializedSize = -1;
            private Internal.IntList path_ = emptyIntList();
            private String sourceFile_ = "";

            private Annotation() {
            }

            public List<Integer> getPathList() {
                return this.path_;
            }

            public int getPathCount() {
                return this.path_.size();
            }

            public int getPath(int index) {
                return this.path_.getInt(index);
            }

            private void ensurePathIsMutable() {
                if (!this.path_.isModifiable()) {
                    this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                }
            }

            /* access modifiers changed from: private */
            public void setPath(int index, int value) {
                ensurePathIsMutable();
                this.path_.setInt(index, value);
            }

            /* access modifiers changed from: private */
            public void addPath(int value) {
                ensurePathIsMutable();
                this.path_.addInt(value);
            }

            /* access modifiers changed from: private */
            public void addAllPath(Iterable<? extends Integer> values) {
                ensurePathIsMutable();
                AbstractMessageLite.addAll(values, this.path_);
            }

            /* access modifiers changed from: private */
            public void clearPath() {
                this.path_ = emptyIntList();
            }

            public boolean hasSourceFile() {
                return (this.bitField0_ & 1) == 1;
            }

            public String getSourceFile() {
                return this.sourceFile_;
            }

            public ByteString getSourceFileBytes() {
                return ByteString.copyFromUtf8(this.sourceFile_);
            }

            /* access modifiers changed from: private */
            public void setSourceFile(String value) {
                if (value != null) {
                    this.bitField0_ |= 1;
                    this.sourceFile_ = value;
                    return;
                }
                throw null;
            }

            /* access modifiers changed from: private */
            public void clearSourceFile() {
                this.bitField0_ &= -2;
                this.sourceFile_ = getDefaultInstance().getSourceFile();
            }

            /* access modifiers changed from: private */
            public void setSourceFileBytes(ByteString value) {
                if (value != null) {
                    this.bitField0_ |= 1;
                    this.sourceFile_ = value.toStringUtf8();
                    return;
                }
                throw null;
            }

            public boolean hasBegin() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getBegin() {
                return this.begin_;
            }

            /* access modifiers changed from: private */
            public void setBegin(int value) {
                this.bitField0_ |= 2;
                this.begin_ = value;
            }

            /* access modifiers changed from: private */
            public void clearBegin() {
                this.bitField0_ &= -3;
                this.begin_ = 0;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 4) == 4;
            }

            public int getEnd() {
                return this.end_;
            }

            /* access modifiers changed from: private */
            public void setEnd(int value) {
                this.bitField0_ |= 4;
                this.end_ = value;
            }

            /* access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -5;
                this.end_ = 0;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    output.writeUInt32NoTag(10);
                    output.writeUInt32NoTag(this.pathMemoizedSerializedSize);
                }
                for (int i = 0; i < this.path_.size(); i++) {
                    output.writeInt32NoTag(this.path_.getInt(i));
                }
                if ((this.bitField0_ & 1) == 1) {
                    output.writeString(2, getSourceFile());
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeInt32(3, this.begin_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    output.writeInt32(4, this.end_);
                }
                this.unknownFields.writeTo(output);
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int dataSize = 0;
                for (int i = 0; i < this.path_.size(); i++) {
                    dataSize += CodedOutputStream.computeInt32SizeNoTag(this.path_.getInt(i));
                }
                int size2 = 0 + dataSize;
                if (!getPathList().isEmpty()) {
                    size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
                }
                this.pathMemoizedSerializedSize = dataSize;
                if ((this.bitField0_ & 1) == 1) {
                    size2 += CodedOutputStream.computeStringSize(2, getSourceFile());
                }
                if ((this.bitField0_ & 2) == 2) {
                    size2 += CodedOutputStream.computeInt32Size(3, this.begin_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    size2 += CodedOutputStream.computeInt32Size(4, this.end_);
                }
                int size3 = size2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size3;
                return size3;
            }

            public static Annotation parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Annotation parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Annotation parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Annotation parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Annotation parseFrom(InputStream input) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Annotation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Annotation parseDelimitedFrom(InputStream input) throws IOException {
                return (Annotation) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Annotation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Annotation) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Annotation parseFrom(CodedInputStream input) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Annotation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Annotation prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(Annotation.DEFAULT_INSTANCE);
                }

                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Annotation) this.instance).getPathList());
                }

                public int getPathCount() {
                    return ((Annotation) this.instance).getPathCount();
                }

                public int getPath(int index) {
                    return ((Annotation) this.instance).getPath(index);
                }

                public Builder setPath(int index, int value) {
                    copyOnWrite();
                    ((Annotation) this.instance).setPath(index, value);
                    return this;
                }

                public Builder addPath(int value) {
                    copyOnWrite();
                    ((Annotation) this.instance).addPath(value);
                    return this;
                }

                public Builder addAllPath(Iterable<? extends Integer> values) {
                    copyOnWrite();
                    ((Annotation) this.instance).addAllPath(values);
                    return this;
                }

                public Builder clearPath() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearPath();
                    return this;
                }

                public boolean hasSourceFile() {
                    return ((Annotation) this.instance).hasSourceFile();
                }

                public String getSourceFile() {
                    return ((Annotation) this.instance).getSourceFile();
                }

                public ByteString getSourceFileBytes() {
                    return ((Annotation) this.instance).getSourceFileBytes();
                }

                public Builder setSourceFile(String value) {
                    copyOnWrite();
                    ((Annotation) this.instance).setSourceFile(value);
                    return this;
                }

                public Builder clearSourceFile() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearSourceFile();
                    return this;
                }

                public Builder setSourceFileBytes(ByteString value) {
                    copyOnWrite();
                    ((Annotation) this.instance).setSourceFileBytes(value);
                    return this;
                }

                public boolean hasBegin() {
                    return ((Annotation) this.instance).hasBegin();
                }

                public int getBegin() {
                    return ((Annotation) this.instance).getBegin();
                }

                public Builder setBegin(int value) {
                    copyOnWrite();
                    ((Annotation) this.instance).setBegin(value);
                    return this;
                }

                public Builder clearBegin() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearBegin();
                    return this;
                }

                public boolean hasEnd() {
                    return ((Annotation) this.instance).hasEnd();
                }

                public int getEnd() {
                    return ((Annotation) this.instance).getEnd();
                }

                public Builder setEnd(int value) {
                    copyOnWrite();
                    ((Annotation) this.instance).setEnd(value);
                    return this;
                }

                public Builder clearEnd() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearEnd();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new Annotation();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        this.path_.makeImmutable();
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                        Annotation other = (Annotation) arg1;
                        this.path_ = visitor.visitIntList(this.path_, other.path_);
                        this.sourceFile_ = visitor.visitString(hasSourceFile(), this.sourceFile_, other.hasSourceFile(), other.sourceFile_);
                        this.begin_ = visitor.visitInt(hasBegin(), this.begin_, other.hasBegin(), other.begin_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, other.hasEnd(), other.end_);
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
                                    if (!this.path_.isModifiable()) {
                                        this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                                    }
                                    this.path_.addInt(input.readInt32());
                                } else if (tag == 10) {
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if (!this.path_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                        this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.path_.addInt(input.readInt32());
                                    }
                                    input.popLimit(limit);
                                } else if (tag == 18) {
                                    String s = input.readString();
                                    this.bitField0_ |= 1;
                                    this.sourceFile_ = s;
                                } else if (tag == 24) {
                                    this.bitField0_ |= 2;
                                    this.begin_ = input.readInt32();
                                } else if (tag == 32) {
                                    this.bitField0_ |= 4;
                                    this.end_ = input.readInt32();
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
                            synchronized (Annotation.class) {
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
                Annotation annotation = new Annotation();
                DEFAULT_INSTANCE = annotation;
                annotation.makeImmutable();
            }

            public static Annotation getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Annotation> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public List<? extends AnnotationOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int index) {
            return (Annotation) this.annotation_.get(index);
        }

        public AnnotationOrBuilder getAnnotationOrBuilder(int index) {
            return (AnnotationOrBuilder) this.annotation_.get(index);
        }

        private void ensureAnnotationIsMutable() {
            if (!this.annotation_.isModifiable()) {
                this.annotation_ = GeneratedMessageLite.mutableCopy(this.annotation_);
            }
        }

        /* access modifiers changed from: private */
        public void setAnnotation(int index, Annotation value) {
            if (value != null) {
                ensureAnnotationIsMutable();
                this.annotation_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAnnotation(int index, Annotation.Builder builderForValue) {
            ensureAnnotationIsMutable();
            this.annotation_.set(index, (Annotation) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAnnotation(Annotation value) {
            if (value != null) {
                ensureAnnotationIsMutable();
                this.annotation_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addAnnotation(int index, Annotation value) {
            if (value != null) {
                ensureAnnotationIsMutable();
                this.annotation_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addAnnotation(Annotation.Builder builderForValue) {
            ensureAnnotationIsMutable();
            this.annotation_.add((Annotation) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAnnotation(int index, Annotation.Builder builderForValue) {
            ensureAnnotationIsMutable();
            this.annotation_.add(index, (Annotation) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllAnnotation(Iterable<? extends Annotation> values) {
            ensureAnnotationIsMutable();
            AbstractMessageLite.addAll(values, this.annotation_);
        }

        /* access modifiers changed from: private */
        public void clearAnnotation() {
            this.annotation_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeAnnotation(int index) {
            ensureAnnotationIsMutable();
            this.annotation_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.annotation_.size(); i++) {
                output.writeMessage(1, (MessageLite) this.annotation_.get(i));
            }
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.annotation_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.annotation_.get(i));
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        public static GeneratedCodeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GeneratedCodeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GeneratedCodeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GeneratedCodeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GeneratedCodeInfo parseFrom(InputStream input) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GeneratedCodeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GeneratedCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GeneratedCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GeneratedCodeInfo parseFrom(CodedInputStream input) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GeneratedCodeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GeneratedCodeInfo prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(GeneratedCodeInfo.DEFAULT_INSTANCE);
            }

            public List<Annotation> getAnnotationList() {
                return Collections.unmodifiableList(((GeneratedCodeInfo) this.instance).getAnnotationList());
            }

            public int getAnnotationCount() {
                return ((GeneratedCodeInfo) this.instance).getAnnotationCount();
            }

            public Annotation getAnnotation(int index) {
                return ((GeneratedCodeInfo) this.instance).getAnnotation(index);
            }

            public Builder setAnnotation(int index, Annotation value) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).setAnnotation(index, value);
                return this;
            }

            public Builder setAnnotation(int index, Annotation.Builder builderForValue) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).setAnnotation(index, builderForValue);
                return this;
            }

            public Builder addAnnotation(Annotation value) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(value);
                return this;
            }

            public Builder addAnnotation(int index, Annotation value) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(index, value);
                return this;
            }

            public Builder addAnnotation(Annotation.Builder builderForValue) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(builderForValue);
                return this;
            }

            public Builder addAnnotation(int index, Annotation.Builder builderForValue) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(index, builderForValue);
                return this;
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> values) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAllAnnotation(values);
                return this;
            }

            public Builder clearAnnotation() {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).clearAnnotation();
                return this;
            }

            public Builder removeAnnotation(int index) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).removeAnnotation(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new GeneratedCodeInfo();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.annotation_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    this.annotation_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.annotation_, ((GeneratedCodeInfo) arg1).annotation_);
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
                                if (!this.annotation_.isModifiable()) {
                                    this.annotation_ = GeneratedMessageLite.mutableCopy(this.annotation_);
                                }
                                this.annotation_.add((Annotation) input.readMessage(Annotation.parser(), extensionRegistry));
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
                        synchronized (GeneratedCodeInfo.class) {
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
            GeneratedCodeInfo generatedCodeInfo = new GeneratedCodeInfo();
            DEFAULT_INSTANCE = generatedCodeInfo;
            generatedCodeInfo.makeImmutable();
        }

        public static GeneratedCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GeneratedCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
