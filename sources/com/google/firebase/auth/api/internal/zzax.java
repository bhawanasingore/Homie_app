package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
final /* synthetic */ class zzax implements RemoteCall {
    private final zzay zza;

    zzax(zzay zzay) {
        this.zza = zzay;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zza((zzef) obj, (TaskCompletionSource) obj2);
    }
}
