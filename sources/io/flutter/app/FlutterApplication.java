package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import io.flutter.FlutterInjector;

public class FlutterApplication extends Application {
    private Activity mCurrentActivity = null;

    public void onCreate() {
        super.onCreate();
        FlutterInjector.instance().flutterLoader().startInitialization(this);
    }

    public Activity getCurrentActivity() {
        return this.mCurrentActivity;
    }

    public void setCurrentActivity(Activity mCurrentActivity2) {
        this.mCurrentActivity = mCurrentActivity2;
    }
}
