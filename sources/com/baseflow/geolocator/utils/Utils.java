package com.baseflow.geolocator.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.common.primitives.Ints;

public class Utils {
    public static boolean openAppSettings(Context context) {
        try {
            Intent settingsIntent = new Intent();
            settingsIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            settingsIntent.addCategory("android.intent.category.DEFAULT");
            settingsIntent.setData(Uri.parse("package:" + context.getPackageName()));
            settingsIntent.addFlags(268435456);
            settingsIntent.addFlags(Ints.MAX_POWER_OF_TWO);
            settingsIntent.addFlags(8388608);
            context.startActivity(settingsIntent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean openLocationSettings(Context context) {
        try {
            Intent settingsIntent = new Intent();
            settingsIntent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            settingsIntent.addCategory("android.intent.category.DEFAULT");
            settingsIntent.addFlags(268435456);
            settingsIntent.addFlags(Ints.MAX_POWER_OF_TWO);
            settingsIntent.addFlags(8388608);
            context.startActivity(settingsIntent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
