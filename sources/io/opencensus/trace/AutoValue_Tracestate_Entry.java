package io.opencensus.trace;

import io.opencensus.trace.Tracestate;

final class AutoValue_Tracestate_Entry extends Tracestate.Entry {
    private final String key;
    private final String value;

    AutoValue_Tracestate_Entry(String key2, String value2) {
        if (key2 != null) {
            this.key = key2;
            if (value2 != null) {
                this.value = value2;
                return;
            }
            throw new NullPointerException("Null value");
        }
        throw new NullPointerException("Null key");
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "Entry{key=" + this.key + ", value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Tracestate.Entry)) {
            return false;
        }
        Tracestate.Entry that = (Tracestate.Entry) o;
        if (!this.key.equals(that.getKey()) || !this.value.equals(that.getValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.key.hashCode()) * 1000003) ^ this.value.hashCode();
    }
}
