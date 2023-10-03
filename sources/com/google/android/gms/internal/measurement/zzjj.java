package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzjj implements zzjg {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Long> zzb;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final long zzb() {
        return zzb.zzc().longValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.sdk.attribution.cache", true);
        zzb = zzcw.zza("measurement.sdk.attribution.cache.ttl", 604800000);
    }
}
