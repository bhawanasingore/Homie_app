package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzba extends zzac.zza {
    private final /* synthetic */ zzp zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzac zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzba(zzac zzac, zzp zzp, int i) {
        super(zzac);
        this.zze = zzac;
        this.zzc = zzp;
        this.zzd = i;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zze.zzr.getTestFlag(this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
