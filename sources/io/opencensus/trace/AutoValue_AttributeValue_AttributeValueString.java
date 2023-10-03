package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;

final class AutoValue_AttributeValue_AttributeValueString extends AttributeValue.AttributeValueString {
    private final String stringValue;

    AutoValue_AttributeValue_AttributeValueString(String stringValue2) {
        if (stringValue2 != null) {
            this.stringValue = stringValue2;
            return;
        }
        throw new NullPointerException("Null stringValue");
    }

    /* access modifiers changed from: package-private */
    public String getStringValue() {
        return this.stringValue;
    }

    public String toString() {
        return "AttributeValueString{stringValue=" + this.stringValue + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof AttributeValue.AttributeValueString) {
            return this.stringValue.equals(((AttributeValue.AttributeValueString) o).getStringValue());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.stringValue.hashCode();
    }
}
