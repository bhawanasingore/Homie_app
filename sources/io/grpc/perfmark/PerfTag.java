package io.grpc.perfmark;

import javax.annotation.Nullable;

public final class PerfTag {
    private static final long NULL_NUMERIC_TAG = 0;
    /* access modifiers changed from: private */
    public static final String NULL_STRING_TAG = null;
    private final long numericTag;
    private final String stringTag;

    private PerfTag(long numericTag2, @Nullable String stringTag2) {
        this.numericTag = numericTag2;
        this.stringTag = stringTag2;
    }

    public long getNumericTag() {
        return this.numericTag;
    }

    @Nullable
    public String getStringTag() {
        return this.stringTag;
    }

    public String toString() {
        return "Tag(numericTag=" + this.numericTag + ",stringTag='" + this.stringTag + "')";
    }

    public int hashCode() {
        long j = this.numericTag;
        int longHashCode = (int) (j ^ (j >>> 32));
        String str = this.stringTag;
        return (str != null ? str.hashCode() : 31) + longHashCode;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PerfTag)) {
            return false;
        }
        PerfTag that = (PerfTag) obj;
        if (this.numericTag != that.numericTag) {
            return false;
        }
        String str = this.stringTag;
        String str2 = that.stringTag;
        if (str == str2 || (str != null && str.equals(str2))) {
            return true;
        }
        return false;
    }

    static final class TagFactory {
        private TagFactory() {
            throw new AssertionError("nope");
        }

        public static PerfTag create(long numericTag, String stringTag) {
            return new PerfTag(numericTag, stringTag);
        }

        public static PerfTag create(String stringTag) {
            return new PerfTag(0, stringTag);
        }

        public static PerfTag create(long numericTag) {
            return new PerfTag(numericTag, PerfTag.NULL_STRING_TAG);
        }

        static PerfTag create() {
            return new PerfTag(0, PerfTag.NULL_STRING_TAG);
        }
    }
}
