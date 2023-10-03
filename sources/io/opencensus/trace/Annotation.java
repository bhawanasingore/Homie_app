package io.opencensus.trace;

import io.opencensus.internal.Utils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Annotation {
    private static final Map<String, AttributeValue> EMPTY_ATTRIBUTES = Collections.unmodifiableMap(Collections.emptyMap());

    public abstract Map<String, AttributeValue> getAttributes();

    public abstract String getDescription();

    public static Annotation fromDescription(String description) {
        return new AutoValue_Annotation(description, EMPTY_ATTRIBUTES);
    }

    public static Annotation fromDescriptionAndAttributes(String description, Map<String, AttributeValue> attributes) {
        return new AutoValue_Annotation(description, Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(attributes, "attributes"))));
    }

    Annotation() {
    }
}
