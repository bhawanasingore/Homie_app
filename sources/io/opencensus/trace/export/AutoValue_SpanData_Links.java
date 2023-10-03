package io.opencensus.trace.export;

import io.opencensus.trace.Link;
import io.opencensus.trace.export.SpanData;
import java.util.List;

final class AutoValue_SpanData_Links extends SpanData.Links {
    private final int droppedLinksCount;
    private final List<Link> links;

    AutoValue_SpanData_Links(List<Link> links2, int droppedLinksCount2) {
        if (links2 != null) {
            this.links = links2;
            this.droppedLinksCount = droppedLinksCount2;
            return;
        }
        throw new NullPointerException("Null links");
    }

    public List<Link> getLinks() {
        return this.links;
    }

    public int getDroppedLinksCount() {
        return this.droppedLinksCount;
    }

    public String toString() {
        return "Links{links=" + this.links + ", droppedLinksCount=" + this.droppedLinksCount + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SpanData.Links)) {
            return false;
        }
        SpanData.Links that = (SpanData.Links) o;
        if (!this.links.equals(that.getLinks()) || this.droppedLinksCount != that.getDroppedLinksCount()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.links.hashCode()) * 1000003) ^ this.droppedLinksCount;
    }
}
