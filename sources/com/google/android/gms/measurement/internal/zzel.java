package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public interface zzel extends IInterface {
    List<zzkn> zza(zzm zzm, boolean z) throws RemoteException;

    List<zzy> zza(String str, String str2, zzm zzm) throws RemoteException;

    List<zzy> zza(String str, String str2, String str3) throws RemoteException;

    List<zzkn> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzkn> zza(String str, String str2, boolean z, zzm zzm) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(zzaq zzaq, zzm zzm) throws RemoteException;

    void zza(zzaq zzaq, String str, String str2) throws RemoteException;

    void zza(zzkn zzkn, zzm zzm) throws RemoteException;

    void zza(zzm zzm) throws RemoteException;

    void zza(zzy zzy) throws RemoteException;

    void zza(zzy zzy, zzm zzm) throws RemoteException;

    byte[] zza(zzaq zzaq, String str) throws RemoteException;

    void zzb(zzm zzm) throws RemoteException;

    String zzc(zzm zzm) throws RemoteException;

    void zzd(zzm zzm) throws RemoteException;
}
