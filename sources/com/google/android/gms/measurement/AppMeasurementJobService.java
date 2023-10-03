package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzjl;
import com.google.android.gms.measurement.internal.zzjp;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public final class AppMeasurementJobService extends JobService implements zzjp {
    private zzjl<AppMeasurementJobService> zza;

    private final zzjl<AppMeasurementJobService> zza() {
        if (this.zza == null) {
            this.zza = new zzjl<>(this);
        }
        return this.zza;
    }

    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return zza().zza(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        return zza().zzb(intent);
    }

    public final void onRebind(Intent intent) {
        zza().zzc(intent);
    }

    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final void zza(Intent intent) {
    }
}
