package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class SharedPreferencesPlugin implements FlutterPlugin {
    private static final String CHANNEL_NAME = "plugins.flutter.io/shared_preferences";
    private MethodChannel channel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new SharedPreferencesPlugin().setupChannel(registrar.messenger(), registrar.context());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        setupChannel(binding.getBinaryMessenger(), binding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        teardownChannel();
    }

    private void setupChannel(BinaryMessenger messenger, Context context) {
        this.channel = new MethodChannel(messenger, CHANNEL_NAME);
        this.channel.setMethodCallHandler(new MethodCallHandlerImpl(context));
    }

    private void teardownChannel() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
    }
}
