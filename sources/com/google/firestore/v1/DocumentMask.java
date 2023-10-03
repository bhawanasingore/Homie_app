package com.google.firestore.v1;

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

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class DocumentMask extends GeneratedMessageLite<DocumentMask, Builder> implements DocumentMaskOrBuilder {
    /* access modifiers changed from: private */
    public static final DocumentMask DEFAULT_INSTANCE;
    public static final int FIELD_PATHS_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentMask> PARSER;
    private Internal.ProtobufList<String> fieldPaths_ = GeneratedMessageLite.emptyProtobufList();

    private DocumentMask() {
    }

    public List<String> getFieldPathsList() {
        return this.fieldPaths_;
    }

    public int getFieldPathsCount() {
        return this.fieldPaths_.size();
    }

    public String getFieldPaths(int index) {
        return (String) this.fieldPaths_.get(index);
    }

    public ByteString getFieldPathsBytes(int index) {
        return ByteString.copyFromUtf8((String) this.fieldPaths_.get(index));
    }

    private void ensureFieldPathsIsMutable() {
        if (!this.fieldPaths_.isModifiable()) {
            this.fieldPaths_ = GeneratedMessageLite.mutableCopy(this.fieldPaths_);
        }
    }

    /* access modifiers changed from: private */
    public void setFieldPaths(int index, String value) {
        if (value != null) {
            ensureFieldPathsIsMutable();
            this.fieldPaths_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFieldPaths(String value) {
        if (value != null) {
            ensureFieldPathsIsMutable();
            this.fieldPaths_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllFieldPaths(Iterable<String> values) {
        ensureFieldPathsIsMutable();
        AbstractMessageLite.addAll(values, this.fieldPaths_);
    }

    /* access modifiers changed from: private */
    public void clearFieldPaths() {
        this.fieldPaths_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addFieldPathsBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureFieldPathsIsMutable();
            this.fieldPaths_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fieldPaths_.size(); i++) {
            output.writeString(1, (String) this.fieldPaths_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int dataSize = 0;
        for (int i = 0; i < this.fieldPaths_.size(); i++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.fieldPaths_.get(i));
        }
        int size2 = 0 + dataSize + (getFieldPathsList().size() * 1);
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static DocumentMask parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DocumentMask parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DocumentMask parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static DocumentMask parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static DocumentMask parseFrom(InputStream input) throws IOException {
        return (DocumentMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentMask parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DocumentMask parseDelimitedFrom(InputStream input) throws IOException {
        return (DocumentMask) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentMask parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentMask) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static DocumentMask parseFrom(CodedInputStream input) throws IOException {
        return (DocumentMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static DocumentMask parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (DocumentMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentMask prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentMask, Builder> implements DocumentMaskOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(DocumentMask.DEFAULT_INSTANCE);
        }

        public List<String> getFieldPathsList() {
            return Collections.unmodifiableList(((DocumentMask) this.instance).getFieldPathsList());
        }

        public int getFieldPathsCount() {
            return ((DocumentMask) this.instance).getFieldPathsCount();
        }

        public String getFieldPaths(int index) {
            return ((DocumentMask) this.instance).getFieldPaths(index);
        }

        public ByteString getFieldPathsBytes(int index) {
            return ((DocumentMask) this.instance).getFieldPathsBytes(index);
        }

        public Builder setFieldPaths(int index, String value) {
            copyOnWrite();
            ((DocumentMask) this.instance).setFieldPaths(index, value);
            return this;
        }

        public Builder addFieldPaths(String value) {
            copyOnWrite();
            ((DocumentMask) this.instance).addFieldPaths(value);
            return this;
        }

        public Builder addAllFieldPaths(Iterable<String> values) {
            copyOnWrite();
            ((DocumentMask) this.instance).addAllFieldPaths(values);
            return this;
        }

        public Builder clearFieldPaths() {
            copyOnWrite();
            ((DocumentMask) this.instance).clearFieldPaths();
            return this;
        }

        public Builder addFieldPathsBytes(ByteString value) {
            copyOnWrite();
            ((DocumentMask) this.instance).addFieldPathsBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.DocumentMask$1  reason: invalid class name */
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
                return new DocumentMask();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fieldPaths_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.fieldPaths_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.fieldPaths_, ((DocumentMask) arg1).fieldPaths_);
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
                            if (!this.fieldPaths_.isModifiable()) {
                                this.fieldPaths_ = GeneratedMessageLite.mutableCopy(this.fieldPaths_);
                            }
                            this.fieldPaths_.add(s);
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
                    synchronized (DocumentMask.class) {
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
        DocumentMask documentMask = new DocumentMask();
        DEFAULT_INSTANCE = documentMask;
        documentMask.makeImmutable();
    }

    public static DocumentMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<DocumentMask> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
