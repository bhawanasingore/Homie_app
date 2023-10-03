package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Summary;
import java.util.List;
import javax.annotation.Nullable;

final class AutoValue_Summary_Snapshot extends Summary.Snapshot {
    private final Long count;
    private final Double sum;
    private final List<Summary.Snapshot.ValueAtPercentile> valueAtPercentiles;

    AutoValue_Summary_Snapshot(@Nullable Long count2, @Nullable Double sum2, List<Summary.Snapshot.ValueAtPercentile> valueAtPercentiles2) {
        this.count = count2;
        this.sum = sum2;
        if (valueAtPercentiles2 != null) {
            this.valueAtPercentiles = valueAtPercentiles2;
            return;
        }
        throw new NullPointerException("Null valueAtPercentiles");
    }

    @Nullable
    public Long getCount() {
        return this.count;
    }

    @Nullable
    public Double getSum() {
        return this.sum;
    }

    public List<Summary.Snapshot.ValueAtPercentile> getValueAtPercentiles() {
        return this.valueAtPercentiles;
    }

    public String toString() {
        return "Snapshot{count=" + this.count + ", sum=" + this.sum + ", valueAtPercentiles=" + this.valueAtPercentiles + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Summary.Snapshot)) {
            return false;
        }
        Summary.Snapshot that = (Summary.Snapshot) o;
        Long l = this.count;
        if (l != null ? l.equals(that.getCount()) : that.getCount() == null) {
            Double d = this.sum;
            if (d != null ? d.equals(that.getSum()) : that.getSum() == null) {
                if (this.valueAtPercentiles.equals(that.getValueAtPercentiles())) {
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
        return ((h2 ^ i) * 1000003) ^ this.valueAtPercentiles.hashCode();
    }
}
