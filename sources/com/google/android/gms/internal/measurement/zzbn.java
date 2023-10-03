package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzbn extends zzac.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzp zzd;
    private final /* synthetic */ zzac.zzd zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbn(zzac.zzd zzd2, Activity activity, zzp zzp) {
        super(zzac.this);
        this.zze = zzd2;
        this.zzc = activity;
        this.zzd = zzp;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzac.this.zzr.onActivitySaveInstanceState(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
