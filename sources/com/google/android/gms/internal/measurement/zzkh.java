package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzkh implements zzke {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Boolean> zzd;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zze() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzcw.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzcw.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzcw.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
