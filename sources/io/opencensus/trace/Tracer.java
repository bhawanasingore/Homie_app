package io.opencensus.trace;

import io.opencensus.common.Scope;
import io.opencensus.internal.Utils;
import io.opencensus.trace.SpanBuilder;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public abstract class Tracer {
    private static final NoopTracer noopTracer = new NoopTracer();

    public abstract SpanBuilder spanBuilderWithExplicitParent(String str, @Nullable Span span);

    public abstract SpanBuilder spanBuilderWithRemoteParent(String str, @Nullable SpanContext spanContext);

    static Tracer getNoopTracer() {
        return noopTracer;
    }

    public final Span getCurrentSpan() {
        Span currentSpan = CurrentSpanUtils.getCurrentSpan();
        return currentSpan != null ? currentSpan : BlankSpan.INSTANCE;
    }

    public final Scope withSpan(Span span) {
        return CurrentSpanUtils.withSpan((Span) Utils.checkNotNull(span, "span"), false);
    }

    public final Runnable withSpan(Span span, Runnable runnable) {
        return CurrentSpanUtils.withSpan(span, false, runnable);
    }

    public final <C> Callable<C> withSpan(Span span, Callable<C> callable) {
        return CurrentSpanUtils.withSpan(span, false, callable);
    }

    public final SpanBuilder spanBuilder(String spanName) {
        return spanBuilderWithExplicitParent(spanName, CurrentSpanUtils.getCurrentSpan());
    }

    private static final class NoopTracer extends Tracer {
        public SpanBuilder spanBuilderWithExplicitParent(String spanName, @Nullable Span parent) {
            return SpanBuilder.NoopSpanBuilder.createWithParent(spanName, parent);
        }

        public SpanBuilder spanBuilderWithRemoteParent(String spanName, @Nullable SpanContext remoteParentSpanContext) {
            return SpanBuilder.NoopSpanBuilder.createWithRemoteParent(spanName, remoteParentSpanContext);
        }

        private NoopTracer() {
        }
    }

    protected Tracer() {
    }
}
