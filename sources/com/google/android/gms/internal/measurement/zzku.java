package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzku implements zzkv {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zzcw.zza("measurement.client.sessions.check_on_startup", true);
        zzc = zzcw.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }
}
