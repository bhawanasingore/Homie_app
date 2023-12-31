package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zzc;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
public final class zzk implements Parcelable.Creator<zzh> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzh[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzn zzn = null;
        zzf zzf = null;
        zzc zzc = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                zzn = (zzn) SafeParcelReader.createParcelable(parcel, readHeader, zzn.CREATOR);
            } else if (fieldId == 2) {
                zzf = (zzf) SafeParcelReader.createParcelable(parcel, readHeader, zzf.CREATOR);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzc = (zzc) SafeParcelReader.createParcelable(parcel, readHeader, zzc.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzh(zzn, zzf, zzc);
    }
}
