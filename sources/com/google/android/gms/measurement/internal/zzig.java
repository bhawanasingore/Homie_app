package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzle;
import io.flutter.plugins.firebase.auth.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzig extends zzkd {
    public zzig(zzkg zzkg) {
        super(zzkg);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    public final byte[] zza(zzaq zzaq, String str) {
        zzkp zzkp;
        zzbw.zzf.zza zza;
        zzbw.zzg.zza zza2;
        zzg zzg;
        byte[] bArr;
        Bundle bundle;
        zzam zzam;
        long j;
        zzaq zzaq2 = zzaq;
        String str2 = str;
        zzd();
        this.zzz.zzae();
        Preconditions.checkNotNull(zzaq);
        Preconditions.checkNotEmpty(str);
        if (!zzt().zze(str2, zzas.zzax)) {
            zzr().zzw().zza("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(zzaq2.zza) || "_iapx".equals(zzaq2.zza)) {
            zzbw.zzf.zza zzb = zzbw.zzf.zzb();
            zzi().zzf();
            try {
                zzg zzb2 = zzi().zzb(str2);
                if (zzb2 == null) {
                    zzr().zzw().zza("Log and bundle not available. package_name", str2);
                    return new byte[0];
                } else if (!zzb2.zzr()) {
                    zzr().zzw().zza("Log and bundle disabled. package_name", str2);
                    byte[] bArr2 = new byte[0];
                    zzi().zzh();
                    return bArr2;
                } else {
                    zzbw.zzg.zza zza3 = zzbw.zzg.zzbf().zza(1).zza(Constants.ANDROID);
                    if (!TextUtils.isEmpty(zzb2.zzc())) {
                        zza3.zzf(zzb2.zzc());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzn())) {
                        zza3.zze(zzb2.zzn());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzl())) {
                        zza3.zzg(zzb2.zzl());
                    }
                    if (zzb2.zzm() != -2147483648L) {
                        zza3.zzh((int) zzb2.zzm());
                    }
                    zza3.zzf(zzb2.zzo()).zzk(zzb2.zzq());
                    if (!zzle.zzb() || !zzt().zze(zzb2.zzc(), zzas.zzbo)) {
                        if (!TextUtils.isEmpty(zzb2.zze())) {
                            zza3.zzk(zzb2.zze());
                        } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                            zza3.zzo(zzb2.zzf());
                        }
                    } else if (!TextUtils.isEmpty(zzb2.zze())) {
                        zza3.zzk(zzb2.zze());
                    } else if (!TextUtils.isEmpty(zzb2.zzg())) {
                        zza3.zzp(zzb2.zzg());
                    } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                        zza3.zzo(zzb2.zzf());
                    }
                    zza3.zzh(zzb2.zzp());
                    if (this.zzz.zzab() && zzt().zzf(zza3.zzj())) {
                        zza3.zzj();
                        if (!TextUtils.isEmpty((CharSequence) null)) {
                            zza3.zzn((String) null);
                        }
                    }
                    Pair<String, Boolean> zza4 = zzs().zza(zzb2.zzc());
                    if (zzb2.zzaf() && zza4 != null && !TextUtils.isEmpty((CharSequence) zza4.first)) {
                        zza3.zzh(zza((String) zza4.first, Long.toString(zzaq2.zzd)));
                        if (zza4.second != null) {
                            zza3.zza(((Boolean) zza4.second).booleanValue());
                        }
                    }
                    zzl().zzaa();
                    zzbw.zzg.zza zzc = zza3.zzc(Build.MODEL);
                    zzl().zzaa();
                    zzc.zzb(Build.VERSION.RELEASE).zzf((int) zzl().zzf()).zzd(zzl().zzg());
                    try {
                        zza3.zzi(zza(zzb2.zzd(), Long.toString(zzaq2.zzd)));
                        if (!TextUtils.isEmpty(zzb2.zzi())) {
                            zza3.zzl(zzb2.zzi());
                        }
                        String zzc2 = zzb2.zzc();
                        List<zzkp> zza5 = zzi().zza(zzc2);
                        Iterator<zzkp> it = zza5.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                zzkp = null;
                                break;
                            }
                            zzkp = it.next();
                            if ("_lte".equals(zzkp.zzc)) {
                                break;
                            }
                        }
                        if (zzkp == null || zzkp.zze == null) {
                            zzkp zzkp2 = new zzkp(zzc2, "auto", "_lte", zzm().currentTimeMillis(), 0L);
                            zza5.add(zzkp2);
                            zzi().zza(zzkp2);
                        }
                        zzkk zzg2 = zzg();
                        zzg2.zzr().zzx().zza("Checking account type status for ad personalization signals");
                        if (zzg2.zzl().zzj()) {
                            String zzc3 = zzb2.zzc();
                            if (zzb2.zzaf() && zzg2.zzj().zze(zzc3)) {
                                zzg2.zzr().zzw().zza("Turning off ad personalization due to account type");
                                Iterator<zzkp> it2 = zza5.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    } else if ("_npa".equals(it2.next().zzc)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                zza5.add(new zzkp(zzc3, "auto", "_npa", zzg2.zzm().currentTimeMillis(), 1L));
                            }
                        }
                        zzbw.zzk[] zzkArr = new zzbw.zzk[zza5.size()];
                        for (int i = 0; i < zza5.size(); i++) {
                            zzbw.zzk.zza zza6 = zzbw.zzk.zzj().zza(zza5.get(i).zzc).zza(zza5.get(i).zzd);
                            zzg().zza(zza6, zza5.get(i).zze);
                            zzkArr[i] = (zzbw.zzk) ((zzfi) zza6.zzu());
                        }
                        zza3.zzb((Iterable<? extends zzbw.zzk>) Arrays.asList(zzkArr));
                        Bundle zzb3 = zzaq2.zzb.zzb();
                        zzb3.putLong("_c", 1);
                        zzr().zzw().zza("Marking in-app purchase as real-time");
                        zzb3.putLong("_r", 1);
                        zzb3.putString("_o", zzaq2.zzc);
                        if (zzp().zzf(zza3.zzj())) {
                            zzp().zza(zzb3, "_dbg", (Object) 1L);
                            zzp().zza(zzb3, "_r", (Object) 1L);
                        }
                        zzam zza7 = zzi().zza(str2, zzaq2.zza);
                        if (zza7 == null) {
                            zzg = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle = zzb3;
                            bArr = null;
                            zzam = new zzam(str, zzaq2.zza, 0, 0, zzaq2.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                            j = 0;
                        } else {
                            zzg = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle = zzb3;
                            bArr = null;
                            j = zza7.zzf;
                            zzam = zza7.zza(zzaq2.zzd);
                        }
                        zzi().zza(zzam);
                        zzaj zzaj = new zzaj(this.zzz, zzaq2.zzc, str, zzaq2.zza, zzaq2.zzd, j, bundle);
                        zzbw.zzc.zza zzb4 = zzbw.zzc.zzj().zza(zzaj.zzc).zza(zzaj.zzb).zzb(zzaj.zzd);
                        Iterator<String> it3 = zzaj.zze.iterator();
                        while (it3.hasNext()) {
                            String next = it3.next();
                            zzbw.zze.zza zza8 = zzbw.zze.zzk().zza(next);
                            zzg().zza(zza8, zzaj.zze.zza(next));
                            zzb4.zza(zza8);
                        }
                        zzbw.zzg.zza zza9 = zza2;
                        zza9.zza(zzb4).zza(zzbw.zzh.zza().zza(zzbw.zzd.zza().zza(zzam.zzc).zza(zzaq2.zza)));
                        zza9.zzc((Iterable<? extends zzbw.zza>) e_().zza(zzg.zzc(), Collections.emptyList(), zza9.zzd(), Long.valueOf(zzb4.zzf()), Long.valueOf(zzb4.zzf())));
                        if (zzb4.zze()) {
                            zza9.zzb(zzb4.zzf()).zzc(zzb4.zzf());
                        }
                        long zzk = zzg.zzk();
                        int i2 = (zzk > 0 ? 1 : (zzk == 0 ? 0 : -1));
                        if (i2 != 0) {
                            zza9.zze(zzk);
                        }
                        long zzj = zzg.zzj();
                        if (zzj != 0) {
                            zza9.zzd(zzj);
                        } else if (i2 != 0) {
                            zza9.zzd(zzk);
                        }
                        zzg.zzv();
                        zza9.zzg((int) zzg.zzs()).zzg(zzt().zzf()).zza(zzm().currentTimeMillis()).zzb(Boolean.TRUE.booleanValue());
                        zzbw.zzf.zza zza10 = zza;
                        zza10.zza(zza9);
                        zzg zzg3 = zzg;
                        zzg3.zza(zza9.zzf());
                        zzg3.zzb(zza9.zzg());
                        zzi().zza(zzg3);
                        zzi().b_();
                        zzi().zzh();
                        try {
                            return zzg().zzc(((zzbw.zzf) ((zzfi) zza10.zzu())).zzbi());
                        } catch (IOException e) {
                            zzr().zzf().zza("Data loss. Failed to bundle and serialize. appId", zzet.zza(str), e);
                            return bArr;
                        }
                    } catch (SecurityException e2) {
                        zzr().zzw().zza("app instance id encryption failed", e2.getMessage());
                        byte[] bArr3 = new byte[0];
                        zzi().zzh();
                        return bArr3;
                    }
                }
            } catch (SecurityException e3) {
                zzr().zzw().zza("Resettable device id encryption failed", e3.getMessage());
                return new byte[0];
            } finally {
                zzi().zzh();
            }
        } else {
            zzr().zzw().zza("Generating a payload for this event is not available. package_name, event_name", str2, zzaq2.zza);
            return null;
        }
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
