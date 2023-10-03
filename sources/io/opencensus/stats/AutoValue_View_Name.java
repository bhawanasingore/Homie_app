package io.opencensus.stats;

import io.opencensus.stats.View;

final class AutoValue_View_Name extends View.Name {
    private final String asString;

    AutoValue_View_Name(String asString2) {
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
        return "Name{asString=" + this.asString + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof View.Name) {
            return this.asString.equals(((View.Name) o).asString());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.asString.hashCode();
    }
}
