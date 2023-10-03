package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public final class BinaryCodec implements MessageCodec<ByteBuffer> {
    public static final BinaryCodec INSTANCE = new BinaryCodec();

    private BinaryCodec() {
    }

    public ByteBuffer encodeMessage(ByteBuffer message) {
        return message;
    }

    public ByteBuffer decodeMessage(ByteBuffer message) {
        return message;
    }
}
