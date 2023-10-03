package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzff extends zzgr {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private SharedPreferences zzaa;
    private String zzab;
    private boolean zzac;
    private long zzad;
    public zzfm zzb;
    public final zzfj zzc = new zzfj(this, "last_upload", 0);
    public final zzfj zzd = new zzfj(this, "last_upload_attempt", 0);
    public final zzfj zze = new zzfj(this, "backoff", 0);
    public final zzfj zzf = new zzfj(this, "last_delete_stale", 0);
    public final zzfj zzg = new zzfj(this, "midnight_offset", 0);
    public final zzfj zzh = new zzfj(this, "first_open_time", 0);
    public final zzfj zzi = new zzfj(this, "app_install_time", 0);
    public final zzfl zzj = new zzfl(this, "app_instance_id", (String) null);
    public final zzfj zzk = new zzfj(this, "time_before_start", 10000);
    public final zzfj zzl = new zzfj(this, "session_timeout", 1800000);
    public final zzfh zzm = new zzfh(this, "start_new_session", true);
    public final zzfl zzn = new zzfl(this, "non_personalized_ads", (String) null);
    public final zzfh zzo = new zzfh(this, "use_dynamite_api", false);
    public final zzfh zzp = new zzfh(this, "allow_remote_dynamite", false);
    public final zzfj zzq = new zzfj(this, "last_pause_time", 0);
    public boolean zzr;
    public zzfh zzs = new zzfh(this, "app_backgrounded", false);
    public zzfh zzt = new zzfh(this, "deep_link_retrieval_complete", false);
    public zzfj zzu = new zzfj(this, "deep_link_retrieval_attempts", 0);
    public final zzfl zzv = new zzfl(this, "firebase_feature_rollouts", (String) null);
    public final zzfl zzw = new zzfl(this, "deferred_attribution_cache", (String) null);
    public final zzfj zzx = new zzfj(this, "deferred_attribution_cache_timestamp", 0);
    public final zzfk zzy = new zzfk(this, "default_event_parameters", (Bundle) null);

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> zza(String str) {
        zzd();
        long elapsedRealtime = zzm().elapsedRealtime();
        if (this.zzab != null && elapsedRealtime < this.zzad) {
            return new Pair<>(this.zzab, Boolean.valueOf(this.zzac));
        }
        this.zzad = elapsedRealtime + zzt().zza(str, zzas.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzn());
            if (advertisingIdInfo != null) {
                this.zzab = advertisingIdInfo.getId();
                this.zzac = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzab == null) {
                this.zzab = "";
            }
        } catch (Exception e) {
            zzr().zzw().zza("Unable to get advertising id", e);
            this.zzab = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzab, Boolean.valueOf(this.zzac));
    }

    /* access modifiers changed from: package-private */
    public final String zzb(String str) {
        zzd();
        String str2 = (String) zza(str).first;
        MessageDigest zzi2 = zzko.zzi();
        if (zzi2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzi2.digest(str2.getBytes()))});
    }

    zzff(zzfx zzfx) {
        super(zzfx);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void f_() {
        SharedPreferences sharedPreferences = zzn().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzaa = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzr = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzaa.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzfm(this, "health_monitor", Math.max(0, zzas.zzb.zza(null).longValue()));
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences zzg() {
        zzd();
        zzaa();
        return this.zzaa;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final String zzh() {
        zzd();
        return zzg().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final String zzi() {
        zzd();
        return zzg().getString("admob_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzj() {
        zzd();
        if (!zzg().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzg().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        zzd();
        Boolean zzv2 = zzv();
        SharedPreferences.Editor edit = zzg().edit();
        edit.clear();
        edit.apply();
        if (zzv2 != null) {
            zzb(zzv2.booleanValue());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(boolean z) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzv() {
        zzd();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final String zzw() {
        zzd();
        String string = zzg().getString("previous_os_version", (String) null);
        zzl().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzg().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(boolean z) {
        zzd();
        zzr().zzx().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zzaa.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzq.zza();
    }
}
