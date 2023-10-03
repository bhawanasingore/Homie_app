package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzgp implements zzgm {
    zzgp() {
    }

    public final Map<?, ?> zza(Object obj) {
        return (zzgn) obj;
    }

    public final zzgk<?, ?> zzf(Object obj) {
        zzgl zzgl = (zzgl) obj;
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzb(Object obj) {
        return (zzgn) obj;
    }

    public final boolean zzc(Object obj) {
        return !((zzgn) obj).zzd();
    }

    public final Object zzd(Object obj) {
        ((zzgn) obj).zzc();
        return obj;
    }

    public final Object zze(Object obj) {
        return zzgn.zza().zzb();
    }

    public final Object zza(Object obj, Object obj2) {
        zzgn zzgn = (zzgn) obj;
        zzgn zzgn2 = (zzgn) obj2;
        if (!zzgn2.isEmpty()) {
            if (!zzgn.zzd()) {
                zzgn = zzgn.zzb();
            }
            zzgn.zza(zzgn2);
        }
        return zzgn;
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzgn zzgn = (zzgn) obj;
        zzgl zzgl = (zzgl) obj2;
        if (zzgn.isEmpty()) {
            return 0;
        }
        Iterator it = zzgn.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
