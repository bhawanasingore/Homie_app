package io.flutter.plugins.urllauncher;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.urllauncher.UrlLauncher;
import java.util.Map;

final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String TAG = "MethodCallHandlerImpl";
    @Nullable
    private MethodChannel channel;
    private final UrlLauncher urlLauncher;

    MethodCallHandlerImpl(UrlLauncher urlLauncher2) {
        this.urlLauncher = urlLauncher2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r7, io.flutter.plugin.common.MethodChannel.Result r8) {
        /*
            r6 = this;
            java.lang.String r0 = "url"
            java.lang.Object r0 = r7.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = r7.method
            int r2 = r1.hashCode()
            r3 = -1109843021(0xffffffffbdd923b3, float:-0.10602512)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L_0x0034
            r3 = -185306205(0xfffffffff4f473a3, float:-1.5493968E32)
            if (r2 == r3) goto L_0x002a
            r3 = -121617663(0xfffffffff8c04301, float:-3.119625E34)
            if (r2 == r3) goto L_0x0020
        L_0x001f:
            goto L_0x003e
        L_0x0020:
            java.lang.String r2 = "closeWebView"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001f
            r1 = r4
            goto L_0x003f
        L_0x002a:
            java.lang.String r2 = "canLaunch"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001f
            r1 = 0
            goto L_0x003f
        L_0x0034:
            java.lang.String r2 = "launch"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001f
            r1 = r5
            goto L_0x003f
        L_0x003e:
            r1 = -1
        L_0x003f:
            if (r1 == 0) goto L_0x0051
            if (r1 == r5) goto L_0x004d
            if (r1 == r4) goto L_0x0049
            r8.notImplemented()
            goto L_0x0055
        L_0x0049:
            r6.onCloseWebView(r8)
            goto L_0x0055
        L_0x004d:
            r6.onLaunch(r7, r8, r0)
            goto L_0x0055
        L_0x0051:
            r6.onCanLaunch(r8, r0)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.urllauncher.MethodCallHandlerImpl.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* access modifiers changed from: package-private */
    public void startListening(BinaryMessenger messenger) {
        if (this.channel != null) {
            Log.wtf(TAG, "Setting a method call handler before the last was disposed.");
            stopListening();
        }
        MethodChannel methodChannel = new MethodChannel(messenger, "plugins.flutter.io/url_launcher");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* access modifiers changed from: package-private */
    public void stopListening() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Log.d(TAG, "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
    }

    private void onCanLaunch(MethodChannel.Result result, String url) {
        result.success(Boolean.valueOf(this.urlLauncher.canLaunch(url)));
    }

    private void onLaunch(MethodCall call, MethodChannel.Result result, String url) {
        boolean useWebView = ((Boolean) call.argument("useWebView")).booleanValue();
        boolean enableJavaScript = ((Boolean) call.argument("enableJavaScript")).booleanValue();
        boolean enableDomStorage = ((Boolean) call.argument("enableDomStorage")).booleanValue();
        if (this.urlLauncher.launch(url, extractBundle((Map) call.argument("headers")), useWebView, enableJavaScript, enableDomStorage) == UrlLauncher.LaunchStatus.NO_ACTIVITY) {
            result.error("NO_ACTIVITY", "Launching a URL requires a foreground activity.", (Object) null);
        } else {
            result.success(true);
        }
    }

    private void onCloseWebView(MethodChannel.Result result) {
        this.urlLauncher.closeWebView();
        result.success((Object) null);
    }

    private static Bundle extractBundle(Map<String, String> headersMap) {
        Bundle headersBundle = new Bundle();
        for (String key : headersMap.keySet()) {
            headersBundle.putString(key, headersMap.get(key));
        }
        return headersBundle;
    }
}
