package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzbd extends zzac.zza {
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbd(zzac zzac, boolean z) {
        super(zzac);
        this.zzd = zzac;
        this.zzc = z;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzr.setDataCollectionEnabled(this.zzc);
    }
}
