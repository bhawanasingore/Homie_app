package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjw implements Runnable {
    long zza;
    long zzb;
    final /* synthetic */ zzjt zzc;

    zzjw(zzjt zzjt, long j, long j2) {
        this.zzc = zzjt;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzq().zza((Runnable) new zzjv(this));
    }
}
