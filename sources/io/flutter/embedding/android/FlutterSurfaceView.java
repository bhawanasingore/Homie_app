package io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;

public class FlutterSurfaceView extends SurfaceView implements RenderSurface {
    private static final String TAG = "FlutterSurfaceView";
    /* access modifiers changed from: private */
    public FlutterRenderer flutterRenderer;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    /* access modifiers changed from: private */
    public boolean isAttachedToFlutterRenderer;
    /* access modifiers changed from: private */
    public boolean isSurfaceAvailableForRendering;
    private final boolean renderTransparently;
    private final SurfaceHolder.Callback surfaceCallback;

    public FlutterSurfaceView(Context context) {
        this(context, (AttributeSet) null, false);
    }

    public FlutterSurfaceView(Context context, boolean renderTransparently2) {
        this(context, (AttributeSet) null, renderTransparently2);
    }

    public FlutterSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, false);
    }

    private FlutterSurfaceView(Context context, AttributeSet attrs, boolean renderTransparently2) {
        super(context, attrs);
        this.isSurfaceAvailableForRendering = false;
        this.isAttachedToFlutterRenderer = false;
        this.surfaceCallback = new SurfaceHolder.Callback() {
            public void surfaceCreated(SurfaceHolder holder) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.startRenderingToSurface()");
                boolean unused = FlutterSurfaceView.this.isSurfaceAvailableForRendering = true;
                if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
                    FlutterSurfaceView.this.connectSurfaceToRenderer();
                }
            }

            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.surfaceChanged()");
                if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
                    FlutterSurfaceView.this.changeSurfaceSize(width, height);
                }
            }

            public void surfaceDestroyed(SurfaceHolder holder) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.stopRenderingToSurface()");
                boolean unused = FlutterSurfaceView.this.isSurfaceAvailableForRendering = false;
                if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
                    FlutterSurfaceView.this.disconnectSurfaceFromRenderer();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                Log.v(FlutterSurfaceView.TAG, "onFlutterUiDisplayed()");
                FlutterSurfaceView.this.setAlpha(1.0f);
                if (FlutterSurfaceView.this.flutterRenderer != null) {
                    FlutterSurfaceView.this.flutterRenderer.removeIsDisplayingFlutterUiListener(this);
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.renderTransparently = renderTransparently2;
        init();
    }

    private void init() {
        if (this.renderTransparently) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.surfaceCallback);
        setAlpha(0.0f);
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer2) {
        Log.v(TAG, "Attaching to FlutterRenderer.");
        if (this.flutterRenderer != null) {
            Log.v(TAG, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.flutterRenderer.stopRenderingToSurface();
            this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        }
        this.flutterRenderer = flutterRenderer2;
        this.isAttachedToFlutterRenderer = true;
        flutterRenderer2.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (this.isSurfaceAvailableForRendering) {
            Log.v(TAG, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            connectSurfaceToRenderer();
        }
    }

    public void detachFromRenderer() {
        if (this.flutterRenderer != null) {
            if (getWindowToken() != null) {
                Log.v(TAG, "Disconnecting FlutterRenderer from Android surface.");
                disconnectSurfaceFromRenderer();
            }
            setAlpha(0.0f);
            this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
            this.flutterRenderer = null;
            this.isAttachedToFlutterRenderer = false;
            return;
        }
        Log.w(TAG, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    public void pause() {
        if (this.flutterRenderer != null) {
            this.flutterRenderer = null;
            this.isAttachedToFlutterRenderer = false;
            return;
        }
        Log.w(TAG, "pause() invoked when no FlutterRenderer was attached.");
    }

    /* access modifiers changed from: private */
    public void connectSurfaceToRenderer() {
        if (this.flutterRenderer == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.flutterRenderer.startRenderingToSurface(getHolder().getSurface());
    }

    /* access modifiers changed from: private */
    public void changeSurfaceSize(int width, int height) {
        if (this.flutterRenderer != null) {
            Log.v(TAG, "Notifying FlutterRenderer that Android surface size has changed to " + width + " x " + height);
            this.flutterRenderer.surfaceChanged(width, height);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }

    /* access modifiers changed from: private */
    public void disconnectSurfaceFromRenderer() {
        FlutterRenderer flutterRenderer2 = this.flutterRenderer;
        if (flutterRenderer2 != null) {
            flutterRenderer2.stopRenderingToSurface();
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }
}
