package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzir implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzin zzb;

    zzir(zzin zzin, zzm zzm) {
        this.zzb = zzin;
        this.zza = zzm;
    }

    public final void run() {
        zzel zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzd.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzak();
    }
}
