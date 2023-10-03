package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@19.3.1 */
public final class zzla extends AbstractList<String> implements zziy, RandomAccess {
    /* access modifiers changed from: private */
    public final zziy zza;

    public zzla(zziy zziy) {
        this.zza = zziy;
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zza(zzgv zzgv) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzld(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzlc(this);
    }

    public final List<?> zzd() {
        return this.zza.zzd();
    }

    public final zziy zze() {
        return this;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
