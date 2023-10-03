package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final /* synthetic */ class zzjn implements Runnable {
    private final zzjl zza;
    private final zzet zzb;
    private final JobParameters zzc;

    zzjn(zzjl zzjl, zzet zzet, JobParameters jobParameters) {
        this.zza = zzjl;
        this.zzb = zzet;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
