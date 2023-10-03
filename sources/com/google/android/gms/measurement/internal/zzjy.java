package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzkm;
import com.google.android.gms.internal.measurement.zzks;
import com.google.android.gms.internal.measurement.zzkx;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzjy {
    private long zza;
    private long zzb;
    private final zzai zzc = new zzjx(this, this.zzd.zzz);
    private final /* synthetic */ zzjs zzd;

    public zzjy(zzjs zzjs) {
        this.zzd = zzjs;
        long elapsedRealtime = zzjs.zzm().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzd.zzd();
        this.zzc.zzc();
        this.zza = j;
        this.zzb = j;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzc();
        this.zza = 0;
        this.zzb = 0;
    }

    /* access modifiers changed from: private */
    public final void zzc() {
        this.zzd.zzd();
        zza(false, false, this.zzd.zzm().elapsedRealtime());
        this.zzd.zze().zza(this.zzd.zzm().elapsedRealtime());
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzd.zzd();
        this.zzd.zzw();
        if (!zzkm.zzb() || !this.zzd.zzt().zza(zzas.zzca)) {
            j = this.zzd.zzm().elapsedRealtime();
        }
        if (!zzks.zzb() || !this.zzd.zzt().zza(zzas.zzbw) || this.zzd.zzz.zzab()) {
            this.zzd.zzs().zzq.zza(this.zzd.zzm().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (this.zzd.zzt().zza(zzas.zzat) && !z2) {
                j2 = (!zzkx.zzb() || !this.zzd.zzt().zza(zzas.zzav) || !zzkm.zzb() || !this.zzd.zzt().zza(zzas.zzca)) ? zzb() : zzc(j);
            }
            this.zzd.zzr().zzx().zza("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzih.zza(this.zzd.zzi().zza(!this.zzd.zzt().zzj().booleanValue()), bundle, true);
            if (this.zzd.zzt().zza(zzas.zzat) && !this.zzd.zzt().zza(zzas.zzau) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.zzd.zzt().zza(zzas.zzau) || !z2) {
                this.zzd.zzf().zza("auto", "_e", bundle);
            }
            this.zza = j;
            this.zzc.zzc();
            this.zzc.zza(3600000);
            return true;
        }
        this.zzd.zzr().zzx().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long zzb() {
        long elapsedRealtime = this.zzd.zzm().elapsedRealtime();
        long j = elapsedRealtime - this.zzb;
        this.zzb = elapsedRealtime;
        return j;
    }

    /* access modifiers changed from: package-private */
    public final long zzc(long j) {
        long j2 = j - this.zzb;
        this.zzb = j;
        return j2;
    }
}
