package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzmz;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzeq extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzeq(zzfx zzfx, long j) {
        super(zzfx);
        this.zzg = j;
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01cd A[Catch:{ IllegalStateException -> 0x0260 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01dd A[Catch:{ IllegalStateException -> 0x0260 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01e7 A[Catch:{ IllegalStateException -> 0x0260 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01e9 A[Catch:{ IllegalStateException -> 0x0260 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01f4 A[SYNTHETIC, Splitter:B:77:0x01f4] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0232 A[Catch:{ IllegalStateException -> 0x0260 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0243 A[Catch:{ IllegalStateException -> 0x0260 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzaa() {
        /*
            r11 = this;
            android.content.Context r0 = r11.zzn()
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r11.zzn()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x0033
            com.google.android.gms.measurement.internal.zzet r7 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzf()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zza(r9, r8)
            r8 = r2
            goto L_0x0098
        L_0x0033:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0038 }
            goto L_0x004a
        L_0x0038:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzet r7 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzf()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zza(r9, r8)
        L_0x004a:
            if (r5 != 0) goto L_0x004f
            java.lang.String r5 = "manual_install"
            goto L_0x0058
        L_0x004f:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x0058
            r5 = r3
        L_0x0058:
            android.content.Context r7 = r11.zzn()     // Catch:{ NameNotFoundException -> 0x0083 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0083 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0083 }
            if (r7 == 0) goto L_0x0081
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0083 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0083 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0083 }
            if (r9 != 0) goto L_0x0077
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0083 }
            goto L_0x0078
        L_0x0077:
            r8 = r2
        L_0x0078:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x007d }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x007d }
            goto L_0x0082
        L_0x007d:
            r7 = move-exception
            r7 = r2
            r2 = r8
            goto L_0x0085
        L_0x0081:
            r8 = r2
        L_0x0082:
            goto L_0x0098
        L_0x0083:
            r7 = move-exception
            r7 = r2
        L_0x0085:
            com.google.android.gms.measurement.internal.zzet r8 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzf()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zza(r10, r9, r2)
            r8 = r2
            r2 = r7
        L_0x0098:
            r11.zza = r0
            r11.zzd = r5
            r11.zzb = r2
            r11.zzc = r6
            r11.zze = r8
            r5 = 0
            r11.zzf = r5
            r11.zzu()
            android.content.Context r2 = r11.zzn()
            com.google.android.gms.common.api.Status r2 = com.google.android.gms.common.api.internal.GoogleServices.initialize(r2)
            r5 = 1
            if (r2 == 0) goto L_0x00bd
            boolean r6 = r2.isSuccess()
            if (r6 == 0) goto L_0x00bd
            r6 = r5
            goto L_0x00be
        L_0x00bd:
            r6 = r4
        L_0x00be:
            com.google.android.gms.measurement.internal.zzfx r7 = r11.zzz
            java.lang.String r7 = r7.zzo()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzfx r7 = r11.zzz
            java.lang.String r7 = r7.zzp()
            java.lang.String r8 = "am"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x00da
            r7 = r5
            goto L_0x00db
        L_0x00da:
            r7 = r4
        L_0x00db:
            r6 = r6 | r7
            if (r6 != 0) goto L_0x0108
            if (r2 != 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.zzet r2 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzg()
            java.lang.String r8 = "GoogleService failed to initialize (no status)"
            r2.zza(r8)
            goto L_0x0108
        L_0x00ef:
            com.google.android.gms.measurement.internal.zzet r8 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzg()
            int r9 = r2.getStatusCode()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = r2.getStatusMessage()
            java.lang.String r10 = "GoogleService failed to initialize, status"
            r8.zza(r10, r9, r2)
        L_0x0108:
            if (r6 == 0) goto L_0x01a7
            com.google.android.gms.measurement.internal.zzfx r2 = r11.zzz
            int r2 = r2.zzac()
            switch(r2) {
                case 0: goto L_0x0193;
                case 1: goto L_0x0185;
                case 2: goto L_0x0177;
                case 3: goto L_0x0169;
                case 4: goto L_0x015b;
                case 5: goto L_0x014d;
                case 6: goto L_0x013f;
                case 7: goto L_0x0131;
                default: goto L_0x0115;
            }
        L_0x0115:
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzv()
            java.lang.String r8 = "App measurement disabled"
            r6.zza(r8)
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzg()
            java.lang.String r8 = "Invalid scion state in identity"
            r6.zza(r8)
            goto L_0x01a1
        L_0x0131:
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzv()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r6.zza(r8)
            goto L_0x01a1
        L_0x013f:
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzk()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r6.zza(r8)
            goto L_0x01a1
        L_0x014d:
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzx()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r6.zza(r8)
            goto L_0x01a1
        L_0x015b:
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzv()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r6.zza(r8)
            goto L_0x01a1
        L_0x0169:
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzv()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r6.zza(r8)
            goto L_0x01a1
        L_0x0177:
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzx()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r6.zza(r8)
            goto L_0x01a1
        L_0x0185:
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzv()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r6.zza(r8)
            goto L_0x01a1
        L_0x0193:
            com.google.android.gms.measurement.internal.zzet r6 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzx()
            java.lang.String r8 = "App measurement collection enabled"
            r6.zza(r8)
        L_0x01a1:
            if (r2 != 0) goto L_0x01a5
            r2 = r5
            goto L_0x01a6
        L_0x01a5:
            r2 = r4
        L_0x01a6:
            goto L_0x01a8
        L_0x01a7:
            r2 = r4
        L_0x01a8:
            r11.zzj = r3
            r11.zzk = r3
            r11.zzl = r3
            r11.zzu()
            if (r7 == 0) goto L_0x01bb
            com.google.android.gms.measurement.internal.zzfx r6 = r11.zzz
            java.lang.String r6 = r6.zzo()
            r11.zzk = r6
        L_0x01bb:
            boolean r6 = com.google.android.gms.internal.measurement.zzmt.zzb()     // Catch:{ IllegalStateException -> 0x0260 }
            if (r6 == 0) goto L_0x01dd
            com.google.android.gms.measurement.internal.zzaa r6 = r11.zzt()     // Catch:{ IllegalStateException -> 0x0260 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzas.zzco     // Catch:{ IllegalStateException -> 0x0260 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r7)     // Catch:{ IllegalStateException -> 0x0260 }
            if (r6 == 0) goto L_0x01dd
            android.content.Context r6 = r11.zzn()     // Catch:{ IllegalStateException -> 0x0260 }
            java.lang.String r7 = "google_app_id"
            com.google.android.gms.common.internal.StringResourceValueReader r8 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x0260 }
            r8.<init>(r6)     // Catch:{ IllegalStateException -> 0x0260 }
            java.lang.String r6 = r8.getString(r7)     // Catch:{ IllegalStateException -> 0x0260 }
            goto L_0x01e1
        L_0x01dd:
            java.lang.String r6 = com.google.android.gms.common.api.internal.GoogleServices.getGoogleAppId()     // Catch:{ IllegalStateException -> 0x0260 }
        L_0x01e1:
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x0260 }
            if (r7 == 0) goto L_0x01e9
            r7 = r3
            goto L_0x01ea
        L_0x01e9:
            r7 = r6
        L_0x01ea:
            r11.zzj = r7     // Catch:{ IllegalStateException -> 0x0260 }
            boolean r7 = com.google.android.gms.internal.measurement.zzle.zzb()     // Catch:{ IllegalStateException -> 0x0260 }
            java.lang.String r8 = "admob_app_id"
            if (r7 == 0) goto L_0x022c
            com.google.android.gms.measurement.internal.zzaa r7 = r11.zzt()     // Catch:{ IllegalStateException -> 0x0260 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzas.zzbo     // Catch:{ IllegalStateException -> 0x0260 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r9)     // Catch:{ IllegalStateException -> 0x0260 }
            if (r7 == 0) goto L_0x022c
            com.google.android.gms.common.internal.StringResourceValueReader r7 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x0260 }
            android.content.Context r9 = r11.zzn()     // Catch:{ IllegalStateException -> 0x0260 }
            r7.<init>(r9)     // Catch:{ IllegalStateException -> 0x0260 }
            java.lang.String r9 = "ga_app_id"
            java.lang.String r9 = r7.getString(r9)     // Catch:{ IllegalStateException -> 0x0260 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IllegalStateException -> 0x0260 }
            if (r10 == 0) goto L_0x0216
            goto L_0x0217
        L_0x0216:
            r3 = r9
        L_0x0217:
            r11.zzl = r3     // Catch:{ IllegalStateException -> 0x0260 }
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x0260 }
            if (r3 == 0) goto L_0x0225
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IllegalStateException -> 0x0260 }
            if (r3 != 0) goto L_0x022b
        L_0x0225:
            java.lang.String r3 = r7.getString(r8)     // Catch:{ IllegalStateException -> 0x0260 }
            r11.zzk = r3     // Catch:{ IllegalStateException -> 0x0260 }
        L_0x022b:
            goto L_0x0241
        L_0x022c:
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x0260 }
            if (r3 != 0) goto L_0x0241
            com.google.android.gms.common.internal.StringResourceValueReader r3 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x0260 }
            android.content.Context r6 = r11.zzn()     // Catch:{ IllegalStateException -> 0x0260 }
            r3.<init>(r6)     // Catch:{ IllegalStateException -> 0x0260 }
            java.lang.String r3 = r3.getString(r8)     // Catch:{ IllegalStateException -> 0x0260 }
            r11.zzk = r3     // Catch:{ IllegalStateException -> 0x0260 }
        L_0x0241:
            if (r2 == 0) goto L_0x025f
            com.google.android.gms.measurement.internal.zzet r2 = r11.zzr()     // Catch:{ IllegalStateException -> 0x0260 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzx()     // Catch:{ IllegalStateException -> 0x0260 }
            java.lang.String r3 = "App measurement enabled for app package, google app id"
            java.lang.String r6 = r11.zza     // Catch:{ IllegalStateException -> 0x0260 }
            java.lang.String r7 = r11.zzj     // Catch:{ IllegalStateException -> 0x0260 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0260 }
            if (r7 == 0) goto L_0x025a
            java.lang.String r7 = r11.zzk     // Catch:{ IllegalStateException -> 0x0260 }
            goto L_0x025c
        L_0x025a:
            java.lang.String r7 = r11.zzj     // Catch:{ IllegalStateException -> 0x0260 }
        L_0x025c:
            r2.zza(r3, r6, r7)     // Catch:{ IllegalStateException -> 0x0260 }
        L_0x025f:
            goto L_0x0272
        L_0x0260:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzet r3 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r0)
            java.lang.String r6 = "Fetching Google App Id failed with exception. appId"
            r3.zza(r6, r0, r2)
        L_0x0272:
            r0 = 0
            r11.zzh = r0
            com.google.android.gms.measurement.internal.zzaa r0 = r11.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzbc
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            if (r0 == 0) goto L_0x02cb
            r11.zzu()
            com.google.android.gms.measurement.internal.zzaa r0 = r11.zzt()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zze(r2)
            if (r0 == 0) goto L_0x02c6
            int r2 = r0.size()
            if (r2 != 0) goto L_0x02a7
            com.google.android.gms.measurement.internal.zzet r2 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzk()
            java.lang.String r3 = "Safelisted event list is empty. Ignoring"
            r2.zza(r3)
            r5 = r4
            goto L_0x02c7
        L_0x02a7:
            java.util.Iterator r2 = r0.iterator()
        L_0x02ab:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x02c6
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzko r6 = r11.zzp()
            java.lang.String r7 = "safelisted event"
            boolean r3 = r6.zzb((java.lang.String) r7, (java.lang.String) r3)
            if (r3 != 0) goto L_0x02c5
            r5 = r4
            goto L_0x02c7
        L_0x02c5:
            goto L_0x02ab
        L_0x02c6:
        L_0x02c7:
            if (r5 == 0) goto L_0x02cb
            r11.zzh = r0
        L_0x02cb:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 < r2) goto L_0x02e1
            if (r1 == 0) goto L_0x02de
            android.content.Context r0 = r11.zzn()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzi = r0
            return
        L_0x02de:
            r11.zzi = r4
            return
        L_0x02e1:
            r11.zzi = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeq.zzaa():void");
    }

    /* access modifiers changed from: package-private */
    public final zzm zza(String str) {
        String str2;
        long j;
        boolean z;
        List<String> list;
        zzd();
        zzb();
        String zzab = zzab();
        String zzac = zzac();
        zzw();
        String str3 = this.zzb;
        long zzaf = (long) zzaf();
        zzw();
        String str4 = this.zzd;
        long zzf2 = zzt().zzf();
        zzw();
        zzd();
        if (this.zzf == 0) {
            this.zzf = this.zzz.zzi().zza(zzn(), zzn().getPackageName());
        }
        long j2 = this.zzf;
        boolean zzab2 = this.zzz.zzab();
        boolean z2 = !zzs().zzr;
        zzd();
        zzb();
        if (!this.zzz.zzab()) {
            str2 = null;
        } else {
            str2 = zzai();
        }
        zzfx zzfx = this.zzz;
        Long valueOf = Long.valueOf(zzfx.zzc().zzh.zza());
        if (valueOf.longValue() == 0) {
            j = zzfx.zza;
            z = zzab2;
        } else {
            z = zzab2;
            j = Math.min(zzfx.zza, valueOf.longValue());
        }
        int zzag = zzag();
        boolean booleanValue = zzt().zzi().booleanValue();
        zzaa zzt = zzt();
        zzt.zzb();
        Boolean zzd2 = zzt.zzd("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(zzd2 == null || zzd2.booleanValue()).booleanValue();
        zzff zzs = zzs();
        zzs.zzd();
        boolean z3 = zzs.zzg().getBoolean("deferred_analytics_collection", false);
        String zzad = zzad();
        Boolean zzd3 = zzt().zzd("google_analytics_default_allow_ad_personalization_signals");
        Boolean valueOf2 = zzd3 == null ? null : Boolean.valueOf(!zzd3.booleanValue());
        long j3 = this.zzg;
        if (zzt().zza(zzas.zzbc)) {
            list = this.zzh;
        } else {
            list = null;
        }
        return new zzm(zzab, zzac, str3, zzaf, str4, zzf2, j2, str, z, z2, str2, 0, j, zzag, booleanValue, booleanValue2, z3, zzad, valueOf2, j3, list, (!zzle.zzb() || !zzt().zza(zzas.zzbo)) ? null : zzae());
    }

    private final String zzai() {
        if (!zzmz.zzb() || !zzt().zza(zzas.zzbr)) {
            try {
                Class<?> loadClass = zzn().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{zzn()});
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception e) {
                        zzr().zzk().zza("Failed to retrieve Firebase Instance Id");
                        return null;
                    }
                } catch (Exception e2) {
                    zzr().zzj().zza("Failed to obtain Firebase Analytics instance");
                    return null;
                }
            } catch (ClassNotFoundException e3) {
                return null;
            }
        } else {
            zzr().zzx().zza("Disabled IID for tests.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzab() {
        zzw();
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzac() {
        zzw();
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final String zzad() {
        zzw();
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final String zzae() {
        zzw();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final int zzaf() {
        zzw();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzag() {
        zzw();
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzah() {
        return this.zzh;
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
