package io.opencensus.trace.samplers;

import io.opencensus.internal.Utils;
import io.opencensus.trace.Sampler;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.TraceId;
import java.util.List;
import javax.annotation.Nullable;

abstract class ProbabilitySampler extends Sampler {
    /* access modifiers changed from: package-private */
    public abstract long getIdUpperBound();

    /* access modifiers changed from: package-private */
    public abstract double getProbability();

    ProbabilitySampler() {
    }

    static ProbabilitySampler create(double probability) {
        long idUpperBound;
        Utils.checkArgument(probability >= 0.0d && probability <= 1.0d, "probability must be in range [0.0, 1.0]");
        if (probability == 0.0d) {
            idUpperBound = Long.MIN_VALUE;
        } else if (probability == 1.0d) {
            idUpperBound = Long.MAX_VALUE;
        } else {
            idUpperBound = (long) (9.223372036854776E18d * probability);
        }
        return new AutoValue_ProbabilitySampler(probability, idUpperBound);
    }

    public final boolean shouldSample(@Nullable SpanContext parentContext, @Nullable Boolean hasRemoteParent, TraceId traceId, SpanId spanId, String name, @Nullable List<Span> parentLinks) {
        if (parentContext != null && parentContext.getTraceOptions().isSampled()) {
            return true;
        }
        if (parentLinks != null) {
            for (Span parentLink : parentLinks) {
                if (parentLink.getContext().getTraceOptions().isSampled()) {
                    return true;
                }
            }
        }
        if (Math.abs(traceId.getLowerLong()) < getIdUpperBound()) {
            return true;
        }
        return false;
    }

    public final String getDescription() {
        return String.format("ProbabilitySampler{%.6f}", new Object[]{Double.valueOf(getProbability())});
    }
}
