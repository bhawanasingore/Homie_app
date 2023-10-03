package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Base64;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String BIG_INTEGER_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy";
    private static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    private static final String LIST_IDENTIFIER = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    private static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    private final SharedPreferences preferences;

    MethodCallHandlerImpl(Context context) {
        this.preferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r8, io.flutter.plugin.common.MethodChannel.Result r9) {
        /*
            r7 = this;
            java.lang.String r0 = "key"
            java.lang.Object r0 = r8.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = r8.method     // Catch:{ IOException -> 0x019e }
            r2 = -1
            int r3 = r1.hashCode()     // Catch:{ IOException -> 0x019e }
            r4 = 1
            switch(r3) {
                case -1354815177: goto L_0x0065;
                case -1249367445: goto L_0x005b;
                case -1096934831: goto L_0x0051;
                case -934610812: goto L_0x0047;
                case -905809875: goto L_0x003d;
                case 94746189: goto L_0x0032;
                case 155439827: goto L_0x0028;
                case 589412115: goto L_0x001e;
                case 1984457324: goto L_0x0014;
                default: goto L_0x0013;
            }     // Catch:{ IOException -> 0x019e }
        L_0x0013:
            goto L_0x006e
        L_0x0014:
            java.lang.String r3 = "setBool"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x0013
            r2 = 0
            goto L_0x006e
        L_0x001e:
            java.lang.String r3 = "setString"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x0013
            r2 = 3
            goto L_0x006e
        L_0x0028:
            java.lang.String r3 = "setDouble"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x0013
            r2 = r4
            goto L_0x006e
        L_0x0032:
            java.lang.String r3 = "clear"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x0013
            r2 = 8
            goto L_0x006e
        L_0x003d:
            java.lang.String r3 = "setInt"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x0013
            r2 = 2
            goto L_0x006e
        L_0x0047:
            java.lang.String r3 = "remove"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x0013
            r2 = 7
            goto L_0x006e
        L_0x0051:
            java.lang.String r3 = "setStringList"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x0013
            r2 = 4
            goto L_0x006e
        L_0x005b:
            java.lang.String r3 = "getAll"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x0013
            r2 = 6
            goto L_0x006e
        L_0x0065:
            java.lang.String r3 = "commit"
            boolean r1 = r1.equals(r3)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x0013
            r2 = 5
        L_0x006e:
            java.lang.String r1 = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy"
            java.lang.String r3 = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu"
            java.lang.String r5 = "value"
            switch(r2) {
                case 0: goto L_0x0186;
                case 1: goto L_0x0159;
                case 2: goto L_0x0117;
                case 3: goto L_0x00ec;
                case 4: goto L_0x00c4;
                case 5: goto L_0x00bb;
                case 6: goto L_0x00b3;
                case 7: goto L_0x00a4;
                case 8: goto L_0x007c;
                default: goto L_0x0077;
            }
        L_0x0077:
            r9.notImplemented()     // Catch:{ IOException -> 0x019e }
            goto L_0x019d
        L_0x007c:
            java.util.Map r1 = r7.getAllPrefs()     // Catch:{ IOException -> 0x019e }
            java.util.Set r1 = r1.keySet()     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences r2 = r7.preferences     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ IOException -> 0x019e }
            java.util.Iterator r3 = r1.iterator()     // Catch:{ IOException -> 0x019e }
        L_0x008e:
            boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x019e }
            if (r4 == 0) goto L_0x009f
            java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x019e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x019e }
            r2.remove(r4)     // Catch:{ IOException -> 0x019e }
            goto L_0x008e
        L_0x009f:
            r7.commitAsync(r2, r9)     // Catch:{ IOException -> 0x019e }
            goto L_0x019d
        L_0x00a4:
            android.content.SharedPreferences r1 = r7.preferences     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r1 = r1.remove(r0)     // Catch:{ IOException -> 0x019e }
            r7.commitAsync(r1, r9)     // Catch:{ IOException -> 0x019e }
            goto L_0x019d
        L_0x00b3:
            java.util.Map r1 = r7.getAllPrefs()     // Catch:{ IOException -> 0x019e }
            r9.success(r1)     // Catch:{ IOException -> 0x019e }
            return
        L_0x00bb:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)     // Catch:{ IOException -> 0x019e }
            r9.success(r1)     // Catch:{ IOException -> 0x019e }
            goto L_0x019d
        L_0x00c4:
            java.lang.Object r1 = r8.argument(r5)     // Catch:{ IOException -> 0x019e }
            java.util.List r1 = (java.util.List) r1     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences r2 = r7.preferences     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ IOException -> 0x019e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019e }
            r4.<init>()     // Catch:{ IOException -> 0x019e }
            r4.append(r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r3 = r7.encodeList(r1)     // Catch:{ IOException -> 0x019e }
            r4.append(r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r2 = r2.putString(r0, r3)     // Catch:{ IOException -> 0x019e }
            r7.commitAsync(r2, r9)     // Catch:{ IOException -> 0x019e }
            goto L_0x019d
        L_0x00ec:
            java.lang.Object r2 = r8.argument(r5)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x019e }
            boolean r3 = r2.startsWith(r3)     // Catch:{ IOException -> 0x019e }
            if (r3 != 0) goto L_0x010e
            boolean r1 = r2.startsWith(r1)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x00ff
            goto L_0x010e
        L_0x00ff:
            android.content.SharedPreferences r1 = r7.preferences     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r1 = r1.putString(r0, r2)     // Catch:{ IOException -> 0x019e }
            r7.commitAsync(r1, r9)     // Catch:{ IOException -> 0x019e }
            goto L_0x019d
        L_0x010e:
            java.lang.String r1 = "StorageError"
            java.lang.String r3 = "This string cannot be stored as it clashes with special identifier prefixes."
            r4 = 0
            r9.error(r1, r3, r4)     // Catch:{ IOException -> 0x019e }
            return
        L_0x0117:
            java.lang.Object r2 = r8.argument(r5)     // Catch:{ IOException -> 0x019e }
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ IOException -> 0x019e }
            boolean r3 = r2 instanceof java.math.BigInteger     // Catch:{ IOException -> 0x019e }
            if (r3 == 0) goto L_0x0147
            r3 = r2
            java.math.BigInteger r3 = (java.math.BigInteger) r3     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences r4 = r7.preferences     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ IOException -> 0x019e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019e }
            r5.<init>()     // Catch:{ IOException -> 0x019e }
            r5.append(r1)     // Catch:{ IOException -> 0x019e }
            r1 = 36
            java.lang.String r1 = r3.toString(r1)     // Catch:{ IOException -> 0x019e }
            r5.append(r1)     // Catch:{ IOException -> 0x019e }
            java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r1 = r4.putString(r0, r1)     // Catch:{ IOException -> 0x019e }
            r7.commitAsync(r1, r9)     // Catch:{ IOException -> 0x019e }
            goto L_0x019d
        L_0x0147:
            android.content.SharedPreferences r1 = r7.preferences     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ IOException -> 0x019e }
            long r3 = r2.longValue()     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r1 = r1.putLong(r0, r3)     // Catch:{ IOException -> 0x019e }
            r7.commitAsync(r1, r9)     // Catch:{ IOException -> 0x019e }
            goto L_0x019d
        L_0x0159:
            java.lang.Object r1 = r8.argument(r5)     // Catch:{ IOException -> 0x019e }
            java.lang.Number r1 = (java.lang.Number) r1     // Catch:{ IOException -> 0x019e }
            double r1 = r1.doubleValue()     // Catch:{ IOException -> 0x019e }
            java.lang.String r3 = java.lang.Double.toString(r1)     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences r4 = r7.preferences     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ IOException -> 0x019e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019e }
            r5.<init>()     // Catch:{ IOException -> 0x019e }
            java.lang.String r6 = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu"
            r5.append(r6)     // Catch:{ IOException -> 0x019e }
            r5.append(r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r4 = r4.putString(r0, r5)     // Catch:{ IOException -> 0x019e }
            r7.commitAsync(r4, r9)     // Catch:{ IOException -> 0x019e }
            goto L_0x019d
        L_0x0186:
            android.content.SharedPreferences r1 = r7.preferences     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ IOException -> 0x019e }
            java.lang.Object r2 = r8.argument(r5)     // Catch:{ IOException -> 0x019e }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ IOException -> 0x019e }
            boolean r2 = r2.booleanValue()     // Catch:{ IOException -> 0x019e }
            android.content.SharedPreferences$Editor r1 = r1.putBoolean(r0, r2)     // Catch:{ IOException -> 0x019e }
            r7.commitAsync(r1, r9)     // Catch:{ IOException -> 0x019e }
        L_0x019d:
            goto L_0x01a6
        L_0x019e:
            r1 = move-exception
            java.lang.String r2 = r8.method
            java.lang.String r3 = "IOException encountered"
            r9.error(r3, r2, r1)
        L_0x01a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.MethodCallHandlerImpl.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private void commitAsync(final SharedPreferences.Editor editor, final MethodChannel.Result result) {
        new AsyncTask<Void, Void, Boolean>() {
            /* access modifiers changed from: protected */
            public Boolean doInBackground(Void... voids) {
                return Boolean.valueOf(editor.commit());
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Boolean value) {
                result.success(value);
            }
        }.execute(new Void[0]);
    }

    private List<String> decodeList(String encodedList) throws IOException {
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(encodedList, 0)));
            List<String> list = (List) stream.readObject();
            stream.close();
            return list;
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        } catch (Throwable th) {
            if (stream != null) {
                stream.close();
            }
            throw th;
        }
    }

    private String encodeList(List<String> list) throws IOException {
        ObjectOutputStream stream = null;
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream stream2 = new ObjectOutputStream(byteStream);
            stream2.writeObject(list);
            stream2.flush();
            String encodeToString = Base64.encodeToString(byteStream.toByteArray(), 0);
            stream2.close();
            return encodeToString;
        } catch (Throwable th) {
            if (stream != null) {
                stream.close();
            }
            throw th;
        }
    }

    private Map<String, Object> getAllPrefs() throws IOException {
        Map<String, ?> allPrefs = this.preferences.getAll();
        Map<String, Object> filteredPrefs = new HashMap<>();
        for (String key : allPrefs.keySet()) {
            if (key.startsWith("flutter.")) {
                Object value = allPrefs.get(key);
                if (value instanceof String) {
                    String stringValue = (String) value;
                    if (stringValue.startsWith(LIST_IDENTIFIER)) {
                        value = decodeList(stringValue.substring(LIST_IDENTIFIER.length()));
                    } else if (stringValue.startsWith(BIG_INTEGER_PREFIX)) {
                        value = new BigInteger(stringValue.substring(BIG_INTEGER_PREFIX.length()), 36);
                    } else if (stringValue.startsWith(DOUBLE_PREFIX)) {
                        value = Double.valueOf(stringValue.substring(DOUBLE_PREFIX.length()));
                    }
                } else if (value instanceof Set) {
                    List<String> listValue = new ArrayList<>((Set) value);
                    SharedPreferences.Editor remove = this.preferences.edit().remove(key);
                    if (remove.putString(key, LIST_IDENTIFIER + encodeList(listValue)).commit()) {
                        value = listValue;
                    } else {
                        throw new IOException("Could not migrate set to list");
                    }
                }
                filteredPrefs.put(key, value);
            }
        }
        return filteredPrefs;
    }
}
