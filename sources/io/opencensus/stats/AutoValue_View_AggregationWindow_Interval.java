package io.opencensus.stats;

import io.opencensus.common.Duration;
import io.opencensus.stats.View;

@Deprecated
final class AutoValue_View_AggregationWindow_Interval extends View.AggregationWindow.Interval {
    private final Duration duration;

    AutoValue_View_AggregationWindow_Interval(Duration duration2) {
        if (duration2 != null) {
            this.duration = duration2;
            return;
        }
        throw new NullPointerException("Null duration");
    }

    public Duration getDuration() {
        return this.duration;
    }

    public String toString() {
        return "Interval{duration=" + this.duration + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof View.AggregationWindow.Interval) {
            return this.duration.equals(((View.AggregationWindow.Interval) o).getDuration());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.duration.hashCode();
    }
}
