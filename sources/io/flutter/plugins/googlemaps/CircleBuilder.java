package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

class CircleBuilder implements CircleOptionsSink {
    private final CircleOptions circleOptions = new CircleOptions();
    private boolean consumeTapEvents;
    private final float density;

    CircleBuilder(float density2) {
        this.density = density2;
    }

    /* access modifiers changed from: package-private */
    public CircleOptions build() {
        return this.circleOptions;
    }

    /* access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    public void setFillColor(int color) {
        this.circleOptions.fillColor(color);
    }

    public void setStrokeColor(int color) {
        this.circleOptions.strokeColor(color);
    }

    public void setCenter(LatLng center) {
        this.circleOptions.center(center);
    }

    public void setRadius(double radius) {
        this.circleOptions.radius(radius);
    }

    public void setConsumeTapEvents(boolean consumeTapEvents2) {
        this.consumeTapEvents = consumeTapEvents2;
        this.circleOptions.clickable(consumeTapEvents2);
    }

    public void setVisible(boolean visible) {
        this.circleOptions.visible(visible);
    }

    public void setStrokeWidth(float strokeWidth) {
        this.circleOptions.strokeWidth(this.density * strokeWidth);
    }

    public void setZIndex(float zIndex) {
        this.circleOptions.zIndex(zIndex);
    }
}
