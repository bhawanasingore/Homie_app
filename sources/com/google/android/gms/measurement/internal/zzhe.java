package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final /* synthetic */ class zzhe implements Runnable {
    private final zzhc zza;

    zzhe(zzhc zzhc) {
        this.zza = zzhc;
    }

    public final void run() {
        zzhc zzhc = this.zza;
        zzhc.zzd();
        if (zzhc.zzs().zzt.zza()) {
            zzhc.zzr().zzw().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzhc.zzs().zzu.zza();
        zzhc.zzs().zzu.zza(1 + zza2);
        if (zza2 >= 5) {
            zzhc.zzr().zzi().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzhc.zzs().zzt.zza(true);
            return;
        }
        zzhc.zzz.zzah();
    }
}
