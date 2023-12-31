package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zza;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
final class zzaw extends zzfe<Void, zza> {
    private final zzbw zza;

    public zzaw(String str, String str2) {
        super(7);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = new zzbw(str, str2);
    }

    public final String zza() {
        return "applyActionCode";
    }

    public final TaskApiCall<zzef, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzav(this)).build();
    }

    public final void zze() {
        zzb(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        if (this.zzu) {
            zzef.zza().zzj(this.zza.zza(), this.zzc);
        } else {
            zzef.zza().zza(this.zza, (zzeo) this.zzc);
        }
    }
}
