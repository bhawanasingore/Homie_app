package io.opencensus.stats;

import java.util.List;

final class AutoValue_BucketBoundaries extends BucketBoundaries {
    private final List<Double> boundaries;

    AutoValue_BucketBoundaries(List<Double> boundaries2) {
        if (boundaries2 != null) {
            this.boundaries = boundaries2;
            return;
        }
        throw new NullPointerException("Null boundaries");
    }

    public List<Double> getBoundaries() {
        return this.boundaries;
    }

    public String toString() {
        return "BucketBoundaries{boundaries=" + this.boundaries + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof BucketBoundaries) {
            return this.boundaries.equals(((BucketBoundaries) o).getBoundaries());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.boundaries.hashCode();
    }
}
