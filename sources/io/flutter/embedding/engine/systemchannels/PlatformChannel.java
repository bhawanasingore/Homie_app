package io.flutter.embedding.engine.systemchannels;

import androidx.core.view.ViewCompat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlatformChannel {
    private static final String TAG = "PlatformChannel";
    public final MethodChannel channel;
    final MethodChannel.MethodCallHandler parsingMethodCallHandler = new MethodChannel.MethodCallHandler() {
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMethodCall(io.flutter.plugin.common.MethodCall r11, io.flutter.plugin.common.MethodChannel.Result r12) {
            /*
                r10 = this;
                java.lang.String r0 = "error"
                io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler
                if (r1 != 0) goto L_0x000b
                return
            L_0x000b:
                java.lang.String r1 = r11.method
                java.lang.Object r2 = r11.arguments
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Received '"
                r3.append(r4)
                r3.append(r1)
                java.lang.String r4 = "' message."
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                java.lang.String r4 = "PlatformChannel"
                io.flutter.Log.v(r4, r3)
                r3 = -1
                r4 = 0
                int r5 = r1.hashCode()     // Catch:{ JSONException -> 0x01f9 }
                switch(r5) {
                    case -766342101: goto L_0x009d;
                    case -720677196: goto L_0x0092;
                    case -548468504: goto L_0x0088;
                    case -247230243: goto L_0x007e;
                    case -215273374: goto L_0x0074;
                    case 241845679: goto L_0x006a;
                    case 875995648: goto L_0x005f;
                    case 1390477857: goto L_0x0055;
                    case 1514180520: goto L_0x004a;
                    case 1674312266: goto L_0x0040;
                    case 2119655719: goto L_0x0035;
                    default: goto L_0x0033;
                }     // Catch:{ JSONException -> 0x01f9 }
            L_0x0033:
                goto L_0x00a6
            L_0x0035:
                java.lang.String r5 = "SystemChrome.setPreferredOrientations"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 2
                goto L_0x00a6
            L_0x0040:
                java.lang.String r5 = "SystemChrome.setEnabledSystemUIOverlays"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 4
                goto L_0x00a6
            L_0x004a:
                java.lang.String r5 = "Clipboard.getData"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 8
                goto L_0x00a6
            L_0x0055:
                java.lang.String r5 = "SystemChrome.setSystemUIOverlayStyle"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 6
                goto L_0x00a6
            L_0x005f:
                java.lang.String r5 = "Clipboard.hasStrings"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 10
                goto L_0x00a6
            L_0x006a:
                java.lang.String r5 = "SystemChrome.restoreSystemUIOverlays"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 5
                goto L_0x00a6
            L_0x0074:
                java.lang.String r5 = "SystemSound.play"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 0
                goto L_0x00a6
            L_0x007e:
                java.lang.String r5 = "HapticFeedback.vibrate"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 1
                goto L_0x00a6
            L_0x0088:
                java.lang.String r5 = "SystemChrome.setApplicationSwitcherDescription"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 3
                goto L_0x00a6
            L_0x0092:
                java.lang.String r5 = "Clipboard.setData"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 9
                goto L_0x00a6
            L_0x009d:
                java.lang.String r5 = "SystemNavigator.pop"
                boolean r5 = r1.equals(r5)     // Catch:{ JSONException -> 0x01f9 }
                if (r5 == 0) goto L_0x0033
                r3 = 7
            L_0x00a6:
                java.lang.String r5 = "text"
                switch(r3) {
                    case 0: goto L_0x01dc;
                    case 1: goto L_0x01bf;
                    case 2: goto L_0x019e;
                    case 3: goto L_0x017f;
                    case 4: goto L_0x015c;
                    case 5: goto L_0x014e;
                    case 6: goto L_0x012b;
                    case 7: goto L_0x011d;
                    case 8: goto L_0x00de;
                    case 9: goto L_0x00c9;
                    case 10: goto L_0x00b0;
                    default: goto L_0x00ab;
                }
            L_0x00ab:
                r12.notImplemented()     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x00b0:
                io.flutter.embedding.engine.systemchannels.PlatformChannel r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01f9 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r3 = r3.platformMessageHandler     // Catch:{ JSONException -> 0x01f9 }
                boolean r3 = r3.clipboardHasStrings()     // Catch:{ JSONException -> 0x01f9 }
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01f9 }
                r5.<init>()     // Catch:{ JSONException -> 0x01f9 }
                java.lang.String r6 = "value"
                r5.put(r6, r3)     // Catch:{ JSONException -> 0x01f9 }
                r12.success(r5)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x00c9:
                r3 = r2
                org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ JSONException -> 0x01f9 }
                java.lang.String r3 = r3.getString(r5)     // Catch:{ JSONException -> 0x01f9 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01f9 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x01f9 }
                r5.setClipboardData(r3)     // Catch:{ JSONException -> 0x01f9 }
                r12.success(r4)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x00de:
                r3 = r2
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x01f9 }
                r6 = 0
                if (r3 == 0) goto L_0x00ff
                io.flutter.embedding.engine.systemchannels.PlatformChannel$ClipboardContentFormat r7 = io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat.fromValue(r3)     // Catch:{ NoSuchFieldException -> 0x00ea }
                r6 = r7
                goto L_0x00ff
            L_0x00ea:
                r7 = move-exception
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f9 }
                r8.<init>()     // Catch:{ JSONException -> 0x01f9 }
                java.lang.String r9 = "No such clipboard content format: "
                r8.append(r9)     // Catch:{ JSONException -> 0x01f9 }
                r8.append(r3)     // Catch:{ JSONException -> 0x01f9 }
                java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x01f9 }
                r12.error(r0, r8, r4)     // Catch:{ JSONException -> 0x01f9 }
            L_0x00ff:
                io.flutter.embedding.engine.systemchannels.PlatformChannel r7 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01f9 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r7 = r7.platformMessageHandler     // Catch:{ JSONException -> 0x01f9 }
                java.lang.CharSequence r7 = r7.getClipboardData(r6)     // Catch:{ JSONException -> 0x01f9 }
                if (r7 == 0) goto L_0x0118
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01f9 }
                r8.<init>()     // Catch:{ JSONException -> 0x01f9 }
                r8.put(r5, r7)     // Catch:{ JSONException -> 0x01f9 }
                r12.success(r8)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x0118:
                r12.success(r4)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x011d:
                io.flutter.embedding.engine.systemchannels.PlatformChannel r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01f9 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r3 = r3.platformMessageHandler     // Catch:{ JSONException -> 0x01f9 }
                r3.popSystemNavigator()     // Catch:{ JSONException -> 0x01f9 }
                r12.success(r4)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x012b:
                io.flutter.embedding.engine.systemchannels.PlatformChannel r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0144, NoSuchFieldException -> 0x0142 }
                r5 = r2
                org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ JSONException -> 0x0144, NoSuchFieldException -> 0x0142 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemChromeStyle r3 = r3.decodeSystemChromeStyle(r5)     // Catch:{ JSONException -> 0x0144, NoSuchFieldException -> 0x0142 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0144, NoSuchFieldException -> 0x0142 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x0144, NoSuchFieldException -> 0x0142 }
                r5.setSystemUiOverlayStyle(r3)     // Catch:{ JSONException -> 0x0144, NoSuchFieldException -> 0x0142 }
                r12.success(r4)     // Catch:{ JSONException -> 0x0144, NoSuchFieldException -> 0x0142 }
                goto L_0x01f8
            L_0x0142:
                r3 = move-exception
                goto L_0x0145
            L_0x0144:
                r3 = move-exception
            L_0x0145:
                java.lang.String r5 = r3.getMessage()     // Catch:{ JSONException -> 0x01f9 }
                r12.error(r0, r5, r4)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x014e:
                io.flutter.embedding.engine.systemchannels.PlatformChannel r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01f9 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r3 = r3.platformMessageHandler     // Catch:{ JSONException -> 0x01f9 }
                r3.restoreSystemUiOverlays()     // Catch:{ JSONException -> 0x01f9 }
                r12.success(r4)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x015c:
                io.flutter.embedding.engine.systemchannels.PlatformChannel r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0175, NoSuchFieldException -> 0x0173 }
                r5 = r2
                org.json.JSONArray r5 = (org.json.JSONArray) r5     // Catch:{ JSONException -> 0x0175, NoSuchFieldException -> 0x0173 }
                java.util.List r3 = r3.decodeSystemUiOverlays(r5)     // Catch:{ JSONException -> 0x0175, NoSuchFieldException -> 0x0173 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0175, NoSuchFieldException -> 0x0173 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x0175, NoSuchFieldException -> 0x0173 }
                r5.showSystemOverlays(r3)     // Catch:{ JSONException -> 0x0175, NoSuchFieldException -> 0x0173 }
                r12.success(r4)     // Catch:{ JSONException -> 0x0175, NoSuchFieldException -> 0x0173 }
                goto L_0x01f8
            L_0x0173:
                r3 = move-exception
                goto L_0x0176
            L_0x0175:
                r3 = move-exception
            L_0x0176:
                java.lang.String r5 = r3.getMessage()     // Catch:{ JSONException -> 0x01f9 }
                r12.error(r0, r5, r4)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x017f:
                io.flutter.embedding.engine.systemchannels.PlatformChannel r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0195 }
                r5 = r2
                org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ JSONException -> 0x0195 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$AppSwitcherDescription r3 = r3.decodeAppSwitcherDescription(r5)     // Catch:{ JSONException -> 0x0195 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0195 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x0195 }
                r5.setApplicationSwitcherDescription(r3)     // Catch:{ JSONException -> 0x0195 }
                r12.success(r4)     // Catch:{ JSONException -> 0x0195 }
                goto L_0x01f8
            L_0x0195:
                r3 = move-exception
                java.lang.String r5 = r3.getMessage()     // Catch:{ JSONException -> 0x01f9 }
                r12.error(r0, r5, r4)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x019e:
                io.flutter.embedding.engine.systemchannels.PlatformChannel r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01b6, NoSuchFieldException -> 0x01b4 }
                r5 = r2
                org.json.JSONArray r5 = (org.json.JSONArray) r5     // Catch:{ JSONException -> 0x01b6, NoSuchFieldException -> 0x01b4 }
                int r3 = r3.decodeOrientations(r5)     // Catch:{ JSONException -> 0x01b6, NoSuchFieldException -> 0x01b4 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x01b6, NoSuchFieldException -> 0x01b4 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x01b6, NoSuchFieldException -> 0x01b4 }
                r5.setPreferredOrientations(r3)     // Catch:{ JSONException -> 0x01b6, NoSuchFieldException -> 0x01b4 }
                r12.success(r4)     // Catch:{ JSONException -> 0x01b6, NoSuchFieldException -> 0x01b4 }
                goto L_0x01f8
            L_0x01b4:
                r3 = move-exception
                goto L_0x01b7
            L_0x01b6:
                r3 = move-exception
            L_0x01b7:
                java.lang.String r5 = r3.getMessage()     // Catch:{ JSONException -> 0x01f9 }
                r12.error(r0, r5, r4)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x01bf:
                r3 = r2
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ NoSuchFieldException -> 0x01d3 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.fromValue(r3)     // Catch:{ NoSuchFieldException -> 0x01d3 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException -> 0x01d3 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ NoSuchFieldException -> 0x01d3 }
                r5.vibrateHapticFeedback(r3)     // Catch:{ NoSuchFieldException -> 0x01d3 }
                r12.success(r4)     // Catch:{ NoSuchFieldException -> 0x01d3 }
                goto L_0x01f8
            L_0x01d3:
                r3 = move-exception
                java.lang.String r5 = r3.getMessage()     // Catch:{ JSONException -> 0x01f9 }
                r12.error(r0, r5, r4)     // Catch:{ JSONException -> 0x01f9 }
                goto L_0x01f8
            L_0x01dc:
                r3 = r2
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ NoSuchFieldException -> 0x01f0 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SoundType r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType.fromValue(r3)     // Catch:{ NoSuchFieldException -> 0x01f0 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException -> 0x01f0 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ NoSuchFieldException -> 0x01f0 }
                r5.playSystemSound(r3)     // Catch:{ NoSuchFieldException -> 0x01f0 }
                r12.success(r4)     // Catch:{ NoSuchFieldException -> 0x01f0 }
                goto L_0x01f8
            L_0x01f0:
                r3 = move-exception
                java.lang.String r5 = r3.getMessage()     // Catch:{ JSONException -> 0x01f9 }
                r12.error(r0, r5, r4)     // Catch:{ JSONException -> 0x01f9 }
            L_0x01f8:
                goto L_0x0212
            L_0x01f9:
                r3 = move-exception
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "JSON error: "
                r5.append(r6)
                java.lang.String r6 = r3.getMessage()
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                r12.error(r0, r5, r4)
            L_0x0212:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.PlatformChannel.AnonymousClass1.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
        }
    };
    /* access modifiers changed from: private */
    public PlatformMessageHandler platformMessageHandler;

    public interface PlatformMessageHandler {
        boolean clipboardHasStrings();

        CharSequence getClipboardData(ClipboardContentFormat clipboardContentFormat);

        void playSystemSound(SoundType soundType);

        void popSystemNavigator();

        void restoreSystemUiOverlays();

        void setApplicationSwitcherDescription(AppSwitcherDescription appSwitcherDescription);

        void setClipboardData(String str);

        void setPreferredOrientations(int i);

        void setSystemUiOverlayStyle(SystemChromeStyle systemChromeStyle);

        void showSystemOverlays(List<SystemUiOverlay> list);

        void vibrateHapticFeedback(HapticFeedbackType hapticFeedbackType);
    }

    public PlatformChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodCallHandler);
    }

    public void setPlatformMessageHandler(PlatformMessageHandler platformMessageHandler2) {
        this.platformMessageHandler = platformMessageHandler2;
    }

    /* access modifiers changed from: private */
    public int decodeOrientations(JSONArray encodedOrientations) throws JSONException, NoSuchFieldException {
        int requestedOrientation = 0;
        int firstRequestedOrientation = 0;
        for (int index = 0; index < encodedOrientations.length(); index++) {
            int i = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.fromValue(encodedOrientations.getString(index)).ordinal()];
            if (i == 1) {
                requestedOrientation |= 1;
            } else if (i == 2) {
                requestedOrientation |= 4;
            } else if (i == 3) {
                requestedOrientation |= 2;
            } else if (i == 4) {
                requestedOrientation |= 8;
            }
            if (firstRequestedOrientation == 0) {
                firstRequestedOrientation = requestedOrientation;
            }
        }
        if (requestedOrientation == 0) {
            return -1;
        }
        switch (requestedOrientation) {
            case 2:
                return 0;
            case 3:
            case 6:
            case 7:
            case 9:
            case 12:
            case 13:
            case 14:
                if (firstRequestedOrientation == 2) {
                    return 0;
                }
                if (firstRequestedOrientation == 4) {
                    return 9;
                }
                if (firstRequestedOrientation != 8) {
                    return 1;
                }
                return 8;
            case 4:
                return 9;
            case 5:
                return 12;
            case 8:
                return 8;
            case 10:
                return 11;
            case 11:
                return 2;
            case 15:
                return 13;
        }
        return 1;
    }

    /* access modifiers changed from: private */
    public AppSwitcherDescription decodeAppSwitcherDescription(JSONObject encodedDescription) throws JSONException {
        int color = encodedDescription.getInt("primaryColor");
        if (color != 0) {
            color |= ViewCompat.MEASURED_STATE_MASK;
        }
        return new AppSwitcherDescription(color, encodedDescription.getString("label"));
    }

    /* access modifiers changed from: private */
    public List<SystemUiOverlay> decodeSystemUiOverlays(JSONArray encodedSystemUiOverlay) throws JSONException, NoSuchFieldException {
        List<SystemUiOverlay> overlays = new ArrayList<>();
        for (int i = 0; i < encodedSystemUiOverlay.length(); i++) {
            int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.fromValue(encodedSystemUiOverlay.getString(i)).ordinal()];
            if (i2 == 1) {
                overlays.add(SystemUiOverlay.TOP_OVERLAYS);
            } else if (i2 == 2) {
                overlays.add(SystemUiOverlay.BOTTOM_OVERLAYS);
            }
        }
        return overlays;
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformChannel$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;

        static {
            int[] iArr = new int[SystemUiOverlay.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = iArr;
            try {
                iArr[SystemUiOverlay.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr2;
            try {
                iArr2[DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* access modifiers changed from: private */
    public SystemChromeStyle decodeSystemChromeStyle(JSONObject encodedStyle) throws JSONException, NoSuchFieldException {
        Brightness systemNavigationBarIconBrightness = null;
        Integer systemNavigationBarColor = null;
        Integer systemNavigationBarDividerColor = null;
        Brightness statusBarIconBrightness = null;
        Integer statusBarColor = null;
        if (!encodedStyle.isNull("systemNavigationBarIconBrightness")) {
            systemNavigationBarIconBrightness = Brightness.fromValue(encodedStyle.getString("systemNavigationBarIconBrightness"));
        }
        if (!encodedStyle.isNull("systemNavigationBarColor")) {
            systemNavigationBarColor = Integer.valueOf(encodedStyle.getInt("systemNavigationBarColor"));
        }
        if (!encodedStyle.isNull("statusBarIconBrightness")) {
            statusBarIconBrightness = Brightness.fromValue(encodedStyle.getString("statusBarIconBrightness"));
        }
        if (!encodedStyle.isNull("statusBarColor")) {
            statusBarColor = Integer.valueOf(encodedStyle.getInt("statusBarColor"));
        }
        if (!encodedStyle.isNull("systemNavigationBarDividerColor")) {
            systemNavigationBarDividerColor = Integer.valueOf(encodedStyle.getInt("systemNavigationBarDividerColor"));
        }
        return new SystemChromeStyle(statusBarColor, statusBarIconBrightness, systemNavigationBarColor, systemNavigationBarIconBrightness, systemNavigationBarDividerColor);
    }

    public enum SoundType {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");
        
        private final String encodedName;

        static SoundType fromValue(String encodedName2) throws NoSuchFieldException {
            for (SoundType soundType : values()) {
                if (soundType.encodedName.equals(encodedName2)) {
                    return soundType;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + encodedName2);
        }

        private SoundType(String encodedName2) {
            this.encodedName = encodedName2;
        }
    }

    public enum HapticFeedbackType {
        STANDARD((String) null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");
        
        private final String encodedName;

        static HapticFeedbackType fromValue(String encodedName2) throws NoSuchFieldException {
            String str;
            for (HapticFeedbackType feedbackType : values()) {
                if ((feedbackType.encodedName == null && encodedName2 == null) || ((str = feedbackType.encodedName) != null && str.equals(encodedName2))) {
                    return feedbackType;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + encodedName2);
        }

        private HapticFeedbackType(String encodedName2) {
            this.encodedName = encodedName2;
        }
    }

    public enum DeviceOrientation {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        
        private String encodedName;

        static DeviceOrientation fromValue(String encodedName2) throws NoSuchFieldException {
            for (DeviceOrientation orientation : values()) {
                if (orientation.encodedName.equals(encodedName2)) {
                    return orientation;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + encodedName2);
        }

        private DeviceOrientation(String encodedName2) {
            this.encodedName = encodedName2;
        }
    }

    public enum SystemUiOverlay {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        
        private String encodedName;

        static SystemUiOverlay fromValue(String encodedName2) throws NoSuchFieldException {
            for (SystemUiOverlay overlay : values()) {
                if (overlay.encodedName.equals(encodedName2)) {
                    return overlay;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + encodedName2);
        }

        private SystemUiOverlay(String encodedName2) {
            this.encodedName = encodedName2;
        }
    }

    public static class AppSwitcherDescription {
        public final int color;
        public final String label;

        public AppSwitcherDescription(int color2, String label2) {
            this.color = color2;
            this.label = label2;
        }
    }

    public static class SystemChromeStyle {
        public final Integer statusBarColor;
        public final Brightness statusBarIconBrightness;
        public final Integer systemNavigationBarColor;
        public final Integer systemNavigationBarDividerColor;
        public final Brightness systemNavigationBarIconBrightness;

        public SystemChromeStyle(Integer statusBarColor2, Brightness statusBarIconBrightness2, Integer systemNavigationBarColor2, Brightness systemNavigationBarIconBrightness2, Integer systemNavigationBarDividerColor2) {
            this.statusBarColor = statusBarColor2;
            this.statusBarIconBrightness = statusBarIconBrightness2;
            this.systemNavigationBarColor = systemNavigationBarColor2;
            this.systemNavigationBarIconBrightness = systemNavigationBarIconBrightness2;
            this.systemNavigationBarDividerColor = systemNavigationBarDividerColor2;
        }
    }

    public enum Brightness {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        
        private String encodedName;

        static Brightness fromValue(String encodedName2) throws NoSuchFieldException {
            for (Brightness brightness : values()) {
                if (brightness.encodedName.equals(encodedName2)) {
                    return brightness;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + encodedName2);
        }

        private Brightness(String encodedName2) {
            this.encodedName = encodedName2;
        }
    }

    public enum ClipboardContentFormat {
        PLAIN_TEXT("text/plain");
        
        private String encodedName;

        static ClipboardContentFormat fromValue(String encodedName2) throws NoSuchFieldException {
            for (ClipboardContentFormat format : values()) {
                if (format.encodedName.equals(encodedName2)) {
                    return format;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + encodedName2);
        }

        private ClipboardContentFormat(String encodedName2) {
            this.encodedName = encodedName2;
        }
    }
}
