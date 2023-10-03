package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzkm;
import com.google.android.gms.internal.measurement.zzkx;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzih extends zze {
    protected zzii zza;
    private volatile zzii zzb;
    private zzii zzc;
    private final Map<Activity, zzii> zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile zzii zzf;
    /* access modifiers changed from: private */
    public zzii zzg;
    private boolean zzh;
    private final Object zzi = new Object();
    private zzii zzj;
    private String zzk;

    public zzih(zzfx zzfx) {
        super(zzfx);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final zzii zza(boolean z) {
        zzw();
        zzd();
        if (!zzt().zza(zzas.zzcd) || !z) {
            return this.zza;
        }
        zzii zzii = this.zza;
        return zzii != null ? zzii : this.zzg;
    }

    public final void zza(Activity activity, String str, String str2) {
        if (!zzt().zzj().booleanValue()) {
            zzr().zzk().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
        } else if (this.zzb == null) {
            zzr().zzk().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzr().zzk().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean zzc2 = zzko.zzc(this.zzb.zzb, str2);
            boolean zzc3 = zzko.zzc(this.zzb.zza, str);
            if (zzc2 && zzc3) {
                zzr().zzk().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzr().zzk().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzr().zzx().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzii zzii = new zzii(str, str2, zzp().zzg());
                this.zzd.put(activity, zzii);
                zza(activity, zzii, true);
            } else {
                zzr().zzk().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final zzii zzab() {
        zzb();
        return this.zzb;
    }

    private final void zza(Activity activity, zzii zzii, boolean z) {
        zzii zzii2;
        zzii zzii3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzii.zzb == null) {
            zzii2 = new zzii(zzii.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zzii.zzc, zzii.zze);
        } else {
            zzii2 = zzii;
        }
        this.zzc = this.zzb;
        this.zzb = zzii2;
        zzq().zza((Runnable) new zzik(this, zzii2, zzii3, zzm().elapsedRealtime(), z));
    }

    /* access modifiers changed from: private */
    public final void zza(zzii zzii, zzii zzii2, long j, boolean z, Bundle bundle) {
        boolean z2;
        long j2;
        zzii zzii3;
        zzd();
        boolean z3 = false;
        if (zzt().zza(zzas.zzat)) {
            z2 = z && this.zza != null;
            if (z2) {
                zza(this.zza, true, j);
            }
        } else {
            if (z && (zzii3 = this.zza) != null) {
                zza(zzii3, true, j);
            }
            z2 = false;
        }
        if (zzii2 == null || zzii2.zzc != zzii.zzc || !zzko.zzc(zzii2.zzb, zzii.zzb) || !zzko.zzc(zzii2.zza, zzii.zza)) {
            z3 = true;
        }
        if (z3) {
            Bundle bundle2 = new Bundle();
            if (zzt().zza(zzas.zzcd)) {
                bundle2 = new Bundle();
            }
            zza(zzii, bundle2, true);
            if (zzii2 != null) {
                if (zzii2.zza != null) {
                    bundle2.putString("_pn", zzii2.zza);
                }
                if (zzii2.zzb != null) {
                    bundle2.putString("_pc", zzii2.zzb);
                }
                bundle2.putLong("_pi", zzii2.zzc);
            }
            if (zzt().zza(zzas.zzat) && z2) {
                if (!zzkx.zzb() || !zzt().zza(zzas.zzav) || !zzkm.zzb() || !zzt().zza(zzas.zzca)) {
                    j2 = zzk().zzb.zzb();
                } else {
                    j2 = zzk().zzb.zzc(j);
                }
                if (j2 > 0) {
                    zzp().zza(bundle2, j2);
                }
            }
            String str = "auto";
            if (zzt().zza(zzas.zzcd)) {
                if (!zzt().zzj().booleanValue()) {
                    bundle2.putLong("_mt", 1);
                }
                if (zzii.zze) {
                    str = "app";
                }
            }
            zzf().zzb(str, "_vs", bundle2);
        }
        this.zza = zzii;
        if (zzt().zza(zzas.zzcd) && zzii.zze) {
            this.zzg = zzii;
        }
        zzh().zza(zzii);
    }

    /* access modifiers changed from: private */
    public final void zza(zzii zzii, boolean z, long j) {
        zze().zza(zzm().elapsedRealtime());
        if (zzk().zza(zzii != null && zzii.zzd, z, j) && zzii != null) {
            zzii.zzd = false;
        }
    }

    public static void zza(zzii zzii, Bundle bundle, boolean z) {
        if (bundle != null && zzii != null && (!bundle.containsKey("_sc") || z)) {
            if (zzii.zza != null) {
                bundle.putString("_sn", zzii.zza);
            } else {
                bundle.remove("_sn");
            }
            if (zzii.zzb != null) {
                bundle.putString("_sc", zzii.zzb);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", zzii.zzc);
        } else if (bundle != null && zzii == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void zza(String str, zzii zzii) {
        zzd();
        synchronized (this) {
            if (this.zzk == null || this.zzk.equals(str) || zzii != null) {
                this.zzk = str;
                this.zzj = zzii;
            }
        }
    }

    private static String zza(String str) {
        String str2;
        String[] split = str.split("\\.");
        if (split.length > 0) {
            str2 = split[split.length - 1];
        } else {
            str2 = "";
        }
        if (str2.length() > 100) {
            return str2.substring(0, 100);
        }
        return str2;
    }

    private final zzii zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzii zzii = this.zzd.get(activity);
        if (zzii == null) {
            zzii zzii2 = new zzii((String) null, zza(activity.getClass().getCanonicalName()), zzp().zzg());
            this.zzd.put(activity, zzii2);
            zzii = zzii2;
        }
        if (!zzt().zza(zzas.zzcd)) {
            return zzii;
        }
        return zzii;
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (zzt().zzj().booleanValue() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzii(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zza(Activity activity) {
        if (zzt().zza(zzas.zzcd)) {
            synchronized (this.zzi) {
                this.zzh = true;
                if (activity != this.zze) {
                    synchronized (this.zzi) {
                        this.zze = activity;
                    }
                    if (zzt().zza(zzas.zzcc) && zzt().zzj().booleanValue()) {
                        this.zzf = null;
                        zzq().zza((Runnable) new zzio(this));
                    }
                }
            }
        }
        if (!zzt().zza(zzas.zzcc) || zzt().zzj().booleanValue()) {
            zza(activity, zzd(activity), false);
            zzb zze2 = zze();
            zze2.zzq().zza((Runnable) new zzc(zze2, zze2.zzm().elapsedRealtime()));
            return;
        }
        this.zzb = this.zzf;
        zzq().zza((Runnable) new zzij(this));
    }

    public final void zzb(Activity activity) {
        if (zzt().zza(zzas.zzcd)) {
            synchronized (this.zzi) {
                this.zzh = false;
            }
        }
        if (!zzt().zza(zzas.zzcc) || zzt().zzj().booleanValue()) {
            zzii zzd2 = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzq().zza((Runnable) new zzil(this, zzd2, zzm().elapsedRealtime()));
            return;
        }
        this.zzb = null;
        zzq().zza((Runnable) new zzim(this));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzii zzii;
        if (zzt().zzj().booleanValue() && bundle != null && (zzii = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzii.zzc);
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzii.zza);
            bundle2.putString("referrer_name", zzii.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void zzc(Activity activity) {
        synchronized (this.zzi) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zzt().zzj().booleanValue()) {
            this.zzd.remove(activity);
        }
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
