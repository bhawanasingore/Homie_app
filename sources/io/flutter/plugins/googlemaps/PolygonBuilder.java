package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.List;

class PolygonBuilder implements PolygonOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final PolygonOptions polygonOptions = new PolygonOptions();

    PolygonBuilder(float density2) {
        this.density = density2;
    }

    /* access modifiers changed from: package-private */
    public PolygonOptions build() {
        return this.polygonOptions;
    }

    /* access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    public void setFillColor(int color) {
        this.polygonOptions.fillColor(color);
    }

    public void setStrokeColor(int color) {
        this.polygonOptions.strokeColor(color);
    }

    public void setPoints(List<LatLng> points) {
        this.polygonOptions.addAll(points);
    }

    public void setConsumeTapEvents(boolean consumeTapEvents2) {
        this.consumeTapEvents = consumeTapEvents2;
        this.polygonOptions.clickable(consumeTapEvents2);
    }

    public void setGeodesic(boolean geodisc) {
        this.polygonOptions.geodesic(geodisc);
    }

    public void setVisible(boolean visible) {
        this.polygonOptions.visible(visible);
    }

    public void setStrokeWidth(float width) {
        this.polygonOptions.strokeWidth(this.density * width);
    }

    public void setZIndex(float zIndex) {
        this.polygonOptions.zIndex(zIndex);
    }
}
