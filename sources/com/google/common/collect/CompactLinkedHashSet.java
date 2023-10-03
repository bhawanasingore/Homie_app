package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;
    @MonotonicNonNullDecl
    private transient int[] predecessor;
    @MonotonicNonNullDecl
    private transient int[] successor;

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> set = createWithExpectedSize(collection.size());
        set.addAll(collection);
        return set;
    }

    public static <E> CompactLinkedHashSet<E> create(E... elements) {
        CompactLinkedHashSet<E> set = createWithExpectedSize(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int expectedSize) {
        return new CompactLinkedHashSet<>(expectedSize);
    }

    CompactLinkedHashSet() {
    }

    CompactLinkedHashSet(int expectedSize) {
        super(expectedSize);
    }

    /* access modifiers changed from: package-private */
    public void init(int expectedSize, float loadFactor) {
        super.init(expectedSize, loadFactor);
        int[] iArr = new int[expectedSize];
        this.predecessor = iArr;
        this.successor = new int[expectedSize];
        Arrays.fill(iArr, -1);
        Arrays.fill(this.successor, -1);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    private void succeeds(int pred, int succ) {
        if (pred == -2) {
            this.firstEntry = succ;
        } else {
            this.successor[pred] = succ;
        }
        if (succ == -2) {
            this.lastEntry = pred;
        } else {
            this.predecessor[succ] = pred;
        }
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int entryIndex, E object, int hash) {
        super.insertEntry(entryIndex, object, hash);
        succeeds(this.lastEntry, entryIndex);
        succeeds(entryIndex, -2);
    }

    /* access modifiers changed from: package-private */
    public void moveEntry(int dstIndex) {
        int srcIndex = size() - 1;
        super.moveEntry(dstIndex);
        succeeds(this.predecessor[dstIndex], this.successor[dstIndex]);
        if (srcIndex != dstIndex) {
            succeeds(this.predecessor[srcIndex], dstIndex);
            succeeds(dstIndex, this.successor[srcIndex]);
        }
        this.predecessor[srcIndex] = -1;
        this.successor[srcIndex] = -1;
    }

    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.predecessor, -1);
        Arrays.fill(this.successor, -1);
    }

    /* access modifiers changed from: package-private */
    public void resizeEntries(int newCapacity) {
        super.resizeEntries(newCapacity);
        int[] iArr = this.predecessor;
        int oldCapacity = iArr.length;
        this.predecessor = Arrays.copyOf(iArr, newCapacity);
        this.successor = Arrays.copyOf(this.successor, newCapacity);
        if (oldCapacity < newCapacity) {
            Arrays.fill(this.predecessor, oldCapacity, newCapacity, -1);
            Arrays.fill(this.successor, oldCapacity, newCapacity, -1);
        }
    }

    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    public <T> T[] toArray(T[] a) {
        return ObjectArrays.toArrayImpl(this, a);
    }

    /* access modifiers changed from: package-private */
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    /* access modifiers changed from: package-private */
    public int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove == size() ? indexRemoved : indexBeforeRemove;
    }

    /* access modifiers changed from: package-private */
    public int getSuccessor(int entryIndex) {
        return this.successor[entryIndex];
    }
}
