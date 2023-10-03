package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgp implements Runnable {
    private final /* synthetic */ zzy zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgc zzc;

    zzgp(zzgc zzgc, zzy zzy, zzm zzm) {
        this.zzc = zzgc;
        this.zza = zzy;
        this.zzb = zzm;
    }

    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
