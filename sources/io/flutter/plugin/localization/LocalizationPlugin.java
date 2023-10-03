package io.flutter.plugin.localization;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocalizationPlugin {
    private final Context context;
    private final LocalizationChannel localizationChannel;

    public LocalizationPlugin(Context context2, LocalizationChannel localizationChannel2) {
        this.context = context2;
        this.localizationChannel = localizationChannel2;
    }

    public Locale resolveNativeLocale(List<Locale> supportedLocales) {
        if (supportedLocales == null || supportedLocales.isEmpty()) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            List<Locale.LanguageRange> languageRanges = new ArrayList<>();
            LocaleList localeList = this.context.getResources().getConfiguration().getLocales();
            int localeCount = localeList.size();
            for (int index = 0; index < localeCount; index++) {
                Locale locale = localeList.get(index);
                languageRanges.add(new Locale.LanguageRange(locale.toString().replace("_", "-")));
                languageRanges.add(new Locale.LanguageRange(locale.getLanguage()));
                languageRanges.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
            }
            Locale platformResolvedLocale = Locale.lookup(languageRanges, supportedLocales);
            if (platformResolvedLocale != null) {
                return platformResolvedLocale;
            }
            return supportedLocales.get(0);
        } else if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList2 = this.context.getResources().getConfiguration().getLocales();
            for (int index2 = 0; index2 < localeList2.size(); index2++) {
                Locale preferredLocale = localeList2.get(index2);
                for (Locale locale2 : supportedLocales) {
                    if (preferredLocale.equals(locale2)) {
                        return locale2;
                    }
                }
                for (Locale locale3 : supportedLocales) {
                    if (preferredLocale.getLanguage().equals(locale3.toLanguageTag())) {
                        return locale3;
                    }
                }
                for (Locale locale4 : supportedLocales) {
                    if (preferredLocale.getLanguage().equals(locale4.getLanguage())) {
                        return locale4;
                    }
                }
            }
            return supportedLocales.get(0);
        } else {
            Locale preferredLocale2 = this.context.getResources().getConfiguration().locale;
            if (preferredLocale2 != null) {
                for (Locale locale5 : supportedLocales) {
                    if (preferredLocale2.equals(locale5)) {
                        return locale5;
                    }
                }
                for (Locale locale6 : supportedLocales) {
                    if (preferredLocale2.getLanguage().equals(locale6.toString())) {
                        return locale6;
                    }
                }
            }
            return supportedLocales.get(0);
        }
    }

    public void sendLocalesToFlutter(Configuration config) {
        List<Locale> locales = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = config.getLocales();
            int localeCount = localeList.size();
            for (int index = 0; index < localeCount; index++) {
                locales.add(localeList.get(index));
            }
        } else {
            locales.add(config.locale);
        }
        this.localizationChannel.sendLocales(locales);
    }
}
