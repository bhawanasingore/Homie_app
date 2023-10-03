package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjj implements Runnable {
    private final /* synthetic */ zzjf zza;

    zzjj(zzjf zzjf) {
        this.zza = zzjf;
    }

    public final void run() {
        zzin zzin = this.zza.zza;
        Context zzn = this.zza.zza.zzn();
        this.zza.zza.zzu();
        zzin.zza(new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
