package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
final /* synthetic */ class Transaction$$Lambda$1 implements Continuation {
    private final Transaction arg$1;

    private Transaction$$Lambda$1(Transaction transaction) {
        this.arg$1 = transaction;
    }

    public static Continuation lambdaFactory$(Transaction transaction) {
        return new Transaction$$Lambda$1(transaction);
    }

    public Object then(Task task) {
        return Transaction.lambda$lookup$0(this.arg$1, task);
    }
}
