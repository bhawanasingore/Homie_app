package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface WriteResultOrBuilder extends MessageLiteOrBuilder {
    Value getTransformResults(int i);

    int getTransformResultsCount();

    List<Value> getTransformResultsList();

    Timestamp getUpdateTime();

    boolean hasUpdateTime();
}
