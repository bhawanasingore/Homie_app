package io.opencensus.trace;

import io.opencensus.internal.Utils;
import javax.annotation.Nullable;

public final class TraceId implements Comparable<TraceId> {
    private static final int BASE16_SIZE = 32;
    public static final TraceId INVALID = new TraceId(0, 0);
    private static final long INVALID_ID = 0;
    public static final int SIZE = 16;
    private final long idHi;
    private final long idLo;

    private TraceId(long idHi2, long idLo2) {
        this.idHi = idHi2;
        this.idLo = idLo2;
    }

    public static TraceId fromBytes(byte[] src) {
        Utils.checkNotNull(src, "src");
        Utils.checkArgument(src.length == 16, "Invalid size: expected %s, got %s", 16, Integer.valueOf(src.length));
        return fromBytes(src, 0);
    }

    public static TraceId fromBytes(byte[] src, int srcOffset) {
        Utils.checkNotNull(src, "src");
        return new TraceId(BigendianEncoding.longFromByteArray(src, srcOffset), BigendianEncoding.longFromByteArray(src, srcOffset + 8));
    }

    public static TraceId fromLowerBase16(CharSequence src) {
        Utils.checkNotNull(src, "src");
        Utils.checkArgument(src.length() == 32, "Invalid size: expected %s, got %s", 32, Integer.valueOf(src.length()));
        return fromLowerBase16(src, 0);
    }

    public static TraceId fromLowerBase16(CharSequence src, int srcOffset) {
        Utils.checkNotNull(src, "src");
        return new TraceId(BigendianEncoding.longFromBase16String(src, srcOffset), BigendianEncoding.longFromBase16String(src, srcOffset + 16));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.opencensus.trace.TraceId generateRandomId(java.util.Random r7) {
        /*
        L_0x0000:
            long r0 = r7.nextLong()
            long r2 = r7.nextLong()
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0012
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0000
        L_0x0012:
            io.opencensus.trace.TraceId r4 = new io.opencensus.trace.TraceId
            r4.<init>(r0, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opencensus.trace.TraceId.generateRandomId(java.util.Random):io.opencensus.trace.TraceId");
    }

    public byte[] getBytes() {
        byte[] bytes = new byte[16];
        BigendianEncoding.longToByteArray(this.idHi, bytes, 0);
        BigendianEncoding.longToByteArray(this.idLo, bytes, 8);
        return bytes;
    }

    public void copyBytesTo(byte[] dest, int destOffset) {
        BigendianEncoding.longToByteArray(this.idHi, dest, destOffset);
        BigendianEncoding.longToByteArray(this.idLo, dest, destOffset + 8);
    }

    public void copyLowerBase16To(char[] dest, int destOffset) {
        BigendianEncoding.longToBase16String(this.idHi, dest, destOffset);
        BigendianEncoding.longToBase16String(this.idLo, dest, destOffset + 16);
    }

    public boolean isValid() {
        return (this.idHi == 0 && this.idLo == 0) ? false : true;
    }

    public String toLowerBase16() {
        char[] chars = new char[32];
        copyLowerBase16To(chars, 0);
        return new String(chars);
    }

    public long getLowerLong() {
        long j = this.idHi;
        return j < 0 ? -j : j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TraceId)) {
            return false;
        }
        TraceId that = (TraceId) obj;
        if (this.idHi == that.idHi && this.idLo == that.idLo) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.idHi;
        long j2 = this.idLo;
        return (((1 * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "TraceId{traceId=" + toLowerBase16() + "}";
    }

    public int compareTo(TraceId that) {
        long j = this.idHi;
        long j2 = that.idHi;
        if (j == j2) {
            long j3 = this.idLo;
            long j4 = that.idLo;
            if (j3 == j4) {
                return 0;
            }
            if (j3 < j4) {
                return -1;
            }
            return 1;
        } else if (j < j2) {
            return -1;
        } else {
            return 1;
        }
    }
}
