package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzly implements zzlz {
    private static final zzcq<Long> zza;
    private static final zzcq<Long> zzb;

    public final long zza() {
        return zzb.zzc().longValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.id.max_bundles_per_iteration", 0);
        zzb = zzcw.zza("measurement.max_bundles_per_iteration", 2);
    }
}
