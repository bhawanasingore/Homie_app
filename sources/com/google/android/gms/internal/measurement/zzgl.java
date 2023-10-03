package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public final class zzgl<K, V> {
    static <K, V> void zza(zzes zzes, zzgk<K, V> zzgk, K k, V v) throws IOException {
        zzfb.zza(zzes, zzgk.zza, 1, k);
        zzfb.zza(zzes, zzgk.zzc, 2, v);
    }

    static <K, V> int zza(zzgk<K, V> zzgk, K k, V v) {
        return zzfb.zza(zzgk.zza, 1, k) + zzfb.zza(zzgk.zzc, 2, v);
    }
}
