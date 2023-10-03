package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzjv implements zzjs {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Long> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Boolean> zzd;
    private static final zzcq<Boolean> zze;
    private static final zzcq<Boolean> zzf;
    private static final zzcq<Boolean> zzg;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    public final boolean zze() {
        return zze.zzc().booleanValue();
    }

    public final boolean zzf() {
        return zzf.zzc().booleanValue();
    }

    public final boolean zzg() {
        return zzg.zzc().booleanValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.gold.enhanced_ecommerce.format_logs", false);
        zzb = zzcw.zza("measurement.id.gold.enhanced_ecommerce.service", 0);
        zzc = zzcw.zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", true);
        zzd = zzcw.zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false);
        zze = zzcw.zza("measurement.gold.enhanced_ecommerce.updated_schema.client", true);
        zzf = zzcw.zza("measurement.gold.enhanced_ecommerce.updated_schema.service", false);
        zzg = zzcw.zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false);
    }
}
