package io.opencensus.stats;

import io.opencensus.common.Function;
import io.opencensus.stats.Measure;

public abstract class Measurement {
    public abstract Measure getMeasure();

    public abstract <T> T match(Function<? super MeasurementDouble, T> function, Function<? super MeasurementLong, T> function2, Function<? super Measurement, T> function3);

    private Measurement() {
    }

    public static abstract class MeasurementDouble extends Measurement {
        public abstract Measure.MeasureDouble getMeasure();

        public abstract double getValue();

        MeasurementDouble() {
            super();
        }

        public static MeasurementDouble create(Measure.MeasureDouble measure, double value) {
            return new AutoValue_Measurement_MeasurementDouble(measure, value);
        }

        public <T> T match(Function<? super MeasurementDouble, T> p0, Function<? super MeasurementLong, T> function, Function<? super Measurement, T> function2) {
            return p0.apply(this);
        }
    }

    public static abstract class MeasurementLong extends Measurement {
        public abstract Measure.MeasureLong getMeasure();

        public abstract long getValue();

        MeasurementLong() {
            super();
        }

        public static MeasurementLong create(Measure.MeasureLong measure, long value) {
            return new AutoValue_Measurement_MeasurementLong(measure, value);
        }

        public <T> T match(Function<? super MeasurementDouble, T> function, Function<? super MeasurementLong, T> p1, Function<? super Measurement, T> function2) {
            return p1.apply(this);
        }
    }
}
