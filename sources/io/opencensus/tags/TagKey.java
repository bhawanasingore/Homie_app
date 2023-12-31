package io.opencensus.tags;

import io.opencensus.internal.StringUtils;
import io.opencensus.internal.Utils;

public abstract class TagKey {
    public static final int MAX_LENGTH = 255;

    public abstract String getName();

    TagKey() {
    }

    public static TagKey create(String name) {
        Utils.checkArgument(isValid(name), "Invalid TagKey name: %s", name);
        return new AutoValue_TagKey(name);
    }

    private static boolean isValid(String name) {
        return !name.isEmpty() && name.length() <= 255 && StringUtils.isPrintableString(name);
    }
}
