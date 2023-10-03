package com.sangcomz.fishbun.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.sangcomz.fishbun.R;
import com.sangcomz.fishbun.define.Define;

public class PermissionCheck {
    private Context context;

    public PermissionCheck(Context context2) {
        this.context = context2;
    }

    public boolean CheckStoragePermission() {
        Define define = new Define();
        int permissionCheckRead = ContextCompat.checkSelfPermission(this.context, "android.permission.READ_EXTERNAL_STORAGE");
        int permissionCheckWrite = ContextCompat.checkSelfPermission(this.context, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (permissionCheckRead == 0 && permissionCheckWrite == 0) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) this.context, "android.permission.READ_EXTERNAL_STORAGE")) {
            define.getClass();
            ActivityCompat.requestPermissions((Activity) this.context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 28);
            return false;
        }
        define.getClass();
        ActivityCompat.requestPermissions((Activity) this.context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 28);
        return false;
    }

    public boolean CheckCameraPermission() {
        try {
            String[] permissions = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4096).requestedPermissions;
            if (permissions != null && permissions.length > 0) {
                for (String permission : permissions) {
                    if (permission.equals("android.permission.CAMERA")) {
                        Define define = new Define();
                        if (ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") == 0) {
                            return true;
                        }
                        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) this.context, "android.permission.CAMERA")) {
                            define.getClass();
                            ActivityCompat.requestPermissions((Activity) this.context, new String[]{"android.permission.CAMERA"}, 29);
                        } else {
                            define.getClass();
                            ActivityCompat.requestPermissions((Activity) this.context, new String[]{"android.permission.CAMERA"}, 29);
                        }
                        return false;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void showPermissionDialog() {
        Toast.makeText(this.context, R.string.msg_permission, 0).show();
    }
}
