package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firestore.v1.Value;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface TransformOperation {
    Value applyToLocalView(Value value, Timestamp timestamp);

    Value applyToRemoteDocument(Value value, Value value2);

    Value computeBaseValue(Value value);
}
