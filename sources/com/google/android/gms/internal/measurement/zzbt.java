package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzfi;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public final class zzbt {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zza extends zzfi<zza, C0007zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzhc<zza> zzi;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private boolean zzf;
        private int zzg;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbt$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class C0007zza extends zzfi.zzb<zza, C0007zza> implements zzgv {
            private C0007zza() {
                super(zza.zzh);
            }

            public final String zza() {
                return ((zza) this.zza).zza();
            }

            public final C0007zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.zza).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.zza).zzd();
            }

            public final int zze() {
                return ((zza) this.zza).zze();
            }

            /* synthetic */ C0007zza(zzbv zzbv) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbv.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0007zza((zzbv) null);
                case 3:
                    return zza((zzgt) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhc<zza> zzhc = zzi;
                    if (zzhc == null) {
                        synchronized (zza.class) {
                            zzhc = zzi;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzh);
                                zzi = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzh = zza;
            zzfi.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzb extends zzfi<zzb, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzb zzl;
        private static volatile zzhc<zzb> zzm;
        private int zzc;
        private long zzd;
        private String zze = "";
        private int zzf;
        private zzfq<zzc> zzg = zzbq();
        private zzfq<zza> zzh = zzbq();
        private zzfq<zzbo.zza> zzi = zzbq();
        private String zzj = "";
        private boolean zzk;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzb, zza> implements zzgv {
            private zza() {
                super(zzb.zzl);
            }

            public final int zza() {
                return ((zzb) this.zza).zzf();
            }

            public final zza zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zza.C0007zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, (zza) ((zzfi) zza.zzu()));
                return this;
            }

            public final List<zzbo.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.zza).zzg());
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zzl();
                return this;
            }

            /* synthetic */ zza(zzbv zzbv) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzh.size();
        }

        public final zza zza(int i) {
            return (zza) this.zzh.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zza zza2) {
            zza2.getClass();
            zzfq<zza> zzfq = this.zzh;
            if (!zzfq.zza()) {
                this.zzh = zzfi.zza(zzfq);
            }
            this.zzh.set(i, zza2);
        }

        public final List<zzbo.zza> zzg() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzi = zzbq();
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public static zza zzi() {
            return (zza) zzl.zzbk();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbv.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbv) null);
                case 3:
                    return zza((zzgt) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbo.zza.class, "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzhc<zzb> zzhc = zzm;
                    if (zzhc == null) {
                        synchronized (zzb.class) {
                            zzhc = zzm;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzl);
                                zzm = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzb zzj() {
            return zzl;
        }

        static {
            zzb zzb = new zzb();
            zzl = zzb;
            zzfi.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzc extends zzfi<zzc, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzc zzf;
        private static volatile zzhc<zzc> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzc, zza> implements zzgv {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzbv zzbv) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbv.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbv) null);
                case 3:
                    return zza((zzgt) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhc<zzc> zzhc = zzg;
                    if (zzhc == null) {
                        synchronized (zzc.class) {
                            zzhc = zzg;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzf);
                                zzg = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzf = zzc2;
            zzfi.zza(zzc.class, zzc2);
        }
    }
}
