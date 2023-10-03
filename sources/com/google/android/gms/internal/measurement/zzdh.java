package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzdh {
    public static <T> zzde<T> zza(zzde<T> zzde) {
        if ((zzde instanceof zzdj) || (zzde instanceof zzdg)) {
            return zzde;
        }
        if (zzde instanceof Serializable) {
            return new zzdg(zzde);
        }
        return new zzdj(zzde);
    }

    public static <T> zzde<T> zza(@NullableDecl T t) {
        return new zzdi(t);
    }
}
