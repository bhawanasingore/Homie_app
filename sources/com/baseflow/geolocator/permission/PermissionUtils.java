package com.baseflow.geolocator.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

public class PermissionUtils {
    public static boolean hasPermissionInManifest(Context context, String permission) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (info.requestedPermissions != null) {
                for (String p : info.requestedPermissions) {
                    if (p.equals(permission)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    static void updatePermissionShouldShowStatus(Activity activity, String permission) {
        if (activity != null) {
            setRequestedPermission(activity, permission);
        }
    }

    static boolean isNeverAskAgainSelected(Activity activity, String name) {
        if (activity == null || Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return neverAskAgainSelected(activity, name);
    }

    @RequiresApi(api = 23)
    static boolean neverAskAgainSelected(Activity activity, String permission) {
        return getRequestedPermissionBefore(activity, permission) && !ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
    }

    static void setRequestedPermission(Context context, String permission) {
        context.getSharedPreferences("GEOLOCATOR_PERMISSIONS_REQUESTED", 0).edit().putBoolean(permission, true).apply();
    }

    static boolean getRequestedPermissionBefore(Context context, String permission) {
        return context.getSharedPreferences("GEOLOCATOR_PERMISSIONS_REQUESTED", 0).getBoolean(permission, false);
    }
}
