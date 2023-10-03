package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgl implements Runnable {
    private final /* synthetic */ zzkn zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgc zzc;

    zzgl(zzgc zzgc, zzkn zzkn, zzm zzm) {
        this.zzc = zzgc;
        this.zza = zzkn;
        this.zzb = zzm;
    }

    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
