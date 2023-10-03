package com.google.firebase.firestore.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface TargetGlobalOrBuilder extends MessageLiteOrBuilder {
    long getHighestListenSequenceNumber();

    int getHighestTargetId();

    Timestamp getLastRemoteSnapshotVersion();

    int getTargetCount();

    boolean hasLastRemoteSnapshotVersion();
}
