package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class ExistenceFilter extends GeneratedMessageLite<ExistenceFilter, Builder> implements ExistenceFilterOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final ExistenceFilter DEFAULT_INSTANCE;
    private static volatile Parser<ExistenceFilter> PARSER = null;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private int count_;
    private int targetId_;

    private ExistenceFilter() {
    }

    public int getTargetId() {
        return this.targetId_;
    }

    /* access modifiers changed from: private */
    public void setTargetId(int value) {
        this.targetId_ = value;
    }

    /* access modifiers changed from: private */
    public void clearTargetId() {
        this.targetId_ = 0;
    }

    public int getCount() {
        return this.count_;
    }

    /* access modifiers changed from: private */
    public void setCount(int value) {
        this.count_ = value;
    }

    /* access modifiers changed from: private */
    public void clearCount() {
        this.count_ = 0;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = this.targetId_;
        if (i != 0) {
            output.writeInt32(1, i);
        }
        int i2 = this.count_;
        if (i2 != 0) {
            output.writeInt32(2, i2);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.targetId_;
        if (i != 0) {
            size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
        }
        int i2 = this.count_;
        if (i2 != 0) {
            size2 += CodedOutputStream.computeInt32Size(2, i2);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ExistenceFilter parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ExistenceFilter parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ExistenceFilter parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ExistenceFilter parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ExistenceFilter parseFrom(InputStream input) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ExistenceFilter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ExistenceFilter parseDelimitedFrom(InputStream input) throws IOException {
        return (ExistenceFilter) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ExistenceFilter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ExistenceFilter) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ExistenceFilter parseFrom(CodedInputStream input) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ExistenceFilter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ExistenceFilter prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<ExistenceFilter, Builder> implements ExistenceFilterOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ExistenceFilter.DEFAULT_INSTANCE);
        }

        public int getTargetId() {
            return ((ExistenceFilter) this.instance).getTargetId();
        }

        public Builder setTargetId(int value) {
            copyOnWrite();
            ((ExistenceFilter) this.instance).setTargetId(value);
            return this;
        }

        public Builder clearTargetId() {
            copyOnWrite();
            ((ExistenceFilter) this.instance).clearTargetId();
            return this;
        }

        public int getCount() {
            return ((ExistenceFilter) this.instance).getCount();
        }

        public Builder setCount(int value) {
            copyOnWrite();
            ((ExistenceFilter) this.instance).setCount(value);
            return this;
        }

        public Builder clearCount() {
            copyOnWrite();
            ((ExistenceFilter) this.instance).clearCount();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.ExistenceFilter$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
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
                return new ExistenceFilter();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ExistenceFilter other = (ExistenceFilter) arg1;
                boolean z = true;
                this.targetId_ = visitor.visitInt(this.targetId_ != 0, this.targetId_, other.targetId_ != 0, other.targetId_);
                boolean z2 = this.count_ != 0;
                int i = this.count_;
                if (other.count_ == 0) {
                    z = false;
                }
                this.count_ = visitor.visitInt(z2, i, z, other.count_);
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
                        } else if (tag == 8) {
                            this.targetId_ = input.readInt32();
                        } else if (tag == 16) {
                            this.count_ = input.readInt32();
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
                    synchronized (ExistenceFilter.class) {
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
        ExistenceFilter existenceFilter = new ExistenceFilter();
        DEFAULT_INSTANCE = existenceFilter;
        existenceFilter.makeImmutable();
    }

    public static ExistenceFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ExistenceFilter> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
