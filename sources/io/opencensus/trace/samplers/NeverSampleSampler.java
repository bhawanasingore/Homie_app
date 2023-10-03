package io.opencensus.trace.samplers;

import io.opencensus.trace.Sampler;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.TraceId;
import java.util.List;
import javax.annotation.Nullable;

final class NeverSampleSampler extends Sampler {
    NeverSampleSampler() {
    }

    public boolean shouldSample(@Nullable SpanContext parentContext, @Nullable Boolean hasRemoteParent, TraceId traceId, SpanId spanId, String name, List<Span> list) {
        return false;
    }

    public String getDescription() {
        return toString();
    }

    public String toString() {
        return "NeverSampleSampler";
    }
}
