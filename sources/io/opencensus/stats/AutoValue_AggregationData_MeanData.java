package io.opencensus.stats;

import io.opencensus.stats.AggregationData;

@Deprecated
final class AutoValue_AggregationData_MeanData extends AggregationData.MeanData {
    private final long count;
    private final double mean;

    AutoValue_AggregationData_MeanData(double mean2, long count2) {
        this.mean = mean2;
        this.count = count2;
    }

    public double getMean() {
        return this.mean;
    }

    public long getCount() {
        return this.count;
    }

    public String toString() {
        return "MeanData{mean=" + this.mean + ", count=" + this.count + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AggregationData.MeanData)) {
            return false;
        }
        AggregationData.MeanData that = (AggregationData.MeanData) o;
        if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(that.getMean()) && this.count == that.getCount()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.count;
        return (int) (((long) (((int) (((long) (1 * 1000003)) ^ ((Double.doubleToLongBits(this.mean) >>> 32) ^ Double.doubleToLongBits(this.mean)))) * 1000003)) ^ (j ^ (j >>> 32)));
    }
}
