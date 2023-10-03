package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzji implements Runnable {
    private final /* synthetic */ zzel zza;
    private final /* synthetic */ zzjf zzb;

    zzji(zzjf zzjf, zzel zzel) {
        this.zzb = zzjf;
        this.zza = zzel;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzx().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
