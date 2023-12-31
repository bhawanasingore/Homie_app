package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public abstract class Filter {
    public abstract String getCanonicalId();

    public abstract FieldPath getField();

    public abstract boolean matches(Document document);

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum Operator {
        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL("<="),
        EQUAL("=="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        ARRAY_CONTAINS("array_contains"),
        ARRAY_CONTAINS_ANY("array_contains_any"),
        IN("in");
        
        private final String text;

        private Operator(String text2) {
            this.text = text2;
        }

        public String toString() {
            return this.text;
        }
    }
}
