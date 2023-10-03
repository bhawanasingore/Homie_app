package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzjs extends zze {
    protected final zzka zza = new zzka(this);
    protected final zzjy zzb = new zzjy(this);
    /* access modifiers changed from: private */
    public Handler zzc;
    private final zzjt zzd = new zzjt(this);

    zzjs(zzfx zzfx) {
        super(zzfx);
    }

    /* access modifiers changed from: private */
    public final void zzab() {
        zzd();
        if (this.zzc == null) {
            this.zzc = new zzm(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: private */
    public final void zza(long j) {
        zzd();
        zzab();
        zzr().zzx().zza("Activity resumed, time", Long.valueOf(j));
        if (zzt().zza(zzas.zzcd)) {
            if (zzt().zzj().booleanValue() || zzs().zzs.zza()) {
                this.zzb.zza(j);
            }
            this.zzd.zza();
        } else {
            this.zzd.zza();
            if (zzt().zzj().booleanValue()) {
                this.zzb.zza(j);
            }
        }
        zzka zzka = this.zza;
        zzka.zza.zzd();
        if (zzka.zza.zzz.zzab()) {
            if (!zzka.zza.zzt().zza(zzas.zzcd)) {
                zzka.zza.zzs().zzs.zza(false);
            }
            zzka.zza(zzka.zza.zzm().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void zzb(long j) {
        zzd();
        zzab();
        zzr().zzx().zza("Activity paused, time", Long.valueOf(j));
        this.zzd.zza(j);
        if (zzt().zzj().booleanValue()) {
            this.zzb.zzb(j);
        }
        zzka zzka = this.zza;
        if (!zzka.zza.zzt().zza(zzas.zzcd)) {
            zzka.zza.zzs().zzs.zza(true);
        }
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.zza(z, z2, j);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhc zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzeq zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzin zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzih zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzep zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzjs zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzak zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzer zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzko zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfu zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzet zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzff zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzaa zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzv zzu() {
        return super.zzu();
    }
}
