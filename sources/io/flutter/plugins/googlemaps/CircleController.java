package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;

class CircleController implements CircleOptionsSink {
    private final Circle circle;
    private boolean consumeTapEvents;
    private final float density;
    private final String googleMapsCircleId;

    CircleController(Circle circle2, boolean consumeTapEvents2, float density2) {
        this.circle = circle2;
        this.consumeTapEvents = consumeTapEvents2;
        this.density = density2;
        this.googleMapsCircleId = circle2.getId();
    }

    /* access modifiers changed from: package-private */
    public void remove() {
        this.circle.remove();
    }

    public void setConsumeTapEvents(boolean consumeTapEvents2) {
        this.consumeTapEvents = consumeTapEvents2;
        this.circle.setClickable(consumeTapEvents2);
    }

    public void setStrokeColor(int strokeColor) {
        this.circle.setStrokeColor(strokeColor);
    }

    public void setFillColor(int fillColor) {
        this.circle.setFillColor(fillColor);
    }

    public void setCenter(LatLng center) {
        this.circle.setCenter(center);
    }

    public void setRadius(double radius) {
        this.circle.setRadius(radius);
    }

    public void setVisible(boolean visible) {
        this.circle.setVisible(visible);
    }

    public void setStrokeWidth(float strokeWidth) {
        this.circle.setStrokeWidth(this.density * strokeWidth);
    }

    public void setZIndex(float zIndex) {
        this.circle.setZIndex(zIndex);
    }

    /* access modifiers changed from: package-private */
    public String getGoogleMapsCircleId() {
        return this.googleMapsCircleId;
    }

    /* access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }
}
