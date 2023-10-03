package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.baseflow.permissionhandler.PermissionManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

@SynthesizedClassMap({$$Lambda$Msf205iOSs2QxATZKozL2TAITw0.class, $$Lambda$jfUlisAID1JnsPRA9QxVZawaFQM.class, $$Lambda$rOyg1Wi6vWVUV2448HhC4KsVuk.class, $$Lambda$sBX9xOXZLIyslP1RzvV3CSTujA.class})
public final class PermissionHandlerPlugin implements FlutterPlugin, ActivityAware {
    @Nullable
    private MethodCallHandlerImpl methodCallHandler;
    private MethodChannel methodChannel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        PermissionHandlerPlugin plugin = new PermissionHandlerPlugin();
        plugin.startListening(registrar.context(), registrar.messenger());
        if (registrar.activeContext() instanceof Activity) {
            Activity activity = registrar.activity();
            registrar.getClass();
            $$Lambda$Msf205iOSs2QxATZKozL2TAITw0 r2 = new PermissionManager.ActivityRegistry() {
                public final void addListener(PluginRegistry.ActivityResultListener activityResultListener) {
                    PluginRegistry.Registrar.this.addActivityResultListener(activityResultListener);
                }
            };
            registrar.getClass();
            plugin.startListeningToActivity(activity, r2, new PermissionManager.PermissionRegistry() {
                public final void addListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
                    PluginRegistry.Registrar.this.addRequestPermissionsResultListener(requestPermissionsResultListener);
                }
            });
        }
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        startListening(binding.getApplicationContext(), binding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        stopListening();
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        Activity activity = binding.getActivity();
        binding.getClass();
        $$Lambda$sBX9xOXZLIyslP1RzvV3CSTujA r1 = new PermissionManager.ActivityRegistry() {
            public final void addListener(PluginRegistry.ActivityResultListener activityResultListener) {
                ActivityPluginBinding.this.addActivityResultListener(activityResultListener);
            }
        };
        binding.getClass();
        startListeningToActivity(activity, r1, new PermissionManager.PermissionRegistry() {
            public final void addListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
                ActivityPluginBinding.this.addRequestPermissionsResultListener(requestPermissionsResultListener);
            }
        });
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    public void onDetachedFromActivity() {
        stopListeningToActivity();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    private void startListening(Context applicationContext, BinaryMessenger messenger) {
        this.methodChannel = new MethodChannel(messenger, "flutter.baseflow.com/permissions/methods");
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(applicationContext, new AppSettingsManager(), new PermissionManager(), new ServiceManager());
        this.methodCallHandler = methodCallHandlerImpl;
        this.methodChannel.setMethodCallHandler(methodCallHandlerImpl);
    }

    private void stopListening() {
        this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.methodChannel = null;
        this.methodCallHandler = null;
    }

    private void startListeningToActivity(Activity activity, PermissionManager.ActivityRegistry activityRegistry, PermissionManager.PermissionRegistry permissionRegistry) {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.setActivity(activity);
            this.methodCallHandler.setActivityRegistry(activityRegistry);
            this.methodCallHandler.setPermissionRegistry(permissionRegistry);
        }
    }

    private void stopListeningToActivity() {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.setActivity((Activity) null);
            this.methodCallHandler.setActivityRegistry((PermissionManager.ActivityRegistry) null);
            this.methodCallHandler.setPermissionRegistry((PermissionManager.PermissionRegistry) null);
        }
    }
}
