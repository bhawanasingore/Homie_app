package io.opencensus.trace.config;

import io.opencensus.trace.Sampler;
import io.opencensus.trace.config.TraceParams;

final class AutoValue_TraceParams extends TraceParams {
    private final int maxNumberOfAnnotations;
    private final int maxNumberOfAttributes;
    private final int maxNumberOfLinks;
    private final int maxNumberOfMessageEvents;
    private final Sampler sampler;

    private AutoValue_TraceParams(Sampler sampler2, int maxNumberOfAttributes2, int maxNumberOfAnnotations2, int maxNumberOfMessageEvents2, int maxNumberOfLinks2) {
        this.sampler = sampler2;
        this.maxNumberOfAttributes = maxNumberOfAttributes2;
        this.maxNumberOfAnnotations = maxNumberOfAnnotations2;
        this.maxNumberOfMessageEvents = maxNumberOfMessageEvents2;
        this.maxNumberOfLinks = maxNumberOfLinks2;
    }

    public Sampler getSampler() {
        return this.sampler;
    }

    public int getMaxNumberOfAttributes() {
        return this.maxNumberOfAttributes;
    }

    public int getMaxNumberOfAnnotations() {
        return this.maxNumberOfAnnotations;
    }

    public int getMaxNumberOfMessageEvents() {
        return this.maxNumberOfMessageEvents;
    }

    public int getMaxNumberOfLinks() {
        return this.maxNumberOfLinks;
    }

    public String toString() {
        return "TraceParams{sampler=" + this.sampler + ", maxNumberOfAttributes=" + this.maxNumberOfAttributes + ", maxNumberOfAnnotations=" + this.maxNumberOfAnnotations + ", maxNumberOfMessageEvents=" + this.maxNumberOfMessageEvents + ", maxNumberOfLinks=" + this.maxNumberOfLinks + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TraceParams)) {
            return false;
        }
        TraceParams that = (TraceParams) o;
        if (this.sampler.equals(that.getSampler()) && this.maxNumberOfAttributes == that.getMaxNumberOfAttributes() && this.maxNumberOfAnnotations == that.getMaxNumberOfAnnotations() && this.maxNumberOfMessageEvents == that.getMaxNumberOfMessageEvents() && this.maxNumberOfLinks == that.getMaxNumberOfLinks()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((1 * 1000003) ^ this.sampler.hashCode()) * 1000003) ^ this.maxNumberOfAttributes) * 1000003) ^ this.maxNumberOfAnnotations) * 1000003) ^ this.maxNumberOfMessageEvents) * 1000003) ^ this.maxNumberOfLinks;
    }

    public TraceParams.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends TraceParams.Builder {
        private Integer maxNumberOfAnnotations;
        private Integer maxNumberOfAttributes;
        private Integer maxNumberOfLinks;
        private Integer maxNumberOfMessageEvents;
        private Sampler sampler;

        Builder() {
        }

        private Builder(TraceParams source) {
            this.sampler = source.getSampler();
            this.maxNumberOfAttributes = Integer.valueOf(source.getMaxNumberOfAttributes());
            this.maxNumberOfAnnotations = Integer.valueOf(source.getMaxNumberOfAnnotations());
            this.maxNumberOfMessageEvents = Integer.valueOf(source.getMaxNumberOfMessageEvents());
            this.maxNumberOfLinks = Integer.valueOf(source.getMaxNumberOfLinks());
        }

        public TraceParams.Builder setSampler(Sampler sampler2) {
            if (sampler2 != null) {
                this.sampler = sampler2;
                return this;
            }
            throw new NullPointerException("Null sampler");
        }

        public TraceParams.Builder setMaxNumberOfAttributes(int maxNumberOfAttributes2) {
            this.maxNumberOfAttributes = Integer.valueOf(maxNumberOfAttributes2);
            return this;
        }

        public TraceParams.Builder setMaxNumberOfAnnotations(int maxNumberOfAnnotations2) {
            this.maxNumberOfAnnotations = Integer.valueOf(maxNumberOfAnnotations2);
            return this;
        }

        public TraceParams.Builder setMaxNumberOfMessageEvents(int maxNumberOfMessageEvents2) {
            this.maxNumberOfMessageEvents = Integer.valueOf(maxNumberOfMessageEvents2);
            return this;
        }

        public TraceParams.Builder setMaxNumberOfLinks(int maxNumberOfLinks2) {
            this.maxNumberOfLinks = Integer.valueOf(maxNumberOfLinks2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public TraceParams autoBuild() {
            String missing = "";
            if (this.sampler == null) {
                missing = missing + " sampler";
            }
            if (this.maxNumberOfAttributes == null) {
                missing = missing + " maxNumberOfAttributes";
            }
            if (this.maxNumberOfAnnotations == null) {
                missing = missing + " maxNumberOfAnnotations";
            }
            if (this.maxNumberOfMessageEvents == null) {
                missing = missing + " maxNumberOfMessageEvents";
            }
            if (this.maxNumberOfLinks == null) {
                missing = missing + " maxNumberOfLinks";
            }
            if (missing.isEmpty()) {
                return new AutoValue_TraceParams(this.sampler, this.maxNumberOfAttributes.intValue(), this.maxNumberOfAnnotations.intValue(), this.maxNumberOfMessageEvents.intValue(), this.maxNumberOfLinks.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
