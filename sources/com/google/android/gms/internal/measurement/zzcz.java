package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzcz implements zzcg {
    private static final Map<String, zzcz> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc = new zzcy(this);
    private final Object zzd = new Object();
    private volatile Map<String, ?> zze;
    private final List<zzch> zzf = new ArrayList();

    static zzcz zza(Context context, String str) {
        boolean z;
        zzcz zzcz;
        if (!zzcd.zza() || str.startsWith("direct_boot:")) {
            z = true;
        } else {
            z = zzcd.zza(context);
        }
        if (!z) {
            return null;
        }
        synchronized (zzcz.class) {
            zzcz = zza.get(str);
            if (zzcz == null) {
                zzcz = new zzcz(zzb(context, str));
                zza.put(str, zzcz);
            }
        }
        return zzcz;
    }

    private static SharedPreferences zzb(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzcd.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private zzcz(SharedPreferences sharedPreferences) {
        this.zzb = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.zzc);
    }

    /* JADX INFO: finally extract failed */
    public final Object zza(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zze = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void zza() {
        synchronized (zzcz.class) {
            for (zzcz next : zza.values()) {
                next.zzb.unregisterOnSharedPreferenceChangeListener(next.zzc);
            }
            zza.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzcq.zza();
        }
        synchronized (this) {
            for (zzch zza2 : this.zzf) {
                zza2.zza();
            }
        }
    }
}
