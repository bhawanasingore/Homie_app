package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzao implements Iterator<String> {
    private Iterator<String> zza = this.zzb.zza.keySet().iterator();
    private final /* synthetic */ zzal zzb;

    zzao(zzal zzal) {
        this.zzb = zzal;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }
}
