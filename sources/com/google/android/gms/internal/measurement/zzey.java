package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzey {
    private static final zzex<?> zza = new zzez();
    private static final zzex<?> zzb = zzc();

    private static zzex<?> zzc() {
        try {
            return (zzex) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    static zzex<?> zza() {
        return zza;
    }

    static zzex<?> zzb() {
        zzex<?> zzex = zzb;
        if (zzex != null) {
            return zzex;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
