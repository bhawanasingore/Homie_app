package io.flutter.embedding.engine.plugins.util;

import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;

public class GeneratedPluginRegister {
    private static final String TAG = "GeneratedPluginsRegister";

    public static void registerGeneratedPlugins(FlutterEngine flutterEngine) {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[]{FlutterEngine.class}).invoke((Object) null, new Object[]{flutterEngine});
        } catch (Exception e) {
            Log.w(TAG, "Tried to automatically register plugins with FlutterEngine (" + flutterEngine + ") but could not find and invoke the GeneratedPluginRegistrant.");
        }
    }
}
