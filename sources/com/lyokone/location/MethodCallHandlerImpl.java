package com.lyokone.location;

import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String METHOD_CHANNEL_NAME = "lyokone/location";
    private static final String TAG = "MethodCallHandlerImpl";
    @Nullable
    private MethodChannel channel;
    private final FlutterLocation location;

    MethodCallHandlerImpl(FlutterLocation location2) {
        this.location = location2;
    }

    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        if (this.location.activity == null) {
            result.error("NO_ACTIVITY", (String) null, (Object) null);
            return;
        }
        String str = call.method;
        char c = 65535;
        switch (str.hashCode()) {
            case -316023509:
                if (str.equals("getLocation")) {
                    c = 1;
                    break;
                }
                break;
            case 128007462:
                if (str.equals("requestService")) {
                    c = 5;
                    break;
                }
                break;
            case 171850761:
                if (str.equals("hasPermission")) {
                    c = 2;
                    break;
                }
                break;
            case 646862540:
                if (str.equals("serviceEnabled")) {
                    c = 4;
                    break;
                }
                break;
            case 746581438:
                if (str.equals("requestPermission")) {
                    c = 3;
                    break;
                }
                break;
            case 1149076467:
                if (str.equals("changeSettings")) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            onChangeSettings(call, result);
        } else if (c == 1) {
            onGetLocation(result);
        } else if (c == 2) {
            onHasPermission(result);
        } else if (c == 3) {
            onRequestPermission(result);
        } else if (c == 4) {
            this.location.checkServiceEnabled(result);
        } else if (c != 5) {
            result.notImplemented();
        } else {
            this.location.requestService(result);
        }
    }

    /* access modifiers changed from: package-private */
    public void startListening(BinaryMessenger messenger) {
        if (this.channel != null) {
            Log.wtf(TAG, "Setting a method call handler before the last was disposed.");
            stopListening();
        }
        MethodChannel methodChannel = new MethodChannel(messenger, METHOD_CHANNEL_NAME);
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

    private void onChangeSettings(MethodCall call, MethodChannel.Result result) {
        try {
            Long updateIntervalMilliseconds = new Long((long) ((Integer) call.argument("interval")).intValue());
            Long fastestUpdateIntervalMilliseconds = Long.valueOf(updateIntervalMilliseconds.longValue() / 2);
            Float distanceFilter = new Float(((Double) call.argument("distanceFilter")).doubleValue());
            this.location.changeSettings(this.location.mapFlutterAccuracy.get(call.argument("accuracy")), updateIntervalMilliseconds, fastestUpdateIntervalMilliseconds, distanceFilter);
            result.success(1);
        } catch (Exception e) {
            result.error("CHANGE_SETTINGS_ERROR", "An unexcepted error happened during location settings change:" + e.getMessage(), (Object) null);
        }
    }

    private void onGetLocation(MethodChannel.Result result) {
        this.location.getLocationResult = result;
        if (!this.location.checkPermissions()) {
            this.location.requestPermissions();
        } else {
            this.location.startRequestingLocation();
        }
    }

    private void onHasPermission(MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT < 23) {
            result.success(1);
        } else if (this.location.checkPermissions()) {
            result.success(1);
        } else {
            result.success(0);
        }
    }

    private void onRequestPermission(MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT < 23) {
            result.success(1);
            return;
        }
        this.location.result = result;
        this.location.requestPermissions();
    }
}
