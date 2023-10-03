package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public enum zziu {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzdz.zza),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzj;

    private zziu(Object obj) {
        this.zzj = obj;
    }
}
