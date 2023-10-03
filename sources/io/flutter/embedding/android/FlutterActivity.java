package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.google.common.primitives.Ints;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.plugin.platform.PlatformPlugin;

public class FlutterActivity extends Activity implements FlutterActivityAndFragmentDelegate.Host, LifecycleOwner {
    private static final String TAG = "FlutterActivity";
    protected FlutterActivityAndFragmentDelegate delegate;
    private LifecycleRegistry lifecycle = new LifecycleRegistry(this);

    public static Intent createDefaultIntent(Context launchContext) {
        return withNewEngine().build(launchContext);
    }

    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(FlutterActivity.class);
    }

    public static class NewEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
        private String initialRoute = "/";

        public NewEngineIntentBuilder(Class<? extends FlutterActivity> activityClass2) {
            this.activityClass = activityClass2;
        }

        public NewEngineIntentBuilder initialRoute(String initialRoute2) {
            this.initialRoute = initialRoute2;
            return this;
        }

        public NewEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        public Intent build(Context context) {
            return new Intent(context, this.activityClass).putExtra("route", this.initialRoute).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", true);
        }
    }

    public static CachedEngineIntentBuilder withCachedEngine(String cachedEngineId) {
        return new CachedEngineIntentBuilder(FlutterActivity.class, cachedEngineId);
    }

    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
        private final String cachedEngineId;
        private boolean destroyEngineWithActivity = false;

        public CachedEngineIntentBuilder(Class<? extends FlutterActivity> activityClass2, String engineId) {
            this.activityClass = activityClass2;
            this.cachedEngineId = engineId;
        }

        public CachedEngineIntentBuilder destroyEngineWithActivity(boolean destroyEngineWithActivity2) {
            this.destroyEngineWithActivity = destroyEngineWithActivity2;
            return this;
        }

        public CachedEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        public Intent build(Context context) {
            return new Intent(context, this.activityClass).putExtra("cached_engine_id", this.cachedEngineId).putExtra("destroy_engine_with_activity", this.destroyEngineWithActivity).putExtra("background_mode", this.backgroundMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDelegate(FlutterActivityAndFragmentDelegate delegate2) {
        this.delegate = delegate2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        switchLaunchThemeForNormalTheme();
        super.onCreate(savedInstanceState);
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
        this.delegate = flutterActivityAndFragmentDelegate;
        flutterActivityAndFragmentDelegate.onAttach(this);
        this.delegate.onActivityCreated(savedInstanceState);
        configureWindowForTransparency();
        setContentView(createFlutterView());
        configureStatusBarForFullscreenFlutterExperience();
    }

    private void switchLaunchThemeForNormalTheme() {
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (activityInfo.metaData != null) {
                int normalThemeRID = activityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (normalThemeRID != -1) {
                    setTheme(normalThemeRID);
                }
                return;
            }
            Log.v(TAG, "Using the launch theme as normal theme.");
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    public SplashScreen provideSplashScreen() {
        Drawable manifestSplashDrawable = getSplashScreenFromManifest();
        if (manifestSplashDrawable != null) {
            return new DrawableSplashScreen(manifestSplashDrawable);
        }
        return null;
    }

    private Drawable getSplashScreenFromManifest() {
        try {
            Bundle metadata = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            int splashScreenId = metadata != null ? metadata.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (splashScreenId == 0) {
                return null;
            }
            if (Build.VERSION.SDK_INT > 21) {
                return getResources().getDrawable(splashScreenId, getTheme());
            }
            return getResources().getDrawable(splashScreenId);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private void configureWindowForTransparency() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private View createFlutterView() {
        return this.delegate.onCreateView((LayoutInflater) null, (ViewGroup) null, (Bundle) null);
    }

    private void configureStatusBarForFullscreenFlutterExperience() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Ints.MAX_POWER_OF_TWO);
            window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.delegate.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.delegate.onResume();
    }

    public void onPostResume() {
        super.onPostResume();
        this.delegate.onPostResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.delegate.onPause();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.delegate.onStop();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.delegate.onSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.delegate.onDestroyView();
        this.delegate.onDetach();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.delegate.onActivityResult(requestCode, resultCode, data);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.delegate.onNewIntent(intent);
    }

    public void onBackPressed() {
        this.delegate.onBackPressed();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        this.delegate.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void onUserLeaveHint() {
        this.delegate.onUserLeaveHint();
    }

    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        this.delegate.onTrimMemory(level);
    }

    public Context getContext() {
        return this;
    }

    public Activity getActivity() {
        return this;
    }

    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public FlutterShellArgs getFlutterShellArgs() {
        return FlutterShellArgs.fromIntent(getIntent());
    }

    public String getCachedEngineId() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    public boolean shouldDestroyEngineWithHost() {
        boolean explicitDestructionRequested = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        if (getCachedEngineId() != null || this.delegate.isFlutterEngineFromHost()) {
            return explicitDestructionRequested;
        }
        return getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    public String getDartEntrypointFunctionName() {
        try {
            Bundle metadata = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String desiredDartEntrypoint = metadata != null ? metadata.getString("io.flutter.Entrypoint") : null;
            if (desiredDartEntrypoint != null) {
                return desiredDartEntrypoint;
            }
            return "main";
        } catch (PackageManager.NameNotFoundException e) {
            return "main";
        }
    }

    public String getInitialRoute() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle metadata = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String desiredInitialRoute = metadata != null ? metadata.getString("io.flutter.InitialRoute") : null;
            if (desiredInitialRoute != null) {
                return desiredInitialRoute;
            }
            return "/";
        } catch (PackageManager.NameNotFoundException e) {
            return "/";
        }
    }

    public String getAppBundlePath() {
        String appBundlePath;
        if (!isDebuggable() || !"android.intent.action.RUN".equals(getIntent().getAction()) || (appBundlePath = getIntent().getDataString()) == null) {
            return null;
        }
        return appBundlePath;
    }

    private boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    public RenderMode getRenderMode() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? RenderMode.surface : RenderMode.texture;
    }

    public TransparencyMode getTransparencyMode() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? TransparencyMode.opaque : TransparencyMode.transparent;
    }

    /* access modifiers changed from: protected */
    public FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        if (getIntent().hasExtra("background_mode")) {
            return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
        }
        return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return null;
    }

    /* access modifiers changed from: protected */
    public FlutterEngine getFlutterEngine() {
        return this.delegate.getFlutterEngine();
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        if (activity != null) {
            return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel());
        }
        return null;
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        GeneratedPluginRegister.registerGeneratedPlugins(flutterEngine);
    }

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
    }

    public void onFlutterUiDisplayed() {
        if (Build.VERSION.SDK_INT >= 21) {
            reportFullyDrawn();
        }
    }

    public void onFlutterUiNoLongerDisplayed() {
    }

    public boolean shouldRestoreAndSaveState() {
        if (getIntent().hasExtra("enable_state_restoration")) {
            return getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        if (getCachedEngineId() != null) {
            return false;
        }
        return true;
    }
}
