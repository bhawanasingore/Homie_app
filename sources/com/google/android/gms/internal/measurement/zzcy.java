package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final /* synthetic */ class zzcy implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzcz zza;

    zzcy(zzcz zzcz) {
        this.zza = zzcz;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zza(sharedPreferences, str);
    }
}
