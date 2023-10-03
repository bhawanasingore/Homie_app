package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.location.LocationMapper;
import com.baseflow.geolocator.location.LocationOptions;
import com.baseflow.geolocator.location.PositionChangedCallback;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import java.util.Map;

@SynthesizedClassMap({$$Lambda$StreamHandlerImpl$BOOiqCIJ_WkQplm9XX2LCj93ut8.class, $$Lambda$StreamHandlerImpl$ofPd5DqE4V4MtlkXojcfhfF0TI.class})
class StreamHandlerImpl implements EventChannel.StreamHandler {
    private static final String TAG = "StreamHandlerImpl";
    @Nullable
    private Activity activity;
    @Nullable
    private EventChannel channel;
    @Nullable
    private Context context;
    private final GeolocationManager geolocationManager;

    public StreamHandlerImpl(GeolocationManager geolocationManager2) {
        this.geolocationManager = geolocationManager2;
    }

    /* access modifiers changed from: package-private */
    public void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    /* access modifiers changed from: package-private */
    public void startListening(Context context2, BinaryMessenger messenger) {
        if (this.channel != null) {
            Log.w(TAG, "Setting a event call handler before the last was disposed.");
            stopListening();
        }
        EventChannel eventChannel = new EventChannel(messenger, "flutter.baseflow.com/geolocator_updates");
        this.channel = eventChannel;
        eventChannel.setStreamHandler(this);
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public void stopListening() {
        EventChannel eventChannel = this.channel;
        if (eventChannel == null) {
            Log.d(TAG, "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        eventChannel.setStreamHandler((EventChannel.StreamHandler) null);
        this.channel = null;
    }

    public void onListen(Object arguments, EventChannel.EventSink events) {
        this.geolocationManager.startPositionUpdates(this.context, this.activity, LocationOptions.parseArguments((Map) arguments), new PositionChangedCallback() {
            public final void onPositionChanged(Location location) {
                EventChannel.EventSink.this.success(LocationMapper.toHashMap(location));
            }
        }, new ErrorCallback() {
            public final void onError(ErrorCodes errorCodes) {
                EventChannel.EventSink.this.error(errorCodes.toString(), errorCodes.toDescription(), (Object) null);
            }
        });
    }

    public void onCancel(Object arguments) {
        this.geolocationManager.stopPositionUpdates();
    }
}
