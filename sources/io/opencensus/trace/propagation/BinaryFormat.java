package io.opencensus.trace.propagation;

import io.opencensus.internal.Utils;
import io.opencensus.trace.SpanContext;
import java.text.ParseException;

public abstract class BinaryFormat {
    static final NoopBinaryFormat NOOP_BINARY_FORMAT = new NoopBinaryFormat();

    @Deprecated
    public byte[] toBinaryValue(SpanContext spanContext) {
        return toByteArray(spanContext);
    }

    public byte[] toByteArray(SpanContext spanContext) {
        return toBinaryValue(spanContext);
    }

    @Deprecated
    public SpanContext fromBinaryValue(byte[] bytes) throws ParseException {
        try {
            return fromByteArray(bytes);
        } catch (SpanContextParseException e) {
            throw new ParseException(e.toString(), 0);
        }
    }

    public SpanContext fromByteArray(byte[] bytes) throws SpanContextParseException {
        try {
            return fromBinaryValue(bytes);
        } catch (ParseException e) {
            throw new SpanContextParseException("Error while parsing.", e);
        }
    }

    static BinaryFormat getNoopBinaryFormat() {
        return NOOP_BINARY_FORMAT;
    }

    private static final class NoopBinaryFormat extends BinaryFormat {
        public byte[] toByteArray(SpanContext spanContext) {
            Utils.checkNotNull(spanContext, "spanContext");
            return new byte[0];
        }

        public SpanContext fromByteArray(byte[] bytes) {
            Utils.checkNotNull(bytes, "bytes");
            return SpanContext.INVALID;
        }

        private NoopBinaryFormat() {
        }
    }
}
