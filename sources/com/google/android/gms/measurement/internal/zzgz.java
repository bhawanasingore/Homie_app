package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzaa;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzgz {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    zzaa zzg;
    boolean zzh = true;
    Long zzi;

    public zzgz(Context context, zzaa zzaa, Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzaa != null) {
            this.zzg = zzaa;
            this.zzb = zzaa.zzf;
            this.zzc = zzaa.zze;
            this.zzd = zzaa.zzd;
            this.zzh = zzaa.zzc;
            this.zzf = zzaa.zzb;
            if (zzaa.zzg != null) {
                this.zze = Boolean.valueOf(zzaa.zzg.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
