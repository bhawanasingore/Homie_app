package io.flutter.view;

import io.flutter.embedding.engine.FlutterJNI;

public final class FlutterCallbackInformation {
    public final String callbackClassName;
    public final String callbackLibraryPath;
    public final String callbackName;

    public static FlutterCallbackInformation lookupCallbackInformation(long handle) {
        return FlutterJNI.nativeLookupCallbackInformation(handle);
    }

    private FlutterCallbackInformation(String callbackName2, String callbackClassName2, String callbackLibraryPath2) {
        this.callbackName = callbackName2;
        this.callbackClassName = callbackClassName2;
        this.callbackLibraryPath = callbackLibraryPath2;
    }
}
