package com.baseflow.geolocator.location;

import android.location.Location;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

public class LocationMapper {
    public static Map<String, Object> toHashMap(Location location) {
        if (location == null) {
            return null;
        }
        Map<String, Object> position = new HashMap<>();
        position.put("latitude", Double.valueOf(location.getLatitude()));
        position.put("longitude", Double.valueOf(location.getLongitude()));
        position.put("timestamp", Long.valueOf(location.getTime()));
        if (location.hasAltitude()) {
            position.put("altitude", Double.valueOf(location.getAltitude()));
        }
        if (location.hasAccuracy()) {
            position.put("accuracy", Double.valueOf((double) location.getAccuracy()));
        }
        if (location.hasBearing()) {
            position.put("heading", Double.valueOf((double) location.getBearing()));
        }
        if (location.hasSpeed()) {
            position.put("speed", Double.valueOf((double) location.getSpeed()));
        }
        if (Build.VERSION.SDK_INT >= 26 && location.hasSpeedAccuracy()) {
            position.put("speed_accuracy", Double.valueOf((double) location.getSpeedAccuracyMetersPerSecond()));
        }
        if (Build.VERSION.SDK_INT >= 18) {
            position.put("is_mocked", Boolean.valueOf(location.isFromMockProvider()));
        } else {
            position.put("is_mocked", false);
        }
        return position;
    }
}
