package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
final class zzj implements Runnable {
    private final /* synthetic */ zzs zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzs, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzs;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        this.zzd.zza.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}
