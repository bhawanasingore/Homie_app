package io.grpc;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

public final class Metadata {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final AsciiMarshaller<String> ASCII_STRING_MARSHALLER = new AsciiMarshaller<String>() {
        public String toAsciiString(String value) {
            return value;
        }

        public String parseAsciiString(String serialized) {
            return serialized;
        }
    };
    static final BaseEncoding BASE64_ENCODING_OMIT_PADDING = BaseEncoding.base64().omitPadding();
    public static final BinaryMarshaller<byte[]> BINARY_BYTE_MARSHALLER = new BinaryMarshaller<byte[]>() {
        public byte[] toBytes(byte[] value) {
            return value;
        }

        public byte[] parseBytes(byte[] serialized) {
            return serialized;
        }
    };
    public static final String BINARY_HEADER_SUFFIX = "-bin";
    private byte[][] namesAndValues;
    /* access modifiers changed from: private */
    public int size;

    public interface AsciiMarshaller<T> {
        T parseAsciiString(String str);

        String toAsciiString(T t);
    }

    public interface BinaryMarshaller<T> {
        T parseBytes(byte[] bArr);

        byte[] toBytes(T t);
    }

    interface TrustedAsciiMarshaller<T> {
        T parseAsciiString(byte[] bArr);

        byte[] toAsciiString(T t);
    }

    Metadata(byte[]... binaryValues) {
        this(binaryValues.length / 2, binaryValues);
    }

    Metadata(int usedNames, byte[]... binaryValues) {
        this.size = usedNames;
        this.namesAndValues = binaryValues;
    }

    /* access modifiers changed from: private */
    public byte[] name(int i) {
        return this.namesAndValues[i * 2];
    }

    private void name(int i, byte[] name) {
        this.namesAndValues[i * 2] = name;
    }

    /* access modifiers changed from: private */
    public byte[] value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    private void value(int i, byte[] value) {
        this.namesAndValues[(i * 2) + 1] = value;
    }

    private int cap() {
        byte[][] bArr = this.namesAndValues;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    private int len() {
        return this.size * 2;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public Metadata() {
    }

    /* access modifiers changed from: package-private */
    public int headerCount() {
        return this.size;
    }

    public boolean containsKey(Key<?> key) {
        for (int i = 0; i < this.size; i++) {
            if (bytesEqual(key.asciiName(), name(i))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public <T> T get(Key<T> key) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (bytesEqual(key.asciiName(), name(i))) {
                return key.parseBytes(value(i));
            }
        }
        return null;
    }

    private final class IterableAt<T> implements Iterable<T> {
        /* access modifiers changed from: private */
        public final Key<T> key;
        /* access modifiers changed from: private */
        public int startIdx;

        private IterableAt(Key<T> key2, int startIdx2) {
            this.key = key2;
            this.startIdx = startIdx2;
        }

        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private boolean hasNext = true;
                private int idx = IterableAt.this.startIdx;

                public boolean hasNext() {
                    if (this.hasNext) {
                        return true;
                    }
                    while (this.idx < Metadata.this.size) {
                        if (Metadata.this.bytesEqual(IterableAt.this.key.asciiName(), Metadata.this.name(this.idx))) {
                            this.hasNext = true;
                            return true;
                        }
                        this.idx++;
                    }
                    return false;
                }

                public T next() {
                    if (hasNext()) {
                        this.hasNext = false;
                        Key access$200 = IterableAt.this.key;
                        Metadata metadata = Metadata.this;
                        int i = this.idx;
                        this.idx = i + 1;
                        return access$200.parseBytes(metadata.value(i));
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    @Nullable
    public <T> Iterable<T> getAll(Key<T> key) {
        for (int i = 0; i < this.size; i++) {
            if (bytesEqual(key.asciiName(), name(i))) {
                return new IterableAt(key, i);
            }
        }
        return null;
    }

    public Set<String> keys() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> ks = new HashSet<>(this.size);
        for (int i = 0; i < this.size; i++) {
            ks.add(new String(name(i), 0));
        }
        return Collections.unmodifiableSet(ks);
    }

    public <T> void put(Key<T> key, T value) {
        Preconditions.checkNotNull(key, "key");
        Preconditions.checkNotNull(value, "value");
        maybeExpand();
        name(this.size, key.asciiName());
        value(this.size, key.toBytes(value));
        this.size++;
    }

    private void maybeExpand() {
        if (len() == 0 || len() == cap()) {
            expand(Math.max(len() * 2, 8));
        }
    }

    private void expand(int newCapacity) {
        byte[][] newNamesAndValues = new byte[newCapacity][];
        if (!isEmpty()) {
            System.arraycopy(this.namesAndValues, 0, newNamesAndValues, 0, len());
        }
        this.namesAndValues = newNamesAndValues;
    }

    public <T> boolean remove(Key<T> key, T value) {
        Preconditions.checkNotNull(key, "key");
        Preconditions.checkNotNull(value, "value");
        for (int i = 0; i < this.size; i++) {
            if (bytesEqual(key.asciiName(), name(i)) && value.equals(key.parseBytes(value(i)))) {
                int readIdx = (i + 1) * 2;
                byte[][] bArr = this.namesAndValues;
                System.arraycopy(bArr, readIdx, bArr, i * 2, len() - readIdx);
                int i2 = this.size - 1;
                this.size = i2;
                name(i2, (byte[]) null);
                value(this.size, (byte[]) null);
                return true;
            }
        }
        return false;
    }

    public <T> Iterable<T> removeAll(Key<T> key) {
        if (isEmpty()) {
            return null;
        }
        int writeIdx = 0;
        List<T> ret = null;
        for (int readIdx = 0; readIdx < this.size; readIdx++) {
            if (bytesEqual(key.asciiName(), name(readIdx))) {
                ret = ret != null ? ret : new ArrayList<>();
                ret.add(key.parseBytes(value(readIdx)));
            } else {
                name(writeIdx, name(readIdx));
                value(writeIdx, value(readIdx));
                writeIdx++;
            }
        }
        Arrays.fill(this.namesAndValues, writeIdx * 2, len(), (Object) null);
        this.size = writeIdx;
        return ret;
    }

    public <T> void discardAll(Key<T> key) {
        if (!isEmpty()) {
            int writeIdx = 0;
            for (int readIdx = 0; readIdx < this.size; readIdx++) {
                if (!bytesEqual(key.asciiName(), name(readIdx))) {
                    name(writeIdx, name(readIdx));
                    value(writeIdx, value(readIdx));
                    writeIdx++;
                }
            }
            Arrays.fill(this.namesAndValues, writeIdx * 2, len(), (Object) null);
            this.size = writeIdx;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public byte[][] serialize() {
        if (len() == cap()) {
            return this.namesAndValues;
        }
        byte[][] serialized = new byte[len()][];
        System.arraycopy(this.namesAndValues, 0, serialized, 0, len());
        return serialized;
    }

    public void merge(Metadata other) {
        if (!other.isEmpty()) {
            int remaining = cap() - len();
            if (isEmpty() || remaining < other.len()) {
                expand(len() + other.len());
            }
            System.arraycopy(other.namesAndValues, 0, this.namesAndValues, len(), other.len());
            this.size += other.size;
        }
    }

    public void merge(Metadata other, Set<Key<?>> keys) {
        Preconditions.checkNotNull(other, "other");
        Map<ByteBuffer, Key<?>> asciiKeys = new HashMap<>(keys.size());
        for (Key<?> key : keys) {
            asciiKeys.put(ByteBuffer.wrap(key.asciiName()), key);
        }
        for (int i = 0; i < other.size; i++) {
            if (asciiKeys.containsKey(ByteBuffer.wrap(other.name(i)))) {
                maybeExpand();
                name(this.size, other.name(i));
                value(this.size, other.value(i));
                this.size++;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                sb.append(',');
            }
            String headerName = new String(name(i), Charsets.US_ASCII);
            sb.append(headerName);
            sb.append('=');
            if (headerName.endsWith(BINARY_HEADER_SUFFIX)) {
                sb.append(BASE64_ENCODING_OMIT_PADDING.encode(value(i)));
            } else {
                sb.append(new String(value(i), Charsets.US_ASCII));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public boolean bytesEqual(byte[] left, byte[] right) {
        return Arrays.equals(left, right);
    }

    public static abstract class Key<T> {
        private static final BitSet VALID_T_CHARS = generateValidTChars();
        private final String name;
        private final byte[] nameBytes;
        private final String originalName;

        /* access modifiers changed from: package-private */
        public abstract T parseBytes(byte[] bArr);

        /* access modifiers changed from: package-private */
        public abstract byte[] toBytes(T t);

        public static <T> Key<T> of(String name2, BinaryMarshaller<T> marshaller) {
            return new BinaryKey(name2, marshaller);
        }

        public static <T> Key<T> of(String name2, AsciiMarshaller<T> marshaller) {
            return of(name2, false, marshaller);
        }

        static <T> Key<T> of(String name2, boolean pseudo, AsciiMarshaller<T> marshaller) {
            return new AsciiKey(name2, pseudo, marshaller);
        }

        static <T> Key<T> of(String name2, boolean pseudo, TrustedAsciiMarshaller<T> marshaller) {
            return new TrustedAsciiKey(name2, pseudo, marshaller);
        }

        private static BitSet generateValidTChars() {
            BitSet valid = new BitSet(127);
            valid.set(45);
            valid.set(95);
            valid.set(46);
            for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
                valid.set(c);
            }
            for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
                valid.set(c2);
            }
            return valid;
        }

        private static String validateName(String n, boolean pseudo) {
            Preconditions.checkNotNull(n, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Preconditions.checkArgument(!n.isEmpty(), "token must have at least 1 tchar");
            for (int i = 0; i < n.length(); i++) {
                char tChar = n.charAt(i);
                if (!pseudo || tChar != ':' || i != 0) {
                    Preconditions.checkArgument(VALID_T_CHARS.get(tChar), "Invalid character '%s' in key name '%s'", tChar, (Object) n);
                }
            }
            return n;
        }

        private Key(String name2, boolean pseudo) {
            String str = (String) Preconditions.checkNotNull(name2, AppMeasurementSdk.ConditionalUserProperty.NAME);
            this.originalName = str;
            String validateName = validateName(str.toLowerCase(Locale.ROOT), pseudo);
            this.name = validateName;
            this.nameBytes = validateName.getBytes(Charsets.US_ASCII);
        }

        public final String originalName() {
            return this.originalName;
        }

        public final String name() {
            return this.name;
        }

        /* access modifiers changed from: package-private */
        public byte[] asciiName() {
            return this.nameBytes;
        }

        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.name.equals(((Key) o).name);
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Key{name='" + this.name + "'}";
        }
    }

    private static class BinaryKey<T> extends Key<T> {
        private final BinaryMarshaller<T> marshaller;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private BinaryKey(String name, BinaryMarshaller<T> marshaller2) {
            super(name, false);
            boolean z = false;
            Preconditions.checkArgument(name.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", (Object) name, (Object) Metadata.BINARY_HEADER_SUFFIX);
            Preconditions.checkArgument(name.length() > Metadata.BINARY_HEADER_SUFFIX.length() ? true : z, "empty key name");
            this.marshaller = (BinaryMarshaller) Preconditions.checkNotNull(marshaller2, "marshaller is null");
        }

        /* access modifiers changed from: package-private */
        public byte[] toBytes(T value) {
            return this.marshaller.toBytes(value);
        }

        /* access modifiers changed from: package-private */
        public T parseBytes(byte[] serialized) {
            return this.marshaller.parseBytes(serialized);
        }
    }

    private static class AsciiKey<T> extends Key<T> {
        private final AsciiMarshaller<T> marshaller;

        private AsciiKey(String name, boolean pseudo, AsciiMarshaller<T> marshaller2) {
            super(name, pseudo);
            Preconditions.checkArgument(!name.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", (Object) name, (Object) Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (AsciiMarshaller) Preconditions.checkNotNull(marshaller2, "marshaller");
        }

        /* access modifiers changed from: package-private */
        public byte[] toBytes(T value) {
            return this.marshaller.toAsciiString(value).getBytes(Charsets.US_ASCII);
        }

        /* access modifiers changed from: package-private */
        public T parseBytes(byte[] serialized) {
            return this.marshaller.parseAsciiString(new String(serialized, Charsets.US_ASCII));
        }
    }

    private static final class TrustedAsciiKey<T> extends Key<T> {
        private final TrustedAsciiMarshaller<T> marshaller;

        private TrustedAsciiKey(String name, boolean pseudo, TrustedAsciiMarshaller<T> marshaller2) {
            super(name, pseudo);
            Preconditions.checkArgument(!name.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", (Object) name, (Object) Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (TrustedAsciiMarshaller) Preconditions.checkNotNull(marshaller2, "marshaller");
        }

        /* access modifiers changed from: package-private */
        public byte[] toBytes(T value) {
            return this.marshaller.toAsciiString(value);
        }

        /* access modifiers changed from: package-private */
        public T parseBytes(byte[] serialized) {
            return this.marshaller.parseAsciiString(serialized);
        }
    }
}
