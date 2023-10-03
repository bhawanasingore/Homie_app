package io.flutter.plugins.firebase.database;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class FirebaseDatabasePlugin implements FlutterPlugin {
    private MethodChannel channel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new FirebaseDatabasePlugin().setupMethodChannel(registrar.messenger());
    }

    private void setupMethodChannel(BinaryMessenger messenger) {
        MethodChannel methodChannel = new MethodChannel(messenger, "plugins.flutter.io/firebase_database");
        this.channel = methodChannel;
        this.channel.setMethodCallHandler(new MethodCallHandlerImpl(methodChannel));
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        setupMethodChannel(binding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
