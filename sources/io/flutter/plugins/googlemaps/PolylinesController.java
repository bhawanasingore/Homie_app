package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PolylinesController {
    private final float density;
    private GoogleMap googleMap;
    private final Map<String, String> googleMapsPolylineIdToDartPolylineId = new HashMap();
    private final MethodChannel methodChannel;
    private final Map<String, PolylineController> polylineIdToController = new HashMap();

    PolylinesController(MethodChannel methodChannel2, float density2) {
        this.methodChannel = methodChannel2;
        this.density = density2;
    }

    /* access modifiers changed from: package-private */
    public void setGoogleMap(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
    }

    /* access modifiers changed from: package-private */
    public void addPolylines(List<Object> polylinesToAdd) {
        if (polylinesToAdd != null) {
            for (Object polylineToAdd : polylinesToAdd) {
                addPolyline(polylineToAdd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void changePolylines(List<Object> polylinesToChange) {
        if (polylinesToChange != null) {
            for (Object polylineToChange : polylinesToChange) {
                changePolyline(polylineToChange);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removePolylines(List<Object> polylineIdsToRemove) {
        PolylineController polylineController;
        if (polylineIdsToRemove != null) {
            for (Object rawPolylineId : polylineIdsToRemove) {
                if (!(rawPolylineId == null || (polylineController = this.polylineIdToController.remove((String) rawPolylineId)) == null)) {
                    polylineController.remove();
                    this.googleMapsPolylineIdToDartPolylineId.remove(polylineController.getGoogleMapsPolylineId());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onPolylineTap(String googlePolylineId) {
        String polylineId = this.googleMapsPolylineIdToDartPolylineId.get(googlePolylineId);
        if (polylineId == null) {
            return false;
        }
        this.methodChannel.invokeMethod("polyline#onTap", Convert.polylineIdToJson(polylineId));
        PolylineController polylineController = this.polylineIdToController.get(polylineId);
        if (polylineController != null) {
            return polylineController.consumeTapEvents();
        }
        return false;
    }

    private void addPolyline(Object polyline) {
        if (polyline != null) {
            PolylineBuilder polylineBuilder = new PolylineBuilder(this.density);
            addPolyline(Convert.interpretPolylineOptions(polyline, polylineBuilder), polylineBuilder.build(), polylineBuilder.consumeTapEvents());
        }
    }

    private void addPolyline(String polylineId, PolylineOptions polylineOptions, boolean consumeTapEvents) {
        Polyline polyline = this.googleMap.addPolyline(polylineOptions);
        this.polylineIdToController.put(polylineId, new PolylineController(polyline, consumeTapEvents, this.density));
        this.googleMapsPolylineIdToDartPolylineId.put(polyline.getId(), polylineId);
    }

    private void changePolyline(Object polyline) {
        PolylineController polylineController;
        if (polyline != null && (polylineController = this.polylineIdToController.get(getPolylineId(polyline))) != null) {
            Convert.interpretPolylineOptions(polyline, polylineController);
        }
    }

    private static String getPolylineId(Object polyline) {
        return (String) ((Map) polyline).get("polylineId");
    }
}
