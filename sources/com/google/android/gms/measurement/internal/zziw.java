package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zziw implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzin zzb;

    zziw(zzin zzin, zzm zzm) {
        this.zzb = zzin;
        this.zza = zzm;
    }

    public final void run() {
        zzel zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzd.zza(this.zza);
            this.zzb.zzj().zzad();
            this.zzb.zza(zzd, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send app launch to the service", e);
        }
    }
}
