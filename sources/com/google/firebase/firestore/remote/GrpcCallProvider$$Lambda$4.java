package com.google.firebase.firestore.remote;

import io.grpc.ManagedChannel;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
final /* synthetic */ class GrpcCallProvider$$Lambda$4 implements Runnable {
    private final GrpcCallProvider arg$1;
    private final ManagedChannel arg$2;

    private GrpcCallProvider$$Lambda$4(GrpcCallProvider grpcCallProvider, ManagedChannel managedChannel) {
        this.arg$1 = grpcCallProvider;
        this.arg$2 = managedChannel;
    }

    public static Runnable lambdaFactory$(GrpcCallProvider grpcCallProvider, ManagedChannel managedChannel) {
        return new GrpcCallProvider$$Lambda$4(grpcCallProvider, managedChannel);
    }

    public void run() {
        GrpcCallProvider.lambda$resetChannel$4(this.arg$1, this.arg$2);
    }
}
