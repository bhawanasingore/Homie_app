package com.google.firestore.v1;

import com.google.firestore.v1.TransactionOptions;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface TransactionOptionsOrBuilder extends MessageLiteOrBuilder {
    TransactionOptions.ModeCase getModeCase();

    TransactionOptions.ReadOnly getReadOnly();

    TransactionOptions.ReadWrite getReadWrite();
}
