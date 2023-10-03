package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzlj;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final /* synthetic */ class zzhb implements Runnable {
    private final zzhc zza;
    private final Bundle zzb;

    zzhb(zzhc zzhc, Bundle bundle) {
        this.zza = zzhc;
        this.zzb = bundle;
    }

    public final void run() {
        zzhc zzhc = this.zza;
        Bundle bundle = this.zzb;
        if (zzlj.zzb() && zzhc.zzt().zza(zzas.zzcn)) {
            if (bundle == null) {
                zzhc.zzs().zzy.zza(new Bundle());
                return;
            }
            Bundle zza2 = zzhc.zzs().zzy.zza();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzhc.zzp();
                    if (zzko.zza(obj)) {
                        zzhc.zzp().zza(27, (String) null, (String) null, 0);
                    }
                    zzhc.zzr().zzk().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzko.zze(str)) {
                    zzhc.zzr().zzk().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    zza2.remove(str);
                } else if (zzhc.zzp().zza("param", str, 100, obj)) {
                    zzhc.zzp().zza(zza2, str, obj);
                }
            }
            zzhc.zzp();
            if (zzko.zza(zza2, zzhc.zzt().zze())) {
                zzhc.zzp().zza(26, (String) null, (String) null, 0);
                zzhc.zzr().zzk().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            zzhc.zzs().zzy.zza(zza2);
        }
    }
}
