package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzal extends zzac.zza {
    private final /* synthetic */ zzac zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzal(zzac zzac) {
        super(zzac);
        this.zzc = zzac;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzc.zzr.resetAnalyticsData(this.zza);
    }
}
