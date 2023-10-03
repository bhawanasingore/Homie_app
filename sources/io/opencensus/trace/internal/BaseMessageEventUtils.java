package io.opencensus.trace.internal;

import androidx.core.app.NotificationCompat;
import io.opencensus.internal.Utils;
import io.opencensus.trace.BaseMessageEvent;
import io.opencensus.trace.MessageEvent;
import io.opencensus.trace.NetworkEvent;

public final class BaseMessageEventUtils {
    public static MessageEvent asMessageEvent(BaseMessageEvent event) {
        MessageEvent.Type type;
        Utils.checkNotNull(event, NotificationCompat.CATEGORY_EVENT);
        if (event instanceof MessageEvent) {
            return (MessageEvent) event;
        }
        NetworkEvent networkEvent = (NetworkEvent) event;
        if (networkEvent.getType() == NetworkEvent.Type.RECV) {
            type = MessageEvent.Type.RECEIVED;
        } else {
            type = MessageEvent.Type.SENT;
        }
        return MessageEvent.builder(type, networkEvent.getMessageId()).setUncompressedMessageSize(networkEvent.getUncompressedMessageSize()).setCompressedMessageSize(networkEvent.getCompressedMessageSize()).build();
    }

    public static NetworkEvent asNetworkEvent(BaseMessageEvent event) {
        NetworkEvent.Type type;
        Utils.checkNotNull(event, NotificationCompat.CATEGORY_EVENT);
        if (event instanceof NetworkEvent) {
            return (NetworkEvent) event;
        }
        MessageEvent messageEvent = (MessageEvent) event;
        if (messageEvent.getType() == MessageEvent.Type.RECEIVED) {
            type = NetworkEvent.Type.RECV;
        } else {
            type = NetworkEvent.Type.SENT;
        }
        return NetworkEvent.builder(type, messageEvent.getMessageId()).setUncompressedMessageSize(messageEvent.getUncompressedMessageSize()).setCompressedMessageSize(messageEvent.getCompressedMessageSize()).build();
    }

    private BaseMessageEventUtils() {
    }
}
