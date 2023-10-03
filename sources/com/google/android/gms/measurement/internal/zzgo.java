package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgo implements Callable<List<zzkp>> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgc zzb;

    zzgo(zzgc zzgc, zzm zzm) {
        this.zzb = zzgc;
        this.zza = zzm;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzo();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}
