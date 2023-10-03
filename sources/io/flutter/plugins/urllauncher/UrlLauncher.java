package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;

class UrlLauncher {
    @Nullable
    private Activity activity;
    private final Context applicationContext;

    enum LaunchStatus {
        OK,
        NO_ACTIVITY
    }

    UrlLauncher(Context applicationContext2, @Nullable Activity activity2) {
        this.applicationContext = applicationContext2;
        this.activity = activity2;
    }

    /* access modifiers changed from: package-private */
    public void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    /* access modifiers changed from: package-private */
    public boolean canLaunch(String url) {
        Intent launchIntent = new Intent("android.intent.action.VIEW");
        launchIntent.setData(Uri.parse(url));
        ComponentName componentName = launchIntent.resolveActivity(this.applicationContext.getPackageManager());
        return componentName != null && !"{com.android.fallback/com.android.fallback.Fallback}".equals(componentName.toShortString());
    }

    /* access modifiers changed from: package-private */
    public LaunchStatus launch(String url, Bundle headersBundle, boolean useWebView, boolean enableJavaScript, boolean enableDomStorage) {
        Intent launchIntent;
        Activity activity2 = this.activity;
        if (activity2 == null) {
            return LaunchStatus.NO_ACTIVITY;
        }
        if (useWebView) {
            launchIntent = WebViewActivity.createIntent(activity2, url, enableJavaScript, enableDomStorage, headersBundle);
        } else {
            launchIntent = new Intent("android.intent.action.VIEW").setData(Uri.parse(url)).putExtra("com.android.browser.headers", headersBundle);
        }
        this.activity.startActivity(launchIntent);
        return LaunchStatus.OK;
    }

    /* access modifiers changed from: package-private */
    public void closeWebView() {
        this.applicationContext.sendBroadcast(new Intent(WebViewActivity.ACTION_CLOSE));
    }
}
