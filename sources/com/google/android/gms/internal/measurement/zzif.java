package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public final class zzif extends AbstractList<String> implements zzga, RandomAccess {
    /* access modifiers changed from: private */
    public final zzga zza;

    public zzif(zzga zzga) {
        this.zza = zzga;
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zza(zzdz zzdz) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzie(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzih(this);
    }

    public final List<?> zzb() {
        return this.zza.zzb();
    }

    public final zzga g_() {
        return this;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
