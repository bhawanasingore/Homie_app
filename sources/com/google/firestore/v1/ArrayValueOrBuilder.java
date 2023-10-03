package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface ArrayValueOrBuilder extends MessageLiteOrBuilder {
    Value getValues(int i);

    int getValuesCount();

    List<Value> getValuesList();
}
