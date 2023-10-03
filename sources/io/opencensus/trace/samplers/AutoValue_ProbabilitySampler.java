package io.opencensus.trace.samplers;

final class AutoValue_ProbabilitySampler extends ProbabilitySampler {
    private final long idUpperBound;
    private final double probability;

    AutoValue_ProbabilitySampler(double probability2, long idUpperBound2) {
        this.probability = probability2;
        this.idUpperBound = idUpperBound2;
    }

    /* access modifiers changed from: package-private */
    public double getProbability() {
        return this.probability;
    }

    /* access modifiers changed from: package-private */
    public long getIdUpperBound() {
        return this.idUpperBound;
    }

    public String toString() {
        return "ProbabilitySampler{probability=" + this.probability + ", idUpperBound=" + this.idUpperBound + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ProbabilitySampler)) {
            return false;
        }
        ProbabilitySampler that = (ProbabilitySampler) o;
        if (Double.doubleToLongBits(this.probability) == Double.doubleToLongBits(that.getProbability()) && this.idUpperBound == that.getIdUpperBound()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.idUpperBound;
        return (int) (((long) (((int) (((long) (1 * 1000003)) ^ ((Double.doubleToLongBits(this.probability) >>> 32) ^ Double.doubleToLongBits(this.probability)))) * 1000003)) ^ (j ^ (j >>> 32)));
    }
}
