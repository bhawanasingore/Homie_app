package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzfb<T extends zzfd<T>> {
    private static final zzfb zzd = new zzfb(true);
    final zzhn<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzfb() {
        this.zza = zzhn.zza(16);
    }

    private zzfb(boolean z) {
        this(zzhn.zza(0));
        zzb();
    }

    private zzfb(zzhn<T, Object> zzhn) {
        this.zza = zzhn;
        zzb();
    }

    public static <T extends zzfd<T>> zzfb<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfb)) {
            return false;
        }
        return this.zza.equals(((zzfb) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzfz(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzfz(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzfu)) {
            return obj;
        }
        zzfu zzfu = (zzfu) obj;
        return zzfu.zza();
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfu) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private static void zza(zzir zzir, Object obj) {
        zzfk.zza(obj);
        boolean z = true;
        switch (zzfa.zza[zzir.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzdz) && !(obj instanceof byte[])) {
                    z = false;
                    break;
                }
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzfn)) {
                    z = false;
                    break;
                }
            case 9:
                if (!(obj instanceof zzgt) && !(obj instanceof zzfu)) {
                    z = false;
                    break;
                }
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza(this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zza2 : this.zza.zzd()) {
            if (!zza(zza2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzfd<T>> boolean zza(Map.Entry<T, Object> entry) {
        zzfd zzfd = (zzfd) entry.getKey();
        if (zzfd.zzc() == zziu.MESSAGE) {
            if (zzfd.zzd()) {
                for (zzgt zzbl : (List) entry.getValue()) {
                    if (!zzbl.zzbl()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgt) {
                    if (!((zzgt) value).zzbl()) {
                        return false;
                    }
                } else if (value instanceof zzfu) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfb<T> zzfb) {
        for (int i = 0; i < zzfb.zza.zzc(); i++) {
            zzb(zzfb.zza.zzb(i));
        }
        for (Map.Entry<T, Object> zzb2 : zzfb.zza.zzd()) {
            zzb(zzb2);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgy) {
            return ((zzgy) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzfd zzfd = (zzfd) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfu) {
            zzfu zzfu = (zzfu) value;
            value = zzfu.zza();
        }
        if (zzfd.zzd()) {
            Object zza2 = zza(zzfd);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object zza3 : (List) value) {
                ((List) zza2).add(zza(zza3));
            }
            this.zza.put(zzfd, zza2);
        } else if (zzfd.zzc() == zziu.MESSAGE) {
            Object zza4 = zza(zzfd);
            if (zza4 == null) {
                this.zza.put(zzfd, zza(value));
                return;
            }
            if (zza4 instanceof zzgy) {
                obj = zzfd.zza((zzgy) zza4, (zzgy) value);
            } else {
                obj = zzfd.zza(((zzgt) zza4).zzbr(), (zzgt) value).zzu();
            }
            this.zza.put(zzfd, obj);
        } else {
            this.zza.put(zzfd, zza(value));
        }
    }

    static void zza(zzes zzes, zzir zzir, int i, Object obj) throws IOException {
        if (zzir == zzir.GROUP) {
            zzgt zzgt = (zzgt) obj;
            zzfk.zza(zzgt);
            zzes.zza(i, 3);
            zzgt.zza(zzes);
            zzes.zza(i, 4);
            return;
        }
        zzes.zza(i, zzir.zzb());
        switch (zzfa.zzb[zzir.ordinal()]) {
            case 1:
                zzes.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzes.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzes.zza(((Long) obj).longValue());
                return;
            case 4:
                zzes.zza(((Long) obj).longValue());
                return;
            case 5:
                zzes.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzes.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzes.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzes.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgt) obj).zza(zzes);
                return;
            case 10:
                zzes.zza((zzgt) obj);
                return;
            case 11:
                if (obj instanceof zzdz) {
                    zzes.zza((zzdz) obj);
                    return;
                } else {
                    zzes.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdz) {
                    zzes.zza((zzdz) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzes.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzes.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzes.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzes.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzes.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzes.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfn) {
                    zzes.zza(((zzfn) obj).zza());
                    return;
                } else {
                    zzes.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzd()) {
            i += zzc(zzc2);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        zzfd zzfd = (zzfd) entry.getKey();
        Object value = entry.getValue();
        if (zzfd.zzc() != zziu.MESSAGE || zzfd.zzd() || zzfd.zze()) {
            return zza((zzfd<?>) zzfd, value);
        }
        if (value instanceof zzfu) {
            return zzes.zzb(((zzfd) entry.getKey()).zza(), (zzfy) (zzfu) value);
        }
        return zzes.zzb(((zzfd) entry.getKey()).zza(), (zzgt) value);
    }

    static int zza(zzir zzir, int i, Object obj) {
        int zze = zzes.zze(i);
        if (zzir == zzir.GROUP) {
            zzfk.zza((zzgt) obj);
            zze <<= 1;
        }
        return zze + zzb(zzir, obj);
    }

    private static int zzb(zzir zzir, Object obj) {
        switch (zzfa.zzb[zzir.ordinal()]) {
            case 1:
                return zzes.zzb(((Double) obj).doubleValue());
            case 2:
                return zzes.zzb(((Float) obj).floatValue());
            case 3:
                return zzes.zzd(((Long) obj).longValue());
            case 4:
                return zzes.zze(((Long) obj).longValue());
            case 5:
                return zzes.zzf(((Integer) obj).intValue());
            case 6:
                return zzes.zzg(((Long) obj).longValue());
            case 7:
                return zzes.zzi(((Integer) obj).intValue());
            case 8:
                return zzes.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzes.zzc((zzgt) obj);
            case 10:
                if (obj instanceof zzfu) {
                    return zzes.zza((zzfy) (zzfu) obj);
                }
                return zzes.zzb((zzgt) obj);
            case 11:
                if (obj instanceof zzdz) {
                    return zzes.zzb((zzdz) obj);
                }
                return zzes.zzb((String) obj);
            case 12:
                if (obj instanceof zzdz) {
                    return zzes.zzb((zzdz) obj);
                }
                return zzes.zzb((byte[]) obj);
            case 13:
                return zzes.zzg(((Integer) obj).intValue());
            case 14:
                return zzes.zzj(((Integer) obj).intValue());
            case 15:
                return zzes.zzh(((Long) obj).longValue());
            case 16:
                return zzes.zzh(((Integer) obj).intValue());
            case 17:
                return zzes.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfn) {
                    return zzes.zzk(((zzfn) obj).zza());
                }
                return zzes.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzfd<?> zzfd, Object obj) {
        zzir zzb2 = zzfd.zzb();
        int zza2 = zzfd.zza();
        if (!zzfd.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzfd.zze()) {
            for (Object zzb3 : (List) obj) {
                i += zzb(zzb2, zzb3);
            }
            return zzes.zze(zza2) + i + zzes.zzl(i);
        }
        for (Object zza3 : (List) obj) {
            i += zza(zzb2, zza2, zza3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfb zzfb = new zzfb();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzfb.zzb((zzfd) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzd()) {
            zzfb.zzb((zzfd) next.getKey(), next.getValue());
        }
        zzfb.zzc = this.zzc;
        return zzfb;
    }
}
