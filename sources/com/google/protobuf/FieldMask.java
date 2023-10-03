package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class FieldMask extends GeneratedMessageLite<FieldMask, Builder> implements FieldMaskOrBuilder {
    /* access modifiers changed from: private */
    public static final FieldMask DEFAULT_INSTANCE;
    private static volatile Parser<FieldMask> PARSER = null;
    public static final int PATHS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<String> paths_ = GeneratedMessageLite.emptyProtobufList();

    private FieldMask() {
    }

    public List<String> getPathsList() {
        return this.paths_;
    }

    public int getPathsCount() {
        return this.paths_.size();
    }

    public String getPaths(int index) {
        return (String) this.paths_.get(index);
    }

    public ByteString getPathsBytes(int index) {
        return ByteString.copyFromUtf8((String) this.paths_.get(index));
    }

    private void ensurePathsIsMutable() {
        if (!this.paths_.isModifiable()) {
            this.paths_ = GeneratedMessageLite.mutableCopy(this.paths_);
        }
    }

    /* access modifiers changed from: private */
    public void setPaths(int index, String value) {
        if (value != null) {
            ensurePathsIsMutable();
            this.paths_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addPaths(String value) {
        if (value != null) {
            ensurePathsIsMutable();
            this.paths_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllPaths(Iterable<String> values) {
        ensurePathsIsMutable();
        AbstractMessageLite.addAll(values, this.paths_);
    }

    /* access modifiers changed from: private */
    public void clearPaths() {
        this.paths_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addPathsBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensurePathsIsMutable();
            this.paths_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.paths_.size(); i++) {
            output.writeString(1, (String) this.paths_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int dataSize = 0;
        for (int i = 0; i < this.paths_.size(); i++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.paths_.get(i));
        }
        int size2 = 0 + dataSize + (getPathsList().size() * 1);
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static FieldMask parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static FieldMask parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static FieldMask parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static FieldMask parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static FieldMask parseFrom(InputStream input) throws IOException {
        return (FieldMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static FieldMask parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (FieldMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static FieldMask parseDelimitedFrom(InputStream input) throws IOException {
        return (FieldMask) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static FieldMask parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (FieldMask) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static FieldMask parseFrom(CodedInputStream input) throws IOException {
        return (FieldMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static FieldMask parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (FieldMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FieldMask prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<FieldMask, Builder> implements FieldMaskOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(FieldMask.DEFAULT_INSTANCE);
        }

        public List<String> getPathsList() {
            return Collections.unmodifiableList(((FieldMask) this.instance).getPathsList());
        }

        public int getPathsCount() {
            return ((FieldMask) this.instance).getPathsCount();
        }

        public String getPaths(int index) {
            return ((FieldMask) this.instance).getPaths(index);
        }

        public ByteString getPathsBytes(int index) {
            return ((FieldMask) this.instance).getPathsBytes(index);
        }

        public Builder setPaths(int index, String value) {
            copyOnWrite();
            ((FieldMask) this.instance).setPaths(index, value);
            return this;
        }

        public Builder addPaths(String value) {
            copyOnWrite();
            ((FieldMask) this.instance).addPaths(value);
            return this;
        }

        public Builder addAllPaths(Iterable<String> values) {
            copyOnWrite();
            ((FieldMask) this.instance).addAllPaths(values);
            return this;
        }

        public Builder clearPaths() {
            copyOnWrite();
            ((FieldMask) this.instance).clearPaths();
            return this;
        }

        public Builder addPathsBytes(ByteString value) {
            copyOnWrite();
            ((FieldMask) this.instance).addPathsBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.protobuf.FieldMask$1  reason: invalid class name */
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
                return new FieldMask();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.paths_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.paths_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.paths_, ((FieldMask) arg1).paths_);
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
                            String s = input.readStringRequireUtf8();
                            if (!this.paths_.isModifiable()) {
                                this.paths_ = GeneratedMessageLite.mutableCopy(this.paths_);
                            }
                            this.paths_.add(s);
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
                    synchronized (FieldMask.class) {
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
        FieldMask fieldMask = new FieldMask();
        DEFAULT_INSTANCE = fieldMask;
        fieldMask.makeImmutable();
    }

    public static FieldMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FieldMask> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
