package io.opencensus.trace;

import io.opencensus.trace.MessageEvent;

final class AutoValue_MessageEvent extends MessageEvent {
    private final long compressedMessageSize;
    private final long messageId;
    private final MessageEvent.Type type;
    private final long uncompressedMessageSize;

    private AutoValue_MessageEvent(MessageEvent.Type type2, long messageId2, long uncompressedMessageSize2, long compressedMessageSize2) {
        this.type = type2;
        this.messageId = messageId2;
        this.uncompressedMessageSize = uncompressedMessageSize2;
        this.compressedMessageSize = compressedMessageSize2;
    }

    public MessageEvent.Type getType() {
        return this.type;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public long getUncompressedMessageSize() {
        return this.uncompressedMessageSize;
    }

    public long getCompressedMessageSize() {
        return this.compressedMessageSize;
    }

    public String toString() {
        return "MessageEvent{type=" + this.type + ", messageId=" + this.messageId + ", uncompressedMessageSize=" + this.uncompressedMessageSize + ", compressedMessageSize=" + this.compressedMessageSize + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MessageEvent)) {
            return false;
        }
        MessageEvent that = (MessageEvent) o;
        if (this.type.equals(that.getType()) && this.messageId == that.getMessageId() && this.uncompressedMessageSize == that.getUncompressedMessageSize() && this.compressedMessageSize == that.getCompressedMessageSize()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.messageId;
        long j2 = this.uncompressedMessageSize;
        long j3 = this.compressedMessageSize;
        return (int) (((long) (((int) (((long) (((int) (((long) (((1 * 1000003) ^ this.type.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003)) ^ (j3 ^ (j3 >>> 32)));
    }

    static final class Builder extends MessageEvent.Builder {
        private Long compressedMessageSize;
        private Long messageId;
        private MessageEvent.Type type;
        private Long uncompressedMessageSize;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public MessageEvent.Builder setType(MessageEvent.Type type2) {
            if (type2 != null) {
                this.type = type2;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        /* access modifiers changed from: package-private */
        public MessageEvent.Builder setMessageId(long messageId2) {
            this.messageId = Long.valueOf(messageId2);
            return this;
        }

        public MessageEvent.Builder setUncompressedMessageSize(long uncompressedMessageSize2) {
            this.uncompressedMessageSize = Long.valueOf(uncompressedMessageSize2);
            return this;
        }

        public MessageEvent.Builder setCompressedMessageSize(long compressedMessageSize2) {
            this.compressedMessageSize = Long.valueOf(compressedMessageSize2);
            return this;
        }

        public MessageEvent build() {
            String missing = "";
            if (this.type == null) {
                missing = missing + " type";
            }
            if (this.messageId == null) {
                missing = missing + " messageId";
            }
            if (this.uncompressedMessageSize == null) {
                missing = missing + " uncompressedMessageSize";
            }
            if (this.compressedMessageSize == null) {
                missing = missing + " compressedMessageSize";
            }
            if (missing.isEmpty()) {
                return new AutoValue_MessageEvent(this.type, this.messageId.longValue(), this.uncompressedMessageSize.longValue(), this.compressedMessageSize.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
