package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
public final class zzet {
    public static final Api<zzeu> zza;
    private static final Api.ClientKey<zzef> zzb = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzef, zzeu> zzc;

    public static zzau zza(Context context, zzeu zzeu) {
        return new zzau(context, zzeu);
    }

    static {
        zzev zzev = new zzev();
        zzc = zzev;
        zza = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", zzev, zzb);
    }
}
