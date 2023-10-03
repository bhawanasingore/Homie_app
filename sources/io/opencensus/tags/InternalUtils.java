package io.opencensus.tags;

import java.util.Iterator;

public final class InternalUtils {
    private InternalUtils() {
    }

    public static Iterator<Tag> getTags(TagContext tags) {
        return tags.getIterator();
    }
}
