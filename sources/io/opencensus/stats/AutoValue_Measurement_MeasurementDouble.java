package io.opencensus.stats;

import io.opencensus.stats.Measure;
import io.opencensus.stats.Measurement;

final class AutoValue_Measurement_MeasurementDouble extends Measurement.MeasurementDouble {
    private final Measure.MeasureDouble measure;
    private final double value;

    AutoValue_Measurement_MeasurementDouble(Measure.MeasureDouble measure2, double value2) {
        if (measure2 != null) {
            this.measure = measure2;
            this.value = value2;
            return;
        }
        throw new NullPointerException("Null measure");
    }

    public Measure.MeasureDouble getMeasure() {
        return this.measure;
    }

    public double getValue() {
        return this.value;
    }

    public String toString() {
        return "MeasurementDouble{measure=" + this.measure + ", value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Measurement.MeasurementDouble)) {
            return false;
        }
        Measurement.MeasurementDouble that = (Measurement.MeasurementDouble) o;
        if (!this.measure.equals(that.getMeasure()) || Double.doubleToLongBits(this.value) != Double.doubleToLongBits(that.getValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (((long) (((1 * 1000003) ^ this.measure.hashCode()) * 1000003)) ^ ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }
}
