package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzhm implements Runnable {
    private final /* synthetic */ zzgx zza;
    private final /* synthetic */ zzhc zzb;

    zzhm(zzhc zzhc, zzgx zzgx) {
        this.zzb = zzhc;
        this.zza = zzgx;
    }

    public final void run() {
        this.zzb.zza(this.zza);
    }
}
