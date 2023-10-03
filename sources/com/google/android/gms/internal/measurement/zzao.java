package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.measurement.internal.zzgx;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzao extends zzac.zza {
    private final /* synthetic */ zzgx zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzao(zzac zzac, zzgx zzgx) {
        super(zzac);
        this.zzd = zzac;
        this.zzc = zzgx;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzr.setEventInterceptor(new zzac.zzc(this.zzc));
    }
}
