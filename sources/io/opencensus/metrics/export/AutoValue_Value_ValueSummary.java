package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Value;

final class AutoValue_Value_ValueSummary extends Value.ValueSummary {
    private final Summary value;

    AutoValue_Value_ValueSummary(Summary value2) {
        if (value2 != null) {
            this.value = value2;
            return;
        }
        throw new NullPointerException("Null value");
    }

    /* access modifiers changed from: package-private */
    public Summary getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueSummary{value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Value.ValueSummary) {
            return this.value.equals(((Value.ValueSummary) o).getValue());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.value.hashCode();
    }
}
