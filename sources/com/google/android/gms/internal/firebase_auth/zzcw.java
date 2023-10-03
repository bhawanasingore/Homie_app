package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
public final class zzcw implements Parcelable.Creator<zzct> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzct[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzfy zzfy = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzfy = (zzfy) SafeParcelReader.createParcelable(parcel, readHeader, zzfy.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzct(str, zzfy);
    }
}
