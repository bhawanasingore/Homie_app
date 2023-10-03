package io.flutter.plugin.common;

import java.util.Map;
import org.json.JSONObject;

public final class MethodCall {
    public final Object arguments;
    public final String method;

    public MethodCall(String method2, Object arguments2) {
        if (method2 != null) {
            this.method = method2;
            this.arguments = arguments2;
            return;
        }
        throw new AssertionError("Parameter method must not be null.");
    }

    public <T> T arguments() {
        return this.arguments;
    }

    public <T> T argument(String key) {
        Object obj = this.arguments;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(key);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).opt(key);
        }
        throw new ClassCastException();
    }

    public boolean hasArgument(String key) {
        Object obj = this.arguments;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(key);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).has(key);
        }
        throw new ClassCastException();
    }
}
