package com.baseflow.geolocator.location;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

public class LocationOptions {
    private LocationAccuracy accuracy;
    private long distanceFilter;
    private boolean forceAndroidLocationManager;
    private long timeInterval;

    public static LocationOptions parseArguments(Map<String, Object> arguments) {
        LocationAccuracy locationAccuracy;
        String accuracy2 = (String) arguments.get("accuracy");
        long distanceFilter2 = (long) ((Integer) arguments.get("distanceFilter")).intValue();
        boolean forceAndroidLocationManager2 = ((Boolean) arguments.get("forceAndroidLocationManager")).booleanValue();
        long timeInterval2 = (long) ((Integer) arguments.get("timeInterval")).intValue();
        LocationAccuracy locationAccuracy2 = LocationAccuracy.best;
        if (accuracy2 != null) {
            char c = 65535;
            switch (accuracy2.hashCode()) {
                case -1096862286:
                    if (accuracy2.equals("lowest")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1078030475:
                    if (accuracy2.equals(FirebaseAnalytics.Param.MEDIUM)) {
                        c = 2;
                        break;
                    }
                    break;
                case 107348:
                    if (accuracy2.equals("low")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3020260:
                    if (accuracy2.equals("best")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3202466:
                    if (accuracy2.equals("high")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1462605881:
                    if (accuracy2.equals("bestForNavigation")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                locationAccuracy = LocationAccuracy.lowest;
            } else if (c == 1) {
                locationAccuracy = LocationAccuracy.low;
            } else if (c == 2) {
                locationAccuracy = LocationAccuracy.medium;
            } else if (c == 3) {
                locationAccuracy = LocationAccuracy.high;
            } else if (c == 4) {
                locationAccuracy = LocationAccuracy.best;
            } else if (c == 5) {
                locationAccuracy = LocationAccuracy.bestForNavigation;
            }
            return new LocationOptions(locationAccuracy, distanceFilter2, forceAndroidLocationManager2, timeInterval2);
        }
        locationAccuracy = locationAccuracy2;
        return new LocationOptions(locationAccuracy, distanceFilter2, forceAndroidLocationManager2, timeInterval2);
    }

    private LocationOptions(LocationAccuracy accuracy2, long distanceFilter2, boolean forceAndroidLocationManager2, long timeInterval2) {
        this.accuracy = accuracy2;
        this.distanceFilter = distanceFilter2;
        this.forceAndroidLocationManager = forceAndroidLocationManager2;
        this.timeInterval = timeInterval2;
    }

    public LocationAccuracy getAccuracy() {
        return this.accuracy;
    }

    public long getDistanceFilter() {
        return this.distanceFilter;
    }

    public boolean isForceAndroidLocationManager() {
        return this.forceAndroidLocationManager;
    }

    public long getTimeInterval() {
        return this.timeInterval;
    }
}
