package com.baseflow.geolocator.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.errors.PermissionUndefinedException;
import com.baseflow.geolocator.permission.LocationPermission;
import com.baseflow.geolocator.permission.PermissionManager;
import com.baseflow.geolocator.permission.PermissionResultCallback;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugin.common.PluginRegistry;

@SynthesizedClassMap({$$Lambda$GeolocationManager$04FQP7tQprNHcCieiWwsl7MHe6k.class, $$Lambda$GeolocationManager$boCQNh1HzLRO8yyNdeq6cg70Yc.class, $$Lambda$GeolocationManager$xQzGjEWcTQ0JUybv5iz2tOl2Xo.class})
public class GeolocationManager implements PluginRegistry.ActivityResultListener {
    @Nullable
    private LocationClient locationClient;
    @NonNull
    private final PermissionManager permissionManager;

    public GeolocationManager(@NonNull PermissionManager permissionManager2) {
        this.permissionManager = permissionManager2;
    }

    public void getLastKnownPosition(Context context, Activity activity, boolean forceLocationManager, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback) {
        handlePermissions(context, activity, new Runnable(context, forceLocationManager, positionChangedCallback, errorCallback) {
            public final /* synthetic */ Context f$1;
            public final /* synthetic */ boolean f$2;
            public final /* synthetic */ PositionChangedCallback f$3;
            public final /* synthetic */ ErrorCallback f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                GeolocationManager.this.lambda$getLastKnownPosition$0$GeolocationManager(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        }, errorCallback);
    }

    public /* synthetic */ void lambda$getLastKnownPosition$0$GeolocationManager(Context context, boolean forceLocationManager, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback) {
        createLocationClient(context, forceLocationManager).getLastKnownPosition(positionChangedCallback, errorCallback);
    }

    public boolean isLocationServiceEnabled(@Nullable Context context) {
        LocationManager locationManager;
        if (context == null || (locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)) == null) {
            return false;
        }
        boolean gps_enabled = locationManager.isProviderEnabled("gps");
        boolean network_enabled = locationManager.isProviderEnabled("network");
        if (gps_enabled || network_enabled) {
            return true;
        }
        return false;
    }

    public void startPositionUpdates(Context context, Activity activity, LocationOptions options, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback) {
        handlePermissions(context, activity, new Runnable(context, options, activity, positionChangedCallback, errorCallback) {
            public final /* synthetic */ Context f$1;
            public final /* synthetic */ LocationOptions f$2;
            public final /* synthetic */ Activity f$3;
            public final /* synthetic */ PositionChangedCallback f$4;
            public final /* synthetic */ ErrorCallback f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                GeolocationManager.this.lambda$startPositionUpdates$1$GeolocationManager(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        }, errorCallback);
    }

    public /* synthetic */ void lambda$startPositionUpdates$1$GeolocationManager(Context context, LocationOptions options, Activity activity, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback) {
        createLocationClient(context, options.isForceAndroidLocationManager()).startPositionUpdates(activity, options, positionChangedCallback, errorCallback);
    }

    public void stopPositionUpdates() {
        LocationClient locationClient2 = this.locationClient;
        if (locationClient2 != null) {
            locationClient2.stopPositionUpdates();
        }
    }

    private LocationClient createLocationClient(Context context, boolean forceLocationManagerClient) {
        if (forceLocationManagerClient) {
            LocationManagerClient locationManagerClient = new LocationManagerClient(context);
            this.locationClient = locationManagerClient;
            return locationManagerClient;
        }
        LocationClient fusedLocationClient = isGooglePlayServicesAvailable(context) ? new FusedLocationClient(context) : new LocationManagerClient(context);
        this.locationClient = fusedLocationClient;
        return fusedLocationClient;
    }

    private boolean isGooglePlayServicesAvailable(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
    }

    private void handlePermissions(Context context, @Nullable Activity activity, Runnable hasPermissionCallback, ErrorCallback errorCallback) {
        try {
            LocationPermission permissionStatus = this.permissionManager.checkPermissionStatus(context, activity);
            if (permissionStatus == LocationPermission.deniedForever) {
                errorCallback.onError(ErrorCodes.permissionDenied);
                return;
            }
            if (permissionStatus != LocationPermission.whileInUse) {
                if (permissionStatus != LocationPermission.always) {
                    if (permissionStatus != LocationPermission.denied || activity == null) {
                        errorCallback.onError(ErrorCodes.permissionDenied);
                    } else {
                        this.permissionManager.requestPermission(activity, new PermissionResultCallback(hasPermissionCallback, errorCallback) {
                            public final /* synthetic */ Runnable f$0;
                            public final /* synthetic */ ErrorCallback f$1;

                            {
                                this.f$0 = r1;
                                this.f$1 = r2;
                            }

                            public final void onResult(LocationPermission locationPermission) {
                                GeolocationManager.lambda$handlePermissions$2(this.f$0, this.f$1, locationPermission);
                            }
                        }, errorCallback);
                    }
                    return;
                }
            }
            hasPermissionCallback.run();
        } catch (PermissionUndefinedException e) {
            errorCallback.onError(ErrorCodes.permissionDefinitionsNotFound);
        }
    }

    static /* synthetic */ void lambda$handlePermissions$2(Runnable hasPermissionCallback, ErrorCallback errorCallback, LocationPermission permission) {
        if (permission == LocationPermission.whileInUse || permission == LocationPermission.always) {
            hasPermissionCallback.run();
        } else {
            errorCallback.onError(ErrorCodes.permissionDenied);
        }
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        LocationClient locationClient2 = this.locationClient;
        if (locationClient2 == null) {
            return false;
        }
        return locationClient2.onActivityResult(requestCode, resultCode);
    }
}
