package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzau extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzp zzf;
    private final /* synthetic */ zzac zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(zzac zzac, String str, String str2, boolean z, zzp zzp) {
        super(zzac);
        this.zzg = zzac;
        this.zzc = str;
        this.zzd = str2;
        this.zze = z;
        this.zzf = zzp;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzg.zzr.getUserProperties(this.zzc, this.zzd, this.zze, this.zzf);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzf.zza((Bundle) null);
    }
}
