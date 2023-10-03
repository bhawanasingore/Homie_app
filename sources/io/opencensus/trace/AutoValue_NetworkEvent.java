package io.opencensus.trace;

import io.opencensus.common.Timestamp;
import io.opencensus.trace.NetworkEvent;
import javax.annotation.Nullable;

@Deprecated
final class AutoValue_NetworkEvent extends NetworkEvent {
    private final long compressedMessageSize;
    private final Timestamp kernelTimestamp;
    private final long messageId;
    private final NetworkEvent.Type type;
    private final long uncompressedMessageSize;

    private AutoValue_NetworkEvent(@Nullable Timestamp kernelTimestamp2, NetworkEvent.Type type2, long messageId2, long uncompressedMessageSize2, long compressedMessageSize2) {
        this.kernelTimestamp = kernelTimestamp2;
        this.type = type2;
        this.messageId = messageId2;
        this.uncompressedMessageSize = uncompressedMessageSize2;
        this.compressedMessageSize = compressedMessageSize2;
    }

    @Nullable
    public Timestamp getKernelTimestamp() {
        return this.kernelTimestamp;
    }

    public NetworkEvent.Type getType() {
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
        return "NetworkEvent{kernelTimestamp=" + this.kernelTimestamp + ", type=" + this.type + ", messageId=" + this.messageId + ", uncompressedMessageSize=" + this.uncompressedMessageSize + ", compressedMessageSize=" + this.compressedMessageSize + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof NetworkEvent)) {
            return false;
        }
        NetworkEvent that = (NetworkEvent) o;
        Timestamp timestamp = this.kernelTimestamp;
        if (timestamp != null ? timestamp.equals(that.getKernelTimestamp()) : that.getKernelTimestamp() == null) {
            if (this.type.equals(that.getType()) && this.messageId == that.getMessageId() && this.uncompressedMessageSize == that.getUncompressedMessageSize() && this.compressedMessageSize == that.getCompressedMessageSize()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int h = 1 * 1000003;
        Timestamp timestamp = this.kernelTimestamp;
        int hashCode = timestamp == null ? 0 : timestamp.hashCode();
        long j = this.messageId;
        long j2 = this.uncompressedMessageSize;
        long j3 = this.compressedMessageSize;
        return (int) (((long) (((int) (((long) (((int) (((long) ((((h ^ hashCode) * 1000003) ^ this.type.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003)) ^ (j3 ^ (j3 >>> 32)));
    }

    static final class Builder extends NetworkEvent.Builder {
        private Long compressedMessageSize;
        private Timestamp kernelTimestamp;
        private Long messageId;
        private NetworkEvent.Type type;
        private Long uncompressedMessageSize;

        Builder() {
        }

        public NetworkEvent.Builder setKernelTimestamp(@Nullable Timestamp kernelTimestamp2) {
            this.kernelTimestamp = kernelTimestamp2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public NetworkEvent.Builder setType(NetworkEvent.Type type2) {
            if (type2 != null) {
                this.type = type2;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        /* access modifiers changed from: package-private */
        public NetworkEvent.Builder setMessageId(long messageId2) {
            this.messageId = Long.valueOf(messageId2);
            return this;
        }

        public NetworkEvent.Builder setUncompressedMessageSize(long uncompressedMessageSize2) {
            this.uncompressedMessageSize = Long.valueOf(uncompressedMessageSize2);
            return this;
        }

        public NetworkEvent.Builder setCompressedMessageSize(long compressedMessageSize2) {
            this.compressedMessageSize = Long.valueOf(compressedMessageSize2);
            return this;
        }

        public NetworkEvent build() {
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
                return new AutoValue_NetworkEvent(this.kernelTimestamp, this.type, this.messageId.longValue(), this.uncompressedMessageSize.longValue(), this.compressedMessageSize.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
