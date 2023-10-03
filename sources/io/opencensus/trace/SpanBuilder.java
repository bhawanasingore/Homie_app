package io.opencensus.trace;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.opencensus.common.Scope;
import io.opencensus.internal.Utils;
import io.opencensus.trace.Span;
import java.util.List;
import javax.annotation.Nullable;

public abstract class SpanBuilder {
    public abstract SpanBuilder setParentLinks(List<Span> list);

    public abstract SpanBuilder setRecordEvents(boolean z);

    public abstract SpanBuilder setSampler(Sampler sampler);

    public abstract Span startSpan();

    public SpanBuilder setSpanKind(@Nullable Span.Kind spanKind) {
        return this;
    }

    public final Scope startScopedSpan() {
        return CurrentSpanUtils.withSpan(startSpan(), true);
    }

    public final void startSpanAndRun(Runnable runnable) {
        CurrentSpanUtils.withSpan(startSpan(), true, runnable).run();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.concurrent.Callable, java.util.concurrent.Callable<V>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <V> V startSpanAndCall(java.util.concurrent.Callable<V> r3) throws java.lang.Exception {
        /*
            r2 = this;
            io.opencensus.trace.Span r0 = r2.startSpan()
            r1 = 1
            java.util.concurrent.Callable r1 = io.opencensus.trace.CurrentSpanUtils.withSpan((io.opencensus.trace.Span) r0, (boolean) r1, r3)
            java.lang.Object r1 = r1.call()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opencensus.trace.SpanBuilder.startSpanAndCall(java.util.concurrent.Callable):java.lang.Object");
    }

    static final class NoopSpanBuilder extends SpanBuilder {
        static NoopSpanBuilder createWithParent(String spanName, @Nullable Span parent) {
            return new NoopSpanBuilder(spanName);
        }

        static NoopSpanBuilder createWithRemoteParent(String spanName, @Nullable SpanContext remoteParentSpanContext) {
            return new NoopSpanBuilder(spanName);
        }

        public Span startSpan() {
            return BlankSpan.INSTANCE;
        }

        public SpanBuilder setSampler(@Nullable Sampler sampler) {
            return this;
        }

        public SpanBuilder setParentLinks(List<Span> list) {
            return this;
        }

        public SpanBuilder setRecordEvents(boolean recordEvents) {
            return this;
        }

        public SpanBuilder setSpanKind(@Nullable Span.Kind spanKind) {
            return this;
        }

        private NoopSpanBuilder(String name) {
            Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        }
    }
}
