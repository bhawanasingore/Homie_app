package io.opencensus.stats;

import io.opencensus.stats.AggregationData;

final class AutoValue_AggregationData_CountData extends AggregationData.CountData {
    private final long count;

    AutoValue_AggregationData_CountData(long count2) {
        this.count = count2;
    }

    public long getCount() {
        return this.count;
    }

    public String toString() {
        return "CountData{count=" + this.count + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AggregationData.CountData)) {
            return false;
        }
        if (this.count == ((AggregationData.CountData) o).getCount()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.count;
        return (int) (((long) (1 * 1000003)) ^ (j ^ (j >>> 32)));
    }
}
