package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
final /* synthetic */ class zzcz implements RemoteCall {
    private final zzda zza;

    zzcz(zzda zzda) {
        this.zza = zzda;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zza((zzef) obj, (TaskCompletionSource) obj2);
    }
}
