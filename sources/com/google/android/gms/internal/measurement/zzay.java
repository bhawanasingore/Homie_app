package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzay extends zzac.zza {
    private final /* synthetic */ zzp zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzay(zzac zzac, zzp zzp) {
        super(zzac);
        this.zzd = zzac;
        this.zzc = zzp;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzr.getAppInstanceId(this.zzc);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
