package io.opencensus.metrics;

final class AutoValue_LabelKey extends LabelKey {
    private final String description;
    private final String key;

    AutoValue_LabelKey(String key2, String description2) {
        if (key2 != null) {
            this.key = key2;
            if (description2 != null) {
                this.description = description2;
                return;
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null key");
    }

    public String getKey() {
        return this.key;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "LabelKey{key=" + this.key + ", description=" + this.description + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LabelKey)) {
            return false;
        }
        LabelKey that = (LabelKey) o;
        if (!this.key.equals(that.getKey()) || !this.description.equals(that.getDescription())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.key.hashCode()) * 1000003) ^ this.description.hashCode();
    }
}
