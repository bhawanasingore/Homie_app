package io.opencensus.trace;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Link {
    private static final Map<String, AttributeValue> EMPTY_ATTRIBUTES = Collections.emptyMap();

    public enum Type {
        CHILD_LINKED_SPAN,
        PARENT_LINKED_SPAN
    }

    public abstract Map<String, AttributeValue> getAttributes();

    public abstract SpanId getSpanId();

    public abstract TraceId getTraceId();

    public abstract Type getType();

    public static Link fromSpanContext(SpanContext context, Type type) {
        return new AutoValue_Link(context.getTraceId(), context.getSpanId(), type, EMPTY_ATTRIBUTES);
    }

    public static Link fromSpanContext(SpanContext context, Type type, Map<String, AttributeValue> attributes) {
        return new AutoValue_Link(context.getTraceId(), context.getSpanId(), type, Collections.unmodifiableMap(new HashMap(attributes)));
    }

    Link() {
    }
}
