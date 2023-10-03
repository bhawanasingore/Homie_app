package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzic extends zzia<zzid, zzid> {
    zzic() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzhj zzhj) {
        return false;
    }

    private static void zza(Object obj, zzid zzid) {
        ((zzfi) obj).zzb = zzid;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object obj) {
        ((zzfi) obj).zzb.zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzf(Object obj) {
        return ((zzid) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zze(Object obj) {
        return ((zzid) obj).zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj, Object obj2) {
        zzid zzid = (zzid) obj;
        zzid zzid2 = (zzid) obj2;
        if (zzid2.equals(zzid.zza())) {
            return zzid;
        }
        return zzid.zza(zzid, zzid2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, zzix zzix) throws IOException {
        ((zzid) obj).zza(zzix);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzix zzix) throws IOException {
        ((zzid) obj).zzb(zzix);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzid) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        zzid zzid = ((zzfi) obj).zzb;
        if (zzid != zzid.zza()) {
            return zzid;
        }
        zzid zzb = zzid.zzb();
        zza(obj, zzb);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzb(Object obj) {
        return ((zzfi) obj).zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Object obj2) {
        zza(obj, (zzid) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        zzid zzid = (zzid) obj;
        zzid.zzc();
        return zzid;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza() {
        return zzid.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzid) obj).zza((i << 3) | 3, (Object) (zzid) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzdz zzdz) {
        ((zzid) obj).zza((i << 3) | 2, (Object) zzdz);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzid) obj).zza((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzid) obj).zza((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzid) obj).zza(i << 3, (Object) Long.valueOf(j));
    }
}
