package io.opencensus.stats;

import io.opencensus.stats.AggregationData;

final class AutoValue_AggregationData_SumDataDouble extends AggregationData.SumDataDouble {
    private final double sum;

    AutoValue_AggregationData_SumDataDouble(double sum2) {
        this.sum = sum2;
    }

    public double getSum() {
        return this.sum;
    }

    public String toString() {
        return "SumDataDouble{sum=" + this.sum + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AggregationData.SumDataDouble)) {
            return false;
        }
        if (Double.doubleToLongBits(this.sum) == Double.doubleToLongBits(((AggregationData.SumDataDouble) o).getSum())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) (((long) (1 * 1000003)) ^ ((Double.doubleToLongBits(this.sum) >>> 32) ^ Double.doubleToLongBits(this.sum)));
    }
}
