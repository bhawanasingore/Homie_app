package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgd implements Callable<List<zzkp>> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzgc zzd;

    zzgd(zzgc zzgc, zzm zzm, String str, String str2) {
        this.zzd = zzgc;
        this.zza = zzm;
        this.zzb = str;
        this.zzc = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzd.zza.zzo();
        return this.zzd.zza.zze().zza(this.zza.zza, this.zzb, this.zzc);
    }
}
