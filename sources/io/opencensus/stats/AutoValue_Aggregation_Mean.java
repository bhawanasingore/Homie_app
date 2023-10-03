package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

@Deprecated
final class AutoValue_Aggregation_Mean extends Aggregation.Mean {
    AutoValue_Aggregation_Mean() {
    }

    public String toString() {
        return "Mean{}";
    }

    public boolean equals(Object o) {
        if (o != this && !(o instanceof Aggregation.Mean)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 1;
    }
}
