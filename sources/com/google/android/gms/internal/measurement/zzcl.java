package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzcl implements zzcg {
    private static zzcl zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    static zzcl zza(Context context) {
        zzcl zzcl;
        synchronized (zzcl.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcl(context) : new zzcl();
            }
            zzcl = zza;
        }
        return zzcl;
    }

    private zzcl(Context context) {
        this.zzb = context;
        this.zzc = new zzcn(this, (Handler) null);
        context.getContentResolver().registerContentObserver(zzcb.zza, true, this.zzc);
    }

    private zzcl() {
        this.zzb = null;
        this.zzc = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zza(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzcj.zza(new zzck(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    static synchronized void zza() {
        synchronized (zzcl.class) {
            if (!(zza == null || zza.zzb == null || zza.zzc == null)) {
                zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzb(String str) {
        return zzcb.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
