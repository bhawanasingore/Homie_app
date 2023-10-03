package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjg implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ zzs zze;
    private final /* synthetic */ zzin zzf;

    zzjg(zzin zzin, String str, String str2, boolean z, zzm zzm, zzs zzs) {
        this.zzf = zzin;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzm;
        this.zze = zzs;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzel zzd2 = this.zzf.zzb;
            if (zzd2 == null) {
                this.zzf.zzr().zzf().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            bundle = zzko.zza(zzd2.zza(this.zza, this.zzb, this.zzc, this.zzd));
            this.zzf.zzak();
            this.zzf.zzp().zza(this.zze, bundle);
        } catch (RemoteException e) {
            this.zzf.zzr().zzf().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzp().zza(this.zze, bundle);
        }
    }
}
