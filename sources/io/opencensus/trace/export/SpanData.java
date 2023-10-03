package io.opencensus.trace.export;

import io.opencensus.common.Timestamp;
import io.opencensus.internal.Utils;
import io.opencensus.trace.Annotation;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.BaseMessageEvent;
import io.opencensus.trace.Link;
import io.opencensus.trace.MessageEvent;
import io.opencensus.trace.NetworkEvent;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.Status;
import io.opencensus.trace.internal.BaseMessageEventUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class SpanData {
    public abstract TimedEvents<Annotation> getAnnotations();

    public abstract Attributes getAttributes();

    @Nullable
    public abstract Integer getChildSpanCount();

    public abstract SpanContext getContext();

    @Nullable
    public abstract Timestamp getEndTimestamp();

    @Nullable
    public abstract Boolean getHasRemoteParent();

    @Nullable
    public abstract Span.Kind getKind();

    public abstract Links getLinks();

    public abstract TimedEvents<MessageEvent> getMessageEvents();

    public abstract String getName();

    @Nullable
    public abstract SpanId getParentSpanId();

    public abstract Timestamp getStartTimestamp();

    @Nullable
    public abstract Status getStatus();

    @Deprecated
    public static SpanData create(SpanContext context, @Nullable SpanId parentSpanId, @Nullable Boolean hasRemoteParent, String name, Timestamp startTimestamp, Attributes attributes, TimedEvents<Annotation> annotations, TimedEvents<? extends BaseMessageEvent> messageOrNetworkEvents, Links links, @Nullable Integer childSpanCount, @Nullable Status status, @Nullable Timestamp endTimestamp) {
        return create(context, parentSpanId, hasRemoteParent, name, (Span.Kind) null, startTimestamp, attributes, annotations, messageOrNetworkEvents, links, childSpanCount, status, endTimestamp);
    }

    public static SpanData create(SpanContext context, @Nullable SpanId parentSpanId, @Nullable Boolean hasRemoteParent, String name, @Nullable Span.Kind kind, Timestamp startTimestamp, Attributes attributes, TimedEvents<Annotation> annotations, TimedEvents<? extends BaseMessageEvent> messageOrNetworkEvents, Links links, @Nullable Integer childSpanCount, @Nullable Status status, @Nullable Timestamp endTimestamp) {
        Utils.checkNotNull(messageOrNetworkEvents, "messageOrNetworkEvents");
        List<TimedEvent<MessageEvent>> messageEventsList = new ArrayList<>();
        for (TimedEvent<? extends BaseMessageEvent> timedEvent : messageOrNetworkEvents.getEvents()) {
            BaseMessageEvent event = (BaseMessageEvent) timedEvent.getEvent();
            if (event instanceof MessageEvent) {
                messageEventsList.add(timedEvent);
            } else {
                messageEventsList.add(TimedEvent.create(timedEvent.getTimestamp(), BaseMessageEventUtils.asMessageEvent(event)));
            }
        }
        return new AutoValue_SpanData(context, parentSpanId, hasRemoteParent, name, kind, startTimestamp, attributes, annotations, TimedEvents.create(messageEventsList, messageOrNetworkEvents.getDroppedEventsCount()), links, childSpanCount, status, endTimestamp);
    }

    @Deprecated
    public TimedEvents<NetworkEvent> getNetworkEvents() {
        TimedEvents<MessageEvent> timedEvents = getMessageEvents();
        List<TimedEvent<NetworkEvent>> networkEventsList = new ArrayList<>();
        for (TimedEvent<MessageEvent> timedEvent : timedEvents.getEvents()) {
            networkEventsList.add(TimedEvent.create(timedEvent.getTimestamp(), BaseMessageEventUtils.asNetworkEvent(timedEvent.getEvent())));
        }
        return TimedEvents.create(networkEventsList, timedEvents.getDroppedEventsCount());
    }

    SpanData() {
    }

    public static abstract class TimedEvent<T> {
        public abstract T getEvent();

        public abstract Timestamp getTimestamp();

        public static <T> TimedEvent<T> create(Timestamp timestamp, T event) {
            return new AutoValue_SpanData_TimedEvent(timestamp, event);
        }

        TimedEvent() {
        }
    }

    public static abstract class TimedEvents<T> {
        public abstract int getDroppedEventsCount();

        public abstract List<TimedEvent<T>> getEvents();

        public static <T> TimedEvents<T> create(List<TimedEvent<T>> events, int droppedEventsCount) {
            return new AutoValue_SpanData_TimedEvents(Collections.unmodifiableList(new ArrayList((Collection) Utils.checkNotNull(events, "events"))), droppedEventsCount);
        }

        TimedEvents() {
        }
    }

    public static abstract class Attributes {
        public abstract Map<String, AttributeValue> getAttributeMap();

        public abstract int getDroppedAttributesCount();

        public static Attributes create(Map<String, AttributeValue> attributeMap, int droppedAttributesCount) {
            return new AutoValue_SpanData_Attributes(Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(attributeMap, "attributeMap"))), droppedAttributesCount);
        }

        Attributes() {
        }
    }

    public static abstract class Links {
        public abstract int getDroppedLinksCount();

        public abstract List<Link> getLinks();

        public static Links create(List<Link> links, int droppedLinksCount) {
            return new AutoValue_SpanData_Links(Collections.unmodifiableList(new ArrayList((Collection) Utils.checkNotNull(links, "links"))), droppedLinksCount);
        }

        Links() {
        }
    }
}
