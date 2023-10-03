package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzla implements zzlb {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Long> zzc;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzcw.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzcw.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }
}
