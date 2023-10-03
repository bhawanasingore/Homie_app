package io.opencensus.metrics;

import io.opencensus.internal.Utils;
import io.opencensus.metrics.AutoValue_MetricOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class MetricOptions {
    public abstract Map<LabelKey, LabelValue> getConstantLabels();

    public abstract String getDescription();

    public abstract List<LabelKey> getLabelKeys();

    public abstract String getUnit();

    public static Builder builder() {
        return new AutoValue_MetricOptions.Builder().setDescription("").setUnit("1").setLabelKeys(Collections.emptyList()).setConstantLabels(Collections.emptyMap());
    }

    public static abstract class Builder {
        /* access modifiers changed from: package-private */
        public abstract MetricOptions autoBuild();

        /* access modifiers changed from: package-private */
        public abstract Map<LabelKey, LabelValue> getConstantLabels();

        /* access modifiers changed from: package-private */
        public abstract List<LabelKey> getLabelKeys();

        public abstract Builder setConstantLabels(Map<LabelKey, LabelValue> map);

        public abstract Builder setDescription(String str);

        public abstract Builder setLabelKeys(List<LabelKey> list);

        public abstract Builder setUnit(String str);

        public MetricOptions build() {
            setLabelKeys(Collections.unmodifiableList(new ArrayList(getLabelKeys())));
            setConstantLabels(Collections.unmodifiableMap(new LinkedHashMap(getConstantLabels())));
            MetricOptions options = autoBuild();
            Utils.checkListElementNotNull(options.getLabelKeys(), "labelKeys elements");
            Utils.checkMapElementNotNull(options.getConstantLabels(), "constantLabels elements");
            HashSet<String> labelKeyNamesMap = new HashSet<>();
            for (LabelKey labelKey : options.getLabelKeys()) {
                if (!labelKeyNamesMap.contains(labelKey.getKey())) {
                    labelKeyNamesMap.add(labelKey.getKey());
                } else {
                    throw new IllegalArgumentException("Invalid LabelKey in labelKeys");
                }
            }
            for (Map.Entry<LabelKey, LabelValue> constantLabel : options.getConstantLabels().entrySet()) {
                if (!labelKeyNamesMap.contains(constantLabel.getKey().getKey())) {
                    labelKeyNamesMap.add(constantLabel.getKey().getKey());
                } else {
                    throw new IllegalArgumentException("Invalid LabelKey in constantLabels");
                }
            }
            return options;
        }

        Builder() {
        }
    }

    MetricOptions() {
    }
}
