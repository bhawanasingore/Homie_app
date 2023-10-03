package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zziy implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzs zzc;
    private final /* synthetic */ zzin zzd;

    zziy(zzin zzin, zzaq zzaq, String str, zzs zzs) {
        this.zzd = zzin;
        this.zza = zzaq;
        this.zzb = str;
        this.zzc = zzs;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            zzel zzd2 = this.zzd.zzb;
            if (zzd2 == null) {
                this.zzd.zzr().zzf().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = zzd2.zza(this.zza, this.zzb);
            this.zzd.zzak();
            this.zzd.zzp().zza(this.zzc, bArr);
        } catch (RemoteException e) {
            this.zzd.zzr().zzf().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzp().zza(this.zzc, bArr);
        }
    }
}
