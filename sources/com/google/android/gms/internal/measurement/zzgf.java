package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzgf extends zzgd {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgf() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzig.zzf(obj, j);
        if (list instanceof zzga) {
            obj2 = ((zzga) list).g_();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzhf) || !(list instanceof zzfq)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzfq zzfq = (zzfq) list;
                if (zzfq.zza()) {
                    zzfq.h_();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzig.zza(obj, j, obj2);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzga) {
                list = new zzgb(i);
            } else if (!(zzc instanceof zzhf) || !(zzc instanceof zzfq)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzfq) zzc).zza(i);
            }
            zzig.zza(obj, j, (Object) list);
            return list;
        } else if (zza.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zzig.zza(obj, j, (Object) arrayList);
            return arrayList;
        } else if (zzc instanceof zzif) {
            zzgb zzgb = new zzgb(zzc.size() + i);
            zzgb.addAll((zzif) zzc);
            zzig.zza(obj, j, (Object) zzgb);
            return zzgb;
        } else if (!(zzc instanceof zzhf) || !(zzc instanceof zzfq)) {
            return zzc;
        } else {
            zzfq zzfq = (zzfq) zzc;
            if (zzfq.zza()) {
                return zzc;
            }
            zzfq zza2 = zzfq.zza(zzc.size() + i);
            zzig.zza(obj, j, (Object) zza2);
            return zza2;
        }
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzig.zza(obj, j, (Object) zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzig.zzf(obj, j);
    }
}
