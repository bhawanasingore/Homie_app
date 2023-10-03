package com.baseflow.geolocator.location;

import android.app.Activity;
import com.baseflow.geolocator.errors.ErrorCallback;

interface LocationClient {
    void getLastKnownPosition(PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback);

    boolean isLocationServiceEnabled();

    boolean onActivityResult(int i, int i2);

    void startPositionUpdates(Activity activity, LocationOptions locationOptions, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback);

    void stopPositionUpdates();
}
