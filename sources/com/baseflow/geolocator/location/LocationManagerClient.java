package com.baseflow.geolocator.location;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

class LocationManagerClient implements LocationClient, LocationListener {
    private static final long TWO_MINUTES = 120000;
    @Nullable
    private Location currentBestLocation;
    @Nullable
    private String currentLocationProvider;
    @Nullable
    private ErrorCallback errorCallback;
    private boolean isListening = false;
    private final LocationManager locationManager;
    @Nullable
    private LocationOptions locationOptions;
    @Nullable
    private PositionChangedCallback positionChangedCallback;

    public LocationManagerClient(@NonNull Context context) {
        this.locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
    }

    public boolean isLocationServiceEnabled() {
        LocationManager locationManager2 = this.locationManager;
        if (locationManager2 == null) {
            return false;
        }
        boolean gps_enabled = locationManager2.isProviderEnabled("gps");
        boolean network_enabled = this.locationManager.isProviderEnabled("network");
        if (gps_enabled || network_enabled) {
            return true;
        }
        return false;
    }

    public void getLastKnownPosition(PositionChangedCallback positionChangedCallback2, ErrorCallback errorCallback2) {
        Location bestLocation = null;
        for (String provider : this.locationManager.getProviders(true)) {
            Location location = this.locationManager.getLastKnownLocation(provider);
            if (location != null && isBetterLocation(location, bestLocation)) {
                bestLocation = location;
            }
        }
        positionChangedCallback2.onPositionChanged(bestLocation);
    }

    public boolean onActivityResult(int requestCode, int resultCode) {
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void startPositionUpdates(Activity activity, LocationOptions options, PositionChangedCallback positionChangedCallback2, ErrorCallback errorCallback2) {
        if (!isLocationServiceEnabled()) {
            errorCallback2.onError(ErrorCodes.locationServicesDisabled);
            return;
        }
        this.locationOptions = options;
        this.positionChangedCallback = positionChangedCallback2;
        this.errorCallback = errorCallback2;
        String bestProvider = getBestProvider(this.locationManager, options.getAccuracy());
        this.currentLocationProvider = bestProvider;
        if (Strings.isEmptyOrWhitespace(bestProvider)) {
            errorCallback2.onError(ErrorCodes.locationServicesDisabled);
            return;
        }
        this.isListening = true;
        this.locationManager.requestLocationUpdates(this.currentLocationProvider, options.getTimeInterval(), (float) options.getDistanceFilter(), this, Looper.getMainLooper());
    }

    @SuppressLint({"MissingPermission"})
    public void stopPositionUpdates() {
        this.isListening = false;
        this.locationManager.removeUpdates(this);
    }

    public synchronized void onLocationChanged(Location location) {
        float desiredAccuracy = this.locationOptions != null ? accuracyToFloat(this.locationOptions.getAccuracy()) : 50.0f;
        if (isBetterLocation(location, this.currentBestLocation) && location.getAccuracy() <= desiredAccuracy) {
            this.currentBestLocation = location;
            if (this.positionChangedCallback != null) {
                this.positionChangedCallback.onPositionChanged(location);
            }
        }
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
        if (status == 2) {
            onProviderEnabled(provider);
        } else if (status == 0) {
            onProviderDisabled(provider);
        }
    }

    public void onProviderEnabled(String provider) {
    }

    @SuppressLint({"MissingPermission"})
    public void onProviderDisabled(String provider) {
        if (provider.equals(this.currentLocationProvider)) {
            if (this.isListening) {
                this.locationManager.removeUpdates(this);
            }
            ErrorCallback errorCallback2 = this.errorCallback;
            if (errorCallback2 != null) {
                errorCallback2.onError(ErrorCodes.locationServicesDisabled);
            }
            this.currentLocationProvider = null;
        }
    }

    static boolean isBetterLocation(Location location, Location bestLocation) {
        if (bestLocation == null) {
            return true;
        }
        Long timeDelta = Long.valueOf(location.getTime() - bestLocation.getTime());
        boolean isSignificantlyNewer = timeDelta.longValue() > TWO_MINUTES;
        boolean isSignificantlyOlder = timeDelta.longValue() < -120000;
        boolean isNewer = timeDelta.longValue() > 0;
        if (isSignificantlyNewer) {
            return true;
        }
        if (isSignificantlyOlder) {
            return false;
        }
        float accuracyDelta = (float) ((int) (location.getAccuracy() - bestLocation.getAccuracy()));
        boolean isLessAccurate = accuracyDelta > 0.0f;
        boolean isMoreAccurate = accuracyDelta < 0.0f;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200.0f;
        boolean isFromSameProvider = false;
        if (location.getProvider() != null) {
            isFromSameProvider = location.getProvider().equals(bestLocation.getProvider());
        }
        if (isMoreAccurate) {
            return true;
        }
        if (isNewer && !isLessAccurate) {
            return true;
        }
        if (!isNewer || isSignificantlyLessAccurate || !isFromSameProvider) {
            return false;
        }
        return true;
    }

    private static String getBestProvider(LocationManager locationManager2, LocationAccuracy accuracy) {
        Criteria criteria = new Criteria();
        criteria.setBearingRequired(false);
        criteria.setAltitudeRequired(false);
        criteria.setSpeedRequired(false);
        int i = AnonymousClass1.$SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[accuracy.ordinal()];
        if (i == 1) {
            criteria.setAccuracy(0);
            criteria.setHorizontalAccuracy(0);
            criteria.setPowerRequirement(0);
        } else if (i == 2) {
            criteria.setAccuracy(2);
            criteria.setHorizontalAccuracy(1);
            criteria.setPowerRequirement(0);
        } else if (i != 3) {
            criteria.setAccuracy(1);
            criteria.setHorizontalAccuracy(3);
            criteria.setPowerRequirement(3);
        } else {
            criteria.setAccuracy(2);
            criteria.setHorizontalAccuracy(2);
            criteria.setPowerRequirement(2);
        }
        String provider = locationManager2.getBestProvider(criteria, true);
        if (!Strings.isEmptyOrWhitespace(provider)) {
            return provider;
        }
        List<String> providers = locationManager2.getProviders(true);
        if (providers.size() > 0) {
            return providers.get(0);
        }
        return provider;
    }

    /* renamed from: com.baseflow.geolocator.location.LocationManagerClient$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
            try {
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.best.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.bestForNavigation.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static float accuracyToFloat(LocationAccuracy accuracy) {
        int i = AnonymousClass1.$SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[accuracy.ordinal()];
        if (i == 1 || i == 2) {
            return 500.0f;
        }
        if (i == 3) {
            return 250.0f;
        }
        if (i == 4 || i == 5) {
            return 50.0f;
        }
        return 100.0f;
    }
}
