package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PolygonsController {
    private final float density;
    private GoogleMap googleMap;
    private final Map<String, String> googleMapsPolygonIdToDartPolygonId = new HashMap();
    private final MethodChannel methodChannel;
    private final Map<String, PolygonController> polygonIdToController = new HashMap();

    PolygonsController(MethodChannel methodChannel2, float density2) {
        this.methodChannel = methodChannel2;
        this.density = density2;
    }

    /* access modifiers changed from: package-private */
    public void setGoogleMap(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
    }

    /* access modifiers changed from: package-private */
    public void addPolygons(List<Object> polygonsToAdd) {
        if (polygonsToAdd != null) {
            for (Object polygonToAdd : polygonsToAdd) {
                addPolygon(polygonToAdd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void changePolygons(List<Object> polygonsToChange) {
        if (polygonsToChange != null) {
            for (Object polygonToChange : polygonsToChange) {
                changePolygon(polygonToChange);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removePolygons(List<Object> polygonIdsToRemove) {
        PolygonController polygonController;
        if (polygonIdsToRemove != null) {
            for (Object rawPolygonId : polygonIdsToRemove) {
                if (!(rawPolygonId == null || (polygonController = this.polygonIdToController.remove((String) rawPolygonId)) == null)) {
                    polygonController.remove();
                    this.googleMapsPolygonIdToDartPolygonId.remove(polygonController.getGoogleMapsPolygonId());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onPolygonTap(String googlePolygonId) {
        String polygonId = this.googleMapsPolygonIdToDartPolygonId.get(googlePolygonId);
        if (polygonId == null) {
            return false;
        }
        this.methodChannel.invokeMethod("polygon#onTap", Convert.polygonIdToJson(polygonId));
        PolygonController polygonController = this.polygonIdToController.get(polygonId);
        if (polygonController != null) {
            return polygonController.consumeTapEvents();
        }
        return false;
    }

    private void addPolygon(Object polygon) {
        if (polygon != null) {
            PolygonBuilder polygonBuilder = new PolygonBuilder(this.density);
            addPolygon(Convert.interpretPolygonOptions(polygon, polygonBuilder), polygonBuilder.build(), polygonBuilder.consumeTapEvents());
        }
    }

    private void addPolygon(String polygonId, PolygonOptions polygonOptions, boolean consumeTapEvents) {
        Polygon polygon = this.googleMap.addPolygon(polygonOptions);
        this.polygonIdToController.put(polygonId, new PolygonController(polygon, consumeTapEvents, this.density));
        this.googleMapsPolygonIdToDartPolygonId.put(polygon.getId(), polygonId);
    }

    private void changePolygon(Object polygon) {
        PolygonController polygonController;
        if (polygon != null && (polygonController = this.polygonIdToController.get(getPolygonId(polygon))) != null) {
            Convert.interpretPolygonOptions(polygon, polygonController);
        }
    }

    private static String getPolygonId(Object polygon) {
        return (String) ((Map) polygon).get("polygonId");
    }
}
