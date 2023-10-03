package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;

public class MouseCursorChannel {
    private static final String TAG = "MouseCursorChannel";
    public final MethodChannel channel;
    /* access modifiers changed from: private */
    public MouseCursorMethodHandler mouseCursorMethodHandler;
    private final MethodChannel.MethodCallHandler parsingMethodCallHandler = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall call, MethodChannel.Result result) {
            if (MouseCursorChannel.this.mouseCursorMethodHandler != null) {
                String method = call.method;
                Log.v(MouseCursorChannel.TAG, "Received '" + method + "' message.");
                char c = 65535;
                try {
                    if (method.hashCode() == -1307105544 && method.equals("activateSystemCursor")) {
                        c = 0;
                    }
                    if (c == 0) {
                        try {
                            MouseCursorChannel.this.mouseCursorMethodHandler.activateSystemCursor((String) ((HashMap) call.arguments).get("kind"));
                            result.success(true);
                        } catch (Exception e) {
                            result.error("error", "Error when setting cursors: " + e.getMessage(), (Object) null);
                        }
                    }
                } catch (Exception e2) {
                    result.error("error", "Unhandled error: " + e2.getMessage(), (Object) null);
                }
            }
        }
    };

    public interface MouseCursorMethodHandler {
        void activateSystemCursor(String str);
    }

    public MouseCursorChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodCallHandler);
    }

    public void setMethodHandler(MouseCursorMethodHandler mouseCursorMethodHandler2) {
        this.mouseCursorMethodHandler = mouseCursorMethodHandler2;
    }

    public void synthesizeMethodCall(MethodCall call, MethodChannel.Result result) {
        this.parsingMethodCallHandler.onMethodCall(call, result);
    }
}
