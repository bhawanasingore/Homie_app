package io.flutter.plugins.firebase.core;

import androidx.annotation.Keep;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

@SynthesizedClassMap({$$Lambda$FlutterFirebasePluginRegistry$JO7RGmIyq1p1FUkBeR9Sz4euXI.class, $$Lambda$FlutterFirebasePluginRegistry$gShZmMieJpkQuwtRno0ljd7ot5c.class})
@Keep
public class FlutterFirebasePluginRegistry {
    private static final Map<String, FlutterFirebasePlugin> registeredPlugins = new WeakHashMap();

    public static void registerPlugin(String channelName, FlutterFirebasePlugin flutterFirebasePlugin) {
        registeredPlugins.put(channelName, flutterFirebasePlugin);
    }

    static Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, new Callable() {
            public final Object call() {
                return FlutterFirebasePluginRegistry.lambda$getPluginConstantsForFirebaseApp$0(FirebaseApp.this);
            }
        });
    }

    static /* synthetic */ Map lambda$getPluginConstantsForFirebaseApp$0(FirebaseApp firebaseApp) throws Exception {
        Map<String, Object> pluginConstants = new HashMap<>(registeredPlugins.size());
        for (Map.Entry<String, FlutterFirebasePlugin> entry : registeredPlugins.entrySet()) {
            pluginConstants.put(entry.getKey(), Tasks.await(entry.getValue().getPluginConstantsForFirebaseApp(firebaseApp)));
        }
        return pluginConstants;
    }

    static Task<Void> didReinitializeFirebaseCore() {
        return Tasks.call(FlutterFirebasePlugin.cachedThreadPool, $$Lambda$FlutterFirebasePluginRegistry$gShZmMieJpkQuwtRno0ljd7ot5c.INSTANCE);
    }

    static /* synthetic */ Void lambda$didReinitializeFirebaseCore$1() throws Exception {
        for (Map.Entry<String, FlutterFirebasePlugin> entry : registeredPlugins.entrySet()) {
            Tasks.await(entry.getValue().didReinitializeFirebaseCore());
        }
        return null;
    }
}
