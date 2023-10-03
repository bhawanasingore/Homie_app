package io.flutter.embedding.engine.dart;

import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class DartMessenger implements BinaryMessenger, PlatformMessageHandler {
    private static final String TAG = "DartMessenger";
    private final FlutterJNI flutterJNI;
    private final Map<String, BinaryMessenger.BinaryMessageHandler> messageHandlers;
    private int nextReplyId = 1;
    private final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;

    DartMessenger(FlutterJNI flutterJNI2) {
        this.flutterJNI = flutterJNI2;
        this.messageHandlers = new HashMap();
        this.pendingReplies = new HashMap();
    }

    public void setMessageHandler(String channel, BinaryMessenger.BinaryMessageHandler handler) {
        if (handler == null) {
            Log.v(TAG, "Removing handler for channel '" + channel + "'");
            this.messageHandlers.remove(channel);
            return;
        }
        Log.v(TAG, "Setting handler for channel '" + channel + "'");
        this.messageHandlers.put(channel, handler);
    }

    public void send(String channel, ByteBuffer message) {
        Log.v(TAG, "Sending message over channel '" + channel + "'");
        send(channel, message, (BinaryMessenger.BinaryReply) null);
    }

    public void send(String channel, ByteBuffer message, BinaryMessenger.BinaryReply callback) {
        Log.v(TAG, "Sending message with callback over channel '" + channel + "'");
        int replyId = 0;
        if (callback != null) {
            int i = this.nextReplyId;
            this.nextReplyId = i + 1;
            replyId = i;
            this.pendingReplies.put(Integer.valueOf(replyId), callback);
        }
        if (message == null) {
            this.flutterJNI.dispatchEmptyPlatformMessage(channel, replyId);
        } else {
            this.flutterJNI.dispatchPlatformMessage(channel, message, message.position(), replyId);
        }
    }

    public void handleMessageFromDart(String channel, byte[] message, int replyId) {
        Log.v(TAG, "Received message from Dart over channel '" + channel + "'");
        BinaryMessenger.BinaryMessageHandler handler = this.messageHandlers.get(channel);
        if (handler != null) {
            try {
                Log.v(TAG, "Deferring to registered handler to process message.");
                handler.onMessage(message == null ? null : ByteBuffer.wrap(message), new Reply(this.flutterJNI, replyId));
            } catch (Exception ex) {
                Log.e(TAG, "Uncaught exception in binary message listener", ex);
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(replyId);
            }
        } else {
            Log.v(TAG, "No registered handler for message. Responding to Dart with empty reply message.");
            this.flutterJNI.invokePlatformMessageEmptyResponseCallback(replyId);
        }
    }

    public void handlePlatformMessageResponse(int replyId, byte[] reply) {
        Log.v(TAG, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply callback = this.pendingReplies.remove(Integer.valueOf(replyId));
        if (callback != null) {
            try {
                Log.v(TAG, "Invoking registered callback for reply from Dart.");
                callback.reply(reply == null ? null : ByteBuffer.wrap(reply));
            } catch (Exception ex) {
                Log.e(TAG, "Uncaught exception in binary message reply handler", ex);
            }
        }
    }

    public int getPendingChannelResponseCount() {
        return this.pendingReplies.size();
    }

    private static class Reply implements BinaryMessenger.BinaryReply {
        private final AtomicBoolean done = new AtomicBoolean(false);
        private final FlutterJNI flutterJNI;
        private final int replyId;

        Reply(FlutterJNI flutterJNI2, int replyId2) {
            this.flutterJNI = flutterJNI2;
            this.replyId = replyId2;
        }

        public void reply(ByteBuffer reply) {
            if (this.done.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            } else if (reply == null) {
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
            } else {
                this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, reply, reply.position());
            }
        }
    }
}
