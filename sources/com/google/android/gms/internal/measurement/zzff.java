package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final /* synthetic */ class zzff {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    static {
        int[] iArr = new int[zzfv.values().length];
        zzb = iArr;
        try {
            iArr[zzfv.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzb[zzfv.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzb[zzfv.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        int[] iArr2 = new int[zzfe.values().length];
        zza = iArr2;
        try {
            iArr2[zzfe.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zza[zzfe.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            zza[zzfe.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
    }
}
