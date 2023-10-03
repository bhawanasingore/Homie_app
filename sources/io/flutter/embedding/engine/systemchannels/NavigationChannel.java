package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;

public class NavigationChannel {
    private static final String TAG = "NavigationChannel";
    public final MethodChannel channel;

    public NavigationChannel(DartExecutor dartExecutor) {
        this.channel = new MethodChannel(dartExecutor, "flutter/navigation", JSONMethodCodec.INSTANCE);
    }

    public void setInitialRoute(String initialRoute) {
        Log.v(TAG, "Sending message to set initial route to '" + initialRoute + "'");
        this.channel.invokeMethod("setInitialRoute", initialRoute);
    }

    public void pushRoute(String route) {
        Log.v(TAG, "Sending message to push route '" + route + "'");
        this.channel.invokeMethod("pushRoute", route);
    }

    public void popRoute() {
        Log.v(TAG, "Sending message to pop route.");
        this.channel.invokeMethod("popRoute", (Object) null);
    }

    public void setMethodCallHandler(MethodChannel.MethodCallHandler handler) {
        this.channel.setMethodCallHandler(handler);
    }
}
