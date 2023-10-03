package com.lyokone.location;

import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;

class StreamHandlerImpl implements EventChannel.StreamHandler {
    private static final String STREAM_CHANNEL_NAME = "lyokone/locationstream";
    private static final String TAG = "StreamHandlerImpl";
    private EventChannel channel;
    private final FlutterLocation location;

    StreamHandlerImpl(FlutterLocation location2) {
        this.location = location2;
    }

    /* access modifiers changed from: package-private */
    public void startListening(BinaryMessenger messenger) {
        if (this.channel != null) {
            Log.wtf(TAG, "Setting a method call handler before the last was disposed.");
            stopListening();
        }
        EventChannel eventChannel = new EventChannel(messenger, STREAM_CHANNEL_NAME);
        this.channel = eventChannel;
        eventChannel.setStreamHandler(this);
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

    public void onListen(Object arguments, EventChannel.EventSink eventsSink) {
        this.location.events = eventsSink;
        if (this.location.activity == null) {
            eventsSink.error("NO_ACTIVITY", (String) null, (Object) null);
        } else if (!this.location.checkPermissions()) {
            this.location.requestPermissions();
        } else {
            this.location.startRequestingLocation();
        }
    }

    public void onCancel(Object arguments) {
        this.location.mFusedLocationClient.removeLocationUpdates(this.location.mLocationCallback);
        this.location.events = null;
    }
}
