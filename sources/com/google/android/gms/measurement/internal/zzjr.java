package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjr implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjs zzb;

    zzjr(zzjs zzjs, long j) {
        this.zzb = zzjs;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zza(this.zza);
    }
}
