package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Color extends GeneratedMessageLite<Color, Builder> implements ColorOrBuilder {
    public static final int ALPHA_FIELD_NUMBER = 4;
    public static final int BLUE_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final Color DEFAULT_INSTANCE;
    public static final int GREEN_FIELD_NUMBER = 2;
    private static volatile Parser<Color> PARSER = null;
    public static final int RED_FIELD_NUMBER = 1;
    private FloatValue alpha_;
    private float blue_;
    private float green_;
    private float red_;

    private Color() {
    }

    public float getRed() {
        return this.red_;
    }

    /* access modifiers changed from: private */
    public void setRed(float value) {
        this.red_ = value;
    }

    /* access modifiers changed from: private */
    public void clearRed() {
        this.red_ = 0.0f;
    }

    public float getGreen() {
        return this.green_;
    }

    /* access modifiers changed from: private */
    public void setGreen(float value) {
        this.green_ = value;
    }

    /* access modifiers changed from: private */
    public void clearGreen() {
        this.green_ = 0.0f;
    }

    public float getBlue() {
        return this.blue_;
    }

    /* access modifiers changed from: private */
    public void setBlue(float value) {
        this.blue_ = value;
    }

    /* access modifiers changed from: private */
    public void clearBlue() {
        this.blue_ = 0.0f;
    }

    public boolean hasAlpha() {
        return this.alpha_ != null;
    }

    public FloatValue getAlpha() {
        FloatValue floatValue = this.alpha_;
        return floatValue == null ? FloatValue.getDefaultInstance() : floatValue;
    }

    /* access modifiers changed from: private */
    public void setAlpha(FloatValue value) {
        if (value != null) {
            this.alpha_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAlpha(FloatValue.Builder builderForValue) {
        this.alpha_ = (FloatValue) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeAlpha(FloatValue value) {
        FloatValue floatValue = this.alpha_;
        if (floatValue == null || floatValue == FloatValue.getDefaultInstance()) {
            this.alpha_ = value;
        } else {
            this.alpha_ = (FloatValue) ((FloatValue.Builder) FloatValue.newBuilder(this.alpha_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAlpha() {
        this.alpha_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        float f = this.red_;
        if (f != 0.0f) {
            output.writeFloat(1, f);
        }
        float f2 = this.green_;
        if (f2 != 0.0f) {
            output.writeFloat(2, f2);
        }
        float f3 = this.blue_;
        if (f3 != 0.0f) {
            output.writeFloat(3, f3);
        }
        if (this.alpha_ != null) {
            output.writeMessage(4, getAlpha());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        float f = this.red_;
        if (f != 0.0f) {
            size2 = 0 + CodedOutputStream.computeFloatSize(1, f);
        }
        float f2 = this.green_;
        if (f2 != 0.0f) {
            size2 += CodedOutputStream.computeFloatSize(2, f2);
        }
        float f3 = this.blue_;
        if (f3 != 0.0f) {
            size2 += CodedOutputStream.computeFloatSize(3, f3);
        }
        if (this.alpha_ != null) {
            size2 += CodedOutputStream.computeMessageSize(4, getAlpha());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Color parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Color parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Color parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Color parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Color parseFrom(InputStream input) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Color parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Color parseDelimitedFrom(InputStream input) throws IOException {
        return (Color) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Color parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Color) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Color parseFrom(CodedInputStream input) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Color parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Color prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Color, Builder> implements ColorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Color.DEFAULT_INSTANCE);
        }

        public float getRed() {
            return ((Color) this.instance).getRed();
        }

        public Builder setRed(float value) {
            copyOnWrite();
            ((Color) this.instance).setRed(value);
            return this;
        }

        public Builder clearRed() {
            copyOnWrite();
            ((Color) this.instance).clearRed();
            return this;
        }

        public float getGreen() {
            return ((Color) this.instance).getGreen();
        }

        public Builder setGreen(float value) {
            copyOnWrite();
            ((Color) this.instance).setGreen(value);
            return this;
        }

        public Builder clearGreen() {
            copyOnWrite();
            ((Color) this.instance).clearGreen();
            return this;
        }

        public float getBlue() {
            return ((Color) this.instance).getBlue();
        }

        public Builder setBlue(float value) {
            copyOnWrite();
            ((Color) this.instance).setBlue(value);
            return this;
        }

        public Builder clearBlue() {
            copyOnWrite();
            ((Color) this.instance).clearBlue();
            return this;
        }

        public boolean hasAlpha() {
            return ((Color) this.instance).hasAlpha();
        }

        public FloatValue getAlpha() {
            return ((Color) this.instance).getAlpha();
        }

        public Builder setAlpha(FloatValue value) {
            copyOnWrite();
            ((Color) this.instance).setAlpha(value);
            return this;
        }

        public Builder setAlpha(FloatValue.Builder builderForValue) {
            copyOnWrite();
            ((Color) this.instance).setAlpha(builderForValue);
            return this;
        }

        public Builder mergeAlpha(FloatValue value) {
            copyOnWrite();
            ((Color) this.instance).mergeAlpha(value);
            return this;
        }

        public Builder clearAlpha() {
            copyOnWrite();
            ((Color) this.instance).clearAlpha();
            return this;
        }
    }

    /* renamed from: com.google.type.Color$1  reason: invalid class name */
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
                return new Color();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Color other = (Color) arg1;
                boolean z = true;
                this.red_ = visitor.visitFloat(this.red_ != 0.0f, this.red_, other.red_ != 0.0f, other.red_);
                this.green_ = visitor.visitFloat(this.green_ != 0.0f, this.green_, other.green_ != 0.0f, other.green_);
                boolean z2 = this.blue_ != 0.0f;
                float f = this.blue_;
                if (other.blue_ == 0.0f) {
                    z = false;
                }
                this.blue_ = visitor.visitFloat(z2, f, z, other.blue_);
                this.alpha_ = (FloatValue) visitor.visitMessage(this.alpha_, other.alpha_);
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
                        } else if (tag == 13) {
                            this.red_ = input.readFloat();
                        } else if (tag == 21) {
                            this.green_ = input.readFloat();
                        } else if (tag == 29) {
                            this.blue_ = input.readFloat();
                        } else if (tag == 34) {
                            FloatValue.Builder subBuilder = null;
                            if (this.alpha_ != null) {
                                subBuilder = (FloatValue.Builder) this.alpha_.toBuilder();
                            }
                            FloatValue floatValue = (FloatValue) input.readMessage(FloatValue.parser(), extensionRegistry);
                            this.alpha_ = floatValue;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(floatValue);
                                this.alpha_ = (FloatValue) subBuilder.buildPartial();
                            }
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
                    synchronized (Color.class) {
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
        Color color = new Color();
        DEFAULT_INSTANCE = color;
        color.makeImmutable();
    }

    public static Color getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Color> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
