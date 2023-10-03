package io.flutter.plugins.googlemaps;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.PluginRegistry;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleMapsPlugin implements Application.ActivityLifecycleCallbacks, FlutterPlugin, ActivityAware, DefaultLifecycleObserver {
    static final int CREATED = 1;
    static final int DESTROYED = 6;
    static final int PAUSED = 4;
    static final int RESUMED = 3;
    static final int STARTED = 2;
    static final int STOPPED = 5;
    private static final String VIEW_TYPE = "plugins.flutter.io/google_maps";
    private Lifecycle lifecycle;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;
    private int registrarActivityHashCode;
    private final AtomicInteger state = new AtomicInteger(0);

    public static void registerWith(PluginRegistry.Registrar registrar) {
        if (registrar.activity() != null) {
            GoogleMapsPlugin plugin = new GoogleMapsPlugin(registrar.activity());
            registrar.activity().getApplication().registerActivityLifecycleCallbacks(plugin);
            registrar.platformViewRegistry().registerViewFactory(VIEW_TYPE, new GoogleMapFactory(plugin.state, registrar.messenger(), (Application) null, (Lifecycle) null, registrar, -1));
        }
    }

    public GoogleMapsPlugin() {
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.pluginBinding = binding;
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.pluginBinding = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding binding) {
        Lifecycle activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(binding);
        this.lifecycle = activityLifecycle;
        activityLifecycle.addObserver(this);
        this.pluginBinding.getPlatformViewRegistry().registerViewFactory(VIEW_TYPE, new GoogleMapFactory(this.state, this.pluginBinding.getBinaryMessenger(), binding.getActivity().getApplication(), this.lifecycle, (PluginRegistry.Registrar) null, binding.getActivity().hashCode()));
    }

    public void onDetachedFromActivity() {
        this.lifecycle.removeObserver(this);
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        Lifecycle activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(binding);
        this.lifecycle = activityLifecycle;
        activityLifecycle.addObserver(this);
    }

    public void onCreate(@NonNull LifecycleOwner owner) {
        this.state.set(1);
    }

    public void onStart(@NonNull LifecycleOwner owner) {
        this.state.set(2);
    }

    public void onResume(@NonNull LifecycleOwner owner) {
        this.state.set(3);
    }

    public void onPause(@NonNull LifecycleOwner owner) {
        this.state.set(4);
    }

    public void onStop(@NonNull LifecycleOwner owner) {
        this.state.set(5);
    }

    public void onDestroy(@NonNull LifecycleOwner owner) {
        this.state.set(6);
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(1);
        }
    }

    public void onActivityStarted(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(2);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(3);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(4);
        }
    }

    public void onActivityStopped(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(5);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            this.state.set(6);
        }
    }

    private GoogleMapsPlugin(Activity activity) {
        this.registrarActivityHashCode = activity.hashCode();
    }
}
