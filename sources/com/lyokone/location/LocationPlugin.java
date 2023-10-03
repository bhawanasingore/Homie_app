package com.lyokone.location;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;

public class LocationPlugin implements FlutterPlugin, ActivityAware {
    private static final String TAG = "LocationPlugin";
    private ActivityPluginBinding activityBinding;
    @Nullable
    private FlutterLocation location;
    @Nullable
    private MethodCallHandlerImpl methodCallHandler;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;
    @Nullable
    private StreamHandlerImpl streamHandlerImpl;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        FlutterLocation flutterLocation = new FlutterLocation(registrar);
        flutterLocation.setActivity(registrar.activity());
        new MethodCallHandlerImpl(flutterLocation).startListening(registrar.messenger());
        new StreamHandlerImpl(flutterLocation).startListening(registrar.messenger());
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        this.pluginBinding = binding;
        FlutterLocation flutterLocation = new FlutterLocation(binding.getApplicationContext(), (Activity) null);
        this.location = flutterLocation;
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(flutterLocation);
        this.methodCallHandler = methodCallHandlerImpl;
        methodCallHandlerImpl.startListening(binding.getBinaryMessenger());
        StreamHandlerImpl streamHandlerImpl2 = new StreamHandlerImpl(this.location);
        this.streamHandlerImpl = streamHandlerImpl2;
        streamHandlerImpl2.startListening(binding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        this.pluginBinding = null;
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.stopListening();
            this.methodCallHandler = null;
        }
        StreamHandlerImpl streamHandlerImpl2 = this.streamHandlerImpl;
        if (streamHandlerImpl2 != null) {
            streamHandlerImpl2.stopListening();
            this.streamHandlerImpl = null;
        }
        this.location = null;
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        this.location.setActivity(binding.getActivity());
        this.activityBinding = binding;
        setup(this.pluginBinding.getBinaryMessenger(), this.activityBinding.getActivity(), (PluginRegistry.Registrar) null);
    }

    public void onDetachedFromActivity() {
        tearDown();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    private void setup(BinaryMessenger messenger, Activity activity, PluginRegistry.Registrar registrar) {
        if (registrar != null) {
            registrar.addActivityResultListener(this.location);
            registrar.addRequestPermissionsResultListener(this.location);
            return;
        }
        this.activityBinding.addActivityResultListener(this.location);
        this.activityBinding.addRequestPermissionsResultListener(this.location);
    }

    private void tearDown() {
        this.activityBinding.removeActivityResultListener(this.location);
        this.activityBinding.removeRequestPermissionsResultListener(this.location);
    }
}
