package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzja implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzin zzb;

    zzja(zzin zzin, zzm zzm) {
        this.zzb = zzin;
        this.zza = zzm;
    }

    public final void run() {
        zzel zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzd.zzb(this.zza);
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
