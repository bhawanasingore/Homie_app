package io.opencensus.resource;

import java.util.Map;
import javax.annotation.Nullable;

final class AutoValue_Resource extends Resource {
    private final Map<String, String> labels;
    private final String type;

    AutoValue_Resource(@Nullable String type2, Map<String, String> labels2) {
        this.type = type2;
        if (labels2 != null) {
            this.labels = labels2;
            return;
        }
        throw new NullPointerException("Null labels");
    }

    @Nullable
    public String getType() {
        return this.type;
    }

    public Map<String, String> getLabels() {
        return this.labels;
    }

    public String toString() {
        return "Resource{type=" + this.type + ", labels=" + this.labels + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Resource)) {
            return false;
        }
        Resource that = (Resource) o;
        String str = this.type;
        if (str != null ? str.equals(that.getType()) : that.getType() == null) {
            if (this.labels.equals(that.getLabels())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int h = 1 * 1000003;
        String str = this.type;
        return ((h ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.labels.hashCode();
    }
}
