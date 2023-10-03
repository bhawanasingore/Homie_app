package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbo;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final /* synthetic */ class zzp {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    static {
        int[] iArr = new int[zzbo.zzd.zza.values().length];
        zzb = iArr;
        try {
            iArr[zzbo.zzd.zza.LESS_THAN.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzb[zzbo.zzd.zza.GREATER_THAN.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzb[zzbo.zzd.zza.EQUAL.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzb[zzbo.zzd.zza.BETWEEN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        int[] iArr2 = new int[zzbo.zzf.zzb.values().length];
        zza = iArr2;
        try {
            iArr2[zzbo.zzf.zzb.REGEXP.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            zza[zzbo.zzf.zzb.BEGINS_WITH.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            zza[zzbo.zzf.zzb.ENDS_WITH.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
        try {
            zza[zzbo.zzf.zzb.PARTIAL.ordinal()] = 4;
        } catch (NoSuchFieldError e8) {
        }
        try {
            zza[zzbo.zzf.zzb.EXACT.ordinal()] = 5;
        } catch (NoSuchFieldError e9) {
        }
        try {
            zza[zzbo.zzf.zzb.IN_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError e10) {
        }
    }
}
