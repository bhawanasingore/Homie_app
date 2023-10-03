package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjh implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzjf zzb;

    zzjh(zzjf zzjf, ComponentName componentName) {
        this.zzb = zzjf;
        this.zza = componentName;
    }

    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
