package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlutterPluginRegistry implements PluginRegistry, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener {
    private static final String TAG = "FlutterPluginRegistry";
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public final List<PluginRegistry.ActivityResultListener> mActivityResultListeners = new ArrayList(0);
    /* access modifiers changed from: private */
    public Context mAppContext;
    /* access modifiers changed from: private */
    public FlutterView mFlutterView;
    /* access modifiers changed from: private */
    public FlutterNativeView mNativeView;
    /* access modifiers changed from: private */
    public final List<PluginRegistry.NewIntentListener> mNewIntentListeners = new ArrayList(0);
    /* access modifiers changed from: private */
    public final PlatformViewsController mPlatformViewsController;
    /* access modifiers changed from: private */
    public final Map<String, Object> mPluginMap = new LinkedHashMap(0);
    /* access modifiers changed from: private */
    public final List<PluginRegistry.RequestPermissionsResultListener> mRequestPermissionsResultListeners = new ArrayList(0);
    /* access modifiers changed from: private */
    public final List<PluginRegistry.UserLeaveHintListener> mUserLeaveHintListeners = new ArrayList(0);
    /* access modifiers changed from: private */
    public final List<PluginRegistry.ViewDestroyListener> mViewDestroyListeners = new ArrayList(0);

    public FlutterPluginRegistry(FlutterNativeView nativeView, Context context) {
        this.mNativeView = nativeView;
        this.mAppContext = context;
        this.mPlatformViewsController = new PlatformViewsController();
    }

    public FlutterPluginRegistry(FlutterEngine engine, Context context) {
        this.mAppContext = context;
        this.mPlatformViewsController = new PlatformViewsController();
    }

    public boolean hasPlugin(String key) {
        return this.mPluginMap.containsKey(key);
    }

    public <T> T valuePublishedByPlugin(String pluginKey) {
        return this.mPluginMap.get(pluginKey);
    }

    public PluginRegistry.Registrar registrarFor(String pluginKey) {
        if (!this.mPluginMap.containsKey(pluginKey)) {
            this.mPluginMap.put(pluginKey, (Object) null);
            return new FlutterRegistrar(pluginKey);
        }
        throw new IllegalStateException("Plugin key " + pluginKey + " is already in use");
    }

    public void attach(FlutterView flutterView, Activity activity) {
        this.mFlutterView = flutterView;
        this.mActivity = activity;
        this.mPlatformViewsController.attach(activity, flutterView, flutterView.getDartExecutor());
    }

    public void detach() {
        this.mPlatformViewsController.detach();
        this.mPlatformViewsController.onDetachedFromJNI();
        this.mFlutterView = null;
        this.mActivity = null;
    }

    public void onPreEngineRestart() {
        this.mPlatformViewsController.onPreEngineRestart();
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.mPlatformViewsController;
    }

    private class FlutterRegistrar implements PluginRegistry.Registrar {
        private final String pluginKey;

        FlutterRegistrar(String pluginKey2) {
            this.pluginKey = pluginKey2;
        }

        public Activity activity() {
            return FlutterPluginRegistry.this.mActivity;
        }

        public Context context() {
            return FlutterPluginRegistry.this.mAppContext;
        }

        public Context activeContext() {
            return FlutterPluginRegistry.this.mActivity != null ? FlutterPluginRegistry.this.mActivity : FlutterPluginRegistry.this.mAppContext;
        }

        public BinaryMessenger messenger() {
            return FlutterPluginRegistry.this.mNativeView;
        }

        public TextureRegistry textures() {
            return FlutterPluginRegistry.this.mFlutterView;
        }

        public PlatformViewRegistry platformViewRegistry() {
            return FlutterPluginRegistry.this.mPlatformViewsController.getRegistry();
        }

        public FlutterView view() {
            return FlutterPluginRegistry.this.mFlutterView;
        }

        public String lookupKeyForAsset(String asset) {
            return FlutterMain.getLookupKeyForAsset(asset);
        }

        public String lookupKeyForAsset(String asset, String packageName) {
            return FlutterMain.getLookupKeyForAsset(asset, packageName);
        }

        public PluginRegistry.Registrar publish(Object value) {
            FlutterPluginRegistry.this.mPluginMap.put(this.pluginKey, value);
            return this;
        }

        public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener listener) {
            FlutterPluginRegistry.this.mRequestPermissionsResultListeners.add(listener);
            return this;
        }

        public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener listener) {
            FlutterPluginRegistry.this.mActivityResultListeners.add(listener);
            return this;
        }

        public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener listener) {
            FlutterPluginRegistry.this.mNewIntentListeners.add(listener);
            return this;
        }

        public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener listener) {
            FlutterPluginRegistry.this.mUserLeaveHintListeners.add(listener);
            return this;
        }

        public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener listener) {
            FlutterPluginRegistry.this.mViewDestroyListeners.add(listener);
            return this;
        }
    }

    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (PluginRegistry.RequestPermissionsResultListener listener : this.mRequestPermissionsResultListeners) {
            if (listener.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
                return true;
            }
        }
        return false;
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        for (PluginRegistry.ActivityResultListener listener : this.mActivityResultListeners) {
            if (listener.onActivityResult(requestCode, resultCode, data)) {
                return true;
            }
        }
        return false;
    }

    public boolean onNewIntent(Intent intent) {
        for (PluginRegistry.NewIntentListener listener : this.mNewIntentListeners) {
            if (listener.onNewIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    public void onUserLeaveHint() {
        for (PluginRegistry.UserLeaveHintListener listener : this.mUserLeaveHintListeners) {
            listener.onUserLeaveHint();
        }
    }

    public boolean onViewDestroy(FlutterNativeView view) {
        boolean handled = false;
        for (PluginRegistry.ViewDestroyListener listener : this.mViewDestroyListeners) {
            if (listener.onViewDestroy(view)) {
                handled = true;
            }
        }
        return handled;
    }

    public void destroy() {
        this.mPlatformViewsController.onDetachedFromJNI();
    }
}
