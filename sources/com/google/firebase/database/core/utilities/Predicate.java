package com.google.firebase.database.core.utilities;

/* compiled from: com.google.firebase:firebase-database@@19.3.0 */
public interface Predicate<T> {
    public static final Predicate<Object> TRUE = new Predicate<Object>() {
        public boolean evaluate(Object object) {
            return true;
        }
    };

    boolean evaluate(T t);
}
