package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Looper;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
    private static String observatoryUri;
    private static float refreshRateFPS = 0.0f;
    private AccessibilityDelegate accessibilityDelegate;
    private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private LocalizationPlugin localizationPlugin;
    private final Looper mainLooper = Looper.getMainLooper();
    private Long nativePlatformViewId;
    private PlatformMessageHandler platformMessageHandler;
    private PlatformViewsController platformViewsController;

    public interface AccessibilityDelegate {
        void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr);

        void updateSemantics(ByteBuffer byteBuffer, String[] strArr);
    }

    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long j);
    }

    private native long nativeAttach(FlutterJNI flutterJNI, boolean z);

    private native void nativeDestroy(long j);

    private native void nativeDispatchEmptyPlatformMessage(long j, String str, int i);

    private native void nativeDispatchPlatformMessage(long j, String str, ByteBuffer byteBuffer, int i, int i2);

    private native void nativeDispatchPointerDataPacket(long j, ByteBuffer byteBuffer, int i);

    private native void nativeDispatchSemanticsAction(long j, int i, int i2, ByteBuffer byteBuffer, int i3);

    private native Bitmap nativeGetBitmap(long j);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j, int i);

    private native void nativeInvokePlatformMessageResponseCallback(long j, int i, ByteBuffer byteBuffer, int i2);

    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j);

    private native void nativeMarkTextureFrameAvailable(long j, long j2);

    private native void nativeNotifyLowMemoryWarning(long j);

    public static native void nativeOnVsync(long j, long j2, long j3);

    public static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterTexture(long j, long j2, SurfaceTexture surfaceTexture);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j, String str, String str2, String str3, AssetManager assetManager);

    private native void nativeSetAccessibilityFeatures(long j, int i);

    private native void nativeSetSemanticsEnabled(long j, boolean z);

    private native void nativeSetViewportMetrics(long j, float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14);

    private native void nativeSurfaceChanged(long j, int i, int i2);

    private native void nativeSurfaceCreated(long j, Surface surface);

    private native void nativeSurfaceDestroyed(long j);

    private native void nativeSurfaceWindowChanged(long j, Surface surface);

    private native void nativeUnregisterTexture(long j, long j2);

    public native boolean nativeFlutterTextUtilsIsEmoji(int i);

    public native boolean nativeFlutterTextUtilsIsEmojiModifier(int i);

    public native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i);

    public native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i);

    public native boolean nativeFlutterTextUtilsIsVariationSelector(int i);

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    public static String getObservatoryUri() {
        return observatoryUri;
    }

    public static void setRefreshRateFPS(float refreshRateFPS2) {
        refreshRateFPS = refreshRateFPS2;
    }

    public static void setAsyncWaitForVsyncDelegate(AsyncWaitForVsyncDelegate delegate) {
        asyncWaitForVsyncDelegate = delegate;
    }

    private static void asyncWaitForVsync(long cookie) {
        AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2 = asyncWaitForVsyncDelegate;
        if (asyncWaitForVsyncDelegate2 != null) {
            asyncWaitForVsyncDelegate2.asyncWaitForVsync(cookie);
            return;
        }
        throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    }

    public boolean isAttached() {
        return this.nativePlatformViewId != null;
    }

    public void attachToNative(boolean isBackgroundView) {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.nativePlatformViewId = Long.valueOf(performNativeAttach(this, isBackgroundView));
    }

    public long performNativeAttach(FlutterJNI flutterJNI, boolean isBackgroundView) {
        return nativeAttach(flutterJNI, isBackgroundView);
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDestroy(this.nativePlatformViewId.longValue());
        this.nativePlatformViewId = null;
    }

    private void ensureNotAttachedToNative() {
        if (this.nativePlatformViewId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureAttachedToNative() {
        if (this.nativePlatformViewId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener listener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(listener);
    }

    public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener listener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(listener);
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener listener : this.flutterUiDisplayListeners) {
            listener.onFlutterUiDisplayed();
        }
    }

    /* access modifiers changed from: package-private */
    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener listener : this.flutterUiDisplayListeners) {
            listener.onFlutterUiNoLongerDisplayed();
        }
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativePlatformViewId.longValue(), surface);
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativePlatformViewId.longValue(), surface);
    }

    public void onSurfaceChanged(int width, int height) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativePlatformViewId.longValue(), width, height);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativePlatformViewId.longValue());
    }

    public void setViewportMetrics(float devicePixelRatio, int physicalWidth, int physicalHeight, int physicalPaddingTop, int physicalPaddingRight, int physicalPaddingBottom, int physicalPaddingLeft, int physicalViewInsetTop, int physicalViewInsetRight, int physicalViewInsetBottom, int physicalViewInsetLeft, int systemGestureInsetTop, int systemGestureInsetRight, int systemGestureInsetBottom, int systemGestureInsetLeft) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativePlatformViewId.longValue(), devicePixelRatio, physicalWidth, physicalHeight, physicalPaddingTop, physicalPaddingRight, physicalPaddingBottom, physicalPaddingLeft, physicalViewInsetTop, physicalViewInsetRight, physicalViewInsetBottom, physicalViewInsetLeft, systemGestureInsetTop, systemGestureInsetRight, systemGestureInsetBottom, systemGestureInsetLeft);
    }

    public void dispatchPointerDataPacket(ByteBuffer buffer, int position) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativePlatformViewId.longValue(), buffer, position);
    }

    public void setPlatformViewsController(PlatformViewsController platformViewsController2) {
        ensureRunningOnMainThread();
        this.platformViewsController = platformViewsController2;
    }

    public void setAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate2) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = accessibilityDelegate2;
    }

    private void updateSemantics(ByteBuffer buffer, String[] strings) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate2 = this.accessibilityDelegate;
        if (accessibilityDelegate2 != null) {
            accessibilityDelegate2.updateSemantics(buffer, strings);
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer buffer, String[] strings) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate2 = this.accessibilityDelegate;
        if (accessibilityDelegate2 != null) {
            accessibilityDelegate2.updateCustomAccessibilityActions(buffer, strings);
        }
    }

    public void dispatchSemanticsAction(int id, AccessibilityBridge.Action action) {
        dispatchSemanticsAction(id, action, (Object) null);
    }

    public void dispatchSemanticsAction(int id, AccessibilityBridge.Action action, Object args) {
        ensureAttachedToNative();
        ByteBuffer encodedArgs = null;
        int position = 0;
        if (args != null) {
            encodedArgs = StandardMessageCodec.INSTANCE.encodeMessage(args);
            position = encodedArgs.position();
        }
        dispatchSemanticsAction(id, action.value, encodedArgs, position);
    }

    public void dispatchSemanticsAction(int id, int action, ByteBuffer args, int argsPosition) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativePlatformViewId.longValue(), id, action, args, argsPosition);
    }

    public void setSemanticsEnabled(boolean enabled) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetSemanticsEnabled(this.nativePlatformViewId.longValue(), enabled);
    }

    public void setAccessibilityFeatures(int flags) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetAccessibilityFeatures(this.nativePlatformViewId.longValue(), flags);
    }

    public void registerTexture(long textureId, SurfaceTexture surfaceTexture) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativePlatformViewId.longValue(), textureId, surfaceTexture);
    }

    public void markTextureFrameAvailable(long textureId) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativePlatformViewId.longValue(), textureId);
    }

    public void unregisterTexture(long textureId) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativePlatformViewId.longValue(), textureId);
    }

    public void runBundleAndSnapshotFromLibrary(String bundlePath, String entrypointFunctionName, String pathToEntrypointFunction, AssetManager assetManager) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativePlatformViewId.longValue(), bundlePath, entrypointFunctionName, pathToEntrypointFunction, assetManager);
    }

    public void setPlatformMessageHandler(PlatformMessageHandler platformMessageHandler2) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = platformMessageHandler2;
    }

    public void handlePlatformMessage(String channel, byte[] message, int replyId) {
        PlatformMessageHandler platformMessageHandler2 = this.platformMessageHandler;
        if (platformMessageHandler2 != null) {
            platformMessageHandler2.handleMessageFromDart(channel, message, replyId);
        }
    }

    private void handlePlatformMessageResponse(int replyId, byte[] reply) {
        PlatformMessageHandler platformMessageHandler2 = this.platformMessageHandler;
        if (platformMessageHandler2 != null) {
            platformMessageHandler2.handlePlatformMessageResponse(replyId, reply);
        }
    }

    public void dispatchEmptyPlatformMessage(String channel, int responseId) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativePlatformViewId.longValue(), channel, responseId);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + channel + ". Response ID: " + responseId);
    }

    public void dispatchPlatformMessage(String channel, ByteBuffer message, int position, int responseId) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativePlatformViewId.longValue(), channel, message, position, responseId);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + channel + ". Response ID: " + responseId);
    }

    public void invokePlatformMessageEmptyResponseCallback(int responseId) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeInvokePlatformMessageEmptyResponseCallback(this.nativePlatformViewId.longValue(), responseId);
            return;
        }
        Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + responseId);
    }

    public void invokePlatformMessageResponseCallback(int responseId, ByteBuffer message, int position) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeInvokePlatformMessageResponseCallback(this.nativePlatformViewId.longValue(), responseId, message, position);
            return;
        }
        Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + responseId);
    }

    public void addEngineLifecycleListener(FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(engineLifecycleListener);
    }

    public void removeEngineLifecycleListener(FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(engineLifecycleListener);
    }

    private void onPreEngineRestart() {
        for (FlutterEngine.EngineLifecycleListener listener : this.engineLifecycleListeners) {
            listener.onPreEngineRestart();
        }
    }

    public void onDisplayOverlaySurface(int id, int x, int y, int width, int height) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onDisplayOverlaySurface(id, x, y, width, height);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onBeginFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
    }

    public void onEndFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onEndFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
    }

    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            return platformViewsController2.createOverlaySurface();
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.destroyOverlaySurfaces();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
    }

    public void setLocalizationPlugin(LocalizationPlugin localizationPlugin2) {
        ensureRunningOnMainThread();
        this.localizationPlugin = localizationPlugin2;
    }

    /* access modifiers changed from: package-private */
    public String[] computePlatformResolvedLocale(String[] strings) {
        if (this.localizationPlugin == null) {
            return new String[0];
        }
        List<Locale> supportedLocales = new ArrayList<>();
        for (int i = 0; i < strings.length; i += 3) {
            String languageCode = strings[i + 0];
            String countryCode = strings[i + 1];
            String scriptCode = strings[i + 2];
            if (Build.VERSION.SDK_INT >= 21) {
                Locale.Builder localeBuilder = new Locale.Builder();
                if (!languageCode.isEmpty()) {
                    localeBuilder.setLanguage(languageCode);
                }
                if (!countryCode.isEmpty()) {
                    localeBuilder.setRegion(countryCode);
                }
                if (!scriptCode.isEmpty()) {
                    localeBuilder.setScript(scriptCode);
                }
                supportedLocales.add(localeBuilder.build());
            } else {
                supportedLocales.add(new Locale(languageCode, countryCode));
            }
        }
        Locale result = this.localizationPlugin.resolveNativeLocale(supportedLocales);
        if (result == null) {
            return new String[0];
        }
        String[] output = new String[3];
        output[0] = result.getLanguage();
        output[1] = result.getCountry();
        if (Build.VERSION.SDK_INT >= 21) {
            output[2] = result.getScript();
        } else {
            output[2] = "";
        }
        return output;
    }

    public void onDisplayPlatformView(int viewId, int x, int y, int width, int height, int viewWidth, int viewHeight, FlutterMutatorsStack mutatorsStack) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onDisplayPlatformView(viewId, x, y, width, height, viewWidth, viewHeight, mutatorsStack);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativePlatformViewId.longValue());
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativePlatformViewId.longValue());
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() != this.mainLooper) {
            throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
        }
    }
}
