package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgm implements Callable<byte[]> {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgc zzc;

    zzgm(zzgc zzgc, zzaq zzaq, String str) {
        this.zzc = zzgc;
        this.zza = zzaq;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzc.zza.zzo();
        return this.zzc.zza.zzg().zza(this.zza, this.zzb);
    }
}
