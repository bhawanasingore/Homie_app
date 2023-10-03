package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzkf;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzs {
    private String zza;
    private boolean zzb;
    private zzbw.zzi zzc;
    /* access modifiers changed from: private */
    public BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzq zzh;

    private zzs(zzq zzq, String str) {
        this.zzh = zzq;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzs(zzq zzq, String str, zzbw.zzi zzi, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzq;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer next : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(next));
                this.zzg.put(next, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzi;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzt zzt) {
        int zza2 = zzt.zza();
        if (zzt.zzc != null) {
            this.zze.set(zza2, zzt.zzc.booleanValue());
        }
        if (zzt.zzd != null) {
            this.zzd.set(zza2, zzt.zzd.booleanValue());
        }
        if (zzt.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(zza2));
            long longValue = zzt.zze.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(zza2), Long.valueOf(longValue));
            }
        }
        if (zzt.zzf != null) {
            List list = this.zzg.get(Integer.valueOf(zza2));
            if (list == null) {
                list = new ArrayList();
                this.zzg.put(Integer.valueOf(zza2), list);
            }
            if (zzt.zzb()) {
                list.clear();
            }
            if (zzkf.zzb() && this.zzh.zzt().zzd(this.zza, zzas.zzbg) && zzt.zzc()) {
                list.clear();
            }
            if (!zzkf.zzb() || !this.zzh.zzt().zzd(this.zza, zzas.zzbg)) {
                list.add(Long.valueOf(zzt.zzf.longValue() / 1000));
                return;
            }
            long longValue2 = zzt.zzf.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzbw.zza zza(int i) {
        ArrayList arrayList;
        List list;
        zzbw.zza.C0008zza zzh2 = zzbw.zza.zzh();
        zzh2.zza(i);
        zzh2.zza(this.zzb);
        zzbw.zzi zzi = this.zzc;
        if (zzi != null) {
            zzh2.zza(zzi);
        }
        zzbw.zzi.zza zza2 = zzbw.zzi.zzi().zzb((Iterable<? extends Long>) zzkk.zza(this.zzd)).zza((Iterable<? extends Long>) zzkk.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            for (Integer intValue : this.zzf.keySet()) {
                int intValue2 = intValue.intValue();
                arrayList.add((zzbw.zzb) ((zzfi) zzbw.zzb.zze().zza(intValue2).zza(this.zzf.get(Integer.valueOf(intValue2)).longValue()).zzu()));
            }
        }
        zza2.zzc(arrayList);
        if (this.zzg == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(this.zzg.size());
            for (Integer next : this.zzg.keySet()) {
                zzbw.zzj.zza zza3 = zzbw.zzj.zze().zza(next.intValue());
                List list2 = this.zzg.get(next);
                if (list2 != null) {
                    Collections.sort(list2);
                    zza3.zza((Iterable<? extends Long>) list2);
                }
                arrayList2.add((zzbw.zzj) ((zzfi) zza3.zzu()));
            }
            list = arrayList2;
        }
        zza2.zzd(list);
        zzh2.zza(zza2);
        return (zzbw.zza) ((zzfi) zzh2.zzu());
    }

    /* synthetic */ zzs(zzq zzq, String str, zzbw.zzi zzi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzp zzp) {
        this(zzq, str, zzi, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzs(zzq zzq, String str, zzp zzp) {
        this(zzq, str);
    }
}
