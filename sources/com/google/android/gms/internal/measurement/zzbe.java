package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzbe extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ boolean zzf;
    private final /* synthetic */ zzac zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbe(zzac zzac, String str, String str2, Object obj, boolean z) {
        super(zzac);
        this.zzg = zzac;
        this.zzc = str;
        this.zzd = str2;
        this.zze = obj;
        this.zzf = z;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzg.zzr.setUserProperty(this.zzc, this.zzd, ObjectWrapper.wrap(this.zze), this.zzf, this.zza);
    }
}
