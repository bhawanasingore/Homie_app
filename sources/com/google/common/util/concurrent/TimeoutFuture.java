package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class TimeoutFuture<V> extends AbstractFuture.TrustedFuture<V> {
    /* access modifiers changed from: private */
    @NullableDecl
    public ListenableFuture<V> delegateRef;
    @NullableDecl
    private Future<?> timer;

    static <V> ListenableFuture<V> create(ListenableFuture<V> delegate, long time, TimeUnit unit, ScheduledExecutorService scheduledExecutor) {
        TimeoutFuture<V> result = new TimeoutFuture<>(delegate);
        Fire<V> fire = new Fire<>(result);
        result.timer = scheduledExecutor.schedule(fire, time, unit);
        delegate.addListener(fire, MoreExecutors.directExecutor());
        return result;
    }

    private TimeoutFuture(ListenableFuture<V> delegate) {
        this.delegateRef = (ListenableFuture) Preconditions.checkNotNull(delegate);
    }

    private static final class Fire<V> implements Runnable {
        @NullableDecl
        TimeoutFuture<V> timeoutFutureRef;

        Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        public void run() {
            ListenableFuture<V> delegate;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture != null && (delegate = timeoutFuture.delegateRef) != null) {
                this.timeoutFutureRef = null;
                if (delegate.isDone()) {
                    timeoutFuture.setFuture(delegate);
                    return;
                }
                try {
                    timeoutFuture.setException(new TimeoutException("Future timed out: " + delegate));
                } finally {
                    delegate.cancel(true);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String pendingToString() {
        ListenableFuture<V> listenableFuture = this.delegateRef;
        if (listenableFuture == null) {
            return null;
        }
        return "inputFuture=[" + listenableFuture + "]";
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        Future<?> localTimer = this.timer;
        if (localTimer != null) {
            localTimer.cancel(false);
        }
        this.delegateRef = null;
        this.timer = null;
    }
}
