package io.flutter.embedding.android;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.view.AccessibilityBridge;
import java.util.HashSet;
import java.util.Set;

public class FlutterView extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {
    private static final String TAG = "FlutterView";
    private AccessibilityBridge accessibilityBridge;
    private AndroidKeyProcessor androidKeyProcessor;
    private AndroidTouchProcessor androidTouchProcessor;
    private FlutterEngine flutterEngine;
    private final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    /* access modifiers changed from: private */
    public FlutterImageView flutterImageView;
    private FlutterSurfaceView flutterSurfaceView;
    private FlutterTextureView flutterTextureView;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    /* access modifiers changed from: private */
    public final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    /* access modifiers changed from: private */
    public boolean isFlutterUiDisplayed;
    private LocalizationPlugin localizationPlugin;
    private MouseCursorPlugin mouseCursorPlugin;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    private RenderSurface previousRenderSurface;
    private RenderSurface renderSurface;
    private TextInputPlugin textInputPlugin;
    private final FlutterRenderer.ViewportMetrics viewportMetrics;

    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    @Deprecated
    public enum RenderMode {
        surface,
        texture,
        image
    }

    @Deprecated
    public enum TransparencyMode {
        opaque,
        transparent
    }

    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(Context context, RenderMode renderMode) {
        super(context, (AttributeSet) null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean isAccessibilityEnabled, boolean isTouchExplorationEnabled) {
                FlutterView.this.resetWillNotDraw(isAccessibilityEnabled, isTouchExplorationEnabled);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView2 = new FlutterSurfaceView(context);
            this.flutterSurfaceView = flutterSurfaceView2;
            this.renderSurface = flutterSurfaceView2;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView2 = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView2;
            this.renderSurface = flutterTextureView2;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        init();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(Context context, TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterView(Context context, FlutterSurfaceView flutterSurfaceView2) {
        this(context, (AttributeSet) null, flutterSurfaceView2);
    }

    public FlutterView(Context context, FlutterTextureView flutterTextureView2) {
        this(context, (AttributeSet) null, flutterTextureView2);
    }

    public FlutterView(Context context, FlutterImageView flutterImageView2) {
        this(context, (AttributeSet) null, flutterImageView2);
    }

    public FlutterView(Context context, AttributeSet attrs) {
        this(context, attrs, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(Context context, RenderMode renderMode, TransparencyMode transparencyMode) {
        super(context, (AttributeSet) null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean isAccessibilityEnabled, boolean isTouchExplorationEnabled) {
                FlutterView.this.resetWillNotDraw(isAccessibilityEnabled, isTouchExplorationEnabled);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        boolean z = false;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView2 = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent ? true : z);
            this.flutterSurfaceView = flutterSurfaceView2;
            this.renderSurface = flutterSurfaceView2;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView2 = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView2;
            this.renderSurface = flutterTextureView2;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        init();
    }

    private FlutterView(Context context, AttributeSet attrs, FlutterSurfaceView flutterSurfaceView2) {
        super(context, attrs);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean isAccessibilityEnabled, boolean isTouchExplorationEnabled) {
                FlutterView.this.resetWillNotDraw(isAccessibilityEnabled, isTouchExplorationEnabled);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.flutterSurfaceView = flutterSurfaceView2;
        this.renderSurface = flutterSurfaceView2;
        init();
    }

    private FlutterView(Context context, AttributeSet attrs, FlutterTextureView flutterTextureView2) {
        super(context, attrs);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean isAccessibilityEnabled, boolean isTouchExplorationEnabled) {
                FlutterView.this.resetWillNotDraw(isAccessibilityEnabled, isTouchExplorationEnabled);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.flutterTextureView = flutterTextureView2;
        this.renderSurface = flutterTextureView2;
        init();
    }

    private FlutterView(Context context, AttributeSet attrs, FlutterImageView flutterImageView2) {
        super(context, attrs);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean isAccessibilityEnabled, boolean isTouchExplorationEnabled) {
                FlutterView.this.resetWillNotDraw(isAccessibilityEnabled, isTouchExplorationEnabled);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener listener : FlutterView.this.flutterUiDisplayListeners) {
                    listener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.flutterImageView = flutterImageView2;
        this.renderSurface = flutterImageView2;
        init();
    }

    private void init() {
        Log.v(TAG, "Initializing FlutterView");
        if (this.flutterSurfaceView != null) {
            Log.v(TAG, "Internally using a FlutterSurfaceView.");
            addView(this.flutterSurfaceView);
        } else if (this.flutterTextureView != null) {
            Log.v(TAG, "Internally using a FlutterTextureView.");
            addView(this.flutterTextureView);
        } else {
            Log.v(TAG, "Internally using a FlutterImageView.");
            addView(this.flutterImageView);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    public boolean hasRenderedFirstFrame() {
        return this.isFlutterUiDisplayed;
    }

    public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener listener) {
        this.flutterUiDisplayListeners.add(listener);
    }

    public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener listener) {
        this.flutterUiDisplayListeners.remove(listener);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.flutterEngine != null) {
            Log.v(TAG, "Configuration changed. Sending locales and user settings to Flutter.");
            this.localizationPlugin.sendLocalesToFlutter(newConfig);
            sendUserSettingsToFlutter();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        Log.v(TAG, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + oldWidth + " x " + oldHeight + ", it is now " + width + " x " + height);
        this.viewportMetrics.width = width;
        this.viewportMetrics.height = height;
        sendViewportMetricsToFlutter();
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
        WindowInsets newInsets = super.onApplyWindowInsets(insets);
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = insets.getSystemGestureInsets();
            this.viewportMetrics.systemGestureInsetTop = systemGestureInsets.top;
            this.viewportMetrics.systemGestureInsetRight = systemGestureInsets.right;
            this.viewportMetrics.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.viewportMetrics.systemGestureInsetLeft = systemGestureInsets.left;
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
            this.viewportMetrics.paddingTop = uiInsets.top;
            this.viewportMetrics.paddingRight = uiInsets.right;
            this.viewportMetrics.paddingBottom = uiInsets.bottom;
            this.viewportMetrics.paddingLeft = uiInsets.left;
            Insets imeInsets = insets.getInsets(WindowInsets.Type.ime());
            this.viewportMetrics.viewInsetTop = imeInsets.top;
            this.viewportMetrics.viewInsetRight = imeInsets.right;
            this.viewportMetrics.viewInsetBottom = imeInsets.bottom;
            this.viewportMetrics.viewInsetLeft = imeInsets.left;
            Insets systemGestureInsets2 = insets.getInsets(WindowInsets.Type.systemGestures());
            this.viewportMetrics.systemGestureInsetTop = systemGestureInsets2.top;
            this.viewportMetrics.systemGestureInsetRight = systemGestureInsets2.right;
            this.viewportMetrics.systemGestureInsetBottom = systemGestureInsets2.bottom;
            this.viewportMetrics.systemGestureInsetLeft = systemGestureInsets2.left;
            DisplayCutout cutout = insets.getDisplayCutout();
            if (cutout != null) {
                Insets waterfallInsets = cutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
                viewportMetrics2.paddingTop = Math.max(Math.max(viewportMetrics2.paddingTop, waterfallInsets.top), cutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.viewportMetrics;
                viewportMetrics3.paddingRight = Math.max(Math.max(viewportMetrics3.paddingRight, waterfallInsets.right), cutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.viewportMetrics;
                viewportMetrics4.paddingBottom = Math.max(Math.max(viewportMetrics4.paddingBottom, waterfallInsets.bottom), cutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics5 = this.viewportMetrics;
                viewportMetrics5.paddingLeft = Math.max(Math.max(viewportMetrics5.paddingLeft, waterfallInsets.left), cutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!navigationBarVisible) {
                zeroSides = calculateShouldZeroSides();
            }
            this.viewportMetrics.paddingTop = statusBarVisible ? insets.getSystemWindowInsetTop() : 0;
            FlutterRenderer.ViewportMetrics viewportMetrics6 = this.viewportMetrics;
            if (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) {
                i = 0;
            } else {
                i = insets.getSystemWindowInsetRight();
            }
            viewportMetrics6.paddingRight = i;
            this.viewportMetrics.paddingBottom = 0;
            FlutterRenderer.ViewportMetrics viewportMetrics7 = this.viewportMetrics;
            if (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) {
                i2 = 0;
            } else {
                i2 = insets.getSystemWindowInsetLeft();
            }
            viewportMetrics7.paddingLeft = i2;
            this.viewportMetrics.viewInsetTop = 0;
            this.viewportMetrics.viewInsetRight = 0;
            FlutterRenderer.ViewportMetrics viewportMetrics8 = this.viewportMetrics;
            if (navigationBarVisible) {
                i3 = insets.getSystemWindowInsetBottom();
            } else {
                i3 = guessBottomKeyboardInset(insets);
            }
            viewportMetrics8.viewInsetBottom = i3;
            this.viewportMetrics.viewInsetLeft = 0;
        }
        Log.v(TAG, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
        sendViewportMetricsToFlutter();
        return newInsets;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect insets) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(insets);
        }
        this.viewportMetrics.paddingTop = insets.top;
        this.viewportMetrics.paddingRight = insets.right;
        this.viewportMetrics.paddingBottom = 0;
        this.viewportMetrics.paddingLeft = insets.left;
        this.viewportMetrics.viewInsetTop = 0;
        this.viewportMetrics.viewInsetRight = 0;
        this.viewportMetrics.viewInsetBottom = insets.bottom;
        this.viewportMetrics.viewInsetLeft = 0;
        Log.v(TAG, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.paddingTop + ", Left: " + this.viewportMetrics.paddingLeft + ", Right: " + this.viewportMetrics.paddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
        sendViewportMetricsToFlutter();
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(outAttrs);
        }
        return this.textInputPlugin.createInputConnection(this, outAttrs);
    }

    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            return flutterEngine2.getPlatformViewsController().checkInputConnectionProxy(view);
        }
        return super.checkInputConnectionProxy(view);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (!isAttachedToFlutterEngine()) {
            return super.onKeyUp(keyCode, event);
        }
        return this.androidKeyProcessor.onKeyUp(event) || super.onKeyUp(keyCode, event);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (!isAttachedToFlutterEngine()) {
            return super.onKeyDown(keyCode, event);
        }
        return this.androidKeyProcessor.onKeyDown(event) || super.onKeyDown(keyCode, event);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!isAttachedToFlutterEngine()) {
            return super.onTouchEvent(event);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(event);
        }
        return this.androidTouchProcessor.onTouchEvent(event);
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        if (isAttachedToFlutterEngine() && this.androidTouchProcessor.onGenericMotionEvent(event)) {
            return true;
        }
        return super.onGenericMotionEvent(event);
    }

    public boolean onHoverEvent(MotionEvent event) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(event);
        }
        return this.accessibilityBridge.onAccessibilityHoverEvent(event);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge2 = this.accessibilityBridge;
        if (accessibilityBridge2 == null || !accessibilityBridge2.isAccessibilityEnabled()) {
            return null;
        }
        return this.accessibilityBridge;
    }

    /* access modifiers changed from: private */
    public void resetWillNotDraw(boolean isAccessibilityEnabled, boolean isTouchExplorationEnabled) {
        boolean z = false;
        if (!this.flutterEngine.getRenderer().isSoftwareRenderingEnabled()) {
            if (!isAccessibilityEnabled && !isTouchExplorationEnabled) {
                z = true;
            }
            setWillNotDraw(z);
            return;
        }
        setWillNotDraw(false);
    }

    public PointerIcon getSystemPointerIcon(int type) {
        return PointerIcon.getSystemIcon(getContext(), type);
    }

    public void attachToFlutterEngine(FlutterEngine flutterEngine2) {
        Log.v(TAG, "Attaching to a FlutterEngine: " + flutterEngine2);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine2 == this.flutterEngine) {
                Log.v(TAG, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.v(TAG, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.flutterEngine = flutterEngine2;
        FlutterRenderer flutterRenderer = flutterEngine2.getRenderer();
        this.isFlutterUiDisplayed = flutterRenderer.isDisplayingFlutterUi();
        this.renderSurface.attachToRenderer(flutterRenderer);
        flutterRenderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mouseCursorPlugin = new MouseCursorPlugin(this, this.flutterEngine.getMouseCursorChannel());
        }
        this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
        this.localizationPlugin = this.flutterEngine.getLocalizationPlugin();
        this.androidKeyProcessor = new AndroidKeyProcessor(this, this.flutterEngine.getKeyEventChannel(), this.textInputPlugin);
        this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer(), false);
        AccessibilityBridge accessibilityBridge2 = new AccessibilityBridge(this, flutterEngine2.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
        this.accessibilityBridge = accessibilityBridge2;
        accessibilityBridge2.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
        this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
        this.flutterEngine.getPlatformViewsController().attachToFlutterRenderer(this.flutterEngine.getRenderer());
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        sendUserSettingsToFlutter();
        this.localizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
        sendViewportMetricsToFlutter();
        flutterEngine2.getPlatformViewsController().attachToView(this);
        for (FlutterEngineAttachmentListener listener : this.flutterEngineAttachmentListeners) {
            listener.onFlutterEngineAttachedToFlutterView(flutterEngine2);
        }
        if (this.isFlutterUiDisplayed) {
            this.flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    public void detachFromFlutterEngine() {
        Log.v(TAG, "Detaching from a FlutterEngine: " + this.flutterEngine);
        if (!isAttachedToFlutterEngine()) {
            Log.v(TAG, "Not attached to an engine. Doing nothing.");
            return;
        }
        for (FlutterEngineAttachmentListener listener : this.flutterEngineAttachmentListeners) {
            listener.onFlutterEngineDetachedFromFlutterView();
        }
        this.flutterEngine.getPlatformViewsController().detachFromView();
        this.flutterEngine.getPlatformViewsController().detachAccessibiltyBridge();
        this.accessibilityBridge.release();
        this.accessibilityBridge = null;
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        this.textInputPlugin.destroy();
        this.androidKeyProcessor.destroy();
        MouseCursorPlugin mouseCursorPlugin2 = this.mouseCursorPlugin;
        if (mouseCursorPlugin2 != null) {
            mouseCursorPlugin2.destroy();
        }
        FlutterRenderer flutterRenderer = this.flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = false;
        flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        flutterRenderer.stopRenderingToSurface();
        flutterRenderer.setSemanticsEnabled(false);
        this.renderSurface.detachFromRenderer();
        this.flutterImageView = null;
        this.previousRenderSurface = null;
        this.flutterEngine = null;
    }

    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void convertToImageView() {
        this.renderSurface.pause();
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 == null) {
            FlutterImageView createImageView = createImageView();
            this.flutterImageView = createImageView;
            addView(createImageView);
        } else {
            flutterImageView2.resizeIfNeeded(getWidth(), getHeight());
        }
        this.previousRenderSurface = this.renderSurface;
        FlutterImageView flutterImageView3 = this.flutterImageView;
        this.renderSurface = flutterImageView3;
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            flutterImageView3.attachToRenderer(flutterEngine2.getRenderer());
        }
    }

    public void revertImageView(final Runnable onDone) {
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 == null) {
            Log.v(TAG, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface2 = this.previousRenderSurface;
        if (renderSurface2 == null) {
            Log.v(TAG, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.renderSurface = renderSurface2;
        this.previousRenderSurface = null;
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 == null) {
            flutterImageView2.detachFromRenderer();
            onDone.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine2.getRenderer();
        if (renderer == null) {
            this.flutterImageView.detachFromRenderer();
            onDone.run();
            return;
        }
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                onDone.run();
                FlutterView.this.flutterImageView.detachFromRenderer();
            }

            public void onFlutterUiNoLongerDisplayed() {
            }
        });
    }

    public void attachOverlaySurfaceToRender(FlutterImageView view) {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            view.attachToRenderer(flutterEngine2.getRenderer());
        }
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 != null) {
            return flutterImageView2.acquireLatestImage();
        }
        return false;
    }

    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        return flutterEngine2 != null && flutterEngine2.getRenderer() == this.renderSurface.getAttachedRenderer();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.flutterEngine;
    }

    public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener listener) {
        this.flutterEngineAttachmentListeners.add(listener);
    }

    public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener listener) {
        this.flutterEngineAttachmentListeners.remove(listener);
    }

    /* access modifiers changed from: package-private */
    public void sendUserSettingsToFlutter() {
        this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness((getResources().getConfiguration().uiMode & 48) == 32 ? SettingsChannel.PlatformBrightness.dark : SettingsChannel.PlatformBrightness.light).send();
    }

    private void sendViewportMetricsToFlutter() {
        if (!isAttachedToFlutterEngine()) {
            Log.w(TAG, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        super.onProvideAutofillVirtualStructure(structure, flags);
        this.textInputPlugin.onProvideAutofillVirtualStructure(structure, flags);
    }

    public void autofill(SparseArray<AutofillValue> values) {
        this.textInputPlugin.autofill(values);
    }
}
