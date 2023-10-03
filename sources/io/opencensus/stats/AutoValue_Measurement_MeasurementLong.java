package io.opencensus.stats;

import io.opencensus.stats.Measure;
import io.opencensus.stats.Measurement;

final class AutoValue_Measurement_MeasurementLong extends Measurement.MeasurementLong {
    private final Measure.MeasureLong measure;
    private final long value;

    AutoValue_Measurement_MeasurementLong(Measure.MeasureLong measure2, long value2) {
        if (measure2 != null) {
            this.measure = measure2;
            this.value = value2;
            return;
        }
        throw new NullPointerException("Null measure");
    }

    public Measure.MeasureLong getMeasure() {
        return this.measure;
    }

    public long getValue() {
        return this.value;
    }

    public String toString() {
        return "MeasurementLong{measure=" + this.measure + ", value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Measurement.MeasurementLong)) {
            return false;
        }
        Measurement.MeasurementLong that = (Measurement.MeasurementLong) o;
        if (!this.measure.equals(that.getMeasure()) || this.value != that.getValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.value;
        return (int) (((long) (((1 * 1000003) ^ this.measure.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)));
    }
}
