package com.google.firebase.firestore.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface NoDocumentOrBuilder extends MessageLiteOrBuilder {
    String getName();

    ByteString getNameBytes();

    Timestamp getReadTime();

    boolean hasReadTime();
}
