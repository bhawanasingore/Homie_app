package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;

final class AutoValue_AttributeValue_AttributeValueLong extends AttributeValue.AttributeValueLong {
    private final Long longValue;

    AutoValue_AttributeValue_AttributeValueLong(Long longValue2) {
        if (longValue2 != null) {
            this.longValue = longValue2;
            return;
        }
        throw new NullPointerException("Null longValue");
    }

    /* access modifiers changed from: package-private */
    public Long getLongValue() {
        return this.longValue;
    }

    public String toString() {
        return "AttributeValueLong{longValue=" + this.longValue + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof AttributeValue.AttributeValueLong) {
            return this.longValue.equals(((AttributeValue.AttributeValueLong) o).getLongValue());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.longValue.hashCode();
    }
}
