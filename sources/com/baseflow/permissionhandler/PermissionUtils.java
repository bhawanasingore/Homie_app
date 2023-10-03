package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PermissionUtils {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int parseManifestName(java.lang.String r14) {
        /*
            int r0 = r14.hashCode()
            r1 = 19
            r2 = 18
            r3 = 17
            r4 = 14
            r5 = 12
            r6 = 11
            r7 = 8
            r8 = 7
            r9 = 3
            r10 = 4
            r11 = 2
            r12 = 1
            r13 = 0
            switch(r0) {
                case -2062386608: goto L_0x013e;
                case -1928411001: goto L_0x0134;
                case -1921431796: goto L_0x012a;
                case -1888586689: goto L_0x0120;
                case -1479758289: goto L_0x0115;
                case -1238066820: goto L_0x010b;
                case -901151997: goto L_0x0100;
                case -895679497: goto L_0x00f5;
                case -895673731: goto L_0x00eb;
                case -406040016: goto L_0x00df;
                case -63024214: goto L_0x00d4;
                case -5573545: goto L_0x00c8;
                case 52602690: goto L_0x00bd;
                case 112197485: goto L_0x00b2;
                case 214526995: goto L_0x00a7;
                case 463403621: goto L_0x009c;
                case 603653886: goto L_0x0091;
                case 610633091: goto L_0x0085;
                case 784519842: goto L_0x0079;
                case 1271781903: goto L_0x006e;
                case 1365911975: goto L_0x0062;
                case 1780337063: goto L_0x0056;
                case 1831139720: goto L_0x004a;
                case 1977429404: goto L_0x003f;
                case 2024715147: goto L_0x0034;
                case 2114579147: goto L_0x0028;
                case 2133799037: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0149
        L_0x001d:
            java.lang.String r0 = "com.android.voicemail.permission.ADD_VOICEMAIL"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r4
            goto L_0x014a
        L_0x0028:
            java.lang.String r0 = "android.permission.ACCESS_MEDIA_LOCATION"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 25
            goto L_0x014a
        L_0x0034:
            java.lang.String r0 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 6
            goto L_0x014a
        L_0x003f:
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r9
            goto L_0x014a
        L_0x004a:
            java.lang.String r0 = "android.permission.RECORD_AUDIO"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 9
            goto L_0x014a
        L_0x0056:
            java.lang.String r0 = "android.permission.ACTIVITY_RECOGNITION"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 26
            goto L_0x014a
        L_0x0062:
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 24
            goto L_0x014a
        L_0x006e:
            java.lang.String r0 = "android.permission.GET_ACCOUNTS"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 5
            goto L_0x014a
        L_0x0079:
            java.lang.String r0 = "android.permission.USE_SIP"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 15
            goto L_0x014a
        L_0x0085:
            java.lang.String r0 = "android.permission.WRITE_CALL_LOG"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 13
            goto L_0x014a
        L_0x0091:
            java.lang.String r0 = "android.permission.WRITE_CALENDAR"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r12
            goto L_0x014a
        L_0x009c:
            java.lang.String r0 = "android.permission.CAMERA"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r11
            goto L_0x014a
        L_0x00a7:
            java.lang.String r0 = "android.permission.WRITE_CONTACTS"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r10
            goto L_0x014a
        L_0x00b2:
            java.lang.String r0 = "android.permission.CALL_PHONE"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r6
            goto L_0x014a
        L_0x00bd:
            java.lang.String r0 = "android.permission.SEND_SMS"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r2
            goto L_0x014a
        L_0x00c8:
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 10
            goto L_0x014a
        L_0x00d4:
            java.lang.String r0 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r8
            goto L_0x014a
        L_0x00df:
            java.lang.String r0 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 23
            goto L_0x014a
        L_0x00eb:
            java.lang.String r0 = "android.permission.RECEIVE_SMS"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r1
            goto L_0x014a
        L_0x00f5:
            java.lang.String r0 = "android.permission.RECEIVE_MMS"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 22
            goto L_0x014a
        L_0x0100:
            java.lang.String r0 = "android.permission.BIND_CALL_REDIRECTION_SERVICE"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 16
            goto L_0x014a
        L_0x010b:
            java.lang.String r0 = "android.permission.BODY_SENSORS"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r3
            goto L_0x014a
        L_0x0115:
            java.lang.String r0 = "android.permission.RECEIVE_WAP_PUSH"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 21
            goto L_0x014a
        L_0x0120:
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r7
            goto L_0x014a
        L_0x012a:
            java.lang.String r0 = "android.permission.READ_CALL_LOG"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r5
            goto L_0x014a
        L_0x0134:
            java.lang.String r0 = "android.permission.READ_CALENDAR"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = r13
            goto L_0x014a
        L_0x013e:
            java.lang.String r0 = "android.permission.READ_SMS"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x001b
            r0 = 20
            goto L_0x014a
        L_0x0149:
            r0 = -1
        L_0x014a:
            switch(r0) {
                case 0: goto L_0x0159;
                case 1: goto L_0x0159;
                case 2: goto L_0x0158;
                case 3: goto L_0x0157;
                case 4: goto L_0x0157;
                case 5: goto L_0x0157;
                case 6: goto L_0x0156;
                case 7: goto L_0x0155;
                case 8: goto L_0x0155;
                case 9: goto L_0x0154;
                case 10: goto L_0x0153;
                case 11: goto L_0x0153;
                case 12: goto L_0x0153;
                case 13: goto L_0x0153;
                case 14: goto L_0x0153;
                case 15: goto L_0x0153;
                case 16: goto L_0x0153;
                case 17: goto L_0x0152;
                case 18: goto L_0x0151;
                case 19: goto L_0x0151;
                case 20: goto L_0x0151;
                case 21: goto L_0x0151;
                case 22: goto L_0x0151;
                case 23: goto L_0x0150;
                case 24: goto L_0x0150;
                case 25: goto L_0x014f;
                case 26: goto L_0x014e;
                default: goto L_0x014d;
            }
        L_0x014d:
            return r1
        L_0x014e:
            return r2
        L_0x014f:
            return r3
        L_0x0150:
            return r4
        L_0x0151:
            return r5
        L_0x0152:
            return r6
        L_0x0153:
            return r7
        L_0x0154:
            return r8
        L_0x0155:
            return r9
        L_0x0156:
            return r10
        L_0x0157:
            return r11
        L_0x0158:
            return r12
        L_0x0159:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baseflow.permissionhandler.PermissionUtils.parseManifestName(java.lang.String):int");
    }

    static List<String> getManifestNames(Context context, int permission) {
        ArrayList<String> permissionNames = new ArrayList<>();
        switch (permission) {
            case 0:
                if (hasPermissionInManifest(context, permissionNames, "android.permission.READ_CALENDAR")) {
                    permissionNames.add("android.permission.READ_CALENDAR");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.WRITE_CALENDAR")) {
                    permissionNames.add("android.permission.WRITE_CALENDAR");
                    break;
                }
                break;
            case 1:
                if (hasPermissionInManifest(context, permissionNames, "android.permission.CAMERA")) {
                    permissionNames.add("android.permission.CAMERA");
                    break;
                }
                break;
            case 2:
                if (hasPermissionInManifest(context, permissionNames, "android.permission.READ_CONTACTS")) {
                    permissionNames.add("android.permission.READ_CONTACTS");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.WRITE_CONTACTS")) {
                    permissionNames.add("android.permission.WRITE_CONTACTS");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.GET_ACCOUNTS")) {
                    permissionNames.add("android.permission.GET_ACCOUNTS");
                    break;
                }
                break;
            case 3:
            case 5:
                break;
            case 4:
                if (Build.VERSION.SDK_INT >= 29 && hasPermissionInManifest(context, permissionNames, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    permissionNames.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                    break;
                }
            case 6:
            case 9:
            case 10:
            case 16:
            case 19:
                return null;
            case 7:
            case 13:
                if (hasPermissionInManifest(context, permissionNames, "android.permission.RECORD_AUDIO")) {
                    permissionNames.add("android.permission.RECORD_AUDIO");
                    break;
                }
                break;
            case 8:
                if (hasPermissionInManifest(context, permissionNames, "android.permission.READ_PHONE_STATE")) {
                    permissionNames.add("android.permission.READ_PHONE_STATE");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.CALL_PHONE")) {
                    permissionNames.add("android.permission.CALL_PHONE");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.READ_CALL_LOG")) {
                    permissionNames.add("android.permission.READ_CALL_LOG");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.WRITE_CALL_LOG")) {
                    permissionNames.add("android.permission.WRITE_CALL_LOG");
                }
                if (hasPermissionInManifest(context, permissionNames, "com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    permissionNames.add("com.android.voicemail.permission.ADD_VOICEMAIL");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.USE_SIP")) {
                    permissionNames.add("android.permission.USE_SIP");
                }
                if (Build.VERSION.SDK_INT >= 29 && hasPermissionInManifest(context, permissionNames, "android.permission.BIND_CALL_REDIRECTION_SERVICE")) {
                    permissionNames.add("android.permission.BIND_CALL_REDIRECTION_SERVICE");
                }
                if (Build.VERSION.SDK_INT >= 26 && hasPermissionInManifest(context, permissionNames, "android.permission.ANSWER_PHONE_CALLS")) {
                    permissionNames.add("android.permission.ANSWER_PHONE_CALLS");
                    break;
                }
            case 11:
                if (Build.VERSION.SDK_INT >= 20 && hasPermissionInManifest(context, permissionNames, "android.permission.BODY_SENSORS")) {
                    permissionNames.add("android.permission.BODY_SENSORS");
                    break;
                }
            case 12:
                if (hasPermissionInManifest(context, permissionNames, "android.permission.SEND_SMS")) {
                    permissionNames.add("android.permission.SEND_SMS");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.RECEIVE_SMS")) {
                    permissionNames.add("android.permission.RECEIVE_SMS");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.READ_SMS")) {
                    permissionNames.add("android.permission.READ_SMS");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.RECEIVE_WAP_PUSH")) {
                    permissionNames.add("android.permission.RECEIVE_WAP_PUSH");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.RECEIVE_MMS")) {
                    permissionNames.add("android.permission.RECEIVE_MMS");
                    break;
                }
                break;
            case 14:
                if (hasPermissionInManifest(context, permissionNames, "android.permission.READ_EXTERNAL_STORAGE")) {
                    permissionNames.add("android.permission.READ_EXTERNAL_STORAGE");
                }
                if (hasPermissionInManifest(context, permissionNames, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    permissionNames.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    break;
                }
                break;
            case 15:
                if (Build.VERSION.SDK_INT >= 23 && hasPermissionInManifest(context, permissionNames, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) {
                    permissionNames.add("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    break;
                }
            case 17:
                if (Build.VERSION.SDK_INT >= 29 && hasPermissionInManifest(context, permissionNames, "android.permission.ACCESS_MEDIA_LOCATION")) {
                    permissionNames.add("android.permission.ACCESS_MEDIA_LOCATION");
                    break;
                }
            case 18:
                if (Build.VERSION.SDK_INT >= 29 && hasPermissionInManifest(context, permissionNames, "android.permission.ACTIVITY_RECOGNITION")) {
                    permissionNames.add("android.permission.ACTIVITY_RECOGNITION");
                    break;
                }
        }
        if (hasPermissionInManifest(context, permissionNames, "android.permission.ACCESS_COARSE_LOCATION")) {
            permissionNames.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        if (hasPermissionInManifest(context, permissionNames, "android.permission.ACCESS_FINE_LOCATION")) {
            permissionNames.add("android.permission.ACCESS_FINE_LOCATION");
        }
        return permissionNames;
    }

    private static boolean hasPermissionInManifest(Context context, ArrayList<String> confirmedPermissions, String permission) {
        if (confirmedPermissions != null) {
            try {
                Iterator<String> it = confirmedPermissions.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(permission)) {
                        return true;
                    }
                }
            } catch (Exception ex) {
                Log.d("permissions_handler", "Unable to check manifest for permission: ", ex);
            }
        }
        if (context == null) {
            Log.d("permissions_handler", "Unable to detect current Activity or App Context.");
            return false;
        }
        PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        if (info == null) {
            Log.d("permissions_handler", "Unable to get Package info, will not be able to determine permissions to request.");
            return false;
        }
        Iterator it2 = new ArrayList(Arrays.asList(info.requestedPermissions)).iterator();
        while (it2.hasNext()) {
            if (((String) it2.next()).equals(permission)) {
                return true;
            }
        }
        return false;
    }

    static int toPermissionStatus(Activity activity, String permissionName, int grantResult) {
        if (grantResult == -1) {
            return (Build.VERSION.SDK_INT < 23 || !isNeverAskAgainSelected(activity, permissionName)) ? 0 : 4;
        }
        return 1;
    }

    static void updatePermissionShouldShowStatus(Activity activity, int permission) {
        List<String> names;
        if (activity != null && (names = getManifestNames(activity, permission)) != null && !names.isEmpty()) {
            for (String name : names) {
                setRequestedPermission(activity, name);
            }
        }
    }

    @RequiresApi(api = 23)
    static boolean isNeverAskAgainSelected(Activity activity, String name) {
        if (activity == null) {
            return false;
        }
        return neverAskAgainSelected(activity, name);
    }

    @RequiresApi(api = 23)
    static boolean neverAskAgainSelected(Activity activity, String permission) {
        return getRequestedPermissionBefore(activity, permission) && !ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
    }

    static void setRequestedPermission(Context context, String permission) {
        SharedPreferences.Editor editor = context.getSharedPreferences("GENERIC_PREFERENCES", 0).edit();
        editor.putBoolean(permission, true);
        editor.apply();
    }

    static boolean getRequestedPermissionBefore(Context context, String permission) {
        return context.getSharedPreferences("GENERIC_PREFERENCES", 0).getBoolean(permission, false);
    }
}
