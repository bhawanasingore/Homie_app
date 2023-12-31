package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.AccessibilityBridge;
import java.util.HashMap;

public class AccessibilityChannel {
    private static final String TAG = "AccessibilityChannel";
    public final BasicMessageChannel<Object> channel;
    public final FlutterJNI flutterJNI;
    /* access modifiers changed from: private */
    public AccessibilityMessageHandler handler;
    private final BasicMessageChannel.MessageHandler<Object> parsingMessageHandler = new BasicMessageChannel.MessageHandler<Object>() {
        public void onMessage(Object message, BasicMessageChannel.Reply<Object> reply) {
            String tooltipMessage;
            if (AccessibilityChannel.this.handler != null) {
                HashMap<String, Object> annotatedEvent = (HashMap) message;
                String type = (String) annotatedEvent.get("type");
                HashMap<String, Object> data = (HashMap) annotatedEvent.get("data");
                Log.v(AccessibilityChannel.TAG, "Received " + type + " message.");
                char c = 65535;
                switch (type.hashCode()) {
                    case -1140076541:
                        if (type.equals("tooltip")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -649620375:
                        if (type.equals("announce")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 114595:
                        if (type.equals("tap")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 114203431:
                        if (type.equals("longPress")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    String announceMessage = (String) data.get("message");
                    if (announceMessage != null) {
                        AccessibilityChannel.this.handler.announce(announceMessage);
                    }
                } else if (c == 1) {
                    Integer nodeId = (Integer) annotatedEvent.get("nodeId");
                    if (nodeId != null) {
                        AccessibilityChannel.this.handler.onTap(nodeId.intValue());
                    }
                } else if (c == 2) {
                    Integer nodeId2 = (Integer) annotatedEvent.get("nodeId");
                    if (nodeId2 != null) {
                        AccessibilityChannel.this.handler.onLongPress(nodeId2.intValue());
                    }
                } else if (c == 3 && (tooltipMessage = (String) data.get("message")) != null) {
                    AccessibilityChannel.this.handler.onTooltip(tooltipMessage);
                }
                reply.reply(null);
            }
        }
    };

    public interface AccessibilityMessageHandler extends FlutterJNI.AccessibilityDelegate {
        void announce(String str);

        void onLongPress(int i);

        void onTap(int i);

        void onTooltip(String str);
    }

    public AccessibilityChannel(DartExecutor dartExecutor, FlutterJNI flutterJNI2) {
        BasicMessageChannel<Object> basicMessageChannel = new BasicMessageChannel<>(dartExecutor, "flutter/accessibility", StandardMessageCodec.INSTANCE);
        this.channel = basicMessageChannel;
        basicMessageChannel.setMessageHandler(this.parsingMessageHandler);
        this.flutterJNI = flutterJNI2;
    }

    public void onAndroidAccessibilityEnabled() {
        this.flutterJNI.setSemanticsEnabled(true);
    }

    public void onAndroidAccessibilityDisabled() {
        this.flutterJNI.setSemanticsEnabled(false);
    }

    public void setAccessibilityFeatures(int accessibilityFeatureFlags) {
        this.flutterJNI.setAccessibilityFeatures(accessibilityFeatureFlags);
    }

    public void dispatchSemanticsAction(int virtualViewId, AccessibilityBridge.Action action) {
        this.flutterJNI.dispatchSemanticsAction(virtualViewId, action);
    }

    public void dispatchSemanticsAction(int virtualViewId, AccessibilityBridge.Action action, Object args) {
        this.flutterJNI.dispatchSemanticsAction(virtualViewId, action, args);
    }

    public void setAccessibilityMessageHandler(AccessibilityMessageHandler handler2) {
        this.handler = handler2;
        this.flutterJNI.setAccessibilityDelegate(handler2);
    }
}
