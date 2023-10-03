package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzho extends zzhu {
    private final /* synthetic */ zzhn zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzho(zzhn zzhn) {
        super(zzhn, (zzhm) null);
        this.zza = zzhn;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzhp(this.zza, (zzhm) null);
    }

    /* synthetic */ zzho(zzhn zzhn, zzhm zzhm) {
        this(zzhn);
    }
}
