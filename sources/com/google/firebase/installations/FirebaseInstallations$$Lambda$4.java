package com.google.firebase.installations;

import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
final /* synthetic */ class FirebaseInstallations$$Lambda$4 implements Callable {
    private final FirebaseInstallations arg$1;

    private FirebaseInstallations$$Lambda$4(FirebaseInstallations firebaseInstallations) {
        this.arg$1 = firebaseInstallations;
    }

    public static Callable lambdaFactory$(FirebaseInstallations firebaseInstallations) {
        return new FirebaseInstallations$$Lambda$4(firebaseInstallations);
    }

    public Object call() {
        return this.arg$1.deleteFirebaseInstallationId();
    }
}
