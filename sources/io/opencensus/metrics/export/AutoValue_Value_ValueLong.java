package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Value;

final class AutoValue_Value_ValueLong extends Value.ValueLong {
    private final long value;

    AutoValue_Value_ValueLong(long value2) {
        this.value = value2;
    }

    /* access modifiers changed from: package-private */
    public long getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueLong{value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Value.ValueLong)) {
            return false;
        }
        if (this.value == ((Value.ValueLong) o).getValue()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.value;
        return (int) (((long) (1 * 1000003)) ^ (j ^ (j >>> 32)));
    }
}
