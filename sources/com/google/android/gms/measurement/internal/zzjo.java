package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final /* synthetic */ class zzjo implements Runnable {
    private final zzjl zza;
    private final int zzb;
    private final zzet zzc;
    private final Intent zzd;

    zzjo(zzjl zzjl, int i, zzet zzet, Intent intent) {
        this.zza = zzjl;
        this.zzb = i;
        this.zzc = zzet;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
