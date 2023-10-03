package io.grpc.perfmark;

import io.grpc.perfmark.PerfTag;

public final class PerfMark {
    private static final PerfTag NULL_PERF_TAG = PerfTag.TagFactory.create();

    private PerfMark() {
        throw new AssertionError("nope");
    }

    public static void taskStart(PerfTag tag, String taskName) {
    }

    public static void taskStart(String taskName) {
    }

    public static void taskEnd(PerfTag tag, String taskName) {
    }

    public static void taskEnd(String taskName) {
    }

    public static PerfMarkTask task(PerfTag tag, String taskName) {
        return NoopTask.INSTANCE;
    }

    public static PerfMarkTask task(String taskName) {
        return NoopTask.INSTANCE;
    }

    public static void event(PerfTag tag, String eventName) {
    }

    public static void event(String eventName) {
    }

    public static PerfTag createTag(long numericTag, String stringTag) {
        return NULL_PERF_TAG;
    }

    public static PerfTag createTag(String stringTag) {
        return NULL_PERF_TAG;
    }

    public static PerfTag createTag(long numericTag) {
        return NULL_PERF_TAG;
    }

    private static final class NoopTask extends PerfMarkTask {
        /* access modifiers changed from: private */
        public static final PerfMarkTask INSTANCE = new NoopTask();

        NoopTask() {
        }

        public void close() {
        }
    }
}
