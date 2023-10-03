package io.opencensus.metrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.opencensus.internal.Utils;
import java.util.List;

public abstract class MetricRegistry {
    public abstract DerivedDoubleCumulative addDerivedDoubleCumulative(String str, MetricOptions metricOptions);

    public abstract DerivedDoubleGauge addDerivedDoubleGauge(String str, MetricOptions metricOptions);

    public abstract DerivedLongCumulative addDerivedLongCumulative(String str, MetricOptions metricOptions);

    public abstract DerivedLongGauge addDerivedLongGauge(String str, MetricOptions metricOptions);

    public abstract DoubleCumulative addDoubleCumulative(String str, MetricOptions metricOptions);

    public abstract DoubleGauge addDoubleGauge(String str, MetricOptions metricOptions);

    public abstract LongCumulative addLongCumulative(String str, MetricOptions metricOptions);

    public abstract LongGauge addLongGauge(String str, MetricOptions metricOptions);

    @Deprecated
    public LongGauge addLongGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
        return addLongGauge(name, MetricOptions.builder().setDescription(description).setUnit(unit).setLabelKeys(labelKeys).build());
    }

    @Deprecated
    public DoubleGauge addDoubleGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
        return addDoubleGauge(name, MetricOptions.builder().setDescription(description).setUnit(unit).setLabelKeys(labelKeys).build());
    }

    @Deprecated
    public DerivedLongGauge addDerivedLongGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
        return addDerivedLongGauge(name, MetricOptions.builder().setDescription(description).setUnit(unit).setLabelKeys(labelKeys).build());
    }

    @Deprecated
    public DerivedDoubleGauge addDerivedDoubleGauge(String name, String description, String unit, List<LabelKey> labelKeys) {
        return addDerivedDoubleGauge(name, MetricOptions.builder().setDescription(description).setUnit(unit).setLabelKeys(labelKeys).build());
    }

    static MetricRegistry newNoopMetricRegistry() {
        return new NoopMetricRegistry();
    }

    private static final class NoopMetricRegistry extends MetricRegistry {
        private NoopMetricRegistry() {
        }

        public LongGauge addLongGauge(String name, MetricOptions options) {
            return LongGauge.newNoopLongGauge((String) Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME), options.getDescription(), options.getUnit(), options.getLabelKeys());
        }

        public DoubleGauge addDoubleGauge(String name, MetricOptions options) {
            return DoubleGauge.newNoopDoubleGauge((String) Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME), options.getDescription(), options.getUnit(), options.getLabelKeys());
        }

        public DerivedLongGauge addDerivedLongGauge(String name, MetricOptions options) {
            return DerivedLongGauge.newNoopDerivedLongGauge((String) Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME), options.getDescription(), options.getUnit(), options.getLabelKeys());
        }

        public DerivedDoubleGauge addDerivedDoubleGauge(String name, MetricOptions options) {
            return DerivedDoubleGauge.newNoopDerivedDoubleGauge((String) Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME), options.getDescription(), options.getUnit(), options.getLabelKeys());
        }

        public LongCumulative addLongCumulative(String name, MetricOptions options) {
            return LongCumulative.newNoopLongCumulative((String) Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME), options.getDescription(), options.getUnit(), options.getLabelKeys());
        }

        public DoubleCumulative addDoubleCumulative(String name, MetricOptions options) {
            return DoubleCumulative.newNoopDoubleCumulative((String) Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME), options.getDescription(), options.getUnit(), options.getLabelKeys());
        }

        public DerivedLongCumulative addDerivedLongCumulative(String name, MetricOptions options) {
            return DerivedLongCumulative.newNoopDerivedLongCumulative((String) Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME), options.getDescription(), options.getUnit(), options.getLabelKeys());
        }

        public DerivedDoubleCumulative addDerivedDoubleCumulative(String name, MetricOptions options) {
            return DerivedDoubleCumulative.newNoopDerivedDoubleCumulative((String) Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME), options.getDescription(), options.getUnit(), options.getLabelKeys());
        }
    }
}
