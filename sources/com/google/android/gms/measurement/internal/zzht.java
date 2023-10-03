package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzht implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhc zzb;

    zzht(zzhc zzhc, boolean z) {
        this.zzb = zzhc;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
