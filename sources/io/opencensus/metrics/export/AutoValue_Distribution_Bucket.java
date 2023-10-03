package io.opencensus.metrics.export;

import io.opencensus.metrics.data.Exemplar;
import io.opencensus.metrics.export.Distribution;
import javax.annotation.Nullable;

final class AutoValue_Distribution_Bucket extends Distribution.Bucket {
    private final long count;
    private final Exemplar exemplar;

    AutoValue_Distribution_Bucket(long count2, @Nullable Exemplar exemplar2) {
        this.count = count2;
        this.exemplar = exemplar2;
    }

    public long getCount() {
        return this.count;
    }

    @Nullable
    public Exemplar getExemplar() {
        return this.exemplar;
    }

    public String toString() {
        return "Bucket{count=" + this.count + ", exemplar=" + this.exemplar + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Distribution.Bucket)) {
            return false;
        }
        Distribution.Bucket that = (Distribution.Bucket) o;
        if (this.count == that.getCount()) {
            Exemplar exemplar2 = this.exemplar;
            if (exemplar2 == null) {
                if (that.getExemplar() == null) {
                    return true;
                }
            } else if (exemplar2.equals(that.getExemplar())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.count;
        int h = ((int) (((long) (1 * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003;
        Exemplar exemplar2 = this.exemplar;
        return h ^ (exemplar2 == null ? 0 : exemplar2.hashCode());
    }
}
