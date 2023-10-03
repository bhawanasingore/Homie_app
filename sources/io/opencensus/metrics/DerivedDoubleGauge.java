package io.opencensus.metrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.opencensus.common.ToDoubleFunction;
import io.opencensus.internal.Utils;
import java.util.List;

public abstract class DerivedDoubleGauge {
    public abstract void clear();

    public abstract <T> void createTimeSeries(List<LabelValue> list, T t, ToDoubleFunction<T> toDoubleFunction);

    public abstract void removeTimeSeries(List<LabelValue> list);

    static DerivedDoubleGauge newNoopDerivedDoubleGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
        return NoopDerivedDoubleGauge.create(name, description, unit, labelKeys);
    }

    private static final class NoopDerivedDoubleGauge extends DerivedDoubleGauge {
        private final int labelKeysSize;

        static NoopDerivedDoubleGauge create(String name, String description, String unit, List<LabelKey> labelKeys) {
            return new NoopDerivedDoubleGauge(name, description, unit, labelKeys);
        }

        NoopDerivedDoubleGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
            Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Utils.checkNotNull(description, "description");
            Utils.checkNotNull(unit, "unit");
            Utils.checkListElementNotNull((List) Utils.checkNotNull(labelKeys, "labelKeys"), "labelKey");
            this.labelKeysSize = labelKeys.size();
        }

        public <T> void createTimeSeries(List<LabelValue> labelValues, T t, ToDoubleFunction<T> function) {
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
