package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzam extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzac zzac, String str) {
        super(zzac);
        this.zzd = zzac;
        this.zzc = str;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzr.beginAdUnitExposure(this.zzc, this.zzb);
    }
}
