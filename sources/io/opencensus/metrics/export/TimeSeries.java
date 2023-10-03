package io.opencensus.metrics.export;

import io.opencensus.common.Timestamp;
import io.opencensus.internal.Utils;
import io.opencensus.metrics.LabelValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public abstract class TimeSeries {
    public abstract List<LabelValue> getLabelValues();

    public abstract List<Point> getPoints();

    @Nullable
    public abstract Timestamp getStartTimestamp();

    TimeSeries() {
    }

    public static TimeSeries create(List<LabelValue> labelValues, List<Point> points, @Nullable Timestamp startTimestamp) {
        Utils.checkListElementNotNull((List) Utils.checkNotNull(points, "points"), "point");
        return createInternal(labelValues, Collections.unmodifiableList(new ArrayList(points)), startTimestamp);
    }

    public static TimeSeries create(List<LabelValue> labelValues) {
        return createInternal(labelValues, Collections.emptyList(), (Timestamp) null);
    }

    public static TimeSeries createWithOnePoint(List<LabelValue> labelValues, Point point, @Nullable Timestamp startTimestamp) {
        Utils.checkNotNull(point, "point");
        return createInternal(labelValues, Collections.singletonList(point), startTimestamp);
    }

    public TimeSeries setPoint(Point point) {
        Utils.checkNotNull(point, "point");
        return new AutoValue_TimeSeries(getLabelValues(), Collections.singletonList(point), (Timestamp) null);
    }

    private static TimeSeries createInternal(List<LabelValue> labelValues, List<Point> points, @Nullable Timestamp startTimestamp) {
        Utils.checkListElementNotNull((List) Utils.checkNotNull(labelValues, "labelValues"), "labelValue");
        return new AutoValue_TimeSeries(Collections.unmodifiableList(new ArrayList(labelValues)), points, startTimestamp);
    }
}
