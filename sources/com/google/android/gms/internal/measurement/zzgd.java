package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
abstract class zzgd {
    private static final zzgd zza = new zzgf();
    private static final zzgd zzb = new zzge();

    private zzgd() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzgd zza() {
        return zza;
    }

    static zzgd zzb() {
        return zzb;
    }
}
