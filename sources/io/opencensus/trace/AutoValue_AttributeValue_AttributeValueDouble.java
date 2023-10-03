package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;

final class AutoValue_AttributeValue_AttributeValueDouble extends AttributeValue.AttributeValueDouble {
    private final Double doubleValue;

    AutoValue_AttributeValue_AttributeValueDouble(Double doubleValue2) {
        if (doubleValue2 != null) {
            this.doubleValue = doubleValue2;
            return;
        }
        throw new NullPointerException("Null doubleValue");
    }

    /* access modifiers changed from: package-private */
    public Double getDoubleValue() {
        return this.doubleValue;
    }

    public String toString() {
        return "AttributeValueDouble{doubleValue=" + this.doubleValue + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof AttributeValue.AttributeValueDouble) {
            return this.doubleValue.equals(((AttributeValue.AttributeValueDouble) o).getDoubleValue());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.doubleValue.hashCode();
    }
}
