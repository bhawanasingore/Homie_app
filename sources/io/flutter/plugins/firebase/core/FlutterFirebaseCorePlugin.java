package io.flutter.plugins.firebase.core;

import android.content.Context;
import androidx.annotation.NonNull;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

@SynthesizedClassMap({$$Lambda$FlutterFirebaseCorePlugin$5poRebhJMWOESqwL6V7pWkSmoI.class, $$Lambda$FlutterFirebaseCorePlugin$UXJZHKnELOzJNekp91xf7BhTHiU.class, $$Lambda$FlutterFirebaseCorePlugin$bnBgkHnmRbq97TuDdS8vJ2hZZMU.class, $$Lambda$FlutterFirebaseCorePlugin$gYVnzTfgrI8f1GfXHpcPbM5sOfM.class, $$Lambda$FlutterFirebaseCorePlugin$qEMNGkrG5kqFaCoeUbtkAMV5w.class, $$Lambda$FlutterFirebaseCorePlugin$qb2shJLzVGwFgjnUYjYjq_o3W0.class, $$Lambda$FlutterFirebaseCorePlugin$vvJMCwJxURJlRP2LYeIAYYFXLq0.class})
public class FlutterFirebaseCorePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static final String CHANNEL_NAME = "plugins.flutter.io/firebase_core";
    private static final String KEY_API_KEY = "apiKey";
    private static final String KEY_APP_ID = "appId";
    private static final String KEY_APP_NAME = "appName";
    private static final String KEY_DATABASE_URL = "databaseURL";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_IS_AUTOMATIC_DATA_COLLECTION_ENABLED = "isAutomaticDataCollectionEnabled";
    private static final String KEY_MESSAGING_SENDER_ID = "messagingSenderId";
    private static final String KEY_NAME = "name";
    private static final String KEY_OPTIONS = "options";
    private static final String KEY_PLUGIN_CONSTANTS = "pluginConstants";
    private static final String KEY_PROJECT_ID = "projectId";
    private static final String KEY_STORAGE_BUCKET = "storageBucket";
    private static final String KEY_TRACKING_ID = "trackingId";
    private Context applicationContext;
    private MethodChannel channel;
    private boolean coreInitialized = false;

    public FlutterFirebaseCorePlugin() {
    }

    private FlutterFirebaseCorePlugin(Context applicationContext2) {
        this.applicationContext = applicationContext2;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), CHANNEL_NAME).setMethodCallHandler(new FlutterFirebaseCorePlugin(registrar.context()));
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.applicationContext = binding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(binding.getBinaryMessenger(), CHANNEL_NAME);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.applicationContext = null;
    }

    private Task<Map<String, Object>> firebaseAppToMap(FirebaseApp firebaseApp) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new Callable() {
            public final Object call() {
                return FlutterFirebaseCorePlugin.lambda$firebaseAppToMap$0(FirebaseApp.this);
            }
        });
    }

    static /* synthetic */ Map lambda$firebaseAppToMap$0(FirebaseApp firebaseApp) throws Exception {
        Map<String, Object> appMap = new HashMap<>();
        Map<String, String> optionsMap = new HashMap<>();
        FirebaseOptions options = firebaseApp.getOptions();
        optionsMap.put(KEY_API_KEY, options.getApiKey());
        optionsMap.put(KEY_APP_ID, options.getApplicationId());
        if (options.getGcmSenderId() != null) {
            optionsMap.put(KEY_MESSAGING_SENDER_ID, options.getGcmSenderId());
        }
        if (options.getProjectId() != null) {
            optionsMap.put(KEY_PROJECT_ID, options.getProjectId());
        }
        if (options.getDatabaseUrl() != null) {
            optionsMap.put(KEY_DATABASE_URL, options.getDatabaseUrl());
        }
        if (options.getStorageBucket() != null) {
            optionsMap.put(KEY_STORAGE_BUCKET, options.getStorageBucket());
        }
        if (options.getGaTrackingId() != null) {
            optionsMap.put(KEY_TRACKING_ID, options.getGaTrackingId());
        }
        appMap.put("name", firebaseApp.getName());
        appMap.put(KEY_OPTIONS, optionsMap);
        appMap.put(KEY_IS_AUTOMATIC_DATA_COLLECTION_ENABLED, Boolean.valueOf(firebaseApp.isDataCollectionDefaultEnabled()));
        appMap.put(KEY_PLUGIN_CONSTANTS, Tasks.await(FlutterFirebasePluginRegistry.getPluginConstantsForFirebaseApp(firebaseApp)));
        return appMap;
    }

    private Task<Map<String, Object>> initializeApp(Map<String, Object> arguments) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseCorePlugin.this.lambda$initializeApp$1$FlutterFirebaseCorePlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Map lambda$initializeApp$1$FlutterFirebaseCorePlugin(Map arguments) throws Exception {
        Map<String, String> optionsMap = (Map) Objects.requireNonNull(arguments.get(KEY_OPTIONS));
        FirebaseOptions options = new FirebaseOptions.Builder().setApiKey((String) Objects.requireNonNull(optionsMap.get(KEY_API_KEY))).setApplicationId((String) Objects.requireNonNull(optionsMap.get(KEY_APP_ID))).setDatabaseUrl(optionsMap.get(KEY_DATABASE_URL)).setGcmSenderId(optionsMap.get(KEY_MESSAGING_SENDER_ID)).setProjectId(optionsMap.get(KEY_PROJECT_ID)).setStorageBucket(optionsMap.get(KEY_STORAGE_BUCKET)).setGaTrackingId(optionsMap.get(KEY_TRACKING_ID)).build();
        return (Map) Tasks.await(firebaseAppToMap(FirebaseApp.initializeApp(this.applicationContext, options, (String) Objects.requireNonNull(arguments.get("appName")))));
    }

    private Task<List<Map<String, Object>>> initializeCore() {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new Callable() {
            public final Object call() {
                return FlutterFirebaseCorePlugin.this.lambda$initializeCore$2$FlutterFirebaseCorePlugin();
            }
        });
    }

    public /* synthetic */ List lambda$initializeCore$2$FlutterFirebaseCorePlugin() throws Exception {
        if (!this.coreInitialized) {
            this.coreInitialized = true;
        } else {
            Tasks.await(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
        }
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps(this.applicationContext);
        List<Map<String, Object>> firebaseAppsList = new ArrayList<>(firebaseApps.size());
        for (FirebaseApp firebaseApp : firebaseApps) {
            firebaseAppsList.add(Tasks.await(firebaseAppToMap(firebaseApp)));
        }
        return firebaseAppsList;
    }

    private Task<Void> setAutomaticDataCollectionEnabled(Map<String, Object> arguments) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FirebaseApp.getInstance((String) Objects.requireNonNull(this.f$0.get("appName"))).setDataCollectionDefaultEnabled(((Boolean) Objects.requireNonNull(this.f$0.get(FlutterFirebaseCorePlugin.KEY_ENABLED))).booleanValue());
            }
        });
    }

    private Task<Void> setAutomaticResourceManagementEnabled(Map<String, Object> arguments) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FirebaseApp.getInstance((String) Objects.requireNonNull(this.f$0.get("appName"))).setAutomaticResourceManagementEnabled(((Boolean) Objects.requireNonNull(this.f$0.get(FlutterFirebaseCorePlugin.KEY_ENABLED))).booleanValue());
            }
        });
    }

    private Task<Void> deleteApp(Map<String, Object> arguments) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseCorePlugin.lambda$deleteApp$5(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$deleteApp$5(Map arguments) throws Exception {
        try {
            FirebaseApp.getInstance((String) Objects.requireNonNull(arguments.get("appName"))).delete();
            return null;
        } catch (IllegalStateException e) {
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r7, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.method
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1428757205: goto L_0x0036;
                case -746799097: goto L_0x002c;
                case -738827499: goto L_0x0022;
                case 145005524: goto L_0x0018;
                case 1633364958: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0040
        L_0x000e:
            java.lang.String r1 = "FirebaseApp#setAutomaticResourceManagementEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r3
            goto L_0x0041
        L_0x0018:
            java.lang.String r1 = "FirebaseApp#delete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r2
            goto L_0x0041
        L_0x0022:
            java.lang.String r1 = "Firebase#initializeApp"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 0
            goto L_0x0041
        L_0x002c:
            java.lang.String r1 = "FirebaseApp#setAutomaticDataCollectionEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r4
            goto L_0x0041
        L_0x0036:
            java.lang.String r1 = "Firebase#initializeCore"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r5
            goto L_0x0041
        L_0x0040:
            r0 = -1
        L_0x0041:
            if (r0 == 0) goto L_0x0075
            if (r0 == r5) goto L_0x0070
            if (r0 == r4) goto L_0x0065
            if (r0 == r3) goto L_0x005a
            if (r0 == r2) goto L_0x004f
            r8.notImplemented()
            return
        L_0x004f:
            java.lang.Object r0 = r7.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r6.deleteApp(r0)
            goto L_0x0080
        L_0x005a:
            java.lang.Object r0 = r7.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r6.setAutomaticResourceManagementEnabled(r0)
            goto L_0x0080
        L_0x0065:
            java.lang.Object r0 = r7.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r6.setAutomaticDataCollectionEnabled(r0)
            goto L_0x0080
        L_0x0070:
            com.google.android.gms.tasks.Task r0 = r6.initializeCore()
            goto L_0x0080
        L_0x0075:
            java.lang.Object r0 = r7.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r6.initializeApp(r0)
        L_0x0080:
            io.flutter.plugins.firebase.core.-$$Lambda$FlutterFirebaseCorePlugin$vvJMCwJxURJlRP2LYeIAYYFXLq0 r1 = new io.flutter.plugins.firebase.core.-$$Lambda$FlutterFirebaseCorePlugin$vvJMCwJxURJlRP2LYeIAYYFXLq0
            r1.<init>()
            r0.addOnCompleteListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    static /* synthetic */ void lambda$onMethodCall$6(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        Exception exception = task.getException();
        result.error("firebase_core", exception != null ? exception.getMessage() : null, (Object) null);
    }
}
