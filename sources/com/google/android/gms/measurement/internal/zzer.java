package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzjt;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzer extends zzgr {
    private static final AtomicReference<String[]> zza = new AtomicReference<>();
    private static final AtomicReference<String[]> zzb = new AtomicReference<>();
    private static final AtomicReference<String[]> zzc = new AtomicReference<>();

    zzer(zzfx zzfx) {
        super(zzfx);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    private final boolean zzg() {
        zzu();
        return this.zzz.zzl() && this.zzz.zzr().zza(3);
    }

    /* access modifiers changed from: protected */
    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        return zza(str, zzgw.zzb, zzgw.zza, zza);
    }

    /* access modifiers changed from: protected */
    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        return zza(str, zzgv.zzb, zzgv.zza, zzb);
    }

    /* access modifiers changed from: protected */
    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, zzgy.zzb, zzgy.zza, zzc);
        }
        return "experiment_id" + "(" + str + ")";
    }

    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzko.zzc(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final String zza(zzaq zzaq) {
        String str = null;
        if (zzaq == null) {
            return null;
        }
        if (!zzg()) {
            return zzaq.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzaq.zzc);
        sb.append(",name=");
        sb.append(zza(zzaq.zza));
        sb.append(",params=");
        zzal zzal = zzaq.zzb;
        if (zzal != null) {
            if (!zzg()) {
                str = zzal.toString();
            } else {
                str = zza(zzal.zzb());
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zza(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!zzg()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str2 : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(zzb(str2));
            sb.append("=");
            if (!zzjt.zzb() || !zzt().zza(zzas.zzce)) {
                sb.append(bundle.get(str2));
            } else {
                Object obj = bundle.get(str2);
                if (obj instanceof Bundle) {
                    str = zza(new Object[]{obj});
                } else if (obj instanceof Object[]) {
                    str = zza((Object[]) obj);
                } else if (obj instanceof ArrayList) {
                    str = zza(((ArrayList) obj).toArray());
                } else {
                    str = String.valueOf(obj);
                }
                sb.append(str);
            }
        }
        sb.append("}]");
        return sb.toString();
    }

    private final String zza(Object[] objArr) {
        String str;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = zza(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzak zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzer zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzko zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfu zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzet zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzff zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzaa zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzv zzu() {
        return super.zzu();
    }
}
