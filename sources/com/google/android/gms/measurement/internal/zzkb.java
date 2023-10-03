package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzkb extends zzai {
    private final /* synthetic */ zzkg zza;
    private final /* synthetic */ zzkc zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzkb(zzkc zzkc, zzgu zzgu, zzkg zzkg) {
        super(zzgu);
        this.zzb = zzkc;
        this.zza = zzkg;
    }

    public final void zza() {
        this.zzb.zzf();
        this.zzb.zzr().zzx().zza("Starting upload from DelayedRunnable");
        this.zza.zzl();
    }
}
