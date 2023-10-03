package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import java.util.List;

class PolylineController implements PolylineOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final String googleMapsPolylineId;
    private final Polyline polyline;

    PolylineController(Polyline polyline2, boolean consumeTapEvents2, float density2) {
        this.polyline = polyline2;
        this.consumeTapEvents = consumeTapEvents2;
        this.density = density2;
        this.googleMapsPolylineId = polyline2.getId();
    }

    /* access modifiers changed from: package-private */
    public void remove() {
        this.polyline.remove();
    }

    public void setConsumeTapEvents(boolean consumeTapEvents2) {
        this.consumeTapEvents = consumeTapEvents2;
        this.polyline.setClickable(consumeTapEvents2);
    }

    public void setColor(int color) {
        this.polyline.setColor(color);
    }

    public void setEndCap(Cap endCap) {
        this.polyline.setEndCap(endCap);
    }

    public void setGeodesic(boolean geodesic) {
        this.polyline.setGeodesic(geodesic);
    }

    public void setJointType(int jointType) {
        this.polyline.setJointType(jointType);
    }

    public void setPattern(List<PatternItem> pattern) {
        this.polyline.setPattern(pattern);
    }

    public void setPoints(List<LatLng> points) {
        this.polyline.setPoints(points);
    }

    public void setStartCap(Cap startCap) {
        this.polyline.setStartCap(startCap);
    }

    public void setVisible(boolean visible) {
        this.polyline.setVisible(visible);
    }

    public void setWidth(float width) {
        this.polyline.setWidth(this.density * width);
    }

    public void setZIndex(float zIndex) {
        this.polyline.setZIndex(zIndex);
    }

    /* access modifiers changed from: package-private */
    public String getGoogleMapsPolylineId() {
        return this.googleMapsPolylineId;
    }

    /* access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }
}
