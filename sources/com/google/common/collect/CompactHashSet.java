package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    private static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;
    @MonotonicNonNullDecl
    transient Object[] elements;
    /* access modifiers changed from: private */
    @MonotonicNonNullDecl
    public transient long[] entries;
    transient float loadFactor;
    transient int modCount;
    private transient int size;
    @MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> set = createWithExpectedSize(collection.size());
        set.addAll(collection);
        return set;
    }

    public static <E> CompactHashSet<E> create(E... elements2) {
        CompactHashSet<E> set = createWithExpectedSize(elements2.length);
        Collections.addAll(set, elements2);
        return set;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int expectedSize) {
        return new CompactHashSet<>(expectedSize);
    }

    CompactHashSet() {
        init(3, DEFAULT_LOAD_FACTOR);
    }

    CompactHashSet(int expectedSize) {
        init(expectedSize, DEFAULT_LOAD_FACTOR);
    }

    /* access modifiers changed from: package-private */
    public void init(int expectedSize, float loadFactor2) {
        boolean z = false;
        Preconditions.checkArgument(expectedSize >= 0, "Initial capacity must be non-negative");
        if (loadFactor2 > 0.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Illegal load factor");
        int buckets = Hashing.closedTableSize(expectedSize, (double) loadFactor2);
        this.table = newTable(buckets);
        this.loadFactor = loadFactor2;
        this.elements = new Object[expectedSize];
        this.entries = newEntries(expectedSize);
        this.threshold = Math.max(1, (int) (((float) buckets) * loadFactor2));
    }

    private static int[] newTable(int size2) {
        int[] array = new int[size2];
        Arrays.fill(array, -1);
        return array;
    }

    private static long[] newEntries(int size2) {
        long[] array = new long[size2];
        Arrays.fill(array, -1);
        return array;
    }

    /* access modifiers changed from: private */
    public static int getHash(long entry) {
        return (int) (entry >>> 32);
    }

    private static int getNext(long entry) {
        return (int) entry;
    }

    private static long swapNext(long entry, int newNext) {
        return (HASH_MASK & entry) | (((long) newNext) & NEXT_MASK);
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    public boolean add(@NullableDecl E object) {
        int last;
        long entry;
        long[] entries2 = this.entries;
        Object[] elements2 = this.elements;
        int hash = Hashing.smearedHash(object);
        int tableIndex = hashTableMask() & hash;
        int newEntryIndex = this.size;
        int[] iArr = this.table;
        int next = iArr[tableIndex];
        if (next == -1) {
            iArr[tableIndex] = newEntryIndex;
        } else {
            do {
                last = next;
                entry = entries2[next];
                if (getHash(entry) == hash && Objects.equal(object, elements2[next])) {
                    return false;
                }
                next = getNext(entry);
            } while (next != -1);
            entries2[last] = swapNext(entry, newEntryIndex);
        }
        if (newEntryIndex != Integer.MAX_VALUE) {
            int newSize = newEntryIndex + 1;
            resizeMeMaybe(newSize);
            insertEntry(newEntryIndex, object, hash);
            this.size = newSize;
            if (newEntryIndex >= this.threshold) {
                resizeTable(this.table.length * 2);
            }
            this.modCount++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int entryIndex, E object, int hash) {
        this.entries[entryIndex] = (((long) hash) << 32) | NEXT_MASK;
        this.elements[entryIndex] = object;
    }

    private void resizeMeMaybe(int newSize) {
        int entriesSize = this.entries.length;
        if (newSize > entriesSize) {
            int newCapacity = Math.max(1, entriesSize >>> 1) + entriesSize;
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            }
            if (newCapacity != entriesSize) {
                resizeEntries(newCapacity);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resizeEntries(int newCapacity) {
        this.elements = Arrays.copyOf(this.elements, newCapacity);
        long[] entries2 = this.entries;
        int oldSize = entries2.length;
        long[] entries3 = Arrays.copyOf(entries2, newCapacity);
        if (newCapacity > oldSize) {
            Arrays.fill(entries3, oldSize, newCapacity, -1);
        }
        this.entries = entries3;
    }

    private void resizeTable(int newCapacity) {
        int[] oldTable = this.table;
        int oldCapacity = oldTable.length;
        if (oldCapacity >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int newThreshold = ((int) (((float) newCapacity) * this.loadFactor)) + 1;
        int[] newTable = newTable(newCapacity);
        long[] entries2 = this.entries;
        int mask = newTable.length - 1;
        int i = 0;
        while (i < this.size) {
            int hash = getHash(entries2[i]);
            int tableIndex = hash & mask;
            int next = newTable[tableIndex];
            newTable[tableIndex] = i;
            entries2[i] = (((long) next) & NEXT_MASK) | (((long) hash) << 32);
            i++;
            oldTable = oldTable;
            oldCapacity = oldCapacity;
        }
        this.threshold = newThreshold;
        this.table = newTable;
    }

    public boolean contains(@NullableDecl Object object) {
        int hash = Hashing.smearedHash(object);
        int next = this.table[hashTableMask() & hash];
        while (next != -1) {
            long entry = this.entries[next];
            if (getHash(entry) == hash && Objects.equal(object, this.elements[next])) {
                return true;
            }
            next = getNext(entry);
        }
        return false;
    }

    public boolean remove(@NullableDecl Object object) {
        return remove(object, Hashing.smearedHash(object));
    }

    /* access modifiers changed from: private */
    public boolean remove(Object object, int hash) {
        int tableIndex = hashTableMask() & hash;
        int next = this.table[tableIndex];
        if (next == -1) {
            return false;
        }
        int last = -1;
        do {
            if (getHash(this.entries[next]) != hash || !Objects.equal(object, this.elements[next])) {
                last = next;
                next = getNext(this.entries[next]);
            } else {
                if (last == -1) {
                    this.table[tableIndex] = getNext(this.entries[next]);
                } else {
                    long[] jArr = this.entries;
                    jArr[last] = swapNext(jArr[last], getNext(jArr[next]));
                }
                moveEntry(next);
                this.size--;
                this.modCount++;
                return true;
            }
        } while (next != -1);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void moveEntry(int dstIndex) {
        int previous;
        long entry;
        int srcIndex = size() - 1;
        if (dstIndex < srcIndex) {
            Object[] objArr = this.elements;
            objArr[dstIndex] = objArr[srcIndex];
            objArr[srcIndex] = null;
            long[] jArr = this.entries;
            long lastEntry = jArr[srcIndex];
            jArr[dstIndex] = lastEntry;
            jArr[srcIndex] = -1;
            int tableIndex = getHash(lastEntry) & hashTableMask();
            int[] iArr = this.table;
            int lastNext = iArr[tableIndex];
            if (lastNext == srcIndex) {
                iArr[tableIndex] = dstIndex;
                return;
            }
            do {
                previous = lastNext;
                long j = this.entries[lastNext];
                entry = j;
                lastNext = getNext(j);
            } while (lastNext != srcIndex);
            this.entries[previous] = swapNext(entry, dstIndex);
            return;
        }
        this.elements[dstIndex] = null;
        this.entries[dstIndex] = -1;
    }

    /* access modifiers changed from: package-private */
    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public int getSuccessor(int entryIndex) {
        if (entryIndex + 1 < this.size) {
            return entryIndex + 1;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove - 1;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = CompactHashSet.this.modCount;
            int index = CompactHashSet.this.firstEntryIndex();
            int indexToRemove = -1;

            public boolean hasNext() {
                return this.index >= 0;
            }

            public E next() {
                checkForConcurrentModification();
                if (hasNext()) {
                    this.indexToRemove = this.index;
                    E[] eArr = CompactHashSet.this.elements;
                    int i = this.index;
                    E result = eArr[i];
                    this.index = CompactHashSet.this.getSuccessor(i);
                    return result;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                checkForConcurrentModification();
                CollectPreconditions.checkRemove(this.indexToRemove >= 0);
                this.expectedModCount++;
                CompactHashSet compactHashSet = CompactHashSet.this;
                boolean unused = compactHashSet.remove(compactHashSet.elements[this.indexToRemove], CompactHashSet.getHash(CompactHashSet.this.entries[this.indexToRemove]));
                this.index = CompactHashSet.this.adjustAfterRemove(this.index, this.indexToRemove);
                this.indexToRemove = -1;
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }

    public <T> T[] toArray(T[] a) {
        return ObjectArrays.toArrayImpl(this.elements, 0, this.size, a);
    }

    public void trimToSize() {
        int size2 = this.size;
        if (size2 < this.entries.length) {
            resizeEntries(size2);
        }
        int minimumTableSize = Math.max(1, Integer.highestOneBit((int) (((float) size2) / this.loadFactor)));
        if (minimumTableSize < 1073741824 && ((double) size2) / ((double) minimumTableSize) > ((double) this.loadFactor)) {
            minimumTableSize <<= 1;
        }
        if (minimumTableSize < this.table.length) {
            resizeTable(minimumTableSize);
        }
    }

    public void clear() {
        this.modCount++;
        Arrays.fill(this.elements, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(this.size);
        Iterator it = iterator();
        while (it.hasNext()) {
            stream.writeObject(it.next());
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        init(3, DEFAULT_LOAD_FACTOR);
        int i = stream.readInt();
        while (true) {
            i--;
            if (i >= 0) {
                add(stream.readObject());
            } else {
                return;
            }
        }
    }
}
