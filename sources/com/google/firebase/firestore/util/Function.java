package com.google.firebase.firestore.util;

import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public interface Function<F, T> {
    @Nullable
    T apply(@Nullable F f);

    boolean equals(@Nullable Object obj);
}
