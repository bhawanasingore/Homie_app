package io.opencensus.trace.export;

import io.opencensus.internal.Utils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class RunningSpanStore {
    private static final RunningSpanStore NOOP_RUNNING_SPAN_STORE = new NoopRunningSpanStore();

    public abstract Collection<SpanData> getRunningSpans(Filter filter);

    public abstract Summary getSummary();

    protected RunningSpanStore() {
    }

    static RunningSpanStore getNoopRunningSpanStore() {
        return NOOP_RUNNING_SPAN_STORE;
    }

    public static abstract class Summary {
        public abstract Map<String, PerSpanNameSummary> getPerSpanNameSummary();

        Summary() {
        }

        public static Summary create(Map<String, PerSpanNameSummary> perSpanNameSummary) {
            return new AutoValue_RunningSpanStore_Summary(Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(perSpanNameSummary, "perSpanNameSummary"))));
        }
    }

    public static abstract class PerSpanNameSummary {
        public abstract int getNumRunningSpans();

        PerSpanNameSummary() {
        }

        public static PerSpanNameSummary create(int numRunningSpans) {
            Utils.checkArgument(numRunningSpans >= 0, "Negative numRunningSpans.");
            return new AutoValue_RunningSpanStore_PerSpanNameSummary(numRunningSpans);
        }
    }

    public static abstract class Filter {
        public abstract int getMaxSpansToReturn();

        public abstract String getSpanName();

        Filter() {
        }

        public static Filter create(String spanName, int maxSpansToReturn) {
            Utils.checkArgument(maxSpansToReturn >= 0, "Negative maxSpansToReturn.");
            return new AutoValue_RunningSpanStore_Filter(spanName, maxSpansToReturn);
        }
    }

    private static final class NoopRunningSpanStore extends RunningSpanStore {
        private static final Summary EMPTY_SUMMARY = Summary.create(Collections.emptyMap());

        private NoopRunningSpanStore() {
        }

        public Summary getSummary() {
            return EMPTY_SUMMARY;
        }

        public Collection<SpanData> getRunningSpans(Filter filter) {
            Utils.checkNotNull(filter, "filter");
            return Collections.emptyList();
        }
    }
}
