package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgb implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgc zzb;

    zzgb(zzgc zzgc, zzm zzm) {
        this.zzb = zzgc;
        this.zza = zzm;
    }

    public final void run() {
        this.zzb.zza.zzo();
        zzkg zza2 = this.zzb.zza;
        zzm zzm = this.zza;
        zza2.zzq().zzd();
        zza2.zzk();
        Preconditions.checkNotEmpty(zzm.zza);
        zza2.zzc(zzm);
    }
}
