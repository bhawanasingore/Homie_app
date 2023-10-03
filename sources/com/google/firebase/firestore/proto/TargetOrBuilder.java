package com.google.firebase.firestore.proto;

import com.google.firebase.firestore.proto.Target;
import com.google.firestore.v1.Target;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface TargetOrBuilder extends MessageLiteOrBuilder {
    Target.DocumentsTarget getDocuments();

    Timestamp getLastLimboFreeSnapshotVersion();

    long getLastListenSequenceNumber();

    Target.QueryTarget getQuery();

    ByteString getResumeToken();

    Timestamp getSnapshotVersion();

    int getTargetId();

    Target.TargetTypeCase getTargetTypeCase();

    boolean hasLastLimboFreeSnapshotVersion();

    boolean hasSnapshotVersion();
}
