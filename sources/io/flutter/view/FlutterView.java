package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.android.AndroidKeyProcessor;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterView extends SurfaceView implements BinaryMessenger, TextureRegistry, MouseCursorPlugin.MouseCursorViewDelegate {
    private static final String TAG = "FlutterView";
    private final AndroidKeyProcessor androidKeyProcessor;
    private final AndroidTouchProcessor androidTouchProcessor;
    private final DartExecutor dartExecutor;
    private boolean didRenderFirstFrame;
    private final FlutterRenderer flutterRenderer;
    private final KeyEventChannel keyEventChannel;
    private final LifecycleChannel lifecycleChannel;
    private final LocalizationChannel localizationChannel;
    private AccessibilityBridge mAccessibilityNodeProvider;
    private final List<ActivityLifecycleListener> mActivityLifecycleListeners;
    private final List<FirstFrameListener> mFirstFrameListeners;
    private final InputMethodManager mImm;
    private boolean mIsSoftwareRenderingEnabled;
    private final LocalizationPlugin mLocalizationPlugin;
    private final ViewportMetrics mMetrics;
    private final MouseCursorPlugin mMouseCursorPlugin;
    /* access modifiers changed from: private */
    public FlutterNativeView mNativeView;
    private final SurfaceHolder.Callback mSurfaceCallback;
    private final TextInputPlugin mTextInputPlugin;
    private final NavigationChannel navigationChannel;
    private final AtomicLong nextTextureId;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    private final PlatformChannel platformChannel;
    private final SettingsChannel settingsChannel;
    private final SystemChannel systemChannel;

    public interface FirstFrameListener {
        void onFirstFrame();
    }

    public interface Provider {
        FlutterView getFlutterView();
    }

    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    static final class ViewportMetrics {
        float devicePixelRatio = 1.0f;
        int physicalHeight = 0;
        int physicalPaddingBottom = 0;
        int physicalPaddingLeft = 0;
        int physicalPaddingRight = 0;
        int physicalPaddingTop = 0;
        int physicalViewInsetBottom = 0;
        int physicalViewInsetLeft = 0;
        int physicalViewInsetRight = 0;
        int physicalViewInsetTop = 0;
        int physicalWidth = 0;
        int systemGestureInsetBottom = 0;
        int systemGestureInsetLeft = 0;
        int systemGestureInsetRight = 0;
        int systemGestureInsetTop = 0;

        ViewportMetrics() {
        }
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlutterView(Context context, AttributeSet attrs) {
        this(context, attrs, (FlutterNativeView) null);
    }

    public FlutterView(Context context, AttributeSet attrs, FlutterNativeView nativeView) {
        super(context, attrs);
        this.nextTextureId = new AtomicLong(0);
        this.mIsSoftwareRenderingEnabled = false;
        this.didRenderFirstFrame = false;
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean isAccessibilityEnabled, boolean isTouchExplorationEnabled) {
                FlutterView.this.resetWillNotDraw(isAccessibilityEnabled, isTouchExplorationEnabled);
            }
        };
        Activity activity = getActivity(getContext());
        if (activity != null) {
            if (nativeView == null) {
                this.mNativeView = new FlutterNativeView(activity.getApplicationContext());
            } else {
                this.mNativeView = nativeView;
            }
            this.dartExecutor = this.mNativeView.getDartExecutor();
            this.flutterRenderer = new FlutterRenderer(this.mNativeView.getFlutterJNI());
            this.mIsSoftwareRenderingEnabled = this.mNativeView.getFlutterJNI().getIsSoftwareRenderingEnabled();
            ViewportMetrics viewportMetrics = new ViewportMetrics();
            this.mMetrics = viewportMetrics;
            viewportMetrics.devicePixelRatio = context.getResources().getDisplayMetrics().density;
            setFocusable(true);
            setFocusableInTouchMode(true);
            this.mNativeView.attachViewAndActivity(this, activity);
            this.mSurfaceCallback = new SurfaceHolder.Callback() {
                public void surfaceCreated(SurfaceHolder holder) {
                    FlutterView.this.assertAttached();
                    FlutterView.this.mNativeView.getFlutterJNI().onSurfaceCreated(holder.getSurface());
                }

                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                    FlutterView.this.assertAttached();
                    FlutterView.this.mNativeView.getFlutterJNI().onSurfaceChanged(width, height);
                }

                public void surfaceDestroyed(SurfaceHolder holder) {
                    FlutterView.this.assertAttached();
                    FlutterView.this.mNativeView.getFlutterJNI().onSurfaceDestroyed();
                }
            };
            getHolder().addCallback(this.mSurfaceCallback);
            this.mActivityLifecycleListeners = new ArrayList();
            this.mFirstFrameListeners = new ArrayList();
            this.navigationChannel = new NavigationChannel(this.dartExecutor);
            this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
            this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
            this.localizationChannel = new LocalizationChannel(this.dartExecutor);
            this.platformChannel = new PlatformChannel(this.dartExecutor);
            this.systemChannel = new SystemChannel(this.dartExecutor);
            this.settingsChannel = new SettingsChannel(this.dartExecutor);
            final PlatformPlugin platformPlugin = new PlatformPlugin(activity, this.platformChannel);
            addActivityLifecycleListener(new ActivityLifecycleListener() {
                public void onPostResume() {
                    platformPlugin.updateSystemUiOverlays();
                }
            });
            this.mImm = (InputMethodManager) getContext().getSystemService("input_method");
            PlatformViewsController platformViewsController = this.mNativeView.getPluginRegistry().getPlatformViewsController();
            this.mTextInputPlugin = new TextInputPlugin(this, new TextInputChannel(this.dartExecutor), platformViewsController);
            if (Build.VERSION.SDK_INT >= 24) {
                this.mMouseCursorPlugin = new MouseCursorPlugin(this, new MouseCursorChannel(this.dartExecutor));
            } else {
                this.mMouseCursorPlugin = null;
            }
            this.mLocalizationPlugin = new LocalizationPlugin(context, this.localizationChannel);
            this.androidKeyProcessor = new AndroidKeyProcessor(this, this.keyEventChannel, this.mTextInputPlugin);
            this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterRenderer, false);
            platformViewsController.attachToFlutterRenderer(this.flutterRenderer);
            this.mNativeView.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(this.mTextInputPlugin);
            this.mNativeView.getFlutterJNI().setLocalizationPlugin(this.mLocalizationPlugin);
            this.mLocalizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
            sendUserPlatformSettingsToDart();
            return;
        }
        throw new IllegalArgumentException("Bad context");
    }

    private static Activity getActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (!isAttached()) {
            return super.onKeyUp(keyCode, event);
        }
        return this.androidKeyProcessor.onKeyUp(event) || super.onKeyUp(keyCode, event);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (!isAttached()) {
            return super.onKeyDown(keyCode, event);
        }
        return this.androidKeyProcessor.onKeyDown(event) || super.onKeyDown(keyCode, event);
    }

    public FlutterNativeView getFlutterNativeView() {
        return this.mNativeView;
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.mNativeView.getPluginRegistry();
    }

    public String getLookupKeyForAsset(String asset) {
        return FlutterMain.getLookupKeyForAsset(asset);
    }

    public String getLookupKeyForAsset(String asset, String packageName) {
        return FlutterMain.getLookupKeyForAsset(asset, packageName);
    }

    public void addActivityLifecycleListener(ActivityLifecycleListener listener) {
        this.mActivityLifecycleListeners.add(listener);
    }

    public void onStart() {
        this.lifecycleChannel.appIsInactive();
    }

    public void onPause() {
        this.lifecycleChannel.appIsInactive();
    }

    public void onPostResume() {
        for (ActivityLifecycleListener listener : this.mActivityLifecycleListeners) {
            listener.onPostResume();
        }
        this.lifecycleChannel.appIsResumed();
    }

    public void onStop() {
        this.lifecycleChannel.appIsPaused();
    }

    public void onMemoryPressure() {
        this.mNativeView.getFlutterJNI().notifyLowMemoryWarning();
        this.systemChannel.sendMemoryPressureWarning();
    }

    public boolean hasRenderedFirstFrame() {
        return this.didRenderFirstFrame;
    }

    public void addFirstFrameListener(FirstFrameListener listener) {
        this.mFirstFrameListeners.add(listener);
    }

    public void removeFirstFrameListener(FirstFrameListener listener) {
        this.mFirstFrameListeners.remove(listener);
    }

    @Deprecated
    public void enableTransparentBackground() {
        Log.w(TAG, "FlutterView in the v1 embedding is always a SurfaceView and will cover accessibility highlights when transparent. Consider migrating to the v2 Android embedding. https://github.com/flutter/flutter/wiki/Upgrading-pre-1.12-Android-projects");
        setZOrderOnTop(true);
        getHolder().setFormat(-2);
    }

    public void disableTransparentBackground() {
        setZOrderOnTop(false);
        getHolder().setFormat(-1);
    }

    public void setInitialRoute(String route) {
        this.navigationChannel.setInitialRoute(route);
    }

    public void pushRoute(String route) {
        this.navigationChannel.pushRoute(route);
    }

    public void popRoute() {
        this.navigationChannel.popRoute();
    }

    private void sendUserPlatformSettingsToDart() {
        this.settingsChannel.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness((getResources().getConfiguration().uiMode & 48) == 32 ? SettingsChannel.PlatformBrightness.dark : SettingsChannel.PlatformBrightness.light).send();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mLocalizationPlugin.sendLocalesToFlutter(newConfig);
        sendUserPlatformSettingsToDart();
    }

    /* access modifiers changed from: package-private */
    public float getDevicePixelRatio() {
        return this.mMetrics.devicePixelRatio;
    }

    public FlutterNativeView detach() {
        if (!isAttached()) {
            return null;
        }
        getHolder().removeCallback(this.mSurfaceCallback);
        this.mNativeView.detachFromFlutterView();
        FlutterNativeView view = this.mNativeView;
        this.mNativeView = null;
        return view;
    }

    public void destroy() {
        if (isAttached()) {
            getHolder().removeCallback(this.mSurfaceCallback);
            releaseAccessibilityNodeProvider();
            this.mNativeView.destroy();
            this.mNativeView = null;
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return this.mTextInputPlugin.createInputConnection(this, outAttrs);
    }

    public boolean checkInputConnectionProxy(View view) {
        return this.mNativeView.getPluginRegistry().getPlatformViewsController().checkInputConnectionProxy(view);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        super.onProvideAutofillVirtualStructure(structure, flags);
        this.mTextInputPlugin.onProvideAutofillVirtualStructure(structure, flags);
    }

    public void autofill(SparseArray<AutofillValue> values) {
        this.mTextInputPlugin.autofill(values);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!isAttached()) {
            return super.onTouchEvent(event);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(event);
        }
        return this.androidTouchProcessor.onTouchEvent(event);
    }

    public boolean onHoverEvent(MotionEvent event) {
        if (!isAttached()) {
            return super.onHoverEvent(event);
        }
        return this.mAccessibilityNodeProvider.onAccessibilityHoverEvent(event);
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        if (isAttached() && this.androidTouchProcessor.onGenericMotionEvent(event)) {
            return true;
        }
        return super.onGenericMotionEvent(event);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        this.mMetrics.physicalWidth = width;
        this.mMetrics.physicalHeight = height;
        updateViewportMetrics();
        super.onSizeChanged(width, height, oldWidth, oldHeight);
    }

    private ZeroSides calculateShouldZeroSides() {
        Context context = getContext();
        int orientation = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (orientation == 2) {
            if (rotation == 1) {
                return ZeroSides.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? ZeroSides.LEFT : ZeroSides.RIGHT;
            }
            if (rotation == 0 || rotation == 2) {
                return ZeroSides.BOTH;
            }
        }
        return ZeroSides.NONE;
    }

    private int guessBottomKeyboardInset(WindowInsets insets) {
        if (((double) insets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return insets.getSystemWindowInsetBottom();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets insets) {
        int i;
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = insets.getSystemGestureInsets();
            this.mMetrics.systemGestureInsetTop = systemGestureInsets.top;
            this.mMetrics.systemGestureInsetRight = systemGestureInsets.right;
            this.mMetrics.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.mMetrics.systemGestureInsetLeft = systemGestureInsets.left;
        }
        boolean navigationBarVisible = true;
        boolean statusBarVisible = (getWindowSystemUiVisibility() & 4) == 0;
        if ((getWindowSystemUiVisibility() & 2) != 0) {
            navigationBarVisible = false;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            int mask = 0;
            if (navigationBarVisible) {
                mask = 0 | WindowInsets.Type.navigationBars();
            }
            if (statusBarVisible) {
                mask |= WindowInsets.Type.statusBars();
            }
            Insets uiInsets = insets.getInsets(mask);
            this.mMetrics.physicalPaddingTop = uiInsets.top;
            this.mMetrics.physicalPaddingRight = uiInsets.right;
            this.mMetrics.physicalPaddingBottom = uiInsets.bottom;
            this.mMetrics.physicalPaddingLeft = uiInsets.left;
            Insets imeInsets = insets.getInsets(WindowInsets.Type.ime());
            this.mMetrics.physicalViewInsetTop = imeInsets.top;
            this.mMetrics.physicalViewInsetRight = imeInsets.right;
            this.mMetrics.physicalViewInsetBottom = imeInsets.bottom;
            this.mMetrics.physicalViewInsetLeft = imeInsets.left;
            Insets systemGestureInsets2 = insets.getInsets(WindowInsets.Type.systemGestures());
            this.mMetrics.systemGestureInsetTop = systemGestureInsets2.top;
            this.mMetrics.systemGestureInsetRight = systemGestureInsets2.right;
            this.mMetrics.systemGestureInsetBottom = systemGestureInsets2.bottom;
            this.mMetrics.systemGestureInsetLeft = systemGestureInsets2.left;
            DisplayCutout cutout = insets.getDisplayCutout();
            if (cutout != null) {
                Insets waterfallInsets = cutout.getWaterfallInsets();
                ViewportMetrics viewportMetrics = this.mMetrics;
                viewportMetrics.physicalPaddingTop = Math.max(Math.max(viewportMetrics.physicalPaddingTop, waterfallInsets.top), cutout.getSafeInsetTop());
                ViewportMetrics viewportMetrics2 = this.mMetrics;
                viewportMetrics2.physicalPaddingRight = Math.max(Math.max(viewportMetrics2.physicalPaddingRight, waterfallInsets.right), cutout.getSafeInsetRight());
                ViewportMetrics viewportMetrics3 = this.mMetrics;
                viewportMetrics3.physicalPaddingBottom = Math.max(Math.max(viewportMetrics3.physicalPaddingBottom, waterfallInsets.bottom), cutout.getSafeInsetBottom());
                ViewportMetrics viewportMetrics4 = this.mMetrics;
                viewportMetrics4.physicalPaddingLeft = Math.max(Math.max(viewportMetrics4.physicalPaddingLeft, waterfallInsets.left), cutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!navigationBarVisible) {
                zeroSides = calculateShouldZeroSides();
            }
            this.mMetrics.physicalPaddingTop = statusBarVisible ? insets.getSystemWindowInsetTop() : 0;
            ViewportMetrics viewportMetrics5 = this.mMetrics;
            if (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) {
                i = 0;
            } else {
                i = insets.getSystemWindowInsetRight();
            }
            viewportMetrics5.physicalPaddingRight = i;
            this.mMetrics.physicalPaddingBottom = 0;
            ViewportMetrics viewportMetrics6 = this.mMetrics;
            if (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) {
                i2 = 0;
            } else {
                i2 = insets.getSystemWindowInsetLeft();
            }
            viewportMetrics6.physicalPaddingLeft = i2;
            this.mMetrics.physicalViewInsetTop = 0;
            this.mMetrics.physicalViewInsetRight = 0;
            ViewportMetrics viewportMetrics7 = this.mMetrics;
            if (navigationBarVisible) {
                i3 = insets.getSystemWindowInsetBottom();
            } else {
                i3 = guessBottomKeyboardInset(insets);
            }
            viewportMetrics7.physicalViewInsetBottom = i3;
            this.mMetrics.physicalViewInsetLeft = 0;
        }
        updateViewportMetrics();
        return super.onApplyWindowInsets(insets);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect insets) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(insets);
        }
        this.mMetrics.physicalPaddingTop = insets.top;
        this.mMetrics.physicalPaddingRight = insets.right;
        this.mMetrics.physicalPaddingBottom = 0;
        this.mMetrics.physicalPaddingLeft = insets.left;
        this.mMetrics.physicalViewInsetTop = 0;
        this.mMetrics.physicalViewInsetRight = 0;
        this.mMetrics.physicalViewInsetBottom = insets.bottom;
        this.mMetrics.physicalViewInsetLeft = 0;
        updateViewportMetrics();
        return true;
    }

    private boolean isAttached() {
        FlutterNativeView flutterNativeView = this.mNativeView;
        return flutterNativeView != null && flutterNativeView.isAttached();
    }

    /* access modifiers changed from: package-private */
    public void assertAttached() {
        if (!isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    private void preRun() {
        resetAccessibilityTree();
    }

    /* access modifiers changed from: package-private */
    public void resetAccessibilityTree() {
        AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
        if (accessibilityBridge != null) {
            accessibilityBridge.reset();
        }
    }

    private void postRun() {
    }

    public void runFromBundle(FlutterRunArguments args) {
        assertAttached();
        preRun();
        this.mNativeView.runFromBundle(args);
        postRun();
    }

    public Bitmap getBitmap() {
        assertAttached();
        return this.mNativeView.getFlutterJNI().getBitmap();
    }

    private void updateViewportMetrics() {
        if (isAttached()) {
            this.mNativeView.getFlutterJNI().setViewportMetrics(this.mMetrics.devicePixelRatio, this.mMetrics.physicalWidth, this.mMetrics.physicalHeight, this.mMetrics.physicalPaddingTop, this.mMetrics.physicalPaddingRight, this.mMetrics.physicalPaddingBottom, this.mMetrics.physicalPaddingLeft, this.mMetrics.physicalViewInsetTop, this.mMetrics.physicalViewInsetRight, this.mMetrics.physicalViewInsetBottom, this.mMetrics.physicalViewInsetLeft, this.mMetrics.systemGestureInsetTop, this.mMetrics.systemGestureInsetRight, this.mMetrics.systemGestureInsetBottom, this.mMetrics.systemGestureInsetLeft);
        }
    }

    public void onFirstFrame() {
        this.didRenderFirstFrame = true;
        for (FirstFrameListener listener : new ArrayList<>(this.mFirstFrameListeners)) {
            listener.onFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, new AccessibilityChannel(this.dartExecutor, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), getPluginRegistry().getPlatformViewsController());
        this.mAccessibilityNodeProvider = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.mAccessibilityNodeProvider.isAccessibilityEnabled(), this.mAccessibilityNodeProvider.isTouchExplorationEnabled());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseAccessibilityNodeProvider();
    }

    /* access modifiers changed from: private */
    public void resetWillNotDraw(boolean isAccessibilityEnabled, boolean isTouchExplorationEnabled) {
        boolean z = false;
        if (!this.mIsSoftwareRenderingEnabled) {
            if (!isAccessibilityEnabled && !isTouchExplorationEnabled) {
                z = true;
            }
            setWillNotDraw(z);
            return;
        }
        setWillNotDraw(false);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.mAccessibilityNodeProvider;
    }

    private void releaseAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
        if (accessibilityBridge != null) {
            accessibilityBridge.release();
            this.mAccessibilityNodeProvider = null;
        }
    }

    public PointerIcon getSystemPointerIcon(int type) {
        return PointerIcon.getSystemIcon(getContext(), type);
    }

    public void send(String channel, ByteBuffer message) {
        send(channel, message, (BinaryMessenger.BinaryReply) null);
    }

    public void send(String channel, ByteBuffer message, BinaryMessenger.BinaryReply callback) {
        if (!isAttached()) {
            Log.d(TAG, "FlutterView.send called on a detached view, channel=" + channel);
            return;
        }
        this.mNativeView.send(channel, message, callback);
    }

    public void setMessageHandler(String channel, BinaryMessenger.BinaryMessageHandler handler) {
        this.mNativeView.setMessageHandler(channel, handler);
    }

    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry entry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        this.mNativeView.getFlutterJNI().registerTexture(entry.id(), surfaceTexture);
        return entry;
    }

    final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        /* access modifiers changed from: private */
        public final long id;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture texture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterView.this.mNativeView != null) {
                    FlutterView.this.mNativeView.getFlutterJNI().markTextureFrameAvailable(SurfaceTextureRegistryEntry.this.id);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean released;
        private final SurfaceTexture surfaceTexture;

        SurfaceTextureRegistryEntry(long id2, SurfaceTexture surfaceTexture2) {
            this.id = id2;
            this.surfaceTexture = surfaceTexture2;
            if (Build.VERSION.SDK_INT >= 21) {
                this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener, new Handler());
            } else {
                this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener);
            }
        }

        public SurfaceTexture surfaceTexture() {
            return this.surfaceTexture;
        }

        public long id() {
            return this.id;
        }

        public void release() {
            if (!this.released) {
                this.released = true;
                this.surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                this.surfaceTexture.release();
                FlutterView.this.mNativeView.getFlutterJNI().unregisterTexture(this.id);
            }
        }
    }
}
