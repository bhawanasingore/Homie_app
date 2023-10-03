package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class JSONMessageCodec implements MessageCodec<Object> {
    public static final JSONMessageCodec INSTANCE = new JSONMessageCodec();

    private JSONMessageCodec() {
    }

    public ByteBuffer encodeMessage(Object message) {
        if (message == null) {
            return null;
        }
        Object wrapped = JSONUtil.wrap(message);
        if (wrapped instanceof String) {
            return StringCodec.INSTANCE.encodeMessage(JSONObject.quote((String) wrapped));
        }
        return StringCodec.INSTANCE.encodeMessage(wrapped.toString());
    }

    public Object decodeMessage(ByteBuffer message) {
        if (message == null) {
            return null;
        }
        try {
            JSONTokener tokener = new JSONTokener(StringCodec.INSTANCE.decodeMessage(message));
            Object value = tokener.nextValue();
            if (!tokener.more()) {
                return value;
            }
            throw new IllegalArgumentException("Invalid JSON");
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }
}
