package io.opencensus.stats;

import io.opencensus.stats.View;
import io.opencensus.tags.TagKey;
import java.util.List;

final class AutoValue_View extends View {
    private final Aggregation aggregation;
    private final List<TagKey> columns;
    private final String description;
    private final Measure measure;
    private final View.Name name;
    private final View.AggregationWindow window;

    AutoValue_View(View.Name name2, String description2, Measure measure2, Aggregation aggregation2, List<TagKey> columns2, View.AggregationWindow window2) {
        if (name2 != null) {
            this.name = name2;
            if (description2 != null) {
                this.description = description2;
                if (measure2 != null) {
                    this.measure = measure2;
                    if (aggregation2 != null) {
                        this.aggregation = aggregation2;
                        if (columns2 != null) {
                            this.columns = columns2;
                            if (window2 != null) {
                                this.window = window2;
                                return;
                            }
                            throw new NullPointerException("Null window");
                        }
                        throw new NullPointerException("Null columns");
                    }
                    throw new NullPointerException("Null aggregation");
                }
                throw new NullPointerException("Null measure");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null name");
    }

    public View.Name getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Measure getMeasure() {
        return this.measure;
    }

    public Aggregation getAggregation() {
        return this.aggregation;
    }

    public List<TagKey> getColumns() {
        return this.columns;
    }

    @Deprecated
    public View.AggregationWindow getWindow() {
        return this.window;
    }

    public String toString() {
        return "View{name=" + this.name + ", description=" + this.description + ", measure=" + this.measure + ", aggregation=" + this.aggregation + ", columns=" + this.columns + ", window=" + this.window + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof View)) {
            return false;
        }
        View that = (View) o;
        if (!this.name.equals(that.getName()) || !this.description.equals(that.getDescription()) || !this.measure.equals(that.getMeasure()) || !this.aggregation.equals(that.getAggregation()) || !this.columns.equals(that.getColumns()) || !this.window.equals(that.getWindow())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((1 * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.measure.hashCode()) * 1000003) ^ this.aggregation.hashCode()) * 1000003) ^ this.columns.hashCode()) * 1000003) ^ this.window.hashCode();
    }
}
