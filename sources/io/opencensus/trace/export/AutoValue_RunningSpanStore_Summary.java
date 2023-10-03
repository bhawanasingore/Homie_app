package io.opencensus.trace.export;

import io.opencensus.trace.export.RunningSpanStore;
import java.util.Map;

final class AutoValue_RunningSpanStore_Summary extends RunningSpanStore.Summary {
    private final Map<String, RunningSpanStore.PerSpanNameSummary> perSpanNameSummary;

    AutoValue_RunningSpanStore_Summary(Map<String, RunningSpanStore.PerSpanNameSummary> perSpanNameSummary2) {
        if (perSpanNameSummary2 != null) {
            this.perSpanNameSummary = perSpanNameSummary2;
            return;
        }
        throw new NullPointerException("Null perSpanNameSummary");
    }

    public Map<String, RunningSpanStore.PerSpanNameSummary> getPerSpanNameSummary() {
        return this.perSpanNameSummary;
    }

    public String toString() {
        return "Summary{perSpanNameSummary=" + this.perSpanNameSummary + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof RunningSpanStore.Summary) {
            return this.perSpanNameSummary.equals(((RunningSpanStore.Summary) o).getPerSpanNameSummary());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.perSpanNameSummary.hashCode();
    }
}
