package com.google.firebase.firestore.core;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.local.IndexFreeQueryEngine;
import com.google.firebase.firestore.local.LocalSerializer;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.local.MemoryPersistence;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.QueryResult;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.AndroidConnectivityMonitor;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import io.grpc.Status;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class FirestoreClient implements RemoteStore.RemoteStoreCallback {
    private static final String LOG_TAG = "FirestoreClient";
    private static final int MAX_CONCURRENT_LIMBO_RESOLUTIONS = 100;
    private final AsyncQueue asyncQueue;
    private final CredentialsProvider credentialsProvider;
    private final DatabaseInfo databaseInfo;
    private EventManager eventManager;
    private LocalStore localStore;
    private LruGarbageCollector.Scheduler lruScheduler;
    private final GrpcMetadataProvider metadataProvider;
    private Persistence persistence;
    private RemoteStore remoteStore;
    private SyncEngine syncEngine;

    public FirestoreClient(Context context, DatabaseInfo databaseInfo2, FirebaseFirestoreSettings settings, CredentialsProvider credentialsProvider2, AsyncQueue asyncQueue2, GrpcMetadataProvider metadataProvider2) {
        this.databaseInfo = databaseInfo2;
        this.credentialsProvider = credentialsProvider2;
        this.asyncQueue = asyncQueue2;
        this.metadataProvider = metadataProvider2;
        TaskCompletionSource<User> firstUser = new TaskCompletionSource<>();
        AtomicBoolean initialized = new AtomicBoolean(false);
        asyncQueue2.enqueueAndForget(FirestoreClient$$Lambda$1.lambdaFactory$(this, firstUser, context, settings));
        credentialsProvider2.setChangeListener(FirestoreClient$$Lambda$2.lambdaFactory$(this, initialized, firstUser, asyncQueue2));
    }

    static /* synthetic */ void lambda$new$0(FirestoreClient firestoreClient, TaskCompletionSource firstUser, Context context, FirebaseFirestoreSettings settings) {
        try {
            firestoreClient.initialize(context, (User) Tasks.await(firstUser.getTask()), settings.isPersistenceEnabled(), settings.getCacheSizeBytes());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    static /* synthetic */ void lambda$new$2(FirestoreClient firestoreClient, AtomicBoolean initialized, TaskCompletionSource firstUser, AsyncQueue asyncQueue2, User user) {
        if (initialized.compareAndSet(false, true)) {
            Assert.hardAssert(true ^ firstUser.getTask().isComplete(), "Already fulfilled first user task", new Object[0]);
            firstUser.setResult(user);
            return;
        }
        asyncQueue2.enqueueAndForget(FirestoreClient$$Lambda$15.lambdaFactory$(firestoreClient, user));
    }

    static /* synthetic */ void lambda$new$1(FirestoreClient firestoreClient, User user) {
        Assert.hardAssert(firestoreClient.syncEngine != null, "SyncEngine not yet initialized", new Object[0]);
        Logger.debug(LOG_TAG, "Credential changed. Current user: %s", user.getUid());
        firestoreClient.syncEngine.handleCredentialChange(user);
    }

    public Task<Void> disableNetwork() {
        verifyNotTerminated();
        return this.asyncQueue.enqueue(FirestoreClient$$Lambda$3.lambdaFactory$(this));
    }

    public Task<Void> enableNetwork() {
        verifyNotTerminated();
        return this.asyncQueue.enqueue(FirestoreClient$$Lambda$4.lambdaFactory$(this));
    }

    public Task<Void> terminate() {
        this.credentialsProvider.removeChangeListener();
        return this.asyncQueue.enqueueAndInitiateShutdown(FirestoreClient$$Lambda$5.lambdaFactory$(this));
    }

    static /* synthetic */ void lambda$terminate$5(FirestoreClient firestoreClient) {
        firestoreClient.remoteStore.shutdown();
        firestoreClient.persistence.shutdown();
        LruGarbageCollector.Scheduler scheduler = firestoreClient.lruScheduler;
        if (scheduler != null) {
            scheduler.stop();
        }
    }

    public boolean isTerminated() {
        return this.asyncQueue.isShuttingDown();
    }

    public QueryListener listen(Query query, EventManager.ListenOptions options, EventListener<ViewSnapshot> listener) {
        verifyNotTerminated();
        QueryListener queryListener = new QueryListener(query, options, listener);
        this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$6.lambdaFactory$(this, queryListener));
        return queryListener;
    }

    public void stopListening(QueryListener listener) {
        if (!isTerminated()) {
            this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$7.lambdaFactory$(this, listener));
        }
    }

    public Task<Document> getDocumentFromLocalCache(DocumentKey docKey) {
        verifyNotTerminated();
        return this.asyncQueue.enqueue(FirestoreClient$$Lambda$8.lambdaFactory$(this, docKey)).continueWith(FirestoreClient$$Lambda$9.lambdaFactory$());
    }

    static /* synthetic */ Document lambda$getDocumentFromLocalCache$9(Task result) throws Exception {
        MaybeDocument maybeDoc = (MaybeDocument) result.getResult();
        if (maybeDoc instanceof Document) {
            return (Document) maybeDoc;
        }
        if (maybeDoc instanceof NoDocument) {
            return null;
        }
        throw new FirebaseFirestoreException("Failed to get document from cache. (However, this document may exist on the server. Run again without setting source to CACHE to attempt to retrieve the document from the server.)", FirebaseFirestoreException.Code.UNAVAILABLE);
    }

    public Task<ViewSnapshot> getDocumentsFromLocalCache(Query query) {
        verifyNotTerminated();
        return this.asyncQueue.enqueue(FirestoreClient$$Lambda$10.lambdaFactory$(this, query));
    }

    static /* synthetic */ ViewSnapshot lambda$getDocumentsFromLocalCache$10(FirestoreClient firestoreClient, Query query) throws Exception {
        QueryResult queryResult = firestoreClient.localStore.executeQuery(query, true);
        View view = new View(query, queryResult.getRemoteKeys());
        return view.applyChanges(view.computeDocChanges(queryResult.getDocuments())).getSnapshot();
    }

    public Task<Void> write(List<Mutation> mutations) {
        verifyNotTerminated();
        TaskCompletionSource<Void> source = new TaskCompletionSource<>();
        this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$11.lambdaFactory$(this, mutations, source));
        return source.getTask();
    }

    public <TResult> Task<TResult> transaction(Function<Transaction, Task<TResult>> updateFunction) {
        verifyNotTerminated();
        return AsyncQueue.callTask(this.asyncQueue.getExecutor(), FirestoreClient$$Lambda$12.lambdaFactory$(this, updateFunction));
    }

    public Task<Void> waitForPendingWrites() {
        verifyNotTerminated();
        TaskCompletionSource<Void> source = new TaskCompletionSource<>();
        this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$13.lambdaFactory$(this, source));
        return source.getTask();
    }

    private void initialize(Context context, User user, boolean usePersistence, long cacheSizeBytes) {
        Logger.debug(LOG_TAG, "Initializing. user=%s", user.getUid());
        LruGarbageCollector gc = null;
        if (usePersistence) {
            Context context2 = context;
            SQLitePersistence sqlitePersistence = new SQLitePersistence(context2, this.databaseInfo.getPersistenceKey(), this.databaseInfo.getDatabaseId(), new LocalSerializer(new RemoteSerializer(this.databaseInfo.getDatabaseId())), LruGarbageCollector.Params.WithCacheSizeBytes(cacheSizeBytes));
            gc = sqlitePersistence.getReferenceDelegate().getGarbageCollector();
            this.persistence = sqlitePersistence;
        } else {
            this.persistence = MemoryPersistence.createEagerGcMemoryPersistence();
        }
        this.persistence.start();
        LocalStore localStore2 = new LocalStore(this.persistence, new IndexFreeQueryEngine(), user);
        this.localStore = localStore2;
        if (gc != null) {
            LruGarbageCollector.Scheduler newScheduler = gc.newScheduler(this.asyncQueue, localStore2);
            this.lruScheduler = newScheduler;
            newScheduler.start();
        }
        ConnectivityMonitor connectivityMonitor = new AndroidConnectivityMonitor(context);
        LocalStore localStore3 = this.localStore;
        this.remoteStore = new RemoteStore(this, localStore3, new Datastore(this.databaseInfo, this.asyncQueue, this.credentialsProvider, context, this.metadataProvider), this.asyncQueue, connectivityMonitor);
        SyncEngine syncEngine2 = new SyncEngine(this.localStore, this.remoteStore, user, 100);
        this.syncEngine = syncEngine2;
        this.eventManager = new EventManager(syncEngine2);
        this.localStore.start();
        this.remoteStore.start();
    }

    public void addSnapshotsInSyncListener(EventListener<Void> listener) {
        verifyNotTerminated();
        this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$14.lambdaFactory$(this, listener));
    }

    public void removeSnapshotsInSyncListener(EventListener<Void> listener) {
        if (!isTerminated()) {
            this.eventManager.removeSnapshotsInSyncListener(listener);
        }
    }

    private void verifyNotTerminated() {
        if (isTerminated()) {
            throw new IllegalStateException("The client has already been terminated");
        }
    }

    public void handleRemoteEvent(RemoteEvent remoteEvent) {
        this.syncEngine.handleRemoteEvent(remoteEvent);
    }

    public void handleRejectedListen(int targetId, Status error) {
        this.syncEngine.handleRejectedListen(targetId, error);
    }

    public void handleSuccessfulWrite(MutationBatchResult mutationBatchResult) {
        this.syncEngine.handleSuccessfulWrite(mutationBatchResult);
    }

    public void handleRejectedWrite(int batchId, Status error) {
        this.syncEngine.handleRejectedWrite(batchId, error);
    }

    public void handleOnlineStateChange(OnlineState onlineState) {
        this.syncEngine.handleOnlineStateChange(onlineState);
    }

    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int targetId) {
        return this.syncEngine.getRemoteKeysForTarget(targetId);
    }
}
