package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Value;

final class AutoValue_Value_ValueDistribution extends Value.ValueDistribution {
    private final Distribution value;

    AutoValue_Value_ValueDistribution(Distribution value2) {
        if (value2 != null) {
            this.value = value2;
            return;
        }
        throw new NullPointerException("Null value");
    }

    /* access modifiers changed from: package-private */
    public Distribution getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueDistribution{value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Value.ValueDistribution) {
            return this.value.equals(((Value.ValueDistribution) o).getValue());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.value.hashCode();
    }
}
