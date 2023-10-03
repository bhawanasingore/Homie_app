package io.opencensus.trace.export;

import io.opencensus.trace.export.SpanData;
import java.util.List;

final class AutoValue_SpanData_TimedEvents<T> extends SpanData.TimedEvents<T> {
    private final int droppedEventsCount;
    private final List<SpanData.TimedEvent<T>> events;

    AutoValue_SpanData_TimedEvents(List<SpanData.TimedEvent<T>> events2, int droppedEventsCount2) {
        if (events2 != null) {
            this.events = events2;
            this.droppedEventsCount = droppedEventsCount2;
            return;
        }
        throw new NullPointerException("Null events");
    }

    public List<SpanData.TimedEvent<T>> getEvents() {
        return this.events;
    }

    public int getDroppedEventsCount() {
        return this.droppedEventsCount;
    }

    public String toString() {
        return "TimedEvents{events=" + this.events + ", droppedEventsCount=" + this.droppedEventsCount + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SpanData.TimedEvents)) {
            return false;
        }
        SpanData.TimedEvents<?> that = (SpanData.TimedEvents) o;
        if (!this.events.equals(that.getEvents()) || this.droppedEventsCount != that.getDroppedEventsCount()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.events.hashCode()) * 1000003) ^ this.droppedEventsCount;
    }
}
