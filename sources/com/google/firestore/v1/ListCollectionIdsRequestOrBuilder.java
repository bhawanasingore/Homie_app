package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface ListCollectionIdsRequestOrBuilder extends MessageLiteOrBuilder {
    int getPageSize();

    String getPageToken();

    ByteString getPageTokenBytes();

    String getParent();

    ByteString getParentBytes();
}
