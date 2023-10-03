package io.opencensus.metrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.opencensus.common.ToLongFunction;
import io.opencensus.internal.Utils;
import java.util.List;

public abstract class DerivedLongCumulative {
    public abstract void clear();

    public abstract <T> void createTimeSeries(List<LabelValue> list, T t, ToLongFunction<T> toLongFunction);

    public abstract void removeTimeSeries(List<LabelValue> list);

    static DerivedLongCumulative newNoopDerivedLongCumulative(String name, String description, String unit, List<LabelKey> labelKeys) {
        return NoopDerivedLongCumulative.create(name, description, unit, labelKeys);
    }

    private static final class NoopDerivedLongCumulative extends DerivedLongCumulative {
        private final int labelKeysSize;

        static NoopDerivedLongCumulative create(String name, String description, String unit, List<LabelKey> labelKeys) {
            return new NoopDerivedLongCumulative(name, description, unit, labelKeys);
        }

        NoopDerivedLongCumulative(String name, String description, String unit, List<LabelKey> labelKeys) {
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
