package io.opencensus.trace;

import io.opencensus.internal.Utils;
import java.util.Arrays;
import javax.annotation.Nullable;

public final class TraceOptions {
    private static final int BASE16_SIZE = 2;
    public static final TraceOptions DEFAULT = fromByte((byte) 0);
    private static final byte DEFAULT_OPTIONS = 0;
    private static final byte IS_SAMPLED = 1;
    public static final int SIZE = 1;
    private final byte options;

    private TraceOptions(byte options2) {
        this.options = options2;
    }

    @Deprecated
    public static TraceOptions fromBytes(byte[] buffer) {
        Utils.checkNotNull(buffer, "buffer");
        Utils.checkArgument(buffer.length == 1, "Invalid size: expected %s, got %s", 1, Integer.valueOf(buffer.length));
        return fromByte(buffer[0]);
    }

    @Deprecated
    public static TraceOptions fromBytes(byte[] src, int srcOffset) {
        Utils.checkIndex(srcOffset, src.length);
        return fromByte(src[srcOffset]);
    }

    public static TraceOptions fromByte(byte src) {
        return new TraceOptions(src);
    }

    public static TraceOptions fromLowerBase16(CharSequence src, int srcOffset) {
        return new TraceOptions(BigendianEncoding.byteFromBase16String(src, srcOffset));
    }

    public byte getByte() {
        return this.options;
    }

    @Deprecated
    public byte[] getBytes() {
        return new byte[]{this.options};
    }

    public void copyBytesTo(byte[] dest, int destOffset) {
        Utils.checkIndex(destOffset, dest.length);
        dest[destOffset] = this.options;
    }

    public void copyLowerBase16To(char[] dest, int destOffset) {
        BigendianEncoding.byteToBase16String(this.options, dest, destOffset);
    }

    public String toLowerBase16() {
        char[] chars = new char[2];
        copyLowerBase16To(chars, 0);
        return new String(chars);
    }

    public static Builder builder() {
        return new Builder((byte) 0);
    }

    public static Builder builder(TraceOptions traceOptions) {
        return new Builder(traceOptions.options);
    }

    public boolean isSampled() {
        return hasOption(1);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TraceOptions)) {
            return false;
        }
        if (this.options == ((TraceOptions) obj).options) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new byte[]{this.options});
    }

    public String toString() {
        return "TraceOptions{sampled=" + isSampled() + "}";
    }

    public static final class Builder {
        private byte options;

        private Builder(byte options2) {
            this.options = options2;
        }

        @Deprecated
        public Builder setIsSampled() {
            return setIsSampled(true);
        }

        public Builder setIsSampled(boolean isSampled) {
            if (isSampled) {
                this.options = (byte) (this.options | 1);
            } else {
                this.options = (byte) (this.options & -2);
            }
            return this;
        }

        public TraceOptions build() {
            return TraceOptions.fromByte(this.options);
        }
    }

    /* access modifiers changed from: package-private */
    public byte getOptions() {
        return this.options;
    }

    private boolean hasOption(int mask) {
        return (this.options & mask) != 0;
    }
}
