package io.flutter.plugin.common;

import android.util.Log;

public class FlutterException extends RuntimeException {
    private static final String TAG = "FlutterException#";
    public final String code;
    public final Object details;

    FlutterException(String code2, String message, Object details2) {
        super(message);
        if (code2 == null) {
            Log.e(TAG, "Parameter code must not be null.");
        }
        this.code = code2;
        this.details = details2;
    }
}
