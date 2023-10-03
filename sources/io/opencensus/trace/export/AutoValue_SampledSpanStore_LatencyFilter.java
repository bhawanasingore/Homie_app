package io.opencensus.trace.export;

import io.opencensus.trace.export.SampledSpanStore;

final class AutoValue_SampledSpanStore_LatencyFilter extends SampledSpanStore.LatencyFilter {
    private final long latencyLowerNs;
    private final long latencyUpperNs;
    private final int maxSpansToReturn;
    private final String spanName;

    AutoValue_SampledSpanStore_LatencyFilter(String spanName2, long latencyLowerNs2, long latencyUpperNs2, int maxSpansToReturn2) {
        if (spanName2 != null) {
            this.spanName = spanName2;
            this.latencyLowerNs = latencyLowerNs2;
            this.latencyUpperNs = latencyUpperNs2;
            this.maxSpansToReturn = maxSpansToReturn2;
            return;
        }
        throw new NullPointerException("Null spanName");
    }

    public String getSpanName() {
        return this.spanName;
    }

    public long getLatencyLowerNs() {
        return this.latencyLowerNs;
    }

    public long getLatencyUpperNs() {
        return this.latencyUpperNs;
    }

    public int getMaxSpansToReturn() {
        return this.maxSpansToReturn;
    }

    public String toString() {
        return "LatencyFilter{spanName=" + this.spanName + ", latencyLowerNs=" + this.latencyLowerNs + ", latencyUpperNs=" + this.latencyUpperNs + ", maxSpansToReturn=" + this.maxSpansToReturn + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SampledSpanStore.LatencyFilter)) {
            return false;
        }
        SampledSpanStore.LatencyFilter that = (SampledSpanStore.LatencyFilter) o;
        if (this.spanName.equals(that.getSpanName()) && this.latencyLowerNs == that.getLatencyLowerNs() && this.latencyUpperNs == that.getLatencyUpperNs() && this.maxSpansToReturn == that.getMaxSpansToReturn()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.latencyLowerNs;
        long j2 = this.latencyUpperNs;
        return (((int) (((long) (((int) (((long) (((1 * 1000003) ^ this.spanName.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.maxSpansToReturn;
    }
}
