package io.opencensus.common;

import java.util.TreeMap;
import javax.annotation.Nullable;

public final class ServerStatsFieldEnums {
    private static final int TOTALSIZE = computeTotalSize();

    public enum Id {
        SERVER_STATS_LB_LATENCY_ID(0),
        SERVER_STATS_SERVICE_LATENCY_ID(1),
        SERVER_STATS_TRACE_OPTION_ID(2);
        
        private static final TreeMap<Integer, Id> map = null;
        private final int value;

        static {
            int i;
            map = new TreeMap<>();
            for (Id id : values()) {
                map.put(Integer.valueOf(id.value), id);
            }
        }

        private Id(int value2) {
            this.value = value2;
        }

        public int value() {
            return this.value;
        }

        @Nullable
        public static Id valueOf(int value2) {
            return map.get(Integer.valueOf(value2));
        }
    }

    public enum Size {
        SERVER_STATS_LB_LATENCY_SIZE(8),
        SERVER_STATS_SERVICE_LATENCY_SIZE(8),
        SERVER_STATS_TRACE_OPTION_SIZE(1);
        
        private final int value;

        private Size(int value2) {
            this.value = value2;
        }

        public int value() {
            return this.value;
        }
    }

    private ServerStatsFieldEnums() {
    }

    private static int computeTotalSize() {
        int sum = 0;
        for (Size sizeValue : Size.values()) {
            sum = sum + sizeValue.value() + 1;
        }
        return sum;
    }

    public static int getTotalSize() {
        return TOTALSIZE;
    }
}
