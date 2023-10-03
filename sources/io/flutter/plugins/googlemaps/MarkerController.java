package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

class MarkerController implements MarkerOptionsSink {
    private boolean consumeTapEvents;
    private final String googleMapsMarkerId;
    private final Marker marker;

    MarkerController(Marker marker2, boolean consumeTapEvents2) {
        this.marker = marker2;
        this.consumeTapEvents = consumeTapEvents2;
        this.googleMapsMarkerId = marker2.getId();
    }

    /* access modifiers changed from: package-private */
    public void remove() {
        this.marker.remove();
    }

    public void setAlpha(float alpha) {
        this.marker.setAlpha(alpha);
    }

    public void setAnchor(float u, float v) {
        this.marker.setAnchor(u, v);
    }

    public void setConsumeTapEvents(boolean consumeTapEvents2) {
        this.consumeTapEvents = consumeTapEvents2;
    }

    public void setDraggable(boolean draggable) {
        this.marker.setDraggable(draggable);
    }

    public void setFlat(boolean flat) {
        this.marker.setFlat(flat);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.marker.setIcon(bitmapDescriptor);
    }

    public void setInfoWindowAnchor(float u, float v) {
        this.marker.setInfoWindowAnchor(u, v);
    }

    public void setInfoWindowText(String title, String snippet) {
        this.marker.setTitle(title);
        this.marker.setSnippet(snippet);
    }

    public void setPosition(LatLng position) {
        this.marker.setPosition(position);
    }

    public void setRotation(float rotation) {
        this.marker.setRotation(rotation);
    }

    public void setVisible(boolean visible) {
        this.marker.setVisible(visible);
    }

    public void setZIndex(float zIndex) {
        this.marker.setZIndex(zIndex);
    }

    /* access modifiers changed from: package-private */
    public String getGoogleMapsMarkerId() {
        return this.googleMapsMarkerId;
    }

    /* access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    public void showInfoWindow() {
        this.marker.showInfoWindow();
    }

    public void hideInfoWindow() {
        this.marker.hideInfoWindow();
    }

    public boolean isInfoWindowShown() {
        return this.marker.isInfoWindowShown();
    }
}
