package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.measurement.internal.zzha;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzbc extends zzac.zza {
    private final /* synthetic */ zzha zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbc(zzac zzac, zzha zzha) {
        super(zzac);
        this.zzd = zzac;
        this.zzc = zzha;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        Pair pair;
        int i = 0;
        while (true) {
            if (i >= this.zzd.zzf.size()) {
                pair = null;
                break;
            } else if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                pair = (Pair) this.zzd.zzf.get(i);
                break;
            } else {
                i++;
            }
        }
        if (pair == null) {
            Log.w(this.zzd.zzc, "OnEventListener had not been registered.");
            return;
        }
        this.zzd.zzr.unregisterOnMeasurementEventListener((zzx) pair.second);
        this.zzd.zzf.remove(pair);
    }
}
