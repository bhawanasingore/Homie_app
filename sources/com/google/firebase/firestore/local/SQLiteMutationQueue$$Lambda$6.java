package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Function;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$6 implements Function {
    private static final SQLiteMutationQueue$$Lambda$6 instance = new SQLiteMutationQueue$$Lambda$6();

    private SQLiteMutationQueue$$Lambda$6() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object obj) {
        return Integer.valueOf(((Cursor) obj).getInt(0));
    }
}
