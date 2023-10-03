package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzbh extends zzac.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ Bundle zzd;
    private final /* synthetic */ zzac.zzd zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbh(zzac.zzd zzd2, Activity activity, Bundle bundle) {
        super(zzac.this);
        this.zze = zzd2;
        this.zzc = activity;
        this.zzd = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzac.this.zzr.onActivityCreated(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
