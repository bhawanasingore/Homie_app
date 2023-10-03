package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzhe {
    private static final zzhe zza = new zzhe();
    private final zzhl zzb = new zzgg();
    private final ConcurrentMap<Class<?>, zzhi<?>> zzc = new ConcurrentHashMap();

    public static zzhe zza() {
        return zza;
    }

    public final <T> zzhi<T> zza(Class<T> cls) {
        zzfk.zza(cls, "messageType");
        zzhi<T> zzhi = (zzhi) this.zzc.get(cls);
        if (zzhi != null) {
            return zzhi;
        }
        zzhi<T> zza2 = this.zzb.zza(cls);
        zzfk.zza(cls, "messageType");
        zzfk.zza(zza2, "schema");
        zzhi<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return zza2;
    }

    public final <T> zzhi<T> zza(T t) {
        return zza(t.getClass());
    }

    private zzhe() {
    }
}
