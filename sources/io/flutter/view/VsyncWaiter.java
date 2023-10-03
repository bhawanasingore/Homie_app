package io.flutter.view;

import android.view.Choreographer;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;

public class VsyncWaiter {
    private static VsyncWaiter instance;
    private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() {
        public void asyncWaitForVsync(final long cookie) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
                public void doFrame(long frameTimeNanos) {
                    FlutterJNI.nativeOnVsync(frameTimeNanos, frameTimeNanos + ((long) (1.0E9d / ((double) VsyncWaiter.this.windowManager.getDefaultDisplay().getRefreshRate()))), cookie);
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public final WindowManager windowManager;

    public static VsyncWaiter getInstance(WindowManager windowManager2) {
        if (instance == null) {
            instance = new VsyncWaiter(windowManager2);
        }
        return instance;
    }

    private VsyncWaiter(WindowManager windowManager2) {
        this.windowManager = windowManager2;
    }

    public void init() {
        FlutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
        FlutterJNI.setRefreshRateFPS(this.windowManager.getDefaultDisplay().getRefreshRate());
    }
}
