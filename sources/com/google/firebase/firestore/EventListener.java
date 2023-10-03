package com.google.firebase.firestore;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface EventListener<T> {
    void onEvent(T t, FirebaseFirestoreException firebaseFirestoreException);
}
