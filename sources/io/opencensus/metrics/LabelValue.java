package io.opencensus.metrics;

import javax.annotation.Nullable;

public abstract class LabelValue {
    @Nullable
    public abstract String getValue();

    LabelValue() {
    }

    public static LabelValue create(@Nullable String value) {
        return new AutoValue_LabelValue(value);
    }
}
