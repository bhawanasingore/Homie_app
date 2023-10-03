package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.baseflow.permissionhandler.PermissionManager;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SynthesizedClassMap({$$Lambda$PermissionManager$C1Lc2eGN38XZcT6FjxSuqfMM4XU.class})
final class PermissionManager {
    private boolean ongoing = false;

    @FunctionalInterface
    interface ActivityRegistry {
        void addListener(PluginRegistry.ActivityResultListener activityResultListener);
    }

    @FunctionalInterface
    interface CheckPermissionsSuccessCallback {
        void onSuccess(int i);
    }

    @FunctionalInterface
    interface PermissionRegistry {
        void addListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener);
    }

    @FunctionalInterface
    interface RequestPermissionsSuccessCallback {
        void onSuccess(Map<Integer, Integer> map);
    }

    @FunctionalInterface
    interface ShouldShowRequestPermissionRationaleSuccessCallback {
        void onSuccess(boolean z);
    }

    PermissionManager() {
    }

    /* access modifiers changed from: package-private */
    public void checkPermissionStatus(int permission, Context context, Activity activity, CheckPermissionsSuccessCallback successCallback, ErrorCallback errorCallback) {
        successCallback.onSuccess(determinePermissionStatus(permission, context, activity));
    }

    /* access modifiers changed from: package-private */
    public void requestPermissions(List<Integer> permissions, Activity activity, ActivityRegistry activityRegistry, PermissionRegistry permissionRegistry, RequestPermissionsSuccessCallback successCallback, ErrorCallback errorCallback) {
        Activity activity2 = activity;
        RequestPermissionsSuccessCallback requestPermissionsSuccessCallback = successCallback;
        ErrorCallback errorCallback2 = errorCallback;
        if (this.ongoing) {
            errorCallback2.onError("PermissionHandler.PermissionManager", "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).");
        } else if (activity2 == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            errorCallback2.onError("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
        } else {
            Map<Integer, Integer> requestResults = new HashMap<>();
            ArrayList<String> permissionsToRequest = new ArrayList<>();
            for (Integer permission : permissions) {
                if (determinePermissionStatus(permission.intValue(), activity2, activity2) != 1) {
                    List<String> names = PermissionUtils.getManifestNames(activity2, permission.intValue());
                    if (names == null) {
                        ActivityRegistry activityRegistry2 = activityRegistry;
                    } else if (names.isEmpty()) {
                        ActivityRegistry activityRegistry3 = activityRegistry;
                    } else if (Build.VERSION.SDK_INT < 23 || permission.intValue() != 15) {
                        ActivityRegistry activityRegistry4 = activityRegistry;
                        permissionsToRequest.addAll(names);
                    } else {
                        activityRegistry.addListener(new ActivityResultListener(requestPermissionsSuccessCallback));
                        String packageName = activity.getPackageName();
                        Intent intent = new Intent();
                        intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                        intent.setData(Uri.parse("package:" + packageName));
                        activity2.startActivityForResult(intent, 5672353);
                    }
                    if (!requestResults.containsKey(permission)) {
                        requestResults.put(permission, 3);
                    }
                } else if (!requestResults.containsKey(permission)) {
                    requestResults.put(permission, 1);
                }
            }
            ActivityRegistry activityRegistry5 = activityRegistry;
            String[] requestPermissions = (String[]) permissionsToRequest.toArray(new String[0]);
            if (permissionsToRequest.size() > 0) {
                permissionRegistry.addListener(new RequestPermissionsListener(activity2, requestResults, new RequestPermissionsSuccessCallback(requestPermissionsSuccessCallback) {
                    public final /* synthetic */ PermissionManager.RequestPermissionsSuccessCallback f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSuccess(Map map) {
                        PermissionManager.this.lambda$requestPermissions$0$PermissionManager(this.f$1, map);
                    }
                }));
                this.ongoing = true;
                ActivityCompat.requestPermissions(activity2, requestPermissions, 24);
                return;
            }
            PermissionRegistry permissionRegistry2 = permissionRegistry;
            this.ongoing = false;
            if (requestResults.size() > 0) {
                requestPermissionsSuccessCallback.onSuccess(requestResults);
            }
        }
    }

    public /* synthetic */ void lambda$requestPermissions$0$PermissionManager(RequestPermissionsSuccessCallback successCallback, Map results) {
        this.ongoing = false;
        successCallback.onSuccess(results);
    }

    private int determinePermissionStatus(int permission, Context context, @Nullable Activity activity) {
        if (permission == 16) {
            return checkNotificationPermissionStatus(context);
        }
        List<String> names = PermissionUtils.getManifestNames(context, permission);
        if (names == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + permission);
            return 1;
        } else if (names.size() == 0) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + permission);
            return 3;
        } else {
            boolean targetsMOrHigher = context.getApplicationInfo().targetSdkVersion >= 23;
            for (String name : names) {
                if (targetsMOrHigher) {
                    if (permission == 15) {
                        String packageName = context.getPackageName();
                        PowerManager pm = (PowerManager) context.getSystemService("power");
                        if (Build.VERSION.SDK_INT < 23) {
                            return 2;
                        }
                        if (pm == null || !pm.isIgnoringBatteryOptimizations(packageName)) {
                            return 0;
                        }
                        return 1;
                    }
                    int permissionStatus = ContextCompat.checkSelfPermission(context, name);
                    if (permissionStatus == -1) {
                        if (!PermissionUtils.getRequestedPermissionBefore(context, name)) {
                            return 3;
                        }
                        if (Build.VERSION.SDK_INT < 23 || !PermissionUtils.isNeverAskAgainSelected(activity, name)) {
                            return 0;
                        }
                        return 4;
                    } else if (permissionStatus != 0) {
                        return 0;
                    }
                }
            }
            return 1;
        }
    }

    /* access modifiers changed from: package-private */
    public void shouldShowRequestPermissionRationale(int permission, Activity activity, ShouldShowRequestPermissionRationaleSuccessCallback successCallback, ErrorCallback errorCallback) {
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            errorCallback.onError("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List<String> names = PermissionUtils.getManifestNames(activity, permission);
        if (names == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + permission);
            successCallback.onSuccess(false);
        } else if (names.isEmpty()) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + permission + " no need to show request rationale");
            successCallback.onSuccess(false);
        } else {
            successCallback.onSuccess(ActivityCompat.shouldShowRequestPermissionRationale(activity, names.get(0)));
        }
    }

    private int checkNotificationPermissionStatus(Context context) {
        if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return 1;
        }
        return 0;
    }

    @VisibleForTesting
    static final class ActivityResultListener implements PluginRegistry.ActivityResultListener {
        boolean alreadyCalled = false;
        final RequestPermissionsSuccessCallback callback;

        @VisibleForTesting
        ActivityResultListener(RequestPermissionsSuccessCallback callback2) {
            this.callback = callback2;
        }

        public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
            int status = 0;
            if (this.alreadyCalled || requestCode != 5672353) {
                return false;
            }
            this.alreadyCalled = true;
            if (resultCode == -1) {
                status = 1;
            }
            HashMap<Integer, Integer> results = new HashMap<>();
            results.put(15, Integer.valueOf(status));
            this.callback.onSuccess(results);
            return true;
        }
    }

    @VisibleForTesting
    static final class RequestPermissionsListener implements PluginRegistry.RequestPermissionsResultListener {
        final Activity activity;
        boolean alreadyCalled = false;
        final RequestPermissionsSuccessCallback callback;
        final Map<Integer, Integer> requestResults;

        @VisibleForTesting
        RequestPermissionsListener(Activity activity2, Map<Integer, Integer> requestResults2, RequestPermissionsSuccessCallback callback2) {
            this.activity = activity2;
            this.callback = callback2;
            this.requestResults = requestResults2;
        }

        public boolean onRequestPermissionsResult(int id, String[] permissions, int[] grantResults) {
            if (this.alreadyCalled || id != 24) {
                return false;
            }
            this.alreadyCalled = true;
            for (int i = 0; i < permissions.length; i++) {
                String permissionName = permissions[i];
                int permission = PermissionUtils.parseManifestName(permissionName);
                if (permission != 19) {
                    int result = grantResults[i];
                    if (permission == 7) {
                        if (!this.requestResults.containsKey(7)) {
                            this.requestResults.put(7, Integer.valueOf(PermissionUtils.toPermissionStatus(this.activity, permissionName, result)));
                        }
                        if (!this.requestResults.containsKey(13)) {
                            this.requestResults.put(13, Integer.valueOf(PermissionUtils.toPermissionStatus(this.activity, permissionName, result)));
                        }
                    } else if (permission == 4) {
                        int permissionStatus = PermissionUtils.toPermissionStatus(this.activity, permissionName, result);
                        if (!this.requestResults.containsKey(4)) {
                            this.requestResults.put(4, Integer.valueOf(permissionStatus));
                        }
                    } else if (permission == 3) {
                        int permissionStatus2 = PermissionUtils.toPermissionStatus(this.activity, permissionName, result);
                        if (Build.VERSION.SDK_INT < 29 && !this.requestResults.containsKey(4)) {
                            this.requestResults.put(4, Integer.valueOf(permissionStatus2));
                        }
                        if (!this.requestResults.containsKey(5)) {
                            this.requestResults.put(5, Integer.valueOf(permissionStatus2));
                        }
                        this.requestResults.put(Integer.valueOf(permission), Integer.valueOf(permissionStatus2));
                    } else if (!this.requestResults.containsKey(Integer.valueOf(permission))) {
                        this.requestResults.put(Integer.valueOf(permission), Integer.valueOf(PermissionUtils.toPermissionStatus(this.activity, permissionName, result)));
                    }
                    PermissionUtils.updatePermissionShouldShowStatus(this.activity, permission);
                }
            }
            this.callback.onSuccess(this.requestResults);
            return true;
        }
    }
}
