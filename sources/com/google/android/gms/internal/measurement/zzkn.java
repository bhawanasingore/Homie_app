package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzkn implements zzkk {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Long> zzb;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcw zzcw = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcw.zza("measurement.sdk.referrer.delayed_install_referrer_api", false);
        zzb = zzcw.zza("measurement.id.sdk.referrer.delayed_install_referrer_api", 0);
    }
}
