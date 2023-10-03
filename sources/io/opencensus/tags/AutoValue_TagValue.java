package io.opencensus.tags;

final class AutoValue_TagValue extends TagValue {
    private final String asString;

    AutoValue_TagValue(String asString2) {
        if (asString2 != null) {
            this.asString = asString2;
            return;
        }
        throw new NullPointerException("Null asString");
    }

    public String asString() {
        return this.asString;
    }

    public String toString() {
        return "TagValue{asString=" + this.asString + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof TagValue) {
            return this.asString.equals(((TagValue) o).asString());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.asString.hashCode();
    }
}
