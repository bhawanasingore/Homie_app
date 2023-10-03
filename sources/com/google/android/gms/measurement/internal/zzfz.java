package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzfz implements Runnable {
    private final /* synthetic */ zzgz zza;
    private final /* synthetic */ zzfx zzb;

    zzfz(zzfx zzfx, zzgz zzgz) {
        this.zzb = zzfx;
        this.zza = zzgz;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
