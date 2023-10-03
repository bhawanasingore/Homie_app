package com.baseflow.geolocator;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.permission.PermissionManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;

public class GeolocatorPlugin implements FlutterPlugin, ActivityAware {
    private static final String TAG = "GeocodingPlugin";
    private final GeolocationManager geolocationManager;
    @Nullable
    private MethodCallHandlerImpl methodCallHandler;
    private final PermissionManager permissionManager;
    @Nullable
    private ActivityPluginBinding pluginBinding;
    @Nullable
    private PluginRegistry.Registrar pluginRegistrar;
    @Nullable
    private StreamHandlerImpl streamHandler;

    public GeolocatorPlugin() {
        PermissionManager permissionManager2 = new PermissionManager();
        this.permissionManager = permissionManager2;
        this.geolocationManager = new GeolocationManager(permissionManager2);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        GeolocatorPlugin geolocatorPlugin = new GeolocatorPlugin();
        geolocatorPlugin.pluginRegistrar = registrar;
        geolocatorPlugin.registerListeners();
        MethodCallHandlerImpl methodCallHandler2 = new MethodCallHandlerImpl(geolocatorPlugin.permissionManager, geolocatorPlugin.geolocationManager);
        methodCallHandler2.startListening(registrar.context(), registrar.messenger());
        methodCallHandler2.setActivity(registrar.activity());
        StreamHandlerImpl streamHandler2 = new StreamHandlerImpl(geolocatorPlugin.geolocationManager);
        streamHandler2.startListening(registrar.context(), registrar.messenger());
        streamHandler2.setActivity(registrar.activity());
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(this.permissionManager, this.geolocationManager);
        this.methodCallHandler = methodCallHandlerImpl;
        methodCallHandlerImpl.startListening(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        StreamHandlerImpl streamHandlerImpl = new StreamHandlerImpl(this.geolocationManager);
        this.streamHandler = streamHandlerImpl;
        streamHandlerImpl.startListening(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.stopListening();
            this.methodCallHandler = null;
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.stopListening();
            this.streamHandler = null;
        }
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.setActivity(binding.getActivity());
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.setActivity(binding.getActivity());
        }
        this.pluginBinding = binding;
        registerListeners();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    public void onDetachedFromActivity() {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.setActivity((Activity) null);
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.setActivity((Activity) null);
        }
        deregisterListeners();
    }

    private void registerListeners() {
        PluginRegistry.Registrar registrar = this.pluginRegistrar;
        if (registrar != null) {
            registrar.addActivityResultListener(this.geolocationManager);
            this.pluginRegistrar.addRequestPermissionsResultListener(this.permissionManager);
            return;
        }
        ActivityPluginBinding activityPluginBinding = this.pluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this.geolocationManager);
            this.pluginBinding.addRequestPermissionsResultListener(this.permissionManager);
        }
    }

    private void deregisterListeners() {
        ActivityPluginBinding activityPluginBinding = this.pluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.geolocationManager);
            this.pluginBinding.removeRequestPermissionsResultListener(this.permissionManager);
        }
    }
}
