package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutionSequencer {
    private final AtomicReference<ListenableFuture<Object>> ref = new AtomicReference<>(Futures.immediateFuture(null));

    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    public <T> ListenableFuture<T> submit(final Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        return submitAsync(new AsyncCallable<T>() {
            public ListenableFuture<T> call() throws Exception {
                return Futures.immediateFuture(callable.call());
            }
        }, executor);
    }

    public <T> ListenableFuture<T> submitAsync(AsyncCallable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        final AtomicReference<RunningState> runningState = new AtomicReference<>(RunningState.NOT_RUN);
        final AsyncCallable<T> asyncCallable = callable;
        AsyncCallable<T> task = new AsyncCallable<T>() {
            public ListenableFuture<T> call() throws Exception {
                if (!runningState.compareAndSet(RunningState.NOT_RUN, RunningState.STARTED)) {
                    return Futures.immediateCancelledFuture();
                }
                return asyncCallable.call();
            }
        };
        SettableFuture create = SettableFuture.create();
        final ListenableFuture<?> oldFuture = this.ref.getAndSet(create);
        final Executor executor2 = executor;
        ListenableFuture<T> taskFuture = Futures.submitAsync(task, new Executor() {
            public void execute(Runnable runnable) {
                oldFuture.addListener(runnable, executor2);
            }
        });
        ListenableFuture<T> outputFuture = Futures.nonCancellationPropagating(taskFuture);
        final ListenableFuture<T> listenableFuture = taskFuture;
        final ListenableFuture<T> listenableFuture2 = outputFuture;
        final AtomicReference<RunningState> atomicReference = runningState;
        final SettableFuture settableFuture = create;
        final ListenableFuture<?> listenableFuture3 = oldFuture;
        Runnable listener = new Runnable() {
            public void run() {
                if (listenableFuture.isDone() || (listenableFuture2.isCancelled() && atomicReference.compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED))) {
                    settableFuture.setFuture(listenableFuture3);
                }
            }
        };
        outputFuture.addListener(listener, MoreExecutors.directExecutor());
        taskFuture.addListener(listener, MoreExecutors.directExecutor());
        return outputFuture;
    }
}
