package io.opencensus.stats;

import io.opencensus.common.Function;
import io.opencensus.internal.Utils;

public abstract class Aggregation {
    public abstract <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> function3, Function<? super LastValue, T> function4, Function<? super Aggregation, T> function5);

    private Aggregation() {
    }

    public static abstract class Sum extends Aggregation {
        private static final Sum INSTANCE = new AutoValue_Aggregation_Sum();

        Sum() {
            super();
        }

        public static Sum create() {
            return INSTANCE;
        }

        public final <T> T match(Function<? super Sum, T> p0, Function<? super Count, T> function, Function<? super Distribution, T> function2, Function<? super LastValue, T> function3, Function<? super Aggregation, T> function4) {
            return p0.apply(this);
        }
    }

    public static abstract class Count extends Aggregation {
        private static final Count INSTANCE = new AutoValue_Aggregation_Count();

        Count() {
            super();
        }

        public static Count create() {
            return INSTANCE;
        }

        public final <T> T match(Function<? super Sum, T> function, Function<? super Count, T> p1, Function<? super Distribution, T> function2, Function<? super LastValue, T> function3, Function<? super Aggregation, T> function4) {
            return p1.apply(this);
        }
    }

    @Deprecated
    public static abstract class Mean extends Aggregation {
        private static final Mean INSTANCE = new AutoValue_Aggregation_Mean();

        Mean() {
            super();
        }

        public static Mean create() {
            return INSTANCE;
        }

        public final <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> function3, Function<? super LastValue, T> function4, Function<? super Aggregation, T> defaultFunction) {
            return defaultFunction.apply(this);
        }
    }

    public static abstract class Distribution extends Aggregation {
        public abstract BucketBoundaries getBucketBoundaries();

        Distribution() {
            super();
        }

        public static Distribution create(BucketBoundaries bucketBoundaries) {
            Utils.checkNotNull(bucketBoundaries, "bucketBoundaries");
            return new AutoValue_Aggregation_Distribution(bucketBoundaries);
        }

        public final <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> p2, Function<? super LastValue, T> function3, Function<? super Aggregation, T> function4) {
            return p2.apply(this);
        }
    }

    public static abstract class LastValue extends Aggregation {
        private static final LastValue INSTANCE = new AutoValue_Aggregation_LastValue();

        LastValue() {
            super();
        }

        public static LastValue create() {
            return INSTANCE;
        }

        public final <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> function3, Function<? super LastValue, T> p3, Function<? super Aggregation, T> function4) {
            return p3.apply(this);
        }
    }
}
