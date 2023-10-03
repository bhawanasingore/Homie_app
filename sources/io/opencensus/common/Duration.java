package io.opencensus.common;

import java.util.concurrent.TimeUnit;

public abstract class Duration implements Comparable<Duration> {
    public abstract int getNanos();

    public abstract long getSeconds();

    public static Duration create(long seconds, int nanos) {
        if (seconds < -315576000000L) {
            throw new IllegalArgumentException("'seconds' is less than minimum (-315576000000): " + seconds);
        } else if (seconds > 315576000000L) {
            throw new IllegalArgumentException("'seconds' is greater than maximum (315576000000): " + seconds);
        } else if (nanos < -999999999) {
            throw new IllegalArgumentException("'nanos' is less than minimum (-999999999): " + nanos);
        } else if (nanos > 999999999) {
            throw new IllegalArgumentException("'nanos' is greater than maximum (999999999): " + nanos);
        } else if ((seconds >= 0 || nanos <= 0) && (seconds <= 0 || nanos >= 0)) {
            return new AutoValue_Duration(seconds, nanos);
        } else {
            throw new IllegalArgumentException("'seconds' and 'nanos' have inconsistent sign: seconds=" + seconds + ", nanos=" + nanos);
        }
    }

    public static Duration fromMillis(long millis) {
        return create(millis / 1000, (int) ((millis % 1000) * 1000000));
    }

    public long toMillis() {
        return TimeUnit.SECONDS.toMillis(getSeconds()) + TimeUnit.NANOSECONDS.toMillis((long) getNanos());
    }

    public int compareTo(Duration otherDuration) {
        int cmp = TimeUtils.compareLongs(getSeconds(), otherDuration.getSeconds());
        if (cmp != 0) {
            return cmp;
        }
        return TimeUtils.compareLongs((long) getNanos(), (long) otherDuration.getNanos());
    }

    Duration() {
    }
}
