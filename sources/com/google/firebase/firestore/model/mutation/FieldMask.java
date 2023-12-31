package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.FieldPath;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class FieldMask {
    private final Set<FieldPath> mask;

    public static FieldMask fromSet(Set<FieldPath> mask2) {
        return new FieldMask(mask2);
    }

    private FieldMask(Set<FieldPath> mask2) {
        this.mask = mask2;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.mask.equals(((FieldMask) o).mask);
    }

    public String toString() {
        return "FieldMask{mask=" + this.mask.toString() + "}";
    }

    public boolean covers(FieldPath fieldPath) {
        for (FieldPath fieldMaskPath : this.mask) {
            if (fieldMaskPath.isPrefixOf(fieldPath)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.mask.hashCode();
    }

    public Set<FieldPath> getMask() {
        return this.mask;
    }
}
