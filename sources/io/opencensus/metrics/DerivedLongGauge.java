package io.opencensus.metrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.opencensus.common.ToLongFunction;
import io.opencensus.internal.Utils;
import java.util.List;

public abstract class DerivedLongGauge {
    public abstract void clear();

    public abstract <T> void createTimeSeries(List<LabelValue> list, T t, ToLongFunction<T> toLongFunction);

    public abstract void removeTimeSeries(List<LabelValue> list);

    static DerivedLongGauge newNoopDerivedLongGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
        return NoopDerivedLongGauge.create(name, description, unit, labelKeys);
    }

    private static final class NoopDerivedLongGauge extends DerivedLongGauge {
        private final int labelKeysSize;

        static NoopDerivedLongGauge create(String name, String description, String unit, List<LabelKey> labelKeys) {
            return new NoopDerivedLongGauge(name, description, unit, labelKeys);
        }

        NoopDerivedLongGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
            Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Utils.checkNotNull(description, "description");
            Utils.checkNotNull(unit, "unit");
            Utils.checkListElementNotNull((List) Utils.checkNotNull(labelKeys, "labelKeys"), "labelKey");
            this.labelKeysSize = labelKeys.size();
        }

        public <T> void createTimeSeries(List<LabelValue> labelValues, T t, ToLongFunction<T> function) {
            Utils.checkListElementNotNull((List) Utils.checkNotNull(labelValues, "labelValues"), "labelValue");
            Utils.checkArgument(this.labelKeysSize == labelValues.size(), "Label Keys and Label Values don't have same size.");
            Utils.checkNotNull(function, "function");
        }

        public void removeTimeSeries(List<LabelValue> labelValues) {
            Utils.checkNotNull(labelValues, "labelValues");
        }

        public void clear() {
        }
    }
}
