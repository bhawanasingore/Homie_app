package com.google.firestore.v1;

import com.google.firestore.v1.Write;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface WriteOrBuilder extends MessageLiteOrBuilder {
    Precondition getCurrentDocument();

    String getDelete();

    ByteString getDeleteBytes();

    Write.OperationCase getOperationCase();

    DocumentTransform getTransform();

    Document getUpdate();

    DocumentMask getUpdateMask();

    String getVerify();

    ByteString getVerifyBytes();

    boolean hasCurrentDocument();

    boolean hasUpdateMask();
}
