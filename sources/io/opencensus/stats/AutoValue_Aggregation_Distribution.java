package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

final class AutoValue_Aggregation_Distribution extends Aggregation.Distribution {
    private final BucketBoundaries bucketBoundaries;

    AutoValue_Aggregation_Distribution(BucketBoundaries bucketBoundaries2) {
        if (bucketBoundaries2 != null) {
            this.bucketBoundaries = bucketBoundaries2;
            return;
        }
        throw new NullPointerException("Null bucketBoundaries");
    }

    public BucketBoundaries getBucketBoundaries() {
        return this.bucketBoundaries;
    }

    public String toString() {
        return "Distribution{bucketBoundaries=" + this.bucketBoundaries + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Aggregation.Distribution) {
            return this.bucketBoundaries.equals(((Aggregation.Distribution) o).getBucketBoundaries());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.bucketBoundaries.hashCode();
    }
}
