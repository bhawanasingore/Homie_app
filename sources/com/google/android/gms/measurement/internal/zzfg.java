package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzfg implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfd zzb;

    zzfg(zzfd zzfd, boolean z) {
        this.zzb = zzfd;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
