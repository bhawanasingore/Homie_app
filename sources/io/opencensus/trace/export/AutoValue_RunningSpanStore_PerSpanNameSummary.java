package io.opencensus.trace.export;

import io.opencensus.trace.export.RunningSpanStore;

final class AutoValue_RunningSpanStore_PerSpanNameSummary extends RunningSpanStore.PerSpanNameSummary {
    private final int numRunningSpans;

    AutoValue_RunningSpanStore_PerSpanNameSummary(int numRunningSpans2) {
        this.numRunningSpans = numRunningSpans2;
    }

    public int getNumRunningSpans() {
        return this.numRunningSpans;
    }

    public String toString() {
        return "PerSpanNameSummary{numRunningSpans=" + this.numRunningSpans + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RunningSpanStore.PerSpanNameSummary)) {
            return false;
        }
        if (this.numRunningSpans == ((RunningSpanStore.PerSpanNameSummary) o).getNumRunningSpans()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.numRunningSpans;
    }
}
