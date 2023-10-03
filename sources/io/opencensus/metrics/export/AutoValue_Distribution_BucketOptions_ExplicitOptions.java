package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Distribution;
import java.util.List;

final class AutoValue_Distribution_BucketOptions_ExplicitOptions extends Distribution.BucketOptions.ExplicitOptions {
    private final List<Double> bucketBoundaries;

    AutoValue_Distribution_BucketOptions_ExplicitOptions(List<Double> bucketBoundaries2) {
        if (bucketBoundaries2 != null) {
            this.bucketBoundaries = bucketBoundaries2;
            return;
        }
        throw new NullPointerException("Null bucketBoundaries");
    }

    public List<Double> getBucketBoundaries() {
        return this.bucketBoundaries;
    }

    public String toString() {
        return "ExplicitOptions{bucketBoundaries=" + this.bucketBoundaries + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Distribution.BucketOptions.ExplicitOptions) {
            return this.bucketBoundaries.equals(((Distribution.BucketOptions.ExplicitOptions) o).getBucketBoundaries());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.bucketBoundaries.hashCode();
    }
}
