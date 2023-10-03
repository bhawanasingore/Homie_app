package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final /* synthetic */ class zzcj {
    public static <V> V zza(zzci<V> zzci) {
        long clearCallingIdentity;
        try {
            return zzci.zza();
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zza = zzci.zza();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zza;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
