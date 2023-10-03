package io.flutter.plugin.common;

import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;

public class MethodChannel {
    private static final String TAG = "MethodChannel#";
    /* access modifiers changed from: private */
    public final MethodCodec codec;
    private final BinaryMessenger messenger;
    /* access modifiers changed from: private */
    public final String name;

    public interface MethodCallHandler {
        void onMethodCall(MethodCall methodCall, Result result);
    }

    public interface Result {
        void error(String str, String str2, Object obj);

        void notImplemented();

        void success(Object obj);
    }

    public MethodChannel(BinaryMessenger messenger2, String name2) {
        this(messenger2, name2, StandardMethodCodec.INSTANCE);
    }

    public MethodChannel(BinaryMessenger messenger2, String name2, MethodCodec codec2) {
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

    public void invokeMethod(String method, Object arguments) {
        invokeMethod(method, arguments, (Result) null);
    }

    public void invokeMethod(String method, Object arguments, Result callback) {
        this.messenger.send(this.name, this.codec.encodeMethodCall(new MethodCall(method, arguments)), callback == null ? null : new IncomingResultHandler(callback));
    }

    public void setMethodCallHandler(MethodCallHandler handler) {
        this.messenger.setMessageHandler(this.name, handler == null ? null : new IncomingMethodCallHandler(handler));
    }

    public void resizeChannelBuffer(int newSize) {
        BasicMessageChannel.resizeChannelBuffer(this.messenger, this.name, newSize);
    }

    private final class IncomingResultHandler implements BinaryMessenger.BinaryReply {
        private final Result callback;

        IncomingResultHandler(Result callback2) {
            this.callback = callback2;
        }

        public void reply(ByteBuffer reply) {
            if (reply == null) {
                try {
                    this.callback.notImplemented();
                } catch (RuntimeException e) {
                    Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call result", e);
                }
            } else {
                try {
                    this.callback.success(MethodChannel.this.codec.decodeEnvelope(reply));
                } catch (FlutterException e2) {
                    this.callback.error(e2.code, e2.getMessage(), e2.details);
                }
            }
        }
    }

    private final class IncomingMethodCallHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MethodCallHandler handler;

        IncomingMethodCallHandler(MethodCallHandler handler2) {
            this.handler = handler2;
        }

        public void onMessage(ByteBuffer message, final BinaryMessenger.BinaryReply reply) {
            try {
                this.handler.onMethodCall(MethodChannel.this.codec.decodeMethodCall(message), new Result() {
                    public void success(Object result) {
                        reply.reply(MethodChannel.this.codec.encodeSuccessEnvelope(result));
                    }

                    public void error(String errorCode, String errorMessage, Object errorDetails) {
                        reply.reply(MethodChannel.this.codec.encodeErrorEnvelope(errorCode, errorMessage, errorDetails));
                    }

                    public void notImplemented() {
                        reply.reply((ByteBuffer) null);
                    }
                });
            } catch (RuntimeException e) {
                Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call", e);
                reply.reply(MethodChannel.this.codec.encodeErrorEnvelopeWithStacktrace("error", e.getMessage(), (Object) null, getStackTrace(e)));
            }
        }

        private String getStackTrace(Exception e) {
            Writer result = new StringWriter();
            e.printStackTrace(new PrintWriter(result));
            return result.toString();
        }
    }
}
