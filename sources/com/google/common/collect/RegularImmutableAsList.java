package com.google.common.collect;

class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    RegularImmutableAsList(ImmutableCollection<E> delegate2, ImmutableList<? extends E> delegateList2) {
        this.delegate = delegate2;
        this.delegateList = delegateList2;
    }

    RegularImmutableAsList(ImmutableCollection<E> delegate2, Object[] array) {
        this(delegate2, ImmutableList.asImmutableList(array));
    }

    RegularImmutableAsList(ImmutableCollection<E> delegate2, Object[] array, int size) {
        this(delegate2, ImmutableList.asImmutableList(array, size));
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    public UnmodifiableListIterator<E> listIterator(int index) {
        return this.delegateList.listIterator(index);
    }

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] dst, int offset) {
        return this.delegateList.copyIntoArray(dst, offset);
    }

    public E get(int index) {
        return this.delegateList.get(index);
    }
}
