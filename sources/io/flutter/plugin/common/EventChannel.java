package io.flutter.plugin.common;

import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class EventChannel {
    private static final String TAG = "EventChannel#";
    /* access modifiers changed from: private */
    public final MethodCodec codec;
    /* access modifiers changed from: private */
    public final BinaryMessenger messenger;
    /* access modifiers changed from: private */
    public final String name;

    public interface EventSink {
        void endOfStream();

        void error(String str, String str2, Object obj);

        void success(Object obj);
    }

    public interface StreamHandler {
        void onCancel(Object obj);

        void onListen(Object obj, EventSink eventSink);
    }

    public EventChannel(BinaryMessenger messenger2, String name2) {
        this(messenger2, name2, StandardMethodCodec.INSTANCE);
    }

    public EventChannel(BinaryMessenger messenger2, String name2, MethodCodec codec2) {
        if (messenger2 == null) {
            Log.e(TAG, "Parameter messenger must not be null.");
        }
        if (name2 == null) {
            Log.e(TAG, "Parameter name must not be null.");
        }
        if (codec2 == null) {
            Log.e(TAG, "Parameter codec must not be null.");
        }
        this.messenger = messenger2;
        this.name = name2;
        this.codec = codec2;
    }

    public void setStreamHandler(StreamHandler handler) {
        this.messenger.setMessageHandler(this.name, handler == null ? null : new IncomingStreamRequestHandler(handler));
    }

    private final class IncomingStreamRequestHandler implements BinaryMessenger.BinaryMessageHandler {
        /* access modifiers changed from: private */
        public final AtomicReference<EventSink> activeSink = new AtomicReference<>((Object) null);
        private final StreamHandler handler;

        IncomingStreamRequestHandler(StreamHandler handler2) {
            this.handler = handler2;
        }

        public void onMessage(ByteBuffer message, BinaryMessenger.BinaryReply reply) {
            MethodCall call = EventChannel.this.codec.decodeMethodCall(message);
            if (call.method.equals("listen")) {
                onListen(call.arguments, reply);
            } else if (call.method.equals("cancel")) {
                onCancel(call.arguments, reply);
            } else {
                reply.reply((ByteBuffer) null);
            }
        }

        private void onListen(Object arguments, BinaryMessenger.BinaryReply callback) {
            EventSink eventSink = new EventSinkImplementation();
            if (this.activeSink.getAndSet(eventSink) != null) {
                try {
                    this.handler.onCancel((Object) null);
                } catch (RuntimeException e) {
                    Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to close existing event stream", e);
                }
            }
            try {
                this.handler.onListen(arguments, eventSink);
                callback.reply(EventChannel.this.codec.encodeSuccessEnvelope((Object) null));
            } catch (RuntimeException e2) {
                this.activeSink.set((Object) null);
                Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to open event stream", e2);
                callback.reply(EventChannel.this.codec.encodeErrorEnvelope("error", e2.getMessage(), (Object) null));
            }
        }

        private void onCancel(Object arguments, BinaryMessenger.BinaryReply callback) {
            if (this.activeSink.getAndSet((Object) null) != null) {
                try {
                    this.handler.onCancel(arguments);
                    callback.reply(EventChannel.this.codec.encodeSuccessEnvelope((Object) null));
                } catch (RuntimeException e) {
                    Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to close event stream", e);
                    callback.reply(EventChannel.this.codec.encodeErrorEnvelope("error", e.getMessage(), (Object) null));
                }
            } else {
                callback.reply(EventChannel.this.codec.encodeErrorEnvelope("error", "No active stream to cancel", (Object) null));
            }
        }

        private final class EventSinkImplementation implements EventSink {
            final AtomicBoolean hasEnded;

            private EventSinkImplementation() {
                this.hasEnded = new AtomicBoolean(false);
            }

            public void success(Object event) {
                if (!this.hasEnded.get() && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeSuccessEnvelope(event));
                }
            }

            public void error(String errorCode, String errorMessage, Object errorDetails) {
                if (!this.hasEnded.get() && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeErrorEnvelope(errorCode, errorMessage, errorDetails));
                }
            }

            public void endOfStream() {
                if (!this.hasEnded.getAndSet(true) && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.messenger.send(EventChannel.this.name, (ByteBuffer) null);
                }
            }
        }
    }
}
