package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzjd implements zzja {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.androidId.delete_feature", true);
        zzb = zzcw.zza("measurement.log_androidId_enabled", false);
    }
}
