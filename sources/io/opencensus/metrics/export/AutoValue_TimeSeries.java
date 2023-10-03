package io.opencensus.metrics.export;

import io.opencensus.common.Timestamp;
import io.opencensus.metrics.LabelValue;
import java.util.List;
import javax.annotation.Nullable;

final class AutoValue_TimeSeries extends TimeSeries {
    private final List<LabelValue> labelValues;
    private final List<Point> points;
    private final Timestamp startTimestamp;

    AutoValue_TimeSeries(List<LabelValue> labelValues2, List<Point> points2, @Nullable Timestamp startTimestamp2) {
        if (labelValues2 != null) {
            this.labelValues = labelValues2;
            if (points2 != null) {
                this.points = points2;
                this.startTimestamp = startTimestamp2;
                return;
            }
            throw new NullPointerException("Null points");
        }
        throw new NullPointerException("Null labelValues");
    }

    public List<LabelValue> getLabelValues() {
        return this.labelValues;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    @Nullable
    public Timestamp getStartTimestamp() {
        return this.startTimestamp;
    }

    public String toString() {
        return "TimeSeries{labelValues=" + this.labelValues + ", points=" + this.points + ", startTimestamp=" + this.startTimestamp + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TimeSeries)) {
            return false;
        }
        TimeSeries that = (TimeSeries) o;
        if (this.labelValues.equals(that.getLabelValues()) && this.points.equals(that.getPoints())) {
            Timestamp timestamp = this.startTimestamp;
            if (timestamp == null) {
                if (that.getStartTimestamp() == null) {
                    return true;
                }
            } else if (timestamp.equals(that.getStartTimestamp())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int h = ((((1 * 1000003) ^ this.labelValues.hashCode()) * 1000003) ^ this.points.hashCode()) * 1000003;
        Timestamp timestamp = this.startTimestamp;
        return h ^ (timestamp == null ? 0 : timestamp.hashCode());
    }
}
