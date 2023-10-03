package io.opencensus.common;

import java.math.BigInteger;

final class TimeUtils {
    private static final BigInteger MAX_LONG_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
    static final int MAX_NANOS = 999999999;
    static final long MAX_SECONDS = 315576000000L;
    static final long MILLIS_PER_SECOND = 1000;
    private static final BigInteger MIN_LONG_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
    static final long NANOS_PER_MILLI = 1000000;
    static final long NANOS_PER_SECOND = 1000000000;

    private TimeUtils() {
    }

    static int compareLongs(long x, long y) {
        if (x < y) {
            return -1;
        }
        if (x == y) {
            return 0;
        }
        return 1;
    }

    static long checkedAdd(long x, long y) {
        BigInteger sum = BigInteger.valueOf(x).add(BigInteger.valueOf(y));
        if (sum.compareTo(MAX_LONG_VALUE) <= 0 && sum.compareTo(MIN_LONG_VALUE) >= 0) {
            return x + y;
        }
        throw new ArithmeticException("Long sum overflow: x=" + x + ", y=" + y);
    }
}
