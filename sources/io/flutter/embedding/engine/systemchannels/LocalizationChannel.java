package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocalizationChannel {
    private static final String TAG = "LocalizationChannel";
    public final MethodChannel channel;

    public LocalizationChannel(DartExecutor dartExecutor) {
        this.channel = new MethodChannel(dartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
    }

    public void sendLocales(List<Locale> locales) {
        Log.v(TAG, "Sending Locales to Flutter.");
        List<String> data = new ArrayList<>();
        for (Locale locale : locales) {
            Log.v(TAG, "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            data.add(locale.getLanguage());
            data.add(locale.getCountry());
            data.add(Build.VERSION.SDK_INT >= 21 ? locale.getScript() : "");
            data.add(locale.getVariant());
        }
        this.channel.invokeMethod("setLocale", data);
    }
}
