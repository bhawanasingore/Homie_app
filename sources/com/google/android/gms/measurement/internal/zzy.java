package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzx();
    public String zza;
    public String zzb;
    public zzkn zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public zzaq zzg;
    public long zzh;
    public zzaq zzi;
    public long zzj;
    public zzaq zzk;

    zzy(zzy zzy) {
        Preconditions.checkNotNull(zzy);
        this.zza = zzy.zza;
        this.zzb = zzy.zzb;
        this.zzc = zzy.zzc;
        this.zzd = zzy.zzd;
        this.zze = zzy.zze;
        this.zzf = zzy.zzf;
        this.zzg = zzy.zzg;
        this.zzh = zzy.zzh;
        this.zzi = zzy.zzi;
        this.zzj = zzy.zzj;
        this.zzk = zzy.zzk;
    }

    zzy(String str, String str2, zzkn zzkn, long j, boolean z, String str3, zzaq zzaq, long j2, zzaq zzaq2, long j3, zzaq zzaq3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzkn;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzaq;
        this.zzh = j2;
        this.zzi = zzaq2;
        this.zzj = j3;
        this.zzk = zzaq3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
