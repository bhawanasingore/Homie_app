package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzkj implements Callable<String> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzkg zzb;

    zzkj(zzkg zzkg, zzm zzm) {
        this.zzb = zzkg;
        this.zza = zzm;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzg zzc = this.zzb.zzc(this.zza);
        if (zzc != null) {
            return zzc.zzd();
        }
        this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
        return null;
    }
}
