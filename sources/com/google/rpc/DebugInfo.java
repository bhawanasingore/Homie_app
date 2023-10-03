package com.google.rpc;

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
public final class DebugInfo extends GeneratedMessageLite<DebugInfo, Builder> implements DebugInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final DebugInfo DEFAULT_INSTANCE;
    public static final int DETAIL_FIELD_NUMBER = 2;
    private static volatile Parser<DebugInfo> PARSER = null;
    public static final int STACK_ENTRIES_FIELD_NUMBER = 1;
    private int bitField0_;
    private String detail_ = "";
    private Internal.ProtobufList<String> stackEntries_ = GeneratedMessageLite.emptyProtobufList();

    private DebugInfo() {
    }

    public List<String> getStackEntriesList() {
        return this.stackEntries_;
    }

    public int getStackEntriesCount() {
        return this.stackEntries_.size();
    }

    public String getStackEntries(int index) {
        return (String) this.stackEntries_.get(index);
    }

    public ByteString getStackEntriesBytes(int index) {
        return ByteString.copyFromUtf8((String) this.stackEntries_.get(index));
    }

    private void ensureStackEntriesIsMutable() {
        if (!this.stackEntries_.isModifiable()) {
            this.stackEntries_ = GeneratedMessageLite.mutableCopy(this.stackEntries_);
        }
    }

    /* access modifiers changed from: private */
    public void setStackEntries(int index, String value) {
        if (value != null) {
            ensureStackEntriesIsMutable();
            this.stackEntries_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addStackEntries(String value) {
        if (value != null) {
            ensureStackEntriesIsMutable();
            this.stackEntries_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllStackEntries(Iterable<String> values) {
        ensureStackEntriesIsMutable();
        AbstractMessageLite.addAll(values, this.stackEntries_);
    }

    /* access modifiers changed from: private */
    public void clearStackEntries() {
        this.stackEntries_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addStackEntriesBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureStackEntriesIsMutable();
            this.stackEntries_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public String getDetail() {
        return this.detail_;
    }

    public ByteString getDetailBytes() {
        return ByteString.copyFromUtf8(this.detail_);
    }

    /* access modifiers changed from: private */
    public void setDetail(String value) {
        if (value != null) {
            this.detail_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDetail() {
        this.detail_ = getDefaultInstance().getDetail();
    }

    /* access modifiers changed from: private */
    public void setDetailBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.detail_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.stackEntries_.size(); i++) {
            output.writeString(1, (String) this.stackEntries_.get(i));
        }
        if (!this.detail_.isEmpty()) {
            output.writeString(2, getDetail());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int dataSize = 0;
        for (int i = 0; i < this.stackEntries_.size(); i++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.stackEntries_.get(i));
        }
        int size2 = 0 + dataSize + (getStackEntriesList().size() * 1);
        if (!this.detail_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getDetail());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static DebugInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DebugInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DebugInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DebugInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DebugInfo parseFrom(InputStream input) throws IOException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DebugInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DebugInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (DebugInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static DebugInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DebugInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DebugInfo parseFrom(CodedInputStream input) throws IOException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DebugInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DebugInfo prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<DebugInfo, Builder> implements DebugInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(DebugInfo.DEFAULT_INSTANCE);
        }

        public List<String> getStackEntriesList() {
            return Collections.unmodifiableList(((DebugInfo) this.instance).getStackEntriesList());
        }

        public int getStackEntriesCount() {
            return ((DebugInfo) this.instance).getStackEntriesCount();
        }

        public String getStackEntries(int index) {
            return ((DebugInfo) this.instance).getStackEntries(index);
        }

        public ByteString getStackEntriesBytes(int index) {
            return ((DebugInfo) this.instance).getStackEntriesBytes(index);
        }

        public Builder setStackEntries(int index, String value) {
            copyOnWrite();
            ((DebugInfo) this.instance).setStackEntries(index, value);
            return this;
        }

        public Builder addStackEntries(String value) {
            copyOnWrite();
            ((DebugInfo) this.instance).addStackEntries(value);
            return this;
        }

        public Builder addAllStackEntries(Iterable<String> values) {
            copyOnWrite();
            ((DebugInfo) this.instance).addAllStackEntries(values);
            return this;
        }

        public Builder clearStackEntries() {
            copyOnWrite();
            ((DebugInfo) this.instance).clearStackEntries();
            return this;
        }

        public Builder addStackEntriesBytes(ByteString value) {
            copyOnWrite();
            ((DebugInfo) this.instance).addStackEntriesBytes(value);
            return this;
        }

        public String getDetail() {
            return ((DebugInfo) this.instance).getDetail();
        }

        public ByteString getDetailBytes() {
            return ((DebugInfo) this.instance).getDetailBytes();
        }

        public Builder setDetail(String value) {
            copyOnWrite();
            ((DebugInfo) this.instance).setDetail(value);
            return this;
        }

        public Builder clearDetail() {
            copyOnWrite();
            ((DebugInfo) this.instance).clearDetail();
            return this;
        }

        public Builder setDetailBytes(ByteString value) {
            copyOnWrite();
            ((DebugInfo) this.instance).setDetailBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.rpc.DebugInfo$1  reason: invalid class name */
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
                return new DebugInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.stackEntries_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                DebugInfo other = (DebugInfo) arg1;
                this.stackEntries_ = visitor.visitList(this.stackEntries_, other.stackEntries_);
                this.detail_ = visitor.visitString(!this.detail_.isEmpty(), this.detail_, !other.detail_.isEmpty(), other.detail_);
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
                            String s = input.readStringRequireUtf8();
                            if (!this.stackEntries_.isModifiable()) {
                                this.stackEntries_ = GeneratedMessageLite.mutableCopy(this.stackEntries_);
                            }
                            this.stackEntries_.add(s);
                        } else if (tag == 18) {
                            this.detail_ = input.readStringRequireUtf8();
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
                    synchronized (DebugInfo.class) {
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
        DebugInfo debugInfo = new DebugInfo();
        DEFAULT_INSTANCE = debugInfo;
        debugInfo.makeImmutable();
    }

    public static DebugInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<DebugInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
