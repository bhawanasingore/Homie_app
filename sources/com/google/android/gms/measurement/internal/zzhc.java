package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzks;
import com.google.android.gms.internal.measurement.zzlj;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzhc extends zze {
    protected zzhx zza;
    final zzn zzb;
    protected boolean zzc = true;
    private zzgx zzd;
    private final Set<zzha> zze = new CopyOnWriteArraySet();
    private boolean zzf;
    private final AtomicReference<String> zzg = new AtomicReference<>();

    protected zzhc(zzfx zzfx) {
        super(zzfx);
        this.zzb = new zzn(zzfx);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000, "boolean test flag value", new zzhd(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000, "String test flag value", new zzhn(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000, "long test flag value", new zzhs(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000, "int test flag value", new zzhr(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000, "double test flag value", new zzhu(this, atomicReference));
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza((Runnable) new zzht(this, z));
    }

    public final void zzb(boolean z) {
        zzw();
        zzb();
        zzq().zza((Runnable) new zzhw(this, z));
    }

    /* access modifiers changed from: private */
    public final void zzd(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        zzd();
        String zza2 = zzs().zzn.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zza("app", "_npa", (Object) null, zzm().currentTimeMillis());
            } else {
                zza("app", "_npa", (Object) Long.valueOf("true".equals(zza2) ? 1 : 0), zzm().currentTimeMillis());
            }
        }
        if (!this.zzz.zzab() || !this.zzc) {
            zzr().zzw().zza("Updating Scion state (FE)");
            zzh().zzac();
            return;
        }
        zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzai();
        if (zzks.zzb() && zzt().zza(zzas.zzbw)) {
            zzk().zza.zza();
        }
        if (zzkl.zzb() && zzt().zza(zzas.zzcb)) {
            if (!(this.zzz.zzf().zza.zzc().zzi.zza() > 0)) {
                zzfo zzf2 = this.zzz.zzf();
                zzf2.zza.zzad();
                zzf2.zza(zzf2.zza.zzn().getPackageName());
            }
        }
        if (zzt().zza(zzas.zzcp)) {
            zzq().zza((Runnable) new zzhv(this));
        }
    }

    public final void zza(long j) {
        zzb();
        zzq().zza((Runnable) new zzhy(this, j));
    }

    public final void zzb(long j) {
        zzb();
        zzq().zza((Runnable) new zzhg(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, false, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzd == null || zzko.zze(str2), false, (String) null);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzii zzii;
        zzii zzii2;
        String str4;
        long j2;
        long j3;
        boolean z4;
        String str5;
        boolean z5;
        String str6;
        ArrayList arrayList;
        Bundle bundle2;
        String str7;
        boolean z6;
        int i;
        zzii zzii3;
        long j4;
        String str8;
        ArrayList arrayList2;
        Bundle bundle3;
        String str9;
        boolean z7;
        Class<?> cls;
        List<String> zzah;
        String str10 = str;
        String str11 = str2;
        long j5 = j;
        Bundle bundle4 = bundle;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzd();
        zzw();
        if (!this.zzz.zzab()) {
            zzr().zzw().zza("Event not sent since app measurement is disabled");
        } else if (!zzt().zza(zzas.zzbc) || (zzah = zzg().zzah()) == null || zzah.contains(str11)) {
            int i2 = 0;
            if (!this.zzf) {
                this.zzf = true;
                try {
                    if (!this.zzz.zzt()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zzn().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{zzn()});
                    } catch (Exception e) {
                        zzr().zzi().zza("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException e2) {
                    zzr().zzv().zza("Tag Manager is not found and thus will not be used");
                }
            }
            if (zzt().zza(zzas.zzbi) && "_cmp".equals(str11) && bundle4.containsKey("gclid")) {
                zza("auto", "_lgclid", (Object) bundle4.getString("gclid"), zzm().currentTimeMillis());
            }
            if (zzlj.zzb() && zzt().zza(zzas.zzcn)) {
                zzu();
                if (z && zzko.zzg(str2)) {
                    zzko zzp = zzp();
                    Bundle zza2 = zzs().zzy.zza();
                    if (zza2 != null) {
                        for (String str12 : zza2.keySet()) {
                            if (!bundle4.containsKey(str12)) {
                                zzp.zzp().zza(bundle4, str12, zza2.get(str12));
                            }
                        }
                    }
                }
            }
            if (z3) {
                zzu();
                if (!"_iap".equals(str11)) {
                    zzko zzi = this.zzz.zzi();
                    int i3 = 2;
                    if (zzi.zza(NotificationCompat.CATEGORY_EVENT, str11)) {
                        if (!zzi.zza(NotificationCompat.CATEGORY_EVENT, zzgw.zza, str11)) {
                            i3 = 13;
                        } else if (zzi.zza(NotificationCompat.CATEGORY_EVENT, 40, str11)) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        zzr().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzo().zza(str11));
                        this.zzz.zzi();
                        String zza3 = zzko.zza(str11, 40, true);
                        if (str11 != null) {
                            i2 = str2.length();
                        }
                        this.zzz.zzi().zza(i3, "_ev", zza3, i2);
                        return;
                    }
                }
            }
            zzu();
            zzii zza4 = zzi().zza(false);
            if (zza4 != null && !bundle4.containsKey("_sc")) {
                zza4.zzd = true;
            }
            zzih.zza(zza4, bundle4, z && z3);
            boolean equals = "am".equals(str10);
            boolean zze2 = zzko.zze(str2);
            if (z && this.zzd != null && !zze2 && !equals) {
                zzr().zzw().zza("Passing event to registered event handler (FE)", zzo().zza(str11), zzo().zza(bundle4));
                this.zzd.interceptEvent(str, str2, bundle, j);
            } else if (this.zzz.zzag()) {
                int zzb2 = zzp().zzb(str11);
                if (zzb2 != 0) {
                    zzr().zzh().zza("Invalid event name. Event will not be logged (FE)", zzo().zza(str11));
                    zzp();
                    String zza5 = zzko.zza(str11, 40, true);
                    if (str11 != null) {
                        i2 = str2.length();
                    }
                    this.zzz.zzi().zza(str3, zzb2, "_ev", zza5, i2);
                    return;
                }
                List listOf = CollectionUtils.listOf((T[]) new String[]{"_o", "_sn", "_sc", "_si"});
                Bundle zza6 = zzp().zza(str3, str2, bundle, (List<String>) listOf, z3, true);
                if (zza6 == null || !zza6.containsKey("_sc") || !zza6.containsKey("_si")) {
                    zzii = null;
                } else {
                    zzii = new zzii(zza6.getString("_sn"), zza6.getString("_sc"), Long.valueOf(zza6.getLong("_si")).longValue());
                }
                if (zzii == null) {
                    zzii2 = zza4;
                } else {
                    zzii2 = zzii;
                }
                String str13 = "_ae";
                if (zzt().zza(zzas.zzat)) {
                    zzu();
                    if (zzi().zza(false) != null) {
                        str4 = str2;
                        if (str13.equals(str4)) {
                            long zzb3 = zzk().zzb.zzb();
                            if (zzb3 > 0) {
                                zzp().zza(zza6, zzb3);
                            }
                        }
                    } else {
                        str4 = str2;
                    }
                } else {
                    str4 = str2;
                }
                if (zzka.zzb() && zzt().zza(zzas.zzbv)) {
                    if (!"auto".equals(str10) && "_ssr".equals(str4)) {
                        zzko zzp2 = zzp();
                        String string = zza6.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            str9 = null;
                        } else {
                            str9 = string.trim();
                        }
                        if (zzko.zzc(str9, zzp2.zzs().zzv.zza())) {
                            zzp2.zzr().zzw().zza("Not logging duplicate session_start_with_rollout event");
                            z7 = false;
                        } else {
                            zzp2.zzs().zzv.zza(str9);
                            z7 = true;
                        }
                        if (!z7) {
                            return;
                        }
                    } else if (str13.equals(str4)) {
                        String zza7 = zzp().zzs().zzv.zza();
                        if (!TextUtils.isEmpty(zza7)) {
                            zza6.putString("_ffr", zza7);
                        }
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(zza6);
                long nextLong = zzp().zzh().nextLong();
                if (zzs().zzq.zza() > 0) {
                    j3 = j;
                    if (!zzs().zza(j3)) {
                        j2 = nextLong;
                    } else if (zzs().zzs.zza()) {
                        zzr().zzx().zza("Current session is expired, remove the session number, ID, and engagement time");
                        j2 = nextLong;
                        zza("auto", "_sid", (Object) null, zzm().currentTimeMillis());
                        zza("auto", "_sno", (Object) null, zzm().currentTimeMillis());
                        zza("auto", "_se", (Object) null, zzm().currentTimeMillis());
                    } else {
                        j2 = nextLong;
                    }
                } else {
                    j3 = j;
                    j2 = nextLong;
                }
                if (zza6.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0) == 1) {
                    zzr().zzx().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    z4 = true;
                    this.zzz.zze().zza.zza(j3, true);
                } else {
                    z4 = true;
                }
                String[] strArr = (String[]) zza6.keySet().toArray(new String[zza6.size()]);
                Arrays.sort(strArr);
                if (!zzjt.zzb() || !zzt().zza(zzas.zzch) || !zzt().zza(zzas.zzcg)) {
                    int length = strArr.length;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < length) {
                        String str14 = strArr[i4];
                        Object obj = zza6.get(str14);
                        zzp();
                        String[] strArr2 = strArr;
                        Bundle[] zzb4 = zzko.zzb(obj);
                        if (zzb4 != null) {
                            i = length;
                            zza6.putInt(str14, zzb4.length);
                            int i6 = 0;
                            while (i6 < zzb4.length) {
                                Bundle bundle5 = zzb4[i6];
                                zzih.zza(zzii2, bundle5, true);
                                ArrayList arrayList4 = arrayList3;
                                Bundle zza8 = zzp().zza(str3, "_ep", bundle5, (List<String>) listOf, z3, false);
                                String str15 = str2;
                                zza8.putString("_en", str15);
                                zza8.putLong("_eid", j2);
                                zza8.putString("_gn", str14);
                                zza8.putInt("_ll", zzb4.length);
                                zza8.putInt("_i", i6);
                                ArrayList arrayList5 = arrayList4;
                                arrayList5.add(zza8);
                                i6++;
                                zza6 = zza6;
                                zzii2 = zzii2;
                                str13 = str13;
                                str4 = str15;
                                arrayList3 = arrayList5;
                                long j6 = j;
                            }
                            arrayList2 = arrayList3;
                            str8 = str4;
                            str7 = str13;
                            zzii3 = zzii2;
                            bundle3 = zza6;
                            j4 = j2;
                            z6 = true;
                            i5 += zzb4.length;
                        } else {
                            i = length;
                            arrayList2 = arrayList3;
                            str8 = str4;
                            str7 = str13;
                            zzii3 = zzii2;
                            bundle3 = zza6;
                            j4 = j2;
                            z6 = true;
                        }
                        i4++;
                        strArr = strArr2;
                        zza6 = bundle3;
                        j2 = j4;
                        zzii2 = zzii3;
                        length = i;
                        z4 = z6;
                        str13 = str7;
                        str4 = str8;
                        arrayList3 = arrayList2;
                        long j7 = j;
                    }
                    z5 = z4;
                    arrayList = arrayList3;
                    str6 = str4;
                    str5 = str13;
                    Bundle bundle6 = zza6;
                    long j8 = j2;
                    if (i5 != 0) {
                        bundle6.putLong("_eid", j8);
                        bundle6.putInt("_epc", i5);
                    }
                } else {
                    for (String str16 : strArr) {
                        zzp();
                        Bundle[] zzb5 = zzko.zzb(zza6.get(str16));
                        if (zzb5 != null) {
                            zza6.putParcelableArray(str16, zzb5);
                        }
                    }
                    z5 = z4;
                    arrayList = arrayList3;
                    str6 = str4;
                    str5 = str13;
                }
                int i7 = 0;
                while (i7 < arrayList.size()) {
                    Bundle bundle7 = (Bundle) arrayList.get(i7);
                    String str17 = i7 != 0 ? z5 : false ? "_ep" : str6;
                    bundle7.putString("_o", str10);
                    if (z2) {
                        bundle2 = zzp().zza(bundle7);
                    } else {
                        bundle2 = bundle7;
                    }
                    boolean z8 = z5;
                    zzh().zza(new zzaq(str17, new zzal(bundle2), str, j), str3);
                    if (!equals) {
                        for (zzha onEvent : this.zze) {
                            onEvent.onEvent(str, str2, new Bundle(bundle2), j);
                        }
                    }
                    i7++;
                    z5 = z8;
                }
                boolean z9 = z5;
                zzu();
                if (zzi().zza(false) != null && str5.equals(str6)) {
                    zzk().zza(z9, z9, zzm().elapsedRealtime());
                }
            }
        } else {
            zzr().zzw().zza("Dropping non-safelisted event. event name, origin", str11, str10);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3;
        Bundle bundle2;
        boolean z3;
        zzb();
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (z2) {
            if (this.zzd != null && !zzko.zze(str2)) {
                z3 = false;
                zzb(str3, str2, j, bundle2, z2, z3, !z, (String) null);
            }
        }
        z3 = true;
        zzb(str3, str2, j, bundle2, z2, z3, !z, (String) null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzq().zza((Runnable) new zzhf(this, str, str2, j, zzko.zzb(bundle), z, z2, z3, str3));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        String str3;
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzp().zzc(str2);
        } else {
            zzko zzp = zzp();
            if (zzp.zza("user property", str2)) {
                if (!zzp.zza("user property", zzgy.zza, str2)) {
                    i = 15;
                } else if (zzp.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzp();
            String zza2 = zzko.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzz.zzi().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzp().zzb(str2, obj);
            if (zzb2 != 0) {
                zzp();
                String zza3 = zzko.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzz.zzi().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzp().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzq().zza((Runnable) new zzhi(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzd()
            r8.zzb()
            r8.zzw()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0069
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0058
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0058
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0038
            r4 = r2
            goto L_0x003a
        L_0x0038:
            r4 = 0
        L_0x003a:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzff r0 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfl r0 = r0.zzn
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0052
            java.lang.String r11 = "true"
        L_0x0052:
            r0.zza(r11)
            r6 = r10
            r3 = r1
            goto L_0x006b
        L_0x0058:
            if (r11 != 0) goto L_0x0069
            com.google.android.gms.measurement.internal.zzff r10 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfl r10 = r10.zzn
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
            r3 = r1
            goto L_0x006b
        L_0x0069:
            r3 = r10
            r6 = r11
        L_0x006b:
            com.google.android.gms.measurement.internal.zzfx r10 = r8.zzz
            boolean r10 = r10.zzab()
            if (r10 != 0) goto L_0x0081
            com.google.android.gms.measurement.internal.zzet r9 = r8.zzr()
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzx()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x0081:
            com.google.android.gms.measurement.internal.zzfx r10 = r8.zzz
            boolean r10 = r10.zzag()
            if (r10 != 0) goto L_0x008a
            return
        L_0x008a:
            com.google.android.gms.measurement.internal.zzkn r10 = new com.google.android.gms.measurement.internal.zzkn
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzin r9 = r8.zzh()
            r9.zza((com.google.android.gms.measurement.internal.zzkn) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhc.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzkn> zzc(boolean z) {
        zzb();
        zzw();
        zzr().zzx().zza("Getting user properties (FE)");
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzv.zza()) {
            zzr().zzf().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzz.zzq().zza(atomicReference, 5000, "get user properties", new zzhh(this, atomicReference, z));
            List<zzkn> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzr().zzf().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final String zzah() {
        zzb();
        return this.zzg.get();
    }

    public final String zzc(long j) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzv.zza()) {
            zzr().zzf().zza("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzm().elapsedRealtime();
            String zze2 = zze(120000);
            long elapsedRealtime2 = zzm().elapsedRealtime() - elapsedRealtime;
            if (zze2 != null || elapsedRealtime2 >= 120000) {
                return zze2;
            }
            return zze(120000 - elapsedRealtime2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        this.zzg.set(str);
    }

    private final String zze(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzq().zza((Runnable) new zzhk(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzr().zzi().zza("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final void zzd(long j) {
        zza((String) null);
        zzq().zza((Runnable) new zzhj(this, j));
    }

    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzz.zzag()) {
            if (zzt().zza(zzas.zzbh)) {
                zzaa zzt = zzt();
                zzt.zzu();
                Boolean zzd2 = zzt.zzd("google_analytics_deferred_deep_link_enabled");
                if (zzd2 != null && zzd2.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza((Runnable) new zzhe(this));
                }
            }
            zzh().zzae();
            this.zzc = false;
            String zzw = zzs().zzw();
            if (!TextUtils.isEmpty(zzw)) {
                zzl().zzaa();
                if (!zzw.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzw);
                    zza("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void zza(zzgx zzgx) {
        zzgx zzgx2;
        zzd();
        zzb();
        zzw();
        if (!(zzgx == null || zzgx == (zzgx2 = this.zzd))) {
            Preconditions.checkState(zzgx2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzgx;
    }

    public final void zza(zzha zzha) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzha);
        if (!this.zze.add(zzha)) {
            zzr().zzi().zza("OnEventListener already registered");
        }
    }

    public final void zzb(zzha zzha) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzha);
        if (!this.zze.remove(zzha)) {
            zzr().zzi().zza("OnEventListener had not been registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgt.zza(bundle, "app_id", String.class, null);
        zzgt.zza(bundle, "origin", String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzgt.zza(bundle, "value", Object.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle.get("value");
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
        } else if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
        } else {
            Object zzc2 = zzp().zzc(string, obj);
            if (zzc2 == null) {
                zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
                return;
            }
            zzgt.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
                } else {
                    zzq().zza((Runnable) new zzhl(this, bundle));
                }
            } else {
                zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza((Runnable) new zzho(this, bundle2));
    }

    /* access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzz.zzab()) {
            zzr().zzx().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkn zzkn = new zzkn(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin"));
        try {
            zzaq zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false);
            zzh().zza(new zzy(bundle2.getString("app_id"), bundle2.getString("origin"), zzkn, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!this.zzz.zzab()) {
            zzr().zzx().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkn zzkn = new zzkn(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), 0, (Object) null, (String) null);
        try {
            zzaq zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false);
            zzkn zzkn2 = zzkn;
            zzh().zza(new zzy(bundle2.getString("app_id"), bundle2.getString("origin"), zzkn2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzaq) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzaq) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza2));
        } catch (IllegalArgumentException e) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzv.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzz.zzq().zza(atomicReference, 5000, "get conditional user properties", new zzhq(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzko.zzb((List<zzy>) list);
            }
            zzr().zzf().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzv.zza()) {
            zzr().zzf().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzz.zzq().zza(atomicReference, 5000, "get user properties", new zzhp(this, atomicReference, str, str2, str3, z));
            List<zzkn> list = (List) atomicReference.get();
            if (list == null) {
                zzr().zzf().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzkn zzkn : list) {
                arrayMap.put(zzkn.zza, zzkn.zza());
            }
            return arrayMap;
        }
    }

    public final String zzaj() {
        zzii zzab = this.zzz.zzv().zzab();
        if (zzab != null) {
            return zzab.zza;
        }
        return null;
    }

    public final String zzak() {
        zzii zzab = this.zzz.zzv().zzab();
        if (zzab != null) {
            return zzab.zzb;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzz.zzo() != null) {
            return this.zzz.zzo();
        }
        try {
            return new StringResourceValueReader(zzn()).getString("google_app_id");
        } catch (IllegalStateException e) {
            this.zzz.zzr().zzf().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhc zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzeq zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzin zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzih zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzep zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzjs zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzak zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzer zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzko zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfu zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzet zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzff zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzaa zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzv zzu() {
        return super.zzu();
    }
}
