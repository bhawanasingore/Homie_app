package io.flutter.plugins.googlemaps;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import androidx.lifecycle.Lifecycle;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import java.util.concurrent.atomic.AtomicInteger;

class GoogleMapBuilder implements GoogleMapOptionsSink {
    private boolean buildingsEnabled = true;
    private boolean indoorEnabled = true;
    private Object initialCircles;
    private Object initialMarkers;
    private Object initialPolygons;
    private Object initialPolylines;
    private boolean myLocationButtonEnabled = false;
    private boolean myLocationEnabled = false;
    private final GoogleMapOptions options = new GoogleMapOptions();
    private Rect padding = new Rect(0, 0, 0, 0);
    private boolean trackCameraPosition = false;
    private boolean trafficEnabled = false;

    GoogleMapBuilder() {
    }

    /* access modifiers changed from: package-private */
    public GoogleMapController build(int id, Context context, AtomicInteger state, BinaryMessenger binaryMessenger, Application application, Lifecycle lifecycle, PluginRegistry.Registrar registrar, int activityHashCode) {
        GoogleMapController controller = new GoogleMapController(id, context, state, binaryMessenger, application, lifecycle, registrar, activityHashCode, this.options);
        controller.init();
        controller.setMyLocationEnabled(this.myLocationEnabled);
        controller.setMyLocationButtonEnabled(this.myLocationButtonEnabled);
        controller.setIndoorEnabled(this.indoorEnabled);
        controller.setTrafficEnabled(this.trafficEnabled);
        controller.setBuildingsEnabled(this.buildingsEnabled);
        controller.setTrackCameraPosition(this.trackCameraPosition);
        controller.setInitialMarkers(this.initialMarkers);
        controller.setInitialPolygons(this.initialPolygons);
        controller.setInitialPolylines(this.initialPolylines);
        controller.setInitialCircles(this.initialCircles);
        controller.setPadding((float) this.padding.top, (float) this.padding.left, (float) this.padding.bottom, (float) this.padding.right);
        return controller;
    }

    /* access modifiers changed from: package-private */
    public void setInitialCameraPosition(CameraPosition position) {
        this.options.camera(position);
    }

    public void setCompassEnabled(boolean compassEnabled) {
        this.options.compassEnabled(compassEnabled);
    }

    public void setMapToolbarEnabled(boolean setMapToolbarEnabled) {
        this.options.mapToolbarEnabled(setMapToolbarEnabled);
    }

    public void setCameraTargetBounds(LatLngBounds bounds) {
        this.options.latLngBoundsForCameraTarget(bounds);
    }

    public void setMapType(int mapType) {
        this.options.mapType(mapType);
    }

    public void setMinMaxZoomPreference(Float min, Float max) {
        if (min != null) {
            this.options.minZoomPreference(min.floatValue());
        }
        if (max != null) {
            this.options.maxZoomPreference(max.floatValue());
        }
    }

    public void setPadding(float top, float left, float bottom, float right) {
        this.padding = new Rect((int) left, (int) top, (int) right, (int) bottom);
    }

    public void setTrackCameraPosition(boolean trackCameraPosition2) {
        this.trackCameraPosition = trackCameraPosition2;
    }

    public void setRotateGesturesEnabled(boolean rotateGesturesEnabled) {
        this.options.rotateGesturesEnabled(rotateGesturesEnabled);
    }

    public void setScrollGesturesEnabled(boolean scrollGesturesEnabled) {
        this.options.scrollGesturesEnabled(scrollGesturesEnabled);
    }

    public void setTiltGesturesEnabled(boolean tiltGesturesEnabled) {
        this.options.tiltGesturesEnabled(tiltGesturesEnabled);
    }

    public void setZoomGesturesEnabled(boolean zoomGesturesEnabled) {
        this.options.zoomGesturesEnabled(zoomGesturesEnabled);
    }

    public void setLiteModeEnabled(boolean liteModeEnabled) {
        this.options.liteMode(liteModeEnabled);
    }

    public void setIndoorEnabled(boolean indoorEnabled2) {
        this.indoorEnabled = indoorEnabled2;
    }

    public void setTrafficEnabled(boolean trafficEnabled2) {
        this.trafficEnabled = trafficEnabled2;
    }

    public void setBuildingsEnabled(boolean buildingsEnabled2) {
        this.buildingsEnabled = buildingsEnabled2;
    }

    public void setMyLocationEnabled(boolean myLocationEnabled2) {
        this.myLocationEnabled = myLocationEnabled2;
    }

    public void setZoomControlsEnabled(boolean zoomControlsEnabled) {
        this.options.zoomControlsEnabled(zoomControlsEnabled);
    }

    public void setMyLocationButtonEnabled(boolean myLocationButtonEnabled2) {
        this.myLocationButtonEnabled = myLocationButtonEnabled2;
    }

    public void setInitialMarkers(Object initialMarkers2) {
        this.initialMarkers = initialMarkers2;
    }

    public void setInitialPolygons(Object initialPolygons2) {
        this.initialPolygons = initialPolygons2;
    }

    public void setInitialPolylines(Object initialPolylines2) {
        this.initialPolylines = initialPolylines2;
    }

    public void setInitialCircles(Object initialCircles2) {
        this.initialCircles = initialCircles2;
    }
}
