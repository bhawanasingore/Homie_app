package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;

public class FlutterFragment extends Fragment implements FlutterActivityAndFragmentDelegate.Host {
    protected static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
    protected static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
    protected static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
    protected static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
    protected static final String ARG_ENABLE_STATE_RESTORATION = "enable_state_restoration";
    protected static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
    protected static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
    protected static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
    protected static final String ARG_INITIAL_ROUTE = "initial_route";
    protected static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
    private static final String TAG = "FlutterFragment";
    FlutterActivityAndFragmentDelegate delegate;

    @interface ActivityCallThrough {
    }

    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public static FlutterFragment createDefault() {
        return new NewEngineFragmentBuilder().build();
    }

    public static NewEngineFragmentBuilder withNewEngine() {
        return new NewEngineFragmentBuilder();
    }

    public static class NewEngineFragmentBuilder {
        private String appBundlePath;
        private String dartEntrypoint;
        private final Class<? extends FlutterFragment> fragmentClass;
        private String initialRoute;
        private RenderMode renderMode;
        private FlutterShellArgs shellArgs;
        private boolean shouldAttachEngineToActivity;
        private TransparencyMode transparencyMode;

        public NewEngineFragmentBuilder() {
            this.dartEntrypoint = "main";
            this.initialRoute = "/";
            this.appBundlePath = null;
            this.shellArgs = null;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.fragmentClass = FlutterFragment.class;
        }

        public NewEngineFragmentBuilder(Class<? extends FlutterFragment> subclass) {
            this.dartEntrypoint = "main";
            this.initialRoute = "/";
            this.appBundlePath = null;
            this.shellArgs = null;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.fragmentClass = subclass;
        }

        public NewEngineFragmentBuilder dartEntrypoint(String dartEntrypoint2) {
            this.dartEntrypoint = dartEntrypoint2;
            return this;
        }

        public NewEngineFragmentBuilder initialRoute(String initialRoute2) {
            this.initialRoute = initialRoute2;
            return this;
        }

        public NewEngineFragmentBuilder appBundlePath(String appBundlePath2) {
            this.appBundlePath = appBundlePath2;
            return this;
        }

        public NewEngineFragmentBuilder flutterShellArgs(FlutterShellArgs shellArgs2) {
            this.shellArgs = shellArgs2;
            return this;
        }

        public NewEngineFragmentBuilder renderMode(RenderMode renderMode2) {
            this.renderMode = renderMode2;
            return this;
        }

        public NewEngineFragmentBuilder transparencyMode(TransparencyMode transparencyMode2) {
            this.transparencyMode = transparencyMode2;
            return this;
        }

        public NewEngineFragmentBuilder shouldAttachEngineToActivity(boolean shouldAttachEngineToActivity2) {
            this.shouldAttachEngineToActivity = shouldAttachEngineToActivity2;
            return this;
        }

        /* access modifiers changed from: protected */
        public Bundle createArgs() {
            Bundle args = new Bundle();
            args.putString(FlutterFragment.ARG_INITIAL_ROUTE, this.initialRoute);
            args.putString(FlutterFragment.ARG_APP_BUNDLE_PATH, this.appBundlePath);
            args.putString(FlutterFragment.ARG_DART_ENTRYPOINT, this.dartEntrypoint);
            FlutterShellArgs flutterShellArgs = this.shellArgs;
            if (flutterShellArgs != null) {
                args.putStringArray(FlutterFragment.ARG_FLUTTER_INITIALIZATION_ARGS, flutterShellArgs.toArray());
            }
            RenderMode renderMode2 = this.renderMode;
            if (renderMode2 == null) {
                renderMode2 = RenderMode.surface;
            }
            args.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, renderMode2.name());
            TransparencyMode transparencyMode2 = this.transparencyMode;
            if (transparencyMode2 == null) {
                transparencyMode2 = TransparencyMode.transparent;
            }
            args.putString(FlutterFragment.ARG_FLUTTERVIEW_TRANSPARENCY_MODE, transparencyMode2.name());
            args.putBoolean(FlutterFragment.ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY, this.shouldAttachEngineToActivity);
            args.putBoolean(FlutterFragment.ARG_DESTROY_ENGINE_WITH_FRAGMENT, true);
            return args;
        }

        public <T extends FlutterFragment> T build() {
            try {
                T frag = (FlutterFragment) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (frag != null) {
                    frag.setArguments(createArgs());
                    return frag;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + ")", e);
            }
        }
    }

    public static CachedEngineFragmentBuilder withCachedEngine(String engineId) {
        return new CachedEngineFragmentBuilder(engineId);
    }

    public static class CachedEngineFragmentBuilder {
        private boolean destroyEngineWithFragment;
        private final String engineId;
        private final Class<? extends FlutterFragment> fragmentClass;
        private RenderMode renderMode;
        private boolean shouldAttachEngineToActivity;
        private TransparencyMode transparencyMode;

        private CachedEngineFragmentBuilder(String engineId2) {
            this((Class<? extends FlutterFragment>) FlutterFragment.class, engineId2);
        }

        protected CachedEngineFragmentBuilder(Class<? extends FlutterFragment> subclass, String engineId2) {
            this.destroyEngineWithFragment = false;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.fragmentClass = subclass;
            this.engineId = engineId2;
        }

        public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean destroyEngineWithFragment2) {
            this.destroyEngineWithFragment = destroyEngineWithFragment2;
            return this;
        }

        public CachedEngineFragmentBuilder renderMode(RenderMode renderMode2) {
            this.renderMode = renderMode2;
            return this;
        }

        public CachedEngineFragmentBuilder transparencyMode(TransparencyMode transparencyMode2) {
            this.transparencyMode = transparencyMode2;
            return this;
        }

        public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean shouldAttachEngineToActivity2) {
            this.shouldAttachEngineToActivity = shouldAttachEngineToActivity2;
            return this;
        }

        /* access modifiers changed from: protected */
        public Bundle createArgs() {
            Bundle args = new Bundle();
            args.putString(FlutterFragment.ARG_CACHED_ENGINE_ID, this.engineId);
            args.putBoolean(FlutterFragment.ARG_DESTROY_ENGINE_WITH_FRAGMENT, this.destroyEngineWithFragment);
            RenderMode renderMode2 = this.renderMode;
            if (renderMode2 == null) {
                renderMode2 = RenderMode.surface;
            }
            args.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, renderMode2.name());
            TransparencyMode transparencyMode2 = this.transparencyMode;
            if (transparencyMode2 == null) {
                transparencyMode2 = TransparencyMode.transparent;
            }
            args.putString(FlutterFragment.ARG_FLUTTERVIEW_TRANSPARENCY_MODE, transparencyMode2.name());
            args.putBoolean(FlutterFragment.ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY, this.shouldAttachEngineToActivity);
            return args;
        }

        public <T extends FlutterFragment> T build() {
            try {
                T frag = (FlutterFragment) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (frag != null) {
                    frag.setArguments(createArgs());
                    return frag;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + ")", e);
            }
        }
    }

    public FlutterFragment() {
        setArguments(new Bundle());
    }

    /* access modifiers changed from: package-private */
    public void setDelegate(FlutterActivityAndFragmentDelegate delegate2) {
        this.delegate = delegate2;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
        this.delegate = flutterActivityAndFragmentDelegate;
        flutterActivityAndFragmentDelegate.onAttach(context);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.delegate.onCreateView(inflater, container, savedInstanceState);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.delegate.onActivityCreated(savedInstanceState);
    }

    public void onStart() {
        super.onStart();
        this.delegate.onStart();
    }

    public void onResume() {
        super.onResume();
        this.delegate.onResume();
    }

    public void onPostResume() {
        this.delegate.onPostResume();
    }

    public void onPause() {
        super.onPause();
        this.delegate.onPause();
    }

    public void onStop() {
        super.onStop();
        this.delegate.onStop();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.delegate.onDestroyView();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.delegate.onSaveInstanceState(outState);
    }

    public void onDetach() {
        super.onDetach();
        this.delegate.onDetach();
        this.delegate.release();
        this.delegate = null;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        this.delegate.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void onNewIntent(Intent intent) {
        this.delegate.onNewIntent(intent);
    }

    public void onBackPressed() {
        this.delegate.onBackPressed();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.delegate.onActivityResult(requestCode, resultCode, data);
    }

    public void onUserLeaveHint() {
        this.delegate.onUserLeaveHint();
    }

    public void onTrimMemory(int level) {
        this.delegate.onTrimMemory(level);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.delegate.onLowMemory();
    }

    public FlutterShellArgs getFlutterShellArgs() {
        String[] flutterShellArgsArray = getArguments().getStringArray(ARG_FLUTTER_INITIALIZATION_ARGS);
        return new FlutterShellArgs(flutterShellArgsArray != null ? flutterShellArgsArray : new String[0]);
    }

    public String getCachedEngineId() {
        return getArguments().getString(ARG_CACHED_ENGINE_ID, (String) null);
    }

    public boolean shouldDestroyEngineWithHost() {
        boolean explicitDestructionRequested = getArguments().getBoolean(ARG_DESTROY_ENGINE_WITH_FRAGMENT, false);
        if (getCachedEngineId() != null || this.delegate.isFlutterEngineFromHost()) {
            return explicitDestructionRequested;
        }
        return getArguments().getBoolean(ARG_DESTROY_ENGINE_WITH_FRAGMENT, true);
    }

    public String getDartEntrypointFunctionName() {
        return getArguments().getString(ARG_DART_ENTRYPOINT, "main");
    }

    public String getAppBundlePath() {
        return getArguments().getString(ARG_APP_BUNDLE_PATH);
    }

    public String getInitialRoute() {
        return getArguments().getString(ARG_INITIAL_ROUTE);
    }

    public RenderMode getRenderMode() {
        return RenderMode.valueOf(getArguments().getString(ARG_FLUTTERVIEW_RENDER_MODE, RenderMode.surface.name()));
    }

    public TransparencyMode getTransparencyMode() {
        return TransparencyMode.valueOf(getArguments().getString(ARG_FLUTTERVIEW_TRANSPARENCY_MODE, TransparencyMode.transparent.name()));
    }

    public SplashScreen provideSplashScreen() {
        FragmentActivity parentActivity = getActivity();
        if (parentActivity instanceof SplashScreenProvider) {
            return ((SplashScreenProvider) parentActivity).provideSplashScreen();
        }
        return null;
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        FragmentActivity attachedActivity = getActivity();
        if (!(attachedActivity instanceof FlutterEngineProvider)) {
            return null;
        }
        Log.v(TAG, "Deferring to attached Activity to provide a FlutterEngine.");
        return ((FlutterEngineProvider) attachedActivity).provideFlutterEngine(getContext());
    }

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
        FragmentActivity attachedActivity = getActivity();
        if (attachedActivity instanceof FlutterEngineConfigurator) {
            ((FlutterEngineConfigurator) attachedActivity).configureFlutterEngine(flutterEngine);
        }
    }

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
        FragmentActivity attachedActivity = getActivity();
        if (attachedActivity instanceof FlutterEngineConfigurator) {
            ((FlutterEngineConfigurator) attachedActivity).cleanUpFlutterEngine(flutterEngine);
        }
    }

    public boolean shouldAttachEngineToActivity() {
        return getArguments().getBoolean(ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY);
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
    }

    public void onFlutterUiDisplayed() {
        FragmentActivity attachedActivity = getActivity();
        if (attachedActivity instanceof FlutterUiDisplayListener) {
            ((FlutterUiDisplayListener) attachedActivity).onFlutterUiDisplayed();
        }
    }

    public void onFlutterUiNoLongerDisplayed() {
        FragmentActivity attachedActivity = getActivity();
        if (attachedActivity instanceof FlutterUiDisplayListener) {
            ((FlutterUiDisplayListener) attachedActivity).onFlutterUiNoLongerDisplayed();
        }
    }

    public boolean shouldRestoreAndSaveState() {
        if (getArguments().containsKey(ARG_ENABLE_STATE_RESTORATION)) {
            return getArguments().getBoolean(ARG_ENABLE_STATE_RESTORATION);
        }
        if (getCachedEngineId() != null) {
            return false;
        }
        return true;
    }
}
