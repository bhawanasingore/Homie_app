package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CirclesController {
    private final Map<String, CircleController> circleIdToController = new HashMap();
    private final float density;
    private GoogleMap googleMap;
    private final Map<String, String> googleMapsCircleIdToDartCircleId = new HashMap();
    private final MethodChannel methodChannel;

    CirclesController(MethodChannel methodChannel2, float density2) {
        this.methodChannel = methodChannel2;
        this.density = density2;
    }

    /* access modifiers changed from: package-private */
    public void setGoogleMap(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
    }

    /* access modifiers changed from: package-private */
    public void addCircles(List<Object> circlesToAdd) {
        if (circlesToAdd != null) {
            for (Object circleToAdd : circlesToAdd) {
                addCircle(circleToAdd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void changeCircles(List<Object> circlesToChange) {
        if (circlesToChange != null) {
            for (Object circleToChange : circlesToChange) {
                changeCircle(circleToChange);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeCircles(List<Object> circleIdsToRemove) {
        CircleController circleController;
        if (circleIdsToRemove != null) {
            for (Object rawCircleId : circleIdsToRemove) {
                if (!(rawCircleId == null || (circleController = this.circleIdToController.remove((String) rawCircleId)) == null)) {
                    circleController.remove();
                    this.googleMapsCircleIdToDartCircleId.remove(circleController.getGoogleMapsCircleId());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onCircleTap(String googleCircleId) {
        String circleId = this.googleMapsCircleIdToDartCircleId.get(googleCircleId);
        if (circleId == null) {
            return false;
        }
        this.methodChannel.invokeMethod("circle#onTap", Convert.circleIdToJson(circleId));
        CircleController circleController = this.circleIdToController.get(circleId);
        if (circleController != null) {
            return circleController.consumeTapEvents();
        }
        return false;
    }

    private void addCircle(Object circle) {
        if (circle != null) {
            CircleBuilder circleBuilder = new CircleBuilder(this.density);
            addCircle(Convert.interpretCircleOptions(circle, circleBuilder), circleBuilder.build(), circleBuilder.consumeTapEvents());
        }
    }

    private void addCircle(String circleId, CircleOptions circleOptions, boolean consumeTapEvents) {
        Circle circle = this.googleMap.addCircle(circleOptions);
        this.circleIdToController.put(circleId, new CircleController(circle, consumeTapEvents, this.density));
        this.googleMapsCircleIdToDartCircleId.put(circle.getId(), circleId);
    }

    private void changeCircle(Object circle) {
        CircleController circleController;
        if (circle != null && (circleController = this.circleIdToController.get(getCircleId(circle))) != null) {
            Convert.interpretCircleOptions(circle, circleController);
        }
    }

    private static String getCircleId(Object circle) {
        return (String) ((Map) circle).get("circleId");
    }
}
