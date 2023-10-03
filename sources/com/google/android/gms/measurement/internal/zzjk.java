package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjk implements Runnable {
    private final /* synthetic */ zzel zza;
    private final /* synthetic */ zzjf zzb;

    zzjk(zzjf zzjf, zzel zzel) {
        this.zzb = zzjf;
        this.zza = zzel;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzw().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
