package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final /* synthetic */ class zzjv implements Runnable {
    private final zzjw zza;

    zzjv(zzjw zzjw) {
        this.zza = zzjw;
    }

    public final void run() {
        zzjw zzjw = this.zza;
        zzjt zzjt = zzjw.zzc;
        long j = zzjw.zza;
        long j2 = zzjw.zzb;
        zzjt.zza.zzd();
        zzjt.zza.zzr().zzw().zza("Application going to the background");
        if (zzjt.zza.zzt().zza(zzas.zzcd)) {
            zzjt.zza.zzs().zzs.zza(true);
        }
        if (!zzjt.zza.zzt().zzj().booleanValue()) {
            zzjt.zza.zzb.zzb(j2);
            zzjt.zza.zza(false, false, j2);
        }
        zzjt.zza.zzf().zza("auto", "_ab", j, new Bundle());
    }
}
