package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public abstract class zzdd<T> implements Serializable {
    public static <T> zzdd<T> zzc() {
        return zzdb.zza;
    }

    public abstract boolean zza();

    public abstract T zzb();

    public static <T> zzdd<T> zza(T t) {
        return new zzdf(zzdc.zza(t));
    }

    zzdd() {
    }
}
