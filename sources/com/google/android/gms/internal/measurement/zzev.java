package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public class zzev {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzev zzc;
    private static volatile zzev zzd;
    private static final zzev zze = new zzev(true);
    private final Map<zza, zzfi.zzf<?, ?>> zzf;

    public static zzev zza() {
        zzev zzev = zzc;
        if (zzev == null) {
            synchronized (zzev.class) {
                zzev = zzc;
                if (zzev == null) {
                    zzev = zze;
                    zzc = zzev;
                }
            }
        }
        return zzev;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            if (this.zza == zza2.zza && this.zzb == zza2.zzb) {
                return true;
            }
            return false;
        }
    }

    public static zzev zzb() {
        Class<zzev> cls = zzev.class;
        zzev zzev = zzd;
        if (zzev != null) {
            return zzev;
        }
        synchronized (cls) {
            zzev zzev2 = zzd;
            if (zzev2 != null) {
                return zzev2;
            }
            zzev zza2 = zzfg.zza(cls);
            zzd = zza2;
            return zza2;
        }
    }

    public final <ContainingType extends zzgt> zzfi.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzf.get(new zza(containingtype, i));
    }

    zzev() {
        this.zzf = new HashMap();
    }

    private zzev(boolean z) {
        this.zzf = Collections.emptyMap();
    }
}
