package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzec extends zzee {
    private int zza = 0;
    private final int zzb = this.zzc.zza();
    private final /* synthetic */ zzdz zzc;

    zzec(zzdz zzdz) {
        this.zzc = zzdz;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
