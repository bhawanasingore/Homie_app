package io.opencensus.trace;

import io.opencensus.internal.Utils;
import java.util.Random;
import javax.annotation.Nullable;

public final class SpanId implements Comparable<SpanId> {
    private static final int BASE16_SIZE = 16;
    public static final SpanId INVALID = new SpanId(0);
    private static final long INVALID_ID = 0;
    public static final int SIZE = 8;
    private final long id;

    private SpanId(long id2) {
        this.id = id2;
    }

    public static SpanId fromBytes(byte[] src) {
        Utils.checkNotNull(src, "src");
        Utils.checkArgument(src.length == 8, "Invalid size: expected %s, got %s", 8, Integer.valueOf(src.length));
        return fromBytes(src, 0);
    }

    public static SpanId fromBytes(byte[] src, int srcOffset) {
        Utils.checkNotNull(src, "src");
        return new SpanId(BigendianEncoding.longFromByteArray(src, srcOffset));
    }

    public static SpanId fromLowerBase16(CharSequence src) {
        Utils.checkNotNull(src, "src");
        Utils.checkArgument(src.length() == 16, "Invalid size: expected %s, got %s", 16, Integer.valueOf(src.length()));
        return fromLowerBase16(src, 0);
    }

    public static SpanId fromLowerBase16(CharSequence src, int srcOffset) {
        Utils.checkNotNull(src, "src");
        return new SpanId(BigendianEncoding.longFromBase16String(src, srcOffset));
    }

    public static SpanId generateRandomId(Random random) {
        long id2;
        do {
            id2 = random.nextLong();
        } while (id2 == 0);
        return new SpanId(id2);
    }

    public byte[] getBytes() {
        byte[] bytes = new byte[8];
        BigendianEncoding.longToByteArray(this.id, bytes, 0);
        return bytes;
    }

    public void copyBytesTo(byte[] dest, int destOffset) {
        BigendianEncoding.longToByteArray(this.id, dest, destOffset);
    }

    public void copyLowerBase16To(char[] dest, int destOffset) {
        BigendianEncoding.longToBase16String(this.id, dest, destOffset);
    }

    public boolean isValid() {
        return this.id != 0;
    }

    public String toLowerBase16() {
        char[] chars = new char[16];
        copyLowerBase16To(chars, 0);
        return new String(chars);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanId)) {
            return false;
        }
        if (this.id == ((SpanId) obj).id) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "SpanId{spanId=" + toLowerBase16() + "}";
    }

    public int compareTo(SpanId that) {
        long j = this.id;
        long j2 = that.id;
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
