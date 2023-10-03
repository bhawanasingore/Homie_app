package io.opencensus.trace.export;

import io.opencensus.trace.export.SampledSpanStore;
import java.util.Map;

final class AutoValue_SampledSpanStore_Summary extends SampledSpanStore.Summary {
    private final Map<String, SampledSpanStore.PerSpanNameSummary> perSpanNameSummary;

    AutoValue_SampledSpanStore_Summary(Map<String, SampledSpanStore.PerSpanNameSummary> perSpanNameSummary2) {
        if (perSpanNameSummary2 != null) {
            this.perSpanNameSummary = perSpanNameSummary2;
            return;
        }
        throw new NullPointerException("Null perSpanNameSummary");
    }

    public Map<String, SampledSpanStore.PerSpanNameSummary> getPerSpanNameSummary() {
        return this.perSpanNameSummary;
    }

    public String toString() {
        return "Summary{perSpanNameSummary=" + this.perSpanNameSummary + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof SampledSpanStore.Summary) {
            return this.perSpanNameSummary.equals(((SampledSpanStore.Summary) o).getPerSpanNameSummary());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.perSpanNameSummary.hashCode();
    }
}
