package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MarkersController {
    private GoogleMap googleMap;
    private final Map<String, String> googleMapsMarkerIdToDartMarkerId = new HashMap();
    private final Map<String, MarkerController> markerIdToController = new HashMap();
    private final MethodChannel methodChannel;

    MarkersController(MethodChannel methodChannel2) {
        this.methodChannel = methodChannel2;
    }

    /* access modifiers changed from: package-private */
    public void setGoogleMap(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
    }

    /* access modifiers changed from: package-private */
    public void addMarkers(List<Object> markersToAdd) {
        if (markersToAdd != null) {
            for (Object markerToAdd : markersToAdd) {
                addMarker(markerToAdd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void changeMarkers(List<Object> markersToChange) {
        if (markersToChange != null) {
            for (Object markerToChange : markersToChange) {
                changeMarker(markerToChange);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeMarkers(List<Object> markerIdsToRemove) {
        MarkerController markerController;
        if (markerIdsToRemove != null) {
            for (Object rawMarkerId : markerIdsToRemove) {
                if (!(rawMarkerId == null || (markerController = this.markerIdToController.remove((String) rawMarkerId)) == null)) {
                    markerController.remove();
                    this.googleMapsMarkerIdToDartMarkerId.remove(markerController.getGoogleMapsMarkerId());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void showMarkerInfoWindow(String markerId, MethodChannel.Result result) {
        MarkerController markerController = this.markerIdToController.get(markerId);
        if (markerController != null) {
            markerController.showInfoWindow();
            result.success((Object) null);
            return;
        }
        result.error("Invalid markerId", "showInfoWindow called with invalid markerId", (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void hideMarkerInfoWindow(String markerId, MethodChannel.Result result) {
        MarkerController markerController = this.markerIdToController.get(markerId);
        if (markerController != null) {
            markerController.hideInfoWindow();
            result.success((Object) null);
            return;
        }
        result.error("Invalid markerId", "hideInfoWindow called with invalid markerId", (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void isInfoWindowShown(String markerId, MethodChannel.Result result) {
        MarkerController markerController = this.markerIdToController.get(markerId);
        if (markerController != null) {
            result.success(Boolean.valueOf(markerController.isInfoWindowShown()));
        } else {
            result.error("Invalid markerId", "isInfoWindowShown called with invalid markerId", (Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onMarkerTap(String googleMarkerId) {
        String markerId = this.googleMapsMarkerIdToDartMarkerId.get(googleMarkerId);
        if (markerId == null) {
            return false;
        }
        this.methodChannel.invokeMethod("marker#onTap", Convert.markerIdToJson(markerId));
        MarkerController markerController = this.markerIdToController.get(markerId);
        if (markerController != null) {
            return markerController.consumeTapEvents();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void onMarkerDragEnd(String googleMarkerId, LatLng latLng) {
        String markerId = this.googleMapsMarkerIdToDartMarkerId.get(googleMarkerId);
        if (markerId != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("markerId", markerId);
            data.put("position", Convert.latLngToJson(latLng));
            this.methodChannel.invokeMethod("marker#onDragEnd", data);
        }
    }

    /* access modifiers changed from: package-private */
    public void onInfoWindowTap(String googleMarkerId) {
        String markerId = this.googleMapsMarkerIdToDartMarkerId.get(googleMarkerId);
        if (markerId != null) {
            this.methodChannel.invokeMethod("infoWindow#onTap", Convert.markerIdToJson(markerId));
        }
    }

    private void addMarker(Object marker) {
        if (marker != null) {
            MarkerBuilder markerBuilder = new MarkerBuilder();
            addMarker(Convert.interpretMarkerOptions(marker, markerBuilder), markerBuilder.build(), markerBuilder.consumeTapEvents());
        }
    }

    private void addMarker(String markerId, MarkerOptions markerOptions, boolean consumeTapEvents) {
        Marker marker = this.googleMap.addMarker(markerOptions);
        this.markerIdToController.put(markerId, new MarkerController(marker, consumeTapEvents));
        this.googleMapsMarkerIdToDartMarkerId.put(marker.getId(), markerId);
    }

    private void changeMarker(Object marker) {
        MarkerController markerController;
        if (marker != null && (markerController = this.markerIdToController.get(getMarkerId(marker))) != null) {
            Convert.interpretMarkerOptions(marker, markerController);
        }
    }

    private static String getMarkerId(Object marker) {
        return (String) ((Map) marker).get("markerId");
    }
}
