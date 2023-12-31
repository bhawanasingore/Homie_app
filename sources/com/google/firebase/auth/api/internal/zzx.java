package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzga;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
final class zzx implements zzfp<zzga> {
    private final /* synthetic */ zzeg zza;
    private final /* synthetic */ zza zzb;

    zzx(zza zza2, zzeg zzeg) {
        this.zzb = zza2;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzga zzga = (zzga) obj;
        if (!zzga.zzo()) {
            this.zzb.zza(zzga, this.zza, (zzfq) this);
        } else if (this.zzb.zzc.zzb()) {
            this.zza.zza(new zzej(zzga.zzn(), zzga.zzm(), zzga.zzp()));
        } else {
            zza.zza.e("Need to do multi-factor auth, but SDK does not support it.", new Object[0]);
            zza("REQUIRES_SECOND_FACTOR_AUTH");
        }
    }
}
