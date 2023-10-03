package io.opencensus.trace;

import io.opencensus.trace.Tracestate;
import java.util.List;

final class AutoValue_Tracestate extends Tracestate {
    private final List<Tracestate.Entry> entries;

    AutoValue_Tracestate(List<Tracestate.Entry> entries2) {
        if (entries2 != null) {
            this.entries = entries2;
            return;
        }
        throw new NullPointerException("Null entries");
    }

    public List<Tracestate.Entry> getEntries() {
        return this.entries;
    }

    public String toString() {
        return "Tracestate{entries=" + this.entries + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Tracestate) {
            return this.entries.equals(((Tracestate) o).getEntries());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.entries.hashCode();
    }
}
