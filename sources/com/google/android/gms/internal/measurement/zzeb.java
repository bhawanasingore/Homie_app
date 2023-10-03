package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzeb implements Comparator<zzdz> {
    zzeb() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdz zzdz = (zzdz) obj;
        zzdz zzdz2 = (zzdz) obj2;
        zzei zzei = (zzei) zzdz.iterator();
        zzei zzei2 = (zzei) zzdz2.iterator();
        while (zzei.hasNext() && zzei2.hasNext()) {
            int compare = Integer.compare(zzdz.zzb(zzei.zza()), zzdz.zzb(zzei2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdz.zza(), zzdz2.zza());
    }
}
