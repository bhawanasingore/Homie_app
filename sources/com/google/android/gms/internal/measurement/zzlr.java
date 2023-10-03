package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzlr implements zzlo {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Boolean> zzd;
    private static final zzcq<Long> zze;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzcw.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzcw.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzcw.zza("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zze = zzcw.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }
}
