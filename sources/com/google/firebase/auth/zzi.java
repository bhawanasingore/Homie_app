package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
final class zzi implements Runnable {
    private final /* synthetic */ InternalTokenResult zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzi(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.zzb = firebaseAuth;
        this.zza = internalTokenResult;
    }

    public final void run() {
        for (IdTokenListener onIdTokenChanged : this.zzb.zzc) {
            onIdTokenChanged.onIdTokenChanged(this.zza);
        }
        for (FirebaseAuth.IdTokenListener onIdTokenChanged2 : this.zzb.zzb) {
            onIdTokenChanged2.onIdTokenChanged(this.zzb);
        }
    }
}
