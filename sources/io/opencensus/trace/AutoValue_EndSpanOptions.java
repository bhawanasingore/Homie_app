package io.opencensus.trace;

import io.opencensus.trace.EndSpanOptions;
import javax.annotation.Nullable;

final class AutoValue_EndSpanOptions extends EndSpanOptions {
    private final boolean sampleToLocalSpanStore;
    private final Status status;

    private AutoValue_EndSpanOptions(boolean sampleToLocalSpanStore2, @Nullable Status status2) {
        this.sampleToLocalSpanStore = sampleToLocalSpanStore2;
        this.status = status2;
    }

    public boolean getSampleToLocalSpanStore() {
        return this.sampleToLocalSpanStore;
    }

    @Nullable
    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        return "EndSpanOptions{sampleToLocalSpanStore=" + this.sampleToLocalSpanStore + ", status=" + this.status + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EndSpanOptions)) {
            return false;
        }
        EndSpanOptions that = (EndSpanOptions) o;
        if (this.sampleToLocalSpanStore == that.getSampleToLocalSpanStore()) {
            Status status2 = this.status;
            if (status2 == null) {
                if (that.getStatus() == null) {
                    return true;
                }
            } else if (status2.equals(that.getStatus())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int h = ((1 * 1000003) ^ (this.sampleToLocalSpanStore ? 1231 : 1237)) * 1000003;
        Status status2 = this.status;
        return h ^ (status2 == null ? 0 : status2.hashCode());
    }

    static final class Builder extends EndSpanOptions.Builder {
        private Boolean sampleToLocalSpanStore;
        private Status status;

        Builder() {
        }

        public EndSpanOptions.Builder setSampleToLocalSpanStore(boolean sampleToLocalSpanStore2) {
            this.sampleToLocalSpanStore = Boolean.valueOf(sampleToLocalSpanStore2);
            return this;
        }

        public EndSpanOptions.Builder setStatus(@Nullable Status status2) {
            this.status = status2;
            return this;
        }

        public EndSpanOptions build() {
            String missing = "";
            if (this.sampleToLocalSpanStore == null) {
                missing = missing + " sampleToLocalSpanStore";
            }
            if (missing.isEmpty()) {
                return new AutoValue_EndSpanOptions(this.sampleToLocalSpanStore.booleanValue(), this.status);
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
