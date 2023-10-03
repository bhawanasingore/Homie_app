package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface LruDelegate {
    void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer);

    void forEachTarget(Consumer<TargetData> consumer);

    long getByteSize();

    LruGarbageCollector getGarbageCollector();

    long getSequenceNumberCount();

    int removeOrphanedDocuments(long j);

    int removeTargets(long j, SparseArray<?> sparseArray);
}
