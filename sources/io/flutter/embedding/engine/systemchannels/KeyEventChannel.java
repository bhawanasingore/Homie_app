package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import android.view.InputDevice;
import android.view.KeyEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.JSONMessageCodec;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class KeyEventChannel {
    private static final String TAG = "KeyEventChannel";
    public final BasicMessageChannel<Object> channel;
    private EventResponseHandler eventResponseHandler;

    public interface EventResponseHandler {
        void onKeyEventHandled(long j);

        void onKeyEventNotHandled(long j);
    }

    public void setEventResponseHandler(EventResponseHandler handler) {
        this.eventResponseHandler = handler;
    }

    public KeyEventChannel(BinaryMessenger binaryMessenger) {
        this.channel = new BasicMessageChannel<>(binaryMessenger, "flutter/keyevent", JSONMessageCodec.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public BasicMessageChannel.Reply<Object> createReplyHandler(long eventId) {
        return new BasicMessageChannel.Reply(eventId) {
            public final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            public final void reply(Object obj) {
                KeyEventChannel.this.lambda$createReplyHandler$0$KeyEventChannel(this.f$1, obj);
            }
        };
    }

    public /* synthetic */ void lambda$createReplyHandler$0$KeyEventChannel(long eventId, Object message) {
        EventResponseHandler eventResponseHandler2 = this.eventResponseHandler;
        if (eventResponseHandler2 != null) {
            if (message == null) {
                try {
                    eventResponseHandler2.onKeyEventNotHandled(eventId);
                } catch (JSONException e) {
                    Log.e(TAG, "Unable to unpack JSON message: " + e);
                    this.eventResponseHandler.onKeyEventNotHandled(eventId);
                }
            } else if (((JSONObject) message).getBoolean("handled")) {
                this.eventResponseHandler.onKeyEventHandled(eventId);
            } else {
                this.eventResponseHandler.onKeyEventNotHandled(eventId);
            }
        }
    }

    public void keyUp(FlutterKeyEvent keyEvent) {
        Map<String, Object> message = new HashMap<>();
        message.put("type", "keyup");
        message.put("keymap", Constants.ANDROID);
        encodeKeyEvent(keyEvent, message);
        this.channel.send(message, createReplyHandler(keyEvent.eventId));
    }

    public void keyDown(FlutterKeyEvent keyEvent) {
        Map<String, Object> message = new HashMap<>();
        message.put("type", "keydown");
        message.put("keymap", Constants.ANDROID);
        encodeKeyEvent(keyEvent, message);
        this.channel.send(message, createReplyHandler(keyEvent.eventId));
    }

    private void encodeKeyEvent(FlutterKeyEvent event, Map<String, Object> message) {
        message.put("flags", Integer.valueOf(event.flags));
        message.put("plainCodePoint", Integer.valueOf(event.plainCodePoint));
        message.put("codePoint", Integer.valueOf(event.codePoint));
        message.put("keyCode", Integer.valueOf(event.keyCode));
        message.put("scanCode", Integer.valueOf(event.scanCode));
        message.put("metaState", Integer.valueOf(event.metaState));
        if (event.complexCharacter != null) {
            message.put(FirebaseAnalytics.Param.CHARACTER, event.complexCharacter.toString());
        }
        message.put(FirebaseAnalytics.Param.SOURCE, Integer.valueOf(event.source));
        message.put("vendorId", Integer.valueOf(event.vendorId));
        message.put("productId", Integer.valueOf(event.productId));
        message.put("deviceId", Integer.valueOf(event.deviceId));
        message.put("repeatCount", Integer.valueOf(event.repeatCount));
    }

    public static class FlutterKeyEvent {
        public final int codePoint;
        public final Character complexCharacter;
        public final int deviceId;
        public final long eventId;
        public final int flags;
        public final int keyCode;
        public final int metaState;
        public final int plainCodePoint;
        public final int productId;
        public final int repeatCount;
        public final int scanCode;
        public final int source;
        public final int vendorId;

        public FlutterKeyEvent(KeyEvent androidKeyEvent, long eventId2) {
            this(androidKeyEvent, (Character) null, eventId2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public FlutterKeyEvent(KeyEvent androidKeyEvent, Character complexCharacter2, long eventId2) {
            this(androidKeyEvent.getDeviceId(), androidKeyEvent.getFlags(), androidKeyEvent.getUnicodeChar(0), androidKeyEvent.getUnicodeChar(), androidKeyEvent.getKeyCode(), complexCharacter2, androidKeyEvent.getScanCode(), androidKeyEvent.getMetaState(), androidKeyEvent.getSource(), androidKeyEvent.getRepeatCount(), eventId2);
            KeyEvent keyEvent = androidKeyEvent;
        }

        public FlutterKeyEvent(int deviceId2, int flags2, int plainCodePoint2, int codePoint2, int keyCode2, Character complexCharacter2, int scanCode2, int metaState2, int source2, int repeatCount2, long eventId2) {
            this.deviceId = deviceId2;
            this.flags = flags2;
            this.plainCodePoint = plainCodePoint2;
            this.codePoint = codePoint2;
            this.keyCode = keyCode2;
            this.complexCharacter = complexCharacter2;
            this.scanCode = scanCode2;
            this.metaState = metaState2;
            this.source = source2;
            this.repeatCount = repeatCount2;
            this.eventId = eventId2;
            InputDevice device = InputDevice.getDevice(deviceId2);
            if (device == null) {
                this.vendorId = 0;
                this.productId = 0;
            } else if (Build.VERSION.SDK_INT >= 19) {
                this.vendorId = device.getVendorId();
                this.productId = device.getProductId();
            } else {
                this.vendorId = 0;
                this.productId = 0;
            }
        }
    }
}
