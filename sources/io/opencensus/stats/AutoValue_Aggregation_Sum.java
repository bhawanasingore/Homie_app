package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

final class AutoValue_Aggregation_Sum extends Aggregation.Sum {
    AutoValue_Aggregation_Sum() {
    }

    public String toString() {
        return "Sum{}";
    }

    public boolean equals(Object o) {
        if (o != this && !(o instanceof Aggregation.Sum)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 1;
    }
}
