package com.google.android.gms.maps.model;

import android.os.Parcelable;

public final class zzh implements Parcelable.Creator<MarkerOptions> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new MarkerOptions[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r23) {
        /*
            r22 = this;
            r0 = r23
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r23)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 1056964608(0x3f000000, float:0.5)
            r6 = 1065353216(0x3f800000, float:1.0)
            r14 = r2
            r15 = r14
            r16 = r15
            r8 = r3
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r4
            r13 = r12
            r17 = r13
            r19 = r17
            r21 = r19
            r18 = r5
            r20 = r6
        L_0x002e:
            int r2 = r23.dataPosition()
            if (r2 >= r1) goto L_0x009b
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r23)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x0091;
                case 3: goto L_0x008b;
                case 4: goto L_0x0085;
                case 5: goto L_0x007f;
                case 6: goto L_0x0079;
                case 7: goto L_0x0073;
                case 8: goto L_0x006d;
                case 9: goto L_0x0067;
                case 10: goto L_0x0061;
                case 11: goto L_0x005b;
                case 12: goto L_0x0055;
                case 13: goto L_0x004f;
                case 14: goto L_0x0049;
                case 15: goto L_0x0043;
                default: goto L_0x003f;
            }
        L_0x003f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x002e
        L_0x0043:
            float r21 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x002e
        L_0x0049:
            float r20 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x002e
        L_0x004f:
            float r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x002e
        L_0x0055:
            float r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x002e
        L_0x005b:
            float r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x002e
        L_0x0061:
            boolean r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x002e
        L_0x0067:
            boolean r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x002e
        L_0x006d:
            boolean r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x002e
        L_0x0073:
            float r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x002e
        L_0x0079:
            float r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x002e
        L_0x007f:
            android.os.IBinder r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002e
        L_0x0085:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x002e
        L_0x008b:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x002e
        L_0x0091:
            android.os.Parcelable$Creator<com.google.android.gms.maps.model.LatLng> r3 = com.google.android.gms.maps.model.LatLng.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r8 = r2
            com.google.android.gms.maps.model.LatLng r8 = (com.google.android.gms.maps.model.LatLng) r8
            goto L_0x002e
        L_0x009b:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.maps.model.MarkerOptions r0 = new com.google.android.gms.maps.model.MarkerOptions
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.zzh.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
