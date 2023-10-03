package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.baseflow.permissionhandler.PermissionManager;
import io.flutter.plugin.common.MethodChannel;

@SynthesizedClassMap({$$Lambda$MethodCallHandlerImpl$EqJFI2oYuoDin3ZEKekEyA_Kdc.class, $$Lambda$MethodCallHandlerImpl$M_fJsohuhGTxNaajHVl4rDteOE4.class, $$Lambda$MethodCallHandlerImpl$jGtwiG3jQ2lAp2Gyt9WGWiMz80.class, $$Lambda$MethodCallHandlerImpl$nBDkVfzRvSfmmA4LbPddaEjgddw.class, $$Lambda$MethodCallHandlerImpl$srvZpHfJnKwaDTQpc3KbxXJu_k.class, $$Lambda$TR2UE6xvkpeRG17hPoBKZeEIKug.class, $$Lambda$WNQCVwakkfCyfzR026kfI0xwI.class, $$Lambda$dmmm8DBenCjBo3Fgt2Az2dG7ZxI.class, $$Lambda$kvb3eDz1QeqVBPF6VqNqPbsSWUA.class, $$Lambda$tkd1HTc7lzMARNRmpQPzCnzrNM.class})
final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    @Nullable
    private Activity activity;
    @Nullable
    private PermissionManager.ActivityRegistry activityRegistry;
    private final AppSettingsManager appSettingsManager;
    private final Context applicationContext;
    private final PermissionManager permissionManager;
    @Nullable
    private PermissionManager.PermissionRegistry permissionRegistry;
    private final ServiceManager serviceManager;

    MethodCallHandlerImpl(Context applicationContext2, AppSettingsManager appSettingsManager2, PermissionManager permissionManager2, ServiceManager serviceManager2) {
        this.applicationContext = applicationContext2;
        this.appSettingsManager = appSettingsManager2;
        this.permissionManager = permissionManager2;
        this.serviceManager = serviceManager2;
    }

    public void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    public void setActivityRegistry(@Nullable PermissionManager.ActivityRegistry activityRegistry2) {
        this.activityRegistry = activityRegistry2;
    }

    public void setPermissionRegistry(@Nullable PermissionManager.PermissionRegistry permissionRegistry2) {
        this.permissionRegistry = permissionRegistry2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r9, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.method
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1544053025: goto L_0x0036;
                case -1017315255: goto L_0x002c;
                case -576207927: goto L_0x0022;
                case 347240634: goto L_0x0018;
                case 1669188213: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0040
        L_0x000e:
            java.lang.String r1 = "requestPermissions"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r4
            goto L_0x0041
        L_0x0018:
            java.lang.String r1 = "openAppSettings"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r2
            goto L_0x0041
        L_0x0022:
            java.lang.String r1 = "checkPermissionStatus"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r5
            goto L_0x0041
        L_0x002c:
            java.lang.String r1 = "shouldShowRequestPermissionRationale"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r3
            goto L_0x0041
        L_0x0036:
            java.lang.String r1 = "checkServiceStatus"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 0
            goto L_0x0041
        L_0x0040:
            r0 = -1
        L_0x0041:
            if (r0 == 0) goto L_0x00c7
            if (r0 == r5) goto L_0x00a5
            if (r0 == r4) goto L_0x0085
            if (r0 == r3) goto L_0x0066
            if (r0 == r2) goto L_0x0050
            r10.notImplemented()
            goto L_0x00e6
        L_0x0050:
            com.baseflow.permissionhandler.AppSettingsManager r0 = r8.appSettingsManager
            android.content.Context r1 = r8.applicationContext
            r10.getClass()
            com.baseflow.permissionhandler.-$$Lambda$TR2UE6xvkpeRG17hPoBKZeEIKug r2 = new com.baseflow.permissionhandler.-$$Lambda$TR2UE6xvkpeRG17hPoBKZeEIKug
            r2.<init>()
            com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$Eq-JFI2oYuoDin3ZEKekEyA_Kdc r3 = new com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$Eq-JFI2oYuoDin3ZEKekEyA_Kdc
            r3.<init>()
            r0.openAppSettings(r1, r2, r3)
            goto L_0x00e6
        L_0x0066:
            java.lang.Object r0 = r9.arguments
            java.lang.String r0 = r0.toString()
            int r0 = java.lang.Integer.parseInt(r0)
            com.baseflow.permissionhandler.PermissionManager r1 = r8.permissionManager
            android.app.Activity r2 = r8.activity
            r10.getClass()
            com.baseflow.permissionhandler.-$$Lambda$WNQCVwak-kfCyfzR026kfI0-xwI r3 = new com.baseflow.permissionhandler.-$$Lambda$WNQCVwak-kfCyfzR026kfI0-xwI
            r3.<init>()
            com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$srvZpHfJnKwaDTQpc3Kbx-XJu_k r4 = new com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$srvZpHfJnKwaDTQpc3Kbx-XJu_k
            r4.<init>()
            r1.shouldShowRequestPermissionRationale(r0, r2, r3, r4)
            goto L_0x00e6
        L_0x0085:
            java.lang.Object r0 = r9.arguments()
            java.util.List r0 = (java.util.List) r0
            com.baseflow.permissionhandler.PermissionManager r1 = r8.permissionManager
            android.app.Activity r3 = r8.activity
            com.baseflow.permissionhandler.PermissionManager$ActivityRegistry r4 = r8.activityRegistry
            com.baseflow.permissionhandler.PermissionManager$PermissionRegistry r5 = r8.permissionRegistry
            r10.getClass()
            com.baseflow.permissionhandler.-$$Lambda$tkd1HTc7lzMA-RNRmpQPzCnzrNM r6 = new com.baseflow.permissionhandler.-$$Lambda$tkd1HTc7lzMA-RNRmpQPzCnzrNM
            r6.<init>()
            com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$M_fJsohuhGTxNaajHVl4rDteOE4 r7 = new com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$M_fJsohuhGTxNaajHVl4rDteOE4
            r7.<init>()
            r2 = r0
            r1.requestPermissions(r2, r3, r4, r5, r6, r7)
            goto L_0x00e6
        L_0x00a5:
            java.lang.Object r0 = r9.arguments
            java.lang.String r0 = r0.toString()
            int r0 = java.lang.Integer.parseInt(r0)
            com.baseflow.permissionhandler.PermissionManager r1 = r8.permissionManager
            android.content.Context r3 = r8.applicationContext
            android.app.Activity r4 = r8.activity
            r10.getClass()
            com.baseflow.permissionhandler.-$$Lambda$dmmm8DBenCjBo3Fgt2Az2dG7ZxI r5 = new com.baseflow.permissionhandler.-$$Lambda$dmmm8DBenCjBo3Fgt2Az2dG7ZxI
            r5.<init>()
            com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$nBDkVfzRvSfmmA4LbPddaEjgddw r6 = new com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$nBDkVfzRvSfmmA4LbPddaEjgddw
            r6.<init>()
            r2 = r0
            r1.checkPermissionStatus(r2, r3, r4, r5, r6)
            goto L_0x00e6
        L_0x00c7:
            java.lang.Object r0 = r9.arguments
            java.lang.String r0 = r0.toString()
            int r0 = java.lang.Integer.parseInt(r0)
            com.baseflow.permissionhandler.ServiceManager r1 = r8.serviceManager
            android.content.Context r2 = r8.applicationContext
            r10.getClass()
            com.baseflow.permissionhandler.-$$Lambda$kvb3eDz1QeqVBPF6VqNqPbsSWUA r3 = new com.baseflow.permissionhandler.-$$Lambda$kvb3eDz1QeqVBPF6VqNqPbsSWUA
            r3.<init>()
            com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$jGtwiG-3jQ2lAp2Gyt9WGWiMz80 r4 = new com.baseflow.permissionhandler.-$$Lambda$MethodCallHandlerImpl$jGtwiG-3jQ2lAp2Gyt9WGWiMz80
            r4.<init>()
            r1.checkServiceStatus(r0, r2, r3, r4)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baseflow.permissionhandler.MethodCallHandlerImpl.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
