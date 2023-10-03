package io.grpc.perfmark;

import io.grpc.perfmark.PerfTag;

public final class InternalPerfMark {
    private static final long NULL_NUMERIC_TAG = 0;
    private static final String NULL_STRING_TAG = null;

    public static abstract class InternalPerfMarkTask extends PerfMarkTask {
    }

    private InternalPerfMark() {
    }

    public static PerfTag createPerfTag(long numericTag, String stringTag) {
        return PerfTag.TagFactory.create(numericTag, stringTag);
    }

    public static PerfTag createPerfTag(String stringTag) {
        return PerfTag.TagFactory.create(0, stringTag);
    }

    public static PerfTag createPerfTag(long numericTag) {
        return PerfTag.TagFactory.create(numericTag, NULL_STRING_TAG);
    }
}
