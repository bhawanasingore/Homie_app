package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzhg implements zzgr {
    private final zzgt zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzhg(zzgt zzgt, String str, Object[] objArr) {
        this.zza = zzgt;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.zzd = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }

    public final zzgt zzc() {
        return this.zza;
    }

    public final int zza() {
        return (this.zzd & 1) == 1 ? zzfi.zze.zzh : zzfi.zze.zzi;
    }

    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }
}
