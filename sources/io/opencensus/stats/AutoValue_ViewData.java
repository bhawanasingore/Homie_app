package io.opencensus.stats;

import io.opencensus.common.Timestamp;
import io.opencensus.stats.ViewData;
import io.opencensus.tags.TagValue;
import java.util.List;
import java.util.Map;

final class AutoValue_ViewData extends ViewData {
    private final Map<List<TagValue>, AggregationData> aggregationMap;
    private final Timestamp end;
    private final Timestamp start;
    private final View view;
    private final ViewData.AggregationWindowData windowData;

    AutoValue_ViewData(View view2, Map<List<TagValue>, AggregationData> aggregationMap2, ViewData.AggregationWindowData windowData2, Timestamp start2, Timestamp end2) {
        if (view2 != null) {
            this.view = view2;
            if (aggregationMap2 != null) {
                this.aggregationMap = aggregationMap2;
                if (windowData2 != null) {
                    this.windowData = windowData2;
                    if (start2 != null) {
                        this.start = start2;
                        if (end2 != null) {
                            this.end = end2;
                            return;
                        }
                        throw new NullPointerException("Null end");
                    }
                    throw new NullPointerException("Null start");
                }
                throw new NullPointerException("Null windowData");
            }
            throw new NullPointerException("Null aggregationMap");
        }
        throw new NullPointerException("Null view");
    }

    public View getView() {
        return this.view;
    }

    public Map<List<TagValue>, AggregationData> getAggregationMap() {
        return this.aggregationMap;
    }

    @Deprecated
    public ViewData.AggregationWindowData getWindowData() {
        return this.windowData;
    }

    public Timestamp getStart() {
        return this.start;
    }

    public Timestamp getEnd() {
        return this.end;
    }

    public String toString() {
        return "ViewData{view=" + this.view + ", aggregationMap=" + this.aggregationMap + ", windowData=" + this.windowData + ", start=" + this.start + ", end=" + this.end + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ViewData)) {
            return false;
        }
        ViewData that = (ViewData) o;
        if (!this.view.equals(that.getView()) || !this.aggregationMap.equals(that.getAggregationMap()) || !this.windowData.equals(that.getWindowData()) || !this.start.equals(that.getStart()) || !this.end.equals(that.getEnd())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((1 * 1000003) ^ this.view.hashCode()) * 1000003) ^ this.aggregationMap.hashCode()) * 1000003) ^ this.windowData.hashCode()) * 1000003) ^ this.start.hashCode()) * 1000003) ^ this.end.hashCode();
    }
}
