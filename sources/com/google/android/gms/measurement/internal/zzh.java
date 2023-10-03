package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
final class zzh implements Runnable {
    private final /* synthetic */ zzs zza;
    private final /* synthetic */ zzaq zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzs, zzaq zzaq, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzs;
        this.zzb = zzaq;
        this.zzc = str;
    }

    public final void run() {
        this.zzd.zza.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}
