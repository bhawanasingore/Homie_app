package io.opencensus.metrics.export;

import io.opencensus.common.Function;
import io.opencensus.internal.Utils;
import io.opencensus.metrics.data.Exemplar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public abstract class Distribution {
    @Nullable
    public abstract BucketOptions getBucketOptions();

    public abstract List<Bucket> getBuckets();

    public abstract long getCount();

    public abstract double getSum();

    public abstract double getSumOfSquaredDeviations();

    Distribution() {
    }

    public static Distribution create(long count, double sum, double sumOfSquaredDeviations, BucketOptions bucketOptions, List<Bucket> buckets) {
        boolean z = true;
        Utils.checkArgument(count >= 0, "count should be non-negative.");
        Utils.checkArgument(sumOfSquaredDeviations >= 0.0d, "sum of squared deviations should be non-negative.");
        if (count == 0) {
            Utils.checkArgument(sum == 0.0d, "sum should be 0 if count is 0.");
            if (sumOfSquaredDeviations != 0.0d) {
                z = false;
            }
            Utils.checkArgument(z, "sum of squared deviations should be 0 if count is 0.");
        }
        Utils.checkNotNull(bucketOptions, "bucketOptions");
        List<Bucket> bucketsCopy = Collections.unmodifiableList(new ArrayList((Collection) Utils.checkNotNull(buckets, "buckets")));
        Utils.checkListElementNotNull(bucketsCopy, "bucket");
        return new AutoValue_Distribution(count, sum, sumOfSquaredDeviations, bucketOptions, bucketsCopy);
    }

    public static abstract class BucketOptions {
        public abstract <T> T match(Function<? super ExplicitOptions, T> function, Function<? super BucketOptions, T> function2);

        private BucketOptions() {
        }

        public static BucketOptions explicitOptions(List<Double> bucketBoundaries) {
            return ExplicitOptions.create(bucketBoundaries);
        }

        public static abstract class ExplicitOptions extends BucketOptions {
            public abstract List<Double> getBucketBoundaries();

            ExplicitOptions() {
                super();
            }

            public final <T> T match(Function<? super ExplicitOptions, T> explicitFunction, Function<? super BucketOptions, T> function) {
                return explicitFunction.apply(this);
            }

            /* access modifiers changed from: private */
            public static ExplicitOptions create(List<Double> bucketBoundaries) {
                Utils.checkNotNull(bucketBoundaries, "bucketBoundaries");
                List<Double> bucketBoundariesCopy = Collections.unmodifiableList(new ArrayList(bucketBoundaries));
                checkBucketBoundsAreSorted(bucketBoundariesCopy);
                return new AutoValue_Distribution_BucketOptions_ExplicitOptions(bucketBoundariesCopy);
            }

            private static void checkBucketBoundsAreSorted(List<Double> bucketBoundaries) {
                if (bucketBoundaries.size() >= 1) {
                    double previous = ((Double) Utils.checkNotNull(bucketBoundaries.get(0), "bucketBoundary")).doubleValue();
                    Utils.checkArgument(previous > 0.0d, "bucket boundary should be > 0");
                    for (int i = 1; i < bucketBoundaries.size(); i++) {
                        double next = ((Double) Utils.checkNotNull(bucketBoundaries.get(i), "bucketBoundary")).doubleValue();
                        Utils.checkArgument(previous < next, "bucket boundaries not sorted.");
                        previous = next;
                    }
                }
            }
        }
    }

    public static abstract class Bucket {
        public abstract long getCount();

        @Nullable
        public abstract Exemplar getExemplar();

        Bucket() {
        }

        public static Bucket create(long count) {
            Utils.checkArgument(count >= 0, "bucket count should be non-negative.");
            return new AutoValue_Distribution_Bucket(count, (Exemplar) null);
        }

        public static Bucket create(long count, Exemplar exemplar) {
            Utils.checkArgument(count >= 0, "bucket count should be non-negative.");
            Utils.checkNotNull(exemplar, "exemplar");
            return new AutoValue_Distribution_Bucket(count, exemplar);
        }
    }
}
