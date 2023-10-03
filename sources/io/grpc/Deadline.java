package io.grpc;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class Deadline implements Comparable<Deadline> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long MAX_OFFSET;
    private static final long MIN_OFFSET;
    private static final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);
    private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
    private final long deadlineNanos;
    private volatile boolean expired;
    private final Ticker ticker;

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500);
        MAX_OFFSET = nanos;
        MIN_OFFSET = -nanos;
    }

    public static Deadline after(long duration, TimeUnit units) {
        return after(duration, units, SYSTEM_TICKER);
    }

    static Deadline after(long duration, TimeUnit units, Ticker ticker2) {
        checkNotNull(units, "units");
        return new Deadline(ticker2, units.toNanos(duration), true);
    }

    private Deadline(Ticker ticker2, long offset, boolean baseInstantAlreadyExpired) {
        this(ticker2, ticker2.read(), offset, baseInstantAlreadyExpired);
    }

    private Deadline(Ticker ticker2, long baseInstant, long offset, boolean baseInstantAlreadyExpired) {
        this.ticker = ticker2;
        long offset2 = Math.min(MAX_OFFSET, Math.max(MIN_OFFSET, offset));
        this.deadlineNanos = baseInstant + offset2;
        this.expired = baseInstantAlreadyExpired && offset2 <= 0;
    }

    public boolean isExpired() {
        if (!this.expired) {
            if (this.deadlineNanos - this.ticker.read() > 0) {
                return false;
            }
            this.expired = true;
        }
        return true;
    }

    public boolean isBefore(Deadline other) {
        return this.deadlineNanos - other.deadlineNanos < 0;
    }

    public Deadline minimum(Deadline other) {
        return isBefore(other) ? this : other;
    }

    public Deadline offset(long offset, TimeUnit units) {
        if (offset == 0) {
            return this;
        }
        return new Deadline(this.ticker, this.deadlineNanos, units.toNanos(offset), isExpired());
    }

    public long timeRemaining(TimeUnit unit) {
        long nowNanos = this.ticker.read();
        if (!this.expired && this.deadlineNanos - nowNanos <= 0) {
            this.expired = true;
        }
        return unit.convert(this.deadlineNanos - nowNanos, TimeUnit.NANOSECONDS);
    }

    public ScheduledFuture<?> runOnExpiration(Runnable task, ScheduledExecutorService scheduler) {
        checkNotNull(task, "task");
        checkNotNull(scheduler, "scheduler");
        return scheduler.schedule(task, this.deadlineNanos - this.ticker.read(), TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long remainingNanos = timeRemaining(TimeUnit.NANOSECONDS);
        long seconds = Math.abs(remainingNanos) / NANOS_PER_SECOND;
        long nanos = Math.abs(remainingNanos) % NANOS_PER_SECOND;
        StringBuilder buf = new StringBuilder();
        if (remainingNanos < 0) {
            buf.append('-');
        }
        buf.append(seconds);
        if (nanos > 0) {
            buf.append(String.format(".%09d", new Object[]{Long.valueOf(nanos)}));
        }
        buf.append("s from now");
        return buf.toString();
    }

    public int compareTo(Deadline that) {
        long diff = this.deadlineNanos - that.deadlineNanos;
        if (diff < 0) {
            return -1;
        }
        if (diff > 0) {
            return 1;
        }
        return 0;
    }

    static abstract class Ticker {
        public abstract long read();

        Ticker() {
        }
    }

    private static class SystemTicker extends Ticker {
        private SystemTicker() {
        }

        public long read() {
            return System.nanoTime();
        }
    }

    private static <T> T checkNotNull(T reference, Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }
}
