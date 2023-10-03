package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzhk {
    private static final Class<?> zza = zzd();
    private static final zzia<?, ?> zzb = zza(false);
    private static final zzia<?, ?> zzc = zza(true);
    private static final zzia<?, ?> zzd = new zzic();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzfi.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzix zzix, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzix zzix) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzdz> list, zzix zzix) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzix zzix, zzhi zzhi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zza(i, list, zzhi);
        }
    }

    public static void zzb(int i, List<?> list, zzix zzix, zzhi zzhi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzix.zzb(i, list, zzhi);
        }
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgh) {
            zzgh zzgh = (zzgh) list;
            i = 0;
            while (i2 < size) {
                i += zzes.zzd(zzgh.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzes.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzes.zze(i));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgh) {
            zzgh zzgh = (zzgh) list;
            i = 0;
            while (i2 < size) {
                i += zzes.zze(zzgh.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzes.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzes.zze(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgh) {
            zzgh zzgh = (zzgh) list;
            i = 0;
            while (i2 < size) {
                i += zzes.zzf(zzgh.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzes.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzes.zze(i));
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            i = 0;
            while (i2 < size) {
                i += zzes.zzk(zzfl.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzes.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzes.zze(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            i = 0;
            while (i2 < size) {
                i += zzes.zzf(zzfl.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzes.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzes.zze(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            i = 0;
            while (i2 < size) {
                i += zzes.zzg(zzfl.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzes.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzes.zze(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            i = 0;
            while (i2 < size) {
                i += zzes.zzh(zzfl.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzes.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzes.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzes.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzes.zzg(i, 0);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzes.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzes.zze(i) * size;
        if (list instanceof zzga) {
            zzga zzga = (zzga) list;
            while (i4 < size) {
                Object zzb2 = zzga.zzb(i4);
                if (zzb2 instanceof zzdz) {
                    i3 = zzes.zzb((zzdz) zzb2);
                } else {
                    i3 = zzes.zzb((String) zzb2);
                }
                zze += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdz) {
                    i2 = zzes.zzb((zzdz) obj);
                } else {
                    i2 = zzes.zzb((String) obj);
                }
                zze += i2;
                i4++;
            }
        }
        return zze;
    }

    static int zza(int i, Object obj, zzhi zzhi) {
        if (obj instanceof zzfy) {
            return zzes.zza(i, (zzfy) obj);
        }
        return zzes.zzb(i, (zzgt) obj, zzhi);
    }

    static int zza(int i, List<?> list, zzhi zzhi) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzes.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzfy) {
                i2 = zzes.zza((zzfy) obj);
            } else {
                i2 = zzes.zza((zzgt) obj, zzhi);
            }
            zze += i2;
        }
        return zze;
    }

    static int zzb(int i, List<zzdz> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzes.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzes.zzb(list.get(i2));
        }
        return zze;
    }

    static int zzb(int i, List<zzgt> list, zzhi zzhi) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzes.zzc(i, list.get(i3), zzhi);
        }
        return i2;
    }

    public static zzia<?, ?> zza() {
        return zzb;
    }

    public static zzia<?, ?> zzb() {
        return zzc;
    }

    public static zzia<?, ?> zzc() {
        return zzd;
    }

    private static zzia<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzia) zze.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzgm zzgm, T t, T t2, long j) {
        zzig.zza((Object) t, j, zzgm.zza(zzig.zzf(t, j), zzig.zzf(t2, j)));
    }

    static <T, FT extends zzfd<FT>> void zza(zzex<FT> zzex, T t, T t2) {
        zzfb<FT> zza2 = zzex.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzex.zzb(t).zza(zza2);
        }
    }

    static <T, UT, UB> void zza(zzia<UT, UB> zzia, T t, T t2) {
        zzia.zza((Object) t, zzia.zzc(zzia.zzb(t), zzia.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfp zzfp, UB ub, zzia<UT, UB> zzia) {
        if (zzfp == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzfp.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzia);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzfp.zza(intValue2)) {
                    ub = zza(i, intValue2, ub, zzia);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzia<UT, UB> zzia) {
        if (ub == null) {
            ub = zzia.zza();
        }
        zzia.zza(ub, i, (long) i2);
        return ub;
    }
}
