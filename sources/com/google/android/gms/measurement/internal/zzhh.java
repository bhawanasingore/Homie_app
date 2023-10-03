package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzhh implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzhc zzc;

    zzhh(zzhc zzhc, AtomicReference atomicReference, boolean z) {
        this.zzc = zzhc;
        this.zza = atomicReference;
        this.zzb = z;
    }

    public final void run() {
        this.zzc.zzh().zza((AtomicReference<List<zzkn>>) this.zza, this.zzb);
    }
}
