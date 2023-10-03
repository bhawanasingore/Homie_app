package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzaw extends zzac.zza {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzp zzd;
    private final /* synthetic */ zzac zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaw(zzac zzac, Bundle bundle, zzp zzp) {
        super(zzac);
        this.zze = zzac;
        this.zzc = bundle;
        this.zzd = zzp;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zze.zzr.performAction(this.zzc, this.zzd, this.zza);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
