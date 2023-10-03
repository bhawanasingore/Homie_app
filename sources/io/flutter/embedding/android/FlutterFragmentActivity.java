package io.flutter.embedding.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.common.primitives.Ints;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.plugin.platform.PlatformPlugin;

public class FlutterFragmentActivity extends FragmentActivity implements SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator {
    private static final int FRAGMENT_CONTAINER_ID = 609893468;
    private static final String TAG = "FlutterFragmentActivity";
    private static final String TAG_FLUTTER_FRAGMENT = "flutter_fragment";
    private FlutterFragment flutterFragment;

    public static Intent createDefaultIntent(Context launchContext) {
        return withNewEngine().build(launchContext);
    }

    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(FlutterFragmentActivity.class);
    }

    public static class NewEngineIntentBuilder {
        private final Class<? extends FlutterFragmentActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
        private String initialRoute = "/";

        public NewEngineIntentBuilder(Class<? extends FlutterFragmentActivity> activityClass2) {
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
        return new CachedEngineIntentBuilder(FlutterFragmentActivity.class, cachedEngineId);
    }

    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterFragmentActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
        private final String cachedEngineId;
        private boolean destroyEngineWithActivity = false;

        public CachedEngineIntentBuilder(Class<? extends FlutterFragmentActivity> activityClass2, String engineId) {
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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        switchLaunchThemeForNormalTheme();
        super.onCreate(savedInstanceState);
        configureWindowForTransparency();
        setContentView(createFragmentContainer());
        configureStatusBarForFullscreenFlutterExperience();
        ensureFlutterFragmentCreated();
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
            Log.e(TAG, "Could not read meta-data for FlutterFragmentActivity. Using the launch theme as normal theme.");
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
            Integer splashScreenId = metadata != null ? Integer.valueOf(metadata.getInt("io.flutter.embedding.android.SplashScreenDrawable")) : null;
            if (splashScreenId == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT > 21) {
                return getResources().getDrawable(splashScreenId.intValue(), getTheme());
            }
            return getResources().getDrawable(splashScreenId.intValue());
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private void configureWindowForTransparency() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private View createFragmentContainer() {
        FrameLayout container = new FrameLayout(this);
        container.setId(FRAGMENT_CONTAINER_ID);
        container.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return container;
    }

    private void ensureFlutterFragmentCreated() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FlutterFragment flutterFragment2 = (FlutterFragment) fragmentManager.findFragmentByTag(TAG_FLUTTER_FRAGMENT);
        this.flutterFragment = flutterFragment2;
        if (flutterFragment2 == null) {
            this.flutterFragment = createFlutterFragment();
            fragmentManager.beginTransaction().add(FRAGMENT_CONTAINER_ID, this.flutterFragment, TAG_FLUTTER_FRAGMENT).commit();
        }
    }

    /* access modifiers changed from: protected */
    public FlutterFragment createFlutterFragment() {
        FlutterActivityLaunchConfigs.BackgroundMode backgroundMode = getBackgroundMode();
        RenderMode renderMode = getRenderMode();
        TransparencyMode transparencyMode = backgroundMode == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? TransparencyMode.opaque : TransparencyMode.transparent;
        if (getCachedEngineId() != null) {
            Log.v(TAG, "Creating FlutterFragment with cached engine:\nCached engine ID: " + getCachedEngineId() + "\nWill destroy engine when Activity is destroyed: " + shouldDestroyEngineWithHost() + "\nBackground transparency mode: " + backgroundMode + "\nWill attach FlutterEngine to Activity: " + shouldAttachEngineToActivity());
            return FlutterFragment.withCachedEngine(getCachedEngineId()).renderMode(renderMode).transparencyMode(transparencyMode).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).destroyEngineWithFragment(shouldDestroyEngineWithHost()).build();
        }
        Log.v(TAG, "Creating FlutterFragment with new engine:\nBackground transparency mode: " + backgroundMode + "\nDart entrypoint: " + getDartEntrypointFunctionName() + "\nInitial route: " + getInitialRoute() + "\nApp bundle path: " + getAppBundlePath() + "\nWill attach FlutterEngine to Activity: " + shouldAttachEngineToActivity());
        return FlutterFragment.withNewEngine().dartEntrypoint(getDartEntrypointFunctionName()).initialRoute(getInitialRoute()).appBundlePath(getAppBundlePath()).flutterShellArgs(FlutterShellArgs.fromIntent(getIntent())).renderMode(renderMode).transparencyMode(transparencyMode).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).build();
    }

    private void configureStatusBarForFullscreenFlutterExperience() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Ints.MAX_POWER_OF_TWO);
            window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        }
    }

    public void onPostResume() {
        super.onPostResume();
        this.flutterFragment.onPostResume();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        this.flutterFragment.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    public void onBackPressed() {
        this.flutterFragment.onBackPressed();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        this.flutterFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void onUserLeaveHint() {
        this.flutterFragment.onUserLeaveHint();
    }

    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        this.flutterFragment.onTrimMemory(level);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.flutterFragment.onActivityResult(requestCode, resultCode, data);
    }

    /* access modifiers changed from: protected */
    public FlutterEngine getFlutterEngine() {
        return this.flutterFragment.getFlutterEngine();
    }

    public boolean shouldDestroyEngineWithHost() {
        return getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    }

    /* access modifiers changed from: protected */
    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return null;
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        GeneratedPluginRegister.registerGeneratedPlugins(flutterEngine);
    }

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
    }

    /* access modifiers changed from: protected */
    public String getAppBundlePath() {
        String appBundlePath;
        if (!isDebuggable() || !"android.intent.action.RUN".equals(getIntent().getAction()) || (appBundlePath = getIntent().getDataString()) == null) {
            return null;
        }
        return appBundlePath;
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

    /* access modifiers changed from: protected */
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

    /* access modifiers changed from: protected */
    public String getCachedEngineId() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    /* access modifiers changed from: protected */
    public FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        if (getIntent().hasExtra("background_mode")) {
            return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
        }
        return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    /* access modifiers changed from: protected */
    public RenderMode getRenderMode() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? RenderMode.surface : RenderMode.texture;
    }

    private boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) != 0;
    }
}
