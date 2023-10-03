package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;

public class FilePickerPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    private static final String CHANNEL = "miguelruivo.flutter.plugins.filepicker";
    private static final String EVENT_CHANNEL = "miguelruivo.flutter.plugins.filepickerevent";
    private static final String TAG = "FilePicker";
    private static String fileType;
    private static boolean isMultipleSelection = false;
    private static boolean withData = false;
    private Activity activity;
    private ActivityPluginBinding activityBinding;
    private Application application;
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public FilePickerDelegate delegate;
    private Lifecycle lifecycle;
    private LifeCycleObserver observer;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;

    private class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
        private final Activity thisActivity;

        LifeCycleObserver(Activity activity) {
            this.thisActivity = activity;
        }

        public void onCreate(@NonNull LifecycleOwner owner) {
        }

        public void onStart(@NonNull LifecycleOwner owner) {
        }

        public void onResume(@NonNull LifecycleOwner owner) {
        }

        public void onPause(@NonNull LifecycleOwner owner) {
        }

        public void onStop(@NonNull LifecycleOwner owner) {
            onActivityStopped(this.thisActivity);
        }

        public void onDestroy(@NonNull LifecycleOwner owner) {
            onActivityDestroyed(this.thisActivity);
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.thisActivity == activity && activity.getApplicationContext() != null) {
                ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        Application application2;
        if (registrar.activity() != null) {
            Activity activity2 = registrar.activity();
            if (registrar.context() != null) {
                application2 = (Application) registrar.context().getApplicationContext();
            } else {
                application2 = null;
            }
            new FilePickerPlugin().setup(registrar.messenger(), application2, activity2, registrar, (ActivityPluginBinding) null);
        }
    }

    public void onMethodCall(MethodCall call, MethodChannel.Result rawResult) {
        String[] allowedExtensions;
        if (this.activity == null) {
            rawResult.error("no_activity", "file picker plugin requires a foreground activity", (Object) null);
            return;
        }
        MethodResultWrapper methodResultWrapper = new MethodResultWrapper(rawResult);
        HashMap arguments = (HashMap) call.arguments;
        if (call.method == null || !call.method.equals("clear")) {
            String resolveType = resolveType(call.method);
            fileType = resolveType;
            if (resolveType == null) {
                methodResultWrapper.notImplemented();
            } else if (resolveType != "dir") {
                isMultipleSelection = ((Boolean) arguments.get("allowMultipleSelection")).booleanValue();
                withData = ((Boolean) arguments.get("withData")).booleanValue();
                allowedExtensions = FileUtils.getMimeTypes((ArrayList) arguments.get("allowedExtensions"));
                if (fileType == "custom" || !(allowedExtensions == null || allowedExtensions.length == 0)) {
                    this.delegate.startFileExplorer(fileType, isMultipleSelection, withData, allowedExtensions, methodResultWrapper);
                    return;
                } else {
                    methodResultWrapper.error(TAG, "Unsupported filter. Make sure that you are only using the extension without the dot, (ie., jpg instead of .jpg). This could also have happened because you are using an unsupported file extension.  If the problem persists, you may want to consider using FileType.all instead.", (Object) null);
                    return;
                }
            }
            allowedExtensions = null;
            if (fileType == "custom") {
            }
            this.delegate.startFileExplorer(fileType, isMultipleSelection, withData, allowedExtensions, methodResultWrapper);
            return;
        }
        methodResultWrapper.success(Boolean.valueOf(FileUtils.clearCache(this.activity.getApplicationContext())));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String resolveType(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            java.lang.String r1 = "dir"
            switch(r0) {
                case -1349088399: goto L_0x0044;
                case 96748: goto L_0x003a;
                case 99469: goto L_0x0032;
                case 93166550: goto L_0x0028;
                case 100313435: goto L_0x001e;
                case 103772132: goto L_0x0014;
                case 112202875: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x004e
        L_0x000a:
            java.lang.String r0 = "video"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x004f
        L_0x0014:
            java.lang.String r0 = "media"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x004f
        L_0x001e:
            java.lang.String r0 = "image"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 1
            goto L_0x004f
        L_0x0028:
            java.lang.String r0 = "audio"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 0
            goto L_0x004f
        L_0x0032:
            boolean r0 = r2.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 6
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "any"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 4
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "custom"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 5
            goto L_0x004f
        L_0x004e:
            r0 = -1
        L_0x004f:
            switch(r0) {
                case 0: goto L_0x0061;
                case 1: goto L_0x005e;
                case 2: goto L_0x005b;
                case 3: goto L_0x0058;
                case 4: goto L_0x0055;
                case 5: goto L_0x0055;
                case 6: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            r0 = 0
            return r0
        L_0x0054:
            return r1
        L_0x0055:
            java.lang.String r0 = "*/*"
            return r0
        L_0x0058:
            java.lang.String r0 = "image/*,video/*"
            return r0
        L_0x005b:
            java.lang.String r0 = "video/*"
            return r0
        L_0x005e:
            java.lang.String r0 = "image/*"
            return r0
        L_0x0061:
            java.lang.String r0 = "audio/*"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mr.flutter.plugin.filepicker.FilePickerPlugin.resolveType(java.lang.String):java.lang.String");
    }

    private static class MethodResultWrapper implements MethodChannel.Result {
        private final Handler handler = new Handler(Looper.getMainLooper());
        /* access modifiers changed from: private */
        public final MethodChannel.Result methodResult;

        MethodResultWrapper(MethodChannel.Result result) {
            this.methodResult = result;
        }

        public void success(final Object result) {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.success(result);
                }
            });
        }

        public void error(final String errorCode, final String errorMessage, final Object errorDetails) {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.error(errorCode, errorMessage, errorDetails);
                }
            });
        }

        public void notImplemented() {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.notImplemented();
                }
            });
        }
    }

    private void setup(BinaryMessenger messenger, Application application2, Activity activity2, PluginRegistry.Registrar registrar, ActivityPluginBinding activityBinding2) {
        this.activity = activity2;
        this.application = application2;
        this.delegate = new FilePickerDelegate(activity2);
        MethodChannel methodChannel = new MethodChannel(messenger, CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        new EventChannel(messenger, EVENT_CHANNEL).setStreamHandler(new EventChannel.StreamHandler() {
            public void onListen(Object arguments, EventChannel.EventSink events) {
                FilePickerPlugin.this.delegate.setEventHandler(events);
            }

            public void onCancel(Object arguments) {
                FilePickerPlugin.this.delegate.setEventHandler((EventChannel.EventSink) null);
            }
        });
        LifeCycleObserver lifeCycleObserver = new LifeCycleObserver(activity2);
        this.observer = lifeCycleObserver;
        if (registrar != null) {
            application2.registerActivityLifecycleCallbacks(lifeCycleObserver);
            registrar.addActivityResultListener(this.delegate);
            registrar.addRequestPermissionsResultListener(this.delegate);
            return;
        }
        activityBinding2.addActivityResultListener(this.delegate);
        activityBinding2.addRequestPermissionsResultListener(this.delegate);
        Lifecycle activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityBinding2);
        this.lifecycle = activityLifecycle;
        activityLifecycle.addObserver(this.observer);
    }

    private void tearDown() {
        this.activityBinding.removeActivityResultListener(this.delegate);
        this.activityBinding.removeRequestPermissionsResultListener(this.delegate);
        this.activityBinding = null;
        this.lifecycle.removeObserver(this.observer);
        this.lifecycle = null;
        this.delegate.setEventHandler((EventChannel.EventSink) null);
        this.delegate = null;
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
        this.application.unregisterActivityLifecycleCallbacks(this.observer);
        this.application = null;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.pluginBinding = binding;
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.pluginBinding = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding binding) {
        this.activityBinding = binding;
        setup(this.pluginBinding.getBinaryMessenger(), (Application) this.pluginBinding.getApplicationContext(), this.activityBinding.getActivity(), (PluginRegistry.Registrar) null, this.activityBinding);
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    public void onDetachedFromActivity() {
        tearDown();
    }
}
