package io.opencensus.stats;

import io.opencensus.metrics.data.Exemplar;
import io.opencensus.stats.AggregationData;
import java.util.List;

final class AutoValue_AggregationData_DistributionData extends AggregationData.DistributionData {
    private final List<Long> bucketCounts;
    private final long count;
    private final List<Exemplar> exemplars;
    private final double mean;
    private final double sumOfSquaredDeviations;

    AutoValue_AggregationData_DistributionData(double mean2, long count2, double sumOfSquaredDeviations2, List<Long> bucketCounts2, List<Exemplar> exemplars2) {
        this.mean = mean2;
        this.count = count2;
        this.sumOfSquaredDeviations = sumOfSquaredDeviations2;
        if (bucketCounts2 != null) {
            this.bucketCounts = bucketCounts2;
            if (exemplars2 != null) {
                this.exemplars = exemplars2;
                return;
            }
            throw new NullPointerException("Null exemplars");
        }
        throw new NullPointerException("Null bucketCounts");
    }

    public double getMean() {
        return this.mean;
    }

    public long getCount() {
        return this.count;
    }

    public double getSumOfSquaredDeviations() {
        return this.sumOfSquaredDeviations;
    }

    public List<Long> getBucketCounts() {
        return this.bucketCounts;
    }

    public List<Exemplar> getExemplars() {
        return this.exemplars;
    }

    public String toString() {
        return "DistributionData{mean=" + this.mean + ", count=" + this.count + ", sumOfSquaredDeviations=" + this.sumOfSquaredDeviations + ", bucketCounts=" + this.bucketCounts + ", exemplars=" + this.exemplars + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AggregationData.DistributionData)) {
            return false;
        }
        AggregationData.DistributionData that = (AggregationData.DistributionData) o;
        if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(that.getMean()) && this.count == that.getCount() && Double.doubleToLongBits(this.sumOfSquaredDeviations) == Double.doubleToLongBits(that.getSumOfSquaredDeviations()) && this.bucketCounts.equals(that.getBucketCounts()) && this.exemplars.equals(that.getExemplars())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.count;
        return (((((int) (((long) (((int) (((long) (((int) (((long) (1 * 1000003)) ^ ((Double.doubleToLongBits(this.mean) >>> 32) ^ Double.doubleToLongBits(this.mean)))) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ ((Double.doubleToLongBits(this.sumOfSquaredDeviations) >>> 32) ^ Double.doubleToLongBits(this.sumOfSquaredDeviations)))) * 1000003) ^ this.bucketCounts.hashCode()) * 1000003) ^ this.exemplars.hashCode();
    }
}
