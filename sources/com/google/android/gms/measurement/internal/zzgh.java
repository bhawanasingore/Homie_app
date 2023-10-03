package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgh implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgc zzb;

    zzgh(zzgc zzgc, zzm zzm) {
        this.zzb = zzgc;
        this.zza = zzm;
    }

    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zza(this.zza);
    }
}
