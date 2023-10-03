package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
final class zzq implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ ActionCodeSettings zza;
    private final /* synthetic */ FirebaseUser zzb;

    zzq(FirebaseUser firebaseUser, ActionCodeSettings actionCodeSettings) {
        this.zzb = firebaseUser;
        this.zza = actionCodeSettings;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzb.zzc()).zza(this.zza, ((GetTokenResult) task.getResult()).getToken());
    }
}
