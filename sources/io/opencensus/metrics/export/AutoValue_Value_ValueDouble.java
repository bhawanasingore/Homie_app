package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Value;

final class AutoValue_Value_ValueDouble extends Value.ValueDouble {
    private final double value;

    AutoValue_Value_ValueDouble(double value2) {
        this.value = value2;
    }

    /* access modifiers changed from: package-private */
    public double getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueDouble{value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Value.ValueDouble)) {
            return false;
        }
        if (Double.doubleToLongBits(this.value) == Double.doubleToLongBits(((Value.ValueDouble) o).getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) (((long) (1 * 1000003)) ^ ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }
}
