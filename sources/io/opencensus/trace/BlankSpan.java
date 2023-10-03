package io.opencensus.trace;

import androidx.core.app.NotificationCompat;
import io.opencensus.internal.Utils;
import io.opencensus.trace.Span;
import java.util.EnumSet;
import java.util.Map;

public final class BlankSpan extends Span {
    public static final BlankSpan INSTANCE = new BlankSpan();

    private BlankSpan() {
        super(SpanContext.INVALID, (EnumSet<Span.Options>) null);
    }

    public void putAttribute(String key, AttributeValue value) {
        Utils.checkNotNull(key, "key");
        Utils.checkNotNull(value, "value");
    }

    public void putAttributes(Map<String, AttributeValue> attributes) {
        Utils.checkNotNull(attributes, "attributes");
    }

    public void addAnnotation(String description, Map<String, AttributeValue> attributes) {
        Utils.checkNotNull(description, "description");
        Utils.checkNotNull(attributes, "attributes");
    }

    public void addAnnotation(Annotation annotation) {
        Utils.checkNotNull(annotation, "annotation");
    }

    @Deprecated
    public void addNetworkEvent(NetworkEvent networkEvent) {
    }

    public void addMessageEvent(MessageEvent messageEvent) {
        Utils.checkNotNull(messageEvent, "messageEvent");
    }

    public void addLink(Link link) {
        Utils.checkNotNull(link, "link");
    }

    public void setStatus(Status status) {
        Utils.checkNotNull(status, NotificationCompat.CATEGORY_STATUS);
    }

    public void end(EndSpanOptions options) {
        Utils.checkNotNull(options, "options");
    }

    public String toString() {
        return "BlankSpan";
    }
}
