package io.opencensus.stats;

import io.opencensus.stats.AggregationData;

final class AutoValue_AggregationData_LastValueDataLong extends AggregationData.LastValueDataLong {
    private final long lastValue;

    AutoValue_AggregationData_LastValueDataLong(long lastValue2) {
        this.lastValue = lastValue2;
    }

    public long getLastValue() {
        return this.lastValue;
    }

    public String toString() {
        return "LastValueDataLong{lastValue=" + this.lastValue + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AggregationData.LastValueDataLong)) {
            return false;
        }
        if (this.lastValue == ((AggregationData.LastValueDataLong) o).getLastValue()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.lastValue;
        return (int) (((long) (1 * 1000003)) ^ (j ^ (j >>> 32)));
    }
}
