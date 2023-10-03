package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class RestorationChannel {
    private static final String TAG = "RestorationChannel";
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public boolean engineHasProvidedData;
    /* access modifiers changed from: private */
    public boolean frameworkHasRequestedData;
    private final MethodChannel.MethodCallHandler handler;
    /* access modifiers changed from: private */
    public MethodChannel.Result pendingFrameworkRestorationChannelRequest;
    /* access modifiers changed from: private */
    public byte[] restorationData;
    public final boolean waitForRestorationData;

    public RestorationChannel(DartExecutor dartExecutor, boolean waitForRestorationData2) {
        this(new MethodChannel(dartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), waitForRestorationData2);
    }

    RestorationChannel(MethodChannel channel2, boolean waitForRestorationData2) {
        this.engineHasProvidedData = false;
        this.frameworkHasRequestedData = false;
        AnonymousClass2 r0 = new MethodChannel.MethodCallHandler() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onMethodCall(io.flutter.plugin.common.MethodCall r6, io.flutter.plugin.common.MethodChannel.Result r7) {
                /*
                    r5 = this;
                    java.lang.String r0 = r6.method
                    java.lang.Object r1 = r6.arguments
                    int r2 = r0.hashCode()
                    r3 = 102230(0x18f56, float:1.43255E-40)
                    r4 = 1
                    if (r2 == r3) goto L_0x001e
                    r3 = 111375(0x1b30f, float:1.5607E-40)
                    if (r2 == r3) goto L_0x0014
                L_0x0013:
                    goto L_0x0028
                L_0x0014:
                    java.lang.String r2 = "put"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x0013
                    r2 = 0
                    goto L_0x0029
                L_0x001e:
                    java.lang.String r2 = "get"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x0013
                    r2 = r4
                    goto L_0x0029
                L_0x0028:
                    r2 = -1
                L_0x0029:
                    if (r2 == 0) goto L_0x0059
                    if (r2 == r4) goto L_0x0031
                    r7.notImplemented()
                    goto L_0x0068
                L_0x0031:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r2 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean unused = r2.frameworkHasRequestedData = r4
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r2 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean r2 = r2.engineHasProvidedData
                    if (r2 != 0) goto L_0x004b
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r2 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean r2 = r2.waitForRestorationData
                    if (r2 != 0) goto L_0x0045
                    goto L_0x004b
                L_0x0045:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r2 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    io.flutter.plugin.common.MethodChannel.Result unused = r2.pendingFrameworkRestorationChannelRequest = r7
                    goto L_0x0068
                L_0x004b:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r2 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    byte[] r3 = r2.restorationData
                    java.util.Map r2 = r2.packageData(r3)
                    r7.success(r2)
                    goto L_0x0068
                L_0x0059:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r2 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    r3 = r1
                    byte[] r3 = (byte[]) r3
                    byte[] r3 = (byte[]) r3
                    byte[] unused = r2.restorationData = r3
                    r2 = 0
                    r7.success(r2)
                L_0x0068:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.RestorationChannel.AnonymousClass2.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
            }
        };
        this.handler = r0;
        this.channel = channel2;
        this.waitForRestorationData = waitForRestorationData2;
        channel2.setMethodCallHandler(r0);
    }

    public byte[] getRestorationData() {
        return this.restorationData;
    }

    public void setRestorationData(final byte[] data) {
        this.engineHasProvidedData = true;
        MethodChannel.Result result = this.pendingFrameworkRestorationChannelRequest;
        if (result != null) {
            result.success(packageData(data));
            this.pendingFrameworkRestorationChannelRequest = null;
            this.restorationData = data;
        } else if (this.frameworkHasRequestedData) {
            this.channel.invokeMethod("push", packageData(data), new MethodChannel.Result() {
                public void success(Object result) {
                    byte[] unused = RestorationChannel.this.restorationData = data;
                }

                public void error(String errorCode, String errorMessage, Object errorDetails) {
                    Log.e(RestorationChannel.TAG, "Error " + errorCode + " while sending restoration data to framework: " + errorMessage);
                }

                public void notImplemented() {
                }
            });
        } else {
            this.restorationData = data;
        }
    }

    public void clearData() {
        this.restorationData = null;
    }

    /* access modifiers changed from: private */
    public Map<String, Object> packageData(byte[] data) {
        Map<String, Object> packaged = new HashMap<>();
        packaged.put("enabled", true);
        packaged.put("data", data);
        return packaged;
    }
}
