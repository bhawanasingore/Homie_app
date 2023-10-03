package io.opencensus.metrics.export;

import io.opencensus.common.Function;

public abstract class Value {
    public abstract <T> T match(Function<? super Double, T> function, Function<? super Long, T> function2, Function<? super Distribution, T> function3, Function<? super Summary, T> function4, Function<? super Value, T> function5);

    Value() {
    }

    public static Value doubleValue(double value) {
        return ValueDouble.create(value);
    }

    public static Value longValue(long value) {
        return ValueLong.create(value);
    }

    public static Value distributionValue(Distribution value) {
        return ValueDistribution.create(value);
    }

    public static Value summaryValue(Summary value) {
        return ValueSummary.create(value);
    }

    static abstract class ValueDouble extends Value {
        /* access modifiers changed from: package-private */
        public abstract double getValue();

        ValueDouble() {
        }

        public final <T> T match(Function<? super Double, T> doubleFunction, Function<? super Long, T> function, Function<? super Distribution, T> function2, Function<? super Summary, T> function3, Function<? super Value, T> function4) {
            return doubleFunction.apply(Double.valueOf(getValue()));
        }

        static ValueDouble create(double value) {
            return new AutoValue_Value_ValueDouble(value);
        }
    }

    static abstract class ValueLong extends Value {
        /* access modifiers changed from: package-private */
        public abstract long getValue();

        ValueLong() {
        }

        public final <T> T match(Function<? super Double, T> function, Function<? super Long, T> longFunction, Function<? super Distribution, T> function2, Function<? super Summary, T> function3, Function<? super Value, T> function4) {
            return longFunction.apply(Long.valueOf(getValue()));
        }

        static ValueLong create(long value) {
            return new AutoValue_Value_ValueLong(value);
        }
    }

    static abstract class ValueDistribution extends Value {
        /* access modifiers changed from: package-private */
        public abstract Distribution getValue();

        ValueDistribution() {
        }

        public final <T> T match(Function<? super Double, T> function, Function<? super Long, T> function2, Function<? super Distribution, T> distributionFunction, Function<? super Summary, T> function3, Function<? super Value, T> function4) {
            return distributionFunction.apply(getValue());
        }

        static ValueDistribution create(Distribution value) {
            return new AutoValue_Value_ValueDistribution(value);
        }
    }

    static abstract class ValueSummary extends Value {
        /* access modifiers changed from: package-private */
        public abstract Summary getValue();

        ValueSummary() {
        }

        public final <T> T match(Function<? super Double, T> function, Function<? super Long, T> function2, Function<? super Distribution, T> function3, Function<? super Summary, T> summaryFunction, Function<? super Value, T> function4) {
            return summaryFunction.apply(getValue());
        }

        static ValueSummary create(Summary value) {
            return new AutoValue_Value_ValueSummary(value);
        }
    }
}
