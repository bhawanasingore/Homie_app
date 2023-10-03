package io.flutter.plugins.firebase.firestore;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.os.EnvironmentCompat;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Source;
import com.google.firebase.firestore.WriteBatch;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMethodCodec;
import io.flutter.plugins.firebase.auth.Constants;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

@SynthesizedClassMap({$$Lambda$FlutterFirebaseFirestorePlugin$nhG57Mf435U2yIbZC0CIRDrRfI.class, $$Lambda$FlutterFirebaseFirestorePlugin$0XC2qCCZvF7oH8fGhdOK5wLSiE.class, $$Lambda$FlutterFirebaseFirestorePlugin$1NN0GvEAexisjE5rzggRhn38nzQ.class, $$Lambda$FlutterFirebaseFirestorePlugin$2VkYBlMFEBMvKMnUZ6uCB1PWTgU.class, $$Lambda$FlutterFirebaseFirestorePlugin$66ivwS7n3Ptt5ML4_BwQKVr6VY.class, $$Lambda$FlutterFirebaseFirestorePlugin$7lkVbriWDruJpEo6waCIJLP1BQY.class, $$Lambda$FlutterFirebaseFirestorePlugin$GjF8t9E5uC0XtkobpODjRnByQoQ.class, $$Lambda$FlutterFirebaseFirestorePlugin$HgfMg1baqkxgDKeFZpCuALP7l7s.class, $$Lambda$FlutterFirebaseFirestorePlugin$KK5JPyaZ2C3deLtmDhAGplGH154.class, $$Lambda$FlutterFirebaseFirestorePlugin$OmQqNeCto0p2tej6MhbBamtjUw.class, $$Lambda$FlutterFirebaseFirestorePlugin$SMPbwPey57tXf81nQ2_KO0iFkLw.class, $$Lambda$FlutterFirebaseFirestorePlugin$TkTiyBAIynA_CQ6V9vWC2Jw39c.class, $$Lambda$FlutterFirebaseFirestorePlugin$VLRXEPGguykhezfD9gSbZsPodus.class, $$Lambda$FlutterFirebaseFirestorePlugin$_Rc9MxQ4nIbiQHi0Z1hRFIcOmwY.class, $$Lambda$FlutterFirebaseFirestorePlugin$b6Gg4MUc364GFp2vsgbkptxUorI.class, $$Lambda$FlutterFirebaseFirestorePlugin$euzHKP9a2TzJPGS3v9aUPvZnXI.class, $$Lambda$FlutterFirebaseFirestorePlugin$ktkDAK4_IeDR4jIOvih0zoH4cg0.class, $$Lambda$FlutterFirebaseFirestorePlugin$oK_RK5jDoJKiAF8ZcX3N55MMjr0.class, $$Lambda$FlutterFirebaseFirestorePlugin$rnjt0L87T6InQpm4GvdCetVduPo.class, $$Lambda$FlutterFirebaseFirestorePlugin$sVTQexlzkXfkyNdsZPLEUn4sOzE.class, $$Lambda$FlutterFirebaseFirestorePlugin$tCcQ7vOqinfBe8hBI66fmLFWyM.class, $$Lambda$FlutterFirebaseFirestorePlugin$u10ScKOi8gFDBqSoiLdhxled3u0.class, $$Lambda$FlutterFirebaseFirestorePlugin$zv6wAvGVjgEm5jqQ4A5Us6Sna5U.class})
public class FlutterFirebaseFirestorePlugin implements FlutterFirebasePlugin, MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    protected static final WeakHashMap<String, WeakReference<FirebaseFirestore>> firestoreInstanceCache = new WeakHashMap<>();
    private static final SparseArray<ListenerRegistration> listenerRegistrations = new SparseArray<>();
    private Activity activity;
    private MethodChannel channel;

    protected static FirebaseFirestore getCachedFirebaseFirestoreInstanceForKey(String key) {
        synchronized (firestoreInstanceCache) {
            WeakReference<FirebaseFirestore> existingInstance = firestoreInstanceCache.get(key);
            if (existingInstance == null) {
                return null;
            }
            FirebaseFirestore firebaseFirestore = (FirebaseFirestore) existingInstance.get();
            return firebaseFirestore;
        }
    }

    protected static void setCachedFirebaseFirestoreInstanceForKey(FirebaseFirestore firestore, String key) {
        synchronized (firestoreInstanceCache) {
            if (firestoreInstanceCache.get(key) == null) {
                firestoreInstanceCache.put(key, new WeakReference(firestore));
            }
        }
    }

    private static void destroyCachedFirebaseFirestoreInstanceForKey(String key) {
        synchronized (firestoreInstanceCache) {
            WeakReference<FirebaseFirestore> existingInstance = firestoreInstanceCache.get(key);
            if (existingInstance != null) {
                existingInstance.clear();
                firestoreInstanceCache.remove(key);
            }
        }
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        FlutterFirebaseFirestorePlugin instance = new FlutterFirebaseFirestorePlugin();
        instance.activity = registrar.activity();
        instance.initInstance(registrar.messenger());
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        initInstance(binding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        removeEventListeners();
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        attachToActivity(activityPluginBinding);
    }

    public void onDetachedFromActivityForConfigChanges() {
        detachToActivity();
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        attachToActivity(activityPluginBinding);
    }

    public void onDetachedFromActivity() {
        detachToActivity();
    }

    private void attachToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activity = activityPluginBinding.getActivity();
    }

    private void detachToActivity() {
        this.activity = null;
    }

    private void removeEventListeners() {
        for (int i = 0; i < listenerRegistrations.size(); i++) {
            ListenerRegistration listenerRegistration = listenerRegistrations.get(listenerRegistrations.keyAt(i));
            if (listenerRegistration != null) {
                listenerRegistration.remove();
            }
        }
        listenerRegistrations.clear();
    }

    private Task<Void> disableNetwork(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.lambda$disableNetwork$0(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$disableNetwork$0(Map arguments) throws Exception {
        return (Void) Tasks.await(((FirebaseFirestore) Objects.requireNonNull(arguments.get("firestore"))).disableNetwork());
    }

    private Task<Void> enableNetwork(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.lambda$enableNetwork$1(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$enableNetwork$1(Map arguments) throws Exception {
        return (Void) Tasks.await(((FirebaseFirestore) Objects.requireNonNull(arguments.get("firestore"))).enableNetwork());
    }

    private Task<Integer> addSnapshotsInSyncListener(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.this.lambda$addSnapshotsInSyncListener$4$FlutterFirebaseFirestorePlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Integer lambda$addSnapshotsInSyncListener$4$FlutterFirebaseFirestorePlugin(Map arguments) throws Exception {
        int handle = ((Integer) Objects.requireNonNull(arguments.get(Constants.HANDLE))).intValue();
        listenerRegistrations.put(handle, ((FirebaseFirestore) Objects.requireNonNull(arguments.get("firestore"))).addSnapshotsInSyncListener(new Runnable(handle) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                FlutterFirebaseFirestorePlugin.this.lambda$null$3$FlutterFirebaseFirestorePlugin(this.f$1);
            }
        }));
        return Integer.valueOf(handle);
    }

    public /* synthetic */ void lambda$null$3$FlutterFirebaseFirestorePlugin(int handle) {
        Map<String, Integer> data = new HashMap<>();
        data.put(Constants.HANDLE, Integer.valueOf(handle));
        this.activity.runOnUiThread(new Runnable(data) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                FlutterFirebaseFirestorePlugin.this.lambda$null$2$FlutterFirebaseFirestorePlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$null$2$FlutterFirebaseFirestorePlugin(Map data) {
        this.channel.invokeMethod("Firestore#snapshotsInSync", data);
    }

    private Task<Object> transactionCreate(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.this.lambda$transactionCreate$5$FlutterFirebaseFirestorePlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Object lambda$transactionCreate$5$FlutterFirebaseFirestorePlugin(Map arguments) throws Exception {
        long timeout;
        FirebaseFirestore firestore = (FirebaseFirestore) Objects.requireNonNull(arguments.get("firestore"));
        int transactionId = ((Integer) Objects.requireNonNull(arguments.get("transactionId"))).intValue();
        Object value = arguments.get(Constants.TIMEOUT);
        if (value instanceof Long) {
            timeout = (Long) value;
        } else if (value instanceof Integer) {
            timeout = Long.valueOf((long) ((Integer) value).intValue());
        } else {
            timeout = 5000L;
        }
        FlutterFirebaseFirestoreTransactionResult transactionResult = (FlutterFirebaseFirestoreTransactionResult) Tasks.await(new FlutterFirebaseFirestoreTransactionHandler(this.channel, this.activity, transactionId).create(firestore, timeout));
        FlutterFirebaseFirestoreTransactionHandler.dispose(transactionId);
        if (transactionResult.exception == null) {
            return null;
        }
        throw transactionResult.exception;
    }

    private Task<DocumentSnapshot> transactionGet(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestoreTransactionHandler.getDocument(((Integer) Objects.requireNonNull(this.f$0.get("transactionId"))).intValue(), (DocumentReference) this.f$0.get("reference"));
            }
        });
    }

    private Task<Void> batchCommit(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.lambda$batchCommit$7(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$batchCommit$7(Map arguments) throws Exception {
        FirebaseFirestore firestore = (FirebaseFirestore) Objects.requireNonNull(arguments.get("firestore"));
        WriteBatch batch = firestore.batch();
        for (Map<String, Object> write : (List) Objects.requireNonNull(arguments.get("writes"))) {
            String type = (String) Objects.requireNonNull(write.get("type"));
            Map<String, Object> data = (Map) write.get("data");
            DocumentReference documentReference = firestore.document((String) Objects.requireNonNull(write.get("path")));
            char c = 65535;
            int hashCode = type.hashCode();
            if (hashCode != -1785516855) {
                if (hashCode != 81986) {
                    if (hashCode == 2012838315 && type.equals("DELETE")) {
                        c = 0;
                    }
                } else if (type.equals("SET")) {
                    c = 2;
                }
            } else if (type.equals("UPDATE")) {
                c = 1;
            }
            if (c == 0) {
                batch = batch.delete(documentReference);
            } else if (c == 1) {
                batch = batch.update(documentReference, (Map<String, Object>) (Map) Objects.requireNonNull(data));
            } else if (c == 2) {
                Map<String, Object> options = (Map) Objects.requireNonNull(write.get("options"));
                if (options.get("merge") == null || !((Boolean) options.get("merge")).booleanValue()) {
                    batch = options.get("mergeFields") != null ? batch.set(documentReference, Objects.requireNonNull(data), SetOptions.mergeFieldPaths((List) Objects.requireNonNull(options.get("mergeFields")))) : batch.set(documentReference, Objects.requireNonNull(data));
                } else {
                    batch = batch.set(documentReference, Objects.requireNonNull(data), SetOptions.merge());
                }
            }
        }
        return (Void) Tasks.await(batch.commit());
    }

    private Task<Void> queryAddSnapshotListener(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.this.lambda$queryAddSnapshotListener$9$FlutterFirebaseFirestorePlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$queryAddSnapshotListener$9$FlutterFirebaseFirestorePlugin(Map arguments) throws Exception {
        int handle = ((Integer) Objects.requireNonNull(arguments.get(Constants.HANDLE))).intValue();
        MetadataChanges metadataChanges = ((Boolean) Objects.requireNonNull(arguments.get("includeMetadataChanges"))).booleanValue() ? MetadataChanges.INCLUDE : MetadataChanges.EXCLUDE;
        Query query = (Query) arguments.get(SearchIntents.EXTRA_QUERY);
        if (query != null) {
            listenerRegistrations.put(handle, query.addSnapshotListener(metadataChanges, (EventListener<QuerySnapshot>) new EventListener(handle) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                    FlutterFirebaseFirestorePlugin.this.lambda$null$8$FlutterFirebaseFirestorePlugin(this.f$1, (QuerySnapshot) obj, firebaseFirestoreException);
                }
            }));
            return null;
        }
        throw new IllegalArgumentException("An error occurred while parsing query arguments, see native logs for more information. Please report this issue.");
    }

    public /* synthetic */ void lambda$null$8$FlutterFirebaseFirestorePlugin(int handle, QuerySnapshot querySnapshot, FirebaseFirestoreException exception) {
        Map<String, Object> querySnapshotMap = new HashMap<>();
        querySnapshotMap.put(Constants.HANDLE, Integer.valueOf(handle));
        if (exception != null) {
            Map<String, Object> exceptionMap = new HashMap<>();
            FlutterFirebaseFirestoreException firestoreException = new FlutterFirebaseFirestoreException(exception, exception.getCause());
            exceptionMap.put(Constants.CODE, firestoreException.getCode());
            exceptionMap.put("message", firestoreException.getMessage());
            querySnapshotMap.put("error", exceptionMap);
            this.channel.invokeMethod("QuerySnapshot#error", querySnapshotMap);
            return;
        }
        querySnapshotMap.put("snapshot", querySnapshot);
        this.channel.invokeMethod("QuerySnapshot#event", querySnapshotMap);
    }

    private Task<QuerySnapshot> queryGet(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.this.lambda$queryGet$10$FlutterFirebaseFirestorePlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ QuerySnapshot lambda$queryGet$10$FlutterFirebaseFirestorePlugin(Map arguments) throws Exception {
        Source source = getSource(arguments);
        Query query = (Query) arguments.get(SearchIntents.EXTRA_QUERY);
        if (query != null) {
            return (QuerySnapshot) Tasks.await(query.get(source));
        }
        throw new IllegalArgumentException("An error occurred while parsing query arguments, see native logs for more information. Please report this issue.");
    }

    private Task<Void> documentAddSnapshotListener(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.this.lambda$documentAddSnapshotListener$12$FlutterFirebaseFirestorePlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$documentAddSnapshotListener$12$FlutterFirebaseFirestorePlugin(Map arguments) throws Exception {
        int handle = ((Integer) Objects.requireNonNull(arguments.get(Constants.HANDLE))).intValue();
        listenerRegistrations.put(handle, ((DocumentReference) Objects.requireNonNull(arguments.get("reference"))).addSnapshotListener(((Boolean) Objects.requireNonNull(arguments.get("includeMetadataChanges"))).booleanValue() ? MetadataChanges.INCLUDE : MetadataChanges.EXCLUDE, (EventListener<DocumentSnapshot>) new EventListener(handle) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                FlutterFirebaseFirestorePlugin.this.lambda$null$11$FlutterFirebaseFirestorePlugin(this.f$1, (DocumentSnapshot) obj, firebaseFirestoreException);
            }
        }));
        return null;
    }

    public /* synthetic */ void lambda$null$11$FlutterFirebaseFirestorePlugin(int handle, DocumentSnapshot documentSnapshot, FirebaseFirestoreException exception) {
        Map<String, Object> eventMap = new HashMap<>();
        eventMap.put(Constants.HANDLE, Integer.valueOf(handle));
        if (exception != null) {
            Map<String, Object> exceptionMap = new HashMap<>();
            FlutterFirebaseFirestoreException firestoreException = new FlutterFirebaseFirestoreException(exception, exception.getCause());
            exceptionMap.put(Constants.CODE, firestoreException.getCode());
            exceptionMap.put("message", firestoreException.getMessage());
            eventMap.put("error", exceptionMap);
            this.channel.invokeMethod("DocumentSnapshot#error", eventMap);
            return;
        }
        eventMap.put("snapshot", documentSnapshot);
        this.channel.invokeMethod("DocumentSnapshot#event", eventMap);
    }

    private Task<DocumentSnapshot> documentGet(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.this.lambda$documentGet$13$FlutterFirebaseFirestorePlugin(this.f$1);
            }
        });
    }

    public /* synthetic */ DocumentSnapshot lambda$documentGet$13$FlutterFirebaseFirestorePlugin(Map arguments) throws Exception {
        return (DocumentSnapshot) Tasks.await(((DocumentReference) Objects.requireNonNull(arguments.get("reference"))).get(getSource(arguments)));
    }

    private Task<Void> documentSet(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.lambda$documentSet$14(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$documentSet$14(Map arguments) throws Exception {
        Task task;
        DocumentReference documentReference = (DocumentReference) Objects.requireNonNull(arguments.get("reference"));
        Map map = (Map) Objects.requireNonNull(arguments.get("data"));
        Map<String, Object> options = (Map) Objects.requireNonNull(arguments.get("options"));
        if (options.get("merge") != null && ((Boolean) options.get("merge")).booleanValue()) {
            task = documentReference.set(map, SetOptions.merge());
        } else if (options.get("mergeFields") != null) {
            task = documentReference.set(map, SetOptions.mergeFieldPaths((List) Objects.requireNonNull(options.get("mergeFields"))));
        } else {
            task = documentReference.set(map);
        }
        return (Void) Tasks.await(task);
    }

    private Task<Void> documentUpdate(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.lambda$documentUpdate$15(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$documentUpdate$15(Map arguments) throws Exception {
        return (Void) Tasks.await(((DocumentReference) Objects.requireNonNull(arguments.get("reference"))).update((Map<String, Object>) (Map) Objects.requireNonNull(arguments.get("data"))));
    }

    private Task<Void> documentDelete(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.lambda$documentDelete$16(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$documentDelete$16(Map arguments) throws Exception {
        return (Void) Tasks.await(((DocumentReference) Objects.requireNonNull(arguments.get("reference"))).delete());
    }

    private Task<Void> clearPersistence(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.lambda$clearPersistence$17(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$clearPersistence$17(Map arguments) throws Exception {
        return (Void) Tasks.await(((FirebaseFirestore) Objects.requireNonNull(arguments.get("firestore"))).clearPersistence());
    }

    private Task<Void> terminate(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.lambda$terminate$18(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$terminate$18(Map arguments) throws Exception {
        FirebaseFirestore firestore = (FirebaseFirestore) Objects.requireNonNull(arguments.get("firestore"));
        Tasks.await(firestore.terminate());
        destroyCachedFirebaseFirestoreInstanceForKey(firestore.getApp().getName());
        return null;
    }

    private Task<Void> waitForPendingWrites(Map<String, Object> arguments) {
        return Tasks.call(cachedThreadPool, new Callable(arguments) {
            public final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return FlutterFirebaseFirestorePlugin.lambda$waitForPendingWrites$19(this.f$0);
            }
        });
    }

    static /* synthetic */ Void lambda$waitForPendingWrites$19(Map arguments) throws Exception {
        return (Void) Tasks.await(((FirebaseFirestore) Objects.requireNonNull(arguments.get("firestore"))).waitForPendingWrites());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r3, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r4) {
        /*
            r2 = this;
            java.lang.String r0 = r3.method
            int r1 = r0.hashCode()
            switch(r1) {
                case -1345933986: goto L_0x00bb;
                case -1237005313: goto L_0x00b1;
                case -787001759: goto L_0x00a7;
                case -717762416: goto L_0x009d;
                case -658486978: goto L_0x0092;
                case -642631514: goto L_0x0087;
                case -231135191: goto L_0x007c;
                case -161874852: goto L_0x0071;
                case -147794790: goto L_0x0067;
                case 33139875: goto L_0x005c;
                case 33151407: goto L_0x0050;
                case 195628283: goto L_0x0044;
                case 264528913: goto L_0x0039;
                case 319154430: goto L_0x002e;
                case 406828874: goto L_0x0022;
                case 515912559: goto L_0x0016;
                case 1562339571: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00c5
        L_0x000b:
            java.lang.String r1 = "Firestore#enableNetwork"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x00c6
        L_0x0016:
            java.lang.String r1 = "Firestore#waitForPendingWrites"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 16
            goto L_0x00c6
        L_0x0022:
            java.lang.String r1 = "Firestore#clearPersistence"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 14
            goto L_0x00c6
        L_0x002e:
            java.lang.String r1 = "Query#addSnapshotListener"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 7
            goto L_0x00c6
        L_0x0039:
            java.lang.String r1 = "Transaction#get"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 5
            goto L_0x00c6
        L_0x0044:
            java.lang.String r1 = "Query#get"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 8
            goto L_0x00c6
        L_0x0050:
            java.lang.String r1 = "DocumentReference#set"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 11
            goto L_0x00c6
        L_0x005c:
            java.lang.String r1 = "DocumentReference#get"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 10
            goto L_0x00c6
        L_0x0067:
            java.lang.String r1 = "Firestore#addSnapshotsInSyncListener"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x00c6
        L_0x0071:
            java.lang.String r1 = "DocumentReference#update"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 12
            goto L_0x00c6
        L_0x007c:
            java.lang.String r1 = "Firestore#terminate"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 15
            goto L_0x00c6
        L_0x0087:
            java.lang.String r1 = "DocumentReference#addSnapshotListener"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 9
            goto L_0x00c6
        L_0x0092:
            java.lang.String r1 = "DocumentReference#delete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 13
            goto L_0x00c6
        L_0x009d:
            java.lang.String r1 = "Firestore#removeListener"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 0
            goto L_0x00c6
        L_0x00a7:
            java.lang.String r1 = "Transaction#create"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 4
            goto L_0x00c6
        L_0x00b1:
            java.lang.String r1 = "WriteBatch#commit"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 6
            goto L_0x00c6
        L_0x00bb:
            java.lang.String r1 = "Firestore#disableNetwork"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 1
            goto L_0x00c6
        L_0x00c5:
            r0 = -1
        L_0x00c6:
            switch(r0) {
                case 0: goto L_0x018c;
                case 1: goto L_0x0178;
                case 2: goto L_0x016d;
                case 3: goto L_0x0162;
                case 4: goto L_0x0157;
                case 5: goto L_0x014c;
                case 6: goto L_0x0141;
                case 7: goto L_0x0136;
                case 8: goto L_0x012b;
                case 9: goto L_0x0120;
                case 10: goto L_0x0115;
                case 11: goto L_0x0109;
                case 12: goto L_0x00fd;
                case 13: goto L_0x00f1;
                case 14: goto L_0x00e5;
                case 15: goto L_0x00d9;
                case 16: goto L_0x00cd;
                default: goto L_0x00c9;
            }
        L_0x00c9:
            r4.notImplemented()
            return
        L_0x00cd:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.waitForPendingWrites(r0)
            goto L_0x0183
        L_0x00d9:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.terminate(r0)
            goto L_0x0183
        L_0x00e5:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.clearPersistence(r0)
            goto L_0x0183
        L_0x00f1:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.documentDelete(r0)
            goto L_0x0183
        L_0x00fd:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.documentUpdate(r0)
            goto L_0x0183
        L_0x0109:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.documentSet(r0)
            goto L_0x0183
        L_0x0115:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.documentGet(r0)
            goto L_0x0183
        L_0x0120:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.documentAddSnapshotListener(r0)
            goto L_0x0183
        L_0x012b:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.queryGet(r0)
            goto L_0x0183
        L_0x0136:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.queryAddSnapshotListener(r0)
            goto L_0x0183
        L_0x0141:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.batchCommit(r0)
            goto L_0x0183
        L_0x014c:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.transactionGet(r0)
            goto L_0x0183
        L_0x0157:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.transactionCreate(r0)
            goto L_0x0183
        L_0x0162:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.addSnapshotsInSyncListener(r0)
            goto L_0x0183
        L_0x016d:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.enableNetwork(r0)
            goto L_0x0183
        L_0x0178:
            java.lang.Object r0 = r3.arguments()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.tasks.Task r0 = r2.disableNetwork(r0)
        L_0x0183:
            io.flutter.plugins.firebase.firestore.-$$Lambda$FlutterFirebaseFirestorePlugin$oK_RK5jDoJKiAF8ZcX3N55MMjr0 r1 = new io.flutter.plugins.firebase.firestore.-$$Lambda$FlutterFirebaseFirestorePlugin$oK_RK5jDoJKiAF8ZcX3N55MMjr0
            r1.<init>(r4, r3)
            r0.addOnCompleteListener(r1)
            return
        L_0x018c:
            java.lang.String r0 = "handle"
            java.lang.Object r0 = r3.argument(r0)
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            android.util.SparseArray<com.google.firebase.firestore.ListenerRegistration> r1 = listenerRegistrations
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L_0x01b4
            android.util.SparseArray<com.google.firebase.firestore.ListenerRegistration> r1 = listenerRegistrations
            java.lang.Object r1 = r1.get(r0)
            com.google.firebase.firestore.ListenerRegistration r1 = (com.google.firebase.firestore.ListenerRegistration) r1
            r1.remove()
            android.util.SparseArray<com.google.firebase.firestore.ListenerRegistration> r1 = listenerRegistrations
            r1.remove(r0)
        L_0x01b4:
            r1 = 0
            r4.success(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public /* synthetic */ void lambda$onMethodCall$20$FlutterFirebaseFirestorePlugin(MethodChannel.Result result, MethodCall call, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        Exception exception = task.getException();
        Map<String, String> exceptionDetails = getExceptionDetails(exception);
        if (exceptionDetails.containsKey(Constants.CODE) && ((String) Objects.requireNonNull(exceptionDetails.get(Constants.CODE))).equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
            Log.e("FLTFirebaseFirestore", "An unknown error occurred calling method " + call.method, exception);
        }
        result.error("firebase_firestore", exception != null ? exception.getMessage() : null, exceptionDetails);
    }

    private void initInstance(BinaryMessenger messenger) {
        MethodChannel methodChannel = new MethodChannel(messenger, "plugins.flutter.io/firebase_firestore", new StandardMethodCodec(FlutterFirebaseFirestoreMessageCodec.INSTANCE));
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_firestore", this);
    }

    private Map<String, String> getExceptionDetails(Exception exception) {
        Throwable th;
        Map<String, String> details = new HashMap<>();
        if (exception == null) {
            return details;
        }
        FlutterFirebaseFirestoreException firestoreException = null;
        if (exception instanceof FirebaseFirestoreException) {
            firestoreException = new FlutterFirebaseFirestoreException((FirebaseFirestoreException) exception, exception.getCause());
        } else if (exception.getCause() != null && (exception.getCause() instanceof FirebaseFirestoreException)) {
            FirebaseFirestoreException firebaseFirestoreException = (FirebaseFirestoreException) exception.getCause();
            if (exception.getCause().getCause() != null) {
                th = exception.getCause().getCause();
            } else {
                th = exception.getCause();
            }
            firestoreException = new FlutterFirebaseFirestoreException(firebaseFirestoreException, th);
        }
        if (firestoreException != null) {
            details.put(Constants.CODE, firestoreException.getCode());
            details.put("message", firestoreException.getMessage());
        }
        return details;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.firebase.firestore.Source getSource(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "source"
            java.lang.Object r0 = r5.get(r0)
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r0.hashCode()
            r2 = -905826493(0xffffffffca022f43, float:-2132944.8)
            r3 = 1
            if (r1 == r2) goto L_0x0026
            r2 = 94416770(0x5a0af82, float:1.5110799E-35)
            if (r1 == r2) goto L_0x001c
        L_0x001b:
            goto L_0x0030
        L_0x001c:
            java.lang.String r1 = "cache"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = r3
            goto L_0x0031
        L_0x0026:
            java.lang.String r1 = "server"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = 0
            goto L_0x0031
        L_0x0030:
            r1 = -1
        L_0x0031:
            if (r1 == 0) goto L_0x003b
            if (r1 == r3) goto L_0x0038
            com.google.firebase.firestore.Source r1 = com.google.firebase.firestore.Source.DEFAULT
            return r1
        L_0x0038:
            com.google.firebase.firestore.Source r1 = com.google.firebase.firestore.Source.CACHE
            return r1
        L_0x003b:
            com.google.firebase.firestore.Source r1 = com.google.firebase.firestore.Source.SERVER
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin.getSource(java.util.Map):com.google.firebase.firestore.Source");
    }

    static /* synthetic */ Map lambda$getPluginConstantsForFirebaseApp$21() throws Exception {
        return null;
    }

    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        return Tasks.call(cachedThreadPool, $$Lambda$FlutterFirebaseFirestorePlugin$HgfMg1baqkxgDKeFZpCuALP7l7s.INSTANCE);
    }

    public Task<Void> didReinitializeFirebaseCore() {
        return Tasks.call(cachedThreadPool, new Callable() {
            public final Object call() {
                return FlutterFirebaseFirestorePlugin.this.lambda$didReinitializeFirebaseCore$22$FlutterFirebaseFirestorePlugin();
            }
        });
    }

    public /* synthetic */ Void lambda$didReinitializeFirebaseCore$22$FlutterFirebaseFirestorePlugin() throws Exception {
        removeEventListeners();
        for (FirebaseApp app : FirebaseApp.getApps((Context) null)) {
            Tasks.await(FirebaseFirestore.getInstance(app).terminate());
            destroyCachedFirebaseFirestoreInstanceForKey(app.getName());
        }
        return null;
    }
}
