package io.opencensus.common;

public abstract class ServerStats {
    public abstract long getLbLatencyNs();

    public abstract long getServiceLatencyNs();

    public abstract byte getTraceOption();

    ServerStats() {
    }

    public static ServerStats create(long lbLatencyNs, long serviceLatencyNs, byte traceOption) {
        if (lbLatencyNs < 0) {
            throw new IllegalArgumentException("'getLbLatencyNs' is less than zero: " + lbLatencyNs);
        } else if (serviceLatencyNs >= 0) {
            return new AutoValue_ServerStats(lbLatencyNs, serviceLatencyNs, traceOption);
        } else {
            throw new IllegalArgumentException("'getServiceLatencyNs' is less than zero: " + serviceLatencyNs);
        }
    }
}
