package com.google.firebase.firestore.core;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public class ListenSequence {
    public static final long INVALID = -1;
    private long previousSequenceNumber;

    public ListenSequence(long startAfter) {
        this.previousSequenceNumber = startAfter;
    }

    public long next() {
        long j = this.previousSequenceNumber + 1;
        this.previousSequenceNumber = j;
        return j;
    }
}
