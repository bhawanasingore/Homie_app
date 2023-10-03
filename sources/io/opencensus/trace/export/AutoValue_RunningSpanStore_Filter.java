package io.opencensus.trace.export;

import io.opencensus.trace.export.RunningSpanStore;

final class AutoValue_RunningSpanStore_Filter extends RunningSpanStore.Filter {
    private final int maxSpansToReturn;
    private final String spanName;

    AutoValue_RunningSpanStore_Filter(String spanName2, int maxSpansToReturn2) {
        if (spanName2 != null) {
            this.spanName = spanName2;
            this.maxSpansToReturn = maxSpansToReturn2;
            return;
        }
        throw new NullPointerException("Null spanName");
    }

    public String getSpanName() {
        return this.spanName;
    }

    public int getMaxSpansToReturn() {
        return this.maxSpansToReturn;
    }

    public String toString() {
        return "Filter{spanName=" + this.spanName + ", maxSpansToReturn=" + this.maxSpansToReturn + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RunningSpanStore.Filter)) {
            return false;
        }
        RunningSpanStore.Filter that = (RunningSpanStore.Filter) o;
        if (!this.spanName.equals(that.getSpanName()) || this.maxSpansToReturn != that.getMaxSpansToReturn()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.spanName.hashCode()) * 1000003) ^ this.maxSpansToReturn;
    }
}
