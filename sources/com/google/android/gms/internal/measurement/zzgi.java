package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzgi implements zzgq {
    private zzgq[] zza;

    zzgi(zzgq... zzgqArr) {
        this.zza = zzgqArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzgq zza2 : this.zza) {
            if (zza2.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzgr zzb(Class<?> cls) {
        for (zzgq zzgq : this.zza) {
            if (zzgq.zza(cls)) {
                return zzgq.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
