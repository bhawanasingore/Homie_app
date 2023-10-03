package io.opencensus.stats;

import io.opencensus.stats.AggregationData;

final class AutoValue_AggregationData_SumDataLong extends AggregationData.SumDataLong {
    private final long sum;

    AutoValue_AggregationData_SumDataLong(long sum2) {
        this.sum = sum2;
    }

    public long getSum() {
        return this.sum;
    }

    public String toString() {
        return "SumDataLong{sum=" + this.sum + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AggregationData.SumDataLong)) {
            return false;
        }
        if (this.sum == ((AggregationData.SumDataLong) o).getSum()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.sum;
        return (int) (((long) (1 * 1000003)) ^ (j ^ (j >>> 32)));
    }
}
