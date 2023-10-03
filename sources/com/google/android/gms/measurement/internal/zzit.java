package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzit implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzs zzb;
    private final /* synthetic */ zzin zzc;

    zzit(zzin zzin, zzm zzm, zzs zzs) {
        this.zzc = zzin;
        this.zza = zzm;
        this.zzb = zzs;
    }

    public final void run() {
        try {
            zzel zzd = this.zzc.zzb;
            if (zzd == null) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id");
                return;
            }
            String zzc2 = zzd.zzc(this.zza);
            if (zzc2 != null) {
                this.zzc.zzf().zza(zzc2);
                this.zzc.zzs().zzj.zza(zzc2);
            }
            this.zzc.zzak();
            this.zzc.zzp().zza(this.zzb, zzc2);
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzp().zza(this.zzb, (String) null);
        }
    }
}
