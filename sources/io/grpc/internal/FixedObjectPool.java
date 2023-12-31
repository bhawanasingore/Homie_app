package io.grpc.internal;

import com.google.common.base.Preconditions;

public final class FixedObjectPool<T> implements ObjectPool<T> {
    private final T object;

    public FixedObjectPool(T object2) {
        this.object = Preconditions.checkNotNull(object2, "object");
    }

    public T getObject() {
        return this.object;
    }

    public T returnObject(Object returned) {
        return null;
    }
}
