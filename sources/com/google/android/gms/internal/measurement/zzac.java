package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzha;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
public class zzac {
    private static volatile zzac zzb;
    private static Boolean zzh = null;
    /* access modifiers changed from: private */
    public static Boolean zzi = null;
    private static boolean zzj = false;
    private static Boolean zzk = null;
    private static String zzl = "use_dynamite_api";
    private static String zzm = "allow_remote_dynamite";
    private static boolean zzn = true;
    private static boolean zzo = false;
    protected final Clock zza;
    /* access modifiers changed from: private */
    public final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    /* access modifiers changed from: private */
    public List<Pair<zzha, zzb>> zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzp;
    private String zzq;
    /* access modifiers changed from: private */
    public zzr zzr;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    class zzd implements Application.ActivityLifecycleCallbacks {
        zzd() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzac.this.zza((zza) new zzbh(this, activity, bundle));
        }

        public final void onActivityStarted(Activity activity) {
            zzac.this.zza((zza) new zzbj(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzac.this.zza((zza) new zzbi(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzac.this.zza((zza) new zzbl(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzac.this.zza((zza) new zzbk(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzp zzp = new zzp();
            zzac.this.zza((zza) new zzbn(this, activity, zzp));
            Bundle zzb = zzp.zzb(50);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            zzac.this.zza((zza) new zzbm(this, activity));
        }
    }

    public static zzac zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    abstract class zza implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        zza(zzac zzac) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        public abstract void zza() throws RemoteException;

        zza(boolean z) {
            this.zza = zzac.this.zza.currentTimeMillis();
            this.zzb = zzac.this.zza.elapsedRealtime();
            this.zzc = z;
        }

        public void run() {
            if (zzac.this.zzp) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzac.this.zza(e, false, this.zzc);
                zzb();
            }
        }

        /* access modifiers changed from: protected */
        public void zzb() {
        }
    }

    public static zzac zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzac.class) {
                if (zzb == null) {
                    zzb = new zzac(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    static class zzb extends zzw {
        private final zzha zza;

        zzb(zzha zzha) {
            this.zza = zzha;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }

        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    static class zzc extends zzw {
        private final zzgx zza;

        zzc(zzgx zzgx) {
            this.zza = zzgx;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }

        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    public final AppMeasurementSdk zza() {
        return this.zze;
    }

    private zzac(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.zze = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!zzf(context) || zzk())) {
            this.zzq = null;
            this.zzp = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzq = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null ? true : z)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.zzq = str2;
        }
        zza((zza) new zzaf(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzd());
        }
    }

    private static boolean zzf(Context context) {
        try {
            if (new StringResourceValueReader(context).getString("google_app_id") != null) {
                return true;
            }
            return false;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        this.zzd.execute(zza2);
    }

    /* access modifiers changed from: protected */
    public final zzr zza(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (DynamiteModule.LoadingException e) {
                zza((Exception) e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzq.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    /* access modifiers changed from: private */
    public static int zzg(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static int zzh(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzp |= z;
        if (z) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", (Object) exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    private static boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public final void zza(zzgx zzgx) {
        zza((zza) new zzao(this, zzgx));
    }

    public final void zza(zzha zzha) {
        Preconditions.checkNotNull(zzha);
        zza((zza) new zzbb(this, zzha));
    }

    public final void zzb(zzha zzha) {
        Preconditions.checkNotNull(zzha);
        zza((zza) new zzbc(this, zzha));
    }

    public final void zza(String str, Bundle bundle) {
        zza((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, (Long) null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza((zza) new zzbf(this, l, str, str2, bundle, z, z2));
    }

    public final void zza(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zza(String str, String str2, Object obj) {
        zza(str, str2, obj, true);
    }

    private final void zza(String str, String str2, Object obj, boolean z) {
        zza((zza) new zzbe(this, str, str2, obj, z));
    }

    public final void zza(Bundle bundle) {
        zza((zza) new zzbg(this, bundle));
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza((zza) new zzae(this, str, str2, bundle));
    }

    public final List<Bundle> zzb(String str, String str2) {
        zzp zzp2 = new zzp();
        zza((zza) new zzah(this, str, str2, zzp2));
        List<Bundle> list = (List) zzp.zza(zzp2.zzb(5000), List.class);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public final void zza(String str) {
        zza((zza) new zzag(this, str));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza((zza) new zzaj(this, activity, str, str2));
    }

    public final void zza(boolean z) {
        zza((zza) new zzai(this, z));
    }

    public final void zzb() {
        zza((zza) new zzal(this));
    }

    public final void zza(long j) {
        zza((zza) new zzak(this, j));
    }

    public final void zzb(long j) {
        zza((zza) new zzan(this, j));
    }

    public final void zzb(String str) {
        zza((zza) new zzam(this, str));
    }

    public final void zzc(String str) {
        zza((zza) new zzap(this, str));
    }

    public final String zzc() {
        zzp zzp2 = new zzp();
        zza((zza) new zzar(this, zzp2));
        return zzp2.zza(500);
    }

    public final String zzd() {
        zzp zzp2 = new zzp();
        zza((zza) new zzaq(this, zzp2));
        return zzp2.zza(50);
    }

    public final long zze() {
        zzp zzp2 = new zzp();
        zza((zza) new zzat(this, zzp2));
        Long l = (Long) zzp.zza(zzp2.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final String zzf() {
        zzp zzp2 = new zzp();
        zza((zza) new zzas(this, zzp2));
        return zzp2.zza(500);
    }

    public final String zzg() {
        zzp zzp2 = new zzp();
        zza((zza) new zzav(this, zzp2));
        return zzp2.zza(500);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzp zzp2 = new zzp();
        zza((zza) new zzau(this, str, str2, z, zzp2));
        Bundle zzb2 = zzp2.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String str3 : zzb2.keySet()) {
            Object obj = zzb2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza((zza) new zzax(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzp zzp2 = new zzp();
        zza((zza) new zzaw(this, bundle, zzp2));
        if (z) {
            return zzp2.zzb(5000);
        }
        return null;
    }

    public final int zzd(String str) {
        zzp zzp2 = new zzp();
        zza((zza) new zzaz(this, str, zzp2));
        Integer num = (Integer) zzp.zza(zzp2.zzb(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String zzh() {
        zzp zzp2 = new zzp();
        zza((zza) new zzay(this, zzp2));
        return zzp2.zza(120000);
    }

    public final String zzi() {
        return this.zzq;
    }

    public final Object zza(int i) {
        zzp zzp2 = new zzp();
        zza((zza) new zzba(this, zzp2, i));
        return zzp.zza(zzp2.zzb(15000), Object.class);
    }

    public final void zzb(boolean z) {
        zza((zza) new zzbd(this, z));
    }

    /* access modifiers changed from: private */
    public static void zzi(Context context) {
        synchronized (zzac.class) {
            try {
                if (zzh != null && zzi != null) {
                    return;
                }
                if (zza(context, "app_measurement_internal_disable_startup_flags")) {
                    zzh = Boolean.valueOf(zzn);
                    zzi = false;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                zzh = Boolean.valueOf(sharedPreferences.getBoolean(zzl, zzn));
                zzi = Boolean.valueOf(sharedPreferences.getBoolean(zzm, false));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(zzl);
                edit.remove(zzm);
                edit.apply();
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                zzh = Boolean.valueOf(zzn);
                zzi = false;
            }
        }
    }

    public static boolean zzb(Context context) {
        zzi(context);
        synchronized (zzac.class) {
            if (!zzj) {
                try {
                    String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{"measurement.dynamite.enabled", ""});
                    if ("true".equals(str)) {
                        zzk = true;
                    } else if ("false".equals(str)) {
                        zzk = false;
                    } else {
                        zzk = null;
                    }
                    zzj = true;
                } catch (Exception e) {
                    try {
                        Log.e("FA", "Unable to call SystemProperties.get()", e);
                        zzk = null;
                    } finally {
                        zzj = true;
                    }
                }
            }
        }
        Boolean bool = zzk;
        if (bool == null) {
            bool = zzh;
        }
        return bool.booleanValue();
    }

    private static boolean zza(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean(str);
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
