package io.flutter.plugins.googlemaps;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleMapFactory extends PlatformViewFactory {
    private final int activityHashCode;
    private final Application application;
    private final BinaryMessenger binaryMessenger;
    private final Lifecycle lifecycle;
    private final AtomicInteger mActivityState;
    private final PluginRegistry.Registrar registrar;

    GoogleMapFactory(AtomicInteger state, BinaryMessenger binaryMessenger2, Application application2, Lifecycle lifecycle2, PluginRegistry.Registrar registrar2, int activityHashCode2) {
        super(StandardMessageCodec.INSTANCE);
        this.mActivityState = state;
        this.binaryMessenger = binaryMessenger2;
        this.application = application2;
        this.activityHashCode = activityHashCode2;
        this.lifecycle = lifecycle2;
        this.registrar = registrar2;
    }

    public PlatformView create(Context context, int id, Object args) {
        Map<String, Object> params = (Map) args;
        GoogleMapBuilder builder = new GoogleMapBuilder();
        Convert.interpretGoogleMapOptions(params.get("options"), builder);
        if (params.containsKey("initialCameraPosition")) {
            builder.setInitialCameraPosition(Convert.toCameraPosition(params.get("initialCameraPosition")));
        }
        if (params.containsKey("markersToAdd")) {
            builder.setInitialMarkers(params.get("markersToAdd"));
        }
        if (params.containsKey("polygonsToAdd")) {
            builder.setInitialPolygons(params.get("polygonsToAdd"));
        }
        if (params.containsKey("polylinesToAdd")) {
            builder.setInitialPolylines(params.get("polylinesToAdd"));
        }
        if (params.containsKey("circlesToAdd")) {
            builder.setInitialCircles(params.get("circlesToAdd"));
        }
        return builder.build(id, context, this.mActivityState, this.binaryMessenger, this.application, this.lifecycle, this.registrar, this.activityHashCode);
    }
}
