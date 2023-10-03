package io.flutter.plugins.googlemaps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformView;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

final class GoogleMapController implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver, ActivityPluginBinding.OnSaveInstanceStateListener, GoogleMapOptionsSink, MethodChannel.MethodCallHandler, OnMapReadyCallback, GoogleMapListener, PlatformView {
    private static final String TAG = "GoogleMapController";
    private final int activityHashCode;
    private final AtomicInteger activityState;
    private boolean buildingsEnabled = true;
    private final CirclesController circlesController;
    private final Context context;
    private final float density;
    private boolean disposed = false;
    private GoogleMap googleMap;
    private final int id;
    private boolean indoorEnabled = true;
    private List<Object> initialCircles;
    private List<Object> initialMarkers;
    private List<Object> initialPolygons;
    private List<Object> initialPolylines;
    private final Lifecycle lifecycle;
    private final Application mApplication;
    private MethodChannel.Result mapReadyResult;
    @Nullable
    private MapView mapView;
    private final MarkersController markersController;
    private final MethodChannel methodChannel;
    private boolean myLocationButtonEnabled = false;
    private boolean myLocationEnabled = false;
    private final GoogleMapOptions options;
    private final PolygonsController polygonsController;
    private final PolylinesController polylinesController;
    private final PluginRegistry.Registrar registrar;
    private boolean trackCameraPosition = false;
    private boolean trafficEnabled = false;
    private boolean zoomControlsEnabled = true;

    @SuppressLint({"NewApi"})
    public /* synthetic */ void onFlutterViewAttached(@NonNull View view) {
        PlatformView.CC.$default$onFlutterViewAttached(this, view);
    }

    @SuppressLint({"NewApi"})
    public /* synthetic */ void onFlutterViewDetached() {
        PlatformView.CC.$default$onFlutterViewDetached(this);
    }

    GoogleMapController(int id2, Context context2, AtomicInteger activityState2, BinaryMessenger binaryMessenger, Application application, Lifecycle lifecycle2, PluginRegistry.Registrar registrar2, int registrarActivityHashCode, GoogleMapOptions options2) {
        this.id = id2;
        this.context = context2;
        this.activityState = activityState2;
        this.options = options2;
        this.mapView = new MapView(context2, options2);
        this.density = context2.getResources().getDisplayMetrics().density;
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "plugins.flutter.io/google_maps_" + id2);
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
        this.mApplication = application;
        this.lifecycle = lifecycle2;
        this.registrar = registrar2;
        this.activityHashCode = registrarActivityHashCode;
        this.markersController = new MarkersController(this.methodChannel);
        this.polygonsController = new PolygonsController(this.methodChannel, this.density);
        this.polylinesController = new PolylinesController(this.methodChannel, this.density);
        this.circlesController = new CirclesController(this.methodChannel, this.density);
    }

    public View getView() {
        return this.mapView;
    }

    /* access modifiers changed from: package-private */
    public void init() {
        switch (this.activityState.get()) {
            case 1:
                this.mapView.onCreate((Bundle) null);
                break;
            case 2:
                this.mapView.onCreate((Bundle) null);
                this.mapView.onStart();
                break;
            case 3:
                this.mapView.onCreate((Bundle) null);
                this.mapView.onStart();
                this.mapView.onResume();
                break;
            case 4:
                this.mapView.onCreate((Bundle) null);
                this.mapView.onStart();
                this.mapView.onResume();
                this.mapView.onPause();
                break;
            case 5:
                this.mapView.onCreate((Bundle) null);
                this.mapView.onStart();
                this.mapView.onResume();
                this.mapView.onPause();
                this.mapView.onStop();
                break;
            case 6:
                break;
            default:
                throw new IllegalArgumentException("Cannot interpret " + this.activityState.get() + " as an activity state");
        }
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 != null) {
            lifecycle2.addObserver(this);
        } else {
            getApplication().registerActivityLifecycleCallbacks(this);
        }
        this.mapView.getMapAsync(this);
    }

    private void moveCamera(CameraUpdate cameraUpdate) {
        this.googleMap.moveCamera(cameraUpdate);
    }

    private void animateCamera(CameraUpdate cameraUpdate) {
        this.googleMap.animateCamera(cameraUpdate);
    }

    private CameraPosition getCameraPosition() {
        if (this.trackCameraPosition) {
            return this.googleMap.getCameraPosition();
        }
        return null;
    }

    public void onMapReady(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
        googleMap2.setIndoorEnabled(this.indoorEnabled);
        this.googleMap.setTrafficEnabled(this.trafficEnabled);
        this.googleMap.setBuildingsEnabled(this.buildingsEnabled);
        googleMap2.setOnInfoWindowClickListener(this);
        MethodChannel.Result result = this.mapReadyResult;
        if (result != null) {
            result.success((Object) null);
            this.mapReadyResult = null;
        }
        setGoogleMapListener(this);
        updateMyLocationSettings();
        this.markersController.setGoogleMap(googleMap2);
        this.polygonsController.setGoogleMap(googleMap2);
        this.polylinesController.setGoogleMap(googleMap2);
        this.circlesController.setGoogleMap(googleMap2);
        updateInitialMarkers();
        updateInitialPolygons();
        updateInitialPolylines();
        updateInitialCircles();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r7, io.flutter.plugin.common.MethodChannel.Result r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.method
            int r1 = r0.hashCode()
            r2 = 2
            switch(r1) {
                case -2068530537: goto L_0x014d;
                case -1753225255: goto L_0x0142;
                case -1675017333: goto L_0x0137;
                case -1389285936: goto L_0x012d;
                case -1366519597: goto L_0x0123;
                case -1264573565: goto L_0x0119;
                case -1255039905: goto L_0x010e;
                case -1102318061: goto L_0x0103;
                case -596474455: goto L_0x00f8;
                case -577075523: goto L_0x00ec;
                case -508357782: goto L_0x00e0;
                case -451921790: goto L_0x00d4;
                case 262112323: goto L_0x00c8;
                case 282895827: goto L_0x00bc;
                case 295004975: goto L_0x00b1;
                case 390939153: goto L_0x00a5;
                case 434031410: goto L_0x009a;
                case 622947733: goto L_0x008f;
                case 643972249: goto L_0x0083;
                case 712945078: goto L_0x0077;
                case 972868051: goto L_0x006b;
                case 1098288608: goto L_0x005f;
                case 1172199911: goto L_0x0053;
                case 1322988819: goto L_0x0047;
                case 1546082965: goto L_0x003b;
                case 1873569705: goto L_0x002f;
                case 1915657375: goto L_0x0023;
                case 1953391461: goto L_0x0017;
                case 2003557999: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0157
        L_0x000c:
            java.lang.String r1 = "camera#move"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 6
            goto L_0x0158
        L_0x0017:
            java.lang.String r1 = "markers#showInfoWindow"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 9
            goto L_0x0158
        L_0x0023:
            java.lang.String r1 = "map#isLiteModeEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 19
            goto L_0x0158
        L_0x002f:
            java.lang.String r1 = "circles#update"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 14
            goto L_0x0158
        L_0x003b:
            java.lang.String r1 = "map#isTrafficEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 25
            goto L_0x0158
        L_0x0047:
            java.lang.String r1 = "markers#update"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 8
            goto L_0x0158
        L_0x0053:
            java.lang.String r1 = "map#isZoomControlsEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 20
            goto L_0x0158
        L_0x005f:
            java.lang.String r1 = "map#isCompassEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 15
            goto L_0x0158
        L_0x006b:
            java.lang.String r1 = "map#isBuildingsEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 26
            goto L_0x0158
        L_0x0077:
            java.lang.String r1 = "map#setStyle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 28
            goto L_0x0158
        L_0x0083:
            java.lang.String r1 = "polylines#update"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 13
            goto L_0x0158
        L_0x008f:
            java.lang.String r1 = "map#getLatLng"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 4
            goto L_0x0158
        L_0x009a:
            java.lang.String r1 = "map#takeSnapshot"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 5
            goto L_0x0158
        L_0x00a5:
            java.lang.String r1 = "map#isMapToolbarEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 16
            goto L_0x0158
        L_0x00b1:
            java.lang.String r1 = "map#waitForMap"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 0
            goto L_0x0158
        L_0x00bc:
            java.lang.String r1 = "map#isZoomGesturesEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 18
            goto L_0x0158
        L_0x00c8:
            java.lang.String r1 = "map#getMinMaxZoomLevels"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 17
            goto L_0x0158
        L_0x00d4:
            java.lang.String r1 = "map#getZoomLevel"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 27
            goto L_0x0158
        L_0x00e0:
            java.lang.String r1 = "markers#hideInfoWindow"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 10
            goto L_0x0158
        L_0x00ec:
            java.lang.String r1 = "map#isMyLocationButtonEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 24
            goto L_0x0158
        L_0x00f8:
            java.lang.String r1 = "map#isTiltGesturesEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 22
            goto L_0x0158
        L_0x0103:
            java.lang.String r1 = "polygons#update"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 12
            goto L_0x0158
        L_0x010e:
            java.lang.String r1 = "markers#isInfoWindowShown"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 11
            goto L_0x0158
        L_0x0119:
            java.lang.String r1 = "camera#animate"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 7
            goto L_0x0158
        L_0x0123:
            java.lang.String r1 = "map#getScreenCoordinate"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 3
            goto L_0x0158
        L_0x012d:
            java.lang.String r1 = "map#update"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 1
            goto L_0x0158
        L_0x0137:
            java.lang.String r1 = "map#isRotateGesturesEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 23
            goto L_0x0158
        L_0x0142:
            java.lang.String r1 = "map#isScrollGesturesEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = 21
            goto L_0x0158
        L_0x014d:
            java.lang.String r1 = "map#getVisibleRegion"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000a
            r0 = r2
            goto L_0x0158
        L_0x0157:
            r0 = -1
        L_0x0158:
            java.lang.String r1 = "cameraUpdate"
            java.lang.String r3 = "markerId"
            java.lang.String r4 = "GoogleMap uninitialized"
            r5 = 0
            switch(r0) {
                case 0: goto L_0x0425;
                case 1: goto L_0x0410;
                case 2: goto L_0x03f4;
                case 3: goto L_0x03d2;
                case 4: goto L_0x03b0;
                case 5: goto L_0x039a;
                case 6: goto L_0x0387;
                case 7: goto L_0x0374;
                case 8: goto L_0x0345;
                case 9: goto L_0x0337;
                case 10: goto L_0x0329;
                case 11: goto L_0x031b;
                case 12: goto L_0x02ec;
                case 13: goto L_0x02bd;
                case 14: goto L_0x028e;
                case 15: goto L_0x027b;
                case 16: goto L_0x0268;
                case 17: goto L_0x0244;
                case 18: goto L_0x0231;
                case 19: goto L_0x0226;
                case 20: goto L_0x0213;
                case 21: goto L_0x0200;
                case 22: goto L_0x01ed;
                case 23: goto L_0x01da;
                case 24: goto L_0x01c7;
                case 25: goto L_0x01b8;
                case 26: goto L_0x01a9;
                case 27: goto L_0x0198;
                case 28: goto L_0x0167;
                default: goto L_0x0162;
            }
        L_0x0162:
            r8.notImplemented()
            goto L_0x0430
        L_0x0167:
            java.lang.Object r0 = r7.arguments
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0174
            com.google.android.gms.maps.GoogleMap r1 = r6.googleMap
            boolean r1 = r1.setMapStyle(r5)
            goto L_0x017f
        L_0x0174:
            com.google.android.gms.maps.GoogleMap r1 = r6.googleMap
            com.google.android.gms.maps.model.MapStyleOptions r3 = new com.google.android.gms.maps.model.MapStyleOptions
            r3.<init>(r0)
            boolean r1 = r1.setMapStyle(r3)
        L_0x017f:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            r2 = r3
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
            r2.add(r3)
            if (r1 != 0) goto L_0x0193
            java.lang.String r3 = "Unable to set the map style. Please check console logs for errors."
            r2.add(r3)
        L_0x0193:
            r8.success(r2)
            goto L_0x0430
        L_0x0198:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            com.google.android.gms.maps.model.CameraPosition r0 = r0.getCameraPosition()
            float r0 = r0.zoom
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x01a9:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            boolean r0 = r0.isBuildingsEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x01b8:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            boolean r0 = r0.isTrafficEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x01c7:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            com.google.android.gms.maps.UiSettings r0 = r0.getUiSettings()
            boolean r0 = r0.isMyLocationButtonEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x01da:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            com.google.android.gms.maps.UiSettings r0 = r0.getUiSettings()
            boolean r0 = r0.isRotateGesturesEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x01ed:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            com.google.android.gms.maps.UiSettings r0 = r0.getUiSettings()
            boolean r0 = r0.isTiltGesturesEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x0200:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            com.google.android.gms.maps.UiSettings r0 = r0.getUiSettings()
            boolean r0 = r0.isScrollGesturesEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x0213:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            com.google.android.gms.maps.UiSettings r0 = r0.getUiSettings()
            boolean r0 = r0.isZoomControlsEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x0226:
            com.google.android.gms.maps.GoogleMapOptions r0 = r6.options
            java.lang.Boolean r0 = r0.getLiteMode()
            r8.success(r0)
            goto L_0x0430
        L_0x0231:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            com.google.android.gms.maps.UiSettings r0 = r0.getUiSettings()
            boolean r0 = r0.isZoomGesturesEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x0244:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r2)
            com.google.android.gms.maps.GoogleMap r1 = r6.googleMap
            float r1 = r1.getMinZoomLevel()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r0.add(r1)
            com.google.android.gms.maps.GoogleMap r1 = r6.googleMap
            float r1 = r1.getMaxZoomLevel()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r0.add(r1)
            r8.success(r0)
            goto L_0x0430
        L_0x0268:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            com.google.android.gms.maps.UiSettings r0 = r0.getUiSettings()
            boolean r0 = r0.isMapToolbarEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x027b:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            com.google.android.gms.maps.UiSettings r0 = r0.getUiSettings()
            boolean r0 = r0.isCompassEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x028e:
            java.lang.String r0 = "circlesToAdd"
            java.lang.Object r0 = r7.argument(r0)
            io.flutter.plugins.googlemaps.CirclesController r1 = r6.circlesController
            r2 = r0
            java.util.List r2 = (java.util.List) r2
            r1.addCircles(r2)
            java.lang.String r1 = "circlesToChange"
            java.lang.Object r1 = r7.argument(r1)
            io.flutter.plugins.googlemaps.CirclesController r2 = r6.circlesController
            r3 = r1
            java.util.List r3 = (java.util.List) r3
            r2.changeCircles(r3)
            java.lang.String r2 = "circleIdsToRemove"
            java.lang.Object r2 = r7.argument(r2)
            io.flutter.plugins.googlemaps.CirclesController r3 = r6.circlesController
            r4 = r2
            java.util.List r4 = (java.util.List) r4
            r3.removeCircles(r4)
            r8.success(r5)
            goto L_0x0430
        L_0x02bd:
            java.lang.String r0 = "polylinesToAdd"
            java.lang.Object r0 = r7.argument(r0)
            io.flutter.plugins.googlemaps.PolylinesController r1 = r6.polylinesController
            r2 = r0
            java.util.List r2 = (java.util.List) r2
            r1.addPolylines(r2)
            java.lang.String r1 = "polylinesToChange"
            java.lang.Object r1 = r7.argument(r1)
            io.flutter.plugins.googlemaps.PolylinesController r2 = r6.polylinesController
            r3 = r1
            java.util.List r3 = (java.util.List) r3
            r2.changePolylines(r3)
            java.lang.String r2 = "polylineIdsToRemove"
            java.lang.Object r2 = r7.argument(r2)
            io.flutter.plugins.googlemaps.PolylinesController r3 = r6.polylinesController
            r4 = r2
            java.util.List r4 = (java.util.List) r4
            r3.removePolylines(r4)
            r8.success(r5)
            goto L_0x0430
        L_0x02ec:
            java.lang.String r0 = "polygonsToAdd"
            java.lang.Object r0 = r7.argument(r0)
            io.flutter.plugins.googlemaps.PolygonsController r1 = r6.polygonsController
            r2 = r0
            java.util.List r2 = (java.util.List) r2
            r1.addPolygons(r2)
            java.lang.String r1 = "polygonsToChange"
            java.lang.Object r1 = r7.argument(r1)
            io.flutter.plugins.googlemaps.PolygonsController r2 = r6.polygonsController
            r3 = r1
            java.util.List r3 = (java.util.List) r3
            r2.changePolygons(r3)
            java.lang.String r2 = "polygonIdsToRemove"
            java.lang.Object r2 = r7.argument(r2)
            io.flutter.plugins.googlemaps.PolygonsController r3 = r6.polygonsController
            r4 = r2
            java.util.List r4 = (java.util.List) r4
            r3.removePolygons(r4)
            r8.success(r5)
            goto L_0x0430
        L_0x031b:
            java.lang.Object r0 = r7.argument(r3)
            io.flutter.plugins.googlemaps.MarkersController r1 = r6.markersController
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            r1.isInfoWindowShown(r2, r8)
            goto L_0x0430
        L_0x0329:
            java.lang.Object r0 = r7.argument(r3)
            io.flutter.plugins.googlemaps.MarkersController r1 = r6.markersController
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            r1.hideMarkerInfoWindow(r2, r8)
            goto L_0x0430
        L_0x0337:
            java.lang.Object r0 = r7.argument(r3)
            io.flutter.plugins.googlemaps.MarkersController r1 = r6.markersController
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            r1.showMarkerInfoWindow(r2, r8)
            goto L_0x0430
        L_0x0345:
            java.lang.String r0 = "markersToAdd"
            java.lang.Object r0 = r7.argument(r0)
            io.flutter.plugins.googlemaps.MarkersController r1 = r6.markersController
            r2 = r0
            java.util.List r2 = (java.util.List) r2
            r1.addMarkers(r2)
            java.lang.String r1 = "markersToChange"
            java.lang.Object r1 = r7.argument(r1)
            io.flutter.plugins.googlemaps.MarkersController r2 = r6.markersController
            r3 = r1
            java.util.List r3 = (java.util.List) r3
            r2.changeMarkers(r3)
            java.lang.String r2 = "markerIdsToRemove"
            java.lang.Object r2 = r7.argument(r2)
            io.flutter.plugins.googlemaps.MarkersController r3 = r6.markersController
            r4 = r2
            java.util.List r4 = (java.util.List) r4
            r3.removeMarkers(r4)
            r8.success(r5)
            goto L_0x0430
        L_0x0374:
            java.lang.Object r0 = r7.argument(r1)
            float r1 = r6.density
            com.google.android.gms.maps.CameraUpdate r0 = io.flutter.plugins.googlemaps.Convert.toCameraUpdate(r0, r1)
            r6.animateCamera(r0)
            r8.success(r5)
            goto L_0x0430
        L_0x0387:
            java.lang.Object r0 = r7.argument(r1)
            float r1 = r6.density
            com.google.android.gms.maps.CameraUpdate r0 = io.flutter.plugins.googlemaps.Convert.toCameraUpdate(r0, r1)
            r6.moveCamera(r0)
            r8.success(r5)
            goto L_0x0430
        L_0x039a:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            if (r0 == 0) goto L_0x03a9
            r1 = r8
            io.flutter.plugins.googlemaps.GoogleMapController$1 r2 = new io.flutter.plugins.googlemaps.GoogleMapController$1
            r2.<init>(r1)
            r0.snapshot(r2)
            goto L_0x0430
        L_0x03a9:
            java.lang.String r0 = "takeSnapshot"
            r8.error(r4, r0, r5)
            goto L_0x0430
        L_0x03b0:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            if (r0 == 0) goto L_0x03cc
            java.lang.Object r0 = r7.arguments
            android.graphics.Point r0 = io.flutter.plugins.googlemaps.Convert.toPoint(r0)
            com.google.android.gms.maps.GoogleMap r1 = r6.googleMap
            com.google.android.gms.maps.Projection r1 = r1.getProjection()
            com.google.android.gms.maps.model.LatLng r1 = r1.fromScreenLocation(r0)
            java.lang.Object r2 = io.flutter.plugins.googlemaps.Convert.latLngToJson(r1)
            r8.success(r2)
            goto L_0x0430
        L_0x03cc:
            java.lang.String r0 = "getLatLng called prior to map initialization"
            r8.error(r4, r0, r5)
            goto L_0x0430
        L_0x03d2:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            if (r0 == 0) goto L_0x03ee
            java.lang.Object r0 = r7.arguments
            com.google.android.gms.maps.model.LatLng r0 = io.flutter.plugins.googlemaps.Convert.toLatLng(r0)
            com.google.android.gms.maps.GoogleMap r1 = r6.googleMap
            com.google.android.gms.maps.Projection r1 = r1.getProjection()
            android.graphics.Point r1 = r1.toScreenLocation(r0)
            java.util.Map r2 = io.flutter.plugins.googlemaps.Convert.pointToJson(r1)
            r8.success(r2)
            goto L_0x0430
        L_0x03ee:
            java.lang.String r0 = "getScreenCoordinate called prior to map initialization"
            r8.error(r4, r0, r5)
            goto L_0x0430
        L_0x03f4:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            if (r0 == 0) goto L_0x040a
            com.google.android.gms.maps.Projection r0 = r0.getProjection()
            com.google.android.gms.maps.model.VisibleRegion r0 = r0.getVisibleRegion()
            com.google.android.gms.maps.model.LatLngBounds r0 = r0.latLngBounds
            java.lang.Object r1 = io.flutter.plugins.googlemaps.Convert.latlngBoundsToJson(r0)
            r8.success(r1)
            goto L_0x0430
        L_0x040a:
            java.lang.String r0 = "getVisibleRegion called prior to map initialization"
            r8.error(r4, r0, r5)
            goto L_0x0430
        L_0x0410:
            java.lang.String r0 = "options"
            java.lang.Object r0 = r7.argument(r0)
            io.flutter.plugins.googlemaps.Convert.interpretGoogleMapOptions(r0, r6)
            com.google.android.gms.maps.model.CameraPosition r0 = r6.getCameraPosition()
            java.lang.Object r0 = io.flutter.plugins.googlemaps.Convert.cameraPositionToJson(r0)
            r8.success(r0)
            goto L_0x0430
        L_0x0425:
            com.google.android.gms.maps.GoogleMap r0 = r6.googleMap
            if (r0 == 0) goto L_0x042d
            r8.success(r5)
            return
        L_0x042d:
            r6.mapReadyResult = r8
        L_0x0430:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.GoogleMapController.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void onMapClick(LatLng latLng) {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("position", Convert.latLngToJson(latLng));
        this.methodChannel.invokeMethod("map#onTap", arguments);
    }

    public void onMapLongClick(LatLng latLng) {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("position", Convert.latLngToJson(latLng));
        this.methodChannel.invokeMethod("map#onLongPress", arguments);
    }

    public void onCameraMoveStarted(int reason) {
        Map<String, Object> arguments = new HashMap<>(2);
        boolean isGesture = true;
        if (reason != 1) {
            isGesture = false;
        }
        arguments.put("isGesture", Boolean.valueOf(isGesture));
        this.methodChannel.invokeMethod("camera#onMoveStarted", arguments);
    }

    public void onInfoWindowClick(Marker marker) {
        this.markersController.onInfoWindowTap(marker.getId());
    }

    public void onCameraMove() {
        if (this.trackCameraPosition) {
            Map<String, Object> arguments = new HashMap<>(2);
            arguments.put("position", Convert.cameraPositionToJson(this.googleMap.getCameraPosition()));
            this.methodChannel.invokeMethod("camera#onMove", arguments);
        }
    }

    public void onCameraIdle() {
        this.methodChannel.invokeMethod("camera#onIdle", Collections.singletonMap("map", Integer.valueOf(this.id)));
    }

    public boolean onMarkerClick(Marker marker) {
        return this.markersController.onMarkerTap(marker.getId());
    }

    public void onMarkerDragStart(Marker marker) {
    }

    public void onMarkerDrag(Marker marker) {
    }

    public void onMarkerDragEnd(Marker marker) {
        this.markersController.onMarkerDragEnd(marker.getId(), marker.getPosition());
    }

    public void onPolygonClick(Polygon polygon) {
        this.polygonsController.onPolygonTap(polygon.getId());
    }

    public void onPolylineClick(Polyline polyline) {
        this.polylinesController.onPolylineTap(polyline.getId());
    }

    public void onCircleClick(Circle circle) {
        this.circlesController.onCircleTap(circle.getId());
    }

    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            setGoogleMapListener((GoogleMapListener) null);
            destroyMapViewIfNecessary();
            getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    private void setGoogleMapListener(@Nullable GoogleMapListener listener) {
        this.googleMap.setOnCameraMoveStartedListener(listener);
        this.googleMap.setOnCameraMoveListener(listener);
        this.googleMap.setOnCameraIdleListener(listener);
        this.googleMap.setOnMarkerClickListener(listener);
        this.googleMap.setOnMarkerDragListener(listener);
        this.googleMap.setOnPolygonClickListener(listener);
        this.googleMap.setOnPolylineClickListener(listener);
        this.googleMap.setOnCircleClickListener(listener);
        this.googleMap.setOnMapClickListener(listener);
        this.googleMap.setOnMapLongClickListener(listener);
    }

    public void onInputConnectionLocked() {
    }

    public void onInputConnectionUnlocked() {
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onCreate(savedInstanceState);
        }
    }

    public void onActivityStarted(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onStart();
        }
    }

    public void onActivityResumed(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onResume();
        }
    }

    public void onActivityPaused(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onPause();
        }
    }

    public void onActivityStopped(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onStop();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            this.mapView.onSaveInstanceState(outState);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (!this.disposed && activity.hashCode() == getActivityHashCode()) {
            destroyMapViewIfNecessary();
        }
    }

    public void onCreate(@NonNull LifecycleOwner owner) {
        if (!this.disposed) {
            this.mapView.onCreate((Bundle) null);
        }
    }

    public void onStart(@NonNull LifecycleOwner owner) {
        if (!this.disposed) {
            this.mapView.onStart();
        }
    }

    public void onResume(@NonNull LifecycleOwner owner) {
        if (!this.disposed) {
            this.mapView.onResume();
        }
    }

    public void onPause(@NonNull LifecycleOwner owner) {
        if (!this.disposed) {
            this.mapView.onResume();
        }
    }

    public void onStop(@NonNull LifecycleOwner owner) {
        if (!this.disposed) {
            this.mapView.onStop();
        }
    }

    public void onDestroy(@NonNull LifecycleOwner owner) {
        if (!this.disposed) {
            destroyMapViewIfNecessary();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (!this.disposed) {
            this.mapView.onCreate(bundle);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (!this.disposed) {
            this.mapView.onSaveInstanceState(bundle);
        }
    }

    public void setCameraTargetBounds(LatLngBounds bounds) {
        this.googleMap.setLatLngBoundsForCameraTarget(bounds);
    }

    public void setCompassEnabled(boolean compassEnabled) {
        this.googleMap.getUiSettings().setCompassEnabled(compassEnabled);
    }

    public void setMapToolbarEnabled(boolean mapToolbarEnabled) {
        this.googleMap.getUiSettings().setMapToolbarEnabled(mapToolbarEnabled);
    }

    public void setMapType(int mapType) {
        this.googleMap.setMapType(mapType);
    }

    public void setTrackCameraPosition(boolean trackCameraPosition2) {
        this.trackCameraPosition = trackCameraPosition2;
    }

    public void setRotateGesturesEnabled(boolean rotateGesturesEnabled) {
        this.googleMap.getUiSettings().setRotateGesturesEnabled(rotateGesturesEnabled);
    }

    public void setScrollGesturesEnabled(boolean scrollGesturesEnabled) {
        this.googleMap.getUiSettings().setScrollGesturesEnabled(scrollGesturesEnabled);
    }

    public void setTiltGesturesEnabled(boolean tiltGesturesEnabled) {
        this.googleMap.getUiSettings().setTiltGesturesEnabled(tiltGesturesEnabled);
    }

    public void setMinMaxZoomPreference(Float min, Float max) {
        this.googleMap.resetMinMaxZoomPreference();
        if (min != null) {
            this.googleMap.setMinZoomPreference(min.floatValue());
        }
        if (max != null) {
            this.googleMap.setMaxZoomPreference(max.floatValue());
        }
    }

    public void setPadding(float top, float left, float bottom, float right) {
        GoogleMap googleMap2 = this.googleMap;
        if (googleMap2 != null) {
            float f = this.density;
            googleMap2.setPadding((int) (left * f), (int) (top * f), (int) (right * f), (int) (f * bottom));
        }
    }

    public void setZoomGesturesEnabled(boolean zoomGesturesEnabled) {
        this.googleMap.getUiSettings().setZoomGesturesEnabled(zoomGesturesEnabled);
    }

    public void setLiteModeEnabled(boolean liteModeEnabled) {
        this.options.liteMode(liteModeEnabled);
    }

    public void setMyLocationEnabled(boolean myLocationEnabled2) {
        if (this.myLocationEnabled != myLocationEnabled2) {
            this.myLocationEnabled = myLocationEnabled2;
            if (this.googleMap != null) {
                updateMyLocationSettings();
            }
        }
    }

    public void setMyLocationButtonEnabled(boolean myLocationButtonEnabled2) {
        if (this.myLocationButtonEnabled != myLocationButtonEnabled2) {
            this.myLocationButtonEnabled = myLocationButtonEnabled2;
            if (this.googleMap != null) {
                updateMyLocationSettings();
            }
        }
    }

    public void setZoomControlsEnabled(boolean zoomControlsEnabled2) {
        if (this.zoomControlsEnabled != zoomControlsEnabled2) {
            this.zoomControlsEnabled = zoomControlsEnabled2;
            GoogleMap googleMap2 = this.googleMap;
            if (googleMap2 != null) {
                googleMap2.getUiSettings().setZoomControlsEnabled(zoomControlsEnabled2);
            }
        }
    }

    public void setInitialMarkers(Object initialMarkers2) {
        this.initialMarkers = (List) initialMarkers2;
        if (this.googleMap != null) {
            updateInitialMarkers();
        }
    }

    private void updateInitialMarkers() {
        this.markersController.addMarkers(this.initialMarkers);
    }

    public void setInitialPolygons(Object initialPolygons2) {
        this.initialPolygons = (List) initialPolygons2;
        if (this.googleMap != null) {
            updateInitialPolygons();
        }
    }

    private void updateInitialPolygons() {
        this.polygonsController.addPolygons(this.initialPolygons);
    }

    public void setInitialPolylines(Object initialPolylines2) {
        this.initialPolylines = (List) initialPolylines2;
        if (this.googleMap != null) {
            updateInitialPolylines();
        }
    }

    private void updateInitialPolylines() {
        this.polylinesController.addPolylines(this.initialPolylines);
    }

    public void setInitialCircles(Object initialCircles2) {
        this.initialCircles = (List) initialCircles2;
        if (this.googleMap != null) {
            updateInitialCircles();
        }
    }

    private void updateInitialCircles() {
        this.circlesController.addCircles(this.initialCircles);
    }

    @SuppressLint({"MissingPermission"})
    private void updateMyLocationSettings() {
        if (hasLocationPermission()) {
            this.googleMap.setMyLocationEnabled(this.myLocationEnabled);
            this.googleMap.getUiSettings().setMyLocationButtonEnabled(this.myLocationButtonEnabled);
            return;
        }
        Log.e(TAG, "Cannot enable MyLocation layer as location permissions are not granted");
    }

    private boolean hasLocationPermission() {
        return checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private int checkSelfPermission(String permission) {
        if (permission != null) {
            return this.context.checkPermission(permission, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    private int getActivityHashCode() {
        PluginRegistry.Registrar registrar2 = this.registrar;
        if (registrar2 == null || registrar2.activity() == null) {
            return this.activityHashCode;
        }
        return this.registrar.activity().hashCode();
    }

    private Application getApplication() {
        PluginRegistry.Registrar registrar2 = this.registrar;
        if (registrar2 == null || registrar2.activity() == null) {
            return this.mApplication;
        }
        return this.registrar.activity().getApplication();
    }

    private void destroyMapViewIfNecessary() {
        MapView mapView2 = this.mapView;
        if (mapView2 != null) {
            mapView2.onDestroy();
            this.mapView = null;
        }
    }

    public void setIndoorEnabled(boolean indoorEnabled2) {
        this.indoorEnabled = indoorEnabled2;
    }

    public void setTrafficEnabled(boolean trafficEnabled2) {
        this.trafficEnabled = trafficEnabled2;
        GoogleMap googleMap2 = this.googleMap;
        if (googleMap2 != null) {
            googleMap2.setTrafficEnabled(trafficEnabled2);
        }
    }

    public void setBuildingsEnabled(boolean buildingsEnabled2) {
        this.buildingsEnabled = buildingsEnabled2;
    }
}
