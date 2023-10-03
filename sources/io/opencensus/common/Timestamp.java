package io.opencensus.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Timestamp implements Comparable<Timestamp> {
    public abstract int getNanos();

    public abstract long getSeconds();

    Timestamp() {
    }

    public static Timestamp create(long seconds, int nanos) {
        if (seconds < -315576000000L) {
            throw new IllegalArgumentException("'seconds' is less than minimum (-315576000000): " + seconds);
        } else if (seconds > 315576000000L) {
            throw new IllegalArgumentException("'seconds' is greater than maximum (315576000000): " + seconds);
        } else if (nanos < 0) {
            throw new IllegalArgumentException("'nanos' is less than zero: " + nanos);
        } else if (nanos <= 999999999) {
            return new AutoValue_Timestamp(seconds, nanos);
        } else {
            throw new IllegalArgumentException("'nanos' is greater than maximum (999999999): " + nanos);
        }
    }

    public static Timestamp fromMillis(long epochMilli) {
        return create(floorDiv(epochMilli, 1000), (int) (((long) ((int) floorMod(epochMilli, 1000))) * 1000000));
    }

    public Timestamp addNanos(long nanosToAdd) {
        return plus(0, nanosToAdd);
    }

    public Timestamp addDuration(Duration duration) {
        return plus(duration.getSeconds(), (long) duration.getNanos());
    }

    public Duration subtractTimestamp(Timestamp timestamp) {
        long durationSeconds = getSeconds() - timestamp.getSeconds();
        int durationNanos = getNanos() - timestamp.getNanos();
        if (durationSeconds < 0 && durationNanos > 0) {
            durationSeconds++;
            durationNanos = (int) (((long) durationNanos) - 1000000000);
        } else if (durationSeconds > 0 && durationNanos < 0) {
            durationSeconds--;
            durationNanos = (int) (((long) durationNanos) + 1000000000);
        }
        return Duration.create(durationSeconds, durationNanos);
    }

    public int compareTo(Timestamp otherTimestamp) {
        int cmp = TimeUtils.compareLongs(getSeconds(), otherTimestamp.getSeconds());
        if (cmp != 0) {
            return cmp;
        }
        return TimeUtils.compareLongs((long) getNanos(), (long) otherTimestamp.getNanos());
    }

    private Timestamp plus(long secondsToAdd, long nanosToAdd) {
        if ((secondsToAdd | nanosToAdd) == 0) {
            return this;
        }
        return ofEpochSecond(TimeUtils.checkedAdd(TimeUtils.checkedAdd(getSeconds(), secondsToAdd), nanosToAdd / 1000000000), ((long) getNanos()) + (nanosToAdd % 1000000000));
    }

    private static Timestamp ofEpochSecond(long epochSecond, long nanoAdjustment) {
        return create(TimeUtils.checkedAdd(epochSecond, floorDiv(nanoAdjustment, 1000000000)), (int) floorMod(nanoAdjustment, 1000000000));
    }

    private static long floorDiv(long x, long y) {
        return BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y), 0, RoundingMode.FLOOR).longValue();
    }

    private static long floorMod(long x, long y) {
        return x - (floorDiv(x, y) * y);
    }
}
