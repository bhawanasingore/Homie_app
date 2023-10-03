package io.opencensus.metrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.opencensus.internal.Utils;
import java.util.List;

public abstract class DoubleGauge {

    public static abstract class DoublePoint {
        public abstract void add(double d);

        public abstract void set(double d);
    }

    public abstract void clear();

    public abstract DoublePoint getDefaultTimeSeries();

    public abstract DoublePoint getOrCreateTimeSeries(List<LabelValue> list);

    public abstract void removeTimeSeries(List<LabelValue> list);

    static DoubleGauge newNoopDoubleGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
        return NoopDoubleGauge.create(name, description, unit, labelKeys);
    }

    private static final class NoopDoubleGauge extends DoubleGauge {
        private final int labelKeysSize;

        static NoopDoubleGauge create(String name, String description, String unit, List<LabelKey> labelKeys) {
            return new NoopDoubleGauge(name, description, unit, labelKeys);
        }

        NoopDoubleGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
            Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Utils.checkNotNull(description, "description");
            Utils.checkNotNull(unit, "unit");
            Utils.checkListElementNotNull((List) Utils.checkNotNull(labelKeys, "labelKeys"), "labelKey");
            this.labelKeysSize = labelKeys.size();
        }

        public NoopDoublePoint getOrCreateTimeSeries(List<LabelValue> labelValues) {
            Utils.checkListElementNotNull((List) Utils.checkNotNull(labelValues, "labelValues"), "labelValue");
            Utils.checkArgument(this.labelKeysSize == labelValues.size(), "Label Keys and Label Values don't have same size.");
            return NoopDoublePoint.INSTANCE;
        }

        public NoopDoublePoint getDefaultTimeSeries() {
            return NoopDoublePoint.INSTANCE;
        }

        public void removeTimeSeries(List<LabelValue> labelValues) {
            Utils.checkNotNull(labelValues, "labelValues");
        }

        public void clear() {
        }

        private static final class NoopDoublePoint extends DoublePoint {
            /* access modifiers changed from: private */
            public static final NoopDoublePoint INSTANCE = new NoopDoublePoint();

            private NoopDoublePoint() {
            }

            public void add(double amt) {
            }

            public void set(double val) {
            }
        }
    }
}
