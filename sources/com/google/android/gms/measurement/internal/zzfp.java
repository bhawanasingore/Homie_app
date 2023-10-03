package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzaa;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzfp {
    private final zzfs zza;

    public zzfp(zzfs zzfs) {
        Preconditions.checkNotNull(zzfs);
        this.zza = zzfs;
    }

    public static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public final void zza(Context context, Intent intent) {
        zzfx zza2 = zzfx.zza(context, (zzaa) null, (Long) null);
        zzet zzr = zza2.zzr();
        if (intent == null) {
            zzr.zzi().zza("Receiver called with null intent");
            return;
        }
        zza2.zzu();
        String action = intent.getAction();
        zzr.zzx().zza("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzr.zzx().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzr.zzi().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
