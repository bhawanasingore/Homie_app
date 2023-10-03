package io.opencensus.stats;

import io.opencensus.stats.Measure;

final class AutoValue_Measure_MeasureDouble extends Measure.MeasureDouble {
    private final String description;
    private final String name;
    private final String unit;

    AutoValue_Measure_MeasureDouble(String name2, String description2, String unit2) {
        if (name2 != null) {
            this.name = name2;
            if (description2 != null) {
                this.description = description2;
                if (unit2 != null) {
                    this.unit = unit2;
                    return;
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

    public String toString() {
        return "MeasureDouble{name=" + this.name + ", description=" + this.description + ", unit=" + this.unit + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Measure.MeasureDouble)) {
            return false;
        }
        Measure.MeasureDouble that = (Measure.MeasureDouble) o;
        if (!this.name.equals(that.getName()) || !this.description.equals(that.getDescription()) || !this.unit.equals(that.getUnit())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((1 * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.unit.hashCode();
    }
}
