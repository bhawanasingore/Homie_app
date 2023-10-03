package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class PlatformViewsChannel {
    private static final String TAG = "PlatformViewsChannel";
    private final MethodChannel channel;
    /* access modifiers changed from: private */
    public PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall call, MethodChannel.Result result) {
            if (PlatformViewsChannel.this.handler != null) {
                Log.v(PlatformViewsChannel.TAG, "Received '" + call.method + "' message.");
                String str = call.method;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1352294148:
                        if (str.equals("create")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -934437708:
                        if (str.equals("resize")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -756050293:
                        if (str.equals("clearFocus")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 110550847:
                        if (str.equals("touch")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 576796989:
                        if (str.equals("setDirection")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1671767583:
                        if (str.equals("dispose")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    create(call, result);
                } else if (c == 1) {
                    dispose(call, result);
                } else if (c == 2) {
                    resize(call, result);
                } else if (c == 3) {
                    touch(call, result);
                } else if (c == 4) {
                    setDirection(call, result);
                } else if (c != 5) {
                    result.notImplemented();
                } else {
                    clearFocus(call, result);
                }
            }
        }

        private void create(MethodCall call, MethodChannel.Result result) {
            MethodChannel.Result result2 = result;
            Map<String, Object> createArgs = (Map) call.arguments();
            boolean usesHybridComposition = createArgs.containsKey("hybrid") && ((Boolean) createArgs.get("hybrid")).booleanValue();
            double height = 0.0d;
            double width = usesHybridComposition ? 0.0d : ((Double) createArgs.get("width")).doubleValue();
            if (!usesHybridComposition) {
                height = ((Double) createArgs.get("height")).doubleValue();
            }
            PlatformViewCreationRequest request = new PlatformViewCreationRequest(((Integer) createArgs.get("id")).intValue(), (String) createArgs.get("viewType"), width, height, ((Integer) createArgs.get("direction")).intValue(), createArgs.containsKey("params") ? ByteBuffer.wrap((byte[]) createArgs.get("params")) : null);
            if (usesHybridComposition) {
                try {
                    PlatformViewsChannel.this.handler.createAndroidViewForPlatformView(request);
                    result2.success((Object) null);
                } catch (IllegalStateException exception) {
                    result2.error("error", PlatformViewsChannel.detailedExceptionString(exception), (Object) null);
                }
            } else {
                result2.success(Long.valueOf(PlatformViewsChannel.this.handler.createVirtualDisplayForPlatformView(request)));
            }
        }

        private void dispose(MethodCall call, MethodChannel.Result result) {
            Map<String, Object> disposeArgs = (Map) call.arguments();
            int viewId = ((Integer) disposeArgs.get("id")).intValue();
            if (disposeArgs.containsKey("hybrid") && ((Boolean) disposeArgs.get("hybrid")).booleanValue()) {
                try {
                    PlatformViewsChannel.this.handler.disposeAndroidViewForPlatformView(viewId);
                } catch (IllegalStateException exception) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(exception), (Object) null);
                    return;
                }
            } else {
                PlatformViewsChannel.this.handler.disposeVirtualDisplayForPlatformView(viewId);
            }
            result.success((Object) null);
        }

        private void resize(MethodCall call, final MethodChannel.Result result) {
            Map<String, Object> resizeArgs = (Map) call.arguments();
            try {
                PlatformViewsChannel.this.handler.resizePlatformView(new PlatformViewResizeRequest(((Integer) resizeArgs.get("id")).intValue(), ((Double) resizeArgs.get("width")).doubleValue(), ((Double) resizeArgs.get("height")).doubleValue()), new Runnable() {
                    public void run() {
                        result.success((Object) null);
                    }
                });
            } catch (IllegalStateException exception) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(exception), (Object) null);
            }
        }

        private void touch(MethodCall call, MethodChannel.Result result) {
            MethodChannel.Result result2;
            MethodChannel.Result result3 = result;
            List<Object> args = (List) call.arguments();
            try {
                PlatformViewsChannel.this.handler.onTouch(new PlatformViewTouch(((Integer) args.get(0)).intValue(), (Number) args.get(1), (Number) args.get(2), ((Integer) args.get(3)).intValue(), ((Integer) args.get(4)).intValue(), args.get(5), args.get(6), ((Integer) args.get(7)).intValue(), ((Integer) args.get(8)).intValue(), (float) ((Double) args.get(9)).doubleValue(), (float) ((Double) args.get(10)).doubleValue(), ((Integer) args.get(11)).intValue(), ((Integer) args.get(12)).intValue(), ((Integer) args.get(13)).intValue(), ((Integer) args.get(14)).intValue(), ((Number) args.get(15)).longValue()));
                result2 = result;
                try {
                    result2.success((Object) null);
                } catch (IllegalStateException e) {
                    exception = e;
                }
            } catch (IllegalStateException e2) {
                exception = e2;
                result2 = result;
                result2.error("error", PlatformViewsChannel.detailedExceptionString(exception), (Object) null);
            }
        }

        private void setDirection(MethodCall call, MethodChannel.Result result) {
            Map<String, Object> setDirectionArgs = (Map) call.arguments();
            try {
                PlatformViewsChannel.this.handler.setDirection(((Integer) setDirectionArgs.get("id")).intValue(), ((Integer) setDirectionArgs.get("direction")).intValue());
                result.success((Object) null);
            } catch (IllegalStateException exception) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(exception), (Object) null);
            }
        }

        private void clearFocus(MethodCall call, MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.clearFocus(((Integer) call.arguments()).intValue());
                result.success((Object) null);
            } catch (IllegalStateException exception) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(exception), (Object) null);
            }
        }
    };

    public interface PlatformViewsHandler {
        void clearFocus(int i);

        void createAndroidViewForPlatformView(PlatformViewCreationRequest platformViewCreationRequest);

        long createVirtualDisplayForPlatformView(PlatformViewCreationRequest platformViewCreationRequest);

        void disposeAndroidViewForPlatformView(int i);

        void disposeVirtualDisplayForPlatformView(int i);

        void onTouch(PlatformViewTouch platformViewTouch);

        void resizePlatformView(PlatformViewResizeRequest platformViewResizeRequest, Runnable runnable);

        void setDirection(int i, int i2);
    }

    public void invokeViewFocused(int viewId) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("viewFocused", Integer.valueOf(viewId));
        }
    }

    /* access modifiers changed from: private */
    public static String detailedExceptionString(Exception exception) {
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public PlatformViewsChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingHandler);
    }

    public void setPlatformViewsHandler(PlatformViewsHandler handler2) {
        this.handler = handler2;
    }

    public static class PlatformViewCreationRequest {
        public final int direction;
        public final double logicalHeight;
        public final double logicalWidth;
        public final ByteBuffer params;
        public final int viewId;
        public final String viewType;

        public PlatformViewCreationRequest(int viewId2, String viewType2, double logicalWidth2, double logicalHeight2, int direction2, ByteBuffer params2) {
            this.viewId = viewId2;
            this.viewType = viewType2;
            this.logicalWidth = logicalWidth2;
            this.logicalHeight = logicalHeight2;
            this.direction = direction2;
            this.params = params2;
        }
    }

    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int viewId2, double newLogicalWidth2, double newLogicalHeight2) {
            this.viewId = viewId2;
            this.newLogicalWidth = newLogicalWidth2;
            this.newLogicalHeight = newLogicalHeight2;
        }
    }

    public static class PlatformViewTouch {
        public final int action;
        public final int buttonState;
        public final int deviceId;
        public final Number downTime;
        public final int edgeFlags;
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final long motionEventId;
        public final int pointerCount;
        public final Object rawPointerCoords;
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        public PlatformViewTouch(int viewId2, Number downTime2, Number eventTime2, int action2, int pointerCount2, Object rawPointerPropertiesList2, Object rawPointerCoords2, int metaState2, int buttonState2, float xPrecision2, float yPrecision2, int deviceId2, int edgeFlags2, int source2, int flags2, long motionEventId2) {
            this.viewId = viewId2;
            this.downTime = downTime2;
            this.eventTime = eventTime2;
            this.action = action2;
            this.pointerCount = pointerCount2;
            this.rawPointerPropertiesList = rawPointerPropertiesList2;
            this.rawPointerCoords = rawPointerCoords2;
            this.metaState = metaState2;
            this.buttonState = buttonState2;
            this.xPrecision = xPrecision2;
            this.yPrecision = yPrecision2;
            this.deviceId = deviceId2;
            this.edgeFlags = edgeFlags2;
            this.source = source2;
            this.flags = flags2;
            this.motionEventId = motionEventId2;
        }
    }
}
