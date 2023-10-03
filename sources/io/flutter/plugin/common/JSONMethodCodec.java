package io.flutter.plugin.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JSONMethodCodec implements MethodCodec {
    public static final JSONMethodCodec INSTANCE = new JSONMethodCodec();

    private JSONMethodCodec() {
    }

    public ByteBuffer encodeMethodCall(MethodCall methodCall) {
        try {
            JSONObject map = new JSONObject();
            map.put(FirebaseAnalytics.Param.METHOD, methodCall.method);
            map.put("args", JSONUtil.wrap(methodCall.arguments));
            return JSONMessageCodec.INSTANCE.encodeMessage(map);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    public MethodCall decodeMethodCall(ByteBuffer message) {
        try {
            Object json = JSONMessageCodec.INSTANCE.decodeMessage(message);
            if (json instanceof JSONObject) {
                JSONObject map = (JSONObject) json;
                Object method = map.get(FirebaseAnalytics.Param.METHOD);
                Object arguments = unwrapNull(map.opt("args"));
                if (method instanceof String) {
                    return new MethodCall((String) method, arguments);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + json);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    public ByteBuffer encodeSuccessEnvelope(Object result) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(JSONUtil.wrap(result)));
    }

    public ByteBuffer encodeErrorEnvelope(String errorCode, String errorMessage, Object errorDetails) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(errorCode).put(JSONUtil.wrap(errorMessage)).put(JSONUtil.wrap(errorDetails)));
    }

    public ByteBuffer encodeErrorEnvelopeWithStacktrace(String errorCode, String errorMessage, Object errorDetails, String errorStacktrace) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(errorCode).put(JSONUtil.wrap(errorMessage)).put(JSONUtil.wrap(errorDetails)).put(JSONUtil.wrap(errorStacktrace)));
    }

    public Object decodeEnvelope(ByteBuffer envelope) {
        try {
            Object json = JSONMessageCodec.INSTANCE.decodeMessage(envelope);
            if (json instanceof JSONArray) {
                JSONArray array = (JSONArray) json;
                if (array.length() == 1) {
                    return unwrapNull(array.opt(0));
                }
                if (array.length() == 3) {
                    Object code = array.get(0);
                    Object message = unwrapNull(array.opt(1));
                    Object details = unwrapNull(array.opt(2));
                    if ((code instanceof String) && (message == null || (message instanceof String))) {
                        throw new FlutterException((String) code, (String) message, details);
                    }
                }
            }
            throw new IllegalArgumentException("Invalid envelope: " + json);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    /* access modifiers changed from: package-private */
    public Object unwrapNull(Object value) {
        if (value == JSONObject.NULL) {
            return null;
        }
        return value;
    }
}
