package io.flutter.plugins.firebase.database;

import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String EVENT_TYPE_CHILD_ADDED = "_EventType.childAdded";
    private static final String EVENT_TYPE_CHILD_CHANGED = "_EventType.childChanged";
    private static final String EVENT_TYPE_CHILD_MOVED = "_EventType.childMoved";
    private static final String EVENT_TYPE_CHILD_REMOVED = "_EventType.childRemoved";
    private static final String EVENT_TYPE_VALUE = "_EventType.value";
    private static final String TAG = "MethodCallHandlerImpl";
    /* access modifiers changed from: private */
    public MethodChannel channel;
    /* access modifiers changed from: private */
    public final Handler handler = new Handler();
    private int nextHandle = 0;
    private final SparseArray<EventObserver> observers = new SparseArray<>();

    MethodCallHandlerImpl(MethodChannel channel2) {
        this.channel = channel2;
    }

    private DatabaseReference getReference(FirebaseDatabase database, Map<String, Object> arguments) {
        String path = (String) arguments.get("path");
        DatabaseReference reference = database.getReference();
        if (path != null) {
            return reference.child(path);
        }
        return reference;
    }

    private Query getQuery(FirebaseDatabase database, Map<String, Object> arguments) {
        Query query = getReference(database, arguments);
        Map<String, Object> parameters = (Map) arguments.get("parameters");
        if (parameters == null) {
            return query;
        }
        Object orderBy = parameters.get("orderBy");
        if ("child".equals(orderBy)) {
            query = query.orderByChild((String) parameters.get("orderByChildKey"));
        } else if ("key".equals(orderBy)) {
            query = query.orderByKey();
        } else if ("value".equals(orderBy)) {
            query = query.orderByValue();
        } else if ("priority".equals(orderBy)) {
            query = query.orderByPriority();
        }
        if (parameters.containsKey("startAt")) {
            Object startAt = parameters.get("startAt");
            if (parameters.containsKey("startAtKey")) {
                String startAtKey = (String) parameters.get("startAtKey");
                if (startAt instanceof Boolean) {
                    query = query.startAt(((Boolean) startAt).booleanValue(), startAtKey);
                } else if (startAt instanceof Number) {
                    query = query.startAt(((Number) startAt).doubleValue(), startAtKey);
                } else {
                    query = query.startAt((String) startAt, startAtKey);
                }
            } else if (startAt instanceof Boolean) {
                query = query.startAt(((Boolean) startAt).booleanValue());
            } else if (startAt instanceof Number) {
                query = query.startAt(((Number) startAt).doubleValue());
            } else {
                query = query.startAt((String) startAt);
            }
        }
        if (parameters.containsKey("endAt")) {
            Object endAt = parameters.get("endAt");
            if (parameters.containsKey("endAtKey")) {
                String endAtKey = (String) parameters.get("endAtKey");
                if (endAt instanceof Boolean) {
                    query = query.endAt(((Boolean) endAt).booleanValue(), endAtKey);
                } else if (endAt instanceof Number) {
                    query = query.endAt(((Number) endAt).doubleValue(), endAtKey);
                } else {
                    query = query.endAt((String) endAt, endAtKey);
                }
            } else if (endAt instanceof Boolean) {
                query = query.endAt(((Boolean) endAt).booleanValue());
            } else if (endAt instanceof Number) {
                query = query.endAt(((Number) endAt).doubleValue());
            } else {
                query = query.endAt((String) endAt);
            }
        }
        if (parameters.containsKey("equalTo")) {
            Object equalTo = parameters.get("equalTo");
            if (parameters.containsKey("equalToKey")) {
                String equalToKey = (String) parameters.get("equalToKey");
                if (equalTo instanceof Boolean) {
                    query = query.equalTo(((Boolean) equalTo).booleanValue(), equalToKey);
                } else if (equalTo instanceof Number) {
                    query = query.equalTo(((Number) equalTo).doubleValue(), equalToKey);
                } else {
                    query = query.equalTo((String) equalTo, equalToKey);
                }
            } else if (equalTo instanceof Boolean) {
                query = query.equalTo(((Boolean) equalTo).booleanValue());
            } else if (equalTo instanceof Number) {
                query = query.equalTo(((Number) equalTo).doubleValue());
            } else {
                query = query.equalTo((String) equalTo);
            }
        }
        if (parameters.containsKey("limitToFirst")) {
            query = query.limitToFirst(((Integer) parameters.get("limitToFirst")).intValue());
        }
        if (parameters.containsKey("limitToLast")) {
            return query.limitToLast(((Integer) parameters.get("limitToLast")).intValue());
        }
        return query;
    }

    private class DefaultCompletionListener implements DatabaseReference.CompletionListener {
        private final MethodChannel.Result result;

        DefaultCompletionListener(MethodChannel.Result result2) {
            this.result = result2;
        }

        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
            if (error != null) {
                this.result.error(String.valueOf(error.getCode()), error.getMessage(), error.getDetails());
            } else {
                this.result.success((Object) null);
            }
        }
    }

    private class EventObserver implements ChildEventListener, ValueEventListener {
        private int handle;
        /* access modifiers changed from: private */
        public String requestedEventType;

        EventObserver(String requestedEventType2, int handle2) {
            this.requestedEventType = requestedEventType2;
            this.handle = handle2;
        }

        private void sendEvent(String eventType, @NonNull DataSnapshot snapshot, String previousChildName) {
            if (eventType.equals(this.requestedEventType)) {
                Map<String, Object> arguments = new HashMap<>();
                Map<String, Object> snapshotMap = new HashMap<>();
                snapshotMap.put("key", snapshot.getKey());
                snapshotMap.put("value", snapshot.getValue());
                arguments.put(Constants.HANDLE, Integer.valueOf(this.handle));
                arguments.put("snapshot", snapshotMap);
                arguments.put("previousSiblingKey", previousChildName);
                MethodCallHandlerImpl.this.channel.invokeMethod("Event", arguments);
            }
        }

        public void onCancelled(@NonNull DatabaseError error) {
            Map<String, Object> arguments = new HashMap<>();
            arguments.put(Constants.HANDLE, Integer.valueOf(this.handle));
            arguments.put("error", MethodCallHandlerImpl.asMap(error));
            MethodCallHandlerImpl.this.channel.invokeMethod("Error", arguments);
        }

        public void onChildAdded(@NonNull DataSnapshot snapshot, String previousChildName) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_CHILD_ADDED, snapshot, previousChildName);
        }

        public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_CHILD_REMOVED, snapshot, (String) null);
        }

        public void onChildChanged(@NonNull DataSnapshot snapshot, String previousChildName) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_CHILD_CHANGED, snapshot, previousChildName);
        }

        public void onChildMoved(@NonNull DataSnapshot snapshot, String previousChildName) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_CHILD_MOVED, snapshot, previousChildName);
        }

        public void onDataChange(@NonNull DataSnapshot snapshot) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_VALUE, snapshot, (String) null);
        }
    }

    public void onMethodCall(MethodCall call, @NonNull MethodChannel.Result result) {
        FirebaseDatabase database;
        Map<String, Object> arguments = (Map) call.arguments();
        String appName = (String) call.argument("app");
        String databaseURL = (String) call.argument("databaseURL");
        if (appName != null && databaseURL != null) {
            database = FirebaseDatabase.getInstance(FirebaseApp.getInstance(appName), databaseURL);
        } else if (appName != null) {
            database = FirebaseDatabase.getInstance(FirebaseApp.getInstance(appName));
        } else if (databaseURL != null) {
            database = FirebaseDatabase.getInstance(databaseURL);
        } else {
            database = FirebaseDatabase.getInstance();
        }
        String str = call.method;
        char c = 65535;
        switch (str.hashCode()) {
            case -2082411450:
                if (str.equals("DatabaseReference#runTransaction")) {
                    c = 8;
                    break;
                }
                break;
            case -2059578349:
                if (str.equals("DatabaseReference#setPriority")) {
                    c = 7;
                    break;
                }
                break;
            case -1666493916:
                if (str.equals("FirebaseDatabase#purgeOutstandingWrites")) {
                    c = 2;
                    break;
                }
                break;
            case -858161988:
                if (str.equals("DatabaseReference#update")) {
                    c = 6;
                    break;
                }
                break;
            case -526424742:
                if (str.equals("FirebaseDatabase#goOffline")) {
                    c = 1;
                    break;
                }
                break;
            case -429179942:
                if (str.equals("OnDisconnect#set")) {
                    c = 9;
                    break;
                }
                break;
            case -283892250:
                if (str.equals("FirebaseDatabase#setPersistenceCacheSizeBytes")) {
                    c = 4;
                    break;
                }
                break;
            case -43852798:
                if (str.equals("OnDisconnect#cancel")) {
                    c = 11;
                    break;
                }
                break;
            case 272980762:
                if (str.equals("Query#keepSynced")) {
                    c = 12;
                    break;
                }
                break;
            case 485025361:
                if (str.equals("OnDisconnect#update")) {
                    c = 10;
                    break;
                }
                break;
            case 734082383:
                if (str.equals("DatabaseReference#set")) {
                    c = 5;
                    break;
                }
                break;
            case 1593173173:
                if (str.equals("Query#removeObserver")) {
                    c = 14;
                    break;
                }
                break;
            case 1653150716:
                if (str.equals("FirebaseDatabase#goOnline")) {
                    c = 0;
                    break;
                }
                break;
            case 1749611585:
                if (str.equals("Query#observe")) {
                    c = 13;
                    break;
                }
                break;
            case 2058796707:
                if (str.equals("FirebaseDatabase#setPersistenceEnabled")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                database.goOnline();
                result.success((Object) null);
                return;
            case 1:
                database.goOffline();
                result.success((Object) null);
                return;
            case 2:
                database.purgeOutstandingWrites();
                result.success((Object) null);
                return;
            case 3:
                try {
                    database.setPersistenceEnabled(((Boolean) call.argument("enabled")).booleanValue());
                    result.success(true);
                    return;
                } catch (DatabaseException e) {
                    result.success(false);
                    return;
                }
            case 4:
                Object value = call.argument("cacheSize");
                Long cacheSizeBytes = 10485760L;
                if (value instanceof Long) {
                    cacheSizeBytes = (Long) value;
                } else if (value instanceof Integer) {
                    cacheSizeBytes = Long.valueOf((long) ((Integer) value).intValue());
                }
                try {
                    database.setPersistenceCacheSizeBytes(cacheSizeBytes.longValue());
                    result.success(true);
                    return;
                } catch (DatabaseException e2) {
                    result.success(false);
                    return;
                }
            case 5:
                Object value2 = call.argument("value");
                Object priority = call.argument("priority");
                DatabaseReference reference = getReference(database, arguments);
                if (priority != null) {
                    reference.setValue(value2, priority, new DefaultCompletionListener(result));
                    return;
                } else {
                    reference.setValue(value2, (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                }
            case 6:
                getReference(database, arguments).updateChildren((Map) call.argument("value"), new DefaultCompletionListener(result));
                return;
            case 7:
                getReference(database, arguments).setPriority(call.argument("priority"), new DefaultCompletionListener(result));
                return;
            case 8:
                DatabaseReference reference2 = getReference(database, arguments);
                final MethodCall methodCall = call;
                final Map<String, Object> map = arguments;
                final DatabaseReference databaseReference = reference2;
                final MethodChannel.Result result2 = result;
                reference2.runTransaction(new Transaction.Handler() {
                    @NonNull
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                        Task task = taskCompletionSource.getTask();
                        final Map<String, Object> doTransactionMap = new HashMap<>();
                        doTransactionMap.put("transactionKey", methodCall.argument("transactionKey"));
                        Map<String, Object> snapshotMap = new HashMap<>();
                        snapshotMap.put("key", mutableData.getKey());
                        snapshotMap.put("value", mutableData.getValue());
                        doTransactionMap.put("snapshot", snapshotMap);
                        MethodCallHandlerImpl.this.handler.post(new Runnable() {
                            public void run() {
                                MethodCallHandlerImpl.this.channel.invokeMethod("DoTransaction", doTransactionMap, new MethodChannel.Result() {
                                    public void success(Object result) {
                                        taskCompletionSource.setResult((Map) result);
                                    }

                                    public void error(String errorCode, String errorMessage, Object errorDetails) {
                                        taskCompletionSource.setException(new Exception("Error code: " + errorCode + "\nError message: " + errorMessage + "\nError details: " + errorDetails));
                                    }

                                    public void notImplemented() {
                                        taskCompletionSource.setException(new Exception("DoTransaction not implemented on Dart side."));
                                    }
                                });
                            }
                        });
                        try {
                            mutableData.setValue(((Map) Tasks.await(task, (long) ((Integer) map.get("transactionTimeout")).intValue(), TimeUnit.MILLISECONDS)).get("value"));
                            return Transaction.success(mutableData);
                        } catch (InterruptedException | ExecutionException | TimeoutException e) {
                            Log.e(MethodCallHandlerImpl.TAG, "Unable to commit Snapshot update. Transaction failed.", e);
                            if (e instanceof TimeoutException) {
                                Log.e(MethodCallHandlerImpl.TAG, "Transaction at " + databaseReference.toString() + " timed out.");
                            }
                            return Transaction.abort();
                        }
                    }

                    public void onComplete(DatabaseError databaseError, boolean committed, DataSnapshot dataSnapshot) {
                        final Map<String, Object> completionMap = new HashMap<>();
                        completionMap.put("transactionKey", methodCall.argument("transactionKey"));
                        if (databaseError != null) {
                            completionMap.put("error", MethodCallHandlerImpl.asMap(databaseError));
                        }
                        completionMap.put("committed", Boolean.valueOf(committed));
                        if (dataSnapshot != null) {
                            Map<String, Object> snapshotMap = new HashMap<>();
                            snapshotMap.put("key", dataSnapshot.getKey());
                            snapshotMap.put("value", dataSnapshot.getValue());
                            completionMap.put("snapshot", snapshotMap);
                        }
                        MethodCallHandlerImpl.this.handler.post(new Runnable() {
                            public void run() {
                                result2.success(completionMap);
                            }
                        });
                    }
                });
                return;
            case 9:
                Object value3 = call.argument("value");
                Object priority2 = call.argument("priority");
                DatabaseReference reference3 = getReference(database, arguments);
                if (priority2 == null) {
                    reference3.onDisconnect().setValue(value3, (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                } else if (priority2 instanceof String) {
                    reference3.onDisconnect().setValue(value3, (String) priority2, (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                } else if (priority2 instanceof Double) {
                    reference3.onDisconnect().setValue(value3, ((Double) priority2).doubleValue(), (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                } else if (priority2 instanceof Map) {
                    reference3.onDisconnect().setValue(value3, (Map) priority2, (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                } else {
                    return;
                }
            case 10:
                getReference(database, arguments).onDisconnect().updateChildren((Map) call.argument("value"), new DefaultCompletionListener(result));
                return;
            case 11:
                getReference(database, arguments).onDisconnect().cancel(new DefaultCompletionListener(result));
                return;
            case 12:
                getQuery(database, arguments).keepSynced(((Boolean) call.argument("value")).booleanValue());
                result.success((Object) null);
                return;
            case 13:
                String eventType = (String) call.argument("eventType");
                int handle = this.nextHandle;
                this.nextHandle = handle + 1;
                EventObserver observer = new EventObserver(eventType, handle);
                this.observers.put(handle, observer);
                if (EVENT_TYPE_VALUE.equals(eventType)) {
                    getQuery(database, arguments).addValueEventListener(observer);
                } else {
                    getQuery(database, arguments).addChildEventListener(observer);
                }
                result.success(Integer.valueOf(handle));
                return;
            case 14:
                Query query = getQuery(database, arguments);
                Integer handle2 = (Integer) call.argument(Constants.HANDLE);
                EventObserver observer2 = this.observers.get(handle2.intValue());
                if (observer2 != null) {
                    if (observer2.requestedEventType.equals(EVENT_TYPE_VALUE)) {
                        query.removeEventListener((ValueEventListener) observer2);
                    } else {
                        query.removeEventListener((ChildEventListener) observer2);
                    }
                    this.observers.delete(handle2.intValue());
                    result.success((Object) null);
                    return;
                }
                result.error("unknown_handle", "removeObserver called on an unknown handle", (Object) null);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> asMap(DatabaseError error) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.CODE, Integer.valueOf(error.getCode()));
        map.put("message", error.getMessage());
        map.put("details", error.getDetails());
        return map;
    }
}
