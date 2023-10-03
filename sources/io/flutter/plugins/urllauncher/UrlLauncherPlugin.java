package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;

public final class UrlLauncherPlugin implements FlutterPlugin, ActivityAware {
    private static final String TAG = "UrlLauncherPlugin";
    @Nullable
    private MethodCallHandlerImpl methodCallHandler;
    @Nullable
    private UrlLauncher urlLauncher;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodCallHandlerImpl(new UrlLauncher(registrar.context(), registrar.activity())).startListening(registrar.messenger());
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        UrlLauncher urlLauncher2 = new UrlLauncher(binding.getApplicationContext(), (Activity) null);
        this.urlLauncher = urlLauncher2;
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(urlLauncher2);
        this.methodCallHandler = methodCallHandlerImpl;
        methodCallHandlerImpl.startListening(binding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl == null) {
            Log.wtf(TAG, "Already detached from the engine.");
            return;
        }
        methodCallHandlerImpl.stopListening();
        this.methodCallHandler = null;
        this.urlLauncher = null;
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        if (this.methodCallHandler == null) {
            Log.wtf(TAG, "urlLauncher was never set.");
        } else {
            this.urlLauncher.setActivity(binding.getActivity());
        }
    }

    public void onDetachedFromActivity() {
        if (this.methodCallHandler == null) {
            Log.wtf(TAG, "urlLauncher was never set.");
        } else {
            this.urlLauncher.setActivity((Activity) null);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }
}
