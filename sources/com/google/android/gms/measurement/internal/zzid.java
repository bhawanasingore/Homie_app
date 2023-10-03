package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final /* synthetic */ class zzid implements Runnable {
    private final zzie zza;
    private final int zzb;
    private final Exception zzc;
    private final byte[] zzd;
    private final Map zze;

    zzid(zzie zzie, int i, Exception exc, byte[] bArr, Map map) {
        this.zza = zzie;
        this.zzb = i;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
