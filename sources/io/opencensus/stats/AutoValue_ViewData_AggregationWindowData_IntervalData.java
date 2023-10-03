package io.opencensus.stats;

import io.opencensus.common.Timestamp;
import io.opencensus.stats.ViewData;

@Deprecated
final class AutoValue_ViewData_AggregationWindowData_IntervalData extends ViewData.AggregationWindowData.IntervalData {
    private final Timestamp end;

    AutoValue_ViewData_AggregationWindowData_IntervalData(Timestamp end2) {
        if (end2 != null) {
            this.end = end2;
            return;
        }
        throw new NullPointerException("Null end");
    }

    public Timestamp getEnd() {
        return this.end;
    }

    public String toString() {
        return "IntervalData{end=" + this.end + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ViewData.AggregationWindowData.IntervalData) {
            return this.end.equals(((ViewData.AggregationWindowData.IntervalData) o).getEnd());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.end.hashCode();
    }
}
