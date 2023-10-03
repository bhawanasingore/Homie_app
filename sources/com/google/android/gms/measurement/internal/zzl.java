package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
final class zzl implements Runnable {
    private final /* synthetic */ zzs zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzs) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzs;
    }

    public final void run() {
        this.zzb.zza.zzi().zza(this.zza, this.zzb.zza.zzaa());
    }
}
