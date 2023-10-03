package io.opencensus.metrics.data;

import io.opencensus.common.Timestamp;
import java.util.Map;

final class AutoValue_Exemplar extends Exemplar {
    private final Map<String, AttachmentValue> attachments;
    private final Timestamp timestamp;
    private final double value;

    AutoValue_Exemplar(double value2, Timestamp timestamp2, Map<String, AttachmentValue> attachments2) {
        this.value = value2;
        if (timestamp2 != null) {
            this.timestamp = timestamp2;
            if (attachments2 != null) {
                this.attachments = attachments2;
                return;
            }
            throw new NullPointerException("Null attachments");
        }
        throw new NullPointerException("Null timestamp");
    }

    public double getValue() {
        return this.value;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public Map<String, AttachmentValue> getAttachments() {
        return this.attachments;
    }

    public String toString() {
        return "Exemplar{value=" + this.value + ", timestamp=" + this.timestamp + ", attachments=" + this.attachments + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Exemplar)) {
            return false;
        }
        Exemplar that = (Exemplar) o;
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(that.getValue()) || !this.timestamp.equals(that.getTimestamp()) || !this.attachments.equals(that.getAttachments())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((int) (((long) (1 * 1000003)) ^ ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)))) * 1000003) ^ this.timestamp.hashCode()) * 1000003) ^ this.attachments.hashCode();
    }
}
