package io.opencensus.trace.export;

import io.opencensus.trace.Status;
import io.opencensus.trace.export.SampledSpanStore;
import javax.annotation.Nullable;

final class AutoValue_SampledSpanStore_ErrorFilter extends SampledSpanStore.ErrorFilter {
    private final Status.CanonicalCode canonicalCode;
    private final int maxSpansToReturn;
    private final String spanName;

    AutoValue_SampledSpanStore_ErrorFilter(String spanName2, @Nullable Status.CanonicalCode canonicalCode2, int maxSpansToReturn2) {
        if (spanName2 != null) {
            this.spanName = spanName2;
            this.canonicalCode = canonicalCode2;
            this.maxSpansToReturn = maxSpansToReturn2;
            return;
        }
        throw new NullPointerException("Null spanName");
    }

    public String getSpanName() {
        return this.spanName;
    }

    @Nullable
    public Status.CanonicalCode getCanonicalCode() {
        return this.canonicalCode;
    }

    public int getMaxSpansToReturn() {
        return this.maxSpansToReturn;
    }

    public String toString() {
        return "ErrorFilter{spanName=" + this.spanName + ", canonicalCode=" + this.canonicalCode + ", maxSpansToReturn=" + this.maxSpansToReturn + "}";
    }

    public boolean equals(Object o) {
        Status.CanonicalCode canonicalCode2;
        if (o == this) {
            return true;
        }
        if (!(o instanceof SampledSpanStore.ErrorFilter)) {
            return false;
        }
        SampledSpanStore.ErrorFilter that = (SampledSpanStore.ErrorFilter) o;
        if (!this.spanName.equals(that.getSpanName()) || ((canonicalCode2 = this.canonicalCode) != null ? !canonicalCode2.equals(that.getCanonicalCode()) : that.getCanonicalCode() != null) || this.maxSpansToReturn != that.getMaxSpansToReturn()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int h = ((1 * 1000003) ^ this.spanName.hashCode()) * 1000003;
        Status.CanonicalCode canonicalCode2 = this.canonicalCode;
        return ((h ^ (canonicalCode2 == null ? 0 : canonicalCode2.hashCode())) * 1000003) ^ this.maxSpansToReturn;
    }
}
