package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzhl implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhc zzb;

    zzhl(zzhc zzhc, Bundle bundle) {
        this.zzb = zzhc;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
