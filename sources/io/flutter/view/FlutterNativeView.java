package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;

public class FlutterNativeView implements BinaryMessenger {
    private static final String TAG = "FlutterNativeView";
    private boolean applicationIsRunning;
    private final DartExecutor dartExecutor;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private final Context mContext;
    private final FlutterJNI mFlutterJNI;
    /* access modifiers changed from: private */
    public FlutterView mFlutterView;
    /* access modifiers changed from: private */
    public final FlutterPluginRegistry mPluginRegistry;

    public FlutterNativeView(Context context) {
        this(context, false);
    }

    public FlutterNativeView(Context context, boolean isBackgroundView) {
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                if (FlutterNativeView.this.mFlutterView != null) {
                    FlutterNativeView.this.mFlutterView.onFirstFrame();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.mContext = context;
        this.mPluginRegistry = new FlutterPluginRegistry(this, context);
        FlutterJNI flutterJNI = new FlutterJNI();
        this.mFlutterJNI = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        this.dartExecutor = new DartExecutor(this.mFlutterJNI, context.getAssets());
        this.mFlutterJNI.addEngineLifecycleListener(new EngineLifecycleListenerImpl());
        attach(this, isBackgroundView);
        assertAttached();
    }

    public void detachFromFlutterView() {
        this.mPluginRegistry.detach();
        this.mFlutterView = null;
    }

    public void destroy() {
        this.mPluginRegistry.destroy();
        this.dartExecutor.onDetachedFromJNI();
        this.mFlutterView = null;
        this.mFlutterJNI.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        this.mFlutterJNI.detachFromNativeAndReleaseResources();
        this.applicationIsRunning = false;
    }

    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.mPluginRegistry;
    }

    public void attachViewAndActivity(FlutterView flutterView, Activity activity) {
        this.mFlutterView = flutterView;
        this.mPluginRegistry.attach(flutterView, activity);
    }

    public boolean isAttached() {
        return this.mFlutterJNI.isAttached();
    }

    public void assertAttached() {
        if (!isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    public void runFromBundle(FlutterRunArguments args) {
        if (args.entrypoint != null) {
            assertAttached();
            if (!this.applicationIsRunning) {
                this.mFlutterJNI.runBundleAndSnapshotFromLibrary(args.bundlePath, args.entrypoint, args.libraryPath, this.mContext.getResources().getAssets());
                this.applicationIsRunning = true;
                return;
            }
            throw new AssertionError("This Flutter engine instance is already running an application");
        }
        throw new AssertionError("An entrypoint must be specified");
    }

    public boolean isApplicationRunning() {
        return this.applicationIsRunning;
    }

    public static String getObservatoryUri() {
        return FlutterJNI.getObservatoryUri();
    }

    public void send(String channel, ByteBuffer message) {
        this.dartExecutor.getBinaryMessenger().send(channel, message);
    }

    public void send(String channel, ByteBuffer message, BinaryMessenger.BinaryReply callback) {
        if (!isAttached()) {
            Log.d(TAG, "FlutterView.send called on a detached view, channel=" + channel);
            return;
        }
        this.dartExecutor.getBinaryMessenger().send(channel, message, callback);
    }

    public void setMessageHandler(String channel, BinaryMessenger.BinaryMessageHandler handler) {
        this.dartExecutor.getBinaryMessenger().setMessageHandler(channel, handler);
    }

    /* access modifiers changed from: package-private */
    public FlutterJNI getFlutterJNI() {
        return this.mFlutterJNI;
    }

    private void attach(FlutterNativeView view, boolean isBackgroundView) {
        this.mFlutterJNI.attachToNative(isBackgroundView);
        this.dartExecutor.onAttachedToJNI();
    }

    private final class EngineLifecycleListenerImpl implements FlutterEngine.EngineLifecycleListener {
        private EngineLifecycleListenerImpl() {
        }

        public void onPreEngineRestart() {
            if (FlutterNativeView.this.mFlutterView != null) {
                FlutterNativeView.this.mFlutterView.resetAccessibilityTree();
            }
            if (FlutterNativeView.this.mPluginRegistry != null) {
                FlutterNativeView.this.mPluginRegistry.onPreEngineRestart();
            }
        }
    }
}
