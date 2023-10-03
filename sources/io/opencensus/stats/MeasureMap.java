package io.opencensus.stats;

import io.opencensus.internal.Utils;
import io.opencensus.metrics.data.AttachmentValue;
import io.opencensus.stats.Measure;
import io.opencensus.tags.TagContext;

public abstract class MeasureMap {
    public abstract MeasureMap put(Measure.MeasureDouble measureDouble, double d);

    public abstract MeasureMap put(Measure.MeasureLong measureLong, long j);

    public abstract void record();

    public abstract void record(TagContext tagContext);

    @Deprecated
    public MeasureMap putAttachment(String key, String value) {
        return putAttachment(key, (AttachmentValue) AttachmentValue.AttachmentValueString.create(value));
    }

    public MeasureMap putAttachment(String key, AttachmentValue value) {
        Utils.checkNotNull(key, "key");
        Utils.checkNotNull(value, "value");
        return this;
    }
}
