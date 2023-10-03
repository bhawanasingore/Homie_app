package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzb;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzen extends zza implements zzel {
    zzen(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void zza(zzaq zzaq, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzaq);
        zzb.zza(a_, (Parcelable) zzm);
        zzb(1, a_);
    }

    public final void zza(zzkn zzkn, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzkn);
        zzb.zza(a_, (Parcelable) zzm);
        zzb(2, a_);
    }

    public final void zza(zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzm);
        zzb(4, a_);
    }

    public final void zza(zzaq zzaq, String str, String str2) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzaq);
        a_.writeString(str);
        a_.writeString(str2);
        zzb(5, a_);
    }

    public final void zzb(zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzm);
        zzb(6, a_);
    }

    public final List<zzkn> zza(zzm zzm, boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzm);
        zzb.zza(a_, z);
        Parcel zza = zza(7, a_);
        ArrayList<zzkn> createTypedArrayList = zza.createTypedArrayList(zzkn.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final byte[] zza(zzaq zzaq, String str) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzaq);
        a_.writeString(str);
        Parcel zza = zza(9, a_);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }

    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel a_ = a_();
        a_.writeLong(j);
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzb(10, a_);
    }

    public final String zzc(zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzm);
        Parcel zza = zza(11, a_);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zza(zzy zzy, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzy);
        zzb.zza(a_, (Parcelable) zzm);
        zzb(12, a_);
    }

    public final void zza(zzy zzy) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzy);
        zzb(13, a_);
    }

    public final List<zzkn> zza(String str, String str2, boolean z, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, z);
        zzb.zza(a_, (Parcelable) zzm);
        Parcel zza = zza(14, a_);
        ArrayList<zzkn> createTypedArrayList = zza.createTypedArrayList(zzkn.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzkn> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzb.zza(a_, z);
        Parcel zza = zza(15, a_);
        ArrayList<zzkn> createTypedArrayList = zza.createTypedArrayList(zzkn.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzy> zza(String str, String str2, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, (Parcelable) zzm);
        Parcel zza = zza(16, a_);
        ArrayList<zzy> createTypedArrayList = zza.createTypedArrayList(zzy.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzy> zza(String str, String str2, String str3) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        Parcel zza = zza(17, a_);
        ArrayList<zzy> createTypedArrayList = zza.createTypedArrayList(zzy.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final void zzd(zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, (Parcelable) zzm);
        zzb(18, a_);
    }
}
