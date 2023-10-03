package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class StringCodec implements MessageCodec<String> {
    public static final StringCodec INSTANCE = new StringCodec();
    private static final Charset UTF8 = Charset.forName("UTF8");

    private StringCodec() {
    }

    public ByteBuffer encodeMessage(String message) {
        if (message == null) {
            return null;
        }
        byte[] bytes = message.getBytes(UTF8);
        ByteBuffer buffer = ByteBuffer.allocateDirect(bytes.length);
        buffer.put(bytes);
        return buffer;
    }

    public String decodeMessage(ByteBuffer message) {
        int offset;
        byte[] bytes;
        if (message == null) {
            return null;
        }
        int length = message.remaining();
        if (message.hasArray()) {
            bytes = message.array();
            offset = message.arrayOffset();
        } else {
            bytes = new byte[length];
            message.get(bytes);
            offset = 0;
        }
        return new String(bytes, offset, length, UTF8);
    }
}
