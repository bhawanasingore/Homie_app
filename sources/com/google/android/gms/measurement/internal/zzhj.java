package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzks;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzhj implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhc zzb;

    zzhj(zzhc zzhc, long j) {
        this.zzb = zzhc;
        this.zza = j;
    }

    public final void run() {
        zzhc zzhc = this.zzb;
        long j = this.zza;
        zzhc.zzd();
        zzhc.zzb();
        zzhc.zzw();
        zzhc.zzr().zzw().zza("Resetting analytics data (FE)");
        zzjs zzk = zzhc.zzk();
        zzk.zzd();
        zzk.zzb.zza();
        boolean zzab = zzhc.zzz.zzab();
        zzff zzs = zzhc.zzs();
        zzs.zzh.zza(j);
        if (!TextUtils.isEmpty(zzs.zzs().zzv.zza())) {
            zzs.zzv.zza((String) null);
        }
        if (zzks.zzb() && zzs.zzt().zza(zzas.zzbw)) {
            zzs.zzq.zza(0);
        }
        if (!zzs.zzt().zzh()) {
            zzs.zzc(!zzab);
        }
        zzs.zzw.zza((String) null);
        zzs.zzx.zza(0);
        zzs.zzy.zza((Bundle) null);
        zzhc.zzh().zzad();
        if (zzks.zzb() && zzhc.zzt().zza(zzas.zzbw)) {
            zzhc.zzk().zza.zza();
        }
        zzhc.zzc = !zzab;
        this.zzb.zzh().zza((AtomicReference<String>) new AtomicReference());
    }
}
