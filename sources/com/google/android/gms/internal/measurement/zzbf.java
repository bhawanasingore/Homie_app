package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzbf extends zzac.zza {
    private final /* synthetic */ Long zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ boolean zzg;
    private final /* synthetic */ boolean zzh;
    private final /* synthetic */ zzac zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbf(zzac zzac, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzac);
        this.zzi = zzac;
        this.zzc = l;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bundle;
        this.zzg = z;
        this.zzh = z2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        Long l = this.zzc;
        this.zzi.zzr.logEvent(this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l == null ? this.zza : l.longValue());
    }
}
