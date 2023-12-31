package com.google.firebase.firestore.remote;

import io.grpc.Metadata;
import io.grpc.Status;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
interface IncomingStreamObserver<RespT> {
    void onClose(Status status);

    void onHeaders(Metadata metadata);

    void onNext(RespT respt);

    void onOpen();
}
