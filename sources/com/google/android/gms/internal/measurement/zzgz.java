package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzgz<T> implements zzhi<T> {
    private final zzgt zza;
    private final zzia<?, ?> zzb;
    private final boolean zzc;
    private final zzex<?> zzd;

    private zzgz(zzia<?, ?> zzia, zzex<?> zzex, zzgt zzgt) {
        this.zzb = zzia;
        this.zzc = zzex.zza(zzgt);
        this.zzd = zzex;
        this.zza = zzgt;
    }

    static <T> zzgz<T> zza(zzia<?, ?> zzia, zzex<?> zzex, zzgt zzgt) {
        return new zzgz<>(zzia, zzex, zzgt);
    }

    public final T zza() {
        return this.zza.zzbs().zzt();
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        if (this.zzc) {
            return (hashCode * 53) + this.zzd.zza((Object) t).hashCode();
        }
        return hashCode;
    }

    public final void zzb(T t, T t2) {
        zzhk.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzhk.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzix zzix) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzfd zzfd = (zzfd) next.getKey();
            if (zzfd.zzc() != zziu.MESSAGE || zzfd.zzd() || zzfd.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzfw) {
                zzix.zza(zzfd.zza(), (Object) ((zzfw) next).zza().zzc());
            } else {
                zzix.zza(zzfd.zza(), next.getValue());
            }
        }
        zzia<?, ?> zzia = this.zzb;
        zzia.zzb(zzia.zzb(t), zzix);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzfi$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzdy r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzfi r0 = (com.google.android.gms.internal.measurement.zzfi) r0
            com.google.android.gms.internal.measurement.zzid r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzid r2 = com.google.android.gms.internal.measurement.zzid.zza()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzid r1 = com.google.android.gms.internal.measurement.zzid.zzb()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzfi$zzd r10 = (com.google.android.gms.internal.measurement.zzfi.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00ac
            int r4 = com.google.android.gms.internal.measurement.zzdv.zza(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0053
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004e
            com.google.android.gms.internal.measurement.zzex<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzev r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzgt r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzfi$zzf r0 = (com.google.android.gms.internal.measurement.zzfi.zzf) r0
            if (r0 != 0) goto L_0x0045
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzdv.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzid) r6, (com.google.android.gms.internal.measurement.zzdy) r7)
            goto L_0x0018
        L_0x0045:
            com.google.android.gms.internal.measurement.zzhe.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004e:
            int r12 = com.google.android.gms.internal.measurement.zzdv.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzdy) r14)
            goto L_0x0018
        L_0x0053:
            r12 = 0
            r2 = r10
        L_0x0055:
            if (r4 >= r13) goto L_0x009f
            int r4 = com.google.android.gms.internal.measurement.zzdv.zza(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x0081
            r8 = 3
            if (r6 == r8) goto L_0x006b
            goto L_0x0096
        L_0x006b:
            if (r0 != 0) goto L_0x0078
            if (r7 != r3) goto L_0x0096
            int r4 = com.google.android.gms.internal.measurement.zzdv.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzdz r2 = (com.google.android.gms.internal.measurement.zzdz) r2
            goto L_0x0055
        L_0x0078:
            com.google.android.gms.internal.measurement.zzhe.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x0081:
            if (r7 != 0) goto L_0x0096
            int r4 = com.google.android.gms.internal.measurement.zzdv.zza(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzex<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzev r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzgt r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzfi$zzf r0 = (com.google.android.gms.internal.measurement.zzfi.zzf) r0
            goto L_0x0055
        L_0x0096:
            r6 = 12
            if (r5 == r6) goto L_0x009f
            int r4 = com.google.android.gms.internal.measurement.zzdv.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzdy) r14)
            goto L_0x0055
        L_0x009f:
            if (r2 == 0) goto L_0x00a9
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza((int) r12, (java.lang.Object) r2)
        L_0x00a9:
            r12 = r4
            goto L_0x0018
        L_0x00ac:
            if (r12 != r13) goto L_0x00af
            return
        L_0x00af:
            com.google.android.gms.internal.measurement.zzft r10 = com.google.android.gms.internal.measurement.zzft.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgz.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzdy):void");
    }

    public final void zza(T t, zzhj zzhj, zzev zzev) throws IOException {
        boolean z;
        zzia<?, ?> zzia = this.zzb;
        zzex<?> zzex = this.zzd;
        Object zzc2 = zzia.zzc(t);
        zzfb<?> zzb2 = zzex.zzb(t);
        do {
            try {
                if (zzhj.zza() == Integer.MAX_VALUE) {
                    zzia.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzhj.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzdz zzdz = null;
                    while (zzhj.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzhj.zzb();
                        if (zzb4 == 16) {
                            i = zzhj.zzo();
                            obj = zzex.zza(zzev, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzex.zza(zzhj, obj, zzev, zzb2);
                            } else {
                                zzdz = zzhj.zzn();
                            }
                        } else if (!zzhj.zzc()) {
                            break;
                        }
                    }
                    if (zzhj.zzb() != 12) {
                        throw zzft.zze();
                    } else if (zzdz != null) {
                        if (obj != null) {
                            zzex.zza(zzdz, obj, zzev, zzb2);
                        } else {
                            zzia.zza(zzc2, i, zzdz);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzex.zza(zzev, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzex.zza(zzhj, zza2, zzev, zzb2);
                    } else {
                        z = zzia.zza(zzc2, zzhj);
                        continue;
                    }
                } else {
                    z = zzhj.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzia.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    public final int zzb(T t) {
        zzia<?, ?> zzia = this.zzb;
        int zze = zzia.zze(zzia.zzb(t)) + 0;
        if (this.zzc) {
            return zze + this.zzd.zza((Object) t).zzg();
        }
        return zze;
    }
}
