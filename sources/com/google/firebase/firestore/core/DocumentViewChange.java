package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public class DocumentViewChange {
    private final Document document;
    private final Type type;

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum Type {
        REMOVED,
        ADDED,
        MODIFIED,
        METADATA
    }

    public static DocumentViewChange create(Type type2, Document document2) {
        return new DocumentViewChange(type2, document2);
    }

    private DocumentViewChange(Type type2, Document document2) {
        this.type = type2;
        this.document = document2;
    }

    public Document getDocument() {
        return this.document;
    }

    public Type getType() {
        return this.type;
    }

    public boolean equals(Object o) {
        if (!(o instanceof DocumentViewChange)) {
            return false;
        }
        DocumentViewChange other = (DocumentViewChange) o;
        if (!this.type.equals(other.type) || !this.document.equals(other.document)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((61 * 31) + this.type.hashCode()) * 31) + this.document.hashCode();
    }

    public String toString() {
        return "DocumentViewChange(" + this.document + "," + this.type + ")";
    }
}
