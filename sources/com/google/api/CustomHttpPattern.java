package com.google.api;

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
public final class CustomHttpPattern extends GeneratedMessageLite<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
    /* access modifiers changed from: private */
    public static final CustomHttpPattern DEFAULT_INSTANCE;
    public static final int KIND_FIELD_NUMBER = 1;
    private static volatile Parser<CustomHttpPattern> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 2;
    private String kind_ = "";
    private String path_ = "";

    private CustomHttpPattern() {
    }

    public String getKind() {
        return this.kind_;
    }

    public ByteString getKindBytes() {
        return ByteString.copyFromUtf8(this.kind_);
    }

    /* access modifiers changed from: private */
    public void setKind(String value) {
        if (value != null) {
            this.kind_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = getDefaultInstance().getKind();
    }

    /* access modifiers changed from: private */
    public void setKindBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.kind_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getPath() {
        return this.path_;
    }

    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    /* access modifiers changed from: private */
    public void setPath(String value) {
        if (value != null) {
            this.path_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearPath() {
        this.path_ = getDefaultInstance().getPath();
    }

    /* access modifiers changed from: private */
    public void setPathBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.path_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.kind_.isEmpty()) {
            output.writeString(1, getKind());
        }
        if (!this.path_.isEmpty()) {
            output.writeString(2, getPath());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.kind_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getKind());
        }
        if (!this.path_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getPath());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static CustomHttpPattern parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CustomHttpPattern parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CustomHttpPattern parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CustomHttpPattern parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CustomHttpPattern parseFrom(InputStream input) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CustomHttpPattern parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CustomHttpPattern parseDelimitedFrom(InputStream input) throws IOException {
        return (CustomHttpPattern) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static CustomHttpPattern parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CustomHttpPattern) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CustomHttpPattern parseFrom(CodedInputStream input) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CustomHttpPattern parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CustomHttpPattern prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(CustomHttpPattern.DEFAULT_INSTANCE);
        }

        public String getKind() {
            return ((CustomHttpPattern) this.instance).getKind();
        }

        public ByteString getKindBytes() {
            return ((CustomHttpPattern) this.instance).getKindBytes();
        }

        public Builder setKind(String value) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setKind(value);
            return this;
        }

        public Builder clearKind() {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).clearKind();
            return this;
        }

        public Builder setKindBytes(ByteString value) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setKindBytes(value);
            return this;
        }

        public String getPath() {
            return ((CustomHttpPattern) this.instance).getPath();
        }

        public ByteString getPathBytes() {
            return ((CustomHttpPattern) this.instance).getPathBytes();
        }

        public Builder setPath(String value) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setPath(value);
            return this;
        }

        public Builder clearPath() {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).clearPath();
            return this;
        }

        public Builder setPathBytes(ByteString value) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setPathBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.CustomHttpPattern$1  reason: invalid class name */
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
                return new CustomHttpPattern();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                CustomHttpPattern other = (CustomHttpPattern) arg1;
                this.kind_ = visitor.visitString(!this.kind_.isEmpty(), this.kind_, !other.kind_.isEmpty(), other.kind_);
                this.path_ = visitor.visitString(!this.path_.isEmpty(), this.path_, !other.path_.isEmpty(), other.path_);
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
                            this.kind_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.path_ = input.readStringRequireUtf8();
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
                    synchronized (CustomHttpPattern.class) {
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
        CustomHttpPattern customHttpPattern = new CustomHttpPattern();
        DEFAULT_INSTANCE = customHttpPattern;
        customHttpPattern.makeImmutable();
    }

    public static CustomHttpPattern getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CustomHttpPattern> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
