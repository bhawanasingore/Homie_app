package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

final class AutoValue_Aggregation_LastValue extends Aggregation.LastValue {
    AutoValue_Aggregation_LastValue() {
    }

    public String toString() {
        return "LastValue{}";
    }

    public boolean equals(Object o) {
        if (o != this && !(o instanceof Aggregation.LastValue)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 1;
    }
}
