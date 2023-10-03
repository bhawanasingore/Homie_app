package io.opencensus.tags;

final class AutoValue_TagKey extends TagKey {
    private final String name;

    AutoValue_TagKey(String name2) {
        if (name2 != null) {
            this.name = name2;
            return;
        }
        throw new NullPointerException("Null name");
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "TagKey{name=" + this.name + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof TagKey) {
            return this.name.equals(((TagKey) o).getName());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.name.hashCode();
    }
}
