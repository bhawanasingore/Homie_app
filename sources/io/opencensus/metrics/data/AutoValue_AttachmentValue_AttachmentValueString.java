package io.opencensus.metrics.data;

import io.opencensus.metrics.data.AttachmentValue;

final class AutoValue_AttachmentValue_AttachmentValueString extends AttachmentValue.AttachmentValueString {
    private final String value;

    AutoValue_AttachmentValue_AttachmentValueString(String value2) {
        if (value2 != null) {
            this.value = value2;
            return;
        }
        throw new NullPointerException("Null value");
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "AttachmentValueString{value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof AttachmentValue.AttachmentValueString) {
            return this.value.equals(((AttachmentValue.AttachmentValueString) o).getValue());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.value.hashCode();
    }
}
