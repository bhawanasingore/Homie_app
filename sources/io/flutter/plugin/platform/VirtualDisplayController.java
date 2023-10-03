package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;
import io.flutter.view.TextureRegistry;

class VirtualDisplayController {
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private final Context context;
    private final int densityDpi;
    private final View.OnFocusChangeListener focusChangeListener;
    SingleViewPresentation presentation;
    private Surface surface;
    private final TextureRegistry.SurfaceTextureEntry textureEntry;
    private VirtualDisplay virtualDisplay;

    public static VirtualDisplayController create(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, PlatformViewFactory viewFactory, TextureRegistry.SurfaceTextureEntry textureEntry2, int width, int height, int viewId, Object createParams, View.OnFocusChangeListener focusChangeListener2) {
        textureEntry2.surfaceTexture().setDefaultBufferSize(width, height);
        Surface surface2 = new Surface(textureEntry2.surfaceTexture());
        int densityDpi2 = context2.getResources().getDisplayMetrics().densityDpi;
        VirtualDisplay virtualDisplay2 = ((DisplayManager) context2.getSystemService("display")).createVirtualDisplay("flutter-vd", width, height, densityDpi2, surface2, 0);
        if (virtualDisplay2 == null) {
            return null;
        }
        int i = densityDpi2;
        return new VirtualDisplayController(context2, accessibilityEventsDelegate2, virtualDisplay2, viewFactory, surface2, textureEntry2, focusChangeListener2, viewId, createParams);
    }

    private VirtualDisplayController(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, VirtualDisplay virtualDisplay2, PlatformViewFactory viewFactory, Surface surface2, TextureRegistry.SurfaceTextureEntry textureEntry2, View.OnFocusChangeListener focusChangeListener2, int viewId, Object createParams) {
        this.context = context2;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
        this.textureEntry = textureEntry2;
        this.focusChangeListener = focusChangeListener2;
        this.surface = surface2;
        this.virtualDisplay = virtualDisplay2;
        this.densityDpi = context2.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context2, this.virtualDisplay.getDisplay(), viewFactory, accessibilityEventsDelegate2, viewId, createParams, focusChangeListener2);
        this.presentation = singleViewPresentation;
        singleViewPresentation.show();
    }

    public void resize(int width, int height, Runnable onNewSizeFrameAvailable) {
        boolean isFocused = getView().isFocused();
        SingleViewPresentation.PresentationState presentationState = this.presentation.detachState();
        this.virtualDisplay.setSurface((Surface) null);
        this.virtualDisplay.release();
        this.textureEntry.surfaceTexture().setDefaultBufferSize(width, height);
        this.virtualDisplay = ((DisplayManager) this.context.getSystemService("display")).createVirtualDisplay("flutter-vd", width, height, this.densityDpi, this.surface, 0);
        final View embeddedView = getView();
        final Runnable runnable = onNewSizeFrameAvailable;
        embeddedView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View v) {
                OneTimeOnDrawListener.schedule(embeddedView, new Runnable() {
                    public void run() {
                        embeddedView.postDelayed(runnable, 128);
                    }
                });
                embeddedView.removeOnAttachStateChangeListener(this);
            }

            public void onViewDetachedFromWindow(View v) {
            }
        });
        SingleViewPresentation newPresentation = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, presentationState, this.focusChangeListener, isFocused);
        newPresentation.show();
        this.presentation.cancel();
        this.presentation = newPresentation;
    }

    public void dispose() {
        PlatformView view = this.presentation.getView();
        this.presentation.cancel();
        this.presentation.detachState();
        view.dispose();
        this.virtualDisplay.release();
        this.textureEntry.release();
    }

    /* access modifiers changed from: package-private */
    public void onFlutterViewAttached(View flutterView) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onFlutterViewAttached(flutterView);
        }
    }

    /* access modifiers changed from: package-private */
    public void onFlutterViewDetached() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onFlutterViewDetached();
        }
    }

    /* access modifiers changed from: package-private */
    public void onInputConnectionLocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onInputConnectionLocked();
        }
    }

    /* access modifiers changed from: package-private */
    public void onInputConnectionUnlocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onInputConnectionUnlocked();
        }
    }

    public View getView() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    public void dispatchTouchEvent(MotionEvent event) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null) {
            singleViewPresentation.dispatchTouchEvent(event);
        }
    }

    static class OneTimeOnDrawListener implements ViewTreeObserver.OnDrawListener {
        Runnable mOnDrawRunnable;
        final View mView;

        static void schedule(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new OneTimeOnDrawListener(view, runnable));
        }

        OneTimeOnDrawListener(View view, Runnable onDrawRunnable) {
            this.mView = view;
            this.mOnDrawRunnable = onDrawRunnable;
        }

        public void onDraw() {
            Runnable runnable = this.mOnDrawRunnable;
            if (runnable != null) {
                runnable.run();
                this.mOnDrawRunnable = null;
                this.mView.post(new Runnable() {
                    public void run() {
                        OneTimeOnDrawListener.this.mView.getViewTreeObserver().removeOnDrawListener(OneTimeOnDrawListener.this);
                    }
                });
            }
        }
    }
}
