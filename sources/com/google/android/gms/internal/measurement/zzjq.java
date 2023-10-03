package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzjq implements zzjr {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Long> zzd;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.sdk.dynamite.allow_remote_dynamite", false);
        zzb = zzcw.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzcw.zza("measurement.sdk.dynamite.use_dynamite3", true);
        zzd = zzcw.zza("measurement.id.sdk.dynamite.use_dynamite", 0);
    }
}
