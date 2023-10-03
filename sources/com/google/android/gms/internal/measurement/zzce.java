package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzce extends ContentObserver {
    private final /* synthetic */ zzcc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzce(zzcc zzcc, Handler handler) {
        super((Handler) null);
        this.zza = zzcc;
    }

    public final void onChange(boolean z) {
        this.zza.zzb();
    }
}
