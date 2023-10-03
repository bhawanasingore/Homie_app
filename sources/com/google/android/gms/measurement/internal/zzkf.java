package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzkf implements Runnable {
    private final /* synthetic */ zzkl zza;
    private final /* synthetic */ zzkg zzb;

    zzkf(zzkg zzkg, zzkl zzkl) {
        this.zzb = zzkg;
        this.zza = zzkl;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
