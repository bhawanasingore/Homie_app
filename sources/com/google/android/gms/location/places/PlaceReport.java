package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.analytics.FirebaseAnalytics;

public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zza();
    private final String tag;
    private final int versionCode;
    private final String zza;
    private final String zzb;

    PlaceReport(int i, String str, String str2, String str3) {
        this.versionCode = i;
        this.zza = str;
        this.tag = str2;
        this.zzb = str3;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.location.places.PlaceReport create(java.lang.String r8, java.lang.String r9) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            java.lang.String r0 = "unknown"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            int r1 = r0.hashCode()
            r2 = 0
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r1) {
                case -1436706272: goto L_0x0049;
                case -1194968642: goto L_0x003f;
                case -284840886: goto L_0x0037;
                case -262743844: goto L_0x002d;
                case 1164924125: goto L_0x0023;
                case 1287171955: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0053
        L_0x0019:
            java.lang.String r1 = "inferredRadioSignals"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0053
            r1 = r5
            goto L_0x0054
        L_0x0023:
            java.lang.String r1 = "inferredSnappedToRoad"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0053
            r1 = r3
            goto L_0x0054
        L_0x002d:
            java.lang.String r1 = "inferredReverseGeocoding"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0053
            r1 = r4
            goto L_0x0054
        L_0x0037:
            boolean r1 = r0.equals(r0)
            if (r1 == 0) goto L_0x0053
            r1 = r2
            goto L_0x0054
        L_0x003f:
            java.lang.String r1 = "userReported"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0053
            r1 = r7
            goto L_0x0054
        L_0x0049:
            java.lang.String r1 = "inferredGeofencing"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0053
            r1 = r6
            goto L_0x0054
        L_0x0053:
            r1 = -1
        L_0x0054:
            if (r1 == 0) goto L_0x0061
            if (r1 == r7) goto L_0x0061
            if (r1 == r6) goto L_0x0061
            if (r1 == r5) goto L_0x0061
            if (r1 == r4) goto L_0x0061
            if (r1 == r3) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r2 = r7
        L_0x0062:
            java.lang.String r1 = "Invalid source"
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2, r1)
            com.google.android.gms.location.places.PlaceReport r1 = new com.google.android.gms.location.places.PlaceReport
            r1.<init>(r7, r8, r9, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.places.PlaceReport.create(java.lang.String, java.lang.String):com.google.android.gms.location.places.PlaceReport");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return Objects.equal(this.zza, placeReport.zza) && Objects.equal(this.tag, placeReport.tag) && Objects.equal(this.zzb, placeReport.zzb);
    }

    public String getPlaceId() {
        return this.zza;
    }

    public String getTag() {
        return this.tag;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.tag, this.zzb);
    }

    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("placeId", this.zza);
        stringHelper.add("tag", this.tag);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.zzb)) {
            stringHelper.add(FirebaseAnalytics.Param.SOURCE, this.zzb);
        }
        return stringHelper.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, getPlaceId(), false);
        SafeParcelWriter.writeString(parcel, 3, getTag(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
