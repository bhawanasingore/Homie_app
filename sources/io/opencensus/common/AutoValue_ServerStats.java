package io.opencensus.common;

final class AutoValue_ServerStats extends ServerStats {
    private final long lbLatencyNs;
    private final long serviceLatencyNs;
    private final byte traceOption;

    AutoValue_ServerStats(long lbLatencyNs2, long serviceLatencyNs2, byte traceOption2) {
        this.lbLatencyNs = lbLatencyNs2;
        this.serviceLatencyNs = serviceLatencyNs2;
        this.traceOption = traceOption2;
    }

    public long getLbLatencyNs() {
        return this.lbLatencyNs;
    }

    public long getServiceLatencyNs() {
        return this.serviceLatencyNs;
    }

    public byte getTraceOption() {
        return this.traceOption;
    }

    public String toString() {
        return "ServerStats{lbLatencyNs=" + this.lbLatencyNs + ", serviceLatencyNs=" + this.serviceLatencyNs + ", traceOption=" + this.traceOption + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ServerStats)) {
            return false;
        }
        ServerStats that = (ServerStats) o;
        if (this.lbLatencyNs == that.getLbLatencyNs() && this.serviceLatencyNs == that.getServiceLatencyNs() && this.traceOption == that.getTraceOption()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.lbLatencyNs;
        long j2 = this.serviceLatencyNs;
        return (((int) (((long) (((int) (((long) (1 * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.traceOption;
    }
}
