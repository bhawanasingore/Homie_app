package io.flutter.plugins.firebase.firestore;

import android.app.Activity;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.android.tools.r8.annotations.SynthesizedClassMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.auth.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@SynthesizedClassMap({$$Lambda$FlutterFirebaseFirestoreTransactionHandler$460iIFpM1FQ3X3PDjd6eSR1n0s.class, $$Lambda$FlutterFirebaseFirestoreTransactionHandler$9zegoJ_J8cbNxWKhU7yGBryjWc.class})
class FlutterFirebaseFirestoreTransactionHandler {
    static final SparseArray<Transaction> transactions = new SparseArray<>();
    private WeakReference<Activity> activityRef;
    private MethodChannel channel;
    private int transactionId;

    FlutterFirebaseFirestoreTransactionHandler(MethodChannel channel2, Activity activity, int transactionId2) {
        this.channel = channel2;
        this.activityRef = new WeakReference<>(activity);
        this.transactionId = transactionId2;
    }

    static void dispose(int transactionId2) {
        transactions.delete(transactionId2);
    }

    /* access modifiers changed from: package-private */
    public static DocumentSnapshot getDocument(int transactionId2, DocumentReference documentReference) throws Exception {
        Transaction transaction = transactions.get(transactionId2);
        if (transaction != null) {
            return transaction.get(documentReference);
        }
        throw new Exception("Transaction.getDocument(): No transaction handler exists for ID: " + transactionId2);
    }

    /* access modifiers changed from: package-private */
    public Task<FlutterFirebaseFirestoreTransactionResult> create(FirebaseFirestore firestore, Long timeout) {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("transactionId", Integer.valueOf(this.transactionId));
        arguments.put(Constants.APP_NAME, firestore.getApp().getName());
        return firestore.runTransaction(new Transaction.Function(arguments, timeout, firestore) {
            public final /* synthetic */ Map f$1;
            public final /* synthetic */ Long f$2;
            public final /* synthetic */ FirebaseFirestore f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object apply(Transaction transaction) {
                return FlutterFirebaseFirestoreTransactionHandler.this.lambda$create$1$FlutterFirebaseFirestoreTransactionHandler(this.f$1, this.f$2, this.f$3, transaction);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult lambda$create$1$FlutterFirebaseFirestoreTransactionHandler(java.util.Map r20, java.lang.Long r21, com.google.firebase.firestore.FirebaseFirestore r22, com.google.firebase.firestore.Transaction r23) throws com.google.firebase.firestore.FirebaseFirestoreException {
        /*
            r19 = this;
            r1 = r19
            r2 = r23
            java.lang.String r0 = "type"
            android.util.SparseArray<com.google.firebase.firestore.Transaction> r3 = transactions
            int r4 = r1.transactionId
            r3.append(r4, r2)
            com.google.android.gms.tasks.TaskCompletionSource r3 = new com.google.android.gms.tasks.TaskCompletionSource
            r3.<init>()
            com.google.android.gms.tasks.Task r4 = r3.getTask()
            java.lang.ref.WeakReference<android.app.Activity> r5 = r1.activityRef
            java.lang.Object r5 = r5.get()
            if (r5 != 0) goto L_0x002a
            android.content.ActivityNotFoundException r0 = new android.content.ActivityNotFoundException
            java.lang.String r5 = "Activity context no longer exists."
            r0.<init>(r5)
            io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult r0 = io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult.failed(r0)
            return r0
        L_0x002a:
            io.flutter.plugins.firebase.firestore.-$$Lambda$FlutterFirebaseFirestoreTransactionHandler$460iIFp-M1FQ3X3PDjd6eSR1n0s r5 = new io.flutter.plugins.firebase.firestore.-$$Lambda$FlutterFirebaseFirestoreTransactionHandler$460iIFp-M1FQ3X3PDjd6eSR1n0s
            r6 = r20
            r5.<init>(r6, r3)
            java.lang.ref.WeakReference<android.app.Activity> r7 = r1.activityRef
            java.lang.Object r7 = r7.get()
            android.app.Activity r7 = (android.app.Activity) r7
            r7.runOnUiThread(r5)
            long r7 = r21.longValue()     // Catch:{ TimeoutException -> 0x0168, Exception -> 0x015e }
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ TimeoutException -> 0x0168, Exception -> 0x015e }
            java.lang.Object r7 = com.google.android.gms.tasks.Tasks.await(r4, r7, r9)     // Catch:{ TimeoutException -> 0x0168, Exception -> 0x015e }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ TimeoutException -> 0x0168, Exception -> 0x015e }
            java.lang.Object r8 = r7.get(r0)     // Catch:{ TimeoutException -> 0x0168, Exception -> 0x015e }
            java.lang.Object r8 = java.util.Objects.requireNonNull(r8)     // Catch:{ TimeoutException -> 0x0168, Exception -> 0x015e }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ TimeoutException -> 0x0168, Exception -> 0x015e }
            java.lang.String r9 = "ERROR"
            boolean r9 = r8.equals(r9)     // Catch:{ TimeoutException -> 0x0168, Exception -> 0x015e }
            if (r9 == 0) goto L_0x006d
            io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult r0 = io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult.complete()     // Catch:{ TimeoutException -> 0x0066, Exception -> 0x005f }
            return r0
        L_0x005f:
            r0 = move-exception
            r13 = r22
            r18 = r3
            goto L_0x0163
        L_0x0066:
            r0 = move-exception
            r13 = r22
            r18 = r3
            goto L_0x016d
        L_0x006d:
            java.lang.String r8 = "commands"
            java.lang.Object r8 = r7.get(r8)
            java.lang.Object r8 = java.util.Objects.requireNonNull(r8)
            java.util.List r8 = (java.util.List) r8
            java.util.Iterator r9 = r8.iterator()
        L_0x007f:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0159
            java.lang.Object r10 = r9.next()
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r11 = r10.get(r0)
            java.lang.Object r11 = java.util.Objects.requireNonNull(r11)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "path"
            java.lang.Object r12 = r10.get(r12)
            java.lang.Object r12 = java.util.Objects.requireNonNull(r12)
            java.lang.String r12 = (java.lang.String) r12
            r13 = r22
            com.google.firebase.firestore.DocumentReference r14 = r13.document(r12)
            java.lang.String r15 = "data"
            java.lang.Object r15 = r10.get(r15)
            java.util.Map r15 = (java.util.Map) r15
            r16 = -1
            r17 = r0
            int r0 = r11.hashCode()
            r1 = -1785516855(0xffffffff95932cc9, float:-5.9443486E-26)
            r18 = r3
            r3 = 1
            if (r0 == r1) goto L_0x00df
            r1 = 81986(0x14042, float:1.14887E-40)
            if (r0 == r1) goto L_0x00d5
            r1 = 2012838315(0x77f979ab, float:1.0119919E34)
            if (r0 == r1) goto L_0x00ca
        L_0x00c9:
            goto L_0x00e9
        L_0x00ca:
            java.lang.String r0 = "DELETE"
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x00c9
            r16 = 0
            goto L_0x00e9
        L_0x00d5:
            java.lang.String r0 = "SET"
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x00c9
            r0 = 2
            goto L_0x00eb
        L_0x00df:
            java.lang.String r0 = "UPDATE"
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x00c9
            r0 = r3
            goto L_0x00eb
        L_0x00e9:
            r0 = r16
        L_0x00eb:
            if (r0 == 0) goto L_0x014d
            if (r0 == r3) goto L_0x0143
            r1 = 2
            if (r0 == r1) goto L_0x00f3
            goto L_0x0151
        L_0x00f3:
            java.lang.String r0 = "options"
            java.lang.Object r0 = r10.get(r0)
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            java.util.Map r0 = (java.util.Map) r0
            r1 = 0
            java.lang.String r3 = "merge"
            java.lang.Object r16 = r0.get(r3)
            if (r16 == 0) goto L_0x011a
            java.lang.Object r3 = r0.get(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x011a
            com.google.firebase.firestore.SetOptions r1 = com.google.firebase.firestore.SetOptions.merge()
            goto L_0x0131
        L_0x011a:
            java.lang.String r3 = "mergeFields"
            java.lang.Object r16 = r0.get(r3)
            if (r16 == 0) goto L_0x0131
            java.lang.Object r3 = r0.get(r3)
            java.lang.Object r3 = java.util.Objects.requireNonNull(r3)
            java.util.List r3 = (java.util.List) r3
            com.google.firebase.firestore.SetOptions r1 = com.google.firebase.firestore.SetOptions.mergeFieldPaths(r3)
        L_0x0131:
            if (r1 != 0) goto L_0x013b
            java.lang.Object r3 = java.util.Objects.requireNonNull(r15)
            r2.set(r14, r3)
            goto L_0x0151
        L_0x013b:
            java.lang.Object r3 = java.util.Objects.requireNonNull(r15)
            r2.set(r14, r3, r1)
            goto L_0x0151
        L_0x0143:
            java.lang.Object r0 = java.util.Objects.requireNonNull(r15)
            java.util.Map r0 = (java.util.Map) r0
            r2.update((com.google.firebase.firestore.DocumentReference) r14, (java.util.Map<java.lang.String, java.lang.Object>) r0)
            goto L_0x0151
        L_0x014d:
            r2.delete(r14)
        L_0x0151:
            r1 = r19
            r0 = r17
            r3 = r18
            goto L_0x007f
        L_0x0159:
            io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult r0 = io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult.complete()
            return r0
        L_0x015e:
            r0 = move-exception
            r13 = r22
            r18 = r3
        L_0x0163:
            io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult r1 = io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult.failed(r0)
            return r1
        L_0x0168:
            r0 = move-exception
            r13 = r22
            r18 = r3
        L_0x016d:
            com.google.firebase.firestore.FirebaseFirestoreException r1 = new com.google.firebase.firestore.FirebaseFirestoreException
            java.lang.String r3 = r0.getMessage()
            com.google.firebase.firestore.FirebaseFirestoreException$Code r7 = com.google.firebase.firestore.FirebaseFirestoreException.Code.DEADLINE_EXCEEDED
            r1.<init>(r3, r7)
            io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult r1 = io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult.failed(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionHandler.lambda$create$1$FlutterFirebaseFirestoreTransactionHandler(java.util.Map, java.lang.Long, com.google.firebase.firestore.FirebaseFirestore, com.google.firebase.firestore.Transaction):io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult");
    }

    public /* synthetic */ void lambda$null$0$FlutterFirebaseFirestoreTransactionHandler(Map arguments, final TaskCompletionSource completionSource) {
        this.channel.invokeMethod("Transaction#attempt", arguments, new MethodChannel.Result() {
            public void success(@Nullable Object result) {
                completionSource.trySetResult((Map) result);
            }

            public void error(String errorCode, @Nullable String errorMessage, @Nullable Object errorDetails) {
                TaskCompletionSource taskCompletionSource = completionSource;
                taskCompletionSource.trySetException(new FirebaseFirestoreException("Transaction#attempt error: " + errorMessage, FirebaseFirestoreException.Code.ABORTED));
            }

            public void notImplemented() {
                completionSource.trySetException(new FirebaseFirestoreException("Transaction#attempt: Not implemented", FirebaseFirestoreException.Code.ABORTED));
            }
        });
    }
}
