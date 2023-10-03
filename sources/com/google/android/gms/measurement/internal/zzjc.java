package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjc implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzy zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ zzy zze;
    private final /* synthetic */ zzin zzf;

    zzjc(zzin zzin, boolean z, boolean z2, zzy zzy, zzm zzm, zzy zzy2) {
        this.zzf = zzin;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzy;
        this.zzd = zzm;
        this.zze = zzy2;
    }

    public final void run() {
        zzel zzd2 = this.zzf.zzb;
        if (zzd2 == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzd2, (AbstractSafeParcelable) this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzd2.zza(this.zzc, this.zzd);
                } else {
                    zzd2.zza(this.zzc);
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzak();
    }
}
