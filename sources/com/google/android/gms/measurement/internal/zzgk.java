package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgk implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgc zzc;

    zzgk(zzgc zzgc, zzaq zzaq, zzm zzm) {
        this.zzc = zzgc;
        this.zza = zzaq;
        this.zzb = zzm;
    }

    public final void run() {
        zzaq zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzo();
        this.zzc.zza.zza(zzb2, this.zzb);
    }
}
