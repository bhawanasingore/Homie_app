package com.google.firestore.v1;

import com.google.firestore.v1.ListenResponse;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface ListenResponseOrBuilder extends MessageLiteOrBuilder {
    DocumentChange getDocumentChange();

    DocumentDelete getDocumentDelete();

    DocumentRemove getDocumentRemove();

    ExistenceFilter getFilter();

    ListenResponse.ResponseTypeCase getResponseTypeCase();

    TargetChange getTargetChange();
}
