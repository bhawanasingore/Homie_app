package com.google.firebase.database;

import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@19.3.0 */
public class Transaction {

    /* compiled from: com.google.firebase:firebase-database@@19.3.0 */
    public interface Handler {
        Result doTransaction(MutableData mutableData);

        void onComplete(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot);
    }

    /* compiled from: com.google.firebase:firebase-database@@19.3.0 */
    public static class Result {
        private Node data;
        private boolean success;

        private Result(boolean success2, Node data2) {
            this.success = success2;
            this.data = data2;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public Node getNode() {
            return this.data;
        }
    }

    public static Result abort() {
        return new Result(false, (Node) null);
    }

    public static Result success(MutableData resultData) {
        return new Result(true, resultData.getNode());
    }
}
