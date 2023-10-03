package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public enum zzir {
    DOUBLE(zziu.DOUBLE, 1),
    FLOAT(zziu.FLOAT, 5),
    INT64(zziu.LONG, 0),
    UINT64(zziu.LONG, 0),
    INT32(zziu.INT, 0),
    FIXED64(zziu.LONG, 1),
    FIXED32(zziu.INT, 5),
    BOOL(zziu.BOOLEAN, 0),
    STRING(zziu.STRING, 2),
    GROUP(zziu.MESSAGE, 3),
    MESSAGE(zziu.MESSAGE, 2),
    BYTES(zziu.BYTE_STRING, 2),
    UINT32(zziu.INT, 0),
    ENUM(zziu.ENUM, 0),
    SFIXED32(zziu.INT, 5),
    SFIXED64(zziu.LONG, 1),
    SINT32(zziu.INT, 0),
    SINT64(zziu.LONG, 0);
    
    private final zziu zzs;
    private final int zzt;

    private zzir(zziu zziu, int i) {
        this.zzs = zziu;
        this.zzt = i;
    }

    public final zziu zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
