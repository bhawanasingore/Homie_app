package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.ResourcePath;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface IndexManager {
    void addToCollectionParentIndex(ResourcePath resourcePath);

    List<ResourcePath> getCollectionParents(String str);
}
