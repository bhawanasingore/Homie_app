package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {
    @MonotonicNonNullDecl
    private transient Set<E> elementSet;
    @MonotonicNonNullDecl
    private transient Set<Multiset.Entry<E>> entrySet;

    public abstract void clear();

    /* access modifiers changed from: package-private */
    public abstract int distinctElements();

    /* access modifiers changed from: package-private */
    public abstract Iterator<E> elementIterator();

    /* access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> entryIterator();

    AbstractMultiset() {
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public boolean contains(@NullableDecl Object element) {
        return count(element) > 0;
    }

    public final boolean add(@NullableDecl E element) {
        add(element, 1);
        return true;
    }

    public int add(@NullableDecl E e, int occurrences) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(@NullableDecl Object element) {
        return remove(element, 1) > 0;
    }

    public int remove(@NullableDecl Object element, int occurrences) {
        throw new UnsupportedOperationException();
    }

    public int setCount(@NullableDecl E element, int count) {
        return Multisets.setCountImpl(this, element, count);
    }

    public boolean setCount(@NullableDecl E element, int oldCount, int newCount) {
        return Multisets.setCountImpl(this, element, oldCount, newCount);
    }

    public final boolean addAll(Collection<? extends E> elementsToAdd) {
        return Multisets.addAllImpl(this, elementsToAdd);
    }

    public final boolean removeAll(Collection<?> elementsToRemove) {
        return Multisets.removeAllImpl(this, elementsToRemove);
    }

    public final boolean retainAll(Collection<?> elementsToRetain) {
        return Multisets.retainAllImpl(this, elementsToRetain);
    }

    public Set<E> elementSet() {
        Set<E> result = this.elementSet;
        if (result != null) {
            return result;
        }
        Set<E> createElementSet = createElementSet();
        Set<E> result2 = createElementSet;
        this.elementSet = createElementSet;
        return result2;
    }

    /* access modifiers changed from: package-private */
    public Set<E> createElementSet() {
        return new ElementSet();
    }

    class ElementSet extends Multisets.ElementSet<E> {
        ElementSet() {
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> multiset() {
            return AbstractMultiset.this;
        }

        public Iterator<E> iterator() {
            return AbstractMultiset.this.elementIterator();
        }
    }

    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> result = this.entrySet;
        if (result != null) {
            return result;
        }
        Set<Multiset.Entry<E>> createEntrySet = createEntrySet();
        Set<Multiset.Entry<E>> result2 = createEntrySet;
        this.entrySet = createEntrySet;
        return result2;
    }

    class EntrySet extends Multisets.EntrySet<E> {
        EntrySet() {
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> multiset() {
            return AbstractMultiset.this;
        }

        public Iterator<Multiset.Entry<E>> iterator() {
            return AbstractMultiset.this.entryIterator();
        }

        public int size() {
            return AbstractMultiset.this.distinctElements();
        }
    }

    /* access modifiers changed from: package-private */
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    public final boolean equals(@NullableDecl Object object) {
        return Multisets.equalsImpl(this, object);
    }

    public final int hashCode() {
        return entrySet().hashCode();
    }

    public final String toString() {
        return entrySet().toString();
    }
}
