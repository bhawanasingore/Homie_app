package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public class zzfy {
    private static final zzev zza = zzev.zza();
    private zzdz zzb;
    private volatile zzgt zzc;
    private volatile zzdz zzd;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfy = (zzfy) obj;
        zzgt zzgt = this.zzc;
        zzgt zzgt2 = zzfy.zzc;
        if (zzgt == null && zzgt2 == null) {
            return zzc().equals(zzfy.zzc());
        }
        if (zzgt != null && zzgt2 != null) {
            return zzgt.equals(zzgt2);
        }
        if (zzgt != null) {
            return zzgt.equals(zzfy.zzb(zzgt.zzbt()));
        }
        return zzb(zzgt2.zzbt()).equals(zzgt2);
    }

    public int hashCode() {
        return 1;
    }

    private final zzgt zzb(zzgt zzgt) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzgt;
                        this.zzd = zzdz.zza;
                    } catch (zzft e) {
                        this.zzc = zzgt;
                        this.zzd = zzdz.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzgt zza(zzgt zzgt) {
        zzgt zzgt2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzgt;
        return zzgt2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbn();
        }
        return 0;
    }

    public final zzdz zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzdz zzdz = this.zzd;
                return zzdz;
            }
            if (this.zzc == null) {
                this.zzd = zzdz.zza;
            } else {
                this.zzd = this.zzc.zzbh();
            }
            zzdz zzdz2 = this.zzd;
            return zzdz2;
        }
    }
}
