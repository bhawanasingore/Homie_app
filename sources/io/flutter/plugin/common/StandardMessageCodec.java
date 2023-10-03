package io.flutter.plugin.common;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardMessageCodec implements MessageCodec<Object> {
    private static final byte BIGINT = 5;
    private static final byte BYTE_ARRAY = 8;
    private static final byte DOUBLE = 6;
    private static final byte DOUBLE_ARRAY = 11;
    private static final byte FALSE = 2;
    public static final StandardMessageCodec INSTANCE = new StandardMessageCodec();
    private static final byte INT = 3;
    private static final byte INT_ARRAY = 9;
    private static final byte LIST = 12;
    private static final boolean LITTLE_ENDIAN = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN);
    private static final byte LONG = 4;
    private static final byte LONG_ARRAY = 10;
    private static final byte MAP = 13;
    private static final byte NULL = 0;
    private static final byte STRING = 7;
    private static final String TAG = "StandardMessageCodec#";
    private static final byte TRUE = 1;
    private static final Charset UTF8 = Charset.forName("UTF8");

    public ByteBuffer encodeMessage(Object message) {
        if (message == null) {
            return null;
        }
        ExposedByteArrayOutputStream stream = new ExposedByteArrayOutputStream();
        writeValue(stream, message);
        ByteBuffer buffer = ByteBuffer.allocateDirect(stream.size());
        buffer.put(stream.buffer(), 0, stream.size());
        return buffer;
    }

    public Object decodeMessage(ByteBuffer message) {
        if (message == null) {
            return null;
        }
        message.order(ByteOrder.nativeOrder());
        Object value = readValue(message);
        if (!message.hasRemaining()) {
            return value;
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    protected static final void writeSize(ByteArrayOutputStream stream, int value) {
        if (value < 0) {
            Log.e(TAG, "Attempted to write a negative size.");
        }
        if (value < 254) {
            stream.write(value);
        } else if (value <= 65535) {
            stream.write(254);
            writeChar(stream, value);
        } else {
            stream.write(255);
            writeInt(stream, value);
        }
    }

    protected static final void writeChar(ByteArrayOutputStream stream, int value) {
        if (LITTLE_ENDIAN) {
            stream.write(value);
            stream.write(value >>> 8);
            return;
        }
        stream.write(value >>> 8);
        stream.write(value);
    }

    protected static final void writeInt(ByteArrayOutputStream stream, int value) {
        if (LITTLE_ENDIAN) {
            stream.write(value);
            stream.write(value >>> 8);
            stream.write(value >>> 16);
            stream.write(value >>> 24);
            return;
        }
        stream.write(value >>> 24);
        stream.write(value >>> 16);
        stream.write(value >>> 8);
        stream.write(value);
    }

    protected static final void writeLong(ByteArrayOutputStream stream, long value) {
        if (LITTLE_ENDIAN) {
            stream.write((byte) ((int) value));
            stream.write((byte) ((int) (value >>> 8)));
            stream.write((byte) ((int) (value >>> 16)));
            stream.write((byte) ((int) (value >>> 24)));
            stream.write((byte) ((int) (value >>> 32)));
            stream.write((byte) ((int) (value >>> 40)));
            stream.write((byte) ((int) (value >>> 48)));
            stream.write((byte) ((int) (value >>> 56)));
            return;
        }
        stream.write((byte) ((int) (value >>> 56)));
        stream.write((byte) ((int) (value >>> 48)));
        stream.write((byte) ((int) (value >>> 40)));
        stream.write((byte) ((int) (value >>> 32)));
        stream.write((byte) ((int) (value >>> 24)));
        stream.write((byte) ((int) (value >>> 16)));
        stream.write((byte) ((int) (value >>> 8)));
        stream.write((byte) ((int) value));
    }

    protected static final void writeDouble(ByteArrayOutputStream stream, double value) {
        writeLong(stream, Double.doubleToLongBits(value));
    }

    protected static final void writeBytes(ByteArrayOutputStream stream, byte[] bytes) {
        writeSize(stream, bytes.length);
        stream.write(bytes, 0, bytes.length);
    }

    protected static final void writeAlignment(ByteArrayOutputStream stream, int alignment) {
        int mod = stream.size() % alignment;
        if (mod != 0) {
            for (int i = 0; i < alignment - mod; i++) {
                stream.write(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void writeValue(ByteArrayOutputStream stream, Object value) {
        int i = 0;
        if (value == null || value.equals((Object) null)) {
            stream.write(0);
        } else if (value == Boolean.TRUE) {
            stream.write(1);
        } else if (value == Boolean.FALSE) {
            stream.write(2);
        } else if (value instanceof Number) {
            if ((value instanceof Integer) || (value instanceof Short) || (value instanceof Byte)) {
                stream.write(3);
                writeInt(stream, ((Number) value).intValue());
            } else if (value instanceof Long) {
                stream.write(4);
                writeLong(stream, ((Long) value).longValue());
            } else if ((value instanceof Float) || (value instanceof Double)) {
                stream.write(6);
                writeAlignment(stream, 8);
                writeDouble(stream, ((Number) value).doubleValue());
            } else if (value instanceof BigInteger) {
                stream.write(5);
                writeBytes(stream, ((BigInteger) value).toString(16).getBytes(UTF8));
            } else {
                throw new IllegalArgumentException("Unsupported Number type: " + value.getClass());
            }
        } else if (value instanceof String) {
            stream.write(7);
            writeBytes(stream, ((String) value).getBytes(UTF8));
        } else if (value instanceof byte[]) {
            stream.write(8);
            writeBytes(stream, (byte[]) value);
        } else if (value instanceof int[]) {
            stream.write(9);
            int[] array = (int[]) value;
            writeSize(stream, array.length);
            writeAlignment(stream, 4);
            int length = array.length;
            while (i < length) {
                writeInt(stream, array[i]);
                i++;
            }
        } else if (value instanceof long[]) {
            stream.write(10);
            long[] array2 = (long[]) value;
            writeSize(stream, array2.length);
            writeAlignment(stream, 8);
            int length2 = array2.length;
            while (i < length2) {
                writeLong(stream, array2[i]);
                i++;
            }
        } else if (value instanceof double[]) {
            stream.write(11);
            double[] array3 = (double[]) value;
            writeSize(stream, array3.length);
            writeAlignment(stream, 8);
            int length3 = array3.length;
            while (i < length3) {
                writeDouble(stream, array3[i]);
                i++;
            }
        } else if (value instanceof List) {
            stream.write(12);
            List<?> list = (List) value;
            writeSize(stream, list.size());
            for (Object o : list) {
                writeValue(stream, o);
            }
        } else if (value instanceof Map) {
            stream.write(13);
            Map<?, ?> map = (Map) value;
            writeSize(stream, map.size());
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                writeValue(stream, entry.getKey());
                writeValue(stream, entry.getValue());
            }
        } else {
            throw new IllegalArgumentException("Unsupported value: " + value);
        }
    }

    protected static final int readSize(ByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            int value = buffer.get() & 255;
            if (value < 254) {
                return value;
            }
            if (value == 254) {
                return buffer.getChar();
            }
            return buffer.getInt();
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    protected static final byte[] readBytes(ByteBuffer buffer) {
        byte[] bytes = new byte[readSize(buffer)];
        buffer.get(bytes);
        return bytes;
    }

    protected static final void readAlignment(ByteBuffer buffer, int alignment) {
        int mod = buffer.position() % alignment;
        if (mod != 0) {
            buffer.position((buffer.position() + alignment) - mod);
        }
    }

    /* access modifiers changed from: protected */
    public final Object readValue(ByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            return readValueOfType(buffer.get(), buffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* access modifiers changed from: protected */
    public Object readValueOfType(byte type, ByteBuffer buffer) {
        switch (type) {
            case 0:
                return null;
            case 1:
                return true;
            case 2:
                return false;
            case 3:
                return Integer.valueOf(buffer.getInt());
            case 4:
                return Long.valueOf(buffer.getLong());
            case 5:
                return new BigInteger(new String(readBytes(buffer), UTF8), 16);
            case 6:
                readAlignment(buffer, 8);
                return Double.valueOf(buffer.getDouble());
            case 7:
                return new String(readBytes(buffer), UTF8);
            case 8:
                return readBytes(buffer);
            case 9:
                int length = readSize(buffer);
                int[] array = new int[length];
                readAlignment(buffer, 4);
                buffer.asIntBuffer().get(array);
                Object result = array;
                buffer.position(buffer.position() + (length * 4));
                return result;
            case 10:
                int length2 = readSize(buffer);
                long[] array2 = new long[length2];
                readAlignment(buffer, 8);
                buffer.asLongBuffer().get(array2);
                long[] jArr = array2;
                buffer.position(buffer.position() + (length2 * 8));
                return array2;
            case 11:
                int length3 = readSize(buffer);
                double[] array3 = new double[length3];
                readAlignment(buffer, 8);
                buffer.asDoubleBuffer().get(array3);
                double[] dArr = array3;
                buffer.position(buffer.position() + (length3 * 8));
                return array3;
            case 12:
                int size = readSize(buffer);
                List<Object> list = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    list.add(readValue(buffer));
                }
                return list;
            case 13:
                int size2 = readSize(buffer);
                Map<Object, Object> map = new HashMap<>();
                for (int i2 = 0; i2 < size2; i2++) {
                    map.put(readValue(buffer), readValue(buffer));
                }
                return map;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
    }

    static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        ExposedByteArrayOutputStream() {
        }

        /* access modifiers changed from: package-private */
        public byte[] buffer() {
            return this.buf;
        }
    }
}
