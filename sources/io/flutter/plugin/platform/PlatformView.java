package io.flutter.plugin.platform;

import android.view.View;

public interface PlatformView {
    void dispose();

    View getView();

    void onFlutterViewAttached(View view);

    void onFlutterViewDetached();

    void onInputConnectionLocked();

    void onInputConnectionUnlocked();

    /* renamed from: io.flutter.plugin.platform.PlatformView$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFlutterViewAttached(PlatformView _this, View flutterView) {
        }

        public static void $default$onFlutterViewDetached(PlatformView _this) {
        }

        public static void $default$onInputConnectionLocked(PlatformView _this) {
        }

        public static void $default$onInputConnectionUnlocked(PlatformView _this) {
        }
    }
}
