package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzca extends ContentObserver {
    zzca(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzcb.zze.set(true);
    }
}
