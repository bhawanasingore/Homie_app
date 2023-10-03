package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzkr;
import com.google.android.gms.internal.measurement.zzle;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public class zzkg implements zzgu {
    private static volatile zzkg zza;
    private zzfr zzb;
    private zzfa zzc;
    private zzab zzd;
    private zzfd zze;
    private zzkc zzf;
    private zzq zzg;
    private final zzkk zzh;
    private zzig zzi;
    private final zzfx zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    class zza implements zzad {
        zzbw.zzg zza;
        List<Long> zzb;
        List<zzbw.zzc> zzc;
        private long zzd;

        private zza() {
        }

        public final void zza(zzbw.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        public final boolean zza(long j, zzbw.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbn = this.zzd + ((long) zzc2.zzbn());
            if (zzbn >= ((long) Math.max(0, zzas.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbn;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzas.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzbw.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzkg zzkg, zzkf zzkf) {
            this();
        }
    }

    public static zzkg zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkg.class) {
                if (zza == null) {
                    zza = new zzkg(new zzkl(context));
                }
            }
        }
        return zza;
    }

    private zzkg(zzkl zzkl) {
        this(zzkl, (zzfx) null);
    }

    private zzkg(zzkl zzkl, zzfx zzfx) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkl);
        this.zzj = zzfx.zza(zzkl.zza, (zzaa) null, (Long) null);
        this.zzx = -1;
        zzkk zzkk = new zzkk(this);
        zzkk.zzal();
        this.zzh = zzkk;
        zzfa zzfa = new zzfa(this);
        zzfa.zzal();
        this.zzc = zzfa;
        zzfr zzfr = new zzfr(this);
        zzfr.zzal();
        this.zzb = zzfr;
        this.zzj.zzq().zza((Runnable) new zzkf(this, zzkl));
    }

    /* access modifiers changed from: private */
    public final void zza(zzkl zzkl) {
        this.zzj.zzq().zzd();
        zzab zzab = new zzab(this);
        zzab.zzal();
        this.zzd = zzab;
        this.zzj.zzb().zza((zzac) this.zzb);
        zzq zzq2 = new zzq(this);
        zzq2.zzal();
        this.zzg = zzq2;
        zzig zzig = new zzig(this);
        zzig.zzal();
        this.zzi = zzig;
        zzkc zzkc = new zzkc(this);
        zzkc.zzal();
        this.zzf = zzkc;
        this.zze = new zzfd(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    public final zzv zzu() {
        return this.zzj.zzu();
    }

    public final zzaa zzb() {
        return this.zzj.zzb();
    }

    public final zzet zzr() {
        return this.zzj.zzr();
    }

    public final zzfu zzq() {
        return this.zzj.zzq();
    }

    public final zzfr zzc() {
        zzb((zzkd) this.zzb);
        return this.zzb;
    }

    public final zzfa zzd() {
        zzb((zzkd) this.zzc);
        return this.zzc;
    }

    public final zzab zze() {
        zzb((zzkd) this.zzd);
        return this.zzd;
    }

    private final zzfd zzt() {
        zzfd zzfd = this.zze;
        if (zzfd != null) {
            return zzfd;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkc zzv() {
        zzb((zzkd) this.zzf);
        return this.zzf;
    }

    public final zzq zzf() {
        zzb((zzkd) this.zzg);
        return this.zzg;
    }

    public final zzig zzg() {
        zzb((zzkd) this.zzi);
        return this.zzi;
    }

    public final zzkk zzh() {
        zzb((zzkd) this.zzh);
        return this.zzh;
    }

    public final zzer zzi() {
        return this.zzj.zzj();
    }

    public final Context zzn() {
        return this.zzj.zzn();
    }

    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final zzko zzj() {
        return this.zzj.zzi();
    }

    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzkd zzkd) {
        if (zzkd == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkd.zzaj()) {
            String valueOf = String.valueOf(zzkd.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzff zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaq zzaq, String str) {
        String str2;
        zzaq zzaq2 = zzaq;
        zzg zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzaq2.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzet.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzet.zza(str));
            return;
        }
        String zze2 = zzb2.zze();
        String zzl2 = zzb2.zzl();
        long zzm2 = zzb2.zzm();
        String zzn2 = zzb2.zzn();
        long zzo2 = zzb2.zzo();
        long zzp2 = zzb2.zzp();
        boolean zzr2 = zzb2.zzr();
        String zzi2 = zzb2.zzi();
        long zzae = zzb2.zzae();
        boolean zzaf = zzb2.zzaf();
        boolean zzag = zzb2.zzag();
        String zzf2 = zzb2.zzf();
        Boolean zzah = zzb2.zzah();
        long zzq2 = zzb2.zzq();
        List<String> zzai = zzb2.zzai();
        if (!zzle.zzb() || !this.zzj.zzb().zze(zzb2.zzc(), zzas.zzbo)) {
            str2 = null;
        } else {
            str2 = zzb2.zzg();
        }
        zzm zzm3 = r2;
        zzm zzm4 = new zzm(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, zzr2, false, zzi2, zzae, 0, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2);
        zza(zzaq2, zzm3);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaq zzaq, zzm zzm2) {
        List<zzy> list;
        List<zzy> list2;
        List<zzy> list3;
        zzaq zzaq2 = zzaq;
        zzm zzm3 = zzm2;
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm3.zza);
        zzw();
        zzk();
        String str = zzm3.zza;
        long j = zzaq2.zzd;
        zzh();
        if (zzkk.zza(zzaq, zzm2)) {
            if (!zzm3.zzh) {
                zzc(zzm3);
                return;
            }
            if (this.zzj.zzb().zze(str, zzas.zzbc) && zzm3.zzu != null) {
                if (zzm3.zzu.contains(zzaq2.zza)) {
                    Bundle zzb2 = zzaq2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzaq2 = new zzaq(zzaq2.zza, new zzal(zzb2), zzaq2.zzc, zzaq2.zzd);
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str, zzaq2.zza, zzaq2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzab zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzd();
                zze2.zzak();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zze2.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzet.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzy next : list) {
                    if (next != null) {
                        this.zzj.zzr().zzx().zza("User property timed out", next.zza, this.zzj.zzj().zzc(next.zzc.zza), next.zzc.zza());
                        if (next.zzg != null) {
                            zzb(new zzaq(next.zzg, j), zzm3);
                        }
                        zze().zze(str, next.zzc.zza);
                    }
                }
                zzab zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzd();
                zze3.zzak();
                if (i < 0) {
                    zze3.zzr().zzi().zza("Invalid time querying expired conditional properties", zzet.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzy next2 : list2) {
                    if (next2 != null) {
                        this.zzj.zzr().zzx().zza("User property expired", next2.zza, this.zzj.zzj().zzc(next2.zzc.zza), next2.zzc.zza());
                        zze().zzb(str, next2.zzc.zza);
                        if (next2.zzk != null) {
                            arrayList.add(next2.zzk);
                        }
                        zze().zze(str, next2.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    zzb(new zzaq((zzaq) obj, j), zzm3);
                }
                zzab zze4 = zze();
                String str2 = zzaq2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzd();
                zze4.zzak();
                if (i < 0) {
                    zze4.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzet.zza(str), zze4.zzo().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzy next3 : list3) {
                    if (next3 != null) {
                        zzkn zzkn = next3.zzc;
                        zzkp zzkp = r4;
                        zzkp zzkp2 = new zzkp(next3.zza, next3.zzb, zzkn.zza, j, zzkn.zza());
                        if (zze().zza(zzkp)) {
                            this.zzj.zzr().zzx().zza("User property triggered", next3.zza, this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                        } else {
                            this.zzj.zzr().zzf().zza("Too many active user properties, ignoring", zzet.zza(next3.zza), this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                        }
                        if (next3.zzi != null) {
                            arrayList3.add(next3.zzi);
                        }
                        next3.zzc = new zzkn(zzkp);
                        next3.zze = true;
                        zze().zza(next3);
                    }
                }
                zzb(zzaq2, zzm3);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    zzb(new zzaq((zzaq) obj2, j), zzm3);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x03b7 A[Catch:{ SQLiteException -> 0x037e, all -> 0x0a48 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03f4 A[Catch:{ SQLiteException -> 0x037e, all -> 0x0a48 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x042b A[Catch:{ SQLiteException -> 0x037e, all -> 0x0a48 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x043b A[Catch:{ SQLiteException -> 0x037e, all -> 0x0a48 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0470 A[Catch:{ SQLiteException -> 0x037e, all -> 0x0a48 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x09f5 A[Catch:{ SQLiteException -> 0x037e, all -> 0x0a48 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0246 A[Catch:{ SQLiteException -> 0x037e, all -> 0x0a48 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x024e A[Catch:{ SQLiteException -> 0x037e, all -> 0x0a48 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(com.google.android.gms.measurement.internal.zzaq r31, com.google.android.gms.measurement.internal.zzm r32) {
        /*
            r30 = this;
            r1 = r30
            r2 = r31
            r3 = r32
            java.lang.String r4 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r32)
            java.lang.String r5 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r30.zzw()
            r30.zzk()
            java.lang.String r15 = r3.zza
            r30.zzh()
            boolean r7 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.measurement.internal.zzaq) r31, (com.google.android.gms.measurement.internal.zzm) r32)
            if (r7 != 0) goto L_0x0026
            return
        L_0x0026:
            boolean r7 = r3.zzh
            if (r7 != 0) goto L_0x002e
            r1.zzc(r3)
            return
        L_0x002e:
            com.google.android.gms.measurement.internal.zzfr r7 = r30.zzc()
            java.lang.String r8 = r2.zza
            boolean r7 = r7.zzb(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            if (r7 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzi()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfr r3 = r30.zzc()
            boolean r3 = r3.zzg(r15)
            if (r3 != 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzfr r3 = r30.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r3 = 0
            goto L_0x0076
        L_0x0075:
            r3 = 1
        L_0x0076:
            if (r3 != 0) goto L_0x0092
            java.lang.String r4 = r2.zza
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x0092
            com.google.android.gms.measurement.internal.zzfx r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzko r7 = r4.zzi()
            r9 = 11
            java.lang.String r11 = r2.zza
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)
        L_0x0092:
            if (r3 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzb(r15)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.zzu()
            long r5 = r2.zzt()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzm()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzas.zzy
            java.lang.Object r5 = r5.zza(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzw()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zza((com.google.android.gms.measurement.internal.zzg) r2)
        L_0x00de:
            return
        L_0x00df:
            boolean r7 = com.google.android.gms.internal.measurement.zzjn.zzb()
            if (r7 == 0) goto L_0x01cf
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzck
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r8)
            if (r7 == 0) goto L_0x01cf
            com.google.android.gms.measurement.internal.zzex r7 = new com.google.android.gms.measurement.internal.zzex
            java.lang.String r8 = r2.zza
            java.lang.String r9 = r2.zzc
            com.google.android.gms.measurement.internal.zzal r10 = r2.zzb
            android.os.Bundle r19 = r10.zzb()
            long r11 = r2.zzd
            r16 = r7
            r17 = r8
            r18 = r9
            r20 = r11
            r16.<init>(r17, r18, r19, r20)
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzko r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzaa r8 = r8.zzb()
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzas.zzah
            r10 = 25
            r11 = 100
            int r8 = r8.zza(r15, r9, r10, r11)
            java.util.TreeSet r9 = new java.util.TreeSet
            android.os.Bundle r10 = r7.zzd
            java.util.Set r10 = r10.keySet()
            r9.<init>(r10)
            java.util.Iterator r9 = r9.iterator()
            r10 = 0
        L_0x0139:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x01ad
            java.lang.Object r11 = r9.next()
            java.lang.String r11 = (java.lang.String) r11
            boolean r12 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r11)
            if (r12 == 0) goto L_0x019f
            int r10 = r10 + 1
            if (r10 <= r8) goto L_0x0198
            r12 = 48
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r12)
            java.lang.String r12 = "Event can't contain more than "
            r13.append(r12)
            r13.append(r8)
            java.lang.String r12 = " params"
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            com.google.android.gms.measurement.internal.zzet r13 = r2.zzr()
            com.google.android.gms.measurement.internal.zzev r13 = r13.zzh()
            r31 = r8
            com.google.android.gms.measurement.internal.zzer r8 = r2.zzo()
            r17 = r9
            java.lang.String r9 = r7.zza
            java.lang.String r8 = r8.zza((java.lang.String) r9)
            com.google.android.gms.measurement.internal.zzer r9 = r2.zzo()
            r18 = r2
            android.os.Bundle r2 = r7.zzd
            java.lang.String r2 = r9.zza((android.os.Bundle) r2)
            r13.zza(r12, r8, r2)
            android.os.Bundle r2 = r7.zzd
            r8 = 5
            com.google.android.gms.measurement.internal.zzko.zzb((android.os.Bundle) r2, (int) r8)
            android.os.Bundle r2 = r7.zzd
            r2.remove(r11)
            goto L_0x01a5
        L_0x0198:
            r18 = r2
            r31 = r8
            r17 = r9
            goto L_0x01a5
        L_0x019f:
            r18 = r2
            r31 = r8
            r17 = r9
        L_0x01a5:
            r8 = r31
            r9 = r17
            r2 = r18
            r13 = 0
            goto L_0x0139
        L_0x01ad:
            com.google.android.gms.measurement.internal.zzaq r2 = new com.google.android.gms.measurement.internal.zzaq
            java.lang.String r8 = r7.zza
            com.google.android.gms.measurement.internal.zzal r9 = new com.google.android.gms.measurement.internal.zzal
            android.os.Bundle r10 = new android.os.Bundle
            android.os.Bundle r11 = r7.zzd
            r10.<init>(r11)
            r9.<init>(r10)
            java.lang.String r10 = r7.zzb
            long r11 = r7.zzc
            r22 = r2
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r22.<init>(r23, r24, r25, r26)
        L_0x01cf:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()
            r8 = 2
            boolean r7 = r7.zza((int) r8)
            if (r7 == 0) goto L_0x01f7
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzfx r9 = r1.zzj
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzj()
            java.lang.String r9 = r9.zza((com.google.android.gms.measurement.internal.zzaq) r2)
            java.lang.String r10 = "Logging event"
            r7.zza(r10, r9)
        L_0x01f7:
            com.google.android.gms.measurement.internal.zzab r7 = r30.zze()
            r7.zzf()
            r1.zzc(r3)     // Catch:{ all -> 0x0a48 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjt.zzb()     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0217
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzas.zzcj     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r9)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0217
            r7 = 1
            goto L_0x0218
        L_0x0217:
            r7 = 0
        L_0x0218:
            java.lang.String r9 = "ecommerce_purchase"
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0a48 }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0a48 }
            java.lang.String r10 = "refund"
            if (r9 != 0) goto L_0x023b
            if (r7 == 0) goto L_0x0239
            java.lang.String r7 = "purchase"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x023b
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0a48 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0239
            goto L_0x023b
        L_0x0239:
            r7 = 0
            goto L_0x023c
        L_0x023b:
            r7 = 1
        L_0x023c:
            java.lang.String r9 = "_iap"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a48 }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0a48 }
            if (r9 != 0) goto L_0x024b
            if (r7 == 0) goto L_0x0249
            goto L_0x024b
        L_0x0249:
            r9 = 0
            goto L_0x024c
        L_0x024b:
            r9 = 1
        L_0x024c:
            if (r9 == 0) goto L_0x0403
            com.google.android.gms.measurement.internal.zzal r9 = r2.zzb     // Catch:{ all -> 0x0a48 }
            java.lang.String r11 = "currency"
            java.lang.String r9 = r9.zzd(r11)     // Catch:{ all -> 0x0a48 }
            java.lang.String r11 = "value"
            if (r7 == 0) goto L_0x02cc
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x0a48 }
            java.lang.Double r7 = r7.zzc(r11)     // Catch:{ all -> 0x0a48 }
            double r12 = r7.doubleValue()     // Catch:{ all -> 0x0a48 }
            r17 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r12 = r12 * r17
            r19 = 0
            int r7 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r7 != 0) goto L_0x027f
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x0a48 }
            java.lang.Long r7 = r7.zzb(r11)     // Catch:{ all -> 0x0a48 }
            long r11 = r7.longValue()     // Catch:{ all -> 0x0a48 }
            double r11 = (double) r11     // Catch:{ all -> 0x0a48 }
            double r12 = r11 * r17
        L_0x027f:
            r17 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r7 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r7 > 0) goto L_0x02ae
            r17 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r7 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r7 < 0) goto L_0x02ae
            long r11 = java.lang.Math.round(r12)     // Catch:{ all -> 0x0a48 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjt.zzb()     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x02ad
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzas.zzcj     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r13)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x02ad
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0a48 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x02ad
            long r11 = -r11
            goto L_0x02d6
        L_0x02ad:
            goto L_0x02d6
        L_0x02ae:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzi()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)     // Catch:{ all -> 0x0a48 }
            java.lang.Double r10 = java.lang.Double.valueOf(r12)     // Catch:{ all -> 0x0a48 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x0a48 }
            r22 = r5
            r5 = 0
            r11 = 0
            goto L_0x03f2
        L_0x02cc:
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x0a48 }
            java.lang.Long r7 = r7.zzb(r11)     // Catch:{ all -> 0x0a48 }
            long r11 = r7.longValue()     // Catch:{ all -> 0x0a48 }
        L_0x02d6:
            boolean r7 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x03ee
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ all -> 0x0a48 }
            java.lang.String r7 = r9.toUpperCase(r7)     // Catch:{ all -> 0x0a48 }
            java.lang.String r9 = "[A-Z]{3}"
            boolean r9 = r7.matches(r9)     // Catch:{ all -> 0x0a48 }
            if (r9 == 0) goto L_0x03ea
            java.lang.String r9 = "_ltv_"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0a48 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0a48 }
            int r10 = r7.length()     // Catch:{ all -> 0x0a48 }
            if (r10 == 0) goto L_0x02ff
            java.lang.String r7 = r9.concat(r7)     // Catch:{ all -> 0x0a48 }
            goto L_0x0304
        L_0x02ff:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0a48 }
            r7.<init>(r9)     // Catch:{ all -> 0x0a48 }
        L_0x0304:
            r10 = r7
            com.google.android.gms.measurement.internal.zzab r7 = r30.zze()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzkp r7 = r7.zzc(r15, r10)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0344
            java.lang.Object r9 = r7.zze     // Catch:{ all -> 0x0a48 }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x0a48 }
            if (r9 != 0) goto L_0x031a
            r22 = r5
            r5 = 0
            r6 = 1
            goto L_0x0348
        L_0x031a:
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x0a48 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0a48 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzkp r17 = new com.google.android.gms.measurement.internal.zzkp     // Catch:{ all -> 0x0a48 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r13 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.common.util.Clock r13 = r13.zzm()     // Catch:{ all -> 0x0a48 }
            long r18 = r13.currentTimeMillis()     // Catch:{ all -> 0x0a48 }
            long r7 = r7 + r11
            java.lang.Long r13 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0a48 }
            r7 = r17
            r8 = r15
            r22 = r5
            r5 = 0
            r6 = 1
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x0a48 }
            r6 = r17
            goto L_0x03ad
        L_0x0344:
            r22 = r5
            r5 = 0
            r6 = 1
        L_0x0348:
            com.google.android.gms.measurement.internal.zzab r7 = r30.zze()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r9 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r9 = r9.zzb()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzas.zzad     // Catch:{ all -> 0x0a48 }
            int r9 = r9.zzb(r15, r13)     // Catch:{ all -> 0x0a48 }
            int r9 = r9 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0a48 }
            r7.zzd()     // Catch:{ all -> 0x0a48 }
            r7.zzak()     // Catch:{ all -> 0x0a48 }
            android.database.sqlite.SQLiteDatabase r13 = r7.c_()     // Catch:{ SQLiteException -> 0x037e }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x037e }
            r6[r5] = r15     // Catch:{ SQLiteException -> 0x037e }
            r16 = 1
            r6[r16] = r15     // Catch:{ SQLiteException -> 0x037e }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x037e }
            r16 = 2
            r6[r16] = r9     // Catch:{ SQLiteException -> 0x037e }
            r13.execSQL(r8, r6)     // Catch:{ SQLiteException -> 0x037e }
            goto L_0x0391
        L_0x037e:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzf()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)     // Catch:{ all -> 0x0a48 }
            r7.zza(r8, r9, r6)     // Catch:{ all -> 0x0a48 }
        L_0x0391:
            com.google.android.gms.measurement.internal.zzkp r17 = new com.google.android.gms.measurement.internal.zzkp     // Catch:{ all -> 0x0a48 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.common.util.Clock r6 = r6.zzm()     // Catch:{ all -> 0x0a48 }
            long r18 = r6.currentTimeMillis()     // Catch:{ all -> 0x0a48 }
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a48 }
            r7 = r17
            r8 = r15
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x0a48 }
            r6 = r17
        L_0x03ad:
            com.google.android.gms.measurement.internal.zzab r7 = r30.zze()     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzkp) r6)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x03f1
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzf()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r10 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzer r10 = r10.zzj()     // Catch:{ all -> 0x0a48 }
            java.lang.String r11 = r6.zzc     // Catch:{ all -> 0x0a48 }
            java.lang.String r10 = r10.zzc(r11)     // Catch:{ all -> 0x0a48 }
            java.lang.Object r6 = r6.zze     // Catch:{ all -> 0x0a48 }
            r7.zza(r8, r9, r10, r6)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzko r7 = r6.zzi()     // Catch:{ all -> 0x0a48 }
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x0a48 }
            goto L_0x03f1
        L_0x03ea:
            r22 = r5
            r5 = 0
            goto L_0x03f1
        L_0x03ee:
            r22 = r5
            r5 = 0
        L_0x03f1:
            r11 = 1
        L_0x03f2:
            if (r11 != 0) goto L_0x0406
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()     // Catch:{ all -> 0x0a48 }
            r2.b_()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()
            r2.zzh()
            return
        L_0x0403:
            r22 = r5
            r5 = 0
        L_0x0406:
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x0a48 }
            boolean r6 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r6)     // Catch:{ all -> 0x0a48 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0a48 }
            boolean r18 = r14.equals(r7)     // Catch:{ all -> 0x0a48 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjt.zzb()     // Catch:{ all -> 0x0a48 }
            r19 = 1
            if (r7 == 0) goto L_0x043b
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzas.zzcf     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x043b
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            r7.zzi()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x0a48 }
            long r7 = com.google.android.gms.measurement.internal.zzko.zza((com.google.android.gms.measurement.internal.zzal) r7)     // Catch:{ all -> 0x0a48 }
            long r7 = r7 + r19
            r11 = r7
            goto L_0x043d
        L_0x043b:
            r11 = r19
        L_0x043d:
            com.google.android.gms.measurement.internal.zzab r7 = r30.zze()     // Catch:{ all -> 0x0a48 }
            long r8 = r30.zzx()     // Catch:{ all -> 0x0a48 }
            r13 = 1
            r16 = 0
            r17 = 0
            r10 = r15
            r14 = r6
            r31 = r15
            r15 = r16
            r16 = r18
            com.google.android.gms.measurement.internal.zzae r7 = r7.zza(r8, r10, r11, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a48 }
            long r8 = r7.zzb     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzas.zzj     // Catch:{ all -> 0x0a48 }
            r14 = 0
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x0a48 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0a48 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0a48 }
            long r10 = (long) r10     // Catch:{ all -> 0x0a48 }
            long r8 = r8 - r10
            r12 = 0
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            r15 = 1000(0x3e8, double:4.94E-321)
            if (r10 <= 0) goto L_0x049e
            long r8 = r8 % r15
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x048f
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x0a48 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r31)     // Catch:{ all -> 0x0a48 }
            long r5 = r7.zzb     // Catch:{ all -> 0x0a48 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a48 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0a48 }
        L_0x048f:
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()     // Catch:{ all -> 0x0a48 }
            r2.b_()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()
            r2.zzh()
            return
        L_0x049e:
            if (r6 == 0) goto L_0x04f5
            long r8 = r7.zza     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzas.zzl     // Catch:{ all -> 0x0a48 }
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x0a48 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0a48 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0a48 }
            long r10 = (long) r10     // Catch:{ all -> 0x0a48 }
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x04f5
            long r8 = r8 % r15
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x04d3
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x0a48 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r31)     // Catch:{ all -> 0x0a48 }
            long r6 = r7.zza     // Catch:{ all -> 0x0a48 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a48 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x0a48 }
        L_0x04d3:
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzko r7 = r3.zzi()     // Catch:{ all -> 0x0a48 }
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a48 }
            r12 = 0
            r8 = r31
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()     // Catch:{ all -> 0x0a48 }
            r2.b_()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()
            r2.zzh()
            return
        L_0x04f5:
            if (r18 == 0) goto L_0x0545
            long r8 = r7.zzd     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r10 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r10 = r10.zzb()     // Catch:{ all -> 0x0a48 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzas.zzk     // Catch:{ all -> 0x0a48 }
            int r10 = r10.zzb(r11, r15)     // Catch:{ all -> 0x0a48 }
            r11 = 1000000(0xf4240, float:1.401298E-39)
            int r10 = java.lang.Math.min(r11, r10)     // Catch:{ all -> 0x0a48 }
            int r10 = java.lang.Math.max(r5, r10)     // Catch:{ all -> 0x0a48 }
            long r10 = (long) r10     // Catch:{ all -> 0x0a48 }
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0545
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0536
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x0a48 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r31)     // Catch:{ all -> 0x0a48 }
            long r5 = r7.zzd     // Catch:{ all -> 0x0a48 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a48 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0a48 }
        L_0x0536:
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()     // Catch:{ all -> 0x0a48 }
            r2.b_()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()
            r2.zzh()
            return
        L_0x0545:
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x0a48 }
            android.os.Bundle r15 = r7.zzb()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzko r7 = r7.zzi()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0a48 }
            r7.zza((android.os.Bundle) r15, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzko r7 = r7.zzi()     // Catch:{ all -> 0x0a48 }
            r11 = r31
            boolean r7 = r7.zzf(r11)     // Catch:{ all -> 0x0a48 }
            java.lang.String r10 = "_r"
            if (r7 == 0) goto L_0x0588
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzko r7 = r7.zzi()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = "_dbg"
            java.lang.Long r9 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0a48 }
            r7.zza((android.os.Bundle) r15, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzko r7 = r7.zzi()     // Catch:{ all -> 0x0a48 }
            java.lang.Long r8 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0a48 }
            r7.zza((android.os.Bundle) r15, (java.lang.String) r10, (java.lang.Object) r8)     // Catch:{ all -> 0x0a48 }
        L_0x0588:
            java.lang.String r7 = "_s"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x05b1
            com.google.android.gms.measurement.internal.zzab r7 = r30.zze()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzkp r7 = r7.zzc(r8, r4)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x05b1
            java.lang.Object r8 = r7.zze     // Catch:{ all -> 0x0a48 }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0a48 }
            if (r8 == 0) goto L_0x05b1
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzko r8 = r8.zzi()     // Catch:{ all -> 0x0a48 }
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x0a48 }
            r8.zza((android.os.Bundle) r15, (java.lang.String) r4, (java.lang.Object) r7)     // Catch:{ all -> 0x0a48 }
        L_0x05b1:
            com.google.android.gms.measurement.internal.zzab r4 = r30.zze()     // Catch:{ all -> 0x0a48 }
            long r7 = r4.zzc(r11)     // Catch:{ all -> 0x0a48 }
            int r4 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x05d5
            com.google.android.gms.measurement.internal.zzfx r4 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzi()     // Catch:{ all -> 0x0a48 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r11)     // Catch:{ all -> 0x0a48 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0a48 }
            r4.zza(r9, r5, r7)     // Catch:{ all -> 0x0a48 }
        L_0x05d5:
            com.google.android.gms.measurement.internal.zzaj r4 = new com.google.android.gms.measurement.internal.zzaj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0a48 }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x0a48 }
            long r12 = r2.zzd     // Catch:{ all -> 0x0a48 }
            r18 = 0
            r7 = r4
            r2 = r10
            r10 = r11
            r29 = r11
            r11 = r5
            r28 = r14
            r5 = r15
            r14 = r18
            r16 = r5
            r7.<init>((com.google.android.gms.measurement.internal.zzfx) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r5 = r30.zze()     // Catch:{ all -> 0x0a48 }
            java.lang.String r7 = r4.zzb     // Catch:{ all -> 0x0a48 }
            r8 = r29
            com.google.android.gms.measurement.internal.zzam r5 = r5.zza((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ all -> 0x0a48 }
            if (r5 != 0) goto L_0x0677
            com.google.android.gms.measurement.internal.zzab r5 = r30.zze()     // Catch:{ all -> 0x0a48 }
            long r9 = r5.zzh(r8)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r5 = r5.zzb()     // Catch:{ all -> 0x0a48 }
            int r5 = r5.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            long r11 = (long) r5     // Catch:{ all -> 0x0a48 }
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x065e
            if (r6 == 0) goto L_0x065e
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x0a48 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzj()     // Catch:{ all -> 0x0a48 }
            java.lang.String r4 = r4.zzb     // Catch:{ all -> 0x0a48 }
            java.lang.String r4 = r6.zza((java.lang.String) r4)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r6 = r6.zzb()     // Catch:{ all -> 0x0a48 }
            int r6 = r6.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0a48 }
            r2.zza(r3, r5, r4, r6)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzko r7 = r2.zzi()     // Catch:{ all -> 0x0a48 }
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()
            r2.zzh()
            return
        L_0x065e:
            com.google.android.gms.measurement.internal.zzam r5 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x0a48 }
            java.lang.String r9 = r4.zzb     // Catch:{ all -> 0x0a48 }
            r10 = 0
            r12 = 0
            long r14 = r4.zzc     // Catch:{ all -> 0x0a48 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r5
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x0a48 }
            goto L_0x0685
        L_0x0677:
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x0a48 }
            long r7 = r5.zzf     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaj r4 = r4.zza(r6, r7)     // Catch:{ all -> 0x0a48 }
            long r6 = r4.zzc     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzam r5 = r5.zza(r6)     // Catch:{ all -> 0x0a48 }
        L_0x0685:
            com.google.android.gms.measurement.internal.zzab r6 = r30.zze()     // Catch:{ all -> 0x0a48 }
            r6.zza((com.google.android.gms.measurement.internal.zzam) r5)     // Catch:{ all -> 0x0a48 }
            r30.zzw()     // Catch:{ all -> 0x0a48 }
            r30.zzk()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r32)     // Catch:{ all -> 0x0a48 }
            java.lang.String r5 = r4.zza     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x0a48 }
            java.lang.String r5 = r4.zza     // Catch:{ all -> 0x0a48 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a48 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r5 = com.google.android.gms.internal.measurement.zzbw.zzg.zzbf()     // Catch:{ all -> 0x0a48 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r5 = r5.zza((int) r6)     // Catch:{ all -> 0x0a48 }
            java.lang.String r7 = "android"
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r5 = r5.zza((java.lang.String) r7)     // Catch:{ all -> 0x0a48 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x06c5
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a48 }
            r5.zzf((java.lang.String) r7)     // Catch:{ all -> 0x0a48 }
        L_0x06c5:
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x06d2
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x0a48 }
            r5.zze((java.lang.String) r7)     // Catch:{ all -> 0x0a48 }
        L_0x06d2:
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x06df
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0a48 }
            r5.zzg((java.lang.String) r7)     // Catch:{ all -> 0x0a48 }
        L_0x06df:
            long r7 = r3.zzj     // Catch:{ all -> 0x0a48 }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x06ee
            long r7 = r3.zzj     // Catch:{ all -> 0x0a48 }
            int r7 = (int) r7     // Catch:{ all -> 0x0a48 }
            r5.zzh((int) r7)     // Catch:{ all -> 0x0a48 }
        L_0x06ee:
            long r7 = r3.zze     // Catch:{ all -> 0x0a48 }
            r5.zzf((long) r7)     // Catch:{ all -> 0x0a48 }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x0700
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x0a48 }
            r5.zzk((java.lang.String) r7)     // Catch:{ all -> 0x0a48 }
        L_0x0700:
            boolean r7 = com.google.android.gms.internal.measurement.zzle.zzb()     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x074f
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzas.zzbo     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x074f
            java.lang.String r7 = r5.zzl()     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x072d
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x072d
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x0a48 }
            r5.zzp(r7)     // Catch:{ all -> 0x0a48 }
        L_0x072d:
            java.lang.String r7 = r5.zzl()     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0766
            java.lang.String r7 = r5.zzo()     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0766
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x0766
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0a48 }
            r5.zzo(r7)     // Catch:{ all -> 0x0a48 }
            goto L_0x0766
        L_0x074f:
            java.lang.String r7 = r5.zzl()     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0766
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x0766
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0a48 }
            r5.zzo(r7)     // Catch:{ all -> 0x0a48 }
        L_0x0766:
            long r7 = r3.zzf     // Catch:{ all -> 0x0a48 }
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0773
            long r7 = r3.zzf     // Catch:{ all -> 0x0a48 }
            r5.zzh((long) r7)     // Catch:{ all -> 0x0a48 }
        L_0x0773:
            long r7 = r3.zzt     // Catch:{ all -> 0x0a48 }
            r5.zzk((long) r7)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzas.zzaw     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.zze(r8, r11)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0796
            com.google.android.gms.measurement.internal.zzkk r7 = r30.zzh()     // Catch:{ all -> 0x0a48 }
            java.util.List r7 = r7.zzf()     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0796
            r5.zzd((java.lang.Iterable<? extends java.lang.Integer>) r7)     // Catch:{ all -> 0x0a48 }
        L_0x0796:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzff r7 = r7.zzc()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a48 }
            android.util.Pair r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x07ca
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x0a48 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x0a48 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a48 }
            if (r8 != 0) goto L_0x07ca
            boolean r8 = r3.zzo     // Catch:{ all -> 0x0a48 }
            if (r8 == 0) goto L_0x0831
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a48 }
            r5.zzh((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            java.lang.Object r8 = r7.second     // Catch:{ all -> 0x0a48 }
            if (r8 == 0) goto L_0x0831
            java.lang.Object r7 = r7.second     // Catch:{ all -> 0x0a48 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0a48 }
            r5.zza((boolean) r7)     // Catch:{ all -> 0x0a48 }
            goto L_0x0831
        L_0x07ca:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzak r7 = r7.zzx()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            android.content.Context r8 = r8.zzn()     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.zza(r8)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x0831
            boolean r7 = r3.zzp     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0831
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            android.content.Context r7 = r7.zzn()     // Catch:{ all -> 0x0a48 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r8)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x0810
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzi()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = "null secure ID. appId"
            java.lang.String r11 = r5.zzj()     // Catch:{ all -> 0x0a48 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r11)     // Catch:{ all -> 0x0a48 }
            r7.zza(r8, r11)     // Catch:{ all -> 0x0a48 }
            java.lang.String r7 = "null"
            goto L_0x082e
        L_0x0810:
            boolean r8 = r7.isEmpty()     // Catch:{ all -> 0x0a48 }
            if (r8 == 0) goto L_0x082e
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzi()     // Catch:{ all -> 0x0a48 }
            java.lang.String r11 = "empty secure ID. appId"
            java.lang.String r12 = r5.zzj()     // Catch:{ all -> 0x0a48 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r12)     // Catch:{ all -> 0x0a48 }
            r8.zza(r11, r12)     // Catch:{ all -> 0x0a48 }
        L_0x082e:
            r5.zzm(r7)     // Catch:{ all -> 0x0a48 }
        L_0x0831:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzak r7 = r7.zzx()     // Catch:{ all -> 0x0a48 }
            r7.zzaa()     // Catch:{ all -> 0x0a48 }
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r7 = r5.zzc((java.lang.String) r7)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzak r8 = r8.zzx()     // Catch:{ all -> 0x0a48 }
            r8.zzaa()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r7 = r7.zzb((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzak r8 = r8.zzx()     // Catch:{ all -> 0x0a48 }
            long r11 = r8.zzf()     // Catch:{ all -> 0x0a48 }
            int r8 = (int) r11     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r7 = r7.zzf((int) r8)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzak r8 = r8.zzx()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x0a48 }
            r7.zzd((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzcm     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r8)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x0880
            long r7 = r3.zzl     // Catch:{ all -> 0x0a48 }
            r5.zzj((long) r7)     // Catch:{ all -> 0x0a48 }
        L_0x0880:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0a48 }
            boolean r7 = r7.zzab()     // Catch:{ all -> 0x0a48 }
            if (r7 == 0) goto L_0x0896
            r5.zzj()     // Catch:{ all -> 0x0a48 }
            boolean r7 = android.text.TextUtils.isEmpty(r28)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x0896
            r7 = r28
            r5.zzn(r7)     // Catch:{ all -> 0x0a48 }
        L_0x0896:
            com.google.android.gms.measurement.internal.zzab r7 = r30.zze()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzb(r8)     // Catch:{ all -> 0x0a48 }
            if (r7 != 0) goto L_0x091a
            com.google.android.gms.measurement.internal.zzg r7 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a48 }
            r7.<init>(r8, r11)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzko r8 = r8.zzi()     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r8.zzk()     // Catch:{ all -> 0x0a48 }
            r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zzk     // Catch:{ all -> 0x0a48 }
            r7.zzf((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0a48 }
            r7.zzb((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzff r8 = r8.zzc()     // Catch:{ all -> 0x0a48 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r8.zzb((java.lang.String) r11)     // Catch:{ all -> 0x0a48 }
            r7.zze((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            r7.zzg((long) r9)     // Catch:{ all -> 0x0a48 }
            r7.zza((long) r9)     // Catch:{ all -> 0x0a48 }
            r7.zzb((long) r9)     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a48 }
            r7.zzg((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            long r11 = r3.zzj     // Catch:{ all -> 0x0a48 }
            r7.zzc((long) r11)     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a48 }
            r7.zzh((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            long r11 = r3.zze     // Catch:{ all -> 0x0a48 }
            r7.zzd((long) r11)     // Catch:{ all -> 0x0a48 }
            long r11 = r3.zzf     // Catch:{ all -> 0x0a48 }
            r7.zze((long) r11)     // Catch:{ all -> 0x0a48 }
            boolean r8 = r3.zzh     // Catch:{ all -> 0x0a48 }
            r7.zza((boolean) r8)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r8 = r8.zzb()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzas.zzcm     // Catch:{ all -> 0x0a48 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0a48 }
            if (r8 != 0) goto L_0x090e
            long r11 = r3.zzl     // Catch:{ all -> 0x0a48 }
            r7.zzp(r11)     // Catch:{ all -> 0x0a48 }
        L_0x090e:
            long r11 = r3.zzt     // Catch:{ all -> 0x0a48 }
            r7.zzf((long) r11)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r8 = r30.zze()     // Catch:{ all -> 0x0a48 }
            r8.zza((com.google.android.gms.measurement.internal.zzg) r7)     // Catch:{ all -> 0x0a48 }
        L_0x091a:
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0a48 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a48 }
            if (r8 != 0) goto L_0x092b
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0a48 }
            r5.zzi((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
        L_0x092b:
            java.lang.String r8 = r7.zzi()     // Catch:{ all -> 0x0a48 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a48 }
            if (r8 != 0) goto L_0x093c
            java.lang.String r7 = r7.zzi()     // Catch:{ all -> 0x0a48 }
            r5.zzl((java.lang.String) r7)     // Catch:{ all -> 0x0a48 }
        L_0x093c:
            com.google.android.gms.measurement.internal.zzab r7 = r30.zze()     // Catch:{ all -> 0x0a48 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0a48 }
            java.util.List r3 = r7.zza((java.lang.String) r3)     // Catch:{ all -> 0x0a48 }
            r11 = 0
        L_0x0947:
            int r7 = r3.size()     // Catch:{ all -> 0x0a48 }
            if (r11 >= r7) goto L_0x097e
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r7 = com.google.android.gms.internal.measurement.zzbw.zzk.zzj()     // Catch:{ all -> 0x0a48 }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzkp r8 = (com.google.android.gms.measurement.internal.zzkp) r8     // Catch:{ all -> 0x0a48 }
            java.lang.String r8 = r8.zzc     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a48 }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzkp r8 = (com.google.android.gms.measurement.internal.zzkp) r8     // Catch:{ all -> 0x0a48 }
            long r12 = r8.zzd     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r7 = r7.zza((long) r12)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzkk r8 = r30.zzh()     // Catch:{ all -> 0x0a48 }
            java.lang.Object r12 = r3.get(r11)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzkp r12 = (com.google.android.gms.measurement.internal.zzkp) r12     // Catch:{ all -> 0x0a48 }
            java.lang.Object r12 = r12.zze     // Catch:{ all -> 0x0a48 }
            r8.zza((com.google.android.gms.internal.measurement.zzbw.zzk.zza) r7, (java.lang.Object) r12)     // Catch:{ all -> 0x0a48 }
            r5.zza((com.google.android.gms.internal.measurement.zzbw.zzk.zza) r7)     // Catch:{ all -> 0x0a48 }
            int r11 = r11 + 1
            goto L_0x0947
        L_0x097e:
            com.google.android.gms.measurement.internal.zzab r3 = r30.zze()     // Catch:{ IOException -> 0x09f8 }
            com.google.android.gms.internal.measurement.zzgt r7 = r5.zzu()     // Catch:{ IOException -> 0x09f8 }
            com.google.android.gms.internal.measurement.zzfi r7 = (com.google.android.gms.internal.measurement.zzfi) r7     // Catch:{ IOException -> 0x09f8 }
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = (com.google.android.gms.internal.measurement.zzbw.zzg) r7     // Catch:{ IOException -> 0x09f8 }
            long r7 = r3.zza((com.google.android.gms.internal.measurement.zzbw.zzg) r7)     // Catch:{ IOException -> 0x09f8 }
            com.google.android.gms.measurement.internal.zzab r3 = r30.zze()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzal r5 = r4.zze     // Catch:{ all -> 0x0a48 }
            if (r5 == 0) goto L_0x09ee
            com.google.android.gms.measurement.internal.zzal r5 = r4.zze     // Catch:{ all -> 0x0a48 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0a48 }
        L_0x099e:
            boolean r11 = r5.hasNext()     // Catch:{ all -> 0x0a48 }
            if (r11 == 0) goto L_0x09b3
            java.lang.Object r11 = r5.next()     // Catch:{ all -> 0x0a48 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0a48 }
            boolean r11 = r2.equals(r11)     // Catch:{ all -> 0x0a48 }
            if (r11 == 0) goto L_0x09b2
            r11 = r6
            goto L_0x09ef
        L_0x09b2:
            goto L_0x099e
        L_0x09b3:
            com.google.android.gms.measurement.internal.zzfr r2 = r30.zzc()     // Catch:{ all -> 0x0a48 }
            java.lang.String r5 = r4.zza     // Catch:{ all -> 0x0a48 }
            java.lang.String r11 = r4.zzb     // Catch:{ all -> 0x0a48 }
            boolean r2 = r2.zzc(r5, r11)     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r11 = r30.zze()     // Catch:{ all -> 0x0a48 }
            long r12 = r30.zzx()     // Catch:{ all -> 0x0a48 }
            java.lang.String r14 = r4.zza     // Catch:{ all -> 0x0a48 }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            com.google.android.gms.measurement.internal.zzae r5 = r11.zza(r12, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0a48 }
            if (r2 == 0) goto L_0x09ee
            long r11 = r5.zze     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0a48 }
            java.lang.String r5 = r4.zza     // Catch:{ all -> 0x0a48 }
            int r2 = r2.zzb(r5)     // Catch:{ all -> 0x0a48 }
            long r13 = (long) r2     // Catch:{ all -> 0x0a48 }
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x09ee
            r11 = r6
            goto L_0x09ef
        L_0x09ee:
            r11 = 0
        L_0x09ef:
            boolean r2 = r3.zza((com.google.android.gms.measurement.internal.zzaj) r4, (long) r7, (boolean) r11)     // Catch:{ all -> 0x0a48 }
            if (r2 == 0) goto L_0x0a13
            r1.zzm = r9     // Catch:{ all -> 0x0a48 }
            goto L_0x0a13
        L_0x09f8:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzr()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x0a48 }
            java.lang.String r4 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r5 = r5.zzj()     // Catch:{ all -> 0x0a48 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0a48 }
            r3.zza(r4, r5, r2)     // Catch:{ all -> 0x0a48 }
        L_0x0a13:
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()     // Catch:{ all -> 0x0a48 }
            r2.b_()     // Catch:{ all -> 0x0a48 }
            com.google.android.gms.measurement.internal.zzab r2 = r30.zze()
            r2.zzh()
            r30.zzz()
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzx()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r22
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x0a48:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzab r3 = r30.zze()
            r3.zzh()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zzb(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzm):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        String d_;
        zzg zzb2;
        String str;
        String str2;
        String zza2;
        zzw();
        zzk();
        this.zzs = true;
        try {
            this.zzj.zzu();
            Boolean zzag = this.zzj.zzw().zzag();
            if (zzag == null) {
                this.zzj.zzr().zzi().zza("Upload data called on the client side before use of service was decided");
                this.zzs = false;
                zzaa();
            } else if (zzag.booleanValue()) {
                this.zzj.zzr().zzf().zza("Upload called in the client side when service should be used");
                this.zzs = false;
                zzaa();
            } else if (this.zzm > 0) {
                zzz();
                this.zzs = false;
                zzaa();
            } else {
                zzw();
                if (this.zzv != null) {
                    this.zzj.zzr().zzx().zza("Uploading requested multiple times");
                    this.zzs = false;
                    zzaa();
                } else if (!zzd().zzf()) {
                    this.zzj.zzr().zzx().zza("Network not connected, ignoring upload request");
                    zzz();
                    this.zzs = false;
                    zzaa();
                } else {
                    long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
                    int zzb3 = this.zzj.zzb().zzb((String) null, zzas.zzap);
                    long zzv2 = currentTimeMillis - zzaa.zzv();
                    for (int i = 0; i < zzb3 && zza((String) null, zzv2); i++) {
                    }
                    long zza3 = this.zzj.zzc().zzc.zza();
                    if (zza3 != 0) {
                        this.zzj.zzr().zzw().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza3)));
                    }
                    d_ = zze().d_();
                    if (!TextUtils.isEmpty(d_)) {
                        if (this.zzx == -1) {
                            this.zzx = zze().zzaa();
                        }
                        List<Pair<zzbw.zzg, Long>> zza4 = zze().zza(d_, this.zzj.zzb().zzb(d_, zzas.zzf), Math.max(0, this.zzj.zzb().zzb(d_, zzas.zzg)));
                        if (!zza4.isEmpty()) {
                            Iterator<Pair<zzbw.zzg, Long>> it = zza4.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzbw.zzg zzg2 = (zzbw.zzg) it.next().first;
                                if (!TextUtils.isEmpty(zzg2.zzad())) {
                                    str = zzg2.zzad();
                                    break;
                                }
                            }
                            if (str != null) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= zza4.size()) {
                                        break;
                                    }
                                    zzbw.zzg zzg3 = (zzbw.zzg) zza4.get(i2).first;
                                    if (!TextUtils.isEmpty(zzg3.zzad()) && !zzg3.zzad().equals(str)) {
                                        zza4 = zza4.subList(0, i2);
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            zzbw.zzf.zza zzb4 = zzbw.zzf.zzb();
                            int size = zza4.size();
                            ArrayList arrayList = new ArrayList(zza4.size());
                            boolean zzf2 = this.zzj.zzb().zzf(d_);
                            for (int i3 = 0; i3 < size; i3++) {
                                zzbw.zzg.zza zza5 = (zzbw.zzg.zza) ((zzbw.zzg) zza4.get(i3).first).zzbm();
                                arrayList.add((Long) zza4.get(i3).second);
                                zzbw.zzg.zza zza6 = zza5.zzg(this.zzj.zzb().zzf()).zza(currentTimeMillis);
                                this.zzj.zzu();
                                zza6.zzb(false);
                                if (!zzf2) {
                                    zza5.zzn();
                                }
                                if (this.zzj.zzb().zze(d_, zzas.zzay)) {
                                    zza5.zzl(zzh().zza(((zzbw.zzg) ((zzfi) zza5.zzu())).zzbi()));
                                }
                                zzb4.zza(zza5);
                            }
                            if (this.zzj.zzr().zza(2)) {
                                str2 = zzh().zza((zzbw.zzf) ((zzfi) zzb4.zzu()));
                            } else {
                                str2 = null;
                            }
                            zzh();
                            byte[] zzbi = ((zzbw.zzf) ((zzfi) zzb4.zzu())).zzbi();
                            zza2 = zzas.zzp.zza(null);
                            URL url = new URL(zza2);
                            Preconditions.checkArgument(!arrayList.isEmpty());
                            if (this.zzv != null) {
                                this.zzj.zzr().zzf().zza("Set uploading progress before finishing the previous upload");
                            } else {
                                this.zzv = new ArrayList(arrayList);
                            }
                            this.zzj.zzc().zzd.zza(currentTimeMillis);
                            String str3 = "?";
                            if (size > 0) {
                                str3 = zzb4.zza(0).zzx();
                            }
                            this.zzj.zzr().zzx().zza("Uploading data. app, uncompressed size, data", str3, Integer.valueOf(zzbi.length), str2);
                            this.zzr = true;
                            zzfa zzd2 = zzd();
                            zzki zzki = new zzki(this, d_);
                            zzd2.zzd();
                            zzd2.zzak();
                            Preconditions.checkNotNull(url);
                            Preconditions.checkNotNull(zzbi);
                            Preconditions.checkNotNull(zzki);
                            zzd2.zzq().zzb((Runnable) new zzfe(zzd2, d_, url, zzbi, (Map<String, String>) null, zzki));
                        }
                    } else {
                        this.zzx = -1;
                        String zza7 = zze().zza(currentTimeMillis - zzaa.zzv());
                        if (!TextUtils.isEmpty(zza7) && (zzb2 = zze().zzb(zza7)) != null) {
                            zza(zzb2);
                        }
                    }
                    this.zzs = false;
                    zzaa();
                }
            }
        } catch (MalformedURLException e) {
            this.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", zzet.zza(d_), zza2);
        } catch (Throwable th) {
            this.zzs = false;
            zzaa();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0267 A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0275 A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03c9 A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03cb A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03ce A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03cf A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x05e2 A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x06b1 A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x06c8 A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0888 A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x08a4 A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x08bf A[Catch:{ IOException -> 0x0223, all -> 0x0fff }] */
    /* JADX WARNING: Removed duplicated region for block: B:570:0x0fe2  */
    /* JADX WARNING: Removed duplicated region for block: B:578:0x0ff9 A[SYNTHETIC, Splitter:B:578:0x0ff9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r44, long r45) {
        /*
            r43 = this;
            r1 = r43
            java.lang.String r2 = "_npa"
            java.lang.String r3 = ""
            com.google.android.gms.measurement.internal.zzab r4 = r43.zze()
            r4.zzf()
            com.google.android.gms.measurement.internal.zzkg$zza r4 = new com.google.android.gms.measurement.internal.zzkg$zza     // Catch:{ all -> 0x0fff }
            r5 = 0
            r4.<init>(r1, r5)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzab r6 = r43.zze()     // Catch:{ all -> 0x0fff }
            long r7 = r1.zzx     // Catch:{ all -> 0x0fff }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0fff }
            r6.zzd()     // Catch:{ all -> 0x0fff }
            r6.zzak()     // Catch:{ all -> 0x0fff }
            r10 = -1
            r12 = 2
            r13 = 0
            r14 = 1
            android.database.sqlite.SQLiteDatabase r15 = r6.c_()     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            boolean r16 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            if (r16 == 0) goto L_0x009c
            int r16 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r16 == 0) goto L_0x004b
            java.lang.String[] r9 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0046 }
            java.lang.String r17 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0046 }
            r9[r13] = r17     // Catch:{ SQLiteException -> 0x0046 }
            java.lang.String r17 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x0046 }
            r9[r14] = r17     // Catch:{ SQLiteException -> 0x0046 }
            goto L_0x0053
        L_0x0046:
            r0 = move-exception
            r7 = r0
            r9 = r5
            goto L_0x024c
        L_0x004b:
            java.lang.String[] r9 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            java.lang.String r17 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            r9[r13] = r17     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
        L_0x0053:
            if (r16 == 0) goto L_0x005b
            java.lang.String r16 = "rowid <= ? and "
            r45 = r16
            goto L_0x005d
        L_0x005b:
            r45 = r3
        L_0x005d:
            java.lang.String r16 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            int r5 = r16.length()     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            int r5 = r5 + 148
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            r12.<init>(r5)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            java.lang.String r5 = "select app_id, metadata_fingerprint from raw_events where "
            r12.append(r5)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            r5 = r45
            r12.append(r5)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r12.append(r5)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            java.lang.String r5 = r12.toString()     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            android.database.Cursor r5 = r15.rawQuery(r5, r9)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            boolean r9 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x023f }
            if (r9 != 0) goto L_0x0090
            if (r5 == 0) goto L_0x008e
            r5.close()     // Catch:{ all -> 0x0fff }
        L_0x008e:
            goto L_0x0262
        L_0x0090:
            java.lang.String r9 = r5.getString(r13)     // Catch:{ SQLiteException -> 0x023f }
            java.lang.String r12 = r5.getString(r14)     // Catch:{ SQLiteException -> 0x023c }
            r5.close()     // Catch:{ SQLiteException -> 0x023c }
            goto L_0x00f2
        L_0x009c:
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x00ad
            r9 = 2
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            r9 = 0
            r12[r13] = r9     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            java.lang.String r9 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            r12[r14] = r9     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            goto L_0x00b2
        L_0x00ad:
            r9 = 0
            java.lang.String[] r12 = new java.lang.String[]{r9}     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
        L_0x00b2:
            if (r5 == 0) goto L_0x00b8
            java.lang.String r5 = " and rowid <= ?"
            goto L_0x00b9
        L_0x00b8:
            r5 = r3
        L_0x00b9:
            java.lang.String r9 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            int r9 = r9.length()     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            int r9 = r9 + 84
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            r10.<init>(r9)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            java.lang.String r9 = "select metadata_fingerprint from raw_events where app_id = ?"
            r10.append(r9)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            r10.append(r5)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            java.lang.String r5 = " order by rowid limit 1;"
            r10.append(r5)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            java.lang.String r5 = r10.toString()     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            android.database.Cursor r5 = r15.rawQuery(r5, r12)     // Catch:{ SQLiteException -> 0x0248, all -> 0x0242 }
            boolean r9 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x023f }
            if (r9 != 0) goto L_0x00ea
            if (r5 == 0) goto L_0x00e8
            r5.close()     // Catch:{ all -> 0x0fff }
        L_0x00e8:
            goto L_0x0262
        L_0x00ea:
            java.lang.String r12 = r5.getString(r13)     // Catch:{ SQLiteException -> 0x023f }
            r5.close()     // Catch:{ SQLiteException -> 0x023f }
            r9 = 0
        L_0x00f2:
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String r10 = "metadata"
            java.lang.String[] r17 = new java.lang.String[]{r10}     // Catch:{ SQLiteException -> 0x023c }
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            r10 = 2
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x023c }
            r11[r13] = r9     // Catch:{ SQLiteException -> 0x023c }
            r11[r14] = r12     // Catch:{ SQLiteException -> 0x023c }
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            java.lang.String r23 = "2"
            r10 = r15
            r19 = r11
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x023c }
            boolean r11 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x023c }
            if (r11 != 0) goto L_0x0130
            com.google.android.gms.measurement.internal.zzet r7 = r6.zzr()     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzf()     // Catch:{ SQLiteException -> 0x023c }
            java.lang.String r8 = "Raw event metadata record is missing. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x023c }
            r7.zza(r8, r10)     // Catch:{ SQLiteException -> 0x023c }
            if (r5 == 0) goto L_0x012e
            r5.close()     // Catch:{ all -> 0x0fff }
        L_0x012e:
            goto L_0x0262
        L_0x0130:
            byte[] r11 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r15 = com.google.android.gms.internal.measurement.zzbw.zzg.zzbf()     // Catch:{ IOException -> 0x0223 }
            com.google.android.gms.internal.measurement.zzgs r11 = com.google.android.gms.measurement.internal.zzkk.zza(r15, (byte[]) r11)     // Catch:{ IOException -> 0x0223 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r11 = (com.google.android.gms.internal.measurement.zzbw.zzg.zza) r11     // Catch:{ IOException -> 0x0223 }
            com.google.android.gms.internal.measurement.zzgt r11 = r11.zzu()     // Catch:{ IOException -> 0x0223 }
            com.google.android.gms.internal.measurement.zzfi r11 = (com.google.android.gms.internal.measurement.zzfi) r11     // Catch:{ IOException -> 0x0223 }
            com.google.android.gms.internal.measurement.zzbw$zzg r11 = (com.google.android.gms.internal.measurement.zzbw.zzg) r11     // Catch:{ IOException -> 0x0223 }
            boolean r15 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x023c }
            if (r15 == 0) goto L_0x015e
            com.google.android.gms.measurement.internal.zzet r15 = r6.zzr()     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.measurement.internal.zzev r15 = r15.zzi()     // Catch:{ SQLiteException -> 0x023c }
            java.lang.String r14 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x023c }
            r15.zza(r14, r13)     // Catch:{ SQLiteException -> 0x023c }
        L_0x015e:
            r5.close()     // Catch:{ SQLiteException -> 0x023c }
            r4.zza(r11)     // Catch:{ SQLiteException -> 0x023c }
            r13 = -1
            int r11 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x0181
            java.lang.String r11 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x023c }
            r13 = 0
            r14[r13] = r9     // Catch:{ SQLiteException -> 0x023c }
            r13 = 1
            r14[r13] = r12     // Catch:{ SQLiteException -> 0x023c }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x023c }
            r8 = 2
            r14[r8] = r7     // Catch:{ SQLiteException -> 0x023c }
            r18 = r11
            r19 = r14
            goto L_0x0190
        L_0x0181:
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            r8 = 2
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x023c }
            r8 = 0
            r11[r8] = r9     // Catch:{ SQLiteException -> 0x023c }
            r8 = 1
            r11[r8] = r12     // Catch:{ SQLiteException -> 0x023c }
            r18 = r7
            r19 = r11
        L_0x0190:
            java.lang.String r16 = "raw_events"
            java.lang.String r7 = "rowid"
            java.lang.String r8 = "name"
            java.lang.String r11 = "timestamp"
            java.lang.String r12 = "data"
            java.lang.String[] r17 = new java.lang.String[]{r7, r8, r11, r12}     // Catch:{ SQLiteException -> 0x023c }
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            r23 = 0
            r15 = r10
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x023c }
            boolean r7 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x023c }
            if (r7 != 0) goto L_0x01c9
            com.google.android.gms.measurement.internal.zzet r7 = r6.zzr()     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzi()     // Catch:{ SQLiteException -> 0x023c }
            java.lang.String r8 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x023c }
            r7.zza(r8, r10)     // Catch:{ SQLiteException -> 0x023c }
            if (r5 == 0) goto L_0x01c7
            r5.close()     // Catch:{ all -> 0x0fff }
        L_0x01c7:
            goto L_0x0262
        L_0x01c9:
            r7 = 0
            long r10 = r5.getLong(r7)     // Catch:{ SQLiteException -> 0x023c }
            r7 = 3
            byte[] r8 = r5.getBlob(r7)     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r7 = com.google.android.gms.internal.measurement.zzbw.zzc.zzj()     // Catch:{ IOException -> 0x0203 }
            com.google.android.gms.internal.measurement.zzgs r7 = com.google.android.gms.measurement.internal.zzkk.zza(r7, (byte[]) r8)     // Catch:{ IOException -> 0x0203 }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r7     // Catch:{ IOException -> 0x0203 }
            r8 = 1
            java.lang.String r12 = r5.getString(r8)     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r8 = r7.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x023c }
            r12 = 2
            long r13 = r5.getLong(r12)     // Catch:{ SQLiteException -> 0x023c }
            r8.zza((long) r13)     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.internal.measurement.zzgt r7 = r7.zzu()     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.internal.measurement.zzfi r7 = (com.google.android.gms.internal.measurement.zzfi) r7     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.internal.measurement.zzbw$zzc r7 = (com.google.android.gms.internal.measurement.zzbw.zzc) r7     // Catch:{ SQLiteException -> 0x023c }
            boolean r7 = r4.zza(r10, r7)     // Catch:{ SQLiteException -> 0x023c }
            if (r7 != 0) goto L_0x0217
            if (r5 == 0) goto L_0x0202
            r5.close()     // Catch:{ all -> 0x0fff }
        L_0x0202:
            goto L_0x0262
        L_0x0203:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzet r8 = r6.zzr()     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzf()     // Catch:{ SQLiteException -> 0x023c }
            java.lang.String r10 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x023c }
            r8.zza(r10, r11, r7)     // Catch:{ SQLiteException -> 0x023c }
        L_0x0217:
            boolean r7 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x023c }
            if (r7 != 0) goto L_0x01c9
            if (r5 == 0) goto L_0x0262
            r5.close()     // Catch:{ all -> 0x0fff }
            goto L_0x0262
        L_0x0223:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzet r8 = r6.zzr()     // Catch:{ SQLiteException -> 0x023c }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzf()     // Catch:{ SQLiteException -> 0x023c }
            java.lang.String r10 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x023c }
            r8.zza(r10, r11, r7)     // Catch:{ SQLiteException -> 0x023c }
            if (r5 == 0) goto L_0x023b
            r5.close()     // Catch:{ all -> 0x0fff }
        L_0x023b:
            goto L_0x0262
        L_0x023c:
            r0 = move-exception
            r7 = r0
            goto L_0x024c
        L_0x023f:
            r0 = move-exception
            r7 = r0
            goto L_0x024b
        L_0x0242:
            r0 = move-exception
            r2 = r1
            r5 = 0
        L_0x0245:
            r1 = r0
            goto L_0x0ff7
        L_0x0248:
            r0 = move-exception
            r7 = r0
            r5 = 0
        L_0x024b:
            r9 = 0
        L_0x024c:
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzr()     // Catch:{ all -> 0x0ff3 }
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzf()     // Catch:{ all -> 0x0ff3 }
            java.lang.String r8 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ all -> 0x0ff3 }
            r6.zza(r8, r9, r7)     // Catch:{ all -> 0x0ff3 }
            if (r5 == 0) goto L_0x0262
            r5.close()     // Catch:{ all -> 0x0fff }
        L_0x0262:
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r5 = r4.zzc     // Catch:{ all -> 0x0fff }
            if (r5 == 0) goto L_0x0272
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r5 = r4.zzc     // Catch:{ all -> 0x0fff }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0fff }
            if (r5 == 0) goto L_0x0270
            goto L_0x0272
        L_0x0270:
            r5 = 0
            goto L_0x0273
        L_0x0272:
            r5 = 1
        L_0x0273:
            if (r5 != 0) goto L_0x0fe2
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r5 = r5.zzbm()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r5 = (com.google.android.gms.internal.measurement.zzfi.zzb) r5     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r5 = (com.google.android.gms.internal.measurement.zzbw.zzg.zza) r5     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r5 = r5.zzc()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzaa r6 = r6.zzb()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzau     // Catch:{ all -> 0x0fff }
            boolean r6 = r6.zze(r7, r8)     // Catch:{ all -> 0x0fff }
            r7 = -1
            r8 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x02a6:
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r9 = r4.zzc     // Catch:{ all -> 0x0fff }
            int r9 = r9.size()     // Catch:{ all -> 0x0fff }
            r18 = r3
            java.lang.String r3 = "_fr"
            r19 = r13
            java.lang.String r13 = "_et"
            r20 = r2
            java.lang.String r2 = "_e"
            r21 = r14
            r22 = r15
            if (r12 >= r9) goto L_0x091d
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r9 = r4.zzc     // Catch:{ all -> 0x0fff }
            java.lang.Object r9 = r9.get(r12)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r9 = (com.google.android.gms.internal.measurement.zzbw.zzc) r9     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r9 = r9.zzbm()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r9 = (com.google.android.gms.internal.measurement.zzfi.zzb) r9     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r9 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzfr r14 = r43.zzc()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r15 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0fff }
            r16 = r12
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x0fff }
            boolean r12 = r14.zzb(r15, r12)     // Catch:{ all -> 0x0fff }
            java.lang.String r14 = "_err"
            if (r12 == 0) goto L_0x0367
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzi()     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r12 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r12)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzfx r13 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzj()     // Catch:{ all -> 0x0fff }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x0fff }
            java.lang.String r13 = r13.zza((java.lang.String) r15)     // Catch:{ all -> 0x0fff }
            r2.zza(r3, r12, r13)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzfr r2 = r43.zzc()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r3 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0fff }
            boolean r2 = r2.zzg(r3)     // Catch:{ all -> 0x0fff }
            if (r2 != 0) goto L_0x0333
            com.google.android.gms.measurement.internal.zzfr r2 = r43.zzc()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r3 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0fff }
            boolean r2 = r2.zzh(r3)     // Catch:{ all -> 0x0fff }
            if (r2 == 0) goto L_0x0331
            goto L_0x0333
        L_0x0331:
            r2 = 0
            goto L_0x0334
        L_0x0333:
            r2 = 1
        L_0x0334:
            if (r2 != 0) goto L_0x035a
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0fff }
            boolean r2 = r14.equals(r2)     // Catch:{ all -> 0x0fff }
            if (r2 != 0) goto L_0x035a
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzko r24 = r2.zzi()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r2 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r25 = r2.zzx()     // Catch:{ all -> 0x0fff }
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r9.zzd()     // Catch:{ all -> 0x0fff }
            r29 = 0
            r24.zza((java.lang.String) r25, (int) r26, (java.lang.String) r27, (java.lang.String) r28, (int) r29)     // Catch:{ all -> 0x0fff }
        L_0x035a:
            r26 = r6
            r12 = r16
            r13 = r19
            r14 = r21
            r15 = r22
            r6 = r5
            goto L_0x0912
        L_0x0367:
            com.google.android.gms.measurement.internal.zzfr r12 = r43.zzc()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r15 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0fff }
            r26 = r6
            java.lang.String r6 = r9.zzd()     // Catch:{ all -> 0x0fff }
            boolean r6 = r12.zzc(r15, r6)     // Catch:{ all -> 0x0fff }
            java.lang.String r12 = "_c"
            if (r6 != 0) goto L_0x03da
            r43.zzh()     // Catch:{ all -> 0x0fff }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0fff }
            r27 = r7
            int r7 = r15.hashCode()     // Catch:{ all -> 0x0fff }
            r28 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r7 == r10) goto L_0x03b6
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r7 == r10) goto L_0x03ac
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r7 == r10) goto L_0x03a2
        L_0x03a1:
            goto L_0x03c0
        L_0x03a2:
            java.lang.String r7 = "_ui"
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0fff }
            if (r7 == 0) goto L_0x03a1
            r7 = 1
            goto L_0x03c1
        L_0x03ac:
            java.lang.String r7 = "_ug"
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0fff }
            if (r7 == 0) goto L_0x03a1
            r7 = 2
            goto L_0x03c1
        L_0x03b6:
            java.lang.String r7 = "_in"
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0fff }
            if (r7 == 0) goto L_0x03a1
            r7 = 0
            goto L_0x03c1
        L_0x03c0:
            r7 = -1
        L_0x03c1:
            if (r7 == 0) goto L_0x03cb
            r10 = 1
            if (r7 == r10) goto L_0x03cb
            r10 = 2
            if (r7 == r10) goto L_0x03cb
            r7 = 0
            goto L_0x03cc
        L_0x03cb:
            r7 = 1
        L_0x03cc:
            if (r7 == 0) goto L_0x03cf
            goto L_0x03de
        L_0x03cf:
            r30 = r5
            r31 = r8
            r10 = r11
            r29 = r13
            r13 = r2
            r11 = r3
            goto L_0x05e0
        L_0x03da:
            r27 = r7
            r28 = r10
        L_0x03de:
            r7 = 0
            r10 = 0
            r15 = 0
        L_0x03e3:
            r29 = r13
            int r13 = r9.zzb()     // Catch:{ all -> 0x0fff }
            r30 = r5
            java.lang.String r5 = "_r"
            if (r15 >= r13) goto L_0x045b
            com.google.android.gms.internal.measurement.zzbw$zze r13 = r9.zza((int) r15)     // Catch:{ all -> 0x0fff }
            java.lang.String r13 = r13.zzb()     // Catch:{ all -> 0x0fff }
            boolean r13 = r12.equals(r13)     // Catch:{ all -> 0x0fff }
            if (r13 == 0) goto L_0x0420
            com.google.android.gms.internal.measurement.zzbw$zze r5 = r9.zza((int) r15)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r5 = r5.zzbm()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r5 = (com.google.android.gms.internal.measurement.zzfi.zzb) r5     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r5 = (com.google.android.gms.internal.measurement.zzbw.zze.zza) r5     // Catch:{ all -> 0x0fff }
            r13 = r8
            r7 = 1
            com.google.android.gms.internal.measurement.zzbw$zze$zza r5 = r5.zza((long) r7)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r5 = r5.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r5 = (com.google.android.gms.internal.measurement.zzfi) r5     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r5 = (com.google.android.gms.internal.measurement.zzbw.zze) r5     // Catch:{ all -> 0x0fff }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzbw.zze) r5)     // Catch:{ all -> 0x0fff }
            r8 = r11
            r7 = 1
            goto L_0x0452
        L_0x0420:
            r13 = r8
            com.google.android.gms.internal.measurement.zzbw$zze r8 = r9.zza((int) r15)     // Catch:{ all -> 0x0fff }
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0fff }
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0fff }
            if (r5 == 0) goto L_0x0451
            com.google.android.gms.internal.measurement.zzbw$zze r5 = r9.zza((int) r15)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r5 = r5.zzbm()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r5 = (com.google.android.gms.internal.measurement.zzfi.zzb) r5     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r5 = (com.google.android.gms.internal.measurement.zzbw.zze.zza) r5     // Catch:{ all -> 0x0fff }
            r8 = r11
            r10 = 1
            com.google.android.gms.internal.measurement.zzbw$zze$zza r5 = r5.zza((long) r10)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r5 = r5.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r5 = (com.google.android.gms.internal.measurement.zzfi) r5     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r5 = (com.google.android.gms.internal.measurement.zzbw.zze) r5     // Catch:{ all -> 0x0fff }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzbw.zze) r5)     // Catch:{ all -> 0x0fff }
            r10 = 1
            goto L_0x0452
        L_0x0451:
            r8 = r11
        L_0x0452:
            int r15 = r15 + 1
            r11 = r8
            r8 = r13
            r13 = r29
            r5 = r30
            goto L_0x03e3
        L_0x045b:
            r13 = r8
            r8 = r11
            if (r7 != 0) goto L_0x0496
            if (r6 == 0) goto L_0x0496
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.String r11 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfx r15 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzer r15 = r15.zzj()     // Catch:{ all -> 0x0fff }
            r31 = r13
            java.lang.String r13 = r9.zzd()     // Catch:{ all -> 0x0fff }
            java.lang.String r13 = r15.zza((java.lang.String) r13)     // Catch:{ all -> 0x0fff }
            r7.zza(r11, r13)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r7 = com.google.android.gms.internal.measurement.zzbw.zze.zzk()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r7 = r7.zza((java.lang.String) r12)     // Catch:{ all -> 0x0fff }
            r13 = r2
            r11 = r3
            r2 = 1
            com.google.android.gms.internal.measurement.zzbw$zze$zza r7 = r7.zza((long) r2)     // Catch:{ all -> 0x0fff }
            r9.zza((com.google.android.gms.internal.measurement.zzbw.zze.zza) r7)     // Catch:{ all -> 0x0fff }
            goto L_0x049a
        L_0x0496:
            r11 = r3
            r31 = r13
            r13 = r2
        L_0x049a:
            if (r10 != 0) goto L_0x04ce
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzj()     // Catch:{ all -> 0x0fff }
            java.lang.String r10 = r9.zzd()     // Catch:{ all -> 0x0fff }
            java.lang.String r7 = r7.zza((java.lang.String) r10)     // Catch:{ all -> 0x0fff }
            r2.zza(r3, r7)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r2 = com.google.android.gms.internal.measurement.zzbw.zze.zzk()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r2 = r2.zza((java.lang.String) r5)     // Catch:{ all -> 0x0fff }
            r3 = r8
            r7 = 1
            com.google.android.gms.internal.measurement.zzbw$zze$zza r2 = r2.zza((long) r7)     // Catch:{ all -> 0x0fff }
            r9.zza((com.google.android.gms.internal.measurement.zzbw.zze.zza) r2)     // Catch:{ all -> 0x0fff }
            goto L_0x04cf
        L_0x04ce:
            r3 = r8
        L_0x04cf:
            com.google.android.gms.measurement.internal.zzab r32 = r43.zze()     // Catch:{ all -> 0x0fff }
            long r33 = r43.zzx()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r2 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r35 = r2.zzx()     // Catch:{ all -> 0x0fff }
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 1
            com.google.android.gms.measurement.internal.zzae r2 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0fff }
            long r7 = r2.zze     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r10 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x0fff }
            int r2 = r2.zzb(r10)     // Catch:{ all -> 0x0fff }
            r10 = r3
            long r2 = (long) r2     // Catch:{ all -> 0x0fff }
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0509
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r5)     // Catch:{ all -> 0x0fff }
            goto L_0x050b
        L_0x0509:
            r19 = 1
        L_0x050b:
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0fff }
            boolean r2 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r2)     // Catch:{ all -> 0x0fff }
            if (r2 == 0) goto L_0x05e0
            if (r6 == 0) goto L_0x05e0
            com.google.android.gms.measurement.internal.zzab r32 = r43.zze()     // Catch:{ all -> 0x0fff }
            long r33 = r43.zzx()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r2 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r35 = r2.zzx()     // Catch:{ all -> 0x0fff }
            r36 = 0
            r37 = 0
            r38 = 1
            r39 = 0
            r40 = 0
            com.google.android.gms.measurement.internal.zzae r2 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0fff }
            long r2 = r2.zzc     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzaa r5 = r5.zzb()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzas.zzm     // Catch:{ all -> 0x0fff }
            int r5 = r5.zzb(r7, r8)     // Catch:{ all -> 0x0fff }
            long r7 = (long) r5     // Catch:{ all -> 0x0fff }
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x05e0
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzi()     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0fff }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0fff }
            r2 = -1
            r3 = 0
            r5 = 0
            r7 = 0
        L_0x056e:
            int r8 = r9.zzb()     // Catch:{ all -> 0x0fff }
            if (r7 >= r8) goto L_0x059c
            com.google.android.gms.internal.measurement.zzbw$zze r8 = r9.zza((int) r7)     // Catch:{ all -> 0x0fff }
            java.lang.String r15 = r8.zzb()     // Catch:{ all -> 0x0fff }
            boolean r15 = r12.equals(r15)     // Catch:{ all -> 0x0fff }
            if (r15 == 0) goto L_0x058e
            com.google.android.gms.internal.measurement.zzfi$zzb r2 = r8.zzbm()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r2 = (com.google.android.gms.internal.measurement.zzfi.zzb) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zze.zza) r2     // Catch:{ all -> 0x0fff }
            r3 = r2
            r2 = r7
            goto L_0x0599
        L_0x058e:
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0fff }
            boolean r8 = r14.equals(r8)     // Catch:{ all -> 0x0fff }
            if (r8 == 0) goto L_0x0599
            r5 = 1
        L_0x0599:
            int r7 = r7 + 1
            goto L_0x056e
        L_0x059c:
            if (r5 == 0) goto L_0x05a5
            if (r3 == 0) goto L_0x05a5
            r9.zzb((int) r2)     // Catch:{ all -> 0x0fff }
            goto L_0x05e0
        L_0x05a5:
            if (r3 == 0) goto L_0x05c6
            java.lang.Object r3 = r3.clone()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r3 = (com.google.android.gms.internal.measurement.zzfi.zzb) r3     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r3 = (com.google.android.gms.internal.measurement.zzbw.zze.zza) r3     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r3 = r3.zza((java.lang.String) r14)     // Catch:{ all -> 0x0fff }
            r7 = 10
            com.google.android.gms.internal.measurement.zzbw$zze$zza r3 = r3.zza((long) r7)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r3 = r3.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r3 = (com.google.android.gms.internal.measurement.zzfi) r3     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r3 = (com.google.android.gms.internal.measurement.zzbw.zze) r3     // Catch:{ all -> 0x0fff }
            r9.zza((int) r2, (com.google.android.gms.internal.measurement.zzbw.zze) r3)     // Catch:{ all -> 0x0fff }
            goto L_0x05e0
        L_0x05c6:
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0fff }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0fff }
        L_0x05e0:
            if (r6 == 0) goto L_0x06b1
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0fff }
            java.util.List r3 = r9.zza()     // Catch:{ all -> 0x0fff }
            r2.<init>(r3)     // Catch:{ all -> 0x0fff }
            r3 = 0
            r5 = -1
            r6 = -1
        L_0x05f1:
            int r7 = r2.size()     // Catch:{ all -> 0x0fff }
            java.lang.String r8 = "currency"
            java.lang.String r14 = "value"
            if (r3 >= r7) goto L_0x0621
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r7 = (com.google.android.gms.internal.measurement.zzbw.zze) r7     // Catch:{ all -> 0x0fff }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x0fff }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0fff }
            if (r7 == 0) goto L_0x060d
            r5 = r3
            goto L_0x061e
        L_0x060d:
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r7 = (com.google.android.gms.internal.measurement.zzbw.zze) r7     // Catch:{ all -> 0x0fff }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x0fff }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0fff }
            if (r7 == 0) goto L_0x061e
            r6 = r3
        L_0x061e:
            int r3 = r3 + 1
            goto L_0x05f1
        L_0x0621:
            r3 = -1
            if (r5 == r3) goto L_0x06af
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r3 = (com.google.android.gms.internal.measurement.zzbw.zze) r3     // Catch:{ all -> 0x0fff }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x0fff }
            if (r3 != 0) goto L_0x065b
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r3 = (com.google.android.gms.internal.measurement.zzbw.zze) r3     // Catch:{ all -> 0x0fff }
            boolean r3 = r3.zzg()     // Catch:{ all -> 0x0fff }
            if (r3 != 0) goto L_0x065b
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzk()     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)     // Catch:{ all -> 0x0fff }
            r9.zzb((int) r5)     // Catch:{ all -> 0x0fff }
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r12)     // Catch:{ all -> 0x0fff }
            r2 = 18
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (int) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0fff }
            r3 = -1
            r7 = 3
            goto L_0x06b3
        L_0x065b:
            r3 = -1
            if (r6 != r3) goto L_0x0662
            r2 = 1
            r7 = 3
            goto L_0x0690
        L_0x0662:
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r2 = (com.google.android.gms.internal.measurement.zzbw.zze) r2     // Catch:{ all -> 0x0fff }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x0fff }
            int r6 = r2.length()     // Catch:{ all -> 0x0fff }
            r7 = 3
            if (r6 == r7) goto L_0x0675
            r2 = 1
            goto L_0x0690
        L_0x0675:
            r6 = 0
        L_0x0676:
            int r14 = r2.length()     // Catch:{ all -> 0x0fff }
            if (r6 >= r14) goto L_0x068f
            int r14 = r2.codePointAt(r6)     // Catch:{ all -> 0x0fff }
            boolean r15 = java.lang.Character.isLetter(r14)     // Catch:{ all -> 0x0fff }
            if (r15 != 0) goto L_0x0689
            r2 = 1
            goto L_0x0690
        L_0x0689:
            int r14 = java.lang.Character.charCount(r14)     // Catch:{ all -> 0x0fff }
            int r6 = r6 + r14
            goto L_0x0676
        L_0x068f:
            r2 = 0
        L_0x0690:
            if (r2 == 0) goto L_0x06b3
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzk()     // Catch:{ all -> 0x0fff }
            java.lang.String r6 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r6)     // Catch:{ all -> 0x0fff }
            r9.zzb((int) r5)     // Catch:{ all -> 0x0fff }
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r12)     // Catch:{ all -> 0x0fff }
            r2 = 19
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (int) r2, (java.lang.String) r8)     // Catch:{ all -> 0x0fff }
            goto L_0x06b3
        L_0x06af:
            r7 = 3
            goto L_0x06b3
        L_0x06b1:
            r3 = -1
            r7 = 3
        L_0x06b3:
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x0fff }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x0fff }
            if (r2 == 0) goto L_0x0888
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0fff }
            r5 = r13
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0fff }
            r12 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x073d
            r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r2 = r9.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r2 = (com.google.android.gms.internal.measurement.zzbw.zzc) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r2 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r2, (java.lang.String) r11)     // Catch:{ all -> 0x0fff }
            if (r2 != 0) goto L_0x0733
            if (r10 == 0) goto L_0x0725
            long r14 = r10.zzf()     // Catch:{ all -> 0x0fff }
            long r24 = r9.zzf()     // Catch:{ all -> 0x0fff }
            long r14 = r14 - r24
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x0fff }
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x0720
            java.lang.Object r2 = r10.clone()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r2 = (com.google.android.gms.internal.measurement.zzfi.zzb) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2     // Catch:{ all -> 0x0fff }
            boolean r6 = r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2)     // Catch:{ all -> 0x0fff }
            if (r6 == 0) goto L_0x071a
            r6 = r30
            r8 = r31
            r6.zza((int) r8, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2)     // Catch:{ all -> 0x0fff }
            r7 = r27
            r14 = r29
            r10 = 0
            r28 = 0
            goto L_0x0892
        L_0x071a:
            r6 = r30
            r8 = r31
            goto L_0x072b
        L_0x0720:
            r6 = r30
            r8 = r31
            goto L_0x0729
        L_0x0725:
            r6 = r30
            r8 = r31
        L_0x0729:
        L_0x072b:
            r28 = r9
            r7 = r21
            r14 = r29
            goto L_0x0892
        L_0x0733:
            r6 = r30
            r8 = r31
            r11 = r27
            r14 = r29
            goto L_0x0891
        L_0x073d:
            r6 = r30
            r8 = r31
            java.lang.String r2 = "_vs"
            java.lang.String r11 = r9.zzd()     // Catch:{ all -> 0x0fff }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x0fff }
            if (r2 == 0) goto L_0x07a4
            r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r2 = r9.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r2 = (com.google.android.gms.internal.measurement.zzbw.zzc) r2     // Catch:{ all -> 0x0fff }
            r14 = r29
            com.google.android.gms.internal.measurement.zzbw$zze r2 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0fff }
            if (r2 != 0) goto L_0x07a0
            if (r28 == 0) goto L_0x0796
            long r10 = r28.zzf()     // Catch:{ all -> 0x0fff }
            long r24 = r9.zzf()     // Catch:{ all -> 0x0fff }
            long r10 = r10 - r24
            long r10 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0fff }
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x0793
            java.lang.Object r2 = r28.clone()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r2 = (com.google.android.gms.internal.measurement.zzfi.zzb) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2     // Catch:{ all -> 0x0fff }
            boolean r10 = r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9)     // Catch:{ all -> 0x0fff }
            if (r10 == 0) goto L_0x078f
            r11 = r27
            r6.zza((int) r11, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2)     // Catch:{ all -> 0x0fff }
            r7 = r11
            r10 = 0
            r28 = 0
            goto L_0x0892
        L_0x078f:
            r11 = r27
            goto L_0x079a
        L_0x0793:
            r11 = r27
            goto L_0x0798
        L_0x0796:
            r11 = r27
        L_0x0798:
        L_0x079a:
            r10 = r9
            r7 = r11
            r8 = r21
            goto L_0x0892
        L_0x07a0:
            r11 = r27
            goto L_0x0891
        L_0x07a4:
            r11 = r27
            r14 = r29
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r12 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzas.zzbs     // Catch:{ all -> 0x0fff }
            boolean r2 = r2.zze(r12, r13)     // Catch:{ all -> 0x0fff }
            if (r2 == 0) goto L_0x0891
            java.lang.String r2 = "_ab"
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x0fff }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x0fff }
            if (r2 == 0) goto L_0x0891
            r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r2 = r9.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r2 = (com.google.android.gms.internal.measurement.zzbw.zzc) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r2 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0fff }
            if (r2 != 0) goto L_0x0891
            if (r28 == 0) goto L_0x0891
            long r12 = r28.zzf()     // Catch:{ all -> 0x0fff }
            long r24 = r9.zzf()     // Catch:{ all -> 0x0fff }
            long r12 = r12 - r24
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0fff }
            r24 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r12 > r24 ? 1 : (r12 == r24 ? 0 : -1))
            if (r2 > 0) goto L_0x0891
            java.lang.Object r2 = r28.clone()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi$zzb r2 = (com.google.android.gms.internal.measurement.zzfi.zzb) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2     // Catch:{ all -> 0x0fff }
            r1.zzb((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9)     // Catch:{ all -> 0x0fff }
            java.lang.String r12 = r2.zzd()     // Catch:{ all -> 0x0fff }
            boolean r12 = r5.equals(r12)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r12)     // Catch:{ all -> 0x0fff }
            r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r12 = r2.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r12 = (com.google.android.gms.internal.measurement.zzfi) r12     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r12 = (com.google.android.gms.internal.measurement.zzbw.zzc) r12     // Catch:{ all -> 0x0fff }
            java.lang.String r13 = "_sn"
            com.google.android.gms.internal.measurement.zzbw$zze r12 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r12, (java.lang.String) r13)     // Catch:{ all -> 0x0fff }
            r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r13 = r2.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r13 = (com.google.android.gms.internal.measurement.zzfi) r13     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r13 = (com.google.android.gms.internal.measurement.zzbw.zzc) r13     // Catch:{ all -> 0x0fff }
            java.lang.String r15 = "_sc"
            com.google.android.gms.internal.measurement.zzbw$zze r13 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r13, (java.lang.String) r15)     // Catch:{ all -> 0x0fff }
            r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r15 = r2.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r15 = (com.google.android.gms.internal.measurement.zzfi) r15     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r15 = (com.google.android.gms.internal.measurement.zzbw.zzc) r15     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = "_si"
            com.google.android.gms.internal.measurement.zzbw$zze r3 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r15, (java.lang.String) r3)     // Catch:{ all -> 0x0fff }
            if (r12 == 0) goto L_0x0844
            java.lang.String r12 = r12.zzd()     // Catch:{ all -> 0x0fff }
            goto L_0x0846
        L_0x0844:
            r12 = r18
        L_0x0846:
            boolean r15 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0fff }
            if (r15 != 0) goto L_0x0855
            com.google.android.gms.measurement.internal.zzkk r15 = r43.zzh()     // Catch:{ all -> 0x0fff }
            java.lang.String r7 = "_sn"
            r15.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r7, (java.lang.Object) r12)     // Catch:{ all -> 0x0fff }
        L_0x0855:
            if (r13 == 0) goto L_0x085c
            java.lang.String r7 = r13.zzd()     // Catch:{ all -> 0x0fff }
            goto L_0x085e
        L_0x085c:
            r7 = r18
        L_0x085e:
            boolean r12 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0fff }
            if (r12 != 0) goto L_0x086d
            com.google.android.gms.measurement.internal.zzkk r12 = r43.zzh()     // Catch:{ all -> 0x0fff }
            java.lang.String r13 = "_sc"
            r12.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r13, (java.lang.Object) r7)     // Catch:{ all -> 0x0fff }
        L_0x086d:
            if (r3 == 0) goto L_0x0880
            com.google.android.gms.measurement.internal.zzkk r7 = r43.zzh()     // Catch:{ all -> 0x0fff }
            java.lang.String r12 = "_si"
            long r24 = r3.zzf()     // Catch:{ all -> 0x0fff }
            java.lang.Long r3 = java.lang.Long.valueOf(r24)     // Catch:{ all -> 0x0fff }
            r7.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r12, (java.lang.Object) r3)     // Catch:{ all -> 0x0fff }
        L_0x0880:
            r6.zza((int) r11, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2)     // Catch:{ all -> 0x0fff }
            r7 = r11
            r28 = 0
            goto L_0x0892
        L_0x0888:
            r5 = r13
            r11 = r27
            r14 = r29
            r6 = r30
            r8 = r31
        L_0x0891:
            r7 = r11
        L_0x0892:
            if (r26 != 0) goto L_0x08f6
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0fff }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0fff }
            if (r2 == 0) goto L_0x08f6
            int r2 = r9.zzb()     // Catch:{ all -> 0x0fff }
            if (r2 != 0) goto L_0x08bf
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzi()     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0fff }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0fff }
            goto L_0x08f6
        L_0x08bf:
            com.google.android.gms.measurement.internal.zzkk r2 = r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r3 = r9.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r3 = (com.google.android.gms.internal.measurement.zzfi) r3     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r3 = (com.google.android.gms.internal.measurement.zzbw.zzc) r3     // Catch:{ all -> 0x0fff }
            java.lang.Object r2 = r2.zzb(r3, r14)     // Catch:{ all -> 0x0fff }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0fff }
            if (r2 != 0) goto L_0x08ef
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzi()     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0fff }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0fff }
            goto L_0x08f6
        L_0x08ef:
            long r2 = r2.longValue()     // Catch:{ all -> 0x0fff }
            long r2 = r22 + r2
            goto L_0x08f8
        L_0x08f6:
            r2 = r22
        L_0x08f8:
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r5 = r4.zzc     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r11 = r9.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r11 = (com.google.android.gms.internal.measurement.zzfi) r11     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r11 = (com.google.android.gms.internal.measurement.zzbw.zzc) r11     // Catch:{ all -> 0x0fff }
            r12 = r16
            r5.set(r12, r11)     // Catch:{ all -> 0x0fff }
            int r14 = r21 + 1
            r6.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9)     // Catch:{ all -> 0x0fff }
            r15 = r2
            r11 = r10
            r13 = r19
            r10 = r28
        L_0x0912:
            int r12 = r12 + 1
            r5 = r6
            r3 = r18
            r2 = r20
            r6 = r26
            goto L_0x02a6
        L_0x091d:
            r11 = r3
            r26 = r6
            r14 = r13
            r6 = r5
            r5 = r2
            if (r26 == 0) goto L_0x097b
            r2 = r21
            r15 = r22
            r3 = 0
        L_0x092a:
            if (r3 >= r2) goto L_0x0979
            com.google.android.gms.internal.measurement.zzbw$zzc r7 = r6.zzb((int) r3)     // Catch:{ all -> 0x0fff }
            java.lang.String r8 = r7.zzc()     // Catch:{ all -> 0x0fff }
            boolean r8 = r5.equals(r8)     // Catch:{ all -> 0x0fff }
            if (r8 == 0) goto L_0x094b
            r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r8 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r7, (java.lang.String) r11)     // Catch:{ all -> 0x0fff }
            if (r8 == 0) goto L_0x094b
            r6.zzc((int) r3)     // Catch:{ all -> 0x0fff }
            int r2 = r2 + -1
            int r3 = r3 + -1
            goto L_0x0976
        L_0x094b:
            r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r7 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r7, (java.lang.String) r14)     // Catch:{ all -> 0x0fff }
            if (r7 == 0) goto L_0x0976
            boolean r8 = r7.zze()     // Catch:{ all -> 0x0fff }
            if (r8 == 0) goto L_0x0964
            long r7 = r7.zzf()     // Catch:{ all -> 0x0fff }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0fff }
            goto L_0x0965
        L_0x0964:
            r7 = 0
        L_0x0965:
            if (r7 == 0) goto L_0x0976
            long r8 = r7.longValue()     // Catch:{ all -> 0x0fff }
            r12 = 0
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x0976
            long r7 = r7.longValue()     // Catch:{ all -> 0x0fff }
            long r15 = r15 + r7
        L_0x0976:
            r7 = 1
            int r3 = r3 + r7
            goto L_0x092a
        L_0x0979:
            r2 = r15
            goto L_0x097d
        L_0x097b:
            r2 = r22
        L_0x097d:
            r5 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6, (long) r2, (boolean) r5)     // Catch:{ all -> 0x0fff }
            java.util.List r5 = r6.zza()     // Catch:{ all -> 0x0fff }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0fff }
        L_0x098a:
            boolean r7 = r5.hasNext()     // Catch:{ all -> 0x0fff }
            if (r7 == 0) goto L_0x09a6
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r7 = (com.google.android.gms.internal.measurement.zzbw.zzc) r7     // Catch:{ all -> 0x0fff }
            java.lang.String r8 = "_s"
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x0fff }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0fff }
            if (r7 == 0) goto L_0x09a5
            r5 = 1
            goto L_0x09a7
        L_0x09a5:
            goto L_0x098a
        L_0x09a6:
            r5 = 0
        L_0x09a7:
            java.lang.String r7 = "_se"
            if (r5 == 0) goto L_0x09b6
            com.google.android.gms.measurement.internal.zzab r5 = r43.zze()     // Catch:{ all -> 0x0fff }
            java.lang.String r8 = r6.zzj()     // Catch:{ all -> 0x0fff }
            r5.zzb((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ all -> 0x0fff }
        L_0x09b6:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6, (java.lang.String) r5)     // Catch:{ all -> 0x0fff }
            if (r5 < 0) goto L_0x09c0
            r5 = 1
            goto L_0x09c1
        L_0x09c0:
            r5 = 0
        L_0x09c1:
            if (r5 == 0) goto L_0x09c8
            r5 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6, (long) r2, (boolean) r5)     // Catch:{ all -> 0x0fff }
            goto L_0x09ec
        L_0x09c8:
            int r2 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0fff }
            if (r2 < 0) goto L_0x09ec
            r6.zze((int) r2)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0fff }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0fff }
        L_0x09ec:
            com.google.android.gms.measurement.internal.zzkk r2 = r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r3 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r3.zza(r5)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzfr r3 = r2.zzj()     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = r6.zzj()     // Catch:{ all -> 0x0fff }
            boolean r3 = r3.zze(r5)     // Catch:{ all -> 0x0fff }
            if (r3 == 0) goto L_0x0a80
            com.google.android.gms.measurement.internal.zzab r3 = r2.zzi()     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = r6.zzj()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzg r3 = r3.zzb(r5)     // Catch:{ all -> 0x0fff }
            if (r3 == 0) goto L_0x0a80
            boolean r3 = r3.zzaf()     // Catch:{ all -> 0x0fff }
            if (r3 == 0) goto L_0x0a80
            com.google.android.gms.measurement.internal.zzak r3 = r2.zzl()     // Catch:{ all -> 0x0fff }
            boolean r3 = r3.zzj()     // Catch:{ all -> 0x0fff }
            if (r3 == 0) goto L_0x0a80
            com.google.android.gms.measurement.internal.zzet r3 = r2.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzw()     // Catch:{ all -> 0x0fff }
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r3.zza(r5)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r3 = com.google.android.gms.internal.measurement.zzbw.zzk.zzj()     // Catch:{ all -> 0x0fff }
            r5 = r20
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r3 = r3.zza((java.lang.String) r5)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzak r2 = r2.zzl()     // Catch:{ all -> 0x0fff }
            long r7 = r2.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r2 = r3.zza((long) r7)     // Catch:{ all -> 0x0fff }
            r7 = 1
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r2 = r2.zzb((long) r7)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r2 = r2.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzk r2 = (com.google.android.gms.internal.measurement.zzbw.zzk) r2     // Catch:{ all -> 0x0fff }
            r3 = 0
        L_0x0a5c:
            int r7 = r6.zze()     // Catch:{ all -> 0x0fff }
            if (r3 >= r7) goto L_0x0a7a
            com.google.android.gms.internal.measurement.zzbw$zzk r7 = r6.zzd((int) r3)     // Catch:{ all -> 0x0fff }
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x0fff }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x0fff }
            if (r7 == 0) goto L_0x0a77
            r6.zza((int) r3, (com.google.android.gms.internal.measurement.zzbw.zzk) r2)     // Catch:{ all -> 0x0fff }
            r3 = 1
            goto L_0x0a7b
        L_0x0a77:
            int r3 = r3 + 1
            goto L_0x0a5c
        L_0x0a7a:
            r3 = 0
        L_0x0a7b:
            if (r3 != 0) goto L_0x0a80
            r6.zza((com.google.android.gms.internal.measurement.zzbw.zzk) r2)     // Catch:{ all -> 0x0fff }
        L_0x0a80:
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = r6.zzj()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzas.zzbn     // Catch:{ all -> 0x0fff }
            boolean r2 = r2.zze(r3, r5)     // Catch:{ all -> 0x0fff }
            if (r2 == 0) goto L_0x0a97
            zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6)     // Catch:{ all -> 0x0fff }
        L_0x0a97:
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r2 = r6.zzm()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzq r7 = r43.zzf()     // Catch:{ all -> 0x0fff }
            java.lang.String r8 = r6.zzj()     // Catch:{ all -> 0x0fff }
            java.util.List r9 = r6.zza()     // Catch:{ all -> 0x0fff }
            java.util.List r10 = r6.zzd()     // Catch:{ all -> 0x0fff }
            long r11 = r6.zzf()     // Catch:{ all -> 0x0fff }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0fff }
            long r12 = r6.zzg()     // Catch:{ all -> 0x0fff }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0fff }
            java.util.List r3 = r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0fff }
            r2.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzbw.zza>) r3)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r3 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0fff }
            boolean r2 = r2.zzg(r3)     // Catch:{ all -> 0x0fff }
            if (r2 == 0) goto L_0x0e32
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0e2d }
            r2.<init>()     // Catch:{ all -> 0x0e2d }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0e2d }
            r3.<init>()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzko r5 = r5.zzi()     // Catch:{ all -> 0x0e2d }
            java.security.SecureRandom r5 = r5.zzh()     // Catch:{ all -> 0x0e2d }
            r7 = 0
        L_0x0aed:
            int r8 = r6.zzb()     // Catch:{ all -> 0x0e2d }
            if (r7 >= r8) goto L_0x0df7
            com.google.android.gms.internal.measurement.zzbw$zzc r8 = r6.zzb((int) r7)     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzfi$zzb r8 = r8.zzbm()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzfi$zzb r8 = (com.google.android.gms.internal.measurement.zzfi.zzb) r8     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8     // Catch:{ all -> 0x0e2d }
            java.lang.String r9 = r8.zzd()     // Catch:{ all -> 0x0e2d }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0e2d }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0b85
            com.google.android.gms.measurement.internal.zzkk r9 = r43.zzh()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r11 = r8.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r11 = (com.google.android.gms.internal.measurement.zzfi) r11     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r11 = (com.google.android.gms.internal.measurement.zzbw.zzc) r11     // Catch:{ all -> 0x0fff }
            java.lang.String r12 = "_en"
            java.lang.Object r9 = r9.zzb(r11, r12)     // Catch:{ all -> 0x0fff }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0fff }
            java.lang.Object r11 = r2.get(r9)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzam r11 = (com.google.android.gms.measurement.internal.zzam) r11     // Catch:{ all -> 0x0fff }
            if (r11 != 0) goto L_0x0b3c
            com.google.android.gms.measurement.internal.zzab r11 = r43.zze()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r12 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza((java.lang.String) r12, (java.lang.String) r9)     // Catch:{ all -> 0x0fff }
            r2.put(r9, r11)     // Catch:{ all -> 0x0fff }
        L_0x0b3c:
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x0fff }
            if (r9 != 0) goto L_0x0b7b
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0fff }
            long r12 = r9.longValue()     // Catch:{ all -> 0x0fff }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0b55
            com.google.android.gms.measurement.internal.zzkk r9 = r43.zzh()     // Catch:{ all -> 0x0fff }
            java.lang.Long r12 = r11.zzj     // Catch:{ all -> 0x0fff }
            r9.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r12)     // Catch:{ all -> 0x0fff }
        L_0x0b55:
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0fff }
            if (r9 == 0) goto L_0x0b70
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0fff }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0fff }
            if (r9 == 0) goto L_0x0b70
            com.google.android.gms.measurement.internal.zzkk r9 = r43.zzh()     // Catch:{ all -> 0x0fff }
            java.lang.String r10 = "_efs"
            r11 = 1
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0fff }
            r9.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r13)     // Catch:{ all -> 0x0fff }
        L_0x0b70:
            com.google.android.gms.internal.measurement.zzgt r9 = r8.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r9 = (com.google.android.gms.internal.measurement.zzfi) r9     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r9 = (com.google.android.gms.internal.measurement.zzbw.zzc) r9     // Catch:{ all -> 0x0fff }
            r3.add(r9)     // Catch:{ all -> 0x0fff }
        L_0x0b7b:
            r6.zza((int) r7, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8)     // Catch:{ all -> 0x0fff }
            r44 = r4
            r15 = r5
            r1 = r6
            r4 = r7
            goto L_0x0ded
        L_0x0b85:
            com.google.android.gms.measurement.internal.zzfr r9 = r43.zzc()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzbw$zzg r11 = r4.zza     // Catch:{ all -> 0x0e2d }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0e2d }
            long r11 = r9.zzf(r11)     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzfx r9 = r1.zzj     // Catch:{ all -> 0x0e2d }
            r9.zzi()     // Catch:{ all -> 0x0e2d }
            long r13 = r8.zzf()     // Catch:{ all -> 0x0e2d }
            long r13 = com.google.android.gms.measurement.internal.zzko.zza((long) r13, (long) r11)     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzgt r9 = r8.zzu()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzfi r9 = (com.google.android.gms.internal.measurement.zzfi) r9     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzbw$zzc r9 = (com.google.android.gms.internal.measurement.zzbw.zzc) r9     // Catch:{ all -> 0x0e2d }
            java.lang.String r15 = "_dbg"
            r20 = r11
            r16 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0e2d }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0e2d }
            if (r12 != 0) goto L_0x0c1a
            if (r11 != 0) goto L_0x0bbe
            goto L_0x0c1a
        L_0x0bbe:
            java.util.List r9 = r9.zza()     // Catch:{ all -> 0x0fff }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0fff }
        L_0x0bc6:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x0fff }
            if (r12 == 0) goto L_0x0c18
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zze r12 = (com.google.android.gms.internal.measurement.zzbw.zze) r12     // Catch:{ all -> 0x0fff }
            r44 = r9
            java.lang.String r9 = r12.zzb()     // Catch:{ all -> 0x0fff }
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0fff }
            if (r9 == 0) goto L_0x0c15
            boolean r9 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0fff }
            if (r9 == 0) goto L_0x0bf0
            long r15 = r12.zzf()     // Catch:{ all -> 0x0fff }
            java.lang.Long r9 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0fff }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0fff }
            if (r9 != 0) goto L_0x0c10
        L_0x0bf0:
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0fff }
            if (r9 == 0) goto L_0x0bfe
            java.lang.String r9 = r12.zzd()     // Catch:{ all -> 0x0fff }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0fff }
            if (r9 != 0) goto L_0x0c10
        L_0x0bfe:
            boolean r9 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x0fff }
            if (r9 == 0) goto L_0x0c12
            double r15 = r12.zzh()     // Catch:{ all -> 0x0fff }
            java.lang.Double r9 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x0fff }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0fff }
            if (r9 == 0) goto L_0x0c12
        L_0x0c10:
            r9 = 1
            goto L_0x0c1b
        L_0x0c12:
            r9 = 0
            goto L_0x0c1b
        L_0x0c15:
            r9 = r44
            goto L_0x0bc6
        L_0x0c18:
            r9 = 0
            goto L_0x0c1b
        L_0x0c1a:
            r9 = 0
        L_0x0c1b:
            if (r9 != 0) goto L_0x0c31
            com.google.android.gms.measurement.internal.zzfr r9 = r43.zzc()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzg r11 = r4.zza     // Catch:{ all -> 0x0fff }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0fff }
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x0fff }
            int r9 = r9.zzd(r11, r12)     // Catch:{ all -> 0x0fff }
            goto L_0x0c32
        L_0x0c31:
            r9 = 1
        L_0x0c32:
            if (r9 > 0) goto L_0x0c61
            com.google.android.gms.measurement.internal.zzfx r10 = r1.zzj     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzr()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzi()     // Catch:{ all -> 0x0fff }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x0fff }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0fff }
            r10.zza(r11, r12, r9)     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzgt r9 = r8.zzu()     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzfi r9 = (com.google.android.gms.internal.measurement.zzfi) r9     // Catch:{ all -> 0x0fff }
            com.google.android.gms.internal.measurement.zzbw$zzc r9 = (com.google.android.gms.internal.measurement.zzbw.zzc) r9     // Catch:{ all -> 0x0fff }
            r3.add(r9)     // Catch:{ all -> 0x0fff }
            r6.zza((int) r7, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8)     // Catch:{ all -> 0x0fff }
            r44 = r4
            r15 = r5
            r1 = r6
            r4 = r7
            goto L_0x0ded
        L_0x0c61:
            java.lang.String r11 = r8.zzd()     // Catch:{ all -> 0x0e2d }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzam r11 = (com.google.android.gms.measurement.internal.zzam) r11     // Catch:{ all -> 0x0e2d }
            if (r11 != 0) goto L_0x0cc1
            com.google.android.gms.measurement.internal.zzab r11 = r43.zze()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzbw$zzg r12 = r4.zza     // Catch:{ all -> 0x0e2d }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0e2d }
            java.lang.String r15 = r8.zzd()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza((java.lang.String) r12, (java.lang.String) r15)     // Catch:{ all -> 0x0e2d }
            if (r11 != 0) goto L_0x0cc1
            com.google.android.gms.measurement.internal.zzfx r11 = r1.zzj     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzet r11 = r11.zzr()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzev r11 = r11.zzi()     // Catch:{ all -> 0x0e2d }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzbw$zzg r15 = r4.zza     // Catch:{ all -> 0x0e2d }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0e2d }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0e2d }
            r11.zza(r12, r15, r1)     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzam r11 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzbw$zzg r1 = r4.zza     // Catch:{ all -> 0x0e2d }
            java.lang.String r27 = r1.zzx()     // Catch:{ all -> 0x0e2d }
            java.lang.String r28 = r8.zzd()     // Catch:{ all -> 0x0e2d }
            r29 = 1
            r31 = 1
            r33 = 1
            long r35 = r8.zzf()     // Catch:{ all -> 0x0e2d }
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r26 = r11
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)     // Catch:{ all -> 0x0e2d }
        L_0x0cc1:
            com.google.android.gms.measurement.internal.zzkk r1 = r43.zzh()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzgt r12 = r8.zzu()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzfi r12 = (com.google.android.gms.internal.measurement.zzfi) r12     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzbw$zzc r12 = (com.google.android.gms.internal.measurement.zzbw.zzc) r12     // Catch:{ all -> 0x0e2d }
            java.lang.String r15 = "_eid"
            java.lang.Object r1 = r1.zzb(r12, r15)     // Catch:{ all -> 0x0e2d }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0e2d }
            if (r1 == 0) goto L_0x0cda
            r12 = 1
            goto L_0x0cdb
        L_0x0cda:
            r12 = 0
        L_0x0cdb:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0e2d }
            r15 = 1
            if (r9 != r15) goto L_0x0d15
            com.google.android.gms.internal.measurement.zzgt r1 = r8.zzu()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzbw$zzc r1 = (com.google.android.gms.internal.measurement.zzbw.zzc) r1     // Catch:{ all -> 0x0e2d }
            r3.add(r1)     // Catch:{ all -> 0x0e2d }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0e2d }
            if (r1 == 0) goto L_0x0d0b
            java.lang.Long r1 = r11.zzi     // Catch:{ all -> 0x0e2d }
            if (r1 != 0) goto L_0x0cff
            java.lang.Long r1 = r11.zzj     // Catch:{ all -> 0x0e2d }
            if (r1 != 0) goto L_0x0cff
            java.lang.Boolean r1 = r11.zzk     // Catch:{ all -> 0x0e2d }
            if (r1 == 0) goto L_0x0d0b
        L_0x0cff:
            r1 = 0
            com.google.android.gms.measurement.internal.zzam r9 = r11.zza(r1, r1, r1)     // Catch:{ all -> 0x0e2d }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0e2d }
            r2.put(r1, r9)     // Catch:{ all -> 0x0e2d }
        L_0x0d0b:
            r6.zza((int) r7, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8)     // Catch:{ all -> 0x0e2d }
            r44 = r4
            r15 = r5
            r1 = r6
            r4 = r7
            goto L_0x0ded
        L_0x0d15:
            int r15 = r5.nextInt(r9)     // Catch:{ all -> 0x0e2d }
            if (r15 != 0) goto L_0x0d5b
            com.google.android.gms.measurement.internal.zzkk r1 = r43.zzh()     // Catch:{ all -> 0x0e2d }
            r44 = r4
            r15 = r5
            long r4 = (long) r9     // Catch:{ all -> 0x0e2d }
            java.lang.Long r9 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0e2d }
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzgt r1 = r8.zzu()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzbw$zzc r1 = (com.google.android.gms.internal.measurement.zzbw.zzc) r1     // Catch:{ all -> 0x0e2d }
            r3.add(r1)     // Catch:{ all -> 0x0e2d }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0e2d }
            if (r1 == 0) goto L_0x0d45
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0e2d }
            r4 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza(r4, r1, r4)     // Catch:{ all -> 0x0e2d }
        L_0x0d45:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0e2d }
            long r4 = r8.zzf()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzam r4 = r11.zza(r4, r13)     // Catch:{ all -> 0x0e2d }
            r2.put(r1, r4)     // Catch:{ all -> 0x0e2d }
            r30 = r6
            r16 = r7
            goto L_0x0de6
        L_0x0d5b:
            r44 = r4
            r15 = r5
            java.lang.Long r4 = r11.zzh     // Catch:{ all -> 0x0e2d }
            if (r4 == 0) goto L_0x0d6d
            java.lang.Long r4 = r11.zzh     // Catch:{ all -> 0x0e2d }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0e2d }
            r30 = r6
            r16 = r7
            goto L_0x0d83
        L_0x0d6d:
            r4 = r43
            com.google.android.gms.measurement.internal.zzfx r5 = r4.zzj     // Catch:{ all -> 0x0e2d }
            r5.zzi()     // Catch:{ all -> 0x0e2d }
            long r4 = r8.zzg()     // Catch:{ all -> 0x0e2d }
            r30 = r6
            r16 = r7
            r6 = r20
            long r4 = com.google.android.gms.measurement.internal.zzko.zza((long) r4, (long) r6)     // Catch:{ all -> 0x0e2d }
        L_0x0d83:
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0dd3
            com.google.android.gms.measurement.internal.zzkk r1 = r43.zzh()     // Catch:{ all -> 0x0e2d }
            java.lang.String r4 = "_efs"
            r5 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e2d }
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r4, (java.lang.Object) r7)     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzkk r1 = r43.zzh()     // Catch:{ all -> 0x0e2d }
            long r5 = (long) r9     // Catch:{ all -> 0x0e2d }
            java.lang.Long r4 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e2d }
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r4)     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzgt r1 = r8.zzu()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.internal.measurement.zzbw$zzc r1 = (com.google.android.gms.internal.measurement.zzbw.zzc) r1     // Catch:{ all -> 0x0e2d }
            r3.add(r1)     // Catch:{ all -> 0x0e2d }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0e2d }
            if (r1 == 0) goto L_0x0dc2
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e2d }
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0e2d }
            r4 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza(r4, r1, r5)     // Catch:{ all -> 0x0e2d }
        L_0x0dc2:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0e2d }
            long r4 = r8.zzf()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzam r4 = r11.zza(r4, r13)     // Catch:{ all -> 0x0e2d }
            r2.put(r1, r4)     // Catch:{ all -> 0x0e2d }
            goto L_0x0de6
        L_0x0dd3:
            boolean r4 = r12.booleanValue()     // Catch:{ all -> 0x0e2d }
            if (r4 == 0) goto L_0x0de6
            java.lang.String r4 = r8.zzd()     // Catch:{ all -> 0x0e2d }
            r5 = 0
            com.google.android.gms.measurement.internal.zzam r1 = r11.zza(r1, r5, r5)     // Catch:{ all -> 0x0e2d }
            r2.put(r4, r1)     // Catch:{ all -> 0x0e2d }
        L_0x0de6:
            r4 = r16
            r1 = r30
            r1.zza((int) r4, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8)     // Catch:{ all -> 0x0e2d }
        L_0x0ded:
            int r7 = r4 + 1
            r4 = r44
            r6 = r1
            r5 = r15
            r1 = r43
            goto L_0x0aed
        L_0x0df7:
            r44 = r4
            r1 = r6
            int r4 = r3.size()     // Catch:{ all -> 0x0e2d }
            int r5 = r1.zzb()     // Catch:{ all -> 0x0e2d }
            if (r4 >= r5) goto L_0x0e0b
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r4 = r1.zzc()     // Catch:{ all -> 0x0e2d }
            r4.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzbw.zzc>) r3)     // Catch:{ all -> 0x0e2d }
        L_0x0e0b:
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0e2d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0e2d }
        L_0x0e13:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0e2d }
            if (r3 == 0) goto L_0x0e35
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0e2d }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzab r4 = r43.zze()     // Catch:{ all -> 0x0e2d }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0e2d }
            com.google.android.gms.measurement.internal.zzam r3 = (com.google.android.gms.measurement.internal.zzam) r3     // Catch:{ all -> 0x0e2d }
            r4.zza((com.google.android.gms.measurement.internal.zzam) r3)     // Catch:{ all -> 0x0e2d }
            goto L_0x0e13
        L_0x0e2d:
            r0 = move-exception
            r2 = r43
            goto L_0x1001
        L_0x0e32:
            r44 = r4
            r1 = r6
        L_0x0e35:
            r2 = r43
            com.google.android.gms.measurement.internal.zzfx r3 = r2.zzj     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzaa r3 = r3.zzb()     // Catch:{ all -> 0x0ffd }
            java.lang.String r4 = r1.zzj()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzas.zzbn     // Catch:{ all -> 0x0ffd }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0ffd }
            if (r3 != 0) goto L_0x0e4e
            zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r1)     // Catch:{ all -> 0x0ffd }
        L_0x0e4e:
            r3 = r44
            com.google.android.gms.internal.measurement.zzbw$zzg r4 = r3.zza     // Catch:{ all -> 0x0ffd }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzab r5 = r43.zze()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzg r5 = r5.zzb(r4)     // Catch:{ all -> 0x0ffd }
            if (r5 != 0) goto L_0x0e7b
            com.google.android.gms.measurement.internal.zzfx r5 = r2.zzj     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzr()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzev r5 = r5.zzf()     // Catch:{ all -> 0x0ffd }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = r3.zza     // Catch:{ all -> 0x0ffd }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0ffd }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r7)     // Catch:{ all -> 0x0ffd }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0ffd }
            goto L_0x0ed6
        L_0x0e7b:
            int r6 = r1.zzb()     // Catch:{ all -> 0x0ffd }
            if (r6 <= 0) goto L_0x0ed6
            long r6 = r5.zzk()     // Catch:{ all -> 0x0ffd }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0e8f
            r1.zze((long) r6)     // Catch:{ all -> 0x0ffd }
            goto L_0x0e92
        L_0x0e8f:
            r1.zzi()     // Catch:{ all -> 0x0ffd }
        L_0x0e92:
            long r8 = r5.zzj()     // Catch:{ all -> 0x0ffd }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0e9d
            goto L_0x0e9e
        L_0x0e9d:
            r6 = r8
        L_0x0e9e:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0ea6
            r1.zzd((long) r6)     // Catch:{ all -> 0x0ffd }
            goto L_0x0ea9
        L_0x0ea6:
            r1.zzh()     // Catch:{ all -> 0x0ffd }
        L_0x0ea9:
            r5.zzv()     // Catch:{ all -> 0x0ffd }
            long r6 = r5.zzs()     // Catch:{ all -> 0x0ffd }
            int r6 = (int) r6     // Catch:{ all -> 0x0ffd }
            r1.zzg((int) r6)     // Catch:{ all -> 0x0ffd }
            long r6 = r1.zzf()     // Catch:{ all -> 0x0ffd }
            r5.zza((long) r6)     // Catch:{ all -> 0x0ffd }
            long r6 = r1.zzg()     // Catch:{ all -> 0x0ffd }
            r5.zzb((long) r6)     // Catch:{ all -> 0x0ffd }
            java.lang.String r6 = r5.zzad()     // Catch:{ all -> 0x0ffd }
            if (r6 == 0) goto L_0x0ecc
            r1.zzj((java.lang.String) r6)     // Catch:{ all -> 0x0ffd }
            goto L_0x0ecf
        L_0x0ecc:
            r1.zzk()     // Catch:{ all -> 0x0ffd }
        L_0x0ecf:
            com.google.android.gms.measurement.internal.zzab r6 = r43.zze()     // Catch:{ all -> 0x0ffd }
            r6.zza((com.google.android.gms.measurement.internal.zzg) r5)     // Catch:{ all -> 0x0ffd }
        L_0x0ed6:
            int r5 = r1.zzb()     // Catch:{ all -> 0x0ffd }
            if (r5 <= 0) goto L_0x0f41
            com.google.android.gms.measurement.internal.zzfx r5 = r2.zzj     // Catch:{ all -> 0x0ffd }
            r5.zzu()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzfr r5 = r43.zzc()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.internal.measurement.zzbw$zzg r6 = r3.zza     // Catch:{ all -> 0x0ffd }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.internal.measurement.zzbt$zzb r5 = r5.zza((java.lang.String) r6)     // Catch:{ all -> 0x0ffd }
            if (r5 == 0) goto L_0x0f04
            boolean r6 = r5.zza()     // Catch:{ all -> 0x0ffd }
            if (r6 != 0) goto L_0x0efc
            goto L_0x0f04
        L_0x0efc:
            long r5 = r5.zzb()     // Catch:{ all -> 0x0ffd }
            r1.zzi((long) r5)     // Catch:{ all -> 0x0ffd }
            goto L_0x0f30
        L_0x0f04:
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r3.zza     // Catch:{ all -> 0x0ffd }
            java.lang.String r5 = r5.zzam()     // Catch:{ all -> 0x0ffd }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0ffd }
            if (r5 == 0) goto L_0x0f16
            r5 = -1
            r1.zzi((long) r5)     // Catch:{ all -> 0x0ffd }
            goto L_0x0f30
        L_0x0f16:
            com.google.android.gms.measurement.internal.zzfx r5 = r2.zzj     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzr()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzev r5 = r5.zzi()     // Catch:{ all -> 0x0ffd }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = r3.zza     // Catch:{ all -> 0x0ffd }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0ffd }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r7)     // Catch:{ all -> 0x0ffd }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0ffd }
        L_0x0f30:
            com.google.android.gms.measurement.internal.zzab r5 = r43.zze()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.internal.measurement.zzgt r1 = r1.zzu()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.internal.measurement.zzbw$zzg r1 = (com.google.android.gms.internal.measurement.zzbw.zzg) r1     // Catch:{ all -> 0x0ffd }
            r13 = r19
            r5.zza((com.google.android.gms.internal.measurement.zzbw.zzg) r1, (boolean) r13)     // Catch:{ all -> 0x0ffd }
        L_0x0f41:
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()     // Catch:{ all -> 0x0ffd }
            java.util.List<java.lang.Long> r3 = r3.zzb     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0ffd }
            r1.zzd()     // Catch:{ all -> 0x0ffd }
            r1.zzak()     // Catch:{ all -> 0x0ffd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0ffd }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0ffd }
            r6 = 0
        L_0x0f58:
            int r7 = r3.size()     // Catch:{ all -> 0x0ffd }
            if (r6 >= r7) goto L_0x0f75
            if (r6 == 0) goto L_0x0f65
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0ffd }
        L_0x0f65:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0ffd }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0ffd }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0ffd }
            r5.append(r7)     // Catch:{ all -> 0x0ffd }
            int r6 = r6 + 1
            goto L_0x0f58
        L_0x0f75:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0ffd }
            android.database.sqlite.SQLiteDatabase r6 = r1.c_()     // Catch:{ all -> 0x0ffd }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0ffd }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0ffd }
            int r6 = r3.size()     // Catch:{ all -> 0x0ffd }
            if (r5 == r6) goto L_0x0fa8
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x0ffd }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0ffd }
            int r3 = r3.size()     // Catch:{ all -> 0x0ffd }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0ffd }
            r1.zza(r6, r5, r3)     // Catch:{ all -> 0x0ffd }
        L_0x0fa8:
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()     // Catch:{ all -> 0x0ffd }
            android.database.sqlite.SQLiteDatabase r3 = r1.c_()     // Catch:{ all -> 0x0ffd }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0fbf }
            r7 = 0
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0fbf }
            r7 = 1
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0fbf }
            r3.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0fbf }
            goto L_0x0fd2
        L_0x0fbf:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x0ffd }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r4)     // Catch:{ all -> 0x0ffd }
            r1.zza(r5, r4, r3)     // Catch:{ all -> 0x0ffd }
        L_0x0fd2:
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()     // Catch:{ all -> 0x0ffd }
            r1.b_()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()
            r1.zzh()
            r1 = 1
            return r1
        L_0x0fe2:
            r2 = r1
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()     // Catch:{ all -> 0x0ffd }
            r1.b_()     // Catch:{ all -> 0x0ffd }
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()
            r1.zzh()
            r1 = 0
            return r1
        L_0x0ff3:
            r0 = move-exception
            r2 = r1
            goto L_0x0245
        L_0x0ff7:
            if (r5 == 0) goto L_0x0ffc
            r5.close()     // Catch:{ all -> 0x0ffd }
        L_0x0ffc:
            throw r1     // Catch:{ all -> 0x0ffd }
        L_0x0ffd:
            r0 = move-exception
            goto L_0x1001
        L_0x0fff:
            r0 = move-exception
            r2 = r1
        L_0x1001:
            r1 = r0
            com.google.android.gms.measurement.internal.zzab r3 = r43.zze()
            r3.zzh()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zza(java.lang.String, long):boolean");
    }

    private static void zza(zzbw.zzg.zza zza2) {
        zza2.zzb(Long.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzbw.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    private final void zza(zzbw.zzg.zza zza2, long j, boolean z) {
        String str;
        zzkp zzkp;
        String str2;
        if (z) {
            str = "_se";
        } else {
            str = "_lte";
        }
        zzkp zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzkp = new zzkp(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkp = new zzkp(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzbw.zzk zzk2 = (zzbw.zzk) ((zzfi) zzbw.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzkp.zze).longValue()).zzu());
        boolean z2 = false;
        int zza3 = zzkk.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzkp);
            if (z) {
                str2 = "session-scoped";
            } else {
                str2 = "lifetime";
            }
            this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", str2, zzkp.zze);
        }
    }

    private final boolean zza(zzbw.zzc.zza zza2, zzbw.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbw.zze zza4 = zzkk.zza((zzbw.zzc) ((zzfi) zza2.zzu()), "_sc");
        String str = null;
        String zzd2 = zza4 == null ? null : zza4.zzd();
        zzh();
        zzbw.zze zza5 = zzkk.zza((zzbw.zzc) ((zzfi) zza3.zzu()), "_pc");
        if (zza5 != null) {
            str = zza5.zzd();
        }
        if (str == null || !str.equals(zzd2)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    private final void zzb(zzbw.zzc.zza zza2, zzbw.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbw.zze zza4 = zzkk.zza((zzbw.zzc) ((zzfi) zza2.zzu()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzbw.zze zza5 = zzkk.zza((zzbw.zzc) ((zzfi) zza3.zzu()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh().zza(zza3, "_et", (Object) Long.valueOf(zzf2));
            zzh().zza(zza2, "_fr", (Object) 1L);
        }
    }

    private static void zza(zzbw.zzc.zza zza2, String str) {
        List<zzbw.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzbw.zzc.zza zza2, int i, String str) {
        List<zzbw.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzbw.zze) ((zzfi) zzbw.zze.zzk().zza("_err").zza(Long.valueOf((long) i).longValue()).zzu())).zza((zzbw.zze) ((zzfi) zzbw.zze.zzk().zza("_ev").zzb(str).zzu()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzab zze2;
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long next : list) {
                        try {
                            zze2 = zze();
                            long longValue = next.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            if (zze2.c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzw == null || !this.zzw.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzh();
                    this.zzw = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzx = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzm = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzr = false;
        zzaa();
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zza(zzg zzg2) {
        ArrayMap arrayMap;
        zzw();
        if (!zzle.zzb() || !this.zzj.zzb().zze(zzg2.zzc(), zzas.zzbo)) {
            if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzf())) {
                zza(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzg()) && TextUtils.isEmpty(zzg2.zzf())) {
            zza(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzg2);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzg2.zzc());
            zzbt.zzb zza3 = zzc().zza(zzg2.zzc());
            String zzb2 = zzc().zzb(zzg2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zzb2);
                arrayMap = arrayMap2;
            }
            this.zzq = true;
            zzfa zzd2 = zzd();
            String zzc2 = zzg2.zzc();
            zzkh zzkh = new zzkh(this);
            zzd2.zzd();
            zzd2.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkh);
            zzd2.zzq().zzb((Runnable) new zzfe(zzd2, zzc2, url, (byte[]) null, arrayMap, zzkh));
        } catch (MalformedURLException e) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzet.zza(zzg2.zzc()), zza2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0141 A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0152 A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x017b A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x017f A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzw()
            r6.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x01a1 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzfx r1 = r6.zzj     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzx()     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x01a1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01a1 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzab r1 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r1.zzf()     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzab r1 = r6.zze()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzb(r7)     // Catch:{ all -> 0x0198 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003f
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003f
            if (r8 != r3) goto L_0x0043
        L_0x003f:
            if (r9 != 0) goto L_0x0043
            r2 = r4
            goto L_0x0044
        L_0x0043:
            r2 = r0
        L_0x0044:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzfx r8 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzr()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzi()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r7)     // Catch:{ all -> 0x0198 }
            r8.zza(r9, r7)     // Catch:{ all -> 0x0198 }
            goto L_0x0183
        L_0x005c:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00d0
            if (r8 != r5) goto L_0x0063
            goto L_0x00d0
        L_0x0063:
            com.google.android.gms.measurement.internal.zzfx r10 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r10 = r10.zzm()     // Catch:{ all -> 0x0198 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r1.zzi((long) r10)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzab r10 = r6.zze()     // Catch:{ all -> 0x0198 }
            r10.zza((com.google.android.gms.measurement.internal.zzg) r1)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfx r10 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzr()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzx()     // Catch:{ all -> 0x0198 }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0198 }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfr r9 = r6.zzc()     // Catch:{ all -> 0x0198 }
            r9.zzc(r7)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfx r7 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzff r7 = r7.zzc()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfj r7 = r7.zzd     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfx r9 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x0198 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r7.zza(r9)     // Catch:{ all -> 0x0198 }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00b3
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r4 = r0
        L_0x00b3:
            if (r4 == 0) goto L_0x00cb
            com.google.android.gms.measurement.internal.zzfx r7 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzff r7 = r7.zzc()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfj r7 = r7.zze     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfx r8 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r8 = r8.zzm()     // Catch:{ all -> 0x0198 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r7.zza(r8)     // Catch:{ all -> 0x0198 }
        L_0x00cb:
            r6.zzz()     // Catch:{ all -> 0x0198 }
            goto L_0x0183
        L_0x00d0:
            r9 = 0
            if (r11 == 0) goto L_0x00dc
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x0198 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0198 }
            goto L_0x00dd
        L_0x00dc:
            r11 = r9
        L_0x00dd:
            if (r11 == 0) goto L_0x00ec
            int r2 = r11.size()     // Catch:{ all -> 0x0198 }
            if (r2 <= 0) goto L_0x00ec
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0198 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0198 }
            goto L_0x00ed
        L_0x00ec:
            r11 = r9
        L_0x00ed:
            if (r8 == r5) goto L_0x0109
            if (r8 != r3) goto L_0x00f2
            goto L_0x0109
        L_0x00f2:
            com.google.android.gms.measurement.internal.zzfr r9 = r6.zzc()     // Catch:{ all -> 0x0198 }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x0198 }
            if (r9 != 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzab r7 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r7.zzh()     // Catch:{ all -> 0x01a1 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0109:
            com.google.android.gms.measurement.internal.zzfr r11 = r6.zzc()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.internal.measurement.zzbt$zzb r11 = r11.zza((java.lang.String) r7)     // Catch:{ all -> 0x0198 }
            if (r11 != 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzfr r11 = r6.zzc()     // Catch:{ all -> 0x0198 }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x0198 }
            if (r9 != 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzab r7 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r7.zzh()     // Catch:{ all -> 0x01a1 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x012a:
            com.google.android.gms.measurement.internal.zzfx r9 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x0198 }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r1.zzh((long) r2)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzab r9 = r6.zze()     // Catch:{ all -> 0x0198 }
            r9.zza((com.google.android.gms.measurement.internal.zzg) r1)     // Catch:{ all -> 0x0198 }
            if (r8 != r5) goto L_0x0152
            com.google.android.gms.measurement.internal.zzfx r8 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzr()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzk()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x0198 }
            goto L_0x016b
        L_0x0152:
            com.google.android.gms.measurement.internal.zzfx r7 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzx()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0198 }
            int r10 = r10.length     // Catch:{ all -> 0x0198 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0198 }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x0198 }
        L_0x016b:
            com.google.android.gms.measurement.internal.zzfa r7 = r6.zzd()     // Catch:{ all -> 0x0198 }
            boolean r7 = r7.zzf()     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x017f
            boolean r7 = r6.zzy()     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x017f
            r6.zzl()     // Catch:{ all -> 0x0198 }
            goto L_0x0183
        L_0x017f:
            r6.zzz()     // Catch:{ all -> 0x0198 }
        L_0x0183:
            com.google.android.gms.measurement.internal.zzab r7 = r6.zze()     // Catch:{ all -> 0x0198 }
            r7.b_()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzab r7 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r7.zzh()     // Catch:{ all -> 0x01a1 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0198:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzab r8 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r8.zzh()     // Catch:{ all -> 0x01a1 }
            throw r7     // Catch:{ all -> 0x01a1 }
        L_0x01a1:
            r7 = move-exception
            r6.zzq = r0
            r6.zzaa()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    private final void zzz() {
        long j;
        long j2;
        zzw();
        zzk();
        if (this.zzm > 0) {
            long abs = 3600000 - Math.abs(this.zzj.zzm().elapsedRealtime() - this.zzm);
            if (abs > 0) {
                this.zzj.zzr().zzx().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzt().zzb();
                zzv().zzf();
                return;
            }
            this.zzm = 0;
        }
        if (!this.zzj.zzag() || !zzy()) {
            this.zzj.zzr().zzx().zza("Nothing to upload or uploading impossible");
            zzt().zzb();
            zzv().zzf();
            return;
        }
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        long max = Math.max(0, zzas.zzz.zza(null).longValue());
        boolean z = zze().zzz() || zze().zzk();
        if (z) {
            String zzw2 = this.zzj.zzb().zzw();
            if (TextUtils.isEmpty(zzw2) || ".none.".equals(zzw2)) {
                j = Math.max(0, zzas.zzt.zza(null).longValue());
            } else {
                j = Math.max(0, zzas.zzu.zza(null).longValue());
            }
        } else {
            j = Math.max(0, zzas.zzs.zza(null).longValue());
        }
        long zza2 = this.zzj.zzc().zzc.zza();
        long zza3 = this.zzj.zzc().zzd.zza();
        long j3 = j;
        long j4 = max;
        long max2 = Math.max(zze().zzw(), zze().zzx());
        if (max2 == 0) {
            j2 = 0;
        } else {
            long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(zza3 - currentTimeMillis);
            long max3 = Math.max(abs3, abs4);
            j2 = abs2 + j4;
            if (z && max3 > 0) {
                j2 = Math.min(abs2, max3) + j3;
            }
            long j5 = j3;
            if (!zzh().zza(max3, j5)) {
                j2 = max3 + j5;
            }
            if (abs4 != 0 && abs4 >= abs2) {
                int i = 0;
                while (true) {
                    if (i >= Math.min(20, Math.max(0, zzas.zzab.zza(null).intValue()))) {
                        j2 = 0;
                        break;
                    }
                    j2 += Math.max(0, zzas.zzaa.zza(null).longValue()) * (1 << i);
                    if (j2 > abs4) {
                        break;
                    }
                    i++;
                }
            }
        }
        if (j2 == 0) {
            this.zzj.zzr().zzx().zza("Next upload time is 0");
            zzt().zzb();
            zzv().zzf();
        } else if (!zzd().zzf()) {
            this.zzj.zzr().zzx().zza("No network");
            zzt().zza();
            zzv().zzf();
        } else {
            long zza4 = this.zzj.zzc().zze.zza();
            long max4 = Math.max(0, zzas.zzq.zza(null).longValue());
            if (!zzh().zza(zza4, max4)) {
                j2 = Math.max(j2, zza4 + max4);
            }
            zzt().zzb();
            long currentTimeMillis2 = j2 - this.zzj.zzm().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                currentTimeMillis2 = Math.max(0, zzas.zzv.zza(null).longValue());
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
            }
            this.zzj.zzr().zzx().zza("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            zzv().zza(currentTimeMillis2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzn.clear();
        }
    }

    private final Boolean zzb(zzg zzg2) {
        try {
            if (zzg2.zzm() != -2147483648L) {
                if (zzg2.zzm() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionName;
                if (zzg2.zzl() != null && zzg2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        zzw();
        zzk();
        if (!this.zzl) {
            this.zzl = true;
            if (zzab()) {
                int zza2 = zza(this.zzu);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                } else if (zza2 >= zzaf) {
                } else {
                    if (zza(zzaf, this.zzu)) {
                        this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    } else {
                        this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    }
                }
            }
        }
    }

    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (!this.zzj.zzb().zza(zzas.zzbm) || (fileLock = this.zzt) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzu = channel;
                FileLock tryLock = channel.tryLock();
                this.zzt = tryLock;
                if (tryLock != null) {
                    this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            if (this.zzj.zzb().zza(zzas.zzbz) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzm zzm2) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzab zze2 = zze();
        String str = zzm2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzet.zza(str), e);
        }
        if (zzm2.zzh) {
            zzb(zzm2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkn zzkn, zzm zzm2) {
        int i;
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            int zzc2 = this.zzj.zzi().zzc(zzkn.zza);
            if (zzc2 != 0) {
                this.zzj.zzi();
                this.zzj.zzi().zza(zzm2.zza, zzc2, "_ev", zzko.zza(zzkn.zza, 24, true), zzkn.zza != null ? zzkn.zza.length() : 0);
                return;
            }
            int zzb2 = this.zzj.zzi().zzb(zzkn.zza, zzkn.zza());
            if (zzb2 != 0) {
                this.zzj.zzi();
                String zza2 = zzko.zza(zzkn.zza, 24, true);
                Object zza3 = zzkn.zza();
                if (zza3 == null || (!(zza3 instanceof String) && !(zza3 instanceof CharSequence))) {
                    i = 0;
                } else {
                    i = String.valueOf(zza3).length();
                }
                this.zzj.zzi().zza(zzm2.zza, zzb2, "_ev", zza2, i);
                return;
            }
            Object zzc3 = this.zzj.zzi().zzc(zzkn.zza, zzkn.zza());
            if (zzc3 != null) {
                if ("_sid".equals(zzkn.zza)) {
                    long j = zzkn.zzb;
                    String str = zzkn.zze;
                    long j2 = 0;
                    zzkp zzc4 = zze().zzc(zzm2.zza, "_sno");
                    if (zzc4 == null || !(zzc4.zze instanceof Long)) {
                        if (zzc4 != null) {
                            this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                        }
                        zzam zza4 = zze().zza(zzm2.zza, "_s");
                        if (zza4 != null) {
                            j2 = zza4.zzc;
                            this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                        }
                    } else {
                        j2 = ((Long) zzc4.zze).longValue();
                    }
                    zza(new zzkn("_sno", j, Long.valueOf(j2 + 1), str), zzm2);
                }
                zzkp zzkp = new zzkp(zzm2.zza, zzkn.zze, zzkn.zza, zzkn.zzb, zzc3);
                this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzkp.zzc), zzc3);
                zze().zzf();
                try {
                    zzc(zzm2);
                    boolean zza5 = zze().zza(zzkp);
                    zze().b_();
                    if (!zza5) {
                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                        this.zzj.zzi().zza(zzm2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzkn zzkn, zzm zzm2) {
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
            } else if (!"_npa".equals(zzkn.zza) || zzm2.zzs == null) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkn.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkn.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkn.zza));
                } finally {
                    zze().zzh();
                }
            } else {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkn("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzm2.zzs.booleanValue() ? 1 : 0), "auto"), zzm2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkd zzkd) {
        this.zzo++;
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final zzfx zzs() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x04af A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0122 A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01d3 A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0209 A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x020b A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x020f A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0232 A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0239 A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0247 A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x025b A[Catch:{ SQLiteException -> 0x01be, all -> 0x04de }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzm r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzw()
            r21.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            boolean r7 = r21.zze(r22)
            if (r7 != 0) goto L_0x0023
            return
        L_0x0023:
            com.google.android.gms.measurement.internal.zzab r7 = r21.zze()
            java.lang.String r8 = r2.zza
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzb(r8)
            r8 = 0
            if (r7 == 0) goto L_0x0056
            java.lang.String r10 = r7.zze()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0056
            java.lang.String r10 = r2.zzb
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0056
            r7.zzh((long) r8)
            com.google.android.gms.measurement.internal.zzab r10 = r21.zze()
            r10.zza((com.google.android.gms.measurement.internal.zzg) r7)
            com.google.android.gms.measurement.internal.zzfr r7 = r21.zzc()
            java.lang.String r10 = r2.zza
            r7.zzd(r10)
        L_0x0056:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x005e
            r21.zzc(r22)
            return
        L_0x005e:
            long r10 = r2.zzm
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.common.util.Clock r7 = r7.zzm()
            long r10 = r7.currentTimeMillis()
        L_0x006f:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzak r7 = r7.zzx()
            r7.zzi()
            int r7 = r2.zzn
            r15 = 1
            if (r7 == 0) goto L_0x009b
            if (r7 == r15) goto L_0x009b
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzr()
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzi()
            java.lang.String r13 = r2.zza
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zza(r14, r13, r7)
            r7 = 0
        L_0x009b:
            com.google.android.gms.measurement.internal.zzab r12 = r21.zze()
            r12.zzf()
            com.google.android.gms.measurement.internal.zzab r12 = r21.zze()     // Catch:{ all -> 0x04de }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x04de }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzkp r14 = r12.zzc(r13, r14)     // Catch:{ all -> 0x04de }
            if (r14 == 0) goto L_0x00c0
            java.lang.String r12 = "auto"
            java.lang.String r13 = r14.zzb     // Catch:{ all -> 0x04de }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x04de }
            if (r12 == 0) goto L_0x00bc
            goto L_0x00c0
        L_0x00bc:
            r18 = r3
            r3 = r15
            goto L_0x0115
        L_0x00c0:
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04de }
            if (r12 == 0) goto L_0x00fd
            com.google.android.gms.measurement.internal.zzkn r13 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04de }
            java.lang.String r18 = "_npa"
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04de }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x04de }
            if (r12 == 0) goto L_0x00d3
            r19 = 1
            goto L_0x00d5
        L_0x00d3:
            r19 = r8
        L_0x00d5:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x04de }
            java.lang.String r20 = "auto"
            r8 = 1
            r12 = r13
            r8 = r13
            r13 = r18
            r18 = r3
            r9 = r14
            r3 = r15
            r14 = r10
            r16 = r19
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04de }
            if (r9 == 0) goto L_0x00f9
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x04de }
            java.lang.Long r12 = r8.zzc     // Catch:{ all -> 0x04de }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x04de }
            if (r9 != 0) goto L_0x0114
        L_0x00f9:
            r1.zza((com.google.android.gms.measurement.internal.zzkn) r8, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            goto L_0x0114
        L_0x00fd:
            r18 = r3
            r9 = r14
            r3 = r15
            if (r9 == 0) goto L_0x0114
            com.google.android.gms.measurement.internal.zzkn r8 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04de }
            r1.zzb((com.google.android.gms.measurement.internal.zzkn) r8, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            goto L_0x0115
        L_0x0114:
        L_0x0115:
            com.google.android.gms.measurement.internal.zzab r8 = r21.zze()     // Catch:{ all -> 0x04de }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzb(r9)     // Catch:{ all -> 0x04de }
            if (r8 == 0) goto L_0x01d1
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj     // Catch:{ all -> 0x04de }
            r12.zzi()     // Catch:{ all -> 0x04de }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04de }
            java.lang.String r13 = r8.zze()     // Catch:{ all -> 0x04de }
            java.lang.String r14 = r2.zzr     // Catch:{ all -> 0x04de }
            java.lang.String r15 = r8.zzf()     // Catch:{ all -> 0x04de }
            boolean r12 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x04de }
            if (r12 == 0) goto L_0x01d1
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzr()     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzi()     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r8.zzc()     // Catch:{ all -> 0x04de }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r14)     // Catch:{ all -> 0x04de }
            r12.zza(r13, r14)     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzab r12 = r21.zze()     // Catch:{ all -> 0x04de }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x04de }
            r12.zzak()     // Catch:{ all -> 0x04de }
            r12.zzd()     // Catch:{ all -> 0x04de }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x04de }
            android.database.sqlite.SQLiteDatabase r13 = r12.c_()     // Catch:{ SQLiteException -> 0x01be }
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01be }
            r15 = 0
            r14[r15] = r8     // Catch:{ SQLiteException -> 0x01be }
            java.lang.String r9 = "events"
            int r9 = r13.delete(r9, r0, r14)     // Catch:{ SQLiteException -> 0x01be }
            int r9 = r9 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01be }
            int r9 = r9 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01be }
            int r9 = r9 + r15
            java.lang.String r15 = "apps"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01be }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01be }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01be }
            int r9 = r9 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01be }
            int r9 = r9 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01be }
            int r9 = r9 + r15
            java.lang.String r15 = "audience_filter_values"
            int r0 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01be }
            int r9 = r9 + r0
            if (r9 <= 0) goto L_0x01bd
            com.google.android.gms.measurement.internal.zzet r0 = r12.zzr()     // Catch:{ SQLiteException -> 0x01be }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzx()     // Catch:{ SQLiteException -> 0x01be }
            java.lang.String r13 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x01be }
            r0.zza(r13, r8, r9)     // Catch:{ SQLiteException -> 0x01be }
        L_0x01bd:
            goto L_0x01d0
        L_0x01be:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzet r9 = r12.zzr()     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzf()     // Catch:{ all -> 0x04de }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r8)     // Catch:{ all -> 0x04de }
            r9.zza(r12, r8, r0)     // Catch:{ all -> 0x04de }
        L_0x01d0:
            r8 = 0
        L_0x01d1:
            if (r8 == 0) goto L_0x0232
            long r12 = r8.zzm()     // Catch:{ all -> 0x04de }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01ec
            long r12 = r8.zzm()     // Catch:{ all -> 0x04de }
            r9 = r4
            long r3 = r2.zzj     // Catch:{ all -> 0x04de }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01ed
            r0 = 1
            goto L_0x01ee
        L_0x01ec:
            r9 = r4
        L_0x01ed:
            r0 = 0
        L_0x01ee:
            long r3 = r8.zzm()     // Catch:{ all -> 0x04de }
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 != 0) goto L_0x020b
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04de }
            if (r3 == 0) goto L_0x020b
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04de }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x04de }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04de }
            if (r3 != 0) goto L_0x020b
            r14 = 1
            goto L_0x020c
        L_0x020b:
            r14 = 0
        L_0x020c:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x0233
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04de }
            r0.<init>()     // Catch:{ all -> 0x04de }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.zzl()     // Catch:{ all -> 0x04de }
            r0.putString(r3, r4)     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04de }
            r14.<init>(r0)     // Catch:{ all -> 0x04de }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04de }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            goto L_0x0233
        L_0x0232:
            r9 = r4
        L_0x0233:
            r21.zzc(r22)     // Catch:{ all -> 0x04de }
            if (r7 != 0) goto L_0x0247
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()     // Catch:{ all -> 0x04de }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04de }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzam r0 = r0.zza((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x04de }
            goto L_0x0259
        L_0x0247:
            r3 = 1
            if (r7 != r3) goto L_0x0258
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()     // Catch:{ all -> 0x04de }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04de }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzam r0 = r0.zza((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x04de }
            goto L_0x0259
        L_0x0258:
            r0 = 0
        L_0x0259:
            if (r0 != 0) goto L_0x04af
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r10 / r3
            r14 = 1
            long r12 = r12 + r14
            long r12 = r12 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r8 = "_et"
            if (r7 != 0) goto L_0x0407
            com.google.android.gms.measurement.internal.zzkn r7 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04de }
            java.lang.String r14 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04de }
            java.lang.String r17 = "auto"
            r12 = r7
            r13 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04de }
            r1.zza((com.google.android.gms.measurement.internal.zzkn) r7, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x04de }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzas.zzar     // Catch:{ all -> 0x04de }
            boolean r7 = r7.zze(r12, r13)     // Catch:{ all -> 0x04de }
            if (r7 == 0) goto L_0x02a1
            r21.zzw()     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzfo r7 = r7.zzf()     // Catch:{ all -> 0x04de }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x04de }
            r7.zza(r12)     // Catch:{ all -> 0x04de }
        L_0x02a1:
            r21.zzw()     // Catch:{ all -> 0x04de }
            r21.zzk()     // Catch:{ all -> 0x04de }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x04de }
            r7.<init>()     // Catch:{ all -> 0x04de }
            r12 = 1
            r7.putLong(r4, r12)     // Catch:{ all -> 0x04de }
            r7.putLong(r3, r12)     // Catch:{ all -> 0x04de }
            r3 = 0
            r7.putLong(r6, r3)     // Catch:{ all -> 0x04de }
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04de }
            r7.putLong(r9, r3)     // Catch:{ all -> 0x04de }
            r14 = r18
            r7.putLong(r14, r3)     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzaa r3 = r3.zzb()     // Catch:{ all -> 0x04de }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x04de }
            boolean r3 = r3.zze(r4, r12)     // Catch:{ all -> 0x04de }
            if (r3 == 0) goto L_0x02db
            r3 = 1
            r7.putLong(r8, r3)     // Catch:{ all -> 0x04de }
        L_0x02db:
            boolean r3 = r2.zzq     // Catch:{ all -> 0x04de }
            if (r3 == 0) goto L_0x02e4
            r3 = 1
            r7.putLong(r0, r3)     // Catch:{ all -> 0x04de }
        L_0x02e4:
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()     // Catch:{ all -> 0x04de }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04de }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x04de }
            r0.zzd()     // Catch:{ all -> 0x04de }
            r0.zzak()     // Catch:{ all -> 0x04de }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.zzh(r3, r4)     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x04de }
            android.content.Context r0 = r0.zzn()     // Catch:{ all -> 0x04de }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04de }
            if (r0 != 0) goto L_0x031f
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzr()     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()     // Catch:{ all -> 0x04de }
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04de }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ all -> 0x04de }
            r0.zza(r6, r9)     // Catch:{ all -> 0x04de }
            goto L_0x03e9
        L_0x031f:
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x0333 }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x0333 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0333 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x0333 }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x0333 }
            goto L_0x034b
        L_0x0333:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzr()     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzf()     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.zza     // Catch:{ all -> 0x04de }
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)     // Catch:{ all -> 0x04de }
            r12.zza(r13, r15, r0)     // Catch:{ all -> 0x04de }
            r0 = 0
        L_0x034b:
            if (r0 == 0) goto L_0x03a4
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04de }
            r15 = 0
            int r12 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r12 == 0) goto L_0x03a2
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04de }
            r18 = r14
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x04de }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0385
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzaa r0 = r0.zzb()     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzbt     // Catch:{ all -> 0x04de }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r12)     // Catch:{ all -> 0x04de }
            if (r0 == 0) goto L_0x037e
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x037b
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04de }
            goto L_0x0383
        L_0x037b:
            r12 = 1
            goto L_0x0383
        L_0x037e:
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04de }
        L_0x0383:
            r14 = 0
            goto L_0x0386
        L_0x0385:
            r14 = 1
        L_0x0386:
            com.google.android.gms.measurement.internal.zzkn r0 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "_fi"
            if (r14 == 0) goto L_0x038f
            r14 = 1
            goto L_0x0391
        L_0x038f:
            r14 = 0
        L_0x0391:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x04de }
            java.lang.String r17 = "auto"
            r12 = r0
            r6 = r18
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04de }
            r1.zza((com.google.android.gms.measurement.internal.zzkn) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            goto L_0x03a5
        L_0x03a2:
            r6 = r14
            goto L_0x03a5
        L_0x03a4:
            r6 = r14
        L_0x03a5:
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x03b9 }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x03b9 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x03b9 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x03b9 }
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x03b9 }
            goto L_0x03d1
        L_0x03b9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzr()     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzf()     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x04de }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r14)     // Catch:{ all -> 0x04de }
            r12.zza(r13, r14, r0)     // Catch:{ all -> 0x04de }
            r0 = 0
        L_0x03d1:
            if (r0 == 0) goto L_0x03e9
            int r12 = r0.flags     // Catch:{ all -> 0x04de }
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x03de
            r12 = 1
            r7.putLong(r9, r12)     // Catch:{ all -> 0x04de }
        L_0x03de:
            int r0 = r0.flags     // Catch:{ all -> 0x04de }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03e9
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04de }
        L_0x03e9:
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x03f2
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04de }
        L_0x03f2:
            com.google.android.gms.measurement.internal.zzaq r0 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04de }
            r14.<init>(r7)     // Catch:{ all -> 0x04de }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04de }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            goto L_0x0465
        L_0x0407:
            r5 = 1
            if (r7 != r5) goto L_0x0465
            com.google.android.gms.measurement.internal.zzkn r5 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04de }
            java.lang.String r6 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04de }
            java.lang.String r17 = "auto"
            r12 = r5
            r13 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04de }
            r1.zza((com.google.android.gms.measurement.internal.zzkn) r5, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            r21.zzw()     // Catch:{ all -> 0x04de }
            r21.zzk()     // Catch:{ all -> 0x04de }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x04de }
            r5.<init>()     // Catch:{ all -> 0x04de }
            r6 = 1
            r5.putLong(r4, r6)     // Catch:{ all -> 0x04de }
            r5.putLong(r3, r6)     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzaa r3 = r3.zzb()     // Catch:{ all -> 0x04de }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x04de }
            boolean r3 = r3.zze(r4, r6)     // Catch:{ all -> 0x04de }
            if (r3 == 0) goto L_0x0447
            r3 = 1
            r5.putLong(r8, r3)     // Catch:{ all -> 0x04de }
        L_0x0447:
            boolean r3 = r2.zzq     // Catch:{ all -> 0x04de }
            if (r3 == 0) goto L_0x0450
            r3 = 1
            r5.putLong(r0, r3)     // Catch:{ all -> 0x04de }
        L_0x0450:
            com.google.android.gms.measurement.internal.zzaq r0 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04de }
            r14.<init>(r5)     // Catch:{ all -> 0x04de }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04de }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            goto L_0x0466
        L_0x0465:
        L_0x0466:
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzaa r0 = r0.zzb()     // Catch:{ all -> 0x04de }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzas.zzau     // Catch:{ all -> 0x04de }
            boolean r0 = r0.zze(r3, r4)     // Catch:{ all -> 0x04de }
            if (r0 != 0) goto L_0x04ce
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04de }
            r0.<init>()     // Catch:{ all -> 0x04de }
            r3 = 1
            r0.putLong(r8, r3)     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzaa r3 = r3.zzb()     // Catch:{ all -> 0x04de }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x04de }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x04de }
            if (r3 == 0) goto L_0x049a
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04de }
        L_0x049a:
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04de }
            r14.<init>(r0)     // Catch:{ all -> 0x04de }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04de }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            goto L_0x04ce
        L_0x04af:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x04de }
            if (r0 == 0) goto L_0x04ce
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04de }
            r0.<init>()     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04de }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04de }
            r14.<init>(r0)     // Catch:{ all -> 0x04de }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04de }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04de }
            goto L_0x04cf
        L_0x04ce:
        L_0x04cf:
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()     // Catch:{ all -> 0x04de }
            r0.b_()     // Catch:{ all -> 0x04de }
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()
            r0.zzh()
            return
        L_0x04de:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzab r2 = r21.zze()
            r2.zzh()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zzb(com.google.android.gms.measurement.internal.zzm):void");
    }

    private final zzm zza(String str) {
        String str2;
        String str3 = str;
        zzg zzb2 = zze().zzb(str3);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str3);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            String zze2 = zzb2.zze();
            String zzl2 = zzb2.zzl();
            long zzm2 = zzb2.zzm();
            String zzn2 = zzb2.zzn();
            long zzo2 = zzb2.zzo();
            long zzp2 = zzb2.zzp();
            boolean zzr2 = zzb2.zzr();
            String zzi2 = zzb2.zzi();
            long zzae = zzb2.zzae();
            boolean zzaf = zzb2.zzaf();
            boolean zzag = zzb2.zzag();
            String zzf2 = zzb2.zzf();
            Boolean zzah = zzb2.zzah();
            long zzq2 = zzb2.zzq();
            List<String> zzai = zzb2.zzai();
            if (!zzle.zzb() || !this.zzj.zzb().zze(str3, zzas.zzbo)) {
                str2 = null;
            } else {
                str2 = zzb2.zzg();
            }
            return new zzm(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, zzr2, false, zzi2, zzae, 0, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2);
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzet.zza(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzy zzy) {
        zzm zza2 = zza(zzy.zza);
        if (zza2 != null) {
            zza(zzy, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzy zzy, zzm zzm2) {
        Preconditions.checkNotNull(zzy);
        Preconditions.checkNotEmpty(zzy.zza);
        Preconditions.checkNotNull(zzy.zzb);
        Preconditions.checkNotNull(zzy.zzc);
        Preconditions.checkNotEmpty(zzy.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zzy zzy2 = new zzy(zzy);
            boolean z = false;
            zzy2.zze = false;
            zze().zzf();
            try {
                zzy zzd2 = zze().zzd(zzy2.zza, zzy2.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzy2.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzy2.zzc.zza), zzy2.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzy2.zzb = zzd2.zzb;
                    zzy2.zzd = zzd2.zzd;
                    zzy2.zzh = zzd2.zzh;
                    zzy2.zzf = zzd2.zzf;
                    zzy2.zzi = zzd2.zzi;
                    zzy2.zze = zzd2.zze;
                    zzy2.zzc = new zzkn(zzy2.zzc.zza, zzd2.zzc.zzb, zzy2.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzy2.zzf)) {
                    zzy2.zzc = new zzkn(zzy2.zzc.zza, zzy2.zzd, zzy2.zzc.zza(), zzy2.zzc.zze);
                    zzy2.zze = true;
                    z = true;
                }
                if (zzy2.zze) {
                    zzkn zzkn = zzy2.zzc;
                    zzkp zzkp = new zzkp(zzy2.zza, zzy2.zzb, zzkn.zza, zzkn.zzb, zzkn.zza());
                    if (zze().zza(zzkp)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzy2.zza, this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzet.zza(zzy2.zza), this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                    }
                    if (z && zzy2.zzi != null) {
                        zzb(new zzaq(zzy2.zzi, zzy2.zzd), zzm2);
                    }
                }
                if (zze().zza(zzy2)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzy2.zza, this.zzj.zzj().zzc(zzy2.zzc.zza), zzy2.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzet.zza(zzy2.zza), this.zzj.zzj().zzc(zzy2.zzc.zza), zzy2.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzy zzy) {
        zzm zza2 = zza(zzy.zza);
        if (zza2 != null) {
            zzb(zzy, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzy zzy, zzm zzm2) {
        Bundle bundle;
        Preconditions.checkNotNull(zzy);
        Preconditions.checkNotEmpty(zzy.zza);
        Preconditions.checkNotNull(zzy.zzc);
        Preconditions.checkNotEmpty(zzy.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zze().zzf();
            try {
                zzc(zzm2);
                zzy zzd2 = zze().zzd(zzy.zza, zzy.zzc.zza);
                if (zzd2 != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzy.zza, this.zzj.zzj().zzc(zzy.zzc.zza));
                    zze().zze(zzy.zza, zzy.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzy.zza, zzy.zzc.zza);
                    }
                    if (zzy.zzk != null) {
                        if (zzy.zzk.zzb != null) {
                            bundle = zzy.zzk.zzb.zzb();
                        } else {
                            bundle = null;
                        }
                        zzb(this.zzj.zzi().zza(zzy.zza, zzy.zzk.zza, bundle, zzd2.zzb, zzy.zzk.zzd, true, false), zzm2);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzet.zza(zzy.zza), this.zzj.zzj().zzc(zzy.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    private final zzg zza(zzm zzm2, zzg zzg2, String str) {
        boolean z;
        boolean z2 = true;
        if (zzg2 == null) {
            zzg2 = new zzg(this.zzj, zzm2.zza);
            zzg2.zza(this.zzj.zzi().zzk());
            zzg2.zze(str);
            z = true;
        } else if (!str.equals(zzg2.zzh())) {
            zzg2.zze(str);
            zzg2.zza(this.zzj.zzi().zzk());
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(zzm2.zzb, zzg2.zze())) {
            zzg2.zzb(zzm2.zzb);
            z = true;
        }
        if (!TextUtils.equals(zzm2.zzr, zzg2.zzf())) {
            zzg2.zzc(zzm2.zzr);
            z = true;
        }
        if (zzle.zzb() && this.zzj.zzb().zze(zzg2.zzc(), zzas.zzbo) && !TextUtils.equals(zzm2.zzv, zzg2.zzg())) {
            zzg2.zzd(zzm2.zzv);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzk) && !zzm2.zzk.equals(zzg2.zzi())) {
            zzg2.zzf(zzm2.zzk);
            z = true;
        }
        if (!(zzm2.zze == 0 || zzm2.zze == zzg2.zzo())) {
            zzg2.zzd(zzm2.zze);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzc) && !zzm2.zzc.equals(zzg2.zzl())) {
            zzg2.zzg(zzm2.zzc);
            z = true;
        }
        if (zzm2.zzj != zzg2.zzm()) {
            zzg2.zzc(zzm2.zzj);
            z = true;
        }
        if (zzm2.zzd != null && !zzm2.zzd.equals(zzg2.zzn())) {
            zzg2.zzh(zzm2.zzd);
            z = true;
        }
        if (zzm2.zzf != zzg2.zzp()) {
            zzg2.zze(zzm2.zzf);
            z = true;
        }
        if (zzm2.zzh != zzg2.zzr()) {
            zzg2.zza(zzm2.zzh);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzg) && !zzm2.zzg.equals(zzg2.zzac())) {
            zzg2.zzi(zzm2.zzg);
            z = true;
        }
        if (!this.zzj.zzb().zza(zzas.zzcm) && zzm2.zzl != zzg2.zzae()) {
            zzg2.zzp(zzm2.zzl);
            z = true;
        }
        if (zzm2.zzo != zzg2.zzaf()) {
            zzg2.zzb(zzm2.zzo);
            z = true;
        }
        if (zzm2.zzp != zzg2.zzag()) {
            zzg2.zzc(zzm2.zzp);
            z = true;
        }
        if (zzm2.zzs != zzg2.zzah()) {
            zzg2.zza(zzm2.zzs);
            z = true;
        }
        if (zzm2.zzt == 0 || zzm2.zzt == zzg2.zzq()) {
            z2 = z;
        } else {
            zzg2.zzf(zzm2.zzt);
        }
        if (z2) {
            zze().zza(zzg2);
        }
        return zzg2;
    }

    /* access modifiers changed from: package-private */
    public final zzg zzc(zzm zzm2) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm2.zza);
        zzg zzb2 = zze().zzb(zzm2.zza);
        String zzb3 = this.zzj.zzc().zzb(zzm2.zza);
        if (!zzkr.zzb() || !this.zzj.zzb().zza(zzas.zzbu)) {
            return zza(zzm2, zzb2, zzb3);
        }
        if (zzb2 == null) {
            zzb2 = new zzg(this.zzj, zzm2.zza);
            zzb2.zza(this.zzj.zzi().zzk());
            zzb2.zze(zzb3);
        } else if (!zzb3.equals(zzb2.zzh())) {
            zzb2.zze(zzb3);
            zzb2.zza(this.zzj.zzi().zzk());
        }
        zzb2.zzb(zzm2.zzb);
        zzb2.zzc(zzm2.zzr);
        if (zzle.zzb() && this.zzj.zzb().zze(zzb2.zzc(), zzas.zzbo)) {
            zzb2.zzd(zzm2.zzv);
        }
        if (!TextUtils.isEmpty(zzm2.zzk)) {
            zzb2.zzf(zzm2.zzk);
        }
        if (zzm2.zze != 0) {
            zzb2.zzd(zzm2.zze);
        }
        if (!TextUtils.isEmpty(zzm2.zzc)) {
            zzb2.zzg(zzm2.zzc);
        }
        zzb2.zzc(zzm2.zzj);
        if (zzm2.zzd != null) {
            zzb2.zzh(zzm2.zzd);
        }
        zzb2.zze(zzm2.zzf);
        zzb2.zza(zzm2.zzh);
        if (!TextUtils.isEmpty(zzm2.zzg)) {
            zzb2.zzi(zzm2.zzg);
        }
        if (!this.zzj.zzb().zza(zzas.zzcm)) {
            zzb2.zzp(zzm2.zzl);
        }
        zzb2.zzb(zzm2.zzo);
        zzb2.zzc(zzm2.zzp);
        zzb2.zza(zzm2.zzs);
        zzb2.zzf(zzm2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzm zzm2) {
        try {
            return (String) this.zzj.zzq().zza(new zzkj(this, zzm2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzet.zza(zzm2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzz();
    }

    private final boolean zze(zzm zzm2) {
        return (!zzle.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzas.zzbo)) ? !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzr) : !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzv) || !TextUtils.isEmpty(zzm2.zzr);
    }
}
