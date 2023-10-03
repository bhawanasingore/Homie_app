package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import io.flutter.Log;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.embedding.engine.plugins.service.ServiceAware;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class FlutterEnginePluginRegistry implements PluginRegistry, ActivityControlSurface, ServiceControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface {
    private static final String TAG = "FlutterEnginePluginRegistry";
    private Activity activity;
    private final Map<Class<? extends FlutterPlugin>, ActivityAware> activityAwarePlugins = new HashMap();
    private FlutterEngineActivityPluginBinding activityPluginBinding;
    private BroadcastReceiver broadcastReceiver;
    private final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> broadcastReceiverAwarePlugins = new HashMap();
    private FlutterEngineBroadcastReceiverPluginBinding broadcastReceiverPluginBinding;
    private ContentProvider contentProvider;
    private final Map<Class<? extends FlutterPlugin>, ContentProviderAware> contentProviderAwarePlugins = new HashMap();
    private FlutterEngineContentProviderPluginBinding contentProviderPluginBinding;
    private final FlutterEngine flutterEngine;
    private boolean isWaitingForActivityReattachment = false;
    private final FlutterPlugin.FlutterPluginBinding pluginBinding;
    private final Map<Class<? extends FlutterPlugin>, FlutterPlugin> plugins = new HashMap();
    private Service service;
    private final Map<Class<? extends FlutterPlugin>, ServiceAware> serviceAwarePlugins = new HashMap();
    private FlutterEngineServicePluginBinding servicePluginBinding;

    FlutterEnginePluginRegistry(Context appContext, FlutterEngine flutterEngine2, FlutterLoader flutterLoader) {
        this.flutterEngine = flutterEngine2;
        this.pluginBinding = new FlutterPlugin.FlutterPluginBinding(appContext, flutterEngine2, flutterEngine2.getDartExecutor(), flutterEngine2.getRenderer(), flutterEngine2.getPlatformViewsController().getRegistry(), new DefaultFlutterAssets(flutterLoader));
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        detachFromAndroidComponent();
        removeAll();
    }

    public void add(FlutterPlugin plugin) {
        if (has(plugin.getClass())) {
            Log.w(TAG, "Attempted to register plugin (" + plugin + ") but it was already registered with this FlutterEngine (" + this.flutterEngine + ").");
            return;
        }
        Log.v(TAG, "Adding plugin: " + plugin);
        this.plugins.put(plugin.getClass(), plugin);
        plugin.onAttachedToEngine(this.pluginBinding);
        if (plugin instanceof ActivityAware) {
            ActivityAware activityAware = (ActivityAware) plugin;
            this.activityAwarePlugins.put(plugin.getClass(), activityAware);
            if (isAttachedToActivity()) {
                activityAware.onAttachedToActivity(this.activityPluginBinding);
            }
        }
        if (plugin instanceof ServiceAware) {
            ServiceAware serviceAware = (ServiceAware) plugin;
            this.serviceAwarePlugins.put(plugin.getClass(), serviceAware);
            if (isAttachedToService()) {
                serviceAware.onAttachedToService(this.servicePluginBinding);
            }
        }
        if (plugin instanceof BroadcastReceiverAware) {
            BroadcastReceiverAware broadcastReceiverAware = (BroadcastReceiverAware) plugin;
            this.broadcastReceiverAwarePlugins.put(plugin.getClass(), broadcastReceiverAware);
            if (isAttachedToBroadcastReceiver()) {
                broadcastReceiverAware.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
            }
        }
        if (plugin instanceof ContentProviderAware) {
            ContentProviderAware contentProviderAware = (ContentProviderAware) plugin;
            this.contentProviderAwarePlugins.put(plugin.getClass(), contentProviderAware);
            if (isAttachedToContentProvider()) {
                contentProviderAware.onAttachedToContentProvider(this.contentProviderPluginBinding);
            }
        }
    }

    public void add(Set<FlutterPlugin> plugins2) {
        for (FlutterPlugin plugin : plugins2) {
            add(plugin);
        }
    }

    public boolean has(Class<? extends FlutterPlugin> pluginClass) {
        return this.plugins.containsKey(pluginClass);
    }

    public FlutterPlugin get(Class<? extends FlutterPlugin> pluginClass) {
        return this.plugins.get(pluginClass);
    }

    public void remove(Class<? extends FlutterPlugin> pluginClass) {
        FlutterPlugin plugin = this.plugins.get(pluginClass);
        if (plugin != null) {
            Log.v(TAG, "Removing plugin: " + plugin);
            if (plugin instanceof ActivityAware) {
                if (isAttachedToActivity()) {
                    ((ActivityAware) plugin).onDetachedFromActivity();
                }
                this.activityAwarePlugins.remove(pluginClass);
            }
            if (plugin instanceof ServiceAware) {
                if (isAttachedToService()) {
                    ((ServiceAware) plugin).onDetachedFromService();
                }
                this.serviceAwarePlugins.remove(pluginClass);
            }
            if (plugin instanceof BroadcastReceiverAware) {
                if (isAttachedToBroadcastReceiver()) {
                    ((BroadcastReceiverAware) plugin).onDetachedFromBroadcastReceiver();
                }
                this.broadcastReceiverAwarePlugins.remove(pluginClass);
            }
            if (plugin instanceof ContentProviderAware) {
                if (isAttachedToContentProvider()) {
                    ((ContentProviderAware) plugin).onDetachedFromContentProvider();
                }
                this.contentProviderAwarePlugins.remove(pluginClass);
            }
            plugin.onDetachedFromEngine(this.pluginBinding);
            this.plugins.remove(pluginClass);
        }
    }

    public void remove(Set<Class<? extends FlutterPlugin>> pluginClasses) {
        for (Class<? extends FlutterPlugin> pluginClass : pluginClasses) {
            remove(pluginClass);
        }
    }

    public void removeAll() {
        remove((Set<Class<? extends FlutterPlugin>>) new HashSet(this.plugins.keySet()));
        this.plugins.clear();
    }

    private void detachFromAndroidComponent() {
        if (isAttachedToActivity()) {
            detachFromActivity();
        } else if (isAttachedToService()) {
            detachFromService();
        } else if (isAttachedToBroadcastReceiver()) {
            detachFromBroadcastReceiver();
        } else if (isAttachedToContentProvider()) {
            detachFromContentProvider();
        }
    }

    private boolean isAttachedToActivity() {
        return this.activity != null;
    }

    public void attachToActivity(Activity activity2, Lifecycle lifecycle) {
        StringBuilder sb = new StringBuilder();
        sb.append("Attaching to an Activity: ");
        sb.append(activity2);
        sb.append(".");
        sb.append(this.isWaitingForActivityReattachment ? " This is after a config change." : "");
        Log.v(TAG, sb.toString());
        detachFromAndroidComponent();
        this.activity = activity2;
        this.activityPluginBinding = new FlutterEngineActivityPluginBinding(activity2, lifecycle);
        this.flutterEngine.getPlatformViewsController().attach(activity2, this.flutterEngine.getRenderer(), this.flutterEngine.getDartExecutor());
        for (ActivityAware activityAware : this.activityAwarePlugins.values()) {
            if (this.isWaitingForActivityReattachment) {
                activityAware.onReattachedToActivityForConfigChanges(this.activityPluginBinding);
            } else {
                activityAware.onAttachedToActivity(this.activityPluginBinding);
            }
        }
        this.isWaitingForActivityReattachment = false;
    }

    public void detachFromActivityForConfigChanges() {
        if (isAttachedToActivity()) {
            Log.v(TAG, "Detaching from an Activity for config changes: " + this.activity);
            this.isWaitingForActivityReattachment = true;
            for (ActivityAware activityAware : this.activityAwarePlugins.values()) {
                activityAware.onDetachedFromActivityForConfigChanges();
            }
            this.flutterEngine.getPlatformViewsController().detach();
            this.activity = null;
            this.activityPluginBinding = null;
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
    }

    public void detachFromActivity() {
        if (isAttachedToActivity()) {
            Log.v(TAG, "Detaching from an Activity: " + this.activity);
            for (ActivityAware activityAware : this.activityAwarePlugins.values()) {
                activityAware.onDetachedFromActivity();
            }
            this.flutterEngine.getPlatformViewsController().detach();
            this.activity = null;
            this.activityPluginBinding = null;
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
    }

    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResult) {
        Log.v(TAG, "Forwarding onRequestPermissionsResult() to plugins.");
        if (isAttachedToActivity()) {
            return this.activityPluginBinding.onRequestPermissionsResult(requestCode, permissions, grantResult);
        }
        Log.e(TAG, "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
        return false;
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v(TAG, "Forwarding onActivityResult() to plugins.");
        if (isAttachedToActivity()) {
            return this.activityPluginBinding.onActivityResult(requestCode, resultCode, data);
        }
        Log.e(TAG, "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
        return false;
    }

    public void onNewIntent(Intent intent) {
        Log.v(TAG, "Forwarding onNewIntent() to plugins.");
        if (isAttachedToActivity()) {
            this.activityPluginBinding.onNewIntent(intent);
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
        }
    }

    public void onUserLeaveHint() {
        Log.v(TAG, "Forwarding onUserLeaveHint() to plugins.");
        if (isAttachedToActivity()) {
            this.activityPluginBinding.onUserLeaveHint();
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Log.v(TAG, "Forwarding onSaveInstanceState() to plugins.");
        if (isAttachedToActivity()) {
            this.activityPluginBinding.onSaveInstanceState(bundle);
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        Log.v(TAG, "Forwarding onRestoreInstanceState() to plugins.");
        if (isAttachedToActivity()) {
            this.activityPluginBinding.onRestoreInstanceState(bundle);
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
        }
    }

    private boolean isAttachedToService() {
        return this.service != null;
    }

    public void attachToService(Service service2, Lifecycle lifecycle, boolean isForeground) {
        Log.v(TAG, "Attaching to a Service: " + service2);
        detachFromAndroidComponent();
        this.service = service2;
        this.servicePluginBinding = new FlutterEngineServicePluginBinding(service2, lifecycle);
        for (ServiceAware serviceAware : this.serviceAwarePlugins.values()) {
            serviceAware.onAttachedToService(this.servicePluginBinding);
        }
    }

    public void detachFromService() {
        if (isAttachedToService()) {
            Log.v(TAG, "Detaching from a Service: " + this.service);
            for (ServiceAware serviceAware : this.serviceAwarePlugins.values()) {
                serviceAware.onDetachedFromService();
            }
            this.service = null;
            this.servicePluginBinding = null;
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from a Service when no Service was attached.");
    }

    public void onMoveToForeground() {
        if (isAttachedToService()) {
            Log.v(TAG, "Attached Service moved to foreground.");
            this.servicePluginBinding.onMoveToForeground();
        }
    }

    public void onMoveToBackground() {
        if (isAttachedToService()) {
            Log.v(TAG, "Attached Service moved to background.");
            this.servicePluginBinding.onMoveToBackground();
        }
    }

    private boolean isAttachedToBroadcastReceiver() {
        return this.broadcastReceiver != null;
    }

    public void attachToBroadcastReceiver(BroadcastReceiver broadcastReceiver2, Lifecycle lifecycle) {
        Log.v(TAG, "Attaching to BroadcastReceiver: " + broadcastReceiver2);
        detachFromAndroidComponent();
        this.broadcastReceiver = broadcastReceiver2;
        this.broadcastReceiverPluginBinding = new FlutterEngineBroadcastReceiverPluginBinding(broadcastReceiver2);
        for (BroadcastReceiverAware broadcastReceiverAware : this.broadcastReceiverAwarePlugins.values()) {
            broadcastReceiverAware.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
        }
    }

    public void detachFromBroadcastReceiver() {
        if (isAttachedToBroadcastReceiver()) {
            Log.v(TAG, "Detaching from BroadcastReceiver: " + this.broadcastReceiver);
            for (BroadcastReceiverAware broadcastReceiverAware : this.broadcastReceiverAwarePlugins.values()) {
                broadcastReceiverAware.onDetachedFromBroadcastReceiver();
            }
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
    }

    private boolean isAttachedToContentProvider() {
        return this.contentProvider != null;
    }

    public void attachToContentProvider(ContentProvider contentProvider2, Lifecycle lifecycle) {
        Log.v(TAG, "Attaching to ContentProvider: " + contentProvider2);
        detachFromAndroidComponent();
        this.contentProvider = contentProvider2;
        this.contentProviderPluginBinding = new FlutterEngineContentProviderPluginBinding(contentProvider2);
        for (ContentProviderAware contentProviderAware : this.contentProviderAwarePlugins.values()) {
            contentProviderAware.onAttachedToContentProvider(this.contentProviderPluginBinding);
        }
    }

    public void detachFromContentProvider() {
        if (isAttachedToContentProvider()) {
            Log.v(TAG, "Detaching from ContentProvider: " + this.contentProvider);
            for (ContentProviderAware contentProviderAware : this.contentProviderAwarePlugins.values()) {
                contentProviderAware.onDetachedFromContentProvider();
            }
            return;
        }
        Log.e(TAG, "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
    }

    private static class DefaultFlutterAssets implements FlutterPlugin.FlutterAssets {
        final FlutterLoader flutterLoader;

        private DefaultFlutterAssets(FlutterLoader flutterLoader2) {
            this.flutterLoader = flutterLoader2;
        }

        public String getAssetFilePathByName(String assetFileName) {
            return this.flutterLoader.getLookupKeyForAsset(assetFileName);
        }

        public String getAssetFilePathByName(String assetFileName, String packageName) {
            return this.flutterLoader.getLookupKeyForAsset(assetFileName, packageName);
        }

        public String getAssetFilePathBySubpath(String assetSubpath) {
            return this.flutterLoader.getLookupKeyForAsset(assetSubpath);
        }

        public String getAssetFilePathBySubpath(String assetSubpath, String packageName) {
            return this.flutterLoader.getLookupKeyForAsset(assetSubpath, packageName);
        }
    }

    private static class FlutterEngineActivityPluginBinding implements ActivityPluginBinding {
        private final Activity activity;
        private final HiddenLifecycleReference hiddenLifecycleReference;
        private final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners = new HashSet();
        private final Set<PluginRegistry.NewIntentListener> onNewIntentListeners = new HashSet();
        private final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners = new HashSet();
        private final Set<ActivityPluginBinding.OnSaveInstanceStateListener> onSaveInstanceStateListeners = new HashSet();
        private final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners = new HashSet();

        public FlutterEngineActivityPluginBinding(Activity activity2, Lifecycle lifecycle) {
            this.activity = activity2;
            this.hiddenLifecycleReference = new HiddenLifecycleReference(lifecycle);
        }

        public Activity getActivity() {
            return this.activity;
        }

        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        public void addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener listener) {
            this.onRequestPermissionsResultListeners.add(listener);
        }

        public void removeRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener listener) {
            this.onRequestPermissionsResultListeners.remove(listener);
        }

        /* access modifiers changed from: package-private */
        public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResult) {
            boolean didConsumeResult = false;
            for (PluginRegistry.RequestPermissionsResultListener listener : this.onRequestPermissionsResultListeners) {
                didConsumeResult = listener.onRequestPermissionsResult(requestCode, permissions, grantResult) || didConsumeResult;
            }
            return didConsumeResult;
        }

        public void addActivityResultListener(PluginRegistry.ActivityResultListener listener) {
            this.onActivityResultListeners.add(listener);
        }

        public void removeActivityResultListener(PluginRegistry.ActivityResultListener listener) {
            this.onActivityResultListeners.remove(listener);
        }

        /* access modifiers changed from: package-private */
        public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
            boolean didConsumeResult = false;
            Iterator it = new HashSet(this.onActivityResultListeners).iterator();
            while (it.hasNext()) {
                didConsumeResult = ((PluginRegistry.ActivityResultListener) it.next()).onActivityResult(requestCode, resultCode, data) || didConsumeResult;
            }
            return didConsumeResult;
        }

        public void addOnNewIntentListener(PluginRegistry.NewIntentListener listener) {
            this.onNewIntentListeners.add(listener);
        }

        public void removeOnNewIntentListener(PluginRegistry.NewIntentListener listener) {
            this.onNewIntentListeners.remove(listener);
        }

        /* access modifiers changed from: package-private */
        public void onNewIntent(Intent intent) {
            for (PluginRegistry.NewIntentListener listener : this.onNewIntentListeners) {
                listener.onNewIntent(intent);
            }
        }

        public void addOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener listener) {
            this.onUserLeaveHintListeners.add(listener);
        }

        public void removeOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener listener) {
            this.onUserLeaveHintListeners.remove(listener);
        }

        public void addOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener listener) {
            this.onSaveInstanceStateListeners.add(listener);
        }

        public void removeOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener listener) {
            this.onSaveInstanceStateListeners.remove(listener);
        }

        /* access modifiers changed from: package-private */
        public void onUserLeaveHint() {
            for (PluginRegistry.UserLeaveHintListener listener : this.onUserLeaveHintListeners) {
                listener.onUserLeaveHint();
            }
        }

        /* access modifiers changed from: package-private */
        public void onSaveInstanceState(Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener listener : this.onSaveInstanceStateListeners) {
                listener.onSaveInstanceState(bundle);
            }
        }

        /* access modifiers changed from: package-private */
        public void onRestoreInstanceState(Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener listener : this.onSaveInstanceStateListeners) {
                listener.onRestoreInstanceState(bundle);
            }
        }
    }

    private static class FlutterEngineServicePluginBinding implements ServicePluginBinding {
        private final HiddenLifecycleReference hiddenLifecycleReference;
        private final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners = new HashSet();
        private final Service service;

        FlutterEngineServicePluginBinding(Service service2, Lifecycle lifecycle) {
            this.service = service2;
            this.hiddenLifecycleReference = lifecycle != null ? new HiddenLifecycleReference(lifecycle) : null;
        }

        public Service getService() {
            return this.service;
        }

        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        public void addOnModeChangeListener(ServiceAware.OnModeChangeListener listener) {
            this.onModeChangeListeners.add(listener);
        }

        public void removeOnModeChangeListener(ServiceAware.OnModeChangeListener listener) {
            this.onModeChangeListeners.remove(listener);
        }

        /* access modifiers changed from: package-private */
        public void onMoveToForeground() {
            for (ServiceAware.OnModeChangeListener listener : this.onModeChangeListeners) {
                listener.onMoveToForeground();
            }
        }

        /* access modifiers changed from: package-private */
        public void onMoveToBackground() {
            for (ServiceAware.OnModeChangeListener listener : this.onModeChangeListeners) {
                listener.onMoveToBackground();
            }
        }
    }

    private static class FlutterEngineBroadcastReceiverPluginBinding implements BroadcastReceiverPluginBinding {
        private final BroadcastReceiver broadcastReceiver;

        FlutterEngineBroadcastReceiverPluginBinding(BroadcastReceiver broadcastReceiver2) {
            this.broadcastReceiver = broadcastReceiver2;
        }

        public BroadcastReceiver getBroadcastReceiver() {
            return this.broadcastReceiver;
        }
    }

    private static class FlutterEngineContentProviderPluginBinding implements ContentProviderPluginBinding {
        private final ContentProvider contentProvider;

        FlutterEngineContentProviderPluginBinding(ContentProvider contentProvider2) {
            this.contentProvider = contentProvider2;
        }

        public ContentProvider getContentProvider() {
            return this.contentProvider;
        }
    }
}
