package io.opencensus.trace;

import java.util.Map;

final class AutoValue_Annotation extends Annotation {
    private final Map<String, AttributeValue> attributes;
    private final String description;

    AutoValue_Annotation(String description2, Map<String, AttributeValue> attributes2) {
        if (description2 != null) {
            this.description = description2;
            if (attributes2 != null) {
                this.attributes = attributes2;
                return;
            }
            throw new NullPointerException("Null attributes");
        }
        throw new NullPointerException("Null description");
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, AttributeValue> getAttributes() {
        return this.attributes;
    }

    public String toString() {
        return "Annotation{description=" + this.description + ", attributes=" + this.attributes + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Annotation)) {
            return false;
        }
        Annotation that = (Annotation) o;
        if (!this.description.equals(that.getDescription()) || !this.attributes.equals(that.getAttributes())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.attributes.hashCode();
    }
}
