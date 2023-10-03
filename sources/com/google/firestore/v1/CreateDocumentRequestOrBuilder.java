package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface CreateDocumentRequestOrBuilder extends MessageLiteOrBuilder {
    String getCollectionId();

    ByteString getCollectionIdBytes();

    Document getDocument();

    String getDocumentId();

    ByteString getDocumentIdBytes();

    DocumentMask getMask();

    String getParent();

    ByteString getParentBytes();

    boolean hasDocument();

    boolean hasMask();
}
