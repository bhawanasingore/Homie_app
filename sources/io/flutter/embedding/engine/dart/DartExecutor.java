package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StringCodec;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;

public class DartExecutor implements BinaryMessenger {
    private static final String TAG = "DartExecutor";
    private final AssetManager assetManager;
    private final BinaryMessenger binaryMessenger;
    private final DartMessenger dartMessenger;
    private final FlutterJNI flutterJNI;
    private boolean isApplicationRunning = false;
    private final BinaryMessenger.BinaryMessageHandler isolateChannelMessageHandler = new BinaryMessenger.BinaryMessageHandler() {
        public void onMessage(ByteBuffer message, BinaryMessenger.BinaryReply callback) {
            String unused = DartExecutor.this.isolateServiceId = StringCodec.INSTANCE.decodeMessage(message);
            if (DartExecutor.this.isolateServiceIdListener != null) {
                DartExecutor.this.isolateServiceIdListener.onIsolateServiceIdAvailable(DartExecutor.this.isolateServiceId);
            }
        }
    };
    /* access modifiers changed from: private */
    public String isolateServiceId;
    /* access modifiers changed from: private */
    public IsolateServiceIdListener isolateServiceIdListener;

    interface IsolateServiceIdListener {
        void onIsolateServiceIdAvailable(String str);
    }

    public DartExecutor(FlutterJNI flutterJNI2, AssetManager assetManager2) {
        this.flutterJNI = flutterJNI2;
        this.assetManager = assetManager2;
        DartMessenger dartMessenger2 = new DartMessenger(flutterJNI2);
        this.dartMessenger = dartMessenger2;
        dartMessenger2.setMessageHandler("flutter/isolate", this.isolateChannelMessageHandler);
        this.binaryMessenger = new DefaultBinaryMessenger(this.dartMessenger);
    }

    public void onAttachedToJNI() {
        Log.v(TAG, "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.flutterJNI.setPlatformMessageHandler(this.dartMessenger);
    }

    public void onDetachedFromJNI() {
        Log.v(TAG, "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.flutterJNI.setPlatformMessageHandler((PlatformMessageHandler) null);
    }

    public boolean isExecutingDart() {
        return this.isApplicationRunning;
    }

    public void executeDartEntrypoint(DartEntrypoint dartEntrypoint) {
        if (this.isApplicationRunning) {
            Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        Log.v(TAG, "Executing Dart entrypoint: " + dartEntrypoint);
        this.flutterJNI.runBundleAndSnapshotFromLibrary(dartEntrypoint.pathToBundle, dartEntrypoint.dartEntrypointFunctionName, (String) null, this.assetManager);
        this.isApplicationRunning = true;
    }

    public void executeDartCallback(DartCallback dartCallback) {
        if (this.isApplicationRunning) {
            Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        Log.v(TAG, "Executing Dart callback: " + dartCallback);
        this.flutterJNI.runBundleAndSnapshotFromLibrary(dartCallback.pathToBundle, dartCallback.callbackHandle.callbackName, dartCallback.callbackHandle.callbackLibraryPath, dartCallback.androidAssetManager);
        this.isApplicationRunning = true;
    }

    public BinaryMessenger getBinaryMessenger() {
        return this.binaryMessenger;
    }

    @Deprecated
    public void send(String channel, ByteBuffer message) {
        this.binaryMessenger.send(channel, message);
    }

    @Deprecated
    public void send(String channel, ByteBuffer message, BinaryMessenger.BinaryReply callback) {
        this.binaryMessenger.send(channel, message, callback);
    }

    @Deprecated
    public void setMessageHandler(String channel, BinaryMessenger.BinaryMessageHandler handler) {
        this.binaryMessenger.setMessageHandler(channel, handler);
    }

    public int getPendingChannelResponseCount() {
        return this.dartMessenger.getPendingChannelResponseCount();
    }

    public String getIsolateServiceId() {
        return this.isolateServiceId;
    }

    public void setIsolateServiceIdListener(IsolateServiceIdListener listener) {
        String str;
        this.isolateServiceIdListener = listener;
        if (listener != null && (str = this.isolateServiceId) != null) {
            listener.onIsolateServiceIdAvailable(str);
        }
    }

    public void notifyLowMemoryWarning() {
        if (this.flutterJNI.isAttached()) {
            this.flutterJNI.notifyLowMemoryWarning();
        }
    }

    public static class DartEntrypoint {
        public final String dartEntrypointFunctionName;
        public final String pathToBundle;

        public static DartEntrypoint createDefault() {
            FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
            if (flutterLoader.initialized()) {
                return new DartEntrypoint(flutterLoader.findAppBundlePath(), "main");
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public DartEntrypoint(String pathToBundle2, String dartEntrypointFunctionName2) {
            this.pathToBundle = pathToBundle2;
            this.dartEntrypointFunctionName = dartEntrypointFunctionName2;
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.pathToBundle + ", function: " + this.dartEntrypointFunctionName + " )";
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            DartEntrypoint that = (DartEntrypoint) o;
            if (!this.pathToBundle.equals(that.pathToBundle)) {
                return false;
            }
            return this.dartEntrypointFunctionName.equals(that.dartEntrypointFunctionName);
        }

        public int hashCode() {
            return (this.pathToBundle.hashCode() * 31) + this.dartEntrypointFunctionName.hashCode();
        }
    }

    public static class DartCallback {
        public final AssetManager androidAssetManager;
        public final FlutterCallbackInformation callbackHandle;
        public final String pathToBundle;

        public DartCallback(AssetManager androidAssetManager2, String pathToBundle2, FlutterCallbackInformation callbackHandle2) {
            this.androidAssetManager = androidAssetManager2;
            this.pathToBundle = pathToBundle2;
            this.callbackHandle = callbackHandle2;
        }

        public String toString() {
            return "DartCallback( bundle path: " + this.pathToBundle + ", library path: " + this.callbackHandle.callbackLibraryPath + ", function: " + this.callbackHandle.callbackName + " )";
        }
    }

    private static class DefaultBinaryMessenger implements BinaryMessenger {
        private final DartMessenger messenger;

        private DefaultBinaryMessenger(DartMessenger messenger2) {
            this.messenger = messenger2;
        }

        public void send(String channel, ByteBuffer message) {
            this.messenger.send(channel, message, (BinaryMessenger.BinaryReply) null);
        }

        public void send(String channel, ByteBuffer message, BinaryMessenger.BinaryReply callback) {
            this.messenger.send(channel, message, callback);
        }

        public void setMessageHandler(String channel, BinaryMessenger.BinaryMessageHandler handler) {
            this.messenger.setMessageHandler(channel, handler);
        }
    }
}
