package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    @NullableDecl
    public transient Node<K, V> head;
    /* access modifiers changed from: private */
    public transient Map<K, KeyList<K, V>> keyToKeyList;
    /* access modifiers changed from: private */
    public transient int modCount;
    /* access modifiers changed from: private */
    public transient int size;
    /* access modifiers changed from: private */
    @NullableDecl
    public transient Node<K, V> tail;

    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private static final class Node<K, V> extends AbstractMapEntry<K, V> {
        @NullableDecl
        final K key;
        @NullableDecl
        Node<K, V> next;
        @NullableDecl
        Node<K, V> nextSibling;
        @NullableDecl
        Node<K, V> previous;
        @NullableDecl
        Node<K, V> previousSibling;
        @NullableDecl
        V value;

        Node(@NullableDecl K key2, @NullableDecl V value2) {
            this.key = key2;
            this.value = value2;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(@NullableDecl V newValue) {
            V result = this.value;
            this.value = newValue;
            return result;
        }
    }

    private static class KeyList<K, V> {
        int count = 1;
        Node<K, V> head;
        Node<K, V> tail;

        KeyList(Node<K, V> firstNode) {
            this.head = firstNode;
            this.tail = firstNode;
            firstNode.previousSibling = null;
            firstNode.nextSibling = null;
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int expectedKeys) {
        return new LinkedListMultimap<>(expectedKeys);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int expectedKeys) {
        this.keyToKeyList = Platform.newHashMapWithExpectedSize(expectedKeys);
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }

    /* access modifiers changed from: private */
    public Node<K, V> addNode(@NullableDecl K key, @NullableDecl V value, @NullableDecl Node<K, V> nextSibling) {
        Node<K, V> node = new Node<>(key, value);
        if (this.head == null) {
            this.tail = node;
            this.head = node;
            this.keyToKeyList.put(key, new KeyList(node));
            this.modCount++;
        } else if (nextSibling == null) {
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
            KeyList<K, V> keyList = this.keyToKeyList.get(key);
            if (keyList == null) {
                Map<K, KeyList<K, V>> map = this.keyToKeyList;
                KeyList keyList2 = new KeyList(node);
                KeyList keyList3 = keyList2;
                map.put(key, keyList2);
                this.modCount++;
            } else {
                keyList.count++;
                Node<K, V> keyTail = keyList.tail;
                keyTail.nextSibling = node;
                node.previousSibling = keyTail;
                keyList.tail = node;
            }
        } else {
            this.keyToKeyList.get(key).count++;
            node.previous = nextSibling.previous;
            node.previousSibling = nextSibling.previousSibling;
            node.next = nextSibling;
            node.nextSibling = nextSibling;
            if (nextSibling.previousSibling == null) {
                this.keyToKeyList.get(key).head = node;
            } else {
                nextSibling.previousSibling.nextSibling = node;
            }
            if (nextSibling.previous == null) {
                this.head = node;
            } else {
                nextSibling.previous.next = node;
            }
            nextSibling.previous = node;
            nextSibling.previousSibling = node;
        }
        this.size++;
        return node;
    }

    /* access modifiers changed from: private */
    public void removeNode(Node<K, V> node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            this.head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            this.tail = node.previous;
        }
        if (node.previousSibling == null && node.nextSibling == null) {
            this.keyToKeyList.remove(node.key).count = 0;
            this.modCount++;
        } else {
            KeyList<K, V> keyList = this.keyToKeyList.get(node.key);
            keyList.count--;
            if (node.previousSibling == null) {
                keyList.head = node.nextSibling;
            } else {
                node.previousSibling.nextSibling = node.nextSibling;
            }
            if (node.nextSibling == null) {
                keyList.tail = node.previousSibling;
            } else {
                node.nextSibling.previousSibling = node.previousSibling;
            }
        }
        this.size--;
    }

    /* access modifiers changed from: private */
    public void removeAllNodes(@NullableDecl Object key) {
        Iterators.clear(new ValueForKeyIterator(key));
    }

    /* access modifiers changed from: private */
    public static void checkElement(@NullableDecl Object node) {
        if (node == null) {
            throw new NoSuchElementException();
        }
    }

    private class NodeIterator implements ListIterator<Map.Entry<K, V>> {
        @NullableDecl
        Node<K, V> current;
        int expectedModCount = LinkedListMultimap.this.modCount;
        @NullableDecl
        Node<K, V> next;
        int nextIndex;
        @NullableDecl
        Node<K, V> previous;

        NodeIterator(int index) {
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(index, size);
            if (index < size / 2) {
                this.next = LinkedListMultimap.this.head;
                while (true) {
                    int index2 = index - 1;
                    if (index <= 0) {
                        break;
                    }
                    next();
                    index = index2;
                }
            } else {
                this.previous = LinkedListMultimap.this.tail;
                this.nextIndex = size;
                while (true) {
                    int index3 = index + 1;
                    if (index >= size) {
                        break;
                    }
                    previous();
                    index = index3;
                }
            }
            this.current = null;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.next != null;
        }

        public Node<K, V> next() {
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            Node<K, V> node = this.next;
            this.current = node;
            this.previous = node;
            this.next = node.next;
            this.nextIndex++;
            return this.current;
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.current != null);
            Node<K, V> node = this.current;
            if (node != this.next) {
                this.previous = node.previous;
                this.nextIndex--;
            } else {
                this.next = node.next;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        public boolean hasPrevious() {
            checkForConcurrentModification();
            return this.previous != null;
        }

        public Node<K, V> previous() {
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.previous);
            Node<K, V> node = this.previous;
            this.current = node;
            this.next = node;
            this.previous = node.previous;
            this.nextIndex--;
            return this.current;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public void setValue(V value) {
            Preconditions.checkState(this.current != null);
            this.current.value = value;
        }
    }

    private class DistinctKeyIterator implements Iterator<K> {
        @NullableDecl
        Node<K, V> current;
        int expectedModCount;
        Node<K, V> next;
        final Set<K> seenKeys;

        private DistinctKeyIterator() {
            this.seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.next = LinkedListMultimap.this.head;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.next != null;
        }

        public K next() {
            Node<K, V> node;
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            Node<K, V> node2 = this.next;
            this.current = node2;
            this.seenKeys.add(node2.key);
            do {
                node = this.next.next;
                this.next = node;
                if (node == null || this.seenKeys.add(node.key)) {
                }
                node = this.next.next;
                this.next = node;
                break;
            } while (this.seenKeys.add(node.key));
            return this.current.key;
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.current != null);
            LinkedListMultimap.this.removeAllNodes(this.current.key);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }
    }

    private class ValueForKeyIterator implements ListIterator<V> {
        @NullableDecl
        Node<K, V> current;
        @NullableDecl
        final Object key;
        @NullableDecl
        Node<K, V> next;
        int nextIndex;
        @NullableDecl
        Node<K, V> previous;

        ValueForKeyIterator(@NullableDecl Object key2) {
            this.key = key2;
            KeyList<K, V> keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(key2);
            this.next = keyList == null ? null : keyList.head;
        }

        public ValueForKeyIterator(@NullableDecl Object key2, int index) {
            KeyList<K, V> keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(key2);
            int size = keyList == null ? 0 : keyList.count;
            Preconditions.checkPositionIndex(index, size);
            if (index < size / 2) {
                this.next = keyList == null ? null : keyList.head;
                while (true) {
                    int index2 = index - 1;
                    if (index <= 0) {
                        break;
                    }
                    next();
                    index = index2;
                }
            } else {
                this.previous = keyList == null ? null : keyList.tail;
                this.nextIndex = size;
                while (true) {
                    int index3 = index + 1;
                    if (index >= size) {
                        break;
                    }
                    previous();
                    index = index3;
                }
            }
            this.key = key2;
            this.current = null;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public V next() {
            LinkedListMultimap.checkElement(this.next);
            Node<K, V> node = this.next;
            this.current = node;
            this.previous = node;
            this.next = node.nextSibling;
            this.nextIndex++;
            return this.current.value;
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        public V previous() {
            LinkedListMultimap.checkElement(this.previous);
            Node<K, V> node = this.previous;
            this.current = node;
            this.next = node;
            this.previous = node.previousSibling;
            this.nextIndex--;
            return this.current.value;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.current != null);
            Node<K, V> node = this.current;
            if (node != this.next) {
                this.previous = node.previousSibling;
                this.nextIndex--;
            } else {
                this.next = node.nextSibling;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
        }

        public void set(V value) {
            Preconditions.checkState(this.current != null);
            this.current.value = value;
        }

        public void add(V value) {
            this.previous = LinkedListMultimap.this.addNode(this.key, value, this.next);
            this.nextIndex++;
            this.current = null;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean containsKey(@NullableDecl Object key) {
        return this.keyToKeyList.containsKey(key);
    }

    public boolean containsValue(@NullableDecl Object value) {
        return values().contains(value);
    }

    public boolean put(@NullableDecl K key, @NullableDecl V value) {
        addNode(key, value, (Node) null);
        return true;
    }

    public List<V> replaceValues(@NullableDecl K key, Iterable<? extends V> values) {
        List<V> oldValues = getCopy(key);
        ListIterator<V> keyValues = new ValueForKeyIterator(key);
        Iterator<? extends V> newValues = values.iterator();
        while (keyValues.hasNext() && newValues.hasNext()) {
            keyValues.next();
            keyValues.set(newValues.next());
        }
        while (keyValues.hasNext()) {
            keyValues.next();
            keyValues.remove();
        }
        while (newValues.hasNext()) {
            keyValues.add(newValues.next());
        }
        return oldValues;
    }

    private List<V> getCopy(@NullableDecl Object key) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(key)));
    }

    public List<V> removeAll(@NullableDecl Object key) {
        List<V> oldValues = getCopy(key);
        removeAllNodes(key);
        return oldValues;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    public List<V> get(@NullableDecl final K key) {
        return new AbstractSequentialList<V>() {
            public int size() {
                KeyList<K, V> keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(key);
                if (keyList == null) {
                    return 0;
                }
                return keyList.count;
            }

            public ListIterator<V> listIterator(int index) {
                return new ValueForKeyIterator(key, index);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return new Sets.ImprovedAbstractSet<K>() {
            public int size() {
                return LinkedListMultimap.this.keyToKeyList.size();
            }

            public Iterator<K> iterator() {
                return new DistinctKeyIterator();
            }

            public boolean contains(Object key) {
                return LinkedListMultimap.this.containsKey(key);
            }

            public boolean remove(Object o) {
                return !LinkedListMultimap.this.removeAll(o).isEmpty();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    public List<V> values() {
        return (List) super.values();
    }

    /* access modifiers changed from: package-private */
    public List<V> createValues() {
        return new AbstractSequentialList<V>() {
            public int size() {
                return LinkedListMultimap.this.size;
            }

            public ListIterator<V> listIterator(int index) {
                final LinkedListMultimap<K, V>.NodeIterator nodeItr = new NodeIterator(index);
                return new TransformedListIterator<Map.Entry<K, V>, V>(nodeItr) {
                    /* access modifiers changed from: package-private */
                    public V transform(Map.Entry<K, V> entry) {
                        return entry.getValue();
                    }

                    public void set(V value) {
                        nodeItr.setValue(value);
                    }
                };
            }
        };
    }

    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    /* access modifiers changed from: package-private */
    public List<Map.Entry<K, V>> createEntries() {
        return new AbstractSequentialList<Map.Entry<K, V>>() {
            public int size() {
                return LinkedListMultimap.this.size;
            }

            public ListIterator<Map.Entry<K, V>> listIterator(int index) {
                return new NodeIterator(index);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.AsMap(this);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int size2 = stream.readInt();
        for (int i = 0; i < size2; i++) {
            put(stream.readObject(), stream.readObject());
        }
    }
}
