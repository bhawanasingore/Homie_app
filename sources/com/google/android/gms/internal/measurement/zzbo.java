package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public final class zzbo {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zza extends zzfi<zza, C0006zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zza zzi;
        private static volatile zzhc<zza> zzj;
        private int zzc;
        private int zzd;
        private zzfq<zze> zze = zzbq();
        private zzfq<zzb> zzf = zzbq();
        private boolean zzg;
        private boolean zzh;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbo$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class C0006zza extends zzfi.zzb<zza, C0006zza> implements zzgv {
            private C0006zza() {
                super(zza.zzi);
            }

            public final int zza() {
                return ((zza) this.zza).zzd();
            }

            public final zze zza(int i) {
                return ((zza) this.zza).zza(i);
            }

            public final C0006zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i, (zze) ((zzfi) zza.zzu()));
                return this;
            }

            public final int zzb() {
                return ((zza) this.zza).zzf();
            }

            public final zzb zzb(int i) {
                return ((zza) this.zza).zzb(i);
            }

            public final C0006zza zza(int i, zzb.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i, (zzb) ((zzfi) zza.zzu()));
                return this;
            }

            /* synthetic */ C0006zza(zzbp zzbp) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<zze> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final zze zza(int i) {
            return (zze) this.zze.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze zze2) {
            zze2.getClass();
            zzfq<zze> zzfq = this.zze;
            if (!zzfq.zza()) {
                this.zze = zzfi.zza(zzfq);
            }
            this.zze.set(i, zze2);
        }

        public final List<zzb> zze() {
            return this.zzf;
        }

        public final int zzf() {
            return this.zzf.size();
        }

        public final zzb zzb(int i) {
            return (zzb) this.zzf.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzb zzb) {
            zzb.getClass();
            zzfq<zzb> zzfq = this.zzf;
            if (!zzfq.zza()) {
                this.zzf = zzfi.zza(zzfq);
            }
            this.zzf.set(i, zzb);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0006zza((zzbp) null);
                case 3:
                    return zza((zzgt) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", zze.class, "zzf", zzb.class, "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhc<zza> zzhc = zzj;
                    if (zzhc == null) {
                        synchronized (zza.class) {
                            zzhc = zzj;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzi);
                                zzj = zzhc;
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
            zzi = zza;
            zzfi.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzb extends zzfi<zzb, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzb zzl;
        private static volatile zzhc<zzb> zzm;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzfq<zzc> zzf = zzbq();
        private boolean zzg;
        private zzd zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzb, zza> implements zzgv {
            private zza() {
                super(zzb.zzl);
            }

            public final String zza() {
                return ((zzb) this.zza).zzc();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(str);
                return this;
            }

            public final int zzb() {
                return ((zzb) this.zza).zze();
            }

            public final zzc zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zzc zzc) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, zzc);
                return this;
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public final List<zzc> zzd() {
            return this.zzf;
        }

        public final int zze() {
            return this.zzf.size();
        }

        public final zzc zza(int i) {
            return (zzc) this.zzf.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzfq<zzc> zzfq = this.zzf;
            if (!zzfq.zza()) {
                this.zzf = zzfi.zza(zzfq);
            }
            this.zzf.set(i, zzc2);
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final zzd zzg() {
            zzd zzd2 = this.zzh;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public final boolean zzi() {
            return this.zzj;
        }

        public final boolean zzj() {
            return (this.zzc & 64) != 0;
        }

        public final boolean zzk() {
            return this.zzk;
        }

        public static zza zzl() {
            return (zza) zzl.zzbk();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbp) null);
                case 3:
                    return zza((zzgt) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
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

        static {
            zzb zzb = new zzb();
            zzl = zzb;
            zzfi.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzc extends zzfi<zzc, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzc zzh;
        private static volatile zzhc<zzc> zzi;
        private int zzc;
        private zzf zzd;
        private zzd zze;
        private boolean zzf;
        private String zzg = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzc, zza> implements zzgv {
            private zza() {
                super(zzc.zzh);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzf zzb() {
            zzf zzf2 = this.zzd;
            return zzf2 == null ? zzf.zzi() : zzf2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final zzd zzd() {
            zzd zzd2 = this.zze;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbp) null);
                case 3:
                    return zza((zzgt) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhc<zzc> zzhc = zzi;
                    if (zzhc == null) {
                        synchronized (zzc.class) {
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

        public static zzc zzi() {
            return zzh;
        }

        static {
            zzc zzc2 = new zzc();
            zzh = zzc2;
            zzfi.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzd extends zzfi<zzd, zzb> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzd zzi;
        private static volatile zzhc<zzd> zzj;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public enum zza implements zzfn {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);
            
            private static final zzfm<zza> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i == 1) {
                    return LESS_THAN;
                }
                if (i == 2) {
                    return GREATER_THAN;
                }
                if (i == 3) {
                    return EQUAL;
                }
                if (i != 4) {
                    return null;
                }
                return BETWEEN;
            }

            public static zzfp zzb() {
                return zzbq.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
            }

            private zza(int i) {
                this.zzg = i;
            }

            static {
                zzf = new zzbr();
            }
        }

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zzb extends zzfi.zzb<zzd, zzb> implements zzgv {
            private zzb() {
                super(zzd.zzi);
            }

            /* synthetic */ zzb(zzbp zzbp) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zza zzb() {
            zza zza2 = zza.zza(this.zzd);
            return zza2 == null ? zza.UNKNOWN_COMPARISON_TYPE : zza2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final boolean zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final String zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final String zzj() {
            return this.zzh;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb((zzbp) null);
                case 3:
                    return zza((zzgt) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhc<zzd> zzhc = zzj;
                    if (zzhc == null) {
                        synchronized (zzd.class) {
                            zzhc = zzj;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzi);
                                zzj = zzhc;
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

        public static zzd zzk() {
            return zzi;
        }

        static {
            zzd zzd2 = new zzd();
            zzi = zzd2;
            zzfi.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zze extends zzfi<zze, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zze zzj;
        private static volatile zzhc<zze> zzk;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzc zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zze, zza> implements zzgv {
            private zza() {
                super(zze.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public final zzc zzd() {
            zzc zzc2 = this.zzf;
            return zzc2 == null ? zzc.zzi() : zzc2;
        }

        public final boolean zze() {
            return this.zzg;
        }

        public final boolean zzf() {
            return this.zzh;
        }

        public final boolean zzg() {
            return (this.zzc & 32) != 0;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public static zza zzi() {
            return (zza) zzj.zzbk();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzbp) null);
                case 3:
                    return zza((zzgt) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhc<zze> zzhc = zzk;
                    if (zzhc == null) {
                        synchronized (zze.class) {
                            zzhc = zzk;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzj);
                                zzk = zzhc;
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
            zze zze2 = new zze();
            zzj = zze2;
            zzfi.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzf extends zzfi<zzf, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzf zzh;
        private static volatile zzhc<zzf> zzi;
        private int zzc;
        private int zzd;
        private String zze = "";
        private boolean zzf;
        private zzfq<String> zzg = zzfi.zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public enum zzb implements zzfn {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);
            
            private static final zzfm<zzb> zzh = null;
            private final int zzi;

            public final int zza() {
                return this.zzi;
            }

            public static zzb zza(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            public static zzfp zzb() {
                return zzbu.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            private zzb(int i) {
                this.zzi = i;
            }

            static {
                zzh = new zzbs();
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzf, zza> implements zzgv {
            private zza() {
                super(zzf.zzh);
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzb zzb() {
            zzb zza2 = zzb.zza(this.zzd);
            return zza2 == null ? zzb.UNKNOWN_MATCH_TYPE : zza2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final List<String> zzg() {
            return this.zzg;
        }

        public final int zzh() {
            return this.zzg.size();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzbp) null);
                case 3:
                    return zza((zzgt) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhc<zzf> zzhc = zzi;
                    if (zzhc == null) {
                        synchronized (zzf.class) {
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

        public static zzf zzi() {
            return zzh;
        }

        static {
            zzf zzf2 = new zzf();
            zzh = zzf2;
            zzfi.zza(zzf.class, zzf2);
        }
    }
}
