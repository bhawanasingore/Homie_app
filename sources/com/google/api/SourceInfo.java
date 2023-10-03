package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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
public final class SourceInfo extends GeneratedMessageLite<SourceInfo, Builder> implements SourceInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final SourceInfo DEFAULT_INSTANCE;
    private static volatile Parser<SourceInfo> PARSER = null;
    public static final int SOURCE_FILES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Any> sourceFiles_ = emptyProtobufList();

    private SourceInfo() {
    }

    public List<Any> getSourceFilesList() {
        return this.sourceFiles_;
    }

    public List<? extends AnyOrBuilder> getSourceFilesOrBuilderList() {
        return this.sourceFiles_;
    }

    public int getSourceFilesCount() {
        return this.sourceFiles_.size();
    }

    public Any getSourceFiles(int index) {
        return (Any) this.sourceFiles_.get(index);
    }

    public AnyOrBuilder getSourceFilesOrBuilder(int index) {
        return (AnyOrBuilder) this.sourceFiles_.get(index);
    }

    private void ensureSourceFilesIsMutable() {
        if (!this.sourceFiles_.isModifiable()) {
            this.sourceFiles_ = GeneratedMessageLite.mutableCopy(this.sourceFiles_);
        }
    }

    /* access modifiers changed from: private */
    public void setSourceFiles(int index, Any value) {
        if (value != null) {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setSourceFiles(int index, Any.Builder builderForValue) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.set(index, (Any) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(Any value) {
        if (value != null) {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(int index, Any value) {
        if (value != null) {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(Any.Builder builderForValue) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add((Any) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(int index, Any.Builder builderForValue) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(index, (Any) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllSourceFiles(Iterable<? extends Any> values) {
        ensureSourceFilesIsMutable();
        AbstractMessageLite.addAll(values, this.sourceFiles_);
    }

    /* access modifiers changed from: private */
    public void clearSourceFiles() {
        this.sourceFiles_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeSourceFiles(int index) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.sourceFiles_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.sourceFiles_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.sourceFiles_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.sourceFiles_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static SourceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static SourceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static SourceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static SourceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static SourceInfo parseFrom(InputStream input) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static SourceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static SourceInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (SourceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static SourceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SourceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static SourceInfo parseFrom(CodedInputStream input) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static SourceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SourceInfo prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<SourceInfo, Builder> implements SourceInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(SourceInfo.DEFAULT_INSTANCE);
        }

        public List<Any> getSourceFilesList() {
            return Collections.unmodifiableList(((SourceInfo) this.instance).getSourceFilesList());
        }

        public int getSourceFilesCount() {
            return ((SourceInfo) this.instance).getSourceFilesCount();
        }

        public Any getSourceFiles(int index) {
            return ((SourceInfo) this.instance).getSourceFiles(index);
        }

        public Builder setSourceFiles(int index, Any value) {
            copyOnWrite();
            ((SourceInfo) this.instance).setSourceFiles(index, value);
            return this;
        }

        public Builder setSourceFiles(int index, Any.Builder builderForValue) {
            copyOnWrite();
            ((SourceInfo) this.instance).setSourceFiles(index, builderForValue);
            return this;
        }

        public Builder addSourceFiles(Any value) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(value);
            return this;
        }

        public Builder addSourceFiles(int index, Any value) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(index, value);
            return this;
        }

        public Builder addSourceFiles(Any.Builder builderForValue) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(builderForValue);
            return this;
        }

        public Builder addSourceFiles(int index, Any.Builder builderForValue) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(index, builderForValue);
            return this;
        }

        public Builder addAllSourceFiles(Iterable<? extends Any> values) {
            copyOnWrite();
            ((SourceInfo) this.instance).addAllSourceFiles(values);
            return this;
        }

        public Builder clearSourceFiles() {
            copyOnWrite();
            ((SourceInfo) this.instance).clearSourceFiles();
            return this;
        }

        public Builder removeSourceFiles(int index) {
            copyOnWrite();
            ((SourceInfo) this.instance).removeSourceFiles(index);
            return this;
        }
    }

    /* renamed from: com.google.api.SourceInfo$1  reason: invalid class name */
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
                return new SourceInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.sourceFiles_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.sourceFiles_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.sourceFiles_, ((SourceInfo) arg1).sourceFiles_);
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
                            if (!this.sourceFiles_.isModifiable()) {
                                this.sourceFiles_ = GeneratedMessageLite.mutableCopy(this.sourceFiles_);
                            }
                            this.sourceFiles_.add((Any) input.readMessage(Any.parser(), extensionRegistry));
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
                    synchronized (SourceInfo.class) {
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
        SourceInfo sourceInfo = new SourceInfo();
        DEFAULT_INSTANCE = sourceInfo;
        sourceInfo.makeImmutable();
    }

    public static SourceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SourceInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
