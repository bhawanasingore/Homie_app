package io.opencensus.tags;

import io.opencensus.internal.StringUtils;
import io.opencensus.internal.Utils;

public abstract class TagValue {
    public static final int MAX_LENGTH = 255;

    public abstract String asString();

    TagValue() {
    }

    public static TagValue create(String value) {
        Utils.checkArgument(isValid(value), "Invalid TagValue: %s", value);
        return new AutoValue_TagValue(value);
    }

    private static boolean isValid(String value) {
        return value.length() <= 255 && StringUtils.isPrintableString(value);
    }
}
