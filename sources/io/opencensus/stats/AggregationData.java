package io.opencensus.stats;

import io.opencensus.common.Function;
import io.opencensus.internal.Utils;
import io.opencensus.metrics.data.Exemplar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AggregationData {
    public abstract <T> T match(Function<? super SumDataDouble, T> function, Function<? super SumDataLong, T> function2, Function<? super CountData, T> function3, Function<? super DistributionData, T> function4, Function<? super LastValueDataDouble, T> function5, Function<? super LastValueDataLong, T> function6, Function<? super AggregationData, T> function7);

    private AggregationData() {
    }

    public static abstract class SumDataDouble extends AggregationData {
        public abstract double getSum();

        SumDataDouble() {
            super();
        }

        public static SumDataDouble create(double sum) {
            return new AutoValue_AggregationData_SumDataDouble(sum);
        }

        public final <T> T match(Function<? super SumDataDouble, T> p0, Function<? super SumDataLong, T> function, Function<? super CountData, T> function2, Function<? super DistributionData, T> function3, Function<? super LastValueDataDouble, T> function4, Function<? super LastValueDataLong, T> function5, Function<? super AggregationData, T> function6) {
            return p0.apply(this);
        }
    }

    public static abstract class SumDataLong extends AggregationData {
        public abstract long getSum();

        SumDataLong() {
            super();
        }

        public static SumDataLong create(long sum) {
            return new AutoValue_AggregationData_SumDataLong(sum);
        }

        public final <T> T match(Function<? super SumDataDouble, T> function, Function<? super SumDataLong, T> p1, Function<? super CountData, T> function2, Function<? super DistributionData, T> function3, Function<? super LastValueDataDouble, T> function4, Function<? super LastValueDataLong, T> function5, Function<? super AggregationData, T> function6) {
            return p1.apply(this);
        }
    }

    public static abstract class CountData extends AggregationData {
        public abstract long getCount();

        CountData() {
            super();
        }

        public static CountData create(long count) {
            return new AutoValue_AggregationData_CountData(count);
        }

        public final <T> T match(Function<? super SumDataDouble, T> function, Function<? super SumDataLong, T> function2, Function<? super CountData, T> p2, Function<? super DistributionData, T> function3, Function<? super LastValueDataDouble, T> function4, Function<? super LastValueDataLong, T> function5, Function<? super AggregationData, T> function6) {
            return p2.apply(this);
        }
    }

    @Deprecated
    public static abstract class MeanData extends AggregationData {
        public abstract long getCount();

        public abstract double getMean();

        MeanData() {
            super();
        }

        public static MeanData create(double mean, long count) {
            return new AutoValue_AggregationData_MeanData(mean, count);
        }

        public final <T> T match(Function<? super SumDataDouble, T> function, Function<? super SumDataLong, T> function2, Function<? super CountData, T> function3, Function<? super DistributionData, T> function4, Function<? super LastValueDataDouble, T> function5, Function<? super LastValueDataLong, T> function6, Function<? super AggregationData, T> defaultFunction) {
            return defaultFunction.apply(this);
        }
    }

    public static abstract class DistributionData extends AggregationData {
        public abstract List<Long> getBucketCounts();

        public abstract long getCount();

        public abstract List<Exemplar> getExemplars();

        public abstract double getMean();

        public abstract double getSumOfSquaredDeviations();

        DistributionData() {
            super();
        }

        @Deprecated
        public static DistributionData create(double mean, long count, double min, double max, double sumOfSquaredDeviations, List<Long> bucketCounts, List<Exemplar> exemplars) {
            return create(mean, count, sumOfSquaredDeviations, bucketCounts, exemplars);
        }

        public static DistributionData create(double mean, long count, double sumOfSquaredDeviations, List<Long> bucketCounts, List<Exemplar> exemplars) {
            List<Exemplar> list = exemplars;
            List<Long> bucketCountsCopy = Collections.unmodifiableList(new ArrayList((Collection) Utils.checkNotNull(bucketCounts, "bucketCounts")));
            for (Long bucketCount : bucketCountsCopy) {
                Utils.checkNotNull(bucketCount, "bucketCount");
            }
            Utils.checkNotNull(list, "exemplars");
            for (Exemplar exemplar : exemplars) {
                Utils.checkNotNull(exemplar, "exemplar");
            }
            return new AutoValue_AggregationData_DistributionData(mean, count, sumOfSquaredDeviations, bucketCountsCopy, Collections.unmodifiableList(new ArrayList(list)));
        }

        @Deprecated
        public static DistributionData create(double mean, long count, double min, double max, double sumOfSquaredDeviations, List<Long> bucketCounts) {
            return create(mean, count, sumOfSquaredDeviations, bucketCounts, Collections.emptyList());
        }

        public static DistributionData create(double mean, long count, double sumOfSquaredDeviations, List<Long> bucketCounts) {
            return create(mean, count, sumOfSquaredDeviations, bucketCounts, Collections.emptyList());
        }

        @Deprecated
        public double getMin() {
            return 0.0d;
        }

        @Deprecated
        public double getMax() {
            return 0.0d;
        }

        public final <T> T match(Function<? super SumDataDouble, T> function, Function<? super SumDataLong, T> function2, Function<? super CountData, T> function3, Function<? super DistributionData, T> p3, Function<? super LastValueDataDouble, T> function4, Function<? super LastValueDataLong, T> function5, Function<? super AggregationData, T> function6) {
            return p3.apply(this);
        }
    }

    public static abstract class LastValueDataDouble extends AggregationData {
        public abstract double getLastValue();

        LastValueDataDouble() {
            super();
        }

        public static LastValueDataDouble create(double lastValue) {
            return new AutoValue_AggregationData_LastValueDataDouble(lastValue);
        }

        public final <T> T match(Function<? super SumDataDouble, T> function, Function<? super SumDataLong, T> function2, Function<? super CountData, T> function3, Function<? super DistributionData, T> function4, Function<? super LastValueDataDouble, T> p4, Function<? super LastValueDataLong, T> function5, Function<? super AggregationData, T> function6) {
            return p4.apply(this);
        }
    }

    public static abstract class LastValueDataLong extends AggregationData {
        public abstract long getLastValue();

        LastValueDataLong() {
            super();
        }

        public static LastValueDataLong create(long lastValue) {
            return new AutoValue_AggregationData_LastValueDataLong(lastValue);
        }

        public final <T> T match(Function<? super SumDataDouble, T> function, Function<? super SumDataLong, T> function2, Function<? super CountData, T> function3, Function<? super DistributionData, T> function4, Function<? super LastValueDataDouble, T> function5, Function<? super LastValueDataLong, T> p5, Function<? super AggregationData, T> function6) {
            return p5.apply(this);
        }
    }
}
