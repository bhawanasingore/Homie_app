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
public final class Date extends GeneratedMessageLite<Date, Builder> implements DateOrBuilder {
    public static final int DAY_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final Date DEFAULT_INSTANCE;
    public static final int MONTH_FIELD_NUMBER = 2;
    private static volatile Parser<Date> PARSER = null;
    public static final int YEAR_FIELD_NUMBER = 1;
    private int day_;
    private int month_;
    private int year_;

    private Date() {
    }

    public int getYear() {
        return this.year_;
    }

    /* access modifiers changed from: private */
    public void setYear(int value) {
        this.year_ = value;
    }

    /* access modifiers changed from: private */
    public void clearYear() {
        this.year_ = 0;
    }

    public int getMonth() {
        return this.month_;
    }

    /* access modifiers changed from: private */
    public void setMonth(int value) {
        this.month_ = value;
    }

    /* access modifiers changed from: private */
    public void clearMonth() {
        this.month_ = 0;
    }

    public int getDay() {
        return this.day_;
    }

    /* access modifiers changed from: private */
    public void setDay(int value) {
        this.day_ = value;
    }

    /* access modifiers changed from: private */
    public void clearDay() {
        this.day_ = 0;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = this.year_;
        if (i != 0) {
            output.writeInt32(1, i);
        }
        int i2 = this.month_;
        if (i2 != 0) {
            output.writeInt32(2, i2);
        }
        int i3 = this.day_;
        if (i3 != 0) {
            output.writeInt32(3, i3);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.year_;
        if (i != 0) {
            size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
        }
        int i2 = this.month_;
        if (i2 != 0) {
            size2 += CodedOutputStream.computeInt32Size(2, i2);
        }
        int i3 = this.day_;
        if (i3 != 0) {
            size2 += CodedOutputStream.computeInt32Size(3, i3);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Date parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Date parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Date parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Date parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Date parseFrom(InputStream input) throws IOException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Date parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Date parseDelimitedFrom(InputStream input) throws IOException {
        return (Date) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Date parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Date) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Date parseFrom(CodedInputStream input) throws IOException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Date parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Date) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Date prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Date, Builder> implements DateOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Date.DEFAULT_INSTANCE);
        }

        public int getYear() {
            return ((Date) this.instance).getYear();
        }

        public Builder setYear(int value) {
            copyOnWrite();
            ((Date) this.instance).setYear(value);
            return this;
        }

        public Builder clearYear() {
            copyOnWrite();
            ((Date) this.instance).clearYear();
            return this;
        }

        public int getMonth() {
            return ((Date) this.instance).getMonth();
        }

        public Builder setMonth(int value) {
            copyOnWrite();
            ((Date) this.instance).setMonth(value);
            return this;
        }

        public Builder clearMonth() {
            copyOnWrite();
            ((Date) this.instance).clearMonth();
            return this;
        }

        public int getDay() {
            return ((Date) this.instance).getDay();
        }

        public Builder setDay(int value) {
            copyOnWrite();
            ((Date) this.instance).setDay(value);
            return this;
        }

        public Builder clearDay() {
            copyOnWrite();
            ((Date) this.instance).clearDay();
            return this;
        }
    }

    /* renamed from: com.google.type.Date$1  reason: invalid class name */
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
                return new Date();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Date other = (Date) arg1;
                boolean z = true;
                this.year_ = visitor.visitInt(this.year_ != 0, this.year_, other.year_ != 0, other.year_);
                this.month_ = visitor.visitInt(this.month_ != 0, this.month_, other.month_ != 0, other.month_);
                boolean z2 = this.day_ != 0;
                int i = this.day_;
                if (other.day_ == 0) {
                    z = false;
                }
                this.day_ = visitor.visitInt(z2, i, z, other.day_);
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
                            this.year_ = input.readInt32();
                        } else if (tag == 16) {
                            this.month_ = input.readInt32();
                        } else if (tag == 24) {
                            this.day_ = input.readInt32();
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
                    synchronized (Date.class) {
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
        Date date = new Date();
        DEFAULT_INSTANCE = date;
        date.makeImmutable();
    }

    public static Date getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Date> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
