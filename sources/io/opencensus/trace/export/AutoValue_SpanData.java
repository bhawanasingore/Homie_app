package io.opencensus.trace.export;

import io.opencensus.common.Timestamp;
import io.opencensus.trace.Annotation;
import io.opencensus.trace.MessageEvent;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.Status;
import io.opencensus.trace.export.SpanData;
import javax.annotation.Nullable;

final class AutoValue_SpanData extends SpanData {
    private final SpanData.TimedEvents<Annotation> annotations;
    private final SpanData.Attributes attributes;
    private final Integer childSpanCount;
    private final SpanContext context;
    private final Timestamp endTimestamp;
    private final Boolean hasRemoteParent;
    private final Span.Kind kind;
    private final SpanData.Links links;
    private final SpanData.TimedEvents<MessageEvent> messageEvents;
    private final String name;
    private final SpanId parentSpanId;
    private final Timestamp startTimestamp;
    private final Status status;

    AutoValue_SpanData(SpanContext context2, @Nullable SpanId parentSpanId2, @Nullable Boolean hasRemoteParent2, String name2, @Nullable Span.Kind kind2, Timestamp startTimestamp2, SpanData.Attributes attributes2, SpanData.TimedEvents<Annotation> annotations2, SpanData.TimedEvents<MessageEvent> messageEvents2, SpanData.Links links2, @Nullable Integer childSpanCount2, @Nullable Status status2, @Nullable Timestamp endTimestamp2) {
        if (context2 != null) {
            this.context = context2;
            this.parentSpanId = parentSpanId2;
            this.hasRemoteParent = hasRemoteParent2;
            if (name2 != null) {
                this.name = name2;
                this.kind = kind2;
                if (startTimestamp2 != null) {
                    this.startTimestamp = startTimestamp2;
                    if (attributes2 != null) {
                        this.attributes = attributes2;
                        if (annotations2 != null) {
                            this.annotations = annotations2;
                            if (messageEvents2 != null) {
                                this.messageEvents = messageEvents2;
                                if (links2 != null) {
                                    this.links = links2;
                                    this.childSpanCount = childSpanCount2;
                                    this.status = status2;
                                    this.endTimestamp = endTimestamp2;
                                    return;
                                }
                                throw new NullPointerException("Null links");
                            }
                            throw new NullPointerException("Null messageEvents");
                        }
                        throw new NullPointerException("Null annotations");
                    }
                    throw new NullPointerException("Null attributes");
                }
                throw new NullPointerException("Null startTimestamp");
            }
            throw new NullPointerException("Null name");
        }
        throw new NullPointerException("Null context");
    }

    public SpanContext getContext() {
        return this.context;
    }

    @Nullable
    public SpanId getParentSpanId() {
        return this.parentSpanId;
    }

    @Nullable
    public Boolean getHasRemoteParent() {
        return this.hasRemoteParent;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public Span.Kind getKind() {
        return this.kind;
    }

    public Timestamp getStartTimestamp() {
        return this.startTimestamp;
    }

    public SpanData.Attributes getAttributes() {
        return this.attributes;
    }

    public SpanData.TimedEvents<Annotation> getAnnotations() {
        return this.annotations;
    }

    public SpanData.TimedEvents<MessageEvent> getMessageEvents() {
        return this.messageEvents;
    }

    public SpanData.Links getLinks() {
        return this.links;
    }

    @Nullable
    public Integer getChildSpanCount() {
        return this.childSpanCount;
    }

    @Nullable
    public Status getStatus() {
        return this.status;
    }

    @Nullable
    public Timestamp getEndTimestamp() {
        return this.endTimestamp;
    }

    public String toString() {
        return "SpanData{context=" + this.context + ", parentSpanId=" + this.parentSpanId + ", hasRemoteParent=" + this.hasRemoteParent + ", name=" + this.name + ", kind=" + this.kind + ", startTimestamp=" + this.startTimestamp + ", attributes=" + this.attributes + ", annotations=" + this.annotations + ", messageEvents=" + this.messageEvents + ", links=" + this.links + ", childSpanCount=" + this.childSpanCount + ", status=" + this.status + ", endTimestamp=" + this.endTimestamp + "}";
    }

    public boolean equals(Object o) {
        SpanId spanId;
        Boolean bool;
        Span.Kind kind2;
        Integer num;
        Status status2;
        if (o == this) {
            return true;
        }
        if (!(o instanceof SpanData)) {
            return false;
        }
        SpanData that = (SpanData) o;
        if (this.context.equals(that.getContext()) && ((spanId = this.parentSpanId) != null ? spanId.equals(that.getParentSpanId()) : that.getParentSpanId() == null) && ((bool = this.hasRemoteParent) != null ? bool.equals(that.getHasRemoteParent()) : that.getHasRemoteParent() == null) && this.name.equals(that.getName()) && ((kind2 = this.kind) != null ? kind2.equals(that.getKind()) : that.getKind() == null) && this.startTimestamp.equals(that.getStartTimestamp()) && this.attributes.equals(that.getAttributes()) && this.annotations.equals(that.getAnnotations()) && this.messageEvents.equals(that.getMessageEvents()) && this.links.equals(that.getLinks()) && ((num = this.childSpanCount) != null ? num.equals(that.getChildSpanCount()) : that.getChildSpanCount() == null) && ((status2 = this.status) != null ? status2.equals(that.getStatus()) : that.getStatus() == null)) {
            Timestamp timestamp = this.endTimestamp;
            if (timestamp == null) {
                if (that.getEndTimestamp() == null) {
                    return true;
                }
            } else if (timestamp.equals(that.getEndTimestamp())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int h = ((1 * 1000003) ^ this.context.hashCode()) * 1000003;
        SpanId spanId = this.parentSpanId;
        int i = 0;
        int h2 = (h ^ (spanId == null ? 0 : spanId.hashCode())) * 1000003;
        Boolean bool = this.hasRemoteParent;
        int h3 = (((h2 ^ (bool == null ? 0 : bool.hashCode())) * 1000003) ^ this.name.hashCode()) * 1000003;
        Span.Kind kind2 = this.kind;
        int h4 = (((((((((((h3 ^ (kind2 == null ? 0 : kind2.hashCode())) * 1000003) ^ this.startTimestamp.hashCode()) * 1000003) ^ this.attributes.hashCode()) * 1000003) ^ this.annotations.hashCode()) * 1000003) ^ this.messageEvents.hashCode()) * 1000003) ^ this.links.hashCode()) * 1000003;
        Integer num = this.childSpanCount;
        int h5 = (h4 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Status status2 = this.status;
        int h6 = (h5 ^ (status2 == null ? 0 : status2.hashCode())) * 1000003;
        Timestamp timestamp = this.endTimestamp;
        if (timestamp != null) {
            i = timestamp.hashCode();
        }
        return h6 ^ i;
    }
}
