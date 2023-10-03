package io.flutter.plugin.common;

import android.util.Log;
import io.flutter.plugin.common.MethodChannel;

public class ErrorLogResult implements MethodChannel.Result {
    private int level;
    private String tag;

    public ErrorLogResult(String tag2) {
        this(tag2, 5);
    }

    public ErrorLogResult(String tag2, int level2) {
        this.tag = tag2;
        this.level = level2;
    }

    public void success(Object result) {
    }

    public void error(String errorCode, String errorMessage, Object errorDetails) {
        String details;
        if (errorDetails != null) {
            details = " details: " + errorDetails;
        } else {
            details = "";
        }
        Log.println(this.level, this.tag, errorMessage + details);
    }

    public void notImplemented() {
        Log.println(this.level, this.tag, "method not implemented");
    }
}
