package io.flutter.embedding.engine.renderer;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterRenderer implements TextureRegistry {
    private static final String TAG = "FlutterRenderer";
    /* access modifiers changed from: private */
    public final FlutterJNI flutterJNI;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    /* access modifiers changed from: private */
    public boolean isDisplayingFlutterUi = false;
    private final AtomicLong nextTextureId = new AtomicLong(0);
    private Surface surface;

    public static final class ViewportMetrics {
        public float devicePixelRatio = 1.0f;
        public int height = 0;
        public int paddingBottom = 0;
        public int paddingLeft = 0;
        public int paddingRight = 0;
        public int paddingTop = 0;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetTop = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int viewInsetRight = 0;
        public int viewInsetTop = 0;
        public int width = 0;
    }

    public FlutterRenderer(FlutterJNI flutterJNI2) {
        AnonymousClass1 r0 = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterRenderer.this.isDisplayingFlutterUi = true;
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterRenderer.this.isDisplayingFlutterUi = false;
            }
        };
        this.flutterUiDisplayListener = r0;
        this.flutterJNI = flutterJNI2;
        flutterJNI2.addIsDisplayingFlutterUiListener(r0);
    }

    public boolean isDisplayingFlutterUi() {
        return this.isDisplayingFlutterUi;
    }

    public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener listener) {
        this.flutterJNI.addIsDisplayingFlutterUiListener(listener);
        if (this.isDisplayingFlutterUi) {
            listener.onFlutterUiDisplayed();
        }
    }

    public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener listener) {
        this.flutterJNI.removeIsDisplayingFlutterUiListener(listener);
    }

    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.v(TAG, "Creating a SurfaceTexture.");
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry entry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        Log.v(TAG, "New SurfaceTexture ID: " + entry.id());
        registerTexture(entry.id(), surfaceTexture);
        return entry;
    }

    final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        /* access modifiers changed from: private */
        public final long id;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture texture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterRenderer.this.flutterJNI.isAttached()) {
                    FlutterRenderer.this.markTextureFrameAvailable(SurfaceTextureRegistryEntry.this.id);
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
                Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.id + ").");
                this.surfaceTexture.release();
                FlutterRenderer.this.unregisterTexture(this.id);
                this.released = true;
            }
        }
    }

    public void startRenderingToSurface(Surface surface2) {
        if (this.surface != null) {
            stopRenderingToSurface();
        }
        this.surface = surface2;
        this.flutterJNI.onSurfaceCreated(surface2);
    }

    public void swapSurface(Surface surface2) {
        this.surface = surface2;
        this.flutterJNI.onSurfaceWindowChanged(surface2);
    }

    public void surfaceChanged(int width, int height) {
        this.flutterJNI.onSurfaceChanged(width, height);
    }

    public void stopRenderingToSurface() {
        this.flutterJNI.onSurfaceDestroyed();
        this.surface = null;
        if (this.isDisplayingFlutterUi) {
            this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
        }
        this.isDisplayingFlutterUi = false;
    }

    public void setViewportMetrics(ViewportMetrics viewportMetrics) {
        ViewportMetrics viewportMetrics2 = viewportMetrics;
        Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics2.width + " x " + viewportMetrics2.height + "\nPadding - L: " + viewportMetrics2.paddingLeft + ", T: " + viewportMetrics2.paddingTop + ", R: " + viewportMetrics2.paddingRight + ", B: " + viewportMetrics2.paddingBottom + "\nInsets - L: " + viewportMetrics2.viewInsetLeft + ", T: " + viewportMetrics2.viewInsetTop + ", R: " + viewportMetrics2.viewInsetRight + ", B: " + viewportMetrics2.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics2.systemGestureInsetLeft + ", T: " + viewportMetrics2.systemGestureInsetTop + ", R: " + viewportMetrics2.systemGestureInsetRight + ", B: " + viewportMetrics2.viewInsetBottom);
        this.flutterJNI.setViewportMetrics(viewportMetrics2.devicePixelRatio, viewportMetrics2.width, viewportMetrics2.height, viewportMetrics2.paddingTop, viewportMetrics2.paddingRight, viewportMetrics2.paddingBottom, viewportMetrics2.paddingLeft, viewportMetrics2.viewInsetTop, viewportMetrics2.viewInsetRight, viewportMetrics2.viewInsetBottom, viewportMetrics2.viewInsetLeft, viewportMetrics2.systemGestureInsetTop, viewportMetrics2.systemGestureInsetRight, viewportMetrics2.systemGestureInsetBottom, viewportMetrics2.systemGestureInsetLeft);
    }

    public Bitmap getBitmap() {
        return this.flutterJNI.getBitmap();
    }

    public void dispatchPointerDataPacket(ByteBuffer buffer, int position) {
        this.flutterJNI.dispatchPointerDataPacket(buffer, position);
    }

    private void registerTexture(long textureId, SurfaceTexture surfaceTexture) {
        this.flutterJNI.registerTexture(textureId, surfaceTexture);
    }

    /* access modifiers changed from: private */
    public void markTextureFrameAvailable(long textureId) {
        this.flutterJNI.markTextureFrameAvailable(textureId);
    }

    /* access modifiers changed from: private */
    public void unregisterTexture(long textureId) {
        this.flutterJNI.unregisterTexture(textureId);
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.flutterJNI.getIsSoftwareRenderingEnabled();
    }

    public void setAccessibilityFeatures(int flags) {
        this.flutterJNI.setAccessibilityFeatures(flags);
    }

    public void setSemanticsEnabled(boolean enabled) {
        this.flutterJNI.setSemanticsEnabled(enabled);
    }

    public void dispatchSemanticsAction(int id, int action, ByteBuffer args, int argsPosition) {
        this.flutterJNI.dispatchSemanticsAction(id, action, args, argsPosition);
    }
}
