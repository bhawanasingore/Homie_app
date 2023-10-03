package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzgg implements zzhl {
    private static final zzgq zzb = new zzgj();
    private final zzgq zza;

    public zzgg() {
        this(new zzgi(zzfj.zza(), zza()));
    }

    private zzgg(zzgq zzgq) {
        this.zza = (zzgq) zzfk.zza(zzgq, "messageInfoFactory");
    }

    public final <T> zzhi<T> zza(Class<T> cls) {
        zzhk.zza((Class<?>) cls);
        zzgr zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzfi.class.isAssignableFrom(cls)) {
                return zzgz.zza(zzhk.zzc(), zzey.zza(), zzb2.zzc());
            }
            return zzgz.zza(zzhk.zza(), zzey.zzb(), zzb2.zzc());
        } else if (zzfi.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzgx.zza(cls, zzb2, zzhd.zzb(), zzgd.zzb(), zzhk.zzc(), zzey.zza(), zzgo.zzb());
            }
            return zzgx.zza(cls, zzb2, zzhd.zzb(), zzgd.zzb(), zzhk.zzc(), (zzex<?>) null, zzgo.zzb());
        } else if (zza(zzb2)) {
            return zzgx.zza(cls, zzb2, zzhd.zza(), zzgd.zza(), zzhk.zza(), zzey.zzb(), zzgo.zza());
        } else {
            return zzgx.zza(cls, zzb2, zzhd.zza(), zzgd.zza(), zzhk.zzb(), (zzex<?>) null, zzgo.zza());
        }
    }

    private static boolean zza(zzgr zzgr) {
        return zzgr.zza() == zzfi.zze.zzh;
    }

    private static zzgq zza() {
        try {
            return (zzgq) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e) {
            return zzb;
        }
    }
}
