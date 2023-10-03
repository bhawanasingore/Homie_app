package io.opencensus.trace.export;

import io.opencensus.internal.Utils;
import io.opencensus.trace.Status;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class SampledSpanStore {
    public abstract Collection<SpanData> getErrorSampledSpans(ErrorFilter errorFilter);

    public abstract Collection<SpanData> getLatencySampledSpans(LatencyFilter latencyFilter);

    public abstract Set<String> getRegisteredSpanNamesForCollection();

    public abstract Summary getSummary();

    @Deprecated
    public abstract void registerSpanNamesForCollection(Collection<String> collection);

    @Deprecated
    public abstract void unregisterSpanNamesForCollection(Collection<String> collection);

    protected SampledSpanStore() {
    }

    static SampledSpanStore newNoopSampledSpanStore() {
        return new NoopSampledSpanStore();
    }

    public static abstract class Summary {
        public abstract Map<String, PerSpanNameSummary> getPerSpanNameSummary();

        Summary() {
        }

        public static Summary create(Map<String, PerSpanNameSummary> perSpanNameSummary) {
            return new AutoValue_SampledSpanStore_Summary(Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(perSpanNameSummary, "perSpanNameSummary"))));
        }
    }

    public static abstract class PerSpanNameSummary {
        public abstract Map<Status.CanonicalCode, Integer> getNumbersOfErrorSampledSpans();

        public abstract Map<LatencyBucketBoundaries, Integer> getNumbersOfLatencySampledSpans();

        PerSpanNameSummary() {
        }

        public static PerSpanNameSummary create(Map<LatencyBucketBoundaries, Integer> numbersOfLatencySampledSpans, Map<Status.CanonicalCode, Integer> numbersOfErrorSampledSpans) {
            return new AutoValue_SampledSpanStore_PerSpanNameSummary(Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(numbersOfLatencySampledSpans, "numbersOfLatencySampledSpans"))), Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(numbersOfErrorSampledSpans, "numbersOfErrorSampledSpans"))));
        }
    }

    public enum LatencyBucketBoundaries {
        ZERO_MICROSx10(0, TimeUnit.MICROSECONDS.toNanos(10)),
        MICROSx10_MICROSx100(TimeUnit.MICROSECONDS.toNanos(10), TimeUnit.MICROSECONDS.toNanos(100)),
        MICROSx100_MILLIx1(TimeUnit.MICROSECONDS.toNanos(100), TimeUnit.MILLISECONDS.toNanos(1)),
        MILLIx1_MILLIx10(TimeUnit.MILLISECONDS.toNanos(1), TimeUnit.MILLISECONDS.toNanos(10)),
        MILLIx10_MILLIx100(TimeUnit.MILLISECONDS.toNanos(10), TimeUnit.MILLISECONDS.toNanos(100)),
        MILLIx100_SECONDx1(TimeUnit.MILLISECONDS.toNanos(100), TimeUnit.SECONDS.toNanos(1)),
        SECONDx1_SECONDx10(TimeUnit.SECONDS.toNanos(1), TimeUnit.SECONDS.toNanos(10)),
        SECONDx10_SECONDx100(TimeUnit.SECONDS.toNanos(10), TimeUnit.SECONDS.toNanos(100)),
        SECONDx100_MAX(TimeUnit.SECONDS.toNanos(100), Long.MAX_VALUE);
        
        private final long latencyLowerNs;
        private final long latencyUpperNs;

        private LatencyBucketBoundaries(long latencyLowerNs2, long latencyUpperNs2) {
            this.latencyLowerNs = latencyLowerNs2;
            this.latencyUpperNs = latencyUpperNs2;
        }

        public long getLatencyLowerNs() {
            return this.latencyLowerNs;
        }

        public long getLatencyUpperNs() {
            return this.latencyUpperNs;
        }
    }

    public static abstract class LatencyFilter {
        public abstract long getLatencyLowerNs();

        public abstract long getLatencyUpperNs();

        public abstract int getMaxSpansToReturn();

        public abstract String getSpanName();

        LatencyFilter() {
        }

        public static LatencyFilter create(String spanName, long latencyLowerNs, long latencyUpperNs, int maxSpansToReturn) {
            boolean z = true;
            Utils.checkArgument(maxSpansToReturn >= 0, "Negative maxSpansToReturn.");
            Utils.checkArgument(latencyLowerNs >= 0, "Negative latencyLowerNs");
            if (latencyUpperNs < 0) {
                z = false;
            }
            Utils.checkArgument(z, "Negative latencyUpperNs");
            return new AutoValue_SampledSpanStore_LatencyFilter(spanName, latencyLowerNs, latencyUpperNs, maxSpansToReturn);
        }
    }

    public static abstract class ErrorFilter {
        @Nullable
        public abstract Status.CanonicalCode getCanonicalCode();

        public abstract int getMaxSpansToReturn();

        public abstract String getSpanName();

        ErrorFilter() {
        }

        public static ErrorFilter create(String spanName, @Nullable Status.CanonicalCode canonicalCode, int maxSpansToReturn) {
            boolean z = true;
            if (canonicalCode != null) {
                Utils.checkArgument(canonicalCode != Status.CanonicalCode.OK, "Invalid canonical code.");
            }
            if (maxSpansToReturn < 0) {
                z = false;
            }
            Utils.checkArgument(z, "Negative maxSpansToReturn.");
            return new AutoValue_SampledSpanStore_ErrorFilter(spanName, canonicalCode, maxSpansToReturn);
        }
    }

    private static final class NoopSampledSpanStore extends SampledSpanStore {
        private static final PerSpanNameSummary EMPTY_PER_SPAN_NAME_SUMMARY = PerSpanNameSummary.create(Collections.emptyMap(), Collections.emptyMap());
        private final Set<String> registeredSpanNames;

        private NoopSampledSpanStore() {
            this.registeredSpanNames = new HashSet();
        }

        public Summary getSummary() {
            Map<String, PerSpanNameSummary> result = new HashMap<>();
            synchronized (this.registeredSpanNames) {
                for (String registeredSpanName : this.registeredSpanNames) {
                    result.put(registeredSpanName, EMPTY_PER_SPAN_NAME_SUMMARY);
                }
            }
            return Summary.create(result);
        }

        public Collection<SpanData> getLatencySampledSpans(LatencyFilter filter) {
            Utils.checkNotNull(filter, "latencyFilter");
            return Collections.emptyList();
        }

        public Collection<SpanData> getErrorSampledSpans(ErrorFilter filter) {
            Utils.checkNotNull(filter, "errorFilter");
            return Collections.emptyList();
        }

        public void registerSpanNamesForCollection(Collection<String> spanNames) {
            Utils.checkNotNull(spanNames, "spanNames");
            synchronized (this.registeredSpanNames) {
                this.registeredSpanNames.addAll(spanNames);
            }
        }

        public void unregisterSpanNamesForCollection(Collection<String> spanNames) {
            Utils.checkNotNull(spanNames, "spanNames");
            synchronized (this.registeredSpanNames) {
                this.registeredSpanNames.removeAll(spanNames);
            }
        }

        public Set<String> getRegisteredSpanNamesForCollection() {
            Set<String> unmodifiableSet;
            synchronized (this.registeredSpanNames) {
                unmodifiableSet = Collections.unmodifiableSet(new HashSet(this.registeredSpanNames));
            }
            return unmodifiableSet;
        }
    }
}
