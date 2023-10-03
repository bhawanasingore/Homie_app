package io.opencensus.stats;

import io.opencensus.stats.AggregationData;

final class AutoValue_AggregationData_LastValueDataDouble extends AggregationData.LastValueDataDouble {
    private final double lastValue;

    AutoValue_AggregationData_LastValueDataDouble(double lastValue2) {
        this.lastValue = lastValue2;
    }

    public double getLastValue() {
        return this.lastValue;
    }

    public String toString() {
        return "LastValueDataDouble{lastValue=" + this.lastValue + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AggregationData.LastValueDataDouble)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lastValue) == Double.doubleToLongBits(((AggregationData.LastValueDataDouble) o).getLastValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) (((long) (1 * 1000003)) ^ ((Double.doubleToLongBits(this.lastValue) >>> 32) ^ Double.doubleToLongBits(this.lastValue)));
    }
}
