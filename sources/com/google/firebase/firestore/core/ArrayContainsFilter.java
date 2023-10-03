package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firestore.v1.Value;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public class ArrayContainsFilter extends FieldFilter {
    ArrayContainsFilter(FieldPath field, Value value) {
        super(field, Filter.Operator.ARRAY_CONTAINS, value);
    }

    public boolean matches(Document doc) {
        Value other = doc.getField(getField());
        return Values.isArray(other) && Values.contains(other.getArrayValue(), getValue());
    }
}
