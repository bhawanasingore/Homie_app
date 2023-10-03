package io.opencensus.metrics;

import io.opencensus.metrics.MetricOptions;
import java.util.List;
import java.util.Map;

final class AutoValue_MetricOptions extends MetricOptions {
    private final Map<LabelKey, LabelValue> constantLabels;
    private final String description;
    private final List<LabelKey> labelKeys;
    private final String unit;

    private AutoValue_MetricOptions(String description2, String unit2, List<LabelKey> labelKeys2, Map<LabelKey, LabelValue> constantLabels2) {
        this.description = description2;
        this.unit = unit2;
        this.labelKeys = labelKeys2;
        this.constantLabels = constantLabels2;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUnit() {
        return this.unit;
    }

    public List<LabelKey> getLabelKeys() {
        return this.labelKeys;
    }

    public Map<LabelKey, LabelValue> getConstantLabels() {
        return this.constantLabels;
    }

    public String toString() {
        return "MetricOptions{description=" + this.description + ", unit=" + this.unit + ", labelKeys=" + this.labelKeys + ", constantLabels=" + this.constantLabels + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MetricOptions)) {
            return false;
        }
        MetricOptions that = (MetricOptions) o;
        if (!this.description.equals(that.getDescription()) || !this.unit.equals(that.getUnit()) || !this.labelKeys.equals(that.getLabelKeys()) || !this.constantLabels.equals(that.getConstantLabels())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((1 * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.unit.hashCode()) * 1000003) ^ this.labelKeys.hashCode()) * 1000003) ^ this.constantLabels.hashCode();
    }

    static final class Builder extends MetricOptions.Builder {
        private Map<LabelKey, LabelValue> constantLabels;
        private String description;
        private List<LabelKey> labelKeys;
        private String unit;

        Builder() {
        }

        public MetricOptions.Builder setDescription(String description2) {
            if (description2 != null) {
                this.description = description2;
                return this;
            }
            throw new NullPointerException("Null description");
        }

        public MetricOptions.Builder setUnit(String unit2) {
            if (unit2 != null) {
                this.unit = unit2;
                return this;
            }
            throw new NullPointerException("Null unit");
        }

        public MetricOptions.Builder setLabelKeys(List<LabelKey> labelKeys2) {
            if (labelKeys2 != null) {
                this.labelKeys = labelKeys2;
                return this;
            }
            throw new NullPointerException("Null labelKeys");
        }

        /* access modifiers changed from: package-private */
        public List<LabelKey> getLabelKeys() {
            List<LabelKey> list = this.labelKeys;
            if (list != null) {
                return list;
            }
            throw new IllegalStateException("Property \"labelKeys\" has not been set");
        }

        public MetricOptions.Builder setConstantLabels(Map<LabelKey, LabelValue> constantLabels2) {
            if (constantLabels2 != null) {
                this.constantLabels = constantLabels2;
                return this;
            }
            throw new NullPointerException("Null constantLabels");
        }

        /* access modifiers changed from: package-private */
        public Map<LabelKey, LabelValue> getConstantLabels() {
            Map<LabelKey, LabelValue> map = this.constantLabels;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"constantLabels\" has not been set");
        }

        /* access modifiers changed from: package-private */
        public MetricOptions autoBuild() {
            String missing = "";
            if (this.description == null) {
                missing = missing + " description";
            }
            if (this.unit == null) {
                missing = missing + " unit";
            }
            if (this.labelKeys == null) {
                missing = missing + " labelKeys";
            }
            if (this.constantLabels == null) {
                missing = missing + " constantLabels";
            }
            if (missing.isEmpty()) {
                return new AutoValue_MetricOptions(this.description, this.unit, this.labelKeys, this.constantLabels);
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
