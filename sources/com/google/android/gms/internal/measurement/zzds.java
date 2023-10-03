package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzds;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public abstract class zzds<MessageType extends zzdq<MessageType, BuilderType>, BuilderType extends zzds<MessageType, BuilderType>> implements zzgs {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzel zzel, zzev zzev) throws IOException;

    /* renamed from: zzp */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzft {
        try {
            zzel zza = zzel.zza(bArr, 0, i2, false);
            zza(zza, zzev.zza());
            zza.zza(0);
            return this;
        } catch (zzft e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzev zzev) throws zzft {
        try {
            zzel zza = zzel.zza(bArr, 0, i2, false);
            zza(zza, zzev);
            zza.zza(0);
            return this;
        } catch (zzft e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    public final /* synthetic */ zzgs zza(zzgt zzgt) {
        if (zzbt().getClass().isInstance(zzgt)) {
            return zza((zzdq) zzgt);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* synthetic */ zzgs zza(byte[] bArr, zzev zzev) throws zzft {
        return zza(bArr, 0, bArr.length, zzev);
    }

    public final /* synthetic */ zzgs zza(byte[] bArr) throws zzft {
        return zza(bArr, 0, bArr.length);
    }
}
