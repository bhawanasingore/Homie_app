package com.baseflow.geolocator.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.errors.PermissionUndefinedException;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;

public class PermissionManager implements PluginRegistry.RequestPermissionsResultListener {
    private static final int PERMISSION_REQUEST_CODE = 109;
    @Nullable
    private Activity activity;
    @Nullable
    private ErrorCallback errorCallback;
    @Nullable
    private PermissionResultCallback resultCallback;

    public LocationPermission checkPermissionStatus(Context context, Activity activity2) throws PermissionUndefinedException {
        String permission = determineFineOrCoarse(context);
        if (Build.VERSION.SDK_INT < 23) {
            return LocationPermission.always;
        }
        if (ContextCompat.checkSelfPermission(context, permission) == -1) {
            if (PermissionUtils.isNeverAskAgainSelected(activity2, permission)) {
                return LocationPermission.deniedForever;
            }
            return LocationPermission.denied;
        } else if (Build.VERSION.SDK_INT < 29) {
            return LocationPermission.always;
        } else {
            if (!PermissionUtils.hasPermissionInManifest(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                return LocationPermission.whileInUse;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
                return LocationPermission.always;
            }
            return LocationPermission.whileInUse;
        }
    }

    public void requestPermission(Activity activity2, PermissionResultCallback resultCallback2, ErrorCallback errorCallback2) throws PermissionUndefinedException {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 23) {
            permissionsToRequest.add(determineFineOrCoarse(activity2));
            if (Build.VERSION.SDK_INT >= 29 && PermissionUtils.hasPermissionInManifest(activity2, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                permissionsToRequest.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            }
            this.errorCallback = errorCallback2;
            this.resultCallback = resultCallback2;
            this.activity = activity2;
            ActivityCompat.requestPermissions(activity2, (String[]) permissionsToRequest.toArray(new String[0]), 109);
        }
    }

    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != 109) {
            return false;
        }
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Log.e("Geolocator", "Trying to process permission result without an valid Activity instance");
            ErrorCallback errorCallback2 = this.errorCallback;
            if (errorCallback2 != null) {
                errorCallback2.onError(ErrorCodes.activityNotSupplied);
            }
            return false;
        }
        try {
            String requestedPermission = determineFineOrCoarse(activity2);
            LocationPermission permission = LocationPermission.denied;
            int requestedPermissionIndex = indexOf(permissions, requestedPermission);
            if (requestedPermissionIndex < 0) {
                Log.w("Geolocator", "Location permissions not part of permissions send to onRequestPermissionsResult method.");
                return false;
            } else if (grantResults.length == 0) {
                Log.i("Geolocator", "The grantResults array is empty. This can happen when the user cancels the permission request");
                return false;
            } else {
                if (grantResults[requestedPermissionIndex] == 0) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        int backgroundPermissionIndex = indexOf(permissions, "android.permission.ACCESS_BACKGROUND_LOCATION");
                        permission = (backgroundPermissionIndex < 0 || grantResults[backgroundPermissionIndex] != 0) ? LocationPermission.whileInUse : LocationPermission.always;
                    } else {
                        permission = LocationPermission.always;
                    }
                } else if (Build.VERSION.SDK_INT >= 23 && !this.activity.shouldShowRequestPermissionRationale(requestedPermission)) {
                    permission = LocationPermission.deniedForever;
                }
                for (String perm : permissions) {
                    PermissionUtils.setRequestedPermission(this.activity, perm);
                }
                PermissionResultCallback permissionResultCallback = this.resultCallback;
                if (permissionResultCallback == null) {
                    return true;
                }
                permissionResultCallback.onResult(permission);
                return true;
            }
        } catch (PermissionUndefinedException e) {
            ErrorCallback errorCallback3 = this.errorCallback;
            if (errorCallback3 != null) {
                errorCallback3.onError(ErrorCodes.permissionDefinitionsNotFound);
            }
            return false;
        }
    }

    private static <T> int indexOf(T[] arr, T val) {
        return Arrays.asList(arr).indexOf(val);
    }

    private static String determineFineOrCoarse(Context context) throws PermissionUndefinedException {
        boolean wantsFineLocation = PermissionUtils.hasPermissionInManifest(context, "android.permission.ACCESS_FINE_LOCATION");
        if (!PermissionUtils.hasPermissionInManifest(context, "android.permission.ACCESS_COARSE_LOCATION") && !wantsFineLocation) {
            throw new PermissionUndefinedException();
        } else if (wantsFineLocation) {
            return "android.permission.ACCESS_FINE_LOCATION";
        } else {
            return "android.permission.ACCESS_COARSE_LOCATION";
        }
    }
}
