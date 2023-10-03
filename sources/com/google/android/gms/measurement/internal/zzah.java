package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzah implements Runnable {
    private final /* synthetic */ zzgu zza;
    private final /* synthetic */ zzai zzb;

    zzah(zzai zzai, zzgu zzgu) {
        this.zzb = zzai;
        this.zza = zzgu;
    }

    public final void run() {
        this.zza.zzu();
        if (zzv.zza()) {
            this.zza.zzq().zza((Runnable) this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        long unused = this.zzb.zzd = 0;
        if (zzb2) {
            this.zzb.zza();
        }
    }
}
