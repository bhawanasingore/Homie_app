package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzcc implements zzcg {
    private static final Map<Uri, zzcc> zza = new ArrayMap();
    private static final String[] zzh = {"key", "value"};
    private final ContentResolver zzb;
    private final Uri zzc;
    private final ContentObserver zzd = new zzce(this, (Handler) null);
    private final Object zze = new Object();
    private volatile Map<String, String> zzf;
    private final List<zzch> zzg = new ArrayList();

    private zzcc(ContentResolver contentResolver, Uri uri) {
        this.zzb = contentResolver;
        this.zzc = uri;
        contentResolver.registerContentObserver(uri, false, this.zzd);
    }

    public static zzcc zza(ContentResolver contentResolver, Uri uri) {
        zzcc zzcc;
        synchronized (zzcc.class) {
            zzcc = zza.get(uri);
            if (zzcc == null) {
                try {
                    zzcc zzcc2 = new zzcc(contentResolver, uri);
                    try {
                        zza.put(uri, zzcc2);
                        zzcc = zzcc2;
                    } catch (SecurityException e) {
                        zzcc = zzcc2;
                    }
                } catch (SecurityException e2) {
                }
            }
        }
        return zzcc;
    }

    public final Map<String, String> zza() {
        Map<String, String> map = this.zzf;
        if (map == null) {
            synchronized (this.zze) {
                map = this.zzf;
                if (map == null) {
                    map = zze();
                    this.zzf = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zzb() {
        synchronized (this.zze) {
            this.zzf = null;
            zzcq.zza();
        }
        synchronized (this) {
            for (zzch zza2 : this.zzg) {
                zza2.zza();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Map<String, String> map = (Map) zzcj.zza(new zzcf(this));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return map;
        } catch (SQLiteException | IllegalStateException | SecurityException e) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return null;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    static synchronized void zzc() {
        synchronized (zzcc.class) {
            for (zzcc next : zza.values()) {
                next.zzb.unregisterContentObserver(next.zzd);
            }
            zza.clear();
        }
    }

    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map zzd() {
        Map map;
        Cursor query = this.zzb.query(this.zzc, zzh, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }
}
