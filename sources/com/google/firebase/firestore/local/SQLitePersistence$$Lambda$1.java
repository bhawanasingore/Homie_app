package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Function;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
final /* synthetic */ class SQLitePersistence$$Lambda$1 implements Function {
    private static final SQLitePersistence$$Lambda$1 instance = new SQLitePersistence$$Lambda$1();

    private SQLitePersistence$$Lambda$1() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object obj) {
        return Long.valueOf(((Cursor) obj).getLong(0));
    }
}
