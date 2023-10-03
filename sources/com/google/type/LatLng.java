package com.google.type;

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
public final class LatLng extends GeneratedMessageLite<LatLng, Builder> implements LatLngOrBuilder {
    /* access modifiers changed from: private */
    public static final LatLng DEFAULT_INSTANCE;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    private static volatile Parser<LatLng> PARSER;
    private double latitude_;
    private double longitude_;

    private LatLng() {
    }

    public double getLatitude() {
        return this.latitude_;
    }

    /* access modifiers changed from: private */
    public void setLatitude(double value) {
        this.latitude_ = value;
    }

    /* access modifiers changed from: private */
    public void clearLatitude() {
        this.latitude_ = 0.0d;
    }

    public double getLongitude() {
        return this.longitude_;
    }

    /* access modifiers changed from: private */
    public void setLongitude(double value) {
        this.longitude_ = value;
    }

    /* access modifiers changed from: private */
    public void clearLongitude() {
        this.longitude_ = 0.0d;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        double d = this.latitude_;
        if (d != 0.0d) {
            output.writeDouble(1, d);
        }
        double d2 = this.longitude_;
        if (d2 != 0.0d) {
            output.writeDouble(2, d2);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        double d = this.latitude_;
        if (d != 0.0d) {
            size2 = 0 + CodedOutputStream.computeDoubleSize(1, d);
        }
        double d2 = this.longitude_;
        if (d2 != 0.0d) {
            size2 += CodedOutputStream.computeDoubleSize(2, d2);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static LatLng parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LatLng parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LatLng parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LatLng parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LatLng parseFrom(InputStream input) throws IOException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LatLng parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LatLng parseDelimitedFrom(InputStream input) throws IOException {
        return (LatLng) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static LatLng parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LatLng) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LatLng parseFrom(CodedInputStream input) throws IOException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LatLng parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LatLng) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LatLng prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<LatLng, Builder> implements LatLngOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(LatLng.DEFAULT_INSTANCE);
        }

        public double getLatitude() {
            return ((LatLng) this.instance).getLatitude();
        }

        public Builder setLatitude(double value) {
            copyOnWrite();
            ((LatLng) this.instance).setLatitude(value);
            return this;
        }

        public Builder clearLatitude() {
            copyOnWrite();
            ((LatLng) this.instance).clearLatitude();
            return this;
        }

        public double getLongitude() {
            return ((LatLng) this.instance).getLongitude();
        }

        public Builder setLongitude(double value) {
            copyOnWrite();
            ((LatLng) this.instance).setLongitude(value);
            return this;
        }

        public Builder clearLongitude() {
            copyOnWrite();
            ((LatLng) this.instance).clearLongitude();
            return this;
        }
    }

    /* renamed from: com.google.type.LatLng$1  reason: invalid class name */
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
                return new LatLng();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                LatLng other = (LatLng) arg1;
                this.latitude_ = visitor.visitDouble(this.latitude_ != 0.0d, this.latitude_, other.latitude_ != 0.0d, other.latitude_);
                this.longitude_ = visitor.visitDouble(this.longitude_ != 0.0d, this.longitude_, other.longitude_ != 0.0d, other.longitude_);
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
                        } else if (tag == 9) {
                            this.latitude_ = input.readDouble();
                        } else if (tag == 17) {
                            this.longitude_ = input.readDouble();
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
                    synchronized (LatLng.class) {
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
        LatLng latLng = new LatLng();
        DEFAULT_INSTANCE = latLng;
        latLng.makeImmutable();
    }

    public static LatLng getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<LatLng> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
