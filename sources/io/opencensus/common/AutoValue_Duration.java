package io.opencensus.common;

final class AutoValue_Duration extends Duration {
    private final int nanos;
    private final long seconds;

    AutoValue_Duration(long seconds2, int nanos2) {
        this.seconds = seconds2;
        this.nanos = nanos2;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public int getNanos() {
        return this.nanos;
    }

    public String toString() {
        return "Duration{seconds=" + this.seconds + ", nanos=" + this.nanos + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Duration)) {
            return false;
        }
        Duration that = (Duration) o;
        if (this.seconds == that.getSeconds() && this.nanos == that.getNanos()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.seconds;
        return (((int) (((long) (1 * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003) ^ this.nanos;
    }
}
