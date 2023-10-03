package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzki implements zzfc {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzkg zzb;

    zzki(zzkg zzkg, String str) {
        this.zzb = zzkg;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
