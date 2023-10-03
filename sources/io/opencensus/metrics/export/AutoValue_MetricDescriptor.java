package io.opencensus.metrics.export;

import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.export.MetricDescriptor;
import java.util.List;

final class AutoValue_MetricDescriptor extends MetricDescriptor {
    private final String description;
    private final List<LabelKey> labelKeys;
    private final String name;
    private final MetricDescriptor.Type type;
    private final String unit;

    AutoValue_MetricDescriptor(String name2, String description2, String unit2, MetricDescriptor.Type type2, List<LabelKey> labelKeys2) {
        if (name2 != null) {
            this.name = name2;
            if (description2 != null) {
                this.description = description2;
                if (unit2 != null) {
                    this.unit = unit2;
                    if (type2 != null) {
                        this.type = type2;
                        if (labelKeys2 != null) {
                            this.labelKeys = labelKeys2;
                            return;
                        }
                        throw new NullPointerException("Null labelKeys");
                    }
                    throw new NullPointerException("Null type");
                }
                throw new NullPointerException("Null unit");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null name");
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUnit() {
        return this.unit;
    }

    public MetricDescriptor.Type getType() {
        return this.type;
    }

    public List<LabelKey> getLabelKeys() {
        return this.labelKeys;
    }

    public String toString() {
        return "MetricDescriptor{name=" + this.name + ", description=" + this.description + ", unit=" + this.unit + ", type=" + this.type + ", labelKeys=" + this.labelKeys + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MetricDescriptor)) {
            return false;
        }
        MetricDescriptor that = (MetricDescriptor) o;
        if (!this.name.equals(that.getName()) || !this.description.equals(that.getDescription()) || !this.unit.equals(that.getUnit()) || !this.type.equals(that.getType()) || !this.labelKeys.equals(that.getLabelKeys())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((1 * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.unit.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.labelKeys.hashCode();
    }
}
