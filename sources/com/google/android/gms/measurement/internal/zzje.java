package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzje implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ zzs zzd;
    private final /* synthetic */ zzin zze;

    zzje(zzin zzin, String str, String str2, zzm zzm, zzs zzs) {
        this.zze = zzin;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzm;
        this.zzd = zzs;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzel zzd2 = this.zze.zzb;
            if (zzd2 == null) {
                this.zze.zzr().zzf().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            arrayList = zzko.zzb(zzd2.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzak();
            this.zze.zzp().zza(this.zzd, arrayList);
        } catch (RemoteException e) {
            this.zze.zzr().zzf().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
        } finally {
            this.zze.zzp().zza(this.zzd, arrayList);
        }
    }
}
