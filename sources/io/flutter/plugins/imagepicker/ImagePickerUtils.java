package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Arrays;

final class ImagePickerUtils {
    ImagePickerUtils() {
    }

    private static boolean isPermissionPresentInManifest(Context context, String permissionName) {
        try {
            return Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions).contains(permissionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    static boolean needRequestCameraPermission(Context context) {
        if (!(Build.VERSION.SDK_INT >= 23) || !isPermissionPresentInManifest(context, "android.permission.CAMERA")) {
            return false;
        }
        return true;
    }
}
