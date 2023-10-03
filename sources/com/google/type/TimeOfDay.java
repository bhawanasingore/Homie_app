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
public final class TimeOfDay extends GeneratedMessageLite<TimeOfDay, Builder> implements TimeOfDayOrBuilder {
    /* access modifiers changed from: private */
    public static final TimeOfDay DEFAULT_INSTANCE;
    public static final int HOURS_FIELD_NUMBER = 1;
    public static final int MINUTES_FIELD_NUMBER = 2;
    public static final int NANOS_FIELD_NUMBER = 4;
    private static volatile Parser<TimeOfDay> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 3;
    private int hours_;
    private int minutes_;
    private int nanos_;
    private int seconds_;

    private TimeOfDay() {
    }

    public int getHours() {
        return this.hours_;
    }

    /* access modifiers changed from: private */
    public void setHours(int value) {
        this.hours_ = value;
    }

    /* access modifiers changed from: private */
    public void clearHours() {
        this.hours_ = 0;
    }

    public int getMinutes() {
        return this.minutes_;
    }

    /* access modifiers changed from: private */
    public void setMinutes(int value) {
        this.minutes_ = value;
    }

    /* access modifiers changed from: private */
    public void clearMinutes() {
        this.minutes_ = 0;
    }

    public int getSeconds() {
        return this.seconds_;
    }

    /* access modifiers changed from: private */
    public void setSeconds(int value) {
        this.seconds_ = value;
    }

    /* access modifiers changed from: private */
    public void clearSeconds() {
        this.seconds_ = 0;
    }

    public int getNanos() {
        return this.nanos_;
    }

    /* access modifiers changed from: private */
    public void setNanos(int value) {
        this.nanos_ = value;
    }

    /* access modifiers changed from: private */
    public void clearNanos() {
        this.nanos_ = 0;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = this.hours_;
        if (i != 0) {
            output.writeInt32(1, i);
        }
        int i2 = this.minutes_;
        if (i2 != 0) {
            output.writeInt32(2, i2);
        }
        int i3 = this.seconds_;
        if (i3 != 0) {
            output.writeInt32(3, i3);
        }
        int i4 = this.nanos_;
        if (i4 != 0) {
            output.writeInt32(4, i4);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.hours_;
        if (i != 0) {
            size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
        }
        int i2 = this.minutes_;
        if (i2 != 0) {
            size2 += CodedOutputStream.computeInt32Size(2, i2);
        }
        int i3 = this.seconds_;
        if (i3 != 0) {
            size2 += CodedOutputStream.computeInt32Size(3, i3);
        }
        int i4 = this.nanos_;
        if (i4 != 0) {
            size2 += CodedOutputStream.computeInt32Size(4, i4);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static TimeOfDay parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TimeOfDay parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TimeOfDay parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static TimeOfDay parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static TimeOfDay parseFrom(InputStream input) throws IOException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TimeOfDay parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TimeOfDay parseDelimitedFrom(InputStream input) throws IOException {
        return (TimeOfDay) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static TimeOfDay parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TimeOfDay) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static TimeOfDay parseFrom(CodedInputStream input) throws IOException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static TimeOfDay parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (TimeOfDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TimeOfDay prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<TimeOfDay, Builder> implements TimeOfDayOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(TimeOfDay.DEFAULT_INSTANCE);
        }

        public int getHours() {
            return ((TimeOfDay) this.instance).getHours();
        }

        public Builder setHours(int value) {
            copyOnWrite();
            ((TimeOfDay) this.instance).setHours(value);
            return this;
        }

        public Builder clearHours() {
            copyOnWrite();
            ((TimeOfDay) this.instance).clearHours();
            return this;
        }

        public int getMinutes() {
            return ((TimeOfDay) this.instance).getMinutes();
        }

        public Builder setMinutes(int value) {
            copyOnWrite();
            ((TimeOfDay) this.instance).setMinutes(value);
            return this;
        }

        public Builder clearMinutes() {
            copyOnWrite();
            ((TimeOfDay) this.instance).clearMinutes();
            return this;
        }

        public int getSeconds() {
            return ((TimeOfDay) this.instance).getSeconds();
        }

        public Builder setSeconds(int value) {
            copyOnWrite();
            ((TimeOfDay) this.instance).setSeconds(value);
            return this;
        }

        public Builder clearSeconds() {
            copyOnWrite();
            ((TimeOfDay) this.instance).clearSeconds();
            return this;
        }

        public int getNanos() {
            return ((TimeOfDay) this.instance).getNanos();
        }

        public Builder setNanos(int value) {
            copyOnWrite();
            ((TimeOfDay) this.instance).setNanos(value);
            return this;
        }

        public Builder clearNanos() {
            copyOnWrite();
            ((TimeOfDay) this.instance).clearNanos();
            return this;
        }
    }

    /* renamed from: com.google.type.TimeOfDay$1  reason: invalid class name */
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
                return new TimeOfDay();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                TimeOfDay other = (TimeOfDay) arg1;
                boolean z = true;
                this.hours_ = visitor.visitInt(this.hours_ != 0, this.hours_, other.hours_ != 0, other.hours_);
                this.minutes_ = visitor.visitInt(this.minutes_ != 0, this.minutes_, other.minutes_ != 0, other.minutes_);
                this.seconds_ = visitor.visitInt(this.seconds_ != 0, this.seconds_, other.seconds_ != 0, other.seconds_);
                boolean z2 = this.nanos_ != 0;
                int i = this.nanos_;
                if (other.nanos_ == 0) {
                    z = false;
                }
                this.nanos_ = visitor.visitInt(z2, i, z, other.nanos_);
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
                            this.hours_ = input.readInt32();
                        } else if (tag == 16) {
                            this.minutes_ = input.readInt32();
                        } else if (tag == 24) {
                            this.seconds_ = input.readInt32();
                        } else if (tag == 32) {
                            this.nanos_ = input.readInt32();
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
                    synchronized (TimeOfDay.class) {
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
        TimeOfDay timeOfDay = new TimeOfDay();
        DEFAULT_INSTANCE = timeOfDay;
        timeOfDay.makeImmutable();
    }

    public static TimeOfDay getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TimeOfDay> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
