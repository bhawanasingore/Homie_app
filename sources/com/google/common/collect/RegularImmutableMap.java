package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final int ABSENT = -1;
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap((int[]) null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    private final transient int[] hashTable;
    private final transient int size;

    static <K, V> RegularImmutableMap<K, V> create(int n, Object[] alternatingKeysAndValues2) {
        if (n == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (n == 1) {
            CollectPreconditions.checkEntryNotNull(alternatingKeysAndValues2[0], alternatingKeysAndValues2[1]);
            return new RegularImmutableMap<>((int[]) null, alternatingKeysAndValues2, 1);
        }
        Preconditions.checkPositionIndex(n, alternatingKeysAndValues2.length >> 1);
        return new RegularImmutableMap<>(createHashTable(alternatingKeysAndValues2, n, ImmutableSet.chooseTableSize(n), 0), alternatingKeysAndValues2, n);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        r1[r6] = (r3 * 2) + r14;
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int[] createHashTable(java.lang.Object[] r11, int r12, int r13, int r14) {
        /*
            r0 = 1
            if (r12 != r0) goto L_0x000e
            r0 = r11[r14]
            r1 = r14 ^ 1
            r1 = r11[r1]
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r0, r1)
            r0 = 0
            return r0
        L_0x000e:
            int r0 = r13 + -1
            int[] r1 = new int[r13]
            r2 = -1
            java.util.Arrays.fill(r1, r2)
            r3 = 0
        L_0x0017:
            if (r3 >= r12) goto L_0x007c
            int r4 = r3 * 2
            int r4 = r4 + r14
            r4 = r11[r4]
            int r5 = r3 * 2
            r6 = r14 ^ 1
            int r5 = r5 + r6
            r5 = r11[r5]
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.common.collect.Hashing.smear(r6)
        L_0x0030:
            r6 = r6 & r0
            r7 = r1[r6]
            if (r7 != r2) goto L_0x003e
            int r8 = r3 * 2
            int r8 = r8 + r14
            r1[r6] = r8
            int r3 = r3 + 1
            goto L_0x0017
        L_0x003e:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0049
            int r6 = r6 + 1
            goto L_0x0030
        L_0x0049:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Multiple entries with same key: "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r9 = "="
            r8.append(r9)
            r8.append(r5)
            java.lang.String r10 = " and "
            r8.append(r10)
            r10 = r11[r7]
            r8.append(r10)
            r8.append(r9)
            r9 = r7 ^ 1
            r9 = r11[r9]
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r2.<init>(r8)
            throw r2
        L_0x007c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.createHashTable(java.lang.Object[], int, int, int):int[]");
    }

    private RegularImmutableMap(int[] hashTable2, Object[] alternatingKeysAndValues2, int size2) {
        this.hashTable = hashTable2;
        this.alternatingKeysAndValues = alternatingKeysAndValues2;
        this.size = size2;
    }

    public int size() {
        return this.size;
    }

    @NullableDecl
    public V get(@NullableDecl Object key) {
        return get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, key);
    }

    static Object get(@NullableDecl int[] hashTable2, @NullableDecl Object[] alternatingKeysAndValues2, int size2, int keyOffset, @NullableDecl Object key) {
        if (key == null) {
            return null;
        }
        if (size2 == 1) {
            if (alternatingKeysAndValues2[keyOffset].equals(key)) {
                return alternatingKeysAndValues2[keyOffset ^ 1];
            }
            return null;
        } else if (hashTable2 == null) {
            return null;
        } else {
            int mask = hashTable2.length - 1;
            int h = Hashing.smear(key.hashCode());
            while (true) {
                int h2 = h & mask;
                int index = hashTable2[h2];
                if (index == -1) {
                    return null;
                }
                if (alternatingKeysAndValues2[index].equals(key)) {
                    return alternatingKeysAndValues2[index ^ 1];
                }
                h = h2 + 1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        /* access modifiers changed from: private */
        public final transient Object[] alternatingKeysAndValues;
        /* access modifiers changed from: private */
        public final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        /* access modifiers changed from: private */
        public final transient int size;

        EntrySet(ImmutableMap<K, V> map2, Object[] alternatingKeysAndValues2, int keyOffset2, int size2) {
            this.map = map2;
            this.alternatingKeysAndValues = alternatingKeysAndValues2;
            this.keyOffset = keyOffset2;
            this.size = size2;
        }

        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        /* access modifiers changed from: package-private */
        public int copyIntoArray(Object[] dst, int offset) {
            return asList().copyIntoArray(dst, offset);
        }

        /* access modifiers changed from: package-private */
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() {
                public Map.Entry<K, V> get(int index) {
                    Preconditions.checkElementIndex(index, EntrySet.this.size);
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.alternatingKeysAndValues[(index * 2) + EntrySet.this.keyOffset], EntrySet.this.alternatingKeysAndValues[(index * 2) + (EntrySet.this.keyOffset ^ 1)]);
                }

                public int size() {
                    return EntrySet.this.size;
                }

                public boolean isPartialView() {
                    return true;
                }
            };
        }

        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) object;
            Object k = entry.getKey();
            Object v = entry.getValue();
            if (v == null || !v.equals(this.map.get(k))) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        KeysOrValuesAsList(Object[] alternatingKeysAndValues2, int offset2, int size2) {
            this.alternatingKeysAndValues = alternatingKeysAndValues2;
            this.offset = offset2;
            this.size = size2;
        }

        public Object get(int index) {
            Preconditions.checkElementIndex(index, this.size);
            return this.alternatingKeysAndValues[(index * 2) + this.offset];
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        KeySet(ImmutableMap<K, ?> map2, ImmutableList<K> list2) {
            this.map = map2;
            this.list = list2;
        }

        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }

        /* access modifiers changed from: package-private */
        public int copyIntoArray(Object[] dst, int offset) {
            return asList().copyIntoArray(dst, offset);
        }

        public ImmutableList<K> asList() {
            return this.list;
        }

        public boolean contains(@NullableDecl Object object) {
            return this.map.get(object) != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.map.size();
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }
}
