package io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import io.flutter.app.FlutterActivityDelegate;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

public class FlutterFragmentActivity extends FragmentActivity implements FlutterView.Provider, PluginRegistry, FlutterActivityDelegate.ViewFactory {
    private final FlutterActivityDelegate delegate;
    private final FlutterActivityEvents eventDelegate;
    private final PluginRegistry pluginRegistry;
    private final FlutterView.Provider viewProvider;

    public FlutterFragmentActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.delegate = flutterActivityDelegate;
        this.eventDelegate = flutterActivityDelegate;
        this.viewProvider = flutterActivityDelegate;
        this.pluginRegistry = flutterActivityDelegate;
    }

    public FlutterView getFlutterView() {
        return this.viewProvider.getFlutterView();
    }

    public FlutterView createFlutterView(Context context) {
        return null;
    }

    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    public boolean retainFlutterNativeView() {
        return false;
    }

    public final boolean hasPlugin(String key) {
        return this.pluginRegistry.hasPlugin(key);
    }

    public final <T> T valuePublishedByPlugin(String pluginKey) {
        return this.pluginRegistry.valuePublishedByPlugin(pluginKey);
    }

    public final PluginRegistry.Registrar registrarFor(String pluginKey) {
        return this.pluginRegistry.registrarFor(pluginKey);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.eventDelegate.onCreate(savedInstanceState);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.eventDelegate.onDestroy();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (!this.eventDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.eventDelegate.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.eventDelegate.onStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.eventDelegate.onPause();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.eventDelegate.onPostResume();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        this.eventDelegate.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!this.eventDelegate.onActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.eventDelegate.onNewIntent(intent);
    }

    public void onUserLeaveHint() {
        this.eventDelegate.onUserLeaveHint();
    }

    public void onTrimMemory(int level) {
        this.eventDelegate.onTrimMemory(level);
    }

    public void onLowMemory() {
        this.eventDelegate.onLowMemory();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.eventDelegate.onConfigurationChanged(newConfig);
    }
}
