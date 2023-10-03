package io.opencensus.metrics.data;

import io.opencensus.common.Timestamp;
import io.opencensus.internal.Utils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Exemplar {
    public abstract Map<String, AttachmentValue> getAttachments();

    public abstract Timestamp getTimestamp();

    public abstract double getValue();

    Exemplar() {
    }

    public static Exemplar create(double value, Timestamp timestamp, Map<String, AttachmentValue> attachments) {
        Utils.checkNotNull(attachments, "attachments");
        Map<String, AttachmentValue> attachmentsCopy = Collections.unmodifiableMap(new HashMap(attachments));
        for (Map.Entry<String, AttachmentValue> entry : attachmentsCopy.entrySet()) {
            Utils.checkNotNull(entry.getKey(), "key of attachments");
            Utils.checkNotNull(entry.getValue(), "value of attachments");
        }
        return new AutoValue_Exemplar(value, timestamp, attachmentsCopy);
    }
}
