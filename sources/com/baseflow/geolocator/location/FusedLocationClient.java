package com.baseflow.geolocator.location;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;

@SynthesizedClassMap({$$Lambda$FusedLocationClient$3vlEP6o_UgaSbo2aGaN7Wtt15Y0.class, $$Lambda$FusedLocationClient$fxkAR12o3_Rrxwxh5GBA77TDaY.class, $$Lambda$FusedLocationClient$yq2BrSiRarae4RCU_EE_IJF9uzc.class, $$Lambda$FyNSKWRJ6K8pfIKflyK9zilTOk0.class})
class FusedLocationClient implements LocationClient {
    private static final int REQUEST_CHECK_SETTINGS = 1;
    @Nullable
    private Activity activity;
    private final Context context;
    /* access modifiers changed from: private */
    @Nullable
    public ErrorCallback errorCallback;
    /* access modifiers changed from: private */
    public final FusedLocationProviderClient fusedLocationProviderClient;
    /* access modifiers changed from: private */
    public final LocationCallback locationCallback = new LocationCallback() {
        public void onLocationResult(LocationResult locationResult) {
            if (locationResult == null || FusedLocationClient.this.positionChangedCallback == null) {
                Log.e("Geolocator", "LocationCallback was called with empty locationResult or no positionChangedCallback was registered.");
                FusedLocationClient.this.fusedLocationProviderClient.removeLocationUpdates(FusedLocationClient.this.locationCallback);
                if (FusedLocationClient.this.errorCallback != null) {
                    FusedLocationClient.this.errorCallback.onError(ErrorCodes.errorWhileAcquiringPosition);
                    return;
                }
                return;
            }
            FusedLocationClient.this.positionChangedCallback.onPositionChanged(locationResult.getLastLocation());
        }
    };
    @Nullable
    private LocationOptions locationOptions;
    /* access modifiers changed from: private */
    @Nullable
    public PositionChangedCallback positionChangedCallback;

    public FusedLocationClient(@NonNull Context context2) {
        this.context = context2;
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context2);
    }

    public boolean isLocationServiceEnabled() {
        LocationManager locationManager = (LocationManager) this.context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (locationManager == null) {
            return false;
        }
        boolean gps_enabled = locationManager.isProviderEnabled("gps");
        boolean network_enabled = locationManager.isProviderEnabled("network");
        if (gps_enabled || network_enabled) {
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void getLastKnownPosition(PositionChangedCallback positionChangedCallback2, ErrorCallback errorCallback2) {
        Task<Location> lastLocation = this.fusedLocationProviderClient.getLastLocation();
        positionChangedCallback2.getClass();
        lastLocation.addOnSuccessListener(new OnSuccessListener() {
            public final void onSuccess(Object obj) {
                PositionChangedCallback.this.onPositionChanged((Location) obj);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public final void onFailure(Exception exc) {
                FusedLocationClient.lambda$getLastKnownPosition$0(ErrorCallback.this, exc);
            }
        });
    }

    static /* synthetic */ void lambda$getLastKnownPosition$0(ErrorCallback errorCallback2, Exception e) {
        Log.e("Geolocator", "Error trying to get last the last known GPS location");
        if (errorCallback2 != null) {
            errorCallback2.onError(ErrorCodes.errorWhileAcquiringPosition);
        }
    }

    public boolean onActivityResult(int requestCode, int resultCode) {
        PositionChangedCallback positionChangedCallback2;
        ErrorCallback errorCallback2;
        if (requestCode == 1) {
            if (resultCode == -1) {
                LocationOptions locationOptions2 = this.locationOptions;
                if (locationOptions2 == null || (positionChangedCallback2 = this.positionChangedCallback) == null || (errorCallback2 = this.errorCallback) == null) {
                    return false;
                }
                startPositionUpdates(this.activity, locationOptions2, positionChangedCallback2, errorCallback2);
                return true;
            }
            ErrorCallback errorCallback3 = this.errorCallback;
            if (errorCallback3 != null) {
                errorCallback3.onError(ErrorCodes.locationServicesDisabled);
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void startPositionUpdates(@Nullable Activity activity2, @NonNull LocationOptions options, @NonNull PositionChangedCallback positionChangedCallback2, @NonNull ErrorCallback errorCallback2) {
        this.activity = activity2;
        this.locationOptions = options;
        this.positionChangedCallback = positionChangedCallback2;
        this.errorCallback = errorCallback2;
        LocationRequest locationRequest = buildLocationRequest(options);
        LocationServices.getSettingsClient(this.context).checkLocationSettings(buildLocationSettingsRequest(locationRequest)).addOnSuccessListener(new OnSuccessListener(locationRequest) {
            public final /* synthetic */ LocationRequest f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                FusedLocationClient.this.lambda$startPositionUpdates$1$FusedLocationClient(this.f$1, (LocationSettingsResponse) obj);
            }
        }).addOnFailureListener(new OnFailureListener(activity2, errorCallback2, locationRequest) {
            public final /* synthetic */ Activity f$1;
            public final /* synthetic */ ErrorCallback f$2;
            public final /* synthetic */ LocationRequest f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onFailure(Exception exc) {
                FusedLocationClient.this.lambda$startPositionUpdates$2$FusedLocationClient(this.f$1, this.f$2, this.f$3, exc);
            }
        });
    }

    public /* synthetic */ void lambda$startPositionUpdates$1$FusedLocationClient(LocationRequest locationRequest, LocationSettingsResponse locationSettingsResponse) {
        this.fusedLocationProviderClient.requestLocationUpdates(locationRequest, this.locationCallback, Looper.getMainLooper());
    }

    public /* synthetic */ void lambda$startPositionUpdates$2$FusedLocationClient(Activity activity2, ErrorCallback errorCallback2, LocationRequest locationRequest, Exception e) {
        if (e instanceof ResolvableApiException) {
            if (activity2 == null) {
                errorCallback2.onError(ErrorCodes.locationServicesDisabled);
                return;
            }
            ResolvableApiException rae = (ResolvableApiException) e;
            if (rae.getStatusCode() == 6) {
                try {
                    rae.startResolutionForResult(activity2, 1);
                } catch (IntentSender.SendIntentException e2) {
                    errorCallback2.onError(ErrorCodes.locationServicesDisabled);
                }
            } else {
                errorCallback2.onError(ErrorCodes.locationServicesDisabled);
            }
        } else if (((ApiException) e).getStatusCode() == 8502) {
            this.fusedLocationProviderClient.requestLocationUpdates(locationRequest, this.locationCallback, Looper.getMainLooper());
        } else {
            errorCallback2.onError(ErrorCodes.locationServicesDisabled);
        }
    }

    public void stopPositionUpdates() {
        this.fusedLocationProviderClient.removeLocationUpdates(this.locationCallback);
    }

    private static LocationRequest buildLocationRequest(LocationOptions options) {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(toPriority(options.getAccuracy()));
        locationRequest.setInterval(options.getTimeInterval());
        locationRequest.setFastestInterval(options.getTimeInterval() / 2);
        locationRequest.setSmallestDisplacement((float) options.getDistanceFilter());
        return locationRequest;
    }

    private static LocationSettingsRequest buildLocationSettingsRequest(LocationRequest locationRequest) {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(locationRequest);
        return builder.build();
    }

    /* renamed from: com.baseflow.geolocator.location.FusedLocationClient$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy;

        static {
            int[] iArr = new int[LocationAccuracy.values().length];
            $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy = iArr;
            try {
                iArr[LocationAccuracy.lowest.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.low.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.medium.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static int toPriority(LocationAccuracy locationAccuracy) {
        int i = AnonymousClass2.$SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[locationAccuracy.ordinal()];
        if (i == 1) {
            return 105;
        }
        if (i == 2) {
            return 104;
        }
        if (i != 3) {
            return 100;
        }
        return 102;
    }
}
