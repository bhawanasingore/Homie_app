package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;

public class ImagePickerPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    private static final int CAMERA_DEVICE_FRONT = 1;
    private static final int CAMERA_DEVICE_REAR = 0;
    private static final String CHANNEL = "plugins.flutter.io/image_picker";
    static final String METHOD_CALL_IMAGE = "pickImage";
    private static final String METHOD_CALL_RETRIEVE = "retrieve";
    static final String METHOD_CALL_VIDEO = "pickVideo";
    private static final int SOURCE_CAMERA = 0;
    private static final int SOURCE_GALLERY = 1;
    private Activity activity;
    private ActivityPluginBinding activityBinding;
    private Application application;
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public ImagePickerDelegate delegate;
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
            if (this.thisActivity == activity) {
                ImagePickerPlugin.this.delegate.saveStateBeforeResult();
            }
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
            new ImagePickerPlugin().setup(registrar.messenger(), application2, activity2, registrar, (ActivityPluginBinding) null);
        }
    }

    public ImagePickerPlugin() {
    }

    @VisibleForTesting
    ImagePickerPlugin(ImagePickerDelegate delegate2, Activity activity2) {
        this.delegate = delegate2;
        this.activity = activity2;
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

    public void onDetachedFromActivity() {
        tearDown();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    private void setup(BinaryMessenger messenger, Application application2, Activity activity2, PluginRegistry.Registrar registrar, ActivityPluginBinding activityBinding2) {
        this.activity = activity2;
        this.application = application2;
        this.delegate = constructDelegate(activity2);
        MethodChannel methodChannel = new MethodChannel(messenger, CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
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
        this.delegate = null;
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
        this.application.unregisterActivityLifecycleCallbacks(this.observer);
        this.application = null;
    }

    private final ImagePickerDelegate constructDelegate(Activity setupActivity) {
        ImagePickerCache cache = new ImagePickerCache(setupActivity);
        File externalFilesDirectory = setupActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return new ImagePickerDelegate(setupActivity, externalFilesDirectory, new ImageResizer(externalFilesDirectory, new ExifDataCopier()), cache);
    }

    private static class MethodResultWrapper implements MethodChannel.Result {
        private Handler handler = new Handler(Looper.getMainLooper());
        /* access modifiers changed from: private */
        public MethodChannel.Result methodResult;

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

    public void onMethodCall(MethodCall call, MethodChannel.Result rawResult) {
        CameraDevice device;
        if (this.activity == null) {
            rawResult.error("no_activity", "image_picker plugin requires a foreground activity.", (Object) null);
            return;
        }
        MethodChannel.Result result = new MethodResultWrapper(rawResult);
        if (call.argument("cameraDevice") != null) {
            if (((Integer) call.argument("cameraDevice")).intValue() == 1) {
                device = CameraDevice.FRONT;
            } else {
                device = CameraDevice.REAR;
            }
            this.delegate.setCameraDevice(device);
        }
        String str = call.method;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1457314374) {
            if (hashCode != -1445424934) {
                if (hashCode == -310034372 && str.equals(METHOD_CALL_RETRIEVE)) {
                    c = 2;
                }
            } else if (str.equals(METHOD_CALL_VIDEO)) {
                c = 1;
            }
        } else if (str.equals(METHOD_CALL_IMAGE)) {
            c = 0;
        }
        if (c == 0) {
            int imageSource = ((Integer) call.argument(FirebaseAnalytics.Param.SOURCE)).intValue();
            if (imageSource == 0) {
                this.delegate.takeImageWithCamera(call, result);
            } else if (imageSource == 1) {
                this.delegate.chooseImageFromGallery(call, result);
            } else {
                throw new IllegalArgumentException("Invalid image source: " + imageSource);
            }
        } else if (c == 1) {
            int imageSource2 = ((Integer) call.argument(FirebaseAnalytics.Param.SOURCE)).intValue();
            if (imageSource2 == 0) {
                this.delegate.takeVideoWithCamera(call, result);
            } else if (imageSource2 == 1) {
                this.delegate.chooseVideoFromGallery(call, result);
            } else {
                throw new IllegalArgumentException("Invalid video source: " + imageSource2);
            }
        } else if (c == 2) {
            this.delegate.retrieveLostImage(result);
        } else {
            throw new IllegalArgumentException("Unknown method " + call.method);
        }
    }
}
