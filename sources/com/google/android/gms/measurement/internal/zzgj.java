package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzgj implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgc zzc;

    zzgj(zzgc zzgc, zzaq zzaq, String str) {
        this.zzc = zzgc;
        this.zza = zzaq;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzo();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
