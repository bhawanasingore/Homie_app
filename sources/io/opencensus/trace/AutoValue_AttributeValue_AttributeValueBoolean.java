package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;

final class AutoValue_AttributeValue_AttributeValueBoolean extends AttributeValue.AttributeValueBoolean {
    private final Boolean booleanValue;

    AutoValue_AttributeValue_AttributeValueBoolean(Boolean booleanValue2) {
        if (booleanValue2 != null) {
            this.booleanValue = booleanValue2;
            return;
        }
        throw new NullPointerException("Null booleanValue");
    }

    /* access modifiers changed from: package-private */
    public Boolean getBooleanValue() {
        return this.booleanValue;
    }

    public String toString() {
        return "AttributeValueBoolean{booleanValue=" + this.booleanValue + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof AttributeValue.AttributeValueBoolean) {
            return this.booleanValue.equals(((AttributeValue.AttributeValueBoolean) o).getBooleanValue());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.booleanValue.hashCode();
    }
}
