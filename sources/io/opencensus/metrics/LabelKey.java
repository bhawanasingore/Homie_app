package io.opencensus.metrics;

public abstract class LabelKey {
    public abstract String getDescription();

    public abstract String getKey();

    LabelKey() {
    }

    public static LabelKey create(String key, String description) {
        return new AutoValue_LabelKey(key, description);
    }
}
