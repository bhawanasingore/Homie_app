package io.opencensus.trace;

import io.opencensus.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public abstract class Tracestate {
    private static final int KEY_MAX_SIZE = 256;
    private static final int MAX_KEY_VALUE_PAIRS = 32;
    private static final int VALUE_MAX_SIZE = 256;

    public abstract List<Entry> getEntries();

    @Nullable
    public String get(String key) {
        for (Entry entry : getEntries()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public static final Tracestate EMPTY = Tracestate.create(Collections.emptyList());
        @Nullable
        private ArrayList<Entry> entries;
        private final Tracestate parent;

        private Builder(Tracestate parent2) {
            Utils.checkNotNull(parent2, "parent");
            this.parent = parent2;
            this.entries = null;
        }

        public Builder set(String key, String value) {
            Entry entry = Entry.create(key, value);
            if (this.entries == null) {
                this.entries = new ArrayList<>(this.parent.getEntries());
            }
            int i = 0;
            while (true) {
                if (i >= this.entries.size()) {
                    break;
                } else if (this.entries.get(i).getKey().equals(entry.getKey())) {
                    this.entries.remove(i);
                    break;
                } else {
                    i++;
                }
            }
            this.entries.add(0, entry);
            return this;
        }

        public Builder remove(String key) {
            Utils.checkNotNull(key, "key");
            if (this.entries == null) {
                this.entries = new ArrayList<>(this.parent.getEntries());
            }
            int i = 0;
            while (true) {
                if (i >= this.entries.size()) {
                    break;
                } else if (this.entries.get(i).getKey().equals(key)) {
                    this.entries.remove(i);
                    break;
                } else {
                    i++;
                }
            }
            return this;
        }

        public Tracestate build() {
            ArrayList<Entry> arrayList = this.entries;
            if (arrayList == null) {
                return this.parent;
            }
            return Tracestate.create(arrayList);
        }
    }

    public static abstract class Entry {
        public abstract String getKey();

        public abstract String getValue();

        public static Entry create(String key, String value) {
            Utils.checkNotNull(key, "key");
            Utils.checkNotNull(value, "value");
            Utils.checkArgument(Tracestate.validateKey(key), "Invalid key %s", key);
            Utils.checkArgument(Tracestate.validateValue(value), "Invalid value %s", value);
            return new AutoValue_Tracestate_Entry(key, value);
        }

        Entry() {
        }
    }

    /* access modifiers changed from: private */
    public static boolean validateKey(String key) {
        if (key.length() > 256 || key.isEmpty() || key.charAt(0) < 'a' || key.charAt(0) > 'z') {
            return false;
        }
        for (int i = 1; i < key.length(); i++) {
            char c = key.charAt(i);
            if ((c < 'a' || c > 'z') && ((c < '0' || c > '9') && c != '_' && c != '-' && c != '*' && c != '/')) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean validateValue(String value) {
        if (value.length() > 256 || value.charAt(value.length() - 1) == ' ') {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == ',' || c == '=' || c < ' ' || c > '~') {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static Tracestate create(List<Entry> entries) {
        Utils.checkState(entries.size() <= 32, "Invalid size");
        return new AutoValue_Tracestate(Collections.unmodifiableList(entries));
    }

    Tracestate() {
    }
}
