package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface UpdateDocumentRequestOrBuilder extends MessageLiteOrBuilder {
    Precondition getCurrentDocument();

    Document getDocument();

    DocumentMask getMask();

    DocumentMask getUpdateMask();

    boolean hasCurrentDocument();

    boolean hasDocument();

    boolean hasMask();

    boolean hasUpdateMask();
}
