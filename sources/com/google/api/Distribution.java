package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Distribution extends GeneratedMessageLite<Distribution, Builder> implements DistributionOrBuilder {
    public static final int BUCKET_COUNTS_FIELD_NUMBER = 7;
    public static final int BUCKET_OPTIONS_FIELD_NUMBER = 6;
    public static final int COUNT_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final Distribution DEFAULT_INSTANCE;
    public static final int MEAN_FIELD_NUMBER = 2;
    private static volatile Parser<Distribution> PARSER = null;
    public static final int RANGE_FIELD_NUMBER = 4;
    public static final int SUM_OF_SQUARED_DEVIATION_FIELD_NUMBER = 3;
    private int bitField0_;
    private Internal.LongList bucketCounts_ = emptyLongList();
    private BucketOptions bucketOptions_;
    private long count_;
    private double mean_;
    private Range range_;
    private double sumOfSquaredDeviation_;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface BucketOptionsOrBuilder extends MessageLiteOrBuilder {
        BucketOptions.Explicit getExplicitBuckets();

        BucketOptions.Exponential getExponentialBuckets();

        BucketOptions.Linear getLinearBuckets();

        BucketOptions.OptionsCase getOptionsCase();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface RangeOrBuilder extends MessageLiteOrBuilder {
        double getMax();

        double getMin();
    }

    private Distribution() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Range extends GeneratedMessageLite<Range, Builder> implements RangeOrBuilder {
        /* access modifiers changed from: private */
        public static final Range DEFAULT_INSTANCE;
        public static final int MAX_FIELD_NUMBER = 2;
        public static final int MIN_FIELD_NUMBER = 1;
        private static volatile Parser<Range> PARSER;
        private double max_;
        private double min_;

        private Range() {
        }

        public double getMin() {
            return this.min_;
        }

        /* access modifiers changed from: private */
        public void setMin(double value) {
            this.min_ = value;
        }

        /* access modifiers changed from: private */
        public void clearMin() {
            this.min_ = 0.0d;
        }

        public double getMax() {
            return this.max_;
        }

        /* access modifiers changed from: private */
        public void setMax(double value) {
            this.max_ = value;
        }

        /* access modifiers changed from: private */
        public void clearMax() {
            this.max_ = 0.0d;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            double d = this.min_;
            if (d != 0.0d) {
                output.writeDouble(1, d);
            }
            double d2 = this.max_;
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
            double d = this.min_;
            if (d != 0.0d) {
                size2 = 0 + CodedOutputStream.computeDoubleSize(1, d);
            }
            double d2 = this.max_;
            if (d2 != 0.0d) {
                size2 += CodedOutputStream.computeDoubleSize(2, d2);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static Range parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Range parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Range parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Range parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Range parseFrom(InputStream input) throws IOException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Range parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Range parseDelimitedFrom(InputStream input) throws IOException {
            return (Range) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Range parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Range) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Range parseFrom(CodedInputStream input) throws IOException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Range parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Range prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<Range, Builder> implements RangeOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(Range.DEFAULT_INSTANCE);
            }

            public double getMin() {
                return ((Range) this.instance).getMin();
            }

            public Builder setMin(double value) {
                copyOnWrite();
                ((Range) this.instance).setMin(value);
                return this;
            }

            public Builder clearMin() {
                copyOnWrite();
                ((Range) this.instance).clearMin();
                return this;
            }

            public double getMax() {
                return ((Range) this.instance).getMax();
            }

            public Builder setMax(double value) {
                copyOnWrite();
                ((Range) this.instance).setMax(value);
                return this;
            }

            public Builder clearMax() {
                copyOnWrite();
                ((Range) this.instance).clearMax();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new Range();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    Range other = (Range) arg1;
                    this.min_ = visitor.visitDouble(this.min_ != 0.0d, this.min_, other.min_ != 0.0d, other.min_);
                    this.max_ = visitor.visitDouble(this.max_ != 0.0d, this.max_, other.max_ != 0.0d, other.max_);
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
                                this.min_ = input.readDouble();
                            } else if (tag == 17) {
                                this.max_ = input.readDouble();
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
                        synchronized (Range.class) {
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
            Range range = new Range();
            DEFAULT_INSTANCE = range;
            range.makeImmutable();
        }

        public static Range getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Range> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class BucketOptions extends GeneratedMessageLite<BucketOptions, Builder> implements BucketOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final BucketOptions DEFAULT_INSTANCE;
        public static final int EXPLICIT_BUCKETS_FIELD_NUMBER = 3;
        public static final int EXPONENTIAL_BUCKETS_FIELD_NUMBER = 2;
        public static final int LINEAR_BUCKETS_FIELD_NUMBER = 1;
        private static volatile Parser<BucketOptions> PARSER;
        private int optionsCase_ = 0;
        private Object options_;

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface ExplicitOrBuilder extends MessageLiteOrBuilder {
            double getBounds(int i);

            int getBoundsCount();

            List<Double> getBoundsList();
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface ExponentialOrBuilder extends MessageLiteOrBuilder {
            double getGrowthFactor();

            int getNumFiniteBuckets();

            double getScale();
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface LinearOrBuilder extends MessageLiteOrBuilder {
            int getNumFiniteBuckets();

            double getOffset();

            double getWidth();
        }

        private BucketOptions() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Linear extends GeneratedMessageLite<Linear, Builder> implements LinearOrBuilder {
            /* access modifiers changed from: private */
            public static final Linear DEFAULT_INSTANCE;
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            public static final int OFFSET_FIELD_NUMBER = 3;
            private static volatile Parser<Linear> PARSER = null;
            public static final int WIDTH_FIELD_NUMBER = 2;
            private int numFiniteBuckets_;
            private double offset_;
            private double width_;

            private Linear() {
            }

            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            /* access modifiers changed from: private */
            public void setNumFiniteBuckets(int value) {
                this.numFiniteBuckets_ = value;
            }

            /* access modifiers changed from: private */
            public void clearNumFiniteBuckets() {
                this.numFiniteBuckets_ = 0;
            }

            public double getWidth() {
                return this.width_;
            }

            /* access modifiers changed from: private */
            public void setWidth(double value) {
                this.width_ = value;
            }

            /* access modifiers changed from: private */
            public void clearWidth() {
                this.width_ = 0.0d;
            }

            public double getOffset() {
                return this.offset_;
            }

            /* access modifiers changed from: private */
            public void setOffset(double value) {
                this.offset_ = value;
            }

            /* access modifiers changed from: private */
            public void clearOffset() {
                this.offset_ = 0.0d;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                int i = this.numFiniteBuckets_;
                if (i != 0) {
                    output.writeInt32(1, i);
                }
                double d = this.width_;
                if (d != 0.0d) {
                    output.writeDouble(2, d);
                }
                double d2 = this.offset_;
                if (d2 != 0.0d) {
                    output.writeDouble(3, d2);
                }
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int size2 = 0;
                int i = this.numFiniteBuckets_;
                if (i != 0) {
                    size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
                }
                double d = this.width_;
                if (d != 0.0d) {
                    size2 += CodedOutputStream.computeDoubleSize(2, d);
                }
                double d2 = this.offset_;
                if (d2 != 0.0d) {
                    size2 += CodedOutputStream.computeDoubleSize(3, d2);
                }
                this.memoizedSerializedSize = size2;
                return size2;
            }

            public static Linear parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Linear parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Linear parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Linear parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Linear parseFrom(InputStream input) throws IOException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Linear parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Linear parseDelimitedFrom(InputStream input) throws IOException {
                return (Linear) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Linear parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Linear) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Linear parseFrom(CodedInputStream input) throws IOException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Linear parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Linear prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Linear, Builder> implements LinearOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(Linear.DEFAULT_INSTANCE);
                }

                public int getNumFiniteBuckets() {
                    return ((Linear) this.instance).getNumFiniteBuckets();
                }

                public Builder setNumFiniteBuckets(int value) {
                    copyOnWrite();
                    ((Linear) this.instance).setNumFiniteBuckets(value);
                    return this;
                }

                public Builder clearNumFiniteBuckets() {
                    copyOnWrite();
                    ((Linear) this.instance).clearNumFiniteBuckets();
                    return this;
                }

                public double getWidth() {
                    return ((Linear) this.instance).getWidth();
                }

                public Builder setWidth(double value) {
                    copyOnWrite();
                    ((Linear) this.instance).setWidth(value);
                    return this;
                }

                public Builder clearWidth() {
                    copyOnWrite();
                    ((Linear) this.instance).clearWidth();
                    return this;
                }

                public double getOffset() {
                    return ((Linear) this.instance).getOffset();
                }

                public Builder setOffset(double value) {
                    copyOnWrite();
                    ((Linear) this.instance).setOffset(value);
                    return this;
                }

                public Builder clearOffset() {
                    copyOnWrite();
                    ((Linear) this.instance).clearOffset();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new Linear();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                        Linear other = (Linear) arg1;
                        this.numFiniteBuckets_ = visitor.visitInt(this.numFiniteBuckets_ != 0, this.numFiniteBuckets_, other.numFiniteBuckets_ != 0, other.numFiniteBuckets_);
                        this.width_ = visitor.visitDouble(this.width_ != 0.0d, this.width_, other.width_ != 0.0d, other.width_);
                        this.offset_ = visitor.visitDouble(this.offset_ != 0.0d, this.offset_, other.offset_ != 0.0d, other.offset_);
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
                                    this.numFiniteBuckets_ = input.readInt32();
                                } else if (tag == 17) {
                                    this.width_ = input.readDouble();
                                } else if (tag == 25) {
                                    this.offset_ = input.readDouble();
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
                            synchronized (Linear.class) {
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
                Linear linear = new Linear();
                DEFAULT_INSTANCE = linear;
                linear.makeImmutable();
            }

            public static Linear getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Linear> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Exponential extends GeneratedMessageLite<Exponential, Builder> implements ExponentialOrBuilder {
            /* access modifiers changed from: private */
            public static final Exponential DEFAULT_INSTANCE;
            public static final int GROWTH_FACTOR_FIELD_NUMBER = 2;
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            private static volatile Parser<Exponential> PARSER = null;
            public static final int SCALE_FIELD_NUMBER = 3;
            private double growthFactor_;
            private int numFiniteBuckets_;
            private double scale_;

            private Exponential() {
            }

            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            /* access modifiers changed from: private */
            public void setNumFiniteBuckets(int value) {
                this.numFiniteBuckets_ = value;
            }

            /* access modifiers changed from: private */
            public void clearNumFiniteBuckets() {
                this.numFiniteBuckets_ = 0;
            }

            public double getGrowthFactor() {
                return this.growthFactor_;
            }

            /* access modifiers changed from: private */
            public void setGrowthFactor(double value) {
                this.growthFactor_ = value;
            }

            /* access modifiers changed from: private */
            public void clearGrowthFactor() {
                this.growthFactor_ = 0.0d;
            }

            public double getScale() {
                return this.scale_;
            }

            /* access modifiers changed from: private */
            public void setScale(double value) {
                this.scale_ = value;
            }

            /* access modifiers changed from: private */
            public void clearScale() {
                this.scale_ = 0.0d;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                int i = this.numFiniteBuckets_;
                if (i != 0) {
                    output.writeInt32(1, i);
                }
                double d = this.growthFactor_;
                if (d != 0.0d) {
                    output.writeDouble(2, d);
                }
                double d2 = this.scale_;
                if (d2 != 0.0d) {
                    output.writeDouble(3, d2);
                }
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int size2 = 0;
                int i = this.numFiniteBuckets_;
                if (i != 0) {
                    size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
                }
                double d = this.growthFactor_;
                if (d != 0.0d) {
                    size2 += CodedOutputStream.computeDoubleSize(2, d);
                }
                double d2 = this.scale_;
                if (d2 != 0.0d) {
                    size2 += CodedOutputStream.computeDoubleSize(3, d2);
                }
                this.memoizedSerializedSize = size2;
                return size2;
            }

            public static Exponential parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Exponential parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Exponential parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Exponential parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Exponential parseFrom(InputStream input) throws IOException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Exponential parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Exponential parseDelimitedFrom(InputStream input) throws IOException {
                return (Exponential) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Exponential parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Exponential) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Exponential parseFrom(CodedInputStream input) throws IOException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Exponential parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Exponential prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Exponential, Builder> implements ExponentialOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(Exponential.DEFAULT_INSTANCE);
                }

                public int getNumFiniteBuckets() {
                    return ((Exponential) this.instance).getNumFiniteBuckets();
                }

                public Builder setNumFiniteBuckets(int value) {
                    copyOnWrite();
                    ((Exponential) this.instance).setNumFiniteBuckets(value);
                    return this;
                }

                public Builder clearNumFiniteBuckets() {
                    copyOnWrite();
                    ((Exponential) this.instance).clearNumFiniteBuckets();
                    return this;
                }

                public double getGrowthFactor() {
                    return ((Exponential) this.instance).getGrowthFactor();
                }

                public Builder setGrowthFactor(double value) {
                    copyOnWrite();
                    ((Exponential) this.instance).setGrowthFactor(value);
                    return this;
                }

                public Builder clearGrowthFactor() {
                    copyOnWrite();
                    ((Exponential) this.instance).clearGrowthFactor();
                    return this;
                }

                public double getScale() {
                    return ((Exponential) this.instance).getScale();
                }

                public Builder setScale(double value) {
                    copyOnWrite();
                    ((Exponential) this.instance).setScale(value);
                    return this;
                }

                public Builder clearScale() {
                    copyOnWrite();
                    ((Exponential) this.instance).clearScale();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new Exponential();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                        Exponential other = (Exponential) arg1;
                        this.numFiniteBuckets_ = visitor.visitInt(this.numFiniteBuckets_ != 0, this.numFiniteBuckets_, other.numFiniteBuckets_ != 0, other.numFiniteBuckets_);
                        this.growthFactor_ = visitor.visitDouble(this.growthFactor_ != 0.0d, this.growthFactor_, other.growthFactor_ != 0.0d, other.growthFactor_);
                        this.scale_ = visitor.visitDouble(this.scale_ != 0.0d, this.scale_, other.scale_ != 0.0d, other.scale_);
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
                                    this.numFiniteBuckets_ = input.readInt32();
                                } else if (tag == 17) {
                                    this.growthFactor_ = input.readDouble();
                                } else if (tag == 25) {
                                    this.scale_ = input.readDouble();
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
                            synchronized (Exponential.class) {
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
                Exponential exponential = new Exponential();
                DEFAULT_INSTANCE = exponential;
                exponential.makeImmutable();
            }

            public static Exponential getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Exponential> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Explicit extends GeneratedMessageLite<Explicit, Builder> implements ExplicitOrBuilder {
            public static final int BOUNDS_FIELD_NUMBER = 1;
            /* access modifiers changed from: private */
            public static final Explicit DEFAULT_INSTANCE;
            private static volatile Parser<Explicit> PARSER;
            private Internal.DoubleList bounds_ = emptyDoubleList();

            private Explicit() {
            }

            public List<Double> getBoundsList() {
                return this.bounds_;
            }

            public int getBoundsCount() {
                return this.bounds_.size();
            }

            public double getBounds(int index) {
                return this.bounds_.getDouble(index);
            }

            private void ensureBoundsIsMutable() {
                if (!this.bounds_.isModifiable()) {
                    this.bounds_ = GeneratedMessageLite.mutableCopy(this.bounds_);
                }
            }

            /* access modifiers changed from: private */
            public void setBounds(int index, double value) {
                ensureBoundsIsMutable();
                this.bounds_.setDouble(index, value);
            }

            /* access modifiers changed from: private */
            public void addBounds(double value) {
                ensureBoundsIsMutable();
                this.bounds_.addDouble(value);
            }

            /* access modifiers changed from: private */
            public void addAllBounds(Iterable<? extends Double> values) {
                ensureBoundsIsMutable();
                AbstractMessageLite.addAll(values, this.bounds_);
            }

            /* access modifiers changed from: private */
            public void clearBounds() {
                this.bounds_ = emptyDoubleList();
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                getSerializedSize();
                for (int i = 0; i < this.bounds_.size(); i++) {
                    output.writeDouble(1, this.bounds_.getDouble(i));
                }
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int size2 = 0 + (getBoundsList().size() * 8) + (getBoundsList().size() * 1);
                this.memoizedSerializedSize = size2;
                return size2;
            }

            public static Explicit parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Explicit parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Explicit parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Explicit parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Explicit parseFrom(InputStream input) throws IOException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Explicit parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Explicit parseDelimitedFrom(InputStream input) throws IOException {
                return (Explicit) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Explicit parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Explicit) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Explicit parseFrom(CodedInputStream input) throws IOException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Explicit parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Explicit prototype) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Explicit, Builder> implements ExplicitOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 x0) {
                    this();
                }

                private Builder() {
                    super(Explicit.DEFAULT_INSTANCE);
                }

                public List<Double> getBoundsList() {
                    return Collections.unmodifiableList(((Explicit) this.instance).getBoundsList());
                }

                public int getBoundsCount() {
                    return ((Explicit) this.instance).getBoundsCount();
                }

                public double getBounds(int index) {
                    return ((Explicit) this.instance).getBounds(index);
                }

                public Builder setBounds(int index, double value) {
                    copyOnWrite();
                    ((Explicit) this.instance).setBounds(index, value);
                    return this;
                }

                public Builder addBounds(double value) {
                    copyOnWrite();
                    ((Explicit) this.instance).addBounds(value);
                    return this;
                }

                public Builder addAllBounds(Iterable<? extends Double> values) {
                    copyOnWrite();
                    ((Explicit) this.instance).addAllBounds(values);
                    return this;
                }

                public Builder clearBounds() {
                    copyOnWrite();
                    ((Explicit) this.instance).clearBounds();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new Explicit();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        this.bounds_.makeImmutable();
                        return null;
                    case 4:
                        return new Builder((AnonymousClass1) null);
                    case 5:
                        this.bounds_ = ((GeneratedMessageLite.Visitor) arg0).visitDoubleList(this.bounds_, ((Explicit) arg1).bounds_);
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
                                    if (!this.bounds_.isModifiable()) {
                                        this.bounds_ = GeneratedMessageLite.mutableCopy(this.bounds_);
                                    }
                                    this.bounds_.addDouble(input.readDouble());
                                } else if (tag == 10) {
                                    int length = input.readRawVarint32();
                                    int limit = input.pushLimit(length);
                                    if (!this.bounds_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                        this.bounds_ = this.bounds_.mutableCopyWithCapacity((length / 8) + this.bounds_.size());
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.bounds_.addDouble(input.readDouble());
                                    }
                                    input.popLimit(limit);
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
                            synchronized (Explicit.class) {
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
                Explicit explicit = new Explicit();
                DEFAULT_INSTANCE = explicit;
                explicit.makeImmutable();
            }

            public static Explicit getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Explicit> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum OptionsCase implements Internal.EnumLite {
            LINEAR_BUCKETS(1),
            EXPONENTIAL_BUCKETS(2),
            EXPLICIT_BUCKETS(3),
            OPTIONS_NOT_SET(0);
            
            private final int value;

            private OptionsCase(int value2) {
                this.value = value2;
            }

            @Deprecated
            public static OptionsCase valueOf(int value2) {
                return forNumber(value2);
            }

            public static OptionsCase forNumber(int value2) {
                if (value2 == 0) {
                    return OPTIONS_NOT_SET;
                }
                if (value2 == 1) {
                    return LINEAR_BUCKETS;
                }
                if (value2 == 2) {
                    return EXPONENTIAL_BUCKETS;
                }
                if (value2 != 3) {
                    return null;
                }
                return EXPLICIT_BUCKETS;
            }

            public int getNumber() {
                return this.value;
            }
        }

        public OptionsCase getOptionsCase() {
            return OptionsCase.forNumber(this.optionsCase_);
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.optionsCase_ = 0;
            this.options_ = null;
        }

        public Linear getLinearBuckets() {
            if (this.optionsCase_ == 1) {
                return (Linear) this.options_;
            }
            return Linear.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setLinearBuckets(Linear value) {
            if (value != null) {
                this.options_ = value;
                this.optionsCase_ = 1;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setLinearBuckets(Linear.Builder builderForValue) {
            this.options_ = builderForValue.build();
            this.optionsCase_ = 1;
        }

        /* access modifiers changed from: private */
        public void mergeLinearBuckets(Linear value) {
            if (this.optionsCase_ != 1 || this.options_ == Linear.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = ((Linear.Builder) Linear.newBuilder((Linear) this.options_).mergeFrom(value)).buildPartial();
            }
            this.optionsCase_ = 1;
        }

        /* access modifiers changed from: private */
        public void clearLinearBuckets() {
            if (this.optionsCase_ == 1) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        public Exponential getExponentialBuckets() {
            if (this.optionsCase_ == 2) {
                return (Exponential) this.options_;
            }
            return Exponential.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setExponentialBuckets(Exponential value) {
            if (value != null) {
                this.options_ = value;
                this.optionsCase_ = 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setExponentialBuckets(Exponential.Builder builderForValue) {
            this.options_ = builderForValue.build();
            this.optionsCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void mergeExponentialBuckets(Exponential value) {
            if (this.optionsCase_ != 2 || this.options_ == Exponential.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = ((Exponential.Builder) Exponential.newBuilder((Exponential) this.options_).mergeFrom(value)).buildPartial();
            }
            this.optionsCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void clearExponentialBuckets() {
            if (this.optionsCase_ == 2) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        public Explicit getExplicitBuckets() {
            if (this.optionsCase_ == 3) {
                return (Explicit) this.options_;
            }
            return Explicit.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setExplicitBuckets(Explicit value) {
            if (value != null) {
                this.options_ = value;
                this.optionsCase_ = 3;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setExplicitBuckets(Explicit.Builder builderForValue) {
            this.options_ = builderForValue.build();
            this.optionsCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void mergeExplicitBuckets(Explicit value) {
            if (this.optionsCase_ != 3 || this.options_ == Explicit.getDefaultInstance()) {
                this.options_ = value;
            } else {
                this.options_ = ((Explicit.Builder) Explicit.newBuilder((Explicit) this.options_).mergeFrom(value)).buildPartial();
            }
            this.optionsCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void clearExplicitBuckets() {
            if (this.optionsCase_ == 3) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.optionsCase_ == 1) {
                output.writeMessage(1, (Linear) this.options_);
            }
            if (this.optionsCase_ == 2) {
                output.writeMessage(2, (Exponential) this.options_);
            }
            if (this.optionsCase_ == 3) {
                output.writeMessage(3, (Explicit) this.options_);
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.optionsCase_ == 1) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, (Linear) this.options_);
            }
            if (this.optionsCase_ == 2) {
                size2 += CodedOutputStream.computeMessageSize(2, (Exponential) this.options_);
            }
            if (this.optionsCase_ == 3) {
                size2 += CodedOutputStream.computeMessageSize(3, (Explicit) this.options_);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static BucketOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static BucketOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static BucketOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static BucketOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static BucketOptions parseFrom(InputStream input) throws IOException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static BucketOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static BucketOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (BucketOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static BucketOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BucketOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static BucketOptions parseFrom(CodedInputStream input) throws IOException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static BucketOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BucketOptions prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<BucketOptions, Builder> implements BucketOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(BucketOptions.DEFAULT_INSTANCE);
            }

            public OptionsCase getOptionsCase() {
                return ((BucketOptions) this.instance).getOptionsCase();
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((BucketOptions) this.instance).clearOptions();
                return this;
            }

            public Linear getLinearBuckets() {
                return ((BucketOptions) this.instance).getLinearBuckets();
            }

            public Builder setLinearBuckets(Linear value) {
                copyOnWrite();
                ((BucketOptions) this.instance).setLinearBuckets(value);
                return this;
            }

            public Builder setLinearBuckets(Linear.Builder builderForValue) {
                copyOnWrite();
                ((BucketOptions) this.instance).setLinearBuckets(builderForValue);
                return this;
            }

            public Builder mergeLinearBuckets(Linear value) {
                copyOnWrite();
                ((BucketOptions) this.instance).mergeLinearBuckets(value);
                return this;
            }

            public Builder clearLinearBuckets() {
                copyOnWrite();
                ((BucketOptions) this.instance).clearLinearBuckets();
                return this;
            }

            public Exponential getExponentialBuckets() {
                return ((BucketOptions) this.instance).getExponentialBuckets();
            }

            public Builder setExponentialBuckets(Exponential value) {
                copyOnWrite();
                ((BucketOptions) this.instance).setExponentialBuckets(value);
                return this;
            }

            public Builder setExponentialBuckets(Exponential.Builder builderForValue) {
                copyOnWrite();
                ((BucketOptions) this.instance).setExponentialBuckets(builderForValue);
                return this;
            }

            public Builder mergeExponentialBuckets(Exponential value) {
                copyOnWrite();
                ((BucketOptions) this.instance).mergeExponentialBuckets(value);
                return this;
            }

            public Builder clearExponentialBuckets() {
                copyOnWrite();
                ((BucketOptions) this.instance).clearExponentialBuckets();
                return this;
            }

            public Explicit getExplicitBuckets() {
                return ((BucketOptions) this.instance).getExplicitBuckets();
            }

            public Builder setExplicitBuckets(Explicit value) {
                copyOnWrite();
                ((BucketOptions) this.instance).setExplicitBuckets(value);
                return this;
            }

            public Builder setExplicitBuckets(Explicit.Builder builderForValue) {
                copyOnWrite();
                ((BucketOptions) this.instance).setExplicitBuckets(builderForValue);
                return this;
            }

            public Builder mergeExplicitBuckets(Explicit value) {
                copyOnWrite();
                ((BucketOptions) this.instance).mergeExplicitBuckets(value);
                return this;
            }

            public Builder clearExplicitBuckets() {
                copyOnWrite();
                ((BucketOptions) this.instance).clearExplicitBuckets();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            int i;
            boolean z = true;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new BucketOptions();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    BucketOptions other = (BucketOptions) arg1;
                    int i2 = AnonymousClass1.$SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase[other.getOptionsCase().ordinal()];
                    if (i2 == 1) {
                        if (this.optionsCase_ != 1) {
                            z = false;
                        }
                        this.options_ = visitor.visitOneofMessage(z, this.options_, other.options_);
                    } else if (i2 == 2) {
                        if (this.optionsCase_ != 2) {
                            z = false;
                        }
                        this.options_ = visitor.visitOneofMessage(z, this.options_, other.options_);
                    } else if (i2 == 3) {
                        if (this.optionsCase_ != 3) {
                            z = false;
                        }
                        this.options_ = visitor.visitOneofMessage(z, this.options_, other.options_);
                    } else if (i2 == 4) {
                        if (this.optionsCase_ == 0) {
                            z = false;
                        }
                        visitor.visitOneofNotSet(z);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.optionsCase_) != 0) {
                        this.optionsCase_ = i;
                    }
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
                                Linear.Builder subBuilder = null;
                                if (this.optionsCase_ == 1) {
                                    subBuilder = (Linear.Builder) ((Linear) this.options_).toBuilder();
                                }
                                MessageLite readMessage = input.readMessage(Linear.parser(), extensionRegistry);
                                this.options_ = readMessage;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((Linear) readMessage);
                                    this.options_ = subBuilder.buildPartial();
                                }
                                this.optionsCase_ = 1;
                            } else if (tag == 18) {
                                Exponential.Builder subBuilder2 = null;
                                if (this.optionsCase_ == 2) {
                                    subBuilder2 = (Exponential.Builder) ((Exponential) this.options_).toBuilder();
                                }
                                MessageLite readMessage2 = input.readMessage(Exponential.parser(), extensionRegistry);
                                this.options_ = readMessage2;
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((Exponential) readMessage2);
                                    this.options_ = subBuilder2.buildPartial();
                                }
                                this.optionsCase_ = 2;
                            } else if (tag == 26) {
                                Explicit.Builder subBuilder3 = null;
                                if (this.optionsCase_ == 3) {
                                    subBuilder3 = (Explicit.Builder) ((Explicit) this.options_).toBuilder();
                                }
                                MessageLite readMessage3 = input.readMessage(Explicit.parser(), extensionRegistry);
                                this.options_ = readMessage3;
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((Explicit) readMessage3);
                                    this.options_ = subBuilder3.buildPartial();
                                }
                                this.optionsCase_ = 3;
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
                        synchronized (BucketOptions.class) {
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
            BucketOptions bucketOptions = new BucketOptions();
            DEFAULT_INSTANCE = bucketOptions;
            bucketOptions.makeImmutable();
        }

        public static BucketOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BucketOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Distribution$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[BucketOptions.OptionsCase.values().length];
            $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase = iArr;
            try {
                iArr[BucketOptions.OptionsCase.LINEAR_BUCKETS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase[BucketOptions.OptionsCase.EXPONENTIAL_BUCKETS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase[BucketOptions.OptionsCase.EXPLICIT_BUCKETS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase[BucketOptions.OptionsCase.OPTIONS_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr2;
            try {
                iArr2[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    public long getCount() {
        return this.count_;
    }

    /* access modifiers changed from: private */
    public void setCount(long value) {
        this.count_ = value;
    }

    /* access modifiers changed from: private */
    public void clearCount() {
        this.count_ = 0;
    }

    public double getMean() {
        return this.mean_;
    }

    /* access modifiers changed from: private */
    public void setMean(double value) {
        this.mean_ = value;
    }

    /* access modifiers changed from: private */
    public void clearMean() {
        this.mean_ = 0.0d;
    }

    public double getSumOfSquaredDeviation() {
        return this.sumOfSquaredDeviation_;
    }

    /* access modifiers changed from: private */
    public void setSumOfSquaredDeviation(double value) {
        this.sumOfSquaredDeviation_ = value;
    }

    /* access modifiers changed from: private */
    public void clearSumOfSquaredDeviation() {
        this.sumOfSquaredDeviation_ = 0.0d;
    }

    public boolean hasRange() {
        return this.range_ != null;
    }

    public Range getRange() {
        Range range = this.range_;
        return range == null ? Range.getDefaultInstance() : range;
    }

    /* access modifiers changed from: private */
    public void setRange(Range value) {
        if (value != null) {
            this.range_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRange(Range.Builder builderForValue) {
        this.range_ = (Range) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeRange(Range value) {
        Range range = this.range_;
        if (range == null || range == Range.getDefaultInstance()) {
            this.range_ = value;
        } else {
            this.range_ = (Range) ((Range.Builder) Range.newBuilder(this.range_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearRange() {
        this.range_ = null;
    }

    public boolean hasBucketOptions() {
        return this.bucketOptions_ != null;
    }

    public BucketOptions getBucketOptions() {
        BucketOptions bucketOptions = this.bucketOptions_;
        return bucketOptions == null ? BucketOptions.getDefaultInstance() : bucketOptions;
    }

    /* access modifiers changed from: private */
    public void setBucketOptions(BucketOptions value) {
        if (value != null) {
            this.bucketOptions_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setBucketOptions(BucketOptions.Builder builderForValue) {
        this.bucketOptions_ = (BucketOptions) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeBucketOptions(BucketOptions value) {
        BucketOptions bucketOptions = this.bucketOptions_;
        if (bucketOptions == null || bucketOptions == BucketOptions.getDefaultInstance()) {
            this.bucketOptions_ = value;
        } else {
            this.bucketOptions_ = (BucketOptions) ((BucketOptions.Builder) BucketOptions.newBuilder(this.bucketOptions_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearBucketOptions() {
        this.bucketOptions_ = null;
    }

    public List<Long> getBucketCountsList() {
        return this.bucketCounts_;
    }

    public int getBucketCountsCount() {
        return this.bucketCounts_.size();
    }

    public long getBucketCounts(int index) {
        return this.bucketCounts_.getLong(index);
    }

    private void ensureBucketCountsIsMutable() {
        if (!this.bucketCounts_.isModifiable()) {
            this.bucketCounts_ = GeneratedMessageLite.mutableCopy(this.bucketCounts_);
        }
    }

    /* access modifiers changed from: private */
    public void setBucketCounts(int index, long value) {
        ensureBucketCountsIsMutable();
        this.bucketCounts_.setLong(index, value);
    }

    /* access modifiers changed from: private */
    public void addBucketCounts(long value) {
        ensureBucketCountsIsMutable();
        this.bucketCounts_.addLong(value);
    }

    /* access modifiers changed from: private */
    public void addAllBucketCounts(Iterable<? extends Long> values) {
        ensureBucketCountsIsMutable();
        AbstractMessageLite.addAll(values, this.bucketCounts_);
    }

    /* access modifiers changed from: private */
    public void clearBucketCounts() {
        this.bucketCounts_ = emptyLongList();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        getSerializedSize();
        long j = this.count_;
        if (j != 0) {
            output.writeInt64(1, j);
        }
        double d = this.mean_;
        if (d != 0.0d) {
            output.writeDouble(2, d);
        }
        double d2 = this.sumOfSquaredDeviation_;
        if (d2 != 0.0d) {
            output.writeDouble(3, d2);
        }
        if (this.range_ != null) {
            output.writeMessage(4, getRange());
        }
        if (this.bucketOptions_ != null) {
            output.writeMessage(6, getBucketOptions());
        }
        for (int i = 0; i < this.bucketCounts_.size(); i++) {
            output.writeInt64(7, this.bucketCounts_.getLong(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        long j = this.count_;
        if (j != 0) {
            size2 = 0 + CodedOutputStream.computeInt64Size(1, j);
        }
        double d = this.mean_;
        if (d != 0.0d) {
            size2 += CodedOutputStream.computeDoubleSize(2, d);
        }
        double d2 = this.sumOfSquaredDeviation_;
        if (d2 != 0.0d) {
            size2 += CodedOutputStream.computeDoubleSize(3, d2);
        }
        if (this.range_ != null) {
            size2 += CodedOutputStream.computeMessageSize(4, getRange());
        }
        if (this.bucketOptions_ != null) {
            size2 += CodedOutputStream.computeMessageSize(6, getBucketOptions());
        }
        int dataSize = 0;
        for (int i = 0; i < this.bucketCounts_.size(); i++) {
            dataSize += CodedOutputStream.computeInt64SizeNoTag(this.bucketCounts_.getLong(i));
        }
        int size3 = size2 + dataSize + (getBucketCountsList().size() * 1);
        this.memoizedSerializedSize = size3;
        return size3;
    }

    public static Distribution parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Distribution parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Distribution parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Distribution parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Distribution parseFrom(InputStream input) throws IOException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Distribution parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Distribution parseDelimitedFrom(InputStream input) throws IOException {
        return (Distribution) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Distribution parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Distribution) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Distribution parseFrom(CodedInputStream input) throws IOException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Distribution parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Distribution prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Distribution, Builder> implements DistributionOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Distribution.DEFAULT_INSTANCE);
        }

        public long getCount() {
            return ((Distribution) this.instance).getCount();
        }

        public Builder setCount(long value) {
            copyOnWrite();
            ((Distribution) this.instance).setCount(value);
            return this;
        }

        public Builder clearCount() {
            copyOnWrite();
            ((Distribution) this.instance).clearCount();
            return this;
        }

        public double getMean() {
            return ((Distribution) this.instance).getMean();
        }

        public Builder setMean(double value) {
            copyOnWrite();
            ((Distribution) this.instance).setMean(value);
            return this;
        }

        public Builder clearMean() {
            copyOnWrite();
            ((Distribution) this.instance).clearMean();
            return this;
        }

        public double getSumOfSquaredDeviation() {
            return ((Distribution) this.instance).getSumOfSquaredDeviation();
        }

        public Builder setSumOfSquaredDeviation(double value) {
            copyOnWrite();
            ((Distribution) this.instance).setSumOfSquaredDeviation(value);
            return this;
        }

        public Builder clearSumOfSquaredDeviation() {
            copyOnWrite();
            ((Distribution) this.instance).clearSumOfSquaredDeviation();
            return this;
        }

        public boolean hasRange() {
            return ((Distribution) this.instance).hasRange();
        }

        public Range getRange() {
            return ((Distribution) this.instance).getRange();
        }

        public Builder setRange(Range value) {
            copyOnWrite();
            ((Distribution) this.instance).setRange(value);
            return this;
        }

        public Builder setRange(Range.Builder builderForValue) {
            copyOnWrite();
            ((Distribution) this.instance).setRange(builderForValue);
            return this;
        }

        public Builder mergeRange(Range value) {
            copyOnWrite();
            ((Distribution) this.instance).mergeRange(value);
            return this;
        }

        public Builder clearRange() {
            copyOnWrite();
            ((Distribution) this.instance).clearRange();
            return this;
        }

        public boolean hasBucketOptions() {
            return ((Distribution) this.instance).hasBucketOptions();
        }

        public BucketOptions getBucketOptions() {
            return ((Distribution) this.instance).getBucketOptions();
        }

        public Builder setBucketOptions(BucketOptions value) {
            copyOnWrite();
            ((Distribution) this.instance).setBucketOptions(value);
            return this;
        }

        public Builder setBucketOptions(BucketOptions.Builder builderForValue) {
            copyOnWrite();
            ((Distribution) this.instance).setBucketOptions(builderForValue);
            return this;
        }

        public Builder mergeBucketOptions(BucketOptions value) {
            copyOnWrite();
            ((Distribution) this.instance).mergeBucketOptions(value);
            return this;
        }

        public Builder clearBucketOptions() {
            copyOnWrite();
            ((Distribution) this.instance).clearBucketOptions();
            return this;
        }

        public List<Long> getBucketCountsList() {
            return Collections.unmodifiableList(((Distribution) this.instance).getBucketCountsList());
        }

        public int getBucketCountsCount() {
            return ((Distribution) this.instance).getBucketCountsCount();
        }

        public long getBucketCounts(int index) {
            return ((Distribution) this.instance).getBucketCounts(index);
        }

        public Builder setBucketCounts(int index, long value) {
            copyOnWrite();
            ((Distribution) this.instance).setBucketCounts(index, value);
            return this;
        }

        public Builder addBucketCounts(long value) {
            copyOnWrite();
            ((Distribution) this.instance).addBucketCounts(value);
            return this;
        }

        public Builder addAllBucketCounts(Iterable<? extends Long> values) {
            copyOnWrite();
            ((Distribution) this.instance).addAllBucketCounts(values);
            return this;
        }

        public Builder clearBucketCounts() {
            copyOnWrite();
            ((Distribution) this.instance).clearBucketCounts();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Distribution();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.bucketCounts_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Distribution other = (Distribution) arg1;
                this.count_ = visitor.visitLong(this.count_ != 0, this.count_, other.count_ != 0, other.count_);
                this.mean_ = visitor.visitDouble(this.mean_ != 0.0d, this.mean_, other.mean_ != 0.0d, other.mean_);
                this.sumOfSquaredDeviation_ = visitor.visitDouble(this.sumOfSquaredDeviation_ != 0.0d, this.sumOfSquaredDeviation_, other.sumOfSquaredDeviation_ != 0.0d, other.sumOfSquaredDeviation_);
                this.range_ = (Range) visitor.visitMessage(this.range_, other.range_);
                this.bucketOptions_ = (BucketOptions) visitor.visitMessage(this.bucketOptions_, other.bucketOptions_);
                this.bucketCounts_ = visitor.visitLongList(this.bucketCounts_, other.bucketCounts_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= other.bitField0_;
                }
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
                        } else if (tag == 8) {
                            this.count_ = input.readInt64();
                        } else if (tag == 17) {
                            this.mean_ = input.readDouble();
                        } else if (tag == 25) {
                            this.sumOfSquaredDeviation_ = input.readDouble();
                        } else if (tag == 34) {
                            Range.Builder subBuilder = null;
                            if (this.range_ != null) {
                                subBuilder = (Range.Builder) this.range_.toBuilder();
                            }
                            Range range = (Range) input.readMessage(Range.parser(), extensionRegistry);
                            this.range_ = range;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(range);
                                this.range_ = (Range) subBuilder.buildPartial();
                            }
                        } else if (tag == 50) {
                            BucketOptions.Builder subBuilder2 = null;
                            if (this.bucketOptions_ != null) {
                                subBuilder2 = (BucketOptions.Builder) this.bucketOptions_.toBuilder();
                            }
                            BucketOptions bucketOptions = (BucketOptions) input.readMessage(BucketOptions.parser(), extensionRegistry);
                            this.bucketOptions_ = bucketOptions;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom(bucketOptions);
                                this.bucketOptions_ = (BucketOptions) subBuilder2.buildPartial();
                            }
                        } else if (tag == 56) {
                            if (!this.bucketCounts_.isModifiable()) {
                                this.bucketCounts_ = GeneratedMessageLite.mutableCopy(this.bucketCounts_);
                            }
                            this.bucketCounts_.addLong(input.readInt64());
                        } else if (tag == 58) {
                            int limit = input.pushLimit(input.readRawVarint32());
                            if (!this.bucketCounts_.isModifiable() && input.getBytesUntilLimit() > 0) {
                                this.bucketCounts_ = GeneratedMessageLite.mutableCopy(this.bucketCounts_);
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.bucketCounts_.addLong(input.readInt64());
                            }
                            input.popLimit(limit);
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
                    synchronized (Distribution.class) {
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
        Distribution distribution = new Distribution();
        DEFAULT_INSTANCE = distribution;
        distribution.makeImmutable();
    }

    public static Distribution getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Distribution> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
