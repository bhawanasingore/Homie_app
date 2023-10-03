package io.opencensus.trace;

import io.opencensus.trace.Link;
import java.util.Map;

final class AutoValue_Link extends Link {
    private final Map<String, AttributeValue> attributes;
    private final SpanId spanId;
    private final TraceId traceId;
    private final Link.Type type;

    AutoValue_Link(TraceId traceId2, SpanId spanId2, Link.Type type2, Map<String, AttributeValue> attributes2) {
        if (traceId2 != null) {
            this.traceId = traceId2;
            if (spanId2 != null) {
                this.spanId = spanId2;
                if (type2 != null) {
                    this.type = type2;
                    if (attributes2 != null) {
                        this.attributes = attributes2;
                        return;
                    }
                    throw new NullPointerException("Null attributes");
                }
                throw new NullPointerException("Null type");
            }
            throw new NullPointerException("Null spanId");
        }
        throw new NullPointerException("Null traceId");
    }

    public TraceId getTraceId() {
        return this.traceId;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public Link.Type getType() {
        return this.type;
    }

    public Map<String, AttributeValue> getAttributes() {
        return this.attributes;
    }

    public String toString() {
        return "Link{traceId=" + this.traceId + ", spanId=" + this.spanId + ", type=" + this.type + ", attributes=" + this.attributes + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Link)) {
            return false;
        }
        Link that = (Link) o;
        if (!this.traceId.equals(that.getTraceId()) || !this.spanId.equals(that.getSpanId()) || !this.type.equals(that.getType()) || !this.attributes.equals(that.getAttributes())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((1 * 1000003) ^ this.traceId.hashCode()) * 1000003) ^ this.spanId.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.attributes.hashCode();
    }
}
