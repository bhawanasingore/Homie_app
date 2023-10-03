package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public final class zzib extends RuntimeException {
    private final List<String> zza = null;

    public zzib(zzgt zzgt) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
