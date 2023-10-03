package io.opencensus.common;

final class AutoValue_Timestamp extends Timestamp {
    private final int nanos;
    private final long seconds;

    AutoValue_Timestamp(long seconds2, int nanos2) {
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
        return "Timestamp{seconds=" + this.seconds + ", nanos=" + this.nanos + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Timestamp)) {
            return false;
        }
        Timestamp that = (Timestamp) o;
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
