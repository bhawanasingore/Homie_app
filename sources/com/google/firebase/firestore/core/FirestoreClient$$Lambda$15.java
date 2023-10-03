package com.google.firebase.firestore.core;

import com.google.firebase.firestore.auth.User;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
final /* synthetic */ class FirestoreClient$$Lambda$15 implements Runnable {
    private final FirestoreClient arg$1;
    private final User arg$2;

    private FirestoreClient$$Lambda$15(FirestoreClient firestoreClient, User user) {
        this.arg$1 = firestoreClient;
        this.arg$2 = user;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient, User user) {
        return new FirestoreClient$$Lambda$15(firestoreClient, user);
    }

    public void run() {
        FirestoreClient.lambda$new$1(this.arg$1, this.arg$2);
    }
}
