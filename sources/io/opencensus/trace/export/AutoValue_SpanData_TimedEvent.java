package io.opencensus.trace.export;

import io.opencensus.common.Timestamp;
import io.opencensus.trace.export.SpanData;

final class AutoValue_SpanData_TimedEvent<T> extends SpanData.TimedEvent<T> {
    private final T event;
    private final Timestamp timestamp;

    AutoValue_SpanData_TimedEvent(Timestamp timestamp2, T event2) {
        if (timestamp2 != null) {
            this.timestamp = timestamp2;
            if (event2 != null) {
                this.event = event2;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null timestamp");
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public T getEvent() {
        return this.event;
    }

    public String toString() {
        return "TimedEvent{timestamp=" + this.timestamp + ", event=" + this.event + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SpanData.TimedEvent)) {
            return false;
        }
        SpanData.TimedEvent<?> that = (SpanData.TimedEvent) o;
        if (!this.timestamp.equals(that.getTimestamp()) || !this.event.equals(that.getEvent())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.timestamp.hashCode()) * 1000003) ^ this.event.hashCode();
    }
}
