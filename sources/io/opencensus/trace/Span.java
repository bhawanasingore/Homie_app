package io.opencensus.trace;

import androidx.core.app.NotificationCompat;
import io.opencensus.internal.Utils;
import io.opencensus.trace.internal.BaseMessageEventUtils;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public abstract class Span {
    private static final Set<Options> DEFAULT_OPTIONS = Collections.unmodifiableSet(EnumSet.noneOf(Options.class));
    private static final Map<String, AttributeValue> EMPTY_ATTRIBUTES = Collections.emptyMap();
    private final SpanContext context;
    private final Set<Options> options;

    public enum Kind {
        SERVER,
        CLIENT
    }

    public enum Options {
        RECORD_EVENTS
    }

    public abstract void addAnnotation(Annotation annotation);

    public abstract void addAnnotation(String str, Map<String, AttributeValue> map);

    public abstract void addLink(Link link);

    public abstract void end(EndSpanOptions endSpanOptions);

    /* JADX WARNING: type inference failed for: r4v0, types: [java.util.EnumSet<io.opencensus.trace.Span$Options>, java.util.EnumSet] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected Span(io.opencensus.trace.SpanContext r3, @javax.annotation.Nullable java.util.EnumSet<io.opencensus.trace.Span.Options> r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.String r0 = "context"
            java.lang.Object r0 = io.opencensus.internal.Utils.checkNotNull(r3, r0)
            io.opencensus.trace.SpanContext r0 = (io.opencensus.trace.SpanContext) r0
            r2.context = r0
            if (r4 != 0) goto L_0x0013
            java.util.Set<io.opencensus.trace.Span$Options> r0 = DEFAULT_OPTIONS
            goto L_0x001b
        L_0x0013:
            java.util.EnumSet r0 = java.util.EnumSet.copyOf(r4)
            java.util.Set r0 = java.util.Collections.unmodifiableSet(r0)
        L_0x001b:
            r2.options = r0
            io.opencensus.trace.TraceOptions r0 = r3.getTraceOptions()
            boolean r0 = r0.isSampled()
            if (r0 == 0) goto L_0x0035
            java.util.Set<io.opencensus.trace.Span$Options> r0 = r2.options
            io.opencensus.trace.Span$Options r1 = io.opencensus.trace.Span.Options.RECORD_EVENTS
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r0 = 0
            goto L_0x0036
        L_0x0035:
            r0 = 1
        L_0x0036:
            java.lang.String r1 = "Span is sampled, but does not have RECORD_EVENTS set."
            io.opencensus.internal.Utils.checkArgument(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opencensus.trace.Span.<init>(io.opencensus.trace.SpanContext, java.util.EnumSet):void");
    }

    public void putAttribute(String key, AttributeValue value) {
        Utils.checkNotNull(key, "key");
        Utils.checkNotNull(value, "value");
        putAttributes(Collections.singletonMap(key, value));
    }

    public void putAttributes(Map<String, AttributeValue> attributes) {
        Utils.checkNotNull(attributes, "attributes");
        addAttributes(attributes);
    }

    @Deprecated
    public void addAttributes(Map<String, AttributeValue> attributes) {
        putAttributes(attributes);
    }

    public final void addAnnotation(String description) {
        Utils.checkNotNull(description, "description");
        addAnnotation(description, EMPTY_ATTRIBUTES);
    }

    @Deprecated
    public void addNetworkEvent(NetworkEvent networkEvent) {
        addMessageEvent(BaseMessageEventUtils.asMessageEvent(networkEvent));
    }

    public void addMessageEvent(MessageEvent messageEvent) {
        Utils.checkNotNull(messageEvent, "messageEvent");
        addNetworkEvent(BaseMessageEventUtils.asNetworkEvent(messageEvent));
    }

    public void setStatus(Status status) {
        Utils.checkNotNull(status, NotificationCompat.CATEGORY_STATUS);
    }

    public final void end() {
        end(EndSpanOptions.DEFAULT);
    }

    public final SpanContext getContext() {
        return this.context;
    }

    public final Set<Options> getOptions() {
        return this.options;
    }
}
