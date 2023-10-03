package io.opencensus.stats;

import io.opencensus.stats.View;

@Deprecated
final class AutoValue_View_AggregationWindow_Cumulative extends View.AggregationWindow.Cumulative {
    AutoValue_View_AggregationWindow_Cumulative() {
    }

    public String toString() {
        return "Cumulative{}";
    }

    public boolean equals(Object o) {
        if (o != this && !(o instanceof View.AggregationWindow.Cumulative)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 1;
    }
}
