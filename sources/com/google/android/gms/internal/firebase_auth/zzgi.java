package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzel;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
public final class zzgi implements zzel<zzgi, zzp.zzy> {
    private String zza;
    private String zzb;
    private long zzc;
    private String zzd;
    private boolean zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private String zzi;

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final long zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzi;
    }

    public final zzjx<zzp.zzy> zza() {
        return zzp.zzy.zzj();
    }

    public final /* synthetic */ zzel zza(zzjn zzjn) {
        if (zzjn instanceof zzp.zzy) {
            zzp.zzy zzy = (zzp.zzy) zzjn;
            this.zza = Strings.emptyToNull(zzy.zza());
            this.zzb = Strings.emptyToNull(zzy.zzb());
            this.zzc = zzy.zzc();
            this.zzd = Strings.emptyToNull(zzy.zzd());
            this.zze = zzy.zze();
            this.zzf = Strings.emptyToNull(zzy.zzf());
            this.zzg = Strings.emptyToNull(zzy.zzg());
            this.zzh = zzy.g_();
            this.zzi = zzy.zzi();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of verifyPhoneNumberResponse.");
    }
}
