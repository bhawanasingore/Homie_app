package io.opencensus.trace;

import io.grpc.Context;
import io.opencensus.common.Scope;
import io.opencensus.trace.unsafe.ContextUtils;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

final class CurrentSpanUtils {
    private CurrentSpanUtils() {
    }

    @Nullable
    static Span getCurrentSpan() {
        return ContextUtils.getValue(Context.current());
    }

    static Scope withSpan(Span span, boolean endSpan) {
        return new ScopeInSpan(span, endSpan);
    }

    static Runnable withSpan(Span span, boolean endSpan, Runnable runnable) {
        return new RunnableInSpan(span, runnable, endSpan);
    }

    static <C> Callable<C> withSpan(Span span, boolean endSpan, Callable<C> callable) {
        return new CallableInSpan(span, callable, endSpan);
    }

    private static final class ScopeInSpan implements Scope {
        private final boolean endSpan;
        private final Context origContext;
        private final Span span;

        private ScopeInSpan(Span span2, boolean endSpan2) {
            this.span = span2;
            this.endSpan = endSpan2;
            this.origContext = ContextUtils.withValue(Context.current(), span2).attach();
        }

        public void close() {
            Context.current().detach(this.origContext);
            if (this.endSpan) {
                this.span.end();
            }
        }
    }

    private static final class RunnableInSpan implements Runnable {
        private final boolean endSpan;
        private final Runnable runnable;
        private final Span span;

        private RunnableInSpan(Span span2, Runnable runnable2, boolean endSpan2) {
            this.span = span2;
            this.runnable = runnable2;
            this.endSpan = endSpan2;
        }

        public void run() {
            Context origContext = ContextUtils.withValue(Context.current(), this.span).attach();
            try {
                this.runnable.run();
                Context.current().detach(origContext);
                if (this.endSpan) {
                    this.span.end();
                }
            } catch (Throwable t) {
                Context.current().detach(origContext);
                if (this.endSpan) {
                    this.span.end();
                }
                throw t;
            }
        }
    }

    private static final class CallableInSpan<V> implements Callable<V> {
        private final Callable<V> callable;
        private final boolean endSpan;
        private final Span span;

        private CallableInSpan(Span span2, Callable<V> callable2, boolean endSpan2) {
            this.span = span2;
            this.callable = callable2;
            this.endSpan = endSpan2;
        }

        public V call() throws Exception {
            Context origContext = ContextUtils.withValue(Context.current(), this.span).attach();
            try {
                V call = this.callable.call();
                Context.current().detach(origContext);
                if (this.endSpan) {
                    this.span.end();
                }
                return call;
            } catch (Exception e) {
                CurrentSpanUtils.setErrorStatus(this.span, e);
                throw e;
            } catch (Throwable e2) {
                Context.current().detach(origContext);
                if (this.endSpan) {
                    this.span.end();
                }
                throw e2;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setErrorStatus(Span span, Throwable t) {
        span.setStatus(Status.UNKNOWN.withDescription(t.getMessage() == null ? t.getClass().getSimpleName() : t.getMessage()));
    }
}
