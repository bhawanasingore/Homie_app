package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzaz extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzp zzd;
    private final /* synthetic */ zzac zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaz(zzac zzac, String str, zzp zzp) {
        super(zzac);
        this.zze = zzac;
        this.zzc = str;
        this.zzd = zzp;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zze.zzr.getMaxUserProperties(this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
