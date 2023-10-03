package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzjq implements Runnable {
    private final /* synthetic */ zzkg zza;
    private final /* synthetic */ Runnable zzb;

    zzjq(zzjl zzjl, zzkg zzkg, Runnable runnable) {
        this.zza = zzkg;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzo();
        this.zza.zza(this.zzb);
        this.zza.zzl();
    }
}
