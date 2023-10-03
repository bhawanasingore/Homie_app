package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzcq;
import com.google.android.gms.internal.measurement.zzka;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public class zzfx implements zzgu {
    private static volatile zzfx zzb;
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    private Boolean zzad;
    private Boolean zzae;
    private int zzaf;
    private AtomicInteger zzag = new AtomicInteger(0);
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzv zzh;
    private final zzaa zzi;
    private final zzff zzj;
    private final zzet zzk;
    private final zzfu zzl;
    private final zzjs zzm;
    private final zzko zzn;
    private final zzer zzo;
    private final Clock zzp;
    private final zzih zzq;
    private final zzhc zzr;
    private final zzb zzs;
    private final zzic zzt;
    private zzep zzu;
    private zzin zzv;
    private zzak zzw;
    private zzeq zzx;
    private zzfo zzy;
    private boolean zzz = false;

    private zzfx(zzgz zzgz) {
        long j;
        boolean z = false;
        Preconditions.checkNotNull(zzgz);
        zzv zzv2 = new zzv(zzgz.zza);
        this.zzh = zzv2;
        zzej.zza = zzv2;
        this.zzc = zzgz.zza;
        this.zzd = zzgz.zzb;
        this.zze = zzgz.zzc;
        this.zzf = zzgz.zzd;
        this.zzg = zzgz.zzh;
        this.zzac = zzgz.zze;
        zzaa zzaa2 = zzgz.zzg;
        if (!(zzaa2 == null || zzaa2.zzg == null)) {
            Object obj = zzaa2.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzaa2.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        zzcq.zza(this.zzc);
        this.zzp = DefaultClock.getInstance();
        if (zzgz.zzi != null) {
            j = zzgz.zzi.longValue();
        } else {
            j = this.zzp.currentTimeMillis();
        }
        this.zza = j;
        this.zzi = new zzaa(this);
        zzff zzff = new zzff(this);
        zzff.zzab();
        this.zzj = zzff;
        zzet zzet = new zzet(this);
        zzet.zzab();
        this.zzk = zzet;
        zzko zzko = new zzko(this);
        zzko.zzab();
        this.zzn = zzko;
        zzer zzer = new zzer(this);
        zzer.zzab();
        this.zzo = zzer;
        this.zzs = new zzb(this);
        zzih zzih = new zzih(this);
        zzih.zzx();
        this.zzq = zzih;
        zzhc zzhc = new zzhc(this);
        zzhc.zzx();
        this.zzr = zzhc;
        zzjs zzjs = new zzjs(this);
        zzjs.zzx();
        this.zzm = zzjs;
        zzic zzic = new zzic(this);
        zzic.zzab();
        this.zzt = zzic;
        zzfu zzfu = new zzfu(this);
        zzfu.zzab();
        this.zzl = zzfu;
        if (!(zzgz.zzg == null || zzgz.zzg.zzb == 0)) {
            z = true;
        }
        boolean z2 = !z;
        if (this.zzc.getApplicationContext() instanceof Application) {
            zzhc zzh2 = zzh();
            if (zzh2.zzn().getApplicationContext() instanceof Application) {
                Application application = (Application) zzh2.zzn().getApplicationContext();
                if (zzh2.zza == null) {
                    zzh2.zza = new zzhx(zzh2, (zzhd) null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzh2.zza);
                    application.registerActivityLifecycleCallbacks(zzh2.zza);
                    zzh2.zzr().zzx().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzr().zzi().zza("Application context is not an Application");
        }
        this.zzl.zza((Runnable) new zzfz(this, zzgz));
    }

    /* access modifiers changed from: private */
    public final void zza(zzgz zzgz) {
        zzev zzev;
        String str;
        zzq().zzd();
        zzak zzak = new zzak(this);
        zzak.zzab();
        this.zzw = zzak;
        zzeq zzeq = new zzeq(this, zzgz.zzf);
        zzeq.zzx();
        this.zzx = zzeq;
        zzep zzep = new zzep(this);
        zzep.zzx();
        this.zzu = zzep;
        zzin zzin = new zzin(this);
        zzin.zzx();
        this.zzv = zzin;
        this.zzn.zzac();
        this.zzj.zzac();
        this.zzy = new zzfo(this);
        this.zzx.zzy();
        zzr().zzv().zza("App measurement initialized, version", Long.valueOf(this.zzi.zzf()));
        zzr().zzv().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzab2 = zzeq.zzab();
        if (TextUtils.isEmpty(this.zzd)) {
            if (zzi().zzf(zzab2)) {
                zzev = zzr().zzv();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzev zzv2 = zzr().zzv();
                String valueOf = String.valueOf(zzab2);
                zzev zzev2 = zzv2;
                str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzev = zzev2;
            }
            zzev.zza(str);
        }
        zzr().zzw().zza("Debug-level message logging enabled");
        if (this.zzaf != this.zzag.get()) {
            zzr().zzf().zza("Not all components initialized", Integer.valueOf(this.zzaf), Integer.valueOf(this.zzag.get()));
        }
        this.zzz = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        zzq().zzd();
        if (zzc().zzc.zza() == 0) {
            zzc().zzc.zza(this.zzp.currentTimeMillis());
        }
        if (Long.valueOf(zzc().zzh.zza()).longValue() == 0) {
            zzr().zzx().zza("Persisting first open", Long.valueOf(this.zza));
            zzc().zzh.zza(this.zza);
        }
        if (this.zzi.zza(zzas.zzcp)) {
            zzh().zzb.zzb();
        }
        if (zzag()) {
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                zzi();
                if (zzko.zza(zzy().zzac(), zzc().zzh(), zzy().zzad(), zzc().zzi())) {
                    zzr().zzv().zza("Rechecking which service to use due to a GMP App Id change");
                    zzc().zzk();
                    zzk().zzab();
                    this.zzv.zzah();
                    this.zzv.zzaf();
                    zzc().zzh.zza(this.zza);
                    zzc().zzj.zza((String) null);
                }
                zzc().zzc(zzy().zzac());
                zzc().zzd(zzy().zzad());
            }
            zzh().zza(zzc().zzj.zza());
            if (zzka.zzb() && this.zzi.zza(zzas.zzbv) && !zzi().zzv() && !TextUtils.isEmpty(zzc().zzv.zza())) {
                zzr().zzi().zza("Remote config removed with active feature rollouts");
                zzc().zzv.zza((String) null);
            }
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                boolean zzab2 = zzab();
                if (!zzc().zzx() && !this.zzi.zzh()) {
                    zzc().zzc(!zzab2);
                }
                if (zzab2) {
                    zzh().zzai();
                }
                zze().zza.zza();
                zzw().zza((AtomicReference<String>) new AtomicReference());
            }
        } else if (zzab()) {
            if (!zzi().zzd("android.permission.INTERNET")) {
                zzr().zzf().zza("App is missing INTERNET permission");
            }
            if (!zzi().zzd("android.permission.ACCESS_NETWORK_STATE")) {
                zzr().zzf().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zzc).isCallerInstantApp() && !this.zzi.zzy()) {
                if (!zzfp.zza(this.zzc)) {
                    zzr().zzf().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzko.zza(this.zzc, false)) {
                    zzr().zzf().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzr().zzf().zza("Uploading is not possible. App measurement disabled");
        }
        zzc().zzo.zza(this.zzi.zza(zzas.zzaz));
        zzc().zzp.zza(this.zzi.zza(zzas.zzba));
    }

    public final zzv zzu() {
        return this.zzh;
    }

    public final zzaa zzb() {
        return this.zzi;
    }

    public final zzff zzc() {
        zza((zzgs) this.zzj);
        return this.zzj;
    }

    public final zzet zzr() {
        zzb((zzgr) this.zzk);
        return this.zzk;
    }

    public final zzet zzd() {
        zzet zzet = this.zzk;
        if (zzet == null || !zzet.zzz()) {
            return null;
        }
        return this.zzk;
    }

    public final zzfu zzq() {
        zzb((zzgr) this.zzl);
        return this.zzl;
    }

    public final zzjs zze() {
        zzb((zze) this.zzm);
        return this.zzm;
    }

    public final zzfo zzf() {
        return this.zzy;
    }

    /* access modifiers changed from: package-private */
    public final zzfu zzg() {
        return this.zzl;
    }

    public final zzhc zzh() {
        zzb((zze) this.zzr);
        return this.zzr;
    }

    public final zzko zzi() {
        zza((zzgs) this.zzn);
        return this.zzn;
    }

    public final zzer zzj() {
        zza((zzgs) this.zzo);
        return this.zzo;
    }

    public final zzep zzk() {
        zzb((zze) this.zzu);
        return this.zzu;
    }

    private final zzic zzai() {
        zzb((zzgr) this.zzt);
        return this.zzt;
    }

    public final Context zzn() {
        return this.zzc;
    }

    public final boolean zzl() {
        return TextUtils.isEmpty(this.zzd);
    }

    public final String zzo() {
        return this.zzd;
    }

    public final String zzp() {
        return this.zze;
    }

    public final String zzs() {
        return this.zzf;
    }

    public final boolean zzt() {
        return this.zzg;
    }

    public final Clock zzm() {
        return this.zzp;
    }

    public final zzih zzv() {
        zzb((zze) this.zzq);
        return this.zzq;
    }

    public final zzin zzw() {
        zzb((zze) this.zzv);
        return this.zzv;
    }

    public final zzak zzx() {
        zzb((zzgr) this.zzw);
        return this.zzw;
    }

    public final zzeq zzy() {
        zzb((zze) this.zzx);
        return this.zzx;
    }

    public final zzb zzz() {
        zzb zzb2 = this.zzs;
        if (zzb2 != null) {
            return zzb2;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzfx zza(Context context, String str, String str2, Bundle bundle) {
        return zza(context, new zzaa(0, 0, true, (String) null, (String) null, (String) null, bundle), (Long) null);
    }

    public static zzfx zza(Context context, zzaa zzaa2, Long l) {
        if (zzaa2 != null && (zzaa2.zze == null || zzaa2.zzf == null)) {
            zzaa2 = new zzaa(zzaa2.zza, zzaa2.zzb, zzaa2.zzc, zzaa2.zzd, (String) null, (String) null, zzaa2.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzfx.class) {
                if (zzb == null) {
                    zzb = new zzfx(new zzgz(context, zzaa2, l));
                }
            }
        } else if (!(zzaa2 == null || zzaa2.zzg == null || !zzaa2.zzg.containsKey("dataCollectionDefaultEnabled"))) {
            zzb.zza(zzaa2.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzb;
    }

    private static void zzb(zzgr zzgr) {
        if (zzgr == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgr.zzz()) {
            String valueOf = String.valueOf(zzgr.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zzb(zze zze2) {
        if (zze2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zze2.zzv()) {
            String valueOf = String.valueOf(zze2.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zza(zzgs zzgs) {
        if (zzgs == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    public final boolean zzaa() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    public final boolean zzab() {
        return zzac() == 0;
    }

    public final int zzac() {
        zzq().zzd();
        if (this.zzi.zzh()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        Boolean zzv2 = zzc().zzv();
        if (zzv2 == null) {
            zzaa zzaa2 = this.zzi;
            zzaa2.zzu();
            Boolean zzd2 = zzaa2.zzd("firebase_analytics_collection_enabled");
            if (zzd2 == null) {
                Boolean bool2 = this.zzad;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                    return 6;
                } else {
                    if (!this.zzi.zza(zzas.zzas) || this.zzac == null || this.zzac.booleanValue()) {
                        return 0;
                    }
                    return 7;
                }
            } else if (zzd2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzv2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzad() {
    }

    /* access modifiers changed from: package-private */
    public final void zzae() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgr zzgr) {
        this.zzaf++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zze zze2) {
        this.zzaf++;
    }

    /* access modifiers changed from: package-private */
    public final void zzaf() {
        this.zzag.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public final boolean zzag() {
        if (this.zzz) {
            zzq().zzd();
            Boolean bool = this.zzaa;
            if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
                this.zzab = this.zzp.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzi().zzd("android.permission.INTERNET") && zzi().zzd("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzy() || (zzfp.zza(this.zzc) && zzko.zza(this.zzc, false))));
                this.zzaa = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzi().zza(zzy().zzac(), zzy().zzad(), zzy().zzae()) && TextUtils.isEmpty(zzy().zzad())) {
                        z = false;
                    }
                    this.zzaa = Boolean.valueOf(z);
                }
            }
            return this.zzaa.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    public final void zzah() {
        zzq().zzd();
        zzb((zzgr) zzai());
        String zzab2 = zzy().zzab();
        Pair<String, Boolean> zza2 = zzc().zza(zzab2);
        if (!this.zzi.zzi().booleanValue() || ((Boolean) zza2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza2.first)) {
            zzr().zzw().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!zzai().zzg()) {
            zzr().zzi().zza("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            zzko zzi2 = zzi();
            URL zza3 = zzi2.zza(zzy().zzt().zzf(), zzab2, (String) zza2.first, zzc().zzu.zza() - 1);
            zzic zzai = zzai();
            zzga zzga = new zzga(this);
            zzai.zzd();
            zzai.zzaa();
            Preconditions.checkNotNull(zza3);
            Preconditions.checkNotNull(zzga);
            zzai.zzq().zzb((Runnable) new zzie(zzai, zzab2, zza3, (byte[]) null, (Map<String, String>) null, zzga));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzr().zzi().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzc().zzt.zza(true);
        if (bArr.length == 0) {
            zzr().zzw().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                zzr().zzw().zza("Deferred Deep Link is empty.");
                return;
            }
            zzko zzi2 = zzi();
            zzi2.zzb();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzi2.zzn().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzr().zzi().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zza("auto", "_cmp", bundle);
            zzko zzi3 = zzi();
            if (!TextUtils.isEmpty(optString) && zzi3.zza(optString, optDouble)) {
                zzi3.zzn().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            zzr().zzf().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
