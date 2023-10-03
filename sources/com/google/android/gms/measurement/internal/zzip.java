package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzip implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkn zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ zzin zzd;

    zzip(zzin zzin, boolean z, zzkn zzkn, zzm zzm) {
        this.zzd = zzin;
        this.zza = z;
        this.zzb = zzkn;
        this.zzc = zzm;
    }

    public final void run() {
        zzel zzd2 = this.zzd.zzb;
        if (zzd2 == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user property");
            return;
        }
        this.zzd.zza(zzd2, (AbstractSafeParcelable) this.zza ? null : this.zzb, this.zzc);
        this.zzd.zzak();
    }
}
