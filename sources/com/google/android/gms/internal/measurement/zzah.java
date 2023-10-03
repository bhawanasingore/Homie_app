package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzah extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzp zze;
    private final /* synthetic */ zzac zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzah(zzac zzac, String str, String str2, zzp zzp) {
        super(zzac);
        this.zzf = zzac;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzp;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzf.zzr.getConditionalUserProperties(this.zzc, this.zzd, this.zze);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zze.zza((Bundle) null);
    }
}
