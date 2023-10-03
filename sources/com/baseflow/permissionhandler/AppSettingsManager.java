package com.baseflow.permissionhandler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.common.primitives.Ints;

final class AppSettingsManager {

    @FunctionalInterface
    interface OpenAppSettingsSuccessCallback {
        void onSuccess(boolean z);
    }

    AppSettingsManager() {
    }

    /* access modifiers changed from: package-private */
    public void openAppSettings(Context context, OpenAppSettingsSuccessCallback successCallback, ErrorCallback errorCallback) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            errorCallback.onError("PermissionHandler.AppSettingsManager", "Android context cannot be null.");
            return;
        }
        try {
            Intent settingsIntent = new Intent();
            settingsIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            settingsIntent.addCategory("android.intent.category.DEFAULT");
            settingsIntent.setData(Uri.parse("package:" + context.getPackageName()));
            settingsIntent.addFlags(268435456);
            settingsIntent.addFlags(Ints.MAX_POWER_OF_TWO);
            settingsIntent.addFlags(8388608);
            context.startActivity(settingsIntent);
            successCallback.onSuccess(true);
        } catch (Exception e) {
            successCallback.onSuccess(false);
        }
    }
}
