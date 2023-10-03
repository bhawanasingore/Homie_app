package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzls implements zzlt {
    private static final zzcq<Long> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Boolean> zzd;
    private static final zzcq<Long> zze;

    public final boolean zza() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.id.lifecycle.app_in_background_parameter", 0);
        zzb = zzcw.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzcw.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzcw.zza("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzcw.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }
}
