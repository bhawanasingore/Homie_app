package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzbg extends zzac.zza {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbg(zzac zzac, Bundle bundle) {
        super(zzac);
        this.zzd = zzac;
        this.zzc = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzr.setConditionalUserProperty(this.zzc, this.zza);
    }
}
