package io.flutter.embedding.engine.plugins;

import android.content.Context;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.TextureRegistry;

public interface FlutterPlugin {

    public interface FlutterAssets {
        String getAssetFilePathByName(String str);

        String getAssetFilePathByName(String str, String str2);

        String getAssetFilePathBySubpath(String str);

        String getAssetFilePathBySubpath(String str, String str2);
    }

    void onAttachedToEngine(FlutterPluginBinding flutterPluginBinding);

    void onDetachedFromEngine(FlutterPluginBinding flutterPluginBinding);

    public static class FlutterPluginBinding {
        private final Context applicationContext;
        private final BinaryMessenger binaryMessenger;
        private final FlutterAssets flutterAssets;
        private final FlutterEngine flutterEngine;
        private final PlatformViewRegistry platformViewRegistry;
        private final TextureRegistry textureRegistry;

        public FlutterPluginBinding(Context applicationContext2, FlutterEngine flutterEngine2, BinaryMessenger binaryMessenger2, TextureRegistry textureRegistry2, PlatformViewRegistry platformViewRegistry2, FlutterAssets flutterAssets2) {
            this.applicationContext = applicationContext2;
            this.flutterEngine = flutterEngine2;
            this.binaryMessenger = binaryMessenger2;
            this.textureRegistry = textureRegistry2;
            this.platformViewRegistry = platformViewRegistry2;
            this.flutterAssets = flutterAssets2;
        }

        public Context getApplicationContext() {
            return this.applicationContext;
        }

        @Deprecated
        public FlutterEngine getFlutterEngine() {
            return this.flutterEngine;
        }

        public BinaryMessenger getBinaryMessenger() {
            return this.binaryMessenger;
        }

        public TextureRegistry getTextureRegistry() {
            return this.textureRegistry;
        }

        public PlatformViewRegistry getPlatformViewRegistry() {
            return this.platformViewRegistry;
        }

        public FlutterAssets getFlutterAssets() {
            return this.flutterAssets;
        }
    }
}
