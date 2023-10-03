package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

final class AutoValue_Aggregation_Count extends Aggregation.Count {
    AutoValue_Aggregation_Count() {
    }

    public String toString() {
        return "Count{}";
    }

    public boolean equals(Object o) {
        if (o != this && !(o instanceof Aggregation.Count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 1;
    }
}
