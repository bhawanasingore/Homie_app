package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.List;

class PolylineBuilder implements PolylineOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final PolylineOptions polylineOptions = new PolylineOptions();

    PolylineBuilder(float density2) {
        this.density = density2;
    }

    /* access modifiers changed from: package-private */
    public PolylineOptions build() {
        return this.polylineOptions;
    }

    /* access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    public void setColor(int color) {
        this.polylineOptions.color(color);
    }

    public void setEndCap(Cap endCap) {
        this.polylineOptions.endCap(endCap);
    }

    public void setJointType(int jointType) {
        this.polylineOptions.jointType(jointType);
    }

    public void setPattern(List<PatternItem> pattern) {
        this.polylineOptions.pattern(pattern);
    }

    public void setPoints(List<LatLng> points) {
        this.polylineOptions.addAll(points);
    }

    public void setConsumeTapEvents(boolean consumeTapEvents2) {
        this.consumeTapEvents = consumeTapEvents2;
        this.polylineOptions.clickable(consumeTapEvents2);
    }

    public void setGeodesic(boolean geodisc) {
        this.polylineOptions.geodesic(geodisc);
    }

    public void setStartCap(Cap startCap) {
        this.polylineOptions.startCap(startCap);
    }

    public void setVisible(boolean visible) {
        this.polylineOptions.visible(visible);
    }

    public void setWidth(float width) {
        this.polylineOptions.width(this.density * width);
    }

    public void setZIndex(float zIndex) {
        this.polylineOptions.zIndex(zIndex);
    }
}
