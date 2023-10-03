package io.opencensus.trace.export;

import io.opencensus.trace.Status;
import io.opencensus.trace.export.SampledSpanStore;
import java.util.Map;

final class AutoValue_SampledSpanStore_PerSpanNameSummary extends SampledSpanStore.PerSpanNameSummary {
    private final Map<Status.CanonicalCode, Integer> numbersOfErrorSampledSpans;
    private final Map<SampledSpanStore.LatencyBucketBoundaries, Integer> numbersOfLatencySampledSpans;

    AutoValue_SampledSpanStore_PerSpanNameSummary(Map<SampledSpanStore.LatencyBucketBoundaries, Integer> numbersOfLatencySampledSpans2, Map<Status.CanonicalCode, Integer> numbersOfErrorSampledSpans2) {
        if (numbersOfLatencySampledSpans2 != null) {
            this.numbersOfLatencySampledSpans = numbersOfLatencySampledSpans2;
            if (numbersOfErrorSampledSpans2 != null) {
                this.numbersOfErrorSampledSpans = numbersOfErrorSampledSpans2;
                return;
            }
            throw new NullPointerException("Null numbersOfErrorSampledSpans");
        }
        throw new NullPointerException("Null numbersOfLatencySampledSpans");
    }

    public Map<SampledSpanStore.LatencyBucketBoundaries, Integer> getNumbersOfLatencySampledSpans() {
        return this.numbersOfLatencySampledSpans;
    }

    public Map<Status.CanonicalCode, Integer> getNumbersOfErrorSampledSpans() {
        return this.numbersOfErrorSampledSpans;
    }

    public String toString() {
        return "PerSpanNameSummary{numbersOfLatencySampledSpans=" + this.numbersOfLatencySampledSpans + ", numbersOfErrorSampledSpans=" + this.numbersOfErrorSampledSpans + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SampledSpanStore.PerSpanNameSummary)) {
            return false;
        }
        SampledSpanStore.PerSpanNameSummary that = (SampledSpanStore.PerSpanNameSummary) o;
        if (!this.numbersOfLatencySampledSpans.equals(that.getNumbersOfLatencySampledSpans()) || !this.numbersOfErrorSampledSpans.equals(that.getNumbersOfErrorSampledSpans())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.numbersOfLatencySampledSpans.hashCode()) * 1000003) ^ this.numbersOfErrorSampledSpans.hashCode();
    }
}
