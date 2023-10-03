package io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextInputChannel {
    private static final String TAG = "TextInputChannel";
    public final MethodChannel channel;
    private final MethodChannel.MethodCallHandler parsingMethodHandler = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall call, MethodChannel.Result result) {
            MethodCall methodCall = call;
            MethodChannel.Result result2 = result;
            if (TextInputChannel.this.textInputMethodHandler != null) {
                String method = methodCall.method;
                Object args = methodCall.arguments;
                Log.v(TextInputChannel.TAG, "Received '" + method + "' message.");
                char c = 65535;
                switch (method.hashCode()) {
                    case -1779068172:
                        if (method.equals("TextInput.setPlatformViewClient")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1015421462:
                        if (method.equals("TextInput.setEditingState")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -37561188:
                        if (method.equals("TextInput.setClient")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 270476819:
                        if (method.equals("TextInput.hide")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 270803918:
                        if (method.equals("TextInput.show")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 649192816:
                        if (method.equals("TextInput.sendAppPrivateCommand")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 1204752139:
                        if (method.equals("TextInput.setEditableSizeAndTransform")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1727570905:
                        if (method.equals("TextInput.finishAutofillContext")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 1904427655:
                        if (method.equals("TextInput.clearClient")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 2113369584:
                        if (method.equals("TextInput.requestAutofill")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        TextInputChannel.this.textInputMethodHandler.show();
                        result2.success((Object) null);
                        return;
                    case 1:
                        TextInputChannel.this.textInputMethodHandler.hide();
                        result2.success((Object) null);
                        return;
                    case 2:
                        try {
                            JSONArray argumentList = (JSONArray) args;
                            TextInputChannel.this.textInputMethodHandler.setClient(argumentList.getInt(0), Configuration.fromJson(argumentList.getJSONObject(1)));
                            result2.success((Object) null);
                            return;
                        } catch (NoSuchFieldException | JSONException exception) {
                            result2.error("error", exception.getMessage(), (Object) null);
                            return;
                        }
                    case 3:
                        TextInputChannel.this.textInputMethodHandler.requestAutofill();
                        result2.success((Object) null);
                        return;
                    case 4:
                        TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(((Integer) args).intValue());
                        return;
                    case 5:
                        try {
                            TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) args));
                            result2.success((Object) null);
                            return;
                        } catch (JSONException exception2) {
                            result2.error("error", exception2.getMessage(), (Object) null);
                            return;
                        }
                    case 6:
                        try {
                            JSONObject arguments = (JSONObject) args;
                            double width = arguments.getDouble("width");
                            double height = arguments.getDouble("height");
                            JSONArray jsonMatrix = arguments.getJSONArray("transform");
                            double[] matrix = new double[16];
                            for (int i = 0; i < 16; i++) {
                                matrix[i] = jsonMatrix.getDouble(i);
                            }
                            TextInputChannel.this.textInputMethodHandler.setEditableSizeAndTransform(width, height, matrix);
                            return;
                        } catch (JSONException exception3) {
                            result2.error("error", exception3.getMessage(), (Object) null);
                            return;
                        }
                    case 7:
                        TextInputChannel.this.textInputMethodHandler.clearClient();
                        result2.success((Object) null);
                        return;
                    case 8:
                        try {
                            JSONObject arguments2 = (JSONObject) args;
                            String action = arguments2.getString("action");
                            String data = arguments2.getString("data");
                            Bundle bundle = null;
                            if (data != null && !data.isEmpty()) {
                                bundle = new Bundle();
                                bundle.putString("data", data);
                            }
                            TextInputChannel.this.textInputMethodHandler.sendAppPrivateCommand(action, bundle);
                            result2.success((Object) null);
                            return;
                        } catch (JSONException exception4) {
                            result2.error("error", exception4.getMessage(), (Object) null);
                            return;
                        }
                    case 9:
                        TextInputChannel.this.textInputMethodHandler.finishAutofillContext(((Boolean) args).booleanValue());
                        result2.success((Object) null);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public TextInputMethodHandler textInputMethodHandler;

    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(String str, Bundle bundle);

        void setClient(int i, Configuration configuration);

        void setEditableSizeAndTransform(double d, double d2, double[] dArr);

        void setEditingState(TextEditState textEditState);

        void setPlatformViewClient(int i);

        void show();
    }

    public TextInputChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodHandler);
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", (Object) null);
    }

    private static HashMap<Object, Object> createEditingStateJSON(String text, int selectionStart, int selectionEnd, int composingStart, int composingEnd) {
        HashMap<Object, Object> state = new HashMap<>();
        state.put("text", text);
        state.put("selectionBase", Integer.valueOf(selectionStart));
        state.put("selectionExtent", Integer.valueOf(selectionEnd));
        state.put("composingBase", Integer.valueOf(composingStart));
        state.put("composingExtent", Integer.valueOf(composingEnd));
        return state;
    }

    public void updateEditingState(int inputClientId, String text, int selectionStart, int selectionEnd, int composingStart, int composingEnd) {
        Log.v(TAG, "Sending message to update editing state: \nText: " + text + "\nSelection start: " + selectionStart + "\nSelection end: " + selectionEnd + "\nComposing start: " + composingStart + "\nComposing end: " + composingEnd);
        HashMap<Object, Object> state = createEditingStateJSON(text, selectionStart, selectionEnd, composingStart, composingEnd);
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), state}));
    }

    public void updateEditingStateWithTag(int inputClientId, HashMap<String, TextEditState> editStates) {
        Log.v(TAG, "Sending message to update editing state for " + String.valueOf(editStates.size()) + " field(s).");
        HashMap<String, HashMap<Object, Object>> json = new HashMap<>();
        for (Map.Entry<String, TextEditState> element : editStates.entrySet()) {
            TextEditState state = element.getValue();
            json.put(element.getKey(), createEditingStateJSON(state.text, state.selectionStart, state.selectionEnd, -1, -1));
        }
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), json}));
    }

    public void newline(int inputClientId) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), "TextInputAction.newline"}));
    }

    public void go(int inputClientId) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), "TextInputAction.go"}));
    }

    public void search(int inputClientId) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), "TextInputAction.search"}));
    }

    public void send(int inputClientId) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), "TextInputAction.send"}));
    }

    public void done(int inputClientId) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), "TextInputAction.done"}));
    }

    public void next(int inputClientId) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), "TextInputAction.next"}));
    }

    public void previous(int inputClientId) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), "TextInputAction.previous"}));
    }

    public void unspecifiedAction(int inputClientId) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), "TextInputAction.unspecified"}));
    }

    public void performPrivateCommand(int inputClientId, String action, Bundle data) {
        HashMap<Object, Object> json = new HashMap<>();
        json.put("action", action);
        if (data != null) {
            HashMap<String, Object> dataMap = new HashMap<>();
            for (String key : data.keySet()) {
                Object value = data.get(key);
                if (value instanceof byte[]) {
                    dataMap.put(key, data.getByteArray(key));
                } else if (value instanceof Byte) {
                    dataMap.put(key, Byte.valueOf(data.getByte(key)));
                } else if (value instanceof char[]) {
                    dataMap.put(key, data.getCharArray(key));
                } else if (value instanceof Character) {
                    dataMap.put(key, Character.valueOf(data.getChar(key)));
                } else if (value instanceof CharSequence[]) {
                    dataMap.put(key, data.getCharSequenceArray(key));
                } else if (value instanceof CharSequence) {
                    dataMap.put(key, data.getCharSequence(key));
                } else if (value instanceof float[]) {
                    dataMap.put(key, data.getFloatArray(key));
                } else if (value instanceof Float) {
                    dataMap.put(key, Float.valueOf(data.getFloat(key)));
                }
            }
            json.put("data", dataMap);
        }
        this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(new Serializable[]{Integer.valueOf(inputClientId), json}));
    }

    public void setTextInputMethodHandler(TextInputMethodHandler textInputMethodHandler2) {
        this.textInputMethodHandler = textInputMethodHandler2;
    }

    public static class Configuration {
        public final String actionLabel;
        public final boolean autocorrect;
        public final Autofill autofill;
        public final boolean enableSuggestions;
        public final Configuration[] fields;
        public final Integer inputAction;
        public final InputType inputType;
        public final boolean obscureText;
        public final TextCapitalization textCapitalization;

        public static Configuration fromJson(JSONObject json) throws JSONException, NoSuchFieldException {
            String inputActionName = json.getString("inputAction");
            if (inputActionName != null) {
                Configuration[] fields2 = null;
                if (!json.isNull("fields")) {
                    JSONArray jsonFields = json.getJSONArray("fields");
                    fields2 = new Configuration[jsonFields.length()];
                    for (int i = 0; i < fields2.length; i++) {
                        fields2[i] = fromJson(jsonFields.getJSONObject(i));
                    }
                }
                return new Configuration(json.optBoolean("obscureText"), json.optBoolean("autocorrect", true), json.optBoolean("enableSuggestions"), TextCapitalization.fromValue(json.getString("textCapitalization")), InputType.fromJson(json.getJSONObject("inputType")), inputActionFromTextInputAction(inputActionName), json.isNull("actionLabel") ? null : json.getString("actionLabel"), json.isNull("autofill") ? null : Autofill.fromJson(json.getJSONObject("autofill")), fields2);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x002a, code lost:
            if (r11.equals("TextInputAction.newline") != false) goto L_0x0074;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.Integer inputActionFromTextInputAction(java.lang.String r11) {
            /*
                int r0 = r11.hashCode()
                r1 = 7
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 6
                r7 = 0
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 1
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                switch(r0) {
                    case -810971940: goto L_0x0069;
                    case -737377923: goto L_0x005f;
                    case -737089298: goto L_0x0055;
                    case -737080013: goto L_0x004b;
                    case -736940669: goto L_0x0041;
                    case 469250275: goto L_0x0037;
                    case 1241689507: goto L_0x002d;
                    case 1539450297: goto L_0x0024;
                    case 2110497650: goto L_0x0019;
                    default: goto L_0x0017;
                }
            L_0x0017:
                goto L_0x0073
            L_0x0019:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0017
                r7 = 8
                goto L_0x0074
            L_0x0024:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0017
                goto L_0x0074
            L_0x002d:
                java.lang.String r0 = "TextInputAction.go"
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0017
                r7 = r3
                goto L_0x0074
            L_0x0037:
                java.lang.String r0 = "TextInputAction.search"
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0017
                r7 = r2
                goto L_0x0074
            L_0x0041:
                java.lang.String r0 = "TextInputAction.send"
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0017
                r7 = r6
                goto L_0x0074
            L_0x004b:
                java.lang.String r0 = "TextInputAction.none"
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0017
                r7 = r9
                goto L_0x0074
            L_0x0055:
                java.lang.String r0 = "TextInputAction.next"
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0017
                r7 = r1
                goto L_0x0074
            L_0x005f:
                java.lang.String r0 = "TextInputAction.done"
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0017
                r7 = r4
                goto L_0x0074
            L_0x0069:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0017
                r7 = r5
                goto L_0x0074
            L_0x0073:
                r7 = -1
            L_0x0074:
                switch(r7) {
                    case 0: goto L_0x0098;
                    case 1: goto L_0x0097;
                    case 2: goto L_0x0096;
                    case 3: goto L_0x0091;
                    case 4: goto L_0x008c;
                    case 5: goto L_0x0087;
                    case 6: goto L_0x0082;
                    case 7: goto L_0x007d;
                    case 8: goto L_0x0078;
                    default: goto L_0x0077;
                }
            L_0x0077:
                return r8
            L_0x0078:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
                return r0
            L_0x007d:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
                return r0
            L_0x0082:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
                return r0
            L_0x0087:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
                return r0
            L_0x008c:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
                return r0
            L_0x0091:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
                return r0
            L_0x0096:
                return r8
            L_0x0097:
                return r10
            L_0x0098:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.inputActionFromTextInputAction(java.lang.String):java.lang.Integer");
        }

        public static class Autofill {
            public final TextEditState editState;
            public final String[] hints;
            public final String uniqueIdentifier;

            public static Autofill fromJson(JSONObject json) throws JSONException, NoSuchFieldException {
                String uniqueIdentifier2 = json.getString("uniqueIdentifier");
                JSONArray hints2 = json.getJSONArray("hints");
                JSONObject editingState = json.getJSONObject("editingValue");
                String[] hintList = new String[hints2.length()];
                for (int i = 0; i < hintList.length; i++) {
                    hintList[i] = translateAutofillHint(hints2.getString(i));
                }
                return new Autofill(uniqueIdentifier2, hintList, TextEditState.fromJson(editingState));
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
                if (r0.equals("password") != false) goto L_0x01af;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String translateAutofillHint(java.lang.String r16) {
                /*
                    r0 = r16
                    int r1 = android.os.Build.VERSION.SDK_INT
                    r2 = 26
                    if (r1 >= r2) goto L_0x0009
                    return r0
                L_0x0009:
                    int r3 = r16.hashCode()
                    java.lang.String r4 = "postalCode"
                    java.lang.String r5 = "postalAddress"
                    java.lang.String r6 = "password"
                    java.lang.String r7 = "newUsername"
                    java.lang.String r8 = "username"
                    java.lang.String r9 = "creditCardExpirationYear"
                    java.lang.String r10 = "creditCardExpirationDate"
                    java.lang.String r11 = "creditCardNumber"
                    java.lang.String r12 = "gender"
                    java.lang.String r13 = "creditCardExpirationDay"
                    java.lang.String r14 = "creditCardSecurityCode"
                    java.lang.String r15 = "newPassword"
                    java.lang.String r1 = "creditCardExpirationMonth"
                    switch(r3) {
                        case -2058889126: goto L_0x01a4;
                        case -1917283616: goto L_0x0199;
                        case -1844815832: goto L_0x0190;
                        case -1825589953: goto L_0x0185;
                        case -1821235109: goto L_0x017c;
                        case -1757573738: goto L_0x0173;
                        case -1682373820: goto L_0x016a;
                        case -1658955742: goto L_0x015f;
                        case -1567118045: goto L_0x0154;
                        case -1476752575: goto L_0x014a;
                        case -1413737489: goto L_0x013e;
                        case -1377792129: goto L_0x0133;
                        case -1249512767: goto L_0x0129;
                        case -1186060294: goto L_0x011d;
                        case -1151034798: goto L_0x0113;
                        case -835992323: goto L_0x0107;
                        case -818219584: goto L_0x00fb;
                        case -747304516: goto L_0x00ef;
                        case -613980922: goto L_0x00e6;
                        case -613352043: goto L_0x00dc;
                        case -549230602: goto L_0x00d0;
                        case -265713450: goto L_0x00c6;
                        case 3373707: goto L_0x00ba;
                        case 96619420: goto L_0x00ae;
                        case 253202685: goto L_0x00a3;
                        case 588174851: goto L_0x0098;
                        case 798554127: goto L_0x008c;
                        case 892233837: goto L_0x0080;
                        case 991032982: goto L_0x0076;
                        case 1069376125: goto L_0x006b;
                        case 1216985755: goto L_0x0063;
                        case 1469046696: goto L_0x0057;
                        case 1662667945: goto L_0x004d;
                        case 1921869058: goto L_0x0041;
                        case 2011152728: goto L_0x0037;
                        case 2011773919: goto L_0x002c;
                        default: goto L_0x002a;
                    }
                L_0x002a:
                    goto L_0x01ae
                L_0x002c:
                    java.lang.String r2 = "birthdayDay"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 3
                    goto L_0x01af
                L_0x0037:
                    boolean r2 = r0.equals(r4)
                    if (r2 == 0) goto L_0x002a
                    r2 = 30
                    goto L_0x01af
                L_0x0041:
                    java.lang.String r2 = "postalAddressExtended"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 28
                    goto L_0x01af
                L_0x004d:
                    boolean r2 = r0.equals(r5)
                    if (r2 == 0) goto L_0x002a
                    r2 = 27
                    goto L_0x01af
                L_0x0057:
                    java.lang.String r2 = "givenName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 17
                    goto L_0x01af
                L_0x0063:
                    boolean r3 = r0.equals(r6)
                    if (r3 == 0) goto L_0x002a
                    goto L_0x01af
                L_0x006b:
                    java.lang.String r2 = "birthday"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 2
                    goto L_0x01af
                L_0x0076:
                    boolean r2 = r0.equals(r7)
                    if (r2 == 0) goto L_0x002a
                    r2 = 24
                    goto L_0x01af
                L_0x0080:
                    java.lang.String r2 = "telephoneNumber"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 31
                    goto L_0x01af
                L_0x008c:
                    java.lang.String r2 = "familyName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 14
                    goto L_0x01af
                L_0x0098:
                    java.lang.String r2 = "birthdayMonth"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 4
                    goto L_0x01af
                L_0x00a3:
                    java.lang.String r2 = "addressState"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 1
                    goto L_0x01af
                L_0x00ae:
                    java.lang.String r2 = "email"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 13
                    goto L_0x01af
                L_0x00ba:
                    java.lang.String r2 = "name"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 20
                    goto L_0x01af
                L_0x00c6:
                    boolean r2 = r0.equals(r8)
                    if (r2 == 0) goto L_0x002a
                    r2 = 35
                    goto L_0x01af
                L_0x00d0:
                    java.lang.String r2 = "telephoneNumberCountryCode"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 32
                    goto L_0x01af
                L_0x00dc:
                    boolean r2 = r0.equals(r9)
                    if (r2 == 0) goto L_0x002a
                    r2 = 10
                    goto L_0x01af
                L_0x00e6:
                    boolean r2 = r0.equals(r10)
                    if (r2 == 0) goto L_0x002a
                    r2 = 7
                    goto L_0x01af
                L_0x00ef:
                    java.lang.String r2 = "nameSuffix"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 22
                    goto L_0x01af
                L_0x00fb:
                    java.lang.String r2 = "middleName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 19
                    goto L_0x01af
                L_0x0107:
                    java.lang.String r2 = "namePrefix"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 21
                    goto L_0x01af
                L_0x0113:
                    boolean r2 = r0.equals(r11)
                    if (r2 == 0) goto L_0x002a
                    r2 = 11
                    goto L_0x01af
                L_0x011d:
                    java.lang.String r2 = "postalAddressExtendedPostalCode"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 29
                    goto L_0x01af
                L_0x0129:
                    boolean r2 = r0.equals(r12)
                    if (r2 == 0) goto L_0x002a
                    r2 = 16
                    goto L_0x01af
                L_0x0133:
                    java.lang.String r2 = "addressCity"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 0
                    goto L_0x01af
                L_0x013e:
                    java.lang.String r2 = "middleInitial"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 18
                    goto L_0x01af
                L_0x014a:
                    java.lang.String r2 = "countryName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 6
                    goto L_0x01af
                L_0x0154:
                    java.lang.String r2 = "telephoneNumberDevice"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 33
                    goto L_0x01af
                L_0x015f:
                    java.lang.String r2 = "fullStreetAddress"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 15
                    goto L_0x01af
                L_0x016a:
                    boolean r2 = r0.equals(r13)
                    if (r2 == 0) goto L_0x002a
                    r2 = 8
                    goto L_0x01af
                L_0x0173:
                    boolean r2 = r0.equals(r14)
                    if (r2 == 0) goto L_0x002a
                    r2 = 12
                    goto L_0x01af
                L_0x017c:
                    boolean r2 = r0.equals(r15)
                    if (r2 == 0) goto L_0x002a
                    r2 = 23
                    goto L_0x01af
                L_0x0185:
                    java.lang.String r2 = "telephoneNumberNational"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 34
                    goto L_0x01af
                L_0x0190:
                    boolean r2 = r0.equals(r1)
                    if (r2 == 0) goto L_0x002a
                    r2 = 9
                    goto L_0x01af
                L_0x0199:
                    java.lang.String r2 = "oneTimeCode"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 25
                    goto L_0x01af
                L_0x01a4:
                    java.lang.String r2 = "birthdayYear"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x002a
                    r2 = 5
                    goto L_0x01af
                L_0x01ae:
                    r2 = -1
                L_0x01af:
                    switch(r2) {
                        case 0: goto L_0x0202;
                        case 1: goto L_0x01ff;
                        case 2: goto L_0x01fc;
                        case 3: goto L_0x01f9;
                        case 4: goto L_0x01f6;
                        case 5: goto L_0x01f3;
                        case 6: goto L_0x01f0;
                        case 7: goto L_0x01ef;
                        case 8: goto L_0x01ee;
                        case 9: goto L_0x01ed;
                        case 10: goto L_0x01ec;
                        case 11: goto L_0x01eb;
                        case 12: goto L_0x01ea;
                        case 13: goto L_0x01e7;
                        case 14: goto L_0x01e4;
                        case 15: goto L_0x01e1;
                        case 16: goto L_0x01e0;
                        case 17: goto L_0x01dd;
                        case 18: goto L_0x01da;
                        case 19: goto L_0x01d7;
                        case 20: goto L_0x01d4;
                        case 21: goto L_0x01d1;
                        case 22: goto L_0x01ce;
                        case 23: goto L_0x01cd;
                        case 24: goto L_0x01cc;
                        case 25: goto L_0x01c9;
                        case 26: goto L_0x01c8;
                        case 27: goto L_0x01c7;
                        case 28: goto L_0x01c4;
                        case 29: goto L_0x01c1;
                        case 30: goto L_0x01c0;
                        case 31: goto L_0x01bd;
                        case 32: goto L_0x01ba;
                        case 33: goto L_0x01b7;
                        case 34: goto L_0x01b4;
                        case 35: goto L_0x01b3;
                        default: goto L_0x01b2;
                    }
                L_0x01b2:
                    return r0
                L_0x01b3:
                    return r8
                L_0x01b4:
                    java.lang.String r1 = "phoneNational"
                    return r1
                L_0x01b7:
                    java.lang.String r1 = "phoneNumberDevice"
                    return r1
                L_0x01ba:
                    java.lang.String r1 = "phoneCountryCode"
                    return r1
                L_0x01bd:
                    java.lang.String r1 = "phoneNumber"
                    return r1
                L_0x01c0:
                    return r4
                L_0x01c1:
                    java.lang.String r1 = "extendedPostalCode"
                    return r1
                L_0x01c4:
                    java.lang.String r1 = "extendedAddress"
                    return r1
                L_0x01c7:
                    return r5
                L_0x01c8:
                    return r6
                L_0x01c9:
                    java.lang.String r1 = "smsOTPCode"
                    return r1
                L_0x01cc:
                    return r7
                L_0x01cd:
                    return r15
                L_0x01ce:
                    java.lang.String r1 = "personNameSuffix"
                    return r1
                L_0x01d1:
                    java.lang.String r1 = "personNamePrefix"
                    return r1
                L_0x01d4:
                    java.lang.String r1 = "personName"
                    return r1
                L_0x01d7:
                    java.lang.String r1 = "personMiddleName"
                    return r1
                L_0x01da:
                    java.lang.String r1 = "personMiddleInitial"
                    return r1
                L_0x01dd:
                    java.lang.String r1 = "personGivenName"
                    return r1
                L_0x01e0:
                    return r12
                L_0x01e1:
                    java.lang.String r1 = "streetAddress"
                    return r1
                L_0x01e4:
                    java.lang.String r1 = "personFamilyName"
                    return r1
                L_0x01e7:
                    java.lang.String r1 = "emailAddress"
                    return r1
                L_0x01ea:
                    return r14
                L_0x01eb:
                    return r11
                L_0x01ec:
                    return r9
                L_0x01ed:
                    return r1
                L_0x01ee:
                    return r13
                L_0x01ef:
                    return r10
                L_0x01f0:
                    java.lang.String r1 = "addressCountry"
                    return r1
                L_0x01f3:
                    java.lang.String r1 = "birthDateYear"
                    return r1
                L_0x01f6:
                    java.lang.String r1 = "birthDateMonth"
                    return r1
                L_0x01f9:
                    java.lang.String r1 = "birthDateDay"
                    return r1
                L_0x01fc:
                    java.lang.String r1 = "birthDateFull"
                    return r1
                L_0x01ff:
                    java.lang.String r1 = "addressRegion"
                    return r1
                L_0x0202:
                    java.lang.String r1 = "addressLocality"
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill.translateAutofillHint(java.lang.String):java.lang.String");
            }

            public Autofill(String uniqueIdentifier2, String[] hints2, TextEditState editingState) {
                this.uniqueIdentifier = uniqueIdentifier2;
                this.hints = hints2;
                this.editState = editingState;
            }
        }

        public Configuration(boolean obscureText2, boolean autocorrect2, boolean enableSuggestions2, TextCapitalization textCapitalization2, InputType inputType2, Integer inputAction2, String actionLabel2, Autofill autofill2, Configuration[] fields2) {
            this.obscureText = obscureText2;
            this.autocorrect = autocorrect2;
            this.enableSuggestions = enableSuggestions2;
            this.textCapitalization = textCapitalization2;
            this.inputType = inputType2;
            this.inputAction = inputAction2;
            this.actionLabel = actionLabel2;
            this.autofill = autofill2;
            this.fields = fields2;
        }
    }

    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        public final TextInputType type;

        public static InputType fromJson(JSONObject json) throws JSONException, NoSuchFieldException {
            return new InputType(TextInputType.fromValue(json.getString(AppMeasurementSdk.ConditionalUserProperty.NAME)), json.optBoolean("signed", false), json.optBoolean("decimal", false));
        }

        public InputType(TextInputType type2, boolean isSigned2, boolean isDecimal2) {
            this.type = type2;
            this.isSigned = isSigned2;
            this.isDecimal = isDecimal2;
        }
    }

    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword");
        
        private final String encodedName;

        static TextInputType fromValue(String encodedName2) throws NoSuchFieldException {
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(encodedName2)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + encodedName2);
        }

        private TextInputType(String encodedName2) {
            this.encodedName = encodedName2;
        }
    }

    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        private final String encodedName;

        static TextCapitalization fromValue(String encodedName2) throws NoSuchFieldException {
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(encodedName2)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + encodedName2);
        }

        private TextCapitalization(String encodedName2) {
            this.encodedName = encodedName2;
        }
    }

    public static class TextEditState {
        public final int selectionEnd;
        public final int selectionStart;
        public final String text;

        public static TextEditState fromJson(JSONObject textEditState) throws JSONException {
            return new TextEditState(textEditState.getString("text"), textEditState.getInt("selectionBase"), textEditState.getInt("selectionExtent"));
        }

        public TextEditState(String text2, int selectionStart2, int selectionEnd2) {
            this.text = text2;
            this.selectionStart = selectionStart2;
            this.selectionEnd = selectionEnd2;
        }
    }
}
