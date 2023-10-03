package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.errors.PermissionUndefinedException;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.location.LocationMapper;
import com.baseflow.geolocator.location.PositionChangedCallback;
import com.baseflow.geolocator.permission.LocationPermission;
import com.baseflow.geolocator.permission.PermissionManager;
import com.baseflow.geolocator.permission.PermissionResultCallback;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

@SynthesizedClassMap({$$Lambda$MethodCallHandlerImpl$HgwoSKdIeyav7j8ZZJufnb77Lqo.class, $$Lambda$MethodCallHandlerImpl$OCefduhIkqAV59oMDlIQqmk7z8g.class, $$Lambda$MethodCallHandlerImpl$dTMHU50CSJBag2TlT7dTUrQec0E.class, $$Lambda$MethodCallHandlerImpl$tyxDngVVF7PcImb4PihgQ0FJ8po.class})
class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String TAG = "MethodCallHandlerImpl";
    @Nullable
    private Activity activity;
    @Nullable
    private MethodChannel channel;
    @Nullable
    private Context context;
    private final GeolocationManager geolocationManager;
    private final PermissionManager permissionManager;

    MethodCallHandlerImpl(PermissionManager permissionManager2, GeolocationManager geolocationManager2) {
        this.permissionManager = permissionManager2;
        this.geolocationManager = geolocationManager2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r8, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r9) {
        /*
            r7 = this;
            java.lang.String r0 = r8.method
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r1) {
                case -1156770336: goto L_0x0041;
                case -821636766: goto L_0x0037;
                case 347240634: goto L_0x002d;
                case 356040619: goto L_0x0023;
                case 686218487: goto L_0x0019;
                case 746581438: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x004b
        L_0x000f:
            java.lang.String r1 = "requestPermission"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = r5
            goto L_0x004c
        L_0x0019:
            java.lang.String r1 = "checkPermission"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = 0
            goto L_0x004c
        L_0x0023:
            java.lang.String r1 = "isLocationServiceEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = r6
            goto L_0x004c
        L_0x002d:
            java.lang.String r1 = "openAppSettings"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = r3
            goto L_0x004c
        L_0x0037:
            java.lang.String r1 = "openLocationSettings"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = r2
            goto L_0x004c
        L_0x0041:
            java.lang.String r1 = "getLastKnownPosition"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = r4
            goto L_0x004c
        L_0x004b:
            r0 = -1
        L_0x004c:
            if (r0 == 0) goto L_0x0084
            if (r0 == r6) goto L_0x0080
            if (r0 == r5) goto L_0x007c
            if (r0 == r4) goto L_0x0078
            if (r0 == r3) goto L_0x006a
            if (r0 == r2) goto L_0x005c
            r9.notImplemented()
            goto L_0x0088
        L_0x005c:
            android.content.Context r0 = r7.context
            boolean r0 = com.baseflow.geolocator.utils.Utils.openLocationSettings(r0)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
            r9.success(r1)
            goto L_0x0088
        L_0x006a:
            android.content.Context r0 = r7.context
            boolean r0 = com.baseflow.geolocator.utils.Utils.openAppSettings(r0)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
            r9.success(r1)
            goto L_0x0088
        L_0x0078:
            r7.onGetLastKnownPosition(r8, r9)
            goto L_0x0088
        L_0x007c:
            r7.onRequestPermission(r9)
            goto L_0x0088
        L_0x0080:
            r7.onIsLocationServiceEnabled(r9)
            goto L_0x0088
        L_0x0084:
            r7.onCheckPermission(r9)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baseflow.geolocator.MethodCallHandlerImpl.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* access modifiers changed from: package-private */
    public void startListening(Context context2, BinaryMessenger messenger) {
        if (this.channel != null) {
            Log.w(TAG, "Setting a method call handler before the last was disposed.");
            stopListening();
        }
        MethodChannel methodChannel = new MethodChannel(messenger, "flutter.baseflow.com/geolocator");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.context = context2;
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

    /* access modifiers changed from: package-private */
    public void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    private void onCheckPermission(MethodChannel.Result result) {
        try {
            result.success(Integer.valueOf(this.permissionManager.checkPermissionStatus(this.context, this.activity).toInt()));
        } catch (PermissionUndefinedException e) {
            ErrorCodes errorCode = ErrorCodes.permissionDefinitionsNotFound;
            result.error(errorCode.toString(), errorCode.toDescription(), (Object) null);
        }
    }

    private void onIsLocationServiceEnabled(MethodChannel.Result result) {
        result.success(Boolean.valueOf(this.geolocationManager.isLocationServiceEnabled(this.context)));
    }

    private void onRequestPermission(MethodChannel.Result result) {
        try {
            this.permissionManager.requestPermission(this.activity, new PermissionResultCallback() {
                public final void onResult(LocationPermission locationPermission) {
                    MethodChannel.Result.this.success(Integer.valueOf(locationPermission.toInt()));
                }
            }, new ErrorCallback() {
                public final void onError(ErrorCodes errorCodes) {
                    MethodChannel.Result.this.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
                }
            });
        } catch (PermissionUndefinedException e) {
            ErrorCodes errorCode = ErrorCodes.permissionDefinitionsNotFound;
            result.error(errorCode.toString(), errorCode.toDescription(), (Object) null);
        }
    }

    private void onGetLastKnownPosition(MethodCall call, MethodChannel.Result result) {
        this.geolocationManager.getLastKnownPosition(this.context, this.activity, ((Boolean) call.argument("forceAndroidLocationManager")).booleanValue(), new PositionChangedCallback() {
            public final void onPositionChanged(Location location) {
                MethodChannel.Result.this.success(LocationMapper.toHashMap(location));
            }
        }, new ErrorCallback() {
            public final void onError(ErrorCodes errorCodes) {
                MethodChannel.Result.this.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
            }
        });
    }
}
