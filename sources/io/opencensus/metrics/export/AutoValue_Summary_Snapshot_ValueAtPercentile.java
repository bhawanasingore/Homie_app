package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Summary;

final class AutoValue_Summary_Snapshot_ValueAtPercentile extends Summary.Snapshot.ValueAtPercentile {
    private final double percentile;
    private final double value;

    AutoValue_Summary_Snapshot_ValueAtPercentile(double percentile2, double value2) {
        this.percentile = percentile2;
        this.value = value2;
    }

    public double getPercentile() {
        return this.percentile;
    }

    public double getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueAtPercentile{percentile=" + this.percentile + ", value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Summary.Snapshot.ValueAtPercentile)) {
            return false;
        }
        Summary.Snapshot.ValueAtPercentile that = (Summary.Snapshot.ValueAtPercentile) o;
        if (Double.doubleToLongBits(this.percentile) == Double.doubleToLongBits(that.getPercentile()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(that.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) (((long) (((int) (((long) (1 * 1000003)) ^ ((Double.doubleToLongBits(this.percentile) >>> 32) ^ Double.doubleToLongBits(this.percentile)))) * 1000003)) ^ ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }
}
