package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgq implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzgc zze;

    zzgq(zzgc zzgc, String str, String str2, String str3, long j) {
        this.zze = zzgc;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzs().zzv().zza(this.zzb, (zzii) null);
            return;
        }
        this.zze.zza.zzs().zzv().zza(this.zzb, new zzii(this.zzc, str, this.zzd));
    }
}
