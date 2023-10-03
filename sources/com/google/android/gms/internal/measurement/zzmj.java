package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzmj implements zzmg {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Double> zzb;
    private static final zzcq<Long> zzc;
    private static final zzcq<Long> zzd;
    private static final zzcq<String> zze;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    public final long zzc() {
        return zzc.zzc().longValue();
    }

    public final long zzd() {
        return zzd.zzc().longValue();
    }

    public final String zze() {
        return zze.zzc();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.test.boolean_flag", false);
        zzb = zzcw.zza("measurement.test.double_flag", -3.0d);
        zzc = zzcw.zza("measurement.test.int_flag", -2);
        zzd = zzcw.zza("measurement.test.long_flag", -1);
        zze = zzcw.zza("measurement.test.string_flag", "---");
    }
}
