package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzge implements Runnable {
    private final /* synthetic */ zzy zza;
    private final /* synthetic */ zzgc zzb;

    zzge(zzgc zzgc, zzy zzy) {
        this.zzb = zzgc;
        this.zza = zzy;
    }

    public final void run() {
        this.zzb.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}
