package io.opencensus.trace.export;

import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.export.SpanData;
import java.util.Map;

final class AutoValue_SpanData_Attributes extends SpanData.Attributes {
    private final Map<String, AttributeValue> attributeMap;
    private final int droppedAttributesCount;

    AutoValue_SpanData_Attributes(Map<String, AttributeValue> attributeMap2, int droppedAttributesCount2) {
        if (attributeMap2 != null) {
            this.attributeMap = attributeMap2;
            this.droppedAttributesCount = droppedAttributesCount2;
            return;
        }
        throw new NullPointerException("Null attributeMap");
    }

    public Map<String, AttributeValue> getAttributeMap() {
        return this.attributeMap;
    }

    public int getDroppedAttributesCount() {
        return this.droppedAttributesCount;
    }

    public String toString() {
        return "Attributes{attributeMap=" + this.attributeMap + ", droppedAttributesCount=" + this.droppedAttributesCount + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SpanData.Attributes)) {
            return false;
        }
        SpanData.Attributes that = (SpanData.Attributes) o;
        if (!this.attributeMap.equals(that.getAttributeMap()) || this.droppedAttributesCount != that.getDroppedAttributesCount()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.attributeMap.hashCode()) * 1000003) ^ this.droppedAttributesCount;
    }
}
