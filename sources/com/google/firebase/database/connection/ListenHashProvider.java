package com.google.firebase.database.connection;

/* compiled from: com.google.firebase:firebase-database@@19.3.0 */
public interface ListenHashProvider {
    CompoundHash getCompoundHash();

    String getSimpleHash();

    boolean shouldIncludeCompoundHash();
}
