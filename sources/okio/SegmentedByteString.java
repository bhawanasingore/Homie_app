package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(Buffer buffer, int byteCount) {
        super((byte[]) null);
        Util.checkOffsetAndCount(buffer.size, 0, (long) byteCount);
        int offset = 0;
        int segmentCount = 0;
        Segment s = buffer.head;
        while (offset < byteCount) {
            if (s.limit != s.pos) {
                offset += s.limit - s.pos;
                segmentCount++;
                s = s.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[segmentCount][];
        this.directory = new int[(segmentCount * 2)];
        int offset2 = 0;
        int segmentCount2 = 0;
        Segment s2 = buffer.head;
        while (offset2 < byteCount) {
            this.segments[segmentCount2] = s2.data;
            offset2 += s2.limit - s2.pos;
            if (offset2 > byteCount) {
                offset2 = byteCount;
            }
            int[] iArr = this.directory;
            iArr[segmentCount2] = offset2;
            iArr[this.segments.length + segmentCount2] = s2.pos;
            s2.shared = true;
            segmentCount2++;
            s2 = s2.next;
        }
    }

    public String utf8() {
        return toByteString().utf8();
    }

    public String string(Charset charset) {
        return toByteString().string(charset);
    }

    public String base64() {
        return toByteString().base64();
    }

    public String hex() {
        return toByteString().hex();
    }

    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public ByteString md5() {
        return toByteString().md5();
    }

    public ByteString sha1() {
        return toByteString().sha1();
    }

    public ByteString sha256() {
        return toByteString().sha256();
    }

    public ByteString hmacSha1(ByteString key) {
        return toByteString().hmacSha1(key);
    }

    public ByteString hmacSha256(ByteString key) {
        return toByteString().hmacSha256(key);
    }

    public String base64Url() {
        return toByteString().base64Url();
    }

    public ByteString substring(int beginIndex) {
        return toByteString().substring(beginIndex);
    }

    public ByteString substring(int beginIndex, int endIndex) {
        return toByteString().substring(beginIndex, endIndex);
    }

    public byte getByte(int pos) {
        Util.checkOffsetAndCount((long) this.directory[this.segments.length - 1], (long) pos, 1);
        int segment = segment(pos);
        int segmentOffset = segment == 0 ? 0 : this.directory[segment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[segment][(pos - segmentOffset) + iArr[bArr.length + segment]];
    }

    private int segment(int pos) {
        int i = Arrays.binarySearch(this.directory, 0, this.segments.length, pos + 1);
        return i >= 0 ? i : ~i;
    }

    public int size() {
        return this.directory[this.segments.length - 1];
    }

    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] result = new byte[iArr[bArr.length - 1]];
        int segmentOffset = 0;
        int segmentCount = bArr.length;
        for (int s = 0; s < segmentCount; s++) {
            int[] iArr2 = this.directory;
            int segmentPos = iArr2[segmentCount + s];
            int nextSegmentOffset = iArr2[s];
            System.arraycopy(this.segments[s], segmentPos, result, segmentOffset, nextSegmentOffset - segmentOffset);
            segmentOffset = nextSegmentOffset;
        }
        return result;
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public void write(OutputStream out) throws IOException {
        if (out != null) {
            int segmentOffset = 0;
            int segmentCount = this.segments.length;
            for (int s = 0; s < segmentCount; s++) {
                int[] iArr = this.directory;
                int segmentPos = iArr[segmentCount + s];
                int nextSegmentOffset = iArr[s];
                out.write(this.segments[s], segmentPos, nextSegmentOffset - segmentOffset);
                segmentOffset = nextSegmentOffset;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* access modifiers changed from: package-private */
    public void write(Buffer buffer) {
        int segmentOffset = 0;
        int segmentCount = this.segments.length;
        for (int s = 0; s < segmentCount; s++) {
            int[] iArr = this.directory;
            int segmentPos = iArr[segmentCount + s];
            int nextSegmentOffset = iArr[s];
            Segment segment = new Segment(this.segments[s], segmentPos, (segmentPos + nextSegmentOffset) - segmentOffset);
            if (buffer.head == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                buffer.head.prev.push(segment);
            }
            segmentOffset = nextSegmentOffset;
        }
        buffer.size += (long) segmentOffset;
    }

    public boolean rangeEquals(int offset, ByteString other, int otherOffset, int byteCount) {
        if (offset < 0 || offset > size() - byteCount) {
            return false;
        }
        int s = segment(offset);
        while (byteCount > 0) {
            int segmentOffset = s == 0 ? 0 : this.directory[s - 1];
            int stepSize = Math.min(byteCount, (segmentOffset + (this.directory[s] - segmentOffset)) - offset);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!other.rangeEquals(otherOffset, bArr[s], (offset - segmentOffset) + iArr[bArr.length + s], stepSize)) {
                return false;
            }
            offset += stepSize;
            otherOffset += stepSize;
            byteCount -= stepSize;
            s++;
        }
        return true;
    }

    public boolean rangeEquals(int offset, byte[] other, int otherOffset, int byteCount) {
        if (offset < 0 || offset > size() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int s = segment(offset);
        while (byteCount > 0) {
            int segmentOffset = s == 0 ? 0 : this.directory[s - 1];
            int stepSize = Math.min(byteCount, (segmentOffset + (this.directory[s] - segmentOffset)) - offset);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!Util.arrayRangeEquals(bArr[s], (offset - segmentOffset) + iArr[bArr.length + s], other, otherOffset, stepSize)) {
                return false;
            }
            offset += stepSize;
            otherOffset += stepSize;
            byteCount -= stepSize;
            s++;
        }
        return true;
    }

    public int indexOf(byte[] other, int fromIndex) {
        return toByteString().indexOf(other, fromIndex);
    }

    public int lastIndexOf(byte[] other, int fromIndex) {
        return toByteString().lastIndexOf(other, fromIndex);
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    /* access modifiers changed from: package-private */
    public byte[] internalArray() {
        return toByteArray();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ByteString) || ((ByteString) o).size() != size() || !rangeEquals(0, (ByteString) o, 0, size())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int result = this.hashCode;
        if (result != 0) {
            return result;
        }
        int result2 = 1;
        int segmentOffset = 0;
        int segmentCount = this.segments.length;
        for (int s = 0; s < segmentCount; s++) {
            byte[] segment = this.segments[s];
            int[] iArr = this.directory;
            int segmentPos = iArr[segmentCount + s];
            int nextSegmentOffset = iArr[s];
            int limit = segmentPos + (nextSegmentOffset - segmentOffset);
            for (int i = segmentPos; i < limit; i++) {
                result2 = (result2 * 31) + segment[i];
            }
            segmentOffset = nextSegmentOffset;
        }
        this.hashCode = result2;
        return result2;
    }

    public String toString() {
        return toByteString().toString();
    }

    private Object writeReplace() {
        return toByteString();
    }
}
