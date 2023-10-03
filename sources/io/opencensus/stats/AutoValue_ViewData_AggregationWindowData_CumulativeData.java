package io.opencensus.stats;

import io.opencensus.common.Timestamp;
import io.opencensus.stats.ViewData;

@Deprecated
final class AutoValue_ViewData_AggregationWindowData_CumulativeData extends ViewData.AggregationWindowData.CumulativeData {
    private final Timestamp end;
    private final Timestamp start;

    AutoValue_ViewData_AggregationWindowData_CumulativeData(Timestamp start2, Timestamp end2) {
        if (start2 != null) {
            this.start = start2;
            if (end2 != null) {
                this.end = end2;
                return;
            }
            throw new NullPointerException("Null end");
        }
        throw new NullPointerException("Null start");
    }

    public Timestamp getStart() {
        return this.start;
    }

    public Timestamp getEnd() {
        return this.end;
    }

    public String toString() {
        return "CumulativeData{start=" + this.start + ", end=" + this.end + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ViewData.AggregationWindowData.CumulativeData)) {
            return false;
        }
        ViewData.AggregationWindowData.CumulativeData that = (ViewData.AggregationWindowData.CumulativeData) o;
        if (!this.start.equals(that.getStart()) || !this.end.equals(that.getEnd())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.start.hashCode()) * 1000003) ^ this.end.hashCode();
    }
}
