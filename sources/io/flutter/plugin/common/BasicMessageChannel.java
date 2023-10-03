package io.flutter.plugin.common;

import android.util.Log;
import com.bumptech.glide.load.Key;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;

public final class BasicMessageChannel<T> {
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
    private static final String TAG = "BasicMessageChannel#";
    /* access modifiers changed from: private */
    public final MessageCodec<T> codec;
    private final BinaryMessenger messenger;
    /* access modifiers changed from: private */
    public final String name;

    public interface MessageHandler<T> {
        void onMessage(T t, Reply<T> reply);
    }

    public interface Reply<T> {
        void reply(T t);
    }

    public BasicMessageChannel(BinaryMessenger messenger2, String name2, MessageCodec<T> codec2) {
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

    public void send(T message) {
        send(message, (Reply) null);
    }

    public void send(T message, Reply<T> callback) {
        BinaryMessenger binaryMessenger = this.messenger;
        String str = this.name;
        ByteBuffer encodeMessage = this.codec.encodeMessage(message);
        IncomingReplyHandler incomingReplyHandler = null;
        if (callback != null) {
            incomingReplyHandler = new IncomingReplyHandler(callback);
        }
        binaryMessenger.send(str, encodeMessage, incomingReplyHandler);
    }

    public void setMessageHandler(MessageHandler<T> handler) {
        BinaryMessenger binaryMessenger = this.messenger;
        String str = this.name;
        IncomingMessageHandler incomingMessageHandler = null;
        if (handler != null) {
            incomingMessageHandler = new IncomingMessageHandler(handler);
        }
        binaryMessenger.setMessageHandler(str, incomingMessageHandler);
    }

    public void resizeChannelBuffer(int newSize) {
        resizeChannelBuffer(this.messenger, this.name, newSize);
    }

    static void resizeChannelBuffer(BinaryMessenger messenger2, String channel, int newSize) {
        messenger2.send(CHANNEL_BUFFERS_CHANNEL, ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", new Object[]{channel, Integer.valueOf(newSize)}).getBytes(Charset.forName(Key.STRING_CHARSET_NAME))));
    }

    private final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        private final Reply<T> callback;

        private IncomingReplyHandler(Reply<T> callback2) {
            this.callback = callback2;
        }

        public void reply(ByteBuffer reply) {
            try {
                this.callback.reply(BasicMessageChannel.this.codec.decodeMessage(reply));
            } catch (RuntimeException e) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message reply", e);
            }
        }
    }

    private final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MessageHandler<T> handler;

        private IncomingMessageHandler(MessageHandler<T> handler2) {
            this.handler = handler2;
        }

        public void onMessage(ByteBuffer message, final BinaryMessenger.BinaryReply callback) {
            try {
                this.handler.onMessage(BasicMessageChannel.this.codec.decodeMessage(message), new Reply<T>() {
                    public void reply(T reply) {
                        callback.reply(BasicMessageChannel.this.codec.encodeMessage(reply));
                    }
                });
            } catch (RuntimeException e) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message", e);
                callback.reply((ByteBuffer) null);
            }
        }
    }
}
