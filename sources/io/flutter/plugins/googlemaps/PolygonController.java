package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import java.util.List;

class PolygonController implements PolygonOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final String googleMapsPolygonId;
    private final Polygon polygon;

    PolygonController(Polygon polygon2, boolean consumeTapEvents2, float density2) {
        this.polygon = polygon2;
        this.density = density2;
        this.consumeTapEvents = consumeTapEvents2;
        this.googleMapsPolygonId = polygon2.getId();
    }

    /* access modifiers changed from: package-private */
    public void remove() {
        this.polygon.remove();
    }

    public void setConsumeTapEvents(boolean consumeTapEvents2) {
        this.consumeTapEvents = consumeTapEvents2;
        this.polygon.setClickable(consumeTapEvents2);
    }

    public void setFillColor(int color) {
        this.polygon.setFillColor(color);
    }

    public void setStrokeColor(int color) {
        this.polygon.setStrokeColor(color);
    }

    public void setGeodesic(boolean geodesic) {
        this.polygon.setGeodesic(geodesic);
    }

    public void setPoints(List<LatLng> points) {
        this.polygon.setPoints(points);
    }

    public void setVisible(boolean visible) {
        this.polygon.setVisible(visible);
    }

    public void setStrokeWidth(float width) {
        this.polygon.setStrokeWidth(this.density * width);
    }

    public void setZIndex(float zIndex) {
        this.polygon.setZIndex(zIndex);
    }

    /* access modifiers changed from: package-private */
    public String getGoogleMapsPolygonId() {
        return this.googleMapsPolygonId;
    }

    /* access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }
}
