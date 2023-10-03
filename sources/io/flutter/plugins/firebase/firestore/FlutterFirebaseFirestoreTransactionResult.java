package io.flutter.plugins.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class FlutterFirebaseFirestoreTransactionResult {
    @Nullable
    final Exception exception;

    private FlutterFirebaseFirestoreTransactionResult(@NonNull Exception failureException) {
        this.exception = failureException;
    }

    private FlutterFirebaseFirestoreTransactionResult() {
        this.exception = null;
    }

    static FlutterFirebaseFirestoreTransactionResult failed(@NonNull Exception exception2) {
        return new FlutterFirebaseFirestoreTransactionResult(exception2);
    }

    static FlutterFirebaseFirestoreTransactionResult complete() {
        return new FlutterFirebaseFirestoreTransactionResult();
    }
}
