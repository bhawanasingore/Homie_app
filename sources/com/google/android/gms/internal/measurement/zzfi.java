package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfi.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public abstract class zzfi<MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdq<MessageType, BuilderType> {
    private static Map<Object, zzfi<?, ?>> zzd = new ConcurrentHashMap();
    protected zzid zzb = zzid.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static class zza<T extends zzfi<T, ?>> extends zzdu<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    static final class zzc implements zzfd<zzc> {
        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzir zzb() {
            throw new NoSuchMethodError();
        }

        public final zziu zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        public final zzgs zza(zzgs zzgs, zzgt zzgt) {
            throw new NoSuchMethodError();
        }

        public final zzgy zza(zzgy zzgy, zzgy zzgy2) {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static class zzf<ContainingType extends zzgt, Type> extends zzew<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzfi<MessageType, BuilderType> implements zzgv {
        protected zzfb<zzc> zzc = zzfb.zza();

        /* access modifiers changed from: package-private */
        public final zzfb<zzc> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzfb) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return zzgu.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzhe.zza().zza(this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static abstract class zzb<MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzds<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (zzfi) messagetype.zza(zze.zzd, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public void zzq() {
            MessageType messagetype = (zzfi) this.zza.zza(zze.zzd, (Object) null, (Object) null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        public final boolean zzbl() {
            return zzfi.zza(this.zza, false);
        }

        /* renamed from: zzr */
        public MessageType zzt() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzhe.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzs */
        public final MessageType zzu() {
            MessageType messagetype = (zzfi) zzt();
            if (messagetype.zzbl()) {
                return messagetype;
            }
            throw new zzib(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzhe.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzev zzev) throws zzft {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzhe.zza().zza(this.zza).zza(this.zza, bArr, 0, i2 + 0, new zzdy(zzev));
                return this;
            } catch (zzft e) {
                throw e;
            } catch (IndexOutOfBoundsException e2) {
                throw zzft.zza();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzel zzel, zzev zzev) throws IOException {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzhe.zza().zza(this.zza).zza(this.zza, zzeq.zza(zzel), zzev);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzds zza(byte[] bArr, int i, int i2, zzev zzev) throws zzft {
            return zzb(bArr, 0, i2, zzev);
        }

        public final /* synthetic */ zzds zza(byte[] bArr, int i, int i2) throws zzft {
            return zzb(bArr, 0, i2, zzev.zza());
        }

        public final /* synthetic */ zzds zzp() {
            return (zzb) clone();
        }

        public final /* synthetic */ zzgt zzbt() {
            return this.zzc;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) ((zzfi) this.zzc).zza(zze.zze, (Object) null, (Object) null);
            zzb2.zza((zzfi) zzt());
            return zzb2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzhe.zza().zza(this).zza(this, (zzfi) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbk() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final boolean zzbl() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbm() {
        BuilderType buildertype = (zzb) zza(zze.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    public final int zzbj() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i) {
        this.zzc = i;
    }

    public final void zza(zzes zzes) throws IOException {
        zzhe.zza().zza(this).zza(this, (zzix) zzeu.zza(zzes));
    }

    public final int zzbn() {
        if (this.zzc == -1) {
            this.zzc = zzhe.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzfi<?, ?>> T zza(Class<T> cls) {
        T t = (zzfi) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzfi) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzfi) ((zzfi) zzig.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzfi<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzgt zzgt, String str, Object[] objArr) {
        return new zzhg(zzgt, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzfi<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzhe.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zze.zzb, (Object) zzd2 ? t : null, (Object) null);
        }
        return zzd2;
    }

    protected static zzfo zzbo() {
        return zzfl.zzd();
    }

    protected static zzfr zzbp() {
        return zzgh.zzd();
    }

    protected static zzfr zza(zzfr zzfr) {
        int size = zzfr.size();
        return zzfr.zzc(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzfq<E> zzbq() {
        return zzhh.zzd();
    }

    protected static <E> zzfq<E> zza(zzfq<E> zzfq) {
        int size = zzfq.size();
        return zzfq.zza(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ zzgs zzbr() {
        zzb zzb2 = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzgs zzbs() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzgt zzbt() {
        return (zzfi) zza(zze.zzf, (Object) null, (Object) null);
    }
}
