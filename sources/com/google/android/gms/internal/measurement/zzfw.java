package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzfw<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzfu> zza;

    private zzfw(Map.Entry<K, zzfu> entry) {
        this.zza = entry;
    }

    public final K getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzfu.zza();
    }

    public final zzfu zza() {
        return this.zza.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzgt) {
            return this.zza.getValue().zza((zzgt) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
