package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface ConnectivityMonitor {

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum NetworkStatus {
        UNREACHABLE,
        REACHABLE
    }

    void addCallback(Consumer<NetworkStatus> consumer);

    void shutdown();
}
