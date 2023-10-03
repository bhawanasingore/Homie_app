package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzbm extends zzac.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzac.zzd zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbm(zzac.zzd zzd2, Activity activity) {
        super(zzac.this);
        this.zzd = zzd2;
        this.zzc = activity;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzac.this.zzr.onActivityDestroyed(ObjectWrapper.wrap(this.zzc), this.zzb);
    }
}
