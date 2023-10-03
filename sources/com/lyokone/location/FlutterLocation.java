package com.lyokone.location;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;

class FlutterLocation implements PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener {
    private static final int GPS_ENABLE_REQUEST = 4097;
    private static final int REQUEST_CHECK_SETTINGS = 1;
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    private static final String TAG = "FlutterLocation";
    private static float distanceFilter = 0.0f;
    private static long fastestUpdateIntervalMilliseconds = (5000 / 2);
    private static Integer locationAccuracy = 100;
    /* access modifiers changed from: private */
    public static LocationRequest mLocationRequest;
    private static long updateIntervalMilliseconds = 5000;
    @Nullable
    public Activity activity;
    private final Context applicationContext;
    public EventChannel.EventSink events;
    public MethodChannel.Result getLocationResult;
    /* access modifiers changed from: private */
    public LocationManager locationManager;
    private int locationPermissionState;
    public FusedLocationProviderClient mFusedLocationClient;
    /* access modifiers changed from: private */
    public Double mLastMslAltitude;
    public LocationCallback mLocationCallback;
    private LocationSettingsRequest mLocationSettingsRequest;
    /* access modifiers changed from: private */
    @TargetApi(24)
    public OnNmeaMessageListener mMessageListener;
    private SettingsClient mSettingsClient;
    public HashMap<Integer, Integer> mapFlutterAccuracy;
    public MethodChannel.Result result;
    private boolean waitingForPermission;

    FlutterLocation(Context applicationContext2, @Nullable Activity activity2) {
        this.waitingForPermission = false;
        this.mapFlutterAccuracy = new HashMap<Integer, Integer>() {
            {
                put(0, 105);
                put(1, 104);
                put(2, 102);
                put(3, 100);
                put(4, 100);
            }
        };
        this.applicationContext = applicationContext2;
        this.activity = activity2;
    }

    FlutterLocation(PluginRegistry.Registrar registrar) {
        this(registrar.context(), registrar.activity());
        registrar.addRequestPermissionsResultListener(this);
    }

    /* access modifiers changed from: package-private */
    public void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
        this.mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity2);
        this.mSettingsClient = LocationServices.getSettingsClient(activity2);
        this.locationManager = (LocationManager) activity2.getSystemService(FirebaseAnalytics.Param.LOCATION);
        createLocationCallback();
        createLocationRequest();
        buildLocationSettingsRequest();
    }

    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        return onRequestPermissionsResultHandler(requestCode, permissions, grantResults);
    }

    public boolean onRequestPermissionsResultHandler(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != 34 || permissions.length != 1 || !permissions[0].equals("android.permission.ACCESS_FINE_LOCATION")) {
            return false;
        }
        if (grantResults[0] == 0) {
            if (!(this.getLocationResult == null && this.events == null)) {
                startRequestingLocation();
            }
            MethodChannel.Result result2 = this.result;
            if (result2 != null) {
                result2.success(1);
                this.result = null;
            }
        } else if (!shouldShowRequestPermissionRationale()) {
            sendError("PERMISSION_DENIED_NEVER_ASK", "Location permission denied forever - please open app settings", (Object) null);
            MethodChannel.Result result3 = this.result;
            if (result3 != null) {
                result3.success(2);
                this.result = null;
            }
        } else {
            sendError("PERMISSION_DENIED", "Location permission denied", (Object) null);
            MethodChannel.Result result4 = this.result;
            if (result4 != null) {
                result4.success(0);
                this.result = null;
            }
        }
        return true;
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        MethodChannel.Result result2 = this.result;
        if (result2 == null) {
            return false;
        }
        if (requestCode != 1) {
            if (requestCode != 4097) {
                return false;
            }
            if (resultCode == -1) {
                result2.success(1);
            } else {
                result2.success(0);
            }
            return true;
        } else if (resultCode == -1) {
            startRequestingLocation();
            return true;
        } else {
            result2.error("SERVICE_STATUS_DISABLED", "Failed to get location. Location services disabled", (Object) null);
            return false;
        }
    }

    public void changeSettings(Integer locationAccuracy2, Long updateIntervalMilliseconds2, Long fastestUpdateIntervalMilliseconds2, Float distanceFilter2) {
        locationAccuracy = locationAccuracy2;
        updateIntervalMilliseconds = updateIntervalMilliseconds2.longValue();
        fastestUpdateIntervalMilliseconds = fastestUpdateIntervalMilliseconds2.longValue();
        distanceFilter = distanceFilter2.floatValue();
        createLocationCallback();
        createLocationRequest();
        buildLocationSettingsRequest();
    }

    /* access modifiers changed from: private */
    public void sendError(String errorCode, String errorMessage, Object errorDetails) {
        MethodChannel.Result result2 = this.getLocationResult;
        if (result2 != null) {
            result2.error(errorCode, errorMessage, errorDetails);
            this.getLocationResult = null;
        }
        EventChannel.EventSink eventSink = this.events;
        if (eventSink != null) {
            eventSink.error(errorCode, errorMessage, errorDetails);
            this.events = null;
        }
    }

    private void createLocationCallback() {
        this.mLocationCallback = new LocationCallback() {
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                Location location = locationResult.getLastLocation();
                HashMap<String, Double> loc = new HashMap<>();
                loc.put("latitude", Double.valueOf(location.getLatitude()));
                loc.put("longitude", Double.valueOf(location.getLongitude()));
                loc.put("accuracy", Double.valueOf((double) location.getAccuracy()));
                if (FlutterLocation.this.mLastMslAltitude == null || Build.VERSION.SDK_INT < 24) {
                    loc.put("altitude", Double.valueOf(location.getAltitude()));
                } else {
                    loc.put("altitude", FlutterLocation.this.mLastMslAltitude);
                }
                loc.put("speed", Double.valueOf((double) location.getSpeed()));
                if (Build.VERSION.SDK_INT >= 26) {
                    loc.put("speed_accuracy", Double.valueOf((double) location.getSpeedAccuracyMetersPerSecond()));
                }
                loc.put("heading", Double.valueOf((double) location.getBearing()));
                loc.put("time", Double.valueOf((double) location.getTime()));
                if (FlutterLocation.this.getLocationResult != null) {
                    FlutterLocation.this.getLocationResult.success(loc);
                    FlutterLocation.this.getLocationResult = null;
                }
                if (FlutterLocation.this.events != null) {
                    FlutterLocation.this.events.success(loc);
                } else {
                    FlutterLocation.this.mFusedLocationClient.removeLocationUpdates(FlutterLocation.this.mLocationCallback);
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 24) {
            this.mMessageListener = new OnNmeaMessageListener() {
                public void onNmeaMessage(String message, long timestamp) {
                    if (message.startsWith("$")) {
                        String[] tokens = message.split(",");
                        if (tokens[0].startsWith("$GPGGA") && tokens.length > 9 && !tokens[9].isEmpty()) {
                            Double unused = FlutterLocation.this.mLastMslAltitude = Double.valueOf(Double.parseDouble(tokens[9]));
                        }
                    }
                }
            };
        }
    }

    private void createLocationRequest() {
        LocationRequest create = LocationRequest.create();
        mLocationRequest = create;
        create.setInterval(updateIntervalMilliseconds);
        mLocationRequest.setFastestInterval(fastestUpdateIntervalMilliseconds);
        mLocationRequest.setPriority(locationAccuracy.intValue());
        mLocationRequest.setSmallestDisplacement(distanceFilter);
    }

    private void buildLocationSettingsRequest() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        this.mLocationSettingsRequest = builder.build();
    }

    public boolean checkPermissions() {
        int checkSelfPermission = ActivityCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_FINE_LOCATION");
        this.locationPermissionState = checkSelfPermission;
        return checkSelfPermission == 0;
    }

    public void requestPermissions() {
        if (checkPermissions()) {
            this.result.success(1);
        } else {
            ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 34);
        }
    }

    public boolean shouldShowRequestPermissionRationale() {
        return ActivityCompat.shouldShowRequestPermissionRationale(this.activity, "android.permission.ACCESS_FINE_LOCATION");
    }

    public boolean checkServiceEnabled(MethodChannel.Result result2) {
        try {
            boolean gps_enabled = this.locationManager.isProviderEnabled("gps");
            boolean network_enabled = this.locationManager.isProviderEnabled("network");
            if (gps_enabled || network_enabled) {
                if (result2 != null) {
                    result2.success(1);
                }
                return true;
            }
            if (result2 != null) {
                result2.success(0);
            }
            return false;
        } catch (Exception e) {
            result2.error("SERVICE_STATUS_ERROR", "Location service status couldn't be determined", (Object) null);
            return false;
        }
    }

    public void requestService(final MethodChannel.Result result2) {
        if (checkServiceEnabled((MethodChannel.Result) null)) {
            result2.success(1);
            return;
        }
        this.result = result2;
        this.mSettingsClient.checkLocationSettings(this.mLocationSettingsRequest).addOnFailureListener(this.activity, (OnFailureListener) new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    ResolvableApiException rae = (ResolvableApiException) e;
                    int statusCode = rae.getStatusCode();
                    if (statusCode == 6) {
                        try {
                            rae.startResolutionForResult(FlutterLocation.this.activity, 4097);
                        } catch (IntentSender.SendIntentException e2) {
                            result2.error("SERVICE_STATUS_ERROR", "Could not resolve location request", (Object) null);
                        }
                    } else if (statusCode == 8502) {
                        result2.error("SERVICE_STATUS_DISABLED", "Failed to get location. Location services disabled", (Object) null);
                    }
                } else {
                    result2.error("SERVICE_STATUS_ERROR", "Unexpected error type received", (Object) null);
                }
            }
        });
    }

    public void startRequestingLocation() {
        this.mSettingsClient.checkLocationSettings(this.mLocationSettingsRequest).addOnSuccessListener(this.activity, new OnSuccessListener<LocationSettingsResponse>() {
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                if (Build.VERSION.SDK_INT >= 24) {
                    FlutterLocation.this.locationManager.addNmeaListener(FlutterLocation.this.mMessageListener);
                }
                FlutterLocation.this.mFusedLocationClient.requestLocationUpdates(FlutterLocation.mLocationRequest, FlutterLocation.this.mLocationCallback, Looper.myLooper());
            }
        }).addOnFailureListener(this.activity, (OnFailureListener) new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    ResolvableApiException rae = (ResolvableApiException) e;
                    if (rae.getStatusCode() == 6) {
                        try {
                            rae.startResolutionForResult(FlutterLocation.this.activity, 1);
                        } catch (IntentSender.SendIntentException e2) {
                            Log.i(FlutterLocation.TAG, "PendingIntent unable to execute request.");
                        }
                    }
                } else if (((ApiException) e).getStatusCode() != 8502) {
                    FlutterLocation.this.sendError("UNEXPECTED_ERROR", e.getMessage(), (Object) null);
                } else {
                    if (Build.VERSION.SDK_INT >= 24) {
                        FlutterLocation.this.locationManager.addNmeaListener(FlutterLocation.this.mMessageListener);
                    }
                    FlutterLocation.this.mFusedLocationClient.requestLocationUpdates(FlutterLocation.mLocationRequest, FlutterLocation.this.mLocationCallback, Looper.myLooper());
                }
            }
        });
    }
}
