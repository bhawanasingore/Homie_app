package io.opencensus.metrics;

import io.opencensus.internal.Utils;
import java.util.List;

public abstract class LongGauge {

    public static abstract class LongPoint {
        public abstract void add(long j);

        public abstract void set(long j);
    }

    public abstract void clear();

    public abstract LongPoint getDefaultTimeSeries();

    public abstract LongPoint getOrCreateTimeSeries(List<LabelValue> list);

    public abstract void removeTimeSeries(List<LabelValue> list);

    static LongGauge newNoopLongGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
        return NoopLongGauge.create(name, description, unit, labelKeys);
    }

    private static final class NoopLongGauge extends LongGauge {
        private final int labelKeysSize;

        static NoopLongGauge create(String name, String description, String unit, List<LabelKey> labelKeys) {
            return new NoopLongGauge(name, description, unit, labelKeys);
        }

        NoopLongGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
            this.labelKeysSize = labelKeys.size();
        }

        public NoopLongPoint getOrCreateTimeSeries(List<LabelValue> labelValues) {
            Utils.checkListElementNotNull((List) Utils.checkNotNull(labelValues, "labelValues"), "labelValue");
            Utils.checkArgument(this.labelKeysSize == labelValues.size(), "Label Keys and Label Values don't have same size.");
            return NoopLongPoint.INSTANCE;
        }

        public NoopLongPoint getDefaultTimeSeries() {
            return NoopLongPoint.INSTANCE;
        }

        public void removeTimeSeries(List<LabelValue> labelValues) {
            Utils.checkNotNull(labelValues, "labelValues");
        }

        public void clear() {
        }

        private static final class NoopLongPoint extends LongPoint {
            /* access modifiers changed from: private */
            public static final NoopLongPoint INSTANCE = new NoopLongPoint();

            private NoopLongPoint() {
            }

            public void add(long amt) {
            }

            public void set(long val) {
            }
        }
    }
}
