package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Distribution;
import java.util.List;
import javax.annotation.Nullable;

final class AutoValue_Distribution extends Distribution {
    private final Distribution.BucketOptions bucketOptions;
    private final List<Distribution.Bucket> buckets;
    private final long count;
    private final double sum;
    private final double sumOfSquaredDeviations;

    AutoValue_Distribution(long count2, double sum2, double sumOfSquaredDeviations2, @Nullable Distribution.BucketOptions bucketOptions2, List<Distribution.Bucket> buckets2) {
        this.count = count2;
        this.sum = sum2;
        this.sumOfSquaredDeviations = sumOfSquaredDeviations2;
        this.bucketOptions = bucketOptions2;
        if (buckets2 != null) {
            this.buckets = buckets2;
            return;
        }
        throw new NullPointerException("Null buckets");
    }

    public long getCount() {
        return this.count;
    }

    public double getSum() {
        return this.sum;
    }

    public double getSumOfSquaredDeviations() {
        return this.sumOfSquaredDeviations;
    }

    @Nullable
    public Distribution.BucketOptions getBucketOptions() {
        return this.bucketOptions;
    }

    public List<Distribution.Bucket> getBuckets() {
        return this.buckets;
    }

    public String toString() {
        return "Distribution{count=" + this.count + ", sum=" + this.sum + ", sumOfSquaredDeviations=" + this.sumOfSquaredDeviations + ", bucketOptions=" + this.bucketOptions + ", buckets=" + this.buckets + "}";
    }

    public boolean equals(Object o) {
        Distribution.BucketOptions bucketOptions2;
        if (o == this) {
            return true;
        }
        if (!(o instanceof Distribution)) {
            return false;
        }
        Distribution that = (Distribution) o;
        if (this.count == that.getCount() && Double.doubleToLongBits(this.sum) == Double.doubleToLongBits(that.getSum()) && Double.doubleToLongBits(this.sumOfSquaredDeviations) == Double.doubleToLongBits(that.getSumOfSquaredDeviations()) && ((bucketOptions2 = this.bucketOptions) != null ? bucketOptions2.equals(that.getBucketOptions()) : that.getBucketOptions() == null) && this.buckets.equals(that.getBuckets())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.count;
        int h = ((int) (((long) (((int) (((long) (((int) (((long) (1 * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ ((Double.doubleToLongBits(this.sum) >>> 32) ^ Double.doubleToLongBits(this.sum)))) * 1000003)) ^ ((Double.doubleToLongBits(this.sumOfSquaredDeviations) >>> 32) ^ Double.doubleToLongBits(this.sumOfSquaredDeviations)))) * 1000003;
        Distribution.BucketOptions bucketOptions2 = this.bucketOptions;
        return ((h ^ (bucketOptions2 == null ? 0 : bucketOptions2.hashCode())) * 1000003) ^ this.buckets.hashCode();
    }
}
