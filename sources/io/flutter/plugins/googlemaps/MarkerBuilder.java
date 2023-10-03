package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

class MarkerBuilder implements MarkerOptionsSink {
    private boolean consumeTapEvents;
    private final MarkerOptions markerOptions = new MarkerOptions();

    MarkerBuilder() {
    }

    /* access modifiers changed from: package-private */
    public MarkerOptions build() {
        return this.markerOptions;
    }

    /* access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    public void setAlpha(float alpha) {
        this.markerOptions.alpha(alpha);
    }

    public void setAnchor(float u, float v) {
        this.markerOptions.anchor(u, v);
    }

    public void setConsumeTapEvents(boolean consumeTapEvents2) {
        this.consumeTapEvents = consumeTapEvents2;
    }

    public void setDraggable(boolean draggable) {
        this.markerOptions.draggable(draggable);
    }

    public void setFlat(boolean flat) {
        this.markerOptions.flat(flat);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.markerOptions.icon(bitmapDescriptor);
    }

    public void setInfoWindowAnchor(float u, float v) {
        this.markerOptions.infoWindowAnchor(u, v);
    }

    public void setInfoWindowText(String title, String snippet) {
        this.markerOptions.title(title);
        this.markerOptions.snippet(snippet);
    }

    public void setPosition(LatLng position) {
        this.markerOptions.position(position);
    }

    public void setRotation(float rotation) {
        this.markerOptions.rotation(rotation);
    }

    public void setVisible(boolean visible) {
        this.markerOptions.visible(visible);
    }

    public void setZIndex(float zIndex) {
        this.markerOptions.zIndex(zIndex);
    }
}
