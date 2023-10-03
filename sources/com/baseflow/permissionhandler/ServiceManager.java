package com.baseflow.permissionhandler;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

final class ServiceManager {

    @FunctionalInterface
    interface SuccessCallback {
        void onSuccess(int i);
    }

    ServiceManager() {
    }

    /* access modifiers changed from: package-private */
    public void checkServiceStatus(int permission, Context context, SuccessCallback successCallback, ErrorCallback errorCallback) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            errorCallback.onError("PermissionHandler.ServiceManager", "Android context cannot be null.");
        } else if (permission == 3 || permission == 4 || permission == 5) {
            successCallback.onSuccess((int) isLocationServiceEnabled(context));
        } else {
            int serviceStatus = 1;
            if (permission == 8) {
                PackageManager pm = context.getPackageManager();
                if (!pm.hasSystemFeature("android.hardware.telephony")) {
                    successCallback.onSuccess(2);
                    return;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
                    successCallback.onSuccess(2);
                    return;
                }
                Intent callIntent = new Intent("android.intent.action.CALL");
                callIntent.setData(Uri.parse("tel:123123"));
                if (pm.queryIntentActivities(callIntent, 0).isEmpty()) {
                    successCallback.onSuccess(2);
                } else if (telephonyManager.getSimState() != 5) {
                    successCallback.onSuccess(0);
                } else {
                    successCallback.onSuccess(1);
                }
            } else if (permission == 15) {
                if (Build.VERSION.SDK_INT < 23) {
                    serviceStatus = 2;
                }
                successCallback.onSuccess(serviceStatus);
            } else {
                successCallback.onSuccess(2);
            }
        }
    }

    private boolean isLocationServiceEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            LocationManager locationManager = (LocationManager) context.getSystemService(LocationManager.class);
            if (locationManager == null) {
                return false;
            }
            return locationManager.isLocationEnabled();
        } else if (Build.VERSION.SDK_INT >= 19) {
            return isLocationServiceEnabledKitKat(context);
        } else {
            return isLocationServiceEnablePreKitKat(context);
        }
    }

    private static boolean isLocationServiceEnabledKitKat(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0) {
                return true;
            }
            return false;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isLocationServiceEnablePreKitKat(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return false;
        }
        return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
    }
}
