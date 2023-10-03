package io.flutter.plugin.platform;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    private static final String TAG = "PlatformViewsController";
    /* access modifiers changed from: private */
    public final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
    private AndroidTouchProcessor androidTouchProcessor;
    private final PlatformViewsChannel.PlatformViewsHandler channelHandler = new PlatformViewsChannel.PlatformViewsHandler() {
        public void createAndroidViewForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest request) {
            ensureValidAndroidVersion(19);
            if (PlatformViewsController.validateDirection(request.direction)) {
                PlatformViewFactory factory = PlatformViewsController.this.registry.getFactory(request.viewType);
                if (factory != null) {
                    Object createParams = null;
                    if (request.params != null) {
                        createParams = factory.getCreateArgsCodec().decodeMessage(request.params);
                    }
                    PlatformViewsController.this.platformViews.put(request.viewId, factory.create(PlatformViewsController.this.context, request.viewId, createParams));
                    return;
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + request.viewType);
            }
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + request.direction + "(view id: " + request.viewId + ")");
        }

        public void disposeAndroidViewForPlatformView(int viewId) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(viewId);
            FlutterMutatorView parentView = (FlutterMutatorView) PlatformViewsController.this.platformViewParent.get(viewId);
            if (platformView != null) {
                if (parentView != null) {
                    parentView.removeView(platformView.getView());
                }
                PlatformViewsController.this.platformViews.remove(viewId);
                platformView.dispose();
            }
            if (parentView != null) {
                ((ViewGroup) parentView.getParent()).removeView(parentView);
                PlatformViewsController.this.platformViewParent.remove(viewId);
            }
        }

        public long createVirtualDisplayForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest request) {
            ensureValidAndroidVersion(20);
            if (!PlatformViewsController.validateDirection(request.direction)) {
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + request.direction + "(view id: " + request.viewId + ")");
            } else if (!PlatformViewsController.this.vdControllers.containsKey(Integer.valueOf(request.viewId))) {
                PlatformViewFactory viewFactory = PlatformViewsController.this.registry.getFactory(request.viewType);
                if (viewFactory != null) {
                    Object createParams = null;
                    if (request.params != null) {
                        createParams = viewFactory.getCreateArgsCodec().decodeMessage(request.params);
                    }
                    int physicalWidth = PlatformViewsController.this.toPhysicalPixels(request.logicalWidth);
                    int physicalHeight = PlatformViewsController.this.toPhysicalPixels(request.logicalHeight);
                    PlatformViewsController.this.validateVirtualDisplayDimensions(physicalWidth, physicalHeight);
                    TextureRegistry.SurfaceTextureEntry textureEntry = PlatformViewsController.this.textureRegistry.createSurfaceTexture();
                    VirtualDisplayController vdController = VirtualDisplayController.create(PlatformViewsController.this.context, PlatformViewsController.this.accessibilityEventsDelegate, viewFactory, textureEntry, physicalWidth, physicalHeight, request.viewId, createParams, new View.OnFocusChangeListener(request) {
                        public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onFocusChange(View view, boolean z) {
                            PlatformViewsController.AnonymousClass1.this.lambda$createVirtualDisplayForPlatformView$0$PlatformViewsController$1(this.f$1, view, z);
                        }
                    });
                    if (vdController != null) {
                        if (PlatformViewsController.this.flutterView != null) {
                            vdController.onFlutterViewAttached(PlatformViewsController.this.flutterView);
                        }
                        PlatformViewsController.this.vdControllers.put(Integer.valueOf(request.viewId), vdController);
                        View platformView = vdController.getView();
                        platformView.setLayoutDirection(request.direction);
                        PlatformViewsController.this.contextToPlatformView.put(platformView.getContext(), platformView);
                        return textureEntry.id();
                    }
                    throw new IllegalStateException("Failed creating virtual display for a " + request.viewType + " with id: " + request.viewId);
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + request.viewType);
            } else {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + request.viewId);
            }
        }

        public /* synthetic */ void lambda$createVirtualDisplayForPlatformView$0$PlatformViewsController$1(PlatformViewsChannel.PlatformViewCreationRequest request, View view, boolean hasFocus) {
            if (hasFocus) {
                PlatformViewsController.this.platformViewsChannel.invokeViewFocused(request.viewId);
            }
        }

        public void disposeVirtualDisplayForPlatformView(int viewId) {
            ensureValidAndroidVersion(20);
            VirtualDisplayController vdController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(viewId));
            if (vdController != null) {
                if (PlatformViewsController.this.textInputPlugin != null) {
                    PlatformViewsController.this.textInputPlugin.clearPlatformViewClient(viewId);
                }
                PlatformViewsController.this.contextToPlatformView.remove(vdController.getView().getContext());
                vdController.dispose();
                PlatformViewsController.this.vdControllers.remove(Integer.valueOf(viewId));
                return;
            }
            throw new IllegalStateException("Trying to dispose a platform view with unknown id: " + viewId);
        }

        public void resizePlatformView(PlatformViewsChannel.PlatformViewResizeRequest request, final Runnable onComplete) {
            ensureValidAndroidVersion(20);
            final VirtualDisplayController vdController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(request.viewId));
            if (vdController != null) {
                int physicalWidth = PlatformViewsController.this.toPhysicalPixels(request.newLogicalWidth);
                int physicalHeight = PlatformViewsController.this.toPhysicalPixels(request.newLogicalHeight);
                PlatformViewsController.this.validateVirtualDisplayDimensions(physicalWidth, physicalHeight);
                PlatformViewsController.this.lockInputConnection(vdController);
                vdController.resize(physicalWidth, physicalHeight, new Runnable() {
                    public void run() {
                        PlatformViewsController.this.unlockInputConnection(vdController);
                        onComplete.run();
                    }
                });
                return;
            }
            throw new IllegalStateException("Trying to resize a platform view with unknown id: " + request.viewId);
        }

        public void onTouch(PlatformViewsChannel.PlatformViewTouch touch) {
            int viewId = touch.viewId;
            float density = PlatformViewsController.this.context.getResources().getDisplayMetrics().density;
            ensureValidAndroidVersion(20);
            if (PlatformViewsController.this.vdControllers.containsKey(Integer.valueOf(viewId))) {
                PlatformViewsController.this.vdControllers.get(Integer.valueOf(touch.viewId)).dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(density, touch, true));
            } else if (PlatformViewsController.this.platformViews.get(viewId) != null) {
                MotionEvent event = PlatformViewsController.this.toMotionEvent(density, touch, false);
                View view = ((PlatformView) PlatformViewsController.this.platformViews.get(touch.viewId)).getView();
                if (view != null) {
                    view.dispatchTouchEvent(event);
                }
            } else {
                throw new IllegalStateException("Sending touch to an unknown view with id: " + viewId);
            }
        }

        public void setDirection(int viewId, int direction) {
            if (PlatformViewsController.validateDirection(direction)) {
                ensureValidAndroidVersion(20);
                View view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(viewId)).getView();
                if (view != null) {
                    view.setLayoutDirection(direction);
                    return;
                }
                throw new IllegalStateException("Sending touch to an unknown view with id: " + direction);
            }
            throw new IllegalStateException("Trying to set unknown direction value: " + direction + "(view id: " + viewId + ")");
        }

        public void clearFocus(int viewId) {
            ensureValidAndroidVersion(20);
            PlatformViewsController.this.vdControllers.get(Integer.valueOf(viewId)).getView().clearFocus();
        }

        private void ensureValidAndroidVersion(int minSdkVersion) {
            if (Build.VERSION.SDK_INT < minSdkVersion) {
                throw new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + minSdkVersion);
            }
        }
    };
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public final HashMap<Context, View> contextToPlatformView = new HashMap<>();
    private HashSet<Integer> currentFrameUsedOverlayLayerIds = new HashSet<>();
    private HashSet<Integer> currentFrameUsedPlatformViewIds = new HashSet<>();
    /* access modifiers changed from: private */
    public View flutterView;
    private boolean flutterViewConvertedToImageView = false;
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();
    private int nextOverlayLayerId = 0;
    private final SparseArray<FlutterImageView> overlayLayerViews = new SparseArray<>();
    /* access modifiers changed from: private */
    public final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray<>();
    /* access modifiers changed from: private */
    public final SparseArray<PlatformView> platformViews = new SparseArray<>();
    /* access modifiers changed from: private */
    public PlatformViewsChannel platformViewsChannel;
    /* access modifiers changed from: private */
    public final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
    /* access modifiers changed from: private */
    public TextInputPlugin textInputPlugin;
    /* access modifiers changed from: private */
    public TextureRegistry textureRegistry;
    final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap<>();

    public MotionEvent toMotionEvent(float density, PlatformViewsChannel.PlatformViewTouch touch, boolean usingVirtualDiplays) {
        PlatformViewsChannel.PlatformViewTouch platformViewTouch = touch;
        MotionEventTracker.MotionEventId motionEventId = MotionEventTracker.MotionEventId.from(platformViewTouch.motionEventId);
        MotionEvent trackedEvent = this.motionEventTracker.pop(motionEventId);
        MotionEvent.PointerProperties[] pointerProperties = (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch.pointerCount]);
        MotionEvent.PointerCoords[] pointerCoords = (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch.rawPointerCoords, density).toArray(new MotionEvent.PointerCoords[platformViewTouch.pointerCount]);
        if (usingVirtualDiplays || trackedEvent == null) {
            long longValue = platformViewTouch.downTime.longValue();
            long longValue2 = platformViewTouch.eventTime.longValue();
            int i = platformViewTouch.action;
            int i2 = platformViewTouch.pointerCount;
            int i3 = platformViewTouch.metaState;
            int i4 = platformViewTouch.buttonState;
            float f = platformViewTouch.xPrecision;
            float f2 = platformViewTouch.yPrecision;
            int i5 = platformViewTouch.deviceId;
            MotionEventTracker.MotionEventId motionEventId2 = motionEventId;
            MotionEvent motionEvent = trackedEvent;
            return MotionEvent.obtain(longValue, longValue2, i, i2, pointerProperties, pointerCoords, i3, i4, f, f2, i5, platformViewTouch.edgeFlags, platformViewTouch.source, platformViewTouch.flags);
        }
        return MotionEvent.obtain(trackedEvent.getDownTime(), trackedEvent.getEventTime(), trackedEvent.getAction(), platformViewTouch.pointerCount, pointerProperties, pointerCoords, trackedEvent.getMetaState(), trackedEvent.getButtonState(), trackedEvent.getXPrecision(), trackedEvent.getYPrecision(), trackedEvent.getDeviceId(), trackedEvent.getEdgeFlags(), trackedEvent.getSource(), trackedEvent.getFlags());
    }

    public void attach(Context context2, TextureRegistry textureRegistry2, DartExecutor dartExecutor) {
        if (this.context == null) {
            this.context = context2;
            this.textureRegistry = textureRegistry2;
            PlatformViewsChannel platformViewsChannel2 = new PlatformViewsChannel(dartExecutor);
            this.platformViewsChannel = platformViewsChannel2;
            platformViewsChannel2.setPlatformViewsHandler(this.channelHandler);
            return;
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    public void detach() {
        this.platformViewsChannel.setPlatformViewsHandler((PlatformViewsChannel.PlatformViewsHandler) null);
        this.platformViewsChannel = null;
        this.context = null;
        this.textureRegistry = null;
    }

    public void attachToView(View flutterView2) {
        this.flutterView = flutterView2;
        for (VirtualDisplayController controller : this.vdControllers.values()) {
            controller.onFlutterViewAttached(flutterView2);
        }
    }

    public void detachFromView() {
        this.flutterView = null;
        for (VirtualDisplayController controller : this.vdControllers.values()) {
            controller.onFlutterViewDetached();
        }
    }

    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
    }

    public void detachAccessibiltyBridge() {
        this.accessibilityEventsDelegate.setAccessibilityBridge((AccessibilityBridge) null);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin2) {
        this.textInputPlugin = textInputPlugin2;
    }

    public void detachTextInputPlugin() {
        this.textInputPlugin = null;
    }

    public boolean checkInputConnectionProxy(View view) {
        if (view == null || !this.contextToPlatformView.containsKey(view.getContext())) {
            return false;
        }
        View platformView = this.contextToPlatformView.get(view.getContext());
        if (platformView == view) {
            return true;
        }
        return platformView.checkInputConnectionProxy(view);
    }

    public PlatformViewRegistry getRegistry() {
        return this.registry;
    }

    public void onAttachedToJNI() {
    }

    public void onDetachedFromJNI() {
        flushAllViews();
    }

    public void onPreEngineRestart() {
        flushAllViews();
    }

    public View getPlatformViewById(Integer id) {
        if (this.platformViews.get(id.intValue()) != null) {
            return this.platformViews.get(id.intValue()).getView();
        }
        VirtualDisplayController controller = this.vdControllers.get(id);
        if (controller == null) {
            return null;
        }
        return controller.getView();
    }

    /* access modifiers changed from: private */
    public void lockInputConnection(VirtualDisplayController controller) {
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.lockPlatformViewInputConnection();
            controller.onInputConnectionLocked();
        }
    }

    /* access modifiers changed from: private */
    public void unlockInputConnection(VirtualDisplayController controller) {
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.unlockPlatformViewInputConnection();
            controller.onInputConnectionUnlocked();
        }
    }

    /* access modifiers changed from: private */
    public static boolean validateDirection(int direction) {
        return direction == 0 || direction == 1;
    }

    private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object rawPropertiesList) {
        List<MotionEvent.PointerProperties> pointerProperties = new ArrayList<>();
        for (Object o : (List) rawPropertiesList) {
            pointerProperties.add(parsePointerProperties(o));
        }
        return pointerProperties;
    }

    private static MotionEvent.PointerProperties parsePointerProperties(Object rawProperties) {
        List<Object> propertiesList = (List) rawProperties;
        MotionEvent.PointerProperties properties = new MotionEvent.PointerProperties();
        properties.id = ((Integer) propertiesList.get(0)).intValue();
        properties.toolType = ((Integer) propertiesList.get(1)).intValue();
        return properties;
    }

    private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object rawCoordsList, float density) {
        List<MotionEvent.PointerCoords> pointerCoords = new ArrayList<>();
        for (Object o : (List) rawCoordsList) {
            pointerCoords.add(parsePointerCoords(o, density));
        }
        return pointerCoords;
    }

    private static MotionEvent.PointerCoords parsePointerCoords(Object rawCoords, float density) {
        List<Object> coordsList = (List) rawCoords;
        MotionEvent.PointerCoords coords = new MotionEvent.PointerCoords();
        coords.orientation = (float) ((Double) coordsList.get(0)).doubleValue();
        coords.pressure = (float) ((Double) coordsList.get(1)).doubleValue();
        coords.size = (float) ((Double) coordsList.get(2)).doubleValue();
        coords.toolMajor = ((float) ((Double) coordsList.get(3)).doubleValue()) * density;
        coords.toolMinor = ((float) ((Double) coordsList.get(4)).doubleValue()) * density;
        coords.touchMajor = ((float) ((Double) coordsList.get(5)).doubleValue()) * density;
        coords.touchMinor = ((float) ((Double) coordsList.get(6)).doubleValue()) * density;
        coords.x = ((float) ((Double) coordsList.get(7)).doubleValue()) * density;
        coords.y = ((float) ((Double) coordsList.get(8)).doubleValue()) * density;
        return coords;
    }

    /* access modifiers changed from: private */
    public void validateVirtualDisplayDimensions(int width, int height) {
        DisplayMetrics metrics = this.context.getResources().getDisplayMetrics();
        if (height > metrics.heightPixels || width > metrics.widthPixels) {
            Log.w(TAG, "Creating a virtual display of size: [" + width + ", " + height + "] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [" + metrics.widthPixels + ", " + metrics.heightPixels + "].");
        }
    }

    private float getDisplayDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: private */
    public int toPhysicalPixels(double logicalPixels) {
        return (int) Math.round(((double) getDisplayDensity()) * logicalPixels);
    }

    private void flushAllViews() {
        for (VirtualDisplayController controller : this.vdControllers.values()) {
            controller.dispose();
        }
        this.vdControllers.clear();
        while (this.platformViews.size() > 0) {
            this.channelHandler.disposeAndroidViewForPlatformView(this.platformViews.keyAt(0));
        }
    }

    private void initializeRootImageViewIfNeeded() {
        if (!this.flutterViewConvertedToImageView) {
            ((FlutterView) this.flutterView).convertToImageView();
            this.flutterViewConvertedToImageView = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void initializePlatformViewIfNeeded(int viewId) {
        PlatformView platformView = this.platformViews.get(viewId);
        if (platformView == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        } else if (this.platformViewParent.get(viewId) == null) {
            if (platformView.getView() == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            } else if (platformView.getView().getParent() == null) {
                Context context2 = this.context;
                FlutterMutatorView parentView = new FlutterMutatorView(context2, context2.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
                this.platformViewParent.put(viewId, parentView);
                parentView.addView(platformView.getView());
                ((FlutterView) this.flutterView).addView(parentView);
            } else {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
        }
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void onDisplayPlatformView(int viewId, int x, int y, int width, int height, int viewWidth, int viewHeight, FlutterMutatorsStack mutatorsStack) {
        initializeRootImageViewIfNeeded();
        initializePlatformViewIfNeeded(viewId);
        FlutterMutatorView parentView = this.platformViewParent.get(viewId);
        parentView.readyToDisplay(mutatorsStack, x, y, width, height);
        parentView.setVisibility(0);
        parentView.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewWidth, viewHeight);
        View view = this.platformViews.get(viewId).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(viewId));
    }

    public void onDisplayOverlaySurface(int id, int x, int y, int width, int height) {
        initializeRootImageViewIfNeeded();
        FlutterImageView overlayView = this.overlayLayerViews.get(id);
        if (overlayView.getParent() == null) {
            ((FlutterView) this.flutterView).addView(overlayView);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        overlayView.setLayoutParams(layoutParams);
        overlayView.setVisibility(0);
        overlayView.bringToFront();
        this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(id));
    }

    public void onBeginFrame() {
        this.currentFrameUsedOverlayLayerIds.clear();
        this.currentFrameUsedPlatformViewIds.clear();
    }

    public void onEndFrame() {
        FlutterView view = (FlutterView) this.flutterView;
        boolean isFrameRenderedUsingImageReaders = false;
        if (!this.flutterViewConvertedToImageView || !this.currentFrameUsedPlatformViewIds.isEmpty()) {
            if (this.flutterViewConvertedToImageView && view.acquireLatestImageViewFrame()) {
                isFrameRenderedUsingImageReaders = true;
            }
            finishFrame(isFrameRenderedUsingImageReaders);
            return;
        }
        this.flutterViewConvertedToImageView = false;
        view.revertImageView(new Runnable() {
            public final void run() {
                PlatformViewsController.this.lambda$onEndFrame$0$PlatformViewsController();
            }
        });
    }

    public /* synthetic */ void lambda$onEndFrame$0$PlatformViewsController() {
        finishFrame(false);
    }

    private void finishFrame(boolean isFrameRenderedUsingImageReaders) {
        for (int i = 0; i < this.overlayLayerViews.size(); i++) {
            int overlayId = this.overlayLayerViews.keyAt(i);
            FlutterImageView overlayView = this.overlayLayerViews.valueAt(i);
            if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(overlayId))) {
                ((FlutterView) this.flutterView).attachOverlaySurfaceToRender(overlayView);
                isFrameRenderedUsingImageReaders &= overlayView.acquireLatestImage();
            } else {
                if (!this.flutterViewConvertedToImageView) {
                    overlayView.detachFromRenderer();
                }
                overlayView.setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < this.platformViewParent.size(); i2++) {
            int viewId = this.platformViewParent.keyAt(i2);
            View parentView = this.platformViewParent.get(viewId);
            if (!isFrameRenderedUsingImageReaders || !this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(viewId))) {
                parentView.setVisibility(8);
            } else {
                parentView.setVisibility(0);
            }
        }
    }

    public FlutterOverlaySurface createOverlaySurface(FlutterImageView imageView) {
        int id = this.nextOverlayLayerId;
        this.nextOverlayLayerId = id + 1;
        this.overlayLayerViews.put(id, imageView);
        return new FlutterOverlaySurface(id, imageView.getSurface());
    }

    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new FlutterImageView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), FlutterImageView.SurfaceKind.overlay));
    }

    public void destroyOverlaySurfaces() {
        for (int i = 0; i < this.overlayLayerViews.size(); i++) {
            int keyAt = this.overlayLayerViews.keyAt(i);
            FlutterImageView overlayView = this.overlayLayerViews.valueAt(i);
            overlayView.detachFromRenderer();
            ((FlutterView) this.flutterView).removeView(overlayView);
        }
        this.overlayLayerViews.clear();
    }
}
