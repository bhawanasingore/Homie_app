package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzil implements Runnable {
    private final /* synthetic */ zzii zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzih zzc;

    zzil(zzih zzih, zzii zzii, long j) {
        this.zzc = zzih;
        this.zza = zzii;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        this.zzc.zza = null;
        this.zzc.zzh().zza((zzii) null);
    }
}
