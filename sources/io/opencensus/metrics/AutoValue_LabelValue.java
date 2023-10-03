package io.opencensus.metrics;

import javax.annotation.Nullable;

final class AutoValue_LabelValue extends LabelValue {
    private final String value;

    AutoValue_LabelValue(@Nullable String value2) {
        this.value = value2;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "LabelValue{value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LabelValue)) {
            return false;
        }
        LabelValue that = (LabelValue) o;
        String str = this.value;
        if (str != null) {
            return str.equals(that.getValue());
        }
        if (that.getValue() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int h = 1 * 1000003;
        String str = this.value;
        return h ^ (str == null ? 0 : str.hashCode());
    }
}
