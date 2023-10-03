package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public enum zzfc {
    DOUBLE(0, zzfe.SCALAR, zzfv.DOUBLE),
    FLOAT(1, zzfe.SCALAR, zzfv.FLOAT),
    INT64(2, zzfe.SCALAR, zzfv.LONG),
    UINT64(3, zzfe.SCALAR, zzfv.LONG),
    INT32(4, zzfe.SCALAR, zzfv.INT),
    FIXED64(5, zzfe.SCALAR, zzfv.LONG),
    FIXED32(6, zzfe.SCALAR, zzfv.INT),
    BOOL(7, zzfe.SCALAR, zzfv.BOOLEAN),
    STRING(8, zzfe.SCALAR, zzfv.STRING),
    MESSAGE(9, zzfe.SCALAR, zzfv.MESSAGE),
    BYTES(10, zzfe.SCALAR, zzfv.BYTE_STRING),
    UINT32(11, zzfe.SCALAR, zzfv.INT),
    ENUM(12, zzfe.SCALAR, zzfv.ENUM),
    SFIXED32(13, zzfe.SCALAR, zzfv.INT),
    SFIXED64(14, zzfe.SCALAR, zzfv.LONG),
    SINT32(15, zzfe.SCALAR, zzfv.INT),
    SINT64(16, zzfe.SCALAR, zzfv.LONG),
    GROUP(17, zzfe.SCALAR, zzfv.MESSAGE),
    DOUBLE_LIST(18, zzfe.VECTOR, zzfv.DOUBLE),
    FLOAT_LIST(19, zzfe.VECTOR, zzfv.FLOAT),
    INT64_LIST(20, zzfe.VECTOR, zzfv.LONG),
    UINT64_LIST(21, zzfe.VECTOR, zzfv.LONG),
    INT32_LIST(22, zzfe.VECTOR, zzfv.INT),
    FIXED64_LIST(23, zzfe.VECTOR, zzfv.LONG),
    FIXED32_LIST(24, zzfe.VECTOR, zzfv.INT),
    BOOL_LIST(25, zzfe.VECTOR, zzfv.BOOLEAN),
    STRING_LIST(26, zzfe.VECTOR, zzfv.STRING),
    MESSAGE_LIST(27, zzfe.VECTOR, zzfv.MESSAGE),
    BYTES_LIST(28, zzfe.VECTOR, zzfv.BYTE_STRING),
    UINT32_LIST(29, zzfe.VECTOR, zzfv.INT),
    ENUM_LIST(30, zzfe.VECTOR, zzfv.ENUM),
    SFIXED32_LIST(31, zzfe.VECTOR, zzfv.INT),
    SFIXED64_LIST(32, zzfe.VECTOR, zzfv.LONG),
    SINT32_LIST(33, zzfe.VECTOR, zzfv.INT),
    SINT64_LIST(34, zzfe.VECTOR, zzfv.LONG),
    DOUBLE_LIST_PACKED(35, zzfe.PACKED_VECTOR, zzfv.DOUBLE),
    FLOAT_LIST_PACKED(36, zzfe.PACKED_VECTOR, zzfv.FLOAT),
    INT64_LIST_PACKED(37, zzfe.PACKED_VECTOR, zzfv.LONG),
    UINT64_LIST_PACKED(38, zzfe.PACKED_VECTOR, zzfv.LONG),
    INT32_LIST_PACKED(39, zzfe.PACKED_VECTOR, zzfv.INT),
    FIXED64_LIST_PACKED(40, zzfe.PACKED_VECTOR, zzfv.LONG),
    FIXED32_LIST_PACKED(41, zzfe.PACKED_VECTOR, zzfv.INT),
    BOOL_LIST_PACKED(42, zzfe.PACKED_VECTOR, zzfv.BOOLEAN),
    UINT32_LIST_PACKED(43, zzfe.PACKED_VECTOR, zzfv.INT),
    ENUM_LIST_PACKED(44, zzfe.PACKED_VECTOR, zzfv.ENUM),
    SFIXED32_LIST_PACKED(45, zzfe.PACKED_VECTOR, zzfv.INT),
    SFIXED64_LIST_PACKED(46, zzfe.PACKED_VECTOR, zzfv.LONG),
    SINT32_LIST_PACKED(47, zzfe.PACKED_VECTOR, zzfv.INT),
    SINT64_LIST_PACKED(48, zzfe.PACKED_VECTOR, zzfv.LONG),
    GROUP_LIST(49, zzfe.VECTOR, zzfv.MESSAGE),
    MAP(50, zzfe.MAP, zzfv.VOID);
    
    private static final zzfc[] zzbe = null;
    private static final Type[] zzbf = null;
    private final zzfv zzaz;
    private final int zzba;
    private final zzfe zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r5 = com.google.android.gms.internal.measurement.zzff.zzb[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzfc(int r4, com.google.android.gms.internal.measurement.zzfe r5, com.google.android.gms.internal.measurement.zzfv r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.zzba = r4
            r1.zzbb = r5
            r1.zzaz = r6
            int[] r2 = com.google.android.gms.internal.measurement.zzff.zza
            int r3 = r5.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0022
            if (r2 == r3) goto L_0x001b
            r2 = 0
            r1.zzbc = r2
            goto L_0x0029
        L_0x001b:
            java.lang.Class r2 = r6.zza()
            r1.zzbc = r2
            goto L_0x0029
        L_0x0022:
            java.lang.Class r2 = r6.zza()
            r1.zzbc = r2
        L_0x0029:
            r2 = 0
            com.google.android.gms.internal.measurement.zzfe r0 = com.google.android.gms.internal.measurement.zzfe.SCALAR
            if (r5 != r0) goto L_0x003e
            int[] r5 = com.google.android.gms.internal.measurement.zzff.zzb
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x003e
            if (r5 == r3) goto L_0x003e
            r3 = 3
            if (r5 == r3) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r4 = r2
        L_0x003f:
            r1.zzbd = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfc.<init>(java.lang.String, int, int, com.google.android.gms.internal.measurement.zzfe, com.google.android.gms.internal.measurement.zzfv):void");
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        int i;
        zzbf = new Type[0];
        zzfc[] values = values();
        zzbe = new zzfc[values.length];
        for (zzfc zzfc : values) {
            zzbe[zzfc.zzba] = zzfc;
        }
    }
}
