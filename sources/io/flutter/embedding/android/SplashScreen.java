package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public interface SplashScreen {
    View createSplashView(Context context, Bundle bundle);

    boolean doesSplashViewRememberItsTransition();

    Bundle saveSplashScreenState();

    void transitionToFlutter(Runnable runnable);

    /* renamed from: io.flutter.embedding.android.SplashScreen$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$doesSplashViewRememberItsTransition(SplashScreen _this) {
            return false;
        }

        public static Bundle $default$saveSplashScreenState(SplashScreen _this) {
            return null;
        }
    }
}
