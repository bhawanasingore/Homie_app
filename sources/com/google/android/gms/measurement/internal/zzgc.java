package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public final class zzgc extends zzeo {
    /* access modifiers changed from: private */
    public final zzkg zza;
    private Boolean zzb;
    private String zzc;

    public zzgc(zzkg zzkg) {
        this(zzkg, (String) null);
    }

    private zzgc(zzkg zzkg, String str) {
        Preconditions.checkNotNull(zzkg);
        this.zza = zzkg;
        this.zzc = null;
    }

    public final void zzb(zzm zzm) {
        zzb(zzm, false);
        zza((Runnable) new zzgb(this, zzm));
    }

    public final void zza(zzaq zzaq, zzm zzm) {
        Preconditions.checkNotNull(zzaq);
        zzb(zzm, false);
        zza((Runnable) new zzgk(this, zzaq, zzm));
    }

    /* access modifiers changed from: package-private */
    public final zzaq zzb(zzaq zzaq, zzm zzm) {
        boolean z = false;
        if (!(!"_cmp".equals(zzaq.zza) || zzaq.zzb == null || zzaq.zzb.zza() == 0)) {
            String zzd = zzaq.zzb.zzd("_cis");
            if (!TextUtils.isEmpty(zzd) && (("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) && this.zza.zzb().zze(zzm.zza, zzas.zzar))) {
                z = true;
            }
        }
        if (!z) {
            return zzaq;
        }
        this.zza.zzr().zzv().zza("Event has been filtered ", zzaq.toString());
        return new zzaq("_cmpx", zzaq.zzb, zzaq.zzc, zzaq.zzd);
    }

    public final void zza(zzaq zzaq, String str, String str2) {
        Preconditions.checkNotNull(zzaq);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza((Runnable) new zzgj(this, zzaq, str));
    }

    public final byte[] zza(zzaq zzaq, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaq);
        zza(str, true);
        this.zza.zzr().zzw().zza("Log and bundle. event", this.zza.zzi().zza(zzaq.zza));
        long nanoTime = this.zza.zzm().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzq().zzb(new zzgm(this, zzaq, str)).get();
            if (bArr == null) {
                this.zza.zzr().zzf().zza("Log and bundle returned null. appId", zzet.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzr().zzw().zza("Log and bundle processed. event, size, time_ms", this.zza.zzi().zza(zzaq.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzm().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to log and bundle. appId, event, error", zzet.zza(str), this.zza.zzi().zza(zzaq.zza), e);
            return null;
        }
    }

    public final void zza(zzkn zzkn, zzm zzm) {
        Preconditions.checkNotNull(zzkn);
        zzb(zzm, false);
        zza((Runnable) new zzgl(this, zzkn, zzm));
    }

    public final List<zzkn> zza(zzm zzm, boolean z) {
        zzb(zzm, false);
        try {
            List<zzkp> list = (List) this.zza.zzq().zza(new zzgo(this, zzm)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkp zzkp : list) {
                if (z || !zzko.zze(zzkp.zzc)) {
                    arrayList.add(new zzkn(zzkp));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user properties. appId", zzet.zza(zzm.zza), e);
            return null;
        }
    }

    public final void zza(zzm zzm) {
        zzb(zzm, false);
        zza((Runnable) new zzgn(this, zzm));
    }

    private final void zzb(zzm zzm, boolean z) {
        Preconditions.checkNotNull(zzm);
        zza(zzm.zza, false);
        this.zza.zzj().zza(zzm.zzb, zzm.zzr, zzm.zzv);
    }

    private final void zza(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzn(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzn()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzr().zzf().zza("Measurement Service called with invalid calling package. appId", zzet.zza(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzn(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzr().zzf().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    public final void zza(long j, String str, String str2, String str3) {
        zza((Runnable) new zzgq(this, str2, str3, str, j));
    }

    public final String zzc(zzm zzm) {
        zzb(zzm, false);
        return this.zza.zzd(zzm);
    }

    public final void zza(zzy zzy, zzm zzm) {
        Preconditions.checkNotNull(zzy);
        Preconditions.checkNotNull(zzy.zzc);
        zzb(zzm, false);
        zzy zzy2 = new zzy(zzy);
        zzy2.zza = zzm.zza;
        zza((Runnable) new zzgp(this, zzy2, zzm));
    }

    public final void zza(zzy zzy) {
        Preconditions.checkNotNull(zzy);
        Preconditions.checkNotNull(zzy.zzc);
        zza(zzy.zza, true);
        zza((Runnable) new zzge(this, new zzy(zzy)));
    }

    public final List<zzkn> zza(String str, String str2, boolean z, zzm zzm) {
        zzb(zzm, false);
        try {
            List<zzkp> list = (List) this.zza.zzq().zza(new zzgd(this, zzm, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkp zzkp : list) {
                if (z || !zzko.zze(zzkp.zzc)) {
                    arrayList.add(new zzkn(zzkp));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to query user properties. appId", zzet.zza(zzm.zza), e);
            return Collections.emptyList();
        }
    }

    public final List<zzkn> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzkp> list = (List) this.zza.zzq().zza(new zzgg(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkp zzkp : list) {
                if (z || !zzko.zze(zzkp.zzc)) {
                    arrayList.add(new zzkn(zzkp));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user properties as. appId", zzet.zza(str), e);
            return Collections.emptyList();
        }
    }

    public final List<zzy> zza(String str, String str2, zzm zzm) {
        zzb(zzm, false);
        try {
            return (List) this.zza.zzq().zza(new zzgf(this, zzm, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    public final List<zzy> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzq().zza(new zzgi(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    public final void zzd(zzm zzm) {
        zza(zzm.zza, false);
        zza((Runnable) new zzgh(this, zzm));
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzq().zzg()) {
            runnable.run();
        } else {
            this.zza.zzq().zza(runnable);
        }
    }
}
