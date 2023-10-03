package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzik implements Runnable {
    private final /* synthetic */ zzii zza;
    private final /* synthetic */ zzii zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzih zze;

    zzik(zzih zzih, zzii zzii, zzii zzii2, long j, boolean z) {
        this.zze = zzih;
        this.zza = zzii;
        this.zzb = zzii2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
