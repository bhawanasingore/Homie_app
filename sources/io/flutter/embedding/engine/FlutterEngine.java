package io.flutter.embedding.engine;

import android.content.Context;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashSet;
import java.util.Set;

public class FlutterEngine {
    private static final String TAG = "FlutterEngine";
    private final AccessibilityChannel accessibilityChannel;
    private final DartExecutor dartExecutor;
    private final EngineLifecycleListener engineLifecycleListener;
    /* access modifiers changed from: private */
    public final Set<EngineLifecycleListener> engineLifecycleListeners;
    private final FlutterJNI flutterJNI;
    private final KeyEventChannel keyEventChannel;
    private final LifecycleChannel lifecycleChannel;
    private final LocalizationChannel localizationChannel;
    private final LocalizationPlugin localizationPlugin;
    private final MouseCursorChannel mouseCursorChannel;
    private final NavigationChannel navigationChannel;
    private final PlatformChannel platformChannel;
    /* access modifiers changed from: private */
    public final PlatformViewsController platformViewsController;
    private final FlutterEnginePluginRegistry pluginRegistry;
    private final FlutterRenderer renderer;
    /* access modifiers changed from: private */
    public final RestorationChannel restorationChannel;
    private final SettingsChannel settingsChannel;
    private final SystemChannel systemChannel;
    private final TextInputChannel textInputChannel;

    public interface EngineLifecycleListener {
        void onPreEngineRestart();
    }

    public FlutterEngine(Context context) {
        this(context, (String[]) null);
    }

    public FlutterEngine(Context context, String[] dartVmArgs) {
        this(context, (FlutterLoader) null, new FlutterJNI(), dartVmArgs, true);
    }

    public FlutterEngine(Context context, String[] dartVmArgs, boolean automaticallyRegisterPlugins) {
        this(context, (FlutterLoader) null, new FlutterJNI(), dartVmArgs, automaticallyRegisterPlugins);
    }

    public FlutterEngine(Context context, String[] dartVmArgs, boolean automaticallyRegisterPlugins, boolean waitForRestorationData) {
        this(context, (FlutterLoader) null, new FlutterJNI(), new PlatformViewsController(), dartVmArgs, automaticallyRegisterPlugins, waitForRestorationData);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI2) {
        this(context, flutterLoader, flutterJNI2, (String[]) null, true);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI2, String[] dartVmArgs, boolean automaticallyRegisterPlugins) {
        this(context, flutterLoader, flutterJNI2, new PlatformViewsController(), dartVmArgs, automaticallyRegisterPlugins);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI2, PlatformViewsController platformViewsController2, String[] dartVmArgs, boolean automaticallyRegisterPlugins) {
        this(context, flutterLoader, flutterJNI2, platformViewsController2, dartVmArgs, automaticallyRegisterPlugins, false);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI2, PlatformViewsController platformViewsController2, String[] dartVmArgs, boolean automaticallyRegisterPlugins, boolean waitForRestorationData) {
        this.engineLifecycleListeners = new HashSet();
        this.engineLifecycleListener = new EngineLifecycleListener() {
            public void onPreEngineRestart() {
                Log.v(FlutterEngine.TAG, "onPreEngineRestart()");
                for (EngineLifecycleListener lifecycleListener : FlutterEngine.this.engineLifecycleListeners) {
                    lifecycleListener.onPreEngineRestart();
                }
                FlutterEngine.this.platformViewsController.onPreEngineRestart();
                FlutterEngine.this.restorationChannel.clearData();
            }
        };
        DartExecutor dartExecutor2 = new DartExecutor(flutterJNI2, context.getAssets());
        this.dartExecutor = dartExecutor2;
        dartExecutor2.onAttachedToJNI();
        this.accessibilityChannel = new AccessibilityChannel(this.dartExecutor, flutterJNI2);
        this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
        this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
        this.localizationChannel = new LocalizationChannel(this.dartExecutor);
        this.mouseCursorChannel = new MouseCursorChannel(this.dartExecutor);
        this.navigationChannel = new NavigationChannel(this.dartExecutor);
        this.platformChannel = new PlatformChannel(this.dartExecutor);
        this.restorationChannel = new RestorationChannel(this.dartExecutor, waitForRestorationData);
        this.settingsChannel = new SettingsChannel(this.dartExecutor);
        this.systemChannel = new SystemChannel(this.dartExecutor);
        this.textInputChannel = new TextInputChannel(this.dartExecutor);
        this.localizationPlugin = new LocalizationPlugin(context, this.localizationChannel);
        this.flutterJNI = flutterJNI2;
        flutterLoader = flutterLoader == null ? FlutterInjector.instance().flutterLoader() : flutterLoader;
        flutterLoader.startInitialization(context.getApplicationContext());
        flutterLoader.ensureInitializationComplete(context, dartVmArgs);
        flutterJNI2.addEngineLifecycleListener(this.engineLifecycleListener);
        flutterJNI2.setPlatformViewsController(platformViewsController2);
        flutterJNI2.setLocalizationPlugin(this.localizationPlugin);
        attachToJni();
        this.renderer = new FlutterRenderer(flutterJNI2);
        this.platformViewsController = platformViewsController2;
        platformViewsController2.onAttachedToJNI();
        this.pluginRegistry = new FlutterEnginePluginRegistry(context.getApplicationContext(), this, flutterLoader);
        if (automaticallyRegisterPlugins) {
            registerPlugins();
        }
    }

    private void attachToJni() {
        Log.v(TAG, "Attaching to JNI.");
        this.flutterJNI.attachToNative(false);
        if (!isAttachedToJni()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean isAttachedToJni() {
        return this.flutterJNI.isAttached();
    }

    private void registerPlugins() {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[]{FlutterEngine.class}).invoke((Object) null, new Object[]{this});
        } catch (Exception e) {
            Log.w(TAG, "Tried to automatically register plugins with FlutterEngine (" + this + ") but could not find and invoke the GeneratedPluginRegistrant.");
        }
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        this.pluginRegistry.destroy();
        this.platformViewsController.onDetachedFromJNI();
        this.dartExecutor.onDetachedFromJNI();
        this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
        this.flutterJNI.detachFromNativeAndReleaseResources();
    }

    public void addEngineLifecycleListener(EngineLifecycleListener listener) {
        this.engineLifecycleListeners.add(listener);
    }

    public void removeEngineLifecycleListener(EngineLifecycleListener listener) {
        this.engineLifecycleListeners.remove(listener);
    }

    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    public FlutterRenderer getRenderer() {
        return this.renderer;
    }

    public AccessibilityChannel getAccessibilityChannel() {
        return this.accessibilityChannel;
    }

    public KeyEventChannel getKeyEventChannel() {
        return this.keyEventChannel;
    }

    public LifecycleChannel getLifecycleChannel() {
        return this.lifecycleChannel;
    }

    public LocalizationChannel getLocalizationChannel() {
        return this.localizationChannel;
    }

    public NavigationChannel getNavigationChannel() {
        return this.navigationChannel;
    }

    public PlatformChannel getPlatformChannel() {
        return this.platformChannel;
    }

    public RestorationChannel getRestorationChannel() {
        return this.restorationChannel;
    }

    public SettingsChannel getSettingsChannel() {
        return this.settingsChannel;
    }

    public SystemChannel getSystemChannel() {
        return this.systemChannel;
    }

    public MouseCursorChannel getMouseCursorChannel() {
        return this.mouseCursorChannel;
    }

    public TextInputChannel getTextInputChannel() {
        return this.textInputChannel;
    }

    public PluginRegistry getPlugins() {
        return this.pluginRegistry;
    }

    public LocalizationPlugin getLocalizationPlugin() {
        return this.localizationPlugin;
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.platformViewsController;
    }

    public ActivityControlSurface getActivityControlSurface() {
        return this.pluginRegistry;
    }

    public ServiceControlSurface getServiceControlSurface() {
        return this.pluginRegistry;
    }

    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.pluginRegistry;
    }

    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.pluginRegistry;
    }
}
