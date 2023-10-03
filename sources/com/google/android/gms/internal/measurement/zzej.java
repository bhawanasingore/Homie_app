package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
class zzej extends zzek {
    protected final byte[] zzb;

    zzej(byte[] bArr) {
        if (bArr != null) {
            this.zzb = bArr;
            return;
        }
        throw null;
    }

    public byte zza(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zzb[i];
    }

    public int zza() {
        return this.zzb.length;
    }

    public final zzdz zza(int i, int i2) {
        int zzb2 = zzb(0, i2, zza());
        if (zzb2 == 0) {
            return zzdz.zza;
        }
        return new zzeg(this.zzb, zze(), zzb2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzea zzea) throws IOException {
        zzea.zza(this.zzb, zze(), zza());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    public final boolean zzc() {
        int zze = zze();
        return zzij.zza(this.zzb, zze, zza() + zze);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdz) || zza() != ((zzdz) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzej)) {
            return obj.equals(this);
        }
        zzej zzej = (zzej) obj;
        int zzd = zzd();
        int zzd2 = zzej.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzej, 0, zza());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzdz zzdz, int i, int i2) {
        if (i2 > zzdz.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdz.zza()) {
            int zza2 = zzdz.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzdz instanceof zzej)) {
            return zzdz.zza(0, i2).equals(zza(0, i2));
        } else {
            zzej zzej = (zzej) zzdz;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzej.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzej.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzfk.zza(i, this.zzb, zze(), i3);
    }

    /* access modifiers changed from: protected */
    public int zze() {
        return 0;
    }
}
