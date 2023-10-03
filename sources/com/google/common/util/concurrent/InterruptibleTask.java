package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE = new DoNothingRunnable();
    private static final Runnable INTERRUPTING = new DoNothingRunnable();

    /* access modifiers changed from: package-private */
    public abstract void afterRanInterruptibly(@NullableDecl T t, @NullableDecl Throwable th);

    /* access modifiers changed from: package-private */
    public abstract boolean isDone();

    /* access modifiers changed from: package-private */
    public abstract T runInterruptibly() throws Exception;

    /* access modifiers changed from: package-private */
    public abstract String toPendingString();

    private static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        public void run() {
        }
    }

    InterruptibleTask() {
    }

    public final void run() {
        Thread currentThread = Thread.currentThread();
        if (compareAndSet((Object) null, currentThread)) {
            boolean run = !isDone();
            T result = null;
            Throwable error = null;
            if (run) {
                try {
                    result = runInterruptibly();
                } catch (Throwable t) {
                    error = t;
                    if (!compareAndSet(currentThread, DONE)) {
                        while (get() == INTERRUPTING) {
                            Thread.yield();
                        }
                    }
                    if (!run) {
                        return;
                    }
                }
            }
            if (!compareAndSet(currentThread, DONE)) {
                while (get() == INTERRUPTING) {
                    Thread.yield();
                }
            }
            if (!run) {
                return;
            }
            afterRanInterruptibly(result, error);
        }
    }

    /* access modifiers changed from: package-private */
    public final void interruptTask() {
        Runnable currentRunner = (Runnable) get();
        if ((currentRunner instanceof Thread) && compareAndSet(currentRunner, INTERRUPTING)) {
            ((Thread) currentRunner).interrupt();
            set(DONE);
        }
    }

    public final String toString() {
        String result;
        Runnable state = (Runnable) get();
        if (state == DONE) {
            result = "running=[DONE]";
        } else if (state == INTERRUPTING) {
            result = "running=[INTERRUPTED]";
        } else if (state instanceof Thread) {
            result = "running=[RUNNING ON " + ((Thread) state).getName() + "]";
        } else {
            result = "running=[NOT STARTED YET]";
        }
        return result + ", " + toPendingString();
    }
}
