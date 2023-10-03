package io.flutter.util;

import android.content.Context;
import android.os.Build;

public final class PathUtils {
    public static String getFilesDir(Context applicationContext) {
        return applicationContext.getFilesDir().getPath();
    }

    public static String getDataDirectory(Context applicationContext) {
        return applicationContext.getDir("flutter", 0).getPath();
    }

    public static String getCacheDirectory(Context applicationContext) {
        if (Build.VERSION.SDK_INT >= 21) {
            return applicationContext.getCodeCacheDir().getPath();
        }
        return applicationContext.getCacheDir().getPath();
    }
}
