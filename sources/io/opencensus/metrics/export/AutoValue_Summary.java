package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Summary;
import javax.annotation.Nullable;

final class AutoValue_Summary extends Summary {
    private final Long count;
    private final Summary.Snapshot snapshot;
    private final Double sum;

    AutoValue_Summary(@Nullable Long count2, @Nullable Double sum2, Summary.Snapshot snapshot2) {
        this.count = count2;
        this.sum = sum2;
        if (snapshot2 != null) {
            this.snapshot = snapshot2;
            return;
        }
        throw new NullPointerException("Null snapshot");
    }

    @Nullable
    public Long getCount() {
        return this.count;
    }

    @Nullable
    public Double getSum() {
        return this.sum;
    }

    public Summary.Snapshot getSnapshot() {
        return this.snapshot;
    }

    public String toString() {
        return "Summary{count=" + this.count + ", sum=" + this.sum + ", snapshot=" + this.snapshot + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Summary)) {
            return false;
        }
        Summary that = (Summary) o;
        Long l = this.count;
        if (l != null ? l.equals(that.getCount()) : that.getCount() == null) {
            Double d = this.sum;
            if (d != null ? d.equals(that.getSum()) : that.getSum() == null) {
                if (this.snapshot.equals(that.getSnapshot())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int h = 1 * 1000003;
        Long l = this.count;
        int i = 0;
        int h2 = (h ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Double d = this.sum;
        if (d != null) {
            i = d.hashCode();
        }
        return ((h2 ^ i) * 1000003) ^ this.snapshot.hashCode();
    }
}
